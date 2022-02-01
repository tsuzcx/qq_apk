package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.i;
import com.tencent.mm.al.i.a;
import com.tencent.mm.al.i.b;
import com.tencent.mm.al.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.audio.c.a;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class s
  implements i.a, i.b, SensorController.a
{
  public static SensorController orl;
  public List<a> callbacks;
  private int dkj;
  long lastShakeTime;
  public i org;
  private boolean orh;
  private boolean ori;
  private boolean orj;
  private bk ork;
  public String path;
  
  public s()
  {
    AppMethodBeat.i(27818);
    this.orh = true;
    this.orj = false;
    this.lastShakeTime = -1L;
    this.callbacks = new LinkedList();
    this.org = ((j)g.ab(j.class)).Lm();
    az.arV();
    Boolean localBoolean = (Boolean)c.afk().get(26, Boolean.FALSE);
    this.ori = localBoolean.booleanValue();
    boolean bool;
    if (!localBoolean.booleanValue())
    {
      bool = true;
      this.orh = bool;
      if (this.org == null) {
        break label213;
      }
      this.org.a(this);
      this.org.a(this);
      if ((!a.bvw()) && (!a.bvC())) {
        break label197;
      }
      this.org.cj(false);
    }
    for (;;)
    {
      if (orl == null) {
        orl = new SensorController(aj.getContext());
      }
      if (this.ork == null) {
        this.ork = new bk(aj.getContext());
      }
      AppMethodBeat.o(27818);
      return;
      bool = false;
      break;
      label197:
      this.org.cj(this.orh);
      continue;
      label213:
      ad.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
    }
  }
  
  public final void bTJ()
  {
    AppMethodBeat.i(27824);
    if (orl != null) {
      orl.eGx();
    }
    if (this.ork != null) {
      this.ork.eGy();
    }
    AppMethodBeat.o(27824);
  }
  
  public final boolean bTK()
  {
    AppMethodBeat.i(27820);
    if (this.org == null)
    {
      ad.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
      AppMethodBeat.o(27820);
      return false;
    }
    boolean bool = this.org.isPlaying();
    AppMethodBeat.o(27820);
    return bool;
  }
  
  public final boolean cI(String paramString, int paramInt)
  {
    AppMethodBeat.i(27819);
    if (this.org == null)
    {
      ad.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(27819);
      return false;
    }
    this.org.stop();
    Object localObject = this.callbacks.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).alu(paramString);
    }
    if ((orl != null) && (!orl.aJR))
    {
      orl.a(this);
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27817);
          s.this.lastShakeTime = bt.GC();
          AppMethodBeat.o(27817);
        }
      };
      if (!this.ork.aC((Runnable)localObject)) {
        break label186;
      }
    }
    label186:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      this.path = paramString;
      this.dkj = paramInt;
      if ((bt.isNullOrNil(paramString)) || (!this.org.a(paramString, this.orh, true, paramInt))) {
        break;
      }
      an.aFx("keep_app_silent");
      AppMethodBeat.o(27819);
      return true;
    }
    AppMethodBeat.o(27819);
    return false;
  }
  
  public final void jz(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(27825);
    if (bt.isNullOrNil(this.path))
    {
      AppMethodBeat.o(27825);
      return;
    }
    if (this.orj)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.orj = paramBoolean;
        AppMethodBeat.o(27825);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (bt.aS(this.lastShakeTime) > 400L))
    {
      this.orj = true;
      AppMethodBeat.o(27825);
      return;
    }
    this.orj = false;
    if ((this.org != null) && (this.org.NY()))
    {
      AppMethodBeat.o(27825);
      return;
    }
    if (this.ori)
    {
      if (this.org != null) {
        this.org.cj(false);
      }
      this.orh = false;
      AppMethodBeat.o(27825);
      return;
    }
    if ((this.org != null) && (!this.org.isPlaying()))
    {
      this.org.cj(true);
      this.orh = true;
      AppMethodBeat.o(27825);
      return;
    }
    if (this.org != null) {
      this.org.cj(paramBoolean);
    }
    this.orh = paramBoolean;
    if (!paramBoolean) {
      cI(this.path, this.dkj);
    }
    AppMethodBeat.o(27825);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(27823);
    ad.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
    stopPlay();
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onFinish();
    }
    AppMethodBeat.o(27823);
  }
  
  public final void onError()
  {
    AppMethodBeat.i(27822);
    ad.d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
    stopPlay();
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onFinish();
    }
    AppMethodBeat.o(27822);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(27821);
    ad.d("MicroMsg.RecordVoiceHelper", "stop play");
    an.aFy("keep_app_silent");
    if (this.org != null) {
      this.org.stop();
    }
    bTJ();
    AppMethodBeat.o(27821);
  }
  
  public static abstract interface a
  {
    public abstract void alu(String paramString);
    
    public abstract void onFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.s
 * JD-Core Version:    0.7.0.1
 */