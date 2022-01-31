package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

final class SendAppMessageWrapperUI$4
  implements q.a
{
  SendAppMessageWrapperUI$4(SendAppMessageWrapperUI paramSendAppMessageWrapperUI) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    this.whK.setResult(-1, new Intent().putExtra("Select_stay_in_wx", true));
    this.whK.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SendAppMessageWrapperUI.4
 * JD-Core Version:    0.7.0.1
 */