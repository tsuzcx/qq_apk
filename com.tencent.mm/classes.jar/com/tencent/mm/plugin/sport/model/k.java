package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.plugin.sport.a.a;
import com.tencent.mm.sdk.platformtools.ah;

public final class k
{
  public static void acx(String paramString)
  {
    AppMethodBeat.i(93692);
    if (ah.brt())
    {
      ((PluginSport)g.G(PluginSport.class)).getSportFileStorage().setString(2, paramString);
      AppMethodBeat.o(93692);
      return;
    }
    paramString = new RuntimeException(String.format("not support set value in %s process", new Object[] { ah.getProcessName() }));
    AppMethodBeat.o(93692);
    throw paramString;
  }
  
  public static void acy(String paramString)
  {
    AppMethodBeat.i(93693);
    if (ah.dsU())
    {
      ((PluginSport)g.G(PluginSport.class)).getSportFileStorage().setString(301, paramString);
      AppMethodBeat.o(93693);
      return;
    }
    paramString = new RuntimeException(String.format("not support set value in %s process", new Object[] { ah.getProcessName() }));
    AppMethodBeat.o(93693);
    throw paramString;
  }
  
  public static long ae(int paramInt, long paramLong)
  {
    AppMethodBeat.i(93690);
    if (ah.brt())
    {
      paramLong = ((PluginSport)g.G(PluginSport.class)).getSportFileStorage().getLong(paramInt, paramLong);
      AppMethodBeat.o(93690);
      return paramLong;
    }
    paramLong = new j(a.spj).getLong(paramInt, paramLong);
    AppMethodBeat.o(93690);
    return paramLong;
  }
  
  public static void af(int paramInt, long paramLong)
  {
    AppMethodBeat.i(93691);
    if (ah.brt())
    {
      ((PluginSport)g.G(PluginSport.class)).getSportFileStorage().setLong(paramInt, paramLong);
      AppMethodBeat.o(93691);
      return;
    }
    RuntimeException localRuntimeException = new RuntimeException(String.format("not support set value in %s process", new Object[] { ah.getProcessName() }));
    AppMethodBeat.o(93691);
    throw localRuntimeException;
  }
  
  public static j cyT()
  {
    AppMethodBeat.i(93688);
    j localj;
    if (ah.brt())
    {
      localj = new j(a.spj);
      AppMethodBeat.o(93688);
      return localj;
    }
    if (ah.dsU())
    {
      localj = new j(a.spk);
      AppMethodBeat.o(93688);
      return localj;
    }
    AppMethodBeat.o(93688);
    return null;
  }
  
  public static String cyU()
  {
    AppMethodBeat.i(93689);
    if (ah.dsU())
    {
      str = ((PluginSport)g.G(PluginSport.class)).getSportFileStorage().getString(301, "");
      AppMethodBeat.o(93689);
      return str;
    }
    String str = new j(a.spk).getString(301, "");
    AppMethodBeat.o(93689);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.k
 * JD-Core Version:    0.7.0.1
 */