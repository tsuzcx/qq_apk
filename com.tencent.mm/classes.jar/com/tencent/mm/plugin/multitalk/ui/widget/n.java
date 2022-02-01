package com.tencent.mm.plugin.multitalk.ui.widget;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.ae;
import com.tencent.mm.plugin.multitalk.model.e;
import com.tencent.mm.plugin.multitalk.model.u;
import com.tencent.mm.plugin.multitalk.model.u.a;
import com.tencent.mm.plugin.voip.c.a.a;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.pb.common.b.a.a.a.aq;
import com.tencent.pb.talkroom.sdk.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow;", "Lcom/tencent/mm/plugin/multitalk/model/IMultiTalkUICallback;", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTargetContainer;", "()V", "callBack", "Lcom/tencent/mm/plugin/voip/ui/IVoipMiniCallBack;", "currentMode", "", "floatBallViewListener", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallViewListenerAdapter;", "getFloatBallViewListener", "()Lcom/tencent/mm/plugin/ball/api/OnFloatBallViewListenerAdapter;", "setFloatBallViewListener", "(Lcom/tencent/mm/plugin/ball/api/OnFloatBallViewListenerAdapter;)V", "intent", "Landroid/content/Intent;", "isAllowToDoAnimation", "", "isHangup", "isNeedShowCameraStatus", "isNeedShowMuteStatus", "mBaseSmallView", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallView;", "mIsBeenSilent", "mTimerAfterClickAutoDismiss", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "mUIHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getMUIHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setMUIHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "subscribeVideoCacheList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "waitingRenderList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "checkRenderUserTalking", "userName", "checkSpeakerHasVideo", "dismiss", "", "isFinish", "doFavScreenShot", "path", "doSendToFriend", "drawVideo", "username", "bitmap", "Landroid/graphics/Bitmap;", "mirror", "angle", "engineDoMemberSelectForView", "memberIdList", "exitProjectScreen", "getLargeRenderTarget", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "ori", "getNormalRenderTarget", "wxUserName", "getOnlineUser", "speaker", "getRandomNum", "maxSize", "initCurrentMode", "isVideo", "isCameraOpen", "isMiniTalkingUiVisibility", "wxGroupId", "mini", "onBadNetTipShow", "show", "onCameraStartError", "onEnterMultiTalk", "onError", "errCode", "onExitMultiTalk", "onHangupHappened", "onILinkCancelSubscribeLargeVideo", "onMemberChange", "onMiniMultiTalk", "onMultiTalkStatusChange", "preStatus", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkStatus;", "currentStatus", "onMuteStateChange", "isMute", "onNetWorkChangeMobileNet", "onNetWorkCostMax", "onNetWorkStatusChange", "preNetWorkType", "Lcom/tencent/mm/plugin/multitalk/model/MultiTalkUtil$NetWorkType;", "currentNetWorkType", "onScreenFrame", "onSpeakerStateChange", "isSpeaker", "onStartRecordFailed", "onTimeSecondCallback", "onVideoGroupMemberChange", "onVideoStateChange", "preAction", "currentAciton", "peakSpeakerUserList", "randomPeakUser", "randomPeakUserWhileTalking", "list", "", "refreshMiniView", "renderVideo", "img", "", "imgW", "imgH", "setHandFreeEnable", "enable", "setVoicePlayDevice", "device", "showCameraStatus", "showMini", "showMuteStatus", "switchToVoiceOrVideo", "updateTime", "time", "updateVideoSubscribe", "Companion", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  implements e, com.tencent.mm.plugin.multitalk.model.g
{
  public static final n.a Lvv;
  private int LvA;
  public boolean LvB;
  boolean LvC;
  private ArrayList<Integer> LvD;
  private boolean LvE;
  private com.tencent.mm.plugin.ball.c.h LvF;
  public m Lvw;
  public com.tencent.mm.plugin.voip.ui.a Lvx;
  private boolean Lvy;
  private MTimerHandler Lvz;
  private MMHandler eqE;
  public Intent intent;
  
  static
  {
    AppMethodBeat.i(285659);
    Lvv = new n.a((byte)0);
    AppMethodBeat.o(285659);
  }
  
  public n()
  {
    AppMethodBeat.i(285469);
    this.LvA = 1;
    this.LvD = new ArrayList();
    this.LvF = ((com.tencent.mm.plugin.ball.c.h)new b(this));
    AppMethodBeat.o(285469);
  }
  
  private static final void a(Intent paramIntent, n paramn, View paramView)
  {
    AppMethodBeat.i(285623);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramIntent);
    localb.cH(paramn);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramIntent, "$intent");
    s.u(paramn, "this$0");
    paramView.setOnClickListener(null);
    paramIntent.addFlags(268435456);
    paramView = MMApplicationContext.getContext();
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramView, paramIntent.aYi(), "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow", "mini$lambda-18", "(Landroid/content/Intent;Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow", "mini$lambda-18", "(Landroid/content/Intent;Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramn.Lvz = new MTimerHandler(new n..ExternalSyntheticLambda1(paramn), false);
    paramIntent = paramn.Lvz;
    if (paramIntent != null) {
      paramIntent.startTimer(2000L);
    }
    MMHandlerThread.postToMainThreadDelayed(new n..ExternalSyntheticLambda8(paramn), 200L);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(285623);
  }
  
  private static final void a(n paramn)
  {
    AppMethodBeat.i(285528);
    s.u(paramn, "this$0");
    paramn.jb(true);
    AppMethodBeat.o(285528);
  }
  
  private static final void a(n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(285549);
    s.u(paramn, "this$0");
    if ((paramn.Lvw != null) && (!paramn.Lvy))
    {
      paramn = paramn.Lvw;
      if (paramn != null) {
        paramn.GH(paramBoolean);
      }
    }
    AppMethodBeat.o(285549);
  }
  
  private static final void b(n paramn)
  {
    int i = 1;
    AppMethodBeat.i(285537);
    s.u(paramn, "this$0");
    m localm = paramn.Lvw;
    if ((localm != null) && (localm.ghw() == true)) {}
    for (;;)
    {
      if (i != 0) {
        com.tencent.threadpool.h.ahAA.o(new n..ExternalSyntheticLambda5(paramn), 2000L);
      }
      AppMethodBeat.o(285537);
      return;
      i = 0;
    }
  }
  
  private static final void b(n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(285555);
    s.u(paramn, "this$0");
    com.tencent.threadpool.h.ahAA.bk(new n..ExternalSyntheticLambda10(paramn, paramBoolean));
    AppMethodBeat.o(285555);
  }
  
  private final void bc(ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(285494);
    if (this.LvD.isEmpty())
    {
      this.LvD.addAll((Collection)paramArrayList);
      AppMethodBeat.o(285494);
      return;
    }
    Object localObject = paramArrayList;
    if (paramArrayList.size() < 2 - this.LvD.size())
    {
      localObject = new ArrayList();
      Iterator localIterator = ((Iterable)this.LvD).iterator();
      while (localIterator.hasNext()) {
        ((ArrayList)localObject).add(Integer.valueOf(((Number)localIterator.next()).intValue()));
      }
      paramArrayList = ((Iterable)paramArrayList).iterator();
      while (paramArrayList.hasNext())
      {
        int i = ((Number)paramArrayList.next()).intValue();
        if (!((ArrayList)localObject).contains(Integer.valueOf(i))) {
          ((ArrayList)localObject).add(Integer.valueOf(i));
        }
      }
    }
    this.LvD = ((ArrayList)localObject);
    AppMethodBeat.o(285494);
  }
  
  private static int bd(ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(285504);
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      AppMethodBeat.o(285504);
      return -1;
    }
    int k = paramArrayList.size();
    int[] arrayOfInt = new int[k];
    StringBuilder localStringBuilder = new StringBuilder();
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      Object localObject = paramArrayList.get(i);
      s.s(localObject, "memberIdList[i]");
      int m = ((Number)localObject).intValue();
      localStringBuilder.append(m).append(",");
      arrayOfInt[i] = m;
      if (j >= k)
      {
        Log.i("MicroMsg.MultiTalkSmallWindow", "steve: engineDoMemberSelectForView: selected id list: %s", new Object[] { localStringBuilder.toString() });
        paramArrayList = ByteBuffer.allocate(k * 4);
        paramArrayList.order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put(arrayOfInt);
        paramArrayList = paramArrayList.array();
        i = ac.ggR().LnJ.setAppCmd(23, paramArrayList, k);
        if (i < 0)
        {
          Log.e("MicroMsg.MultiTalkSmallWindow", "steve:engineDoMemberSelectForView failed!!");
          com.tencent.mm.plugin.multitalk.model.o.gfI();
          AppMethodBeat.o(285504);
          return -1;
        }
        AppMethodBeat.o(285504);
        return i;
      }
    }
  }
  
  private static final void c(n paramn)
  {
    AppMethodBeat.i(285566);
    s.u(paramn, "this$0");
    if ((paramn.Lvw != null) && (!paramn.Lvy))
    {
      paramn = paramn.Lvw;
      if (paramn != null) {
        paramn.fwi();
      }
    }
    AppMethodBeat.o(285566);
  }
  
  private static final void d(n paramn)
  {
    AppMethodBeat.i(285573);
    s.u(paramn, "this$0");
    com.tencent.threadpool.h.ahAA.bk(new n..ExternalSyntheticLambda3(paramn));
    AppMethodBeat.o(285573);
  }
  
  private static final void e(n paramn)
  {
    AppMethodBeat.i(285578);
    s.u(paramn, "this$0");
    paramn = paramn.Lvw;
    if (paramn != null) {
      paramn.zk(true);
    }
    AppMethodBeat.o(285578);
  }
  
  private static final void f(n paramn)
  {
    AppMethodBeat.i(285591);
    s.u(paramn, "this$0");
    paramn = paramn.Lvw;
    if (paramn != null) {
      paramn.zl(ac.ggS().lAj);
    }
    AppMethodBeat.o(285591);
  }
  
  private static final boolean g(n paramn)
  {
    AppMethodBeat.i(285602);
    s.u(paramn, "this$0");
    Log.i("MicroMsg.MultiTalkSmallWindow", "click small view and time is up we remove it..");
    paramn.jb(false);
    paramn = paramn.Lvz;
    if (paramn != null) {
      paramn.stopTimer();
    }
    AppMethodBeat.o(285602);
    return true;
  }
  
  private final ArrayList<String> ghB()
  {
    AppMethodBeat.i(285518);
    Object localObject1 = this.Lvw;
    Object localObject2;
    label27:
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = ac.ggR();
      if (localObject2 != null) {
        break label119;
      }
      localObject2 = null;
      if (localObject2 != null) {
        break label274;
      }
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (!kotlin.n.n.bp((CharSequence)localObject2))) {
        break label127;
      }
      i = 1;
    }
    for (;;)
    {
      if (i == 0)
      {
        if (s.p(localObject1, z.bAM()))
        {
          if (ac.ggS().LoD != null)
          {
            ac.ggS();
            if (!com.tencent.mm.plugin.multitalk.b.b.gee())
            {
              Log.i("MicroMsg.MultiTalkSmallWindow", "check mute form local pcm recorder");
              localObject1 = kotlin.a.p.al(new String[] { localObject1 });
              AppMethodBeat.o(285518);
              return localObject1;
              localObject1 = ((m)localObject1).getRendererSpeaker();
              break;
              label119:
              localObject2 = ((com.tencent.mm.plugin.multitalk.model.n)localObject2).gfr();
              break label27;
              label127:
              i = 0;
              continue;
            }
          }
          if (!this.LvE)
          {
            this.LvE = true;
            localObject1 = kotlin.a.p.al(new String[] { localObject1 });
            AppMethodBeat.o(285518);
            return localObject1;
          }
          this.LvE = false;
          AppMethodBeat.o(285518);
          return null;
        }
        if (ac.ggR().gfq().contains(localObject1))
        {
          Log.i("MicroMsg.MultiTalkSmallWindow", "check mute form service status");
          localObject1 = kotlin.a.p.al(new String[] { localObject1 });
          AppMethodBeat.o(285518);
          return localObject1;
        }
        if (!this.LvE)
        {
          this.LvE = true;
          localObject1 = kotlin.a.p.al(new String[] { localObject1 });
          AppMethodBeat.o(285518);
          return localObject1;
        }
        this.LvE = false;
        AppMethodBeat.o(285518);
        return null;
      }
    }
    AppMethodBeat.o(285518);
    return null;
    label274:
    AppMethodBeat.o(285518);
    return localObject2;
  }
  
  private static final void h(n paramn)
  {
    AppMethodBeat.i(285610);
    s.u(paramn, "this$0");
    paramn.jb(false);
    AppMethodBeat.o(285610);
  }
  
  private void zn(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(285483);
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      if (this.LvA == 2)
      {
        localObject1 = this.Lvw;
        if (localObject1 != null)
        {
          ((m)localObject1).zj(true);
          AppMethodBeat.o(285483);
        }
      }
      else
      {
        this.LvA = 2;
        localObject1 = this.Lvw;
        if (localObject1 != null)
        {
          ((m)localObject1).etJ();
          AppMethodBeat.o(285483);
        }
      }
    }
    else if (this.LvA == 1)
    {
      localObject1 = this.Lvw;
      if (localObject1 != null)
      {
        ((m)localObject1).zj(false);
        AppMethodBeat.o(285483);
      }
    }
    else
    {
      this.LvA = 1;
      localObject1 = this.Lvw;
      if (localObject1 != null)
      {
        localObject2 = ((m)localObject1).Lvs;
        if (localObject2 != null)
        {
          localObject2 = ((j)localObject2).ght();
          if (localObject2 != null) {
            break label232;
          }
        }
        i = 0;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject2 = ((m)localObject1).Lvs;
        if (localObject2 != null)
        {
          ((j)localObject2).rootView.setAlpha(0.0F);
          ((j)localObject2).rootView.setVisibility(0);
          ((j)localObject2).rootView.clearAnimation();
          ((j)localObject2).rootView.animate().alpha(1.0F).setDuration(300L).setListener((Animator.AnimatorListener)new j.b((j)localObject2)).start();
        }
        localObject1 = ((m)localObject1).Lvt;
        if (localObject1 != null) {
          ((i)localObject1).abR(4);
        }
      }
      AppMethodBeat.o(285483);
      return;
      label232:
      if (((Integer)localObject2).intValue() != 0) {
        break;
      }
    }
  }
  
  public final void a(u.a parama) {}
  
  public final void a(o paramo) {}
  
  public final com.tencent.mm.plugin.multitalk.model.f aMH(String paramString)
  {
    AppMethodBeat.i(285914);
    s.u(paramString, "wxUserName");
    m localm = this.Lvw;
    int i;
    if (localm != null) {
      if ((TextUtils.isEmpty((CharSequence)localm.getUsername())) || (s.p(localm.getUsername(), paramString)))
      {
        i = 1;
        if (i == 0) {
          break label72;
        }
      }
    }
    label72:
    for (paramString = localm;; paramString = null)
    {
      paramString = (com.tencent.mm.plugin.multitalk.model.f)paramString;
      AppMethodBeat.o(285914);
      return paramString;
      i = 0;
      break;
    }
  }
  
  public final void aMZ(String paramString) {}
  
  public final void aNa(String paramString) {}
  
  public final com.tencent.mm.plugin.multitalk.model.f abB(int paramInt)
  {
    return null;
  }
  
  public final void bh(Intent paramIntent)
  {
    AppMethodBeat.i(286084);
    Log.i("MicroMsg.MultiTalkSmallWindow", "mini now..");
    if (this.Lvw != null) {
      jb(false);
    }
    if (this.Lvw == null)
    {
      localObject = MMApplicationContext.getContext();
      s.s(localObject, "getContext()");
      this.Lvw = new m((Context)localObject);
      this.Lvy = false;
    }
    Object localObject = this.Lvw;
    if (localObject != null) {
      ((m)localObject).zk(ac.ggU().bsA());
    }
    localObject = this.Lvw;
    if (localObject != null) {
      ((m)localObject).zl(ac.ggS().lAj);
    }
    localObject = this.Lvw;
    if (localObject != null) {
      ((m)localObject).zm(((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class)).cXP());
    }
    this.eqE = new MMHandler();
    ac.ggS().Lnt = ((e)this);
    ac.ggU().Lnt = ((e)this);
    localObject = this.Lvz;
    if (localObject != null) {
      ((MTimerHandler)localObject).stopTimer();
    }
    localObject = this.Lvw;
    if (localObject != null) {
      ((m)localObject).setOnClickListener(new n..ExternalSyntheticLambda0(paramIntent, this));
    }
    a.a.Uvh.a(8, true, (View)this.Lvw);
    ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class)).a((com.tencent.mm.plugin.ball.c.g)this.LvF);
    ac.ggR().LnR = new HashMap();
    this.LvA = 1;
    zn(false);
    localObject = this.Lvx;
    s.checkNotNull(localObject);
    ((com.tencent.mm.plugin.voip.ui.a)localObject).a(paramIntent, (BaseSmallView)this.Lvw);
    paramIntent = ac.ggS().ggf();
    s.s(paramIntent, "");
    ae.a(paramIntent);
    paramIntent.a((com.tencent.mm.plugin.multitalk.model.g)this);
    AppMethodBeat.o(286084);
  }
  
  public final boolean bsA()
  {
    AppMethodBeat.i(285938);
    boolean bool = ac.ggU().bsA();
    AppMethodBeat.o(285938);
    return bool;
  }
  
  public final void fQN() {}
  
  public final void fQY() {}
  
  public final void fQZ()
  {
    AppMethodBeat.i(285875);
    if (u.abK(ac.ggS().Lod))
    {
      localObject1 = this.eqE;
      if (localObject1 != null) {
        ((MMHandler)localObject1).post(new n..ExternalSyntheticLambda7(this));
      }
    }
    Object localObject1 = this.eqE;
    if (localObject1 != null) {
      ((MMHandler)localObject1).post(new n..ExternalSyntheticLambda4(this));
    }
    if (ac.ggS().gfW()) {
      ac.ggS().ggr();
    }
    Object localObject3 = ghB();
    Object localObject2;
    if (localObject3 == null)
    {
      localObject1 = null;
      localObject2 = this.Lvw;
      if (localObject2 != null) {
        break label342;
      }
      localObject2 = null;
      label111:
      if (!s.p(localObject1, localObject2)) {
        break label357;
      }
      localObject1 = this.Lvw;
      if (localObject1 != null)
      {
        localObject2 = ((m)localObject1).Lvt;
        if (localObject2 != null) {
          ((i)localObject2).LuW = Long.valueOf(Util.currentTicks());
        }
        localObject2 = ((m)localObject1).Lvt;
        if ((localObject2 == null) || (((i)localObject2).LuT != true)) {
          break label352;
        }
        i = 1;
        label178:
        if (i == 0)
        {
          localObject2 = ((m)localObject1).Lvt;
          if (localObject2 != null) {
            ((i)localObject2).aNC(((m)localObject1).getRendererSpeaker());
          }
        }
      }
      label205:
      ac.ggU().gfj();
      localObject1 = new ArrayList();
      localObject2 = (Collection)localObject3;
      if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
        break label431;
      }
    }
    label431:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || (((ArrayList)localObject3).size() - 1 <= 0)) {
        break label436;
      }
      localObject2 = ((ArrayList)localObject3).subList(1, ((ArrayList)localObject3).size());
      s.s(localObject2, "speakers.subList(startIndex,speakers.size)");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add(Integer.valueOf(com.tencent.mm.plugin.multitalk.e.f.aNL((String)((Iterator)localObject2).next())));
      }
      localObject1 = (String)kotlin.a.p.oK((List)localObject3);
      break;
      label342:
      localObject2 = ((m)localObject2).getRendererSpeaker();
      break label111;
      label352:
      i = 0;
      break label178;
      label357:
      if (localObject1 == null)
      {
        localObject1 = this.Lvw;
        if (localObject1 != null) {
          ((m)localObject1).aNH(null);
        }
        zn(false);
        break label205;
      }
      localObject2 = this.Lvw;
      if (localObject2 != null) {
        ((m)localObject2).aNH((String)localObject1);
      }
      localObject2 = this.Lvw;
      if (localObject2 != null) {
        ((m)localObject2).aNG((String)localObject1);
      }
      zn(true);
      break label205;
    }
    label436:
    if (((Collection)localObject1).isEmpty())
    {
      i = 1;
      if (i != 0) {
        break label673;
      }
      bc((ArrayList)localObject1);
      boolean bool = ac.ggS().gfV();
      if (!bool) {
        bd(this.LvD);
      }
      if (!bool) {
        break label579;
      }
      if (this.LvD.size() != 1) {
        break label566;
      }
      com.tencent.mm.plugin.multitalk.c.o.Ljn.z((Integer)kotlin.a.p.oK((List)this.LvD));
    }
    for (;;)
    {
      Log.i("MicroMsg.MultiTalkSmallWindow", "ilink subscribeByUserMids ok, mids:" + localObject1 + " and subscribe one is " + this.LvD);
      AppMethodBeat.o(285875);
      return;
      i = 0;
      break;
      label566:
      com.tencent.mm.plugin.multitalk.c.o.Ljn.ba(this.LvD);
    }
    label579:
    int k = this.LvD.size();
    localObject1 = (List)new ArrayList();
    if (k > 0) {}
    int j;
    for (i = 0;; i = j)
    {
      j = i + 1;
      localObject2 = new a.aq();
      localObject3 = this.LvD.get(i);
      s.s(localObject3, "subscribeVideoCacheList[i]");
      ((a.aq)localObject2).wTC = ((Number)localObject3).intValue();
      ((List)localObject1).add(localObject2);
      if (j >= k)
      {
        ac.ggS().ja((List)localObject1);
        label673:
        AppMethodBeat.o(285875);
        return;
      }
    }
  }
  
  public final void fwi()
  {
    AppMethodBeat.i(285833);
    if ((this.Lvw != null) && (!this.Lvy))
    {
      com.tencent.threadpool.h.ahAA.bFQ("showIcon");
      com.tencent.threadpool.h.ahAA.g(new n..ExternalSyntheticLambda2(this), "showIcon");
    }
    AppMethodBeat.o(285833);
  }
  
  public final void fwx() {}
  
  public final void gau() {}
  
  public final void geI() {}
  
  public final void geY()
  {
    AppMethodBeat.i(285989);
    ghz();
    AppMethodBeat.o(285989);
  }
  
  public final void geZ() {}
  
  public final void gfa()
  {
    int j = 1;
    AppMethodBeat.i(286005);
    Log.i("MicroMsg.MultiTalkSmallWindow", s.X("onVideoGroupMemberChange, SubCoreMultiTalk.getMultiTalkManager().getCurrentVideoUserSet().size(): ", Integer.valueOf(ac.ggS().Loj.size())));
    if (ac.ggS().gfW()) {
      if (!ac.ggS().Loj.contains(z.bAM())) {
        break label319;
      }
    }
    label189:
    label317:
    label319:
    for (int i = 1;; i = 0)
    {
      Object localObject1;
      Object localObject2;
      if (ac.ggS().Loj.size() > i)
      {
        ac.ggS().ggr();
        localObject1 = this.Lvw;
        if (localObject1 != null)
        {
          if (!s.p(((m)localObject1).getRendererSpeaker(), ""))
          {
            zn(true);
            localObject1 = this.Lvw;
            if (localObject1 != null) {
              ((m)localObject1).etJ();
            }
          }
          AppMethodBeat.o(286005);
        }
      }
      else
      {
        ac.ggS().ggs();
        localObject1 = this.Lvw;
        if (localObject1 != null)
        {
          if (s.p(((m)localObject1).getRendererSpeaker(), "")) {
            break label189;
          }
          localObject2 = this.Lvw;
          if (localObject2 != null) {
            ((m)localObject2).aNG(((m)localObject1).getRendererSpeaker());
          }
        }
      }
      for (;;)
      {
        ghB();
        zn(false);
        AppMethodBeat.o(286005);
        return;
        localObject1 = ghB();
        if (localObject1 == null)
        {
          localObject1 = null;
          label200:
          if (localObject1 == null) {
            break label306;
          }
          localObject2 = ac.ggS().Loj;
          s.s(localObject2, "getMultiTalkManager().currentVideoUserSet");
          Iterator localIterator = ((Iterable)localObject2).iterator();
          while (localIterator.hasNext())
          {
            localObject2 = localIterator.next();
            if (s.p((String)localObject2, localObject1)) {
              if (localObject2 == null) {
                break label314;
              }
            }
          }
        }
        for (i = j;; i = 0)
        {
          if (i != 0) {
            break label317;
          }
          localObject2 = this.Lvw;
          if (localObject2 == null) {
            break;
          }
          ((m)localObject2).aNG((String)localObject1);
          break;
          localObject1 = (String)kotlin.a.p.oK((List)localObject1);
          break label200;
          break;
          localObject2 = null;
          break label263;
        }
      }
    }
  }
  
  public final void gfb() {}
  
  public final void gfc() {}
  
  public final void gfd() {}
  
  public final void ghA()
  {
    AppMethodBeat.i(285818);
    if ((this.Lvw != null) && (!this.Lvy))
    {
      com.tencent.threadpool.h.ahAA.bFQ("showIcon");
      com.tencent.threadpool.h.ahAA.g(new n..ExternalSyntheticLambda9(this, true), "showIcon");
    }
    AppMethodBeat.o(285818);
  }
  
  public final void ghz()
  {
    AppMethodBeat.i(285809);
    if (this.Lvw != null)
    {
      this.Lvy = true;
      com.tencent.threadpool.h.ahAA.bFQ("showIcon");
      com.tencent.threadpool.h.ahAA.bk(new n..ExternalSyntheticLambda6(this));
      AppMethodBeat.o(285809);
      return;
    }
    jb(true);
    AppMethodBeat.o(285809);
  }
  
  public final void jQ(int paramInt1, int paramInt2) {}
  
  public final void jb(boolean paramBoolean)
  {
    AppMethodBeat.i(286106);
    Log.i("MicroMsg.MultiTalkSmallWindow", "dismiss now.. isFinish: %b, smallView: %s", new Object[] { Boolean.valueOf(paramBoolean), this.Lvw });
    if (this.Lvw != null)
    {
      if (paramBoolean) {
        a.a.Uvh.b((FrameLayout)this.Lvw);
      }
      m localm = this.Lvw;
      if (localm != null) {
        localm.setOnClickListener(null);
      }
      localm = this.Lvw;
      if (localm != null) {
        localm.uninit();
      }
      this.Lvw = null;
      ac.ggS().Lnt = null;
      ac.ggU().Lnt = null;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class)).b((com.tencent.mm.plugin.ball.c.g)this.LvF);
      ac.ggS().ggf().b((com.tencent.mm.plugin.multitalk.model.g)this);
      AppMethodBeat.o(286106);
      return;
      if (paramBoolean) {
        a.a.Uvh.cYp();
      }
    }
  }
  
  public final void oc(int paramInt) {}
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(285841);
    m localm = this.Lvw;
    if (localm != null) {
      localm.setVoicePlayDevice(paramInt);
    }
    AppMethodBeat.o(285841);
  }
  
  public final void yN(boolean paramBoolean) {}
  
  public final void yO(boolean paramBoolean) {}
  
  public final void yP(boolean paramBoolean) {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow$floatBallViewListener$1", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallViewListenerAdapter;", "onBallPositionChanged", "", "x", "", "y", "height", "isSettled", "", "isDockLeft", "collapseState", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends com.tencent.mm.plugin.ball.c.h
  {
    b(n paramn) {}
    
    public final void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4)
    {
      AppMethodBeat.i(285491);
      super.a(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2, paramInt4);
      m localm = n.i(this.LvG);
      if (localm != null) {
        localm.zm(paramBoolean2);
      }
      AppMethodBeat.o(285491);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow$showMini$1", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog$OverlayPermissionResultCallBack;", "onResultAllow", "", "dialog", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog;", "onResultCancel", "onResultRefuse", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements RequestFloatWindowPermissionDialog.a
  {
    public c(com.tencent.mm.plugin.voip.ui.a parama, n paramn, Intent paramIntent, boolean paramBoolean) {}
    
    public final void a(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(285489);
      s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      paramRequestFloatWindowPermissionDialog.finish();
      this.LvH.fQT();
      if (this.LvH.fQS()) {
        n.a(this.LvG, this.odM);
      }
      AppMethodBeat.o(285489);
    }
    
    public final void b(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(285495);
      s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      this.LvH.fQU();
      paramRequestFloatWindowPermissionDialog.finish();
      AppMethodBeat.o(285495);
    }
    
    public final void c(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(285499);
      s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      this.LvH.fQU();
      paramRequestFloatWindowPermissionDialog.finish();
      AppMethodBeat.o(285499);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.n
 * JD-Core Version:    0.7.0.1
 */