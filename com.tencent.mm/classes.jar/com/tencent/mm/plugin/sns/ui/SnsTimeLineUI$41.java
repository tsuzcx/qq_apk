package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMPullDownView.f;

final class SnsTimeLineUI$41
  implements MMPullDownView.f
{
  SnsTimeLineUI$41(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void be(float paramFloat)
  {
    AppMethodBeat.i(155753);
    SnsTimeLineUI.N(this.rYv);
    if (SnsTimeLineUI.rYc.booleanValue()) {
      ab.i("MicroMsg.SnsTimeLineUI", "mUIAction.header.getTop %s originalHeaderTop %s distanceY %s", new Object[] { Integer.valueOf(SnsTimeLineUI.l(this.rYv).rmc.getTop()), Integer.valueOf(SnsTimeLineUI.j(this.rYv).rZa), Float.valueOf(paramFloat) });
    }
    if ((SnsTimeLineUI.l(this.rYv).rmc.getTop() >= SnsTimeLineUI.j(this.rYv).rZa) || (paramFloat > 0.0F)) {
      SnsTimeLineUI.j(this.rYv).bf(paramFloat);
    }
    SnsTimeLineUI.i(this.rYv).ctr();
    this.rYv.ctC();
    SnsTimeLineUI.i(this.rYv).rFp.cwK();
    AppMethodBeat.o(155753);
  }
  
  public final void cwp()
  {
    AppMethodBeat.i(155754);
    SnsTimeLineUI.j(this.rYv).cws();
    AppMethodBeat.o(155754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.41
 * JD-Core Version:    0.7.0.1
 */