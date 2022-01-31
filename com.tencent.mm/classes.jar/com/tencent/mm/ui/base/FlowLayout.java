package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.ac.a.m;
import java.util.LinkedList;

public class FlowLayout
  extends ViewGroup
{
  private int uSV = 0;
  int uSW = 0;
  LinkedList<Integer> uSX = new LinkedList();
  
  static
  {
    if (!FlowLayout.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c(paramContext, paramAttributeSet);
  }
  
  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c(paramContext, paramAttributeSet);
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.FlowLayout);
    try
    {
      this.uSV = paramContext.getDimensionPixelSize(a.m.FlowLayout_horizontalSpacing, 0);
      this.uSW = paramContext.getDimensionPixelSize(a.m.FlowLayout_verticalSpacing, 0);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof ViewGroup.LayoutParams;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.LayoutParams(-2, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ViewGroup.LayoutParams(paramLayoutParams.width, paramLayoutParams.height);
  }
  
  public int getLineCount()
  {
    return this.uSX.size();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = getChildCount();
    int i = getPaddingLeft();
    paramInt2 = getPaddingTop();
    paramInt4 = 0;
    int j = 0;
    View localView;
    int n;
    int m;
    int k;
    if (j < i1)
    {
      localView = getChildAt(j);
      n = i;
      m = paramInt4;
      k = paramInt2;
      if (localView.getVisibility() != 8)
      {
        k = localView.getMeasuredWidth();
        m = localView.getMeasuredHeight();
        if (i + k + getPaddingRight() <= paramInt3 - paramInt1) {
          break label210;
        }
        i = getPaddingLeft();
        paramInt2 += ((Integer)this.uSX.get(paramInt4)).intValue() + this.uSW;
        paramInt4 += 1;
      }
    }
    label210:
    for (;;)
    {
      n = (((Integer)this.uSX.get(paramInt4)).intValue() - m) / 2;
      localView.layout(i, paramInt2 + n, i + k, n + paramInt2 + m);
      n = this.uSV + k + i;
      k = paramInt2;
      m = paramInt4;
      j += 1;
      i = n;
      paramInt4 = m;
      paramInt2 = k;
      break;
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    assert (View.MeasureSpec.getMode(paramInt1) != 0);
    int i5 = View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight();
    int i4 = View.MeasureSpec.getSize(paramInt2) - getPaddingTop() - getPaddingBottom();
    int i6 = getChildCount();
    this.uSX.clear();
    if (View.MeasureSpec.getMode(paramInt2) == -2147483648) {}
    int j;
    int k;
    for (int n = View.MeasureSpec.makeMeasureSpec(i4, -2147483648);; n = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      int i1 = 0;
      j = 0;
      k = 0;
      int i2;
      for (int i = 0; i1 < i6; i = i2)
      {
        View localView = getChildAt(i1);
        int i3 = j;
        int m = k;
        i2 = i;
        if (localView.getVisibility() != 8)
        {
          localView.measure(View.MeasureSpec.makeMeasureSpec(i5, -2147483648), n);
          int i7 = localView.getMeasuredWidth();
          i3 = j;
          m = k;
          i2 = i;
          if (i + i7 > i5)
          {
            m = k + (this.uSW + j);
            this.uSX.add(Integer.valueOf(j));
            i3 = 0;
            i2 = 0;
          }
          i3 = Math.max(i3, localView.getMeasuredHeight());
          i2 += this.uSV + i7;
        }
        i1 += 1;
        j = i3;
        k = m;
      }
    }
    this.uSX.add(Integer.valueOf(j));
    if (View.MeasureSpec.getMode(paramInt2) == 0) {
      paramInt2 = k + j + getPaddingTop() + getPaddingBottom();
    }
    for (;;)
    {
      setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), paramInt2);
      return;
      if ((View.MeasureSpec.getMode(paramInt2) == -2147483648) && (k + j < i4)) {
        paramInt2 = k + j + getPaddingTop() + getPaddingBottom();
      } else {
        paramInt2 = i4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.FlowLayout
 * JD-Core Version:    0.7.0.1
 */