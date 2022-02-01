package com.tencent.mm.plugin.ringtone;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.ringtone.g.b.a;
import com.tencent.mm.plugin.ringtone.g.b.b;
import com.tencent.mm.plugin.ringtone.j.c.e;
import com.tencent.mm.plugin.ringtone.ui.RingtoneSelectUI;
import com.tencent.mm.plugin.ringtone.ui.RingtoneSettingsUI;
import com.tencent.mm.protocal.protobuf.a.q;
import com.tencent.mm.protocal.protobuf.a.u;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d<-Ljava.lang.Boolean;>;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.r;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/PluginRingtone;", "Lcom/tencent/mm/plugin/ringtone/IPluginRingtone;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "TAG", "", "currentPosition", "", "getCurrentPosition", "()I", "setCurrentPosition", "(I)V", "ringtoneHelper", "Lcom/tencent/mm/plugin/ringtone/service/RingtoneServiceHelper;", "getRingtoneHelper", "()Lcom/tencent/mm/plugin/ringtone/service/RingtoneServiceHelper;", "setRingtoneHelper", "(Lcom/tencent/mm/plugin/ringtone/service/RingtoneServiceHelper;)V", "sceneManager", "Lcom/tencent/mm/plugin/ringtone/setting/BaseSceneSetting;", "getSceneManager", "()Lcom/tencent/mm/plugin/ringtone/setting/BaseSceneSetting;", "setSceneManager", "(Lcom/tencent/mm/plugin/ringtone/setting/BaseSceneSetting;)V", "adjustVolume", "", "left", "", "right", "checkPlayerStatus", "doReportRingtoneExposure", "action", "wordType", "wording", "execute", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "getPlayInfo", "Lcom/tencent/mm/plugin/ringtone/api/PlayerReportInfo;", "getStreamType", "installed", "jumpToRingtoneSettingUI", "context", "Landroid/content/Context;", "channel", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "pausePlay", "", "responseSence", "sence", "Lcom/tencent/mm/plugin/ringtone/IPluginRingtone$RingSence;", "params", "Landroid/os/Bundle;", "resumePlay", "setAudioMode", "mode", "setMute", "mute", "setRingSpeakerStatus", "isSpeakerOn", "setUpRingtoneInfo", "soundType", "Lcom/tencent/mm/plugin/ringtone/IPluginRingtone$SoundType;", "streamType", "isLoop", "startPlaySound", "startShake", "isStill", "startShakeOnly", "stopPlay", "stopShake", "updateRingtoneInfo", "name", "isOutCall", "seekStartMs", "", "Companion", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginRingtone
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, a
{
  public static final a OBl;
  private int EuH;
  private com.tencent.mm.plugin.ringtone.j.c OBm;
  private com.tencent.mm.plugin.ringtone.k.a OBn;
  private final String TAG = "MicroMsg.PluginRingtone";
  
  static
  {
    AppMethodBeat.i(272855);
    OBl = new a((byte)0);
    AppMethodBeat.o(272855);
  }
  
  public static final void enterRingtoneSelectUI(Activity paramActivity, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(272850);
    a.enterRingtoneSelectUI(paramActivity, paramInt1, paramString, paramInt2);
    AppMethodBeat.o(272850);
  }
  
  public static final void enterRingtoneSettingUI(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(272847);
    a.enterRingtoneSettingUI(paramContext, paramInt);
    AppMethodBeat.o(272847);
  }
  
  public static final Object getRingBackFromFinder(long paramLong, String paramString, kotlin.d.d<? super com.tencent.mm.plugin.ringtone.i.a.a> paramd)
  {
    AppMethodBeat.i(272801);
    paramString = com.tencent.mm.plugin.ringtone.i.a.getRingBackFromFinder(paramLong, paramString, paramd);
    AppMethodBeat.o(272801);
    return paramString;
  }
  
  public static final Object getRingBackPlayInfo(String paramString, boolean paramBoolean, kotlin.d.d<? super r<? extends com.tencent.mm.plugin.ringtone.g.c, ? extends com.tencent.mm.plugin.ringtone.a.b>> paramd)
  {
    AppMethodBeat.i(272842);
    paramString = a.getRingBackPlayInfo(paramString, paramBoolean, paramd);
    AppMethodBeat.o(272842);
    return paramString;
  }
  
  public static final Object getSingleMusicRingBackPlayInfo(int paramInt, kotlin.d.d<? super q> paramd)
  {
    AppMethodBeat.i(272793);
    paramd = a.getSingleMusicRingBackPlayInfo(paramInt, paramd);
    AppMethodBeat.o(272793);
    return paramd;
  }
  
  public static final Object saveExclusivePersonalityRingtone(int paramInt1, int paramInt2, long paramLong, String paramString1, String paramString2, int paramInt3, int paramInt4, String paramString3, kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(272835);
    paramString1 = a.a(paramInt1, paramInt2, paramLong, paramString1, paramInt3, paramInt4, paramString3, paramd);
    AppMethodBeat.o(272835);
    return paramString1;
  }
  
  public static final Object saveExclusiveRingtone(int paramInt1, int paramInt2, com.tencent.mm.protocal.protobuf.a.z paramz, int paramInt3, int paramInt4, String paramString, kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(272810);
    paramz = a.saveExclusiveRingtone(paramInt1, paramInt2, paramz, paramInt3, paramInt4, paramString, paramd);
    AppMethodBeat.o(272810);
    return paramz;
  }
  
  public static final Object saveGlobalRingtone(int paramInt1, int paramInt2, com.tencent.mm.protocal.protobuf.a.z paramz, int paramInt3, int paramInt4, kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(272817);
    paramz = a.saveGlobalRingtone(paramInt1, paramInt2, paramz, paramInt3, paramInt4, paramd);
    AppMethodBeat.o(272817);
    return paramz;
  }
  
  public static final Object saveNormalPersonalityRingtone(int paramInt1, int paramInt2, int paramInt3, long paramLong, String paramString, int paramInt4, int paramInt5, int paramInt6, kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(272829);
    paramString = a.a(paramInt1, paramInt2, paramInt3, paramLong, paramString, paramInt4, paramInt5, paramd);
    AppMethodBeat.o(272829);
    return paramString;
  }
  
  public static final Object setRingtoneSelf(com.tencent.mm.plugin.ringtone.g.d paramd, int paramInt, kotlin.d.d<? super Boolean> paramd1)
  {
    AppMethodBeat.i(272826);
    paramd = OBl.setRingtoneSelf(paramd, paramInt, paramd1);
    AppMethodBeat.o(272826);
    return paramd;
  }
  
  public static final Object setRingtoneSelf(aq paramaq, int paramInt, kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(272822);
    paramaq = a.setRingtoneSelf(paramaq, paramInt, paramd);
    AppMethodBeat.o(272822);
    return paramaq;
  }
  
  public final void adjustVolume(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(272921);
    com.tencent.mm.plugin.ringtone.j.c localc = this.OBm;
    if (localc != null) {
      localc.da(paramFloat1);
    }
    AppMethodBeat.o(272921);
  }
  
  public final int checkPlayerStatus()
  {
    int i = 1;
    AppMethodBeat.i(273003);
    Object localObject = this.OBm;
    if (localObject == null)
    {
      AppMethodBeat.o(273003);
      return 9;
    }
    localObject = ((com.tencent.mm.plugin.ringtone.j.c)localObject).OEd;
    if ((localObject != null) && (((com.tencent.mm.plugin.ringtone.j.b)localObject).isPlaying() == true)) {}
    while (i != 0)
    {
      AppMethodBeat.o(273003);
      return 5;
      i = 0;
    }
    AppMethodBeat.o(273003);
    return 9;
  }
  
  public final void doReportRingtoneExposure(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(273029);
    s.u(paramString, "wording");
    a.K(paramInt2, paramInt1, paramString);
    AppMethodBeat.o(273029);
  }
  
  public final void execute(g paramg) {}
  
  public final int getCurrentPosition()
  {
    return this.EuH;
  }
  
  public final com.tencent.mm.plugin.ringtone.a.a getPlayInfo()
  {
    AppMethodBeat.i(273044);
    com.tencent.mm.plugin.ringtone.j.c localc = this.OBm;
    if (localc == null)
    {
      AppMethodBeat.o(273044);
      return null;
    }
    localc.OEn = (System.currentTimeMillis() - localc.GmG);
    Object localObject = com.tencent.mm.plugin.audio.c.a.uVi;
    int i;
    int j;
    boolean bool1;
    if (com.tencent.mm.plugin.audio.c.a.a.cTW().cTV())
    {
      localObject = com.tencent.mm.plugin.audio.c.a.uVi;
      i = com.tencent.mm.plugin.audio.c.a.a.cTW().cTR();
      localObject = com.tencent.mm.plugin.audio.c.a.uVi;
      j = com.tencent.mm.plugin.audio.c.a.a.cTW().getStreamVolume(i);
      localObject = com.tencent.mm.plugin.audio.c.a.uVi;
      if (com.tencent.mm.plugin.audio.c.a.a.cUh() != 0) {
        break label251;
      }
      bool1 = true;
      label89:
      if (localc.ODB != com.tencent.mm.plugin.ringtone.g.c.ODs) {
        break label256;
      }
    }
    label256:
    for (boolean bool2 = true;; bool2 = false)
    {
      localObject = new com.tencent.mm.plugin.ringtone.a.a(bool2, localc.OEn, localc.duration, String.valueOf(localc.ODC), localc.OEp, localc.OEo, localc.OEr, localc.sWX, j, i, localc.OEq, bool1, localc.OBR);
      localc.GmG = 0L;
      localc.OEn = 0L;
      localc.OEo = true;
      localc.ODB = com.tencent.mm.plugin.ringtone.g.c.ODp;
      localc.OEp = "";
      localc.ODC = 0;
      localc.OEr = false;
      localc.OEq = 0;
      AppMethodBeat.o(273044);
      return localObject;
      localObject = localc.ODZ;
      if (localObject == null)
      {
        i = 0;
        break;
      }
      i = ((b.b)localObject).streamType;
      break;
      label251:
      bool1 = false;
      break label89;
    }
  }
  
  public final com.tencent.mm.plugin.ringtone.j.c getRingtoneHelper()
  {
    return this.OBm;
  }
  
  public final com.tencent.mm.plugin.ringtone.k.a getSceneManager()
  {
    return this.OBn;
  }
  
  public final int getStreamType()
  {
    AppMethodBeat.i(273011);
    com.tencent.mm.plugin.ringtone.j.c localc = this.OBm;
    if (localc == null)
    {
      AppMethodBeat.o(273011);
      return 5;
    }
    Object localObject = localc.ODZ;
    if (localObject == null) {
      localObject = null;
    }
    while (localObject == null)
    {
      localObject = localc.OEd;
      if (localObject == null)
      {
        AppMethodBeat.o(273011);
        return 3;
        localObject = Integer.valueOf(((b.b)localObject).streamType);
      }
      else
      {
        i = ((com.tencent.mm.plugin.ringtone.j.b)localObject).getStreamType();
        AppMethodBeat.o(273011);
        return i;
      }
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(273011);
    return i;
  }
  
  public final void installed()
  {
    AppMethodBeat.i(272944);
    super.installed();
    com.tencent.mm.kernel.h.b(a.class, (com.tencent.mm.kernel.c.a)this);
    alias(a.class);
    AppMethodBeat.o(272944);
  }
  
  public final void jumpToRingtoneSettingUI(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(273024);
    s.u(paramContext, "context");
    a.enterRingtoneSettingUI(paramContext, paramInt);
    AppMethodBeat.o(273024);
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(272995);
    this.OBm = new com.tencent.mm.plugin.ringtone.j.c();
    d.aZq();
    AppMethodBeat.o(272995);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(272986);
    this.OBm = null;
    d.onAccountRelease();
    AppMethodBeat.o(272986);
  }
  
  public final boolean pausePlay()
  {
    AppMethodBeat.i(272963);
    com.tencent.mm.plugin.ringtone.j.c localc = this.OBm;
    if (localc != null) {
      localc.a(b.a.OCZ);
    }
    AppMethodBeat.o(272963);
    return true;
  }
  
  public final boolean responseSence(a.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(272913);
    s.u(paramBundle, "params");
    Object localObject;
    if (this.OBn != null)
    {
      localObject = this.OBn;
      if (localObject != null) {
        break label79;
      }
      localObject = null;
      if (localObject == parama) {}
    }
    else
    {
      if (parama != a.a.OBd) {
        break label89;
      }
      this.OBn = ((com.tencent.mm.plugin.ringtone.k.a)new com.tencent.mm.plugin.ringtone.k.c(this));
    }
    for (;;)
    {
      parama = this.OBn;
      if (parama != null) {
        break label114;
      }
      AppMethodBeat.o(272913);
      return false;
      label79:
      localObject = ((com.tencent.mm.plugin.ringtone.k.a)localObject).OEw;
      break;
      label89:
      if (parama == a.a.OBe) {
        this.OBn = ((com.tencent.mm.plugin.ringtone.k.a)new com.tencent.mm.plugin.ringtone.k.b(this));
      }
    }
    label114:
    boolean bool = parama.aP(paramBundle);
    AppMethodBeat.o(272913);
    return bool;
  }
  
  public final boolean resumePlay()
  {
    AppMethodBeat.i(272971);
    com.tencent.mm.plugin.ringtone.j.c localc = this.OBm;
    if (localc != null) {
      localc.a(b.a.ODf);
    }
    AppMethodBeat.o(272971);
    return true;
  }
  
  public final void setAudioMode(int paramInt)
  {
    AppMethodBeat.i(273020);
    if (this.OBm != null) {
      com.tencent.mm.plugin.ringtone.j.c.setAudioMode(paramInt);
    }
    AppMethodBeat.o(273020);
  }
  
  public final void setCurrentPosition(int paramInt)
  {
    this.EuH = paramInt;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(272928);
    Object localObject = this.OBm;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.ringtone.j.c)localObject).OEd;
      if (localObject != null) {
        ((com.tencent.mm.plugin.ringtone.j.b)localObject).setMute(paramBoolean);
      }
    }
    AppMethodBeat.o(272928);
  }
  
  public final void setRingSpeakerStatus(boolean paramBoolean)
  {
    AppMethodBeat.i(273015);
    if (this.OBm != null) {
      com.tencent.mm.plugin.ringtone.j.c.BN(paramBoolean);
    }
    AppMethodBeat.o(273015);
  }
  
  public final void setRingtoneHelper(com.tencent.mm.plugin.ringtone.j.c paramc)
  {
    this.OBm = paramc;
  }
  
  public final void setSceneManager(com.tencent.mm.plugin.ringtone.k.a parama)
  {
    this.OBn = parama;
  }
  
  public final void setUpRingtoneInfo(a.b paramb, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(272906);
    s.u(paramb, "soundType");
    com.tencent.mm.plugin.ringtone.j.c localc = this.OBm;
    if (localc != null)
    {
      s.u(paramb, "soundType");
      localc.ODZ = new b.b(paramb, paramInt, paramBoolean);
      paramb = com.tencent.mm.plugin.audio.c.a.uVi;
      if (!com.tencent.mm.plugin.audio.c.a.a.cTW().cTV()) {
        break label93;
      }
      paramb = com.tencent.mm.plugin.audio.c.a.uVi;
      paramInt = com.tencent.mm.plugin.audio.c.a.a.cTW().cTR();
    }
    for (;;)
    {
      paramb = com.tencent.mm.plugin.audio.c.a.uVi;
      localc.OEq = com.tencent.mm.plugin.audio.c.a.a.cTW().getStreamVolume(paramInt);
      AppMethodBeat.o(272906);
      return;
      label93:
      paramb = localc.ODZ;
      if (paramb == null) {
        paramInt = 0;
      } else {
        paramInt = paramb.streamType;
      }
    }
  }
  
  public final void startPlaySound(boolean paramBoolean)
  {
    AppMethodBeat.i(272888);
    if (this.OBm != null) {
      com.tencent.mm.plugin.ringtone.j.c.BN(paramBoolean);
    }
    AppMethodBeat.o(272888);
  }
  
  public final boolean startShake(boolean paramBoolean)
  {
    AppMethodBeat.i(272952);
    Object localObject = com.tencent.mm.plugin.audio.c.a.uVi;
    switch (com.tencent.mm.plugin.audio.c.a.a.cUh())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(272952);
      return true;
      localObject = this.OBm;
      if (localObject != null) {
        ((com.tencent.mm.plugin.ringtone.j.c)localObject).OEm = true;
      }
    }
  }
  
  public final boolean startShakeOnly()
  {
    AppMethodBeat.i(272956);
    Object localObject1 = com.tencent.mm.plugin.audio.c.a.uVi;
    switch (com.tencent.mm.plugin.audio.c.a.a.cUh())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(272956);
      return true;
      localObject1 = this.OBm;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.ringtone.j.c)localObject1).OEl = new com.tencent.mm.plugin.au.a();
        Object localObject2 = ((com.tencent.mm.plugin.ringtone.j.c)localObject1).OBS;
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.ringtone.g.d)localObject2).gOD();
          if (localObject2 != null)
          {
            com.tencent.mm.plugin.au.a locala = ((com.tencent.mm.plugin.ringtone.j.c)localObject1).OEl;
            if (locala != null) {
              locala.a((com.tencent.mm.plugin.aj.a.a)localObject2, null);
            }
            localObject2 = ((com.tencent.mm.plugin.ringtone.j.c)localObject1).OEl;
            if (localObject2 != null) {
              ((com.tencent.mm.plugin.au.a)localObject2).hQe();
            }
            ((com.tencent.mm.plugin.ringtone.j.c)localObject1).OBR = true;
          }
        }
      }
    }
  }
  
  public final boolean stopPlay()
  {
    AppMethodBeat.i(272978);
    com.tencent.mm.plugin.ringtone.j.c localc = this.OBm;
    if (localc != null) {
      localc.a(b.a.ODd);
    }
    AppMethodBeat.o(272978);
    return true;
  }
  
  public final boolean stopShake()
  {
    return true;
  }
  
  public final void updateRingtoneInfo(String paramString, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(272899);
    com.tencent.mm.plugin.ringtone.j.c localc = this.OBm;
    if (localc != null)
    {
      Log.i("MicroMsg.RingtoneServiceHelper", "updateRingtoneInfo name:" + paramString + ", isOutCall:" + paramBoolean + ", seekStartMs:" + paramLong);
      localc.OEc = localc.GvR;
      localc.GvR = null;
      localc.OEf = paramLong;
      localc.OEa = paramBoolean;
      localc.OEg = -1.0F;
      cb localcb = localc.OEh;
      if (localcb != null) {
        localcb.a(null);
      }
      localc.OEh = j.a(localc.OEi, null, null, (m)new c.e(paramString, localc, paramBoolean, null), 3);
    }
    AppMethodBeat.o(272899);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/PluginRingtone$Companion;", "", "()V", "enterRingtoneSelectUI", "", "context", "Landroid/app/Activity;", "caller", "", "username", "", "channel", "enterRingtoneSettingUI", "Landroid/content/Context;", "getRingBackFromFinder", "Lcom/tencent/mm/plugin/ringtone/ringtone/RingtoneSettingHelper$FinderObjectDesc;", "finderObjectId", "", "finderNonceId", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRingBackPlayInfo", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/ringtone/params/RingtoneSource;", "Lcom/tencent/mm/plugin/ringtone/api/RingBackPlayInfo;", "isOutCall", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSingleMusicRingBackPlayInfo", "Lcom/tencent/mm/protocal/protobuf/ringtone/GetRingBackDetailInfo;", "sid", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportRingtoneEntranceExposure", "wordingType", "action", "wording", "saveExclusivePersonalityRingtone", "opType", "setRingBackType", "musicUrl", "startTs", "endTs", "(IIJLjava/lang/String;Ljava/lang/String;IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveExclusiveRingtone", "ringbackDetail", "Lcom/tencent/mm/protocal/protobuf/ringtone/RingBack;", "(IILcom/tencent/mm/protocal/protobuf/ringtone/RingBack;IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveGlobalRingtone", "(IILcom/tencent/mm/protocal/protobuf/ringtone/RingBack;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveNormalPersonalityRingtone", "musicSid", "ringtoneType", "(IIIJLjava/lang/String;IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setRingtoneSelf", "playInfo", "Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;", "scene", "(Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void K(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(273074);
      s.u(paramString, "wording");
      com.tencent.mm.plugin.ringtone.h.a.L(paramInt1, paramInt2, paramString);
      AppMethodBeat.o(273074);
    }
    
    public static Object a(int paramInt1, int paramInt2, int paramInt3, long paramLong, String paramString, int paramInt4, int paramInt5, kotlin.d.d<? super Boolean> paramd)
    {
      AppMethodBeat.i(273039);
      com.tencent.mm.plugin.ringtone.i.a locala = com.tencent.mm.plugin.ringtone.i.a.ODH;
      paramString = com.tencent.mm.plugin.ringtone.i.a.a(paramInt1, paramInt2, paramInt3, paramLong, paramString, paramInt4, paramInt5, paramd);
      AppMethodBeat.o(273039);
      return paramString;
    }
    
    public static Object a(int paramInt1, int paramInt2, long paramLong, String paramString1, int paramInt3, int paramInt4, String paramString2, kotlin.d.d<? super Boolean> paramd)
    {
      AppMethodBeat.i(273049);
      com.tencent.mm.plugin.ringtone.i.a locala = com.tencent.mm.plugin.ringtone.i.a.ODH;
      paramString1 = com.tencent.mm.plugin.ringtone.i.a.b(paramInt1, paramInt2, paramLong, paramString1, paramInt3, paramInt4, paramString2, paramd);
      AppMethodBeat.o(273049);
      return paramString1;
    }
    
    public static void enterRingtoneSelectUI(Activity paramActivity, int paramInt1, String paramString, int paramInt2)
    {
      AppMethodBeat.i(273070);
      s.u(paramActivity, "context");
      Intent localIntent = new Intent();
      localIntent.putExtra("ringtone_caller", paramInt1);
      localIntent.putExtra("channel", paramInt2);
      localIntent.putExtra("exclusvie_name", paramString);
      localIntent.setClass((Context)paramActivity, RingtoneSelectUI.class);
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(5, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/ringtone/PluginRingtone$Companion", "enterRingtoneSelectUI", "(Landroid/app/Activity;ILjava/lang/String;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      AppMethodBeat.o(273070);
    }
    
    public static void enterRingtoneSettingUI(Context paramContext, int paramInt)
    {
      AppMethodBeat.i(273063);
      s.u(paramContext, "context");
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("channel", paramInt);
      ((Intent)localObject).setClass(paramContext, RingtoneSettingsUI.class);
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/ringtone/PluginRingtone$Companion", "enterRingtoneSettingUI", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/ringtone/PluginRingtone$Companion", "enterRingtoneSettingUI", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(273063);
    }
    
    public static Object getRingBackPlayInfo(String paramString, final boolean paramBoolean, kotlin.d.d<? super r<? extends com.tencent.mm.plugin.ringtone.g.c, ? extends com.tencent.mm.plugin.ringtone.a.b>> paramd)
    {
      AppMethodBeat.i(273055);
      paramString = l.a((kotlin.d.f)bg.kCi(), (m)new a(paramString, paramBoolean, null), paramd);
      AppMethodBeat.o(273055);
      return paramString;
    }
    
    public static Object getSingleMusicRingBackPlayInfo(int paramInt, kotlin.d.d<? super q> paramd)
    {
      AppMethodBeat.i(273010);
      paramd = l.a((kotlin.d.f)bg.kCi(), (m)new PluginRingtone.a.b(paramInt, null), paramd);
      AppMethodBeat.o(273010);
      return paramd;
    }
    
    public static Object saveExclusiveRingtone(int paramInt1, int paramInt2, com.tencent.mm.protocal.protobuf.a.z paramz, int paramInt3, int paramInt4, String paramString, kotlin.d.d<? super Boolean> paramd)
    {
      AppMethodBeat.i(273017);
      if (paramz.vhJ == 2)
      {
        Object localObject = paramz.acji;
        if (localObject == null) {}
        for (localObject = null; localObject == null; localObject = kotlin.d.b.a.b.BF(((com.tencent.mm.protocal.protobuf.a.b)localObject).aacf))
        {
          paramz = Boolean.FALSE;
          AppMethodBeat.o(273017);
          return paramz;
        }
        long l = ((Long)localObject).longValue();
        paramz = paramz.acji;
        if (paramz == null) {}
        for (paramz = null; paramz == null; paramz = paramz.aacg)
        {
          paramz = Boolean.FALSE;
          AppMethodBeat.o(273017);
          return paramz;
        }
        localObject = com.tencent.mm.plugin.ringtone.i.a.ODH;
        paramz = com.tencent.mm.plugin.ringtone.i.a.b(paramInt1, paramInt2, l, paramz, paramInt3, paramInt4, paramString, paramd);
        AppMethodBeat.o(273017);
        return paramz;
      }
      paramz = paramz.acjh;
      if (paramz == null) {}
      for (paramz = null; paramz == null; paramz = Integer.valueOf(paramz.aaYO))
      {
        paramz = Boolean.FALSE;
        AppMethodBeat.o(273017);
        return paramz;
      }
      int i = paramz.intValue();
      paramz = com.tencent.mm.plugin.ringtone.i.a.ODH;
      paramz = com.tencent.mm.plugin.ringtone.i.a.a(paramInt1, paramInt2, 0L, "", paramInt3, paramInt4, paramString, i, paramd);
      AppMethodBeat.o(273017);
      return paramz;
    }
    
    public static Object saveGlobalRingtone(int paramInt1, int paramInt2, com.tencent.mm.protocal.protobuf.a.z paramz, int paramInt3, int paramInt4, kotlin.d.d<? super Boolean> paramd)
    {
      AppMethodBeat.i(273025);
      if (paramz.vhJ == 2)
      {
        Object localObject = paramz.acji;
        if (localObject == null) {}
        for (localObject = null; localObject == null; localObject = kotlin.d.b.a.b.BF(((com.tencent.mm.protocal.protobuf.a.b)localObject).aacf))
        {
          paramz = Boolean.FALSE;
          AppMethodBeat.o(273025);
          return paramz;
        }
        long l = ((Long)localObject).longValue();
        paramz = paramz.acji;
        if (paramz == null) {}
        for (paramz = null; paramz == null; paramz = paramz.aacg)
        {
          paramz = Boolean.FALSE;
          AppMethodBeat.o(273025);
          return paramz;
        }
        localObject = com.tencent.mm.plugin.ringtone.i.a.ODH;
        paramz = com.tencent.mm.plugin.ringtone.i.a.a(paramInt1, paramInt2, 0, l, paramz, paramInt3, paramInt4, paramd);
        AppMethodBeat.o(273025);
        return paramz;
      }
      paramz = paramz.acjh;
      if (paramz == null) {}
      for (paramz = null; paramz == null; paramz = Integer.valueOf(paramz.aaYO))
      {
        paramz = Boolean.FALSE;
        AppMethodBeat.o(273025);
        return paramz;
      }
      int i = paramz.intValue();
      paramz = com.tencent.mm.plugin.ringtone.i.a.ODH;
      paramz = com.tencent.mm.plugin.ringtone.i.a.a(paramInt1, paramInt2, i, 0L, "", paramInt3, paramInt4, paramd);
      AppMethodBeat.o(273025);
      return paramz;
    }
    
    public static Object setRingtoneSelf(aq paramaq, int paramInt, kotlin.d.d<? super Boolean> paramd)
    {
      AppMethodBeat.i(273032);
      kotlin.d.h localh = new kotlin.d.h(kotlin.d.a.b.au(paramd));
      j.a(paramaq, null, null, (m)new c(paramInt, (kotlin.d.d)localh, null), 3);
      paramaq = localh.kli();
      if (paramaq == kotlin.d.a.a.aiwj) {
        s.u(paramd, "frame");
      }
      AppMethodBeat.o(273032);
      return paramaq;
    }
    
    public final Object setRingtoneSelf(com.tencent.mm.plugin.ringtone.g.d paramd, int paramInt, kotlin.d.d<? super Boolean> paramd1)
    {
      AppMethodBeat.i(273094);
      if ((paramd1 instanceof d))
      {
        localObject1 = (d)paramd1;
        if ((((d)localObject1).label & 0x80000000) != 0) {
          ((d)localObject1).label += -2147483648;
        }
      }
      kotlin.d.a.a locala;
      for (paramd1 = (kotlin.d.d<? super Boolean>)localObject1;; paramd1 = new d(this, paramd1))
      {
        localObject1 = paramd1.result;
        locala = kotlin.d.a.a.aiwj;
        switch (paramd1.label)
        {
        default: 
          paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(273094);
          throw paramd;
        }
      }
      ResultKt.throwOnFailure(localObject1);
      Object localObject2 = new com.tencent.mm.protocal.protobuf.a.z();
      ((com.tencent.mm.protocal.protobuf.a.z)localObject2).abaj = 0;
      ((com.tencent.mm.protocal.protobuf.a.z)localObject2).abak = ((int)paramd.mEndTime);
      ah localah;
      if (paramd.ODw != null)
      {
        localObject1 = new com.tencent.mm.protocal.protobuf.a.b();
        ((com.tencent.mm.protocal.protobuf.a.b)localObject1).aacg = paramd.LYS;
        ((com.tencent.mm.protocal.protobuf.a.b)localObject1).aacf = paramd.mIH;
        localah = ah.aiuX;
        ((com.tencent.mm.protocal.protobuf.a.z)localObject2).acji = ((com.tencent.mm.protocal.protobuf.a.b)localObject1);
        ((com.tencent.mm.protocal.protobuf.a.z)localObject2).vhJ = 2;
      }
      Object localObject1 = Integer.valueOf(paramd.ODC);
      int i;
      if (((Number)localObject1).intValue() != 0)
      {
        i = 1;
        if (i == 0) {
          break label354;
        }
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          ((Number)localObject1).intValue();
          localObject1 = new u();
          ((u)localObject1).aaYO = paramd.ODC;
          ((com.tencent.mm.protocal.protobuf.a.z)localObject2).vhJ = 1;
          localah = ah.aiuX;
          ((com.tencent.mm.protocal.protobuf.a.z)localObject2).acjh = ((u)localObject1);
        }
        localObject1 = PluginRingtone.OBl;
        i = ((com.tencent.mm.protocal.protobuf.a.z)localObject2).abaj;
        int j = ((com.tencent.mm.protocal.protobuf.a.z)localObject2).abak;
        paramd1.L$0 = paramd;
        paramd1.aai = paramInt;
        paramd1.label = 1;
        localObject2 = saveGlobalRingtone(1, 1, (com.tencent.mm.protocal.protobuf.a.z)localObject2, i, j, paramd1);
        localObject1 = localObject2;
        if (localObject2 != locala) {
          break label378;
        }
        AppMethodBeat.o(273094);
        return locala;
        i = 0;
        break;
        label354:
        localObject1 = null;
      }
      paramInt = paramd1.aai;
      paramd = (com.tencent.mm.plugin.ringtone.g.d)paramd1.L$0;
      ResultKt.throwOnFailure(localObject1);
      label378:
      boolean bool1 = ((Boolean)localObject1).booleanValue();
      boolean bool2 = bool1;
      if (bool1)
      {
        localObject1 = d.OBx;
        paramd1.L$0 = paramd;
        paramd1.aai = paramInt;
        paramd1.YF = bool1;
        paramd1.label = 2;
        if (((d)localObject1).a("", paramd, paramd1) != locala) {
          break label560;
        }
        AppMethodBeat.o(273094);
        return locala;
        bool1 = paramd1.YF;
        paramInt = paramd1.aai;
        paramd = (com.tencent.mm.plugin.ringtone.g.d)paramd1.L$0;
        ResultKt.throwOnFailure(localObject1);
      }
      label554:
      label560:
      for (;;)
      {
        paramd1 = com.tencent.mm.model.z.bAM();
        s.s(paramd1, "getUsernameFromUserInfo()");
        d.a(paramd1, paramd);
        if (paramd.mIH != 0L)
        {
          i = 2;
          paramd = com.tencent.mm.ae.d.hF(paramd.mIH);
          com.tencent.mm.plugin.ringtone.h.a.P(paramd, i, paramInt);
          bool2 = bool1;
          if (!bool2) {
            break label554;
          }
        }
        for (bool1 = true;; bool1 = false)
        {
          AppMethodBeat.o(273094);
          return Boolean.valueOf(bool1);
          i = 1;
          paramd = String.valueOf(paramd.ODC);
          break;
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/ringtone/params/RingtoneSource;", "Lcom/tencent/mm/plugin/ringtone/api/RingBackPlayInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends k
      implements m<aq, kotlin.d.d<? super r<? extends com.tencent.mm.plugin.ringtone.g.c, ? extends com.tencent.mm.plugin.ringtone.a.b>>, Object>
    {
      int label;
      
      a(String paramString, boolean paramBoolean, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(272772);
        paramObject = (kotlin.d.d)new a(this.mrr, paramBoolean, paramd);
        AppMethodBeat.o(272772);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(272768);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(272768);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.mrr;
          boolean bool = paramBoolean;
          Object localObject = (kotlin.d.d)this;
          this.label = 1;
          localObject = com.tencent.mm.plugin.ringtone.i.a.getRingBackPlayInfo(paramObject, bool, (kotlin.d.d)localObject);
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(272768);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        AppMethodBeat.o(272768);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends k
      implements m<aq, kotlin.d.d<? super ah>, Object>
    {
      Object L$0;
      Object Uf;
      int label;
      
      c(int paramInt, kotlin.d.d<? super Boolean> paramd, kotlin.d.d<? super c> paramd1)
      {
        super(paramd1);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(272770);
        paramObject = (kotlin.d.d)new c(this.ofW, this.ntL, paramd);
        AppMethodBeat.o(272770);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(272765);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        Object localObject1;
        Object localObject2;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(272765);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = c.OBr;
          localObject1 = (com.tencent.mm.plugin.ringtone.g.d)c.gOe().getValue();
          if (localObject1 == null) {
            break label188;
          }
          int i = this.ofW;
          paramObject = this.ntL;
          localObject2 = PluginRingtone.OBl;
          this.L$0 = localObject1;
          this.Uf = paramObject;
          this.label = 1;
          localObject2 = ((PluginRingtone.a)localObject2).setRingtoneSelf((com.tencent.mm.plugin.ringtone.g.d)localObject1, i, this);
          localObject1 = localObject2;
          if (localObject2 == locala)
          {
            AppMethodBeat.o(272765);
            return locala;
          }
          break;
        case 1: 
          localObject2 = (kotlin.d.d)this.Uf;
          ResultKt.throwOnFailure(paramObject);
          localObject1 = paramObject;
          paramObject = localObject2;
        }
        if (((Boolean)localObject1).booleanValue()) {}
        for (boolean bool = true;; bool = false)
        {
          localObject1 = Result.Companion;
          paramObject.resumeWith(Result.constructor-impl(Boolean.valueOf(bool)));
          label188:
          paramObject = ah.aiuX;
          AppMethodBeat.o(272765);
          return paramObject;
        }
      }
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class d
      extends kotlin.d.b.a.d
    {
      Object L$0;
      boolean YF;
      int aai;
      int label;
      
      d(PluginRingtone.a parama, kotlin.d.d<? super d> paramd)
      {
        super();
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(272763);
        this.result = paramObject;
        this.label |= 0x80000000;
        paramObject = this.OBq.setRingtoneSelf(null, 0, (kotlin.d.d)this);
        AppMethodBeat.o(272763);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.PluginRingtone
 * JD-Core Version:    0.7.0.1
 */