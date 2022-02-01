package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.k;
import com.tencent.mm.an.k.a;
import com.tencent.mm.an.k.b;
import com.tencent.mm.an.l;
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
import com.tencent.mm.storage.ao;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class u
  implements k.a, k.b, SensorController.SensorEventCallBack
{
  public static SensorController uww;
  public List<a> callbacks;
  private int fEi;
  private long lastShakeTime;
  public String path;
  public k uwr;
  private boolean uws;
  private boolean uwt;
  private boolean uwu;
  private ShakeManager uwv;
  
  public u()
  {
    AppMethodBeat.i(27818);
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
        break label213;
      }
      this.uwr.a(this);
      this.uwr.a(this);
      if ((!a.crh()) && (!a.cro())) {
        break label197;
      }
      this.uwr.dr(false);
    }
    for (;;)
    {
      if (uww == null) {
        uww = new SensorController(MMApplicationContext.getContext());
      }
      if (this.uwv == null) {
        this.uwv = new ShakeManager(MMApplicationContext.getContext());
      }
      AppMethodBeat.o(27818);
      return;
      bool = false;
      break;
      label197:
      this.uwr.dr(this.uws);
      continue;
      label213:
      Log.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
    }
  }
  
  public final void cTk()
  {
    AppMethodBeat.i(27824);
    if (uww != null) {
      uww.removeSensorCallBack();
    }
    if (this.uwv != null) {
      this.uwv.stopShake();
    }
    AppMethodBeat.o(27824);
  }
  
  public final boolean cTl()
  {
    AppMethodBeat.i(27820);
    if (this.uwr == null)
    {
      Log.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
      AppMethodBeat.o(27820);
      return false;
    }
    boolean bool = this.uwr.isPlaying();
    AppMethodBeat.o(27820);
    return bool;
  }
  
  public final boolean dt(String paramString, int paramInt)
  {
    AppMethodBeat.i(27819);
    if (this.uwr == null)
    {
      Log.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(27819);
      return false;
    }
    this.uwr.stop();
    Object localObject = this.callbacks.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).aVA(paramString);
    }
    if ((uww != null) && (!uww.hasRegistered()))
    {
      uww.setSensorCallBack(this);
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27817);
          u.a(u.this, Util.currentTicks());
          AppMethodBeat.o(27817);
        }
      };
      if (!this.uwv.startShake((Runnable)localObject)) {
        break label186;
      }
    }
    label186:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      this.path = paramString;
      this.fEi = paramInt;
      if ((Util.isNullOrNil(paramString)) || (!this.uwr.a(paramString, this.uws, true, paramInt))) {
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
  
  public void onSensorEvent(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(27825);
    if (Util.isNullOrNil(this.path))
    {
      AppMethodBeat.o(27825);
      return;
    }
    if (this.uwu)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.uwu = paramBoolean;
        AppMethodBeat.o(27825);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (Util.ticksToNow(this.lastShakeTime) > 400L))
    {
      this.uwu = true;
      AppMethodBeat.o(27825);
      return;
    }
    this.uwu = false;
    if ((this.uwr != null) && (this.uwr.isCalling()))
    {
      AppMethodBeat.o(27825);
      return;
    }
    if (this.uwt)
    {
      if (this.uwr != null) {
        this.uwr.dr(false);
      }
      this.uws = false;
      AppMethodBeat.o(27825);
      return;
    }
    if ((this.uwr != null) && (!this.uwr.isPlaying()))
    {
      this.uwr.dr(true);
      this.uws = true;
      AppMethodBeat.o(27825);
      return;
    }
    if (this.uwr != null) {
      this.uwr.dr(paramBoolean);
    }
    this.uws = paramBoolean;
    if (!paramBoolean) {
      dt(this.path, this.fEi);
    }
    AppMethodBeat.o(27825);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(27821);
    Log.d("MicroMsg.RecordVoiceHelper", "stop play");
    MMEntryLock.unlock("keep_app_silent");
    if (this.uwr != null) {
      this.uwr.stop();
    }
    cTk();
    AppMethodBeat.o(27821);
  }
  
  public static abstract interface a
  {
    public abstract void aVA(String paramString);
    
    public abstract void onFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.u
 * JD-Core Version:    0.7.0.1
 */