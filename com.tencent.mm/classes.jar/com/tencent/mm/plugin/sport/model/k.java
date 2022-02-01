package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.plugin.sport.a.a;
import com.tencent.mm.sdk.platformtools.ai;

public final class k
{
  public static long av(int paramInt, long paramLong)
  {
    AppMethodBeat.i(149332);
    if (ai.cin())
    {
      paramLong = ((PluginSport)g.ad(PluginSport.class)).getSportFileStorage().getLong(paramInt, paramLong);
      AppMethodBeat.o(149332);
      return paramLong;
    }
    paramLong = new j(a.zoE).getLong(paramInt, paramLong);
    AppMethodBeat.o(149332);
    return paramLong;
  }
  
  public static void aw(int paramInt, long paramLong)
  {
    AppMethodBeat.i(149333);
    if (ai.cin())
    {
      ((PluginSport)g.ad(PluginSport.class)).getSportFileStorage().setLong(paramInt, paramLong);
      AppMethodBeat.o(149333);
      return;
    }
    RuntimeException localRuntimeException = new RuntimeException(String.format("not support set value in %s process", new Object[] { ai.getProcessName() }));
    AppMethodBeat.o(149333);
    throw localRuntimeException;
  }
  
  public static void awj(String paramString)
  {
    AppMethodBeat.i(149334);
    if (ai.cin())
    {
      ((PluginSport)g.ad(PluginSport.class)).getSportFileStorage().setString(2, paramString);
      AppMethodBeat.o(149334);
      return;
    }
    paramString = new RuntimeException(String.format("not support set value in %s process", new Object[] { ai.getProcessName() }));
    AppMethodBeat.o(149334);
    throw paramString;
  }
  
  public static void awk(String paramString)
  {
    AppMethodBeat.i(149335);
    if (ai.eVb())
    {
      ((PluginSport)g.ad(PluginSport.class)).getSportFileStorage().setString(301, paramString);
      AppMethodBeat.o(149335);
      return;
    }
    paramString = new RuntimeException(String.format("not support set value in %s process", new Object[] { ai.getProcessName() }));
    AppMethodBeat.o(149335);
    throw paramString;
  }
  
  public static j dUg()
  {
    AppMethodBeat.i(149330);
    j localj;
    if (ai.cin())
    {
      localj = new j(a.zoE);
      AppMethodBeat.o(149330);
      return localj;
    }
    if (ai.eVb())
    {
      localj = new j(a.zoF);
      AppMethodBeat.o(149330);
      return localj;
    }
    AppMethodBeat.o(149330);
    return null;
  }
  
  public static String dUh()
  {
    AppMethodBeat.i(149331);
    if (ai.eVb())
    {
      str = ((PluginSport)g.ad(PluginSport.class)).getSportFileStorage().getString(301, "");
      AppMethodBeat.o(149331);
      return str;
    }
    String str = new j(a.zoF).getString(301, "");
    AppMethodBeat.o(149331);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.k
 * JD-Core Version:    0.7.0.1
 */