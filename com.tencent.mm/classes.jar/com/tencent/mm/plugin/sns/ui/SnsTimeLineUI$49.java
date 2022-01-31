package com.tencent.mm.plugin.sns.ui;

import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.ListView;
import com.tencent.mm.plugin.sns.j.b;
import com.tencent.mm.plugin.sns.j.b.a;
import com.tencent.mm.ui.widget.QFadeImageView;

final class SnsTimeLineUI$49
  implements Runnable
{
  SnsTimeLineUI$49(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void run()
  {
    SnsTimeLineUI.h(this.pfC).lwE.setSelection(0);
    SnsTimeLineUI.a locala = SnsTimeLineUI.E(this.pfC);
    if (locala.pfY)
    {
      AbsoluteLayout.LayoutParams localLayoutParams = (AbsoluteLayout.LayoutParams)SnsTimeLineUI.m(locala.pfC).getLayoutParams();
      localLayoutParams.y = locala.pfZ;
      SnsTimeLineUI.m(locala.pfC).setLayoutParams(localLayoutParams);
      locala.pfS = locala.pga;
      locala.pfU = locala.pgb;
    }
    SnsTimeLineUI.E(this.pfC).bJL();
    SnsTimeLineUI.k(this.pfC).prw.b(SnsTimeLineUI.r(this.pfC), SnsTimeLineUI.i(this.pfC), SnsTimeLineUI.j(this.pfC), SnsTimeLineUI.s(this.pfC));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.49
 * JD-Core Version:    0.7.0.1
 */