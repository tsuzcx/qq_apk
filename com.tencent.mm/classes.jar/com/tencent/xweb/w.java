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
  static b aaaD;
  static a aaaE;
  
  static
  {
    AppMethodBeat.i(156773);
    l.a locala = l.h(WebView.c.aabm);
    aaaD = (b)locala.excute("STR_CMD_GET_UPDATER", null);
    aaaE = (a)locala.excute("STR_CMD_GET_PLUGIN_UPDATER", null);
    AppMethodBeat.o(156773);
  }
  
  public static void b(Context paramContext, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(156769);
    for (;;)
    {
      try
      {
        h.iyr();
        if (aaaD != null)
        {
          Log.i("WCWebUpdater", "start check runtime update");
          aaaD.b(paramContext, paramHashMap);
          if (aaaE != null)
          {
            h.iyk();
            aaaE.b(paramContext, paramHashMap);
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
  
  public static boolean isBusy()
  {
    AppMethodBeat.i(156772);
    boolean bool1;
    if (aaaD != null)
    {
      bool1 = aaaD.isBusy();
      if (aaaE == null) {
        break label62;
      }
    }
    for (boolean bool2 = aaaE.isBusy();; bool2 = false)
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
  
  public static void iwj()
  {
    AppMethodBeat.i(156770);
    if (aaaD != null)
    {
      Log.i("WCWebUpdater", "start check runtime update");
      HashMap localHashMap = new HashMap();
      localHashMap.put("UpdaterCheckType", "2");
      aaaD.b(XWalkEnvironment.getApplicationContext(), localHashMap);
      AppMethodBeat.o(156770);
      return;
    }
    Log.e("WCWebUpdater", "no sWebviewUpdater");
    AppMethodBeat.o(156770);
  }
  
  public static void iwk()
  {
    AppMethodBeat.i(156771);
    if (aaaD != null)
    {
      Log.i("WCWebUpdater", "start check runtime update");
      new HashMap().put("UpdaterCheckType", "3");
      aaaD.b(XWalkEnvironment.getApplicationContext(), null);
      AppMethodBeat.o(156771);
      return;
    }
    Log.e("WCWebUpdater", "no sWebviewUpdater");
    AppMethodBeat.o(156771);
  }
  
  public static void iwl()
  {
    AppMethodBeat.i(197193);
    if (aaaD != null)
    {
      Log.i("WCWebUpdater", "tryEmbedInstall");
      HashMap localHashMap = new HashMap();
      localHashMap.put("UpdaterCheckType", "4");
      aaaD.b(XWalkEnvironment.getApplicationContext(), localHashMap);
      AppMethodBeat.o(197193);
      return;
    }
    Log.e("WCWebUpdater", "no sWebviewUpdater");
    AppMethodBeat.o(197193);
  }
  
  public static boolean iwm()
  {
    AppMethodBeat.i(197199);
    try
    {
      if (aaaD != null)
      {
        if (aaaD.iwo())
        {
          Log.i("WCWebUpdater", "needCheckUpdate sWebviewUpdater ret true");
          return true;
        }
        Log.i("WCWebUpdater", "needCheckUpdate sWebviewUpdater ret false");
      }
      if ((aaaE != null) && (aaaE.iwo()))
      {
        Log.i("WCWebUpdater", "needCheckUpdate sPluginUpdater ret true");
        return true;
      }
      Log.i("WCWebUpdater", "needCheckUpdate sPluginUpdater ret false");
      return false;
    }
    finally
    {
      AppMethodBeat.o(197199);
    }
  }
  
  public static abstract interface a
    extends w.b
  {
    public abstract void a(String paramString, j paramj);
    
    public abstract void iwn();
  }
  
  public static abstract interface b
  {
    public abstract void b(Context paramContext, HashMap<String, String> paramHashMap);
    
    public abstract boolean isBusy();
    
    public abstract boolean iwo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.w
 * JD-Core Version:    0.7.0.1
 */