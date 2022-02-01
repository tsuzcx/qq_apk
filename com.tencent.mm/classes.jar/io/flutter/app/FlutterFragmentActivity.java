package io.flutter.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;
import io.flutter.view.FlutterView.Provider;

@Deprecated
public class FlutterFragmentActivity
  extends FragmentActivity
  implements FlutterActivityDelegate.ViewFactory, PluginRegistry, FlutterView.Provider
{
  private final FlutterActivityDelegate delegate;
  private final FlutterActivityEvents eventDelegate;
  private final PluginRegistry pluginRegistry;
  private final FlutterView.Provider viewProvider;
  
  public FlutterFragmentActivity()
  {
    AppMethodBeat.i(9631);
    this.delegate = new FlutterActivityDelegate(this, this);
    this.eventDelegate = this.delegate;
    this.viewProvider = this.delegate;
    this.pluginRegistry = this.delegate;
    AppMethodBeat.o(9631);
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
    AppMethodBeat.i(189571);
    FlutterView localFlutterView = this.viewProvider.getFlutterView();
    AppMethodBeat.o(189571);
    return localFlutterView;
  }
  
  public final boolean hasPlugin(String paramString)
  {
    AppMethodBeat.i(9632);
    boolean bool = this.pluginRegistry.hasPlugin(paramString);
    AppMethodBeat.o(9632);
    return bool;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(9642);
    if (!this.eventDelegate.onActivityResult(paramInt1, paramInt2, paramIntent)) {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(9642);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(9636);
    if (!this.eventDelegate.onBackPressed()) {
      super.onBackPressed();
    }
    AppMethodBeat.o(9636);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(9647);
    super.onConfigurationChanged(paramConfiguration);
    this.eventDelegate.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(9647);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(9634);
    super.onCreate(paramBundle);
    this.eventDelegate.onCreate(paramBundle);
    AppMethodBeat.o(9634);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(9635);
    this.eventDelegate.onDestroy();
    super.onDestroy();
    AppMethodBeat.o(9635);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(9646);
    this.eventDelegate.onLowMemory();
    AppMethodBeat.o(9646);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(9643);
    super.onNewIntent(paramIntent);
    this.eventDelegate.onNewIntent(paramIntent);
    AppMethodBeat.o(9643);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(9639);
    super.onPause();
    this.eventDelegate.onPause();
    AppMethodBeat.o(9639);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(9640);
    super.onPostResume();
    this.eventDelegate.onPostResume();
    AppMethodBeat.o(9640);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(9641);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    this.eventDelegate.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(9641);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(9637);
    super.onStart();
    this.eventDelegate.onStart();
    AppMethodBeat.o(9637);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(9638);
    this.eventDelegate.onStop();
    super.onStop();
    AppMethodBeat.o(9638);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(9645);
    this.eventDelegate.onTrimMemory(paramInt);
    AppMethodBeat.o(9645);
  }
  
  public void onUserLeaveHint()
  {
    AppMethodBeat.i(9644);
    this.eventDelegate.onUserLeaveHint();
    AppMethodBeat.o(9644);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final PluginRegistry.Registrar registrarFor(String paramString)
  {
    AppMethodBeat.i(9633);
    paramString = this.pluginRegistry.registrarFor(paramString);
    AppMethodBeat.o(9633);
    return paramString;
  }
  
  public boolean retainFlutterNativeView()
  {
    return false;
  }
  
  public final <T> T valuePublishedByPlugin(String paramString)
  {
    AppMethodBeat.i(189599);
    paramString = this.pluginRegistry.valuePublishedByPlugin(paramString);
    AppMethodBeat.o(189599);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.app.FlutterFragmentActivity
 * JD-Core Version:    0.7.0.1
 */