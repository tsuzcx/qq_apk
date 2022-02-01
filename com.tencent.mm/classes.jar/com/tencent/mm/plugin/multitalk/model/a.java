package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.multitalk.ui.widget.MultitalkFrameView;
import com.tencent.mm.plugin.multitalk.ui.widget.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.a.ae;
import kotlin.l;
import kotlin.o;
import kotlin.s;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManager;", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTargetContainer;", "Landroid/view/View$OnClickListener;", "()V", "bigAvatarAdapter", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutAdapter;", "bigAvatarHolder", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "bigAvatarLayout", "Landroid/widget/RelativeLayout;", "dispatchToAvatarEvent", "Lkotlin/Function1;", "", "", "dispatchToScreenCastBigEvent", "dispatchToScreenCastSmallEvent", "dispatchToVideoBigEvent", "dispatchToVideoSmallEvent", "firstScreenUser", "handlerMap", "", "", "screenCastBigLoadingShow", "", "screenCastUiCallback", "Lcom/tencent/mm/plugin/multitalk/model/IScreenCastUiCallback;", "showElement", "talkingAvatarContainer", "Landroidx/recyclerview/widget/RecyclerView;", "talkingBigAvatarLayout", "Landroid/widget/FrameLayout;", "uiCallback", "Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManagerUiCallback;", "userStateMap", "Landroid/util/ArrayMap;", "videoDisplayDataMuxer", "Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer;", "getVideoDisplayDataMuxer", "()Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer;", "close", "closeMemberToVideo", "videoUserSet", "", "closeScreenCastBig", "displayVoiceTalkingIcon", "displayWeakNetWorkIcon", "finish", "isMini", "getAvatarViewGroupByUsername", "Landroid/view/View;", "wxUserName", "getAvatarViewHolderByUsername", "getBigHolderWxUserName", "getLargeRenderTarget", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "ori", "getNormalRenderTarget", "getUserState", "hideScreenCastBig", "hideVideoBig", "initCurrentViewStatus", "isBigAvatarScreenCastting", "isBigAvatarVideo", "isScreenCastPause", "onClick", "v", "onScreenFrame", "openMemberToVideo", "registerView", "mainUI", "Lcom/tencent/mm/plugin/multitalk/ui/MultiTalkMainUI;", "setBigAvatarUserState", "member", "Lcom/tencent/pb/talkroom/sdk/MultiTalkGroupMember;", "is2GOr3G", "currentVideoSet", "Ljava/util/HashSet;", "setMute", "isMute", "setStatus", "state", "showScreenCastBig", "showVideoBig", "unregisterLisenter", "unregisterView", "updateAvatar", "userStateTrans", "Companion", "ScreenCastReceiverUiCallbackImpl", "plugin-multitalk_release"})
public final class a
  implements View.OnClickListener, g
{
  public static final a.a Fqv;
  private RecyclerView Fqe;
  private FrameLayout Fqf;
  private RelativeLayout Fqg;
  public b Fqh;
  private com.tencent.mm.plugin.multitalk.ui.widget.b Fqi;
  public com.tencent.mm.plugin.multitalk.ui.widget.a Fqj;
  public ArrayMap<String, Integer> Fqk;
  private i Fql;
  private String Fqm;
  private boolean Fqn;
  private af Fqo;
  private final kotlin.g.a.b<String, x> Fqp;
  private final kotlin.g.a.b<String, x> Fqq;
  private final kotlin.g.a.b<String, x> Fqr;
  private final kotlin.g.a.b<String, x> Fqs;
  private final kotlin.g.a.b<String, x> Fqt;
  private boolean Fqu;
  private final Map<Integer, kotlin.g.a.b<String, x>> lvN;
  
  static
  {
    AppMethodBeat.i(204465);
    Fqv = new a.a((byte)0);
    AppMethodBeat.o(204465);
  }
  
  public a()
  {
    AppMethodBeat.i(204463);
    this.Fqk = new ArrayMap();
    this.Fqm = "";
    Object localObject = ad.eYc();
    kotlin.g.b.p.j(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
    localObject = ((q)localObject).eXp();
    kotlin.g.b.p.j(localObject, "SubCoreMultiTalk.getMult…kManager().videoDataMuxer");
    this.Fqo = ((af)localObject);
    this.Fqp = ((kotlin.g.a.b)new c(this));
    this.Fqq = ((kotlin.g.a.b)new g(this));
    this.Fqr = ((kotlin.g.a.b)new f(this));
    this.Fqs = ((kotlin.g.a.b)new e(this));
    this.Fqt = ((kotlin.g.a.b)new d(this));
    this.lvN = ae.e(new o[] { s.M(Integer.valueOf(0), this.Fqp), s.M(Integer.valueOf(1), this.Fqq), s.M(Integer.valueOf(2), this.Fqr), s.M(Integer.valueOf(3), this.Fqs), s.M(Integer.valueOf(4), this.Fqt) });
    this.Fqu = true;
    AppMethodBeat.o(204463);
  }
  
  private final af eVL()
  {
    AppMethodBeat.i(204425);
    Object localObject1 = ad.eYc();
    kotlin.g.b.p.j(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    localObject1 = ((q)localObject1).eXp();
    kotlin.g.b.p.j(localObject1, "SubCoreMultiTalk.getMult…kManager().videoDataMuxer");
    this.Fqo = ((af)localObject1);
    Object localObject2 = this.Fqo;
    localObject1 = (g)this;
    kotlin.g.b.p.k(localObject1, "container");
    localObject2 = ((af)localObject2).Fuz;
    if ((localObject2 != null) && (((ArrayList)localObject2).contains(localObject1) == true)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.Fqo.a((g)this);
      }
      localObject1 = this.Fqo;
      AppMethodBeat.o(204425);
      return localObject1;
    }
  }
  
  private void eVM()
  {
    AppMethodBeat.i(204427);
    this.Fqi = null;
    this.Fqj = null;
    this.Fqg = null;
    q localq = ad.eYc();
    kotlin.g.b.p.j(localq, "SubCoreMultiTalk.getMultiTalkManager()");
    localq.eXp().b((g)this);
    AppMethodBeat.o(204427);
  }
  
  private final void eVS()
  {
    AppMethodBeat.i(204461);
    Object localObject1 = this.Fqe;
    if (localObject1 != null) {
      ((RecyclerView)localObject1).setVisibility(0);
    }
    localObject1 = this.Fqh;
    if (localObject1 != null) {
      ((b)localObject1).eVY();
    }
    localObject1 = this.Fqh;
    if (localObject1 != null) {
      b.a.a((b)localObject1, "");
    }
    localObject1 = this.Fqi;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).Fww;
      if (localObject2 != null) {
        ((MultitalkFrameView)localObject2).eYR();
      }
      com.tencent.mm.plugin.multitalk.ui.widget.b.b((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1);
      ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).eYt();
    }
    localObject1 = this.Fqf;
    if (localObject1 != null)
    {
      localObject2 = ((FrameLayout)localObject1).getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(204461);
        throw ((Throwable)localObject1);
      }
      localObject2 = (RelativeLayout.LayoutParams)localObject2;
      Object localObject3 = this.Fqh;
      if (localObject3 != null)
      {
        localObject3 = ((b)localObject3).eVT();
        ((RelativeLayout.LayoutParams)localObject2).topMargin = (localObject3[1] - localObject3[0]);
      }
      ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((FrameLayout)localObject1).setVisibility(8);
    }
    localObject1 = this.Fqh;
    if (localObject1 != null) {
      ((b)localObject1).eWc();
    }
    ad.eYc().bY("", true);
    AppMethodBeat.o(204461);
  }
  
  public final f Xq(final int paramInt)
  {
    AppMethodBeat.i(204455);
    Object localObject = this.Fqi;
    if (localObject != null) {
      if (1 <= paramInt) {}
    }
    for (localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).Fww;; localObject = null)
    {
      localObject = (f)localObject;
      AppMethodBeat.o(204455);
      return localObject;
      if (5 < paramInt) {
        break;
      }
      d.uiThread((kotlin.g.a.a)new h((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject, paramInt));
      break;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, FrameLayout paramFrameLayout, MultiTalkMainUI paramMultiTalkMainUI, b paramb)
  {
    AppMethodBeat.i(204426);
    kotlin.g.b.p.k(paramRecyclerView, "talkingAvatarContainer");
    kotlin.g.b.p.k(paramFrameLayout, "talkingBigAvatarLayout");
    kotlin.g.b.p.k(paramMultiTalkMainUI, "mainUI");
    kotlin.g.b.p.k(paramb, "uiCallback");
    this.Fqh = paramb;
    this.Fqe = paramRecyclerView;
    this.Fqf = paramFrameLayout;
    paramRecyclerView = paramRecyclerView.getAdapter();
    if (paramRecyclerView == null)
    {
      paramRecyclerView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.multitalk.ui.widget.AvatarLayoutAdapter");
      AppMethodBeat.o(204426);
      throw paramRecyclerView;
    }
    this.Fqj = ((com.tencent.mm.plugin.multitalk.ui.widget.a)paramRecyclerView);
    paramRecyclerView = c.FwS;
    paramRecyclerView = (Context)paramMultiTalkMainUI;
    paramMultiTalkMainUI = (ViewGroup)paramFrameLayout;
    paramb = (View.OnClickListener)this;
    kotlin.g.b.p.k(paramRecyclerView, "context");
    kotlin.g.b.p.k(paramMultiTalkMainUI, "parent");
    kotlin.g.b.p.k(paramb, "clickListener");
    paramRecyclerView = LayoutInflater.from(paramRecyclerView).inflate(com.tencent.mm.plugin.multitalk.a.f.main_ui_talking_avatar_cell, paramMultiTalkMainUI, false);
    if (paramRecyclerView == null)
    {
      paramRecyclerView = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(204426);
      throw paramRecyclerView;
    }
    paramRecyclerView = (RelativeLayout)paramRecyclerView;
    paramMultiTalkMainUI = new com.tencent.mm.plugin.multitalk.ui.widget.b((View)paramRecyclerView);
    paramMultiTalkMainUI.Fww = ((MultitalkFrameView)paramRecyclerView.findViewById(com.tencent.mm.plugin.multitalk.a.e.talking_video_view));
    MultitalkFrameView localMultitalkFrameView = paramMultiTalkMainUI.Fww;
    if (localMultitalkFrameView != null) {
      localMultitalkFrameView.setIndex(0);
    }
    localMultitalkFrameView = paramMultiTalkMainUI.Fww;
    if (localMultitalkFrameView != null) {
      localMultitalkFrameView.setOnClickListener(paramb);
    }
    paramMultiTalkMainUI.maskView = paramRecyclerView.findViewById(com.tencent.mm.plugin.multitalk.a.e.mask_view);
    paramb = paramRecyclerView.findViewById(com.tencent.mm.plugin.multitalk.a.e.voice_icon_iv);
    if (paramb == null)
    {
      paramRecyclerView = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(204426);
      throw paramRecyclerView;
    }
    paramMultiTalkMainUI.Fwx = ((ImageView)paramb);
    paramb = paramRecyclerView.findViewById(com.tencent.mm.plugin.multitalk.a.e.multitalk_weaknetwork_iv);
    if (paramb == null)
    {
      paramRecyclerView = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(204426);
      throw paramRecyclerView;
    }
    paramMultiTalkMainUI.Fwy = ((ImageView)paramb);
    paramb = paramRecyclerView.findViewById(com.tencent.mm.plugin.multitalk.a.e.switch_camera_tip_tv);
    if (paramb == null)
    {
      paramRecyclerView = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(204426);
      throw paramRecyclerView;
    }
    paramMultiTalkMainUI.Fwz = ((TextView)paramb);
    paramb = paramRecyclerView.findViewById(com.tencent.mm.plugin.multitalk.a.e.loading_iv);
    if (paramb == null)
    {
      paramRecyclerView = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(204426);
      throw paramRecyclerView;
    }
    paramMultiTalkMainUI.EMn = ((ImageView)paramb);
    paramRecyclerView.setTag(paramMultiTalkMainUI);
    this.Fqg = paramRecyclerView;
    paramRecyclerView = this.Fqg;
    if (paramRecyclerView != null) {}
    for (paramRecyclerView = paramRecyclerView.getTag(); paramRecyclerView == null; paramRecyclerView = null)
    {
      paramRecyclerView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.multitalk.ui.widget.AvatarLayoutHolder");
      AppMethodBeat.o(204426);
      throw paramRecyclerView;
    }
    this.Fqi = ((com.tencent.mm.plugin.multitalk.ui.widget.b)paramRecyclerView);
    paramFrameLayout.addView((View)this.Fqg);
    paramRecyclerView = this.Fqg;
    if (paramRecyclerView != null) {
      paramRecyclerView.setVisibility(8);
    }
    paramFrameLayout.setVisibility(8);
    this.Fql = ((i)new b());
    paramRecyclerView = ad.eYc();
    kotlin.g.b.p.j(paramRecyclerView, "SubCoreMultiTalk.getMultiTalkManager()");
    paramRecyclerView.eXm().a(this.Fql);
    eVL();
    AppMethodBeat.o(204426);
  }
  
  public final com.tencent.mm.plugin.multitalk.ui.widget.b aPL(String paramString)
  {
    AppMethodBeat.i(204436);
    kotlin.g.b.p.k(paramString, "wxUserName");
    kotlin.g.b.p.k(paramString, "wxUserName");
    com.tencent.mm.plugin.multitalk.ui.widget.a locala = this.Fqj;
    Object localObject1;
    label103:
    label115:
    int i;
    if (locala != null)
    {
      kotlin.g.b.p.k(paramString, "userName");
      Iterator localIterator = ((Iterable)locala.Fwl).iterator();
      if (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        localObject1 = (com.tencent.mm.plugin.multitalk.data.a)localObject2;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.multitalk.data.a)localObject1).Fmr;
          if (localObject1 != null)
          {
            localObject1 = ((MultiTalkGroupMember)localObject1).ZiH;
            if (!kotlin.g.b.p.h(localObject1, paramString)) {
              break label198;
            }
            paramString = localObject2;
            paramString = (com.tencent.mm.plugin.multitalk.data.a)paramString;
            if (paramString == null) {
              break label205;
            }
            i = paramString.index;
            label129:
            int j = locala.BcO;
            paramString = this.Fqe;
            if (paramString == null) {
              break label210;
            }
            paramString = paramString.getChildAt(i + j);
            label152:
            if (paramString == null) {
              break label233;
            }
            localObject1 = this.Fqe;
            if (localObject1 == null) {
              break label220;
            }
          }
        }
      }
    }
    label198:
    label205:
    label210:
    label220:
    for (paramString = ((RecyclerView)localObject1).aQ(paramString);; paramString = null)
    {
      if (!(paramString instanceof com.tencent.mm.plugin.multitalk.ui.widget.b)) {
        break label225;
      }
      paramString = (com.tencent.mm.plugin.multitalk.ui.widget.b)paramString;
      AppMethodBeat.o(204436);
      return paramString;
      localObject1 = null;
      break label103;
      break;
      paramString = null;
      break label115;
      i = -1;
      break label129;
      paramString = null;
      break label152;
      paramString = null;
      break label152;
    }
    label225:
    AppMethodBeat.o(204436);
    return null;
    label233:
    AppMethodBeat.o(204436);
    return null;
  }
  
  public final f aPM(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(204457);
    kotlin.g.b.p.k(paramString, "wxUserName");
    com.tencent.mm.plugin.multitalk.ui.widget.b localb = aPL(paramString);
    paramString = localObject;
    int i;
    if (localb != null)
    {
      if (localb.md() < 0) {
        break label67;
      }
      i = 1;
      if (i == 0) {
        break label72;
      }
    }
    for (;;)
    {
      paramString = localObject;
      if (localb != null) {
        paramString = localb.Fww;
      }
      paramString = (f)paramString;
      AppMethodBeat.o(204457);
      return paramString;
      label67:
      i = 0;
      break;
      label72:
      localb = null;
    }
  }
  
  public final void eVN()
  {
    AppMethodBeat.i(204429);
    q localq = ad.eYc();
    kotlin.g.b.p.j(localq, "SubCoreMultiTalk.getMultiTalkManager()");
    localq.eXp().b((g)this);
    AppMethodBeat.o(204429);
  }
  
  public final void eVO()
  {
    AppMethodBeat.i(204444);
    Object localObject = this.Fqf;
    if (localObject != null)
    {
      if (((FrameLayout)localObject).getVisibility() != 0) {
        break label111;
      }
      localObject = this.Fqi;
      if (localObject == null) {
        break label111;
      }
      localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).Fww;
      if (localObject == null) {
        break label111;
      }
      localObject = ((MultitalkFrameView)localObject).getUsername();
      if (localObject == null) {
        break label111;
      }
      q localq = ad.eYc();
      kotlin.g.b.p.j(localq, "SubCoreMultiTalk.getMultiTalkManager()");
      int i = localq.eXm().aQx((String)localObject);
      if ((i == 103) || (i == 100))
      {
        eVS();
        AppMethodBeat.o(204444);
      }
    }
    else
    {
      AppMethodBeat.o(204444);
      return;
    }
    fm((String)localObject, 3);
    AppMethodBeat.o(204444);
    return;
    label111:
    AppMethodBeat.o(204444);
  }
  
  public final boolean eVP()
  {
    AppMethodBeat.i(204445);
    Object localObject = this.Fqf;
    if ((localObject != null) && (((FrameLayout)localObject).getVisibility() == 0))
    {
      localObject = this.Fqi;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).Fww;
        if (localObject == null) {}
      }
      for (boolean bool = ((MultitalkFrameView)localObject).eYT(); bool; bool = false)
      {
        AppMethodBeat.o(204445);
        return true;
      }
    }
    AppMethodBeat.o(204445);
    return false;
  }
  
  public final String eVQ()
  {
    AppMethodBeat.i(204453);
    Object localObject = this.Fqi;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).Fww;
      if (localObject != null)
      {
        String str = ((MultitalkFrameView)localObject).getUsername();
        localObject = str;
        if (str != null) {
          break label38;
        }
      }
    }
    localObject = "";
    label38:
    AppMethodBeat.o(204453);
    return localObject;
  }
  
  public final void eVR()
  {
    AppMethodBeat.i(204459);
    if (!this.Fqn)
    {
      com.tencent.mm.plugin.multitalk.ui.widget.b localb = this.Fqi;
      if (localb == null) {
        break label51;
      }
      if (localb.FwL != 1) {}
    }
    else
    {
      d.uiThread((kotlin.g.a.a)new i(this));
    }
    AppMethodBeat.o(204459);
    return;
    label51:
    AppMethodBeat.o(204459);
  }
  
  public final void fm(String paramString, int paramInt)
  {
    for (;;)
    {
      int j;
      try
      {
        AppMethodBeat.i(204441);
        kotlin.g.b.p.k(paramString, "wxUserName");
        localObject = ad.eYc();
        kotlin.g.b.p.j(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
        j = ((q)localObject).eXm().aQx(paramString);
        if (paramInt != 1) {
          break label180;
        }
        if (j == 101) {
          break label185;
        }
        if (j != 102) {
          break label180;
        }
      }
      finally {}
      Log.printInfoStack("AvatarViewManager", paramString + " to state " + i, new Object[0]);
      Object localObject = (kotlin.g.a.b)this.lvN.get(Integer.valueOf(i));
      if (localObject != null) {
        ((kotlin.g.a.b)localObject).invoke(paramString);
      }
      if ((paramInt == 1) && (j == 102))
      {
        localObject = this.Fql;
        if (localObject != null)
        {
          ((i)localObject).aPO(paramString);
          AppMethodBeat.o(204441);
          return;
        }
      }
      AppMethodBeat.o(204441);
      continue;
      label180:
      int i = paramInt;
      continue;
      label185:
      i = 3;
    }
  }
  
  public final void hS(boolean paramBoolean)
  {
    AppMethodBeat.i(204452);
    Object localObject1 = this.Fqj;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject1).Fwl;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.multitalk.data.a)((Iterator)localObject1).next();
          Object localObject3 = ((com.tencent.mm.plugin.multitalk.data.a)localObject2).Fmr.ZiH;
          kotlin.g.b.p.j(localObject3, "it.member.usrName");
          localObject3 = aPL((String)localObject3);
          if (localObject3 != null)
          {
            MTimerHandler localMTimerHandler = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).cts;
            if (localMTimerHandler != null) {
              localMTimerHandler.quitSafely();
            }
            localMTimerHandler = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).cts;
            if (localMTimerHandler != null) {
              localMTimerHandler.stopTimer();
            }
            localMTimerHandler = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).cts;
            if (localMTimerHandler != null) {
              localMTimerHandler.removeCallbacksAndMessages(null);
            }
            ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).cts = null;
          }
          localObject2 = ((com.tencent.mm.plugin.multitalk.data.a)localObject2).Fmr.ZiH;
          kotlin.g.b.p.j(localObject2, "it.member.usrName");
          localObject2 = aPL((String)localObject2);
          if (localObject2 != null)
          {
            localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject2).Fww;
            if (localObject2 != null) {
              Log.i("MicroMsg.MultitalkFrameView", "release it " + ((MultitalkFrameView)localObject2).hashCode());
            }
          }
        }
      }
    }
    if (paramBoolean)
    {
      localObject1 = this.Fqi;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).Fww;
        if (localObject1 != null)
        {
          localObject1 = ((MultitalkFrameView)localObject1).getUsername();
          if (localObject1 != null)
          {
            if (!eVP()) {
              break label309;
            }
            fm((String)localObject1, 3);
          }
        }
      }
    }
    label384:
    for (;;)
    {
      eVM();
      localObject1 = this.Fqj;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject1).Fws = null;
      }
      this.Fql = null;
      localObject1 = ad.eYc();
      kotlin.g.b.p.j(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
      ((q)localObject1).eXm().a(null);
      AppMethodBeat.o(204452);
      return;
      label309:
      localObject2 = this.Fqf;
      if ((localObject2 != null) && (((FrameLayout)localObject2).getVisibility() == 0))
      {
        localObject2 = this.Fqi;
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject2).Fww;
          if (localObject2 != null)
          {
            paramBoolean = ((MultitalkFrameView)localObject2).eXd();
            label357:
            if (!paramBoolean) {
              break label381;
            }
          }
        }
      }
      label381:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label384;
        }
        fm((String)localObject1, 1);
        break;
        paramBoolean = false;
        break label357;
      }
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(204431);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/model/AvatarViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    if (eVP())
    {
      if (this.Fqu)
      {
        paramView = this.Fqh;
        if (paramView != null) {
          paramView.eWa();
        }
      }
      for (this.Fqu = false;; this.Fqu = true)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/model/AvatarViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(204431);
        return;
        paramView = this.Fqh;
        if (paramView != null) {
          paramView.eVZ();
        }
      }
    }
    if (paramView == null)
    {
      paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.multitalk.ui.widget.MultitalkFrameView");
      AppMethodBeat.o(204431);
      throw paramView;
    }
    paramView = (MultitalkFrameView)paramView;
    if (paramView.getUsername() == null)
    {
      Log.e("AvatarViewManager", "videoview get null username");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/model/AvatarViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(204431);
      return;
    }
    localObject = this.Fqf;
    if ((localObject == null) || (((FrameLayout)localObject).getVisibility() != 0)) {
      if (paramView.eYT())
      {
        fm(paramView.getUsername(), 4);
        p.FrL += 1;
        paramView = this.Fqh;
        if (paramView != null) {
          paramView.eWb();
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/model/AvatarViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(204431);
      return;
      fm(paramView.getUsername(), 2);
      paramView = this.Fqh;
      if (paramView != null)
      {
        paramView.eWc();
        continue;
        if (paramView.eYT())
        {
          fm(paramView.getUsername(), 3);
          paramView = this.Fqh;
          if (paramView != null) {
            paramView.eWc();
          }
        }
        else
        {
          fm(paramView.getUsername(), 1);
          paramView = this.Fqh;
          if (paramView != null) {
            paramView.eWc();
          }
        }
      }
    }
  }
  
  public final void p(Set<String> paramSet)
  {
    AppMethodBeat.i(204449);
    kotlin.g.b.p.k(paramSet, "videoUserSet");
    Log.i("AvatarViewManager", "openMemberToVideo, %s", new Object[] { paramSet });
    Object localObject = this.Fqj;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject).Fwl;
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        label140:
        label144:
        label177:
        label334:
        label339:
        label351:
        label354:
        while (localIterator.hasNext())
        {
          com.tencent.mm.plugin.multitalk.data.a locala = (com.tencent.mm.plugin.multitalk.data.a)localIterator.next();
          localObject = locala.Fmr.ZiH;
          kotlin.g.b.p.j(localObject, "it.member.usrName");
          localObject = aPL((String)localObject);
          int i;
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).Fww;
            if (localObject != null) {
              if (((kotlin.g.b.p.h(z.bcZ(), ((MultitalkFrameView)localObject).getUsername()) ^ true)) && (!((MultitalkFrameView)localObject).eYT()))
              {
                i = 1;
                if (i == 0) {
                  break label334;
                }
                if (localObject == null) {
                  break label351;
                }
                if (!paramSet.contains(((MultitalkFrameView)localObject).getUsername())) {
                  break label339;
                }
                if (((MultitalkFrameView)localObject).eYS()) {
                  fm(((MultitalkFrameView)localObject).getUsername(), 1);
                }
              }
            }
          }
          for (localObject = x.aazN;; localObject = null)
          {
            if (localObject != null) {
              break label354;
            }
            Log.i("AvatarViewManager", "UI not ready, just init state");
            if ((!paramSet.contains(locala.Fmr.ZiH)) || (!(kotlin.g.b.p.h(z.bcZ(), locala.Fmr.ZiH) ^ true))) {
              break;
            }
            localObject = ad.eYc();
            kotlin.g.b.p.j(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
            localObject = ((q)localObject).eXm().Ftb;
            if ((localObject != null) && (((ArrayList)localObject).contains(locala.Fmr.ZiH) == true)) {
              break;
            }
            Log.i("AvatarViewManager", "init " + locala.Fmr.ZiH + " to VIDEO_SMALL");
            localObject = locala.Fmr.ZiH;
            kotlin.g.b.p.j(localObject, "it.member.usrName");
            fm((String)localObject, 1);
            break;
            i = 0;
            break label140;
            localObject = null;
            break label144;
            fm(((MultitalkFrameView)localObject).getUsername(), 0);
            break label177;
          }
        }
        AppMethodBeat.o(204449);
        return;
      }
    }
    AppMethodBeat.o(204449);
  }
  
  public final void q(Set<String> paramSet)
  {
    AppMethodBeat.i(204450);
    kotlin.g.b.p.k(paramSet, "videoUserSet");
    Object localObject = this.Fqj;
    Iterator localIterator;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject).Fwl;
      Log.i("AvatarViewManager", "openMemberToVideo, %s,%s", new Object[] { paramSet, localObject });
      localObject = this.Fqj;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject).Fwl;
        if (localObject != null) {
          localIterator = ((Iterable)localObject).iterator();
        }
      }
    }
    else
    {
      label195:
      label456:
      label459:
      for (;;)
      {
        label77:
        if (!localIterator.hasNext()) {
          break label461;
        }
        com.tencent.mm.plugin.multitalk.data.a locala = (com.tencent.mm.plugin.multitalk.data.a)localIterator.next();
        localObject = ad.eYc();
        kotlin.g.b.p.j(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
        localObject = ((q)localObject).eXm().Ftb;
        int i;
        if ((localObject != null) && (((ArrayList)localObject).contains(locala.Fmr.ZiH) == true))
        {
          Log.i("AvatarViewManager", "init " + locala.Fmr.ZiH + " to SCREEN_CAST_SMALL");
          localObject = locala.Fmr.ZiH;
          kotlin.g.b.p.j(localObject, "it.member.usrName");
          fm((String)localObject, 3);
          localObject = locala.Fmr.ZiH;
          kotlin.g.b.p.j(localObject, "it.member.usrName");
          localObject = aPL((String)localObject);
          if (localObject == null) {
            break label456;
          }
          localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).Fww;
          if (localObject == null) {
            break label456;
          }
          if ((!(kotlin.g.b.p.h(z.bcZ(), ((MultitalkFrameView)localObject).getUsername()) ^ true)) || (((MultitalkFrameView)localObject).eYT())) {
            break label434;
          }
          i = 1;
          label254:
          if (i == 0) {
            break label439;
          }
          if (localObject == null) {
            break label456;
          }
          if (!paramSet.contains(((MultitalkFrameView)localObject).getUsername())) {
            break label444;
          }
          if (((MultitalkFrameView)localObject).eYS()) {
            fm(((MultitalkFrameView)localObject).getUsername(), 1);
          }
        }
        for (localObject = x.aazN;; localObject = null)
        {
          if (localObject != null) {
            break label459;
          }
          Log.i("AvatarViewManager", "UI not ready, just init state user name is %s", new Object[] { locala.Fmr.ZiH });
          break label77;
          localObject = null;
          break;
          if (paramSet.contains(locala.Fmr.ZiH))
          {
            Log.i("AvatarViewManager", "init " + locala.Fmr.ZiH + " to VIDEO_SMALL");
            localObject = locala.Fmr.ZiH;
            kotlin.g.b.p.j(localObject, "it.member.usrName");
            fm((String)localObject, 1);
            break label195;
          }
          localObject = locala.Fmr.ZiH;
          kotlin.g.b.p.j(localObject, "it.member.usrName");
          fm((String)localObject, 0);
          break label195;
          i = 0;
          break label254;
          localObject = null;
          break label258;
          fm(((MultitalkFrameView)localObject).getUsername(), 0);
          break label291;
        }
      }
      label258:
      label291:
      label434:
      label439:
      label444:
      label461:
      AppMethodBeat.o(204450);
      return;
    }
    AppMethodBeat.o(204450);
  }
  
  public final void r(Set<String> paramSet)
  {
    AppMethodBeat.i(204451);
    kotlin.g.b.p.k(paramSet, "videoUserSet");
    Object localObject = this.Fqj;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject).Fwl;
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        while (localIterator.hasNext())
        {
          localObject = ((com.tencent.mm.plugin.multitalk.data.a)localIterator.next()).Fmr.ZiH;
          kotlin.g.b.p.j(localObject, "it.member.usrName");
          localObject = aPL((String)localObject);
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).Fww;
            if (localObject != null)
            {
              int i;
              if ((((MultitalkFrameView)localObject).getUsername() != null) && ((kotlin.g.b.p.h(z.bcZ(), ((MultitalkFrameView)localObject).getUsername()) ^ true)))
              {
                i = 1;
                label119:
                if (i == 0) {
                  break label157;
                }
              }
              for (;;)
              {
                if (localObject == null) {
                  break label160;
                }
                if (paramSet.contains(((MultitalkFrameView)localObject).getUsername())) {
                  break label162;
                }
                fm(((MultitalkFrameView)localObject).getUsername(), 0);
                break;
                i = 0;
                break label119;
                label157:
                localObject = null;
              }
              label160:
              continue;
              label162:
              if (((MultitalkFrameView)localObject).eYS()) {
                fm(((MultitalkFrameView)localObject).getUsername(), 1);
              }
            }
          }
        }
        AppMethodBeat.o(204451);
        return;
      }
    }
    AppMethodBeat.o(204451);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManager$ScreenCastReceiverUiCallbackImpl;", "Lcom/tencent/mm/plugin/multitalk/model/IScreenCastUiCallback;", "(Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManager;)V", "markPause", "", "wxUserName", "", "markRestart", "markResume", "markStart", "markStop", "updateTask", "task", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "plugin-multitalk_release"})
  public final class b
    implements i
  {
    public final void aPN(String paramString)
    {
      AppMethodBeat.i(196534);
      kotlin.g.b.p.k(paramString, "wxUserName");
      this.Fqw.fm(paramString, 3);
      AppMethodBeat.o(196534);
    }
    
    public final void aPO(String paramString)
    {
      Object localObject2 = null;
      AppMethodBeat.i(196537);
      kotlin.g.b.p.k(paramString, "wxUserName");
      Object localObject1 = this.Fqw.aPL(paramString);
      boolean bool;
      if (localObject1 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).Fww;
        if (localObject3 == null) {
          break label153;
        }
        bool = ((MultitalkFrameView)localObject3).eYT();
        if (!bool) {
          break label158;
        }
        label51:
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).aj(true, false);
        }
      }
      Object localObject3 = a.a(this.Fqw);
      if (localObject3 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).Fww;
        if (localObject1 != null)
        {
          localObject1 = ((MultitalkFrameView)localObject1).getUsername();
          label96:
          if (!kotlin.g.b.p.h(localObject1, paramString)) {
            break label175;
          }
          paramString = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).Fww;
          if (paramString == null) {
            break label170;
          }
          bool = paramString.eYT();
          label120:
          if (!bool) {
            break label175;
          }
        }
        label153:
        label158:
        label170:
        label175:
        for (int i = 1;; i = 0)
        {
          paramString = localObject2;
          if (i != 0) {
            paramString = (String)localObject3;
          }
          if (paramString == null) {
            break label180;
          }
          com.tencent.mm.plugin.multitalk.ui.widget.b.a(paramString, false, false, 3);
          AppMethodBeat.o(196537);
          return;
          bool = false;
          break;
          localObject1 = null;
          break label51;
          localObject1 = null;
          break label96;
          bool = false;
          break label120;
        }
      }
      label180:
      AppMethodBeat.o(196537);
    }
    
    public final void aPP(String paramString)
    {
      AppMethodBeat.i(196539);
      kotlin.g.b.p.k(paramString, "wxUserName");
      this.Fqw.fm(paramString, 3);
      Object localObject = a.a(this.Fqw);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).Fww;
        if (localObject == null) {}
      }
      for (localObject = ((MultitalkFrameView)localObject).getUsername();; localObject = null)
      {
        if (kotlin.g.b.p.h(localObject, paramString)) {
          this.Fqw.fm(paramString, 4);
        }
        AppMethodBeat.o(196539);
        return;
      }
    }
    
    public final void aPQ(String paramString)
    {
      Object localObject2 = null;
      AppMethodBeat.i(196546);
      kotlin.g.b.p.k(paramString, "wxUserName");
      kotlin.g.a.b localb = (kotlin.g.a.b)a.Fqx;
      Object localObject1 = this.Fqw.aPL(paramString);
      boolean bool;
      if (localObject1 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).Fww;
        if (localObject3 == null) {
          break label260;
        }
        bool = ((MultitalkFrameView)localObject3).eYT();
        if (!bool) {
          break label265;
        }
        label59:
        if (localObject1 != null) {
          localb.invoke(localObject1);
        }
      }
      Object localObject3 = a.a(this.Fqw);
      label107:
      int i;
      if (localObject3 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).Fww;
        if (localObject1 == null) {
          break label271;
        }
        localObject1 = ((MultitalkFrameView)localObject1).getUsername();
        if (!kotlin.g.b.p.h(localObject1, paramString)) {
          break label282;
        }
        localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).Fww;
        if (localObject1 == null) {
          break label277;
        }
        bool = ((MultitalkFrameView)localObject1).eYT();
        label134:
        if (!bool) {
          break label282;
        }
        i = 1;
        label140:
        if (i == 0) {
          break label287;
        }
        localObject1 = localObject3;
        label148:
        if (localObject1 != null) {
          localb.invoke(localObject1);
        }
      }
      localObject3 = a.a(this.Fqw);
      if (localObject3 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).Fww;
        if (localObject1 != null)
        {
          localObject1 = ((MultitalkFrameView)localObject1).getUsername();
          label196:
          if (!kotlin.g.b.p.h(localObject1, paramString)) {
            break label304;
          }
          paramString = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).Fww;
          if (paramString == null) {
            break label299;
          }
          bool = paramString.eYT();
          label220:
          if (!bool) {
            break label304;
          }
        }
        label260:
        label265:
        label271:
        label277:
        label282:
        label287:
        label299:
        label304:
        for (i = 1;; i = 0)
        {
          paramString = localObject2;
          if (i != 0) {
            paramString = (String)localObject3;
          }
          if (paramString == null) {
            break label309;
          }
          paramString.aj(false, false);
          a.a(this.Fqw, true);
          AppMethodBeat.o(196546);
          return;
          bool = false;
          break;
          localObject1 = null;
          break label59;
          localObject1 = null;
          break label107;
          bool = false;
          break label134;
          i = 0;
          break label140;
          localObject1 = null;
          break label148;
          localObject1 = null;
          break label196;
          bool = false;
          break label220;
        }
      }
      label309:
      AppMethodBeat.o(196546);
    }
    
    public final void aPR(String paramString)
    {
      AppMethodBeat.i(196547);
      kotlin.g.b.p.k(paramString, "wxUserName");
      this.Fqw.fm(paramString, 0);
      AppMethodBeat.o(196547);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.b<com.tencent.mm.plugin.multitalk.ui.widget.b, x>
    {
      public static final a Fqx;
      
      static
      {
        AppMethodBeat.i(200452);
        Fqx = new a();
        AppMethodBeat.o(200452);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "wxUserName", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "wxUserName", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "wxUserName", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "wxUserName", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "wxUserName", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    g(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/multitalk/model/AvatarViewManager$getLargeRenderTarget$1$1"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    h(com.tencent.mm.plugin.multitalk.ui.widget.b paramb, int paramInt)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    i(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.a
 * JD-Core Version:    0.7.0.1
 */