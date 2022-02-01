package com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview;

import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.voip.ui.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbnailLayoutHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "radius", "", "thumbCover", "Landroid/widget/ImageView;", "getThumbCover", "()Landroid/widget/ImageView;", "setThumbCover", "(Landroid/widget/ImageView;)V", "thumbLayout", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "plugin-multitalk_release"})
public final class d
  extends RecyclerView.v
{
  public WeImageView FEx;
  ImageView FEy;
  private final float radius;
  
  public d(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(199633);
    this.radius = a.fromDPToPix(MMApplicationContext.getContext(), 2);
    Object localObject = paramView.findViewById(a.e.multitalk_screen_project_cover);
    if (localObject == null)
    {
      paramView = new t("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(199633);
      throw paramView;
    }
    this.FEy = ((ImageView)localObject);
    localObject = this.FEy;
    if (localObject != null) {
      ((ImageView)localObject).setClipToOutline(true);
    }
    localObject = this.FEy;
    if (localObject != null) {
      ((ImageView)localObject).setOutlineProvider((ViewOutlineProvider)new e(this.radius));
    }
    paramView = paramView.findViewById(a.e.multitalk_screen_project_thumb);
    if (paramView == null)
    {
      paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.imageview.WeImageView");
      AppMethodBeat.o(199633);
      throw paramView;
    }
    this.FEx = ((WeImageView)paramView);
    paramView = this.FEx;
    if (paramView != null) {
      paramView.setClipToOutline(true);
    }
    paramView = this.FEx;
    if (paramView != null)
    {
      paramView.setOutlineProvider((ViewOutlineProvider)new e(this.radius));
      AppMethodBeat.o(199633);
      return;
    }
    AppMethodBeat.o(199633);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.d
 * JD-Core Version:    0.7.0.1
 */