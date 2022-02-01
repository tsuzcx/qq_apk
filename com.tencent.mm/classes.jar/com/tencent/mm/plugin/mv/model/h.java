package com.tencent.mm.plugin.mv.model;

import android.animation.Animator;
import android.graphics.Point;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"captureAnimationInfo", "Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "Landroid/view/View;", "transitionTo", "Landroid/animation/Animator;", "Landroid/widget/ImageView;", "to", "animateView", "hide", "", "plugin-mv_release"})
public final class h
{
  public static final Animator a(ImageView paramImageView1, View paramView, ImageView paramImageView2, boolean paramBoolean)
  {
    AppMethodBeat.i(238645);
    p.k(paramImageView1, "$this$transitionTo");
    p.k(paramView, "to");
    p.k(paramImageView2, "animateView");
    paramImageView1 = fC((View)paramImageView1).a(fC(paramView), paramImageView2, paramBoolean);
    AppMethodBeat.o(238645);
    return paramImageView1;
  }
  
  public static final g fC(View paramView)
  {
    AppMethodBeat.i(238647);
    p.k(paramView, "$this$captureAnimationInfo");
    Object localObject = new int[2];
    paramView.getLocationInWindow((int[])localObject);
    localObject = new Point(localObject[0], localObject[1]);
    Size localSize = new Size(paramView.getWidth(), paramView.getHeight());
    if ((paramView instanceof ImageView)) {}
    for (paramView = ((ImageView)paramView).getDrawable();; paramView = null)
    {
      paramView = new g(paramView, (Point)localObject, localSize);
      AppMethodBeat.o(238647);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.h
 * JD-Core Version:    0.7.0.1
 */