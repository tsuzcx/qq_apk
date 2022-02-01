package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.plugin.sport.a.a;
import com.tencent.mm.sdk.platformtools.ak;

public final class k
{
  public static long aC(int paramInt, long paramLong)
  {
    AppMethodBeat.i(149332);
    if (ak.coh())
    {
      paramLong = ((PluginSport)g.ad(PluginSport.class)).getSportFileStorage().getLong(paramInt, paramLong);
      AppMethodBeat.o(149332);
      return paramLong;
    }
    paramLong = new j(a.AYb).getLong(paramInt, paramLong);
    AppMethodBeat.o(149332);
    return paramLong;
  }
  
  public static void aCI(String paramString)
  {
    AppMethodBeat.i(149334);
    if (ak.coh())
    {
      ((PluginSport)g.ad(PluginSport.class)).getSportFileStorage().setString(2, paramString);
      AppMethodBeat.o(149334);
      return;
    }
    paramString = new RuntimeException(String.format("not support set value in %s process", new Object[] { ak.getProcessName() }));
    AppMethodBeat.o(149334);
    throw paramString;
  }
  
  public static void aCJ(String paramString)
  {
    AppMethodBeat.i(149335);
    if (ak.foA())
    {
      ((PluginSport)g.ad(PluginSport.class)).getSportFileStorage().setString(301, paramString);
      AppMethodBeat.o(149335);
      return;
    }
    paramString = new RuntimeException(String.format("not support set value in %s process", new Object[] { ak.getProcessName() }));
    AppMethodBeat.o(149335);
    throw paramString;
  }
  
  public static void aD(int paramInt, long paramLong)
  {
    AppMethodBeat.i(149333);
    if (ak.coh())
    {
      ((PluginSport)g.ad(PluginSport.class)).getSportFileStorage().setLong(paramInt, paramLong);
      AppMethodBeat.o(149333);
      return;
    }
    RuntimeException localRuntimeException = new RuntimeException(String.format("not support set value in %s process", new Object[] { ak.getProcessName() }));
    AppMethodBeat.o(149333);
    throw localRuntimeException;
  }
  
  public static j ekc()
  {
    AppMethodBeat.i(149330);
    j localj;
    if (ak.coh())
    {
      localj = new j(a.AYb);
      AppMethodBeat.o(149330);
      return localj;
    }
    if (ak.foA())
    {
      localj = new j(a.AYc);
      AppMethodBeat.o(149330);
      return localj;
    }
    AppMethodBeat.o(149330);
    return null;
  }
  
  public static String ekd()
  {
    AppMethodBeat.i(149331);
    if (ak.foA())
    {
      str = ((PluginSport)g.ad(PluginSport.class)).getSportFileStorage().getString(301, "");
      AppMethodBeat.o(149331);
      return str;
    }
    String str = new j(a.AYc).getString(301, "");
    AppMethodBeat.o(149331);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.k
 * JD-Core Version:    0.7.0.1
 */