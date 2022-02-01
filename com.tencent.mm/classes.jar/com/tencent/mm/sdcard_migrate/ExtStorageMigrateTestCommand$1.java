package com.tencent.mm.sdcard_migrate;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdcard_migrate.util.ExtStorageMigrateException;
import com.tencent.mm.sdk.platformtools.ad;

class ExtStorageMigrateTestCommand$1
  extends MigrateResultCallbackAdapter
{
  ExtStorageMigrateTestCommand$1(c paramc, Context paramContext) {}
  
  protected final void VU(int paramInt)
  {
    AppMethodBeat.i(196826);
    Toast.makeText(this.val$context, "Cancelled, reason: ".concat(String.valueOf(paramInt)), 1).show();
    AppMethodBeat.o(196826);
  }
  
  protected final void a(int paramInt, ExtStorageMigrateException paramExtStorageMigrateException)
  {
    AppMethodBeat.i(196827);
    ad.printErrStackTrace("MicroMsg.ExtStorageMigrateTestCommand", paramExtStorageMigrateException, "[-] Failure.", new Object[0]);
    Toast.makeText(this.val$context, "Failure, reason: ".concat(String.valueOf(paramInt)), 1).show();
    AppMethodBeat.o(196827);
  }
  
  protected final void eEg()
  {
    AppMethodBeat.i(196828);
    Toast.makeText(this.val$context, "Done.", 1).show();
    AppMethodBeat.o(196828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.ExtStorageMigrateTestCommand.1
 * JD-Core Version:    0.7.0.1
 */