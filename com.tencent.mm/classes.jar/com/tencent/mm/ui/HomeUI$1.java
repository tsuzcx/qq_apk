package com.tencent.mm.ui;

import com.tencent.mm.blink.FirstScreenFrameLayout.a;
import com.tencent.mm.blink.a;
import com.tencent.mm.blink.b;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.f;

final class HomeUI$1
  implements FirstScreenFrameLayout.a
{
  HomeUI$1(HomeUI paramHomeUI) {}
  
  public final void vQ()
  {
    if (a.vC())
    {
      a.fP(6);
      a.vD();
      a.el("First Screen");
      f.cLb().ij(500L).d(new HomeUI.1.1(this));
    }
    b.vG().vK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.1
 * JD-Core Version:    0.7.0.1
 */