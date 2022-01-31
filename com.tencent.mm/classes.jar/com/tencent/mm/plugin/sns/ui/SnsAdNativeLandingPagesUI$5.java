package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.snackbar.a.b;

final class SnsAdNativeLandingPagesUI$5
  implements a.b
{
  SnsAdNativeLandingPagesUI$5(SnsAdNativeLandingPagesUI paramSnsAdNativeLandingPagesUI) {}
  
  public final void amw()
  {
    try
    {
      AdLandingPagesProxy.getInstance().favEditTag();
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.SnsAdNativeLandingPagesUI", "favorite edittag fail, ex = " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.5
 * JD-Core Version:    0.7.0.1
 */