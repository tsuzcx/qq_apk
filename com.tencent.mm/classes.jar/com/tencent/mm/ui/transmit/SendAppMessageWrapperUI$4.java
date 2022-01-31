package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.i;

final class SendAppMessageWrapperUI$4
  implements DialogInterface.OnDismissListener
{
  SendAppMessageWrapperUI$4(SendAppMessageWrapperUI paramSendAppMessageWrapperUI, String paramString, View paramView) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(154016);
    ((i)g.E(i.class)).a(this.hpi, this.val$view);
    AppMethodBeat.o(154016);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SendAppMessageWrapperUI.4
 * JD-Core Version:    0.7.0.1
 */