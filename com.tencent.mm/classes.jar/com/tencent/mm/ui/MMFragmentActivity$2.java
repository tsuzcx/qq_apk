package com.tencent.mm.ui;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class MMFragmentActivity$2
  extends MMFragmentActivity.f
{
  MMFragmentActivity$2(MMFragmentActivity paramMMFragmentActivity, Runnable paramRunnable) {}
  
  public final void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    AppMethodBeat.i(249134);
    if ((paramString.equals("gprs_alert")) && (!paramSharedPreferences.getBoolean("gprs_alert", true)))
    {
      Log.i("MicroMsg.MMFragmentActivity", "onSharedPreferenceChanged");
      this.adFq.run();
      if ((!this.adFp.isPaused()) && (MMFragmentActivity.access$000(this.adFp) != null)) {
        MMFragmentActivity.access$000(this.adFp).onResume();
      }
      dead();
    }
    AppMethodBeat.o(249134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.MMFragmentActivity.2
 * JD-Core Version:    0.7.0.1
 */