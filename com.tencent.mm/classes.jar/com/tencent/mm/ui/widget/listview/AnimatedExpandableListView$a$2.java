package com.tencent.mm.ui.widget.listview;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ExpandableListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AnimatedExpandableListView$a$2
  implements Animation.AnimationListener
{
  AnimatedExpandableListView$a$2(AnimatedExpandableListView.a parama, int paramInt, ExpandableListView paramExpandableListView, AnimatedExpandableListView.d paramd, AnimatedExpandableListView.b paramb) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(112711);
    AnimatedExpandableListView.a.b(this.AHG, this.rSi);
    this.AHH.collapseGroup(this.rSi);
    this.AHG.notifyDataSetChanged();
    this.AHI.AHQ = -1;
    this.AHF.setTag(Integer.valueOf(0));
    AppMethodBeat.o(112711);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.a.2
 * JD-Core Version:    0.7.0.1
 */