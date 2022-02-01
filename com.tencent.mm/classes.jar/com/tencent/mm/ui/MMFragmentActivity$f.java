package com.tencent.mm.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vending.e.a;

abstract class MMFragmentActivity$f
  implements SharedPreferences.OnSharedPreferenceChangeListener, a
{
  public MMFragmentActivity$f()
  {
    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).registerOnSharedPreferenceChangeListener(this);
  }
  
  public void dead()
  {
    Log.i("MicroMsg.MMFragmentActivity", "OnSharedPreferenceChangeListenerLifeCycleAware dead");
    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).unregisterOnSharedPreferenceChangeListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.MMFragmentActivity.f
 * JD-Core Version:    0.7.0.1
 */