package com.tencent.mm.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import java.util.ArrayList;

final class i
  extends HellActivity
{
  public String FbM;
  
  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
      h.b("WxSplash.SplashHackActivity", "unknown request code.", new Object[0]);
    }
    AppMethodBeat.o(40677);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(40672);
    super.onCreate(paramBundle);
    h.b("WxSplash.SplashHackActivity", "onCreate", new Object[0]);
    setVisible(false);
    paramBundle = new Intent(this, h.eIq());
    paramBundle.putExtra("hashcode", hashCode());
    startActivityForResult(paramBundle, 100);
    AppMethodBeat.o(40672);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(40676);
    h.b("WxSplash.SplashHackActivity", "onDestroy", new Object[0]);
    h.Fbm.remove(this);
    setVisible(true);
    h.Fbm.remove(this);
    super.onDestroy();
    AppMethodBeat.o(40676);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(40673);
    h.b("WxSplash.SplashHackActivity", "onNewIntent.", new Object[0]);
    if ((h.Fbp != null) && (h.Fbp.n(paramIntent))) {
      finish();
    }
    AppMethodBeat.o(40673);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(40675);
    h.b("WxSplash.SplashHackActivity", "onPause", new Object[0]);
    super.onPause();
    AppMethodBeat.o(40675);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(40674);
    super.onResume();
    h.b("WxSplash.SplashHackActivity", "onResume", new Object[0]);
    AppMethodBeat.o(40674);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.i
 * JD-Core Version:    0.7.0.1
 */