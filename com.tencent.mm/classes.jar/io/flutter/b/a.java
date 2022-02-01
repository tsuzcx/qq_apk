package io.flutter.b;

import com.e.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a.a.k;
import io.flutter.a.a.m;
import io.flutter.a.a.m.c;
import java.lang.reflect.Method;

public final class a
{
  public static void registerWith(m paramm)
  {
    int i = 1;
    AppMethodBeat.i(159080);
    if (com.tencent.mm.ah.a.gmB == null) {}
    try
    {
      com.tencent.mm.ah.a.gmB = Class.forName("com.tencent.mm.sdk.platformtools.ad").getMethod("i", new Class[] { String.class, String.class, [Ljava.lang.Object.class });
      try
      {
        label45:
        com.tencent.mm.ah.a.gmB.invoke(null, new Object[] { "MicroMsg.Flutter.GeneratedPluginRegistrant", "registerWith", new Object[0] });
        label74:
        Object localObject = a.class.getCanonicalName();
        if (paramm.aPH((String)localObject)) {}
        while (i != 0)
        {
          AppMethodBeat.o(159080);
          return;
          paramm.dB((String)localObject);
          i = 0;
        }
        localObject = paramm.dB("io.flutter.plugins.pathprovider.PathProviderPlugin");
        new k(((m.c)localObject).IJ(), "plugins.flutter.io/path_provider").a(new io.flutter.b.a.a((m.c)localObject));
        new k(paramm.dB("com.jhomlala.catcher.CatcherPlugin").IJ(), "catcher").a(new com.b.a.a());
        c.a(paramm.dB("com.tekartik.sqflite.SqflitePlugin"));
        localObject = paramm.dB("flutter.plugins.screen.screen");
        new k(((m.c)localObject).IJ(), "com.tencent.mm.flutter/screen").a(new b.a.a.a.a((m.c)localObject));
        try
        {
          Class.forName("com.tencent.mm.plugin.flutter.model.ChannelRegistrant").getMethod("registerWith", new Class[] { m.class }).invoke(null, new Object[] { paramm });
          AppMethodBeat.o(159080);
          return;
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          try
          {
            Class.forName("com.tencent.mm.plugin.luggage.natives.flutter.channel.ChannelRegistrant").getMethod("registerWith", new Class[] { m.class }).invoke(null, new Object[] { paramm });
            AppMethodBeat.o(159080);
            return;
          }
          catch (Exception paramm)
          {
            AppMethodBeat.o(159080);
            return;
          }
        }
        catch (Exception paramm)
        {
          AppMethodBeat.o(159080);
          return;
        }
      }
      catch (Exception localException1)
      {
        break label74;
      }
    }
    catch (Exception localException2)
    {
      break label45;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.b.a
 * JD-Core Version:    0.7.0.1
 */