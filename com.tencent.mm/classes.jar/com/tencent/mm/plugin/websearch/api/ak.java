package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.aas;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.faq;
import com.tencent.mm.protocal.protobuf.far;
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
  private static HashMap<String, ar.a> IEM;
  private static Map<String, JSONObject> IEN;
  private static ab IEO;
  private static HashMap<String, Long> IEP;
  private static String IEQ;
  private static i gNh;
  
  static
  {
    AppMethodBeat.i(117722);
    IEM = new HashMap();
    IEN = new HashMap();
    IEM.put("zh_CN", ar.a.Obp);
    IEM.put("zh_HK", ar.a.Obr);
    IEM.put("zh_TW", ar.a.Obq);
    IEM.put("en", ar.a.Obs);
    IEM.put("ar", ar.a.Obt);
    IEM.put("de", ar.a.Obu);
    IEM.put("de_DE", ar.a.Obv);
    IEM.put("es", ar.a.Obw);
    IEM.put("fr", ar.a.Obx);
    IEM.put("he", ar.a.Oby);
    IEM.put("hi", ar.a.Obz);
    IEM.put("id", ar.a.ObA);
    IEM.put("in", ar.a.ObB);
    IEM.put("it", ar.a.ObC);
    IEM.put("iw", ar.a.ObD);
    IEM.put("ja", ar.a.ObE);
    IEM.put("ko", ar.a.ObF);
    IEM.put("lo", ar.a.ObG);
    IEM.put("ms", ar.a.ObH);
    IEM.put("my", ar.a.ObI);
    IEM.put("pl", ar.a.ObJ);
    IEM.put("pt", ar.a.ObK);
    IEM.put("ru", ar.a.ObL);
    IEM.put("th", ar.a.ObM);
    IEM.put("tr", ar.a.ObN);
    IEM.put("vi", ar.a.ObO);
    IEQ = "";
    gNh = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(117709);
        Log.i("MicroMsg.WebSearch.WebSearchConfigLogic", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousq instanceof ab))
        {
          g.azz().b(1948, ak.fmA());
          paramAnonymousString = new aas();
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            break label162;
          }
          Object localObject = (ab)paramAnonymousq;
          paramAnonymousq = ((ab)localObject).IEh;
          localObject = ((ab)localObject).IEg;
          Log.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfig onSceneEnd %s", new Object[] { paramAnonymousq.MaZ });
          if (ak.lJ(((faq)localObject).rBI, paramAnonymousq.MaZ) != ak.a.IER) {
            break label151;
          }
          paramAnonymousString.ehH.result = 0;
        }
        for (;;)
        {
          EventCenter.instance.publish(paramAnonymousString);
          AppMethodBeat.o(117709);
          return;
          label151:
          paramAnonymousString.ehH.result = -1;
          continue;
          label162:
          paramAnonymousString.ehH.result = -1;
        }
      }
    };
    AppMethodBeat.o(117722);
  }
  
  private static JSONObject aXc(String paramString)
  {
    AppMethodBeat.i(117714);
    if ((IEN.containsKey(paramString)) && (IEN.get(paramString) != null))
    {
      paramString = (JSONObject)IEN.get(paramString);
      AppMethodBeat.o(117714);
      return paramString;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      IEN.put(paramString, localJSONObject);
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
  
  private static ar.a aXd(String paramString)
  {
    AppMethodBeat.i(117715);
    ar.a locala = (ar.a)IEM.get(paramString);
    paramString = locala;
    if (locala == null) {
      paramString = ar.a.Obs;
    }
    AppMethodBeat.o(117715);
    return paramString;
  }
  
  public static JSONObject aXe(String paramString)
  {
    localObject3 = null;
    AppMethodBeat.i(117717);
    String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    try
    {
      localObject1 = (String)g.aAh().azQ().get(aXd(str), null);
      if (Util.isNullOrNil((String)localObject1)) {
        break label146;
      }
      localObject1 = aXc((String)localObject1).optJSONObject("data").optJSONObject(paramString);
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
        localObject4 = fYf();
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
  
  public static String aXf(String paramString)
  {
    Object localObject3 = null;
    AppMethodBeat.i(117718);
    String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    try
    {
      localObject1 = (String)g.aAh().azQ().get(aXd(str), null);
      if (Util.isNullOrNil((String)localObject1)) {
        break label139;
      }
      localObject1 = aXc((String)localObject1);
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
        localObject4 = fYf();
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
  
  public static String aXg(String paramString)
  {
    AppMethodBeat.i(117720);
    JSONObject localJSONObject = aXe("entranceWording");
    if (localJSONObject != null)
    {
      paramString = localJSONObject.optString(paramString);
      AppMethodBeat.o(117720);
      return paramString;
    }
    AppMethodBeat.o(117720);
    return null;
  }
  
  public static boolean bq(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(187861);
    if (IEP == null) {
      IEP = new HashMap();
    }
    String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    if ((paramBoolean) || ((IEQ != null) && (!IEQ.equalsIgnoreCase(str)))) {
      Log.i("MicroMsg.WebSearch.WebSearchConfigLogic", "force update cfg %s %s %s", new Object[] { IEQ, str, Boolean.valueOf(paramBoolean) });
    }
    for (;;)
    {
      IEQ = str;
      if (IEO != null)
      {
        g.azz().a(IEO);
        IEO = null;
      }
      IEO = new ab(paramInt);
      g.azz().a(1948, gNh);
      g.azz().a(IEO, 0);
      AppMethodBeat.o(187861);
      return true;
      Long localLong = (Long)IEP.get(str);
      Object localObject = localLong;
      if (localLong == null) {
        localObject = Long.valueOf(0L);
      }
      if (System.currentTimeMillis() - ((Long)localObject).longValue() < 600000L)
      {
        AppMethodBeat.o(187861);
        return false;
      }
      long l = System.currentTimeMillis();
      IEP.put(str, Long.valueOf(l));
      Log.i("MicroMsg.WebSearch.WebSearchConfigLogic", "startToRequestConfig %s %d %d", new Object[] { str, Integer.valueOf(paramInt), Long.valueOf(0L) });
      localObject = (String)g.aAh().azQ().get(aXd(str), null);
      try
      {
        if (!Util.isNullOrNil((String)localObject))
        {
          localObject = aXc((String)localObject);
          if (localObject != null) {
            break label316;
          }
          localObject = a.IET;
          if (localObject != a.IER) {
            continue;
          }
          AppMethodBeat.o(187861);
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
            locala = a.IES;
          } else {
            locala = a.IER;
          }
        }
      }
    }
  }
  
  /* Error */
  private static String fYf()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc_w 389
    //   5: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 232	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   11: invokevirtual 395	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   14: astore_0
    //   15: aload_0
    //   16: ldc_w 397
    //   19: invokestatic 232	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   22: invokestatic 238	com/tencent/mm/sdk/platformtools/LocaleUtil:getCurrentLanguage	(Landroid/content/Context;)Ljava/lang/String;
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
    //   61: ldc 212
    //   63: aload_2
    //   64: aload_2
    //   65: invokevirtual 420	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   68: iconst_0
    //   69: anewarray 4	java/lang/Object
    //   72: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  private static a lI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117716);
    try
    {
      paramString2 = new JSONObject(paramString2);
      paramString2.put("updateTime", System.currentTimeMillis());
      paramString2 = paramString2.toString();
      g.aAh().azQ().set(aXd(paramString1), paramString2);
      try
      {
        paramString1 = new JSONObject(paramString2);
        IEN.put(paramString2, paramString1);
        paramString1 = a.IER;
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
      paramString1 = a.IET;
      AppMethodBeat.o(117716);
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(117712);
      IER = new a("Valid", 0);
      IES = new a("Expired", 1);
      IET = new a("Invalid", 2);
      IEU = new a[] { IER, IES, IET };
      AppMethodBeat.o(117712);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ak
 * JD-Core Version:    0.7.0.1
 */