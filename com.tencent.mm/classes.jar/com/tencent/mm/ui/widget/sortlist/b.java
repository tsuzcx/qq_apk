package com.tencent.mm.ui.widget.sortlist;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class b
  extends ViewGroup
{
  private int tJ;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(159747);
    this.tJ = 48;
    setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    AppMethodBeat.o(159747);
  }
  
  public int getGravity()
  {
    return this.tJ;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159748);
    View localView = getChildAt(0);
    if (localView == null)
    {
      AppMethodBeat.o(159748);
      return;
    }
    if (this.tJ == 48)
    {
      localView.layout(0, 0, getMeasuredWidth(), localView.getMeasuredHeight());
      AppMethodBeat.o(159748);
      return;
    }
    localView.layout(0, getMeasuredHeight() - localView.getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight());
    AppMethodBeat.o(159748);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159749);
    int i = View.MeasureSpec.getSize(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getMode(paramInt2);
    View localView = getChildAt(0);
    if (localView == null)
    {
      setMeasuredDimension(0, j);
      AppMethodBeat.o(159749);
      return;
    }
    if (localView.isLayoutRequested()) {
      measureChild(localView, paramInt1, View.MeasureSpec.makeMeasureSpec(0, 0));
    }
    paramInt1 = i;
    ViewGroup.LayoutParams localLayoutParams;
    if (paramInt2 == 0)
    {
      localLayoutParams = getLayoutParams();
      if (localLayoutParams.height <= 0) {
        break label105;
      }
    }
    label105:
    for (paramInt1 = localLayoutParams.height;; paramInt1 = localView.getMeasuredHeight())
    {
      setMeasuredDimension(j, paramInt1);
      AppMethodBeat.o(159749);
      return;
    }
  }
  
  public void setGravity(int paramInt)
  {
    this.tJ = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.b
 * JD-Core Version:    0.7.0.1
 */