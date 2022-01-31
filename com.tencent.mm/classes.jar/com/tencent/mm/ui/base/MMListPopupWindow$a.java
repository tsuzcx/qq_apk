package com.tencent.mm.ui.base;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.mm.ci.a.b;

final class MMListPopupWindow$a
  extends ListView
{
  private boolean acj;
  private boolean ack;
  
  private MMListPopupWindow$a(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, null, a.b.dropDownListViewStyle);
    this.ack = paramBoolean;
    setCacheColorHint(0);
  }
  
  final int ck(int paramInt1, int paramInt2)
  {
    int i = getListPaddingTop();
    int j = getListPaddingBottom();
    int m = getDividerHeight();
    Object localObject = getDivider();
    ListAdapter localListAdapter = getAdapter();
    int k;
    if (localListAdapter == null)
    {
      k = i + j;
      return k;
    }
    i += j;
    label58:
    int n;
    if ((m > 0) && (localObject != null))
    {
      int i1 = localListAdapter.getCount();
      n = 0;
      j = 0;
      localObject = null;
      label76:
      if (n >= i1) {
        break label234;
      }
      k = localListAdapter.getItemViewType(n);
      if (k == j) {
        break label236;
      }
      localObject = null;
      j = k;
    }
    label130:
    label224:
    label234:
    label236:
    for (;;)
    {
      localObject = localListAdapter.getView(n, (View)localObject, this);
      if (localObject == null)
      {
        k = 0;
        if (k <= 0) {
          break label224;
        }
      }
      for (k = View.MeasureSpec.makeMeasureSpec(k, 1073741824);; k = View.MeasureSpec.makeMeasureSpec(0, 0))
      {
        if (localObject != null) {
          ((View)localObject).measure(paramInt1, k);
        }
        k = i;
        if (n > 0) {
          k = i + m;
        }
        i = k;
        if (localObject != null) {
          i = k + ((View)localObject).getMeasuredHeight();
        }
        k = paramInt2;
        if (i >= paramInt2) {
          break;
        }
        n += 1;
        break label76;
        m = 0;
        break label58;
        k = ((View)localObject).getLayoutParams().height;
        break label130;
      }
      return i;
    }
  }
  
  public final boolean hasFocus()
  {
    return (this.ack) || (super.hasFocus());
  }
  
  public final boolean hasWindowFocus()
  {
    return (this.ack) || (super.hasWindowFocus());
  }
  
  public final boolean isFocused()
  {
    return (this.ack) || (super.isFocused());
  }
  
  public final boolean isInTouchMode()
  {
    return ((this.ack) && (this.acj)) || (super.isInTouchMode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMListPopupWindow.a
 * JD-Core Version:    0.7.0.1
 */