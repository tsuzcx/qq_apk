package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.k;
import com.tencent.mm.an.k.a;
import com.tencent.mm.an.k.b;
import com.tencent.mm.an.l;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.SensorEventCallBack;
import com.tencent.mm.sdk.platformtools.ShakeManager;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class a
  implements k.a, k.b, SensorController.SensorEventCallBack
{
  private static volatile a QKF = null;
  List<a> callbacks;
  private int fEi;
  private long lastShakeTime;
  public String path;
  public k uwr;
  private boolean uws;
  private boolean uwt;
  private boolean uwu;
  private ShakeManager uwv;
  private SensorController uww;
  
  private a()
  {
    AppMethodBeat.i(30900);
    this.uws = true;
    this.uwu = false;
    this.lastShakeTime = -1L;
    this.callbacks = new LinkedList();
    this.uwr = ((l)h.ae(l.class)).abD();
    bh.beI();
    Boolean localBoolean = (Boolean)c.aHp().b(26, Boolean.FALSE);
    this.uwt = localBoolean.booleanValue();
    boolean bool;
    if (!localBoolean.booleanValue())
    {
      bool = true;
      this.uws = bool;
      if (this.uwr == null) {
        break label190;
      }
      this.uwr.a(this);
      this.uwr.a(this);
      this.uwr.dr(this.uws);
    }
    for (;;)
    {
      if (this.uww == null) {
        this.uww = new SensorController(MMApplicationContext.getContext());
      }
      if (this.uwv == null) {
        this.uwv = new ShakeManager(MMApplicationContext.getContext());
      }
      AppMethodBeat.o(30900);
      return;
      bool = false;
      break;
      label190:
      Log.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
    }
  }
  
  private void cTj()
  {
    AppMethodBeat.i(30903);
    if ((this.uww != null) && (!this.uww.hasRegistered()))
    {
      this.uww.setSensorCallBack(this);
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30899);
          a.a(a.this, Util.currentTicks());
          AppMethodBeat.o(30899);
        }
      };
      if (this.uwv.startShake(local1))
      {
        this.lastShakeTime = 0L;
        AppMethodBeat.o(30903);
        return;
      }
      this.lastShakeTime = -1L;
    }
    AppMethodBeat.o(30903);
  }
  
  private void cTk()
  {
    AppMethodBeat.i(30904);
    if (this.uww != null) {
      this.uww.removeSensorCallBack();
    }
    if (this.uwv != null) {
      this.uwv.stopShake();
    }
    AppMethodBeat.o(30904);
  }
  
  public static a hec()
  {
    AppMethodBeat.i(30901);
    if (QKF == null) {}
    try
    {
      if (QKF == null) {
        QKF = new a();
      }
      a locala = QKF;
      AppMethodBeat.o(30901);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(30901);
    }
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
  
  public final double aeI()
  {
    AppMethodBeat.i(30908);
    if (this.uwr == null)
    {
      Log.w("MicroMsg.RecordVoiceHelper", "get now progress error, player is null");
      AppMethodBeat.o(30908);
      return 0.0D;
    }
    double d = this.uwr.aeI();
    AppMethodBeat.o(30908);
    return d;
  }
  
  public final boolean cTl()
  {
    AppMethodBeat.i(30907);
    if (this.uwr == null)
    {
      Log.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
      AppMethodBeat.o(30907);
      return false;
    }
    boolean bool = this.uwr.isPlaying();
    AppMethodBeat.o(30907);
    return bool;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(179754);
    stopPlay();
    this.uww = null;
    this.uwv = null;
    this.callbacks.clear();
    AppMethodBeat.o(179754);
  }
  
  public final boolean dt(String paramString, int paramInt)
  {
    AppMethodBeat.i(30905);
    if (this.uwr == null)
    {
      Log.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(30905);
      return false;
    }
    this.uwr.stop();
    cTj();
    this.path = paramString;
    this.fEi = paramInt;
    if ((!Util.isNullOrNil(paramString)) && (this.uwr.a(paramString, this.uws, true, paramInt)))
    {
      MMEntryLock.lock("keep_app_silent");
      Iterator localIterator = this.callbacks.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.atP(paramString);
        }
      }
      AppMethodBeat.o(30905);
      return true;
    }
    AppMethodBeat.o(30905);
    return false;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(30910);
    Log.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
    stopPlay();
    AppMethodBeat.o(30910);
  }
  
  public final void onError()
  {
    AppMethodBeat.i(30909);
    Log.d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
    stopPlay();
    AppMethodBeat.o(30909);
  }
  
  public void onSensorEvent(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(30911);
    if (Util.isNullOrNil(this.path))
    {
      AppMethodBeat.o(30911);
      return;
    }
    if (this.uwu)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.uwu = paramBoolean;
        AppMethodBeat.o(30911);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (Util.ticksToNow(this.lastShakeTime) > 400L))
    {
      this.uwu = true;
      AppMethodBeat.o(30911);
      return;
    }
    this.uwu = false;
    if ((this.uwr != null) && (this.uwr.isCalling()))
    {
      AppMethodBeat.o(30911);
      return;
    }
    if (this.uwt)
    {
      if (this.uwr != null) {
        this.uwr.dr(false);
      }
      this.uws = false;
      AppMethodBeat.o(30911);
      return;
    }
    if ((this.uwr != null) && (!this.uwr.isPlaying()))
    {
      this.uwr.dr(true);
      this.uws = true;
      AppMethodBeat.o(30911);
      return;
    }
    if (this.uwr != null) {
      this.uwr.dr(paramBoolean);
    }
    this.uws = paramBoolean;
    if (!paramBoolean) {
      dt(this.path, this.fEi);
    }
    AppMethodBeat.o(30911);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(30906);
    Log.i("MicroMsg.RecordVoiceHelper", "stop play");
    MMEntryLock.unlock("keep_app_silent");
    if (this.uwr != null)
    {
      this.uwr.stop();
      Iterator localIterator = this.callbacks.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.cTh();
        }
      }
    }
    cTk();
    AppMethodBeat.o(30906);
  }
  
  public static abstract interface a
  {
    public abstract void atP(String paramString);
    
    public abstract void cTh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a
 * JD-Core Version:    0.7.0.1
 */