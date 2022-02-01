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
    AppMethodBeat.i(249145);
    Log.i("MicroMsg.MMFragmentActivity", "createNfcFilterHelperTask run");
    MMFragmentActivity.access$002(this.adFp, new MMFragmentActivity.e(this.adFp, (byte)0));
    MMFragmentActivity.e locale = MMFragmentActivity.access$000(this.adFp);
    try
    {
      Log.i("MicroMsg.MMFragmentActivity", "[NFC] getDefaultAdapter");
      locale.adFv = NfcAdapter.getDefaultAdapter(locale.adFp);
      locale.init();
      AppMethodBeat.o(249145);
      return;
    }
    finally
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.MMFragmentActivity", localThrowable, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.MMFragmentActivity.1
 * JD-Core Version:    0.7.0.1
 */