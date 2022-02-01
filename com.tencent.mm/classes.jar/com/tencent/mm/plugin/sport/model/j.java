package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.plugin.sport.a.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class j
{
  public static long aJ(int paramInt, long paramLong)
  {
    AppMethodBeat.i(149332);
    if (MMApplicationContext.isMainProcess())
    {
      paramLong = ((PluginSport)g.ah(PluginSport.class)).getSportFileStorage().getLong(paramInt, paramLong);
      AppMethodBeat.o(149332);
      return paramLong;
    }
    paramLong = new i(a.FiV).getLong(paramInt, paramLong);
    AppMethodBeat.o(149332);
    return paramLong;
  }
  
  public static void aK(int paramInt, long paramLong)
  {
    AppMethodBeat.i(149333);
    if (MMApplicationContext.isMainProcess())
    {
      ((PluginSport)g.ah(PluginSport.class)).getSportFileStorage().setLong(paramInt, paramLong);
      AppMethodBeat.o(149333);
      return;
    }
    RuntimeException localRuntimeException = new RuntimeException(String.format("not support set value in %s process", new Object[] { MMApplicationContext.getProcessName() }));
    AppMethodBeat.o(149333);
    throw localRuntimeException;
  }
  
  public static void aRE(String paramString)
  {
    AppMethodBeat.i(149334);
    if (MMApplicationContext.isMainProcess())
    {
      ((PluginSport)g.ah(PluginSport.class)).getSportFileStorage().setString(2, paramString);
      AppMethodBeat.o(149334);
      return;
    }
    paramString = new RuntimeException(String.format("not support set value in %s process", new Object[] { MMApplicationContext.getProcessName() }));
    AppMethodBeat.o(149334);
    throw paramString;
  }
  
  public static void aRF(String paramString)
  {
    AppMethodBeat.i(149335);
    if (MMApplicationContext.isPushProcess())
    {
      ((PluginSport)g.ah(PluginSport.class)).getSportFileStorage().setString(301, paramString);
      AppMethodBeat.o(149335);
      return;
    }
    paramString = new RuntimeException(String.format("not support set value in %s process", new Object[] { MMApplicationContext.getProcessName() }));
    AppMethodBeat.o(149335);
    throw paramString;
  }
  
  public static i fmC()
  {
    AppMethodBeat.i(149330);
    i locali;
    if (MMApplicationContext.isMainProcess())
    {
      locali = new i(a.FiV);
      AppMethodBeat.o(149330);
      return locali;
    }
    if (MMApplicationContext.isPushProcess())
    {
      locali = new i(a.FiW);
      AppMethodBeat.o(149330);
      return locali;
    }
    AppMethodBeat.o(149330);
    return null;
  }
  
  public static String fmD()
  {
    AppMethodBeat.i(149331);
    if (MMApplicationContext.isPushProcess())
    {
      str = ((PluginSport)g.ah(PluginSport.class)).getSportFileStorage().getString(301, "");
      AppMethodBeat.o(149331);
      return str;
    }
    String str = new i(a.FiW).getString(301, "");
    AppMethodBeat.o(149331);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.j
 * JD-Core Version:    0.7.0.1
 */