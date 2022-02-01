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
  private int mWV;
  private int mWW;
  
  public StoryAvatarDotsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143459);
    this.mWV = a.fromDPToPix(getContext(), 25);
    this.mWW = a.fromDPToPix(getContext(), 19);
    AppMethodBeat.o(143459);
  }
  
  public StoryAvatarDotsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143460);
    this.mWV = a.fromDPToPix(getContext(), 25);
    this.mWW = a.fromDPToPix(getContext(), 19);
    AppMethodBeat.o(143460);
  }
  
  private void bCP()
  {
    AppMethodBeat.i(143463);
    if (getChildCount() > 0)
    {
      int i = getChildCount() - 1;
      while (i >= 0)
      {
        View localView = getChildAt(i);
        Object localObject = localView.getLayoutParams();
        ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
        int j = this.mWV;
        localLayoutParams.height = j;
        ((ViewGroup.LayoutParams)localObject).width = j;
        localObject = (FrameLayout.LayoutParams)localView.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).gravity |= 0x5;
        ((FrameLayout.LayoutParams)localView.getLayoutParams()).rightMargin = (this.mWW * i);
        i -= 1;
      }
      requestLayout();
      invalidate();
    }
    AppMethodBeat.o(143463);
  }
  
  public final int getExpandDuration()
  {
    AppMethodBeat.i(143466);
    if (getChildCount() <= 1)
    {
      AppMethodBeat.o(143466);
      return 0;
    }
    int i = getChildCount();
    AppMethodBeat.o(143466);
    return (i - 2) * 50 + 200;
  }
  
  public final void setIconGap(int paramInt)
  {
    AppMethodBeat.i(143462);
    if ((paramInt >= 0) && (this.mWW != paramInt))
    {
      this.mWW = paramInt;
      bCP();
    }
    AppMethodBeat.o(143462);
  }
  
  public final void setIconLayerCount(int paramInt)
  {
    AppMethodBeat.i(143464);
    if ((paramInt >= 0) && (paramInt != getChildCount()))
    {
      if (paramInt > getChildCount())
      {
        int j = getChildCount();
        int i = 0;
        while (i < paramInt - j)
        {
          ImageView localImageView = new ImageView(getContext());
          FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.mWV, this.mWV);
          localLayoutParams.gravity = 16;
          addViewInLayout(localImageView, 0, localLayoutParams, true);
          i += 1;
        }
      }
      if (paramInt < getChildCount()) {
        removeViewsInLayout(0, getChildCount() - paramInt);
      }
      bCP();
    }
    AppMethodBeat.o(143464);
  }
  
  public final void setIconSize(int paramInt)
  {
    AppMethodBeat.i(143461);
    if ((paramInt > 0) && (paramInt != this.mWV))
    {
      this.mWV = paramInt;
      bCP();
    }
    AppMethodBeat.o(143461);
  }
  
  public final ImageView vV(int paramInt)
  {
    AppMethodBeat.i(143465);
    ImageView localImageView = (ImageView)getChildAt(getChildCount() - 1 - paramInt);
    AppMethodBeat.o(143465);
    return localImageView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.StoryAvatarDotsView
 * JD-Core Version:    0.7.0.1
 */