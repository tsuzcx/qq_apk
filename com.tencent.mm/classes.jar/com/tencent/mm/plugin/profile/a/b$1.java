package com.tencent.mm.plugin.profile.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.ad;

final class b$1
  implements DialogInterface.OnClickListener
{
  b$1(b paramb, CheckBox paramCheckBox) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(23257);
    b.a(this.pxL);
    if (b.b(this.pxL).getSource() == 18)
    {
      b.c(this.pxL);
      if (this.pxK.isChecked()) {
        this.pxL.cbN();
      }
    }
    AppMethodBeat.o(23257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.b.1
 * JD-Core Version:    0.7.0.1
 */