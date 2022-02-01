package com.tencent.mm.ui.base;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.b;

final class MMListPopupWindow$a
  extends ListView
{
  private boolean so;
  private boolean sq;
  
  private MMListPopupWindow$a(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, null, a.b.dropDownListViewStyle);
    AppMethodBeat.i(159184);
    this.sq = paramBoolean;
    setCacheColorHint(0);
    AppMethodBeat.o(159184);
  }
  
  final int fk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159189);
    int i = getListPaddingTop();
    int j = getListPaddingBottom();
    int m = getDividerHeight();
    Object localObject = getDivider();
    ListAdapter localListAdapter = getAdapter();
    if (localListAdapter == null)
    {
      AppMethodBeat.o(159189);
      return i + j;
    }
    i += j;
    int n;
    label82:
    int k;
    if ((m > 0) && (localObject != null))
    {
      int i1 = localListAdapter.getCount();
      n = 0;
      j = 0;
      localObject = null;
      if (n >= i1) {
        break label244;
      }
      k = localListAdapter.getItemViewType(n);
      if (k == j) {
        break label251;
      }
      localObject = null;
      j = k;
    }
    label136:
    label225:
    label235:
    label244:
    label251:
    for (;;)
    {
      localObject = localListAdapter.getView(n, (View)localObject, this);
      if (localObject == null)
      {
        k = 0;
        if (k <= 0) {
          break label225;
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
        if (i < paramInt2) {
          break label235;
        }
        AppMethodBeat.o(159189);
        return paramInt2;
        m = 0;
        break;
        k = ((View)localObject).getLayoutParams().height;
        break label136;
      }
      n += 1;
      break label82;
      AppMethodBeat.o(159189);
      return i;
    }
  }
  
  public final boolean hasFocus()
  {
    AppMethodBeat.i(159188);
    if ((this.sq) || (super.hasFocus()))
    {
      AppMethodBeat.o(159188);
      return true;
    }
    AppMethodBeat.o(159188);
    return false;
  }
  
  public final boolean hasWindowFocus()
  {
    AppMethodBeat.i(159186);
    if ((this.sq) || (super.hasWindowFocus()))
    {
      AppMethodBeat.o(159186);
      return true;
    }
    AppMethodBeat.o(159186);
    return false;
  }
  
  public final boolean isFocused()
  {
    AppMethodBeat.i(159187);
    if ((this.sq) || (super.isFocused()))
    {
      AppMethodBeat.o(159187);
      return true;
    }
    AppMethodBeat.o(159187);
    return false;
  }
  
  public final boolean isInTouchMode()
  {
    AppMethodBeat.i(159185);
    if (((this.sq) && (this.so)) || (super.isInTouchMode()))
    {
      AppMethodBeat.o(159185);
      return true;
    }
    AppMethodBeat.o(159185);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMListPopupWindow.a
 * JD-Core Version:    0.7.0.1
 */