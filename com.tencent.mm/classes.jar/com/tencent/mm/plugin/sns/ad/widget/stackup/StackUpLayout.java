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
  private int DBJ = 0;
  private int DBx = 0;
  private int DBy = 0;
  
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
    AppMethodBeat.i(202494);
    if ((parama == null) || (parama.getItemCount() == 0))
    {
      setVisibility(8);
      AppMethodBeat.o(202494);
      return;
    }
    int i = getChildCount();
    int j = parama.getItemCount();
    int k = this.DBx * j - (j - 1) * this.DBJ;
    if (k < this.DBx)
    {
      setVisibility(8);
      AppMethodBeat.o(202494);
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
        localObject = parama.j(getContext(), this.DBx, this.DBy);
        j = getChildCount();
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.DBx, this.DBy);
        localLayoutParams.leftMargin = (this.DBx * j - j * this.DBJ);
        ((View)localObject).setLayoutParams(localLayoutParams);
        addView((View)localObject);
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
      parama.av(getChildAt(i), i);
      i += 1;
    }
    AppMethodBeat.o(202494);
  }
  
  public final void ir(int paramInt1, int paramInt2)
  {
    this.DBx = paramInt1;
    this.DBy = paramInt2;
  }
  
  public void setAdapter(a parama)
  {
    AppMethodBeat.i(202493);
    try
    {
      setAdapterInternal(parama);
      AppMethodBeat.o(202493);
      return;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(202493);
    }
  }
  
  public void setStackUpWidthSize(int paramInt)
  {
    this.DBJ = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void av(View paramView, int paramInt);
    
    public abstract int getItemCount();
    
    public abstract View j(Context paramContext, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.stackup.StackUpLayout
 * JD-Core Version:    0.7.0.1
 */