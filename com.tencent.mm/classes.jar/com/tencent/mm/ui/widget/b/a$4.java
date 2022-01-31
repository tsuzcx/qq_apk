package com.tencent.mm.ui.widget.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.o;

final class a$4
  implements View.OnClickListener
{
  a$4(a parama, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    if (a.b(this.woj) != null) {
      a.b(this.woj).onMMMenuItemSelected(a.a(this.woj).getItem(this.kX), this.kX);
    }
    a.d(this.woj).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.b.a.4
 * JD-Core Version:    0.7.0.1
 */