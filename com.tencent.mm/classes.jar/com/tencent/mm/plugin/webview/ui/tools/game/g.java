package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.a;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.net.URLEncoder;
import java.util.HashMap;

public final class g
{
  private static HashMap<String, g> EjG;
  public long EjA;
  public long EjB;
  public long EjC;
  public long EjD;
  public long EjE;
  public long EjF;
  public long Ejp;
  public long Ejq;
  public long Ejr;
  public long Ejs;
  public long Ejt;
  public long Eju;
  public long Ejv;
  public long Ejw;
  public long Ejx;
  public long Ejy;
  public long Ejz;
  public long mxj;
  public long startTime;
  public String url;
  
  static
  {
    AppMethodBeat.i(80894);
    EjG = new HashMap();
    AppMethodBeat.o(80894);
  }
  
  public static g aJc(String paramString)
  {
    AppMethodBeat.i(80878);
    if (EjG.containsKey(paramString)) {
      EjG.remove(paramString);
    }
    g localg = new g();
    localg.url = paramString;
    EjG.put(paramString, localg);
    AppMethodBeat.o(80878);
    return localg;
  }
  
  public static g aJd(String paramString)
  {
    AppMethodBeat.i(80879);
    if (EjG.containsKey(paramString))
    {
      paramString = (g)EjG.get(paramString);
      AppMethodBeat.o(80879);
      return paramString;
    }
    g localg = new g();
    localg.url = paramString;
    EjG.put(paramString, localg);
    AppMethodBeat.o(80879);
    return localg;
  }
  
  public static g aJe(String paramString)
  {
    AppMethodBeat.i(80880);
    paramString = (g)EjG.get(paramString);
    AppMethodBeat.o(80880);
    return paramString;
  }
  
  public static g aJf(String paramString)
  {
    AppMethodBeat.i(80881);
    paramString = (g)EjG.remove(paramString);
    AppMethodBeat.o(80881);
    return paramString;
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
  
  public static void bA(String paramString, long paramLong)
  {
    AppMethodBeat.i(80882);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80882);
      return;
    }
    if (eUo())
    {
      if (aJe(paramString) != null)
      {
        aJe(paramString).startTime = paramLong;
        AppMethodBeat.o(80882);
      }
    }
    else {
      c(1, paramString, paramLong);
    }
    AppMethodBeat.o(80882);
  }
  
  public static void bB(String paramString, long paramLong)
  {
    AppMethodBeat.i(80883);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80883);
      return;
    }
    if (eUo())
    {
      if (aJe(paramString) != null)
      {
        aJe(paramString).Ejq = paramLong;
        AppMethodBeat.o(80883);
      }
    }
    else {
      c(2, paramString, paramLong);
    }
    AppMethodBeat.o(80883);
  }
  
  public static void bC(String paramString, long paramLong)
  {
    AppMethodBeat.i(80884);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80884);
      return;
    }
    if (eUo())
    {
      if (aJe(paramString) != null)
      {
        aJe(paramString).Ejr = paramLong;
        AppMethodBeat.o(80884);
      }
    }
    else {
      c(3, paramString, paramLong);
    }
    AppMethodBeat.o(80884);
  }
  
  public static void bD(String paramString, long paramLong)
  {
    AppMethodBeat.i(80885);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80885);
      return;
    }
    if (eUo())
    {
      if (aJe(paramString) != null)
      {
        aJe(paramString).Ejs = paramLong;
        AppMethodBeat.o(80885);
      }
    }
    else {
      c(4, paramString, paramLong);
    }
    AppMethodBeat.o(80885);
  }
  
  public static void bE(String paramString, long paramLong)
  {
    AppMethodBeat.i(80886);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80886);
      return;
    }
    if (eUo())
    {
      if (aJe(paramString) != null)
      {
        aJe(paramString).Ejt = paramLong;
        AppMethodBeat.o(80886);
      }
    }
    else {
      c(5, paramString, paramLong);
    }
    AppMethodBeat.o(80886);
  }
  
  public static void bF(String paramString, long paramLong)
  {
    AppMethodBeat.i(80887);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80887);
      return;
    }
    if (eUo())
    {
      if (aJe(paramString) != null)
      {
        aJe(paramString).Eju = paramLong;
        AppMethodBeat.o(80887);
      }
    }
    else {
      c(6, paramString, paramLong);
    }
    AppMethodBeat.o(80887);
  }
  
  public static void bG(String paramString, long paramLong)
  {
    AppMethodBeat.i(80888);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80888);
      return;
    }
    if (eUo())
    {
      if (aJe(paramString) != null)
      {
        aJe(paramString).Ejv = paramLong;
        AppMethodBeat.o(80888);
      }
    }
    else {
      c(7, paramString, paramLong);
    }
    AppMethodBeat.o(80888);
  }
  
  public static void bH(String paramString, long paramLong)
  {
    AppMethodBeat.i(80889);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80889);
      return;
    }
    if (eUo())
    {
      if (aJe(paramString) != null)
      {
        aJe(paramString).Ejw = paramLong;
        AppMethodBeat.o(80889);
      }
    }
    else {
      c(8, paramString, paramLong);
    }
    AppMethodBeat.o(80889);
  }
  
  public static void bI(String paramString, long paramLong)
  {
    AppMethodBeat.i(80890);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80890);
      return;
    }
    if (eUo())
    {
      if (aJe(paramString) != null)
      {
        aJe(paramString).Ejx = paramLong;
        AppMethodBeat.o(80890);
      }
    }
    else {
      c(10, paramString, paramLong);
    }
    AppMethodBeat.o(80890);
  }
  
  public static void bJ(String paramString, long paramLong)
  {
    AppMethodBeat.i(208225);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(208225);
      return;
    }
    if (eUo())
    {
      paramString = aJe(paramString);
      if (paramString != null)
      {
        paramString.Ejy = paramLong;
        paramString.EjC = paramLong;
      }
      AppMethodBeat.o(208225);
      return;
    }
    c(11, paramString, paramLong);
    AppMethodBeat.o(208225);
  }
  
  public static void bz(String paramString, long paramLong)
  {
    AppMethodBeat.i(182714);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(182714);
      return;
    }
    if (eUo())
    {
      if (aJe(paramString) == null) {
        break label74;
      }
      aJe(paramString).Ejp = paramLong;
      try
      {
        a.gsb.a(6, URLEncoder.encode(paramString), "", 0L);
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
  
  private static void c(int paramInt, String paramString, long paramLong)
  {
    AppMethodBeat.i(80893);
    ToolsProcessIPCService.a(b(paramInt, paramString, paramLong), a.class, null);
    AppMethodBeat.o(80893);
  }
  
  private static boolean eUo()
  {
    AppMethodBeat.i(80892);
    if ((aj.fkI()) || (aj.fkJ()))
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