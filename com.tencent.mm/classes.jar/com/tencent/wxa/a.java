package com.tencent.wxa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import java.util.HashSet;
import java.util.Iterator;

final class a
{
  public static void a(FlutterEngine paramFlutterEngine, HashSet<FlutterPlugin> paramHashSet)
  {
    AppMethodBeat.i(210486);
    if (paramHashSet != null)
    {
      paramHashSet = paramHashSet.iterator();
      while (paramHashSet.hasNext())
      {
        FlutterPlugin localFlutterPlugin = (FlutterPlugin)paramHashSet.next();
        if (paramFlutterEngine.getPlugins().has(localFlutterPlugin.getClass())) {
          paramFlutterEngine.getPlugins().remove(localFlutterPlugin.getClass());
        }
        paramFlutterEngine.getPlugins().add(localFlutterPlugin);
      }
    }
    AppMethodBeat.o(210486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.wxa.a
 * JD-Core Version:    0.7.0.1
 */