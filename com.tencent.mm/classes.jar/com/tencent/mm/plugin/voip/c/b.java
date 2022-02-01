package com.tencent.mm.plugin.voip.c;

import android.content.Context;
import android.os.HandlerThread;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.plugin.audio.b.e;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.plugin.audio.d.d;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.SensorEventCallBack;
import com.tencent.mm.sdk.platformtools.ShakeManager;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/util/VoIPAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseVoIPAudioManager;", "()V", "asyncRingPlayer", "", "deviceSwitchNearScreenTick", "", "getDeviceSwitchNearScreenTick", "()J", "setDeviceSwitchNearScreenTick", "(J)V", "deviceTotalNearScreenTime", "getDeviceTotalNearScreenTime", "setDeviceTotalNearScreenTime", "hasSkip", "isAllowToResponseMike", "isCheckBluetoothEnd", "isOutCall", "isSystemPhoneRing", "()Z", "setSystemPhoneRing", "(Z)V", "lastIsDeviceNear", "getLastIsDeviceNear", "setLastIsDeviceNear", "lastScreenSensorTick", "getLastScreenSensorTick", "setLastScreenSensorTick", "lastShakeTime", "mAudioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "mBTRecoverSpeakerOn", "mEventCallback", "Lkotlin/Function1;", "mHSRecoverSpeakerOn", "mIgnoreBluetooth", "mIsMute", "mIsScreenOff", "", "mIsSpeakerOn", "mSensorHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mStateMachine", "Lcom/tencent/mm/plugin/voip/util/VoipStateMachine;", "mUIType", "value", "Lcom/tencent/mm/plugin/voip/ui/IVoipUI;", "mVoIPUi", "getMVoIPUi", "()Lcom/tencent/mm/plugin/voip/ui/IVoipUI;", "setMVoIPUi", "(Lcom/tencent/mm/plugin/voip/ui/IVoipUI;)V", "mVoicePlayDevice", "ringPlayerHandler", "ringPlayerThread", "Landroid/os/HandlerThread;", "sensorController", "Lcom/tencent/mm/sdk/platformtools/SensorController;", "sensorListener", "Lcom/tencent/mm/sdk/platformtools/SensorController$SensorEventCallBack;", "shakeManager", "Lcom/tencent/mm/sdk/platformtools/ShakeManager;", "checkClean", "", "checkStartRingAsyncThread", "doPlayRingSound", "type", "doStartRing", "ringType", "doStopRing", "enableSpeaker", "speakerOn", "ignoreBluetooth", "getContext", "Landroid/content/Context;", "initParams", "isVideoCall", "initSensorListener", "eventCallback", "Lkotlin/ParameterName;", "name", "isOn", "onAudioDeviceStateChanged", "status", "onSensorEvent", "isON", "playRingSound", "mIsVideoCall", "refreshBTStatus", "releaseAudioPlayingDevice", "requestAudioMute", "requestAudioPlayingDevice", "isSwitchVoice", "useLastedDevice", "requestRingPlayerDevice", "requestSpeakerOn", "responseScreenOn", "isScreenOn", "setSpeakerAfterBluetoothDisconnected", "startVoIPRing", "stopVoIPRing", "switchVoicePlayDevice", "newDevice", "unInit", "unInitSensorListener", "Companion", "plugin-voip_release"})
public final class b
  extends e
{
  public static final b.a NXt;
  private boolean NKM;
  private boolean NKT;
  public l NKi;
  private int NKw;
  public boolean NLf;
  public boolean NPE;
  private SensorController.SensorEventCallBack NXe;
  private kotlin.g.a.b<? super Boolean, Long> NXf;
  long NXg;
  boolean NXh;
  public long NXi;
  long NXj;
  private boolean NXk;
  public boolean NXl;
  private volatile com.tencent.mm.plugin.voip.ui.b NXm;
  private boolean NXn;
  private boolean NXo;
  private HandlerThread NXp;
  private MMHandler NXq;
  private MMHandler NXr;
  public boolean NXs;
  private com.tencent.mm.compatible.util.b fmh;
  private long lastShakeTime;
  private boolean mIsMute;
  private int mUIType;
  private boolean uwu;
  private ShakeManager uwv;
  private SensorController uww;
  
  static
  {
    AppMethodBeat.i(239569);
    NXt = new b.a((byte)0);
    AppMethodBeat.o(239569);
  }
  
  public b()
  {
    AppMethodBeat.i(239567);
    this.lastShakeTime = -1L;
    this.NXg = -1L;
    this.NXj = -1L;
    this.NKw = 1;
    this.fmh = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    Object localObject = this.fmh;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).avy();
    }
    localObject = com.tencent.mm.plugin.audio.c.a.rJX;
    a.a.a((com.tencent.mm.plugin.audio.b.a)this, "voip");
    com.tencent.mm.plugin.audio.d.b.crG();
    d.crG();
    com.tencent.mm.plugin.audio.broadcast.bluetooth.a.anS("voip");
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vZN, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.NXo = bool;
      Log.i("MicroMsg.VoIP.VoIPAudioManager", "asyncRingPlayer:" + this.NXo);
      this.NXr = new MMHandler("mSensorHandler");
      AppMethodBeat.o(239567);
      return;
    }
  }
  
  private final void Bg(boolean paramBoolean)
  {
    AppMethodBeat.i(239526);
    aW(paramBoolean, this.NKT);
    AppMethodBeat.o(239526);
  }
  
  private final void aW(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(239528);
    Log.printInfoStack("MicroMsg.VoIP.VoIPAudioManager", "enableSpeaker: %s, ignoreBluetooth: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    boolean bool = paramBoolean1;
    if (!paramBoolean2)
    {
      localObject = com.tencent.mm.plugin.audio.c.a.rJX;
      localObject = com.tencent.mm.plugin.audio.d.b.rKe;
      bool = paramBoolean1;
      if (com.tencent.mm.plugin.audio.d.b.cro()) {
        bool = false;
      }
    }
    if (af.juI.jnK)
    {
      af.juI.Y();
      if (af.juI.jnL > 0) {
        c.gxs().AK(bool);
      }
    }
    if ((af.juI.jor >= 0) || (af.juI.jos >= 0)) {
      c.gxs().AK(bool);
    }
    Object localObject = c.gxs();
    p.j(localObject, "SubCoreVoip.getVoipService()");
    a(bool, ((u)localObject).gxF(), paramBoolean2);
    c.gxs().AW(bool);
    this.NXn = bool;
    AppMethodBeat.o(239528);
  }
  
  private final void alq(int paramInt)
  {
    AppMethodBeat.i(239524);
    Log.printInfoStack("MicroMsg.VoIP.VoIPAudioManager", "switchVoicePlayDevice: %s and before is %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.NKw) });
    this.NKw = paramInt;
    com.tencent.mm.plugin.voip.ui.b localb = this.NXm;
    if (localb != null)
    {
      localb.setVoicePlayDevice(this.NKw);
      AppMethodBeat.o(239524);
      return;
    }
    AppMethodBeat.o(239524);
  }
  
  private final void alr(int paramInt)
  {
    AppMethodBeat.i(239539);
    if (this.NXo)
    {
      Object localObject = this.NXp;
      if ((localObject != null) && (((HandlerThread)localObject).isAlive() == true) && (this.NXq != null))
      {
        localObject = this.NXq;
        if (localObject != null)
        {
          ((MMHandler)localObject).post((Runnable)new b(paramInt));
          AppMethodBeat.o(239539);
          return;
        }
        AppMethodBeat.o(239539);
        return;
      }
    }
    Log.i("MicroMsg.VoIP.VoIPAudioManager", "sync play sound");
    c.gxs().kP(com.tencent.mm.plugin.voip.b.f.close_lower_volume, paramInt);
    AppMethodBeat.o(239539);
  }
  
  private final void gCi()
  {
    int i = 3;
    AppMethodBeat.i(239530);
    boolean bool2 = Ez(3);
    boolean bool3 = this.NKM;
    Object localObject;
    boolean bool1;
    if (this.NKi != null)
    {
      localObject = this.NKi;
      if (localObject == null) {
        p.iCn();
      }
      localObject = Boolean.valueOf(k.alD(((l)localObject).getState()));
      u localu = c.gxs();
      p.j(localu, "SubCoreVoip.getVoipService()");
      boolean bool4 = localu.cNL();
      boolean bool5 = this.NXl;
      if (2 != this.mUIType) {
        break label261;
      }
      bool1 = true;
      label89:
      Log.i("MicroMsg.VoIP.VoIPAudioManager", "setSpeakerAfterBluetoothDisconnected, isCheckBluetoothEnd: %s, isVideoState: %s, isRingStop: %s, mBTRecoverSpeakerOn: %s, isMini: %s, isHeadsetPlugged: %s", new Object[] { Boolean.valueOf(bool3), localObject, Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (!this.NKM)
      {
        localObject = this.NKi;
        if (localObject != null)
        {
          if (!k.alD(((l)localObject).getState())) {
            break label271;
          }
          if (bool2) {
            break label266;
          }
          i = 1;
          label181:
          this.NKw = i;
        }
        if (this.NKw != 1) {
          break label367;
        }
        aW(true, true);
        label200:
        switch (this.NKw)
        {
        }
      }
    }
    for (;;)
    {
      alq(this.NKw);
      this.NKM = true;
      c.gxs().uB(false);
      AppMethodBeat.o(239530);
      return;
      localObject = null;
      break;
      label261:
      bool1 = false;
      break label89;
      label266:
      i = 3;
      break label181;
      label271:
      localObject = c.gxs();
      p.j(localObject, "SubCoreVoip.getVoipService()");
      if (!((u)localObject).cNL())
      {
        if (Ez(3)) {}
        for (;;)
        {
          this.NKw = i;
          break;
          if (!this.NPE) {
            i = 1;
          } else {
            i = 2;
          }
        }
      }
      if (((this.NXl) || (2 == this.mUIType)) && (!bool2)) {
        i = 1;
      }
      for (;;)
      {
        this.NKw = i;
        this.NXl = false;
        break;
        if (!bool2) {
          i = 2;
        }
      }
      label367:
      Bg(false);
      break label200;
      crf();
      continue;
      kE(true);
    }
  }
  
  private final void gCk()
  {
    AppMethodBeat.i(239548);
    if (this.NXo)
    {
      Object localObject = this.NXp;
      if ((localObject != null) && (((HandlerThread)localObject).isAlive() == true) && (this.NXq != null))
      {
        localObject = this.NXq;
        if (localObject != null)
        {
          ((MMHandler)localObject).post((Runnable)d.NXw);
          AppMethodBeat.o(239548);
          return;
        }
        AppMethodBeat.o(239548);
        return;
      }
    }
    Log.i("MicroMsg.VoIP.VoIPAudioManager", "sync stop ring player");
    c.gxs().stopRing();
    AppMethodBeat.o(239548);
  }
  
  private final Context getContext()
  {
    Object localObject2 = null;
    AppMethodBeat.i(239557);
    Object localObject1 = localObject2;
    if (this.NXm != null)
    {
      com.tencent.mm.plugin.voip.ui.b localb = this.NXm;
      localObject1 = localObject2;
      if (localb != null) {
        localObject1 = localb.gBI();
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = MMApplicationContext.getContext();
    }
    AppMethodBeat.o(239557);
    return localObject2;
  }
  
  public final void Bh(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(239534);
    if (paramBoolean)
    {
      c.gxs().gAp();
      c.gxs().akP(9);
      c.gxs().AV(true);
    }
    for (;;)
    {
      this.mIsMute = paramBoolean;
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
      if (paramBoolean) {
        i = 2;
      }
      localh.a(11080, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(i) });
      AppMethodBeat.o(239534);
      return;
      c.gxs().gAq();
      c.gxs().akP(8);
      c.gxs().AV(false);
    }
  }
  
  public final void Bi(boolean paramBoolean)
  {
    AppMethodBeat.i(239537);
    gCk();
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      alr(i);
      AppMethodBeat.o(239537);
      return;
    }
  }
  
  public final void aX(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(239536);
    Object localObject = com.tencent.mm.plugin.audio.c.a.rJX;
    int i;
    if (a.a.crn().crh()) {
      i = 3;
    }
    for (;;)
    {
      this.NKw = i;
      this.NPE = paramBoolean2;
      this.NXl = paramBoolean1;
      AppMethodBeat.o(239536);
      return;
      localObject = com.tencent.mm.plugin.audio.c.a.rJX;
      localObject = com.tencent.mm.plugin.audio.d.b.rKe;
      if (com.tencent.mm.plugin.audio.d.b.crr())
      {
        localObject = com.tencent.mm.plugin.audio.c.a.rJX;
        if (a.a.crp())
        {
          i = 4;
          continue;
        }
      }
      if (paramBoolean1) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
  
  public final void aY(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(239541);
    Object localObject = this.fmh;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).avy();
    }
    localObject = com.tencent.mm.plugin.audio.c.a.rJX;
    localObject = com.tencent.mm.plugin.audio.d.b.rKe;
    if (com.tencent.mm.plugin.audio.d.b.cro())
    {
      localObject = com.tencent.mm.plugin.audio.c.a.rJX;
      if (a.a.crp())
      {
        b("voip", Integer.valueOf(4));
        Bg(false);
        AppMethodBeat.o(239541);
        return;
      }
    }
    localObject = com.tencent.mm.plugin.audio.c.a.rJX;
    if (a.a.crn().crh())
    {
      b("voip", Integer.valueOf(3));
      Bg(false);
      AppMethodBeat.o(239541);
      return;
    }
    boolean bool1;
    if (1 == this.NKw)
    {
      bool1 = true;
      if ((!paramBoolean1) || (this.NXs)) {
        break label165;
      }
      b("voip", Integer.valueOf(2));
      paramBoolean1 = bool2;
    }
    for (;;)
    {
      ds(paramBoolean1);
      AppMethodBeat.o(239541);
      return;
      bool1 = false;
      break;
      label165:
      if (paramBoolean2)
      {
        b("voip", Integer.valueOf(1));
        paramBoolean1 = true;
      }
      else
      {
        b("voip", Integer.valueOf(this.NKw));
        paramBoolean1 = bool1;
      }
    }
  }
  
  public final void aZ(final boolean paramBoolean1, final boolean paramBoolean2)
  {
    final int i = 1;
    int j = 0;
    AppMethodBeat.i(239545);
    if (!crd())
    {
      Log.printInfoStack("MicroMsg.VoIP.VoIPAudioManager", "startVoIPRing ignore bluetooth or not bt plug", new Object[0]);
      if (paramBoolean1) {
        i = 0;
      }
      if (this.NXo)
      {
        if (this.NXp == null)
        {
          localObject = new HandlerThread("Voip_RingPlayer");
          Log.i("MicroMsg.VoIP.VoIPAudioManager", "create voip ring player thread");
          ((HandlerThread)localObject).start();
          this.NXq = new MMHandler(((HandlerThread)localObject).getLooper());
          this.NXp = ((HandlerThread)localObject);
        }
        Object localObject = this.NXq;
        if (localObject != null) {
          ((MMHandler)localObject).post((Runnable)new c(this, i));
        }
      }
      while (this.NKw == 4)
      {
        gCi();
        AppMethodBeat.o(239545);
        return;
        Log.i("MicroMsg.VoIP.VoIPAudioManager", "sync start ring player");
        c.gxs().K(com.tencent.mm.plugin.voip.b.f.phonering, i, this.NPE);
      }
    }
    Log.i("MicroMsg.VoIP.VoIPAudioManager", "startVoIPRing but waitting the bt connected");
    if (crm())
    {
      if (paramBoolean1) {}
      for (i = j;; i = 1)
      {
        c.gxs().K(com.tencent.mm.plugin.voip.b.f.phonering, i, paramBoolean2);
        AppMethodBeat.o(239545);
        return;
      }
    }
    B((kotlin.g.a.b)new f(this, paramBoolean1, paramBoolean2));
    AppMethodBeat.o(239545);
  }
  
  public final void ab(final kotlin.g.a.b<? super Boolean, Long> paramb)
  {
    AppMethodBeat.i(239561);
    p.k(paramb, "eventCallback");
    gCl();
    MMHandler localMMHandler = this.NXr;
    if (localMMHandler != null)
    {
      localMMHandler.post((Runnable)new e(this, paramb));
      AppMethodBeat.o(239561);
      return;
    }
    AppMethodBeat.o(239561);
  }
  
  public final void b(com.tencent.mm.plugin.voip.ui.b paramb)
  {
    AppMethodBeat.i(239506);
    this.NXm = paramb;
    paramb = this.NXm;
    if (paramb != null) {
      paramb.setVoicePlayDevice(this.NKw);
    }
    paramb = this.NXm;
    if (paramb != null)
    {
      paramb.setMute(this.mIsMute);
      AppMethodBeat.o(239506);
      return;
    }
    AppMethodBeat.o(239506);
  }
  
  public final void ds(boolean paramBoolean)
  {
    AppMethodBeat.i(239532);
    Object localObject = this.fmh;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).avy();
    }
    super.ds(paramBoolean);
    if (crj() != -1)
    {
      i = crj();
      alq(i);
      localObject = c.gxs();
      p.j(localObject, "SubCoreVoip.getVoipService()");
      if (((u)localObject).cNL()) {
        break label125;
      }
      c.gxs().AX(paramBoolean);
      label68:
      localObject = com.tencent.mm.plugin.report.service.h.IzE;
      if (!paramBoolean) {
        break label133;
      }
    }
    label133:
    for (int i = 1;; i = 2)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).a(11080, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Integer.valueOf(0) });
      AppMethodBeat.o(239532);
      return;
      i = this.NKw;
      break;
      label125:
      Bg(paramBoolean);
      break label68;
    }
  }
  
  public final void eVm()
  {
    AppMethodBeat.i(239554);
    anT("voip");
    gCk();
    if (this.NXo)
    {
      HandlerThread localHandlerThread = this.NXp;
      if (localHandlerThread == null) {
        break label75;
      }
      if (localHandlerThread.isAlive() == true)
      {
        Log.i("MicroMsg.VoIP.VoIPAudioManager", "release quit ring player thread");
        localHandlerThread = this.NXp;
        if (localHandlerThread != null) {
          localHandlerThread.quitSafely();
        }
        this.NXp = null;
      }
    }
    AppMethodBeat.o(239554);
    return;
    label75:
    AppMethodBeat.o(239554);
  }
  
  public final void gCj()
  {
    AppMethodBeat.i(239543);
    Object localObject = com.tencent.mm.plugin.audio.c.a.rJX;
    localObject = com.tencent.mm.plugin.audio.d.b.rKe;
    if (com.tencent.mm.plugin.audio.d.b.crr())
    {
      b("voip", Integer.valueOf(4));
      AppMethodBeat.o(239543);
      return;
    }
    localObject = com.tencent.mm.plugin.audio.c.a.rJX;
    if (a.a.crn().crh())
    {
      b("voip", Integer.valueOf(3));
      AppMethodBeat.o(239543);
      return;
    }
    b("voip", Integer.valueOf(2));
    AppMethodBeat.o(239543);
  }
  
  public final void gCl()
  {
    AppMethodBeat.i(239564);
    MMHandler localMMHandler = this.NXr;
    if (localMMHandler != null)
    {
      localMMHandler.post((Runnable)new g(this));
      AppMethodBeat.o(239564);
      return;
    }
    AppMethodBeat.o(239564);
  }
  
  public final void gxW()
  {
    AppMethodBeat.i(239546);
    gCk();
    B(null);
    AppMethodBeat.o(239546);
  }
  
  public final void gyh()
  {
    AppMethodBeat.i(239550);
    com.tencent.mm.compatible.util.b localb = this.fmh;
    if (localb != null) {
      localb.avz();
    }
    gCk();
    crg();
    AppMethodBeat.o(239550);
  }
  
  public final void ko(int paramInt)
  {
    AppMethodBeat.i(239522);
    super.ko(paramInt);
    if ((crc().isEmpty()) && ((paramInt != 9) || (paramInt != 8)))
    {
      Log.i("MicroMsg.VoIP.VoIPAudioManager", "no situation need to respone this event ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(239522);
      return;
    }
    switch (paramInt)
    {
    }
    Object localObject;
    boolean bool;
    label216:
    label344:
    do
    {
      do
      {
        AppMethodBeat.o(239522);
        return;
        this.NKM = false;
        localObject = this.NKi;
        if (localObject != null)
        {
          if (!k.alD(((l)localObject).getState())) {
            if (1 != this.NKw) {
              break label216;
            }
          }
          for (bool = true;; bool = false)
          {
            this.NXl = bool;
            localObject = c.gxs();
            p.j(localObject, "SubCoreVoip.getVoipService()");
            a(false, ((u)localObject).gxF(), false);
            c.gxs().AK(false);
            c.gxs().AW(false);
            alq(4);
            this.NKM = false;
            c.gxs().uB(true);
            AppMethodBeat.o(239522);
            return;
          }
        }
        AppMethodBeat.o(239522);
        return;
      } while (this.NLf);
      gCi();
      this.NKT = true;
      AppMethodBeat.o(239522);
      return;
      localObject = com.tencent.mm.plugin.audio.d.b.rKe;
      bool = com.tencent.mm.plugin.audio.d.b.crr();
      Log.i("MicroMsg.VoIP.VoIPAudioManager", "headset disconnected and  bluetooth: %s", new Object[] { Boolean.valueOf(bool) });
      if (3 != this.NKw)
      {
        Log.i("MicroMsg.VoIP.VoIPAudioManager", "same status, no changed");
        AppMethodBeat.o(239522);
        return;
      }
      localObject = this.NKi;
      if (localObject != null)
      {
        if (k.alD(((l)localObject).getState())) {
          if (bool)
          {
            b("voip", Integer.valueOf(4));
            paramInt = 4;
            this.NKw = paramInt;
            if (this.NKw != 1) {
              break label649;
            }
            aW(true, true);
          }
        }
        for (;;)
        {
          c.gxs().uB(false);
          alq(this.NKw);
          AppMethodBeat.o(239522);
          return;
          localObject = c.gxs();
          p.j(localObject, "SubCoreVoip.getVoipService()");
          if (!((u)localObject).cNL())
          {
            if (!this.NPE)
            {
              paramInt = 1;
              break;
            }
            paramInt = 2;
            break;
          }
          Context localContext = getContext();
          localObject = getContext();
          if (localObject != null) {}
          for (localObject = ((Context)localObject).getString(com.tencent.mm.plugin.voip.b.g.voip_voice_come_from_speaker);; localObject = null)
          {
            Toast.makeText(localContext, (CharSequence)localObject, 0).show();
            paramInt = 1;
            break;
          }
          if (bool)
          {
            if (1 == this.NKw) {}
            for (bool = true;; bool = false)
            {
              this.NXk = bool;
              this.NKw = 4;
              b("voip", Integer.valueOf(4));
              break;
            }
          }
          localObject = c.gxs();
          p.j(localObject, "SubCoreVoip.getVoipService()");
          if (!((u)localObject).cNL())
          {
            if (!this.NPE) {
              break label344;
            }
            break label344;
          }
          if ((this.NXk) || (2 == this.mUIType))
          {
            localContext = getContext();
            localObject = getContext();
            if (localObject != null) {}
            for (localObject = ((Context)localObject).getString(com.tencent.mm.plugin.voip.b.g.voip_voice_come_from_speaker);; localObject = null)
            {
              Toast.makeText(localContext, (CharSequence)localObject, 0).show();
              paramInt = 1;
              this.NKw = paramInt;
              this.NXk = false;
              break;
            }
          }
          localContext = getContext();
          localObject = getContext();
          if (localObject != null) {}
          for (localObject = ((Context)localObject).getString(com.tencent.mm.plugin.voip.b.g.voip_voice_come_from_earpiece);; localObject = null)
          {
            Toast.makeText(localContext, (CharSequence)localObject, 0).show();
            paramInt = 2;
            break;
          }
          Bg(false);
        }
      }
      AppMethodBeat.o(239522);
      return;
      localObject = com.tencent.mm.plugin.audio.c.a.rJX;
      localObject = com.tencent.mm.plugin.audio.d.b.rKe;
      Log.i("MicroMsg.VoIP.VoIPAudioManager", "headset connected and bluetooth: %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.d.b.crr()) });
      if (3 == this.NKw)
      {
        Log.i("MicroMsg.VoIP.VoIPAudioManager", "same status, no changed");
        AppMethodBeat.o(239522);
        return;
      }
      localObject = this.NKi;
    } while (localObject == null);
    label649:
    if (k.alD(((l)localObject).getState()))
    {
      this.NKw = 3;
      if (this.NKw != 1) {
        break label806;
      }
      aW(true, true);
    }
    for (;;)
    {
      c.gxs().uB(true);
      alq(this.NKw);
      AppMethodBeat.o(239522);
      return;
      if (1 == this.NKw) {}
      for (bool = true;; bool = false)
      {
        this.NXk = bool;
        this.NKw = 3;
        break;
      }
      label806:
      aW(false, true);
    }
  }
  
  public final void onSensorEvent(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(239515);
    Log.printInfoStack("MicroMsg.VoIP.VoIPAudioManager", "onSensorEvent, isON: %s, lastIsDeviceNear: %s, deviceSwitchNearScreenTick: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.NXh), Long.valueOf(this.NXg) });
    if (this.NKi == null)
    {
      Log.i("MicroMsg.VoIP.VoIPAudioManager", "onSensorEvent, not create stateMachine yet, ignore");
      AppMethodBeat.o(239515);
      return;
    }
    Object localObject = this.NKi;
    if (localObject == null) {
      p.iCn();
    }
    if ((k.alD(((l)localObject).getState())) || (this.NKw != 2))
    {
      gCl();
      AppMethodBeat.o(239515);
      return;
    }
    if (this.uwu)
    {
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.uwu = paramBoolean;
        Log.i("MicroMsg.VoIP.VoIPAudioManager", "onSensorEvent has skip and val is %s", new Object[] { Boolean.valueOf(this.uwu) });
        AppMethodBeat.o(239515);
        return;
      }
    }
    if ((Math.abs(Util.currentTicks() - this.NXj) < 500L) && (this.NXj != -1L))
    {
      Log.i("MicroMsg.VoIP.VoIPAudioManager", "onSensorEvent time interval too small");
      AppMethodBeat.o(239515);
      return;
    }
    if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vUj, true)) && (!paramBoolean) && (this.lastShakeTime != -1L) && (Util.ticksToNow(this.lastShakeTime) > 400L))
    {
      this.uwu = true;
      Log.i("MicroMsg.VoIP.VoIPAudioManager", "onSensorEvent has skip case shake near to small");
      AppMethodBeat.o(239515);
      return;
    }
    this.uwu = false;
    localObject = this.NKi;
    if (localObject != null)
    {
      if ((k.alC(((l)localObject).getState())) && ((this.NXh != paramBoolean) || (this.NXg == -1L)))
      {
        if ((!this.NXh) && (paramBoolean) && (!k.alD(((l)localObject).getState())) && (this.mUIType != 2) && (this.NXg != -1L))
        {
          long l = Util.ticksToNow(this.NXg);
          Log.i("MicroMsg.VoIP.VoIPAudioManager", "accumulate near screen time: %s", new Object[] { Long.valueOf(l) });
          this.NXi = (l + this.NXi);
        }
        this.NXg = Util.currentTicks();
        this.NXh = paramBoolean;
      }
      localObject = this.NXf;
      if (localObject != null)
      {
        localObject = (Long)((kotlin.g.a.b)localObject).invoke(Boolean.valueOf(paramBoolean));
        if (localObject != null)
        {
          if (((Number)localObject).longValue() != -1L) {
            if (i == 0) {
              break label500;
            }
          }
          for (;;)
          {
            if (localObject == null) {
              break label506;
            }
            this.NXj = ((Number)localObject).longValue();
            AppMethodBeat.o(239515);
            return;
            i = 0;
            break;
            label500:
            localObject = null;
          }
        }
      }
      label506:
      AppMethodBeat.o(239515);
      return;
    }
    AppMethodBeat.o(239515);
  }
  
  public final void unInit()
  {
    AppMethodBeat.i(239509);
    Object localObject = com.tencent.mm.plugin.audio.c.a.rJX;
    a.a.anX("voip");
    gCl();
    localObject = this.NXr;
    if (localObject != null) {
      ((MMHandler)localObject).quitSafely();
    }
    this.NXr = null;
    AppMethodBeat.o(239509);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(245723);
      Log.i("MicroMsg.VoIP.VoIPAudioManager", "async play sound");
      c.gxs().kP(com.tencent.mm.plugin.voip.b.f.close_lower_volume, this.cPi);
      AppMethodBeat.o(245723);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(b paramb, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(244187);
      Log.i("MicroMsg.VoIP.VoIPAudioManager", "async start ring player");
      c.gxs().K(com.tencent.mm.plugin.voip.b.f.phonering, i, this.NXu.NPE);
      AppMethodBeat.o(244187);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    public static final d NXw;
    
    static
    {
      AppMethodBeat.i(243504);
      NXw = new d();
      AppMethodBeat.o(243504);
    }
    
    public final void run()
    {
      AppMethodBeat.i(243503);
      Log.i("MicroMsg.VoIP.VoIPAudioManager", "async stop ring player");
      c.gxs().stopRing();
      AppMethodBeat.o(243503);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(b paramb, kotlin.g.a.b paramb1) {}
    
    public final void run()
    {
      AppMethodBeat.i(243877);
      Object localObject2 = MMApplicationContext.getContext();
      p.j(localObject2, "MMApplicationContext.getContext()");
      b.a(this.NXu, new SensorController((Context)localObject2));
      Log.i("MicroMsg.VoIP.VoIPAudioManager", "initMgr setSensorCallBack context is ".concat(String.valueOf(localObject2)));
      b.a(this.NXu, (SensorController.SensorEventCallBack)new SensorController.SensorEventCallBack()
      {
        public final void onSensorEvent(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(236832);
          this.NXy.NXu.onSensorEvent(paramAnonymousBoolean);
          AppMethodBeat.o(236832);
        }
      });
      Object localObject1 = b.d(this.NXu);
      if (localObject1 != null) {
        ((SensorController)localObject1).setSensorCallBack(b.e(this.NXu));
      }
      b localb;
      if (b.f(this.NXu) == null)
      {
        localObject1 = this.NXu;
        localObject2 = new ShakeManager((Context)localObject2);
        Runnable localRunnable = (Runnable)new a(this);
        localb = this.NXu;
        if (!((ShakeManager)localObject2).startShake(localRunnable)) {
          break label175;
        }
      }
      label175:
      for (long l = 0L;; l = -1L)
      {
        b.a(localb, l);
        b.a((b)localObject1, (ShakeManager)localObject2);
        b.a(this.NXu, paramb);
        AppMethodBeat.o(243877);
        return;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/voip/util/VoIPAudioManager$initSensorListener$1$2$callback$1"})
    static final class a
      implements Runnable
    {
      a(b.e parame) {}
      
      public final void run()
      {
        AppMethodBeat.i(235041);
        b.a(this.NXy.NXu, Util.currentTicks());
        Log.i("MicroMsg.VoIP.VoIPAudioManager", "device happened shake in time,%s", new Object[] { Long.valueOf(b.g(this.NXy.NXu)) });
        AppMethodBeat.o(235041);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b
  {
    f(b paramb, boolean paramBoolean1, boolean paramBoolean2)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(235965);
      Object localObject;
      if (b.d(this.NXu) != null)
      {
        Log.printInfoStack("MicroMsg.VoIP.VoIPAudioManager", "removeSensorCallBack", new Object[0]);
        localObject = b.d(this.NXu);
        if (localObject != null) {
          ((SensorController)localObject).removeSensorCallBack();
        }
        b.a(this.NXu, null);
        this.NXu.NXh = false;
        this.NXu.NXi = 0L;
        this.NXu.NXg = -1L;
      }
      if (b.f(this.NXu) != null)
      {
        localObject = b.f(this.NXu);
        if (localObject == null) {
          p.iCn();
        }
        ((ShakeManager)localObject).stopShake();
      }
      b.a(this.NXu, null);
      this.NXu.NXj = -1L;
      b.a(this.NXu, -1L);
      AppMethodBeat.o(235965);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.c.b
 * JD-Core Version:    0.7.0.1
 */