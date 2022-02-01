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
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.f;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "context", "Landroid/content/Context;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "avatarManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarManager;", "getAvatarManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarManager;", "setAvatarManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarManager;)V", "avatarRootLayout", "Landroid/view/View;", "getAvatarRootLayout", "()Landroid/view/View;", "setAvatarRootLayout", "(Landroid/view/View;)V", "beforeOrientation", "", "getBeforeOrientation", "()I", "setBeforeOrientation", "(I)V", "cellContent", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarCellLayout;", "getCellContent", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarCellLayout;", "setCellContent", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarCellLayout;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "mRootView", "Landroid/view/ViewGroup;", "getMRootView", "()Landroid/view/ViewGroup;", "setMRootView", "(Landroid/view/ViewGroup;)V", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "applyOrientation", "", "orientation", "changeRendererSpeaker", "userName", "", "checkIfReceivingVideo", "", "doShowOrHideAvatarView", "show", "drawAvatar", "drawBitmap", "bm", "Landroid/graphics/Bitmap;", "angle", "mirror", "getAvatarIv", "Landroid/widget/ImageView;", "getLastRenderSwitchTick", "", "()Ljava/lang/Long;", "getRendererSpeaker", "getScreenProjectAvatarContent", "rootView", "getUsername", "isShown", "refreshAvatar", "speakers", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "release", "resetLayoutCauseDoodle", "showSpeakerAvatar", "showSpeakerVoice", "Companion", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements f
{
  public static final i.a Lyh;
  private a Lsq;
  private View Lyi;
  private g Lyj;
  public h Lyk;
  private int Lyl;
  private Context context;
  public ViewGroup tth;
  
  static
  {
    AppMethodBeat.i(285697);
    Lyh = new i.a((byte)0);
    AppMethodBeat.o(285697);
  }
  
  public i(Context paramContext, a parama)
  {
    AppMethodBeat.i(285686);
    this.context = paramContext;
    this.Lsq = parama;
    this.Lyk = new h(this, this.Lsq);
    this.Lyl = -1;
    AppMethodBeat.o(285686);
  }
  
  public final void Q(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(285709);
    kotlin.g.b.s.u(paramViewGroup, "rootView");
    this.tth = paramViewGroup;
    this.Lyi = View.inflate(this.context, a.f.multitalk_screen_project_avatar_ui, paramViewGroup);
    paramViewGroup = this.Lyi;
    if (paramViewGroup == null) {}
    for (paramViewGroup = null; paramViewGroup == null; paramViewGroup = (RelativeLayout)paramViewGroup.findViewById(a.e.avatar_container))
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(285709);
      throw paramViewGroup;
    }
    this.Lyj = new g(paramViewGroup, this.Lsq);
    AppMethodBeat.o(285709);
  }
  
  public final void a(String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(285742);
    kotlin.g.b.s.u(paramString, "userName");
    kotlin.g.b.s.u(paramBitmap, "bm");
    Object localObject1 = this.Lyj;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null)
      {
        localObject1 = this.Lyj;
        if (localObject1 != null) {
          break label131;
        }
      }
    }
    label131:
    for (localObject1 = localObject2;; localObject1 = ((g)localObject1).LuU)
    {
      if ((kotlin.g.b.s.p(paramString, localObject1)) && ((ac.ggS().ggc().aNq(paramString) == 100) || (ac.ggS().ggc().aNq(paramString) == 103)))
      {
        localObject1 = this.Lyj;
        if (localObject1 != null) {
          ((g)localObject1).b(paramString, paramBitmap, paramInt2, paramInt1);
        }
      }
      AppMethodBeat.o(285742);
      return;
      localObject1 = ((g)localObject1).LuU;
      break;
    }
  }
  
  public final void aNG(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(285783);
    kotlin.g.b.s.u(paramString, "userName");
    g localg = this.Lyj;
    if ((localg != null) && (localg.LxZ == 1)) {}
    for (;;)
    {
      if ((i == 0) || (!ac.ggS().Loj.contains(paramString)))
      {
        localg = this.Lyj;
        if (localg != null) {
          localg.aNC(paramString);
        }
      }
      AppMethodBeat.o(285783);
      return;
      i = 0;
    }
  }
  
  public final void aNH(String paramString)
  {
    AppMethodBeat.i(285797);
    g localg = this.Lyj;
    if (localg != null) {
      localg.aNz(paramString);
    }
    AppMethodBeat.o(285797);
  }
  
  public final void aca(int paramInt)
  {
    AppMethodBeat.i(285716);
    if (this.Lyl != paramInt)
    {
      this.Lyl = paramInt;
      g localg = this.Lyj;
      if (localg != null) {
        localg.aca(paramInt);
      }
    }
    AppMethodBeat.o(285716);
  }
  
  public final boolean be(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(285814);
    kotlin.g.b.s.u(paramArrayList, "speakers");
    h localh = this.Lyk;
    kotlin.g.b.s.u(paramArrayList, "speakers");
    Long localLong = localh.Lyf.getLastRenderSwitchTick();
    if (localLong == null) {
      paramArrayList = h.jc((List)paramArrayList);
    }
    for (;;)
    {
      localh.Lyf.aNH(paramArrayList);
      localh.Lyf.zv(true);
      AppMethodBeat.o(285814);
      return true;
      if ((Util.ticksToNow(localLong.longValue()) >= 3000L) && (!paramArrayList.contains(localh.Lyf.getRendererSpeaker()))) {
        paramArrayList = h.jc((List)paramArrayList);
      } else {
        paramArrayList = localh.Lyf.getRendererSpeaker();
      }
    }
  }
  
  public final ImageView getAvatarIv()
  {
    return null;
  }
  
  public final Long getLastRenderSwitchTick()
  {
    g localg = this.Lyj;
    if (localg == null) {
      return null;
    }
    return localg.LuW;
  }
  
  public final String getRendererSpeaker()
  {
    Object localObject = this.Lyj;
    if (localObject == null) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = ((g)localObject).LuU;
      localObject = str;
    } while (str != null);
    return "";
  }
  
  public final String getUsername()
  {
    Object localObject = this.Lyj;
    if (localObject == null) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = ((g)localObject).LuU;
      localObject = str;
    } while (str != null);
    return "";
  }
  
  public final void gfe() {}
  
  public final void gil()
  {
    AppMethodBeat.i(285804);
    g localg = this.Lyj;
    if (localg != null) {
      localg.gil();
    }
    AppMethodBeat.o(285804);
  }
  
  public final void zv(boolean paramBoolean)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(285727);
    if (paramBoolean)
    {
      localObject = this.Lyj;
      if (localObject != null)
      {
        localObject = ((g)localObject).ght();
        if (localObject != null) {}
      }
      else
      {
        i = 0;
      }
      for (;;)
      {
        if (i != 0) {
          break label122;
        }
        localObject = this.Lyj;
        if (localObject == null) {
          break label122;
        }
        ((g)localObject).gij();
        AppMethodBeat.o(285727);
        return;
        if (((Integer)localObject).intValue() != 0) {
          break;
        }
      }
    }
    Object localObject = this.Lyj;
    if (localObject != null)
    {
      localObject = ((g)localObject).ght();
      if (localObject != null) {
        break label129;
      }
    }
    for (i = 0;; i = j)
    {
      if (i == 0)
      {
        localObject = this.Lyj;
        if (localObject != null) {
          ((g)localObject).gik();
        }
      }
      label122:
      AppMethodBeat.o(285727);
      return;
      label129:
      if (((Integer)localObject).intValue() != 4) {
        break;
      }
    }
  }
  
  public final void zw(boolean paramBoolean)
  {
    AppMethodBeat.i(285774);
    Object localObject = this.Lyj;
    if (localObject != null)
    {
      localObject = ((g)localObject).ght();
      if (localObject != null) {}
    }
    else
    {
      i = 0;
      label26:
      if (i != 0) {
        if (n.bp((CharSequence)getRendererSpeaker())) {
          break label82;
        }
      }
    }
    label82:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = this.Lyj;
        if (localObject != null) {
          ((g)localObject).zu(paramBoolean);
        }
      }
      AppMethodBeat.o(285774);
      return;
      if (((Integer)localObject).intValue() != 0) {
        break;
      }
      i = 1;
      break label26;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.i
 * JD-Core Version:    0.7.0.1
 */