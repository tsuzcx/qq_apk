package io.flutter.embedding.android;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FlutterActivityLaunchConfigs
{
  static final String DART_ENTRYPOINT_META_DATA_KEY = "io.flutter.Entrypoint";
  static final String DEFAULT_BACKGROUND_MODE;
  static final String DEFAULT_DART_ENTRYPOINT = "main";
  static final String DEFAULT_INITIAL_ROUTE = "/";
  static final String EXTRA_BACKGROUND_MODE = "background_mode";
  static final String EXTRA_CACHED_ENGINE_ID = "cached_engine_id";
  static final String EXTRA_DESTROY_ENGINE_WITH_ACTIVITY = "destroy_engine_with_activity";
  static final String EXTRA_ENABLE_STATE_RESTORATION = "enable_state_restoration";
  static final String EXTRA_INITIAL_ROUTE = "route";
  static final String HANDLE_DEEPLINKING_META_DATA_KEY = "flutter_deeplinking_enabled";
  static final String INITIAL_ROUTE_META_DATA_KEY = "io.flutter.InitialRoute";
  static final String NORMAL_THEME_META_DATA_KEY = "io.flutter.embedding.android.NormalTheme";
  static final String SPLASH_SCREEN_META_DATA_KEY = "io.flutter.embedding.android.SplashScreenDrawable";
  
  static
  {
    AppMethodBeat.i(190473);
    DEFAULT_BACKGROUND_MODE = BackgroundMode.opaque.name();
    AppMethodBeat.o(190473);
  }
  
  public static enum BackgroundMode
  {
    static
    {
      AppMethodBeat.i(190377);
      opaque = new BackgroundMode("opaque", 0);
      transparent = new BackgroundMode("transparent", 1);
      $VALUES = new BackgroundMode[] { opaque, transparent };
      AppMethodBeat.o(190377);
    }
    
    private BackgroundMode() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterActivityLaunchConfigs
 * JD-Core Version:    0.7.0.1
 */