package com.tencent.mm.plugin.voip.f;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.plugin.audio.b.e;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.SensorEventCallBack;
import com.tencent.mm.sdk.platformtools.ShakeManager;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/util/VoIPAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseVoIPAudioManager;", "()V", "deviceSwitchNearScreenTick", "", "getDeviceSwitchNearScreenTick", "()J", "setDeviceSwitchNearScreenTick", "(J)V", "deviceTotalNearScreenTime", "getDeviceTotalNearScreenTime", "setDeviceTotalNearScreenTime", "hasSkip", "", "isAllowToResponseMike", "isCheckBluetoothEnd", "isOutCall", "isSystemPhoneRing", "()Z", "setSystemPhoneRing", "(Z)V", "isVideoCall", "lastIsDeviceNear", "getLastIsDeviceNear", "setLastIsDeviceNear", "lastScreenSensorTick", "getLastScreenSensorTick", "setLastScreenSensorTick", "lastShakeTime", "mAudioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "mBTRecoverSpeakerOn", "mEventCallback", "Lkotlin/Function1;", "mHSRecoverSpeakerOn", "mIgnoreBluetooth", "mIsMute", "mIsScreenOff", "", "mIsSpeakerOn", "mSensorHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mStateMachine", "Lcom/tencent/mm/plugin/voip/util/VoipStateMachine;", "mUIType", "value", "Lcom/tencent/mm/plugin/voip/ui/IVoipUI;", "mVoIPUi", "getMVoIPUi", "()Lcom/tencent/mm/plugin/voip/ui/IVoipUI;", "setMVoIPUi", "(Lcom/tencent/mm/plugin/voip/ui/IVoipUI;)V", "mVoicePlayDevice", "getMVoicePlayDevice", "()I", "setMVoicePlayDevice", "(I)V", "playInfo", "Lcom/tencent/mm/plugin/voip/report/VoipRingtoneReport;", "getPlayInfo", "()Lcom/tencent/mm/plugin/voip/report/VoipRingtoneReport;", "setPlayInfo", "(Lcom/tencent/mm/plugin/voip/report/VoipRingtoneReport;)V", "ringing", "sensorController", "Lcom/tencent/mm/sdk/platformtools/SensorController;", "sensorListener", "Lcom/tencent/mm/sdk/platformtools/SensorController$SensorEventCallBack;", "shakeManager", "Lcom/tencent/mm/sdk/platformtools/ShakeManager;", "checkClean", "", "checkCurrentMute", "continuePlayStartRing", "username", "", "dealCallingParam", "roomId", "roomKey", "(Ljava/lang/Integer;Ljava/lang/Long;)V", "enableSpeaker", "speakerOn", "ignoreBluetooth", "getContext", "Landroid/content/Context;", "initParams", "initSensorListener", "eventCallback", "Lkotlin/ParameterName;", "name", "isOn", "onAudioDeviceStateChanged", "status", "onSensorEvent", "isON", "playRingSound", "refreshBTStatus", "releaseAudioPlayingDevice", "requestAudioMute", "requestAudioPlayingDevice", "isSwitchVoice", "mIsVideoCall", "useLastedDevice", "requestRingPlayerDevice", "requestSpeakerOn", "responseScreenOn", "isScreenOn", "setSpeakerAfterBluetoothDisconnected", "stopVoIPRing", "switchVoicePlayDevice", "newDevice", "unInit", "unInitSensorListener", "Companion", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends e
{
  public static final d.a ULl;
  public boolean OEa;
  private int PRF;
  private SensorController.SensorEventCallBack ULm;
  private kotlin.g.a.b<? super Boolean, Long> ULn;
  private long ULo;
  private boolean ULp;
  public long ULq;
  private long ULr;
  private boolean ULs;
  public boolean ULt;
  private volatile com.tencent.mm.plugin.voip.ui.b ULu;
  private boolean ULv;
  private MMHandler ULw;
  public boolean ULx;
  private com.tencent.mm.plugin.voip.d.h ULy;
  public boolean ULz;
  public boolean UvH;
  public l UwS;
  private boolean UxB;
  public boolean UxO;
  public int Uxg;
  private boolean Uxx;
  private com.tencent.mm.compatible.util.b hqw;
  private long lastShakeTime;
  public boolean mIsMute;
  private boolean xCT;
  private ShakeManager xCU;
  private SensorController xCV;
  
  static
  {
    AppMethodBeat.i(292653);
    ULl = new d.a((byte)0);
    AppMethodBeat.o(292653);
  }
  
  public d()
  {
    AppMethodBeat.i(292561);
    this.lastShakeTime = -1L;
    this.ULo = -1L;
    this.ULr = -1L;
    this.Uxg = 1;
    this.hqw = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    Object localObject = this.hqw;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
    }
    localObject = com.tencent.mm.plugin.audio.c.a.uVi;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "voip");
    cTM();
    com.tencent.mm.plugin.audio.broadcast.bluetooth.a.ahp("voip");
    this.ULw = new MMHandler("mSensorHandler");
    this.ULy = new com.tencent.mm.plugin.voip.d.h();
    AppMethodBeat.o(292561);
  }
  
  private final void GK(boolean paramBoolean)
  {
    AppMethodBeat.i(292585);
    bs(paramBoolean, this.UxB);
    AppMethodBeat.o(292585);
  }
  
  private static final void a(d paramd)
  {
    AppMethodBeat.i(292613);
    s.u(paramd, "this$0");
    com.tencent.mm.plugin.voip.ui.b localb = paramd.ULu;
    if (localb != null) {
      localb.setVoicePlayDevice(paramd.Uxg);
    }
    AppMethodBeat.o(292613);
  }
  
  private static final void a(d paramd, kotlin.g.a.b paramb)
  {
    AppMethodBeat.i(292638);
    s.u(paramd, "this$0");
    s.u(paramb, "$eventCallback");
    Object localObject1 = MMApplicationContext.getContext();
    s.s(localObject1, "getContext()");
    paramd.xCV = new SensorController((Context)localObject1);
    Log.i("MicroMsg.VoIP.VoIPAudioManager", s.X("initMgr setSensorCallBack context is ", localObject1));
    paramd.ULm = new d..ExternalSyntheticLambda0(paramd);
    Object localObject2 = paramd.xCV;
    if (localObject2 != null) {
      ((SensorController)localObject2).setSensorCallBack(paramd.ULm);
    }
    if (paramd.xCU == null)
    {
      localObject1 = new ShakeManager((Context)localObject1);
      if (!((ShakeManager)localObject1).startShake(new d..ExternalSyntheticLambda1(paramd))) {
        break label156;
      }
    }
    label156:
    for (long l = 0L;; l = -1L)
    {
      paramd.lastShakeTime = l;
      localObject2 = ah.aiuX;
      paramd.xCU = ((ShakeManager)localObject1);
      paramd.ULn = paramb;
      AppMethodBeat.o(292638);
      return;
    }
  }
  
  private static final void a(d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(292620);
    s.u(paramd, "this$0");
    paramd.onSensorEvent(paramBoolean);
    AppMethodBeat.o(292620);
  }
  
  private final void aqZ(int paramInt)
  {
    AppMethodBeat.i(292570);
    Log.printInfoStack("MicroMsg.VoIP.VoIPAudioManager", "switchVoicePlayDevice: %s and before is %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.Uxg) });
    this.Uxg = paramInt;
    com.tencent.threadpool.h.ahAA.bk(new d..ExternalSyntheticLambda3(this));
    AppMethodBeat.o(292570);
  }
  
  private static final void b(d paramd)
  {
    AppMethodBeat.i(292628);
    s.u(paramd, "this$0");
    paramd.lastShakeTime = Util.currentTicks();
    Log.i("MicroMsg.VoIP.VoIPAudioManager", "device happened shake in time,%s", new Object[] { Long.valueOf(paramd.lastShakeTime) });
    AppMethodBeat.o(292628);
  }
  
  private final void bs(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(292598);
    Log.printInfoStack("MicroMsg.VoIP.VoIPAudioManager", "enableSpeaker: %s, ignoreBluetooth: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    boolean bool = paramBoolean1;
    if (!paramBoolean2)
    {
      Object localObject = com.tencent.mm.plugin.audio.c.a.uVi;
      localObject = com.tencent.mm.plugin.audio.d.b.uVo;
      bool = paramBoolean1;
      if (com.tencent.mm.plugin.audio.d.b.cTX()) {
        bool = false;
      }
    }
    if (af.lXZ.lQS)
    {
      af.lXZ.aQ();
      if (af.lXZ.lQT > 0) {
        SubCoreVoip.hVp().Gj(bool);
      }
    }
    if ((af.lXZ.lRz >= 0) || (af.lXZ.lRA >= 0)) {
      SubCoreVoip.hVp().Gj(bool);
    }
    a(bool, SubCoreVoip.hVp().gdZ(), paramBoolean2);
    SubCoreVoip.hVp().Gu(bool);
    this.ULv = bool;
    AppMethodBeat.o(292598);
  }
  
  private static final void c(d paramd)
  {
    AppMethodBeat.i(292649);
    s.u(paramd, "this$0");
    if (paramd.xCV != null)
    {
      Log.printInfoStack("MicroMsg.VoIP.VoIPAudioManager", "removeSensorCallBack", new Object[0]);
      localObject = paramd.xCV;
      if (localObject != null) {
        ((SensorController)localObject).removeSensorCallBack();
      }
      paramd.xCV = null;
      paramd.ULp = false;
      paramd.ULq = 0L;
      paramd.ULo = -1L;
    }
    Object localObject = paramd.xCU;
    if (localObject != null) {
      ((ShakeManager)localObject).stopShake();
    }
    paramd.ULm = null;
    paramd.ULr = -1L;
    paramd.lastShakeTime = -1L;
    AppMethodBeat.o(292649);
  }
  
  private final Context getContext()
  {
    Object localObject2 = null;
    AppMethodBeat.i(292606);
    Object localObject1 = localObject2;
    if (this.ULu != null)
    {
      localObject1 = this.ULu;
      if (localObject1 != null) {
        break label46;
      }
    }
    label46:
    for (localObject1 = localObject2;; localObject1 = ((com.tencent.mm.plugin.voip.ui.b)localObject1).fwr())
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = MMApplicationContext.getContext();
      }
      AppMethodBeat.o(292606);
      return localObject2;
    }
  }
  
  public final void GL(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(292756);
    if (paramBoolean)
    {
      SubCoreVoip.hVp().hYs();
      SubCoreVoip.hVp().aqh(9);
      SubCoreVoip.hVp().Gt(true);
    }
    for (;;)
    {
      this.mIsMute = paramBoolean;
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
      if (paramBoolean) {
        i = 2;
      }
      localh.b(11080, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(i) });
      AppMethodBeat.o(292756);
      return;
      SubCoreVoip.hVp().hYt();
      SubCoreVoip.hVp().aqh(8);
      SubCoreVoip.hVp().Gt(false);
    }
  }
  
  public final void a(Integer paramInteger, Long paramLong)
  {
    AppMethodBeat.i(292702);
    com.tencent.mm.plugin.voip.d.h localh = this.ULy;
    if (localh != null) {
      localh.a(paramInteger, paramLong);
    }
    AppMethodBeat.o(292702);
  }
  
  public final void aM(kotlin.g.a.b<? super Boolean, Long> paramb)
  {
    AppMethodBeat.i(292806);
    s.u(paramb, "eventCallback");
    ibb();
    MMHandler localMMHandler = this.ULw;
    if (localMMHandler != null) {
      localMMHandler.post(new d..ExternalSyntheticLambda4(this, paramb));
    }
    AppMethodBeat.o(292806);
  }
  
  public final void bt(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(292761);
    Object localObject = this.hqw;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
    }
    this.UvH = paramBoolean2;
    localObject = com.tencent.mm.plugin.audio.c.a.uVi;
    localObject = com.tencent.mm.plugin.audio.d.b.uVo;
    if (com.tencent.mm.plugin.audio.d.b.cTX())
    {
      localObject = com.tencent.mm.plugin.audio.c.a.uVi;
      if (com.tencent.mm.plugin.audio.c.a.a.cTY())
      {
        b("voip", Integer.valueOf(4));
        if (((!SubCoreVoip.hVp().dro()) || (this.OEa)) && (!this.OEa)) {
          break label204;
        }
        GK(false);
        AppMethodBeat.o(292761);
        return;
      }
    }
    localObject = com.tencent.mm.plugin.audio.c.a.uVi;
    boolean bool1;
    if (com.tencent.mm.plugin.audio.c.a.a.cTW().cTQ())
    {
      b("voip", Integer.valueOf(3));
      if (((SubCoreVoip.hVp().dro()) && (!this.OEa)) || (this.OEa))
      {
        GK(false);
        AppMethodBeat.o(292761);
      }
    }
    else
    {
      if (1 != this.Uxg) {
        break label211;
      }
      bool1 = true;
      if ((!paramBoolean1) || (this.ULx)) {
        break label216;
      }
      b("voip", Integer.valueOf(2));
      paramBoolean1 = bool2;
    }
    for (;;)
    {
      ee(paramBoolean1);
      label204:
      AppMethodBeat.o(292761);
      return;
      label211:
      bool1 = false;
      break;
      label216:
      if (paramBoolean2)
      {
        b("voip", Integer.valueOf(1));
        paramBoolean1 = true;
      }
      else
      {
        b("voip", Integer.valueOf(this.Uxg));
        paramBoolean1 = bool1;
      }
    }
  }
  
  public final void c(com.tencent.mm.plugin.voip.ui.b paramb)
  {
    AppMethodBeat.i(292696);
    this.ULu = paramb;
    paramb = this.ULu;
    if (paramb != null) {
      paramb.setVoicePlayDevice(this.Uxg);
    }
    paramb = this.ULu;
    if (paramb != null) {
      paramb.setMute(this.mIsMute);
    }
    AppMethodBeat.o(292696);
  }
  
  public final void ee(boolean paramBoolean)
  {
    AppMethodBeat.i(292751);
    Object localObject = this.hqw;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
    }
    super.ee(paramBoolean);
    if (cTS() != -1)
    {
      i = cTS();
      aqZ(i);
      if (SubCoreVoip.hVp().dro()) {
        break label117;
      }
      SubCoreVoip.hVp();
      u.setRingSpeakerStatus(paramBoolean);
      label60:
      localObject = com.tencent.mm.plugin.report.service.h.OAn;
      if (!paramBoolean) {
        break label125;
      }
    }
    label117:
    label125:
    for (int i = 1;; i = 2)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).b(11080, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Integer.valueOf(0) });
      AppMethodBeat.o(292751);
      return;
      i = this.Uxg;
      break;
      GK(paramBoolean);
      break label60;
    }
  }
  
  public final void ged()
  {
    AppMethodBeat.i(292798);
    ahq("voip");
    hVY();
    AppMethodBeat.o(292798);
  }
  
  public final void hVY()
  {
    AppMethodBeat.i(292786);
    com.tencent.mm.plugin.ringtone.a.a locala;
    Object localObject1;
    Object localObject2;
    boolean bool;
    if (this.ULy != null)
    {
      this.ULz = false;
      locala = ((com.tencent.mm.plugin.ringtone.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ringtone.a.class)).getPlayInfo();
      com.tencent.mm.plugin.voip.d.c.a(locala);
      localObject1 = this.ULy;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.voip.d.c.UGb;
        ((com.tencent.mm.plugin.voip.d.h)localObject1).UGw = com.tencent.mm.plugin.voip.d.c.hZK();
      }
      if (!this.OEa) {
        break label220;
      }
      localObject2 = locala.sWX;
      s.s(localObject2, "info.mUsername");
      if ((locala.OBL == null) || (s.p(locala.OBL, "0"))) {
        break label212;
      }
      localObject1 = locala.OBL;
      s.s(localObject1, "if(info.mFinderObjectId …ectId else info.mMusicSid");
      c.nu((String)localObject2, (String)localObject1);
      localObject1 = this.ULy;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.voip.d.c.UGb;
        localObject2 = com.tencent.mm.plugin.voip.d.c.UGb;
        bool = this.UvH;
        localObject2 = locala.sWX;
        s.s(localObject2, "info.mUsername");
        ((com.tencent.mm.plugin.voip.d.h)localObject1).a(locala, bool, (String)localObject2);
      }
    }
    for (;;)
    {
      this.ULy = null;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("scene", "close");
      ((com.tencent.mm.plugin.ringtone.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ringtone.a.class)).responseSence(com.tencent.mm.plugin.ringtone.a.a.OBd, (Bundle)localObject1);
      AppMethodBeat.o(292786);
      return;
      label212:
      localObject1 = locala.OBK;
      break;
      label220:
      localObject1 = this.ULy;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.voip.d.c.UGb;
        localObject2 = com.tencent.mm.plugin.voip.d.c.UGb;
        bool = this.UvH;
        localObject2 = locala.sWX;
        s.s(localObject2, "info.mUsername");
        ((com.tencent.mm.plugin.voip.d.h)localObject1).b(locala, bool, (String)localObject2);
      }
    }
  }
  
  public final void hWd()
  {
    AppMethodBeat.i(292792);
    com.tencent.mm.compatible.util.b localb = this.hqw;
    if (localb != null) {
      localb.aPS();
    }
    hVY();
    cTP();
    AppMethodBeat.o(292792);
  }
  
  public final void iba()
  {
    AppMethodBeat.i(292766);
    Bundle localBundle = new Bundle();
    localBundle.putString("scene", "end");
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.uVi;
    boolean bool = this.ULv;
    localBundle.putInt("streamType", com.tencent.mm.plugin.audio.c.a.a.cTW().lS(bool));
    ((com.tencent.mm.plugin.ringtone.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ringtone.a.class)).responseSence(com.tencent.mm.plugin.ringtone.a.a.OBd, localBundle);
    AppMethodBeat.o(292766);
  }
  
  public final void ibb()
  {
    AppMethodBeat.i(292812);
    MMHandler localMMHandler = this.ULw;
    if (localMMHandler != null) {
      localMMHandler.post(new d..ExternalSyntheticLambda2(this));
    }
    AppMethodBeat.o(292812);
  }
  
  public final void nW(int paramInt)
  {
    int i = 2;
    int j = 3;
    AppMethodBeat.i(292743);
    super.nW(paramInt);
    if ((cTJ().isEmpty()) && ((paramInt != 9) || (paramInt != 8)))
    {
      Log.i("MicroMsg.VoIP.VoIPAudioManager", s.X("no situation need to respone this event ", Integer.valueOf(paramInt)));
      AppMethodBeat.o(292743);
      return;
    }
    switch (paramInt)
    {
    }
    Object localObject;
    boolean bool1;
    label216:
    label474:
    label480:
    label485:
    label1009:
    do
    {
      do
      {
        do
        {
          do
          {
            AppMethodBeat.o(292743);
            return;
            this.Uxx = false;
            localObject = this.UwS;
          } while (localObject == null);
          if (!k.ark(((l)localObject).mState)) {
            if (1 != this.Uxg) {
              break label216;
            }
          }
          for (bool1 = true;; bool1 = false)
          {
            this.ULt = bool1;
            a(false, SubCoreVoip.hVp().gdZ(), false);
            SubCoreVoip.hVp().Gj(false);
            SubCoreVoip.hVp().Gu(false);
            aqZ(4);
            this.Uxx = false;
            SubCoreVoip.hVp().yQ(true);
            AppMethodBeat.o(292743);
            return;
          }
        } while (this.UxO);
        boolean bool2 = Fa(3);
        boolean bool3 = this.Uxx;
        if (this.UwS != null)
        {
          localObject = this.UwS;
          s.checkNotNull(localObject);
          localObject = Boolean.valueOf(k.ark(((l)localObject).mState));
          boolean bool4 = SubCoreVoip.hVp().dro();
          boolean bool5 = this.ULt;
          if (2 != this.PRF) {
            break label474;
          }
          bool1 = true;
          Log.i("MicroMsg.VoIP.VoIPAudioManager", "setSpeakerAfterBluetoothDisconnected, isCheckBluetoothEnd: %s, isVideoState: %s, isRingStop: %s, mBTRecoverSpeakerOn: %s, isMini: %s, isHeadsetPlugged: %s", new Object[] { Boolean.valueOf(bool3), localObject, Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if (!this.Uxx)
          {
            localObject = this.UwS;
            if (localObject != null)
            {
              if (!k.ark(((l)localObject).mState)) {
                break label485;
              }
              if (bool2) {
                break label480;
              }
              paramInt = 1;
              this.Uxg = paramInt;
            }
            if (this.Uxg != 1) {
              break label575;
            }
            bs(true, true);
            switch (this.Uxg)
            {
            }
          }
        }
        for (;;)
        {
          aqZ(this.Uxg);
          this.Uxx = true;
          SubCoreVoip.hVp().yQ(false);
          this.UxB = true;
          AppMethodBeat.o(292743);
          return;
          localObject = null;
          break;
          bool1 = false;
          break label297;
          paramInt = 3;
          break label392;
          if (!SubCoreVoip.hVp().dro())
          {
            if (Fa(3)) {
              paramInt = j;
            }
            for (;;)
            {
              this.Uxg = paramInt;
              break;
              if (!this.OEa) {
                paramInt = 1;
              } else {
                paramInt = 2;
              }
            }
          }
          if (((this.ULt) || (2 == this.PRF)) && (!bool2)) {
            paramInt = 1;
          }
          for (;;)
          {
            this.Uxg = paramInt;
            this.ULt = false;
            break;
            paramInt = j;
            if (!bool2) {
              paramInt = 2;
            }
          }
          GK(false);
          break label411;
          cTO();
          continue;
          lR(true);
        }
        localObject = com.tencent.mm.plugin.audio.d.b.uVo;
        bool1 = com.tencent.mm.plugin.audio.d.b.cUa();
        Log.i("MicroMsg.VoIP.VoIPAudioManager", "headset disconnected and  bluetooth: %s", new Object[] { Boolean.valueOf(bool1) });
        if (3 != this.Uxg)
        {
          Log.i("MicroMsg.VoIP.VoIPAudioManager", "same status, no changed");
          AppMethodBeat.o(292743);
          return;
        }
        localObject = this.UwS;
      } while (localObject == null);
      if (k.ark(((l)localObject).mState)) {
        if (bool1)
        {
          b("voip", Integer.valueOf(4));
          paramInt = 4;
          this.Uxg = paramInt;
          if (this.Uxg != 1) {
            break label1009;
          }
          bs(true, true);
        }
      }
      for (;;)
      {
        SubCoreVoip.hVp().yQ(false);
        aqZ(this.Uxg);
        AppMethodBeat.o(292743);
        return;
        if (!SubCoreVoip.hVp().dro())
        {
          paramInt = i;
          if (this.OEa) {
            break;
          }
          paramInt = 1;
          break;
        }
        Context localContext = getContext();
        localObject = getContext();
        if (localObject == null) {}
        for (localObject = null;; localObject = ((Context)localObject).getString(b.g.voip_voice_come_from_speaker))
        {
          Toast.makeText(localContext, (CharSequence)localObject, 0).show();
          paramInt = 1;
          break;
        }
        if (bool1)
        {
          if (1 == this.Uxg) {}
          for (bool1 = true;; bool1 = false)
          {
            this.ULs = bool1;
            this.Uxg = 4;
            b("voip", Integer.valueOf(4));
            break;
          }
        }
        if (!SubCoreVoip.hVp().dro())
        {
          if (!this.OEa) {
            i = 1;
          }
          this.Uxg = i;
          break label698;
        }
        if ((this.ULs) || (2 == this.PRF))
        {
          localContext = getContext();
          localObject = getContext();
          if (localObject == null) {}
          for (localObject = null;; localObject = ((Context)localObject).getString(b.g.voip_voice_come_from_speaker))
          {
            Toast.makeText(localContext, (CharSequence)localObject, 0).show();
            i = 1;
            this.Uxg = i;
            this.ULs = false;
            break;
          }
        }
        localContext = getContext();
        localObject = getContext();
        if (localObject == null) {}
        for (localObject = null;; localObject = ((Context)localObject).getString(b.g.voip_voice_come_from_earpiece))
        {
          Toast.makeText(localContext, (CharSequence)localObject, 0).show();
          break;
        }
        GK(false);
      }
      localObject = com.tencent.mm.plugin.audio.c.a.uVi;
      localObject = com.tencent.mm.plugin.audio.d.b.uVo;
      Log.i("MicroMsg.VoIP.VoIPAudioManager", "headset connected and bluetooth: %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.d.b.cUa()) });
      if (3 == this.Uxg)
      {
        Log.i("MicroMsg.VoIP.VoIPAudioManager", "same status, no changed");
        AppMethodBeat.o(292743);
        return;
      }
      localObject = this.UwS;
    } while (localObject == null);
    label297:
    label575:
    if (k.ark(((l)localObject).mState))
    {
      this.Uxg = 3;
      if (this.Uxg != 1) {
        break label1163;
      }
      bs(true, true);
    }
    for (;;)
    {
      label392:
      label411:
      label698:
      SubCoreVoip.hVp().yQ(true);
      aqZ(this.Uxg);
      break;
      if (1 == this.Uxg) {}
      for (bool1 = true;; bool1 = false)
      {
        this.ULs = bool1;
        this.Uxg = 3;
        break;
      }
      label1163:
      bs(false, true);
    }
  }
  
  public final void o(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(292776);
    s.u(paramString, "username");
    Bundle localBundle = new Bundle();
    int i;
    u localu;
    if (paramBoolean1)
    {
      i = 0;
      localBundle.putInt("isVideoCall", i);
      localBundle.putString("username", paramString);
      localBundle.putBoolean("isOutCall", paramBoolean2);
      localBundle.putString("scene", "start");
      localu = SubCoreVoip.hVp();
      if (localu != null) {
        break label196;
      }
      l = 0L;
      label81:
      if (l <= 0L) {
        break label206;
      }
    }
    label196:
    label206:
    for (long l = System.currentTimeMillis() - l;; l = 0L)
    {
      localBundle.putLong("seekStartMs", l);
      Log.i("MicroMsg.VoIP.VoIPAudioManager", "continuePlayStartRing username:" + paramString + ", isVideoCall:" + paramBoolean1 + ", isOutCall:" + paramBoolean2 + ", seekStart:" + l);
      this.ULz = ((com.tencent.mm.plugin.ringtone.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ringtone.a.class)).responseSence(com.tencent.mm.plugin.ringtone.a.a.OBd, localBundle);
      AppMethodBeat.o(292776);
      return;
      i = 1;
      break;
      l = localu.UxU;
      break label81;
    }
  }
  
  public final void onSensorEvent(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(292722);
    Log.printInfoStack("MicroMsg.VoIP.VoIPAudioManager", "onSensorEvent, isON: %s, lastIsDeviceNear: %s, deviceSwitchNearScreenTick: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.ULp), Long.valueOf(this.ULo) });
    if (this.UwS == null)
    {
      Log.i("MicroMsg.VoIP.VoIPAudioManager", "onSensorEvent, not create stateMachine yet, ignore");
      AppMethodBeat.o(292722);
      return;
    }
    Object localObject = this.UwS;
    s.checkNotNull(localObject);
    if ((k.ark(((l)localObject).mState)) || (this.Uxg != 2))
    {
      ibb();
      AppMethodBeat.o(292722);
      return;
    }
    if (this.xCT)
    {
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.xCT = paramBoolean;
        Log.i("MicroMsg.VoIP.VoIPAudioManager", "onSensorEvent has skip and val is %s", new Object[] { Boolean.valueOf(this.xCT) });
        AppMethodBeat.o(292722);
        return;
      }
    }
    if ((Math.abs(Util.currentTicks() - this.ULr) < 500L) && (this.ULr != -1L))
    {
      Log.i("MicroMsg.VoIP.VoIPAudioManager", "onSensorEvent time interval too small");
      AppMethodBeat.o(292722);
      return;
    }
    if ((((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zmM, true)) && (!paramBoolean) && (this.lastShakeTime != -1L) && (Util.ticksToNow(this.lastShakeTime) > 400L))
    {
      this.xCT = true;
      Log.i("MicroMsg.VoIP.VoIPAudioManager", "onSensorEvent has skip case shake near to small");
      AppMethodBeat.o(292722);
      return;
    }
    this.xCT = false;
    localObject = this.UwS;
    if (localObject != null)
    {
      if ((k.arj(((l)localObject).mState)) && ((this.ULp != paramBoolean) || (this.ULo == -1L)))
      {
        if ((!this.ULp) && (paramBoolean) && (!k.ark(((l)localObject).mState)) && (this.PRF != 2) && (this.ULo != -1L))
        {
          long l = Util.ticksToNow(this.ULo);
          Log.i("MicroMsg.VoIP.VoIPAudioManager", "accumulate near screen time: %s", new Object[] { Long.valueOf(l) });
          this.ULq = (l + this.ULq);
        }
        this.ULo = Util.currentTicks();
        this.ULp = paramBoolean;
      }
      localObject = this.ULn;
      if (localObject != null)
      {
        localObject = (Long)((kotlin.g.a.b)localObject).invoke(Boolean.valueOf(paramBoolean));
        if (localObject != null)
        {
          if (((Number)localObject).longValue() == -1L) {
            break label493;
          }
          if (i == 0) {
            break label498;
          }
        }
      }
    }
    for (;;)
    {
      if (localObject != null) {
        this.ULr = ((Number)localObject).longValue();
      }
      AppMethodBeat.o(292722);
      return;
      label493:
      i = 0;
      break;
      label498:
      localObject = null;
    }
  }
  
  public final void unInit()
  {
    AppMethodBeat.i(292707);
    Object localObject = com.tencent.mm.plugin.audio.c.a.uVi;
    com.tencent.mm.plugin.audio.c.a.a.ahu("voip");
    ibb();
    localObject = this.ULw;
    if (localObject != null) {
      ((MMHandler)localObject).quitSafely();
    }
    this.ULw = null;
    AppMethodBeat.o(292707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.f.d
 * JD-Core Version:    0.7.0.1
 */