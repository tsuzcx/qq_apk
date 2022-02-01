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
  public boolean afpm = true;
  private View afpn;
  private int dpX = 0;
  
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
    AppMethodBeat.i(38588);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.afpm)
    {
      AppMethodBeat.o(38588);
      return;
    }
    try
    {
      if (this.afpm) {
        break label266;
      }
      int j = getHeaderViewsCount();
      int k = getAdapter().getCount();
      paramInt4 = i;
      paramInt1 = k;
      paramInt3 = j;
      if (this.afpn != null)
      {
        paramInt1 = k - 1;
        paramInt3 = j;
        paramInt4 = i;
      }
      View localView;
      while (paramInt3 < paramInt1)
      {
        i = this.dpX;
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
        this.dpX = localView.getMeasuredHeight();
        i = paramInt4 + this.dpX;
        paramInt4 = i;
        if (i <= paramInt2) {
          break label193;
        }
        if (this.afpn != null)
        {
          removeFooterView(this.afpn);
          this.afpn = null;
        }
        AppMethodBeat.o(38588);
        return;
      }
      catch (Exception localException2)
      {
        paramInt3 += 1;
      }
      localException1 = localException1;
      AppMethodBeat.o(38588);
      return;
    }
    label193:
    if (this.afpn == null) {
      this.afpn = new View(getContext());
    }
    removeFooterView(this.afpn);
    this.afpn.setLayoutParams(new AbsListView.LayoutParams(-1, paramInt2 - paramInt4));
    addFooterView(this.afpn, null, false);
    label266:
    AppMethodBeat.o(38588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseFullHeightListView
 * JD-Core Version:    0.7.0.1
 */