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
  
  protected final void a(int paramInt, ExtStorageMigrateException paramExtStorageMigrateException)
  {
    AppMethodBeat.i(211082);
    ad.printErrStackTrace("MicroMsg.ExtStorageMigrateTestCommand", paramExtStorageMigrateException, "[-] Failure.", new Object[0]);
    Toast.makeText(this.val$context, "Failure, reason: ".concat(String.valueOf(paramInt)), 1).show();
    AppMethodBeat.o(211082);
  }
  
  protected final void aah(int paramInt)
  {
    AppMethodBeat.i(211081);
    Toast.makeText(this.val$context, "Cancelled, reason: ".concat(String.valueOf(paramInt)), 1).show();
    AppMethodBeat.o(211081);
  }
  
  protected final void fjd()
  {
    AppMethodBeat.i(211083);
    Toast.makeText(this.val$context, "Done.", 1).show();
    AppMethodBeat.o(211083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.ExtStorageMigrateTestCommand.1
 * JD-Core Version:    0.7.0.1
 */