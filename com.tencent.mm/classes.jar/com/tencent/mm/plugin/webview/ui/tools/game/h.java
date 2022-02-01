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
  private static HashMap<String, h> QoI;
  public long QoA;
  public long QoB;
  public long QoC;
  public long QoD;
  public long QoE;
  public long QoF;
  public long QoG;
  public long QoH;
  public long Qor;
  public long Qos;
  public long Qot;
  public long Qou;
  public long Qov;
  public long Qow;
  public long Qox;
  public long Qoy;
  public long Qoz;
  public long qRk;
  public long startTime;
  public String url;
  
  static
  {
    AppMethodBeat.i(80894);
    QoI = new HashMap();
    AppMethodBeat.o(80894);
  }
  
  public static void bI(String paramString, long paramLong)
  {
    AppMethodBeat.i(182714);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(182714);
      return;
    }
    if (haz())
    {
      if (bmJ(paramString) == null) {
        break label74;
      }
      bmJ(paramString).Qor = paramLong;
      try
      {
        a.jTp.a(6, URLEncoder.encode(paramString), "", 0L);
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
  
  public static void bJ(String paramString, long paramLong)
  {
    AppMethodBeat.i(80882);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80882);
      return;
    }
    if (haz())
    {
      if (bmJ(paramString) != null)
      {
        bmJ(paramString).startTime = paramLong;
        AppMethodBeat.o(80882);
      }
    }
    else {
      d(1, paramString, paramLong);
    }
    AppMethodBeat.o(80882);
  }
  
  public static void bK(String paramString, long paramLong)
  {
    AppMethodBeat.i(80883);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80883);
      return;
    }
    if (haz())
    {
      if (bmJ(paramString) != null)
      {
        bmJ(paramString).Qos = paramLong;
        AppMethodBeat.o(80883);
      }
    }
    else {
      d(2, paramString, paramLong);
    }
    AppMethodBeat.o(80883);
  }
  
  public static void bL(String paramString, long paramLong)
  {
    AppMethodBeat.i(80884);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80884);
      return;
    }
    if (haz())
    {
      if (bmJ(paramString) != null)
      {
        bmJ(paramString).Qot = paramLong;
        AppMethodBeat.o(80884);
      }
    }
    else {
      d(3, paramString, paramLong);
    }
    AppMethodBeat.o(80884);
  }
  
  public static void bM(String paramString, long paramLong)
  {
    AppMethodBeat.i(80885);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80885);
      return;
    }
    if (haz())
    {
      if (bmJ(paramString) != null)
      {
        bmJ(paramString).Qou = paramLong;
        AppMethodBeat.o(80885);
      }
    }
    else {
      d(4, paramString, paramLong);
    }
    AppMethodBeat.o(80885);
  }
  
  public static void bN(String paramString, long paramLong)
  {
    AppMethodBeat.i(80886);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80886);
      return;
    }
    if (haz())
    {
      if (bmJ(paramString) != null)
      {
        bmJ(paramString).Qov = paramLong;
        AppMethodBeat.o(80886);
      }
    }
    else {
      d(5, paramString, paramLong);
    }
    AppMethodBeat.o(80886);
  }
  
  public static void bO(String paramString, long paramLong)
  {
    AppMethodBeat.i(80887);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80887);
      return;
    }
    if (haz())
    {
      if (bmJ(paramString) != null)
      {
        bmJ(paramString).Qow = paramLong;
        AppMethodBeat.o(80887);
      }
    }
    else {
      d(6, paramString, paramLong);
    }
    AppMethodBeat.o(80887);
  }
  
  public static void bP(String paramString, long paramLong)
  {
    AppMethodBeat.i(80888);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80888);
      return;
    }
    if (haz())
    {
      if (bmJ(paramString) != null)
      {
        bmJ(paramString).Qox = paramLong;
        AppMethodBeat.o(80888);
      }
    }
    else {
      d(7, paramString, paramLong);
    }
    AppMethodBeat.o(80888);
  }
  
  public static void bQ(String paramString, long paramLong)
  {
    AppMethodBeat.i(80889);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80889);
      return;
    }
    if (haz())
    {
      if (bmJ(paramString) != null)
      {
        bmJ(paramString).Qoy = paramLong;
        AppMethodBeat.o(80889);
      }
    }
    else {
      d(8, paramString, paramLong);
    }
    AppMethodBeat.o(80889);
  }
  
  public static void bR(String paramString, long paramLong)
  {
    AppMethodBeat.i(80890);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80890);
      return;
    }
    if (haz())
    {
      if (bmJ(paramString) != null)
      {
        bmJ(paramString).Qoz = paramLong;
        AppMethodBeat.o(80890);
      }
    }
    else {
      d(10, paramString, paramLong);
    }
    AppMethodBeat.o(80890);
  }
  
  public static void bS(String paramString, long paramLong)
  {
    AppMethodBeat.i(219007);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(219007);
      return;
    }
    if (haz())
    {
      paramString = bmJ(paramString);
      if (paramString != null)
      {
        paramString.QoA = paramLong;
        paramString.QoE = paramLong;
      }
      AppMethodBeat.o(219007);
      return;
    }
    d(11, paramString, paramLong);
    AppMethodBeat.o(219007);
  }
  
  public static h bmH(String paramString)
  {
    AppMethodBeat.i(80878);
    if (QoI.containsKey(paramString)) {
      QoI.remove(paramString);
    }
    h localh = new h();
    localh.url = paramString;
    QoI.put(paramString, localh);
    AppMethodBeat.o(80878);
    return localh;
  }
  
  public static h bmI(String paramString)
  {
    AppMethodBeat.i(80879);
    if (QoI.containsKey(paramString))
    {
      paramString = (h)QoI.get(paramString);
      AppMethodBeat.o(80879);
      return paramString;
    }
    h localh = new h();
    localh.url = paramString;
    QoI.put(paramString, localh);
    AppMethodBeat.o(80879);
    return localh;
  }
  
  public static h bmJ(String paramString)
  {
    AppMethodBeat.i(80880);
    paramString = (h)QoI.get(paramString);
    AppMethodBeat.o(80880);
    return paramString;
  }
  
  public static h bmK(String paramString)
  {
    AppMethodBeat.i(80881);
    paramString = (h)QoI.remove(paramString);
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
  
  private static void d(int paramInt, String paramString, long paramLong)
  {
    AppMethodBeat.i(80893);
    ToolsProcessIPCService.a(c(paramInt, paramString, paramLong), a.class, null);
    AppMethodBeat.o(80893);
  }
  
  private static boolean haz()
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