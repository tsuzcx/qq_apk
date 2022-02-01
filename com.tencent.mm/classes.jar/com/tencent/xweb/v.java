package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.j;
import com.tencent.xweb.internal.j.a;
import com.tencent.xweb.util.g;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class v
{
  static a IMU;
  static a IMV;
  
  static
  {
    AppMethodBeat.i(156773);
    j.a locala = j.g(WebView.c.INC);
    IMU = (a)locala.excute("STR_CMD_GET_UPDATER", null);
    IMV = (a)locala.excute("STR_CMD_GET_PLUGIN_UPDATER", null);
    AppMethodBeat.o(156773);
  }
  
  public static void a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(156769);
    g.fsK();
    if (IMU != null)
    {
      Log.i("WCWebUpdater", "start check runtime update");
      IMU.a(paramContext, paramHashMap);
    }
    while (IMV != null)
    {
      g.fsD();
      IMV.a(paramContext, paramHashMap);
      AppMethodBeat.o(156769);
      return;
      Log.e("WCWebUpdater", "no sWebviewUpdater");
    }
    Log.e("WCWebUpdater", "no sPluginUpdater");
    AppMethodBeat.o(156769);
  }
  
  public static void fqO()
  {
    AppMethodBeat.i(156770);
    if (IMU != null)
    {
      Log.i("WCWebUpdater", "start check runtime update");
      HashMap localHashMap = new HashMap();
      localHashMap.put("UpdaterCheckType", "2");
      IMU.a(XWalkEnvironment.getApplicationContext(), localHashMap);
      AppMethodBeat.o(156770);
      return;
    }
    Log.e("WCWebUpdater", "no sWebviewUpdater");
    AppMethodBeat.o(156770);
  }
  
  public static void fqP()
  {
    AppMethodBeat.i(156771);
    if (IMU != null)
    {
      Log.i("WCWebUpdater", "start check runtime update");
      new HashMap().put("UpdaterCheckType", "3");
      IMU.a(XWalkEnvironment.getApplicationContext(), null);
      AppMethodBeat.o(156771);
      return;
    }
    Log.e("WCWebUpdater", "no sWebviewUpdater");
    AppMethodBeat.o(156771);
  }
  
  public static void fqQ()
  {
    AppMethodBeat.i(195162);
    if (IMU != null)
    {
      Log.i("WCWebUpdater", "tryEmbedInstall");
      HashMap localHashMap = new HashMap();
      localHashMap.put("UpdaterCheckType", "4");
      IMU.a(XWalkEnvironment.getApplicationContext(), localHashMap);
      AppMethodBeat.o(195162);
      return;
    }
    Log.e("WCWebUpdater", "no sWebviewUpdater");
    AppMethodBeat.o(195162);
  }
  
  public static boolean isBusy()
  {
    AppMethodBeat.i(156772);
    boolean bool1;
    if (IMU != null)
    {
      bool1 = IMU.isBusy();
      if (IMV == null) {
        break label62;
      }
    }
    for (boolean bool2 = IMV.isBusy();; bool2 = false)
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
  {
    public abstract void a(Context paramContext, HashMap<String, String> paramHashMap);
    
    public abstract boolean isBusy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.v
 * JD-Core Version:    0.7.0.1
 */