package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.plugin.sport.a.a;
import com.tencent.mm.sdk.platformtools.aj;

public final class k
{
  public static void ara(String paramString)
  {
    AppMethodBeat.i(149334);
    if (aj.cbe())
    {
      ((PluginSport)g.ad(PluginSport.class)).getSportFileStorage().setString(2, paramString);
      AppMethodBeat.o(149334);
      return;
    }
    paramString = new RuntimeException(String.format("not support set value in %s process", new Object[] { aj.getProcessName() }));
    AppMethodBeat.o(149334);
    throw paramString;
  }
  
  public static void arb(String paramString)
  {
    AppMethodBeat.i(149335);
    if (aj.eFH())
    {
      ((PluginSport)g.ad(PluginSport.class)).getSportFileStorage().setString(301, paramString);
      AppMethodBeat.o(149335);
      return;
    }
    paramString = new RuntimeException(String.format("not support set value in %s process", new Object[] { aj.getProcessName() }));
    AppMethodBeat.o(149335);
    throw paramString;
  }
  
  public static long aw(int paramInt, long paramLong)
  {
    AppMethodBeat.i(149332);
    if (aj.cbe())
    {
      paramLong = ((PluginSport)g.ad(PluginSport.class)).getSportFileStorage().getLong(paramInt, paramLong);
      AppMethodBeat.o(149332);
      return paramLong;
    }
    paramLong = new j(a.ybE).getLong(paramInt, paramLong);
    AppMethodBeat.o(149332);
    return paramLong;
  }
  
  public static void ax(int paramInt, long paramLong)
  {
    AppMethodBeat.i(149333);
    if (aj.cbe())
    {
      ((PluginSport)g.ad(PluginSport.class)).getSportFileStorage().setLong(paramInt, paramLong);
      AppMethodBeat.o(149333);
      return;
    }
    RuntimeException localRuntimeException = new RuntimeException(String.format("not support set value in %s process", new Object[] { aj.getProcessName() }));
    AppMethodBeat.o(149333);
    throw localRuntimeException;
  }
  
  public static j dFF()
  {
    AppMethodBeat.i(149330);
    j localj;
    if (aj.cbe())
    {
      localj = new j(a.ybE);
      AppMethodBeat.o(149330);
      return localj;
    }
    if (aj.eFH())
    {
      localj = new j(a.ybF);
      AppMethodBeat.o(149330);
      return localj;
    }
    AppMethodBeat.o(149330);
    return null;
  }
  
  public static String dFG()
  {
    AppMethodBeat.i(149331);
    if (aj.eFH())
    {
      str = ((PluginSport)g.ad(PluginSport.class)).getSportFileStorage().getString(301, "");
      AppMethodBeat.o(149331);
      return str;
    }
    String str = new j(a.ybF).getString(301, "");
    AppMethodBeat.o(149331);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.k
 * JD-Core Version:    0.7.0.1
 */