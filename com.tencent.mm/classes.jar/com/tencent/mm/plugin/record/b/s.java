package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.i.a;
import com.tencent.mm.ak.i.b;
import com.tencent.mm.ak.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.audio.c.a;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class s
  implements i.a, i.b, SensorController.a
{
  public static SensorController oUL;
  public List<a> callbacks;
  private int dhE;
  long lastShakeTime;
  public i oUG;
  private boolean oUH;
  private boolean oUI;
  private boolean oUJ;
  private bj oUK;
  public String path;
  
  public s()
  {
    AppMethodBeat.i(27818);
    this.oUH = true;
    this.oUJ = false;
    this.lastShakeTime = -1L;
    this.callbacks = new LinkedList();
    this.oUG = ((j)g.ab(j.class)).Lk();
    az.ayM();
    Boolean localBoolean = (Boolean)c.agA().get(26, Boolean.FALSE);
    this.oUI = localBoolean.booleanValue();
    boolean bool;
    if (!localBoolean.booleanValue())
    {
      bool = true;
      this.oUH = bool;
      if (this.oUG == null) {
        break label213;
      }
      this.oUG.a(this);
      this.oUG.a(this);
      if ((!a.bCs()) && (!a.bCy())) {
        break label197;
      }
      this.oUG.cl(false);
    }
    for (;;)
    {
      if (oUL == null) {
        oUL = new SensorController(ai.getContext());
      }
      if (this.oUK == null) {
        this.oUK = new bj(ai.getContext());
      }
      AppMethodBeat.o(27818);
      return;
      bool = false;
      break;
      label197:
      this.oUG.cl(this.oUH);
      continue;
      label213:
      ac.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
    }
  }
  
  public final boolean cN(String paramString, int paramInt)
  {
    AppMethodBeat.i(27819);
    if (this.oUG == null)
    {
      ac.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(27819);
      return false;
    }
    this.oUG.stop();
    Object localObject = this.callbacks.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).aqt(paramString);
    }
    if ((oUL != null) && (!oUL.aKH))
    {
      oUL.a(this);
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27817);
          s.this.lastShakeTime = bs.Gn();
          AppMethodBeat.o(27817);
        }
      };
      if (!this.oUK.aE((Runnable)localObject)) {
        break label186;
      }
    }
    label186:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      this.path = paramString;
      this.dhE = paramInt;
      if ((bs.isNullOrNil(paramString)) || (!this.oUG.a(paramString, this.oUH, true, paramInt))) {
        break;
      }
      am.aKO("keep_app_silent");
      AppMethodBeat.o(27819);
      return true;
    }
    AppMethodBeat.o(27819);
    return false;
  }
  
  public final void caX()
  {
    AppMethodBeat.i(27824);
    if (oUL != null) {
      oUL.eVS();
    }
    if (this.oUK != null) {
      this.oUK.eVT();
    }
    AppMethodBeat.o(27824);
  }
  
  public final boolean caY()
  {
    AppMethodBeat.i(27820);
    if (this.oUG == null)
    {
      ac.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
      AppMethodBeat.o(27820);
      return false;
    }
    boolean bool = this.oUG.isPlaying();
    AppMethodBeat.o(27820);
    return bool;
  }
  
  public final void kc(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(27825);
    if (bs.isNullOrNil(this.path))
    {
      AppMethodBeat.o(27825);
      return;
    }
    if (this.oUJ)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.oUJ = paramBoolean;
        AppMethodBeat.o(27825);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (bs.aO(this.lastShakeTime) > 400L))
    {
      this.oUJ = true;
      AppMethodBeat.o(27825);
      return;
    }
    this.oUJ = false;
    if ((this.oUG != null) && (this.oUG.NU()))
    {
      AppMethodBeat.o(27825);
      return;
    }
    if (this.oUI)
    {
      if (this.oUG != null) {
        this.oUG.cl(false);
      }
      this.oUH = false;
      AppMethodBeat.o(27825);
      return;
    }
    if ((this.oUG != null) && (!this.oUG.isPlaying()))
    {
      this.oUG.cl(true);
      this.oUH = true;
      AppMethodBeat.o(27825);
      return;
    }
    if (this.oUG != null) {
      this.oUG.cl(paramBoolean);
    }
    this.oUH = paramBoolean;
    if (!paramBoolean) {
      cN(this.path, this.dhE);
    }
    AppMethodBeat.o(27825);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(27823);
    ac.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
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
    ac.d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
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
    ac.d("MicroMsg.RecordVoiceHelper", "stop play");
    am.aKP("keep_app_silent");
    if (this.oUG != null) {
      this.oUG.stop();
    }
    caX();
    AppMethodBeat.o(27821);
  }
  
  public static abstract interface a
  {
    public abstract void aqt(String paramString);
    
    public abstract void onFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.s
 * JD-Core Version:    0.7.0.1
 */