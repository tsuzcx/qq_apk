package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.a;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.net.URLEncoder;
import java.util.HashMap;

public final class h
{
  private static HashMap<String, h> CFU;
  public long CFE;
  public long CFF;
  public long CFG;
  public long CFH;
  public long CFI;
  public long CFJ;
  public long CFK;
  public long CFL;
  public long CFM;
  public long CFN;
  public long CFO;
  public long CFP;
  public long CFQ;
  public long CFR;
  public long CFS;
  public long CFT;
  public long lXu;
  public long startTime;
  public String url;
  
  static
  {
    AppMethodBeat.i(80894);
    CFU = new HashMap();
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
  
  public static h aDB(String paramString)
  {
    AppMethodBeat.i(80878);
    if (CFU.containsKey(paramString)) {
      CFU.remove(paramString);
    }
    h localh = new h();
    localh.url = paramString;
    CFU.put(paramString, localh);
    AppMethodBeat.o(80878);
    return localh;
  }
  
  public static h aDC(String paramString)
  {
    AppMethodBeat.i(80879);
    if (CFU.containsKey(paramString))
    {
      paramString = (h)CFU.get(paramString);
      AppMethodBeat.o(80879);
      return paramString;
    }
    h localh = new h();
    localh.url = paramString;
    CFU.put(paramString, localh);
    AppMethodBeat.o(80879);
    return localh;
  }
  
  public static h aDD(String paramString)
  {
    AppMethodBeat.i(80880);
    paramString = (h)CFU.get(paramString);
    AppMethodBeat.o(80880);
    return paramString;
  }
  
  public static h aDE(String paramString)
  {
    AppMethodBeat.i(80881);
    paramString = (h)CFU.remove(paramString);
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
    AppMethodBeat.i(80885);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80885);
      return;
    }
    if (eFs())
    {
      if (aDD(paramString) != null)
      {
        aDD(paramString).CFH = paramLong;
        AppMethodBeat.o(80885);
      }
    }
    else {
      b(4, paramString, paramLong);
    }
    AppMethodBeat.o(80885);
  }
  
  public static void bB(String paramString, long paramLong)
  {
    AppMethodBeat.i(80886);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80886);
      return;
    }
    if (eFs())
    {
      if (aDD(paramString) != null)
      {
        aDD(paramString).CFI = paramLong;
        AppMethodBeat.o(80886);
      }
    }
    else {
      b(5, paramString, paramLong);
    }
    AppMethodBeat.o(80886);
  }
  
  public static void bC(String paramString, long paramLong)
  {
    AppMethodBeat.i(80887);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80887);
      return;
    }
    if (eFs())
    {
      if (aDD(paramString) != null)
      {
        aDD(paramString).CFJ = paramLong;
        AppMethodBeat.o(80887);
      }
    }
    else {
      b(6, paramString, paramLong);
    }
    AppMethodBeat.o(80887);
  }
  
  public static void bD(String paramString, long paramLong)
  {
    AppMethodBeat.i(80888);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80888);
      return;
    }
    if (eFs())
    {
      if (aDD(paramString) != null)
      {
        aDD(paramString).CFK = paramLong;
        AppMethodBeat.o(80888);
      }
    }
    else {
      b(7, paramString, paramLong);
    }
    AppMethodBeat.o(80888);
  }
  
  public static void bE(String paramString, long paramLong)
  {
    AppMethodBeat.i(80889);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80889);
      return;
    }
    if (eFs())
    {
      if (aDD(paramString) != null)
      {
        aDD(paramString).CFL = paramLong;
        AppMethodBeat.o(80889);
      }
    }
    else {
      b(8, paramString, paramLong);
    }
    AppMethodBeat.o(80889);
  }
  
  public static void bF(String paramString, long paramLong)
  {
    AppMethodBeat.i(80890);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80890);
      return;
    }
    if (eFs())
    {
      if (aDD(paramString) != null)
      {
        aDD(paramString).CFM = paramLong;
        AppMethodBeat.o(80890);
      }
    }
    else {
      b(10, paramString, paramLong);
    }
    AppMethodBeat.o(80890);
  }
  
  public static void bG(String paramString, long paramLong)
  {
    AppMethodBeat.i(188555);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(188555);
      return;
    }
    if (eFs())
    {
      if (aDD(paramString) != null)
      {
        aDD(paramString).CFN = paramLong;
        aDD(paramString).CFR = paramLong;
        AppMethodBeat.o(188555);
      }
    }
    else {
      b(11, paramString, paramLong);
    }
    AppMethodBeat.o(188555);
  }
  
  public static void bw(String paramString, long paramLong)
  {
    AppMethodBeat.i(182714);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(182714);
      return;
    }
    if (eFs())
    {
      if (aDD(paramString) == null) {
        break label74;
      }
      aDD(paramString).CFE = paramLong;
      try
      {
        a.fYF.a(6, URLEncoder.encode(paramString), "", 0L);
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
  
  public static void bx(String paramString, long paramLong)
  {
    AppMethodBeat.i(80882);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80882);
      return;
    }
    if (eFs())
    {
      if (aDD(paramString) != null)
      {
        aDD(paramString).startTime = paramLong;
        AppMethodBeat.o(80882);
      }
    }
    else {
      b(1, paramString, paramLong);
    }
    AppMethodBeat.o(80882);
  }
  
  public static void by(String paramString, long paramLong)
  {
    AppMethodBeat.i(80883);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80883);
      return;
    }
    if (eFs())
    {
      if (aDD(paramString) != null)
      {
        aDD(paramString).CFF = paramLong;
        AppMethodBeat.o(80883);
      }
    }
    else {
      b(2, paramString, paramLong);
    }
    AppMethodBeat.o(80883);
  }
  
  public static void bz(String paramString, long paramLong)
  {
    AppMethodBeat.i(80884);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80884);
      return;
    }
    if (eFs())
    {
      if (aDD(paramString) != null)
      {
        aDD(paramString).CFG = paramLong;
        AppMethodBeat.o(80884);
      }
    }
    else {
      b(3, paramString, paramLong);
    }
    AppMethodBeat.o(80884);
  }
  
  private static boolean eFs()
  {
    AppMethodBeat.i(80892);
    if ((ai.eVd()) || (ai.eVe()))
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