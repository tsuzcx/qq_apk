package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.h;
import com.tencent.mm.al.h.a;
import com.tencent.mm.al.h.b;
import com.tencent.mm.al.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class a
  implements h.a, h.b, SensorController.a
{
  private static volatile a ECW = null;
  List<a> callbacks;
  private int dtc;
  private long lastShakeTime;
  public String path;
  public h pyq;
  private boolean pyr;
  private boolean pys;
  private boolean pyt;
  private bk pyu;
  private SensorController pyv;
  
  private a()
  {
    AppMethodBeat.i(30900);
    this.pyr = true;
    this.pyt = false;
    this.lastShakeTime = -1L;
    this.callbacks = new LinkedList();
    this.pyq = ((i)g.ab(i.class)).MS();
    ba.aBQ();
    Boolean localBoolean = (Boolean)c.ajl().get(26, Boolean.FALSE);
    this.pys = localBoolean.booleanValue();
    boolean bool;
    if (!localBoolean.booleanValue())
    {
      bool = true;
      this.pyr = bool;
      if (this.pyq == null) {
        break label190;
      }
      this.pyq.a(this);
      this.pyq.a(this);
      this.pyq.cm(this.pyr);
    }
    for (;;)
    {
      if (this.pyv == null) {
        this.pyv = new SensorController(aj.getContext());
      }
      if (this.pyu == null) {
        this.pyu = new bk(aj.getContext());
      }
      AppMethodBeat.o(30900);
      return;
      bool = false;
      break;
      label190:
      ad.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
    }
  }
  
  private void cfA()
  {
    AppMethodBeat.i(30903);
    if ((this.pyv != null) && (!this.pyv.aMy))
    {
      this.pyv.a(this);
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30899);
          a.a(a.this, bt.HI());
          AppMethodBeat.o(30899);
        }
      };
      if (this.pyu.aD(local1))
      {
        this.lastShakeTime = 0L;
        AppMethodBeat.o(30903);
        return;
      }
      this.lastShakeTime = -1L;
    }
    AppMethodBeat.o(30903);
  }
  
  private void cfB()
  {
    AppMethodBeat.i(30904);
    if (this.pyv != null) {
      this.pyv.flC();
    }
    if (this.pyu != null) {
      this.pyu.flD();
    }
    AppMethodBeat.o(30904);
  }
  
  public static a eXt()
  {
    AppMethodBeat.i(30901);
    if (ECW == null) {}
    try
    {
      if (ECW == null) {
        ECW = new a();
      }
      a locala = ECW;
      AppMethodBeat.o(30901);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(30901);
    }
  }
  
  public final double PF()
  {
    AppMethodBeat.i(30908);
    if (this.pyq == null)
    {
      ad.w("MicroMsg.RecordVoiceHelper", "get now progress error, player is null");
      AppMethodBeat.o(30908);
      return 0.0D;
    }
    double d = this.pyq.PF();
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
  
  public final boolean cQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(30905);
    if (this.pyq == null)
    {
      ad.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(30905);
      return false;
    }
    this.pyq.stop();
    cfA();
    this.path = paramString;
    this.dtc = paramInt;
    if ((!bt.isNullOrNil(paramString)) && (this.pyq.a(paramString, this.pyr, true, paramInt)))
    {
      an.aQu("keep_app_silent");
      Iterator localIterator = this.callbacks.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.aaY(paramString);
        }
      }
      AppMethodBeat.o(30905);
      return true;
    }
    AppMethodBeat.o(30905);
    return false;
  }
  
  public final boolean cfC()
  {
    AppMethodBeat.i(30907);
    if (this.pyq == null)
    {
      ad.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
      AppMethodBeat.o(30907);
      return false;
    }
    boolean bool = this.pyq.isPlaying();
    AppMethodBeat.o(30907);
    return bool;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(179754);
    stopPlay();
    this.pyv = null;
    this.pyu = null;
    this.callbacks.clear();
    AppMethodBeat.o(179754);
  }
  
  public final void kn(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(30911);
    if (bt.isNullOrNil(this.path))
    {
      AppMethodBeat.o(30911);
      return;
    }
    if (this.pyt)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.pyt = paramBoolean;
        AppMethodBeat.o(30911);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (bt.aO(this.lastShakeTime) > 400L))
    {
      this.pyt = true;
      AppMethodBeat.o(30911);
      return;
    }
    this.pyt = false;
    if ((this.pyq != null) && (this.pyq.PD()))
    {
      AppMethodBeat.o(30911);
      return;
    }
    if (this.pys)
    {
      if (this.pyq != null) {
        this.pyq.cm(false);
      }
      this.pyr = false;
      AppMethodBeat.o(30911);
      return;
    }
    if ((this.pyq != null) && (!this.pyq.isPlaying()))
    {
      this.pyq.cm(true);
      this.pyr = true;
      AppMethodBeat.o(30911);
      return;
    }
    if (this.pyq != null) {
      this.pyq.cm(paramBoolean);
    }
    this.pyr = paramBoolean;
    if (!paramBoolean) {
      cQ(this.path, this.dtc);
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
    an.aQv("keep_app_silent");
    if (this.pyq != null)
    {
      this.pyq.stop();
      Iterator localIterator = this.callbacks.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.cfy();
        }
      }
    }
    cfB();
    AppMethodBeat.o(30906);
  }
  
  public static abstract interface a
  {
    public abstract void aaY(String paramString);
    
    public abstract void cfy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a
 * JD-Core Version:    0.7.0.1
 */