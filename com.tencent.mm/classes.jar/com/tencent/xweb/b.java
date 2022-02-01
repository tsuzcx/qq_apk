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
  static b IMl;
  
  public static void a(com.tencent.xweb.internal.a.a[] paramArrayOfa, String paramString)
  {
    AppMethodBeat.i(156711);
    fqA().b(paramArrayOfa, paramString, false);
    AppMethodBeat.o(156711);
  }
  
  public static String aOM(String paramString)
  {
    AppMethodBeat.i(156713);
    String str2 = WebView.getCurStrModule();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "tools";
    }
    paramString = lW(paramString, str1);
    AppMethodBeat.o(156713);
    return paramString;
  }
  
  public static f.a aOT(String paramString)
  {
    AppMethodBeat.i(156715);
    paramString = aOU(lW("fr_" + paramString.toLowerCase(), "tools"));
    AppMethodBeat.o(156715);
    return paramString;
  }
  
  public static f.a aOU(String paramString)
  {
    AppMethodBeat.i(156716);
    f.a locala = f.a.IMt;
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
        paramString = f.a.IMt;
      }
    }
  }
  
  private static b fqA()
  {
    try
    {
      AppMethodBeat.i(156707);
      if (IMl == null)
      {
        localb = new b();
        IMl = localb;
        localb.fqv();
      }
      b localb = IMl;
      AppMethodBeat.o(156707);
      return localb;
    }
    finally {}
  }
  
  public static void fqB()
  {
    try
    {
      AppMethodBeat.i(161632);
      Log.i("CommandCfgPlugin", "resetCommandCfgPlugin ");
      IMl = null;
      fqA();
      AppMethodBeat.o(161632);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String getAbstractInfo()
  {
    AppMethodBeat.i(156709);
    try
    {
      String str = fqA().fqw();
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
  
  public static String lW(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(156714);
      paramString1 = a(paramString1, paramString2, fqA());
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
      R(paramString, localHashMap);
      AppMethodBeat.o(156712);
      return;
    }
    int i = 0;
    while (i < paramArrayOfa.length)
    {
      if ((paramArrayOfa[i] != null) && ((!paramBoolean) || (!aON(paramArrayOfa[i].IPN))) && (paramArrayOfa[i].IPM.frG()))
      {
        Object localObject = (a.a)j.g(WebView.c.INC).excute("STR_CMD_EXXCUTE_CMD_FROM_CONFIG", new Object[] { paramArrayOfa[i] });
        if (((localObject == null) || (!((a.a)localObject).IMj)) && (paramArrayOfa[i].IPO != null) && (paramArrayOfa[i].IPP != null) && (!paramArrayOfa[i].IPP.isEmpty()))
        {
          localObject = paramArrayOfa[i].IPP.split(",");
          a(paramArrayOfa[i], localHashMap, (String[])localObject);
        }
      }
      i += 1;
    }
    R(paramString, localHashMap);
    AppMethodBeat.o(156712);
  }
  
  public final SharedPreferences fqu()
  {
    AppMethodBeat.i(156708);
    SharedPreferences localSharedPreferences = XWalkEnvironment.getMMKVSharedPreferences("XWEB.CMDCFG.PLUGIN");
    AppMethodBeat.o(156708);
    return localSharedPreferences;
  }
  
  public final String fqw()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156710);
        StringBuilder localStringBuilder = new StringBuilder(512);
        Object localObject1 = this.IMh.keySet();
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
          String str2 = bP(aOG(str3));
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