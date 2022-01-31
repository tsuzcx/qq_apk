package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.j.b;
import com.tencent.mm.plugin.sns.j.b.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class SnsTimeLineUI$30$1
  implements Runnable
{
  SnsTimeLineUI$30$1(SnsTimeLineUI.30 param30) {}
  
  public final void run()
  {
    if ((SnsTimeLineUI.a(this.pfL.pfC) == null) || (SnsTimeLineUI.z(this.pfL.pfC) == null)) {
      y.i("MicroMsg.SnsTimeLineUI", "onViewDrawed is error");
    }
    do
    {
      return;
      SnsTimeLineUI.z(this.pfL.pfC).setListener(null);
      SnsTimeLineUI.a(this.pfL.pfC, SnsTimeLineUI.F(this.pfL.pfC));
      if (SnsTimeLineUI.G(this.pfL.pfC))
      {
        y.w("MicroMsg.SnsTimeLineUI", "too fast that it finish");
        return;
      }
      if (SnsTimeLineUI.v(this.pfL.pfC)) {
        af.bDv().x(af.bDM().oto, -1);
      }
      if (!SnsTimeLineUI.v(this.pfL.pfC)) {
        SnsTimeLineUI.k(this.pfL.pfC).prw.b(SnsTimeLineUI.r(this.pfL.pfC), SnsTimeLineUI.i(this.pfL.pfC), SnsTimeLineUI.j(this.pfL.pfC), SnsTimeLineUI.s(this.pfL.pfC));
      }
      SnsTimeLineUI.a(this.pfL.pfC, false);
    } while (this.pfL.pfC.oWw == null);
    this.pfL.pfC.oWw.bCe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.30.1
 * JD-Core Version:    0.7.0.1
 */