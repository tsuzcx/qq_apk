package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;

public class EnterpriseFullHeightListView
  extends ListView
{
  private int ixe = 0;
  public boolean vSZ = true;
  private View vTa;
  
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
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.vSZ) {
      return;
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          if (this.vSZ) {
            break;
          }
          int j = getHeaderViewsCount();
          int k = getAdapter().getCount();
          paramInt4 = i;
          paramInt1 = k;
          paramInt3 = j;
          if (this.vTa != null)
          {
            paramInt1 = k - 1;
            paramInt3 = j;
            paramInt4 = i;
          }
          if (paramInt3 < paramInt1)
          {
            i = this.ixe;
            if (i > 0) {}
          }
        }
        catch (Exception localException1)
        {
          View localView;
          return;
        }
        try
        {
          localView = getAdapter().getView(paramInt3, null, this);
          localView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
          this.ixe = localView.getMeasuredHeight();
          i = paramInt4 + this.ixe;
          paramInt4 = i;
          if (i <= paramInt2) {
            break label240;
          }
          if (this.vTa == null) {
            break;
          }
          removeFooterView(this.vTa);
          this.vTa = null;
          return;
        }
        catch (Exception localException2)
        {
          label240:
          paramInt3 += 1;
        }
      }
      if (paramInt4 >= paramInt2) {
        break;
      }
      if (this.vTa == null) {
        this.vTa = new View(getContext());
      }
      removeFooterView(this.vTa);
      this.vTa.setLayoutParams(new AbsListView.LayoutParams(-1, paramInt2 - paramInt4));
      addFooterView(this.vTa, null, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseFullHeightListView
 * JD-Core Version:    0.7.0.1
 */