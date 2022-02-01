package com.tencent.mm.plugin.record.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j;
import com.tencent.mm.am.j.a;
import com.tencent.mm.am.j.b;
import com.tencent.mm.am.k;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.audio.c.a;
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

public class u
  implements j.a, j.b, SensorController.SensorEventCallBack
{
  public static SensorController xCV;
  public List<a> bPE;
  private int hIY;
  private long lastShakeTime;
  public String path;
  public j xCQ;
  private boolean xCR;
  private boolean xCS;
  private boolean xCT;
  private ShakeManager xCU;
  
  public u()
  {
    AppMethodBeat.i(27818);
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
        break label213;
      }
      this.xCQ.a(this);
      this.xCQ.a(this);
      if ((!a.cTQ()) && (!a.cTX())) {
        break label197;
      }
      this.xCQ.ed(false);
    }
    for (;;)
    {
      if (xCV == null) {
        xCV = new SensorController(MMApplicationContext.getContext());
      }
      if (this.xCU == null) {
        this.xCU = new ShakeManager(MMApplicationContext.getContext());
      }
      AppMethodBeat.o(27818);
      return;
      bool = false;
      break;
      label197:
      this.xCQ.ed(this.xCR);
      continue;
      label213:
      Log.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
    }
  }
  
  public final void atR()
  {
    AppMethodBeat.i(27822);
    Log.d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
    stopPlay();
    Iterator localIterator = this.bPE.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onFinish();
    }
    AppMethodBeat.o(27822);
  }
  
  public final boolean dU(String paramString, int paramInt)
  {
    AppMethodBeat.i(27819);
    if (this.xCQ == null)
    {
      Log.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(27819);
      return false;
    }
    this.xCQ.stop();
    Object localObject = this.bPE.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).aSI(paramString);
    }
    if ((xCV != null) && (!xCV.hasRegistered()))
    {
      xCV.setSensorCallBack(this);
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27817);
          u.a(u.this, Util.currentTicks());
          AppMethodBeat.o(27817);
        }
      };
      if (!this.xCU.startShake((Runnable)localObject)) {
        break label186;
      }
    }
    label186:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      this.path = paramString;
      this.hIY = paramInt;
      if ((Util.isNullOrNil(paramString)) || (!this.xCQ.a(paramString, this.xCR, true, paramInt))) {
        break;
      }
      MMEntryLock.lock("keep_app_silent");
      AppMethodBeat.o(27819);
      return true;
    }
    AppMethodBeat.o(27819);
    return false;
  }
  
  public final void dxD()
  {
    AppMethodBeat.i(27824);
    if (xCV != null) {
      xCV.removeSensorCallBack();
    }
    if (this.xCU != null) {
      this.xCU.stopShake();
    }
    AppMethodBeat.o(27824);
  }
  
  public final boolean dxE()
  {
    AppMethodBeat.i(27820);
    if (this.xCQ == null)
    {
      Log.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
      AppMethodBeat.o(27820);
      return false;
    }
    boolean bool = this.xCQ.isPlaying();
    AppMethodBeat.o(27820);
    return bool;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(27823);
    Log.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
    stopPlay();
    Iterator localIterator = this.bPE.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onFinish();
    }
    AppMethodBeat.o(27823);
  }
  
  public void onSensorEvent(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(27825);
    if (Util.isNullOrNil(this.path))
    {
      AppMethodBeat.o(27825);
      return;
    }
    if (this.xCT)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.xCT = paramBoolean;
        AppMethodBeat.o(27825);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (Util.ticksToNow(this.lastShakeTime) > 400L))
    {
      this.xCT = true;
      AppMethodBeat.o(27825);
      return;
    }
    this.xCT = false;
    if ((this.xCQ != null) && (this.xCQ.isCalling()))
    {
      AppMethodBeat.o(27825);
      return;
    }
    if (this.xCS)
    {
      if (this.xCQ != null) {
        this.xCQ.ed(false);
      }
      this.xCR = false;
      AppMethodBeat.o(27825);
      return;
    }
    if ((this.xCQ != null) && (!this.xCQ.isPlaying()))
    {
      this.xCQ.ed(true);
      this.xCR = true;
      AppMethodBeat.o(27825);
      return;
    }
    if (this.xCQ != null) {
      this.xCQ.ed(paramBoolean);
    }
    this.xCR = paramBoolean;
    if (!paramBoolean) {
      dU(this.path, this.hIY);
    }
    AppMethodBeat.o(27825);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(27821);
    Log.d("MicroMsg.RecordVoiceHelper", "stop play");
    MMEntryLock.unlock("keep_app_silent");
    if (this.xCQ != null) {
      this.xCQ.stop();
    }
    dxD();
    AppMethodBeat.o(27821);
  }
  
  public static abstract interface a
  {
    public abstract void aSI(String paramString);
    
    public abstract void onFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.model.u
 * JD-Core Version:    0.7.0.1
 */