package com.tencent.mm.ui.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.b.b;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.y;

final class a$2
  implements View.OnClickListener
{
  a$2(a parama) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.ChattingMonitoredBanner", "hy: user required close the banner");
    this.uSG.Gg(2);
    au.Hx().FZ().c(b.b.dYq);
    au.Hx().FZ().c(b.b.dYr);
    this.uSG.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.d.a.2
 * JD-Core Version:    0.7.0.1
 */