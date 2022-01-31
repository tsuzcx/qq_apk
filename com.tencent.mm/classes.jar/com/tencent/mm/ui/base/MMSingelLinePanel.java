package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.tencent.mm.ac.a.d;
import com.tencent.mm.ac.a.m;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public class MMSingelLinePanel
  extends MMTagPanel
{
  private int uSV = 0;
  private int uSW = 0;
  private LinkedList<Integer> uSX = new LinkedList();
  private boolean uXI = true;
  private TextView uXJ;
  private int uXK = 0;
  private int uXL = 0;
  
  static
  {
    if (!MMSingelLinePanel.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public MMSingelLinePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MMSingelLinePanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
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
  
  public final void cAU()
  {
    super.cAU();
    this.uXJ = new TextView(getContext());
    this.uXJ.setText("...");
    this.uXJ.setTextColor(getResources().getColor(a.d.wechat_green));
    this.uXJ.setLayoutParams(generateDefaultLayoutParams());
    addView(this.uXJ);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int n;
    int i1;
    int i;
    int k;
    int m;
    int j;
    View localView;
    if (this.uXI)
    {
      n = getChildCount();
      i1 = this.uXK;
      i = getPaddingLeft();
      paramInt2 = getPaddingTop();
      k = 0;
      m = 0;
      paramInt4 = 0;
      j = 0;
      if (j < n)
      {
        localView = getChildAt(j);
        if ((localView.getVisibility() == 8) || (localView == this.uXJ)) {
          break label487;
        }
        int i2 = localView.getMeasuredWidth();
        int i3 = localView.getMeasuredHeight();
        if (i + i2 + getPaddingRight() <= paramInt3 - paramInt1 - i1) {
          break label484;
        }
        i = getPaddingLeft();
        paramInt2 += ((Integer)this.uSX.get(paramInt4)).intValue() + this.uSW;
        paramInt4 += 1;
        label145:
        if (paramInt4 > 0) {
          break label481;
        }
        localView.layout(i, paramInt2 + 0, i + i2, paramInt2 + 0 + i3);
        i = this.uSV + i2 + i;
        m = paramInt2;
        k = i;
      }
    }
    label272:
    label478:
    label481:
    label484:
    label487:
    for (;;)
    {
      j += 1;
      break;
      if (this.uXJ != null)
      {
        if (paramInt4 > 0) {
          this.uXJ.layout(k, m, this.uXK + k, this.uXL + m);
        }
      }
      else {
        return;
      }
      this.uXJ.layout(0, 0, 0, 0);
      return;
      i1 = getChildCount();
      i = getPaddingLeft();
      paramInt2 = getPaddingTop();
      paramInt4 = 0;
      j = 0;
      if (j < i1)
      {
        localView = getChildAt(j);
        n = i;
        m = paramInt4;
        k = paramInt2;
        if (localView.getVisibility() != 8)
        {
          n = i;
          m = paramInt4;
          k = paramInt2;
          if (localView != this.uXJ)
          {
            k = localView.getMeasuredWidth();
            m = localView.getMeasuredHeight();
            if (i + k + getPaddingRight() <= paramInt3 - paramInt1) {
              break label478;
            }
            i = getPaddingLeft();
            paramInt2 += ((Integer)this.uSX.get(paramInt4)).intValue() + this.uSW;
            paramInt4 += 1;
          }
        }
      }
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
        break label272;
        break;
      }
      continue;
      break label145;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    assert (View.MeasureSpec.getMode(paramInt1) != 0);
    int m = View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight();
    int i7 = View.MeasureSpec.getSize(paramInt2) - getPaddingTop() - getPaddingBottom();
    int i8 = getChildCount();
    this.uSX.clear();
    int k = 0;
    int j = 0;
    int i = 0;
    if (View.MeasureSpec.getMode(paramInt2) == -2147483648) {}
    for (int n = View.MeasureSpec.makeMeasureSpec(i7, -2147483648);; n = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      if ((this.uXI) && (this.uXJ != null))
      {
        this.uXJ.measure(View.MeasureSpec.makeMeasureSpec(m, -2147483648), n);
        this.uXK = this.uXJ.getMeasuredWidth();
        this.uXL = this.uXJ.getMeasuredHeight();
        y.d("MicroMsg.MMTagContactPanel", "mEllipsisWidth %d", new Object[] { Integer.valueOf(this.uXK) });
      }
      int i1 = m;
      if (this.uXI) {
        i1 = m - this.uXK;
      }
      m = 0;
      int i2 = 0;
      while (i2 < i8)
      {
        View localView = getChildAt(i2);
        int i6 = i;
        int i5 = j;
        int i3 = k;
        int i4 = m;
        if (localView.getVisibility() != 8)
        {
          localView.measure(View.MeasureSpec.makeMeasureSpec(i1, -2147483648), n);
          int i9 = localView.getMeasuredWidth();
          i5 = localView.getMeasuredHeight();
          i4 = i;
          m = j;
          i3 = k;
          if (k + i9 > i1)
          {
            i3 = 0;
            m = j + (this.uSW + i);
            this.uSX.add(Integer.valueOf(i));
            i4 = 0;
          }
          i6 = Math.max(i4, localView.getMeasuredHeight());
          i3 += this.uSV + i9;
          i4 = i5;
          i5 = m;
        }
        i2 += 1;
        i = i6;
        j = i5;
        k = i3;
        m = i4;
      }
    }
    this.uSX.add(Integer.valueOf(i));
    if (this.uXI)
    {
      getPaddingTop();
      getPaddingBottom();
    }
    for (;;)
    {
      setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), m);
      return;
      if (View.MeasureSpec.getMode(paramInt2) == 0)
      {
        getPaddingTop();
        getPaddingBottom();
      }
      else if ((View.MeasureSpec.getMode(paramInt2) == -2147483648) && (j + i < i7))
      {
        getPaddingTop();
        getPaddingBottom();
      }
    }
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    this.uXI = paramBoolean;
    this.uXJ = new TextView(getContext());
    this.uXJ.setText("...");
    this.uXJ.setLayoutParams(generateDefaultLayoutParams());
    addView(this.uXJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMSingelLinePanel
 * JD-Core Version:    0.7.0.1
 */