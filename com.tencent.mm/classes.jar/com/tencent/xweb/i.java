package com.tencent.xweb;

import android.content.Context;
import com.tencent.xweb.c.j;
import com.tencent.xweb.c.j.a;
import com.tencent.xweb.util.e;
import java.util.HashMap;
import org.xwalk.core.Log;

public final class i
{
  static i.a xgG;
  static i.a xgH;
  
  static
  {
    j.a locala = j.c(WebView.d.xho);
    xgG = (i.a)locala.excute("STR_CMD_GET_UPDATER", null);
    xgH = (i.a)locala.excute("STR_CMD_GET_PLUGIN_UPDATER", null);
  }
  
  public static void a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    
    if (xgG != null)
    {
      Log.i("WCWebUpdater", "start check runtime update");
      xgG.a(paramContext, paramHashMap);
    }
    while (xgH != null)
    {
      e.cTk();
      xgH.a(paramContext, paramHashMap);
      return;
      Log.e("WCWebUpdater", "no sWebviewUpdater");
    }
    Log.e("WCWebUpdater", "no sPluginUpdater");
  }
  
  public static boolean isBusy()
  {
    boolean bool3 = false;
    boolean bool1;
    if (xgG != null)
    {
      bool1 = xgG.isBusy();
      if (xgH == null) {
        break label58;
      }
    }
    for (boolean bool2 = xgH.isBusy();; bool2 = false)
    {
      if (!bool1)
      {
        bool1 = bool3;
        if (!bool2) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
      Log.e("WCWebUpdater", "check is busy : no sWebviewUpdater");
      bool1 = false;
      break;
      label58:
      Log.e("WCWebUpdater", "check is busy : no sPluginUpdater");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.i
 * JD-Core Version:    0.7.0.1
 */