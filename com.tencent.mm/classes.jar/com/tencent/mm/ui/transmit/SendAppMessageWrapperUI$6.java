package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

final class SendAppMessageWrapperUI$6
  implements q.a
{
  SendAppMessageWrapperUI$6(SendAppMessageWrapperUI paramSendAppMessageWrapperUI) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(35217);
    this.AAH.setResult(-1, new Intent().putExtra("Select_stay_in_wx", true));
    this.AAH.finish();
    AppMethodBeat.o(35217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SendAppMessageWrapperUI.6
 * JD-Core Version:    0.7.0.1
 */