package com.tencent.mm.plugin.multitalk.model;

import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView;
import com.tencent.mm.plugin.voip.ui.d;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.u;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManager;", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTargetContainer;", "Landroid/view/View$OnClickListener;", "()V", "bigAvatarAdapter", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutAdapter;", "bigAvatarHolder", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "bigAvatarLayout", "Landroid/widget/RelativeLayout;", "dispatchToAvatarEvent", "Lkotlin/Function1;", "", "", "dispatchToScreenCastBigEvent", "dispatchToScreenCastSmallEvent", "dispatchToVideoBigEvent", "dispatchToVideoSmallEvent", "firstScreenUser", "handlerMap", "", "", "screenCastBigLoadingShow", "", "screenCastUiCallback", "Lcom/tencent/mm/plugin/multitalk/model/IScreenCastUiCallback;", "showElement", "talkingAvatarContainer", "Landroid/support/v7/widget/RecyclerView;", "talkingBigAvatarLayout", "Landroid/widget/FrameLayout;", "uiCallback", "Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManagerUiCallback;", "userStateMap", "Landroid/util/ArrayMap;", "videoDisplayDataMuxer", "Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer;", "getVideoDisplayDataMuxer", "()Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer;", "close", "closeMemberToVideo", "videoUserSet", "", "closeScreenCastBig", "displayVoiceTalkingIcon", "displayWeakNetWorkIcon", "finish", "isMini", "getAvatarViewGroupByUsername", "Landroid/view/View;", "wxUserName", "getAvatarViewHolderByUsername", "getBigHolderWxUserName", "getLargeRenderTarget", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "ori", "getNormalRenderTarget", "getUserState", "hideScreenCastBig", "hideVideoBig", "isBigAvatarScreenCastting", "isBigAvatarVideo", "isScreenCastPause", "onClick", "v", "onScreenFrame", "openMemberToVideo", "registerView", "mainUI", "Lcom/tencent/mm/plugin/multitalk/ui/MultiTalkMainUI;", "setBigAvatarUserState", "member", "Lcom/tencent/pb/talkroom/sdk/MultiTalkGroupMember;", "is2GOr3G", "currentVideoSet", "Ljava/util/HashSet;", "setMute", "isMute", "setStatus", "state", "showScreenCastBig", "showVideoBig", "unregisterView", "updateAvatar", "userStateTrans", "Companion", "ScreenCastReceiverUiCallbackImpl", "plugin-multitalk_release"})
public final class a
  implements View.OnClickListener, g
{
  public static final a.a wpS;
  private final Map<Integer, d.g.a.b<String, d.z>> hKX;
  public RecyclerView wpB;
  public FrameLayout wpC;
  public RelativeLayout wpD;
  public b wpE;
  public com.tencent.mm.plugin.multitalk.ui.widget.b wpF;
  public com.tencent.mm.plugin.multitalk.ui.widget.a wpG;
  public ArrayMap<String, Integer> wpH;
  public i wpI;
  private String wpJ;
  private boolean wpK;
  private ab wpL;
  private final d.g.a.b<String, d.z> wpM;
  private final d.g.a.b<String, d.z> wpN;
  private final d.g.a.b<String, d.z> wpO;
  private final d.g.a.b<String, d.z> wpP;
  private final d.g.a.b<String, d.z> wpQ;
  private boolean wpR;
  
  static
  {
    AppMethodBeat.i(190922);
    wpS = new a.a((byte)0);
    AppMethodBeat.o(190922);
  }
  
  public a()
  {
    AppMethodBeat.i(190921);
    this.wpH = new ArrayMap();
    this.wpJ = "";
    Object localObject = z.dtK();
    p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
    localObject = ((o)localObject).dte();
    p.g(localObject, "SubCoreMultiTalk.getMult…kManager().videoDataMuxer");
    this.wpL = ((ab)localObject);
    this.wpM = ((d.g.a.b)new c(this));
    this.wpN = ((d.g.a.b)new g(this));
    this.wpO = ((d.g.a.b)new f(this));
    this.wpP = ((d.g.a.b)new e(this));
    this.wpQ = ((d.g.a.b)new d(this));
    this.hKX = d.a.ae.a(new d.o[] { u.R(Integer.valueOf(0), this.wpM), u.R(Integer.valueOf(1), this.wpN), u.R(Integer.valueOf(2), this.wpO), u.R(Integer.valueOf(3), this.wpP), u.R(Integer.valueOf(4), this.wpQ) });
    this.wpR = true;
    AppMethodBeat.o(190921);
  }
  
  public final f Lc(final int paramInt)
  {
    AppMethodBeat.i(190917);
    Object localObject = this.wpF;
    if (localObject != null) {
      if (1 <= paramInt) {}
    }
    for (localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).wua;; localObject = null)
    {
      localObject = (f)localObject;
      AppMethodBeat.o(190917);
      return localObject;
      if (5 < paramInt) {
        break;
      }
      com.tencent.mm.ac.c.h((d.g.a.a)new h((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject, paramInt));
      break;
    }
  }
  
  public final com.tencent.mm.plugin.multitalk.ui.widget.b asg(String paramString)
  {
    AppMethodBeat.i(190910);
    p.h(paramString, "wxUserName");
    p.h(paramString, "wxUserName");
    com.tencent.mm.plugin.multitalk.ui.widget.a locala = this.wpG;
    Object localObject1;
    label103:
    label115:
    int i;
    if (locala != null)
    {
      p.h(paramString, "userName");
      Iterator localIterator = ((Iterable)locala.wtQ).iterator();
      if (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        localObject1 = (com.tencent.mm.plugin.multitalk.data.a)localObject2;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.multitalk.data.a)localObject1).wmd;
          if (localObject1 != null)
          {
            localObject1 = ((MultiTalkGroupMember)localObject1).MgJ;
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
            int j = locala.tii;
            paramString = this.wpB;
            if (paramString == null) {
              break label210;
            }
            paramString = paramString.getChildAt(i + j);
            label152:
            if (paramString == null) {
              break label233;
            }
            localObject1 = this.wpB;
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
      AppMethodBeat.o(190910);
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
    AppMethodBeat.o(190910);
    return null;
    label233:
    AppMethodBeat.o(190910);
    return null;
  }
  
  public final f ash(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(190918);
    p.h(paramString, "wxUserName");
    com.tencent.mm.plugin.multitalk.ui.widget.b localb = asg(paramString);
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
        paramString = localb.wua;
      }
      paramString = (f)paramString;
      AppMethodBeat.o(190918);
      return paramString;
      label67:
      i = 0;
      break;
      label72:
      localb = null;
    }
  }
  
  public final ab drS()
  {
    AppMethodBeat.i(190908);
    Object localObject = z.dtK();
    p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
    localObject = ((o)localObject).dte();
    p.g(localObject, "SubCoreMultiTalk.getMult…kManager().videoDataMuxer");
    this.wpL = ((ab)localObject);
    if (this.wpL.wsM != null) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.wpL;
        g localg = (g)this;
        p.h(localg, "targetContainer");
        if (!p.i(((ab)localObject).wsM, localg)) {
          ((ab)localObject).wsM = localg;
        }
      }
      localObject = this.wpL;
      AppMethodBeat.o(190908);
      return localObject;
    }
  }
  
  public final boolean drT()
  {
    AppMethodBeat.i(190912);
    Object localObject = this.wpC;
    if ((localObject != null) && (((FrameLayout)localObject).getVisibility() == 0))
    {
      localObject = this.wpF;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).wua;
        if (localObject == null) {}
      }
      for (boolean bool = ((MultiTalkVideoView)localObject).duj(); bool; bool = false)
      {
        AppMethodBeat.o(190912);
        return true;
      }
    }
    AppMethodBeat.o(190912);
    return false;
  }
  
  public final void drU()
  {
    AppMethodBeat.i(190913);
    Object localObject1 = z.dtK();
    p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    localObject1 = ((o)localObject1).dts();
    Object localObject2 = this.wpG;
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject2).wtQ;
      if (localObject2 != null)
      {
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (com.tencent.mm.plugin.multitalk.data.a)((Iterator)localObject2).next();
          if ((localObject1 != null) && (((List)localObject1).contains(((com.tencent.mm.plugin.multitalk.data.a)localObject3).wmd.MgJ) == true))
          {
            Object localObject4 = ((com.tencent.mm.plugin.multitalk.data.a)localObject3).wmd.MgJ;
            p.g(localObject4, "it.member.usrName");
            localObject4 = asg((String)localObject4);
            if (localObject4 != null)
            {
              localObject4 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject4).wuc;
              if (localObject4 != null) {
                ((ImageView)localObject4).setVisibility(0);
              }
            }
            boolean bool = p.i(com.tencent.mm.model.v.aAC(), ((com.tencent.mm.plugin.multitalk.data.a)localObject3).wmd.MgJ);
            n.oU(bool);
            if (bool) {
              com.tencent.mm.plugin.voip.c.eyt().tC(true);
            }
          }
          else
          {
            localObject3 = ((com.tencent.mm.plugin.multitalk.data.a)localObject3).wmd.MgJ;
            p.g(localObject3, "it.member.usrName");
            localObject3 = asg((String)localObject3);
            if (localObject3 != null)
            {
              localObject3 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).wuc;
              if (localObject3 != null) {
                ((ImageView)localObject3).setVisibility(8);
              }
            }
          }
        }
        AppMethodBeat.o(190913);
        return;
      }
    }
    AppMethodBeat.o(190913);
  }
  
  public final void drV()
  {
    AppMethodBeat.i(190919);
    if (!this.wpK)
    {
      com.tencent.mm.plugin.multitalk.ui.widget.b localb = this.wpF;
      if (localb == null) {
        break label51;
      }
      if (localb.wuo != 1) {}
    }
    else
    {
      com.tencent.mm.ac.c.h((d.g.a.a)new i(this));
    }
    AppMethodBeat.o(190919);
    return;
    label51:
    AppMethodBeat.o(190919);
  }
  
  public final void drW()
  {
    AppMethodBeat.i(190920);
    Object localObject1 = this.wpB;
    if (localObject1 != null) {
      ((RecyclerView)localObject1).setVisibility(0);
    }
    localObject1 = this.wpE;
    if (localObject1 != null) {
      ((b)localObject1).dsd();
    }
    localObject1 = this.wpE;
    if (localObject1 != null) {
      b.a.a((b)localObject1, "");
    }
    localObject1 = this.wpF;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).wua;
      if (localObject2 != null) {
        ((MultiTalkVideoView)localObject2).duf();
      }
      com.tencent.mm.plugin.multitalk.ui.widget.b.b((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1);
      ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).dtU();
    }
    localObject1 = this.wpC;
    if (localObject1 != null)
    {
      localObject2 = ((FrameLayout)localObject1).getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(190920);
        throw ((Throwable)localObject1);
      }
      localObject2 = (RelativeLayout.LayoutParams)localObject2;
      Object localObject3 = this.wpE;
      if (localObject3 != null)
      {
        localObject3 = ((b)localObject3).drX();
        ((RelativeLayout.LayoutParams)localObject2).topMargin = (localObject3[1] - localObject3[0]);
      }
      ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((FrameLayout)localObject1).setVisibility(8);
    }
    z.dtK().asG("");
    AppMethodBeat.o(190920);
  }
  
  public final void ex(String paramString, int paramInt)
  {
    for (;;)
    {
      int j;
      try
      {
        AppMethodBeat.i(190911);
        p.h(paramString, "wxUserName");
        localObject = z.dtK();
        p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
        j = ((o)localObject).dtb().asL(paramString);
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
      com.tencent.mm.sdk.platformtools.ae.i("AvatarViewManager", paramString + " to state " + i);
      Object localObject = (d.g.a.b)this.hKX.get(Integer.valueOf(i));
      if (localObject != null) {
        ((d.g.a.b)localObject).invoke(paramString);
      }
      if ((paramInt == 1) && (j == 102))
      {
        localObject = this.wpI;
        if (localObject != null)
        {
          ((i)localObject).asj(paramString);
          AppMethodBeat.o(190911);
          return;
        }
      }
      AppMethodBeat.o(190911);
      continue;
      label176:
      int i = paramInt;
      continue;
      label181:
      i = 3;
    }
  }
  
  public final void ge(boolean paramBoolean)
  {
    AppMethodBeat.i(190916);
    Object localObject1 = this.wpG;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject1).wtQ;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((com.tencent.mm.plugin.multitalk.data.a)((Iterator)localObject1).next()).wmd.MgJ;
          p.g(localObject2, "it.member.usrName");
          localObject2 = asg((String)localObject2);
          if (localObject2 != null)
          {
            localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject2).wua;
            if (localObject2 != null) {
              ((MultiTalkVideoView)localObject2).finish();
            }
          }
        }
      }
    }
    if (paramBoolean)
    {
      localObject1 = this.wpF;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).wua;
        if (localObject1 != null)
        {
          localObject1 = ((MultiTalkVideoView)localObject1).getUsername();
          if (localObject1 != null)
          {
            if (!drT()) {
              break label211;
            }
            p.g(localObject1, "it");
            ex((String)localObject1, 3);
          }
        }
      }
    }
    label259:
    label290:
    label293:
    for (;;)
    {
      this.wpF = null;
      this.wpG = null;
      this.wpD = null;
      localObject1 = this.wpG;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject1).wtW = null;
      }
      this.wpI = null;
      localObject1 = z.dtK();
      p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
      ((o)localObject1).dtb().a(null);
      AppMethodBeat.o(190916);
      return;
      label211:
      localObject2 = this.wpC;
      if ((localObject2 != null) && (((FrameLayout)localObject2).getVisibility() == 0))
      {
        localObject2 = this.wpF;
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject2).wua;
          if (localObject2 != null)
          {
            paramBoolean = ((MultiTalkVideoView)localObject2).dui();
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
        ex((String)localObject1, 1);
        break;
        paramBoolean = false;
        break label259;
      }
    }
  }
  
  public final void n(Set<String> paramSet)
  {
    AppMethodBeat.i(190914);
    p.h(paramSet, "videoUserSet");
    com.tencent.mm.sdk.platformtools.ae.i("AvatarViewManager", "openMemberToVideo, %s", new Object[] { paramSet });
    Object localObject = this.wpG;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject).wtQ;
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        label147:
        label151:
        label193:
        label322:
        while (localIterator.hasNext())
        {
          com.tencent.mm.plugin.multitalk.data.a locala = (com.tencent.mm.plugin.multitalk.data.a)localIterator.next();
          localObject = locala.wmd.MgJ;
          p.g(localObject, "it.member.usrName");
          localObject = asg((String)localObject);
          int i;
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).wua;
            if (localObject != null) {
              if ((((MultiTalkVideoView)localObject).getUsername() != null) && ((p.i(com.tencent.mm.model.v.aAC(), ((MultiTalkVideoView)localObject).getUsername()) ^ true)) && (!((MultiTalkVideoView)localObject).duj()))
              {
                i = 1;
                if (i == 0) {
                  break label293;
                }
                if (localObject == null) {
                  break label319;
                }
                if (!paramSet.contains(((MultiTalkVideoView)localObject).getUsername())) {
                  break label298;
                }
                if (((MultiTalkVideoView)localObject).duh())
                {
                  localObject = ((MultiTalkVideoView)localObject).getUsername();
                  p.g(localObject, "it.getUsername()");
                  ex((String)localObject, 1);
                }
              }
            }
          }
          for (localObject = d.z.Nhr;; localObject = null)
          {
            if (localObject != null) {
              break label322;
            }
            com.tencent.mm.sdk.platformtools.ae.i("AvatarViewManager", "UI not ready, just init state");
            if (!paramSet.contains(locala.wmd.MgJ)) {
              break;
            }
            com.tencent.mm.sdk.platformtools.ae.i("AvatarViewManager", "init " + locala.wmd.MgJ + " to VIDEO_SMALL");
            localObject = locala.wmd.MgJ;
            p.g(localObject, "it.member.usrName");
            ex((String)localObject, 1);
            break;
            i = 0;
            break label147;
            localObject = null;
            break label151;
            localObject = ((MultiTalkVideoView)localObject).getUsername();
            p.g(localObject, "it.getUsername()");
            ex((String)localObject, 0);
            break label193;
          }
        }
        label293:
        label298:
        label319:
        AppMethodBeat.o(190914);
        return;
      }
    }
    AppMethodBeat.o(190914);
  }
  
  public final void o(Set<String> paramSet)
  {
    AppMethodBeat.i(190915);
    p.h(paramSet, "videoUserSet");
    Object localObject = this.wpG;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject).wtQ;
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        while (localIterator.hasNext())
        {
          localObject = ((com.tencent.mm.plugin.multitalk.data.a)localIterator.next()).wmd.MgJ;
          p.g(localObject, "it.member.usrName");
          localObject = asg((String)localObject);
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).wua;
            if (localObject != null)
            {
              int i;
              if ((((MultiTalkVideoView)localObject).getUsername() != null) && ((p.i(com.tencent.mm.model.v.aAC(), ((MultiTalkVideoView)localObject).getUsername()) ^ true)))
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
                ex((String)localObject, 0);
                break;
                i = 0;
                break label119;
                label166:
                localObject = null;
              }
              label169:
              continue;
              label171:
              if (((MultiTalkVideoView)localObject).duh())
              {
                localObject = ((MultiTalkVideoView)localObject).getUsername();
                p.g(localObject, "it.getUsername()");
                ex((String)localObject, 1);
              }
            }
          }
        }
        AppMethodBeat.o(190915);
        return;
      }
    }
    AppMethodBeat.o(190915);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(190909);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/model/AvatarViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    if (drT())
    {
      if (this.wpR)
      {
        paramView = this.wpE;
        if (paramView != null) {
          paramView.dsf();
        }
      }
      for (this.wpR = false;; this.wpR = true)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/model/AvatarViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(190909);
        return;
        paramView = this.wpE;
        if (paramView != null) {
          paramView.dse();
        }
      }
    }
    if (paramView == null)
    {
      paramView = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView");
      AppMethodBeat.o(190909);
      throw paramView;
    }
    paramView = (MultiTalkVideoView)paramView;
    if (paramView.getUsername() == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("AvatarViewManager", "videoview get null username");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/model/AvatarViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(190909);
      return;
    }
    localObject = this.wpC;
    if ((localObject == null) || (((FrameLayout)localObject).getVisibility() != 0)) {
      if (paramView.duj())
      {
        paramView = paramView.getUsername();
        p.g(paramView, "videoView.getUsername()");
        ex(paramView, 4);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/model/AvatarViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(190909);
      return;
      paramView = paramView.getUsername();
      p.g(paramView, "videoView.getUsername()");
      ex(paramView, 2);
      continue;
      if (paramView.duj())
      {
        paramView = paramView.getUsername();
        p.g(paramView, "videoView.getUsername()");
        ex(paramView, 3);
      }
      else
      {
        paramView = paramView.getUsername();
        p.g(paramView, "videoView.getUsername()");
        ex(paramView, 1);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManager$ScreenCastReceiverUiCallbackImpl;", "Lcom/tencent/mm/plugin/multitalk/model/IScreenCastUiCallback;", "(Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManager;)V", "markPause", "", "wxUserName", "", "markRestart", "markResume", "markStart", "markStop", "updateTask", "task", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "plugin-multitalk_release"})
  public final class b
    implements i
  {
    public final void asi(String paramString)
    {
      AppMethodBeat.i(190896);
      p.h(paramString, "wxUserName");
      this.wpT.ex(paramString, 3);
      AppMethodBeat.o(190896);
    }
    
    public final void asj(String paramString)
    {
      Object localObject2 = null;
      AppMethodBeat.i(190897);
      p.h(paramString, "wxUserName");
      Object localObject1 = this.wpT.asg(paramString);
      boolean bool;
      if (localObject1 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).wua;
        if (localObject3 == null) {
          break label153;
        }
        bool = ((MultiTalkVideoView)localObject3).duj();
        if (!bool) {
          break label158;
        }
        label51:
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).W(true, false);
        }
      }
      Object localObject3 = a.a(this.wpT);
      if (localObject3 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).wua;
        if (localObject1 != null)
        {
          localObject1 = ((MultiTalkVideoView)localObject1).getUsername();
          label96:
          if (!p.i(localObject1, paramString)) {
            break label175;
          }
          paramString = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).wua;
          if (paramString == null) {
            break label170;
          }
          bool = paramString.duj();
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
          AppMethodBeat.o(190897);
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
      AppMethodBeat.o(190897);
    }
    
    public final void ask(String paramString)
    {
      AppMethodBeat.i(190898);
      p.h(paramString, "wxUserName");
      this.wpT.ex(paramString, 3);
      Object localObject = a.a(this.wpT);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).wua;
        if (localObject == null) {}
      }
      for (localObject = ((MultiTalkVideoView)localObject).getUsername();; localObject = null)
      {
        if (p.i(localObject, paramString)) {
          this.wpT.ex(paramString, 4);
        }
        AppMethodBeat.o(190898);
        return;
      }
    }
    
    public final void asl(String paramString)
    {
      Object localObject2 = null;
      AppMethodBeat.i(190899);
      p.h(paramString, "wxUserName");
      d.g.a.b localb = (d.g.a.b)a.wpU;
      Object localObject1 = this.wpT.asg(paramString);
      boolean bool;
      if (localObject1 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).wua;
        if (localObject3 == null) {
          break label260;
        }
        bool = ((MultiTalkVideoView)localObject3).duj();
        if (!bool) {
          break label265;
        }
        label59:
        if (localObject1 != null) {
          localb.invoke(localObject1);
        }
      }
      Object localObject3 = a.a(this.wpT);
      label107:
      int i;
      if (localObject3 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).wua;
        if (localObject1 == null) {
          break label271;
        }
        localObject1 = ((MultiTalkVideoView)localObject1).getUsername();
        if (!p.i(localObject1, paramString)) {
          break label282;
        }
        localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).wua;
        if (localObject1 == null) {
          break label277;
        }
        bool = ((MultiTalkVideoView)localObject1).duj();
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
      localObject3 = a.a(this.wpT);
      if (localObject3 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).wua;
        if (localObject1 != null)
        {
          localObject1 = ((MultiTalkVideoView)localObject1).getUsername();
          label196:
          if (!p.i(localObject1, paramString)) {
            break label304;
          }
          paramString = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).wua;
          if (paramString == null) {
            break label299;
          }
          bool = paramString.duj();
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
          paramString.W(false, false);
          a.a(this.wpT, true);
          AppMethodBeat.o(190899);
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
      AppMethodBeat.o(190899);
    }
    
    public final void asm(String paramString)
    {
      AppMethodBeat.i(190900);
      p.h(paramString, "wxUserName");
      this.wpT.ex(paramString, 0);
      AppMethodBeat.o(190900);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "invoke"})
    static final class a
      extends q
      implements d.g.a.b<com.tencent.mm.plugin.multitalk.ui.widget.b, d.z>
    {
      public static final a wpU;
      
      static
      {
        AppMethodBeat.i(190895);
        wpU = new a();
        AppMethodBeat.o(190895);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "wxUserName", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.b<String, d.z>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "wxUserName", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<String, d.z>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "wxUserName", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.b<String, d.z>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "wxUserName", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.b<String, d.z>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "wxUserName", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.b<String, d.z>
  {
    g(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/multitalk/model/AvatarViewManager$getLargeRenderTarget$1$1"})
  static final class h
    extends q
    implements d.g.a.a<d.z>
  {
    h(com.tencent.mm.plugin.multitalk.ui.widget.b paramb, int paramInt)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.a
 * JD-Core Version:    0.7.0.1
 */