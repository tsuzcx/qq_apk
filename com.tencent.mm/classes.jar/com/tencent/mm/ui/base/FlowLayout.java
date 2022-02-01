package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.m;
import java.util.LinkedList;
import org.xwalk.core.Log;

public class FlowLayout
  extends ViewGroup
{
  public int aYP;
  protected int adOr;
  protected int adOs;
  private LinkedList<Integer> adOt;
  
  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141630);
    this.adOr = 0;
    this.adOs = 0;
    this.adOt = new LinkedList();
    this.aYP = 0;
    b(paramContext, paramAttributeSet);
    AppMethodBeat.o(141630);
  }
  
  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(141631);
    this.adOr = 0;
    this.adOs = 0;
    this.adOt = new LinkedList();
    this.aYP = 0;
    b(paramContext, paramAttributeSet);
    AppMethodBeat.o(141631);
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(141632);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.FlowLayout);
    try
    {
      this.adOr = paramContext.getDimensionPixelSize(a.m.FlowLayout_horizontalSpacing, 0);
      this.adOs = paramContext.getDimensionPixelSize(a.m.FlowLayout_verticalSpacing, 0);
      return;
    }
    finally
    {
      paramContext.recycle();
      AppMethodBeat.o(141632);
    }
  }
  
  public final int aAJ(int paramInt)
  {
    AppMethodBeat.i(251300);
    int j = Math.max(0, Math.min(this.adOt.size(), paramInt));
    paramInt = getPaddingTop();
    int i = 0;
    while (i < j - 1)
    {
      paramInt += ((Integer)this.adOt.get(i)).intValue() + this.adOs;
      i += 1;
    }
    i = ((Integer)this.adOt.get(j - 1)).intValue();
    j = getPaddingBottom();
    AppMethodBeat.o(251300);
    return i + paramInt + j;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof ViewGroup.LayoutParams;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(141636);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -2);
    AppMethodBeat.o(141636);
    return localLayoutParams;
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(141637);
    paramAttributeSet = new ViewGroup.LayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(141637);
    return paramAttributeSet;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(141638);
    paramLayoutParams = new ViewGroup.LayoutParams(paramLayoutParams.width, paramLayoutParams.height);
    AppMethodBeat.o(141638);
    return paramLayoutParams;
  }
  
  public int getLineCount()
  {
    AppMethodBeat.i(141633);
    int i = this.adOt.size();
    AppMethodBeat.o(141633);
    return i;
  }
  
  public int getRealLineCount()
  {
    return this.aYP;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141635);
    int i1 = getChildCount();
    int i = getPaddingLeft();
    paramInt2 = getPaddingTop();
    this.aYP = 1;
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
          break label235;
        }
        i = getPaddingLeft();
        paramInt2 += ((Integer)this.adOt.get(paramInt4)).intValue() + this.adOs;
        this.aYP += 1;
        paramInt4 += 1;
      }
    }
    label235:
    for (;;)
    {
      n = (((Integer)this.adOt.get(paramInt4)).intValue() - m) / 2;
      localView.layout(i, paramInt2 + n, i + k, n + paramInt2 + m);
      n = this.adOr + k + i;
      k = paramInt2;
      m = paramInt4;
      j += 1;
      i = n;
      paramInt4 = m;
      paramInt2 = k;
      break;
      AppMethodBeat.o(141635);
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141634);
    if (View.MeasureSpec.getMode(paramInt1) == 0) {
      Log.e("MicroMsg.FlowLayout", " getMode(widthMeasureSpec) == MeasureSpec.UNSPECIFIED");
    }
    int i5 = View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight();
    int i4 = View.MeasureSpec.getSize(paramInt2) - getPaddingTop() - getPaddingBottom();
    int i6 = getChildCount();
    this.adOt.clear();
    int k = 0;
    int j = 0;
    int i = 0;
    if (View.MeasureSpec.getMode(paramInt2) == -2147483648) {}
    for (int n = View.MeasureSpec.makeMeasureSpec(i4, -2147483648);; n = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      int i1 = 0;
      while (i1 < i6)
      {
        View localView = getChildAt(i1);
        int i3 = i;
        int m = j;
        int i2 = k;
        if (localView.getVisibility() != 8)
        {
          localView.measure(View.MeasureSpec.makeMeasureSpec(i5, -2147483648), n);
          int i7 = localView.getMeasuredWidth();
          i3 = i;
          m = j;
          i2 = k;
          if (k + i7 > i5)
          {
            i2 = 0;
            m = j + (this.adOs + i);
            this.adOt.add(Integer.valueOf(i));
            i3 = 0;
          }
          i3 = Math.max(i3, localView.getMeasuredHeight());
          i2 += this.adOr + i7;
        }
        i1 += 1;
        i = i3;
        j = m;
        k = i2;
      }
    }
    this.adOt.add(Integer.valueOf(i));
    if (View.MeasureSpec.getMode(paramInt2) == 0) {
      paramInt2 = j + i + getPaddingTop() + getPaddingBottom();
    }
    for (;;)
    {
      setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), paramInt2);
      AppMethodBeat.o(141634);
      return;
      if ((View.MeasureSpec.getMode(paramInt2) == -2147483648) && (j + i < i4)) {
        paramInt2 = j + i + getPaddingTop() + getPaddingBottom();
      } else {
        paramInt2 = i4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.FlowLayout
 * JD-Core Version:    0.7.0.1
 */