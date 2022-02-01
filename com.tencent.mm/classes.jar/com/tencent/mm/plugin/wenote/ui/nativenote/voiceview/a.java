package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.i;
import com.tencent.mm.al.i.a;
import com.tencent.mm.al.i.b;
import com.tencent.mm.al.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
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

public class a
  implements i.a, i.b, SensorController.a
{
  private static volatile a BGT = null;
  List<a> callbacks;
  private int dkj;
  private long lastShakeTime;
  public i org;
  private boolean orh;
  private boolean ori;
  private boolean orj;
  private bk ork;
  private SensorController orl;
  public String path;
  
  private a()
  {
    AppMethodBeat.i(30900);
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
        break label190;
      }
      this.org.a(this);
      this.org.a(this);
      this.org.cj(this.orh);
    }
    for (;;)
    {
      if (this.orl == null) {
        this.orl = new SensorController(aj.getContext());
      }
      if (this.ork == null) {
        this.ork = new bk(aj.getContext());
      }
      AppMethodBeat.o(30900);
      return;
      bool = false;
      break;
      label190:
      ad.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
    }
  }
  
  private void bTI()
  {
    AppMethodBeat.i(30903);
    if ((this.orl != null) && (!this.orl.aJR))
    {
      this.orl.a(this);
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30899);
          a.a(a.this, bt.GC());
          AppMethodBeat.o(30899);
        }
      };
      if (this.ork.aC(local1))
      {
        this.lastShakeTime = 0L;
        AppMethodBeat.o(30903);
        return;
      }
      this.lastShakeTime = -1L;
    }
    AppMethodBeat.o(30903);
  }
  
  private void bTJ()
  {
    AppMethodBeat.i(30904);
    if (this.orl != null) {
      this.orl.eGx();
    }
    if (this.ork != null) {
      this.ork.eGy();
    }
    AppMethodBeat.o(30904);
  }
  
  public static a eth()
  {
    AppMethodBeat.i(30901);
    if (BGT == null) {}
    try
    {
      if (BGT == null) {
        BGT = new a();
      }
      a locala = BGT;
      AppMethodBeat.o(30901);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(30901);
    }
  }
  
  public final double Oa()
  {
    AppMethodBeat.i(30908);
    if (this.org == null)
    {
      ad.w("MicroMsg.RecordVoiceHelper", "get now progress error, player is null");
      AppMethodBeat.o(30908);
      return 0.0D;
    }
    double d = this.org.Oa();
    AppMethodBeat.o(30908);
    return d;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(30902);
    if (parama == null)
    {
      AppMethodBeat.o(30902);
      return;
    }
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      if (parama == (a)localIterator.next())
      {
        AppMethodBeat.o(30902);
        return;
      }
    }
    this.callbacks.add(parama);
    AppMethodBeat.o(30902);
  }
  
  public final boolean bTK()
  {
    AppMethodBeat.i(30907);
    if (this.org == null)
    {
      ad.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
      AppMethodBeat.o(30907);
      return false;
    }
    boolean bool = this.org.isPlaying();
    AppMethodBeat.o(30907);
    return bool;
  }
  
  public final boolean cI(String paramString, int paramInt)
  {
    AppMethodBeat.i(30905);
    if (this.org == null)
    {
      ad.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(30905);
      return false;
    }
    this.org.stop();
    bTI();
    this.path = paramString;
    this.dkj = paramInt;
    if ((!bt.isNullOrNil(paramString)) && (this.org.a(paramString, this.orh, true, paramInt)))
    {
      an.aFx("keep_app_silent");
      Iterator localIterator = this.callbacks.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.Tf(paramString);
        }
      }
      AppMethodBeat.o(30905);
      return true;
    }
    AppMethodBeat.o(30905);
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(179754);
    stopPlay();
    this.orl = null;
    this.ork = null;
    this.callbacks.clear();
    AppMethodBeat.o(179754);
  }
  
  public final void jz(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(30911);
    if (bt.isNullOrNil(this.path))
    {
      AppMethodBeat.o(30911);
      return;
    }
    if (this.orj)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.orj = paramBoolean;
        AppMethodBeat.o(30911);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (bt.aS(this.lastShakeTime) > 400L))
    {
      this.orj = true;
      AppMethodBeat.o(30911);
      return;
    }
    this.orj = false;
    if ((this.org != null) && (this.org.NY()))
    {
      AppMethodBeat.o(30911);
      return;
    }
    if (this.ori)
    {
      if (this.org != null) {
        this.org.cj(false);
      }
      this.orh = false;
      AppMethodBeat.o(30911);
      return;
    }
    if ((this.org != null) && (!this.org.isPlaying()))
    {
      this.org.cj(true);
      this.orh = true;
      AppMethodBeat.o(30911);
      return;
    }
    if (this.org != null) {
      this.org.cj(paramBoolean);
    }
    this.orh = paramBoolean;
    if (!paramBoolean) {
      cI(this.path, this.dkj);
    }
    AppMethodBeat.o(30911);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(30910);
    ad.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
    stopPlay();
    AppMethodBeat.o(30910);
  }
  
  public final void onError()
  {
    AppMethodBeat.i(30909);
    ad.d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
    stopPlay();
    AppMethodBeat.o(30909);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(30906);
    ad.i("MicroMsg.RecordVoiceHelper", "stop play");
    an.aFy("keep_app_silent");
    if (this.org != null)
    {
      this.org.stop();
      Iterator localIterator = this.callbacks.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.bTG();
        }
      }
    }
    bTJ();
    AppMethodBeat.o(30906);
  }
  
  public static abstract interface a
  {
    public abstract void Tf(String paramString);
    
    public abstract void bTG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a
 * JD-Core Version:    0.7.0.1
 */