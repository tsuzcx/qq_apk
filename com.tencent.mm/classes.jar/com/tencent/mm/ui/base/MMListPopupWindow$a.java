package com.tencent.mm.ui.base;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMListPopupWindow$a
  extends ListView
{
  private boolean acV;
  private boolean acW;
  
  private MMListPopupWindow$a(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, null, 2130772197);
    AppMethodBeat.i(112507);
    this.acW = paramBoolean;
    setCacheColorHint(0);
    AppMethodBeat.o(112507);
  }
  
  final int dy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(112512);
    int i = getListPaddingTop();
    int j = getListPaddingBottom();
    int m = getDividerHeight();
    Object localObject = getDivider();
    ListAdapter localListAdapter = getAdapter();
    if (localListAdapter == null)
    {
      AppMethodBeat.o(112512);
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
        AppMethodBeat.o(112512);
        return paramInt2;
        m = 0;
        break;
        k = ((View)localObject).getLayoutParams().height;
        break label136;
      }
      n += 1;
      break label82;
      AppMethodBeat.o(112512);
      return i;
    }
  }
  
  public final boolean hasFocus()
  {
    AppMethodBeat.i(112511);
    if ((this.acW) || (super.hasFocus()))
    {
      AppMethodBeat.o(112511);
      return true;
    }
    AppMethodBeat.o(112511);
    return false;
  }
  
  public final boolean hasWindowFocus()
  {
    AppMethodBeat.i(112509);
    if ((this.acW) || (super.hasWindowFocus()))
    {
      AppMethodBeat.o(112509);
      return true;
    }
    AppMethodBeat.o(112509);
    return false;
  }
  
  public final boolean isFocused()
  {
    AppMethodBeat.i(112510);
    if ((this.acW) || (super.isFocused()))
    {
      AppMethodBeat.o(112510);
      return true;
    }
    AppMethodBeat.o(112510);
    return false;
  }
  
  public final boolean isInTouchMode()
  {
    AppMethodBeat.i(112508);
    if (((this.acW) && (this.acV)) || (super.isInTouchMode()))
    {
      AppMethodBeat.o(112508);
      return true;
    }
    AppMethodBeat.o(112508);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMListPopupWindow.a
 * JD-Core Version:    0.7.0.1
 */