package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.a;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;

public final class g
{
  private static HashMap<String, g> Jrl;
  public long JqU;
  public long JqV;
  public long JqW;
  public long JqX;
  public long JqY;
  public long JqZ;
  public long Jra;
  public long Jrb;
  public long Jrc;
  public long Jrd;
  public long Jre;
  public long Jrf;
  public long Jrg;
  public long Jrh;
  public long Jri;
  public long Jrj;
  public long Jrk;
  public long nOC;
  public long startTime;
  public String url;
  
  static
  {
    AppMethodBeat.i(80894);
    Jrl = new HashMap();
    AppMethodBeat.o(80894);
  }
  
  private static Bundle b(int paramInt, String paramString, long paramLong)
  {
    AppMethodBeat.i(80891);
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", paramInt);
    localBundle.putString("url", paramString);
    localBundle.putLong("time", paramLong);
    AppMethodBeat.o(80891);
    return localBundle;
  }
  
  public static void bB(String paramString, long paramLong)
  {
    AppMethodBeat.i(182714);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(182714);
      return;
    }
    if (ghg())
    {
      if (baL(paramString) == null) {
        break label74;
      }
      baL(paramString).JqU = paramLong;
      try
      {
        a.hhr.a(6, URLEncoder.encode(paramString), "", 0L);
        AppMethodBeat.o(182714);
        return;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(182714);
        return;
      }
    }
    c(9, paramString, paramLong);
    label74:
    AppMethodBeat.o(182714);
  }
  
  public static void bC(String paramString, long paramLong)
  {
    AppMethodBeat.i(80882);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80882);
      return;
    }
    if (ghg())
    {
      if (baL(paramString) != null)
      {
        baL(paramString).startTime = paramLong;
        AppMethodBeat.o(80882);
      }
    }
    else {
      c(1, paramString, paramLong);
    }
    AppMethodBeat.o(80882);
  }
  
  public static void bD(String paramString, long paramLong)
  {
    AppMethodBeat.i(80883);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80883);
      return;
    }
    if (ghg())
    {
      if (baL(paramString) != null)
      {
        baL(paramString).JqV = paramLong;
        AppMethodBeat.o(80883);
      }
    }
    else {
      c(2, paramString, paramLong);
    }
    AppMethodBeat.o(80883);
  }
  
  public static void bE(String paramString, long paramLong)
  {
    AppMethodBeat.i(80884);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80884);
      return;
    }
    if (ghg())
    {
      if (baL(paramString) != null)
      {
        baL(paramString).JqW = paramLong;
        AppMethodBeat.o(80884);
      }
    }
    else {
      c(3, paramString, paramLong);
    }
    AppMethodBeat.o(80884);
  }
  
  public static void bF(String paramString, long paramLong)
  {
    AppMethodBeat.i(80885);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80885);
      return;
    }
    if (ghg())
    {
      if (baL(paramString) != null)
      {
        baL(paramString).JqX = paramLong;
        AppMethodBeat.o(80885);
      }
    }
    else {
      c(4, paramString, paramLong);
    }
    AppMethodBeat.o(80885);
  }
  
  public static void bG(String paramString, long paramLong)
  {
    AppMethodBeat.i(80886);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80886);
      return;
    }
    if (ghg())
    {
      if (baL(paramString) != null)
      {
        baL(paramString).JqY = paramLong;
        AppMethodBeat.o(80886);
      }
    }
    else {
      c(5, paramString, paramLong);
    }
    AppMethodBeat.o(80886);
  }
  
  public static void bH(String paramString, long paramLong)
  {
    AppMethodBeat.i(80887);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80887);
      return;
    }
    if (ghg())
    {
      if (baL(paramString) != null)
      {
        baL(paramString).JqZ = paramLong;
        AppMethodBeat.o(80887);
      }
    }
    else {
      c(6, paramString, paramLong);
    }
    AppMethodBeat.o(80887);
  }
  
  public static void bI(String paramString, long paramLong)
  {
    AppMethodBeat.i(80888);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80888);
      return;
    }
    if (ghg())
    {
      if (baL(paramString) != null)
      {
        baL(paramString).Jra = paramLong;
        AppMethodBeat.o(80888);
      }
    }
    else {
      c(7, paramString, paramLong);
    }
    AppMethodBeat.o(80888);
  }
  
  public static void bJ(String paramString, long paramLong)
  {
    AppMethodBeat.i(80889);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80889);
      return;
    }
    if (ghg())
    {
      if (baL(paramString) != null)
      {
        baL(paramString).Jrb = paramLong;
        AppMethodBeat.o(80889);
      }
    }
    else {
      c(8, paramString, paramLong);
    }
    AppMethodBeat.o(80889);
  }
  
  public static void bK(String paramString, long paramLong)
  {
    AppMethodBeat.i(80890);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80890);
      return;
    }
    if (ghg())
    {
      if (baL(paramString) != null)
      {
        baL(paramString).Jrc = paramLong;
        AppMethodBeat.o(80890);
      }
    }
    else {
      c(10, paramString, paramLong);
    }
    AppMethodBeat.o(80890);
  }
  
  public static void bL(String paramString, long paramLong)
  {
    AppMethodBeat.i(211315);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(211315);
      return;
    }
    if (ghg())
    {
      paramString = baL(paramString);
      if (paramString != null)
      {
        paramString.Jrd = paramLong;
        paramString.Jrh = paramLong;
      }
      AppMethodBeat.o(211315);
      return;
    }
    c(11, paramString, paramLong);
    AppMethodBeat.o(211315);
  }
  
  public static g baJ(String paramString)
  {
    AppMethodBeat.i(80878);
    if (Jrl.containsKey(paramString)) {
      Jrl.remove(paramString);
    }
    g localg = new g();
    localg.url = paramString;
    Jrl.put(paramString, localg);
    AppMethodBeat.o(80878);
    return localg;
  }
  
  public static g baK(String paramString)
  {
    AppMethodBeat.i(80879);
    if (Jrl.containsKey(paramString))
    {
      paramString = (g)Jrl.get(paramString);
      AppMethodBeat.o(80879);
      return paramString;
    }
    g localg = new g();
    localg.url = paramString;
    Jrl.put(paramString, localg);
    AppMethodBeat.o(80879);
    return localg;
  }
  
  public static g baL(String paramString)
  {
    AppMethodBeat.i(80880);
    paramString = (g)Jrl.get(paramString);
    AppMethodBeat.o(80880);
    return paramString;
  }
  
  public static g baM(String paramString)
  {
    AppMethodBeat.i(80881);
    paramString = (g)Jrl.remove(paramString);
    AppMethodBeat.o(80881);
    return paramString;
  }
  
  private static void c(int paramInt, String paramString, long paramLong)
  {
    AppMethodBeat.i(80893);
    ToolsProcessIPCService.a(b(paramInt, paramString, paramLong), a.class, null);
    AppMethodBeat.o(80893);
  }
  
  private static boolean ghg()
  {
    AppMethodBeat.i(80892);
    if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
    {
      AppMethodBeat.o(80892);
      return true;
    }
    AppMethodBeat.o(80892);
    return false;
  }
  
  public static class a
    implements b<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.g
 * JD-Core Version:    0.7.0.1
 */