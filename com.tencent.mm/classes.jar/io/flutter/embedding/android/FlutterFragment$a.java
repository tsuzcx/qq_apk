package io.flutter.embedding.android;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;

public final class FlutterFragment$a
{
  private final String aaoJ;
  boolean aaoK = false;
  boolean aaoL = false;
  private final Class<? extends FlutterFragment> cpi;
  i cpj = i.aapM;
  l cpk = l.aapR;
  boolean cpl = true;
  
  private FlutterFragment$a(Class<? extends FlutterFragment> paramClass, String paramString)
  {
    this.cpi = paramClass;
    this.aaoJ = paramString;
  }
  
  private FlutterFragment$a(String paramString)
  {
    this(FlutterFragment.class, paramString);
  }
  
  public final <T extends FlutterFragment> T iAx()
  {
    AppMethodBeat.i(255282);
    FlutterFragment localFlutterFragment;
    try
    {
      localFlutterFragment = (FlutterFragment)this.cpi.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      if (localFlutterFragment == null)
      {
        RuntimeException localRuntimeException = new RuntimeException("The FlutterFragment subclass sent in the constructor (" + this.cpi.getCanonicalName() + ") does not match the expected return type.");
        AppMethodBeat.o(255282);
        throw localRuntimeException;
      }
    }
    catch (Exception localException)
    {
      localObject = new RuntimeException("Could not instantiate FlutterFragment subclass (" + this.cpi.getName() + ")", localException);
      AppMethodBeat.o(255282);
      throw ((Throwable)localObject);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("cached_engine_id", this.aaoJ);
    localBundle.putBoolean("destroy_engine_with_fragment", this.aaoK);
    localBundle.putBoolean("handle_deeplinking", this.aaoL);
    if (this.cpj != null)
    {
      localObject = this.cpj.name();
      localBundle.putString("flutterview_render_mode", (String)localObject);
      if (this.cpk == null) {
        break label231;
      }
    }
    label231:
    for (Object localObject = this.cpk.name();; localObject = l.aapR.name())
    {
      localBundle.putString("flutterview_transparency_mode", (String)localObject);
      localBundle.putBoolean("should_attach_engine_to_activity", this.cpl);
      localFlutterFragment.setArguments(localBundle);
      AppMethodBeat.o(255282);
      return localFlutterFragment;
      localObject = i.aapM.name();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterFragment.a
 * JD-Core Version:    0.7.0.1
 */