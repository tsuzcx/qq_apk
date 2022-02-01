package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.a;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;

public final class h
{
  private static HashMap<String, h> XgW;
  public long XgF;
  public long XgG;
  public long XgH;
  public long XgI;
  public long XgJ;
  public long XgK;
  public long XgL;
  public long XgM;
  public long XgN;
  public long XgO;
  public long XgP;
  public long XgQ;
  public long XgR;
  public long XgS;
  public long XgT;
  public long XgU;
  public long XgV;
  public long startTime;
  public long tVS;
  public String url;
  
  static
  {
    AppMethodBeat.i(80894);
    XgW = new HashMap();
    AppMethodBeat.o(80894);
  }
  
  public static void bT(String paramString, long paramLong)
  {
    AppMethodBeat.i(182714);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(182714);
      return;
    }
    if (iAM())
    {
      if (bmn(paramString) == null) {
        break label74;
      }
      bmn(paramString).XgF = paramLong;
      try
      {
        a.mtH.a(6, URLEncoder.encode(paramString), "", 0L);
        AppMethodBeat.o(182714);
        return;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(182714);
        return;
      }
    }
    d(9, paramString, paramLong);
    label74:
    AppMethodBeat.o(182714);
  }
  
  public static void bU(String paramString, long paramLong)
  {
    AppMethodBeat.i(80882);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80882);
      return;
    }
    if (iAM())
    {
      if (bmn(paramString) != null)
      {
        bmn(paramString).startTime = paramLong;
        AppMethodBeat.o(80882);
      }
    }
    else {
      d(1, paramString, paramLong);
    }
    AppMethodBeat.o(80882);
  }
  
  public static void bV(String paramString, long paramLong)
  {
    AppMethodBeat.i(80883);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80883);
      return;
    }
    if (iAM())
    {
      if (bmn(paramString) != null)
      {
        bmn(paramString).XgG = paramLong;
        AppMethodBeat.o(80883);
      }
    }
    else {
      d(2, paramString, paramLong);
    }
    AppMethodBeat.o(80883);
  }
  
  public static void bW(String paramString, long paramLong)
  {
    AppMethodBeat.i(80884);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80884);
      return;
    }
    if (iAM())
    {
      if (bmn(paramString) != null)
      {
        bmn(paramString).XgH = paramLong;
        AppMethodBeat.o(80884);
      }
    }
    else {
      d(3, paramString, paramLong);
    }
    AppMethodBeat.o(80884);
  }
  
  public static void bX(String paramString, long paramLong)
  {
    AppMethodBeat.i(80885);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80885);
      return;
    }
    if (iAM())
    {
      if (bmn(paramString) != null)
      {
        bmn(paramString).XgI = paramLong;
        AppMethodBeat.o(80885);
      }
    }
    else {
      d(4, paramString, paramLong);
    }
    AppMethodBeat.o(80885);
  }
  
  public static void bY(String paramString, long paramLong)
  {
    AppMethodBeat.i(80886);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80886);
      return;
    }
    if (iAM())
    {
      if (bmn(paramString) != null)
      {
        bmn(paramString).XgJ = paramLong;
        AppMethodBeat.o(80886);
      }
    }
    else {
      d(5, paramString, paramLong);
    }
    AppMethodBeat.o(80886);
  }
  
  public static void bZ(String paramString, long paramLong)
  {
    AppMethodBeat.i(80887);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80887);
      return;
    }
    if (iAM())
    {
      if (bmn(paramString) != null)
      {
        bmn(paramString).XgK = paramLong;
        AppMethodBeat.o(80887);
      }
    }
    else {
      d(6, paramString, paramLong);
    }
    AppMethodBeat.o(80887);
  }
  
  public static h bml(String paramString)
  {
    AppMethodBeat.i(80878);
    if (XgW.containsKey(paramString)) {
      XgW.remove(paramString);
    }
    h localh = new h();
    localh.url = paramString;
    XgW.put(paramString, localh);
    AppMethodBeat.o(80878);
    return localh;
  }
  
  public static h bmm(String paramString)
  {
    AppMethodBeat.i(80879);
    if (XgW.containsKey(paramString))
    {
      paramString = (h)XgW.get(paramString);
      AppMethodBeat.o(80879);
      return paramString;
    }
    h localh = new h();
    localh.url = paramString;
    XgW.put(paramString, localh);
    AppMethodBeat.o(80879);
    return localh;
  }
  
  public static h bmn(String paramString)
  {
    AppMethodBeat.i(80880);
    paramString = (h)XgW.get(paramString);
    AppMethodBeat.o(80880);
    return paramString;
  }
  
  public static h bmo(String paramString)
  {
    AppMethodBeat.i(80881);
    paramString = (h)XgW.remove(paramString);
    AppMethodBeat.o(80881);
    return paramString;
  }
  
  private static Bundle c(int paramInt, String paramString, long paramLong)
  {
    AppMethodBeat.i(80891);
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", paramInt);
    localBundle.putString("url", paramString);
    localBundle.putLong("time", paramLong);
    AppMethodBeat.o(80891);
    return localBundle;
  }
  
  public static void ca(String paramString, long paramLong)
  {
    AppMethodBeat.i(80888);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80888);
      return;
    }
    if (iAM())
    {
      if (bmn(paramString) != null)
      {
        bmn(paramString).XgL = paramLong;
        AppMethodBeat.o(80888);
      }
    }
    else {
      d(7, paramString, paramLong);
    }
    AppMethodBeat.o(80888);
  }
  
  public static void cb(String paramString, long paramLong)
  {
    AppMethodBeat.i(80889);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80889);
      return;
    }
    if (iAM())
    {
      if (bmn(paramString) != null)
      {
        bmn(paramString).XgM = paramLong;
        AppMethodBeat.o(80889);
      }
    }
    else {
      d(8, paramString, paramLong);
    }
    AppMethodBeat.o(80889);
  }
  
  public static void cc(String paramString, long paramLong)
  {
    AppMethodBeat.i(80890);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80890);
      return;
    }
    if (iAM())
    {
      if (bmn(paramString) != null)
      {
        bmn(paramString).XgN = paramLong;
        AppMethodBeat.o(80890);
      }
    }
    else {
      d(10, paramString, paramLong);
    }
    AppMethodBeat.o(80890);
  }
  
  public static void cd(String paramString, long paramLong)
  {
    AppMethodBeat.i(297034);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(297034);
      return;
    }
    if (iAM())
    {
      paramString = bmn(paramString);
      if (paramString != null)
      {
        paramString.XgO = paramLong;
        paramString.XgS = paramLong;
      }
      AppMethodBeat.o(297034);
      return;
    }
    d(11, paramString, paramLong);
    AppMethodBeat.o(297034);
  }
  
  private static void d(int paramInt, String paramString, long paramLong)
  {
    AppMethodBeat.i(80893);
    ToolsProcessIPCService.a(c(paramInt, paramString, paramLong), a.class, null);
    AppMethodBeat.o(80893);
  }
  
  private static boolean iAM()
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
    implements d<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.h
 * JD-Core Version:    0.7.0.1
 */