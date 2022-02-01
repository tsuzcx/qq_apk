package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.k;
import com.tencent.mm.ak.k.a;
import com.tencent.mm.ak.k.b;
import com.tencent.mm.ak.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
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
  private static volatile a JLm = null;
  List<a> callbacks;
  private int dLt;
  private long lastShakeTime;
  public String path;
  public k qUl;
  private boolean qUm;
  private boolean qUn;
  private boolean qUo;
  private ShakeManager qUp;
  private SensorController qUq;
  
  private a()
  {
    AppMethodBeat.i(30900);
    this.qUm = true;
    this.qUo = false;
    this.lastShakeTime = -1L;
    this.callbacks = new LinkedList();
    this.qUl = ((l)g.af(l.class)).Xa();
    bg.aVF();
    Boolean localBoolean = (Boolean)c.azQ().get(26, Boolean.FALSE);
    this.qUn = localBoolean.booleanValue();
    boolean bool;
    if (!localBoolean.booleanValue())
    {
      bool = true;
      this.qUm = bool;
      if (this.qUl == null) {
        break label190;
      }
      this.qUl.a(this);
      this.qUl.a(this);
      this.qUl.cU(this.qUm);
    }
    for (;;)
    {
      if (this.qUq == null) {
        this.qUq = new SensorController(MMApplicationContext.getContext());
      }
      if (this.qUp == null) {
        this.qUp = new ShakeManager(MMApplicationContext.getContext());
      }
      AppMethodBeat.o(30900);
      return;
      bool = false;
      break;
      label190:
      Log.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
    }
  }
  
  private void cED()
  {
    AppMethodBeat.i(30903);
    if ((this.qUq != null) && (!this.qUq.hasRegistered()))
    {
      this.qUq.setSensorCallBack(this);
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30899);
          a.a(a.this, Util.currentTicks());
          AppMethodBeat.o(30899);
        }
      };
      if (this.qUp.startShake(local1))
      {
        this.lastShakeTime = 0L;
        AppMethodBeat.o(30903);
        return;
      }
      this.lastShakeTime = -1L;
    }
    AppMethodBeat.o(30903);
  }
  
  private void cEE()
  {
    AppMethodBeat.i(30904);
    if (this.qUq != null) {
      this.qUq.removeSensorCallBack();
    }
    if (this.qUp != null) {
      this.qUp.stopShake();
    }
    AppMethodBeat.o(30904);
  }
  
  public static a gkl()
  {
    AppMethodBeat.i(30901);
    if (JLm == null) {}
    try
    {
      if (JLm == null) {
        JLm = new a();
      }
      a locala = JLm;
      AppMethodBeat.o(30901);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(30901);
    }
  }
  
  public final double ZY()
  {
    AppMethodBeat.i(30908);
    if (this.qUl == null)
    {
      Log.w("MicroMsg.RecordVoiceHelper", "get now progress error, player is null");
      AppMethodBeat.o(30908);
      return 0.0D;
    }
    double d = this.qUl.ZY();
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
  
  public final boolean cEF()
  {
    AppMethodBeat.i(30907);
    if (this.qUl == null)
    {
      Log.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
      AppMethodBeat.o(30907);
      return false;
    }
    boolean bool = this.qUl.isPlaying();
    AppMethodBeat.o(30907);
    return bool;
  }
  
  public final boolean cZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(30905);
    if (this.qUl == null)
    {
      Log.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(30905);
      return false;
    }
    this.qUl.stop();
    cED();
    this.path = paramString;
    this.dLt = paramInt;
    if ((!Util.isNullOrNil(paramString)) && (this.qUl.a(paramString, this.qUm, true, paramInt)))
    {
      MMEntryLock.lock("keep_app_silent");
      Iterator localIterator = this.callbacks.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.alV(paramString);
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
    this.qUq = null;
    this.qUp = null;
    this.callbacks.clear();
    AppMethodBeat.o(179754);
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
    if (this.qUo)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.qUo = paramBoolean;
        AppMethodBeat.o(30911);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (Util.ticksToNow(this.lastShakeTime) > 400L))
    {
      this.qUo = true;
      AppMethodBeat.o(30911);
      return;
    }
    this.qUo = false;
    if ((this.qUl != null) && (this.qUl.isCalling()))
    {
      AppMethodBeat.o(30911);
      return;
    }
    if (this.qUn)
    {
      if (this.qUl != null) {
        this.qUl.cU(false);
      }
      this.qUm = false;
      AppMethodBeat.o(30911);
      return;
    }
    if ((this.qUl != null) && (!this.qUl.isPlaying()))
    {
      this.qUl.cU(true);
      this.qUm = true;
      AppMethodBeat.o(30911);
      return;
    }
    if (this.qUl != null) {
      this.qUl.cU(paramBoolean);
    }
    this.qUm = paramBoolean;
    if (!paramBoolean) {
      cZ(this.path, this.dLt);
    }
    AppMethodBeat.o(30911);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(30906);
    Log.i("MicroMsg.RecordVoiceHelper", "stop play");
    MMEntryLock.unlock("keep_app_silent");
    if (this.qUl != null)
    {
      this.qUl.stop();
      Iterator localIterator = this.callbacks.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.cEB();
        }
      }
    }
    cEE();
    AppMethodBeat.o(30906);
  }
  
  public static abstract interface a
  {
    public abstract void alV(String paramString);
    
    public abstract void cEB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a
 * JD-Core Version:    0.7.0.1
 */