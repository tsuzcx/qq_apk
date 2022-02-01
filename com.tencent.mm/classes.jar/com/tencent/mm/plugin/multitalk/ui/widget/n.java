package com.tencent.mm.plugin.multitalk.ui.widget;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.ae;
import com.tencent.mm.plugin.multitalk.model.f;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.multitalk.model.v.a;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.pb.common.b.a.a.a.ar;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import com.tencent.pb.talkroom.sdk.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow;", "Lcom/tencent/mm/plugin/multitalk/model/IMultiTalkUICallback;", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTargetContainer;", "()V", "callBack", "Lcom/tencent/mm/plugin/voip/ui/IVoipMiniCallBack;", "currentMode", "", "floatBallViewListener", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallViewListenerAdapter;", "getFloatBallViewListener", "()Lcom/tencent/mm/plugin/ball/api/OnFloatBallViewListenerAdapter;", "setFloatBallViewListener", "(Lcom/tencent/mm/plugin/ball/api/OnFloatBallViewListenerAdapter;)V", "intent", "Landroid/content/Intent;", "isAllowToDoAnimation", "", "isHangup", "isNeedShowCameraStatus", "isNeedShowMuteStatus", "mBaseSmallView", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallView;", "mIsBeenSilent", "mTimerAfterClickAutoDismiss", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "mUIHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getMUIHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setMUIHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "waitingRenderList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "checkRenderUserTalking", "userName", "checkSpeakerHasVideo", "dismiss", "", "isFinish", "disturbSpeaker", "interval", "doFavScreenShot", "path", "doSendToFriend", "drawVideo", "username", "bitmap", "Landroid/graphics/Bitmap;", "mirror", "angle", "engineDoMemberSelectForView", "memberIdList", "Ljava/util/ArrayList;", "exitProjectScreen", "getLargeRenderTarget", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "ori", "getNormalRenderTarget", "wxUserName", "getOnlineUser", "Lkotlin/collections/ArrayList;", "getRandomNum", "maxSize", "initCurrentMode", "isVideo", "isCameraOpen", "isMiniTalkingUiVisibility", "wxGroupId", "mini", "onBadNetTipShow", "show", "onCameraStartError", "onEnterMultiTalk", "onError", "errCode", "onExitMultiTalk", "onHangupHappened", "onILinkCancelSubscribeLargeVideo", "onMemberChange", "onMiniMultiTalk", "onMultiTalkStatusChange", "preStatus", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkStatus;", "currentStatus", "onMuteStateChange", "isMute", "onNetWorkStatusChange", "preNetWorkType", "Lcom/tencent/mm/plugin/multitalk/model/MultiTalkUtil$NetWorkType;", "currentNetWorkType", "onScreenFrame", "onSpeakerStateChange", "isSpeaker", "onStartRecordFailed", "onTimeSecondCallback", "onVideoGroupMemberChange", "onVideoStateChange", "preAction", "currentAciton", "peakSpeakerUserList", "randomPeakUser", "randomPeakUserWhileTalking", "list", "", "refreshMiniView", "renderVideo", "img", "", "imgW", "imgH", "setHandFreeEnable", "enable", "setVoicePlayDevice", "device", "showCameraStatus", "showMini", "showMuteStatus", "switchToVoiceOrVideo", "updateTime", "time", "Companion", "plugin-multitalk_release"})
public final class n
  implements com.tencent.mm.plugin.multitalk.model.e, com.tencent.mm.plugin.multitalk.model.g
{
  public static final n.a zTV;
  private MMHandler czp;
  public Intent intent;
  public m zTM;
  public com.tencent.mm.plugin.voip.ui.a zTN;
  public boolean zTO;
  private MTimerHandler zTP;
  private int zTQ;
  boolean zTR;
  boolean zTS;
  private boolean zTT;
  private com.tencent.mm.plugin.ball.c.h zTU;
  
  static
  {
    AppMethodBeat.i(239871);
    zTV = new n.a((byte)0);
    AppMethodBeat.o(239871);
  }
  
  public n()
  {
    AppMethodBeat.i(239870);
    this.zTQ = 1;
    this.zTU = ((com.tencent.mm.plugin.ball.c.h)new b(this));
    AppMethodBeat.o(239870);
  }
  
  private static int aB(ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(239861);
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      AppMethodBeat.o(239861);
      return -1;
    }
    int j = paramArrayList.size();
    Object localObject1 = new int[j];
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < j)
    {
      Object localObject2 = paramArrayList.get(i);
      kotlin.g.b.p.g(localObject2, "memberIdList[i]");
      int k = ((Number)localObject2).intValue();
      localStringBuilder.append(k).append(",");
      localObject1[i] = k;
      i += 1;
    }
    Log.i("MicroMsg.MultiTalkSmallWindow", "steve: engineDoMemberSelectForView: selected id list: %s", new Object[] { localStringBuilder.toString() });
    paramArrayList = ByteBuffer.allocate(j * 4);
    paramArrayList.order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put((int[])localObject1);
    paramArrayList = paramArrayList.array();
    localObject1 = ac.eol();
    kotlin.g.b.p.g(localObject1, "SubCoreMultiTalk.getMultiEngine()");
    i = ((com.tencent.mm.plugin.multitalk.model.o)localObject1).emG().setAppCmd(23, paramArrayList, j);
    if (i < 0)
    {
      Log.e("MicroMsg.MultiTalkSmallWindow", "steve:engineDoMemberSelectForView failed!!");
      com.tencent.mm.plugin.multitalk.model.p.emZ();
      AppMethodBeat.o(239861);
      return -1;
    }
    AppMethodBeat.o(239861);
    return i;
  }
  
  private static boolean aGB(String paramString)
  {
    AppMethodBeat.i(239864);
    Object localObject = ac.eom();
    kotlin.g.b.p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
    localObject = ((q)localObject).enr();
    kotlin.g.b.p.g(localObject, "SubCoreMultiTalk.getMult…ger().currentVideoUserSet");
    Iterator localIterator = ((Iterable)localObject).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!kotlin.g.b.p.j((String)localObject, paramString));
    for (paramString = (String)localObject; paramString != null; paramString = null)
    {
      AppMethodBeat.o(239864);
      return true;
    }
    AppMethodBeat.o(239864);
    return false;
  }
  
  private final String eoO()
  {
    Object localObject2 = null;
    AppMethodBeat.i(239862);
    Object localObject1 = this.zTM;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((m)localObject1).getRendererSpeaker();
      localObject3 = ac.eol().emJ();
      if (localObject3 != null) {
        break label205;
      }
      localObject3 = (CharSequence)localObject1;
      if ((localObject3 != null) && (!kotlin.n.n.aL((CharSequence)localObject3))) {
        break label102;
      }
    }
    label102:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label208;
      }
      if (!kotlin.g.b.p.j(localObject1, z.aTY())) {
        break label140;
      }
      ac.eom();
      if (com.tencent.mm.plugin.multitalk.a.a.elC()) {
        break label107;
      }
      Log.i("MicroMsg.MultiTalkSmallWindow", "check mute form local pcm recorder");
      AppMethodBeat.o(239862);
      return localObject1;
      localObject1 = null;
      break;
    }
    label107:
    if (!this.zTT)
    {
      this.zTT = true;
      AppMethodBeat.o(239862);
      return localObject1;
    }
    this.zTT = false;
    AppMethodBeat.o(239862);
    return null;
    label140:
    if (ac.eol().emH().contains(localObject1))
    {
      Log.i("MicroMsg.MultiTalkSmallWindow", "check mute form service status");
      AppMethodBeat.o(239862);
      return localObject1;
    }
    if (!this.zTT)
    {
      this.zTT = true;
      AppMethodBeat.o(239862);
      return localObject1;
    }
    this.zTT = false;
    AppMethodBeat.o(239862);
    return null;
    label205:
    localObject2 = localObject3;
    label208:
    AppMethodBeat.o(239862);
    return localObject2;
  }
  
  private static ArrayList<Integer> eoP()
  {
    AppMethodBeat.i(239863);
    Object localObject1 = ac.eom();
    kotlin.g.b.p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    Object localObject2 = ((q)localObject1).enn();
    localObject1 = new ArrayList();
    localObject2 = ((MultiTalkGroup)localObject2).RHa.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)((Iterator)localObject2).next();
      if ((localMultiTalkGroupMember.status == 10) || (localMultiTalkGroupMember.status == 1))
      {
        int i = com.tencent.mm.plugin.multitalk.d.e.aGF(localMultiTalkGroupMember.RHb);
        if (i != -1) {
          ((ArrayList)localObject1).add(Integer.valueOf(i));
        }
      }
    }
    AppMethodBeat.o(239863);
    return localObject1;
  }
  
  private void rW(boolean paramBoolean)
  {
    AppMethodBeat.i(239858);
    Object localObject;
    if (paramBoolean)
    {
      if (this.zTQ == 2)
      {
        localObject = this.zTM;
        if (localObject != null)
        {
          ((m)localObject).rS(true);
          AppMethodBeat.o(239858);
          return;
        }
        AppMethodBeat.o(239858);
        return;
      }
      this.zTQ = 2;
      localObject = this.zTM;
      if (localObject != null)
      {
        ((m)localObject).eoJ();
        AppMethodBeat.o(239858);
        return;
      }
      AppMethodBeat.o(239858);
      return;
    }
    if (this.zTQ == 1)
    {
      localObject = this.zTM;
      if (localObject != null)
      {
        ((m)localObject).rS(false);
        AppMethodBeat.o(239858);
        return;
      }
      AppMethodBeat.o(239858);
      return;
    }
    this.zTQ = 1;
    m localm = this.zTM;
    if (localm != null)
    {
      localObject = localm.zTI;
      if (localObject != null)
      {
        localObject = ((j)localObject).eoH();
        if (localObject != null) {
          break label238;
        }
      }
      label238:
      while (((Integer)localObject).intValue() != 0)
      {
        localObject = localm.zTI;
        if (localObject != null)
        {
          ((j)localObject).lJI.setAlpha(0.0F);
          ((j)localObject).lJI.setVisibility(0);
          ((j)localObject).lJI.clearAnimation();
          ((j)localObject).lJI.animate().alpha(1.0F).setDuration(300L).setListener((Animator.AnimatorListener)new j.b((j)localObject)).start();
        }
        localObject = localm.zTJ;
        if (localObject == null) {
          break label245;
        }
        ((i)localObject).H(4);
        AppMethodBeat.o(239858);
        return;
        localObject = null;
        break;
      }
      label245:
      AppMethodBeat.o(239858);
      return;
    }
    AppMethodBeat.o(239858);
  }
  
  public final f Rc(int paramInt)
  {
    return null;
  }
  
  public final void a(v.a parama) {}
  
  public final void a(o paramo) {}
  
  public final f aFB(String paramString)
  {
    AppMethodBeat.i(239865);
    kotlin.g.b.p.h(paramString, "wxUserName");
    m localm = this.zTM;
    int i;
    if (localm != null) {
      if ((TextUtils.isEmpty((CharSequence)localm.getUsername())) || (kotlin.g.b.p.j(localm.getUsername(), paramString)))
      {
        i = 1;
        if (i == 0) {
          break label72;
        }
        paramString = localm;
      }
    }
    for (;;)
    {
      paramString = (f)paramString;
      AppMethodBeat.o(239865);
      return paramString;
      i = 0;
      break;
      label72:
      paramString = null;
      continue;
      paramString = null;
    }
  }
  
  public final void aFS(String paramString) {}
  
  public final void aFT(String paramString) {}
  
  public final void aM(final Intent paramIntent)
  {
    AppMethodBeat.i(239868);
    Log.i("MicroMsg.MultiTalkSmallWindow", "mini now..");
    if (this.zTM != null) {
      rX(false);
    }
    if (this.zTM == null)
    {
      localObject1 = MMApplicationContext.getContext();
      kotlin.g.b.p.g(localObject1, "MMApplicationContext.getContext()");
      this.zTM = new m((Context)localObject1);
      this.zTO = false;
    }
    Object localObject1 = this.zTM;
    if (localObject1 != null) {
      ((m)localObject1).rT(ac.eoo().emo());
    }
    localObject1 = this.zTM;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ac.eom();
      kotlin.g.b.p.g(localObject2, "SubCoreMultiTalk.getMultiTalkManager()");
      ((m)localObject1).rU(((q)localObject2).Zx());
    }
    localObject1 = this.zTM;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class);
      kotlin.g.b.p.g(localObject2, "MMKernel.service(IFloatBallService::class.java)");
      ((m)localObject1).rV(((com.tencent.mm.plugin.ball.c.b)localObject2).chT());
    }
    this.czp = new MMHandler();
    ac.eom().a((com.tencent.mm.plugin.multitalk.model.e)this);
    ac.eoo().zLR = ((com.tencent.mm.plugin.multitalk.model.e)this);
    localObject1 = this.zTP;
    if (localObject1 != null) {
      ((MTimerHandler)localObject1).stopTimer();
    }
    localObject1 = this.zTM;
    if (localObject1 != null) {
      ((m)localObject1).setOnClickListener((View.OnClickListener)new c(this, paramIntent));
    }
    com.tencent.mm.plugin.voip.a.a.fFk().a(8, true, (View)this.zTM);
    ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).a((com.tencent.mm.plugin.ball.c.g)this.zTU);
    ac.eol().emI();
    this.zTQ = 1;
    rW(false);
    localObject1 = this.zTN;
    if (localObject1 == null) {
      kotlin.g.b.p.hyc();
    }
    ((com.tencent.mm.plugin.voip.ui.a)localObject1).a(paramIntent, (BaseSmallView)this.zTM);
    paramIntent = ac.eom();
    kotlin.g.b.p.g(paramIntent, "SubCoreMultiTalk.getMultiTalkManager()");
    paramIntent = paramIntent.enz();
    ae.a(paramIntent);
    paramIntent.a((com.tencent.mm.plugin.multitalk.model.g)this);
    AppMethodBeat.o(239868);
  }
  
  public final void dZZ() {}
  
  public final void eaa()
  {
    AppMethodBeat.i(239860);
    Object localObject1 = ac.eom();
    kotlin.g.b.p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    if (((q)localObject1).eno())
    {
      localObject1 = this.czp;
      if (localObject1 != null) {
        ((MMHandler)localObject1).post((Runnable)new g(this));
      }
    }
    localObject1 = this.czp;
    if (localObject1 != null) {
      ((MMHandler)localObject1).post((Runnable)new h(this));
    }
    localObject1 = ac.eom();
    kotlin.g.b.p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    if (((q)localObject1).ent()) {
      ac.eom().enL();
    }
    Object localObject2 = eoO();
    localObject1 = this.zTM;
    if (localObject1 != null)
    {
      localObject1 = ((m)localObject1).getRendererSpeaker();
      if (!kotlin.g.b.p.j(localObject2, localObject1)) {
        break label206;
      }
      localObject1 = this.zTM;
      if (localObject1 != null)
      {
        localObject2 = ((m)localObject1).zTJ;
        if (localObject2 != null) {
          ((i)localObject2).zTi = Long.valueOf(Util.currentTicks());
        }
        localObject2 = ((m)localObject1).zTJ;
        if ((localObject2 == null) || (((i)localObject2).zTf != true))
        {
          localObject2 = ((m)localObject1).zTJ;
          if (localObject2 != null) {
            ((i)localObject2).aGv(((m)localObject1).getRendererSpeaker());
          }
        }
      }
    }
    for (;;)
    {
      ac.eoo().emE();
      AppMethodBeat.o(239860);
      return;
      localObject1 = null;
      break;
      label206:
      if (localObject2 == null)
      {
        localObject1 = this.zTM;
        if (localObject1 != null) {
          ((m)localObject1).aGA(null);
        }
        rW(false);
      }
      else
      {
        localObject1 = this.zTM;
        if (localObject1 != null) {
          ((m)localObject1).aGA((String)localObject2);
        }
        localObject1 = this.zTM;
        if (localObject1 != null) {
          ((m)localObject1).aGz((String)localObject2);
        }
        rW(true);
      }
    }
  }
  
  public final void eie() {}
  
  public final void emc() {}
  
  public final boolean emo()
  {
    return false;
  }
  
  public final void emt()
  {
    AppMethodBeat.i(239866);
    eoN();
    AppMethodBeat.o(239866);
  }
  
  public final void emu() {}
  
  public final void emv()
  {
    int j = 0;
    AppMethodBeat.i(239867);
    Object localObject1 = new StringBuilder("onVideoGroupMemberChange, SubCoreMultiTalk.getMultiTalkManager().getCurrentVideoUserSet().size(): ");
    Object localObject2 = ac.eom();
    kotlin.g.b.p.g(localObject2, "SubCoreMultiTalk.getMultiTalkManager()");
    Log.i("MicroMsg.MultiTalkSmallWindow", ((q)localObject2).enr().size());
    localObject1 = ac.eom();
    kotlin.g.b.p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    if (((q)localObject1).ent())
    {
      localObject1 = ac.eom();
      kotlin.g.b.p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
      if (!((q)localObject1).enr().contains(z.aTY())) {
        break label484;
      }
    }
    label348:
    label477:
    label484:
    for (int i = 1;; i = 0)
    {
      localObject1 = ac.eom();
      kotlin.g.b.p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
      if (((q)localObject1).enr().size() > i)
      {
        ac.eom().enL();
        localObject1 = this.zTM;
        if ((localObject1 != null) && ((kotlin.g.b.p.j(((m)localObject1).getRendererSpeaker(), "") ^ true)))
        {
          rW(true);
          localObject1 = this.zTM;
          if (localObject1 != null) {
            ((m)localObject1).eoJ();
          }
        }
        localObject1 = ac.eom();
        kotlin.g.b.p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
        boolean bool = ((q)localObject1).ens();
        localObject1 = eoP();
        if (!bool) {
          aB((ArrayList)localObject1);
        }
        if (bool)
        {
          localObject2 = ac.eom();
          kotlin.g.b.p.g(localObject2, "SubCoreMultiTalk.getMultiTalkManager()");
          if (((q)localObject2).enA().emb()) {
            break label477;
          }
          com.tencent.mm.plugin.multitalk.b.p.zHS.az((ArrayList)localObject1);
          Log.i("MicroMsg.MultiTalkSmallWindow", "ilink subscribeByUserMids ok, mids:".concat(String.valueOf(localObject1)));
          AppMethodBeat.o(239867);
        }
      }
      else
      {
        ac.eom().enM();
        localObject1 = this.zTM;
        if (localObject1 != null)
        {
          if (!(kotlin.g.b.p.j(((m)localObject1).getRendererSpeaker(), "") ^ true)) {
            break label348;
          }
          localObject2 = this.zTM;
          if (localObject2 != null) {
            ((m)localObject2).aGz(((m)localObject1).getRendererSpeaker());
          }
        }
        for (;;)
        {
          eoO();
          rW(false);
          break;
          localObject1 = eoO();
          if ((localObject1 != null) && (!aGB((String)localObject1)))
          {
            localObject2 = this.zTM;
            if (localObject2 != null) {
              ((m)localObject2).aGz((String)localObject1);
            }
          }
        }
      }
      int k = ((ArrayList)localObject1).size();
      localObject2 = (List)new ArrayList();
      i = j;
      while (i < k)
      {
        a.ar localar = new a.ar();
        Object localObject3 = ((ArrayList)localObject1).get(i);
        kotlin.g.b.p.g(localObject3, "userList[i]");
        localar.qrD = ((Number)localObject3).intValue();
        ((List)localObject2).add(localar);
        i += 1;
      }
      ac.eom().fB((List)localObject2);
      AppMethodBeat.o(239867);
      return;
    }
  }
  
  public final void emw() {}
  
  public final void emx() {}
  
  public final void emy() {}
  
  public final void eoN()
  {
    AppMethodBeat.i(239857);
    if (this.zTM != null)
    {
      this.zTO = true;
      com.tencent.f.h.RTc.bqo("showIcon");
      com.tencent.f.h.RTc.aV((Runnable)new e(this));
      AppMethodBeat.o(239857);
      return;
    }
    rX(true);
    AppMethodBeat.o(239857);
  }
  
  public final void hh(int paramInt1, int paramInt2) {}
  
  public final void onError(int paramInt) {}
  
  public final void rX(boolean paramBoolean)
  {
    AppMethodBeat.i(239869);
    Log.i("MicroMsg.MultiTalkSmallWindow", "dismiss now.. isFinish: %b, smallView: %s", new Object[] { Boolean.valueOf(paramBoolean), this.zTM });
    Object localObject;
    if (this.zTM != null)
    {
      if (paramBoolean) {
        com.tencent.mm.plugin.voip.a.a.fFk().b((FrameLayout)this.zTM);
      }
      localObject = this.zTM;
      if (localObject != null) {
        ((m)localObject).setOnClickListener(null);
      }
      localObject = this.zTM;
      if (localObject != null) {
        ((m)localObject).uninit();
      }
      this.zTM = null;
      ac.eom().enm();
      ac.eoo().zLR = null;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).b((com.tencent.mm.plugin.ball.c.g)this.zTU);
      localObject = ac.eom();
      kotlin.g.b.p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
      ((q)localObject).enz().b((com.tencent.mm.plugin.multitalk.model.g)this);
      AppMethodBeat.o(239869);
      return;
      if (paramBoolean) {
        com.tencent.mm.plugin.voip.a.a.fFk().cir();
      }
    }
  }
  
  public final void rv(boolean paramBoolean) {}
  
  public final void rw(boolean paramBoolean) {}
  
  public final void rx(boolean paramBoolean) {}
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(239859);
    m localm = this.zTM;
    if (localm != null)
    {
      localm.setVoicePlayDevice(paramInt);
      AppMethodBeat.o(239859);
      return;
    }
    AppMethodBeat.o(239859);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow$floatBallViewListener$1", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallViewListenerAdapter;", "onBallPositionChanged", "", "x", "", "y", "height", "isSettled", "", "isDockLeft", "plugin-multitalk_release"})
  public static final class b
    extends com.tencent.mm.plugin.ball.c.h
  {
    public final void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(239842);
      super.a(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2);
      m localm = n.a(this.zTW);
      if (localm != null)
      {
        localm.rV(paramBoolean2);
        AppMethodBeat.o(239842);
        return;
      }
      AppMethodBeat.o(239842);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(n paramn, Intent paramIntent) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(239845);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow$mini$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView.setOnClickListener(null);
      paramIntent.addFlags(268435456);
      paramView = MMApplicationContext.getContext();
      localObject = paramIntent;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow$mini$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow$mini$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      n.a(this.zTW, new MTimerHandler((MTimerHandler.CallBack)new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(239843);
          Log.i("MicroMsg.MultiTalkSmallWindow", "click small view and time is up we remove it..");
          this.zTX.zTW.rX(false);
          MTimerHandler localMTimerHandler = n.c(this.zTX.zTW);
          if (localMTimerHandler != null) {
            localMTimerHandler.stopTimer();
          }
          AppMethodBeat.o(239843);
          return true;
        }
      }, false));
      paramView = n.c(this.zTW);
      if (paramView != null) {
        paramView.startTimer(2000L);
      }
      MMHandlerThread.postToMainThreadDelayed((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(239844);
          this.zTX.zTW.rX(false);
          AppMethodBeat.o(239844);
        }
      }, 200L);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow$mini$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(239845);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class d
    implements Runnable
  {
    public d(n paramn) {}
    
    public final void run()
    {
      AppMethodBeat.i(239847);
      com.tencent.f.h.RTc.aV((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(239846);
          if ((n.a(this.zTY.zTW) != null) && (!n.b(this.zTY.zTW)))
          {
            m localm = n.a(this.zTY.zTW);
            if (localm != null)
            {
              localm.xm(this.zTY.rti);
              AppMethodBeat.o(239846);
              return;
            }
          }
          AppMethodBeat.o(239846);
        }
      });
      AppMethodBeat.o(239847);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(n paramn) {}
    
    public final void run()
    {
      AppMethodBeat.i(239849);
      m localm = n.a(this.zTW);
      if (localm != null)
      {
        localm.eoK();
        com.tencent.f.h.RTc.n((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(239848);
            this.zTZ.zTW.rX(true);
            AppMethodBeat.o(239848);
          }
        }, 2000L);
        AppMethodBeat.o(239849);
        return;
      }
      AppMethodBeat.o(239849);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class f
    implements Runnable
  {
    public f(n paramn) {}
    
    public final void run()
    {
      AppMethodBeat.i(239851);
      com.tencent.f.h.RTc.aV((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(239850);
          if ((n.a(this.zUa.zTW) != null) && (!n.b(this.zUa.zTW)))
          {
            m localm = n.a(this.zUa.zTW);
            if (localm != null)
            {
              localm.enR();
              AppMethodBeat.o(239850);
              return;
            }
          }
          AppMethodBeat.o(239850);
        }
      });
      AppMethodBeat.o(239851);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(n paramn) {}
    
    public final void run()
    {
      AppMethodBeat.i(239852);
      m localm = n.a(this.zTW);
      if (localm != null)
      {
        localm.rT(true);
        AppMethodBeat.o(239852);
        return;
      }
      AppMethodBeat.o(239852);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(n paramn) {}
    
    public final void run()
    {
      AppMethodBeat.i(239853);
      m localm = n.a(this.zTW);
      if (localm != null)
      {
        q localq = ac.eom();
        kotlin.g.b.p.g(localq, "SubCoreMultiTalk.getMultiTalkManager()");
        localm.rU(localq.Zx());
        AppMethodBeat.o(239853);
        return;
      }
      AppMethodBeat.o(239853);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow$showMini$1", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog$OverlayPermissionResultCallBack;", "onResultAllow", "", "dialog", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog;", "onResultCancel", "onResultRefuse", "plugin-multitalk_release"})
  public static final class i
    implements RequestFloatWindowPermissionDialog.a
  {
    public i(com.tencent.mm.plugin.voip.ui.a parama, Intent paramIntent, boolean paramBoolean) {}
    
    public final void onResultAllow(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(239854);
      kotlin.g.b.p.h(paramRequestFloatWindowPermissionDialog, "dialog");
      paramRequestFloatWindowPermissionDialog.finish();
      if (this.zUb.dZV()) {
        n.a(this.zTW, this.gtH);
      }
      AppMethodBeat.o(239854);
    }
    
    public final void onResultCancel(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(239856);
      kotlin.g.b.p.h(paramRequestFloatWindowPermissionDialog, "dialog");
      paramRequestFloatWindowPermissionDialog.finish();
      AppMethodBeat.o(239856);
    }
    
    public final void onResultRefuse(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(239855);
      kotlin.g.b.p.h(paramRequestFloatWindowPermissionDialog, "dialog");
      paramRequestFloatWindowPermissionDialog.finish();
      AppMethodBeat.o(239855);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.n
 * JD-Core Version:    0.7.0.1
 */