package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.b;

final class a$1
  implements DialogInterface.OnClickListener
{
  a$1(h.b paramb, EditText paramEditText, Context paramContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(47853);
    boolean bool = true;
    if (this.uwb != null) {
      bool = this.uwb.onFinish(this.uwc.getText().toString().trim());
    }
    if (bool)
    {
      paramDialogInterface.dismiss();
      if ((this.val$context instanceof MMActivity)) {
        al.d(new a.1.1(this));
      }
    }
    AppMethodBeat.o(47853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.a.1
 * JD-Core Version:    0.7.0.1
 */