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
  private int JNi = 0;
  private int JNj = 0;
  private int JOe = 0;
  
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
    AppMethodBeat.i(270310);
    if ((parama == null) || (parama.getItemCount() == 0))
    {
      setVisibility(8);
      AppMethodBeat.o(270310);
      return;
    }
    int i = getChildCount();
    int j = parama.getItemCount();
    int k = this.JNi * j - (j - 1) * this.JOe;
    if (k < this.JNi)
    {
      setVisibility(8);
      AppMethodBeat.o(270310);
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
        localObject = parama.k(getContext(), this.JNi, this.JNj);
        j = getChildCount();
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.JNi, this.JNj);
        localLayoutParams.leftMargin = (this.JNi * j - j * this.JOe);
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
      parama.az(getChildAt(i), i);
      i += 1;
    }
    AppMethodBeat.o(270310);
  }
  
  public final void jA(int paramInt1, int paramInt2)
  {
    this.JNi = paramInt1;
    this.JNj = paramInt2;
  }
  
  public void setAdapter(a parama)
  {
    AppMethodBeat.i(270309);
    try
    {
      setAdapterInternal(parama);
      AppMethodBeat.o(270309);
      return;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(270309);
    }
  }
  
  public void setStackUpWidthSize(int paramInt)
  {
    this.JOe = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void az(View paramView, int paramInt);
    
    public abstract int getItemCount();
    
    public abstract View k(Context paramContext, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.stackup.StackUpLayout
 * JD-Core Version:    0.7.0.1
 */