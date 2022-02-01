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

public final class h
{
  private static HashMap<String, h> BnN;
  public long BnA;
  public long BnB;
  public long BnC;
  public long BnD;
  public long BnE;
  public long BnF;
  public long BnG;
  public long BnH;
  public long BnI;
  public long BnJ;
  public long BnK;
  public long BnL;
  public long BnM;
  public long Bnx;
  public long Bny;
  public long Bnz;
  public long lvA;
  public long startTime;
  public String url;
  
  static
  {
    AppMethodBeat.i(80894);
    BnN = new HashMap();
    AppMethodBeat.o(80894);
  }
  
  private static Bundle a(int paramInt, String paramString, long paramLong)
  {
    AppMethodBeat.i(80891);
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", paramInt);
    localBundle.putString("url", paramString);
    localBundle.putLong("time", paramLong);
    AppMethodBeat.o(80891);
    return localBundle;
  }
  
  public static h ayk(String paramString)
  {
    AppMethodBeat.i(80878);
    if (BnN.containsKey(paramString)) {
      BnN.remove(paramString);
    }
    h localh = new h();
    localh.url = paramString;
    BnN.put(paramString, localh);
    AppMethodBeat.o(80878);
    return localh;
  }
  
  public static h ayl(String paramString)
  {
    AppMethodBeat.i(80879);
    if (BnN.containsKey(paramString))
    {
      paramString = (h)BnN.get(paramString);
      AppMethodBeat.o(80879);
      return paramString;
    }
    h localh = new h();
    localh.url = paramString;
    BnN.put(paramString, localh);
    AppMethodBeat.o(80879);
    return localh;
  }
  
  public static h aym(String paramString)
  {
    AppMethodBeat.i(80880);
    paramString = (h)BnN.get(paramString);
    AppMethodBeat.o(80880);
    return paramString;
  }
  
  public static h ayn(String paramString)
  {
    AppMethodBeat.i(80881);
    paramString = (h)BnN.remove(paramString);
    AppMethodBeat.o(80881);
    return paramString;
  }
  
  private static void b(int paramInt, String paramString, long paramLong)
  {
    AppMethodBeat.i(80893);
    ToolsProcessIPCService.a(a(paramInt, paramString, paramLong), a.class, null);
    AppMethodBeat.o(80893);
  }
  
  public static void bA(String paramString, long paramLong)
  {
    AppMethodBeat.i(80887);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80887);
      return;
    }
    if (epY())
    {
      if (aym(paramString) != null)
      {
        aym(paramString).BnC = paramLong;
        AppMethodBeat.o(80887);
      }
    }
    else {
      b(6, paramString, paramLong);
    }
    AppMethodBeat.o(80887);
  }
  
  public static void bB(String paramString, long paramLong)
  {
    AppMethodBeat.i(80888);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80888);
      return;
    }
    if (epY())
    {
      if (aym(paramString) != null)
      {
        aym(paramString).BnD = paramLong;
        AppMethodBeat.o(80888);
      }
    }
    else {
      b(7, paramString, paramLong);
    }
    AppMethodBeat.o(80888);
  }
  
  public static void bC(String paramString, long paramLong)
  {
    AppMethodBeat.i(80889);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80889);
      return;
    }
    if (epY())
    {
      if (aym(paramString) != null)
      {
        aym(paramString).BnE = paramLong;
        AppMethodBeat.o(80889);
      }
    }
    else {
      b(8, paramString, paramLong);
    }
    AppMethodBeat.o(80889);
  }
  
  public static void bD(String paramString, long paramLong)
  {
    AppMethodBeat.i(80890);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80890);
      return;
    }
    if (epY())
    {
      if (aym(paramString) != null)
      {
        aym(paramString).BnF = paramLong;
        AppMethodBeat.o(80890);
      }
    }
    else {
      b(10, paramString, paramLong);
    }
    AppMethodBeat.o(80890);
  }
  
  public static void bE(String paramString, long paramLong)
  {
    AppMethodBeat.i(188111);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(188111);
      return;
    }
    if (epY())
    {
      if (aym(paramString) != null)
      {
        aym(paramString).BnG = paramLong;
        aym(paramString).BnK = paramLong;
        AppMethodBeat.o(188111);
      }
    }
    else {
      b(11, paramString, paramLong);
    }
    AppMethodBeat.o(188111);
  }
  
  public static void bu(String paramString, long paramLong)
  {
    AppMethodBeat.i(182714);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(182714);
      return;
    }
    if (epY())
    {
      if (aym(paramString) == null) {
        break label74;
      }
      aym(paramString).Bnx = paramLong;
      try
      {
        a.fUK.a(6, URLEncoder.encode(paramString), "", 0L);
        AppMethodBeat.o(182714);
        return;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(182714);
        return;
      }
    }
    b(9, paramString, paramLong);
    label74:
    AppMethodBeat.o(182714);
  }
  
  public static void bv(String paramString, long paramLong)
  {
    AppMethodBeat.i(80882);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80882);
      return;
    }
    if (epY())
    {
      if (aym(paramString) != null)
      {
        aym(paramString).startTime = paramLong;
        AppMethodBeat.o(80882);
      }
    }
    else {
      b(1, paramString, paramLong);
    }
    AppMethodBeat.o(80882);
  }
  
  public static void bw(String paramString, long paramLong)
  {
    AppMethodBeat.i(80883);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80883);
      return;
    }
    if (epY())
    {
      if (aym(paramString) != null)
      {
        aym(paramString).Bny = paramLong;
        AppMethodBeat.o(80883);
      }
    }
    else {
      b(2, paramString, paramLong);
    }
    AppMethodBeat.o(80883);
  }
  
  public static void bx(String paramString, long paramLong)
  {
    AppMethodBeat.i(80884);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80884);
      return;
    }
    if (epY())
    {
      if (aym(paramString) != null)
      {
        aym(paramString).Bnz = paramLong;
        AppMethodBeat.o(80884);
      }
    }
    else {
      b(3, paramString, paramLong);
    }
    AppMethodBeat.o(80884);
  }
  
  public static void by(String paramString, long paramLong)
  {
    AppMethodBeat.i(80885);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80885);
      return;
    }
    if (epY())
    {
      if (aym(paramString) != null)
      {
        aym(paramString).BnA = paramLong;
        AppMethodBeat.o(80885);
      }
    }
    else {
      b(4, paramString, paramLong);
    }
    AppMethodBeat.o(80885);
  }
  
  public static void bz(String paramString, long paramLong)
  {
    AppMethodBeat.i(80886);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80886);
      return;
    }
    if (epY())
    {
      if (aym(paramString) != null)
      {
        aym(paramString).BnB = paramLong;
        AppMethodBeat.o(80886);
      }
    }
    else {
      b(5, paramString, paramLong);
    }
    AppMethodBeat.o(80886);
  }
  
  private static boolean epY()
  {
    AppMethodBeat.i(80892);
    if ((aj.eFJ()) || (aj.eFK()))
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.h
 * JD-Core Version:    0.7.0.1
 */