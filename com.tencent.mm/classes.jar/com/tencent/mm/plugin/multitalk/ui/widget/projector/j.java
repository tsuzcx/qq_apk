package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.f;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "context", "Landroid/content/Context;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "avatarManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarManager;", "getAvatarManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarManager;", "setAvatarManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarManager;)V", "avatarRootLayout", "Landroid/view/View;", "getAvatarRootLayout", "()Landroid/view/View;", "setAvatarRootLayout", "(Landroid/view/View;)V", "beforeOrientation", "", "getBeforeOrientation", "()I", "setBeforeOrientation", "(I)V", "cellContent", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarCellLayout;", "getCellContent", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarCellLayout;", "setCellContent", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarCellLayout;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "mRootView", "Landroid/view/ViewGroup;", "getMRootView", "()Landroid/view/ViewGroup;", "setMRootView", "(Landroid/view/ViewGroup;)V", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "applyOrientation", "", "orientation", "changeRendererSpeaker", "userName", "", "checkIfReceivingVideo", "", "doShowOrHideAvatarView", "show", "drawAvatar", "drawBitmap", "bm", "Landroid/graphics/Bitmap;", "angle", "mirror", "getAvatarIv", "Landroid/widget/ImageView;", "getLastRenderSwitchTick", "", "()Ljava/lang/Long;", "getRendererSpeaker", "getScreenProjectAvatarContent", "rootView", "getUsername", "isShown", "refreshAvatar", "speakers", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "release", "resetLayoutCauseDoodle", "showSpeakerAvatar", "showSpeakerVoice", "Companion", "plugin-multitalk_release"})
public final class j
  implements f
{
  public static final j.a zWG;
  private Context context;
  public ViewGroup nmW;
  private a zQD;
  private View zWC;
  private h zWD;
  public i zWE;
  private int zWF;
  
  static
  {
    AppMethodBeat.i(240007);
    zWG = new j.a((byte)0);
    AppMethodBeat.o(240007);
  }
  
  public j(Context paramContext, a parama)
  {
    AppMethodBeat.i(240006);
    this.context = paramContext;
    this.zQD = parama;
    this.zWE = new i(this, this.zQD);
    this.zWF = -1;
    AppMethodBeat.o(240006);
  }
  
  private static boolean aGD(String paramString)
  {
    AppMethodBeat.i(240002);
    q localq = ac.eom();
    p.g(localq, "SubCoreMultiTalk.getMultiTalkManager()");
    boolean bool = localq.enr().contains(paramString);
    AppMethodBeat.o(240002);
    return bool;
  }
  
  public final void A(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(239996);
    p.h(paramViewGroup, "rootView");
    this.nmW = paramViewGroup;
    this.zWC = View.inflate(this.context, 2131495737, paramViewGroup);
    paramViewGroup = this.zWC;
    if (paramViewGroup != null) {}
    for (paramViewGroup = (RelativeLayout)paramViewGroup.findViewById(2131297128); paramViewGroup == null; paramViewGroup = null)
    {
      paramViewGroup = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(239996);
      throw paramViewGroup;
    }
    this.zWD = new h(paramViewGroup, this.zQD);
    AppMethodBeat.o(239996);
  }
  
  public final void RA(int paramInt)
  {
    AppMethodBeat.i(239997);
    if (this.zWF != paramInt)
    {
      this.zWF = paramInt;
      h localh = this.zWD;
      if (localh != null)
      {
        localh.RA(paramInt);
        AppMethodBeat.o(239997);
        return;
      }
    }
    AppMethodBeat.o(239997);
  }
  
  public final void a(String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(239999);
    p.h(paramString, "userName");
    p.h(paramBitmap, "bm");
    Object localObject1 = this.zWD;
    if (localObject1 != null) {}
    for (localObject1 = ((h)localObject1).zTg; localObject1 != null; localObject1 = null)
    {
      h localh = this.zWD;
      localObject1 = localObject2;
      if (localh != null) {
        localObject1 = localh.zTg;
      }
      if (!p.j(paramString, localObject1)) {
        break;
      }
      localObject1 = ac.eom();
      p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
      if (((q)localObject1).enw().aGj(paramString) != 100) {
        break;
      }
      localObject1 = this.zWD;
      if (localObject1 == null) {
        break;
      }
      ((h)localObject1).b(paramString, paramBitmap, paramInt2, paramInt1);
      AppMethodBeat.o(239999);
      return;
    }
    AppMethodBeat.o(239999);
  }
  
  public final boolean aD(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(240005);
    p.h(paramArrayList, "speakers");
    i locali = this.zWE;
    p.h(paramArrayList, "speakers");
    Long localLong = locali.zWA.getLastRenderSwitchTick();
    if (localLong == null) {
      paramArrayList = i.fC((List)paramArrayList);
    }
    for (;;)
    {
      locali.zWA.aGA(paramArrayList);
      locali.zWA.sf(true);
      AppMethodBeat.o(240005);
      return true;
      if ((Util.ticksToNow(localLong.longValue()) >= 3000L) && (!paramArrayList.contains(locali.zWA.getRendererSpeaker()))) {
        paramArrayList = i.fC((List)paramArrayList);
      } else {
        paramArrayList = locali.zWA.getRendererSpeaker();
      }
    }
  }
  
  public final void aGA(String paramString)
  {
    AppMethodBeat.i(240003);
    h localh = this.zWD;
    if (localh != null)
    {
      localh.aGs(paramString);
      AppMethodBeat.o(240003);
      return;
    }
    AppMethodBeat.o(240003);
  }
  
  public final void aGz(String paramString)
  {
    AppMethodBeat.i(240001);
    p.h(paramString, "userName");
    Object localObject;
    if (!aGD(paramString))
    {
      localObject = this.zWD;
      if (localObject != null)
      {
        ((h)localObject).aGv(paramString);
        AppMethodBeat.o(240001);
        return;
      }
      AppMethodBeat.o(240001);
      return;
    }
    if (aGD(paramString))
    {
      localObject = ac.eom();
      p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
      if (((q)localObject).enw().aGj(paramString) != 100)
      {
        localObject = ac.eom();
        p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
        if (((q)localObject).enw().aGj(paramString) != 103) {}
      }
      else
      {
        if ((!ac.eom().zMz) || (!p.j(z.aTY(), paramString))) {
          break label142;
        }
      }
      localObject = this.zWD;
      if (localObject != null)
      {
        ((h)localObject).aGv(paramString);
        AppMethodBeat.o(240001);
        return;
      }
    }
    label142:
    AppMethodBeat.o(240001);
  }
  
  public final void emz() {}
  
  public final void epz()
  {
    AppMethodBeat.i(240004);
    h localh = this.zWD;
    if (localh != null)
    {
      localh.epz();
      AppMethodBeat.o(240004);
      return;
    }
    AppMethodBeat.o(240004);
  }
  
  public final ImageView getAvatarIv()
  {
    return null;
  }
  
  public final Long getLastRenderSwitchTick()
  {
    h localh = this.zWD;
    if (localh != null) {
      return localh.zTi;
    }
    return null;
  }
  
  public final String getRendererSpeaker()
  {
    Object localObject = this.zWD;
    if (localObject != null)
    {
      String str = ((h)localObject).zTg;
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
    Object localObject = this.zWD;
    if (localObject != null)
    {
      String str = ((h)localObject).zTg;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    return localObject;
  }
  
  public final void sf(boolean paramBoolean)
  {
    h localh1 = null;
    Object localObject = null;
    AppMethodBeat.i(239998);
    if (paramBoolean)
    {
      localh1 = this.zWD;
      if (localh1 != null) {
        localObject = localh1.eoH();
      }
      if (localObject == null) {}
      while (((Integer)localObject).intValue() != 0)
      {
        localObject = this.zWD;
        if (localObject == null) {
          break;
        }
        ((h)localObject).epx();
        AppMethodBeat.o(239998);
        return;
      }
      AppMethodBeat.o(239998);
      return;
      AppMethodBeat.o(239998);
      return;
    }
    h localh2 = this.zWD;
    localObject = localh1;
    if (localh2 != null) {
      localObject = localh2.eoH();
    }
    if (localObject == null) {}
    for (;;)
    {
      localObject = this.zWD;
      if (localObject == null) {
        break;
      }
      ((h)localObject).epy();
      AppMethodBeat.o(239998);
      return;
      if (((Integer)localObject).intValue() == 4) {
        break;
      }
    }
  }
  
  public final void sg(boolean paramBoolean)
  {
    AppMethodBeat.i(240000);
    Object localObject = this.zWD;
    if (localObject != null) {}
    for (localObject = ((h)localObject).eoH(); localObject == null; localObject = null)
    {
      AppMethodBeat.o(240000);
      return;
    }
    if (((Integer)localObject).intValue() == 0)
    {
      if (!n.aL((CharSequence)getRendererSpeaker())) {}
      for (int i = 1; i != 0; i = 0)
      {
        localObject = this.zWD;
        if (localObject == null) {
          break;
        }
        ((h)localObject).se(paramBoolean);
        AppMethodBeat.o(240000);
        return;
      }
    }
    AppMethodBeat.o(240000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.j
 * JD-Core Version:    0.7.0.1
 */