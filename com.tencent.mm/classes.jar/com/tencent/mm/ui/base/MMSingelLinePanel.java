package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public class MMSingelLinePanel
  extends MMTagPanel
{
  private int OOj;
  private int OOk;
  private LinkedList<Integer> OOl;
  private boolean OSP;
  private TextView OSQ;
  private int OSR;
  private int OSS;
  
  static
  {
    AppMethodBeat.i(142126);
    if (!MMSingelLinePanel.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(142126);
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
    AppMethodBeat.i(142121);
    this.OOl = new LinkedList();
    this.OOj = 0;
    this.OOk = 0;
    this.OSP = true;
    this.OSR = 0;
    this.OSS = 0;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.FlowLayout);
    try
    {
      this.OOj = paramContext.getDimensionPixelSize(0, 0);
      this.OOk = paramContext.getDimensionPixelSize(3, 0);
      return;
    }
    finally
    {
      paramContext.recycle();
      AppMethodBeat.o(142121);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final void gKV()
  {
    AppMethodBeat.i(142122);
    super.gKV();
    this.OSQ = new TextView(getContext());
    this.OSQ.setText("...");
    this.OSQ.setTextColor(getResources().getColor(2131101414));
    this.OSQ.setLayoutParams(generateDefaultLayoutParams());
    addView(this.OSQ);
    AppMethodBeat.o(142122);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142125);
    int n;
    int i1;
    int i;
    int k;
    int m;
    int j;
    View localView;
    if (this.OSP)
    {
      n = getChildCount();
      i1 = this.OSR;
      i = getPaddingLeft();
      paramInt2 = getPaddingTop();
      k = 0;
      m = 0;
      paramInt4 = 0;
      j = 0;
      if (j < n)
      {
        localView = getChildAt(j);
        if ((localView.getVisibility() == 8) || (localView == this.OSQ)) {
          break label508;
        }
        int i2 = localView.getMeasuredWidth();
        int i3 = localView.getMeasuredHeight();
        if (i + i2 + getPaddingRight() <= paramInt3 - paramInt1 - i1) {
          break label505;
        }
        i = getPaddingLeft();
        paramInt2 += ((Integer)this.OOl.get(paramInt4)).intValue() + this.OOk;
        paramInt4 += 1;
        label150:
        if (paramInt4 > 0) {
          break label502;
        }
        localView.layout(i, paramInt2 + 0, i + i2, paramInt2 + 0 + i3);
        i = this.OOj + i2 + i;
        m = paramInt2;
        k = i;
      }
    }
    label499:
    label502:
    label505:
    label508:
    for (;;)
    {
      j += 1;
      break;
      if (this.OSQ != null)
      {
        if (paramInt4 > 0)
        {
          this.OSQ.layout(k, m, this.OSR + k, this.OSS + m);
          AppMethodBeat.o(142125);
          return;
        }
        this.OSQ.layout(0, 0, 0, 0);
      }
      AppMethodBeat.o(142125);
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
          if (localView != this.OSQ)
          {
            k = localView.getMeasuredWidth();
            m = localView.getMeasuredHeight();
            if (i + k + getPaddingRight() <= paramInt3 - paramInt1) {
              break label499;
            }
            i = getPaddingLeft();
            paramInt2 += ((Integer)this.OOl.get(paramInt4)).intValue() + this.OOk;
            paramInt4 += 1;
          }
        }
      }
      for (;;)
      {
        n = (((Integer)this.OOl.get(paramInt4)).intValue() - m) / 2;
        localView.layout(i, paramInt2 + n, i + k, n + paramInt2 + m);
        n = this.OOj + k + i;
        k = paramInt2;
        m = paramInt4;
        j += 1;
        i = n;
        paramInt4 = m;
        paramInt2 = k;
        break;
        AppMethodBeat.o(142125);
        return;
      }
      continue;
      break label150;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142124);
    Object localObject;
    if ((!$assertionsDisabled) && (View.MeasureSpec.getMode(paramInt1) == 0))
    {
      localObject = new AssertionError();
      AppMethodBeat.o(142124);
      throw ((Throwable)localObject);
    }
    int m = View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight();
    int i7 = View.MeasureSpec.getSize(paramInt2) - getPaddingTop() - getPaddingBottom();
    int i8 = getChildCount();
    this.OOl.clear();
    int k = 0;
    int j = 0;
    int i = 0;
    if (View.MeasureSpec.getMode(paramInt2) == -2147483648) {}
    for (int n = View.MeasureSpec.makeMeasureSpec(i7, -2147483648);; n = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      if ((this.OSP) && (this.OSQ != null))
      {
        this.OSQ.measure(View.MeasureSpec.makeMeasureSpec(m, -2147483648), n);
        this.OSR = this.OSQ.getMeasuredWidth();
        this.OSS = this.OSQ.getMeasuredHeight();
        Log.d("MicroMsg.MMTagContactPanel", "mEllipsisWidth %d", new Object[] { Integer.valueOf(this.OSR) });
      }
      int i1 = m;
      if (this.OSP) {
        i1 = m - this.OSR;
      }
      m = 0;
      int i2 = 0;
      while (i2 < i8)
      {
        localObject = getChildAt(i2);
        int i6 = i;
        int i5 = j;
        int i3 = k;
        int i4 = m;
        if (((View)localObject).getVisibility() != 8)
        {
          ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(i1, -2147483648), n);
          int i9 = ((View)localObject).getMeasuredWidth();
          i5 = ((View)localObject).getMeasuredHeight();
          i4 = i;
          m = j;
          i3 = k;
          if (k + i9 > i1)
          {
            i3 = 0;
            m = j + (this.OOk + i);
            this.OOl.add(Integer.valueOf(i));
            i4 = 0;
          }
          i6 = Math.max(i4, ((View)localObject).getMeasuredHeight());
          i3 += this.OOj + i9;
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
    this.OOl.add(Integer.valueOf(i));
    if (this.OSP)
    {
      getPaddingTop();
      getPaddingBottom();
    }
    for (;;)
    {
      setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), m);
      AppMethodBeat.o(142124);
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
    AppMethodBeat.i(142123);
    this.OSP = paramBoolean;
    this.OSQ = new TextView(getContext());
    this.OSQ.setText("...");
    this.OSQ.setLayoutParams(generateDefaultLayoutParams());
    addView(this.OSQ);
    AppMethodBeat.o(142123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMSingelLinePanel
 * JD-Core Version:    0.7.0.1
 */