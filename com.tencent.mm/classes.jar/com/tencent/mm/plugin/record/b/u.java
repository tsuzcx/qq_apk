package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.k;
import com.tencent.mm.ak.k.a;
import com.tencent.mm.ak.k.b;
import com.tencent.mm.ak.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.audio.c.a;
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

public final class u
  implements k.a, k.b, SensorController.SensorEventCallBack
{
  public static SensorController qUq;
  public List<a> callbacks;
  private int dLt;
  private long lastShakeTime;
  public String path;
  public k qUl;
  private boolean qUm;
  private boolean qUn;
  private boolean qUo;
  private ShakeManager qUp;
  
  public u()
  {
    AppMethodBeat.i(27818);
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
        break label213;
      }
      this.qUl.a(this);
      this.qUl.a(this);
      if ((!a.cdW()) && (!a.ceb())) {
        break label197;
      }
      this.qUl.cU(false);
    }
    for (;;)
    {
      if (qUq == null) {
        qUq = new SensorController(MMApplicationContext.getContext());
      }
      if (this.qUp == null) {
        this.qUp = new ShakeManager(MMApplicationContext.getContext());
      }
      AppMethodBeat.o(27818);
      return;
      bool = false;
      break;
      label197:
      this.qUl.cU(this.qUm);
      continue;
      label213:
      Log.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
    }
  }
  
  public final void cEE()
  {
    AppMethodBeat.i(27824);
    if (qUq != null) {
      qUq.removeSensorCallBack();
    }
    if (this.qUp != null) {
      this.qUp.stopShake();
    }
    AppMethodBeat.o(27824);
  }
  
  public final boolean cEF()
  {
    AppMethodBeat.i(27820);
    if (this.qUl == null)
    {
      Log.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
      AppMethodBeat.o(27820);
      return false;
    }
    boolean bool = this.qUl.isPlaying();
    AppMethodBeat.o(27820);
    return bool;
  }
  
  public final boolean cZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(27819);
    if (this.qUl == null)
    {
      Log.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(27819);
      return false;
    }
    this.qUl.stop();
    Object localObject = this.callbacks.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).aKZ(paramString);
    }
    if ((qUq != null) && (!qUq.hasRegistered()))
    {
      qUq.setSensorCallBack(this);
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27817);
          u.a(u.this, Util.currentTicks());
          AppMethodBeat.o(27817);
        }
      };
      if (!this.qUp.startShake((Runnable)localObject)) {
        break label186;
      }
    }
    label186:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      this.path = paramString;
      this.dLt = paramInt;
      if ((Util.isNullOrNil(paramString)) || (!this.qUl.a(paramString, this.qUm, true, paramInt))) {
        break;
      }
      MMEntryLock.lock("keep_app_silent");
      AppMethodBeat.o(27819);
      return true;
    }
    AppMethodBeat.o(27819);
    return false;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(27823);
    Log.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
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
    Log.d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
    stopPlay();
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onFinish();
    }
    AppMethodBeat.o(27822);
  }
  
  public final void onSensorEvent(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(27825);
    if (Util.isNullOrNil(this.path))
    {
      AppMethodBeat.o(27825);
      return;
    }
    if (this.qUo)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.qUo = paramBoolean;
        AppMethodBeat.o(27825);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (Util.ticksToNow(this.lastShakeTime) > 400L))
    {
      this.qUo = true;
      AppMethodBeat.o(27825);
      return;
    }
    this.qUo = false;
    if ((this.qUl != null) && (this.qUl.isCalling()))
    {
      AppMethodBeat.o(27825);
      return;
    }
    if (this.qUn)
    {
      if (this.qUl != null) {
        this.qUl.cU(false);
      }
      this.qUm = false;
      AppMethodBeat.o(27825);
      return;
    }
    if ((this.qUl != null) && (!this.qUl.isPlaying()))
    {
      this.qUl.cU(true);
      this.qUm = true;
      AppMethodBeat.o(27825);
      return;
    }
    if (this.qUl != null) {
      this.qUl.cU(paramBoolean);
    }
    this.qUm = paramBoolean;
    if (!paramBoolean) {
      cZ(this.path, this.dLt);
    }
    AppMethodBeat.o(27825);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(27821);
    Log.d("MicroMsg.RecordVoiceHelper", "stop play");
    MMEntryLock.unlock("keep_app_silent");
    if (this.qUl != null) {
      this.qUl.stop();
    }
    cEE();
    AppMethodBeat.o(27821);
  }
  
  public static abstract interface a
  {
    public abstract void aKZ(String paramString);
    
    public abstract void onFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.u
 * JD-Core Version:    0.7.0.1
 */