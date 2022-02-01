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
  static b ZZC;
  
  public static void a(com.tencent.xweb.internal.a.a[] paramArrayOfa, String paramString)
  {
    AppMethodBeat.i(156711);
    ivR().b(paramArrayOfa, paramString, false);
    AppMethodBeat.o(156711);
  }
  
  public static String bEI(String paramString)
  {
    AppMethodBeat.i(156713);
    String str2 = WebView.getCurStrModule();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "tools";
    }
    paramString = oO(paramString, str1);
    AppMethodBeat.o(156713);
    return paramString;
  }
  
  public static HashMap<String, String> bEP(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(196929);
    try
    {
      paramString = oO("param_".concat(String.valueOf(paramString)), "tools");
      if (paramString != null)
      {
        boolean bool = paramString.isEmpty();
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(196929);
        return null;
      }
      paramString = paramString.split(",");
      if (paramString == null)
      {
        AppMethodBeat.o(196929);
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
      AppMethodBeat.o(196929);
      return localHashMap;
    }
    catch (Exception paramString)
    {
      Log.e("CommandCfgPlugin", "getCmdPluginParam error: ", paramString);
      AppMethodBeat.o(196929);
    }
    return null;
  }
  
  public static f.c bEQ(String paramString)
  {
    AppMethodBeat.i(196933);
    paramString = oR(paramString, XWalkEnvironment.getSafeModuleForCommand("tools"));
    AppMethodBeat.o(196933);
    return paramString;
  }
  
  public static f.c bER(String paramString)
  {
    AppMethodBeat.i(196937);
    f.c localc = f.c.ZZP;
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(196937);
      return localc;
    }
    try
    {
      paramString = f.c.valueOf(paramString);
      AppMethodBeat.o(196937);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = f.c.ZZP;
      }
    }
  }
  
  public static f.a bES(String paramString)
  {
    AppMethodBeat.i(156715);
    paramString = oS(paramString, ivW());
    AppMethodBeat.o(156715);
    return paramString;
  }
  
  public static f.a bET(String paramString)
  {
    AppMethodBeat.i(156716);
    f.a locala = f.a.ZZK;
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
        paramString = f.a.ZZK;
      }
    }
  }
  
  public static String getAbstractInfo()
  {
    AppMethodBeat.i(156709);
    try
    {
      String str = ivR().ivN();
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
  
  private static b ivR()
  {
    try
    {
      AppMethodBeat.i(156707);
      if (ZZC == null)
      {
        localb = new b();
        ZZC = localb;
        localb.ivM();
      }
      b localb = ZZC;
      AppMethodBeat.o(156707);
      return localb;
    }
    finally {}
  }
  
  public static void ivS()
  {
    try
    {
      AppMethodBeat.i(161632);
      Log.i("CommandCfgPlugin", "resetCommandCfgPlugin ");
      ZZC = null;
      ivR();
      AppMethodBeat.o(161632);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static int ivT()
  {
    AppMethodBeat.i(196911);
    try
    {
      String str = oO("setPluginConfigPeriod", "tools");
      if (str != null)
      {
        boolean bool = str.isEmpty();
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(196911);
        return -1;
      }
      int i = Integer.parseInt(str);
      if (i < 30)
      {
        AppMethodBeat.o(196911);
        return -1;
      }
      AppMethodBeat.o(196911);
      return i * 60 * 1000;
    }
    catch (Exception localException)
    {
      Log.e("CommandCfgPlugin", "getCmdPluginUpdatePeriod error: ", localException);
      AppMethodBeat.o(196911);
    }
    return -1;
  }
  
  public static boolean ivU()
  {
    AppMethodBeat.i(196913);
    try
    {
      String str = oO("download_when_not_install", ivW());
      if (str != null)
      {
        bool = str.isEmpty();
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(196913);
        return false;
      }
      boolean bool = Boolean.parseBoolean(str);
      AppMethodBeat.o(196913);
      return bool;
    }
    catch (Exception localException)
    {
      Log.e("CommandCfgPlugin", "canDownloadWhenNotInstall error: ", localException);
      AppMethodBeat.o(196913);
    }
    return false;
  }
  
  public static boolean ivV()
  {
    AppMethodBeat.i(196918);
    try
    {
      String str = oO("download_when_x5_fail", ivW());
      if (str != null)
      {
        bool = str.isEmpty();
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(196918);
        return false;
      }
      boolean bool = Boolean.parseBoolean(str);
      AppMethodBeat.o(196918);
      return bool;
    }
    catch (Exception localException)
    {
      Log.e("CommandCfgPlugin", "canDownloadWhenX5Fail error: ", localException);
      AppMethodBeat.o(196918);
    }
    return false;
  }
  
  private static String ivW()
  {
    AppMethodBeat.i(196941);
    if ("appbrand".equalsIgnoreCase(XWalkEnvironment.getSafeModuleForCommand("tools")))
    {
      Log.i("CommandCfgPlugin", "getSafeModuleForFileReader use module appbrand");
      AppMethodBeat.o(196941);
      return "appbrand";
    }
    Log.i("CommandCfgPlugin", "getSafeModuleForFileReader use module tools");
    AppMethodBeat.o(196941);
    return "tools";
  }
  
  public static String oO(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(156714);
      paramString1 = ivR().oQ(paramString1, paramString2);
      AppMethodBeat.o(156714);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static f.c oR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(196931);
    paramString1 = bER(oO("use_office_reader_" + paramString1.toLowerCase(), paramString2));
    AppMethodBeat.o(196931);
    return paramString1;
  }
  
  public static f.a oS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(196940);
    paramString1 = bET(oO("fr_" + paramString1.toLowerCase(), paramString2));
    AppMethodBeat.o(196940);
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
      af(paramString, localHashMap);
      AppMethodBeat.o(156712);
      return;
    }
    int i = 0;
    while (i < paramArrayOfa.length)
    {
      if ((paramArrayOfa[i] != null) && ((!paramBoolean) || (!bEJ(paramArrayOfa[i].aadP))) && (paramArrayOfa[i].aadO.ixf()))
      {
        Object localObject = (a.a)l.h(WebView.c.aabm).excute("STR_CMD_EXXCUTE_CMD_FROM_CONFIG", new Object[] { paramArrayOfa[i] });
        if (((localObject == null) || (!((a.a)localObject).ZZA)) && (paramArrayOfa[i].aadQ != null) && (paramArrayOfa[i].aadR != null) && (!paramArrayOfa[i].aadR.isEmpty()))
        {
          localObject = paramArrayOfa[i].aadR.split(",");
          a(paramArrayOfa[i], localHashMap, (String[])localObject);
        }
      }
      i += 1;
    }
    af(paramString, localHashMap);
    AppMethodBeat.o(156712);
  }
  
  public final SharedPreferences ivL()
  {
    AppMethodBeat.i(156708);
    SharedPreferences localSharedPreferences = XWalkEnvironment.getMMKVSharedPreferences("XWEB.CMDCFG.PLUGIN");
    AppMethodBeat.o(156708);
    return localSharedPreferences;
  }
  
  public final String ivN()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156710);
        StringBuilder localStringBuilder = new StringBuilder(512);
        Object localObject1 = this.ZZy.keySet();
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
          String str2 = cy(bEB(str3));
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