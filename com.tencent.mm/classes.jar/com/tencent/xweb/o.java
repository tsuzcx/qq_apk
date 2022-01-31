package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.l;
import com.tencent.xweb.c.l.a;
import com.tencent.xweb.util.f;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class o
{
  static o.a BDD;
  static o.a BDE;
  
  static
  {
    AppMethodBeat.i(3817);
    l.a locala = l.e(WebView.d.BEq);
    BDD = (o.a)locala.excute("STR_CMD_GET_UPDATER", null);
    BDE = (o.a)locala.excute("STR_CMD_GET_PLUGIN_UPDATER", null);
    AppMethodBeat.o(3817);
  }
  
  public static void a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(3813);
    f.dZL();
    if (BDD != null)
    {
      Log.i("WCWebUpdater", "start check runtime update");
      BDD.a(paramContext, paramHashMap);
    }
    while (BDE != null)
    {
      f.dZA();
      BDE.a(paramContext, paramHashMap);
      AppMethodBeat.o(3813);
      return;
      Log.e("WCWebUpdater", "no sWebviewUpdater");
    }
    Log.e("WCWebUpdater", "no sPluginUpdater");
    AppMethodBeat.o(3813);
  }
  
  public static void dYl()
  {
    AppMethodBeat.i(3814);
    if (BDD != null)
    {
      Log.i("WCWebUpdater", "start check runtime update");
      HashMap localHashMap = new HashMap();
      localHashMap.put("UpdaterCheckType", "2");
      BDD.a(XWalkEnvironment.getApplicationContext(), localHashMap);
      AppMethodBeat.o(3814);
      return;
    }
    Log.e("WCWebUpdater", "no sWebviewUpdater");
    AppMethodBeat.o(3814);
  }
  
  public static void dYm()
  {
    AppMethodBeat.i(3815);
    if (BDD != null)
    {
      Log.i("WCWebUpdater", "start check runtime update");
      new HashMap().put("UpdaterCheckType", "3");
      BDD.a(XWalkEnvironment.getApplicationContext(), null);
      AppMethodBeat.o(3815);
      return;
    }
    Log.e("WCWebUpdater", "no sWebviewUpdater");
    AppMethodBeat.o(3815);
  }
  
  public static boolean isBusy()
  {
    AppMethodBeat.i(3816);
    boolean bool1;
    if (BDD != null)
    {
      bool1 = BDD.isBusy();
      if (BDE == null) {
        break label64;
      }
    }
    for (boolean bool2 = BDE.isBusy();; bool2 = false)
    {
      if ((!bool1) && (!bool2)) {
        break label76;
      }
      AppMethodBeat.o(3816);
      return true;
      Log.e("WCWebUpdater", "check is busy : no sWebviewUpdater");
      bool1 = false;
      break;
      label64:
      Log.e("WCWebUpdater", "check is busy : no sPluginUpdater");
    }
    label76:
    AppMethodBeat.o(3816);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.o
 * JD-Core Version:    0.7.0.1
 */