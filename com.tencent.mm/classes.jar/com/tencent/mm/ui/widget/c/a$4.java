package com.tencent.mm.ui.widget.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.o;

final class a$4
  implements View.OnClickListener
{
  a$4(a parama, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(112758);
    if (a.b(this.AIL) != null) {
      a.b(this.AIL).onMMMenuItemSelected(a.a(this.AIL).getItem(this.lU), this.lU);
    }
    a.d(this.AIL).dismiss();
    AppMethodBeat.o(112758);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.c.a.4
 * JD-Core Version:    0.7.0.1
 */