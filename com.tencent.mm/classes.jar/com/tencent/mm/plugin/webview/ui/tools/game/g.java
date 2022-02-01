package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.a;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.net.URLEncoder;
import java.util.HashMap;

public final class g
{
  private static HashMap<String, g> EBK;
  public long EBA;
  public long EBB;
  public long EBC;
  public long EBD;
  public long EBE;
  public long EBF;
  public long EBG;
  public long EBH;
  public long EBI;
  public long EBJ;
  public long EBt;
  public long EBu;
  public long EBv;
  public long EBw;
  public long EBx;
  public long EBy;
  public long EBz;
  public long mCg;
  public long startTime;
  public String url;
  
  static
  {
    AppMethodBeat.i(80894);
    EBK = new HashMap();
    AppMethodBeat.o(80894);
  }
  
  public static g aKv(String paramString)
  {
    AppMethodBeat.i(80878);
    if (EBK.containsKey(paramString)) {
      EBK.remove(paramString);
    }
    g localg = new g();
    localg.url = paramString;
    EBK.put(paramString, localg);
    AppMethodBeat.o(80878);
    return localg;
  }
  
  public static g aKw(String paramString)
  {
    AppMethodBeat.i(80879);
    if (EBK.containsKey(paramString))
    {
      paramString = (g)EBK.get(paramString);
      AppMethodBeat.o(80879);
      return paramString;
    }
    g localg = new g();
    localg.url = paramString;
    EBK.put(paramString, localg);
    AppMethodBeat.o(80879);
    return localg;
  }
  
  public static g aKx(String paramString)
  {
    AppMethodBeat.i(80880);
    paramString = (g)EBK.get(paramString);
    AppMethodBeat.o(80880);
    return paramString;
  }
  
  public static g aKy(String paramString)
  {
    AppMethodBeat.i(80881);
    paramString = (g)EBK.remove(paramString);
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
    AppMethodBeat.i(182714);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(182714);
      return;
    }
    if (eYb())
    {
      if (aKx(paramString) == null) {
        break label74;
      }
      aKx(paramString).EBt = paramLong;
      try
      {
        a.guC.a(6, URLEncoder.encode(paramString), "", 0L);
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
  
  public static void bB(String paramString, long paramLong)
  {
    AppMethodBeat.i(80882);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80882);
      return;
    }
    if (eYb())
    {
      if (aKx(paramString) != null)
      {
        aKx(paramString).startTime = paramLong;
        AppMethodBeat.o(80882);
      }
    }
    else {
      c(1, paramString, paramLong);
    }
    AppMethodBeat.o(80882);
  }
  
  public static void bC(String paramString, long paramLong)
  {
    AppMethodBeat.i(80883);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80883);
      return;
    }
    if (eYb())
    {
      if (aKx(paramString) != null)
      {
        aKx(paramString).EBu = paramLong;
        AppMethodBeat.o(80883);
      }
    }
    else {
      c(2, paramString, paramLong);
    }
    AppMethodBeat.o(80883);
  }
  
  public static void bD(String paramString, long paramLong)
  {
    AppMethodBeat.i(80884);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80884);
      return;
    }
    if (eYb())
    {
      if (aKx(paramString) != null)
      {
        aKx(paramString).EBv = paramLong;
        AppMethodBeat.o(80884);
      }
    }
    else {
      c(3, paramString, paramLong);
    }
    AppMethodBeat.o(80884);
  }
  
  public static void bE(String paramString, long paramLong)
  {
    AppMethodBeat.i(80885);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80885);
      return;
    }
    if (eYb())
    {
      if (aKx(paramString) != null)
      {
        aKx(paramString).EBw = paramLong;
        AppMethodBeat.o(80885);
      }
    }
    else {
      c(4, paramString, paramLong);
    }
    AppMethodBeat.o(80885);
  }
  
  public static void bF(String paramString, long paramLong)
  {
    AppMethodBeat.i(80886);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80886);
      return;
    }
    if (eYb())
    {
      if (aKx(paramString) != null)
      {
        aKx(paramString).EBx = paramLong;
        AppMethodBeat.o(80886);
      }
    }
    else {
      c(5, paramString, paramLong);
    }
    AppMethodBeat.o(80886);
  }
  
  public static void bG(String paramString, long paramLong)
  {
    AppMethodBeat.i(80887);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80887);
      return;
    }
    if (eYb())
    {
      if (aKx(paramString) != null)
      {
        aKx(paramString).EBy = paramLong;
        AppMethodBeat.o(80887);
      }
    }
    else {
      c(6, paramString, paramLong);
    }
    AppMethodBeat.o(80887);
  }
  
  public static void bH(String paramString, long paramLong)
  {
    AppMethodBeat.i(80888);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80888);
      return;
    }
    if (eYb())
    {
      if (aKx(paramString) != null)
      {
        aKx(paramString).EBz = paramLong;
        AppMethodBeat.o(80888);
      }
    }
    else {
      c(7, paramString, paramLong);
    }
    AppMethodBeat.o(80888);
  }
  
  public static void bI(String paramString, long paramLong)
  {
    AppMethodBeat.i(80889);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80889);
      return;
    }
    if (eYb())
    {
      if (aKx(paramString) != null)
      {
        aKx(paramString).EBA = paramLong;
        AppMethodBeat.o(80889);
      }
    }
    else {
      c(8, paramString, paramLong);
    }
    AppMethodBeat.o(80889);
  }
  
  public static void bJ(String paramString, long paramLong)
  {
    AppMethodBeat.i(80890);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80890);
      return;
    }
    if (eYb())
    {
      if (aKx(paramString) != null)
      {
        aKx(paramString).EBB = paramLong;
        AppMethodBeat.o(80890);
      }
    }
    else {
      c(10, paramString, paramLong);
    }
    AppMethodBeat.o(80890);
  }
  
  public static void bK(String paramString, long paramLong)
  {
    AppMethodBeat.i(198406);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(198406);
      return;
    }
    if (eYb())
    {
      paramString = aKx(paramString);
      if (paramString != null)
      {
        paramString.EBC = paramLong;
        paramString.EBG = paramLong;
      }
      AppMethodBeat.o(198406);
      return;
    }
    c(11, paramString, paramLong);
    AppMethodBeat.o(198406);
  }
  
  private static void c(int paramInt, String paramString, long paramLong)
  {
    AppMethodBeat.i(80893);
    ToolsProcessIPCService.a(b(paramInt, paramString, paramLong), a.class, null);
    AppMethodBeat.o(80893);
  }
  
  private static boolean eYb()
  {
    AppMethodBeat.i(80892);
    if ((ak.foC()) || (ak.foD()))
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