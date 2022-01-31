package com.tencent.mm.plugin.shake.c.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.h;
import com.tencent.mm.sdk.platformtools.y;

final class a$2
  implements View.OnClickListener
{
  a$2(a parama) {}
  
  public final void onClick(View paramView)
  {
    if (paramView.getId() == R.h.card_close_img)
    {
      this.oai.dismiss();
      if (a.a(this.oai) != null) {
        a.a(this.oai).bAj();
      }
      y.i("MicroMsg.ShakeCardDialog", "close ShakeCardDialog");
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramView.getId() != R.h.card_accept_btn);
        if (a.b(this.oai) == a.a.oak)
        {
          a.a(this.oai, a.a.oal);
          a.a(this.oai, 0);
          a.c(this.oai);
          a.d(this.oai);
          return;
        }
      } while (a.b(this.oai) == a.a.oal);
      if (a.b(this.oai) == a.a.oan)
      {
        a.d(this.oai);
        return;
      }
    } while (a.b(this.oai) != a.a.oam);
    com.tencent.mm.sdk.b.a.udP.c(a.e(this.oai));
    a.f(this.oai);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.b.a.2
 * JD-Core Version:    0.7.0.1
 */