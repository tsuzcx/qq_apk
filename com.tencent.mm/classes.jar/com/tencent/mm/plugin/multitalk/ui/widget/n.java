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
import com.tencent.mm.plugin.multitalk.model.ad;
import com.tencent.mm.plugin.multitalk.model.af;
import com.tencent.mm.plugin.multitalk.model.f;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.multitalk.model.v.a;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.pb.common.b.a.a.a.aq;
import com.tencent.pb.talkroom.sdk.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow;", "Lcom/tencent/mm/plugin/multitalk/model/IMultiTalkUICallback;", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTargetContainer;", "()V", "callBack", "Lcom/tencent/mm/plugin/voip/ui/IVoipMiniCallBack;", "currentMode", "", "floatBallViewListener", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallViewListenerAdapter;", "getFloatBallViewListener", "()Lcom/tencent/mm/plugin/ball/api/OnFloatBallViewListenerAdapter;", "setFloatBallViewListener", "(Lcom/tencent/mm/plugin/ball/api/OnFloatBallViewListenerAdapter;)V", "intent", "Landroid/content/Intent;", "isAllowToDoAnimation", "", "isHangup", "isNeedShowCameraStatus", "isNeedShowMuteStatus", "mBaseSmallView", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallView;", "mIsBeenSilent", "mTimerAfterClickAutoDismiss", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "mUIHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getMUIHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setMUIHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "subscribeVideoCacheList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "waitingRenderList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "checkRenderUserTalking", "userName", "checkSpeakerHasVideo", "dismiss", "", "isFinish", "doFavScreenShot", "path", "doSendToFriend", "drawVideo", "username", "bitmap", "Landroid/graphics/Bitmap;", "mirror", "angle", "engineDoMemberSelectForView", "memberIdList", "exitProjectScreen", "getLargeRenderTarget", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "ori", "getNormalRenderTarget", "wxUserName", "getOnlineUser", "speaker", "getRandomNum", "maxSize", "initCurrentMode", "isVideo", "isCameraOpen", "isMiniTalkingUiVisibility", "wxGroupId", "mini", "onBadNetTipShow", "show", "onCameraStartError", "onEnterMultiTalk", "onError", "errCode", "onExitMultiTalk", "onHangupHappened", "onILinkCancelSubscribeLargeVideo", "onMemberChange", "onMiniMultiTalk", "onMultiTalkStatusChange", "preStatus", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkStatus;", "currentStatus", "onMuteStateChange", "isMute", "onNetWorkChangeMobileNet", "onNetWorkCostMax", "onNetWorkStatusChange", "preNetWorkType", "Lcom/tencent/mm/plugin/multitalk/model/MultiTalkUtil$NetWorkType;", "currentNetWorkType", "onScreenFrame", "onSpeakerStateChange", "isSpeaker", "onStartRecordFailed", "onTimeSecondCallback", "onVideoGroupMemberChange", "onVideoStateChange", "preAction", "currentAciton", "peakSpeakerUserList", "randomPeakUser", "randomPeakUserWhileTalking", "list", "", "refreshMiniView", "renderVideo", "img", "", "imgW", "imgH", "setHandFreeEnable", "enable", "setVoicePlayDevice", "device", "showCameraStatus", "showMini", "showMuteStatus", "switchToVoiceOrVideo", "updateTime", "time", "updateVideoSubscribe", "Companion", "plugin-multitalk_release"})
public final class n
  implements com.tencent.mm.plugin.multitalk.model.e, com.tencent.mm.plugin.multitalk.model.g
{
  public static final n.a Fzy;
  public m Fzo;
  public com.tencent.mm.plugin.voip.ui.a Fzp;
  public boolean Fzq;
  private MTimerHandler Fzr;
  private int Fzs;
  boolean Fzt;
  boolean Fzu;
  private ArrayList<Integer> Fzv;
  private boolean Fzw;
  private com.tencent.mm.plugin.ball.c.h Fzx;
  private MMHandler cyl;
  public Intent intent;
  
  static
  {
    AppMethodBeat.i(196758);
    Fzy = new n.a((byte)0);
    AppMethodBeat.o(196758);
  }
  
  public n()
  {
    AppMethodBeat.i(196756);
    this.Fzs = 1;
    this.Fzv = new ArrayList();
    this.Fzx = ((com.tencent.mm.plugin.ball.c.h)new b(this));
    AppMethodBeat.o(196756);
  }
  
  private final void aI(ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(196702);
    if (this.Fzv.isEmpty())
    {
      this.Fzv.addAll((Collection)paramArrayList);
      AppMethodBeat.o(196702);
      return;
    }
    Object localObject = paramArrayList;
    if (paramArrayList.size() < 2 - this.Fzv.size())
    {
      localObject = new ArrayList();
      Iterator localIterator = ((Iterable)this.Fzv).iterator();
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
    this.Fzv = ((ArrayList)localObject);
    AppMethodBeat.o(196702);
  }
  
  private static int aJ(ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(196706);
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      AppMethodBeat.o(196706);
      return -1;
    }
    int j = paramArrayList.size();
    Object localObject1 = new int[j];
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < j)
    {
      Object localObject2 = paramArrayList.get(i);
      kotlin.g.b.p.j(localObject2, "memberIdList[i]");
      int k = ((Number)localObject2).intValue();
      localStringBuilder.append(k).append(",");
      localObject1[i] = k;
      i += 1;
    }
    Log.i("MicroMsg.MultiTalkSmallWindow", "steve: engineDoMemberSelectForView: selected id list: %s", new Object[] { localStringBuilder.toString() });
    paramArrayList = ByteBuffer.allocate(j * 4);
    paramArrayList.order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put((int[])localObject1);
    paramArrayList = paramArrayList.array();
    localObject1 = ad.eYb();
    kotlin.g.b.p.j(localObject1, "SubCoreMultiTalk.getMultiEngine()");
    i = ((com.tencent.mm.plugin.multitalk.model.o)localObject1).eWv().setAppCmd(23, paramArrayList, j);
    if (i < 0)
    {
      Log.e("MicroMsg.MultiTalkSmallWindow", "steve:engineDoMemberSelectForView failed!!");
      com.tencent.mm.plugin.multitalk.model.p.eWO();
      AppMethodBeat.o(196706);
      return -1;
    }
    AppMethodBeat.o(196706);
    return i;
  }
  
  private static boolean aQQ(String paramString)
  {
    AppMethodBeat.i(196715);
    Object localObject = ad.eYc();
    kotlin.g.b.p.j(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
    localObject = ((q)localObject).eXf();
    kotlin.g.b.p.j(localObject, "SubCoreMultiTalk.getMult…ger().currentVideoUserSet");
    Iterator localIterator = ((Iterable)localObject).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!kotlin.g.b.p.h((String)localObject, paramString));
    for (paramString = (String)localObject; paramString != null; paramString = null)
    {
      AppMethodBeat.o(196715);
      return true;
    }
    AppMethodBeat.o(196715);
    return false;
  }
  
  private final ArrayList<String> eYF()
  {
    Object localObject2 = null;
    AppMethodBeat.i(196710);
    Object localObject1 = this.Fzo;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((m)localObject1).getRendererSpeaker();
      localObject3 = ad.eYb();
      if (localObject3 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.multitalk.model.o)localObject3).eWy();
        if (localObject3 != null) {
          break label262;
        }
      }
      localObject3 = (CharSequence)localObject1;
      if ((localObject3 != null) && (!kotlin.n.n.ba((CharSequence)localObject3))) {
        break label123;
      }
    }
    label123:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label265;
      }
      if (!kotlin.g.b.p.h(localObject1, z.bcZ())) {
        break label173;
      }
      ad.eYc();
      if (com.tencent.mm.plugin.multitalk.a.b.eVn()) {
        break label128;
      }
      Log.i("MicroMsg.MultiTalkSmallWindow", "check mute form local pcm recorder");
      localObject1 = kotlin.a.j.ag(new String[] { localObject1 });
      AppMethodBeat.o(196710);
      return localObject1;
      localObject1 = null;
      break;
    }
    label128:
    if (!this.Fzw)
    {
      this.Fzw = true;
      localObject1 = kotlin.a.j.ag(new String[] { localObject1 });
      AppMethodBeat.o(196710);
      return localObject1;
    }
    this.Fzw = false;
    AppMethodBeat.o(196710);
    return null;
    label173:
    if (ad.eYb().eWw().contains(localObject1))
    {
      Log.i("MicroMsg.MultiTalkSmallWindow", "check mute form service status");
      localObject1 = kotlin.a.j.ag(new String[] { localObject1 });
      AppMethodBeat.o(196710);
      return localObject1;
    }
    if (!this.Fzw)
    {
      this.Fzw = true;
      localObject1 = kotlin.a.j.ag(new String[] { localObject1 });
      AppMethodBeat.o(196710);
      return localObject1;
    }
    this.Fzw = false;
    AppMethodBeat.o(196710);
    return null;
    label262:
    localObject2 = localObject3;
    label265:
    AppMethodBeat.o(196710);
    return localObject2;
  }
  
  private void uZ(boolean paramBoolean)
  {
    AppMethodBeat.i(196691);
    Object localObject;
    if (paramBoolean)
    {
      if (this.Fzs == 2)
      {
        localObject = this.Fzo;
        if (localObject != null)
        {
          ((m)localObject).uV(true);
          AppMethodBeat.o(196691);
          return;
        }
        AppMethodBeat.o(196691);
        return;
      }
      this.Fzs = 2;
      localObject = this.Fzo;
      if (localObject != null)
      {
        ((m)localObject).dDz();
        AppMethodBeat.o(196691);
        return;
      }
      AppMethodBeat.o(196691);
      return;
    }
    if (this.Fzs == 1)
    {
      localObject = this.Fzo;
      if (localObject != null)
      {
        ((m)localObject).uV(false);
        AppMethodBeat.o(196691);
        return;
      }
      AppMethodBeat.o(196691);
      return;
    }
    this.Fzs = 1;
    m localm = this.Fzo;
    if (localm != null)
    {
      localObject = localm.Fzk;
      if (localObject != null)
      {
        localObject = ((j)localObject).eYy();
        if (localObject != null) {
          break label238;
        }
      }
      label238:
      while (((Integer)localObject).intValue() != 0)
      {
        localObject = localm.Fzk;
        if (localObject != null)
        {
          ((j)localObject).oFW.setAlpha(0.0F);
          ((j)localObject).oFW.setVisibility(0);
          ((j)localObject).oFW.clearAnimation();
          ((j)localObject).oFW.animate().alpha(1.0F).setDuration(300L).setListener((Animator.AnimatorListener)new j.b((j)localObject)).start();
        }
        localObject = localm.Fzl;
        if (localObject == null) {
          break label245;
        }
        ((i)localObject).XH(4);
        AppMethodBeat.o(196691);
        return;
        localObject = null;
        break;
      }
      label245:
      AppMethodBeat.o(196691);
      return;
    }
    AppMethodBeat.o(196691);
  }
  
  public final f Xq(int paramInt)
  {
    return null;
  }
  
  public final void a(v.a parama) {}
  
  public final void a(o paramo) {}
  
  public final void aK(final Intent paramIntent)
  {
    AppMethodBeat.i(196748);
    Log.i("MicroMsg.MultiTalkSmallWindow", "mini now..");
    if (this.Fzo != null) {
      ic(false);
    }
    if (this.Fzo == null)
    {
      localObject1 = MMApplicationContext.getContext();
      kotlin.g.b.p.j(localObject1, "MMApplicationContext.getContext()");
      this.Fzo = new m((Context)localObject1);
      this.Fzq = false;
    }
    Object localObject1 = this.Fzo;
    if (localObject1 != null) {
      ((m)localObject1).uW(ad.eYe().aXN());
    }
    localObject1 = this.Fzo;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ad.eYc();
      kotlin.g.b.p.j(localObject2, "SubCoreMultiTalk.getMultiTalkManager()");
      ((m)localObject1).uX(((q)localObject2).aeg());
    }
    localObject1 = this.Fzo;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class);
      kotlin.g.b.p.j(localObject2, "MMKernel.service(IFloatBallService::class.java)");
      ((m)localObject1).uY(((com.tencent.mm.plugin.ball.c.b)localObject2).cvf());
    }
    this.cyl = new MMHandler();
    ad.eYc().a((com.tencent.mm.plugin.multitalk.model.e)this);
    ad.eYe().Fri = ((com.tencent.mm.plugin.multitalk.model.e)this);
    localObject1 = this.Fzr;
    if (localObject1 != null) {
      ((MTimerHandler)localObject1).stopTimer();
    }
    localObject1 = this.Fzo;
    if (localObject1 != null) {
      ((m)localObject1).setOnClickListener((View.OnClickListener)new c(this, paramIntent));
    }
    com.tencent.mm.plugin.voip.a.a.gxw().a(8, true, (View)this.Fzo);
    ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class)).a((com.tencent.mm.plugin.ball.c.g)this.Fzx);
    ad.eYb().eWx();
    this.Fzs = 1;
    uZ(false);
    localObject1 = this.Fzp;
    if (localObject1 == null) {
      kotlin.g.b.p.iCn();
    }
    ((com.tencent.mm.plugin.voip.ui.a)localObject1).a(paramIntent, (BaseSmallView)this.Fzo);
    paramIntent = ad.eYc();
    kotlin.g.b.p.j(paramIntent, "SubCoreMultiTalk.getMultiTalkManager()");
    paramIntent = paramIntent.eXp();
    af.a(paramIntent);
    paramIntent.a((com.tencent.mm.plugin.multitalk.model.g)this);
    AppMethodBeat.o(196748);
  }
  
  public final f aPM(String paramString)
  {
    AppMethodBeat.i(196719);
    kotlin.g.b.p.k(paramString, "wxUserName");
    m localm = this.Fzo;
    int i;
    if (localm != null) {
      if ((TextUtils.isEmpty((CharSequence)localm.getUsername())) || (kotlin.g.b.p.h(localm.getUsername(), paramString)))
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
      AppMethodBeat.o(196719);
      return paramString;
      i = 0;
      break;
      label72:
      paramString = null;
      continue;
      paramString = null;
    }
  }
  
  public final void aQe(String paramString) {}
  
  public final void aQf(String paramString) {}
  
  public final boolean aXN()
  {
    return false;
  }
  
  public final void eIN() {}
  
  public final void eIO() {}
  
  public final void eIX() {}
  
  public final void eIY()
  {
    AppMethodBeat.i(196701);
    Object localObject1 = ad.eYc();
    kotlin.g.b.p.j(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    if (((q)localObject1).eXc())
    {
      localObject1 = this.cyl;
      if (localObject1 != null) {
        ((MMHandler)localObject1).post((Runnable)new g(this));
      }
    }
    localObject1 = this.cyl;
    if (localObject1 != null) {
      ((MMHandler)localObject1).post((Runnable)new h(this));
    }
    localObject1 = ad.eYc();
    kotlin.g.b.p.j(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    if (((q)localObject1).eXh()) {
      ad.eYc().eXB();
    }
    Object localObject3 = eYF();
    Object localObject2;
    if (localObject3 != null)
    {
      localObject1 = (String)kotlin.a.j.lo((List)localObject3);
      localObject2 = this.Fzo;
      if (localObject2 == null) {
        break label367;
      }
      localObject2 = ((m)localObject2).getRendererSpeaker();
      label152:
      if (!kotlin.g.b.p.h(localObject1, localObject2)) {
        break label373;
      }
      localObject1 = this.Fzo;
      if (localObject1 != null)
      {
        localObject2 = ((m)localObject1).Fzl;
        if (localObject2 != null) {
          ((i)localObject2).FyK = Long.valueOf(Util.currentTicks());
        }
        localObject2 = ((m)localObject1).Fzl;
        if ((localObject2 == null) || (((i)localObject2).FyH != true))
        {
          localObject2 = ((m)localObject1).Fzl;
          if (localObject2 != null) {
            ((i)localObject2).aQJ(((m)localObject1).getRendererSpeaker());
          }
        }
      }
      label240:
      ad.eYe().eWs();
      localObject1 = new ArrayList();
      localObject2 = (Collection)localObject3;
      if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
        break label447;
      }
    }
    label447:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || (((ArrayList)localObject3).size() - 1 <= 0)) {
        break label452;
      }
      localObject2 = ((ArrayList)localObject3).subList(1, ((ArrayList)localObject3).size());
      kotlin.g.b.p.j(localObject2, "speakers.subList(startIndex,speakers.size)");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add(Integer.valueOf(com.tencent.mm.plugin.multitalk.d.e.aQT((String)((Iterator)localObject2).next())));
      }
      localObject1 = null;
      break;
      label367:
      localObject2 = null;
      break label152;
      label373:
      if (localObject1 == null)
      {
        localObject1 = this.Fzo;
        if (localObject1 != null) {
          ((m)localObject1).aQP(null);
        }
        uZ(false);
        break label240;
      }
      localObject2 = this.Fzo;
      if (localObject2 != null) {
        ((m)localObject2).aQP((String)localObject1);
      }
      localObject2 = this.Fzo;
      if (localObject2 != null) {
        ((m)localObject2).aQO((String)localObject1);
      }
      uZ(true);
      break label240;
    }
    label452:
    if (((Collection)localObject1).isEmpty())
    {
      i = 1;
      if (i != 0) {
        break label697;
      }
      aI((ArrayList)localObject1);
      localObject2 = ad.eYc();
      kotlin.g.b.p.j(localObject2, "SubCoreMultiTalk.getMultiTalkManager()");
      boolean bool = ((q)localObject2).eXg();
      if (!bool) {
        aJ(this.Fzv);
      }
      if (!bool) {
        break label604;
      }
      if (this.Fzv.size() != 1) {
        break label591;
      }
      com.tencent.mm.plugin.multitalk.b.o.Fne.s((Integer)kotlin.a.j.lo((List)this.Fzv));
    }
    for (;;)
    {
      Log.i("MicroMsg.MultiTalkSmallWindow", "ilink subscribeByUserMids ok, mids:" + localObject1 + " and subscribe one is " + this.Fzv);
      AppMethodBeat.o(196701);
      return;
      i = 0;
      break;
      label591:
      com.tencent.mm.plugin.multitalk.b.o.Fne.aG(this.Fzv);
    }
    label604:
    int j = this.Fzv.size();
    localObject1 = (List)new ArrayList();
    i = 0;
    while (i < j)
    {
      localObject2 = new a.aq();
      localObject3 = this.Fzv.get(i);
      kotlin.g.b.p.j(localObject3, "subscribeVideoCacheList[i]");
      ((a.aq)localObject2).tQm = ((Number)localObject3).intValue();
      ((List)localObject1).add(localObject2);
      i += 1;
    }
    ad.eYc().gd((List)localObject1);
    label697:
    AppMethodBeat.o(196701);
  }
  
  public final void eRL() {}
  
  public final void eVR() {}
  
  public final void eWh()
  {
    AppMethodBeat.i(196727);
    eYE();
    AppMethodBeat.o(196727);
  }
  
  public final void eWi() {}
  
  public final void eWj()
  {
    AppMethodBeat.i(196736);
    Object localObject1 = new StringBuilder("onVideoGroupMemberChange, SubCoreMultiTalk.getMultiTalkManager().getCurrentVideoUserSet().size(): ");
    Object localObject2 = ad.eYc();
    kotlin.g.b.p.j(localObject2, "SubCoreMultiTalk.getMultiTalkManager()");
    Log.i("MicroMsg.MultiTalkSmallWindow", ((q)localObject2).eXf().size());
    localObject1 = ad.eYc();
    kotlin.g.b.p.j(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    if (((q)localObject1).eXh())
    {
      localObject1 = ad.eYc();
      kotlin.g.b.p.j(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
      if (!((q)localObject1).eXf().contains(z.bcZ())) {
        break label300;
      }
    }
    label298:
    label300:
    for (int i = 1;; i = 0)
    {
      localObject1 = ad.eYc();
      kotlin.g.b.p.j(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
      if (((q)localObject1).eXf().size() > i)
      {
        ad.eYc().eXB();
        localObject1 = this.Fzo;
        if (localObject1 != null)
        {
          if ((kotlin.g.b.p.h(((m)localObject1).getRendererSpeaker(), "") ^ true))
          {
            uZ(true);
            localObject1 = this.Fzo;
            if (localObject1 != null)
            {
              ((m)localObject1).dDz();
              AppMethodBeat.o(196736);
              return;
            }
          }
          AppMethodBeat.o(196736);
          return;
        }
        AppMethodBeat.o(196736);
        return;
      }
      ad.eYc().eXC();
      localObject1 = this.Fzo;
      if (localObject1 != null)
      {
        if (!(kotlin.g.b.p.h(((m)localObject1).getRendererSpeaker(), "") ^ true)) {
          break label247;
        }
        localObject2 = this.Fzo;
        if (localObject2 != null) {
          ((m)localObject2).aQO(((m)localObject1).getRendererSpeaker());
        }
      }
      for (;;)
      {
        eYF();
        uZ(false);
        AppMethodBeat.o(196736);
        return;
        label247:
        localObject1 = eYF();
        if (localObject1 != null) {}
        for (localObject1 = (String)kotlin.a.j.lo((List)localObject1);; localObject1 = null)
        {
          if ((localObject1 == null) || (aQQ((String)localObject1))) {
            break label298;
          }
          localObject2 = this.Fzo;
          if (localObject2 == null) {
            break;
          }
          ((m)localObject2).aQO((String)localObject1);
          break;
        }
      }
    }
  }
  
  public final void eWk() {}
  
  public final void eWl() {}
  
  public final void eWm() {}
  
  public final void eYE()
  {
    AppMethodBeat.i(196683);
    if (this.Fzo != null)
    {
      this.Fzq = true;
      com.tencent.e.h.ZvG.bDh("showIcon");
      com.tencent.e.h.ZvG.bc((Runnable)new e(this));
      AppMethodBeat.o(196683);
      return;
    }
    ic(true);
    AppMethodBeat.o(196683);
  }
  
  public final void ic(boolean paramBoolean)
  {
    AppMethodBeat.i(196755);
    Log.i("MicroMsg.MultiTalkSmallWindow", "dismiss now.. isFinish: %b, smallView: %s", new Object[] { Boolean.valueOf(paramBoolean), this.Fzo });
    Object localObject;
    if (this.Fzo != null)
    {
      if (paramBoolean) {
        com.tencent.mm.plugin.voip.a.a.gxw().b((FrameLayout)this.Fzo);
      }
      localObject = this.Fzo;
      if (localObject != null) {
        ((m)localObject).setOnClickListener(null);
      }
      localObject = this.Fzo;
      if (localObject != null) {
        ((m)localObject).uninit();
      }
      this.Fzo = null;
      ad.eYc().eXa();
      ad.eYe().Fri = null;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class)).b((com.tencent.mm.plugin.ball.c.g)this.Fzx);
      localObject = ad.eYc();
      kotlin.g.b.p.j(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
      ((q)localObject).eXp().b((com.tencent.mm.plugin.multitalk.model.g)this);
      AppMethodBeat.o(196755);
      return;
      if (paramBoolean) {
        com.tencent.mm.plugin.voip.a.a.gxw().cvE();
      }
    }
  }
  
  public final void im(int paramInt1, int paramInt2) {}
  
  public final void kv(int paramInt) {}
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(196693);
    m localm = this.Fzo;
    if (localm != null)
    {
      localm.setVoicePlayDevice(paramInt);
      AppMethodBeat.o(196693);
      return;
    }
    AppMethodBeat.o(196693);
  }
  
  public final void uA(boolean paramBoolean) {}
  
  public final void uy(boolean paramBoolean) {}
  
  public final void uz(boolean paramBoolean) {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow$floatBallViewListener$1", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallViewListenerAdapter;", "onBallPositionChanged", "", "x", "", "y", "height", "isSettled", "", "isDockLeft", "plugin-multitalk_release"})
  public static final class b
    extends com.tencent.mm.plugin.ball.c.h
  {
    public final void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(197763);
      super.a(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2);
      m localm = n.a(this.Fzz);
      if (localm != null)
      {
        localm.uY(paramBoolean2);
        AppMethodBeat.o(197763);
        return;
      }
      AppMethodBeat.o(197763);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(n paramn, Intent paramIntent) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(197425);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow$mini$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView.setOnClickListener(null);
      paramIntent.addFlags(268435456);
      paramView = MMApplicationContext.getContext();
      localObject = paramIntent;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow$mini$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow$mini$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      n.a(this.Fzz, new MTimerHandler((MTimerHandler.CallBack)new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(199102);
          Log.i("MicroMsg.MultiTalkSmallWindow", "click small view and time is up we remove it..");
          this.FzA.Fzz.ic(false);
          MTimerHandler localMTimerHandler = n.c(this.FzA.Fzz);
          if (localMTimerHandler != null) {
            localMTimerHandler.stopTimer();
          }
          AppMethodBeat.o(199102);
          return true;
        }
      }, false));
      paramView = n.c(this.Fzz);
      if (paramView != null) {
        paramView.startTimer(2000L);
      }
      MMHandlerThread.postToMainThreadDelayed((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(198741);
          this.FzA.Fzz.ic(false);
          AppMethodBeat.o(198741);
        }
      }, 200L);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow$mini$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(197425);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class d
    implements Runnable
  {
    public d(n paramn) {}
    
    public final void run()
    {
      AppMethodBeat.i(196472);
      com.tencent.e.h.ZvG.bc((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(206698);
          if ((n.a(this.FzB.Fzz) != null) && (!n.b(this.FzB.Fzz)))
          {
            m localm = n.a(this.FzB.Fzz);
            if (localm != null)
            {
              localm.Be(this.FzB.uYN);
              AppMethodBeat.o(206698);
              return;
            }
          }
          AppMethodBeat.o(206698);
        }
      });
      AppMethodBeat.o(196472);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(n paramn) {}
    
    public final void run()
    {
      AppMethodBeat.i(199135);
      m localm = n.a(this.Fzz);
      if (localm != null)
      {
        localm.eYB();
        com.tencent.e.h.ZvG.n((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(203904);
            this.FzC.Fzz.ic(true);
            AppMethodBeat.o(203904);
          }
        }, 2000L);
        AppMethodBeat.o(199135);
        return;
      }
      AppMethodBeat.o(199135);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class f
    implements Runnable
  {
    public f(n paramn) {}
    
    public final void run()
    {
      AppMethodBeat.i(205131);
      com.tencent.e.h.ZvG.bc((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(202368);
          if ((n.a(this.FzD.Fzz) != null) && (!n.b(this.FzD.Fzz)))
          {
            m localm = n.a(this.FzD.Fzz);
            if (localm != null)
            {
              localm.eXH();
              AppMethodBeat.o(202368);
              return;
            }
          }
          AppMethodBeat.o(202368);
        }
      });
      AppMethodBeat.o(205131);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(n paramn) {}
    
    public final void run()
    {
      AppMethodBeat.i(199058);
      m localm = n.a(this.Fzz);
      if (localm != null)
      {
        localm.uW(true);
        AppMethodBeat.o(199058);
        return;
      }
      AppMethodBeat.o(199058);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(n paramn) {}
    
    public final void run()
    {
      AppMethodBeat.i(198097);
      m localm = n.a(this.Fzz);
      if (localm != null)
      {
        q localq = ad.eYc();
        kotlin.g.b.p.j(localq, "SubCoreMultiTalk.getMultiTalkManager()");
        localm.uX(localq.aeg());
        AppMethodBeat.o(198097);
        return;
      }
      AppMethodBeat.o(198097);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.n
 * JD-Core Version:    0.7.0.1
 */