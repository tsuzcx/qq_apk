package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

final class SendAppMessageWrapperUI$5
  implements q.a
{
  SendAppMessageWrapperUI$5(SendAppMessageWrapperUI paramSendAppMessageWrapperUI) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    this.whK.setResult(-1);
    this.whK.finish();
    paramString = ReportUtil.c(this.whK.getIntent().getExtras(), 0);
    ReportUtil.a(this.whK, paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SendAppMessageWrapperUI.5
 * JD-Core Version:    0.7.0.1
 */