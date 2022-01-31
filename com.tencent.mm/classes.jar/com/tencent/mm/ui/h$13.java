package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.c;

final class h$13
  implements DialogInterface.OnClickListener
{
  h$13(h paramh) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(29326);
    this.yXo.qHE.setText("");
    this.yXo.gwr.dismiss();
    AppMethodBeat.o(29326);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.h.13
 * JD-Core Version:    0.7.0.1
 */