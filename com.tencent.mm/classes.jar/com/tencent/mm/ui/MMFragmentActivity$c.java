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

final class MMFragmentActivity$c
{
  NfcAdapter Wba = null;
  private PendingIntent Wbb;
  private IntentFilter[] Wbc;
  private String[][] Wbd;
  
  private MMFragmentActivity$c(MMFragmentActivity paramMMFragmentActivity) {}
  
  final void init()
  {
    AppMethodBeat.i(141405);
    Object localObject = new Intent();
    ((Intent)localObject).setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI");
    ((Intent)localObject).addFlags(536870912);
    this.Wbb = PendingIntent.getActivity(this.WaU, 0, (Intent)localObject, 0);
    localObject = new IntentFilter("android.nfc.action.NDEF_DISCOVERED");
    try
    {
      ((IntentFilter)localObject).addDataType("*/*");
      IntentFilter localIntentFilter = new IntentFilter("android.nfc.action.TECH_DISCOVERED");
      localIntentFilter.addDataScheme("vnd.android.nfc");
      this.Wbc = new IntentFilter[] { localObject, localIntentFilter, new IntentFilter("android.nfc.action.TAG_DISCOVERED") };
      this.Wbd = new String[][] { { NfcA.class.getName(), IsoDep.class.getName() } };
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
    AppMethodBeat.i(219920);
    if (this.Wba != null)
    {
      if ((this.Wbb == null) || (this.Wbc == null) || (this.Wbd == null)) {
        init();
      }
      try
      {
        Log.i("MicroMsg.MMFragmentActivity", "[NFC] enableForegroundDispatch");
        this.Wba.enableForegroundDispatch(this.WaU, this.Wbb, this.Wbc, this.Wbd);
        AppMethodBeat.o(219920);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.MMFragmentActivity", "lo-nfc-onResume: exp:" + localException.getLocalizedMessage());
      }
    }
    AppMethodBeat.o(219920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.MMFragmentActivity.c
 * JD-Core Version:    0.7.0.1
 */