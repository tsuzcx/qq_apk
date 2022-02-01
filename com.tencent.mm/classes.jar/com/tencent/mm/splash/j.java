package com.tencent.mm.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import java.util.ArrayList;

class j
  extends HellActivity
{
  public String UZM;
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(40677);
    if (paramInt1 == 100)
    {
      if (paramInt2 != -100)
      {
        onBackPressed();
        AppMethodBeat.o(40677);
      }
    }
    else
    {
      finish();
      i.g("WxSplash.SplashHackActivity", "unknown request code.", new Object[0]);
    }
    AppMethodBeat.o(40677);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(40672);
    super.onCreate(paramBundle);
    i.g("WxSplash.SplashHackActivity", "onCreate", new Object[0]);
    setVisible(false);
    paramBundle = new Intent(this, i.hup());
    paramBundle.putExtra("hashcode", hashCode());
    startActivityForResult(paramBundle, 100);
    overridePendingTransition(0, 0);
    AppMethodBeat.o(40672);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(40676);
    i.g("WxSplash.SplashHackActivity", "onDestroy", new Object[0]);
    i.UZl.remove(this);
    setVisible(true);
    i.UZl.remove(this);
    super.onDestroy();
    AppMethodBeat.o(40676);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(40673);
    i.g("WxSplash.SplashHackActivity", "onNewIntent.", new Object[0]);
    if ((i.UZo != null) && (i.UZo.p(paramIntent))) {
      finish();
    }
    AppMethodBeat.o(40673);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(40675);
    i.g("WxSplash.SplashHackActivity", "onPause", new Object[0]);
    super.onPause();
    AppMethodBeat.o(40675);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(40674);
    super.onResume();
    i.g("WxSplash.SplashHackActivity", "onResume", new Object[0]);
    AppMethodBeat.o(40674);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.splash.j
 * JD-Core Version:    0.7.0.1
 */