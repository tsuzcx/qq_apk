package com.tencent.mm.splash;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.hellhoundlib.b.c;
import java.util.ArrayList;

final class j
  extends HellActivity
{
  public String acBe;
  private PendingIntent acBf;
  
  j()
  {
    this(null);
  }
  
  j(PendingIntent paramPendingIntent)
  {
    super();
    this.acBf = paramPendingIntent;
  }
  
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
      i.g("WxSplash.SplashHackActivity", "unknown request code.", new Object[0]);
    }
    AppMethodBeat.o(40677);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(40672);
    super.onCreate(paramBundle);
    if (this.acBf != null)
    {
      i.g("WxSplash.SplashHackActivity", "early redirection", new Object[0]);
      try
      {
        this.acBf.send();
        finish();
        AppMethodBeat.o(40672);
        return;
      }
      catch (PendingIntent.CanceledException paramBundle)
      {
        i.g("WxSplash.SplashHackActivity", "Failed to redirect", new Object[0]);
        this.acBf = null;
      }
    }
    i.g("WxSplash.SplashHackActivity", "onCreate", new Object[0]);
    setVisible(false);
    paramBundle = new Intent(this, i.iVS());
    paramBundle.putExtra("hashcode", hashCode());
    startActivityForResult(paramBundle, 100);
    overridePendingTransition(0, 0);
    AppMethodBeat.o(40672);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(40676);
    if (this.acBf != null)
    {
      com.tencent.mm.hellhoundlib.b.a locala = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/splash/SplashHackActivity", "onDestroy", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)locala.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/splash/SplashHackActivity", "onDestroy", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    }
    i.g("WxSplash.SplashHackActivity", "onDestroy", new Object[0]);
    i.acAD.remove(this);
    setVisible(true);
    i.acAD.remove(this);
    super.onDestroy();
    AppMethodBeat.o(40676);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(40673);
    i.g("WxSplash.SplashHackActivity", "onNewIntent.", new Object[0]);
    if ((i.acAG != null) && (i.acAG.q(paramIntent))) {
      finish();
    }
    AppMethodBeat.o(40673);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(40675);
    i.g("WxSplash.SplashHackActivity", "onPause", new Object[0]);
    super.onPause();
    AppMethodBeat.o(40675);
  }
  
  public final void onResume()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.splash.j
 * JD-Core Version:    0.7.0.1
 */