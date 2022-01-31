package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsTimeLineUI$38
  implements TestTimeForSns.a
{
  SnsTimeLineUI$38(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void bEm()
  {
    AppMethodBeat.i(155750);
    ab.i("MicroMsg.SnsTimeLineUI", "sns has drawed");
    SnsTimeLineUI.G(this.rYv).post(new SnsTimeLineUI.38.1(this));
    AppMethodBeat.o(155750);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.38
 * JD-Core Version:    0.7.0.1
 */