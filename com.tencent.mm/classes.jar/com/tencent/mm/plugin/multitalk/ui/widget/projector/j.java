package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.model.ad;
import com.tencent.mm.plugin.multitalk.model.f;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "context", "Landroid/content/Context;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "avatarManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarManager;", "getAvatarManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarManager;", "setAvatarManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarManager;)V", "avatarRootLayout", "Landroid/view/View;", "getAvatarRootLayout", "()Landroid/view/View;", "setAvatarRootLayout", "(Landroid/view/View;)V", "beforeOrientation", "", "getBeforeOrientation", "()I", "setBeforeOrientation", "(I)V", "cellContent", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarCellLayout;", "getCellContent", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarCellLayout;", "setCellContent", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarCellLayout;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "mRootView", "Landroid/view/ViewGroup;", "getMRootView", "()Landroid/view/ViewGroup;", "setMRootView", "(Landroid/view/ViewGroup;)V", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "applyOrientation", "", "orientation", "changeRendererSpeaker", "userName", "", "checkIfReceivingVideo", "", "doShowOrHideAvatarView", "show", "drawAvatar", "drawBitmap", "bm", "Landroid/graphics/Bitmap;", "angle", "mirror", "getAvatarIv", "Landroid/widget/ImageView;", "getLastRenderSwitchTick", "", "()Ljava/lang/Long;", "getRendererSpeaker", "getScreenProjectAvatarContent", "rootView", "getUsername", "isShown", "refreshAvatar", "speakers", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "release", "resetLayoutCauseDoodle", "showSpeakerAvatar", "showSpeakerVoice", "Companion", "plugin-multitalk_release"})
public final class j
  implements f
{
  public static final j.a FCo;
  private View FCk;
  private h FCl;
  public i FCm;
  private int FCn;
  private a Fwg;
  private Context context;
  public ViewGroup qoE;
  
  static
  {
    AppMethodBeat.i(195833);
    FCo = new j.a((byte)0);
    AppMethodBeat.o(195833);
  }
  
  public j(Context paramContext, a parama)
  {
    AppMethodBeat.i(195831);
    this.context = paramContext;
    this.Fwg = parama;
    this.FCm = new i(this, this.Fwg);
    this.FCn = -1;
    AppMethodBeat.o(195831);
  }
  
  public final void G(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(195798);
    p.k(paramViewGroup, "rootView");
    this.qoE = paramViewGroup;
    this.FCk = View.inflate(this.context, a.f.multitalk_screen_project_avatar_ui, paramViewGroup);
    paramViewGroup = this.FCk;
    if (paramViewGroup != null) {}
    for (paramViewGroup = (RelativeLayout)paramViewGroup.findViewById(a.e.avatar_container); paramViewGroup == null; paramViewGroup = null)
    {
      paramViewGroup = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(195798);
      throw paramViewGroup;
    }
    this.FCl = new h(paramViewGroup, this.Fwg);
    AppMethodBeat.o(195798);
  }
  
  public final void XQ(int paramInt)
  {
    AppMethodBeat.i(195800);
    if (this.FCn != paramInt)
    {
      this.FCn = paramInt;
      h localh = this.FCl;
      if (localh != null)
      {
        localh.XQ(paramInt);
        AppMethodBeat.o(195800);
        return;
      }
    }
    AppMethodBeat.o(195800);
  }
  
  public final void a(String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(195810);
    p.k(paramString, "userName");
    p.k(paramBitmap, "bm");
    Object localObject1 = this.FCl;
    if (localObject1 != null) {}
    for (localObject1 = ((h)localObject1).FyI; localObject1 != null; localObject1 = null)
    {
      h localh = this.FCl;
      localObject1 = localObject2;
      if (localh != null) {
        localObject1 = localh.FyI;
      }
      if (!p.h(paramString, localObject1)) {
        break;
      }
      localObject1 = ad.eYc();
      p.j(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
      if (((q)localObject1).eXm().aQx(paramString) != 100)
      {
        localObject1 = ad.eYc();
        p.j(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
        if (((q)localObject1).eXm().aQx(paramString) != 103) {
          break;
        }
      }
      localObject1 = this.FCl;
      if (localObject1 == null) {
        break;
      }
      ((h)localObject1).b(paramString, paramBitmap, paramInt2, paramInt1);
      AppMethodBeat.o(195810);
      return;
    }
    AppMethodBeat.o(195810);
  }
  
  public final boolean aK(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(195828);
    p.k(paramArrayList, "speakers");
    i locali = this.FCm;
    p.k(paramArrayList, "speakers");
    Long localLong = locali.FCi.getLastRenderSwitchTick();
    if (localLong == null) {
      paramArrayList = i.ge((List)paramArrayList);
    }
    for (;;)
    {
      locali.FCi.aQP(paramArrayList);
      locali.FCi.vh(true);
      AppMethodBeat.o(195828);
      return true;
      if ((Util.ticksToNow(localLong.longValue()) >= 3000L) && (!paramArrayList.contains(locali.FCi.getRendererSpeaker()))) {
        paramArrayList = i.ge((List)paramArrayList);
      } else {
        paramArrayList = locali.FCi.getRendererSpeaker();
      }
    }
  }
  
  public final void aQO(String paramString)
  {
    AppMethodBeat.i(195814);
    p.k(paramString, "userName");
    Object localObject = this.FCl;
    if ((localObject != null) && (((h)localObject).FBZ == 1))
    {
      localObject = ad.eYc();
      p.j(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
      if (((q)localObject).eXf().contains(paramString)) {}
    }
    else
    {
      localObject = this.FCl;
      if (localObject != null)
      {
        ((h)localObject).aQJ(paramString);
        AppMethodBeat.o(195814);
        return;
      }
    }
    AppMethodBeat.o(195814);
  }
  
  public final void aQP(String paramString)
  {
    AppMethodBeat.i(195824);
    h localh = this.FCl;
    if (localh != null)
    {
      localh.aQG(paramString);
      AppMethodBeat.o(195824);
      return;
    }
    AppMethodBeat.o(195824);
  }
  
  public final void eWn() {}
  
  public final void eZm()
  {
    AppMethodBeat.i(195825);
    h localh = this.FCl;
    if (localh != null)
    {
      localh.eZm();
      AppMethodBeat.o(195825);
      return;
    }
    AppMethodBeat.o(195825);
  }
  
  public final ImageView getAvatarIv()
  {
    return null;
  }
  
  public final Long getLastRenderSwitchTick()
  {
    h localh = this.FCl;
    if (localh != null) {
      return localh.FyK;
    }
    return null;
  }
  
  public final String getRendererSpeaker()
  {
    Object localObject = this.FCl;
    if (localObject != null)
    {
      String str = ((h)localObject).FyI;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    return localObject;
  }
  
  public final String getUsername()
  {
    Object localObject = this.FCl;
    if (localObject != null)
    {
      String str = ((h)localObject).FyI;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    return localObject;
  }
  
  public final void vh(boolean paramBoolean)
  {
    h localh1 = null;
    Object localObject = null;
    AppMethodBeat.i(195804);
    if (paramBoolean)
    {
      localh1 = this.FCl;
      if (localh1 != null) {
        localObject = localh1.eYy();
      }
      if (localObject == null) {}
      while (((Integer)localObject).intValue() != 0)
      {
        localObject = this.FCl;
        if (localObject == null) {
          break;
        }
        ((h)localObject).eZk();
        AppMethodBeat.o(195804);
        return;
      }
      AppMethodBeat.o(195804);
      return;
      AppMethodBeat.o(195804);
      return;
    }
    h localh2 = this.FCl;
    localObject = localh1;
    if (localh2 != null) {
      localObject = localh2.eYy();
    }
    if (localObject == null) {}
    for (;;)
    {
      localObject = this.FCl;
      if (localObject == null) {
        break;
      }
      ((h)localObject).eZl();
      AppMethodBeat.o(195804);
      return;
      if (((Integer)localObject).intValue() == 4) {
        break;
      }
    }
  }
  
  public final void vi(boolean paramBoolean)
  {
    AppMethodBeat.i(195811);
    Object localObject = this.FCl;
    if (localObject != null) {}
    for (localObject = ((h)localObject).eYy(); localObject == null; localObject = null)
    {
      AppMethodBeat.o(195811);
      return;
    }
    if (((Integer)localObject).intValue() == 0)
    {
      if (!n.ba((CharSequence)getRendererSpeaker())) {}
      for (int i = 1; i != 0; i = 0)
      {
        localObject = this.FCl;
        if (localObject == null) {
          break;
        }
        ((h)localObject).vg(paramBoolean);
        AppMethodBeat.o(195811);
        return;
      }
    }
    AppMethodBeat.o(195811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.j
 * JD-Core Version:    0.7.0.1
 */