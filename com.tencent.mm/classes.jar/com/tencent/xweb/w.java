package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.internal.l.a;
import com.tencent.xweb.util.h;
import com.tencent.xweb.xwalk.a.j;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class w
{
  static b SzM;
  static a SzN;
  
  static
  {
    AppMethodBeat.i(156773);
    l.a locala = l.g(WebView.c.SAt);
    SzM = (b)locala.excute("STR_CMD_GET_UPDATER", null);
    SzN = (a)locala.excute("STR_CMD_GET_PLUGIN_UPDATER", null);
    AppMethodBeat.o(156773);
  }
  
  public static void b(Context paramContext, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(156769);
    for (;;)
    {
      try
      {
        h.huE();
        if (SzM != null)
        {
          Log.i("WCWebUpdater", "start check runtime update");
          SzM.b(paramContext, paramHashMap);
          if (SzN != null)
          {
            h.hux();
            SzN.b(paramContext, paramHashMap);
          }
        }
        else
        {
          Log.e("WCWebUpdater", "no sWebviewUpdater");
          continue;
        }
        Log.e("WCWebUpdater", "no sPluginUpdater");
      }
      finally
      {
        AppMethodBeat.o(156769);
      }
    }
  }
  
  public static void hsB()
  {
    AppMethodBeat.i(156770);
    if (SzM != null)
    {
      Log.i("WCWebUpdater", "start check runtime update");
      HashMap localHashMap = new HashMap();
      localHashMap.put("UpdaterCheckType", "2");
      SzM.b(XWalkEnvironment.getApplicationContext(), localHashMap);
      AppMethodBeat.o(156770);
      return;
    }
    Log.e("WCWebUpdater", "no sWebviewUpdater");
    AppMethodBeat.o(156770);
  }
  
  public static void hsC()
  {
    AppMethodBeat.i(156771);
    if (SzM != null)
    {
      Log.i("WCWebUpdater", "start check runtime update");
      new HashMap().put("UpdaterCheckType", "3");
      SzM.b(XWalkEnvironment.getApplicationContext(), null);
      AppMethodBeat.o(156771);
      return;
    }
    Log.e("WCWebUpdater", "no sWebviewUpdater");
    AppMethodBeat.o(156771);
  }
  
  public static void hsD()
  {
    AppMethodBeat.i(219045);
    if (SzM != null)
    {
      Log.i("WCWebUpdater", "tryEmbedInstall");
      HashMap localHashMap = new HashMap();
      localHashMap.put("UpdaterCheckType", "4");
      SzM.b(XWalkEnvironment.getApplicationContext(), localHashMap);
      AppMethodBeat.o(219045);
      return;
    }
    Log.e("WCWebUpdater", "no sWebviewUpdater");
    AppMethodBeat.o(219045);
  }
  
  public static boolean isBusy()
  {
    AppMethodBeat.i(156772);
    boolean bool1;
    if (SzM != null)
    {
      bool1 = SzM.isBusy();
      if (SzN == null) {
        break label62;
      }
    }
    for (boolean bool2 = SzN.isBusy();; bool2 = false)
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
    public abstract void a(String paramString, j paramj);
    
    public abstract void hsE();
  }
  
  public static abstract interface b
  {
    public abstract void b(Context paramContext, HashMap<String, String> paramHashMap);
    
    public abstract boolean isBusy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.w
 * JD-Core Version:    0.7.0.1
 */