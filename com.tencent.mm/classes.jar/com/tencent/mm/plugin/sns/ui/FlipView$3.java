package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.h.a.am;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.widget.a.d.a;

final class FlipView$3
  implements d.a
{
  FlipView$3(FlipView paramFlipView) {}
  
  public final void onDismiss()
  {
    am localam = new am();
    localam.bGF.filePath = FlipView.a(this.oOW);
    a.udP.m(localam);
    FlipView.b(this.oOW);
    FlipView.c(this.oOW);
    FlipView.a(this.oOW, "");
    FlipView.d(this.oOW);
    FlipView.b(this.oOW, null);
    FlipView.a(this.oOW, FlipView.b(this.oOW, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.FlipView.3
 * JD-Core Version:    0.7.0.1
 */