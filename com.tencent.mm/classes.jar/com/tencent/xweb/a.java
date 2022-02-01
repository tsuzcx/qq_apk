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
  private static a MLO;
  static boolean MLP = false;
  static String MLQ = "";
  static int MLR = 0;
  static String[] MLT = { "disable_url_watchdog" };
  Map<String, Object> MLS;
  
  public a()
  {
    AppMethodBeat.i(156676);
    this.MLS = new HashMap();
    AppMethodBeat.o(156676);
  }
  
  private static Map<String, String> U(String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(156685);
    geL();
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
    //   10: invokevirtual 80	com/tencent/xweb/a:bbY	(Ljava/lang/String;)Ljava/util/Map;
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
    String str2 = parama.MPH;
    String str1 = parama.MPI;
    if (parama.MPH.equals("executeCommand"))
    {
      parama = bcg(parama.MPI);
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
    parama = U(str2, paramMap);
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
      geL().b(paramArrayOfa, paramString, paramBoolean);
      AppMethodBeat.o(156696);
      return;
    }
    finally
    {
      paramArrayOfa = finally;
      throw paramArrayOfa;
    }
  }
  
  public static void ajg(int paramInt)
  {
    AppMethodBeat.i(156682);
    XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit().putInt("cStrSpKeyConfigPeriod", paramInt).commit();
    AppMethodBeat.o(156682);
  }
  
  public static WebView.c bbZ(String paramString)
  {
    AppMethodBeat.i(156686);
    geL();
    paramString = nb("setwebtype", paramString);
    geL();
    paramString = bch(paramString);
    AppMethodBeat.o(156686);
    return paramString;
  }
  
  public static JsRuntime.JsRuntimeType bca(String paramString)
  {
    AppMethodBeat.i(156687);
    geL();
    paramString = nb("setjscore", paramString);
    geL();
    paramString = bci(paramString);
    AppMethodBeat.o(156687);
    return paramString;
  }
  
  public static WebView.a bcb(String paramString)
  {
    AppMethodBeat.i(156688);
    geL();
    paramString = nb("setfullscreenvideo", paramString);
    geL();
    paramString = bcj(paramString);
    AppMethodBeat.o(156688);
    return paramString;
  }
  
  public static int bcc(String paramString)
  {
    AppMethodBeat.i(156689);
    geL();
    paramString = nb("setTraceSampleRatioInTenThousand", paramString);
    if ((TextUtils.isEmpty(paramString)) || (!TextUtils.isDigitsOnly(paramString)))
    {
      AppMethodBeat.o(156689);
      return 0;
    }
    int i = Integer.parseInt(paramString);
    AppMethodBeat.o(156689);
    return i;
  }
  
  public static String bcd(String paramString)
  {
    AppMethodBeat.i(156690);
    geL();
    paramString = nb("setEnabledTraceCategory", paramString);
    AppMethodBeat.o(156690);
    return paramString;
  }
  
  public static String bce(String paramString)
  {
    AppMethodBeat.i(156691);
    String str2 = WebView.getCurStrModule();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "tools";
    }
    paramString = nb(paramString, str1);
    AppMethodBeat.o(156691);
    return paramString;
  }
  
  protected static boolean bcf(String paramString)
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
  
  public static String[] bcg(String paramString)
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
  
  private static WebView.c bch(String paramString)
  {
    AppMethodBeat.i(156700);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramString = WebView.c.MNx;
      AppMethodBeat.o(156700);
      return paramString;
    }
    WebView.c localc = WebView.c.MNx;
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
  
  private static JsRuntime.JsRuntimeType bci(String paramString)
  {
    AppMethodBeat.i(156701);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramString = JsRuntime.JsRuntimeType.MMA;
      AppMethodBeat.o(156701);
      return paramString;
    }
    JsRuntime.JsRuntimeType localJsRuntimeType = JsRuntime.JsRuntimeType.MMA;
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
  
  private static WebView.a bcj(String paramString)
  {
    AppMethodBeat.i(156702);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramString = WebView.a.MNv;
      AppMethodBeat.o(156702);
      return paramString;
    }
    WebView.a locala = WebView.a.MNv;
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
  
  private static Map<String, String> bck(String paramString)
  {
    AppMethodBeat.i(217358);
    HashMap localHashMap = new HashMap();
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(217358);
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
    AppMethodBeat.o(217358);
    return localHashMap;
  }
  
  static String cg(Map<String, String> paramMap)
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
  
  private static a geL()
  {
    try
    {
      AppMethodBeat.i(156677);
      if (MLO == null)
      {
        locala = new a();
        MLO = locala;
        locala.geO();
      }
      a locala = MLO;
      AppMethodBeat.o(156677);
      return locala;
    }
    finally {}
  }
  
  public static void geM()
  {
    try
    {
      AppMethodBeat.i(185165);
      MLO = null;
      Log.i("CommandCfg", "resetCommandCfg ");
      geL();
      AppMethodBeat.o(185165);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static int geQ()
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
  
  private void geR()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156705);
        Object localObject1 = geN().getAll();
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
        localEditor = geN().edit();
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
  
  private void geS()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156706);
        geR();
        SharedPreferences.Editor localEditor = geN().edit();
        localEditor.putString("cStrTAGConfigVer", MLQ);
        localEditor.putString("cStrTAGConfigSdkVer", "200901");
        Iterator localIterator = this.MLS.entrySet().iterator();
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
                localEditor.putString((String)localEntry.getKey(), cg(localMap));
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
    XWalkEnvironment.addXWalkInitializeLog(geP());
    AppMethodBeat.o(156706);
  }
  
  public static String getAbstractInfo()
  {
    AppMethodBeat.i(156680);
    geL();
    String str = geL().geP();
    AppMethodBeat.o(156680);
    return str;
  }
  
  public static String nb(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(156692);
      geL();
      paramString1 = a(paramString1, paramString2, geL());
      AppMethodBeat.o(156692);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static int nc(String paramString1, String paramString2)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(217357);
        geL();
        paramString1 = nb(paramString1, paramString2);
        if (TextUtils.isEmpty(paramString1))
        {
          AppMethodBeat.o(217357);
          return i;
        }
        paramString1 = e.bcS(paramString1);
        if (!paramString1.MRB)
        {
          AppMethodBeat.o(217357);
          continue;
        }
        i = paramString1.intValue();
      }
      finally {}
      AppMethodBeat.o(217357);
    }
  }
  
  final void V(String paramString, Map<String, Object> paramMap)
  {
    try
    {
      AppMethodBeat.i(156704);
      MLQ = paramString;
      this.MLS = paramMap;
      geS();
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
    geL();
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
      V(paramString, localHashMap6);
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
          if (bcf(paramArrayOfa[k].MPH)) {}
        }
        else
        {
          m = j;
          if (paramArrayOfa[k].MPG.gge())
          {
            Object localObject = (a)j.g(WebView.c.MNy).excute("STR_CMD_EXXCUTE_CMD_FROM_CONFIG", new Object[] { paramArrayOfa[k] });
            if (localObject != null)
            {
              m = j;
              if (((a)localObject).MLU) {}
            }
            else
            {
              m = j;
              if (paramArrayOfa[k].MPI != null)
              {
                i = j;
                if (paramArrayOfa[k].MPH.equals("setConfigPeriod")) {}
                try
                {
                  i = Integer.parseInt(paramArrayOfa[k].MPI);
                  m = i;
                  if (paramArrayOfa[k].MPJ != null)
                  {
                    m = i;
                    if (!paramArrayOfa[k].MPJ.isEmpty())
                    {
                      localObject = paramArrayOfa[k].MPJ.split(",");
                      if (!paramArrayOfa[k].MPH.equals("setwebtype")) {
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
                              localHashMap1.put(str, paramArrayOfa[k].MPI);
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
                    Log.e("CommandCfg", "parse pariod cmdvalue to int failed , value is " + paramArrayOfa[k].MPI);
                    i = j;
                  }
                  m = i;
                  if (j != 0)
                  {
                    m = i;
                    if (paramArrayOfa[k].MPG.MQa > 0)
                    {
                      g.FJ(199L);
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
        if (paramArrayOfa[k].MPH.equals("setjscore"))
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
              localHashMap2.put(str, paramArrayOfa[k].MPI);
            }
            j += 1;
          }
        }
        if (paramArrayOfa[k].MPH.equals("setfullscreenvideo"))
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
              localHashMap3.put(str, paramArrayOfa[k].MPI);
            }
            j += 1;
          }
        }
        if (paramArrayOfa[k].MPH.equals("setTraceSampleRatioInTenThousand"))
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
              localHashMap4.put(str, paramArrayOfa[k].MPI);
            }
            j += 1;
          }
        }
        if (paramArrayOfa[k].MPH.equals("setEnabledTraceCategory"))
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
              localHashMap5.put(str, paramArrayOfa[k].MPI);
            }
            j += 1;
          }
        }
        a(paramArrayOfa[k], localHashMap6, localException);
        m = i;
      }
    }
    ajg(j);
    V(paramString, localHashMap6);
    AppMethodBeat.o(156697);
  }
  
  protected final Map<String, String> bbY(String paramString)
  {
    try
    {
      AppMethodBeat.i(156684);
      paramString = U(paramString, this.MLS);
      AppMethodBeat.o(156684);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public SharedPreferences geN()
  {
    AppMethodBeat.i(156678);
    SharedPreferences localSharedPreferences = XWalkEnvironment.getMMKVSharedTransportOld("XWEB.CMDCFG");
    AppMethodBeat.o(156678);
    return localSharedPreferences;
  }
  
  final void geO()
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
      this.MLS.clear();
      SharedPreferences localSharedPreferences = geN();
      MLQ = localSharedPreferences.getString("cStrTAGConfigVer", "");
      Object localObject1 = localSharedPreferences.getString("cStrTAGConfigSdkVer", "");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label390;
      }
      i = e.bcS((String)localObject1).intValue();
      MLR = i;
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
          this.MLS.put(str1, str2);
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
          localObject3 = bck(str2);
          break label222;
          label359:
          this.MLS.put(str1, localObject3);
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
  
  public String geP()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156681);
        StringBuilder localStringBuilder = new StringBuilder(512);
        Object localObject1 = this.MLS.keySet();
        localStringBuilder.append("strConfig ver = " + MLQ + "\n");
        localStringBuilder.append("strConfig sdk ver = " + MLR + "\n");
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
          String str2 = cg(bbY(str3));
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
    public boolean MLU = false;
    public Object MLV = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.a
 * JD-Core Version:    0.7.0.1
 */