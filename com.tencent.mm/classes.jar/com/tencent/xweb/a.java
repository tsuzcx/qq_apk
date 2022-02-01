package com.tencent.xweb;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.a.b;
import com.tencent.xweb.internal.i;
import com.tencent.xweb.internal.j.a;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.internal.l.a;
import com.tencent.xweb.util.e;
import com.tencent.xweb.util.e.a;
import com.tencent.xweb.util.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class a
{
  private static a ZZu;
  static boolean ZZv = false;
  static String ZZw = "";
  static int ZZx = 0;
  static String[] ZZz = { "disable_url_watchdog" };
  Map<String, Object> ZZy;
  
  public a()
  {
    AppMethodBeat.i(156676);
    this.ZZy = new HashMap();
    AppMethodBeat.o(156676);
  }
  
  protected static void a(com.tencent.xweb.internal.a.a parama, Map<String, Object> paramMap, String[] paramArrayOfString)
  {
    AppMethodBeat.i(156698);
    String str2 = parama.aadP;
    String str1 = parama.aadQ;
    if (parama.aadP.equals("executeCommand"))
    {
      parama = bEK(parama.aadQ);
      if ((parama == null) || (parama.length < 2))
      {
        AppMethodBeat.o(156698);
        return;
      }
      str2 = parama[0];
      str1 = parama[1];
    }
    if (TextUtils.isEmpty(str2))
    {
      AppMethodBeat.o(156698);
      return;
    }
    parama = ae(str2, paramMap);
    if ((parama == null) || (parama.isEmpty()))
    {
      parama = new HashMap();
      paramMap.put(str2, parama);
    }
    for (;;)
    {
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        paramMap = paramArrayOfString[i].trim();
        if ((paramMap != null) && (!paramMap.isEmpty()) && (!parama.containsKey(paramMap))) {
          parama.put(paramMap, str1);
        }
        i += 1;
      }
      AppMethodBeat.o(156698);
      return;
    }
  }
  
  public static void a(com.tencent.xweb.internal.a.a[] paramArrayOfa, String paramString)
  {
    AppMethodBeat.i(156695);
    a(paramArrayOfa, paramString, false);
    AppMethodBeat.o(156695);
  }
  
  public static void a(com.tencent.xweb.internal.a.a[] paramArrayOfa, String paramString, boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(156696);
      ivJ().b(paramArrayOfa, paramString, paramBoolean);
      AppMethodBeat.o(156696);
      return;
    }
    finally
    {
      paramArrayOfa = finally;
      throw paramArrayOfa;
    }
  }
  
  public static void aCG(int paramInt)
  {
    AppMethodBeat.i(156682);
    XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit().putInt("cStrSpKeyConfigPeriod", paramInt).commit();
    AppMethodBeat.o(156682);
  }
  
  private static Map<String, String> ae(String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(156685);
    ivJ();
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramString = new HashMap();
      AppMethodBeat.o(156685);
      return paramString;
    }
    paramString = paramMap.get(paramString);
    if ((paramString instanceof HashMap))
    {
      paramString = (Map)paramString;
      AppMethodBeat.o(156685);
      return paramString;
    }
    paramString = new HashMap();
    AppMethodBeat.o(156685);
    return paramString;
  }
  
  public static WebView.c bEC(String paramString)
  {
    AppMethodBeat.i(156686);
    ivJ();
    paramString = oO("setwebtype", paramString);
    ivJ();
    paramString = bEL(paramString);
    AppMethodBeat.o(156686);
    return paramString;
  }
  
  public static JsRuntime.JsRuntimeType bED(String paramString)
  {
    AppMethodBeat.i(156687);
    ivJ();
    paramString = oO("setjscore", paramString);
    ivJ();
    paramString = bEM(paramString);
    AppMethodBeat.o(156687);
    return paramString;
  }
  
  public static WebView.a bEE(String paramString)
  {
    AppMethodBeat.i(156688);
    ivJ();
    paramString = oO("setfullscreenvideo", paramString);
    ivJ();
    paramString = bEN(paramString);
    AppMethodBeat.o(156688);
    return paramString;
  }
  
  public static WebView.a bEF(String paramString)
  {
    AppMethodBeat.i(196152);
    ivJ();
    paramString = oO("setx5fullscreenvideo", paramString);
    ivJ();
    paramString = bEN(paramString);
    AppMethodBeat.o(196152);
    return paramString;
  }
  
  public static int bEG(String paramString)
  {
    AppMethodBeat.i(156689);
    ivJ();
    paramString = oO("setTraceSampleRatioInTenThousand", paramString);
    if ((TextUtils.isEmpty(paramString)) || (!TextUtils.isDigitsOnly(paramString)))
    {
      AppMethodBeat.o(156689);
      return 0;
    }
    int i = Integer.parseInt(paramString);
    AppMethodBeat.o(156689);
    return i;
  }
  
  public static String bEH(String paramString)
  {
    AppMethodBeat.i(156690);
    ivJ();
    paramString = oO("setEnabledTraceCategory", paramString);
    AppMethodBeat.o(156690);
    return paramString;
  }
  
  public static String bEI(String paramString)
  {
    AppMethodBeat.i(156691);
    String str2 = WebView.getCurStrModule();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "tools";
    }
    paramString = oO(paramString, str1);
    AppMethodBeat.o(156691);
    return paramString;
  }
  
  protected static boolean bEJ(String paramString)
  {
    AppMethodBeat.i(156694);
    if ("revertToVersion".equals(paramString))
    {
      AppMethodBeat.o(156694);
      return true;
    }
    AppMethodBeat.o(156694);
    return false;
  }
  
  public static String[] bEK(String paramString)
  {
    AppMethodBeat.i(156699);
    String[] arrayOfString = new String[2];
    if ((paramString == null) || (!paramString.contains(":")))
    {
      AppMethodBeat.o(156699);
      return null;
    }
    int i = paramString.indexOf(':');
    arrayOfString[0] = paramString.substring(0, i);
    if (paramString.length() - 1 <= i) {
      arrayOfString[1] = "";
    }
    for (;;)
    {
      AppMethodBeat.o(156699);
      return arrayOfString;
      arrayOfString[1] = paramString.substring(i + 1);
    }
  }
  
  private static WebView.c bEL(String paramString)
  {
    AppMethodBeat.i(156700);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramString = WebView.c.aabl;
      AppMethodBeat.o(156700);
      return paramString;
    }
    WebView.c localc = WebView.c.aabl;
    try
    {
      paramString = WebView.c.valueOf(paramString);
      AppMethodBeat.o(156700);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = localc;
      }
    }
  }
  
  private static JsRuntime.JsRuntimeType bEM(String paramString)
  {
    AppMethodBeat.i(156701);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramString = JsRuntime.JsRuntimeType.aaam;
      AppMethodBeat.o(156701);
      return paramString;
    }
    JsRuntime.JsRuntimeType localJsRuntimeType = JsRuntime.JsRuntimeType.aaam;
    try
    {
      paramString = JsRuntime.JsRuntimeType.valueOf(paramString);
      AppMethodBeat.o(156701);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = localJsRuntimeType;
      }
    }
  }
  
  private static WebView.a bEN(String paramString)
  {
    AppMethodBeat.i(156702);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramString = WebView.a.aabj;
      AppMethodBeat.o(156702);
      return paramString;
    }
    WebView.a locala = WebView.a.aabj;
    try
    {
      paramString = WebView.a.valueOf(paramString);
      AppMethodBeat.o(156702);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = locala;
      }
    }
  }
  
  private static Map<String, String> bEO(String paramString)
  {
    AppMethodBeat.i(196228);
    HashMap localHashMap = new HashMap();
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(196228);
      return localHashMap;
    }
    paramString = paramString.split("~~~");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String[] arrayOfString = paramString[i];
      if ((arrayOfString != null) && (!arrayOfString.isEmpty()))
      {
        arrayOfString = arrayOfString.split("```");
        if ((arrayOfString.length == 2) && (arrayOfString[0] != null) && (arrayOfString[1] != null)) {
          localHashMap.put(arrayOfString[0], arrayOfString[1]);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(196228);
    return localHashMap;
  }
  
  static String cy(Map<String, String> paramMap)
  {
    AppMethodBeat.i(156703);
    if (paramMap == null)
    {
      AppMethodBeat.o(156703);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(128);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (localStringBuilder.length() != 0) {
        localStringBuilder.append("~~~");
      }
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append("```");
      localStringBuilder.append((String)localEntry.getValue());
    }
    paramMap = localStringBuilder.toString();
    AppMethodBeat.o(156703);
    return paramMap;
  }
  
  public static String getAbstractInfo()
  {
    AppMethodBeat.i(156680);
    ivJ();
    String str = ivJ().ivN();
    AppMethodBeat.o(156680);
    return str;
  }
  
  public static a ivJ()
  {
    try
    {
      AppMethodBeat.i(156677);
      if (ZZu == null)
      {
        locala = new a();
        ZZu = locala;
        locala.ivM();
      }
      a locala = ZZu;
      AppMethodBeat.o(156677);
      return locala;
    }
    finally {}
  }
  
  public static void ivK()
  {
    try
    {
      AppMethodBeat.i(185165);
      ZZu = null;
      Log.i("CommandCfg", "resetCommandCfg ");
      ivJ();
      AppMethodBeat.o(185165);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static int ivO()
  {
    AppMethodBeat.i(156683);
    int i = XWalkEnvironment.getSharedPreferencesForUpdateConfig().getInt("cStrSpKeyConfigPeriod", -1);
    if (i <= 30)
    {
      AppMethodBeat.o(156683);
      return -1;
    }
    AppMethodBeat.o(156683);
    return i * 60 * 1000;
  }
  
  private void ivP()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156705);
        Object localObject1 = ivL().getAll();
        if ((localObject1 == null) || (((Map)localObject1).size() == 0))
        {
          AppMethodBeat.o(156705);
          return;
        }
        localObject1 = ((Map)localObject1).entrySet().iterator();
        localObject3 = new ArrayList();
        if (((Iterator)localObject1).hasNext())
        {
          ((ArrayList)localObject3).add((String)((Map.Entry)((Iterator)localObject1).next()).getKey());
          continue;
        }
        localEditor = ivL().edit();
      }
      finally {}
      SharedPreferences.Editor localEditor;
      Object localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        if ((!"cStrTAGConfigVer".equalsIgnoreCase(str)) && (!"cStrTAGConfigSdkVer".equalsIgnoreCase(str))) {
          localEditor.remove(str);
        }
      }
      localEditor.commit();
      AppMethodBeat.o(156705);
    }
  }
  
  private void ivQ()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156706);
        ivP();
        SharedPreferences.Editor localEditor = ivL().edit();
        localEditor.putString("cStrTAGConfigVer", ZZw);
        localEditor.putString("cStrTAGConfigSdkVer", "20210601");
        Iterator localIterator = this.ZZy.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((localEntry.getKey() != null) && (!((String)localEntry.getKey()).isEmpty()))
        {
          Object localObject2 = localEntry.getValue();
          if (localObject2 != null)
          {
            boolean bool = localObject2 instanceof Map;
            if (bool) {
              try
              {
                Map localMap = (Map)localObject2;
                if (localMap == null) {
                  continue;
                }
                localEditor.putString((String)localEntry.getKey(), cy(localMap));
              }
              catch (Exception localException)
              {
                localEditor.putString((String)localEntry.getKey(), localObject2.toString());
              }
            } else {
              localObject1.putString((String)localEntry.getKey(), localObject2.toString());
            }
          }
        }
      }
      finally {}
    }
    localObject1.commit();
    XWalkEnvironment.addXWalkInitializeLog(ivN());
    AppMethodBeat.o(156706);
  }
  
  public static String oO(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(156692);
      ivJ();
      paramString1 = ivJ().oQ(paramString1, paramString2);
      AppMethodBeat.o(156692);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final int aG(String paramString1, String paramString2, int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(196166);
        paramString1 = oQ(paramString1, paramString2);
        if (TextUtils.isEmpty(paramString1))
        {
          AppMethodBeat.o(196166);
          return paramInt;
        }
        paramString1 = e.bFC(paramString1);
        if (!paramString1.aafP)
        {
          AppMethodBeat.o(196166);
          continue;
        }
        paramInt = paramString1.intValue();
      }
      finally {}
      AppMethodBeat.o(196166);
    }
  }
  
  final void af(String paramString, Map<String, Object> paramMap)
  {
    try
    {
      AppMethodBeat.i(156704);
      ZZw = paramString;
      this.ZZy = paramMap;
      ivQ();
      AppMethodBeat.o(156704);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  protected void b(com.tencent.xweb.internal.a.a[] paramArrayOfa, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(156697);
    ivJ();
    if (paramString == null)
    {
      AppMethodBeat.o(156697);
      return;
    }
    XWalkEnvironment.addXWalkInitializeLog("apply command config version is ".concat(String.valueOf(paramString)));
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    HashMap localHashMap4 = new HashMap();
    HashMap localHashMap5 = new HashMap();
    HashMap localHashMap6 = new HashMap();
    localHashMap6.put("setwebtype", localHashMap1);
    localHashMap6.put("setjscore", localHashMap2);
    localHashMap6.put("setfullscreenvideo", localHashMap3);
    localHashMap6.put("setTraceSampleRatioInTenThousand", localHashMap4);
    localHashMap6.put("setEnabledTraceCategory", localHashMap5);
    if ((paramArrayOfa == null) || (paramArrayOfa.length == 0))
    {
      af(paramString, localHashMap6);
      AppMethodBeat.o(156697);
      return;
    }
    int j = -1;
    int k = 0;
    if (k < paramArrayOfa.length)
    {
      int m = j;
      int i;
      String str;
      if (paramArrayOfa[k] != null) {
        if (paramBoolean)
        {
          m = j;
          if (bEJ(paramArrayOfa[k].aadP)) {}
        }
        else
        {
          m = j;
          if (paramArrayOfa[k].aadO.ixf())
          {
            Object localObject = (a)l.h(WebView.c.aabm).excute("STR_CMD_EXXCUTE_CMD_FROM_CONFIG", new Object[] { paramArrayOfa[k] });
            if (localObject != null)
            {
              m = j;
              if (((a)localObject).ZZA) {}
            }
            else
            {
              m = j;
              if (paramArrayOfa[k].aadQ != null)
              {
                i = j;
                if (paramArrayOfa[k].aadP.equals("setConfigPeriod")) {}
                try
                {
                  i = Integer.parseInt(paramArrayOfa[k].aadQ);
                  m = i;
                  if (paramArrayOfa[k].aadR != null)
                  {
                    m = i;
                    if (!paramArrayOfa[k].aadR.isEmpty())
                    {
                      localObject = paramArrayOfa[k].aadR.split(",");
                      if (!paramArrayOfa[k].aadP.equals("setwebtype")) {
                        break label568;
                      }
                      j = 0;
                      m = 0;
                      while (m < localObject.length)
                      {
                        str = localObject[m].trim();
                        int n = j;
                        if (str != null)
                        {
                          n = j;
                          if (!str.isEmpty())
                          {
                            n = j;
                            if (!localHashMap1.containsKey(str))
                            {
                              localHashMap1.put(str, paramArrayOfa[k].aadQ);
                              n = 1;
                            }
                          }
                        }
                        m += 1;
                        j = n;
                      }
                    }
                  }
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    Log.e("CommandCfg", "parse pariod cmdvalue to int failed , value is " + paramArrayOfa[k].aadQ);
                    i = j;
                  }
                  m = i;
                  if (j != 0)
                  {
                    m = i;
                    if (paramArrayOfa[k].aadO.aaek > 0)
                    {
                      h.Xg(199L);
                      m = i;
                    }
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        k += 1;
        j = m;
        break;
        label568:
        if (paramArrayOfa[k].aadP.equals("setjscore"))
        {
          j = 0;
          for (;;)
          {
            m = i;
            if (j >= localException.length) {
              break;
            }
            str = localException[j].trim();
            if ((str != null) && (!str.isEmpty()) && (!localHashMap2.containsKey(str))) {
              localHashMap2.put(str, paramArrayOfa[k].aadQ);
            }
            j += 1;
          }
        }
        if (paramArrayOfa[k].aadP.equals("setfullscreenvideo"))
        {
          j = 0;
          for (;;)
          {
            m = i;
            if (j >= localException.length) {
              break;
            }
            str = localException[j].trim();
            if ((str != null) && (!str.isEmpty()) && (!localHashMap3.containsKey(str))) {
              localHashMap3.put(str, paramArrayOfa[k].aadQ);
            }
            j += 1;
          }
        }
        if (paramArrayOfa[k].aadP.equals("setTraceSampleRatioInTenThousand"))
        {
          j = 0;
          for (;;)
          {
            m = i;
            if (j >= localException.length) {
              break;
            }
            str = localException[j].trim();
            if ((str != null) && (!str.isEmpty()) && (!localHashMap4.containsKey(str))) {
              localHashMap4.put(str, paramArrayOfa[k].aadQ);
            }
            j += 1;
          }
        }
        if (paramArrayOfa[k].aadP.equals("setEnabledTraceCategory"))
        {
          j = 0;
          for (;;)
          {
            m = i;
            if (j >= localException.length) {
              break;
            }
            str = localException[j].trim();
            if ((str != null) && (!str.isEmpty()) && (!localHashMap5.containsKey(str))) {
              localHashMap5.put(str, paramArrayOfa[k].aadQ);
            }
            j += 1;
          }
        }
        a(paramArrayOfa[k], localHashMap6, localException);
        m = i;
      }
    }
    aCG(j);
    af(paramString, localHashMap6);
    AppMethodBeat.o(156697);
  }
  
  public final Map<String, String> bEB(String paramString)
  {
    try
    {
      AppMethodBeat.i(156684);
      paramString = ae(paramString, this.ZZy);
      AppMethodBeat.o(156684);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public SharedPreferences ivL()
  {
    AppMethodBeat.i(156678);
    SharedPreferences localSharedPreferences = XWalkEnvironment.getMMKVSharedTransportOld("XWEB.CMDCFG");
    AppMethodBeat.o(156678);
    return localSharedPreferences;
  }
  
  final void ivM()
  {
    int i;
    label88:
    label118:
    String str1;
    label135:
    String str2;
    HashMap localHashMap;
    try
    {
      AppMethodBeat.i(156679);
      this.ZZy.clear();
      SharedPreferences localSharedPreferences = ivL();
      ZZw = localSharedPreferences.getString("cStrTAGConfigVer", "");
      Object localObject1 = localSharedPreferences.getString("cStrTAGConfigSdkVer", "");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label390;
      }
      i = e.bFC((String)localObject1).intValue();
      ZZx = i;
      if (i >= 200502) {
        break label385;
      }
      XWalkEnvironment.addXWalkInitializeLog("config sdk ver is old , use deserized from old");
      i = 1;
      localObject1 = localSharedPreferences.getAll();
      if ((localObject1 == null) || (((Map)localObject1).size() == 0))
      {
        AppMethodBeat.o(156679);
        return;
      }
      Iterator localIterator = ((Map)localObject1).entrySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label376;
        }
        str1 = (String)((Map.Entry)localIterator.next()).getKey();
        str2 = localSharedPreferences.getString(str1, "");
        if ((str1 != null) && (str2 != null))
        {
          if (i == 0) {
            break label349;
          }
          localHashMap = new HashMap();
          localObject1 = localHashMap;
          if (str2 != null)
          {
            if (!str2.isEmpty()) {
              break;
            }
            localObject1 = localHashMap;
          }
          label222:
          if (((Map)localObject1).size() != 0) {
            break label359;
          }
          this.ZZy.put(str1, str2);
        }
      }
      arrayOfString = str2.split(";");
    }
    finally {}
    String[] arrayOfString;
    int k = arrayOfString.length;
    int j = 0;
    for (;;)
    {
      Object localObject3 = localHashMap;
      if (j >= k) {
        break label222;
      }
      localObject3 = arrayOfString[j];
      if ((localObject3 != null) && (!((String)localObject3).isEmpty()))
      {
        localObject3 = ((String)localObject3).split(":");
        if ((localObject3.length == 2) && (localObject3[0] != null) && (localObject3[1] != null))
        {
          localHashMap.put(localObject3[0], localObject3[1]);
          break label395;
          label349:
          localObject3 = bEO(str2);
          break label222;
          label359:
          this.ZZy.put(str1, localObject3);
          break label135;
          label376:
          AppMethodBeat.o(156679);
          break label118;
          label385:
          i = 0;
          break label88;
          label390:
          i = 0;
          break;
        }
      }
      label395:
      j += 1;
    }
  }
  
  public String ivN()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156681);
        StringBuilder localStringBuilder = new StringBuilder(512);
        Object localObject1 = this.ZZy.keySet();
        localStringBuilder.append("strConfig ver = " + ZZw + "\n");
        localStringBuilder.append("strConfig sdk ver = " + ZZx + "\n");
        if (localObject1 == null)
        {
          localObject1 = localStringBuilder.toString();
          AppMethodBeat.o(156681);
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
          localStringBuilder.append(str3 + " : ");
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("\n");
          continue;
        }
        String str1 = localStringBuilder.toString();
      }
      finally {}
      AppMethodBeat.o(156681);
    }
  }
  
  public final boolean oP(String paramString1, String paramString2)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(196168);
        paramString1 = oQ(paramString1, paramString2);
        if (TextUtils.isEmpty(paramString1))
        {
          AppMethodBeat.o(196168);
          return bool;
        }
        if ("true".equalsIgnoreCase(paramString1))
        {
          bool = true;
          AppMethodBeat.o(196168);
          continue;
        }
        if (!"false".equalsIgnoreCase(paramString1)) {
          break label79;
        }
      }
      finally {}
      AppMethodBeat.o(196168);
      continue;
      label79:
      AppMethodBeat.o(196168);
    }
  }
  
  protected final String oQ(String paramString1, String paramString2)
  {
    Object localObject1;
    double d;
    try
    {
      AppMethodBeat.i(196180);
      localObject1 = bEB(paramString1);
      paramString1 = paramString2;
      if (!TextUtils.isEmpty(paramString2)) {
        break label349;
      }
      paramString2 = WebView.getCurStrModule();
      paramString1 = paramString2;
      if (!TextUtils.isEmpty(paramString2)) {
        break label349;
      }
      paramString1 = "tools";
    }
    finally {}
    paramString1 = "";
    AppMethodBeat.o(196180);
    label52:
    return paramString1;
    label56:
    paramString1 = (String)((Map)localObject1).get(paramString1);
    int k;
    int i;
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("[")) && (paramString1.contains("]")))
    {
      d = e.ixB();
      localObject1 = TextUtils.split(paramString1, "]");
      k = localObject1.length;
      i = 0;
    }
    for (;;)
    {
      label157:
      int j;
      Object localObject2;
      if (i < k)
      {
        paramString1 = localObject1[i];
        if (TextUtils.isEmpty(paramString1)) {
          break label370;
        }
        paramString1 = paramString1.trim();
        if (!paramString1.startsWith(";")) {
          break label346;
        }
        paramString1 = paramString1.substring(1);
        j = paramString1.indexOf('[');
        paramString2 = paramString1.substring(0, j);
        localObject2 = paramString1.substring(j + 1);
        paramString1 = new ArrayList();
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = ((String)localObject2).split(";");
          if ((localObject2 != null) && (localObject2.length != 0)) {
            break label267;
          }
        }
      }
      label267:
      label346:
      label349:
      label361:
      label368:
      for (;;)
      {
        localObject2 = new j.a((byte)0);
        ((j.a)localObject2).fSV = paramString2;
        ((j.a)localObject2).aaeZ = paramString1;
        if (!((j.a)localObject2).K(d)) {
          break label370;
        }
        AppMethodBeat.o(196180);
        paramString1 = paramString2;
        break label52;
        e.ixB();
        int m = localObject2.length;
        j = 0;
        for (;;)
        {
          if (j >= m) {
            break label368;
          }
          Object localObject3 = localObject2[j];
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject3 = i.bFx((String)localObject3);
            if (localObject3 != null)
            {
              paramString1.add(localObject3);
              break label361;
              paramString1 = "";
              AppMethodBeat.o(196180);
              break label52;
              AppMethodBeat.o(196180);
              break label52;
              break label157;
              if (localObject1 == null) {
                break;
              }
              if (paramString1 != null) {
                break label56;
              }
              break;
            }
          }
          j += 1;
        }
      }
      label370:
      i += 1;
    }
  }
  
  public static final class a
  {
    public boolean ZZA = false;
    public Object ZZB = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.a
 * JD-Core Version:    0.7.0.1
 */