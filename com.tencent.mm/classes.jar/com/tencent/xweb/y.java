package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.WebViewWrapperFactory;
import com.tencent.xweb.internal.WebViewWrapperFactory.IWebViewProvider;
import com.tencent.xweb.util.l;
import com.tencent.xweb.xwalk.a.k;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkGrayValueUtil;

public class y
{
  private static b aieZ;
  private static a aifa;
  
  static
  {
    AppMethodBeat.i(156773);
    WebViewWrapperFactory.IWebViewProvider localIWebViewProvider = WebViewWrapperFactory.khn();
    if (localIWebViewProvider != null)
    {
      aieZ = (b)localIWebViewProvider.excute("STR_CMD_GET_UPDATER", null);
      aifa = (a)localIWebViewProvider.excute("STR_CMD_GET_PLUGIN_UPDATER", null);
    }
    AppMethodBeat.o(156773);
  }
  
  @Deprecated
  public static void b(Context paramContext, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(156769);
    for (;;)
    {
      try
      {
        if (aieZ != null)
        {
          l.kiF();
          Log.i("WCWebUpdater", "startCheck, start check runtime update");
          aieZ.b(paramContext, paramHashMap);
          if (aifa == null) {
            break label144;
          }
          l.kiy();
          if (XWalkGrayValueUtil.hasUin())
          {
            Log.i("WCWebUpdater", "startCheck, start check plugin update");
            aifa.a("", null);
            aifa.b(paramContext, paramHashMap);
          }
        }
        else
        {
          Log.w("WCWebUpdater", "startCheck, no sWebviewUpdater");
          continue;
        }
        Log.i("WCWebUpdater", "startCheck, start check update for plugin fullscreen_video_js");
      }
      finally
      {
        AppMethodBeat.o(156769);
      }
      aifa.a("FullScreenVideo", new k()
      {
        public final void aJu(int paramAnonymousInt) {}
        
        public final void aJv(int paramAnonymousInt) {}
        
        public final void kfs() {}
      });
      aifa.b(paramContext, paramHashMap);
      continue;
      label144:
      Log.w("WCWebUpdater", "startCheck, no sPluginUpdater");
    }
  }
  
  @Deprecated
  public static boolean isBusy()
  {
    AppMethodBeat.i(156772);
    boolean bool1;
    if (aieZ != null)
    {
      bool1 = aieZ.isBusy();
      if (aifa == null) {
        break label62;
      }
    }
    for (boolean bool2 = aifa.isBusy();; bool2 = false)
    {
      if ((!bool1) && (!bool2)) {
        break label74;
      }
      AppMethodBeat.o(156772);
      return true;
      Log.w("WCWebUpdater", "isBusy, no sWebviewUpdater");
      bool1 = false;
      break;
      label62:
      Log.w("WCWebUpdater", "isBusy, no sPluginUpdater");
    }
    label74:
    AppMethodBeat.o(156772);
    return false;
  }
  
  @Deprecated
  public static boolean kfA()
  {
    AppMethodBeat.i(212410);
    try
    {
      if ((aieZ != null) && (aieZ.kfC()))
      {
        Log.i("WCWebUpdater", "needCheckUpdate, sWebviewUpdater ret true");
        return true;
      }
      Log.w("WCWebUpdater", "needCheckUpdate, sWebviewUpdater ret false");
      if ((aifa != null) && (aifa.kfC()))
      {
        Log.i("WCWebUpdater", "needCheckUpdate, sPluginUpdater ret true");
        return true;
      }
      Log.w("WCWebUpdater", "needCheckUpdate, sPluginUpdater ret false");
      return false;
    }
    finally
    {
      AppMethodBeat.o(212410);
    }
  }
  
  public static void kfx()
  {
    AppMethodBeat.i(212395);
    if (aieZ != null)
    {
      Log.i("WCWebUpdater", "tryEmbedInstall, start check runtime update");
      HashMap localHashMap = new HashMap();
      localHashMap.put("UpdaterCheckType", "4");
      aieZ.b(XWalkEnvironment.getApplicationContext(), localHashMap);
      AppMethodBeat.o(212395);
      return;
    }
    Log.w("WCWebUpdater", "tryEmbedInstall, no sWebviewUpdater");
    AppMethodBeat.o(212395);
  }
  
  @Deprecated
  public static void kfy()
  {
    AppMethodBeat.i(156770);
    if (aieZ != null)
    {
      Log.i("WCWebUpdater", "checkNeedDownload, start check runtime update");
      HashMap localHashMap = new HashMap();
      localHashMap.put("UpdaterCheckType", "2");
      aieZ.b(XWalkEnvironment.getApplicationContext(), localHashMap);
      AppMethodBeat.o(156770);
      return;
    }
    Log.w("WCWebUpdater", "checkNeedDownload, no sWebviewUpdater");
    AppMethodBeat.o(156770);
  }
  
  @Deprecated
  public static void kfz()
  {
    AppMethodBeat.i(156771);
    if (aieZ != null)
    {
      Log.i("WCWebUpdater", "tryStartDownload, start check runtime update");
      aieZ.b(XWalkEnvironment.getApplicationContext(), null);
      AppMethodBeat.o(156771);
      return;
    }
    Log.w("WCWebUpdater", "tryStartDownload, no sWebviewUpdater");
    AppMethodBeat.o(156771);
  }
  
  public static abstract interface a
    extends y.b
  {
    public abstract void a(String paramString, k paramk);
    
    public abstract void kfB();
  }
  
  public static abstract interface b
  {
    public abstract void b(Context paramContext, HashMap<String, String> paramHashMap);
    
    public abstract boolean isBusy();
    
    public abstract boolean kfC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.y
 * JD-Core Version:    0.7.0.1
 */