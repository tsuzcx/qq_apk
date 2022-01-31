package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.snackbar.a.b;

final class SnsAdNativeLandingPagesUI$9
  implements a.b
{
  SnsAdNativeLandingPagesUI$9(SnsAdNativeLandingPagesUI paramSnsAdNativeLandingPagesUI) {}
  
  public final void aVA()
  {
    AppMethodBeat.i(154489);
    try
    {
      AdLandingPagesProxy.getInstance().favEditTag();
      AppMethodBeat.o(154489);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.SnsAdNativeLandingPagesUI", "favorite edittag fail, ex = " + localException.getMessage());
      AppMethodBeat.o(154489);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.9
 * JD-Core Version:    0.7.0.1
 */