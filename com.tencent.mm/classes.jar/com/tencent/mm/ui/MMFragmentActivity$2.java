package com.tencent.mm.ui;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class MMFragmentActivity$2
  extends MMFragmentActivity.d
{
  MMFragmentActivity$2(MMFragmentActivity paramMMFragmentActivity, Runnable paramRunnable) {}
  
  public final void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    AppMethodBeat.i(211797);
    if ((paramString.equals("gprs_alert")) && (!paramSharedPreferences.getBoolean("gprs_alert", true)))
    {
      Log.i("MicroMsg.MMFragmentActivity", "onSharedPreferenceChanged");
      this.WaV.run();
      if ((!this.WaU.isPaused()) && (MMFragmentActivity.access$000(this.WaU) != null)) {
        MMFragmentActivity.access$000(this.WaU).onResume();
      }
      dead();
    }
    AppMethodBeat.o(211797);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.MMFragmentActivity.2
 * JD-Core Version:    0.7.0.1
 */