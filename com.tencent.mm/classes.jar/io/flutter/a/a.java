package io.flutter.a;

import com.github.a.a.a.2;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wax.e;
import io.flutter.plugin.a.d;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.m;
import io.flutter.plugin.a.m.c;
import java.lang.reflect.Method;

public final class a
{
  public static void registerWith(m paramm)
  {
    int i = 1;
    AppMethodBeat.i(159080);
    if (com.tencent.mm.ah.a.hhl == null) {}
    try
    {
      com.tencent.mm.ah.a.hhl = Class.forName("com.tencent.mm.sdk.platformtools.ad").getMethod("i", new Class[] { String.class, String.class, [Ljava.lang.Object.class });
      try
      {
        label45:
        com.tencent.mm.ah.a.hhl.invoke(null, new Object[] { "MicroMsg.Flutter.GeneratedPluginRegistrant", "registerWith", new Object[0] });
        label74:
        Object localObject1 = a.class.getCanonicalName();
        if (paramm.bbH((String)localObject1)) {}
        while (i != 0)
        {
          AppMethodBeat.o(159080);
          return;
          paramm.em((String)localObject1);
          i = 0;
        }
        localObject1 = paramm.em("io.flutter.plugins.pathprovider.PathProviderPlugin");
        Object localObject2 = new io.flutter.a.a.a();
        ((io.flutter.a.a.a)localObject2).vCn = new k(((m.c)localObject1).JS(), "plugins.flutter.io/path_provider");
        ((io.flutter.a.a.a)localObject2).context = ((m.c)localObject1).JR();
        ((io.flutter.a.a.a)localObject2).vCn.a((k.c)localObject2);
        new k(paramm.em("com.jhomlala.catcher.CatcherPlugin").JS(), "catcher").a(new com.c.a.a());
        localObject1 = paramm.em("flutter.plugins.screen.screen.ScreenPlugin");
        new k(((m.c)localObject1).JS(), "com.tencent.mm.flutter/screen").a(new b.a.a.a.a((m.c)localObject1));
        e.a(paramm.em("com.tencent.wax.WxaRouterPlugin"));
        localObject1 = paramm.em("com.github.sososdk.orientation.OrientationPlugin");
        localObject2 = new com.github.a.a.a((m.c)localObject1);
        new k(((m.c)localObject1).JS(), "sososdk.github.com/orientation").a((k.c)localObject2);
        new d(((m.c)localObject1).JS(), "sososdk.github.com/orientationEvent").a(new a.2((com.github.a.a.a)localObject2));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.a.a
 * JD-Core Version:    0.7.0.1
 */