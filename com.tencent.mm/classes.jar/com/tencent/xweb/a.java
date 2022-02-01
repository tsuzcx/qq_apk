package com.tencent.xweb;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.a.b;
import com.tencent.xweb.internal.j;
import com.tencent.xweb.internal.j.a;
import com.tencent.xweb.util.e;
import com.tencent.xweb.util.e.a;
import com.tencent.xweb.util.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class a
{
  static String[] KyB = { "disable_url_watchdog" };
  private static a Kyw;
  static boolean Kyx = false;
  static String Kyy = "";
  static int Kyz = 0;
  Map<String, Object> KyA;
  
  public a()
  {
    AppMethodBeat.i(156676);
    this.KyA = new HashMap();
    AppMethodBeat.o(156676);
  }
  
  private static Map<String, String> R(String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(156685);
    fIN();
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
  
  /* Error */
  protected static String a(String paramString1, String paramString2, a parama)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 76
    //   5: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_2
    //   9: aload_0
    //   10: invokevirtual 80	com/tencent/xweb/a:aUs	(Ljava/lang/String;)Ljava/util/Map;
    //   13: astore_0
    //   14: aload_0
    //   15: ifnull +7 -> 22
    //   18: aload_1
    //   19: ifnonnull +16 -> 35
    //   22: ldc 26
    //   24: astore_0
    //   25: ldc 76
    //   27: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: ldc 2
    //   32: monitorexit
    //   33: aload_0
    //   34: areturn
    //   35: aload_0
    //   36: aload_1
    //   37: invokeinterface 72 2 0
    //   42: checkcast 32	java/lang/String
    //   45: astore_0
    //   46: ldc 76
    //   48: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: goto -21 -> 30
    //   54: astore_0
    //   55: ldc 2
    //   57: monitorexit
    //   58: aload_0
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	paramString1	String
    //   0	60	1	paramString2	String
    //   0	60	2	parama	a
    // Exception table:
    //   from	to	target	type
    //   3	14	54	finally
    //   25	30	54	finally
    //   35	51	54	finally
  }
  
  protected static void a(com.tencent.xweb.internal.a.a parama, Map<String, Object> paramMap, String[] paramArrayOfString)
  {
    AppMethodBeat.i(156698);
    String str2 = parama.KCi;
    String str1 = parama.KCj;
    if (parama.KCi.equals("executeCommand"))
    {
      parama = aUA(parama.KCj);
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
    parama = R(str2, paramMap);
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
      fIN().b(paramArrayOfa, paramString, paramBoolean);
      AppMethodBeat.o(156696);
      return;
    }
    finally
    {
      paramArrayOfa = finally;
      throw paramArrayOfa;
    }
  }
  
  public static String[] aUA(String paramString)
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
  
  private static WebView.c aUB(String paramString)
  {
    AppMethodBeat.i(156700);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramString = WebView.c.KzY;
      AppMethodBeat.o(156700);
      return paramString;
    }
    WebView.c localc = WebView.c.KzY;
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
  
  private static JsRuntime.JsRuntimeType aUC(String paramString)
  {
    AppMethodBeat.i(156701);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramString = JsRuntime.JsRuntimeType.Kzb;
      AppMethodBeat.o(156701);
      return paramString;
    }
    JsRuntime.JsRuntimeType localJsRuntimeType = JsRuntime.JsRuntimeType.Kzb;
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
  
  private static WebView.a aUD(String paramString)
  {
    AppMethodBeat.i(156702);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramString = WebView.a.KzW;
      AppMethodBeat.o(156702);
      return paramString;
    }
    WebView.a locala = WebView.a.KzW;
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
  
  private static Map<String, String> aUE(String paramString)
  {
    AppMethodBeat.i(205041);
    HashMap localHashMap = new HashMap();
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(205041);
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
    AppMethodBeat.o(205041);
    return localHashMap;
  }
  
  public static WebView.c aUt(String paramString)
  {
    AppMethodBeat.i(156686);
    fIN();
    paramString = mx("setwebtype", paramString);
    fIN();
    paramString = aUB(paramString);
    AppMethodBeat.o(156686);
    return paramString;
  }
  
  public static JsRuntime.JsRuntimeType aUu(String paramString)
  {
    AppMethodBeat.i(156687);
    fIN();
    paramString = mx("setjscore", paramString);
    fIN();
    paramString = aUC(paramString);
    AppMethodBeat.o(156687);
    return paramString;
  }
  
  public static WebView.a aUv(String paramString)
  {
    AppMethodBeat.i(156688);
    fIN();
    paramString = mx("setfullscreenvideo", paramString);
    fIN();
    paramString = aUD(paramString);
    AppMethodBeat.o(156688);
    return paramString;
  }
  
  public static int aUw(String paramString)
  {
    AppMethodBeat.i(156689);
    fIN();
    paramString = mx("setTraceSampleRatioInTenThousand", paramString);
    if ((TextUtils.isEmpty(paramString)) || (!TextUtils.isDigitsOnly(paramString)))
    {
      AppMethodBeat.o(156689);
      return 0;
    }
    int i = Integer.parseInt(paramString);
    AppMethodBeat.o(156689);
    return i;
  }
  
  public static String aUx(String paramString)
  {
    AppMethodBeat.i(156690);
    fIN();
    paramString = mx("setEnabledTraceCategory", paramString);
    AppMethodBeat.o(156690);
    return paramString;
  }
  
  public static String aUy(String paramString)
  {
    AppMethodBeat.i(156691);
    String str2 = WebView.getCurStrModule();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "tools";
    }
    paramString = mx(paramString, str1);
    AppMethodBeat.o(156691);
    return paramString;
  }
  
  protected static boolean aUz(String paramString)
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
  
  public static void afX(int paramInt)
  {
    AppMethodBeat.i(156682);
    XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit().putInt("cStrSpKeyConfigPeriod", paramInt).commit();
    AppMethodBeat.o(156682);
  }
  
  static String bY(Map<String, String> paramMap)
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
  
  private static a fIN()
  {
    try
    {
      AppMethodBeat.i(156677);
      if (Kyw == null)
      {
        locala = new a();
        Kyw = locala;
        locala.fIQ();
      }
      a locala = Kyw;
      AppMethodBeat.o(156677);
      return locala;
    }
    finally {}
  }
  
  public static void fIO()
  {
    try
    {
      AppMethodBeat.i(185165);
      Kyw = null;
      Log.i("CommandCfg", "resetCommandCfg ");
      fIN();
      AppMethodBeat.o(185165);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static int fIS()
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
  
  private void fIT()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156705);
        Object localObject1 = fIP().getAll();
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
        localEditor = fIP().edit();
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
  
  private void fIU()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156706);
        fIT();
        SharedPreferences.Editor localEditor = fIP().edit();
        localEditor.putString("cStrTAGConfigVer", Kyy);
        localEditor.putString("cStrTAGConfigSdkVer", "200601");
        Iterator localIterator = this.KyA.entrySet().iterator();
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
                localEditor.putString((String)localEntry.getKey(), bY(localMap));
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
    XWalkEnvironment.addXWalkInitializeLog(fIR());
    AppMethodBeat.o(156706);
  }
  
  public static String getAbstractInfo()
  {
    AppMethodBeat.i(156680);
    fIN();
    String str = fIN().fIR();
    AppMethodBeat.o(156680);
    return str;
  }
  
  public static String mx(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(156692);
      fIN();
      paramString1 = a(paramString1, paramString2, fIN());
      AppMethodBeat.o(156692);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static int my(String paramString1, String paramString2)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(205040);
        fIN();
        paramString1 = mx(paramString1, paramString2);
        if (TextUtils.isEmpty(paramString1))
        {
          AppMethodBeat.o(205040);
          return i;
        }
        paramString1 = e.aVm(paramString1);
        if (!paramString1.KDX)
        {
          AppMethodBeat.o(205040);
          continue;
        }
        i = paramString1.intValue();
      }
      finally {}
      AppMethodBeat.o(205040);
    }
  }
  
  final void S(String paramString, Map<String, Object> paramMap)
  {
    try
    {
      AppMethodBeat.i(156704);
      Kyy = paramString;
      this.KyA = paramMap;
      fIU();
      AppMethodBeat.o(156704);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  protected final Map<String, String> aUs(String paramString)
  {
    try
    {
      AppMethodBeat.i(156684);
      paramString = R(paramString, this.KyA);
      AppMethodBeat.o(156684);
      return paramString;
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
    fIN();
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
      S(paramString, localHashMap6);
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
          if (aUz(paramArrayOfa[k].KCi)) {}
        }
        else
        {
          m = j;
          if (paramArrayOfa[k].KCh.fKi())
          {
            Object localObject = (a)j.g(WebView.c.KzZ).excute("STR_CMD_EXXCUTE_CMD_FROM_CONFIG", new Object[] { paramArrayOfa[k] });
            if (localObject != null)
            {
              m = j;
              if (((a)localObject).KyC) {}
            }
            else
            {
              m = j;
              if (paramArrayOfa[k].KCj != null)
              {
                i = j;
                if (paramArrayOfa[k].KCi.equals("setConfigPeriod")) {}
                try
                {
                  i = Integer.parseInt(paramArrayOfa[k].KCj);
                  m = i;
                  if (paramArrayOfa[k].KCk != null)
                  {
                    m = i;
                    if (!paramArrayOfa[k].KCk.isEmpty())
                    {
                      localObject = paramArrayOfa[k].KCk.split(",");
                      if (!paramArrayOfa[k].KCi.equals("setwebtype")) {
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
                              localHashMap1.put(str, paramArrayOfa[k].KCj);
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
                    Log.e("CommandCfg", "parse pariod cmdvalue to int failed , value is " + paramArrayOfa[k].KCj);
                    i = j;
                  }
                  m = i;
                  if (j != 0)
                  {
                    m = i;
                    if (paramArrayOfa[k].KCh.KCx > 0)
                    {
                      g.Cf(199L);
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
        if (paramArrayOfa[k].KCi.equals("setjscore"))
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
              localHashMap2.put(str, paramArrayOfa[k].KCj);
            }
            j += 1;
          }
        }
        if (paramArrayOfa[k].KCi.equals("setfullscreenvideo"))
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
              localHashMap3.put(str, paramArrayOfa[k].KCj);
            }
            j += 1;
          }
        }
        if (paramArrayOfa[k].KCi.equals("setTraceSampleRatioInTenThousand"))
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
              localHashMap4.put(str, paramArrayOfa[k].KCj);
            }
            j += 1;
          }
        }
        if (paramArrayOfa[k].KCi.equals("setEnabledTraceCategory"))
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
              localHashMap5.put(str, paramArrayOfa[k].KCj);
            }
            j += 1;
          }
        }
        a(paramArrayOfa[k], localHashMap6, localException);
        m = i;
      }
    }
    afX(j);
    S(paramString, localHashMap6);
    AppMethodBeat.o(156697);
  }
  
  public SharedPreferences fIP()
  {
    AppMethodBeat.i(156678);
    SharedPreferences localSharedPreferences = XWalkEnvironment.getMMKVSharedTransportOld("XWEB.CMDCFG");
    AppMethodBeat.o(156678);
    return localSharedPreferences;
  }
  
  final void fIQ()
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
      this.KyA.clear();
      SharedPreferences localSharedPreferences = fIP();
      Kyy = localSharedPreferences.getString("cStrTAGConfigVer", "");
      Object localObject1 = localSharedPreferences.getString("cStrTAGConfigSdkVer", "");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label390;
      }
      i = e.aVm((String)localObject1).intValue();
      Kyz = i;
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
          this.KyA.put(str1, str2);
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
          localObject3 = aUE(str2);
          break label222;
          label359:
          this.KyA.put(str1, localObject3);
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
  
  public String fIR()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156681);
        StringBuilder localStringBuilder = new StringBuilder(512);
        Object localObject1 = this.KyA.keySet();
        localStringBuilder.append("strConfig ver = " + Kyy + "\n");
        localStringBuilder.append("strConfig sdk ver = " + Kyz + "\n");
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
          String str2 = bY(aUs(str3));
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
  
  public static final class a
  {
    public boolean KyC = false;
    public Object KyD = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.a
 * JD-Core Version:    0.7.0.1
 */