package io.flutter.embedding.android;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.d;
import java.lang.reflect.Constructor;

public final class FlutterFragment$b
{
  String ZYN = "main";
  String ZYO = "/";
  boolean aaoL = false;
  String aaoM = null;
  d aaoN = null;
  private final Class<? extends FlutterFragment> cpi = FlutterFragment.class;
  i cpj = i.aapM;
  l cpk = l.aapR;
  boolean cpl = true;
  
  public final <T extends FlutterFragment> T iAx()
  {
    AppMethodBeat.i(255056);
    FlutterFragment localFlutterFragment;
    try
    {
      localFlutterFragment = (FlutterFragment)this.cpi.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      if (localFlutterFragment == null)
      {
        RuntimeException localRuntimeException = new RuntimeException("The FlutterFragment subclass sent in the constructor (" + this.cpi.getCanonicalName() + ") does not match the expected return type.");
        AppMethodBeat.o(255056);
        throw localRuntimeException;
      }
    }
    catch (Exception localException)
    {
      localObject = new RuntimeException("Could not instantiate FlutterFragment subclass (" + this.cpi.getName() + ")", localException);
      AppMethodBeat.o(255056);
      throw ((Throwable)localObject);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("initial_route", this.ZYO);
    localBundle.putBoolean("handle_deeplinking", this.aaoL);
    localBundle.putString("app_bundle_path", this.aaoM);
    localBundle.putString("dart_entrypoint", this.ZYN);
    if (this.aaoN != null) {
      localBundle.putStringArray("initialization_args", this.aaoN.toArray());
    }
    if (this.cpj != null)
    {
      localObject = this.cpj.name();
      localBundle.putString("flutterview_render_mode", (String)localObject);
      if (this.cpk == null) {
        break label268;
      }
    }
    label268:
    for (Object localObject = this.cpk.name();; localObject = l.aapR.name())
    {
      localBundle.putString("flutterview_transparency_mode", (String)localObject);
      localBundle.putBoolean("should_attach_engine_to_activity", this.cpl);
      localBundle.putBoolean("destroy_engine_with_fragment", true);
      localFlutterFragment.setArguments(localBundle);
      AppMethodBeat.o(255056);
      return localFlutterFragment;
      localObject = i.aapM.name();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterFragment.b
 * JD-Core Version:    0.7.0.1
 */