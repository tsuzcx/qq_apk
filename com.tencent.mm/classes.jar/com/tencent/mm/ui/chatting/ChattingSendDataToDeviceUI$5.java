package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.de;
import com.tencent.mm.sdk.b.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

final class ChattingSendDataToDeviceUI$5
  implements DialogInterface.OnClickListener
{
  ChattingSendDataToDeviceUI$5(ChattingSendDataToDeviceUI paramChattingSendDataToDeviceUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(30766);
    paramDialogInterface = ChattingSendDataToDeviceUI.b(this.zAW).keySet().iterator();
    while (paramDialogInterface.hasNext())
    {
      String str = (String)paramDialogInterface.next();
      de localde = new de();
      localde.cqF.bYu = str;
      a.ymk.l(localde);
    }
    this.zAW.finish();
    AppMethodBeat.o(30766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.5
 * JD-Core Version:    0.7.0.1
 */