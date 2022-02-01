package io.flutter.app;

import android.app.Activity;
import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.loader.FlutterLoader;

public class FlutterApplication
  extends Application
{
  private Activity mCurrentActivity = null;
  
  public Activity getCurrentActivity()
  {
    return this.mCurrentActivity;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(9604);
    super.onCreate();
    FlutterInjector.instance().flutterLoader().startInitialization(this);
    AppMethodBeat.o(9604);
  }
  
  public void setCurrentActivity(Activity paramActivity)
  {
    this.mCurrentActivity = paramActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.app.FlutterApplication
 * JD-Core Version:    0.7.0.1
 */