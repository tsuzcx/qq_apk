package com.tencent.mm.plugin.performance.watchdogs;

import com.tencent.matrix.report.n.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.xweb.ao;
import java.util.HashMap;
import java.util.Map;

public final class h
{
  private static final a MPf;
  private static final b MPg;
  private static boolean sInstalled;
  
  static
  {
    AppMethodBeat.i(301038);
    MPf = new a((byte)0);
    sInstalled = false;
    MPg = new b((byte)0);
    AppMethodBeat.o(301038);
  }
  
  public static void install()
  {
    AppMethodBeat.i(301032);
    if (sInstalled)
    {
      AppMethodBeat.o(301032);
      return;
    }
    if ((MMApplicationContext.isToolsMpProcess()) || (MMApplicationContext.isToolsProcess()))
    {
      d.gzs().MOg = MPf;
      com.tencent.matrix.report.n.eYW = MPg;
      sInstalled = true;
    }
    AppMethodBeat.o(301032);
  }
  
  static final class a
    implements d.a
  {
    public final String cIr()
    {
      return null;
    }
    
    public final String cIs()
    {
      AppMethodBeat.i(300997);
      int i = ao.getInstalledTbsCoreVersion(MMApplicationContext.getContext());
      AppMethodBeat.o(300997);
      return String.valueOf(i);
    }
    
    public final String cIt()
    {
      AppMethodBeat.i(301003);
      int i = ao.kge();
      AppMethodBeat.o(301003);
      return String.valueOf(i);
    }
    
    public final String cIu()
    {
      return null;
    }
    
    public final String cIv()
    {
      return null;
    }
  }
  
  static final class b
    implements n.a
  {
    public final Map<String, String> ayZ()
    {
      AppMethodBeat.i(301006);
      HashMap localHashMap = new HashMap();
      localHashMap.put("X5Version", String.valueOf(ao.getInstalledTbsCoreVersion(MMApplicationContext.getContext())));
      localHashMap.put("XWebVersion", String.valueOf(ao.kge()));
      AppMethodBeat.o(301006);
      return localHashMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.watchdogs.h
 * JD-Core Version:    0.7.0.1
 */