package io.flutter.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.m;
import io.flutter.plugin.a.m.c;
import io.flutter.view.FlutterView.b;

public class FlutterFragmentActivity
  extends FragmentActivity
  implements a.a, m, FlutterView.b
{
  private final a MXJ;
  private final b MXK;
  private final FlutterView.b MXL;
  private final m MXM;
  
  public FlutterFragmentActivity()
  {
    AppMethodBeat.i(9631);
    this.MXJ = new a(this, this);
    this.MXK = this.MXJ;
    this.MXL = this.MXJ;
    this.MXM = this.MXJ;
    AppMethodBeat.o(9631);
  }
  
  public final boolean bdl(String paramString)
  {
    AppMethodBeat.i(9632);
    boolean bool = this.MXM.bdl(paramString);
    AppMethodBeat.o(9632);
    return bool;
  }
  
  public final m.c er(String paramString)
  {
    AppMethodBeat.i(9633);
    paramString = this.MXM.er(paramString);
    AppMethodBeat.o(9633);
    return paramString;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(9642);
    if (!this.MXK.onActivityResult(paramInt1, paramInt2, paramIntent)) {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(9642);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(9636);
    if (!this.MXK.onBackPressed()) {
      super.onBackPressed();
    }
    AppMethodBeat.o(9636);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(9647);
    super.onConfigurationChanged(paramConfiguration);
    this.MXK.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(9647);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(9634);
    super.onCreate(paramBundle);
    this.MXK.giJ();
    AppMethodBeat.o(9634);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(9635);
    this.MXK.onDestroy();
    super.onDestroy();
    AppMethodBeat.o(9635);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(9646);
    this.MXK.onLowMemory();
    AppMethodBeat.o(9646);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(9643);
    super.onNewIntent(paramIntent);
    this.MXK.onNewIntent(paramIntent);
    AppMethodBeat.o(9643);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(9639);
    super.onPause();
    this.MXK.onPause();
    AppMethodBeat.o(9639);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(9640);
    super.onPostResume();
    this.MXK.onPostResume();
    AppMethodBeat.o(9640);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(9641);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    this.MXK.a(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(9641);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(9637);
    super.onStart();
    this.MXK.onStart();
    AppMethodBeat.o(9637);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(9638);
    this.MXK.onStop();
    super.onStop();
    AppMethodBeat.o(9638);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(9645);
    this.MXK.onTrimMemory(paramInt);
    AppMethodBeat.o(9645);
  }
  
  public void onUserLeaveHint()
  {
    AppMethodBeat.i(9644);
    this.MXK.onUserLeaveHint();
    AppMethodBeat.o(9644);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.app.FlutterFragmentActivity
 * JD-Core Version:    0.7.0.1
 */