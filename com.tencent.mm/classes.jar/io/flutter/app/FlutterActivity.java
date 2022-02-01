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
  private final a SLU;
  private final b SLV;
  private final FlutterView.b SLW;
  private final m wJn;
  
  public FlutterActivity()
  {
    AppMethodBeat.i(9605);
    this.SLU = new a(this, this);
    this.SLV = this.SLU;
    this.SLW = this.SLU;
    this.wJn = this.SLU;
    AppMethodBeat.o(9605);
  }
  
  public final boolean bsW(String paramString)
  {
    AppMethodBeat.i(9606);
    boolean bool = this.wJn.bsW(paramString);
    AppMethodBeat.o(9606);
    return bool;
  }
  
  public final m.c bsX(String paramString)
  {
    AppMethodBeat.i(9607);
    paramString = this.wJn.bsX(paramString);
    AppMethodBeat.o(9607);
    return paramString;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(9617);
    if (!this.SLV.onActivityResult(paramInt1, paramInt2, paramIntent)) {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(9617);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(9612);
    if (!this.SLV.onBackPressed()) {
      super.onBackPressed();
    }
    AppMethodBeat.o(9612);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(9622);
    super.onConfigurationChanged(paramConfiguration);
    this.SLV.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(9622);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(9608);
    super.onCreate(paramBundle);
    this.SLV.hwi();
    AppMethodBeat.o(9608);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(9611);
    this.SLV.onDestroy();
    super.onDestroy();
    AppMethodBeat.o(9611);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(9621);
    this.SLV.onLowMemory();
    AppMethodBeat.o(9621);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(9618);
    this.SLV.onNewIntent(paramIntent);
    AppMethodBeat.o(9618);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(9614);
    super.onPause();
    this.SLV.onPause();
    AppMethodBeat.o(9614);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(9615);
    super.onPostResume();
    this.SLV.onPostResume();
    AppMethodBeat.o(9615);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(9616);
    this.SLV.a(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(9616);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(9610);
    super.onResume();
    this.SLV.onResume();
    AppMethodBeat.o(9610);
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(9609);
    super.onStart();
    this.SLV.onStart();
    AppMethodBeat.o(9609);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(9613);
    this.SLV.onStop();
    super.onStop();
    AppMethodBeat.o(9613);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(9620);
    this.SLV.onTrimMemory(paramInt);
    AppMethodBeat.o(9620);
  }
  
  public void onUserLeaveHint()
  {
    AppMethodBeat.i(9619);
    this.SLV.onUserLeaveHint();
    AppMethodBeat.o(9619);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.app.FlutterActivity
 * JD-Core Version:    0.7.0.1
 */