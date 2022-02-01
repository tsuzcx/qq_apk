package io.flutter.plugins;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.m;
import java.lang.reflect.Method;

public final class GeneratedPluginRegistrant
{
  private static final String TAG = "MicroMsg.Flutter.GeneratedPluginRegistrant";
  
  private static boolean alreadyRegisteredWith(m paramm)
  {
    AppMethodBeat.i(214853);
    String str = GeneratedPluginRegistrant.class.getCanonicalName();
    if (paramm.bsW(str))
    {
      AppMethodBeat.o(214853);
      return true;
    }
    paramm.bsX(str);
    AppMethodBeat.o(214853);
    return false;
  }
  
  public static void registerWith(io.flutter.embedding.engine.a parama)
  {
    AppMethodBeat.i(214852);
    parama.SNX.a(new com.tencent.liteapp.b());
    parama.SNX.a(new com.tencent.wxa.d());
    parama.SNX.a(new io.flutter.plugins.a.a());
    parama.SNX.a(new j.a.a.a());
    parama.SNX.a(new com.tencent.j.b());
    parama.SNX.a(new com.tencent.mm.flutter.plugins.a.d());
    parama.SNX.a(new com.github.a.a.b());
    try
    {
      Class.forName("com.tencent.mm.plugin.flutter.model.ChannelRegistrant").getMethod("registerWith", new Class[] { io.flutter.embedding.engine.a.class }).invoke(null, new Object[] { parama });
      AppMethodBeat.o(214852);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      try
      {
        Class.forName("com.tencent.mm.plugin.luggage.natives.flutter.channel.ChannelRegistrant").getMethod("registerWith", new Class[] { io.flutter.embedding.engine.a.class }).invoke(null, new Object[] { parama });
        AppMethodBeat.o(214852);
        return;
      }
      catch (Exception parama)
      {
        AppMethodBeat.o(214852);
        return;
      }
    }
    catch (Exception parama)
    {
      AppMethodBeat.o(214852);
    }
  }
  
  public static void registerWith(m paramm)
  {
    AppMethodBeat.i(159080);
    com.tencent.liteapp.b.b.i("MicroMsg.Flutter.GeneratedPluginRegistrant", "registerWith", new Object[0]);
    if (alreadyRegisteredWith(paramm))
    {
      AppMethodBeat.o(159080);
      return;
    }
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.plugins.GeneratedPluginRegistrant
 * JD-Core Version:    0.7.0.1
 */