package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.adw;
import com.tencent.mm.kernel.f;
import com.tencent.mm.protocal.protobuf.ghy;
import com.tencent.mm.protocal.protobuf.ghz;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class al
{
  private static HashMap<String, at.a> Wpn;
  private static Map<String, JSONObject> Wpo;
  private static ac Wpp;
  private static HashMap<String, Long> Wpq;
  private static String Wpr;
  private static com.tencent.mm.am.h maV;
  
  static
  {
    AppMethodBeat.i(117722);
    Wpn = new HashMap();
    Wpo = new HashMap();
    Wpn.put("zh_CN", at.a.acQU);
    Wpn.put("zh_HK", at.a.acQW);
    Wpn.put("zh_TW", at.a.acQV);
    Wpn.put("en", at.a.acQX);
    Wpn.put("ar", at.a.acQY);
    Wpn.put("de", at.a.acQZ);
    Wpn.put("de_DE", at.a.acRa);
    Wpn.put("es", at.a.acRb);
    Wpn.put("fr", at.a.acRc);
    Wpn.put("he", at.a.acRd);
    Wpn.put("hi", at.a.acRe);
    Wpn.put("id", at.a.acRf);
    Wpn.put("in", at.a.acRg);
    Wpn.put("it", at.a.acRh);
    Wpn.put("iw", at.a.acRi);
    Wpn.put("ja", at.a.acRj);
    Wpn.put("ko", at.a.acRk);
    Wpn.put("lo", at.a.acRl);
    Wpn.put("ms", at.a.acRm);
    Wpn.put("my", at.a.acRn);
    Wpn.put("pl", at.a.acRo);
    Wpn.put("pt", at.a.acRp);
    Wpn.put("ru", at.a.acRq);
    Wpn.put("th", at.a.acRr);
    Wpn.put("tr", at.a.acRs);
    Wpn.put("vi", at.a.acRt);
    Wpr = "";
    maV = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(117709);
        Log.i("MicroMsg.WebSearch.WebSearchConfigLogic", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousp instanceof ac))
        {
          com.tencent.mm.kernel.h.aZW().b(1948, al.hul());
          paramAnonymousString = new adw();
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            break label159;
          }
          Object localObject = (ac)paramAnonymousp;
          paramAnonymousp = ((ac)localObject).WoE;
          localObject = ((ac)localObject).WoD;
          Log.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfig onSceneEnd %s", new Object[] { paramAnonymousp.aayd });
          if (al.nU(((ghy)localObject).yts, paramAnonymousp.aayd) != al.a.Wps) {
            break label148;
          }
          paramAnonymousString.iij.result = 0;
        }
        for (;;)
        {
          paramAnonymousString.publish();
          AppMethodBeat.o(117709);
          return;
          label148:
          paramAnonymousString.iij.result = -1;
          continue;
          label159:
          paramAnonymousString.iij.result = -1;
        }
      }
    };
    AppMethodBeat.o(117722);
  }
  
  private static JSONObject biv(String paramString)
  {
    AppMethodBeat.i(117714);
    if ((Wpo.containsKey(paramString)) && (Wpo.get(paramString) != null))
    {
      paramString = (JSONObject)Wpo.get(paramString);
      AppMethodBeat.o(117714);
      return paramString;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      Wpo.put(paramString, localJSONObject);
      AppMethodBeat.o(117714);
      return localJSONObject;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchConfigLogic", paramString, "", new Object[0]);
      AppMethodBeat.o(117714);
    }
    return null;
  }
  
  private static at.a biw(String paramString)
  {
    AppMethodBeat.i(117715);
    at.a locala = (at.a)Wpn.get(paramString);
    paramString = locala;
    if (locala == null) {
      paramString = at.a.acQX;
    }
    AppMethodBeat.o(117715);
    return paramString;
  }
  
  public static JSONObject bix(String paramString)
  {
    localObject3 = null;
    AppMethodBeat.i(117717);
    String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    try
    {
      localObject1 = (String)com.tencent.mm.kernel.h.baE().ban().get(biw(str), null);
      if (Util.isNullOrNil((String)localObject1)) {
        break label146;
      }
      localObject1 = biv((String)localObject1).optJSONObject("data").optJSONObject(paramString);
      localObject4 = "Config Storage";
      localObject3 = localObject1;
      localObject1 = localObject4;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject4;
        Object localObject2 = "";
        continue;
        Object localObject5 = localObject3;
        localObject3 = localObject2;
        localObject2 = localObject5;
      }
    }
    if (localObject3 == null)
    {
      try
      {
        localObject4 = iqc();
        if (localObject4 == null) {
          break label165;
        }
        localObject4 = new JSONObject((String)localObject4).optJSONObject("data").optJSONObject(paramString);
        localObject1 = localObject4;
        localObject3 = "Asset";
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localObject5 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject5;
        }
      }
      if (localObject1 == null)
      {
        localObject1 = new JSONObject();
        Log.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigKeyObj %s %s %s", new Object[] { str, paramString, localObject3 });
        AppMethodBeat.o(117717);
        return localObject1;
      }
    }
  }
  
  public static String biy(String paramString)
  {
    Object localObject3 = null;
    AppMethodBeat.i(117718);
    String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    try
    {
      localObject1 = (String)com.tencent.mm.kernel.h.baE().ban().get(biw(str), null);
      if (Util.isNullOrNil((String)localObject1)) {
        break label139;
      }
      localObject1 = biv((String)localObject1);
      localObject4 = "Config Storage";
      localObject3 = localObject1;
      localObject1 = localObject4;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject4;
        localObject2 = "";
      }
    }
    if (localObject3 == null) {}
    for (;;)
    {
      try
      {
        localObject4 = iqc();
        if (localObject4 == null) {
          break label171;
        }
        localObject4 = new JSONObject((String)localObject4);
        localObject3 = "Asset";
        localObject1 = localObject4;
      }
      catch (Exception localException2)
      {
        label139:
        localObject5 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject5;
        continue;
        paramString = paramString.toString();
        AppMethodBeat.o(117718);
        return paramString;
      }
      if (localObject1 == null)
      {
        localObject1 = new JSONObject();
        Log.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", new Object[] { str, paramString, localObject3 });
        paramString = ((JSONObject)localObject1).opt(paramString);
        if (paramString == null)
        {
          AppMethodBeat.o(117718);
          return "";
        }
      }
      continue;
      label171:
      Object localObject5 = localObject3;
      localObject3 = localObject2;
      Object localObject2 = localObject5;
    }
  }
  
  public static String biz(String paramString)
  {
    AppMethodBeat.i(117720);
    JSONObject localJSONObject = bix("entranceWording");
    if (localJSONObject != null)
    {
      paramString = localJSONObject.optString(paramString);
      AppMethodBeat.o(117720);
      return paramString;
    }
    AppMethodBeat.o(117720);
    return null;
  }
  
  public static boolean cj(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(315332);
    if (Wpq == null) {
      Wpq = new HashMap();
    }
    String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    if ((paramBoolean) || ((Wpr != null) && (!Wpr.equalsIgnoreCase(str)))) {
      Log.i("MicroMsg.WebSearch.WebSearchConfigLogic", "force update cfg %s %s %s", new Object[] { Wpr, str, Boolean.valueOf(paramBoolean) });
    }
    for (;;)
    {
      Wpr = str;
      if (Wpp != null)
      {
        com.tencent.mm.kernel.h.aZW().a(Wpp);
        Wpp = null;
      }
      Wpp = new ac(paramInt);
      com.tencent.mm.kernel.h.aZW().a(1948, maV);
      com.tencent.mm.kernel.h.aZW().a(Wpp, 0);
      AppMethodBeat.o(315332);
      return true;
      Long localLong = (Long)Wpq.get(str);
      Object localObject = localLong;
      if (localLong == null) {
        localObject = Long.valueOf(0L);
      }
      if (System.currentTimeMillis() - ((Long)localObject).longValue() < 600000L)
      {
        AppMethodBeat.o(315332);
        return false;
      }
      long l = System.currentTimeMillis();
      Wpq.put(str, Long.valueOf(l));
      Log.i("MicroMsg.WebSearch.WebSearchConfigLogic", "startToRequestConfig %s %d %d", new Object[] { str, Integer.valueOf(paramInt), Long.valueOf(0L) });
      localObject = (String)com.tencent.mm.kernel.h.baE().ban().get(biw(str), null);
      try
      {
        if (!Util.isNullOrNil((String)localObject))
        {
          localObject = biv((String)localObject);
          if (localObject != null) {
            break label316;
          }
          localObject = a.Wpu;
          if (localObject != a.Wps) {
            continue;
          }
          AppMethodBeat.o(315332);
          return false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          a locala = null;
          continue;
          label316:
          if (locala.optLong("updateTime") + locala.optLong("timevalSec") * 1000L < System.currentTimeMillis()) {
            locala = a.Wpt;
          } else {
            locala = a.Wps;
          }
        }
      }
    }
  }
  
  /* Error */
  private static String iqc()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc_w 391
    //   5: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 232	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   11: invokevirtual 397	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   14: astore_0
    //   15: aload_0
    //   16: ldc_w 399
    //   19: invokestatic 232	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   22: invokestatic 238	com/tencent/mm/sdk/platformtools/LocaleUtil:getCurrentLanguage	(Landroid/content/Context;)Ljava/lang/String;
    //   25: invokestatic 402	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   28: invokevirtual 405	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   31: invokevirtual 411	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   34: astore_1
    //   35: aload_1
    //   36: astore_0
    //   37: aload_1
    //   38: invokestatic 415	com/tencent/mm/sdk/platformtools/Util:streamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   41: astore_2
    //   42: aload_2
    //   43: astore_0
    //   44: aload_1
    //   45: invokestatic 419	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   48: ldc_w 391
    //   51: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: aload_0
    //   55: areturn
    //   56: astore_2
    //   57: aconst_null
    //   58: astore_1
    //   59: aload_1
    //   60: astore_0
    //   61: ldc 212
    //   63: aload_2
    //   64: aload_2
    //   65: invokevirtual 422	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   68: iconst_0
    //   69: anewarray 4	java/lang/Object
    //   72: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: aload_1
    //   76: invokestatic 419	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   79: aload_3
    //   80: astore_0
    //   81: goto -33 -> 48
    //   84: astore_1
    //   85: aconst_null
    //   86: astore_0
    //   87: aload_0
    //   88: invokestatic 419	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   91: ldc_w 391
    //   94: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_1
    //   98: athrow
    //   99: astore_1
    //   100: goto -13 -> 87
    //   103: astore_2
    //   104: goto -45 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   14	74	0	localObject1	Object
    //   34	42	1	localInputStream	java.io.InputStream
    //   84	14	1	localObject2	Object
    //   99	1	1	localObject3	Object
    //   41	2	2	str	String
    //   56	9	2	localException1	Exception
    //   103	1	2	localException2	Exception
    //   1	79	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   15	35	56	java/lang/Exception
    //   15	35	84	finally
    //   37	42	99	finally
    //   61	75	99	finally
    //   37	42	103	java/lang/Exception
  }
  
  private static a nT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117716);
    try
    {
      paramString2 = new JSONObject(paramString2);
      paramString2.put("updateTime", System.currentTimeMillis());
      paramString2 = paramString2.toString();
      com.tencent.mm.kernel.h.baE().ban().set(biw(paramString1), paramString2);
      try
      {
        paramString1 = new JSONObject(paramString2);
        Wpo.put(paramString2, paramString1);
        paramString1 = a.Wps;
        AppMethodBeat.o(117716);
        return paramString1;
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchConfigLogic", paramString1, "", new Object[0]);
        }
      }
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      paramString1 = a.Wpu;
      AppMethodBeat.o(117716);
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(117712);
      Wps = new a("Valid", 0);
      Wpt = new a("Expired", 1);
      Wpu = new a("Invalid", 2);
      Wpv = new a[] { Wps, Wpt, Wpu };
      AppMethodBeat.o(117712);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.al
 * JD-Core Version:    0.7.0.1
 */