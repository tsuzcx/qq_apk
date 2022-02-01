package io.flutter.facade;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a.a;
import io.flutter.embedding.engine.c.c;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterView;
import io.flutter.view.b;

final class Flutter$2
  implements LifecycleObserver
{
  Flutter$2(Activity paramActivity, FlutterView paramFlutterView) {}
  
  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  public final void onCreate()
  {
    AppMethodBeat.i(159071);
    b localb = new b();
    localb.Ngy = FlutterMain.findAppBundlePath(this.val$activity.getApplicationContext());
    localb.Ngz = "main";
    this.NcM.a(localb);
    a.registerWith(this.NcM.getPluginRegistry());
    AppMethodBeat.o(159071);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public final void onDestroy()
  {
    AppMethodBeat.i(159076);
    this.NcM.destroy();
    AppMethodBeat.o(159076);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public final void onPause()
  {
    AppMethodBeat.i(159074);
    this.NcM.MZp.gjA();
    AppMethodBeat.o(159074);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public final void onResume()
  {
    AppMethodBeat.i(159073);
    this.NcM.onPostResume();
    AppMethodBeat.o(159073);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_START)
  public final void onStart()
  {
    AppMethodBeat.i(159072);
    this.NcM.MZp.gjA();
    AppMethodBeat.o(159072);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
  public final void onStop()
  {
    AppMethodBeat.i(159075);
    this.NcM.MZp.gjC();
    AppMethodBeat.o(159075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.facade.Flutter.2
 * JD-Core Version:    0.7.0.1
 */