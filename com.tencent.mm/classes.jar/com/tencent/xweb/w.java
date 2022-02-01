package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.j;
import com.tencent.xweb.internal.j.a;
import com.tencent.xweb.util.g;
import com.tencent.xweb.xwalk.a.i;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class w
{
  static b MMR;
  static a MMS;
  
  static
  {
    AppMethodBeat.i(156773);
    j.a locala = j.g(WebView.c.MNy);
    MMR = (b)locala.excute("STR_CMD_GET_UPDATER", null);
    MMS = (a)locala.excute("STR_CMD_GET_PLUGIN_UPDATER", null);
    AppMethodBeat.o(156773);
  }
  
  public static void a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(156769);
    g.ghk();
    if (MMR != null)
    {
      Log.i("WCWebUpdater", "start check runtime update");
      MMR.a(paramContext, paramHashMap);
    }
    while (MMS != null)
    {
      g.ghd();
      MMS.a(paramContext, paramHashMap);
      AppMethodBeat.o(156769);
      return;
      Log.e("WCWebUpdater", "no sWebviewUpdater");
    }
    Log.e("WCWebUpdater", "no sPluginUpdater");
    AppMethodBeat.o(156769);
  }
  
  public static void gfk()
  {
    AppMethodBeat.i(156770);
    if (MMR != null)
    {
      Log.i("WCWebUpdater", "start check runtime update");
      HashMap localHashMap = new HashMap();
      localHashMap.put("UpdaterCheckType", "2");
      MMR.a(XWalkEnvironment.getApplicationContext(), localHashMap);
      AppMethodBeat.o(156770);
      return;
    }
    Log.e("WCWebUpdater", "no sWebviewUpdater");
    AppMethodBeat.o(156770);
  }
  
  public static void gfl()
  {
    AppMethodBeat.i(156771);
    if (MMR != null)
    {
      Log.i("WCWebUpdater", "start check runtime update");
      new HashMap().put("UpdaterCheckType", "3");
      MMR.a(XWalkEnvironment.getApplicationContext(), null);
      AppMethodBeat.o(156771);
      return;
    }
    Log.e("WCWebUpdater", "no sWebviewUpdater");
    AppMethodBeat.o(156771);
  }
  
  public static void gfm()
  {
    AppMethodBeat.i(217395);
    if (MMR != null)
    {
      Log.i("WCWebUpdater", "tryEmbedInstall");
      HashMap localHashMap = new HashMap();
      localHashMap.put("UpdaterCheckType", "4");
      MMR.a(XWalkEnvironment.getApplicationContext(), localHashMap);
      AppMethodBeat.o(217395);
      return;
    }
    Log.e("WCWebUpdater", "no sWebviewUpdater");
    AppMethodBeat.o(217395);
  }
  
  public static boolean isBusy()
  {
    AppMethodBeat.i(156772);
    boolean bool1;
    if (MMR != null)
    {
      bool1 = MMR.isBusy();
      if (MMS == null) {
        break label62;
      }
    }
    for (boolean bool2 = MMS.isBusy();; bool2 = false)
    {
      if ((!bool1) && (!bool2)) {
        break label74;
      }
      AppMethodBeat.o(156772);
      return true;
      Log.e("WCWebUpdater", "check is busy : no sWebviewUpdater");
      bool1 = false;
      break;
      label62:
      Log.e("WCWebUpdater", "check is busy : no sPluginUpdater");
    }
    label74:
    AppMethodBeat.o(156772);
    return false;
  }
  
  public static abstract interface a
    extends w.b
  {
    public abstract void a(String paramString, i parami);
    
    public abstract void gfn();
  }
  
  public static abstract interface b
  {
    public abstract void a(Context paramContext, HashMap<String, String> paramHashMap);
    
    public abstract boolean isBusy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.w
 * JD-Core Version:    0.7.0.1
 */