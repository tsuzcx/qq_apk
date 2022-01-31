package com.tencent.mm.ui.widget.listview;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AnimatedExpandableListView$c
  extends Animation
{
  private int AHL;
  private int AHM;
  private AnimatedExpandableListView.d AHN;
  private View view;
  
  private AnimatedExpandableListView$c(View paramView, int paramInt1, int paramInt2, AnimatedExpandableListView.d paramd)
  {
    AppMethodBeat.i(112717);
    this.AHL = paramInt1;
    this.AHM = (paramInt2 - paramInt1);
    this.view = paramView;
    this.AHN = paramd;
    this.view.getLayoutParams().height = paramInt1;
    this.view.requestLayout();
    AppMethodBeat.o(112717);
  }
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    AppMethodBeat.i(112718);
    super.applyTransformation(paramFloat, paramTransformation);
    if (paramFloat < 1.0F)
    {
      i = this.AHL + (int)(this.AHM * paramFloat);
      this.view.getLayoutParams().height = i;
      this.AHN.AHQ = i;
      this.view.requestLayout();
      AppMethodBeat.o(112718);
      return;
    }
    int i = this.AHL + this.AHM;
    this.view.getLayoutParams().height = i;
    this.AHN.AHQ = i;
    this.view.requestLayout();
    AppMethodBeat.o(112718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.c
 * JD-Core Version:    0.7.0.1
 */