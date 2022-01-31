package com.tencent.mm.ui.widget.c;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(112757);
    if (a.b(this.AIL) != null) {
      a.b(this.AIL).onMMMenuItemSelected(a.a(this.AIL).getItem(paramInt), paramInt);
    }
    if ((a.c(this.AIL) != null) && (a.c(this.AIL).gMK.isShowing())) {
      a.c(this.AIL).dismiss();
    }
    AppMethodBeat.o(112757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.c.a.3
 * JD-Core Version:    0.7.0.1
 */