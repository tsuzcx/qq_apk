package com.tencent.mm.ui;

import android.nfc.NfcAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class MMFragmentActivity$1
  implements Runnable
{
  MMFragmentActivity$1(MMFragmentActivity paramMMFragmentActivity) {}
  
  public final void run()
  {
    AppMethodBeat.i(193603);
    Log.i("MicroMsg.MMFragmentActivity", "createNfcFilterHelperTask run");
    MMFragmentActivity.access$002(this.WaU, new MMFragmentActivity.c(this.WaU, (byte)0));
    MMFragmentActivity.c localc = MMFragmentActivity.access$000(this.WaU);
    try
    {
      Log.i("MicroMsg.MMFragmentActivity", "[NFC] getDefaultAdapter");
      localc.Wba = NfcAdapter.getDefaultAdapter(localc.WaU);
      localc.init();
      AppMethodBeat.o(193603);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.MMFragmentActivity", localThrowable, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.MMFragmentActivity.1
 * JD-Core Version:    0.7.0.1
 */