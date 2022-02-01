package com.tencent.mm.ui;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentFilter.MalformedMimeTypeException;
import android.nfc.NfcAdapter;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class MMFragmentActivity$e
{
  NfcAdapter adFv = null;
  private PendingIntent adFw;
  private IntentFilter[] adFx;
  private String[][] adFy;
  
  private MMFragmentActivity$e(MMFragmentActivity paramMMFragmentActivity) {}
  
  final void init()
  {
    AppMethodBeat.i(141405);
    Object localObject = new Intent();
    ((Intent)localObject).setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcDispatchLogicUI");
    ((Intent)localObject).addFlags(536870912);
    this.adFw = PendingIntent.getActivity(this.adFp, 0, (Intent)localObject, 0);
    localObject = new IntentFilter("android.nfc.action.NDEF_DISCOVERED");
    try
    {
      ((IntentFilter)localObject).addDataType("*/*");
      IntentFilter localIntentFilter = new IntentFilter("android.nfc.action.TECH_DISCOVERED");
      localIntentFilter.addDataScheme("vnd.android.nfc");
      this.adFx = new IntentFilter[] { localObject, localIntentFilter, new IntentFilter("android.nfc.action.TAG_DISCOVERED") };
      this.adFy = new String[][] { { NfcA.class.getName(), IsoDep.class.getName() } };
      AppMethodBeat.o(141405);
      return;
    }
    catch (IntentFilter.MalformedMimeTypeException localMalformedMimeTypeException)
    {
      RuntimeException localRuntimeException = new RuntimeException("fail", localMalformedMimeTypeException);
      AppMethodBeat.o(141405);
      throw localRuntimeException;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(249746);
    if (this.adFv != null)
    {
      if ((this.adFw == null) || (this.adFx == null) || (this.adFy == null)) {
        init();
      }
      try
      {
        Log.i("MicroMsg.MMFragmentActivity", "[NFC] enableForegroundDispatch");
        this.adFv.enableForegroundDispatch(this.adFp, this.adFw, this.adFx, this.adFy);
        AppMethodBeat.o(249746);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.MMFragmentActivity", "lo-nfc-onResume: exp:" + localException.getLocalizedMessage());
      }
    }
    AppMethodBeat.o(249746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.MMFragmentActivity.e
 * JD-Core Version:    0.7.0.1
 */