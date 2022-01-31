package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.label.a.b;
import java.util.ArrayList;

final class SnsLabelUI$2
  implements Runnable
{
  SnsLabelUI$2(SnsLabelUI paramSnsLabelUI) {}
  
  public final void run()
  {
    a.bdA().bdu();
    SnsLabelUI.a(this.oZN, (ArrayList)a.bdA().bdv());
    SnsLabelUI.a(this.oZN).Q(SnsLabelUI.j(this.oZN));
    SnsLabelUI.k(this.oZN);
    if (((SnsLabelUI.j(this.oZN) == null) || (SnsLabelUI.j(this.oZN).size() == 0)) && ((SnsLabelUI.p(this.oZN) == null) || (SnsLabelUI.p(this.oZN).length() == 0)) && (SnsLabelUI.a(this.oZN).oZT != 0) && (SnsLabelUI.a(this.oZN).oZT != 1)) {
      SnsLabelUI.a(this.oZN).oZT = 0;
    }
    SnsLabelUI.a(this.oZN).notifyDataSetChanged();
    SnsLabelUI.m(this.oZN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLabelUI.2
 * JD-Core Version:    0.7.0.1
 */