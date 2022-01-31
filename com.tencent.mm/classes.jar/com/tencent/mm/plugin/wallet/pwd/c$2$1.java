package com.tencent.mm.plugin.wallet.pwd;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$2$1
  implements DialogInterface.OnClickListener
{
  c$2$1(c.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(46156);
    c.c(this.tXF.tXE).putInt("RESET_PWD_USER_ACTION", 2);
    this.tXF.tXE.a(this.tXF.hwZ, 0, c.d(this.tXF.tXE));
    AppMethodBeat.o(46156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.c.2.1
 * JD-Core Version:    0.7.0.1
 */