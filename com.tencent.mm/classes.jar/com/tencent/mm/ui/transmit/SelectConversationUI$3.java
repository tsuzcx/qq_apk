package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.i;

final class SelectConversationUI$3
  implements DialogInterface.OnDismissListener
{
  SelectConversationUI$3(SelectConversationUI paramSelectConversationUI, String paramString, View paramView) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(35126);
    ((i)g.E(i.class)).a(this.hpi, this.val$view);
    AppMethodBeat.o(35126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI.3
 * JD-Core Version:    0.7.0.1
 */