package com.tencent.mm.ui.widget.listview;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AnimatedExpandableListView$a$1
  implements Animation.AnimationListener
{
  AnimatedExpandableListView$a$1(AnimatedExpandableListView.a parama, int paramInt, AnimatedExpandableListView.b paramb) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(112710);
    AnimatedExpandableListView.a.b(this.AHG, this.rSi);
    this.AHG.notifyDataSetChanged();
    this.AHF.setTag(Integer.valueOf(0));
    AppMethodBeat.o(112710);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.a.1
 * JD-Core Version:    0.7.0.1
 */