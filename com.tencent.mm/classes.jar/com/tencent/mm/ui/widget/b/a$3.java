package com.tencent.mm.ui.widget.b;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.o;

final class a$3
  implements AdapterView.OnItemClickListener
{
  a$3(a parama) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (a.b(this.woj) != null) {
      a.b(this.woj).onMMMenuItemSelected(a.a(this.woj).getItem(paramInt), paramInt);
    }
    if ((a.c(this.woj) != null) && (a.c(this.woj).fvf.isShowing())) {
      a.c(this.woj).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.b.a.3
 * JD-Core Version:    0.7.0.1
 */