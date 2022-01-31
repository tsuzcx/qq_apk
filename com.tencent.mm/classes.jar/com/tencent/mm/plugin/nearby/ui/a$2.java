package com.tencent.mm.plugin.nearby.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.z;

final class a$2
  implements DialogInterface.OnClickListener
{
  a$2(a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(55412);
    paramDialogInterface = g.RL().Ru();
    if (!a.b(this.pcO).isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramDialogInterface.set(4104, Boolean.valueOf(bool));
      com.tencent.mm.bo.a.fF(a.a(this.pcO));
      ((Activity)a.a(this.pcO)).finish();
      AppMethodBeat.o(55412);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.a.2
 * JD-Core Version:    0.7.0.1
 */