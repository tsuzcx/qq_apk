package com.tencent.mm.plugin.mv.a;

import android.animation.Animator;
import android.graphics.Point;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"captureAnimationInfo", "Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "Landroid/view/View;", "transitionTo", "Landroid/animation/Animator;", "Landroid/widget/ImageView;", "to", "animateView", "hide", "", "plugin-mv_release"})
public final class g
{
  public static final Animator a(ImageView paramImageView1, View paramView, ImageView paramImageView2, boolean paramBoolean)
  {
    AppMethodBeat.i(256795);
    p.h(paramImageView1, "$this$transitionTo");
    p.h(paramView, "to");
    p.h(paramImageView2, "animateView");
    paramImageView1 = eC((View)paramImageView1).a(eC(paramView), paramImageView2, paramBoolean);
    AppMethodBeat.o(256795);
    return paramImageView1;
  }
  
  public static final f eC(View paramView)
  {
    AppMethodBeat.i(256796);
    p.h(paramView, "$this$captureAnimationInfo");
    Object localObject = new int[2];
    paramView.getLocationInWindow((int[])localObject);
    localObject = new Point(localObject[0], localObject[1]);
    Size localSize = new Size(paramView.getWidth(), paramView.getHeight());
    if ((paramView instanceof ImageView)) {}
    for (paramView = ((ImageView)paramView).getDrawable();; paramView = null)
    {
      paramView = new f(paramView, (Point)localObject, localSize);
      AppMethodBeat.o(256796);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.g
 * JD-Core Version:    0.7.0.1
 */