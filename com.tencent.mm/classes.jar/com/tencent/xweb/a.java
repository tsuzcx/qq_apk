package com.tencent.xweb;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.a.b;
import com.tencent.xweb.c.l;
import com.tencent.xweb.c.l.a;
import com.tencent.xweb.util.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class a
{
  static boolean BCP;
  static String BCQ;
  static Map<String, Object> BCR;
  static String[] BCS;
  
  static
  {
    AppMethodBeat.i(3794);
    BCP = false;
    BCQ = "";
    BCR = new HashMap();
    BCS = new String[] { "disable_url_watchdog" };
    AppMethodBeat.o(3794);
  }
  
  private static Map<String, String> K(String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(3774);
    init();
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramString = new HashMap();
      AppMethodBeat.o(3774);
      return paramString;
    }
    paramString = paramMap.get(paramString);
    if ((paramString instanceof HashMap))
    {
      paramString = (Map)paramString;
      AppMethodBeat.o(3774);
      return paramString;
    }
    paramString = new HashMap();
    AppMethodBeat.o(3774);
    return paramString;
  }
  
  private static void L(String paramString, Map<String, Object> paramMap)
  {
    try
    {
      AppMethodBeat.i(3791);
      BCQ = paramString;
      BCR = paramMap;
      dYf();
      AppMethodBeat.o(3791);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void Ty(int paramInt)
  {
    AppMethodBeat.i(3771);
    XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit().putInt("cStrSpKeyConfigPeriod", paramInt).commit();
    AppMethodBeat.o(3771);
  }
  
  public static void a(com.tencent.xweb.c.a.a[] paramArrayOfa, String paramString)
  {
    AppMethodBeat.i(3783);
    a(paramArrayOfa, paramString, false);
    AppMethodBeat.o(3783);
  }
  
  public static void a(com.tencent.xweb.c.a.a[] paramArrayOfa, String paramString, boolean paramBoolean)
  {
    HashMap localHashMap1;
    HashMap localHashMap2;
    HashMap localHashMap3;
    HashMap localHashMap4;
    HashMap localHashMap5;
    HashMap localHashMap6;
    try
    {
      AppMethodBeat.i(3784);
      init();
      if (paramString == null) {
        AppMethodBeat.o(3784);
      }
      for (;;)
      {
        return;
        localHashMap1 = new HashMap();
        localHashMap2 = new HashMap();
        localHashMap3 = new HashMap();
        localHashMap4 = new HashMap();
        localHashMap5 = new HashMap();
        localHashMap6 = new HashMap();
        localHashMap6.put("setwebtype", localHashMap1);
        localHashMap6.put("setjscore", localHashMap2);
        localHashMap6.put("setfullscreenvideo", localHashMap3);
        localHashMap6.put("setTraceSampleRatioInTenThousand", localHashMap4);
        localHashMap6.put("setEnabledTraceCategory", localHashMap5);
        if ((paramArrayOfa != null) && (paramArrayOfa.length != 0)) {
          break;
        }
        L(paramString, localHashMap6);
        AppMethodBeat.o(3784);
      }
      j = -1;
    }
    finally {}
    int j;
    int m = 0;
    int k;
    int i;
    String[] arrayOfString;
    label392:
    int n;
    label532:
    label550:
    Object localObject2;
    label631:
    String str;
    label712:
    Object localObject3;
    if (m < paramArrayOfa.length)
    {
      k = j;
      if (paramArrayOfa[m] == null) {
        break label1075;
      }
      if (paramBoolean)
      {
        if (!"revertToVersion".equals(paramArrayOfa[m].BGk)) {
          break label1108;
        }
        i = 1;
        break label1084;
      }
      k = j;
      if (!paramArrayOfa[m].BGj.dYM()) {
        break label1075;
      }
      Object localObject1 = (a.a)l.e(WebView.d.BEq).excute("STR_CMD_EXXCUTE_CMD_FROM_CONFIG", new Object[] { paramArrayOfa[m] });
      if (localObject1 != null)
      {
        k = j;
        if (((a.a)localObject1).cyy) {
          break label1075;
        }
      }
      k = j;
      if (paramArrayOfa[m].BGl == null) {
        break label1075;
      }
      boolean bool = paramArrayOfa[m].BGk.equals("setConfigPeriod");
      i = j;
      if (bool) {}
      try
      {
        i = Integer.parseInt(paramArrayOfa[m].BGl);
        k = i;
        if (paramArrayOfa[m].BGm == null) {
          break label1075;
        }
        k = i;
        if (paramArrayOfa[m].BGm.isEmpty()) {
          break label1075;
        }
        arrayOfString = paramArrayOfa[m].BGm.split(",");
        if (!paramArrayOfa[m].BGk.equals("setwebtype")) {
          break label532;
        }
        k = 0;
        j = 0;
        if (j < arrayOfString.length)
        {
          localObject1 = arrayOfString[j].trim();
          n = k;
          if (localObject1 == null) {
            break label1095;
          }
          n = k;
          if (((String)localObject1).isEmpty()) {
            break label1095;
          }
          n = k;
          if (localHashMap1.containsKey(localObject1)) {
            break label1095;
          }
          localHashMap1.put(localObject1, paramArrayOfa[m].BGl);
          n = 1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("CommandCfg", "parse pariod cmdvalue to int failed , value is " + paramArrayOfa[m].BGl);
          i = j;
        }
        if (k == 0) {
          break label1113;
        }
      }
      if (paramArrayOfa[m].BGj.BGz <= 0) {
        break label1113;
      }
      f.pf(199L);
      break label1113;
      if (paramArrayOfa[m].BGk.equals("setjscore"))
      {
        j = 0;
        if (j >= arrayOfString.length) {
          break label1134;
        }
        localObject2 = arrayOfString[j].trim();
        if ((localObject2 == null) || (((String)localObject2).isEmpty()) || (localHashMap2.containsKey(localObject2))) {
          break label1125;
        }
        localHashMap2.put(localObject2, paramArrayOfa[m].BGl);
        break label1125;
      }
      if (paramArrayOfa[m].BGk.equals("setfullscreenvideo"))
      {
        j = 0;
        if (j >= arrayOfString.length) {
          break label1146;
        }
        localObject2 = arrayOfString[j].trim();
        if ((localObject2 == null) || (((String)localObject2).isEmpty()) || (localHashMap3.containsKey(localObject2))) {
          break label1137;
        }
        localHashMap3.put(localObject2, paramArrayOfa[m].BGl);
        break label1137;
      }
      if (paramArrayOfa[m].BGk.equals("setTraceSampleRatioInTenThousand"))
      {
        j = 0;
        if (j >= arrayOfString.length) {
          break label1158;
        }
        localObject2 = arrayOfString[j].trim();
        if ((localObject2 == null) || (((String)localObject2).isEmpty()) || (localHashMap4.containsKey(localObject2))) {
          break label1149;
        }
        localHashMap4.put(localObject2, paramArrayOfa[m].BGl);
        break label1149;
      }
      if (paramArrayOfa[m].BGk.equals("setEnabledTraceCategory"))
      {
        j = 0;
        label793:
        if (j >= arrayOfString.length) {
          break label1170;
        }
        localObject2 = arrayOfString[j].trim();
        if ((localObject2 == null) || (((String)localObject2).isEmpty()) || (localHashMap5.containsKey(localObject2))) {
          break label1161;
        }
        localHashMap5.put(localObject2, paramArrayOfa[m].BGl);
        break label1161;
      }
      str = paramArrayOfa[m].BGk;
      localObject2 = paramArrayOfa[m].BGl;
      if (!paramArrayOfa[m].BGk.equals("executeCommand")) {
        break label1081;
      }
      localObject2 = axO(paramArrayOfa[m].BGl);
      k = i;
      if (localObject2 == null) {
        break label1075;
      }
      k = i;
      if (localObject2.length < 2) {
        break label1075;
      }
      str = localObject2[0];
      localObject2 = localObject2[1];
      label931:
      k = i;
      if (TextUtils.isEmpty(str)) {
        break label1075;
      }
      Map localMap = K(str, localHashMap6);
      if (localMap != null)
      {
        localObject3 = localMap;
        if (!localMap.isEmpty()) {
          break label1173;
        }
      }
      localObject3 = new HashMap();
      localHashMap6.put(str, localObject3);
      break label1173;
    }
    for (;;)
    {
      k = i;
      if (j < arrayOfString.length)
      {
        str = arrayOfString[j].trim();
        if ((str == null) || (str.isEmpty()) || (((Map)localObject3).containsKey(str))) {
          break label1179;
        }
        ((Map)localObject3).put(str, localObject2);
        break label1179;
        Ty(j);
        L(paramString, localHashMap6);
        AppMethodBeat.o(3784);
        break;
      }
      label1075:
      i = k;
      break label1113;
      label1081:
      break label931;
      for (;;)
      {
        label1084:
        k = j;
        if (i != 0) {
          break label1075;
        }
        break;
        label1095:
        j += 1;
        k = n;
        break label392;
        label1108:
        i = 0;
      }
      label1158:
      label1161:
      label1170:
      for (;;)
      {
        label1113:
        m += 1;
        j = i;
        break;
        label1125:
        j += 1;
        break label550;
        label1134:
        continue;
        label1137:
        j += 1;
        break label631;
        label1146:
        continue;
        label1149:
        j += 1;
        break label712;
        continue;
        j += 1;
        break label793;
      }
      label1173:
      j = 0;
      continue;
      label1179:
      j += 1;
    }
  }
  
  private static Map<String, String> axG(String paramString)
  {
    try
    {
      AppMethodBeat.i(3773);
      paramString = K(paramString, BCR);
      AppMethodBeat.o(3773);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static WebView.d axH(String paramString)
  {
    AppMethodBeat.i(3775);
    init();
    paramString = axP(iW("setwebtype", paramString));
    AppMethodBeat.o(3775);
    return paramString;
  }
  
  public static k.a axI(String paramString)
  {
    AppMethodBeat.i(3776);
    init();
    paramString = axQ(iW("setjscore", paramString));
    AppMethodBeat.o(3776);
    return paramString;
  }
  
  public static WebView.a axJ(String paramString)
  {
    AppMethodBeat.i(3777);
    init();
    paramString = axR(iW("setfullscreenvideo", paramString));
    AppMethodBeat.o(3777);
    return paramString;
  }
  
  public static d.a axK(String paramString)
  {
    AppMethodBeat.i(3778);
    init();
    paramString = axS(iW("fr_" + paramString.toLowerCase(), "tools"));
    AppMethodBeat.o(3778);
    return paramString;
  }
  
  public static int axL(String paramString)
  {
    AppMethodBeat.i(3779);
    init();
    paramString = iW("setTraceSampleRatioInTenThousand", paramString);
    if ((TextUtils.isEmpty(paramString)) || (!TextUtils.isDigitsOnly(paramString)))
    {
      AppMethodBeat.o(3779);
      return 0;
    }
    int i = Integer.parseInt(paramString);
    AppMethodBeat.o(3779);
    return i;
  }
  
  public static String axM(String paramString)
  {
    AppMethodBeat.i(3780);
    init();
    paramString = iW("setEnabledTraceCategory", paramString);
    AppMethodBeat.o(3780);
    return paramString;
  }
  
  public static String axN(String paramString)
  {
    AppMethodBeat.i(3781);
    String str2 = WebView.getCurStrModule();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "tools";
    }
    paramString = iW(paramString, str1);
    AppMethodBeat.o(3781);
    return paramString;
  }
  
  public static String[] axO(String paramString)
  {
    AppMethodBeat.i(3785);
    String[] arrayOfString = new String[2];
    if ((paramString == null) || (!paramString.contains(":")))
    {
      AppMethodBeat.o(3785);
      return null;
    }
    int i = paramString.indexOf(':');
    arrayOfString[0] = paramString.substring(0, i);
    if (paramString.length() - 1 <= i) {
      arrayOfString[1] = "";
    }
    for (;;)
    {
      AppMethodBeat.o(3785);
      return arrayOfString;
      arrayOfString[1] = paramString.substring(i + 1);
    }
  }
  
  private static WebView.d axP(String paramString)
  {
    AppMethodBeat.i(3786);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramString = WebView.d.BEp;
      AppMethodBeat.o(3786);
      return paramString;
    }
    WebView.d locald = WebView.d.BEp;
    try
    {
      paramString = WebView.d.valueOf(paramString);
      AppMethodBeat.o(3786);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = locald;
      }
    }
  }
  
  private static k.a axQ(String paramString)
  {
    AppMethodBeat.i(3787);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramString = k.a.BDo;
      AppMethodBeat.o(3787);
      return paramString;
    }
    k.a locala = k.a.BDo;
    try
    {
      paramString = k.a.valueOf(paramString);
      AppMethodBeat.o(3787);
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
  
  private static WebView.a axR(String paramString)
  {
    AppMethodBeat.i(3788);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramString = WebView.a.BEn;
      AppMethodBeat.o(3788);
      return paramString;
    }
    WebView.a locala = WebView.a.BEn;
    try
    {
      paramString = WebView.a.valueOf(paramString);
      AppMethodBeat.o(3788);
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
  
  static d.a axS(String paramString)
  {
    AppMethodBeat.i(3789);
    d.a locala = d.a.BDa;
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(3789);
      return locala;
    }
    try
    {
      paramString = d.a.valueOf(paramString);
      AppMethodBeat.o(3789);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = d.a.BDa;
      }
    }
  }
  
  private static String ba(Map<String, String> paramMap)
  {
    AppMethodBeat.i(3790);
    if (paramMap == null)
    {
      AppMethodBeat.o(3790);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(128);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (localStringBuilder.length() != 0) {
        localStringBuilder.append(";");
      }
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append(":");
      localStringBuilder.append((String)localEntry.getValue());
    }
    paramMap = localStringBuilder.toString();
    AppMethodBeat.o(3790);
    return paramMap;
  }
  
  private static void dYb()
  {
    label274:
    label290:
    label299:
    label304:
    for (;;)
    {
      label80:
      String str1;
      HashMap localHashMap;
      try
      {
        AppMethodBeat.i(3768);
        BCR.clear();
        SharedPreferences localSharedPreferences = XWalkEnvironment.getMMKVSharedTransportOld("XWEB.CMDCFG");
        BCQ = localSharedPreferences.getString("cStrTAGConfigVer", "");
        Object localObject2 = localSharedPreferences.getAll();
        if ((localObject2 == null) || (((Map)localObject2).size() == 0))
        {
          AppMethodBeat.o(3768);
          return;
        }
        localObject2 = ((Map)localObject2).entrySet().iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label290;
        }
        str1 = (String)((Map.Entry)((Iterator)localObject2).next()).getKey();
        String str2 = localSharedPreferences.getString(str1, "");
        if ((str1 == null) || (str2 == null)) {
          continue;
        }
        localHashMap = new HashMap();
        if ((str2 == null) || (str2.isEmpty()))
        {
          if (localHashMap.size() != 0) {
            break label274;
          }
          BCR.put(str1, str2);
          continue;
        }
        arrayOfString = str2.split(";");
      }
      finally {}
      String[] arrayOfString;
      int j = arrayOfString.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label304;
        }
        Object localObject3 = arrayOfString[i];
        if ((localObject3 != null) && (!((String)localObject3).isEmpty()))
        {
          localObject3 = ((String)localObject3).split(":");
          if ((localObject3.length == 2) && (localObject3[0] != null) && (localObject3[1] != null))
          {
            localHashMap.put(localObject3[0], localObject3[1]);
            break label299;
            BCR.put(str1, localHashMap);
            break label80;
            AppMethodBeat.o(3768);
            break;
          }
        }
        i += 1;
      }
    }
  }
  
  private static String dYc()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(3770);
        StringBuilder localStringBuilder = new StringBuilder(512);
        Object localObject1 = BCR.keySet();
        if (localObject1 == null)
        {
          localObject1 = "";
          AppMethodBeat.o(3770);
          return localObject1;
        }
        Iterator localIterator = ((Set)localObject1).iterator();
        if (localIterator.hasNext())
        {
          String str3 = (String)localIterator.next();
          if (TextUtils.isEmpty(str3)) {
            continue;
          }
          String str2 = ba(axG(str3));
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
      AppMethodBeat.o(3770);
    }
  }
  
  public static int dYd()
  {
    AppMethodBeat.i(3772);
    int i = XWalkEnvironment.getSharedPreferencesForUpdateConfig().getInt("cStrSpKeyConfigPeriod", -1);
    if (i <= 30)
    {
      AppMethodBeat.o(3772);
      return -1;
    }
    AppMethodBeat.o(3772);
    return i * 60 * 1000;
  }
  
  private static void dYe()
  {
    for (;;)
    {
      Object localObject3;
      try
      {
        AppMethodBeat.i(3792);
        Object localObject1 = XWalkEnvironment.getMMKVSharedTransportOld("XWEB.CMDCFG").getAll();
        if ((localObject1 == null) || (((Map)localObject1).size() == 0))
        {
          AppMethodBeat.o(3792);
          return;
        }
        localObject3 = ((Map)localObject1).entrySet().iterator();
        localObject1 = new ArrayList();
        if (((Iterator)localObject3).hasNext())
        {
          ((ArrayList)localObject1).add((String)((Map.Entry)((Iterator)localObject3).next()).getKey());
          continue;
        }
        localObject3 = XWalkEnvironment.getMMKVSharedTransportOld("XWEB.CMDCFG").edit();
      }
      finally {}
      Iterator localIterator = localObject2.iterator();
      while (localIterator.hasNext()) {
        ((SharedPreferences.Editor)localObject3).remove((String)localIterator.next());
      }
      ((SharedPreferences.Editor)localObject3).commit();
      AppMethodBeat.o(3792);
    }
  }
  
  private static void dYf()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(3793);
        dYe();
        SharedPreferences.Editor localEditor = XWalkEnvironment.getMMKVSharedTransportOld("XWEB.CMDCFG").edit();
        localEditor.putString("cStrTAGConfigVer", BCQ);
        Iterator localIterator = BCR.entrySet().iterator();
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
                localEditor.putString((String)localEntry.getKey(), ba(localMap));
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
    XWalkEnvironment.addXWalkInitializeLog(dYc());
    AppMethodBeat.o(3793);
  }
  
  public static String getAbstractInfo()
  {
    AppMethodBeat.i(3769);
    init();
    String str = dYc();
    AppMethodBeat.o(3769);
    return str;
  }
  
  /* Error */
  public static String iW(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: sipush 3782
    //   6: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 51	com/tencent/xweb/a:init	()V
    //   12: aload_0
    //   13: invokestatic 393	com/tencent/xweb/a:axG	(Ljava/lang/String;)Ljava/util/Map;
    //   16: astore_0
    //   17: aload_0
    //   18: ifnull +7 -> 25
    //   21: aload_1
    //   22: ifnonnull +17 -> 39
    //   25: ldc 27
    //   27: astore_0
    //   28: sipush 3782
    //   31: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: ldc 2
    //   36: monitorexit
    //   37: aload_0
    //   38: areturn
    //   39: aload_0
    //   40: aload_1
    //   41: invokeinterface 61 2 0
    //   46: checkcast 38	java/lang/String
    //   49: astore_0
    //   50: sipush 3782
    //   53: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: goto -22 -> 34
    //   59: astore_0
    //   60: ldc 2
    //   62: monitorexit
    //   63: aload_0
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	paramString1	String
    //   0	65	1	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   3	17	59	finally
    //   28	34	59	finally
    //   39	56	59	finally
  }
  
  private static void init()
  {
    AppMethodBeat.i(3767);
    if (BCP)
    {
      AppMethodBeat.o(3767);
      return;
    }
    BCP = true;
    dYb();
    AppMethodBeat.o(3767);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.a
 * JD-Core Version:    0.7.0.1
 */