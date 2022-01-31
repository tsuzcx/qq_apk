package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class EnterpriseFullHeightListView
  extends ListView
{
  public boolean AkR = true;
  private View AkS;
  private int itemHeight = 0;
  
  public EnterpriseFullHeightListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public EnterpriseFullHeightListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    AppMethodBeat.i(34459);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.AkR)
    {
      AppMethodBeat.o(34459);
      return;
    }
    try
    {
      if (this.AkR) {
        break label266;
      }
      int j = getHeaderViewsCount();
      int k = getAdapter().getCount();
      paramInt4 = i;
      paramInt1 = k;
      paramInt3 = j;
      if (this.AkS != null)
      {
        paramInt1 = k - 1;
        paramInt3 = j;
        paramInt4 = i;
      }
      View localView;
      while (paramInt3 < paramInt1)
      {
        i = this.itemHeight;
        if (i > 0) {}
      }
      if (paramInt4 >= paramInt2) {
        break label266;
      }
    }
    catch (Exception localException1)
    {
      try
      {
        localView = getAdapter().getView(paramInt3, null, this);
        localView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.itemHeight = localView.getMeasuredHeight();
        i = paramInt4 + this.itemHeight;
        paramInt4 = i;
        if (i <= paramInt2) {
          break label193;
        }
        if (this.AkS != null)
        {
          removeFooterView(this.AkS);
          this.AkS = null;
        }
        AppMethodBeat.o(34459);
        return;
      }
      catch (Exception localException2)
      {
        paramInt3 += 1;
      }
      localException1 = localException1;
      AppMethodBeat.o(34459);
      return;
    }
    label193:
    if (this.AkS == null) {
      this.AkS = new View(getContext());
    }
    removeFooterView(this.AkS);
    this.AkS.setLayoutParams(new AbsListView.LayoutParams(-1, paramInt2 - paramInt4));
    addFooterView(this.AkS, null, false);
    label266:
    AppMethodBeat.o(34459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseFullHeightListView
 * JD-Core Version:    0.7.0.1
 */