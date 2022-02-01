package com.tencent.xweb;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.a.b;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.internal.l.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class b
  extends a
{
  static b SyL;
  
  public static void a(com.tencent.xweb.internal.a.a[] paramArrayOfa, String paramString)
  {
    AppMethodBeat.i(156711);
    hsj().b(paramArrayOfa, paramString, false);
    AppMethodBeat.o(156711);
  }
  
  public static String brJ(String paramString)
  {
    AppMethodBeat.i(156713);
    String str2 = WebView.getCurStrModule();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "tools";
    }
    paramString = nS(paramString, str1);
    AppMethodBeat.o(156713);
    return paramString;
  }
  
  public static HashMap<String, String> brQ(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(218993);
    try
    {
      paramString = nS("param_".concat(String.valueOf(paramString)), "tools");
      if (paramString != null)
      {
        boolean bool = paramString.isEmpty();
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(218993);
        return null;
      }
      paramString = paramString.split(",");
      if (paramString == null)
      {
        AppMethodBeat.o(218993);
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
      AppMethodBeat.o(218993);
      return localHashMap;
    }
    catch (Exception paramString)
    {
      Log.e("CommandCfgPlugin", "getCmdPluginParam error: ", paramString);
      AppMethodBeat.o(218993);
    }
    return null;
  }
  
  public static f.c brR(String paramString)
  {
    AppMethodBeat.i(218995);
    paramString = nV(paramString, XWalkEnvironment.getSafeModuleForCommand("tools"));
    AppMethodBeat.o(218995);
    return paramString;
  }
  
  public static f.c brS(String paramString)
  {
    AppMethodBeat.i(218996);
    f.c localc = f.c.SyY;
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(218996);
      return localc;
    }
    try
    {
      paramString = f.c.valueOf(paramString);
      AppMethodBeat.o(218996);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = f.c.SyY;
      }
    }
  }
  
  public static f.a brT(String paramString)
  {
    AppMethodBeat.i(156715);
    paramString = nW(paramString, hso());
    AppMethodBeat.o(156715);
    return paramString;
  }
  
  public static f.a brU(String paramString)
  {
    AppMethodBeat.i(156716);
    f.a locala = f.a.SyT;
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
        paramString = f.a.SyT;
      }
    }
  }
  
  public static String getAbstractInfo()
  {
    AppMethodBeat.i(156709);
    try
    {
      String str = hsj().hsf();
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
  
  private static b hsj()
  {
    try
    {
      AppMethodBeat.i(156707);
      if (SyL == null)
      {
        localb = new b();
        SyL = localb;
        localb.hse();
      }
      b localb = SyL;
      AppMethodBeat.o(156707);
      return localb;
    }
    finally {}
  }
  
  public static void hsk()
  {
    try
    {
      AppMethodBeat.i(161632);
      Log.i("CommandCfgPlugin", "resetCommandCfgPlugin ");
      SyL = null;
      hsj();
      AppMethodBeat.o(161632);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static int hsl()
  {
    AppMethodBeat.i(218990);
    try
    {
      String str = nS("setPluginConfigPeriod", "tools");
      if (str != null)
      {
        boolean bool = str.isEmpty();
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(218990);
        return -1;
      }
      int i = Integer.parseInt(str);
      if (i < 30)
      {
        AppMethodBeat.o(218990);
        return -1;
      }
      AppMethodBeat.o(218990);
      return i * 60 * 1000;
    }
    catch (Exception localException)
    {
      Log.e("CommandCfgPlugin", "getCmdPluginUpdatePeriod error: ", localException);
      AppMethodBeat.o(218990);
    }
    return -1;
  }
  
  public static boolean hsm()
  {
    AppMethodBeat.i(218991);
    try
    {
      String str = nS("download_when_not_install", hso());
      if (str != null)
      {
        bool = str.isEmpty();
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(218991);
        return false;
      }
      boolean bool = Boolean.parseBoolean(str);
      AppMethodBeat.o(218991);
      return bool;
    }
    catch (Exception localException)
    {
      Log.e("CommandCfgPlugin", "canDownloadWhenNotInstall error: ", localException);
      AppMethodBeat.o(218991);
    }
    return false;
  }
  
  public static boolean hsn()
  {
    AppMethodBeat.i(218992);
    try
    {
      String str = nS("download_when_x5_fail", hso());
      if (str != null)
      {
        bool = str.isEmpty();
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(218992);
        return false;
      }
      boolean bool = Boolean.parseBoolean(str);
      AppMethodBeat.o(218992);
      return bool;
    }
    catch (Exception localException)
    {
      Log.e("CommandCfgPlugin", "canDownloadWhenX5Fail error: ", localException);
      AppMethodBeat.o(218992);
    }
    return false;
  }
  
  private static String hso()
  {
    AppMethodBeat.i(218998);
    if ("appbrand".equalsIgnoreCase(XWalkEnvironment.getSafeModuleForCommand("tools")))
    {
      Log.i("CommandCfgPlugin", "getSafeModuleForFileReader use module appbrand");
      AppMethodBeat.o(218998);
      return "appbrand";
    }
    Log.i("CommandCfgPlugin", "getSafeModuleForFileReader use module tools");
    AppMethodBeat.o(218998);
    return "tools";
  }
  
  public static String nS(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(156714);
      paramString1 = hsj().nU(paramString1, paramString2);
      AppMethodBeat.o(156714);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static f.c nV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(218994);
    paramString1 = brS(nS("use_office_reader_" + paramString1.toLowerCase(), paramString2));
    AppMethodBeat.o(218994);
    return paramString1;
  }
  
  public static f.a nW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(218997);
    paramString1 = brU(nS("fr_" + paramString1.toLowerCase(), paramString2));
    AppMethodBeat.o(218997);
    return paramString1;
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
      ac(paramString, localHashMap);
      AppMethodBeat.o(156712);
      return;
    }
    int i = 0;
    while (i < paramArrayOfa.length)
    {
      if ((paramArrayOfa[i] != null) && ((!paramBoolean) || (!brK(paramArrayOfa[i].SCF))) && (paramArrayOfa[i].SCE.htw()))
      {
        Object localObject = (a.a)l.g(WebView.c.SAt).excute("STR_CMD_EXXCUTE_CMD_FROM_CONFIG", new Object[] { paramArrayOfa[i] });
        if (((localObject == null) || (!((a.a)localObject).SyJ)) && (paramArrayOfa[i].SCG != null) && (paramArrayOfa[i].SCH != null) && (!paramArrayOfa[i].SCH.isEmpty()))
        {
          localObject = paramArrayOfa[i].SCH.split(",");
          a(paramArrayOfa[i], localHashMap, (String[])localObject);
        }
      }
      i += 1;
    }
    ac(paramString, localHashMap);
    AppMethodBeat.o(156712);
  }
  
  public final SharedPreferences hsd()
  {
    AppMethodBeat.i(156708);
    SharedPreferences localSharedPreferences = XWalkEnvironment.getMMKVSharedPreferences("XWEB.CMDCFG.PLUGIN");
    AppMethodBeat.o(156708);
    return localSharedPreferences;
  }
  
  public final String hsf()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156710);
        StringBuilder localStringBuilder = new StringBuilder(512);
        Object localObject1 = this.SyH.keySet();
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
          String str2 = cs(brD(str3));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.b
 * JD-Core Version:    0.7.0.1
 */