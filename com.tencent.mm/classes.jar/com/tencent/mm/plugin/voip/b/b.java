package com.tencent.mm.plugin.voip.b;

import android.content.Context;
import android.os.HandlerThread;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.audio.b.e;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.plugin.audio.d.d;
import com.tencent.mm.plugin.report.service.h;
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

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/util/VoIPAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseVoIPAudioManager;", "()V", "asyncRingPlayer", "", "deviceSwitchNearScreenTick", "", "getDeviceSwitchNearScreenTick", "()J", "setDeviceSwitchNearScreenTick", "(J)V", "deviceTotalNearScreenTime", "getDeviceTotalNearScreenTime", "setDeviceTotalNearScreenTime", "hasSkip", "isAllowToResponseMike", "isCheckBluetoothEnd", "isOutCall", "isSystemPhoneRing", "()Z", "setSystemPhoneRing", "(Z)V", "lastIsDeviceNear", "getLastIsDeviceNear", "setLastIsDeviceNear", "lastScreenSensorTick", "getLastScreenSensorTick", "setLastScreenSensorTick", "lastShakeTime", "mAudioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "mBTRecoverSpeakerOn", "mEventCallback", "Lkotlin/Function1;", "mHSRecoverSpeakerOn", "mIgnoreBluetooth", "mIsMute", "mIsScreenOff", "", "mIsSpeakerOn", "mSensorHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mStateMachine", "Lcom/tencent/mm/plugin/voip/util/VoipStateMachine;", "mUIType", "value", "Lcom/tencent/mm/plugin/voip/ui/IVoipUI;", "mVoIPUi", "getMVoIPUi", "()Lcom/tencent/mm/plugin/voip/ui/IVoipUI;", "setMVoIPUi", "(Lcom/tencent/mm/plugin/voip/ui/IVoipUI;)V", "mVoicePlayDevice", "ringPlayerHandler", "ringPlayerThread", "Landroid/os/HandlerThread;", "sensorController", "Lcom/tencent/mm/sdk/platformtools/SensorController;", "sensorListener", "Lcom/tencent/mm/sdk/platformtools/SensorController$SensorEventCallBack;", "shakeManager", "Lcom/tencent/mm/sdk/platformtools/ShakeManager;", "checkClean", "", "checkStartRingAsyncThread", "doPlayRingSound", "type", "doStartRing", "ringType", "doStopRing", "enableSpeaker", "speakerOn", "ignoreBluetooth", "getContext", "Landroid/content/Context;", "initParams", "isVideoCall", "initSensorListener", "eventCallback", "Lkotlin/ParameterName;", "name", "isOn", "onAudioDeviceStateChanged", "status", "onSensorEvent", "isON", "playRingSound", "mIsVideoCall", "refreshBTStatus", "releaseAudioPlayingDevice", "requestAudioMute", "requestAudioPlayingDevice", "isSwitchVoice", "useLastedDevice", "requestRingPlayerDevice", "requestSpeakerOn", "responseScreenOn", "isScreenOn", "setSpeakerAfterBluetoothDisconnected", "startVoIPRing", "stopVoIPRing", "switchVoicePlayDevice", "newDevice", "unInit", "unInitSensorListener", "Companion", "plugin-voip_release"})
public final class b
  extends e
{
  public static final b.a HgF;
  public l GTW;
  private boolean GUA;
  private boolean GUH;
  public boolean GUT;
  private int GUk;
  public boolean GZs;
  private boolean HgA;
  private HandlerThread HgB;
  private MMHandler HgC;
  private MMHandler HgD;
  public boolean HgE;
  private SensorController.SensorEventCallBack Hgq;
  private kotlin.g.a.b<? super Boolean, Long> Hgr;
  long Hgs;
  boolean Hgt;
  public long Hgu;
  long Hgv;
  private boolean Hgw;
  public boolean Hgx;
  private volatile com.tencent.mm.plugin.voip.ui.b Hgy;
  private boolean Hgz;
  private com.tencent.mm.compatible.util.b dtz;
  private long lastShakeTime;
  private boolean mIsMute;
  private int mUIType;
  private boolean qUo;
  private ShakeManager qUp;
  private SensorController qUq;
  
  static
  {
    AppMethodBeat.i(236031);
    HgF = new b.a((byte)0);
    AppMethodBeat.o(236031);
  }
  
  public b()
  {
    AppMethodBeat.i(236030);
    this.lastShakeTime = -1L;
    this.Hgs = -1L;
    this.Hgv = -1L;
    this.GUk = 1;
    this.dtz = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    Object localObject = this.dtz;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
    }
    localObject = com.tencent.mm.plugin.audio.c.a.oIh;
    a.a.a((com.tencent.mm.plugin.audio.b.a)this, "voip");
    com.tencent.mm.plugin.audio.d.b.cet();
    d.cet();
    com.tencent.mm.plugin.audio.broadcast.bluetooth.a.agp("voip");
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.soo, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.HgA = bool;
      Log.i("MicroMsg.VoIP.VoIPAudioManager", "asyncRingPlayer:" + this.HgA);
      this.HgD = new MMHandler("mSensorHandler");
      AppMethodBeat.o(236030);
      return;
    }
  }
  
  private final void aK(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(236013);
    Log.printInfoStack("MicroMsg.VoIP.VoIPAudioManager", "enableSpeaker: %s, ignoreBluetooth: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    boolean bool = paramBoolean1;
    if (!paramBoolean2)
    {
      localObject = com.tencent.mm.plugin.audio.c.a.oIh;
      localObject = com.tencent.mm.plugin.audio.d.b.oIo;
      bool = paramBoolean1;
      if (com.tencent.mm.plugin.audio.d.b.ceb()) {
        bool = false;
      }
    }
    if (ae.gKu.gDA)
    {
      ae.gKu.dump();
      if (ae.gKu.gDB > 0) {
        c.fFg().wS(bool);
      }
    }
    if ((ae.gKu.gEh >= 0) || (ae.gKu.gEi >= 0)) {
      c.fFg().wS(bool);
    }
    Object localObject = c.fFg();
    p.g(localObject, "SubCoreVoip.getVoipService()");
    a(bool, ((u)localObject).bhV(), paramBoolean2);
    c.fFg().xe(bool);
    this.Hgz = bool;
    AppMethodBeat.o(236013);
  }
  
  private final void adD(int paramInt)
  {
    AppMethodBeat.i(236011);
    Log.printInfoStack("MicroMsg.VoIP.VoIPAudioManager", "switchVoicePlayDevice: %s and before is %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.GUk) });
    this.GUk = paramInt;
    com.tencent.mm.plugin.voip.ui.b localb = this.Hgy;
    if (localb != null)
    {
      localb.setVoicePlayDevice(this.GUk);
      AppMethodBeat.o(236011);
      return;
    }
    AppMethodBeat.o(236011);
  }
  
  private final void adE(int paramInt)
  {
    AppMethodBeat.i(236019);
    if (this.HgA)
    {
      Object localObject = this.HgB;
      if ((localObject != null) && (((HandlerThread)localObject).isAlive() == true) && (this.HgC != null))
      {
        localObject = this.HgC;
        if (localObject != null)
        {
          ((MMHandler)localObject).post((Runnable)new b(paramInt));
          AppMethodBeat.o(236019);
          return;
        }
        AppMethodBeat.o(236019);
        return;
      }
    }
    Log.i("MicroMsg.VoIP.VoIPAudioManager", "sync play sound");
    c.fFg().ado(paramInt);
    AppMethodBeat.o(236019);
  }
  
  private final void fJM()
  {
    int i = 3;
    AppMethodBeat.i(236014);
    boolean bool2 = AY(3);
    boolean bool3 = this.GUA;
    Object localObject;
    boolean bool1;
    if (this.GTW != null)
    {
      localObject = this.GTW;
      if (localObject == null) {
        p.hyc();
      }
      localObject = Boolean.valueOf(k.adQ(((l)localObject).getState()));
      u localu = c.fFg();
      p.g(localu, "SubCoreVoip.getVoipService()");
      boolean bool4 = localu.czl();
      boolean bool5 = this.Hgx;
      if (2 != this.mUIType) {
        break label261;
      }
      bool1 = true;
      label89:
      Log.i("MicroMsg.VoIP.VoIPAudioManager", "setSpeakerAfterBluetoothDisconnected, isCheckBluetoothEnd: %s, isVideoState: %s, isRingStop: %s, mBTRecoverSpeakerOn: %s, isMini: %s, isHeadsetPlugged: %s", new Object[] { Boolean.valueOf(bool3), localObject, Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (!this.GUA)
      {
        localObject = this.GTW;
        if (localObject != null)
        {
          if (!k.adQ(((l)localObject).getState())) {
            break label271;
          }
          if (bool2) {
            break label266;
          }
          i = 1;
          label181:
          this.GUk = i;
        }
        if (this.GUk != 1) {
          break label367;
        }
        aK(true, true);
        label200:
        switch (this.GUk)
        {
        }
      }
    }
    for (;;)
    {
      adD(this.GUk);
      this.GUA = true;
      c.fFg().ry(false);
      AppMethodBeat.o(236014);
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
      localObject = c.fFg();
      p.g(localObject, "SubCoreVoip.getVoipService()");
      if (!((u)localObject).czl())
      {
        if (AY(3)) {}
        for (;;)
        {
          this.GUk = i;
          break;
          if (!this.GZs) {
            i = 1;
          } else {
            i = 2;
          }
        }
      }
      if (((this.Hgx) || (2 == this.mUIType)) && (!bool2)) {
        i = 1;
      }
      for (;;)
      {
        this.GUk = i;
        this.Hgx = false;
        break;
        if (!bool2) {
          i = 2;
        }
      }
      label367:
      xo(false);
      break label200;
      cdU();
      continue;
      jt(true);
    }
  }
  
  private final void fJO()
  {
    AppMethodBeat.i(236024);
    if (this.HgA)
    {
      Object localObject = this.HgB;
      if ((localObject != null) && (((HandlerThread)localObject).isAlive() == true) && (this.HgC != null))
      {
        localObject = this.HgC;
        if (localObject != null)
        {
          ((MMHandler)localObject).post((Runnable)d.HgI);
          AppMethodBeat.o(236024);
          return;
        }
        AppMethodBeat.o(236024);
        return;
      }
    }
    Log.i("MicroMsg.VoIP.VoIPAudioManager", "sync stop ring player");
    c.fFg().stopRing();
    AppMethodBeat.o(236024);
  }
  
  private final Context getContext()
  {
    Object localObject2 = null;
    AppMethodBeat.i(236027);
    Object localObject1 = localObject2;
    if (this.Hgy != null)
    {
      com.tencent.mm.plugin.voip.ui.b localb = this.Hgy;
      localObject1 = localObject2;
      if (localb != null) {
        localObject1 = localb.fJl();
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = MMApplicationContext.getContext();
    }
    AppMethodBeat.o(236027);
    return localObject2;
  }
  
  private final void xo(boolean paramBoolean)
  {
    AppMethodBeat.i(236012);
    aK(paramBoolean, this.GUH);
    AppMethodBeat.o(236012);
  }
  
  public final void Z(final kotlin.g.a.b<? super Boolean, Long> paramb)
  {
    AppMethodBeat.i(258470);
    p.h(paramb, "eventCallback");
    fJP();
    MMHandler localMMHandler = this.HgD;
    if (localMMHandler != null)
    {
      localMMHandler.post((Runnable)new e(this, paramb));
      AppMethodBeat.o(258470);
      return;
    }
    AppMethodBeat.o(258470);
  }
  
  public final void aL(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(236017);
    Object localObject = com.tencent.mm.plugin.audio.c.a.oIh;
    int i;
    if (a.a.cea().cdW()) {
      i = 3;
    }
    for (;;)
    {
      this.GUk = i;
      this.GZs = paramBoolean2;
      this.Hgx = paramBoolean1;
      AppMethodBeat.o(236017);
      return;
      localObject = com.tencent.mm.plugin.audio.c.a.oIh;
      localObject = com.tencent.mm.plugin.audio.d.b.oIo;
      if (com.tencent.mm.plugin.audio.d.b.cee())
      {
        localObject = com.tencent.mm.plugin.audio.c.a.oIh;
        if (a.a.cec())
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
  
  public final void aM(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(236020);
    Object localObject = this.dtz;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
    }
    localObject = com.tencent.mm.plugin.audio.c.a.oIh;
    localObject = com.tencent.mm.plugin.audio.d.b.oIo;
    if (com.tencent.mm.plugin.audio.d.b.ceb())
    {
      localObject = com.tencent.mm.plugin.audio.c.a.oIh;
      if (a.a.cec())
      {
        b("voip", Integer.valueOf(4));
        xo(false);
        AppMethodBeat.o(236020);
        return;
      }
    }
    localObject = com.tencent.mm.plugin.audio.c.a.oIh;
    if (a.a.cea().cdW())
    {
      b("voip", Integer.valueOf(3));
      xo(false);
      AppMethodBeat.o(236020);
      return;
    }
    boolean bool1;
    if (1 == this.GUk)
    {
      bool1 = true;
      if ((!paramBoolean1) || (this.HgE)) {
        break label165;
      }
      b("voip", Integer.valueOf(2));
      paramBoolean1 = bool2;
    }
    for (;;)
    {
      cV(paramBoolean1);
      AppMethodBeat.o(236020);
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
        b("voip", Integer.valueOf(this.GUk));
        paramBoolean1 = bool1;
      }
    }
  }
  
  public final void aN(final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(236022);
    if (!this.oHS)
    {
      Log.printInfoStack("MicroMsg.VoIP.VoIPAudioManager", "startVoIPRing ignore bluetooth or not bt plug", new Object[0]);
      final int i;
      if (paramBoolean1)
      {
        i = 0;
        if (!this.HgA) {
          break label147;
        }
        if (this.HgB == null)
        {
          localObject = new HandlerThread("Voip_RingPlayer");
          Log.i("MicroMsg.VoIP.VoIPAudioManager", "create voip ring player thread");
          ((HandlerThread)localObject).start();
          this.HgC = new MMHandler(((HandlerThread)localObject).getLooper());
          this.HgB = ((HandlerThread)localObject);
        }
        Object localObject = this.HgC;
        if (localObject != null) {
          ((MMHandler)localObject).post((Runnable)new c(this, i));
        }
      }
      for (;;)
      {
        if (this.GUk != 4) {
          break label196;
        }
        fJM();
        AppMethodBeat.o(236022);
        return;
        i = 1;
        break;
        label147:
        Log.i("MicroMsg.VoIP.VoIPAudioManager", "sync start ring player");
        c.fFg().bk(i, this.GZs);
      }
    }
    Log.i("MicroMsg.VoIP.VoIPAudioManager", "startVoIPRing but waitting the bt connected");
    this.oHR = ((kotlin.g.a.b)new f(this, paramBoolean1, paramBoolean2));
    label196:
    AppMethodBeat.o(236022);
  }
  
  public final void b(com.tencent.mm.plugin.voip.ui.b paramb)
  {
    AppMethodBeat.i(236007);
    this.Hgy = paramb;
    paramb = this.Hgy;
    if (paramb != null) {
      paramb.setVoicePlayDevice(this.GUk);
    }
    paramb = this.Hgy;
    if (paramb != null)
    {
      paramb.setMute(this.mIsMute);
      AppMethodBeat.o(236007);
      return;
    }
    AppMethodBeat.o(236007);
  }
  
  public final void cV(boolean paramBoolean)
  {
    AppMethodBeat.i(236015);
    Object localObject = this.dtz;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
    }
    super.cV(paramBoolean);
    if (cdY() != -1)
    {
      i = cdY();
      adD(i);
      localObject = c.fFg();
      p.g(localObject, "SubCoreVoip.getVoipService()");
      if (((u)localObject).czl()) {
        break label125;
      }
      c.fFg().xf(paramBoolean);
      label68:
      localObject = h.CyF;
      if (!paramBoolean) {
        break label133;
      }
    }
    label133:
    for (int i = 1;; i = 2)
    {
      ((h)localObject).a(11080, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Integer.valueOf(0) });
      AppMethodBeat.o(236015);
      return;
      i = this.GUk;
      break;
      label125:
      xo(paramBoolean);
      break label68;
    }
  }
  
  public final void elB()
  {
    AppMethodBeat.i(236026);
    agq("voip");
    fJO();
    if (this.HgA)
    {
      HandlerThread localHandlerThread = this.HgB;
      if (localHandlerThread == null) {
        break label75;
      }
      if (localHandlerThread.isAlive() == true)
      {
        Log.i("MicroMsg.VoIP.VoIPAudioManager", "release quit ring player thread");
        localHandlerThread = this.HgB;
        if (localHandlerThread != null) {
          localHandlerThread.quitSafely();
        }
        this.HgB = null;
      }
    }
    AppMethodBeat.o(236026);
    return;
    label75:
    AppMethodBeat.o(236026);
  }
  
  public final void fFK()
  {
    AppMethodBeat.i(236023);
    fJO();
    this.oHR = null;
    AppMethodBeat.o(236023);
  }
  
  public final void fFV()
  {
    AppMethodBeat.i(236025);
    com.tencent.mm.compatible.util.b localb = this.dtz;
    if (localb != null) {
      localb.apm();
    }
    fJO();
    cdV();
    AppMethodBeat.o(236025);
  }
  
  public final void fJN()
  {
    AppMethodBeat.i(236021);
    Object localObject = com.tencent.mm.plugin.audio.c.a.oIh;
    localObject = com.tencent.mm.plugin.audio.d.b.oIo;
    if (com.tencent.mm.plugin.audio.d.b.cee())
    {
      b("voip", Integer.valueOf(4));
      AppMethodBeat.o(236021);
      return;
    }
    localObject = com.tencent.mm.plugin.audio.c.a.oIh;
    if (a.a.cea().cdW())
    {
      b("voip", Integer.valueOf(3));
      AppMethodBeat.o(236021);
      return;
    }
    b("voip", Integer.valueOf(2));
    AppMethodBeat.o(236021);
  }
  
  public final void fJP()
  {
    AppMethodBeat.i(236029);
    MMHandler localMMHandler = this.HgD;
    if (localMMHandler != null)
    {
      localMMHandler.post((Runnable)new g(this));
      AppMethodBeat.o(236029);
      return;
    }
    AppMethodBeat.o(236029);
  }
  
  public final void iY(int paramInt)
  {
    AppMethodBeat.i(236010);
    super.iY(paramInt);
    if ((this.oHP.isEmpty()) && ((paramInt != 9) || (paramInt != 8)))
    {
      Log.i("MicroMsg.VoIP.VoIPAudioManager", "no situation need to respone this event ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(236010);
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
        AppMethodBeat.o(236010);
        return;
        this.GUA = false;
        localObject = this.GTW;
        if (localObject != null)
        {
          if (!k.adQ(((l)localObject).getState())) {
            if (1 != this.GUk) {
              break label216;
            }
          }
          for (bool = true;; bool = false)
          {
            this.Hgx = bool;
            localObject = c.fFg();
            p.g(localObject, "SubCoreVoip.getVoipService()");
            a(false, ((u)localObject).bhV(), false);
            c.fFg().wS(false);
            c.fFg().xe(false);
            adD(4);
            this.GUA = false;
            c.fFg().ry(true);
            AppMethodBeat.o(236010);
            return;
          }
        }
        AppMethodBeat.o(236010);
        return;
      } while (this.GUT);
      fJM();
      this.GUH = true;
      AppMethodBeat.o(236010);
      return;
      localObject = com.tencent.mm.plugin.audio.d.b.oIo;
      bool = com.tencent.mm.plugin.audio.d.b.cee();
      Log.i("MicroMsg.VoIP.VoIPAudioManager", "headset disconnected and  bluetooth: %s", new Object[] { Boolean.valueOf(bool) });
      if (3 != this.GUk)
      {
        Log.i("MicroMsg.VoIP.VoIPAudioManager", "same status, no changed");
        AppMethodBeat.o(236010);
        return;
      }
      localObject = this.GTW;
      if (localObject != null)
      {
        if (k.adQ(((l)localObject).getState())) {
          if (bool)
          {
            b("voip", Integer.valueOf(4));
            paramInt = 4;
            this.GUk = paramInt;
            if (this.GUk != 1) {
              break label649;
            }
            aK(true, true);
          }
        }
        for (;;)
        {
          c.fFg().ry(false);
          adD(this.GUk);
          AppMethodBeat.o(236010);
          return;
          localObject = c.fFg();
          p.g(localObject, "SubCoreVoip.getVoipService()");
          if (!((u)localObject).czl())
          {
            if (!this.GZs)
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
          for (localObject = ((Context)localObject).getString(2131767378);; localObject = null)
          {
            Toast.makeText(localContext, (CharSequence)localObject, 0).show();
            paramInt = 1;
            break;
          }
          if (bool)
          {
            if (1 == this.GUk) {}
            for (bool = true;; bool = false)
            {
              this.Hgw = bool;
              this.GUk = 4;
              b("voip", Integer.valueOf(4));
              break;
            }
          }
          localObject = c.fFg();
          p.g(localObject, "SubCoreVoip.getVoipService()");
          if (!((u)localObject).czl())
          {
            if (!this.GZs) {
              break label344;
            }
            break label344;
          }
          if ((this.Hgw) || (2 == this.mUIType))
          {
            localContext = getContext();
            localObject = getContext();
            if (localObject != null) {}
            for (localObject = ((Context)localObject).getString(2131767378);; localObject = null)
            {
              Toast.makeText(localContext, (CharSequence)localObject, 0).show();
              paramInt = 1;
              this.GUk = paramInt;
              this.Hgw = false;
              break;
            }
          }
          localContext = getContext();
          localObject = getContext();
          if (localObject != null) {}
          for (localObject = ((Context)localObject).getString(2131767377);; localObject = null)
          {
            Toast.makeText(localContext, (CharSequence)localObject, 0).show();
            paramInt = 2;
            break;
          }
          xo(false);
        }
      }
      AppMethodBeat.o(236010);
      return;
      localObject = com.tencent.mm.plugin.audio.c.a.oIh;
      localObject = com.tencent.mm.plugin.audio.d.b.oIo;
      Log.i("MicroMsg.VoIP.VoIPAudioManager", "headset connected and bluetooth: %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.d.b.cee()) });
      if (3 == this.GUk)
      {
        Log.i("MicroMsg.VoIP.VoIPAudioManager", "same status, no changed");
        AppMethodBeat.o(236010);
        return;
      }
      localObject = this.GTW;
    } while (localObject == null);
    label649:
    if (k.adQ(((l)localObject).getState()))
    {
      this.GUk = 3;
      if (this.GUk != 1) {
        break label806;
      }
      aK(true, true);
    }
    for (;;)
    {
      c.fFg().ry(true);
      adD(this.GUk);
      AppMethodBeat.o(236010);
      return;
      if (1 == this.GUk) {}
      for (bool = true;; bool = false)
      {
        this.Hgw = bool;
        this.GUk = 3;
        break;
      }
      label806:
      aK(false, true);
    }
  }
  
  public final void onSensorEvent(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(236009);
    Log.printInfoStack("MicroMsg.VoIP.VoIPAudioManager", "onSensorEvent, isON: %s, lastIsDeviceNear: %s, deviceSwitchNearScreenTick: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.Hgt), Long.valueOf(this.Hgs) });
    if (this.GTW == null)
    {
      Log.i("MicroMsg.VoIP.VoIPAudioManager", "onSensorEvent, not create stateMachine yet, ignore");
      AppMethodBeat.o(236009);
      return;
    }
    Object localObject = this.GTW;
    if (localObject == null) {
      p.hyc();
    }
    if ((k.adQ(((l)localObject).getState())) || (this.GUk != 2))
    {
      fJP();
      AppMethodBeat.o(236009);
      return;
    }
    if (this.qUo)
    {
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.qUo = paramBoolean;
        Log.i("MicroMsg.VoIP.VoIPAudioManager", "onSensorEvent has skip and val is %s", new Object[] { Boolean.valueOf(this.qUo) });
        AppMethodBeat.o(236009);
        return;
      }
    }
    if ((Math.abs(Util.currentTicks() - this.Hgv) < 500L) && (this.Hgv != -1L))
    {
      Log.i("MicroMsg.VoIP.VoIPAudioManager", "onSensorEvent time interval too small");
      AppMethodBeat.o(236009);
      return;
    }
    if ((((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sjI, true)) && (!paramBoolean) && (this.lastShakeTime != -1L) && (Util.ticksToNow(this.lastShakeTime) > 400L))
    {
      this.qUo = true;
      Log.i("MicroMsg.VoIP.VoIPAudioManager", "onSensorEvent has skip case shake near to small");
      AppMethodBeat.o(236009);
      return;
    }
    this.qUo = false;
    localObject = this.GTW;
    if (localObject != null)
    {
      if ((k.adP(((l)localObject).getState())) && ((this.Hgt != paramBoolean) || (this.Hgs == -1L)))
      {
        if ((!this.Hgt) && (paramBoolean) && (!k.adQ(((l)localObject).getState())) && (this.mUIType != 2) && (this.Hgs != -1L))
        {
          long l = Util.ticksToNow(this.Hgs);
          Log.i("MicroMsg.VoIP.VoIPAudioManager", "accumulate near screen time: %s", new Object[] { Long.valueOf(l) });
          this.Hgu = (l + this.Hgu);
        }
        this.Hgs = Util.currentTicks();
        this.Hgt = paramBoolean;
      }
      localObject = this.Hgr;
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
            this.Hgv = ((Number)localObject).longValue();
            AppMethodBeat.o(236009);
            return;
            i = 0;
            break;
            label500:
            localObject = null;
          }
        }
      }
      label506:
      AppMethodBeat.o(236009);
      return;
    }
    AppMethodBeat.o(236009);
  }
  
  public final void unInit()
  {
    AppMethodBeat.i(236008);
    Object localObject = com.tencent.mm.plugin.audio.c.a.oIh;
    a.a.agt("voip");
    fJP();
    localObject = this.HgD;
    if (localObject != null) {
      ((MMHandler)localObject).quitSafely();
    }
    this.HgD = null;
    AppMethodBeat.o(236008);
  }
  
  public final void xp(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(236016);
    if (paramBoolean)
    {
      c.fFg().fHW();
      c.fFg().adf(9);
      c.fFg().xd(true);
    }
    for (;;)
    {
      this.mIsMute = paramBoolean;
      h localh = h.CyF;
      if (paramBoolean) {
        i = 2;
      }
      localh.a(11080, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(i) });
      AppMethodBeat.o(236016);
      return;
      c.fFg().fHX();
      c.fFg().adf(8);
      c.fFg().xd(false);
    }
  }
  
  public final void xq(boolean paramBoolean)
  {
    AppMethodBeat.i(236018);
    fJO();
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      adE(i);
      AppMethodBeat.o(236018);
      return;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(235998);
      Log.i("MicroMsg.VoIP.VoIPAudioManager", "async play sound");
      c.fFg().ado(this.$type);
      AppMethodBeat.o(235998);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(b paramb, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(235999);
      Log.i("MicroMsg.VoIP.VoIPAudioManager", "async start ring player");
      c.fFg().bk(i, this.HgG.GZs);
      AppMethodBeat.o(235999);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    public static final d HgI;
    
    static
    {
      AppMethodBeat.i(236001);
      HgI = new d();
      AppMethodBeat.o(236001);
    }
    
    public final void run()
    {
      AppMethodBeat.i(236000);
      Log.i("MicroMsg.VoIP.VoIPAudioManager", "async stop ring player");
      c.fFg().stopRing();
      AppMethodBeat.o(236000);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(b paramb, kotlin.g.a.b paramb1) {}
    
    public final void run()
    {
      AppMethodBeat.i(236004);
      Object localObject2 = MMApplicationContext.getContext();
      p.g(localObject2, "MMApplicationContext.getContext()");
      b.a(this.HgG, new SensorController((Context)localObject2));
      Log.i("MicroMsg.VoIP.VoIPAudioManager", "initMgr setSensorCallBack context is ".concat(String.valueOf(localObject2)));
      b.a(this.HgG, (SensorController.SensorEventCallBack)new SensorController.SensorEventCallBack()
      {
        public final void onSensorEvent(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(236003);
          this.HgK.HgG.onSensorEvent(paramAnonymousBoolean);
          AppMethodBeat.o(236003);
        }
      });
      Object localObject1 = b.d(this.HgG);
      if (localObject1 == null) {
        p.hyc();
      }
      ((SensorController)localObject1).setSensorCallBack(b.e(this.HgG));
      b localb;
      if (b.f(this.HgG) == null)
      {
        localObject1 = this.HgG;
        localObject2 = new ShakeManager((Context)localObject2);
        Runnable localRunnable = (Runnable)new a(this);
        localb = this.HgG;
        if (!((ShakeManager)localObject2).startShake(localRunnable)) {
          break label178;
        }
      }
      label178:
      for (long l = 0L;; l = -1L)
      {
        b.a(localb, l);
        b.a((b)localObject1, (ShakeManager)localObject2);
        b.a(this.HgG, paramb);
        AppMethodBeat.o(236004);
        return;
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/voip/util/VoIPAudioManager$initSensorListener$1$2$callback$1"})
    static final class a
      implements Runnable
    {
      a(b.e parame) {}
      
      public final void run()
      {
        AppMethodBeat.i(236002);
        b.a(this.HgK.HgG, Util.currentTicks());
        Log.i("MicroMsg.VoIP.VoIPAudioManager", "device happened shake in time,%s", new Object[] { Long.valueOf(b.g(this.HgK.HgG)) });
        AppMethodBeat.o(236002);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b
  {
    f(b paramb, boolean paramBoolean1, boolean paramBoolean2)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(236006);
      Object localObject;
      if (b.d(this.HgG) != null)
      {
        Log.printInfoStack("MicroMsg.VoIP.VoIPAudioManager", "removeSensorCallBack", new Object[0]);
        localObject = b.d(this.HgG);
        if (localObject != null) {
          ((SensorController)localObject).setSensorCallBack(null);
        }
        localObject = b.d(this.HgG);
        if (localObject != null) {
          ((SensorController)localObject).removeSensorCallBack();
        }
        b.a(this.HgG, null);
        this.HgG.Hgt = false;
        this.HgG.Hgu = 0L;
        this.HgG.Hgs = -1L;
      }
      if (b.f(this.HgG) != null)
      {
        localObject = b.f(this.HgG);
        if (localObject == null) {
          p.hyc();
        }
        ((ShakeManager)localObject).stopShake();
      }
      b.a(this.HgG, null);
      this.HgG.Hgv = -1L;
      b.a(this.HgG, -1L);
      AppMethodBeat.o(236006);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.b
 * JD-Core Version:    0.7.0.1
 */