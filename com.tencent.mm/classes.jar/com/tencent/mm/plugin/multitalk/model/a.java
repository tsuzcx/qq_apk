package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
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
import kotlin.l;
import kotlin.o;
import kotlin.s;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManager;", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTargetContainer;", "Landroid/view/View$OnClickListener;", "()V", "bigAvatarAdapter", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutAdapter;", "bigAvatarHolder", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "bigAvatarLayout", "Landroid/widget/RelativeLayout;", "dispatchToAvatarEvent", "Lkotlin/Function1;", "", "", "dispatchToScreenCastBigEvent", "dispatchToScreenCastSmallEvent", "dispatchToVideoBigEvent", "dispatchToVideoSmallEvent", "firstScreenUser", "handlerMap", "", "", "screenCastBigLoadingShow", "", "screenCastUiCallback", "Lcom/tencent/mm/plugin/multitalk/model/IScreenCastUiCallback;", "showElement", "talkingAvatarContainer", "Landroid/support/v7/widget/RecyclerView;", "talkingBigAvatarLayout", "Landroid/widget/FrameLayout;", "uiCallback", "Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManagerUiCallback;", "userStateMap", "Landroid/util/ArrayMap;", "videoDisplayDataMuxer", "Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer;", "getVideoDisplayDataMuxer", "()Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer;", "close", "closeMemberToVideo", "videoUserSet", "", "closeScreenCastBig", "displayVoiceTalkingIcon", "displayWeakNetWorkIcon", "finish", "isMini", "getAvatarViewGroupByUsername", "Landroid/view/View;", "wxUserName", "getAvatarViewHolderByUsername", "getBigHolderWxUserName", "getLargeRenderTarget", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "ori", "getNormalRenderTarget", "getUserState", "hideScreenCastBig", "hideVideoBig", "initCurrentViewStatus", "isBigAvatarScreenCastting", "isBigAvatarVideo", "isScreenCastPause", "onClick", "v", "onScreenFrame", "openMemberToVideo", "registerView", "mainUI", "Lcom/tencent/mm/plugin/multitalk/ui/MultiTalkMainUI;", "setBigAvatarUserState", "member", "Lcom/tencent/pb/talkroom/sdk/MultiTalkGroupMember;", "is2GOr3G", "currentVideoSet", "Ljava/util/HashSet;", "setMute", "isMute", "setStatus", "state", "showScreenCastBig", "showVideoBig", "unregisterView", "updateAvatar", "userStateTrans", "Companion", "ScreenCastReceiverUiCallbackImpl", "plugin-multitalk_release"})
public final class a
  implements View.OnClickListener, g
{
  public static final a.a zLe;
  private final Map<Integer, kotlin.g.a.b<String, x>> iFL;
  private RecyclerView zKN;
  private FrameLayout zKO;
  private RelativeLayout zKP;
  public b zKQ;
  com.tencent.mm.plugin.multitalk.ui.widget.b zKR;
  public com.tencent.mm.plugin.multitalk.ui.widget.a zKS;
  public ArrayMap<String, Integer> zKT;
  private i zKU;
  private String zKV;
  private boolean zKW;
  private ae zKX;
  private final kotlin.g.a.b<String, x> zKY;
  private final kotlin.g.a.b<String, x> zKZ;
  private final kotlin.g.a.b<String, x> zLa;
  private final kotlin.g.a.b<String, x> zLb;
  private final kotlin.g.a.b<String, x> zLc;
  private boolean zLd;
  
  static
  {
    AppMethodBeat.i(239592);
    zLe = new a.a((byte)0);
    AppMethodBeat.o(239592);
  }
  
  public a()
  {
    AppMethodBeat.i(239591);
    this.zKT = new ArrayMap();
    this.zKV = "";
    Object localObject = ac.eom();
    kotlin.g.b.p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
    localObject = ((q)localObject).enz();
    kotlin.g.b.p.g(localObject, "SubCoreMultiTalk.getMult…kManager().videoDataMuxer");
    this.zKX = ((ae)localObject);
    this.zKY = ((kotlin.g.a.b)new c(this));
    this.zKZ = ((kotlin.g.a.b)new g(this));
    this.zLa = ((kotlin.g.a.b)new f(this));
    this.zLb = ((kotlin.g.a.b)new e(this));
    this.zLc = ((kotlin.g.a.b)new d(this));
    this.iFL = kotlin.a.ae.e(new o[] { s.U(Integer.valueOf(0), this.zKY), s.U(Integer.valueOf(1), this.zKZ), s.U(Integer.valueOf(2), this.zLa), s.U(Integer.valueOf(3), this.zLb), s.U(Integer.valueOf(4), this.zLc) });
    this.zLd = true;
    AppMethodBeat.o(239591);
  }
  
  private final ae elY()
  {
    AppMethodBeat.i(239575);
    Object localObject1 = ac.eom();
    kotlin.g.b.p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    localObject1 = ((q)localObject1).enz();
    kotlin.g.b.p.g(localObject1, "SubCoreMultiTalk.getMult…kManager().videoDataMuxer");
    this.zKX = ((ae)localObject1);
    Object localObject2 = this.zKX;
    localObject1 = (g)this;
    kotlin.g.b.p.h(localObject1, "container");
    localObject2 = ((ae)localObject2).zPa;
    if ((localObject2 != null) && (((ArrayList)localObject2).contains(localObject1) == true)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.zKX.a((g)this);
      }
      localObject1 = this.zKX;
      AppMethodBeat.o(239575);
      return localObject1;
    }
  }
  
  private void elZ()
  {
    AppMethodBeat.i(239577);
    this.zKR = null;
    this.zKS = null;
    this.zKP = null;
    q localq = ac.eom();
    kotlin.g.b.p.g(localq, "SubCoreMultiTalk.getMultiTalkManager()");
    localq.enz().b((g)this);
    AppMethodBeat.o(239577);
  }
  
  private final void emd()
  {
    AppMethodBeat.i(239590);
    Object localObject1 = this.zKN;
    if (localObject1 != null) {
      ((RecyclerView)localObject1).setVisibility(0);
    }
    localObject1 = this.zKQ;
    if (localObject1 != null) {
      ((b)localObject1).emj();
    }
    localObject1 = this.zKQ;
    if (localObject1 != null) {
      b.a.a((b)localObject1, "");
    }
    localObject1 = this.zKR;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).zQT;
      if (localObject2 != null) {
        ((MultitalkFrameView)localObject2).epb();
      }
      com.tencent.mm.plugin.multitalk.ui.widget.b.b((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1);
      ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).eoB();
    }
    localObject1 = this.zKO;
    if (localObject1 != null)
    {
      localObject2 = ((FrameLayout)localObject1).getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(239590);
        throw ((Throwable)localObject1);
      }
      localObject2 = (RelativeLayout.LayoutParams)localObject2;
      Object localObject3 = this.zKQ;
      if (localObject3 != null)
      {
        localObject3 = ((b)localObject3).eme();
        ((RelativeLayout.LayoutParams)localObject2).topMargin = (localObject3[1] - localObject3[0]);
      }
      ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((FrameLayout)localObject1).setVisibility(8);
    }
    localObject1 = this.zKQ;
    if (localObject1 != null) {
      ((b)localObject1).emn();
    }
    ac.eom().bR("", true);
    AppMethodBeat.o(239590);
  }
  
  public final f Rc(final int paramInt)
  {
    AppMethodBeat.i(239587);
    Object localObject = this.zKR;
    if (localObject != null) {
      if (1 <= paramInt) {}
    }
    for (localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).zQT;; localObject = null)
    {
      localObject = (f)localObject;
      AppMethodBeat.o(239587);
      return localObject;
      if (5 < paramInt) {
        break;
      }
      d.h((kotlin.g.a.a)new h((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject, paramInt));
      break;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, FrameLayout paramFrameLayout, MultiTalkMainUI paramMultiTalkMainUI, b paramb)
  {
    AppMethodBeat.i(239576);
    kotlin.g.b.p.h(paramRecyclerView, "talkingAvatarContainer");
    kotlin.g.b.p.h(paramFrameLayout, "talkingBigAvatarLayout");
    kotlin.g.b.p.h(paramMultiTalkMainUI, "mainUI");
    kotlin.g.b.p.h(paramb, "uiCallback");
    this.zKQ = paramb;
    this.zKN = paramRecyclerView;
    this.zKO = paramFrameLayout;
    paramRecyclerView = paramRecyclerView.getAdapter();
    if (paramRecyclerView == null)
    {
      paramRecyclerView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.multitalk.ui.widget.AvatarLayoutAdapter");
      AppMethodBeat.o(239576);
      throw paramRecyclerView;
    }
    this.zKS = ((com.tencent.mm.plugin.multitalk.ui.widget.a)paramRecyclerView);
    paramRecyclerView = c.zRp;
    paramRecyclerView = (Context)paramMultiTalkMainUI;
    paramMultiTalkMainUI = (ViewGroup)paramFrameLayout;
    paramb = (View.OnClickListener)this;
    kotlin.g.b.p.h(paramRecyclerView, "context");
    kotlin.g.b.p.h(paramMultiTalkMainUI, "parent");
    kotlin.g.b.p.h(paramb, "clickListener");
    paramRecyclerView = LayoutInflater.from(paramRecyclerView).inflate(2131495411, paramMultiTalkMainUI, false);
    if (paramRecyclerView == null)
    {
      paramRecyclerView = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(239576);
      throw paramRecyclerView;
    }
    paramRecyclerView = (RelativeLayout)paramRecyclerView;
    paramMultiTalkMainUI = new com.tencent.mm.plugin.multitalk.ui.widget.b((View)paramRecyclerView);
    paramMultiTalkMainUI.zQT = ((MultitalkFrameView)paramRecyclerView.findViewById(2131308916));
    MultitalkFrameView localMultitalkFrameView = paramMultiTalkMainUI.zQT;
    if (localMultitalkFrameView != null) {
      localMultitalkFrameView.setIndex(0);
    }
    localMultitalkFrameView = paramMultiTalkMainUI.zQT;
    if (localMultitalkFrameView != null) {
      localMultitalkFrameView.setOnClickListener(paramb);
    }
    paramMultiTalkMainUI.maskView = paramRecyclerView.findViewById(2131304511);
    paramb = paramRecyclerView.findViewById(2131309946);
    if (paramb == null)
    {
      paramRecyclerView = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(239576);
      throw paramRecyclerView;
    }
    paramMultiTalkMainUI.zQU = ((ImageView)paramb);
    paramb = paramRecyclerView.findViewById(2131305074);
    if (paramb == null)
    {
      paramRecyclerView = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(239576);
      throw paramRecyclerView;
    }
    paramMultiTalkMainUI.zQV = ((ImageView)paramb);
    paramb = paramRecyclerView.findViewById(2131308801);
    if (paramb == null)
    {
      paramRecyclerView = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(239576);
      throw paramRecyclerView;
    }
    paramMultiTalkMainUI.zQW = ((TextView)paramb);
    paramb = paramRecyclerView.findViewById(2131303705);
    if (paramb == null)
    {
      paramRecyclerView = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(239576);
      throw paramRecyclerView;
    }
    paramMultiTalkMainUI.zhh = ((ImageView)paramb);
    paramRecyclerView.setTag(paramMultiTalkMainUI);
    this.zKP = paramRecyclerView;
    paramRecyclerView = this.zKP;
    if (paramRecyclerView != null) {}
    for (paramRecyclerView = paramRecyclerView.getTag(); paramRecyclerView == null; paramRecyclerView = null)
    {
      paramRecyclerView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.multitalk.ui.widget.AvatarLayoutHolder");
      AppMethodBeat.o(239576);
      throw paramRecyclerView;
    }
    this.zKR = ((com.tencent.mm.plugin.multitalk.ui.widget.b)paramRecyclerView);
    paramFrameLayout.addView((View)this.zKP);
    paramRecyclerView = this.zKP;
    if (paramRecyclerView != null) {
      paramRecyclerView.setVisibility(8);
    }
    paramFrameLayout.setVisibility(8);
    this.zKU = ((i)new b());
    paramRecyclerView = ac.eom();
    kotlin.g.b.p.g(paramRecyclerView, "SubCoreMultiTalk.getMultiTalkManager()");
    paramRecyclerView.enw().a(this.zKU);
    elY();
    AppMethodBeat.o(239576);
  }
  
  public final com.tencent.mm.plugin.multitalk.ui.widget.b aFA(String paramString)
  {
    AppMethodBeat.i(239579);
    kotlin.g.b.p.h(paramString, "wxUserName");
    kotlin.g.b.p.h(paramString, "wxUserName");
    com.tencent.mm.plugin.multitalk.ui.widget.a locala = this.zKS;
    Object localObject1;
    label103:
    label115:
    int i;
    if (locala != null)
    {
      kotlin.g.b.p.h(paramString, "userName");
      Iterator localIterator = ((Iterable)locala.zQI).iterator();
      if (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        localObject1 = (com.tencent.mm.plugin.multitalk.data.a)localObject2;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.multitalk.data.a)localObject1).zHg;
          if (localObject1 != null)
          {
            localObject1 = ((MultiTalkGroupMember)localObject1).RHb;
            if (!kotlin.g.b.p.j(localObject1, paramString)) {
              break label198;
            }
            paramString = localObject2;
            paramString = (com.tencent.mm.plugin.multitalk.data.a)paramString;
            if (paramString == null) {
              break label205;
            }
            i = paramString.index;
            label129:
            int j = locala.wqJ;
            paramString = this.zKN;
            if (paramString == null) {
              break label210;
            }
            paramString = paramString.getChildAt(i + j);
            label152:
            if (paramString == null) {
              break label233;
            }
            localObject1 = this.zKN;
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
    for (paramString = ((RecyclerView)localObject1).bi(paramString);; paramString = null)
    {
      if (!(paramString instanceof com.tencent.mm.plugin.multitalk.ui.widget.b)) {
        break label225;
      }
      paramString = (com.tencent.mm.plugin.multitalk.ui.widget.b)paramString;
      AppMethodBeat.o(239579);
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
    AppMethodBeat.o(239579);
    return null;
    label233:
    AppMethodBeat.o(239579);
    return null;
  }
  
  public final f aFB(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(239588);
    kotlin.g.b.p.h(paramString, "wxUserName");
    com.tencent.mm.plugin.multitalk.ui.widget.b localb = aFA(paramString);
    paramString = localObject;
    int i;
    if (localb != null)
    {
      if (localb.lR() < 0) {
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
        paramString = localb.zQT;
      }
      paramString = (f)paramString;
      AppMethodBeat.o(239588);
      return paramString;
      label67:
      i = 0;
      break;
      label72:
      localb = null;
    }
  }
  
  public final void eL(String paramString, int paramInt)
  {
    for (;;)
    {
      int j;
      try
      {
        AppMethodBeat.i(239580);
        kotlin.g.b.p.h(paramString, "wxUserName");
        localObject = ac.eom();
        kotlin.g.b.p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
        j = ((q)localObject).enw().aGj(paramString);
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
      Object localObject = (kotlin.g.a.b)this.iFL.get(Integer.valueOf(i));
      if (localObject != null) {
        ((kotlin.g.a.b)localObject).invoke(paramString);
      }
      if ((paramInt == 1) && (j == 102))
      {
        localObject = this.zKU;
        if (localObject != null)
        {
          ((i)localObject).aFC(paramString);
          AppMethodBeat.o(239580);
          return;
        }
      }
      AppMethodBeat.o(239580);
      continue;
      label180:
      int i = paramInt;
      continue;
      label185:
      i = 3;
    }
  }
  
  public final void ema()
  {
    AppMethodBeat.i(239581);
    Object localObject = this.zKO;
    if (localObject != null)
    {
      if (((FrameLayout)localObject).getVisibility() != 0) {
        break label111;
      }
      localObject = this.zKR;
      if (localObject == null) {
        break label111;
      }
      localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).zQT;
      if (localObject == null) {
        break label111;
      }
      localObject = ((MultitalkFrameView)localObject).getUsername();
      if (localObject == null) {
        break label111;
      }
      q localq = ac.eom();
      kotlin.g.b.p.g(localq, "SubCoreMultiTalk.getMultiTalkManager()");
      int i = localq.enw().aGj((String)localObject);
      if ((i == 103) || (i == 100))
      {
        emd();
        AppMethodBeat.o(239581);
      }
    }
    else
    {
      AppMethodBeat.o(239581);
      return;
    }
    eL((String)localObject, 3);
    AppMethodBeat.o(239581);
    return;
    label111:
    AppMethodBeat.o(239581);
  }
  
  public final boolean emb()
  {
    AppMethodBeat.i(239582);
    Object localObject = this.zKO;
    if ((localObject != null) && (((FrameLayout)localObject).getVisibility() == 0))
    {
      localObject = this.zKR;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).zQT;
        if (localObject == null) {}
      }
      for (boolean bool = ((MultitalkFrameView)localObject).epd(); bool; bool = false)
      {
        AppMethodBeat.o(239582);
        return true;
      }
    }
    AppMethodBeat.o(239582);
    return false;
  }
  
  public final void emc()
  {
    AppMethodBeat.i(239589);
    if (!this.zKW)
    {
      com.tencent.mm.plugin.multitalk.ui.widget.b localb = this.zKR;
      if (localb == null) {
        break label51;
      }
      if (localb.zRi != 1) {}
    }
    else
    {
      d.h((kotlin.g.a.a)new i(this));
    }
    AppMethodBeat.o(239589);
    return;
    label51:
    AppMethodBeat.o(239589);
  }
  
  public final void hb(boolean paramBoolean)
  {
    AppMethodBeat.i(239586);
    Object localObject1 = this.zKS;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject1).zQI;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.multitalk.data.a)((Iterator)localObject1).next();
          Object localObject3 = ((com.tencent.mm.plugin.multitalk.data.a)localObject2).zHg.RHb;
          kotlin.g.b.p.g(localObject3, "it.member.usrName");
          localObject3 = aFA((String)localObject3);
          if (localObject3 != null)
          {
            MTimerHandler localMTimerHandler = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).cve;
            if (localMTimerHandler != null) {
              localMTimerHandler.quitSafely();
            }
            localMTimerHandler = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).cve;
            if (localMTimerHandler != null) {
              localMTimerHandler.stopTimer();
            }
            localMTimerHandler = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).cve;
            if (localMTimerHandler != null) {
              localMTimerHandler.removeCallbacksAndMessages(null);
            }
            ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).cve = null;
          }
          localObject2 = ((com.tencent.mm.plugin.multitalk.data.a)localObject2).zHg.RHb;
          kotlin.g.b.p.g(localObject2, "it.member.usrName");
          localObject2 = aFA((String)localObject2);
          if (localObject2 != null)
          {
            localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject2).zQT;
            if (localObject2 != null) {
              Log.i("MicroMsg.MultitalkFrameView", "release it " + ((MultitalkFrameView)localObject2).hashCode());
            }
          }
        }
      }
    }
    if (paramBoolean)
    {
      localObject1 = this.zKR;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).zQT;
        if (localObject1 != null)
        {
          localObject1 = ((MultitalkFrameView)localObject1).getUsername();
          if (localObject1 != null)
          {
            if (!emb()) {
              break label309;
            }
            eL((String)localObject1, 3);
          }
        }
      }
    }
    label384:
    for (;;)
    {
      elZ();
      localObject1 = this.zKS;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject1).zQP = null;
      }
      this.zKU = null;
      localObject1 = ac.eom();
      kotlin.g.b.p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
      ((q)localObject1).enw().a(null);
      AppMethodBeat.o(239586);
      return;
      label309:
      localObject2 = this.zKO;
      if ((localObject2 != null) && (((FrameLayout)localObject2).getVisibility() == 0))
      {
        localObject2 = this.zKR;
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject2).zQT;
          if (localObject2 != null)
          {
            paramBoolean = ((MultitalkFrameView)localObject2).enp();
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
        eL((String)localObject1, 1);
        break;
        paramBoolean = false;
        break label357;
      }
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(239578);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/model/AvatarViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    if (emb())
    {
      if (this.zLd)
      {
        paramView = this.zKQ;
        if (paramView != null) {
          paramView.eml();
        }
      }
      for (this.zLd = false;; this.zLd = true)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/model/AvatarViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(239578);
        return;
        paramView = this.zKQ;
        if (paramView != null) {
          paramView.emk();
        }
      }
    }
    if (paramView == null)
    {
      paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.multitalk.ui.widget.MultitalkFrameView");
      AppMethodBeat.o(239578);
      throw paramView;
    }
    paramView = (MultitalkFrameView)paramView;
    if (paramView.getUsername() == null)
    {
      Log.e("AvatarViewManager", "videoview get null username");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/model/AvatarViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(239578);
      return;
    }
    localObject = this.zKO;
    if ((localObject == null) || (((FrameLayout)localObject).getVisibility() != 0)) {
      if (paramView.epd())
      {
        eL(paramView.getUsername(), 4);
        p.zMs += 1;
        paramView = this.zKQ;
        if (paramView != null) {
          paramView.emm();
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/model/AvatarViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(239578);
      return;
      eL(paramView.getUsername(), 2);
      paramView = this.zKQ;
      if (paramView != null)
      {
        paramView.emn();
        continue;
        if (paramView.epd())
        {
          eL(paramView.getUsername(), 3);
          paramView = this.zKQ;
          if (paramView != null) {
            paramView.emn();
          }
        }
        else
        {
          eL(paramView.getUsername(), 1);
          paramView = this.zKQ;
          if (paramView != null) {
            paramView.emn();
          }
        }
      }
    }
  }
  
  public final void p(Set<String> paramSet)
  {
    AppMethodBeat.i(239583);
    kotlin.g.b.p.h(paramSet, "videoUserSet");
    Log.i("AvatarViewManager", "openMemberToVideo, %s", new Object[] { paramSet });
    Object localObject = this.zKS;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject).zQI;
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
          localObject = locala.zHg.RHb;
          kotlin.g.b.p.g(localObject, "it.member.usrName");
          localObject = aFA((String)localObject);
          int i;
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).zQT;
            if (localObject != null) {
              if (((kotlin.g.b.p.j(z.aTY(), ((MultitalkFrameView)localObject).getUsername()) ^ true)) && (!((MultitalkFrameView)localObject).epd()))
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
                if (((MultitalkFrameView)localObject).epc()) {
                  eL(((MultitalkFrameView)localObject).getUsername(), 1);
                }
              }
            }
          }
          for (localObject = x.SXb;; localObject = null)
          {
            if (localObject != null) {
              break label354;
            }
            Log.i("AvatarViewManager", "UI not ready, just init state");
            if ((!paramSet.contains(locala.zHg.RHb)) || (!(kotlin.g.b.p.j(z.aTY(), locala.zHg.RHb) ^ true))) {
              break;
            }
            localObject = ac.eom();
            kotlin.g.b.p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
            localObject = ((q)localObject).enw().zNE;
            if ((localObject != null) && (((ArrayList)localObject).contains(locala.zHg.RHb) == true)) {
              break;
            }
            Log.i("AvatarViewManager", "init " + locala.zHg.RHb + " to VIDEO_SMALL");
            localObject = locala.zHg.RHb;
            kotlin.g.b.p.g(localObject, "it.member.usrName");
            eL((String)localObject, 1);
            break;
            i = 0;
            break label140;
            localObject = null;
            break label144;
            eL(((MultitalkFrameView)localObject).getUsername(), 0);
            break label177;
          }
        }
        AppMethodBeat.o(239583);
        return;
      }
    }
    AppMethodBeat.o(239583);
  }
  
  public final void q(Set<String> paramSet)
  {
    AppMethodBeat.i(239584);
    kotlin.g.b.p.h(paramSet, "videoUserSet");
    Object localObject = this.zKS;
    Iterator localIterator;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject).zQI;
      Log.i("AvatarViewManager", "openMemberToVideo, %s,%s", new Object[] { paramSet, localObject });
      localObject = this.zKS;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject).zQI;
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
        localObject = ac.eom();
        kotlin.g.b.p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
        localObject = ((q)localObject).enw().zNE;
        int i;
        if ((localObject != null) && (((ArrayList)localObject).contains(locala.zHg.RHb) == true))
        {
          Log.i("AvatarViewManager", "init " + locala.zHg.RHb + " to SCREEN_CAST_SMALL");
          localObject = locala.zHg.RHb;
          kotlin.g.b.p.g(localObject, "it.member.usrName");
          eL((String)localObject, 3);
          localObject = locala.zHg.RHb;
          kotlin.g.b.p.g(localObject, "it.member.usrName");
          localObject = aFA((String)localObject);
          if (localObject == null) {
            break label456;
          }
          localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).zQT;
          if (localObject == null) {
            break label456;
          }
          if ((!(kotlin.g.b.p.j(z.aTY(), ((MultitalkFrameView)localObject).getUsername()) ^ true)) || (((MultitalkFrameView)localObject).epd())) {
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
          if (((MultitalkFrameView)localObject).epc()) {
            eL(((MultitalkFrameView)localObject).getUsername(), 1);
          }
        }
        for (localObject = x.SXb;; localObject = null)
        {
          if (localObject != null) {
            break label459;
          }
          Log.i("AvatarViewManager", "UI not ready, just init state user name is %s", new Object[] { locala.zHg.RHb });
          break label77;
          localObject = null;
          break;
          if (paramSet.contains(locala.zHg.RHb))
          {
            Log.i("AvatarViewManager", "init " + locala.zHg.RHb + " to VIDEO_SMALL");
            localObject = locala.zHg.RHb;
            kotlin.g.b.p.g(localObject, "it.member.usrName");
            eL((String)localObject, 1);
            break label195;
          }
          localObject = locala.zHg.RHb;
          kotlin.g.b.p.g(localObject, "it.member.usrName");
          eL((String)localObject, 0);
          break label195;
          i = 0;
          break label254;
          localObject = null;
          break label258;
          eL(((MultitalkFrameView)localObject).getUsername(), 0);
          break label291;
        }
      }
      label258:
      label291:
      label434:
      label439:
      label444:
      label461:
      AppMethodBeat.o(239584);
      return;
    }
    AppMethodBeat.o(239584);
  }
  
  public final void r(Set<String> paramSet)
  {
    AppMethodBeat.i(239585);
    kotlin.g.b.p.h(paramSet, "videoUserSet");
    Object localObject = this.zKS;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject).zQI;
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        while (localIterator.hasNext())
        {
          localObject = ((com.tencent.mm.plugin.multitalk.data.a)localIterator.next()).zHg.RHb;
          kotlin.g.b.p.g(localObject, "it.member.usrName");
          localObject = aFA((String)localObject);
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).zQT;
            if (localObject != null)
            {
              int i;
              if ((((MultitalkFrameView)localObject).getUsername() != null) && ((kotlin.g.b.p.j(z.aTY(), ((MultitalkFrameView)localObject).getUsername()) ^ true)))
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
                eL(((MultitalkFrameView)localObject).getUsername(), 0);
                break;
                i = 0;
                break label119;
                label157:
                localObject = null;
              }
              label160:
              continue;
              label162:
              if (((MultitalkFrameView)localObject).epc()) {
                eL(((MultitalkFrameView)localObject).getUsername(), 1);
              }
            }
          }
        }
        AppMethodBeat.o(239585);
        return;
      }
    }
    AppMethodBeat.o(239585);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManager$ScreenCastReceiverUiCallbackImpl;", "Lcom/tencent/mm/plugin/multitalk/model/IScreenCastUiCallback;", "(Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManager;)V", "markPause", "", "wxUserName", "", "markRestart", "markResume", "markStart", "markStop", "updateTask", "task", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "plugin-multitalk_release"})
  public final class b
    implements i
  {
    public final void aFC(String paramString)
    {
      Object localObject2 = null;
      AppMethodBeat.i(239564);
      kotlin.g.b.p.h(paramString, "wxUserName");
      Object localObject1 = this.zLf.aFA(paramString);
      boolean bool;
      if (localObject1 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).zQT;
        if (localObject3 == null) {
          break label153;
        }
        bool = ((MultitalkFrameView)localObject3).epd();
        if (!bool) {
          break label158;
        }
        label51:
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).Z(true, false);
        }
      }
      Object localObject3 = a.a(this.zLf);
      if (localObject3 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).zQT;
        if (localObject1 != null)
        {
          localObject1 = ((MultitalkFrameView)localObject1).getUsername();
          label96:
          if (!kotlin.g.b.p.j(localObject1, paramString)) {
            break label175;
          }
          paramString = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).zQT;
          if (paramString == null) {
            break label170;
          }
          bool = paramString.epd();
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
          AppMethodBeat.o(239564);
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
      AppMethodBeat.o(239564);
    }
    
    public final void aFD(String paramString)
    {
      AppMethodBeat.i(239565);
      kotlin.g.b.p.h(paramString, "wxUserName");
      this.zLf.eL(paramString, 3);
      Object localObject = a.a(this.zLf);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).zQT;
        if (localObject == null) {}
      }
      for (localObject = ((MultitalkFrameView)localObject).getUsername();; localObject = null)
      {
        if (kotlin.g.b.p.j(localObject, paramString)) {
          this.zLf.eL(paramString, 4);
        }
        AppMethodBeat.o(239565);
        return;
      }
    }
    
    public final void aFE(String paramString)
    {
      Object localObject2 = null;
      AppMethodBeat.i(239566);
      kotlin.g.b.p.h(paramString, "wxUserName");
      kotlin.g.a.b localb = (kotlin.g.a.b)a.zLg;
      Object localObject1 = this.zLf.aFA(paramString);
      boolean bool;
      if (localObject1 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).zQT;
        if (localObject3 == null) {
          break label260;
        }
        bool = ((MultitalkFrameView)localObject3).epd();
        if (!bool) {
          break label265;
        }
        label59:
        if (localObject1 != null) {
          localb.invoke(localObject1);
        }
      }
      Object localObject3 = a.a(this.zLf);
      label107:
      int i;
      if (localObject3 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).zQT;
        if (localObject1 == null) {
          break label271;
        }
        localObject1 = ((MultitalkFrameView)localObject1).getUsername();
        if (!kotlin.g.b.p.j(localObject1, paramString)) {
          break label282;
        }
        localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).zQT;
        if (localObject1 == null) {
          break label277;
        }
        bool = ((MultitalkFrameView)localObject1).epd();
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
      localObject3 = a.a(this.zLf);
      if (localObject3 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).zQT;
        if (localObject1 != null)
        {
          localObject1 = ((MultitalkFrameView)localObject1).getUsername();
          label196:
          if (!kotlin.g.b.p.j(localObject1, paramString)) {
            break label304;
          }
          paramString = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).zQT;
          if (paramString == null) {
            break label299;
          }
          bool = paramString.epd();
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
          paramString.Z(false, false);
          a.a(this.zLf, true);
          AppMethodBeat.o(239566);
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
      AppMethodBeat.o(239566);
    }
    
    public final void aFF(String paramString)
    {
      AppMethodBeat.i(239567);
      kotlin.g.b.p.h(paramString, "wxUserName");
      this.zLf.eL(paramString, 0);
      AppMethodBeat.o(239567);
    }
    
    public final void afd(String paramString)
    {
      AppMethodBeat.i(239563);
      kotlin.g.b.p.h(paramString, "wxUserName");
      this.zLf.eL(paramString, 3);
      AppMethodBeat.o(239563);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.b<com.tencent.mm.plugin.multitalk.ui.widget.b, x>
    {
      public static final a zLg;
      
      static
      {
        AppMethodBeat.i(239562);
        zLg = new a();
        AppMethodBeat.o(239562);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "wxUserName", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "wxUserName", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "wxUserName", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "wxUserName", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "wxUserName", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    g(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/multitalk/model/AvatarViewManager$getLargeRenderTarget$1$1"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    h(com.tencent.mm.plugin.multitalk.ui.widget.b paramb, int paramInt)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.a
 * JD-Core Version:    0.7.0.1
 */