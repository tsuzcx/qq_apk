package com.tencent.mm.plugin.sns.ad.widget.stackup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class StackUpLayout
  extends FrameLayout
{
  private int QhI = 0;
  private int QhJ = 0;
  private int QiZ = 0;
  
  public StackUpLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public StackUpLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void setAdapterInternal(a parama)
  {
    AppMethodBeat.i(310212);
    if ((parama == null) || (parama.getItemCount() == 0))
    {
      setVisibility(8);
      AppMethodBeat.o(310212);
      return;
    }
    int i = getChildCount();
    int j = parama.getItemCount();
    int k = this.QhI * j - (j - 1) * this.QiZ;
    if (k < this.QhI)
    {
      setVisibility(8);
      AppMethodBeat.o(310212);
      return;
    }
    Object localObject = getLayoutParams();
    if (localObject != null) {
      if (((ViewGroup.LayoutParams)localObject).width != k) {
        ((ViewGroup.LayoutParams)localObject).width = k;
      }
    }
    while (i < j)
    {
      i = j - i;
      while (i > 0)
      {
        localObject = parama.o(getContext(), this.QhI, this.QhJ);
        if (localObject != null)
        {
          j = getChildCount();
          if (localObject != null)
          {
            FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.QhI, this.QhJ);
            localLayoutParams.leftMargin = (this.QhI * j - j * this.QiZ);
            ((View)localObject).setLayoutParams(localLayoutParams);
          }
          addView((View)localObject);
        }
        i -= 1;
      }
      setLayoutParams(new ViewGroup.LayoutParams(k, -2));
    }
    if (i > j) {
      while (i > j)
      {
        removeViewAt(i - 1);
        i -= 1;
      }
    }
    i = 0;
    while (i < getChildCount())
    {
      parama.aV(getChildAt(i), i);
      i += 1;
    }
    AppMethodBeat.o(310212);
  }
  
  public final void lk(int paramInt1, int paramInt2)
  {
    this.QhI = paramInt1;
    this.QhJ = paramInt2;
  }
  
  public void setAdapter(a parama)
  {
    AppMethodBeat.i(310230);
    try
    {
      setAdapterInternal(parama);
      return;
    }
    finally
    {
      AppMethodBeat.o(310230);
    }
  }
  
  public void setStackUpWidthSize(int paramInt)
  {
    this.QiZ = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void aV(View paramView, int paramInt);
    
    public abstract int getItemCount();
    
    public abstract View o(Context paramContext, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.stackup.StackUpLayout
 * JD-Core Version:    0.7.0.1
 */