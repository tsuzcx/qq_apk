package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.h.f;
import com.tencent.mm.ui.base.n.d;

final class SnsTimeLineUI$43
  implements n.d
{
  SnsTimeLineUI$43(SnsTimeLineUI paramSnsTimeLineUI, b paramb) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    case 2: 
    default: 
      return;
    case 1: 
      com.tencent.mm.plugin.report.service.h.nFQ.f(13822, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
      f.ozP.b(this.pfM);
      this.pfM.QX();
      SnsTimeLineUI.h(this.pfC).piE = this.pfM;
      SnsTimeLineUI.h(this.pfC).yW(1);
      SnsTimeLineUI.J(this.pfC).yQ(2);
      SnsTimeLineUI.b(SnsTimeLineUI.J(this.pfC));
      return;
    case 3: 
      SnsTimeLineUI.J(this.pfC).yQ(1);
      SnsTimeLineUI.b(SnsTimeLineUI.J(this.pfC));
      SnsTimeLineUI.K(this.pfC);
      return;
    }
    SnsTimeLineUI.J(this.pfC).yQ(3);
    SnsTimeLineUI.b(SnsTimeLineUI.J(this.pfC));
    SnsTimeLineUI.L(this.pfC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.43
 * JD-Core Version:    0.7.0.1
 */