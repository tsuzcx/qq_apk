package com.tencent.xweb;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.b.b;
import com.tencent.xweb.internal.j;
import com.tencent.xweb.internal.k.a;
import com.tencent.xweb.util.i;
import com.tencent.xweb.util.i.a;
import com.tencent.xweb.util.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkSharedPreferenceUtil;

public class a
{
  private static int aief = 0;
  private static String aieg = "";
  private static a aiei;
  protected Map<String, Object> aieh;
  
  public a()
  {
    AppMethodBeat.i(156676);
    this.aieh = new HashMap();
    AppMethodBeat.o(156676);
  }
  
  private void a(Map<String, Object> paramMap, SharedPreferences paramSharedPreferences)
  {
    for (;;)
    {
      Object localObject1;
      try
      {
        AppMethodBeat.i(212387);
        localObject1 = paramSharedPreferences.getAll();
        if ((localObject1 == null) || (((Map)localObject1).size() == 0))
        {
          AppMethodBeat.o(212387);
          return;
        }
        localObject1 = ((Map)localObject1).entrySet().iterator();
        localObject2 = new ArrayList();
        if (((Iterator)localObject1).hasNext())
        {
          ((ArrayList)localObject2).add((String)((Map.Entry)((Iterator)localObject1).next()).getKey());
          continue;
        }
        localObject1 = paramSharedPreferences.edit();
      }
      finally {}
      Object localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if ((!"cStrTAGConfigVer".equalsIgnoreCase(str)) && (!"cStrTAGConfigSdkVer".equalsIgnoreCase(str)) && (!"cStrSpKeyConfigsReady".equalsIgnoreCase(str)) && (!paramMap.containsKey(str))) {
          ((SharedPreferences.Editor)localObject1).remove(str);
        }
      }
      ((SharedPreferences.Editor)localObject1).commit();
      Log.i(getLogTag(), "clearOldCommandConfigs, remained section B size:" + paramSharedPreferences.getAll().size());
      AppMethodBeat.o(212387);
    }
  }
  
  private Map<String, String> ao(String paramString, Map<String, Object> paramMap)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(212429);
        if ((paramString == null) || (paramString.isEmpty()))
        {
          paramString = new HashMap();
          AppMethodBeat.o(212429);
          return paramString;
        }
        paramString = paramMap.get(paramString);
        if ((paramString instanceof HashMap))
        {
          paramString = (Map)paramString;
          AppMethodBeat.o(212429);
          continue;
        }
        paramString = new HashMap();
      }
      finally {}
      AppMethodBeat.o(212429);
    }
  }
  
  protected static boolean bHd(String paramString)
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
  
  public static String[] bHe(String paramString)
  {
    AppMethodBeat.i(212392);
    String[] arrayOfString = new String[2];
    if ((paramString == null) || (!paramString.contains(":")))
    {
      AppMethodBeat.o(212392);
      return null;
    }
    int i = paramString.indexOf(':');
    arrayOfString[0] = paramString.substring(0, i);
    if (paramString.length() - 1 <= i) {
      arrayOfString[1] = "";
    }
    for (;;)
    {
      AppMethodBeat.o(212392);
      return arrayOfString;
      arrayOfString[1] = paramString.substring(i + 1);
    }
  }
  
  private static Map<String, String> bHf(String paramString)
  {
    AppMethodBeat.i(212400);
    HashMap localHashMap = new HashMap();
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(212400);
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
    AppMethodBeat.o(212400);
    return localHashMap;
  }
  
  private static Map<String, String> bHg(String paramString)
  {
    AppMethodBeat.i(212404);
    HashMap localHashMap = new HashMap();
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(212404);
      return localHashMap;
    }
    paramString = paramString.split(";");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String[] arrayOfString = paramString[i];
      if ((arrayOfString != null) && (!arrayOfString.isEmpty()))
      {
        arrayOfString = arrayOfString.split(":");
        if ((arrayOfString.length == 2) && (arrayOfString[0] != null) && (arrayOfString[1] != null)) {
          localHashMap.put(arrayOfString[0], arrayOfString[1]);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(212404);
    return localHashMap;
  }
  
  private WebView.WebViewKind bHj(String paramString)
  {
    AppMethodBeat.i(212409);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramString = WebView.WebViewKind.aifH;
      AppMethodBeat.o(212409);
      return paramString;
    }
    WebView.WebViewKind localWebViewKind = WebView.WebViewKind.aifH;
    try
    {
      paramString = WebView.WebViewKind.valueOf(paramString);
      AppMethodBeat.o(212409);
      return paramString;
    }
    finally
    {
      for (;;)
      {
        Log.e(getLogTag(), "convertWebType error:".concat(String.valueOf(paramString)));
        paramString = localWebViewKind;
      }
    }
  }
  
  private Map<String, String> bHm(String paramString)
  {
    try
    {
      AppMethodBeat.i(212422);
      paramString = ao(paramString, this.aieh);
      AppMethodBeat.o(212422);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private static String dr(Map<String, String> paramMap)
  {
    AppMethodBeat.i(212396);
    if (paramMap == null)
    {
      AppMethodBeat.o(212396);
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
    AppMethodBeat.o(212396);
    return paramMap;
  }
  
  private static boolean h(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(212383);
    if ((paramSharedPreferences != null) && (paramSharedPreferences.contains("cStrSpKeyConfigsReady")))
    {
      paramSharedPreferences = paramSharedPreferences.getString("cStrSpKeyConfigsReady", "");
      if ((paramSharedPreferences != null) && (paramSharedPreferences.equalsIgnoreCase("true")))
      {
        AppMethodBeat.o(212383);
        return true;
      }
    }
    AppMethodBeat.o(212383);
    return false;
  }
  
  public static a keX()
  {
    try
    {
      AppMethodBeat.i(156677);
      if (aiei == null)
      {
        locala = new a();
        aiei = locala;
        locala.kfb();
      }
      a locala = aiei;
      AppMethodBeat.o(156677);
      return locala;
    }
    finally {}
  }
  
  public static void keY()
  {
    try
    {
      AppMethodBeat.i(185165);
      Log.i("CommandCfg", "resetCommandCfg, module: " + XWalkEnvironment.getModuleName());
      aiei = null;
      keX();
      AppMethodBeat.o(185165);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private String kfh()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156681);
        StringBuilder localStringBuilder = new StringBuilder(512);
        Object localObject1 = this.aieh.keySet();
        localStringBuilder.append(" config version = " + aieg + "\n");
        localStringBuilder.append(" config sdk version = " + aief + "\n");
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
          String str2 = dr(bHm(str3));
          localObject1 = str2;
          if (str2 == null) {
            localObject1 = "";
          }
          localStringBuilder.append(" [" + str3 + "] = ");
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
  
  private String qN(String paramString1, String paramString2)
  {
    Object localObject1;
    double d;
    try
    {
      AppMethodBeat.i(212417);
      localObject1 = bHm(paramString1);
      paramString1 = paramString2;
      if (!TextUtils.isEmpty(paramString2)) {
        break label344;
      }
      paramString2 = WebView.getCurStrModule();
      paramString1 = paramString2;
      if (!TextUtils.isEmpty(paramString2)) {
        break label344;
      }
      paramString1 = "tools";
    }
    finally {}
    paramString1 = "";
    AppMethodBeat.o(212417);
    label53:
    return paramString1;
    label57:
    paramString1 = (String)((Map)localObject1).get(paramString1);
    int k;
    int i;
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("[")) && (paramString1.contains("]")))
    {
      d = i.khC();
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
          break label365;
        }
        paramString1 = paramString1.trim();
        if (!paramString1.startsWith(";")) {
          break label341;
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
            break label266;
          }
        }
      }
      label266:
      label341:
      label344:
      label356:
      label363:
      for (;;)
      {
        localObject2 = new k.a((byte)0);
        ((k.a)localObject2).hYT = paramString2;
        ((k.a)localObject2).aikj = paramString1;
        if (!((k.a)localObject2).af(d)) {
          break label365;
        }
        AppMethodBeat.o(212417);
        paramString1 = paramString2;
        break label53;
        int m = localObject2.length;
        j = 0;
        for (;;)
        {
          if (j >= m) {
            break label363;
          }
          Object localObject3 = localObject2[j];
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject3 = j.bHR((String)localObject3);
            if (localObject3 != null)
            {
              paramString1.add(localObject3);
              break label356;
              paramString1 = "";
              AppMethodBeat.o(212417);
              break label53;
              AppMethodBeat.o(212417);
              break label53;
              break label157;
              if (localObject1 == null) {
                break;
              }
              if (paramString1 != null) {
                break label57;
              }
              break;
            }
          }
          j += 1;
        }
      }
      label365:
      i += 1;
    }
  }
  
  public final boolean Q(String paramString1, String paramString2, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(212545);
        paramString1 = qN(paramString1, paramString2);
        if (TextUtils.isEmpty(paramString1))
        {
          AppMethodBeat.o(212545);
          return paramBoolean;
        }
        if ("true".equalsIgnoreCase(paramString1))
        {
          paramBoolean = true;
          AppMethodBeat.o(212545);
          continue;
        }
        if (!"false".equalsIgnoreCase(paramString1)) {
          break label78;
        }
      }
      finally {}
      paramBoolean = false;
      AppMethodBeat.o(212545);
      continue;
      label78:
      AppMethodBeat.o(212545);
    }
  }
  
  public final void a(b.b[] paramArrayOfb, String paramString)
  {
    try
    {
      AppMethodBeat.i(156695);
      a(paramArrayOfb, paramString, false);
      AppMethodBeat.o(156695);
      return;
    }
    finally
    {
      paramArrayOfb = finally;
      throw paramArrayOfb;
    }
  }
  
  public final void a(b.b[] paramArrayOfb, String paramString, boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(212478);
      b(paramArrayOfb, paramString, paramBoolean);
      AppMethodBeat.o(212478);
      return;
    }
    finally
    {
      paramArrayOfb = finally;
      throw paramArrayOfb;
    }
  }
  
  protected final boolean a(b.b paramb, Map<String, Object> paramMap, String[] paramArrayOfString)
  {
    AppMethodBeat.i(212497);
    String str2 = paramb.aiiR;
    String str1 = paramb.aiiS;
    if (paramb.aiiR.equals("executeCommand"))
    {
      paramb = bHe(paramb.aiiS);
      if ((paramb == null) || (paramb.length < 2))
      {
        AppMethodBeat.o(212497);
        return false;
      }
      str2 = paramb[0];
      str1 = paramb[1];
    }
    if (TextUtils.isEmpty(str2))
    {
      AppMethodBeat.o(212497);
      return false;
    }
    paramb = ao(str2, paramMap);
    if ((paramb == null) || (paramb.isEmpty()))
    {
      paramb = new HashMap();
      paramMap.put(str2, paramb);
    }
    for (;;)
    {
      int i = 0;
      boolean bool = false;
      if (i < paramArrayOfString.length)
      {
        paramMap = paramArrayOfString[i].trim();
        if ((paramMap == null) || (paramMap.isEmpty()) || (paramb.containsKey(paramMap))) {
          break label195;
        }
        paramb.put(paramMap, str1);
        bool = true;
      }
      label195:
      for (;;)
      {
        i += 1;
        break;
        AppMethodBeat.o(212497);
        return bool;
      }
    }
  }
  
  public final void aJt(int paramInt)
  {
    AppMethodBeat.i(212549);
    Log.i(getLogTag(), "setCmdFetchConfigPeriodInMinutes, period:".concat(String.valueOf(paramInt)));
    XWalkSharedPreferenceUtil.getSharedPreferencesForUpdateConfig().edit().putInt("cStrSpKeyConfigPeriod", paramInt).commit();
    AppMethodBeat.o(212549);
  }
  
  public final int aU(String paramString1, String paramString2, int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(212543);
        paramString1 = qN(paramString1, paramString2);
        if (TextUtils.isEmpty(paramString1))
        {
          AppMethodBeat.o(212543);
          return paramInt;
        }
        paramString1 = i.bIb(paramString1);
        if ((paramString1 == null) || (!paramString1.aimD))
        {
          AppMethodBeat.o(212543);
          continue;
        }
        paramInt = paramString1.intValue();
      }
      finally {}
      AppMethodBeat.o(212543);
    }
  }
  
  protected final void an(String paramString, Map<String, Object> paramMap)
  {
    SharedPreferences.Editor localEditor;
    for (;;)
    {
      Map.Entry localEntry;
      Object localObject1;
      try
      {
        AppMethodBeat.i(212501);
        localEditor = kfa().edit();
        localEditor.putString("cStrSpKeyConfigsReady", "false");
        localEditor.commit();
        a(paramMap, kfa());
        localEditor.putString("cStrTAGConfigVer", paramString);
        localEditor.putString("cStrTAGConfigSdkVer", String.valueOf(ao.kge()));
        if (paramMap.isEmpty()) {
          Log.w(getLogTag(), "saveCommandConfigs, new command configs is empty");
        }
        Iterator localIterator = paramMap.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localEntry = (Map.Entry)localIterator.next();
        if ((localEntry.getKey() == null) || (((String)localEntry.getKey()).isEmpty())) {
          continue;
        }
        localObject1 = localEntry.getValue();
        if (localObject1 == null) {
          continue;
        }
        bool = localObject1 instanceof Map;
        if (bool)
        {
          try
          {
            Object localObject2 = (Map)localObject1;
            if (localObject2 == null) {
              continue;
            }
            localObject2 = dr((Map)localObject2);
            localEditor.putString((String)localEntry.getKey(), (String)localObject2);
            Log.i(getLogTag(), "saveCommandConfigs, command:" + (String)localEntry.getKey() + ", map:" + (String)localObject2);
            continue;
          }
          finally
          {
            localEditor.putString((String)localEntry.getKey(), localObject1.toString());
            Log.i(getLogTag(), "saveCommandConfigs error, command:" + (String)localEntry.getKey() + ", map:" + localObject1);
          }
          continue;
        }
        localEditor.putString((String)localEntry.getKey(), localObject1.toString());
      }
      finally {}
      Log.i(getLogTag(), "saveCommandConfigs, command:" + (String)localEntry.getKey() + ", map:" + localObject1);
    }
    localEditor.putString("cStrSpKeyConfigsReady", "true");
    boolean bool = localEditor.commit();
    if (bool)
    {
      aieg = paramString;
      this.aieh = paramMap;
    }
    Log.i(getLogTag(), "saveCommandConfigs, result:" + bool + ", sp size:" + kfa().getAll().size());
    AppMethodBeat.o(212501);
  }
  
  /* Error */
  protected void b(b.b[] paramArrayOfb, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 460
    //   5: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_2
    //   9: ifnonnull +22 -> 31
    //   12: aload_0
    //   13: invokevirtual 122	com/tencent/xweb/a:getLogTag	()Ljava/lang/String;
    //   16: ldc_w 462
    //   19: invokestatic 141	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: ldc_w 460
    //   25: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: aload_0
    //   32: invokevirtual 122	com/tencent/xweb/a:getLogTag	()Ljava/lang/String;
    //   35: new 124	java/lang/StringBuilder
    //   38: dup
    //   39: ldc_w 464
    //   42: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   45: aload_2
    //   46: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc_w 466
    //   52: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: iload_3
    //   56: invokevirtual 456	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   59: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 141	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: aload_0
    //   66: invokevirtual 469	com/tencent/xweb/a:kfc	()V
    //   69: new 37	java/util/HashMap
    //   72: dup
    //   73: invokespecial 38	java/util/HashMap:<init>	()V
    //   76: astore 8
    //   78: aload_1
    //   79: ifnull +8 -> 87
    //   82: aload_1
    //   83: arraylength
    //   84: ifne +34 -> 118
    //   87: aload_0
    //   88: invokevirtual 122	com/tencent/xweb/a:getLogTag	()Ljava/lang/String;
    //   91: ldc_w 471
    //   94: invokestatic 441	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: aload_0
    //   98: aload_2
    //   99: aload 8
    //   101: invokevirtual 473	com/tencent/xweb/a:an	(Ljava/lang/String;Ljava/util/Map;)V
    //   104: ldc_w 460
    //   107: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: goto -82 -> 28
    //   113: astore_1
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_1
    //   117: athrow
    //   118: iconst_m1
    //   119: istore 4
    //   121: iconst_0
    //   122: istore 5
    //   124: iload 5
    //   126: aload_1
    //   127: arraylength
    //   128: if_icmpge +373 -> 501
    //   131: aload_1
    //   132: iload 5
    //   134: aaload
    //   135: ifnull +400 -> 535
    //   138: iload_3
    //   139: ifeq +16 -> 155
    //   142: aload_1
    //   143: iload 5
    //   145: aaload
    //   146: getfield 376	com/tencent/xweb/internal/b$b:aiiR	Ljava/lang/String;
    //   149: invokestatic 475	com/tencent/xweb/a:bHd	(Ljava/lang/String;)Z
    //   152: ifne +383 -> 535
    //   155: aload_0
    //   156: invokevirtual 122	com/tencent/xweb/a:getLogTag	()Ljava/lang/String;
    //   159: new 124	java/lang/StringBuilder
    //   162: dup
    //   163: ldc_w 477
    //   166: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   169: iload 5
    //   171: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   174: ldc_w 479
    //   177: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_1
    //   181: iload 5
    //   183: aaload
    //   184: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 141	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: aload_1
    //   194: iload 5
    //   196: aaload
    //   197: getfield 483	com/tencent/xweb/internal/b$b:aiiB	Lcom/tencent/xweb/internal/b$d;
    //   200: iconst_0
    //   201: iconst_0
    //   202: ldc_w 268
    //   205: invokevirtual 489	com/tencent/xweb/internal/b$d:g	(ZZLjava/lang/String;)Z
    //   208: ifeq +327 -> 535
    //   211: invokestatic 495	com/tencent/xweb/internal/WebViewWrapperFactory:khn	()Lcom/tencent/xweb/internal/WebViewWrapperFactory$IWebViewProvider;
    //   214: astore 9
    //   216: aload 9
    //   218: ifnull +81 -> 299
    //   221: aload 9
    //   223: ldc_w 497
    //   226: iconst_1
    //   227: anewarray 4	java/lang/Object
    //   230: dup
    //   231: iconst_0
    //   232: aload_1
    //   233: iload 5
    //   235: aaload
    //   236: aastore
    //   237: invokeinterface 503 3 0
    //   242: checkcast 6	com/tencent/xweb/a$a
    //   245: astore 9
    //   247: aload 9
    //   249: ifnull +50 -> 299
    //   252: aload 9
    //   254: getfield 506	com/tencent/xweb/a$a:aiej	Z
    //   257: ifeq +42 -> 299
    //   260: aload_0
    //   261: invokevirtual 122	com/tencent/xweb/a:getLogTag	()Ljava/lang/String;
    //   264: new 124	java/lang/StringBuilder
    //   267: dup
    //   268: ldc_w 508
    //   271: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   274: aload_1
    //   275: iload 5
    //   277: aaload
    //   278: getfield 376	com/tencent/xweb/internal/b$b:aiiR	Ljava/lang/String;
    //   281: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: ldc_w 510
    //   287: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 141	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: goto +227 -> 523
    //   299: aload_1
    //   300: iload 5
    //   302: aaload
    //   303: getfield 379	com/tencent/xweb/internal/b$b:aiiS	Ljava/lang/String;
    //   306: ifnull +229 -> 535
    //   309: aload_1
    //   310: iload 5
    //   312: aaload
    //   313: getfield 513	com/tencent/xweb/internal/b$b:aiiT	Ljava/lang/String;
    //   316: ifnull +219 -> 535
    //   319: aload_1
    //   320: iload 5
    //   322: aaload
    //   323: getfield 513	com/tencent/xweb/internal/b$b:aiiT	Ljava/lang/String;
    //   326: invokevirtual 149	java/lang/String:isEmpty	()Z
    //   329: ifne +206 -> 535
    //   332: aload_1
    //   333: iload 5
    //   335: aaload
    //   336: getfield 513	com/tencent/xweb/internal/b$b:aiiT	Ljava/lang/String;
    //   339: ldc_w 515
    //   342: invokevirtual 192	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   345: astore 9
    //   347: aload_1
    //   348: iload 5
    //   350: aaload
    //   351: getfield 376	com/tencent/xweb/internal/b$b:aiiR	Ljava/lang/String;
    //   354: ldc_w 517
    //   357: invokevirtual 161	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   360: istore 7
    //   362: iload 7
    //   364: ifeq +68 -> 432
    //   367: aload_1
    //   368: iload 5
    //   370: aaload
    //   371: getfield 379	com/tencent/xweb/internal/b$b:aiiS	Ljava/lang/String;
    //   374: invokestatic 523	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   377: istore 6
    //   379: iload 6
    //   381: istore 4
    //   383: goto +140 -> 523
    //   386: astore 9
    //   388: aload_0
    //   389: invokevirtual 122	com/tencent/xweb/a:getLogTag	()Ljava/lang/String;
    //   392: new 124	java/lang/StringBuilder
    //   395: dup
    //   396: ldc_w 525
    //   399: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   402: aload_1
    //   403: iload 5
    //   405: aaload
    //   406: getfield 379	com/tencent/xweb/internal/b$b:aiiS	Ljava/lang/String;
    //   409: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: ldc_w 527
    //   415: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: aload 9
    //   420: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   423: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokestatic 227	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   429: goto +94 -> 523
    //   432: aload_1
    //   433: iload 5
    //   435: aaload
    //   436: getfield 376	com/tencent/xweb/internal/b$b:aiiR	Ljava/lang/String;
    //   439: ldc_w 529
    //   442: invokevirtual 161	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   445: ifeq +40 -> 485
    //   448: aload_0
    //   449: aload_1
    //   450: iload 5
    //   452: aaload
    //   453: aload 8
    //   455: aload 9
    //   457: invokevirtual 531	com/tencent/xweb/a:a	(Lcom/tencent/xweb/internal/b$b;Ljava/util/Map;[Ljava/lang/String;)Z
    //   460: ifeq +72 -> 532
    //   463: aload_1
    //   464: iload 5
    //   466: aaload
    //   467: getfield 483	com/tencent/xweb/internal/b$b:aiiB	Lcom/tencent/xweb/internal/b$d;
    //   470: getfield 534	com/tencent/xweb/internal/b$d:aijp	I
    //   473: ifle +59 -> 532
    //   476: ldc2_w 535
    //   479: invokestatic 542	com/tencent/xweb/util/l:Br	(J)V
    //   482: goto +50 -> 532
    //   485: aload_0
    //   486: aload_1
    //   487: iload 5
    //   489: aaload
    //   490: aload 8
    //   492: aload 9
    //   494: invokevirtual 531	com/tencent/xweb/a:a	(Lcom/tencent/xweb/internal/b$b;Ljava/util/Map;[Ljava/lang/String;)Z
    //   497: pop
    //   498: goto +37 -> 535
    //   501: aload_0
    //   502: iload 4
    //   504: invokevirtual 544	com/tencent/xweb/a:aJt	(I)V
    //   507: aload_0
    //   508: aload_2
    //   509: aload 8
    //   511: invokevirtual 473	com/tencent/xweb/a:an	(Ljava/lang/String;Ljava/util/Map;)V
    //   514: ldc_w 460
    //   517: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   520: goto -492 -> 28
    //   523: iload 5
    //   525: iconst_1
    //   526: iadd
    //   527: istore 5
    //   529: goto -405 -> 124
    //   532: goto -9 -> 523
    //   535: goto -12 -> 523
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	538	0	this	a
    //   0	538	1	paramArrayOfb	b.b[]
    //   0	538	2	paramString	String
    //   0	538	3	paramBoolean	boolean
    //   119	384	4	i	int
    //   122	406	5	j	int
    //   377	3	6	k	int
    //   360	3	7	bool	boolean
    //   76	434	8	localHashMap	HashMap
    //   214	132	9	localObject1	Object
    //   386	107	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	8	113	finally
    //   12	28	113	finally
    //   31	78	113	finally
    //   82	87	113	finally
    //   87	110	113	finally
    //   124	131	113	finally
    //   142	155	113	finally
    //   155	216	113	finally
    //   221	247	113	finally
    //   252	296	113	finally
    //   299	362	113	finally
    //   388	429	113	finally
    //   432	482	113	finally
    //   485	498	113	finally
    //   501	520	113	finally
    //   367	379	386	finally
  }
  
  public final WebView.WebViewKind bHh(String paramString)
  {
    AppMethodBeat.i(156686);
    paramString = bHj(qM("setwebtype", paramString));
    AppMethodBeat.o(156686);
    return paramString;
  }
  
  public final WebView.a bHi(String paramString)
  {
    AppMethodBeat.i(156688);
    paramString = bHk(qM("setfullscreenvideo", paramString));
    AppMethodBeat.o(156688);
    return paramString;
  }
  
  public final WebView.a bHk(String paramString)
  {
    AppMethodBeat.i(212538);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramString = WebView.a.aifF;
      AppMethodBeat.o(212538);
      return paramString;
    }
    WebView.a locala = WebView.a.aifF;
    try
    {
      paramString = WebView.a.valueOf(paramString);
      AppMethodBeat.o(212538);
      return paramString;
    }
    finally
    {
      for (;;)
      {
        Log.e(getLogTag(), "convertFullscreenVideo error:".concat(String.valueOf(paramString)));
        paramString = locala;
      }
    }
  }
  
  public final String bHl(String paramString)
  {
    try
    {
      AppMethodBeat.i(156691);
      String str2 = WebView.getCurStrModule();
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "tools";
      }
      paramString = qM(paramString, str1);
      AppMethodBeat.o(156691);
      return paramString;
    }
    finally {}
  }
  
  public final String getAbstractInfo()
  {
    AppMethodBeat.i(156680);
    try
    {
      String str = kfh();
      AppMethodBeat.o(156680);
      return str;
    }
    finally
    {
      Log.e(getLogTag(), "getAbstractInfo error:".concat(String.valueOf(localObject)));
      AppMethodBeat.o(156680);
    }
    return "";
  }
  
  protected String getLogTag()
  {
    return "CommandCfg";
  }
  
  protected SharedPreferences keZ()
  {
    AppMethodBeat.i(212446);
    SharedPreferences localSharedPreferences = XWalkSharedPreferenceUtil.getSharedPreferencesForCommandCfg();
    AppMethodBeat.o(212446);
    return localSharedPreferences;
  }
  
  protected SharedPreferences kfa()
  {
    AppMethodBeat.i(212452);
    SharedPreferences localSharedPreferences = XWalkSharedPreferenceUtil.getSharedPreferencesForCommandCfgLatest();
    AppMethodBeat.o(212452);
    return localSharedPreferences;
  }
  
  public final void kfb()
  {
    for (;;)
    {
      Object localObject2;
      String str1;
      try
      {
        AppMethodBeat.i(212463);
        Log.i(getLogTag(), "initCommandConfigs start");
        this.aieh.clear();
        SharedPreferences localSharedPreferences = kfa();
        if (!h(localSharedPreferences))
        {
          localSharedPreferences = keZ();
          if (!h(localSharedPreferences))
          {
            Log.w(getLogTag(), "initCommandConfigs, section A and B both not ready!!!");
            l.y(1749L, 46L, 1L);
            aieg = localSharedPreferences.getString("cStrTAGConfigVer", "");
            localObject2 = localSharedPreferences.getString("cStrTAGConfigSdkVer", "");
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break label514;
            }
            i = i.bIb((String)localObject2).intValue();
            aief = i;
            if (i >= 200502) {
              break label509;
            }
            Log.i(getLogTag(), "config sdk version(" + i + ") is old, use deserialize from old");
            i = 1;
            localObject2 = localSharedPreferences.getAll();
            if ((localObject2 == null) || (((Map)localObject2).size() == 0))
            {
              Log.i(getLogTag(), "initCommandConfigs end, empty command configs");
              AppMethodBeat.o(212463);
            }
          }
          else
          {
            Log.i(getLogTag(), "initCommandConfigs, section A is ready");
            l.y(1749L, 47L, 1L);
            continue;
          }
        }
        else
        {
          Log.i(getLogTag(), "initCommandConfigs, section B is ready");
          l.y(1749L, 48L, 1L);
          continue;
        }
        Iterator localIterator = ((Map)localObject2).entrySet().iterator();
        if (!localIterator.hasNext()) {
          break label444;
        }
        str1 = (String)((Map.Entry)localIterator.next()).getKey();
        String str2 = localSharedPreferences.getString(str1, "");
        if ((str1 == null) || (str2 == null)) {
          continue;
        }
        if (i != 0)
        {
          localObject2 = bHg(str2);
          if ((localObject2 != null) && (((Map)localObject2).size() != 0)) {
            break label393;
          }
          Log.i(getLogTag(), "initCommandConfigs, command:" + str1 + ", value:" + str2);
          this.aieh.put(str1, str2);
          continue;
        }
        localObject2 = bHf(str2);
      }
      finally {}
      continue;
      label393:
      Log.i(getLogTag(), "initCommandConfigs, command:" + str1 + ", map:" + localObject2);
      this.aieh.put(str1, localObject2);
      continue;
      label444:
      Log.i(getLogTag(), "initCommandConfigs end, config version:" + aieg + ", config sdk version:" + aief + ", config map size:" + this.aieh.size());
      AppMethodBeat.o(212463);
      continue;
      label509:
      int i = 0;
      continue;
      label514:
      i = 0;
    }
  }
  
  protected final void kfc()
  {
    for (;;)
    {
      SharedPreferences localSharedPreferences;
      Object localObject2;
      try
      {
        AppMethodBeat.i(212508);
        if (!h(kfa()))
        {
          Log.i(getLogTag(), "forkSectionBToSectionAIfNeed, section B not ready, ignore");
          AppMethodBeat.o(212508);
          return;
        }
        SharedPreferences.Editor localEditor = keZ().edit();
        localEditor.putString("cStrSpKeyConfigsReady", "false");
        localEditor.commit();
        localSharedPreferences = kfa();
        localObject2 = localSharedPreferences.getAll();
        if ((localObject2 == null) || (((Map)localObject2).size() == 0))
        {
          Log.i(getLogTag(), "forkSectionBToSectionAIfNeed, empty command configs");
          localEditor.putString("cStrSpKeyConfigsReady", "true");
          localEditor.commit();
          Log.i(getLogTag(), "forkSectionBToSectionAIfNeed, forked section A size:" + keZ().getAll().size());
          AppMethodBeat.o(212508);
          continue;
        }
        localObject2 = ((Map)localObject2).entrySet().iterator();
      }
      finally {}
      while (((Iterator)localObject2).hasNext())
      {
        String str1 = (String)((Map.Entry)((Iterator)localObject2).next()).getKey();
        String str2 = localSharedPreferences.getString(str1, "");
        if ((str1 != null) && (!str1.equalsIgnoreCase("cStrSpKeyConfigsReady"))) {
          localObject1.putString(str1, String.valueOf(str2));
        }
      }
    }
  }
  
  public final boolean kfd()
  {
    AppMethodBeat.i(212522);
    boolean bool = Q("fullscreen_video_enable_mute", "tools", false);
    AppMethodBeat.o(212522);
    return bool;
  }
  
  public final boolean kfe()
  {
    AppMethodBeat.i(212528);
    boolean bool = Q("fullscreen_video_enable_speed", "tools", false);
    AppMethodBeat.o(212528);
    return bool;
  }
  
  public final boolean kff()
  {
    AppMethodBeat.i(212533);
    boolean bool = Q("fullscreen_video_enable_init_channels_try_runtime", "tools", true);
    AppMethodBeat.o(212533);
    return bool;
  }
  
  public final int kfg()
  {
    AppMethodBeat.i(156683);
    int i = XWalkSharedPreferenceUtil.getSharedPreferencesForUpdateConfig().getInt("cStrSpKeyConfigPeriod", -1);
    Log.i(getLogTag(), "getCmdFetchConfigPeriodMills, period:".concat(String.valueOf(i)));
    if (i <= 30)
    {
      AppMethodBeat.o(156683);
      return -1;
    }
    AppMethodBeat.o(156683);
    return i * 60 * 1000;
  }
  
  public final String qM(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(156692);
      paramString1 = qN(paramString1, paramString2);
      AppMethodBeat.o(156692);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static final class a
  {
    public boolean aiej = false;
    public Object aiek = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.a
 * JD-Core Version:    0.7.0.1
 */