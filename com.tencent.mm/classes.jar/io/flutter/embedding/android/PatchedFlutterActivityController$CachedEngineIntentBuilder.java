package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PatchedFlutterActivityController$CachedEngineIntentBuilder
{
  private final Class<? extends Activity> activityClass;
  private String backgroundMode = FlutterActivityLaunchConfigs.DEFAULT_BACKGROUND_MODE;
  private final String cachedEngineId;
  private boolean destroyEngineWithActivity = false;
  
  public PatchedFlutterActivityController$CachedEngineIntentBuilder(Class<? extends Activity> paramClass, String paramString)
  {
    this.activityClass = paramClass;
    this.cachedEngineId = paramString;
  }
  
  public CachedEngineIntentBuilder backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode paramBackgroundMode)
  {
    AppMethodBeat.i(190346);
    this.backgroundMode = paramBackgroundMode.name();
    AppMethodBeat.o(190346);
    return this;
  }
  
  public Intent build(Context paramContext)
  {
    AppMethodBeat.i(190355);
    paramContext = new Intent(paramContext, this.activityClass).putExtra("cached_engine_id", this.cachedEngineId).putExtra("destroy_engine_with_activity", this.destroyEngineWithActivity).putExtra("background_mode", this.backgroundMode);
    AppMethodBeat.o(190355);
    return paramContext;
  }
  
  public CachedEngineIntentBuilder destroyEngineWithActivity(boolean paramBoolean)
  {
    this.destroyEngineWithActivity = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     io.flutter.embedding.android.PatchedFlutterActivityController.CachedEngineIntentBuilder
 * JD-Core Version:    0.7.0.1
 */