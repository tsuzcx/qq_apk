package com.tencent.mm.plugin.shake.c.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$2
  implements View.OnClickListener
{
  a$2(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(24548);
    if (paramView.getId() == 2131827694)
    {
      this.qOr.dismiss();
      if (a.a(this.qOr) != null) {
        a.a(this.qOr).clB();
      }
      ab.i("MicroMsg.ShakeCardDialog", "close ShakeCardDialog");
      AppMethodBeat.o(24548);
      return;
    }
    if (paramView.getId() == 2131821984)
    {
      if (a.b(this.qOr) == a.a.qOt)
      {
        a.a(this.qOr, a.a.qOu);
        a.a(this.qOr, 0);
        a.c(this.qOr);
        a.d(this.qOr);
        AppMethodBeat.o(24548);
        return;
      }
      if (a.b(this.qOr) != a.a.qOu)
      {
        if (a.b(this.qOr) == a.a.qOw)
        {
          a.d(this.qOr);
          AppMethodBeat.o(24548);
          return;
        }
        if (a.b(this.qOr) == a.a.qOv)
        {
          com.tencent.mm.sdk.b.a.ymk.c(a.e(this.qOr));
          a.f(this.qOr);
        }
      }
    }
    AppMethodBeat.o(24548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.b.a.2
 * JD-Core Version:    0.7.0.1
 */