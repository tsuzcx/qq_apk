package io.flutter.embedding.engine.plugins.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.b;
import java.lang.reflect.Method;

public final class a
{
  public static void h(io.flutter.embedding.engine.a parama)
  {
    AppMethodBeat.i(255294);
    try
    {
      Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", new Class[] { io.flutter.embedding.engine.a.class }).invoke(null, new Object[] { parama });
      AppMethodBeat.o(255294);
      return;
    }
    catch (Exception localException)
    {
      new StringBuilder("Tried to automatically register plugins with FlutterEngine (").append(parama).append(") but could not find and invoke the GeneratedPluginRegistrant.");
      b.iAf();
      AppMethodBeat.o(255294);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.e.a
 * JD-Core Version:    0.7.0.1
 */