package com.tencent.mm.ui.gridviewheaders;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public final class c$d
  extends FrameLayout
{
  private int mNumColumns;
  private int mPosition;
  private boolean vWC;
  private View[] vWx;
  
  public c$d(c paramc, Context paramContext)
  {
    super(paramContext);
  }
  
  protected final FrameLayout.LayoutParams generateDefaultLayoutParams()
  {
    return new FrameLayout.LayoutParams(-1, -1);
  }
  
  public final Object getTag()
  {
    return getChildAt(0).getTag();
  }
  
  public final Object getTag(int paramInt)
  {
    return getChildAt(0).getTag(paramInt);
  }
  
  public final View getView()
  {
    return getChildAt(0);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 0;
    super.onMeasure(paramInt1, paramInt2);
    if ((this.mNumColumns == 1) || (c.b(this.vWy) == null)) {}
    int k;
    int i;
    do
    {
      return;
      if ((this.mPosition % this.mNumColumns == 0) && (!this.vWC))
      {
        this.vWC = true;
        arrayOfView = this.vWx;
        k = arrayOfView.length;
        i = 0;
        while (i < k)
        {
          arrayOfView[i].measure(paramInt1, paramInt2);
          i += 1;
        }
        this.vWC = false;
      }
      k = getMeasuredHeight();
      View[] arrayOfView = this.vWx;
      int m = arrayOfView.length;
      i = k;
      paramInt2 = j;
      while (paramInt2 < m)
      {
        View localView = arrayOfView[paramInt2];
        j = i;
        if (localView != null) {
          j = Math.max(i, localView.getMeasuredHeight());
        }
        paramInt2 += 1;
        i = j;
      }
    } while (i == k);
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(i, 1073741824));
  }
  
  public final void setNumColumns(int paramInt)
  {
    this.mNumColumns = paramInt;
  }
  
  public final void setPosition(int paramInt)
  {
    this.mPosition = paramInt;
  }
  
  @SuppressLint({"NewApi"})
  public final void setRowSiblings(View[] paramArrayOfView)
  {
    this.vWx = paramArrayOfView;
  }
  
  public final void setTag(int paramInt, Object paramObject)
  {
    getChildAt(0).setTag(paramInt, paramObject);
  }
  
  public final void setTag(Object paramObject)
  {
    getChildAt(0).setTag(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.c.d
 * JD-Core Version:    0.7.0.1
 */