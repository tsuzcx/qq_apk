package io.flutter.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import io.flutter.plugin.a.m;
import io.flutter.plugin.a.m.c;
import io.flutter.view.FlutterView.b;

public class FlutterActivity
  extends HellActivity
  implements a.a, m, FlutterView.b
{
  private final a MAC;
  private final b MAD;
  private final FlutterView.b MAE;
  private final m MAF;
  
  public FlutterActivity()
  {
    AppMethodBeat.i(9605);
    this.MAC = new a(this, this);
    this.MAD = this.MAC;
    this.MAE = this.MAC;
    this.MAF = this.MAC;
    AppMethodBeat.o(9605);
  }
  
  public final boolean bbH(String paramString)
  {
    AppMethodBeat.i(9606);
    boolean bool = this.MAF.bbH(paramString);
    AppMethodBeat.o(9606);
    return bool;
  }
  
  public final m.c em(String paramString)
  {
    AppMethodBeat.i(9607);
    paramString = this.MAF.em(paramString);
    AppMethodBeat.o(9607);
    return paramString;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(9617);
    if (!this.MAD.onActivityResult(paramInt1, paramInt2, paramIntent)) {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(9617);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(9612);
    if (!this.MAD.onBackPressed()) {
      super.onBackPressed();
    }
    AppMethodBeat.o(9612);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(9622);
    super.onConfigurationChanged(paramConfiguration);
    this.MAD.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(9622);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(9608);
    super.onCreate(paramBundle);
    this.MAD.geg();
    AppMethodBeat.o(9608);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(9611);
    this.MAD.onDestroy();
    super.onDestroy();
    AppMethodBeat.o(9611);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(9621);
    this.MAD.onLowMemory();
    AppMethodBeat.o(9621);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(9618);
    this.MAD.onNewIntent(paramIntent);
    AppMethodBeat.o(9618);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(9614);
    super.onPause();
    this.MAD.onPause();
    AppMethodBeat.o(9614);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(9615);
    super.onPostResume();
    this.MAD.onPostResume();
    AppMethodBeat.o(9615);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(9616);
    this.MAD.a(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(9616);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(9610);
    super.onResume();
    this.MAD.onResume();
    AppMethodBeat.o(9610);
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(9609);
    super.onStart();
    this.MAD.onStart();
    AppMethodBeat.o(9609);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(9613);
    this.MAD.onStop();
    super.onStop();
    AppMethodBeat.o(9613);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(9620);
    this.MAD.onTrimMemory(paramInt);
    AppMethodBeat.o(9620);
  }
  
  public void onUserLeaveHint()
  {
    AppMethodBeat.i(9619);
    this.MAD.onUserLeaveHint();
    AppMethodBeat.o(9619);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.app.FlutterActivity
 * JD-Core Version:    0.7.0.1
 */