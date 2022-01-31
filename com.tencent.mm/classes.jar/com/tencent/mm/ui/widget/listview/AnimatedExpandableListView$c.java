package com.tencent.mm.ui.widget.listview;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

final class AnimatedExpandableListView$c
  extends Animation
{
  private View view;
  private int wnS;
  private int wnT;
  private AnimatedExpandableListView.d wnU;
  
  private AnimatedExpandableListView$c(View paramView, int paramInt1, int paramInt2, AnimatedExpandableListView.d paramd)
  {
    this.wnS = paramInt1;
    this.wnT = (paramInt2 - paramInt1);
    this.view = paramView;
    this.wnU = paramd;
    this.view.getLayoutParams().height = paramInt1;
    this.view.requestLayout();
  }
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    if (paramFloat < 1.0F)
    {
      i = this.wnS + (int)(this.wnT * paramFloat);
      this.view.getLayoutParams().height = i;
      this.wnU.wnX = i;
      this.view.requestLayout();
      return;
    }
    int i = this.wnS + this.wnT;
    this.view.getLayoutParams().height = i;
    this.wnU.wnX = i;
    this.view.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.c
 * JD-Core Version:    0.7.0.1
 */