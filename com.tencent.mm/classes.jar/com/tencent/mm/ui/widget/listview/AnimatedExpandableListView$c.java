package com.tencent.mm.ui.widget.listview;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AnimatedExpandableListView$c
  extends Animation
{
  private int HHA;
  private int HHB;
  private AnimatedExpandableListView.d HHC;
  private View view;
  
  private AnimatedExpandableListView$c(View paramView, int paramInt1, int paramInt2, AnimatedExpandableListView.d paramd)
  {
    AppMethodBeat.i(159426);
    this.HHA = paramInt1;
    this.HHB = (paramInt2 - paramInt1);
    this.view = paramView;
    this.HHC = paramd;
    this.view.getLayoutParams().height = paramInt1;
    this.view.requestLayout();
    AppMethodBeat.o(159426);
  }
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    AppMethodBeat.i(159427);
    super.applyTransformation(paramFloat, paramTransformation);
    if (paramFloat < 1.0F)
    {
      i = this.HHA + (int)(this.HHB * paramFloat);
      this.view.getLayoutParams().height = i;
      this.HHC.HHF = i;
      this.view.requestLayout();
      AppMethodBeat.o(159427);
      return;
    }
    int i = this.HHA + this.HHB;
    this.view.getLayoutParams().height = i;
    this.HHC.HHF = i;
    this.view.requestLayout();
    AppMethodBeat.o(159427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.c
 * JD-Core Version:    0.7.0.1
 */