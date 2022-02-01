package io.flutter.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a.a.m;
import io.flutter.a.a.m.c;
import io.flutter.view.FlutterView.b;

public class FlutterFragmentActivity
  extends FragmentActivity
  implements m, a.a, FlutterView.b
{
  private final a IWF;
  private final b IWG;
  private final FlutterView.b IWH;
  private final m IWI;
  
  public FlutterFragmentActivity()
  {
    AppMethodBeat.i(9631);
    this.IWF = new a(this, this);
    this.IWG = this.IWF;
    this.IWH = this.IWF;
    this.IWI = this.IWF;
    AppMethodBeat.o(9631);
  }
  
  public final boolean aPH(String paramString)
  {
    AppMethodBeat.i(9632);
    boolean bool = this.IWI.aPH(paramString);
    AppMethodBeat.o(9632);
    return bool;
  }
  
  public final m.c dB(String paramString)
  {
    AppMethodBeat.i(9633);
    paramString = this.IWI.dB(paramString);
    AppMethodBeat.o(9633);
    return paramString;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(9642);
    if (!this.IWG.onActivityResult(paramInt1, paramInt2, paramIntent)) {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(9642);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(9636);
    if (!this.IWG.onBackPressed()) {
      super.onBackPressed();
    }
    AppMethodBeat.o(9636);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(9647);
    super.onConfigurationChanged(paramConfiguration);
    this.IWG.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(9647);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(9634);
    super.onCreate(paramBundle);
    this.IWG.ftX();
    AppMethodBeat.o(9634);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(9635);
    this.IWG.onDestroy();
    super.onDestroy();
    AppMethodBeat.o(9635);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(9646);
    this.IWG.onLowMemory();
    AppMethodBeat.o(9646);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(9643);
    this.IWG.onNewIntent(paramIntent);
    AppMethodBeat.o(9643);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(9639);
    super.onPause();
    this.IWG.onPause();
    AppMethodBeat.o(9639);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(9640);
    super.onPostResume();
    this.IWG.onPostResume();
    AppMethodBeat.o(9640);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(9641);
    this.IWG.a(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(9641);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(9637);
    super.onStart();
    this.IWG.onStart();
    AppMethodBeat.o(9637);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(9638);
    this.IWG.onStop();
    super.onStop();
    AppMethodBeat.o(9638);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(9645);
    this.IWG.onTrimMemory(paramInt);
    AppMethodBeat.o(9645);
  }
  
  public void onUserLeaveHint()
  {
    AppMethodBeat.i(9644);
    this.IWG.onUserLeaveHint();
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