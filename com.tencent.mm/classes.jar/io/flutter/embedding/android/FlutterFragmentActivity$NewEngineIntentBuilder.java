package io.flutter.embedding.android;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FlutterFragmentActivity$NewEngineIntentBuilder
{
  private final Class<? extends FlutterFragmentActivity> activityClass;
  private String backgroundMode = FlutterActivityLaunchConfigs.DEFAULT_BACKGROUND_MODE;
  private String initialRoute = "/";
  
  public FlutterFragmentActivity$NewEngineIntentBuilder(Class<? extends FlutterFragmentActivity> paramClass)
  {
    this.activityClass = paramClass;
  }
  
  public NewEngineIntentBuilder backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode paramBackgroundMode)
  {
    AppMethodBeat.i(190496);
    this.backgroundMode = paramBackgroundMode.name();
    AppMethodBeat.o(190496);
    return this;
  }
  
  public Intent build(Context paramContext)
  {
    AppMethodBeat.i(190506);
    paramContext = new Intent(paramContext, this.activityClass).putExtra("route", this.initialRoute).putExtra("background_mode", this.backgroundMode).putExtra("destroy_engine_with_activity", true);
    AppMethodBeat.o(190506);
    return paramContext;
  }
  
  public NewEngineIntentBuilder initialRoute(String paramString)
  {
    this.initialRoute = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterFragmentActivity.NewEngineIntentBuilder
 * JD-Core Version:    0.7.0.1
 */