package com.tencent.mm.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class i
  extends Activity
{
  public String yvL;
  
  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(114883);
    if (paramInt1 == 100)
    {
      if (paramInt2 != -100)
      {
        onBackPressed();
        AppMethodBeat.o(114883);
      }
    }
    else
    {
      finish();
      h.c("WxSplash.SplashHackActivity", "unknown request code.", new Object[0]);
    }
    AppMethodBeat.o(114883);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(114878);
    super.onCreate(paramBundle);
    h.c("WxSplash.SplashHackActivity", "onCreate", new Object[0]);
    setVisible(false);
    paramBundle = new Intent(this, h.dvA());
    paramBundle.putExtra("hashcode", hashCode());
    startActivityForResult(paramBundle, 100);
    AppMethodBeat.o(114878);
  }
  
  protected final void onDestroy()
  {
    AppMethodBeat.i(114882);
    h.c("WxSplash.SplashHackActivity", "onDestroy", new Object[0]);
    h.yvj.remove(this);
    setVisible(true);
    h.yvj.remove(this);
    super.onDestroy();
    AppMethodBeat.o(114882);
  }
  
  protected final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(114879);
    h.c("WxSplash.SplashHackActivity", "onNewIntent.", new Object[0]);
    if ((h.yvn != null) && (h.yvn.n(paramIntent))) {
      finish();
    }
    AppMethodBeat.o(114879);
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(114881);
    h.c("WxSplash.SplashHackActivity", "onPause", new Object[0]);
    super.onPause();
    AppMethodBeat.o(114881);
  }
  
  protected final void onResume()
  {
    AppMethodBeat.i(114880);
    super.onResume();
    h.c("WxSplash.SplashHackActivity", "onResume", new Object[0]);
    AppMethodBeat.o(114880);
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