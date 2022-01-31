package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public final class StoryAvatarDotsView
  extends FrameLayout
{
  private int eB;
  private int jak;
  
  public StoryAvatarDotsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107965);
    this.eB = a.fromDPToPix(getContext(), 25);
    this.jak = a.fromDPToPix(getContext(), 19);
    AppMethodBeat.o(107965);
  }
  
  public StoryAvatarDotsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(107966);
    this.eB = a.fromDPToPix(getContext(), 25);
    this.jak = a.fromDPToPix(getContext(), 19);
    AppMethodBeat.o(107966);
  }
  
  private void aOw()
  {
    AppMethodBeat.i(107969);
    if (getChildCount() > 0)
    {
      int i = getChildCount() - 1;
      while (i >= 0)
      {
        View localView = getChildAt(i);
        Object localObject = localView.getLayoutParams();
        ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
        int j = this.eB;
        localLayoutParams.height = j;
        ((ViewGroup.LayoutParams)localObject).width = j;
        localObject = (FrameLayout.LayoutParams)localView.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).gravity |= 0x5;
        ((FrameLayout.LayoutParams)localView.getLayoutParams()).rightMargin = (this.jak * i);
        i -= 1;
      }
      requestLayout();
      invalidate();
    }
    AppMethodBeat.o(107969);
  }
  
  public final int getExpandDuration()
  {
    AppMethodBeat.i(107972);
    if (getChildCount() <= 1)
    {
      AppMethodBeat.o(107972);
      return 0;
    }
    int i = getChildCount();
    AppMethodBeat.o(107972);
    return (i - 2) * 50 + 200;
  }
  
  public final ImageView pU(int paramInt)
  {
    AppMethodBeat.i(107971);
    ImageView localImageView = (ImageView)getChildAt(getChildCount() - 1 - paramInt);
    AppMethodBeat.o(107971);
    return localImageView;
  }
  
  public final void setIconGap(int paramInt)
  {
    AppMethodBeat.i(107968);
    if ((paramInt >= 0) && (this.jak != paramInt))
    {
      this.jak = paramInt;
      aOw();
    }
    AppMethodBeat.o(107968);
  }
  
  public final void setIconLayerCount(int paramInt)
  {
    AppMethodBeat.i(107970);
    if ((paramInt >= 0) && (paramInt != getChildCount()))
    {
      if (paramInt > getChildCount())
      {
        int j = getChildCount();
        int i = 0;
        while (i < paramInt - j)
        {
          ImageView localImageView = new ImageView(getContext());
          FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.eB, this.eB);
          localLayoutParams.gravity = 16;
          addViewInLayout(localImageView, 0, localLayoutParams, true);
          i += 1;
        }
      }
      if (paramInt < getChildCount()) {
        removeViewsInLayout(0, getChildCount() - paramInt);
      }
      aOw();
    }
    AppMethodBeat.o(107970);
  }
  
  public final void setIconSize(int paramInt)
  {
    AppMethodBeat.i(107967);
    if ((paramInt > 0) && (paramInt != this.eB))
    {
      this.eB = paramInt;
      aOw();
    }
    AppMethodBeat.o(107967);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.StoryAvatarDotsView
 * JD-Core Version:    0.7.0.1
 */