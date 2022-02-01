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
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManager;", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTargetContainer;", "Landroid/view/View$OnClickListener;", "()V", "bigAvatarAdapter", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutAdapter;", "bigAvatarHolder", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "bigAvatarLayout", "Landroid/widget/RelativeLayout;", "dispatchToAvatarEvent", "Lkotlin/Function1;", "", "", "dispatchToScreenCastBigEvent", "dispatchToScreenCastSmallEvent", "dispatchToVideoBigEvent", "dispatchToVideoSmallEvent", "firstScreenUser", "handlerMap", "", "", "screenCastBigLoadingShow", "", "screenCastUiCallback", "Lcom/tencent/mm/plugin/multitalk/model/IScreenCastUiCallback;", "showElement", "talkingAvatarContainer", "Landroidx/recyclerview/widget/RecyclerView;", "talkingBigAvatarLayout", "Landroid/widget/FrameLayout;", "uiCallback", "Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManagerUiCallback;", "userStateMap", "Landroid/util/ArrayMap;", "videoDisplayDataMuxer", "Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer;", "getVideoDisplayDataMuxer", "()Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer;", "close", "closeMemberToVideo", "videoUserSet", "", "closeScreenCastBig", "displayVoiceTalkingIcon", "displayWeakNetWorkIcon", "finish", "isMini", "getAvatarViewGroupByUsername", "Landroid/view/View;", "wxUserName", "getAvatarViewHolderByUsername", "getBigHolderWxUserName", "getLargeRenderTarget", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "ori", "getNormalRenderTarget", "getUserState", "hideScreenCastBig", "hideVideoBig", "initCurrentViewStatus", "isBigAvatarScreenCastting", "isBigAvatarVideo", "isScreenCastPause", "onClick", "v", "onScreenFrame", "openMemberToVideo", "registerView", "mainUI", "Lcom/tencent/mm/plugin/multitalk/ui/MultiTalkMainUI;", "setBigAvatarUserState", "member", "Lcom/tencent/pb/talkroom/sdk/MultiTalkGroupMember;", "is2GOr3G", "currentVideoSet", "Ljava/util/HashSet;", "setMute", "isMute", "setStatus", "state", "showScreenCastBig", "showVideoBig", "unregisterLisenter", "unregisterView", "updateAvatar", "userStateTrans", "Companion", "ScreenCastReceiverUiCallbackImpl", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements View.OnClickListener, g
{
  public static final a.a Lmo;
  private final kotlin.g.a.b<String, ah> LmA;
  private final kotlin.g.a.b<String, ah> LmB;
  private final kotlin.g.a.b<String, ah> LmC;
  private final kotlin.g.a.b<String, ah> LmD;
  private final kotlin.g.a.b<String, ah> LmE;
  private boolean LmF;
  private RecyclerView Lmp;
  private FrameLayout Lmq;
  private RelativeLayout Lmr;
  public b Lms;
  private com.tencent.mm.plugin.multitalk.ui.widget.b Lmt;
  public com.tencent.mm.plugin.multitalk.ui.widget.a Lmu;
  public ArrayMap<String, Integer> Lmv;
  private i Lmw;
  private String Lmx;
  private boolean Lmy;
  private ae Lmz;
  private final Map<Integer, kotlin.g.a.b<String, ah>> onl;
  
  static
  {
    AppMethodBeat.i(284900);
    Lmo = new a.a((byte)0);
    AppMethodBeat.o(284900);
  }
  
  public a()
  {
    AppMethodBeat.i(284817);
    this.Lmv = new ArrayMap();
    this.Lmx = "";
    ae localae = ac.ggS().ggf();
    kotlin.g.b.s.s(localae, "getMultiTalkManager().videoDataMuxer");
    this.Lmz = localae;
    this.LmA = ((kotlin.g.a.b)new c(this));
    this.LmB = ((kotlin.g.a.b)new g(this));
    this.LmC = ((kotlin.g.a.b)new f(this));
    this.LmD = ((kotlin.g.a.b)new e(this));
    this.LmE = ((kotlin.g.a.b)new d(this));
    this.onl = ak.e(new r[] { v.Y(Integer.valueOf(0), this.LmA), v.Y(Integer.valueOf(1), this.LmB), v.Y(Integer.valueOf(2), this.LmC), v.Y(Integer.valueOf(3), this.LmD), v.Y(Integer.valueOf(4), this.LmE) });
    this.LmF = true;
    AppMethodBeat.o(284817);
  }
  
  private final ae geD()
  {
    AppMethodBeat.i(284822);
    Object localObject1 = ac.ggS().ggf();
    kotlin.g.b.s.s(localObject1, "getMultiTalkManager().videoDataMuxer");
    this.Lmz = ((ae)localObject1);
    Object localObject2 = this.Lmz;
    localObject1 = (g)this;
    kotlin.g.b.s.u(localObject1, "container");
    localObject2 = ((ae)localObject2).LqS;
    if ((localObject2 != null) && (((ArrayList)localObject2).contains(localObject1) == true)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.Lmz.a((g)this);
      }
      localObject1 = this.Lmz;
      AppMethodBeat.o(284822);
      return localObject1;
    }
  }
  
  private final void geJ()
  {
    AppMethodBeat.i(284831);
    Object localObject1 = com.tencent.mm.plugin.multitalk.e.d.LAq;
    com.tencent.mm.plugin.multitalk.e.d.zB(false);
    localObject1 = this.Lmp;
    if (localObject1 != null) {
      ((RecyclerView)localObject1).setVisibility(0);
    }
    localObject1 = this.Lms;
    if (localObject1 != null) {
      ((b)localObject1).geP();
    }
    localObject1 = this.Lms;
    if (localObject1 != null) {
      b.a.a((b)localObject1, "");
    }
    localObject1 = this.Lmt;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).LsI;
      if (localObject2 != null) {
        ((MultitalkFrameView)localObject2).ghP();
      }
      com.tencent.mm.plugin.multitalk.ui.widget.b.b((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1);
      ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).gho();
    }
    localObject1 = this.Lmq;
    if (localObject1 != null)
    {
      localObject2 = ((FrameLayout)localObject1).getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(284831);
        throw ((Throwable)localObject1);
      }
      localObject2 = (RelativeLayout.LayoutParams)localObject2;
      Object localObject3 = this.Lms;
      if (localObject3 != null)
      {
        localObject3 = ((b)localObject3).geK();
        ((RelativeLayout.LayoutParams)localObject2).topMargin = (localObject3[1] - localObject3[0]);
      }
      localObject3 = ah.aiuX;
      ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((FrameLayout)localObject1).setVisibility(8);
    }
    localObject1 = this.Lms;
    if (localObject1 != null) {
      ((b)localObject1).geT();
    }
    localObject1 = this.Lms;
    if (localObject1 != null) {
      ((b)localObject1).geQ();
    }
    this.LmF = true;
    ac.ggS().cu("", true);
    AppMethodBeat.o(284831);
  }
  
  public final void a(RecyclerView paramRecyclerView, FrameLayout paramFrameLayout, MultiTalkMainUI paramMultiTalkMainUI, b paramb)
  {
    AppMethodBeat.i(284912);
    kotlin.g.b.s.u(paramRecyclerView, "talkingAvatarContainer");
    kotlin.g.b.s.u(paramFrameLayout, "talkingBigAvatarLayout");
    kotlin.g.b.s.u(paramMultiTalkMainUI, "mainUI");
    kotlin.g.b.s.u(paramb, "uiCallback");
    this.Lms = paramb;
    this.Lmp = paramRecyclerView;
    this.Lmq = paramFrameLayout;
    paramRecyclerView = paramRecyclerView.getAdapter();
    if (paramRecyclerView == null)
    {
      paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.multitalk.ui.widget.AvatarLayoutAdapter");
      AppMethodBeat.o(284912);
      throw paramRecyclerView;
    }
    this.Lmu = ((com.tencent.mm.plugin.multitalk.ui.widget.a)paramRecyclerView);
    paramRecyclerView = c.Ltc;
    paramRecyclerView = (Context)paramMultiTalkMainUI;
    paramMultiTalkMainUI = (ViewGroup)paramFrameLayout;
    paramb = (View.OnClickListener)this;
    kotlin.g.b.s.u(paramRecyclerView, "context");
    kotlin.g.b.s.u(paramMultiTalkMainUI, "parent");
    kotlin.g.b.s.u(paramb, "clickListener");
    paramRecyclerView = LayoutInflater.from(paramRecyclerView).inflate(com.tencent.mm.plugin.multitalk.a.f.main_ui_talking_avatar_cell, paramMultiTalkMainUI, false);
    if (paramRecyclerView == null)
    {
      paramRecyclerView = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(284912);
      throw paramRecyclerView;
    }
    paramRecyclerView = (RelativeLayout)paramRecyclerView;
    paramMultiTalkMainUI = new com.tencent.mm.plugin.multitalk.ui.widget.b((View)paramRecyclerView);
    paramMultiTalkMainUI.LsI = ((MultitalkFrameView)paramRecyclerView.findViewById(com.tencent.mm.plugin.multitalk.a.e.talking_video_view));
    MultitalkFrameView localMultitalkFrameView = paramMultiTalkMainUI.LsI;
    if (localMultitalkFrameView != null) {
      localMultitalkFrameView.setIndex(0);
    }
    localMultitalkFrameView = paramMultiTalkMainUI.LsI;
    if (localMultitalkFrameView != null) {
      localMultitalkFrameView.setOnClickListener(paramb);
    }
    paramMultiTalkMainUI.maskView = paramRecyclerView.findViewById(com.tencent.mm.plugin.multitalk.a.e.mask_view);
    paramb = paramRecyclerView.findViewById(com.tencent.mm.plugin.multitalk.a.e.voice_icon_iv);
    if (paramb == null)
    {
      paramRecyclerView = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(284912);
      throw paramRecyclerView;
    }
    paramMultiTalkMainUI.LsJ = ((ImageView)paramb);
    paramb = paramRecyclerView.findViewById(com.tencent.mm.plugin.multitalk.a.e.multitalk_weaknetwork_iv);
    if (paramb == null)
    {
      paramRecyclerView = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(284912);
      throw paramRecyclerView;
    }
    paramMultiTalkMainUI.LsK = ((ImageView)paramb);
    paramb = paramRecyclerView.findViewById(com.tencent.mm.plugin.multitalk.a.e.switch_camera_tip_tv);
    if (paramb == null)
    {
      paramRecyclerView = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(284912);
      throw paramRecyclerView;
    }
    paramMultiTalkMainUI.LsL = ((TextView)paramb);
    paramb = paramRecyclerView.findViewById(com.tencent.mm.plugin.multitalk.a.e.loading_iv);
    if (paramb == null)
    {
      paramRecyclerView = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(284912);
      throw paramRecyclerView;
    }
    paramMultiTalkMainUI.KGG = ((ImageView)paramb);
    paramRecyclerView.setTag(paramMultiTalkMainUI);
    this.Lmr = paramRecyclerView;
    paramRecyclerView = this.Lmr;
    if (paramRecyclerView == null) {}
    for (paramRecyclerView = null; paramRecyclerView == null; paramRecyclerView = paramRecyclerView.getTag())
    {
      paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.multitalk.ui.widget.AvatarLayoutHolder");
      AppMethodBeat.o(284912);
      throw paramRecyclerView;
    }
    this.Lmt = ((com.tencent.mm.plugin.multitalk.ui.widget.b)paramRecyclerView);
    paramFrameLayout.addView((View)this.Lmr);
    paramRecyclerView = this.Lmr;
    if (paramRecyclerView != null) {
      paramRecyclerView.setVisibility(8);
    }
    paramFrameLayout.setVisibility(8);
    this.Lmw = ((i)new b());
    ac.ggS().ggc().a(this.Lmw);
    geD();
    AppMethodBeat.o(284912);
  }
  
  public final com.tencent.mm.plugin.multitalk.ui.widget.b aMG(String paramString)
  {
    AppMethodBeat.i(284934);
    kotlin.g.b.s.u(paramString, "wxUserName");
    kotlin.g.b.s.u(paramString, "wxUserName");
    com.tencent.mm.plugin.multitalk.ui.widget.a locala = this.Lmu;
    Object localObject1;
    if (locala == null)
    {
      paramString = null;
      if (paramString == null) {
        break label231;
      }
      localObject1 = this.Lmp;
      if (localObject1 != null) {
        break label221;
      }
    }
    label92:
    label221:
    for (paramString = null;; paramString = ((RecyclerView)localObject1).bj(paramString))
    {
      if (!(paramString instanceof com.tencent.mm.plugin.multitalk.ui.widget.b)) {
        break label231;
      }
      paramString = (com.tencent.mm.plugin.multitalk.ui.widget.b)paramString;
      AppMethodBeat.o(284934);
      return paramString;
      kotlin.g.b.s.u(paramString, "userName");
      Iterator localIterator = ((Iterable)locala.Lsx).iterator();
      if (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        localObject1 = (com.tencent.mm.plugin.multitalk.data.a)localObject2;
        if (localObject1 == null)
        {
          localObject1 = null;
          label126:
          if (!kotlin.g.b.s.p(localObject1, paramString)) {
            break label195;
          }
          paramString = localObject2;
          paramString = (com.tencent.mm.plugin.multitalk.data.a)paramString;
          if (paramString != null) {
            break label202;
          }
        }
      }
      int j;
      for (int i = -1;; i = paramString.index)
      {
        j = locala.xZt;
        paramString = this.Lmp;
        if (paramString != null) {
          break label210;
        }
        paramString = null;
        break;
        localObject1 = ((com.tencent.mm.plugin.multitalk.data.a)localObject1).Liv;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label126;
        }
        localObject1 = ((MultiTalkGroupMember)localObject1).ahhi;
        break label126;
        break label92;
        paramString = null;
        break label138;
      }
      paramString = paramString.getChildAt(i + j);
      break;
    }
    label138:
    label195:
    label202:
    label210:
    label231:
    AppMethodBeat.o(284934);
    return null;
  }
  
  public final f aMH(String paramString)
  {
    MultitalkFrameView localMultitalkFrameView = null;
    AppMethodBeat.i(284991);
    kotlin.g.b.s.u(paramString, "wxUserName");
    paramString = aMG(paramString);
    if (paramString == null) {}
    label47:
    label68:
    label71:
    for (;;)
    {
      paramString = (f)localMultitalkFrameView;
      AppMethodBeat.o(284991);
      return paramString;
      int i;
      if (paramString.KJ() >= 0)
      {
        i = 1;
        if (i == 0) {
          break label68;
        }
      }
      for (;;)
      {
        if (paramString == null) {
          break label71;
        }
        localMultitalkFrameView = paramString.LsI;
        break;
        i = 0;
        break label47;
        paramString = null;
      }
    }
  }
  
  public final f abB(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(284985);
    Object localObject = this.Lmt;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).LsI)
    {
      localObject = (f)localObject;
      AppMethodBeat.o(284985);
      return localObject;
      int i = j;
      if (paramInt > 0)
      {
        i = j;
        if (paramInt <= 5) {
          i = 1;
        }
      }
      if (i != 0) {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h(paramInt, (com.tencent.mm.plugin.multitalk.ui.widget.b)localObject));
      }
    }
  }
  
  public final void geE()
  {
    AppMethodBeat.i(284919);
    ac.ggS().ggf().b((g)this);
    AppMethodBeat.o(284919);
  }
  
  public final void geF()
  {
    AppMethodBeat.i(284945);
    Object localObject = this.Lmq;
    if ((localObject != null) && (((FrameLayout)localObject).getVisibility() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = this.Lmt;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).LsI;
          if (localObject != null)
          {
            localObject = ((MultitalkFrameView)localObject).getUsername();
            if (localObject == null) {}
          }
        }
      }
      switch (ac.ggS().ggc().aNq((String)localObject))
      {
      case 101: 
      case 102: 
      default: 
        gf((String)localObject, 3);
        AppMethodBeat.o(284945);
        return;
      }
    }
    geJ();
    AppMethodBeat.o(284945);
  }
  
  public final boolean geG()
  {
    AppMethodBeat.i(284952);
    Object localObject = this.Lmq;
    int i;
    boolean bool;
    if ((localObject != null) && (((FrameLayout)localObject).getVisibility() == 0))
    {
      i = 1;
      if (i == 0) {
        break label78;
      }
      localObject = this.Lmt;
      if (localObject != null) {
        break label56;
      }
      bool = false;
    }
    for (;;)
    {
      if (!bool) {
        break label78;
      }
      AppMethodBeat.o(284952);
      return true;
      i = 0;
      break;
      label56:
      localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).LsI;
      if (localObject == null) {
        bool = false;
      } else {
        bool = ((MultitalkFrameView)localObject).ghR();
      }
    }
    label78:
    AppMethodBeat.o(284952);
    return false;
  }
  
  public final String geH()
  {
    AppMethodBeat.i(284982);
    Object localObject = this.Lmt;
    if (localObject == null)
    {
      AppMethodBeat.o(284982);
      return "";
    }
    localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).LsI;
    if (localObject == null)
    {
      AppMethodBeat.o(284982);
      return "";
    }
    localObject = ((MultitalkFrameView)localObject).getUsername();
    if (localObject == null)
    {
      AppMethodBeat.o(284982);
      return "";
    }
    AppMethodBeat.o(284982);
    return localObject;
  }
  
  public final void geI()
  {
    int i = 1;
    AppMethodBeat.i(284996);
    if (!this.Lmy)
    {
      com.tencent.mm.plugin.multitalk.ui.widget.b localb = this.Lmt;
      if ((localb == null) || (localb.LsX != 1)) {
        break label57;
      }
    }
    for (;;)
    {
      if (i != 0) {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new i(this));
      }
      AppMethodBeat.o(284996);
      return;
      label57:
      i = 0;
    }
  }
  
  public final void gf(String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(284938);
        kotlin.g.b.s.u(paramString, "wxUserName");
        int j = ac.ggS().ggc().aNq(paramString);
        if (paramInt != 1) {
          break label172;
        }
        switch (j)
        {
        case 101: 
          Log.printInfoStack("AvatarViewManager", paramString + " to state " + i, new Object[0]);
          Object localObject = (kotlin.g.a.b)this.onl.get(Integer.valueOf(i));
          if (localObject != null) {
            ((kotlin.g.a.b)localObject).invoke(paramString);
          }
          if ((paramInt == 1) && (j == 102))
          {
            localObject = this.Lmw;
            if (localObject != null) {
              ((i)localObject).aMJ(paramString);
            }
          }
          AppMethodBeat.o(284938);
          return;
        }
      }
      finally {}
      int i = 3;
      continue;
      label172:
      i = paramInt;
    }
  }
  
  public final void iR(boolean paramBoolean)
  {
    AppMethodBeat.i(284975);
    Object localObject1 = this.Lmu;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject1).Lsx;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.multitalk.data.a)((Iterator)localObject1).next();
          Object localObject3 = ((com.tencent.mm.plugin.multitalk.data.a)localObject2).Liv.ahhi;
          kotlin.g.b.s.s(localObject3, "it.member.usrName");
          localObject3 = aMG((String)localObject3);
          if (localObject3 != null)
          {
            MTimerHandler localMTimerHandler = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).eln;
            if (localMTimerHandler != null) {
              localMTimerHandler.quitSafely();
            }
            localMTimerHandler = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).eln;
            if (localMTimerHandler != null) {
              localMTimerHandler.stopTimer();
            }
            localMTimerHandler = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).eln;
            if (localMTimerHandler != null) {
              localMTimerHandler.removeCallbacksAndMessages(null);
            }
            ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).eln = null;
          }
          localObject2 = ((com.tencent.mm.plugin.multitalk.data.a)localObject2).Liv.ahhi;
          kotlin.g.b.s.s(localObject2, "it.member.usrName");
          localObject2 = aMG((String)localObject2);
          if (localObject2 != null)
          {
            localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject2).LsI;
            if (localObject2 != null) {
              Log.i("MicroMsg.MultitalkFrameView", kotlin.g.b.s.X("release it ", Integer.valueOf(((MultitalkFrameView)localObject2).hashCode())));
            }
          }
        }
      }
    }
    if (paramBoolean)
    {
      localObject1 = this.Lmt;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).LsI;
        if (localObject1 != null)
        {
          localObject1 = ((MultitalkFrameView)localObject1).getUsername();
          if (localObject1 != null)
          {
            if (!geG()) {
              break label318;
            }
            gf((String)localObject1, 3);
          }
        }
      }
    }
    label406:
    label409:
    for (;;)
    {
      this.Lmt = null;
      this.Lmu = null;
      this.Lmr = null;
      ac.ggS().ggf().b((g)this);
      localObject1 = this.Lmu;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject1).LsE = null;
      }
      this.Lmw = null;
      ac.ggS().ggc().a(null);
      AppMethodBeat.o(284975);
      return;
      label318:
      localObject2 = this.Lmq;
      if ((localObject2 != null) && (((FrameLayout)localObject2).getVisibility() == 0))
      {
        i = 1;
        label339:
        if (i == 0) {
          break label406;
        }
        localObject2 = this.Lmt;
        if (localObject2 != null) {
          break label380;
        }
        paramBoolean = false;
        label356:
        if (!paramBoolean) {
          break label406;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label409;
        }
        gf((String)localObject1, 1);
        break;
        i = 0;
        break label339;
        label380:
        localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject2).LsI;
        if (localObject2 == null)
        {
          paramBoolean = false;
          break label356;
        }
        paramBoolean = ((MultitalkFrameView)localObject2).gfU();
        break label356;
      }
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(284925);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/model/AvatarViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    if (geG())
    {
      if (this.LmF)
      {
        paramView = this.Lms;
        if (paramView != null) {
          paramView.geR();
        }
      }
      for (this.LmF = false;; this.LmF = true)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/model/AvatarViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(284925);
        return;
        paramView = this.Lms;
        if (paramView != null) {
          paramView.geQ();
        }
      }
    }
    if (paramView == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.multitalk.ui.widget.MultitalkFrameView");
      AppMethodBeat.o(284925);
      throw paramView;
    }
    paramView = (MultitalkFrameView)paramView;
    if (paramView.getUsername() == null)
    {
      Log.e("AvatarViewManager", "videoview get null username");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/model/AvatarViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(284925);
      return;
    }
    localObject = this.Lmq;
    int i;
    if ((localObject != null) && (((FrameLayout)localObject).getVisibility() == 0))
    {
      i = 1;
      if (i != 0) {
        break label302;
      }
      if (!paramView.ghR()) {
        break label275;
      }
      gf(paramView.getUsername(), 4);
      o.LnY += 1;
      paramView = this.Lms;
      if (paramView != null) {
        paramView.geS();
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/model/AvatarViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(284925);
      return;
      i = 0;
      break;
      label275:
      gf(paramView.getUsername(), 2);
      paramView = this.Lms;
      if (paramView != null)
      {
        paramView.geT();
        continue;
        label302:
        if (paramView.ghR())
        {
          gf(paramView.getUsername(), 3);
          paramView = this.Lms;
          if (paramView != null) {
            paramView.geT();
          }
        }
        else
        {
          gf(paramView.getUsername(), 1);
          paramView = this.Lms;
          if (paramView != null) {
            paramView.geT();
          }
        }
      }
    }
  }
  
  public final void x(Set<String> paramSet)
  {
    AppMethodBeat.i(284958);
    kotlin.g.b.s.u(paramSet, "videoUserSet");
    Log.i("AvatarViewManager", "openMemberToVideo, %s", new Object[] { paramSet });
    Object localObject = this.Lmu;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject).Lsx;
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        label289:
        label307:
        label312:
        label346:
        label360:
        label363:
        while (localIterator.hasNext())
        {
          com.tencent.mm.plugin.multitalk.data.a locala = (com.tencent.mm.plugin.multitalk.data.a)localIterator.next();
          localObject = locala.Liv.ahhi;
          kotlin.g.b.s.s(localObject, "it.member.usrName");
          localObject = aMG((String)localObject);
          if (localObject == null)
          {
            localObject = null;
            label109:
            if (localObject != null) {
              break label346;
            }
            Log.i("AvatarViewManager", "UI not ready, just init state");
            if ((!paramSet.contains(locala.Liv.ahhi)) || (kotlin.g.b.s.p(z.bAM(), locala.Liv.ahhi))) {
              continue;
            }
            localObject = ac.ggS().ggc().Lpv;
            if ((localObject == null) || (((ArrayList)localObject).contains(locala.Liv.ahhi) != true)) {
              break label360;
            }
          }
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              break label363;
            }
            Log.i("AvatarViewManager", "init " + locala.Liv.ahhi + " to VIDEO_SMALL");
            localObject = locala.Liv.ahhi;
            kotlin.g.b.s.s(localObject, "it.member.usrName");
            gf((String)localObject, 1);
            break;
            localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).LsI;
            if (localObject == null)
            {
              localObject = null;
              break label109;
            }
            if ((!kotlin.g.b.s.p(z.bAM(), ((MultitalkFrameView)localObject).getUsername())) && (!((MultitalkFrameView)localObject).ghR()))
            {
              i = 1;
              if (i == 0) {
                break label307;
              }
            }
            for (;;)
            {
              if (localObject != null) {
                break label312;
              }
              localObject = null;
              break;
              i = 0;
              break label289;
              localObject = null;
            }
            if (paramSet.contains(((MultitalkFrameView)localObject).getUsername())) {
              if (((MultitalkFrameView)localObject).ghQ()) {
                gf(((MultitalkFrameView)localObject).getUsername(), 1);
              }
            }
            for (;;)
            {
              localObject = ah.aiuX;
              break label109;
              break;
              gf(((MultitalkFrameView)localObject).getUsername(), 0);
            }
          }
        }
      }
    }
    AppMethodBeat.o(284958);
  }
  
  public final void y(Set<String> paramSet)
  {
    AppMethodBeat.i(284963);
    kotlin.g.b.s.u(paramSet, "videoUserSet");
    Object localObject = this.Lmu;
    label74:
    com.tencent.mm.plugin.multitalk.data.a locala;
    int i;
    if (localObject == null)
    {
      localObject = null;
      Log.i("AvatarViewManager", "openMemberToVideo, %s,%s", new Object[] { paramSet, localObject });
      localObject = this.Lmu;
      if (localObject == null) {
        break label472;
      }
      localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject).Lsx;
      if (localObject == null) {
        break label472;
      }
      Iterator localIterator = ((Iterable)localObject).iterator();
      if (!localIterator.hasNext()) {
        break label472;
      }
      locala = (com.tencent.mm.plugin.multitalk.data.a)localIterator.next();
      localObject = ac.ggS().ggc().Lpv;
      if ((localObject == null) || (((ArrayList)localObject).contains(locala.Liv.ahhi) != true)) {
        break label257;
      }
      i = 1;
      label128:
      if (i == 0) {
        break label262;
      }
      Log.i("AvatarViewManager", "init " + locala.Liv.ahhi + " to SCREEN_CAST_SMALL");
      localObject = locala.Liv.ahhi;
      kotlin.g.b.s.s(localObject, "it.member.usrName");
      gf((String)localObject, 3);
      label190:
      localObject = locala.Liv.ahhi;
      kotlin.g.b.s.s(localObject, "it.member.usrName");
      localObject = aMG((String)localObject);
      if (localObject != null) {
        break label365;
      }
      localObject = null;
    }
    label257:
    label262:
    label401:
    label419:
    label424:
    for (;;)
    {
      label218:
      if (localObject == null)
      {
        Log.i("AvatarViewManager", "UI not ready, just init state user name is %s", new Object[] { locala.Liv.ahhi });
        break label74;
        localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject).Lsx;
        break;
        i = 0;
        break label128;
        if (paramSet.contains(locala.Liv.ahhi))
        {
          Log.i("AvatarViewManager", "init " + locala.Liv.ahhi + " to VIDEO_SMALL");
          localObject = locala.Liv.ahhi;
          kotlin.g.b.s.s(localObject, "it.member.usrName");
          gf((String)localObject, 1);
          break label190;
        }
        localObject = locala.Liv.ahhi;
        kotlin.g.b.s.s(localObject, "it.member.usrName");
        gf((String)localObject, 0);
        break label190;
        label365:
        localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).LsI;
        if (localObject == null)
        {
          localObject = null;
        }
        else
        {
          if ((!kotlin.g.b.s.p(z.bAM(), ((MultitalkFrameView)localObject).getUsername())) && (!((MultitalkFrameView)localObject).ghR()))
          {
            i = 1;
            if (i == 0) {
              break label419;
            }
          }
          for (;;)
          {
            if (localObject != null) {
              break label424;
            }
            localObject = null;
            break;
            i = 0;
            break label401;
            localObject = null;
          }
          if (!paramSet.contains(((MultitalkFrameView)localObject).getUsername())) {
            break label460;
          }
          if (((MultitalkFrameView)localObject).ghQ()) {
            gf(((MultitalkFrameView)localObject).getUsername(), 1);
          }
        }
      }
    }
    for (;;)
    {
      localObject = ah.aiuX;
      break label218;
      break;
      label460:
      gf(((MultitalkFrameView)localObject).getUsername(), 0);
    }
    label472:
    AppMethodBeat.o(284963);
  }
  
  public final void z(Set<String> paramSet)
  {
    AppMethodBeat.i(284969);
    kotlin.g.b.s.u(paramSet, "videoUserSet");
    Object localObject = this.Lmu;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject).Lsx;
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        while (localIterator.hasNext())
        {
          localObject = ((com.tencent.mm.plugin.multitalk.data.a)localIterator.next()).Liv.ahhi;
          kotlin.g.b.s.s(localObject, "it.member.usrName");
          localObject = aMG((String)localObject);
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).LsI;
            if (localObject != null)
            {
              int i;
              if ((((MultitalkFrameView)localObject).getUsername() != null) && (!kotlin.g.b.s.p(z.bAM(), ((MultitalkFrameView)localObject).getUsername())))
              {
                i = 1;
                label117:
                if (i == 0) {
                  break label155;
                }
              }
              for (;;)
              {
                if (localObject == null) {
                  break label158;
                }
                if (paramSet.contains(((MultitalkFrameView)localObject).getUsername())) {
                  break label160;
                }
                gf(((MultitalkFrameView)localObject).getUsername(), 0);
                break;
                i = 0;
                break label117;
                label155:
                localObject = null;
              }
              label158:
              continue;
              label160:
              if (((MultitalkFrameView)localObject).ghQ()) {
                gf(((MultitalkFrameView)localObject).getUsername(), 1);
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(284969);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManager$ScreenCastReceiverUiCallbackImpl;", "Lcom/tencent/mm/plugin/multitalk/model/IScreenCastUiCallback;", "(Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManager;)V", "markPause", "", "wxUserName", "", "markRestart", "markResume", "markStart", "markStop", "updateTask", "task", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements i
  {
    public b()
    {
      AppMethodBeat.i(284721);
      AppMethodBeat.o(284721);
    }
    
    public final void aMI(String paramString)
    {
      AppMethodBeat.i(284723);
      kotlin.g.b.s.u(paramString, "wxUserName");
      this.LmG.gf(paramString, 3);
      AppMethodBeat.o(284723);
    }
    
    public final void aMJ(String paramString)
    {
      Object localObject2 = null;
      AppMethodBeat.i(284726);
      kotlin.g.b.s.u(paramString, "wxUserName");
      Object localObject1 = this.LmG.aMG(paramString);
      boolean bool;
      if (localObject1 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).LsI;
        if (localObject3 != null) {
          break label142;
        }
        bool = false;
        if (!bool) {
          break label151;
        }
        label47:
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).aC(true, false);
        }
      }
      Object localObject3 = a.a(this.LmG);
      if (localObject3 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).LsI;
        if (localObject1 != null) {
          break label157;
        }
        localObject1 = null;
        label88:
        if (!kotlin.g.b.s.p(localObject1, paramString)) {
          break label175;
        }
        paramString = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).LsI;
        if (paramString != null) {
          break label167;
        }
        bool = false;
        label109:
        if (!bool) {
          break label175;
        }
      }
      label142:
      label151:
      label157:
      label167:
      label175:
      for (int i = 1;; i = 0)
      {
        paramString = localObject2;
        if (i != 0) {
          paramString = (String)localObject3;
        }
        if (paramString != null) {
          com.tencent.mm.plugin.multitalk.ui.widget.b.a(paramString, false, false, 3);
        }
        AppMethodBeat.o(284726);
        return;
        bool = ((MultitalkFrameView)localObject3).ghR();
        break;
        localObject1 = null;
        break label47;
        localObject1 = ((MultitalkFrameView)localObject1).getUsername();
        break label88;
        bool = paramString.ghR();
        break label109;
      }
    }
    
    public final void aMK(String paramString)
    {
      Object localObject1 = null;
      AppMethodBeat.i(284730);
      kotlin.g.b.s.u(paramString, "wxUserName");
      this.LmG.gf(paramString, 3);
      Object localObject2 = a.a(this.LmG);
      if (localObject2 == null) {}
      for (;;)
      {
        if (kotlin.g.b.s.p(localObject1, paramString)) {
          this.LmG.gf(paramString, 4);
        }
        AppMethodBeat.o(284730);
        return;
        localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject2).LsI;
        if (localObject2 != null) {
          localObject1 = ((MultitalkFrameView)localObject2).getUsername();
        }
      }
    }
    
    public final void aML(String paramString)
    {
      Object localObject2 = null;
      AppMethodBeat.i(284734);
      kotlin.g.b.s.u(paramString, "wxUserName");
      kotlin.g.a.b localb = (kotlin.g.a.b)a.LmH;
      Object localObject1 = this.LmG.aMG(paramString);
      boolean bool;
      if (localObject1 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).LsI;
        if (localObject3 != null) {
          break label245;
        }
        bool = false;
        if (!bool) {
          break label254;
        }
        label55:
        if (localObject1 != null) {
          localb.invoke(localObject1);
        }
      }
      Object localObject3 = a.a(this.LmG);
      if (localObject3 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).LsI;
        if (localObject1 != null) {
          break label260;
        }
        localObject1 = null;
        label99:
        if (!kotlin.g.b.s.p(localObject1, paramString)) {
          break label279;
        }
        localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).LsI;
        if (localObject1 != null) {
          break label270;
        }
        bool = false;
        label122:
        if (!bool) {
          break label279;
        }
        i = 1;
        label128:
        if (i == 0) {
          break label284;
        }
        localObject1 = localObject3;
        label136:
        if (localObject1 != null) {
          localb.invoke(localObject1);
        }
      }
      localObject3 = a.a(this.LmG);
      if (localObject3 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).LsI;
        if (localObject1 != null) {
          break label290;
        }
        localObject1 = null;
        label180:
        if (!kotlin.g.b.s.p(localObject1, paramString)) {
          break label308;
        }
        paramString = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).LsI;
        if (paramString != null) {
          break label300;
        }
        bool = false;
        label201:
        if (!bool) {
          break label308;
        }
      }
      label260:
      label270:
      label279:
      label284:
      label290:
      label300:
      label308:
      for (int i = 1;; i = 0)
      {
        paramString = localObject2;
        if (i != 0) {
          paramString = (String)localObject3;
        }
        if (paramString != null)
        {
          localObject1 = this.LmG;
          paramString.aC(false, false);
          a.a((a)localObject1, true);
        }
        AppMethodBeat.o(284734);
        return;
        label245:
        bool = ((MultitalkFrameView)localObject3).ghR();
        break;
        label254:
        localObject1 = null;
        break label55;
        localObject1 = ((MultitalkFrameView)localObject1).getUsername();
        break label99;
        bool = ((MultitalkFrameView)localObject1).ghR();
        break label122;
        i = 0;
        break label128;
        localObject1 = null;
        break label136;
        localObject1 = ((MultitalkFrameView)localObject1).getUsername();
        break label180;
        bool = paramString.ghR();
        break label201;
      }
    }
    
    public final void aMM(String paramString)
    {
      AppMethodBeat.i(284737);
      kotlin.g.b.s.u(paramString, "wxUserName");
      this.LmG.gf(paramString, 0);
      AppMethodBeat.o(284737);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<com.tencent.mm.plugin.multitalk.ui.widget.b, ah>
    {
      public static final a LmH;
      
      static
      {
        AppMethodBeat.i(284700);
        LmH = new a();
        AppMethodBeat.o(284700);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "wxUserName", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "wxUserName", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "wxUserName", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "wxUserName", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "wxUserName", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    g(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(int paramInt, com.tencent.mm.plugin.multitalk.ui.widget.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.a
 * JD-Core Version:    0.7.0.1
 */