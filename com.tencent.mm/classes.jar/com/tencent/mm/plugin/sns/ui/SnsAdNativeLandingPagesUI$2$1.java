package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class SnsAdNativeLandingPagesUI$2$1
  implements n.c
{
  SnsAdNativeLandingPagesUI$2$1(SnsAdNativeLandingPagesUI.2 param2) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(38622);
    if ((SnsAdNativeLandingPagesUI.A(this.rMX.rMW) == 0) || ((SnsAdNativeLandingPagesUI.A(this.rMX.rMW) & 0x2) == 0)) {
      paraml.a(1, this.rMX.rMW.getString(2131302657), 2131231038);
    }
    if ((SnsAdNativeLandingPagesUI.A(this.rMX.rMW) == 0) || ((SnsAdNativeLandingPagesUI.A(this.rMX.rMW) & 0x1) == 0)) {
      paraml.a(2, this.rMX.rMW.getString(2131303768), 2131231024);
    }
    if (((SnsAdNativeLandingPagesUI.A(this.rMX.rMW) == 0) || ((SnsAdNativeLandingPagesUI.A(this.rMX.rMW) & 0x4) == 0)) && (SnsAdNativeLandingPagesUI.u(this.rMX.rMW) != 7)) {
      paraml.a(3, this.rMX.rMW.getString(2131298168), 2131231015);
    }
    if (((SnsAdNativeLandingPagesUI.A(this.rMX.rMW) == 0) || (SnsAdNativeLandingPagesUI.B(this.rMX.rMW))) && (SnsAdNativeLandingPagesUI.t(this.rMX.rMW) == 2) && (SnsAdNativeLandingPagesUI.C(this.rMX.rMW))) {
      if (SnsAdNativeLandingPagesUI.D(this.rMX.rMW) == null) {
        break label255;
      }
    }
    label255:
    for (String str = SnsAdNativeLandingPagesUI.D(this.rMX.rMW);; str = "")
    {
      paraml.a(4, str, 0);
      AppMethodBeat.o(38622);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.2.1
 * JD-Core Version:    0.7.0.1
 */