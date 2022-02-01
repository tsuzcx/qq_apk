package com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview;

import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.voip.ui.k;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbnailLayoutHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "radius", "", "thumbCover", "Landroid/widget/ImageView;", "getThumbCover", "()Landroid/widget/ImageView;", "setThumbCover", "(Landroid/widget/ImageView;)V", "thumbLayout", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends RecyclerView.v
{
  public WeImageView LAg;
  ImageView LAh;
  private final float radius;
  
  public d(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(285888);
    this.radius = a.fromDPToPix(MMApplicationContext.getContext(), 2);
    Object localObject = paramView.findViewById(a.e.multitalk_screen_project_cover);
    if (localObject == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(285888);
      throw paramView;
    }
    this.LAh = ((ImageView)localObject);
    localObject = this.LAh;
    if (localObject != null) {
      ((ImageView)localObject).setClipToOutline(true);
    }
    localObject = this.LAh;
    if (localObject != null) {
      ((ImageView)localObject).setOutlineProvider((ViewOutlineProvider)new k(this.radius));
    }
    paramView = paramView.findViewById(a.e.multitalk_screen_project_thumb);
    if (paramView == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.imageview.WeImageView");
      AppMethodBeat.o(285888);
      throw paramView;
    }
    this.LAg = ((WeImageView)paramView);
    paramView = this.LAg;
    if (paramView != null) {
      paramView.setClipToOutline(true);
    }
    paramView = this.LAg;
    if (paramView != null) {
      paramView.setOutlineProvider((ViewOutlineProvider)new k(this.radius));
    }
    AppMethodBeat.o(285888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.d
 * JD-Core Version:    0.7.0.1
 */