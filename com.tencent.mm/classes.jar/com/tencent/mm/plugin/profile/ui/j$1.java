package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.pluginsdk.n;

final class j$1
  implements DialogInterface.OnClickListener
{
  j$1(j paramj) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(23548);
    b.gmO.g(new Intent(), j.a(this.pAj));
    AppMethodBeat.o(23548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.j.1
 * JD-Core Version:    0.7.0.1
 */