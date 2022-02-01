package com.tencent.mm.plugin.mv.model;

import android.animation.Animator;
import android.graphics.Point;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"captureAnimationInfo", "Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "Landroid/view/View;", "transitionTo", "Landroid/animation/Animator;", "Landroid/widget/ImageView;", "to", "animateView", "hide", "", "plugin-mv_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final Animator a(ImageView paramImageView1, View paramView, ImageView paramImageView2, boolean paramBoolean)
  {
    AppMethodBeat.i(286051);
    s.u(paramImageView1, "<this>");
    s.u(paramView, "to");
    s.u(paramImageView2, "animateView");
    paramImageView1 = ip((View)paramImageView1).a(ip(paramView), paramImageView2, paramBoolean);
    AppMethodBeat.o(286051);
    return paramImageView1;
  }
  
  public static final g ip(View paramView)
  {
    AppMethodBeat.i(286059);
    s.u(paramView, "<this>");
    Object localObject = new int[2];
    paramView.getLocationInWindow((int[])localObject);
    localObject = new Point(localObject[0], localObject[1]);
    Size localSize = new Size(paramView.getWidth(), paramView.getHeight());
    if ((paramView instanceof ImageView)) {}
    for (paramView = ((ImageView)paramView).getDrawable();; paramView = null)
    {
      paramView = new g(paramView, (Point)localObject, localSize);
      AppMethodBeat.o(286059);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.h
 * JD-Core Version:    0.7.0.1
 */