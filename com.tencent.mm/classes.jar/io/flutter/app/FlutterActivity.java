package io.flutter.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;
import io.flutter.view.FlutterView.Provider;

@Deprecated
public class FlutterActivity
  extends HellActivity
  implements FlutterActivityDelegate.ViewFactory, PluginRegistry, FlutterView.Provider
{
  private static final String TAG = "FlutterActivity";
  private final FlutterActivityDelegate delegate;
  private final FlutterActivityEvents eventDelegate;
  private final PluginRegistry pluginRegistry;
  private final FlutterView.Provider viewProvider;
  
  public FlutterActivity()
  {
    AppMethodBeat.i(9605);
    this.delegate = new FlutterActivityDelegate(this, this);
    this.eventDelegate = this.delegate;
    this.viewProvider = this.delegate;
    this.pluginRegistry = this.delegate;
    AppMethodBeat.o(9605);
  }
  
  public FlutterNativeView createFlutterNativeView()
  {
    return null;
  }
  
  public FlutterView createFlutterView(Context paramContext)
  {
    return null;
  }
  
  public FlutterView getFlutterView()
  {
    AppMethodBeat.i(189580);
    FlutterView localFlutterView = this.viewProvider.getFlutterView();
    AppMethodBeat.o(189580);
    return localFlutterView;
  }
  
  public final boolean hasPlugin(String paramString)
  {
    AppMethodBeat.i(9606);
    boolean bool = this.pluginRegistry.hasPlugin(paramString);
    AppMethodBeat.o(9606);
    return bool;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(9617);
    if (!this.eventDelegate.onActivityResult(paramInt1, paramInt2, paramIntent)) {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(9617);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(9612);
    if (!this.eventDelegate.onBackPressed()) {
      super.onBackPressed();
    }
    AppMethodBeat.o(9612);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(9622);
    super.onConfigurationChanged(paramConfiguration);
    this.eventDelegate.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(9622);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(9608);
    super.onCreate(paramBundle);
    this.eventDelegate.onCreate(paramBundle);
    AppMethodBeat.o(9608);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(9611);
    this.eventDelegate.onDestroy();
    super.onDestroy();
    AppMethodBeat.o(9611);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(9621);
    this.eventDelegate.onLowMemory();
    AppMethodBeat.o(9621);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(9618);
    this.eventDelegate.onNewIntent(paramIntent);
    AppMethodBeat.o(9618);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(9614);
    super.onPause();
    this.eventDelegate.onPause();
    AppMethodBeat.o(9614);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(9615);
    super.onPostResume();
    this.eventDelegate.onPostResume();
    AppMethodBeat.o(9615);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(9616);
    this.eventDelegate.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(9616);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(9610);
    super.onResume();
    this.eventDelegate.onResume();
    AppMethodBeat.o(9610);
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(9609);
    super.onStart();
    this.eventDelegate.onStart();
    AppMethodBeat.o(9609);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(9613);
    this.eventDelegate.onStop();
    super.onStop();
    AppMethodBeat.o(9613);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(9620);
    this.eventDelegate.onTrimMemory(paramInt);
    AppMethodBeat.o(9620);
  }
  
  public void onUserLeaveHint()
  {
    AppMethodBeat.i(9619);
    this.eventDelegate.onUserLeaveHint();
    AppMethodBeat.o(9619);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final PluginRegistry.Registrar registrarFor(String paramString)
  {
    AppMethodBeat.i(9607);
    paramString = this.pluginRegistry.registrarFor(paramString);
    AppMethodBeat.o(9607);
    return paramString;
  }
  
  public boolean retainFlutterNativeView()
  {
    return false;
  }
  
  public final <T> T valuePublishedByPlugin(String paramString)
  {
    AppMethodBeat.i(189616);
    paramString = this.pluginRegistry.valuePublishedByPlugin(paramString);
    AppMethodBeat.o(189616);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.app.FlutterActivity
 * JD-Core Version:    0.7.0.1
 */