package com.tencent.xweb;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.WebViewWrapperFactory;
import com.tencent.xweb.internal.WebViewWrapperFactory.IWebViewProvider;
import com.tencent.xweb.internal.b.b;
import com.tencent.xweb.internal.b.d;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkSharedPreferenceUtil;

public final class b
  extends a
{
  private static b aiel;
  
  public static h.c bHo(String paramString)
  {
    AppMethodBeat.i(212378);
    h.c localc = h.c.aiey;
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(212378);
      return localc;
    }
    try
    {
      paramString = h.c.valueOf(paramString);
      AppMethodBeat.o(212378);
      return paramString;
    }
    finally
    {
      for (;;)
      {
        paramString = h.c.aiey;
      }
    }
  }
  
  public static h.a bHp(String paramString)
  {
    AppMethodBeat.i(212380);
    h.a locala = h.a.aiet;
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(212380);
      return locala;
    }
    try
    {
      paramString = h.a.valueOf(paramString);
      AppMethodBeat.o(212380);
      return paramString;
    }
    finally
    {
      for (;;)
      {
        paramString = h.a.aiet;
      }
    }
  }
  
  public static b kfi()
  {
    try
    {
      AppMethodBeat.i(212374);
      if (aiel == null)
      {
        localb = new b();
        aiel = localb;
        localb.kfb();
      }
      b localb = aiel;
      AppMethodBeat.o(212374);
      return localb;
    }
    finally {}
  }
  
  public static void kfj()
  {
    try
    {
      AppMethodBeat.i(161632);
      Log.i("CommandCfgPlugin", "resetCommandCfg, module: " + XWalkEnvironment.getModuleName());
      aiel = null;
      kfi();
      AppMethodBeat.o(161632);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static String kfn()
  {
    AppMethodBeat.i(212381);
    if ("appbrand".equalsIgnoreCase(XWalkEnvironment.getSafeModuleName("tools")))
    {
      Log.i("CommandCfgPlugin", "getSafeModuleForFileReader, use module appbrand");
      AppMethodBeat.o(212381);
      return "appbrand";
    }
    Log.i("CommandCfgPlugin", "getSafeModuleForFileReader, use module tools");
    AppMethodBeat.o(212381);
    return "tools";
  }
  
  protected final void b(b.b[] paramArrayOfb, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(212394);
    if (paramString == null)
    {
      Log.i("CommandCfgPlugin", "applyCommandInternal, invalid configVersion");
      AppMethodBeat.o(212394);
      return;
    }
    Log.i("CommandCfgPlugin", "applyCommandInternal, configVersion:" + paramString + ", isRecheck:" + paramBoolean);
    kfc();
    HashMap localHashMap = new HashMap();
    if ((paramArrayOfb == null) || (paramArrayOfb.length == 0))
    {
      Log.w("CommandCfgPlugin", "applyCommandInternal, empty new command configs");
      an(paramString, localHashMap);
      AppMethodBeat.o(212394);
      return;
    }
    int i = 0;
    if (i < paramArrayOfb.length)
    {
      Object localObject;
      if ((paramArrayOfb[i] != null) && ((!paramBoolean) || (!bHd(paramArrayOfb[i].aiiR))) && (paramArrayOfb[i].aiiB.g(false, false, "CommandCfgPlugin")))
      {
        localObject = WebViewWrapperFactory.khn();
        if (localObject == null) {
          break label231;
        }
        localObject = (a.a)((WebViewWrapperFactory.IWebViewProvider)localObject).excute("STR_CMD_EXXCUTE_CMD_FROM_CONFIG", new Object[] { paramArrayOfb[i] });
        if ((localObject == null) || (!((a.a)localObject).aiej)) {
          break label231;
        }
        Log.i("CommandCfgPlugin", "applyCommandInternal, command(" + paramArrayOfb[i] + ") handled");
      }
      for (;;)
      {
        i += 1;
        break;
        label231:
        if ((paramArrayOfb[i].aiiS != null) && (paramArrayOfb[i].aiiT != null) && (!paramArrayOfb[i].aiiT.isEmpty()))
        {
          localObject = paramArrayOfb[i].aiiT.split(",");
          a(paramArrayOfb[i], localHashMap, (String[])localObject);
        }
      }
    }
    an(paramString, localHashMap);
    AppMethodBeat.o(212394);
  }
  
  public final HashMap<String, String> bHn(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(212408);
    try
    {
      paramString = qM("param_".concat(String.valueOf(paramString)), "tools");
      if (paramString != null)
      {
        boolean bool = paramString.isEmpty();
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(212408);
        return null;
      }
      paramString = paramString.split(",");
      if (paramString == null)
      {
        AppMethodBeat.o(212408);
        return null;
      }
      HashMap localHashMap = new HashMap();
      int j = paramString.length;
      while (i < j)
      {
        String[] arrayOfString = paramString[i];
        if ((arrayOfString != null) && (!arrayOfString.isEmpty()))
        {
          arrayOfString = arrayOfString.split("_");
          if ((arrayOfString != null) && (arrayOfString.length == 2)) {
            localHashMap.put(arrayOfString[0], arrayOfString[1]);
          }
        }
        i += 1;
      }
      AppMethodBeat.o(212408);
      return localHashMap;
    }
    finally
    {
      Log.e("CommandCfgPlugin", "getCmdPluginParam error:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(212408);
    }
    return null;
  }
  
  protected final String getLogTag()
  {
    return "CommandCfgPlugin";
  }
  
  public final SharedPreferences keZ()
  {
    AppMethodBeat.i(212386);
    SharedPreferences localSharedPreferences = XWalkSharedPreferenceUtil.getMMKVSharedPreferencesForCommandCfgPlugin();
    AppMethodBeat.o(212386);
    return localSharedPreferences;
  }
  
  public final SharedPreferences kfa()
  {
    AppMethodBeat.i(212388);
    SharedPreferences localSharedPreferences = XWalkSharedPreferenceUtil.getMMKVSharedPreferencesForCommandCfgPluginLatest();
    AppMethodBeat.o(212388);
    return localSharedPreferences;
  }
  
  public final int kfk()
  {
    AppMethodBeat.i(212397);
    try
    {
      String str = qM("setPluginConfigPeriod", "tools");
      if (str != null)
      {
        boolean bool = str.isEmpty();
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(212397);
        return -1;
      }
      int i = Integer.parseInt(str);
      if (i < 30)
      {
        AppMethodBeat.o(212397);
        return -1;
      }
      AppMethodBeat.o(212397);
      return i * 60 * 1000;
    }
    finally
    {
      Log.e("CommandCfgPlugin", "getCmdPluginUpdatePeriod error:".concat(String.valueOf(localObject)));
      AppMethodBeat.o(212397);
    }
    return -1;
  }
  
  public final boolean kfl()
  {
    AppMethodBeat.i(212399);
    try
    {
      String str = qM("download_when_not_install", kfn());
      if (str != null)
      {
        bool = str.isEmpty();
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(212399);
        return false;
      }
      boolean bool = Boolean.parseBoolean(str);
      AppMethodBeat.o(212399);
      return bool;
    }
    finally
    {
      Log.e("CommandCfgPlugin", "canDownloadWhenNotInstall error:".concat(String.valueOf(localObject)));
      AppMethodBeat.o(212399);
    }
    return false;
  }
  
  public final boolean kfm()
  {
    AppMethodBeat.i(212401);
    try
    {
      String str = qM("download_when_x5_fail", kfn());
      if (str != null)
      {
        bool = str.isEmpty();
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(212401);
        return false;
      }
      boolean bool = Boolean.parseBoolean(str);
      AppMethodBeat.o(212401);
      return bool;
    }
    finally
    {
      Log.e("CommandCfgPlugin", "canDownloadWhenX5Fail error:".concat(String.valueOf(localObject)));
      AppMethodBeat.o(212401);
    }
    return false;
  }
  
  public final h.c qO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212414);
    paramString1 = bHo(qM("use_office_reader_" + paramString1.toLowerCase(), paramString2));
    AppMethodBeat.o(212414);
    return paramString1;
  }
  
  public final h.a qP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212418);
    paramString1 = bHp(qM("fr_" + paramString1.toLowerCase(), paramString2));
    AppMethodBeat.o(212418);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.b
 * JD-Core Version:    0.7.0.1
 */