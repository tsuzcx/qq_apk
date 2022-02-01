package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.i.a;
import com.tencent.mm.ak.i.b;
import com.tencent.mm.ak.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
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

public class a
  implements i.a, i.b, SensorController.a
{
  private static volatile a CZa = null;
  List<a> callbacks;
  private int dhE;
  private long lastShakeTime;
  public i oUG;
  private boolean oUH;
  private boolean oUI;
  private boolean oUJ;
  private bj oUK;
  private SensorController oUL;
  public String path;
  
  private a()
  {
    AppMethodBeat.i(30900);
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
        break label190;
      }
      this.oUG.a(this);
      this.oUG.a(this);
      this.oUG.cl(this.oUH);
    }
    for (;;)
    {
      if (this.oUL == null) {
        this.oUL = new SensorController(ai.getContext());
      }
      if (this.oUK == null) {
        this.oUK = new bj(ai.getContext());
      }
      AppMethodBeat.o(30900);
      return;
      bool = false;
      break;
      label190:
      ac.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
    }
  }
  
  private void caW()
  {
    AppMethodBeat.i(30903);
    if ((this.oUL != null) && (!this.oUL.aKH))
    {
      this.oUL.a(this);
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30899);
          a.a(a.this, bs.Gn());
          AppMethodBeat.o(30899);
        }
      };
      if (this.oUK.aE(local1))
      {
        this.lastShakeTime = 0L;
        AppMethodBeat.o(30903);
        return;
      }
      this.lastShakeTime = -1L;
    }
    AppMethodBeat.o(30903);
  }
  
  private void caX()
  {
    AppMethodBeat.i(30904);
    if (this.oUL != null) {
      this.oUL.eVS();
    }
    if (this.oUK != null) {
      this.oUK.eVT();
    }
    AppMethodBeat.o(30904);
  }
  
  public static a eIA()
  {
    AppMethodBeat.i(30901);
    if (CZa == null) {}
    try
    {
      if (CZa == null) {
        CZa = new a();
      }
      a locala = CZa;
      AppMethodBeat.o(30901);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(30901);
    }
  }
  
  public final double NW()
  {
    AppMethodBeat.i(30908);
    if (this.oUG == null)
    {
      ac.w("MicroMsg.RecordVoiceHelper", "get now progress error, player is null");
      AppMethodBeat.o(30908);
      return 0.0D;
    }
    double d = this.oUG.NW();
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
  
  public final boolean cN(String paramString, int paramInt)
  {
    AppMethodBeat.i(30905);
    if (this.oUG == null)
    {
      ac.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(30905);
      return false;
    }
    this.oUG.stop();
    caW();
    this.path = paramString;
    this.dhE = paramInt;
    if ((!bs.isNullOrNil(paramString)) && (this.oUG.a(paramString, this.oUH, true, paramInt)))
    {
      am.aKO("keep_app_silent");
      Iterator localIterator = this.callbacks.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.Xr(paramString);
        }
      }
      AppMethodBeat.o(30905);
      return true;
    }
    AppMethodBeat.o(30905);
    return false;
  }
  
  public final boolean caY()
  {
    AppMethodBeat.i(30907);
    if (this.oUG == null)
    {
      ac.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
      AppMethodBeat.o(30907);
      return false;
    }
    boolean bool = this.oUG.isPlaying();
    AppMethodBeat.o(30907);
    return bool;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(179754);
    stopPlay();
    this.oUL = null;
    this.oUK = null;
    this.callbacks.clear();
    AppMethodBeat.o(179754);
  }
  
  public final void kc(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(30911);
    if (bs.isNullOrNil(this.path))
    {
      AppMethodBeat.o(30911);
      return;
    }
    if (this.oUJ)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.oUJ = paramBoolean;
        AppMethodBeat.o(30911);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (bs.aO(this.lastShakeTime) > 400L))
    {
      this.oUJ = true;
      AppMethodBeat.o(30911);
      return;
    }
    this.oUJ = false;
    if ((this.oUG != null) && (this.oUG.NU()))
    {
      AppMethodBeat.o(30911);
      return;
    }
    if (this.oUI)
    {
      if (this.oUG != null) {
        this.oUG.cl(false);
      }
      this.oUH = false;
      AppMethodBeat.o(30911);
      return;
    }
    if ((this.oUG != null) && (!this.oUG.isPlaying()))
    {
      this.oUG.cl(true);
      this.oUH = true;
      AppMethodBeat.o(30911);
      return;
    }
    if (this.oUG != null) {
      this.oUG.cl(paramBoolean);
    }
    this.oUH = paramBoolean;
    if (!paramBoolean) {
      cN(this.path, this.dhE);
    }
    AppMethodBeat.o(30911);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(30910);
    ac.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
    stopPlay();
    AppMethodBeat.o(30910);
  }
  
  public final void onError()
  {
    AppMethodBeat.i(30909);
    ac.d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
    stopPlay();
    AppMethodBeat.o(30909);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(30906);
    ac.i("MicroMsg.RecordVoiceHelper", "stop play");
    am.aKP("keep_app_silent");
    if (this.oUG != null)
    {
      this.oUG.stop();
      Iterator localIterator = this.callbacks.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.caU();
        }
      }
    }
    caX();
    AppMethodBeat.o(30906);
  }
  
  public static abstract interface a
  {
    public abstract void Xr(String paramString);
    
    public abstract void caU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a
 * JD-Core Version:    0.7.0.1
 */