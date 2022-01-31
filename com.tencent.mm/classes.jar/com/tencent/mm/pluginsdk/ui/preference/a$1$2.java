package com.tencent.mm.pluginsdk.ui.preference;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.p;

final class a$1$2
  implements DialogInterface.OnClickListener
{
  a$1$2(a.1 param1, EditText paramEditText) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(28026);
    paramDialogInterface = this.waG.getText().toString().trim();
    if ((paramDialogInterface != null) && (paramDialogInterface.length() > 0)) {
      try
      {
        a.a(this.waF.waD, paramDialogInterface);
        AppMethodBeat.o(28026);
        return;
      }
      catch (ArrayIndexOutOfBoundsException paramDialogInterface)
      {
        ab.printErrStackTrace("MicroMsg.FMessageItemView", paramDialogInterface, "", new Object[0]);
        if ((a.b(this.waF.waD) != null) && (a.b(this.waF.waD).isShowing())) {
          a.b(this.waF.waD).dismiss();
        }
      }
    }
    AppMethodBeat.o(28026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.a.1.2
 * JD-Core Version:    0.7.0.1
 */