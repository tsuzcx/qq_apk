package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.snackbar.a.b;

final class SnsAdNativeLandingPagesUI$14
  implements a.b
{
  SnsAdNativeLandingPagesUI$14(SnsAdNativeLandingPagesUI paramSnsAdNativeLandingPagesUI) {}
  
  public final void biY()
  {
    AppMethodBeat.i(219809);
    try
    {
      AdLandingPagesProxy.getInstance().favEditTag();
      AppMethodBeat.o(219809);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.SnsAdNativeLandingPagesUI", "favorite edittag fail, ex = " + localException.getMessage());
      AppMethodBeat.o(219809);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.14
 * JD-Core Version:    0.7.0.1
 */