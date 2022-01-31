package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.a.a;
import java.util.LinkedList;

public class FlowLayout
  extends ViewGroup
{
  private int zhv;
  int zhw;
  LinkedList<Integer> zhx;
  
  static
  {
    AppMethodBeat.i(106276);
    if (!FlowLayout.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(106276);
      return;
    }
  }
  
  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106267);
    this.zhv = 0;
    this.zhw = 0;
    this.zhx = new LinkedList();
    c(paramContext, paramAttributeSet);
    AppMethodBeat.o(106267);
  }
  
  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(106268);
    this.zhv = 0;
    this.zhw = 0;
    this.zhx = new LinkedList();
    c(paramContext, paramAttributeSet);
    AppMethodBeat.o(106268);
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(106269);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.FlowLayout);
    try
    {
      this.zhv = paramContext.getDimensionPixelSize(0, 0);
      this.zhw = paramContext.getDimensionPixelSize(1, 0);
      return;
    }
    finally
    {
      paramContext.recycle();
      AppMethodBeat.o(106269);
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof ViewGroup.LayoutParams;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(106273);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -2);
    AppMethodBeat.o(106273);
    return localLayoutParams;
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(106274);
    paramAttributeSet = new ViewGroup.LayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(106274);
    return paramAttributeSet;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(106275);
    paramLayoutParams = new ViewGroup.LayoutParams(paramLayoutParams.width, paramLayoutParams.height);
    AppMethodBeat.o(106275);
    return paramLayoutParams;
  }
  
  public int getLineCount()
  {
    AppMethodBeat.i(106270);
    int i = this.zhx.size();
    AppMethodBeat.o(106270);
    return i;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(106272);
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
          break label220;
        }
        i = getPaddingLeft();
        paramInt2 += ((Integer)this.zhx.get(paramInt4)).intValue() + this.zhw;
        paramInt4 += 1;
      }
    }
    label220:
    for (;;)
    {
      n = (((Integer)this.zhx.get(paramInt4)).intValue() - m) / 2;
      localView.layout(i, paramInt2 + n, i + k, n + paramInt2 + m);
      n = this.zhv + k + i;
      k = paramInt2;
      m = paramInt4;
      j += 1;
      i = n;
      paramInt4 = m;
      paramInt2 = k;
      break;
      AppMethodBeat.o(106272);
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106271);
    Object localObject;
    if ((!$assertionsDisabled) && (View.MeasureSpec.getMode(paramInt1) == 0))
    {
      localObject = new AssertionError();
      AppMethodBeat.o(106271);
      throw ((Throwable)localObject);
    }
    int i5 = View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight();
    int i4 = View.MeasureSpec.getSize(paramInt2) - getPaddingTop() - getPaddingBottom();
    int i6 = getChildCount();
    this.zhx.clear();
    int k = 0;
    int j = 0;
    int i = 0;
    if (View.MeasureSpec.getMode(paramInt2) == -2147483648) {}
    for (int n = View.MeasureSpec.makeMeasureSpec(i4, -2147483648);; n = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      int i1 = 0;
      while (i1 < i6)
      {
        localObject = getChildAt(i1);
        int i3 = i;
        int m = j;
        int i2 = k;
        if (((View)localObject).getVisibility() != 8)
        {
          ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(i5, -2147483648), n);
          int i7 = ((View)localObject).getMeasuredWidth();
          i3 = i;
          m = j;
          i2 = k;
          if (k + i7 > i5)
          {
            i2 = 0;
            m = j + (this.zhw + i);
            this.zhx.add(Integer.valueOf(i));
            i3 = 0;
          }
          i3 = Math.max(i3, ((View)localObject).getMeasuredHeight());
          i2 += this.zhv + i7;
        }
        i1 += 1;
        i = i3;
        j = m;
        k = i2;
      }
    }
    this.zhx.add(Integer.valueOf(i));
    if (View.MeasureSpec.getMode(paramInt2) == 0) {
      paramInt2 = j + i + getPaddingTop() + getPaddingBottom();
    }
    for (;;)
    {
      setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), paramInt2);
      AppMethodBeat.o(106271);
      return;
      if ((View.MeasureSpec.getMode(paramInt2) == -2147483648) && (j + i < i4)) {
        paramInt2 = j + i + getPaddingTop() + getPaddingBottom();
      } else {
        paramInt2 = i4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.FlowLayout
 * JD-Core Version:    0.7.0.1
 */