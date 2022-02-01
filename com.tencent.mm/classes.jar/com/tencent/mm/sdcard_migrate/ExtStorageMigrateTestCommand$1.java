package com.tencent.mm.sdcard_migrate;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdcard_migrate.util.ExtStorageMigrateException;
import com.tencent.mm.sdk.platformtools.ac;

class ExtStorageMigrateTestCommand$1
  extends MigrateResultCallbackAdapter
{
  ExtStorageMigrateTestCommand$1(c paramc, Context paramContext) {}
  
  protected final void Yd(int paramInt)
  {
    AppMethodBeat.i(195846);
    Toast.makeText(this.val$context, "Cancelled, reason: ".concat(String.valueOf(paramInt)), 1).show();
    AppMethodBeat.o(195846);
  }
  
  protected final void a(int paramInt, ExtStorageMigrateException paramExtStorageMigrateException)
  {
    AppMethodBeat.i(195847);
    ac.printErrStackTrace("MicroMsg.ExtStorageMigrateTestCommand", paramExtStorageMigrateException, "[-] Failure.", new Object[0]);
    Toast.makeText(this.val$context, "Failure, reason: ".concat(String.valueOf(paramInt)), 1).show();
    AppMethodBeat.o(195847);
  }
  
  protected final void eTA()
  {
    AppMethodBeat.i(195848);
    Toast.makeText(this.val$context, "Done.", 1).show();
    AppMethodBeat.o(195848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.ExtStorageMigrateTestCommand.1
 * JD-Core Version:    0.7.0.1
 */