package com.tencent.xweb;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.a.b;
import com.tencent.xweb.internal.j;
import com.tencent.xweb.internal.j.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class b
  extends a
{
  static b KyE;
  
  public static void a(com.tencent.xweb.internal.a.a[] paramArrayOfa, String paramString)
  {
    AppMethodBeat.i(156711);
    fIV().b(paramArrayOfa, paramString, false);
    AppMethodBeat.o(156711);
  }
  
  public static HashMap<String, String> aUF(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(205045);
    try
    {
      paramString = mx("param_".concat(String.valueOf(paramString)), "tools");
      if (paramString != null)
      {
        boolean bool = paramString.isEmpty();
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(205045);
        return null;
      }
      paramString = paramString.split(",");
      if (paramString == null)
      {
        AppMethodBeat.o(205045);
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
      AppMethodBeat.o(205045);
      return localHashMap;
    }
    catch (Exception paramString)
    {
      Log.e("CommandCfgPlugin", "getCmdPluginParam error: ", paramString);
      AppMethodBeat.o(205045);
    }
    return null;
  }
  
  public static f.a aUG(String paramString)
  {
    AppMethodBeat.i(156715);
    paramString = aUH(mx("fr_" + paramString.toLowerCase(), "tools"));
    AppMethodBeat.o(156715);
    return paramString;
  }
  
  public static f.a aUH(String paramString)
  {
    AppMethodBeat.i(156716);
    f.a locala = f.a.KyM;
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(156716);
      return locala;
    }
    try
    {
      paramString = f.a.valueOf(paramString);
      AppMethodBeat.o(156716);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = f.a.KyM;
      }
    }
  }
  
  public static String aUy(String paramString)
  {
    AppMethodBeat.i(156713);
    String str2 = WebView.getCurStrModule();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "tools";
    }
    paramString = mx(paramString, str1);
    AppMethodBeat.o(156713);
    return paramString;
  }
  
  private static b fIV()
  {
    try
    {
      AppMethodBeat.i(156707);
      if (KyE == null)
      {
        localb = new b();
        KyE = localb;
        localb.fIQ();
      }
      b localb = KyE;
      AppMethodBeat.o(156707);
      return localb;
    }
    finally {}
  }
  
  public static void fIW()
  {
    try
    {
      AppMethodBeat.i(161632);
      Log.i("CommandCfgPlugin", "resetCommandCfgPlugin ");
      KyE = null;
      fIV();
      AppMethodBeat.o(161632);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static int fIX()
  {
    AppMethodBeat.i(205042);
    try
    {
      String str = mx("setPluginConfigPeriod", "tools");
      if (str != null)
      {
        boolean bool = str.isEmpty();
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(205042);
        return -1;
      }
      int i = Integer.parseInt(str);
      if (i < 30)
      {
        AppMethodBeat.o(205042);
        return -1;
      }
      AppMethodBeat.o(205042);
      return i * 60 * 1000;
    }
    catch (Exception localException)
    {
      Log.e("CommandCfgPlugin", "getCmdPluginUpdatePeriod error: ", localException);
      AppMethodBeat.o(205042);
    }
    return -1;
  }
  
  public static boolean fIY()
  {
    AppMethodBeat.i(205043);
    try
    {
      String str = mx("download_when_not_install", "tools");
      if (str != null)
      {
        bool = str.isEmpty();
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(205043);
        return false;
      }
      boolean bool = Boolean.parseBoolean(str);
      AppMethodBeat.o(205043);
      return bool;
    }
    catch (Exception localException)
    {
      Log.e("CommandCfgPlugin", "canDownloadWhenNotInstall error: ", localException);
      AppMethodBeat.o(205043);
    }
    return false;
  }
  
  public static boolean fIZ()
  {
    AppMethodBeat.i(205044);
    try
    {
      String str = mx("download_when_x5_fail", "tools");
      if (str != null)
      {
        bool = str.isEmpty();
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(205044);
        return false;
      }
      boolean bool = Boolean.parseBoolean(str);
      AppMethodBeat.o(205044);
      return bool;
    }
    catch (Exception localException)
    {
      Log.e("CommandCfgPlugin", "canDownloadWhenX5Fail error: ", localException);
      AppMethodBeat.o(205044);
    }
    return false;
  }
  
  public static String getAbstractInfo()
  {
    AppMethodBeat.i(156709);
    try
    {
      String str = fIV().fIR();
      AppMethodBeat.o(156709);
      return str;
    }
    catch (Exception localException)
    {
      Log.e("CommandCfgPlugin", "getAbstractInfo error ", localException);
      AppMethodBeat.o(156709);
    }
    return "";
  }
  
  public static String mx(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(156714);
      paramString1 = a(paramString1, paramString2, fIV());
      AppMethodBeat.o(156714);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  protected final void b(com.tencent.xweb.internal.a.a[] paramArrayOfa, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(156712);
    if (paramString == null)
    {
      AppMethodBeat.o(156712);
      return;
    }
    HashMap localHashMap = new HashMap();
    if ((paramArrayOfa == null) || (paramArrayOfa.length == 0))
    {
      S(paramString, localHashMap);
      AppMethodBeat.o(156712);
      return;
    }
    int i = 0;
    while (i < paramArrayOfa.length)
    {
      if ((paramArrayOfa[i] != null) && ((!paramBoolean) || (!aUz(paramArrayOfa[i].KCi))) && (paramArrayOfa[i].KCh.fKi()))
      {
        Object localObject = (a.a)j.g(WebView.c.KzZ).excute("STR_CMD_EXXCUTE_CMD_FROM_CONFIG", new Object[] { paramArrayOfa[i] });
        if (((localObject == null) || (!((a.a)localObject).KyC)) && (paramArrayOfa[i].KCj != null) && (paramArrayOfa[i].KCk != null) && (!paramArrayOfa[i].KCk.isEmpty()))
        {
          localObject = paramArrayOfa[i].KCk.split(",");
          a(paramArrayOfa[i], localHashMap, (String[])localObject);
        }
      }
      i += 1;
    }
    S(paramString, localHashMap);
    AppMethodBeat.o(156712);
  }
  
  public final SharedPreferences fIP()
  {
    AppMethodBeat.i(156708);
    SharedPreferences localSharedPreferences = XWalkEnvironment.getMMKVSharedPreferences("XWEB.CMDCFG.PLUGIN");
    AppMethodBeat.o(156708);
    return localSharedPreferences;
  }
  
  public final String fIR()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156710);
        StringBuilder localStringBuilder = new StringBuilder(512);
        Object localObject1 = this.KyA.keySet();
        if (localObject1 == null)
        {
          localObject1 = "";
          AppMethodBeat.o(156710);
          return localObject1;
        }
        Iterator localIterator = ((Set)localObject1).iterator();
        if (localIterator.hasNext())
        {
          String str3 = (String)localIterator.next();
          if (TextUtils.isEmpty(str3)) {
            continue;
          }
          String str2 = bY(aUs(str3));
          localObject1 = str2;
          if (str2 == null) {
            localObject1 = "";
          }
          localStringBuilder.append(" ");
          localStringBuilder.append(str3);
          localStringBuilder.append(" : ");
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("\n");
          continue;
        }
        String str1 = localStringBuilder.toString();
      }
      finally {}
      AppMethodBeat.o(156710);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.b
 * JD-Core Version:    0.7.0.1
 */