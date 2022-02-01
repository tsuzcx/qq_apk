package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.multitalk.a.d;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.plugin.multitalk.ui.widget.k;
import com.tencent.mm.plugin.multitalk.ui.widget.k.a;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI;", "", "context", "Landroid/content/Context;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "mCancelBtn", "Landroid/widget/TextView;", "mStopProjectAction", "Landroid/view/View;", "mStopProjectIconIv", "Landroid/widget/ImageView;", "mStopProjectTv", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "topUiLayout", "getTopUiLayout", "()Landroid/view/View;", "setTopUiLayout", "(Landroid/view/View;)V", "applyClickEvent", "", "getLandScapeLayout", "viewGroup", "Landroid/widget/FrameLayout;", "getPortraitLayout", "refreshLayout", "showReaderContent", "show", "", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
{
  private a Lsq;
  View Lzv;
  View Lzw;
  TextView Lzx;
  ImageView Lzy;
  Context context;
  TextView xeE;
  
  public n(Context paramContext, a parama)
  {
    AppMethodBeat.i(285652);
    this.context = paramContext;
    this.Lsq = parama;
    AppMethodBeat.o(285652);
  }
  
  private static final void H(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(285689);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(285689);
  }
  
  private static final void a(n paramn, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(285677);
    s.u(paramn, "this$0");
    a.b.a(paramn.Lsq, a.c.LwY);
    ImageView localImageView = paramn.Lzy;
    if (localImageView != null) {
      localImageView.setBackground(bb.m(paramn.context, a.g.icons_filled_start, Color.parseColor("#07C160")));
    }
    paramDialogInterface.dismiss();
    AppMethodBeat.o(285677);
  }
  
  private static final void a(n paramn, View paramView)
  {
    AppMethodBeat.i(285666);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramn);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramn, "this$0");
    a.b.a(paramn.Lsq, a.c.LwY);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(285666);
  }
  
  private static final void b(n paramn, View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(285729);
    Object localObject2 = new Object();
    Object localObject3 = new b();
    ((b)localObject3).cH(paramn);
    ((b)localObject3).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject2, ((b)localObject3).aYj());
    s.u(paramn, "this$0");
    if (paramn.Lsq.getCurrentStatus())
    {
      localObject2 = new e.a(paramn.context);
      paramView = paramn.context.getResources();
      if (paramView == null)
      {
        paramView = null;
        ((e.a)localObject2).bDw(paramView);
        paramView = ((e.a)localObject2).aER(a.h.screen_projector_pause_btn).c(new n..ExternalSyntheticLambda0(paramn));
        paramn = paramn.context;
        if (paramn != null) {
          break label202;
        }
        paramn = localObject1;
      }
      for (;;)
      {
        s.checkNotNull(paramn);
        paramView.aET(paramn.intValue());
        ((e.a)localObject2).aES(a.h.app_cancel).d(n..ExternalSyntheticLambda1.INSTANCE);
        ((e.a)localObject2).jHH().show();
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(285729);
        return;
        paramView = paramView.getString(a.h.screen_projector_stop_tip);
        break;
        label202:
        localObject3 = paramn.getResources();
        paramn = localObject1;
        if (localObject3 != null) {
          paramn = Integer.valueOf(((Resources)localObject3).getColor(com.tencent.mm.plugin.multitalk.a.b.Red));
        }
      }
    }
    if (paramn.Lzy != null)
    {
      paramView = paramn.Lzy;
      if (paramView != null) {
        paramView.setBackground(bb.m(paramn.context, a.g.icons_filled_stop, Color.parseColor("#FA5151")));
      }
    }
    for (;;)
    {
      a.b.a(paramn.Lsq, a.c.LwX);
      paramn = paramn.xeE;
      if (paramn == null) {
        break;
      }
      paramn.setVisibility(8);
      break;
      paramView = paramn.Lzw;
      if (paramView != null) {
        paramView.setBackground(bb.m(paramn.context, a.d.green_rect_link, Color.parseColor("#FA5151")));
      }
      paramView = paramn.Lzx;
      if (paramView != null) {
        paramView.setText(a.h.screen_project_pause);
      }
    }
  }
  
  final void gin()
  {
    Object localObject2 = null;
    AppMethodBeat.i(285802);
    Object localObject1 = this.Lzv;
    if (localObject1 == null)
    {
      localObject1 = null;
      this.Lzw = ((View)localObject1);
      localObject1 = this.Lzv;
      if (localObject1 != null) {
        break label151;
      }
    }
    label151:
    for (localObject1 = localObject2;; localObject1 = (TextView)((View)localObject1).findViewById(a.e.pause_project_tv))
    {
      this.Lzx = ((TextView)localObject1);
      if (this.Lzy == null) {
        break label165;
      }
      localObject1 = this.Lzy;
      if (localObject1 != null) {
        ((ImageView)localObject1).setBackground(bb.m(this.context, a.g.icons_filled_stop, Color.parseColor("#FA5151")));
      }
      localObject1 = this.xeE;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      localObject1 = this.xeE;
      if (localObject1 != null) {
        ((TextView)localObject1).setOnClickListener(new n..ExternalSyntheticLambda2(this));
      }
      localObject1 = this.Lzw;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener(new n..ExternalSyntheticLambda3(this));
      }
      AppMethodBeat.o(285802);
      return;
      localObject1 = ((View)localObject1).findViewById(a.e.pause_project_iv);
      break;
    }
    label165:
    localObject1 = this.Lzw;
    if (localObject1 != null) {
      ((View)localObject1).setBackground(bb.m(this.context, a.d.green_rect_link, Color.parseColor("#FA5151")));
    }
    localObject1 = k.Lvg;
    if (k.a.iY(this.context) != 90)
    {
      localObject1 = k.Lvg;
      if (k.a.iY(this.context) != 270) {}
    }
    else
    {
      localObject1 = this.Lzx;
      if (localObject1 != null) {
        ((TextView)localObject1).setText(a.h.screen_projector_pause_btn);
      }
    }
    for (;;)
    {
      localObject1 = this.Lzw;
      if (localObject1 == null) {
        break;
      }
      ((View)localObject1).requestLayout();
      break;
      localObject1 = this.Lzx;
      if (localObject1 != null) {
        ((TextView)localObject1).setText(a.h.screen_project_pause);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.n
 * JD-Core Version:    0.7.0.1
 */