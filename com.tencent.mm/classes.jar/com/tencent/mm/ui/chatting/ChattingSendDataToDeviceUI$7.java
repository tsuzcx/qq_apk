package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dk;
import com.tencent.mm.sdk.b.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

final class ChattingSendDataToDeviceUI$7
  implements DialogInterface.OnClickListener
{
  ChattingSendDataToDeviceUI$7(ChattingSendDataToDeviceUI paramChattingSendDataToDeviceUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(34641);
    paramDialogInterface = ChattingSendDataToDeviceUI.b(this.Gpk).keySet().iterator();
    while (paramDialogInterface.hasNext())
    {
      String str = (String)paramDialogInterface.next();
      dk localdk = new dk();
      localdk.dfB.cLR = str;
      a.ESL.l(localdk);
    }
    this.Gpk.finish();
    AppMethodBeat.o(34641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.7
 * JD-Core Version:    0.7.0.1
 */