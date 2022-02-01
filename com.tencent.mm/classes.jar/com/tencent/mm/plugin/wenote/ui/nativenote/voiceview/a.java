package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j;
import com.tencent.mm.am.j.a;
import com.tencent.mm.am.j.b;
import com.tencent.mm.am.k;
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
import com.tencent.mm.storage.aq;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class a
  implements j.a, j.b, SensorController.SensorEventCallBack
{
  private static volatile a XEe = null;
  List<a> bPE;
  private int hIY;
  private long lastShakeTime;
  public String path;
  public j xCQ;
  private boolean xCR;
  private boolean xCS;
  private boolean xCT;
  private ShakeManager xCU;
  private SensorController xCV;
  
  private a()
  {
    AppMethodBeat.i(30900);
    this.xCR = true;
    this.xCT = false;
    this.lastShakeTime = -1L;
    this.bPE = new LinkedList();
    this.xCQ = ((k)h.ax(k.class)).aDy();
    bh.bCz();
    Boolean localBoolean = (Boolean)c.ban().d(26, Boolean.FALSE);
    this.xCS = localBoolean.booleanValue();
    boolean bool;
    if (!localBoolean.booleanValue())
    {
      bool = true;
      this.xCR = bool;
      if (this.xCQ == null) {
        break label190;
      }
      this.xCQ.a(this);
      this.xCQ.a(this);
      this.xCQ.ed(this.xCR);
    }
    for (;;)
    {
      if (this.xCV == null) {
        this.xCV = new SensorController(MMApplicationContext.getContext());
      }
      if (this.xCU == null) {
        this.xCU = new ShakeManager(MMApplicationContext.getContext());
      }
      AppMethodBeat.o(30900);
      return;
      bool = false;
      break;
      label190:
      Log.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
    }
  }
  
  private void dxC()
  {
    AppMethodBeat.i(30903);
    if ((this.xCV != null) && (!this.xCV.hasRegistered()))
    {
      this.xCV.setSensorCallBack(this);
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30899);
          a.a(a.this, Util.currentTicks());
          AppMethodBeat.o(30899);
        }
      };
      if (this.xCU.startShake(local1))
      {
        this.lastShakeTime = 0L;
        AppMethodBeat.o(30903);
        return;
      }
      this.lastShakeTime = -1L;
    }
    AppMethodBeat.o(30903);
  }
  
  private void dxD()
  {
    AppMethodBeat.i(30904);
    if (this.xCV != null) {
      this.xCV.removeSensorCallBack();
    }
    if (this.xCU != null) {
      this.xCU.stopShake();
    }
    AppMethodBeat.o(30904);
  }
  
  public static a iEK()
  {
    AppMethodBeat.i(30901);
    if (XEe == null) {}
    try
    {
      if (XEe == null) {
        XEe = new a();
      }
      a locala = XEe;
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
    Iterator localIterator = this.bPE.iterator();
    while (localIterator.hasNext()) {
      if (parama == (a)localIterator.next())
      {
        AppMethodBeat.o(30902);
        return;
      }
    }
    this.bPE.add(parama);
    AppMethodBeat.o(30902);
  }
  
  public final double aGG()
  {
    AppMethodBeat.i(30908);
    if (this.xCQ == null)
    {
      Log.w("MicroMsg.RecordVoiceHelper", "get now progress error, player is null");
      AppMethodBeat.o(30908);
      return 0.0D;
    }
    double d = this.xCQ.aGG();
    AppMethodBeat.o(30908);
    return d;
  }
  
  public final void atR()
  {
    AppMethodBeat.i(30909);
    Log.d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
    stopPlay();
    AppMethodBeat.o(30909);
  }
  
  public final boolean dU(String paramString, int paramInt)
  {
    AppMethodBeat.i(30905);
    if (this.xCQ == null)
    {
      Log.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(30905);
      return false;
    }
    this.xCQ.stop();
    dxC();
    this.path = paramString;
    this.hIY = paramInt;
    if ((!Util.isNullOrNil(paramString)) && (this.xCQ.a(paramString, this.xCR, true, paramInt)))
    {
      MMEntryLock.lock("keep_app_silent");
      Iterator localIterator = this.bPE.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.anE(paramString);
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
    this.xCV = null;
    this.xCU = null;
    this.bPE.clear();
    AppMethodBeat.o(179754);
  }
  
  public final boolean dxE()
  {
    AppMethodBeat.i(30907);
    if (this.xCQ == null)
    {
      Log.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
      AppMethodBeat.o(30907);
      return false;
    }
    boolean bool = this.xCQ.isPlaying();
    AppMethodBeat.o(30907);
    return bool;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(30910);
    Log.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
    stopPlay();
    AppMethodBeat.o(30910);
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
    if (this.xCT)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.xCT = paramBoolean;
        AppMethodBeat.o(30911);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (Util.ticksToNow(this.lastShakeTime) > 400L))
    {
      this.xCT = true;
      AppMethodBeat.o(30911);
      return;
    }
    this.xCT = false;
    if ((this.xCQ != null) && (this.xCQ.isCalling()))
    {
      AppMethodBeat.o(30911);
      return;
    }
    if (this.xCS)
    {
      if (this.xCQ != null) {
        this.xCQ.ed(false);
      }
      this.xCR = false;
      AppMethodBeat.o(30911);
      return;
    }
    if ((this.xCQ != null) && (!this.xCQ.isPlaying()))
    {
      this.xCQ.ed(true);
      this.xCR = true;
      AppMethodBeat.o(30911);
      return;
    }
    if (this.xCQ != null) {
      this.xCQ.ed(paramBoolean);
    }
    this.xCR = paramBoolean;
    if (!paramBoolean) {
      dU(this.path, this.hIY);
    }
    AppMethodBeat.o(30911);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(30906);
    Log.i("MicroMsg.RecordVoiceHelper", "stop play");
    MMEntryLock.unlock("keep_app_silent");
    if (this.xCQ != null)
    {
      this.xCQ.stop();
      Iterator localIterator = this.bPE.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.dxA();
        }
      }
    }
    dxD();
    AppMethodBeat.o(30906);
  }
  
  public static abstract interface a
  {
    public abstract void anE(String paramString);
    
    public abstract void dxA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a
 * JD-Core Version:    0.7.0.1
 */