package com.tencent.mm.plugin.multitalk.model;

import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import d.a.ae;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManager;", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTargetContainer;", "Landroid/view/View$OnClickListener;", "()V", "bigAvatarAdapter", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutAdapter;", "bigAvatarHolder", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "bigAvatarLayout", "Landroid/widget/RelativeLayout;", "dispatchToAvatarEvent", "Lkotlin/Function1;", "", "", "dispatchToScreenCastBigEvent", "dispatchToScreenCastSmallEvent", "dispatchToVideoBigEvent", "dispatchToVideoSmallEvent", "firstScreenUser", "handlerMap", "", "", "screenCastBigLoadingShow", "", "screenCastUiCallback", "Lcom/tencent/mm/plugin/multitalk/model/IScreenCastUiCallback;", "showElement", "talkingAvatarContainer", "Landroid/support/v7/widget/RecyclerView;", "talkingBigAvatarLayout", "Landroid/widget/FrameLayout;", "uiCallback", "Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManagerUiCallback;", "userStateMap", "Landroid/util/ArrayMap;", "videoDisplayDataMuxer", "Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer;", "getVideoDisplayDataMuxer", "()Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer;", "close", "closeMemberToVideo", "videoUserSet", "", "closeScreenCastBig", "displayVoiceTalkingIcon", "displayWeakNetWorkIcon", "finish", "isMini", "getAvatarViewGroupByUsername", "Landroid/view/View;", "wxUserName", "getAvatarViewHolderByUsername", "getBigHolderWxUserName", "getLargeRenderTarget", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "ori", "getNormalRenderTarget", "getUserState", "hideScreenCastBig", "hideVideoBig", "isBigAvatarScreenCastting", "isBigAvatarVideo", "isScreenCastPause", "onClick", "v", "onScreenFrame", "openMemberToVideo", "registerView", "mainUI", "Lcom/tencent/mm/plugin/multitalk/ui/MultiTalkMainUI;", "setBigAvatarUserState", "member", "Lcom/tencent/pb/talkroom/sdk/MultiTalkGroupMember;", "is2GOr3G", "currentVideoSet", "Ljava/util/HashSet;", "setMute", "isMute", "setStatus", "state", "showScreenCastBig", "showVideoBig", "unregisterView", "updateAvatar", "userStateTrans", "Companion", "ScreenCastReceiverUiCallbackImpl", "plugin-multitalk_release"})
public final class a
  implements View.OnClickListener, g
{
  public static final a.a wat;
  private final Map<Integer, d.g.a.b<String, d.z>> hIf;
  public RecyclerView wac;
  public FrameLayout wad;
  public RelativeLayout wae;
  public b waf;
  public com.tencent.mm.plugin.multitalk.ui.widget.b wag;
  public com.tencent.mm.plugin.multitalk.ui.widget.a wah;
  public ArrayMap<String, Integer> wai;
  public i waj;
  private String wak;
  private boolean wal;
  private ab wam;
  private final d.g.a.b<String, d.z> wan;
  private final d.g.a.b<String, d.z> wao;
  private final d.g.a.b<String, d.z> wap;
  private final d.g.a.b<String, d.z> waq;
  private final d.g.a.b<String, d.z> war;
  private boolean was;
  
  static
  {
    AppMethodBeat.i(206652);
    wat = new a.a((byte)0);
    AppMethodBeat.o(206652);
  }
  
  public a()
  {
    AppMethodBeat.i(206651);
    this.wai = new ArrayMap();
    this.wak = "";
    Object localObject = z.dqx();
    p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
    localObject = ((o)localObject).dpS();
    p.g(localObject, "SubCoreMultiTalk.getMult…kManager().videoDataMuxer");
    this.wam = ((ab)localObject);
    this.wan = ((d.g.a.b)new c(this));
    this.wao = ((d.g.a.b)new g(this));
    this.wap = ((d.g.a.b)new f(this));
    this.waq = ((d.g.a.b)new e(this));
    this.war = ((d.g.a.b)new d(this));
    this.hIf = ae.a(new d.o[] { d.u.S(Integer.valueOf(0), this.wan), d.u.S(Integer.valueOf(1), this.wao), d.u.S(Integer.valueOf(2), this.wap), d.u.S(Integer.valueOf(3), this.waq), d.u.S(Integer.valueOf(4), this.war) });
    this.was = true;
    AppMethodBeat.o(206651);
  }
  
  public final f Kx(final int paramInt)
  {
    AppMethodBeat.i(206647);
    Object localObject = this.wag;
    if (localObject != null) {
      if (1 <= paramInt) {}
    }
    for (localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).wex;; localObject = null)
    {
      localObject = (f)localObject;
      AppMethodBeat.o(206647);
      return localObject;
      if (5 < paramInt) {
        break;
      }
      c.g((d.g.a.a)new h((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject, paramInt));
      break;
    }
  }
  
  public final com.tencent.mm.plugin.multitalk.ui.widget.b aqY(String paramString)
  {
    AppMethodBeat.i(206641);
    p.h(paramString, "wxUserName");
    p.h(paramString, "wxUserName");
    com.tencent.mm.plugin.multitalk.ui.widget.a locala = this.wah;
    Object localObject1;
    label103:
    label115:
    int i;
    if (locala != null)
    {
      p.h(paramString, "userName");
      Iterator localIterator = ((Iterable)locala.wen).iterator();
      if (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        localObject1 = (com.tencent.mm.plugin.multitalk.data.a)localObject2;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.multitalk.data.a)localObject1).vZZ;
          if (localObject1 != null)
          {
            localObject1 = ((MultiTalkGroupMember)localObject1).LJH;
            if (!p.i(localObject1, paramString)) {
              break label198;
            }
            paramString = localObject2;
            paramString = (com.tencent.mm.plugin.multitalk.data.a)paramString;
            if (paramString == null) {
              break label205;
            }
            i = paramString.index;
            label129:
            int j = locala.sWU;
            paramString = this.wac;
            if (paramString == null) {
              break label210;
            }
            paramString = paramString.getChildAt(i + j);
            label152:
            if (paramString == null) {
              break label233;
            }
            localObject1 = this.wac;
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
    for (paramString = ((RecyclerView)localObject1).bh(paramString);; paramString = null)
    {
      if (!(paramString instanceof com.tencent.mm.plugin.multitalk.ui.widget.b)) {
        break label225;
      }
      paramString = (com.tencent.mm.plugin.multitalk.ui.widget.b)paramString;
      AppMethodBeat.o(206641);
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
    AppMethodBeat.o(206641);
    return null;
    label233:
    AppMethodBeat.o(206641);
    return null;
  }
  
  public final f aqZ(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(206648);
    p.h(paramString, "wxUserName");
    com.tencent.mm.plugin.multitalk.ui.widget.b localb = aqY(paramString);
    paramString = localObject;
    int i;
    if (localb != null)
    {
      if (localb.lN() < 0) {
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
        paramString = localb.wex;
      }
      paramString = (f)paramString;
      AppMethodBeat.o(206648);
      return paramString;
      label67:
      i = 0;
      break;
      label72:
      localb = null;
    }
  }
  
  public final ab doJ()
  {
    AppMethodBeat.i(206639);
    Object localObject = z.dqx();
    p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
    localObject = ((o)localObject).dpS();
    p.g(localObject, "SubCoreMultiTalk.getMult…kManager().videoDataMuxer");
    this.wam = ((ab)localObject);
    if (this.wam.wdk != null) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.wam;
        g localg = (g)this;
        p.h(localg, "targetContainer");
        if (!p.i(((ab)localObject).wdk, localg)) {
          ((ab)localObject).wdk = localg;
        }
      }
      localObject = this.wam;
      AppMethodBeat.o(206639);
      return localObject;
    }
  }
  
  public final boolean doK()
  {
    AppMethodBeat.i(206643);
    Object localObject = this.wad;
    if ((localObject != null) && (((FrameLayout)localObject).getVisibility() == 0))
    {
      localObject = this.wag;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).wex;
        if (localObject == null) {}
      }
      for (boolean bool = ((MultiTalkVideoView)localObject).dqX(); bool; bool = false)
      {
        AppMethodBeat.o(206643);
        return true;
      }
    }
    AppMethodBeat.o(206643);
    return false;
  }
  
  public final void doL()
  {
    AppMethodBeat.i(206649);
    if (!this.wal)
    {
      com.tencent.mm.plugin.multitalk.ui.widget.b localb = this.wag;
      if (localb == null) {
        break label51;
      }
      if (localb.weL != 1) {}
    }
    else
    {
      c.g((d.g.a.a)new i(this));
    }
    AppMethodBeat.o(206649);
    return;
    label51:
    AppMethodBeat.o(206649);
  }
  
  public final void doM()
  {
    AppMethodBeat.i(206650);
    Object localObject1 = this.wac;
    if (localObject1 != null) {
      ((RecyclerView)localObject1).setVisibility(0);
    }
    localObject1 = this.waf;
    if (localObject1 != null) {
      ((b)localObject1).doT();
    }
    localObject1 = this.waf;
    if (localObject1 != null) {
      b.a.a((b)localObject1, "");
    }
    localObject1 = this.wag;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).wex;
      if (localObject2 != null) {
        ((MultiTalkVideoView)localObject2).dqT();
      }
      com.tencent.mm.plugin.multitalk.ui.widget.b.b((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1);
      ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).dqH();
    }
    localObject1 = this.wad;
    if (localObject1 != null)
    {
      localObject2 = ((FrameLayout)localObject1).getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(206650);
        throw ((Throwable)localObject1);
      }
      localObject2 = (RelativeLayout.LayoutParams)localObject2;
      Object localObject3 = this.waf;
      if (localObject3 != null)
      {
        localObject3 = ((b)localObject3).doN();
        ((RelativeLayout.LayoutParams)localObject2).topMargin = (localObject3[1] - localObject3[0]);
      }
      ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((FrameLayout)localObject1).setVisibility(8);
    }
    z.dqx().arv("");
    AppMethodBeat.o(206650);
  }
  
  public final void eq(String paramString, int paramInt)
  {
    for (;;)
    {
      int j;
      try
      {
        AppMethodBeat.i(206642);
        p.h(paramString, "wxUserName");
        localObject = z.dqx();
        p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
        j = ((o)localObject).dpP().arA(paramString);
        if (paramInt != 1) {
          break label176;
        }
        if (j == 101) {
          break label181;
        }
        if (j != 102) {
          break label176;
        }
      }
      finally {}
      ad.i("AvatarViewManager", paramString + " to state " + i);
      Object localObject = (d.g.a.b)this.hIf.get(Integer.valueOf(i));
      if (localObject != null) {
        ((d.g.a.b)localObject).invoke(paramString);
      }
      if ((paramInt == 1) && (j == 102))
      {
        localObject = this.waj;
        if (localObject != null)
        {
          ((i)localObject).arb(paramString);
          AppMethodBeat.o(206642);
          return;
        }
      }
      AppMethodBeat.o(206642);
      continue;
      label176:
      int i = paramInt;
      continue;
      label181:
      i = 3;
    }
  }
  
  public final void gg(boolean paramBoolean)
  {
    AppMethodBeat.i(206646);
    Object localObject1 = this.wah;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject1).wen;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((com.tencent.mm.plugin.multitalk.data.a)((Iterator)localObject1).next()).vZZ.LJH;
          p.g(localObject2, "it.member.usrName");
          localObject2 = aqY((String)localObject2);
          if (localObject2 != null)
          {
            localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject2).wex;
            if (localObject2 != null) {
              ((MultiTalkVideoView)localObject2).finish();
            }
          }
        }
      }
    }
    if (paramBoolean)
    {
      localObject1 = this.wag;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).wex;
        if (localObject1 != null)
        {
          localObject1 = ((MultiTalkVideoView)localObject1).getUsername();
          if (localObject1 != null)
          {
            if (!doK()) {
              break label211;
            }
            p.g(localObject1, "it");
            eq((String)localObject1, 3);
          }
        }
      }
    }
    label259:
    label290:
    label293:
    for (;;)
    {
      this.wag = null;
      this.wah = null;
      this.wae = null;
      localObject1 = this.wah;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject1).wet = null;
      }
      this.waj = null;
      localObject1 = z.dqx();
      p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
      ((o)localObject1).dpP().a(null);
      AppMethodBeat.o(206646);
      return;
      label211:
      localObject2 = this.wad;
      if ((localObject2 != null) && (((FrameLayout)localObject2).getVisibility() == 0))
      {
        localObject2 = this.wag;
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject2).wex;
          if (localObject2 != null)
          {
            paramBoolean = ((MultiTalkVideoView)localObject2).dqW();
            if (!paramBoolean) {
              break label290;
            }
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label293;
        }
        p.g(localObject1, "it");
        eq((String)localObject1, 1);
        break;
        paramBoolean = false;
        break label259;
      }
    }
  }
  
  public final void n(Set<String> paramSet)
  {
    AppMethodBeat.i(206644);
    p.h(paramSet, "videoUserSet");
    Object localObject = this.wah;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject).wen;
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        while (localIterator.hasNext())
        {
          localObject = ((com.tencent.mm.plugin.multitalk.data.a)localIterator.next()).vZZ.LJH;
          p.g(localObject, "it.member.usrName");
          localObject = aqY((String)localObject);
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).wex;
            if (localObject != null)
            {
              int i;
              if ((((MultiTalkVideoView)localObject).getUsername() != null) && ((p.i(com.tencent.mm.model.u.aAm(), ((MultiTalkVideoView)localObject).getUsername()) ^ true)) && (!((MultiTalkVideoView)localObject).dqX()))
              {
                i = 1;
                label126:
                if (i == 0) {
                  break label180;
                }
              }
              for (;;)
              {
                if (localObject == null) {
                  break label183;
                }
                if (!paramSet.contains(((MultiTalkVideoView)localObject).getUsername())) {
                  break label185;
                }
                if (!((MultiTalkVideoView)localObject).dqV()) {
                  break;
                }
                localObject = ((MultiTalkVideoView)localObject).getUsername();
                p.g(localObject, "it.getUsername()");
                eq((String)localObject, 1);
                break;
                i = 0;
                break label126;
                label180:
                localObject = null;
              }
              label183:
              continue;
              label185:
              localObject = ((MultiTalkVideoView)localObject).getUsername();
              p.g(localObject, "it.getUsername()");
              eq((String)localObject, 0);
            }
          }
        }
        AppMethodBeat.o(206644);
        return;
      }
    }
    AppMethodBeat.o(206644);
  }
  
  public final void o(Set<String> paramSet)
  {
    AppMethodBeat.i(206645);
    p.h(paramSet, "videoUserSet");
    Object localObject = this.wah;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject).wen;
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        while (localIterator.hasNext())
        {
          localObject = ((com.tencent.mm.plugin.multitalk.data.a)localIterator.next()).vZZ.LJH;
          p.g(localObject, "it.member.usrName");
          localObject = aqY((String)localObject);
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).wex;
            if (localObject != null)
            {
              int i;
              if ((((MultiTalkVideoView)localObject).getUsername() != null) && ((p.i(com.tencent.mm.model.u.aAm(), ((MultiTalkVideoView)localObject).getUsername()) ^ true)))
              {
                i = 1;
                label119:
                if (i == 0) {
                  break label166;
                }
              }
              for (;;)
              {
                if (localObject == null) {
                  break label169;
                }
                if (paramSet.contains(((MultiTalkVideoView)localObject).getUsername())) {
                  break label171;
                }
                localObject = ((MultiTalkVideoView)localObject).getUsername();
                p.g(localObject, "it.getUsername()");
                eq((String)localObject, 0);
                break;
                i = 0;
                break label119;
                label166:
                localObject = null;
              }
              label169:
              continue;
              label171:
              if (((MultiTalkVideoView)localObject).dqV())
              {
                localObject = ((MultiTalkVideoView)localObject).getUsername();
                p.g(localObject, "it.getUsername()");
                eq((String)localObject, 1);
              }
            }
          }
        }
        AppMethodBeat.o(206645);
        return;
      }
    }
    AppMethodBeat.o(206645);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(206640);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/model/AvatarViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    if (doK())
    {
      if (this.was)
      {
        paramView = this.waf;
        if (paramView != null) {
          paramView.doV();
        }
      }
      for (this.was = false;; this.was = true)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/model/AvatarViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(206640);
        return;
        paramView = this.waf;
        if (paramView != null) {
          paramView.doU();
        }
      }
    }
    if (paramView == null)
    {
      paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView");
      AppMethodBeat.o(206640);
      throw paramView;
    }
    paramView = (MultiTalkVideoView)paramView;
    if (paramView.getUsername() == null)
    {
      ad.e("AvatarViewManager", "videoview get null username");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/model/AvatarViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(206640);
      return;
    }
    localObject = this.wad;
    if ((localObject == null) || (((FrameLayout)localObject).getVisibility() != 0)) {
      if (paramView.dqX())
      {
        paramView = paramView.getUsername();
        p.g(paramView, "videoView.getUsername()");
        eq(paramView, 4);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/model/AvatarViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(206640);
      return;
      paramView = paramView.getUsername();
      p.g(paramView, "videoView.getUsername()");
      eq(paramView, 2);
      continue;
      if (paramView.dqX())
      {
        paramView = paramView.getUsername();
        p.g(paramView, "videoView.getUsername()");
        eq(paramView, 3);
      }
      else
      {
        paramView = paramView.getUsername();
        p.g(paramView, "videoView.getUsername()");
        eq(paramView, 1);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManager$ScreenCastReceiverUiCallbackImpl;", "Lcom/tencent/mm/plugin/multitalk/model/IScreenCastUiCallback;", "(Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManager;)V", "markPause", "", "wxUserName", "", "markRestart", "markResume", "markStart", "markStop", "updateTask", "task", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "plugin-multitalk_release"})
  public final class b
    implements i
  {
    public final void ara(String paramString)
    {
      AppMethodBeat.i(206627);
      p.h(paramString, "wxUserName");
      this.wau.eq(paramString, 3);
      AppMethodBeat.o(206627);
    }
    
    public final void arb(String paramString)
    {
      Object localObject2 = null;
      AppMethodBeat.i(206628);
      p.h(paramString, "wxUserName");
      Object localObject1 = this.wau.aqY(paramString);
      boolean bool;
      if (localObject1 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).wex;
        if (localObject3 == null) {
          break label153;
        }
        bool = ((MultiTalkVideoView)localObject3).dqX();
        if (!bool) {
          break label158;
        }
        label51:
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).X(true, false);
        }
      }
      Object localObject3 = a.a(this.wau);
      if (localObject3 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).wex;
        if (localObject1 != null)
        {
          localObject1 = ((MultiTalkVideoView)localObject1).getUsername();
          label96:
          if (!p.i(localObject1, paramString)) {
            break label175;
          }
          paramString = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).wex;
          if (paramString == null) {
            break label170;
          }
          bool = paramString.dqX();
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
          AppMethodBeat.o(206628);
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
      AppMethodBeat.o(206628);
    }
    
    public final void arc(String paramString)
    {
      AppMethodBeat.i(206629);
      p.h(paramString, "wxUserName");
      this.wau.eq(paramString, 3);
      Object localObject = a.a(this.wau);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).wex;
        if (localObject == null) {}
      }
      for (localObject = ((MultiTalkVideoView)localObject).getUsername();; localObject = null)
      {
        if (p.i(localObject, paramString)) {
          this.wau.eq(paramString, 4);
        }
        AppMethodBeat.o(206629);
        return;
      }
    }
    
    public final void ard(String paramString)
    {
      Object localObject2 = null;
      AppMethodBeat.i(206630);
      p.h(paramString, "wxUserName");
      d.g.a.b localb = (d.g.a.b)a.wav;
      Object localObject1 = this.wau.aqY(paramString);
      boolean bool;
      if (localObject1 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).wex;
        if (localObject3 == null) {
          break label260;
        }
        bool = ((MultiTalkVideoView)localObject3).dqX();
        if (!bool) {
          break label265;
        }
        label59:
        if (localObject1 != null) {
          localb.invoke(localObject1);
        }
      }
      Object localObject3 = a.a(this.wau);
      label107:
      int i;
      if (localObject3 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).wex;
        if (localObject1 == null) {
          break label271;
        }
        localObject1 = ((MultiTalkVideoView)localObject1).getUsername();
        if (!p.i(localObject1, paramString)) {
          break label282;
        }
        localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).wex;
        if (localObject1 == null) {
          break label277;
        }
        bool = ((MultiTalkVideoView)localObject1).dqX();
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
      localObject3 = a.a(this.wau);
      if (localObject3 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).wex;
        if (localObject1 != null)
        {
          localObject1 = ((MultiTalkVideoView)localObject1).getUsername();
          label196:
          if (!p.i(localObject1, paramString)) {
            break label304;
          }
          paramString = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).wex;
          if (paramString == null) {
            break label299;
          }
          bool = paramString.dqX();
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
          paramString.X(false, false);
          a.a(this.wau, true);
          AppMethodBeat.o(206630);
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
      AppMethodBeat.o(206630);
    }
    
    public final void are(String paramString)
    {
      AppMethodBeat.i(206631);
      p.h(paramString, "wxUserName");
      this.wau.eq(paramString, 0);
      AppMethodBeat.o(206631);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "invoke"})
    static final class a
      extends q
      implements d.g.a.b<com.tencent.mm.plugin.multitalk.ui.widget.b, d.z>
    {
      public static final a wav;
      
      static
      {
        AppMethodBeat.i(206626);
        wav = new a();
        AppMethodBeat.o(206626);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "wxUserName", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.b<String, d.z>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "wxUserName", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<String, d.z>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "wxUserName", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.b<String, d.z>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "wxUserName", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.b<String, d.z>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "wxUserName", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.b<String, d.z>
  {
    g(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/multitalk/model/AvatarViewManager$getLargeRenderTarget$1$1"})
  static final class h
    extends q
    implements d.g.a.a<d.z>
  {
    h(com.tencent.mm.plugin.multitalk.ui.widget.b paramb, int paramInt)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements d.g.a.a<d.z>
  {
    i(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.a
 * JD-Core Version:    0.7.0.1
 */