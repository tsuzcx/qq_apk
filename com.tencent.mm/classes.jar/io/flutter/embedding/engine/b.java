package io.flutter.embedding.engine;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.Lifecycle.State;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
  extends LifecycleRegistry
{
  private Lifecycle IYt;
  private final LifecycleObserver IYu;
  private boolean aJO;
  
  b(LifecycleOwner paramLifecycleOwner)
  {
    super(paramLifecycleOwner);
    AppMethodBeat.i(10121);
    this.aJO = false;
    this.IYu = new FlutterEngineAndroidLifecycle.1(this);
    AppMethodBeat.o(10121);
  }
  
  private void fuD()
  {
    AppMethodBeat.i(10125);
    if (this.aJO)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Tried to invoke a method on a destroyed FlutterEngineAndroidLifecycle.");
      AppMethodBeat.o(10125);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(10125);
  }
  
  public final void a(Lifecycle paramLifecycle)
  {
    AppMethodBeat.i(10122);
    fuD();
    if (this.IYt != null) {
      this.IYt.removeObserver(this.IYu);
    }
    handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    this.IYt = paramLifecycle;
    if (this.IYt != null) {
      paramLifecycle.addObserver(this.IYu);
    }
    AppMethodBeat.o(10122);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(10124);
    fuD();
    a(null);
    markState(Lifecycle.State.DESTROYED);
    this.aJO = true;
    AppMethodBeat.o(10124);
  }
  
  public final void handleLifecycleEvent(Lifecycle.Event paramEvent)
  {
    AppMethodBeat.i(10123);
    fuD();
    super.handleLifecycleEvent(paramEvent);
    AppMethodBeat.o(10123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.b
 * JD-Core Version:    0.7.0.1
 */