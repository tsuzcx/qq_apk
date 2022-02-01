package io.flutter.facade;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.b;
import io.flutter.plugin.a.p;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;

final class a$1
  extends FlutterView
{
  private final b<String> NcL;
  
  a$1(Context paramContext, FlutterNativeView paramFlutterNativeView)
  {
    super(paramContext, null, paramFlutterNativeView);
    AppMethodBeat.i(159068);
    this.NcL = new b(this, "flutter/lifecycle", p.Ndi);
    AppMethodBeat.o(159068);
  }
  
  public final void onFirstFrame()
  {
    AppMethodBeat.i(159069);
    super.onFirstFrame();
    setAlpha(1.0F);
    AppMethodBeat.o(159069);
  }
  
  public final void onPostResume()
  {
    AppMethodBeat.i(159070);
    this.NcL.eI("AppLifecycleState.resumed");
    AppMethodBeat.o(159070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.facade.a.1
 * JD-Core Version:    0.7.0.1
 */