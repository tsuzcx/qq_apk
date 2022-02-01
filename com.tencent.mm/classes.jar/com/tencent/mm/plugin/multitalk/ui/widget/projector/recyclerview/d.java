package com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.voip.ui.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbnailLayoutHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "radius", "", "thumbCover", "Landroid/widget/ImageView;", "getThumbCover", "()Landroid/widget/ImageView;", "setThumbCover", "(Landroid/widget/ImageView;)V", "thumbLayout", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "plugin-multitalk_release"})
public final class d
  extends RecyclerView.v
{
  private final float radius;
  public WeImageView zYM;
  ImageView zYN;
  
  public d(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(240080);
    this.radius = a.fromDPToPix(MMApplicationContext.getContext(), 2);
    Object localObject = paramView.findViewById(2131305052);
    if (localObject == null)
    {
      paramView = new t("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(240080);
      throw paramView;
    }
    this.zYN = ((ImageView)localObject);
    localObject = this.zYN;
    if (localObject != null) {
      ((ImageView)localObject).setClipToOutline(true);
    }
    localObject = this.zYN;
    if (localObject != null) {
      ((ImageView)localObject).setOutlineProvider((ViewOutlineProvider)new e(this.radius));
    }
    paramView = paramView.findViewById(2131305053);
    if (paramView == null)
    {
      paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.imageview.WeImageView");
      AppMethodBeat.o(240080);
      throw paramView;
    }
    this.zYM = ((WeImageView)paramView);
    paramView = this.zYM;
    if (paramView != null) {
      paramView.setClipToOutline(true);
    }
    paramView = this.zYM;
    if (paramView != null)
    {
      paramView.setOutlineProvider((ViewOutlineProvider)new e(this.radius));
      AppMethodBeat.o(240080);
      return;
    }
    AppMethodBeat.o(240080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.d
 * JD-Core Version:    0.7.0.1
 */