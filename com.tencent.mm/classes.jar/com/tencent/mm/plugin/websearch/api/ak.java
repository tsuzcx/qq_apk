package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.abz;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.flj;
import com.tencent.mm.protocal.protobuf.flk;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ak
{
  private static HashMap<String, ar.a> Pze;
  private static Map<String, JSONObject> Pzf;
  private static ab Pzg;
  private static HashMap<String, Long> Pzh;
  private static String Pzi;
  private static i jxB;
  
  static
  {
    AppMethodBeat.i(117722);
    Pze = new HashMap();
    Pzf = new HashMap();
    Pze.put("zh_CN", ar.a.Vps);
    Pze.put("zh_HK", ar.a.Vpu);
    Pze.put("zh_TW", ar.a.Vpt);
    Pze.put("en", ar.a.Vpv);
    Pze.put("ar", ar.a.Vpw);
    Pze.put("de", ar.a.Vpx);
    Pze.put("de_DE", ar.a.Vpy);
    Pze.put("es", ar.a.Vpz);
    Pze.put("fr", ar.a.VpA);
    Pze.put("he", ar.a.VpB);
    Pze.put("hi", ar.a.VpC);
    Pze.put("id", ar.a.VpD);
    Pze.put("in", ar.a.VpE);
    Pze.put("it", ar.a.VpF);
    Pze.put("iw", ar.a.VpG);
    Pze.put("ja", ar.a.VpH);
    Pze.put("ko", ar.a.VpI);
    Pze.put("lo", ar.a.VpJ);
    Pze.put("ms", ar.a.VpK);
    Pze.put("my", ar.a.VpL);
    Pze.put("pl", ar.a.VpM);
    Pze.put("pt", ar.a.VpN);
    Pze.put("ru", ar.a.VpO);
    Pze.put("th", ar.a.VpP);
    Pze.put("tr", ar.a.VpQ);
    Pze.put("vi", ar.a.VpR);
    Pzi = "";
    jxB = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(117709);
        Log.i("MicroMsg.WebSearch.WebSearchConfigLogic", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousq instanceof ab))
        {
          h.aGY().b(1948, ak.gaU());
          paramAnonymousString = new abz();
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            break label162;
          }
          Object localObject = (ab)paramAnonymousq;
          paramAnonymousq = ((ab)localObject).Pyx;
          localObject = ((ab)localObject).Pyw;
          Log.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfig onSceneEnd %s", new Object[] { paramAnonymousq.Tkw });
          if (ak.mi(((flj)localObject).vhq, paramAnonymousq.Tkw) != ak.a.Pzj) {
            break label151;
          }
          paramAnonymousString.gbX.result = 0;
        }
        for (;;)
        {
          EventCenter.instance.publish(paramAnonymousString);
          AppMethodBeat.o(117709);
          return;
          label151:
          paramAnonymousString.gbX.result = -1;
          continue;
          label162:
          paramAnonymousString.gbX.result = -1;
        }
      }
    };
    AppMethodBeat.o(117722);
  }
  
  public static boolean bB(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(211485);
    if (Pzh == null) {
      Pzh = new HashMap();
    }
    String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    if ((paramBoolean) || ((Pzi != null) && (!Pzi.equalsIgnoreCase(str)))) {
      Log.i("MicroMsg.WebSearch.WebSearchConfigLogic", "force update cfg %s %s %s", new Object[] { Pzi, str, Boolean.valueOf(paramBoolean) });
    }
    for (;;)
    {
      Pzi = str;
      if (Pzg != null)
      {
        h.aGY().a(Pzg);
        Pzg = null;
      }
      Pzg = new ab(paramInt);
      h.aGY().a(1948, jxB);
      h.aGY().a(Pzg, 0);
      AppMethodBeat.o(211485);
      return true;
      Long localLong = (Long)Pzh.get(str);
      Object localObject = localLong;
      if (localLong == null) {
        localObject = Long.valueOf(0L);
      }
      if (System.currentTimeMillis() - ((Long)localObject).longValue() < 600000L)
      {
        AppMethodBeat.o(211485);
        return false;
      }
      long l = System.currentTimeMillis();
      Pzh.put(str, Long.valueOf(l));
      Log.i("MicroMsg.WebSearch.WebSearchConfigLogic", "startToRequestConfig %s %d %d", new Object[] { str, Integer.valueOf(paramInt), Long.valueOf(0L) });
      localObject = (String)h.aHG().aHp().get(biO(str), null);
      try
      {
        if (!Util.isNullOrNil((String)localObject))
        {
          localObject = biN((String)localObject);
          if (localObject != null) {
            break label311;
          }
          localObject = a.Pzl;
          if (localObject != a.Pzj) {
            continue;
          }
          AppMethodBeat.o(211485);
          return false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          a locala = null;
          continue;
          label311:
          if (locala.optLong("updateTime") + locala.optLong("timevalSec") * 1000L < System.currentTimeMillis()) {
            locala = a.Pzk;
          } else {
            locala = a.Pzj;
          }
        }
      }
    }
  }
  
  private static JSONObject biN(String paramString)
  {
    AppMethodBeat.i(117714);
    if ((Pzf.containsKey(paramString)) && (Pzf.get(paramString) != null))
    {
      paramString = (JSONObject)Pzf.get(paramString);
      AppMethodBeat.o(117714);
      return paramString;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      Pzf.put(paramString, localJSONObject);
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
  
  private static ar.a biO(String paramString)
  {
    AppMethodBeat.i(117715);
    ar.a locala = (ar.a)Pze.get(paramString);
    paramString = locala;
    if (locala == null) {
      paramString = ar.a.Vpv;
    }
    AppMethodBeat.o(117715);
    return paramString;
  }
  
  public static JSONObject biP(String paramString)
  {
    localObject3 = null;
    AppMethodBeat.i(117717);
    String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    try
    {
      localObject1 = (String)h.aHG().aHp().get(biO(str), null);
      if (Util.isNullOrNil((String)localObject1)) {
        break label148;
      }
      localObject1 = biN((String)localObject1).optJSONObject("data").optJSONObject(paramString);
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
        localObject4 = gQQ();
        if (localObject4 == null) {
          break label167;
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
  
  public static String biQ(String paramString)
  {
    Object localObject3 = null;
    AppMethodBeat.i(117718);
    String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    try
    {
      localObject1 = (String)h.aHG().aHp().get(biO(str), null);
      if (Util.isNullOrNil((String)localObject1)) {
        break label139;
      }
      localObject1 = biN((String)localObject1);
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
        localObject4 = gQQ();
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
  
  public static String biR(String paramString)
  {
    AppMethodBeat.i(117720);
    JSONObject localJSONObject = biP("entranceWording");
    if (localJSONObject != null)
    {
      paramString = localJSONObject.optString(paramString);
      AppMethodBeat.o(117720);
      return paramString;
    }
    AppMethodBeat.o(117720);
    return null;
  }
  
  /* Error */
  private static String gQQ()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc_w 389
    //   5: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 202	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   11: invokevirtual 395	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   14: astore_0
    //   15: aload_0
    //   16: ldc_w 397
    //   19: invokestatic 202	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   22: invokestatic 208	com/tencent/mm/sdk/platformtools/LocaleUtil:getCurrentLanguage	(Landroid/content/Context;)Ljava/lang/String;
    //   25: invokestatic 400	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   28: invokevirtual 403	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   31: invokevirtual 409	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   34: astore_1
    //   35: aload_1
    //   36: astore_0
    //   37: aload_1
    //   38: invokestatic 413	com/tencent/mm/sdk/platformtools/Util:streamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   41: astore_2
    //   42: aload_2
    //   43: astore_0
    //   44: aload_1
    //   45: invokestatic 417	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   48: ldc_w 389
    //   51: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: aload_0
    //   55: areturn
    //   56: astore_2
    //   57: aconst_null
    //   58: astore_1
    //   59: aload_1
    //   60: astore_0
    //   61: ldc 216
    //   63: aload_2
    //   64: aload_2
    //   65: invokevirtual 420	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   68: iconst_0
    //   69: anewarray 4	java/lang/Object
    //   72: invokestatic 348	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: aload_1
    //   76: invokestatic 417	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   79: aload_3
    //   80: astore_0
    //   81: goto -33 -> 48
    //   84: astore_1
    //   85: aconst_null
    //   86: astore_0
    //   87: aload_0
    //   88: invokestatic 417	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   91: ldc_w 389
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
  
  private static a mh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117716);
    try
    {
      paramString2 = new JSONObject(paramString2);
      paramString2.put("updateTime", System.currentTimeMillis());
      paramString2 = paramString2.toString();
      h.aHG().aHp().set(biO(paramString1), paramString2);
      try
      {
        paramString1 = new JSONObject(paramString2);
        Pzf.put(paramString2, paramString1);
        paramString1 = a.Pzj;
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
      paramString1 = a.Pzl;
      AppMethodBeat.o(117716);
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(117712);
      Pzj = new a("Valid", 0);
      Pzk = new a("Expired", 1);
      Pzl = new a("Invalid", 2);
      Pzm = new a[] { Pzj, Pzk, Pzl };
      AppMethodBeat.o(117712);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ak
 * JD-Core Version:    0.7.0.1
 */