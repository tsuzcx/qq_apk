package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ya;
import com.tencent.mm.kernel.e;
import com.tencent.mm.protocal.protobuf.dsv;
import com.tencent.mm.protocal.protobuf.dsw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ac
{
  private static HashMap<String, ae.a> AGG;
  private static Map<String, JSONObject> AGH;
  private static u AGI;
  private static HashMap<String, Long> AGJ;
  private static String AGK;
  private static com.tencent.mm.al.g gWw;
  
  static
  {
    AppMethodBeat.i(117722);
    AGG = new HashMap();
    AGH = new HashMap();
    AGG.put("zh_CN", ae.a.Fow);
    AGG.put("zh_HK", ae.a.Foy);
    AGG.put("zh_TW", ae.a.Fox);
    AGG.put("en", ae.a.Foz);
    AGG.put("ar", ae.a.FoA);
    AGG.put("de", ae.a.FoB);
    AGG.put("de_DE", ae.a.FoC);
    AGG.put("es", ae.a.FoD);
    AGG.put("fr", ae.a.FoE);
    AGG.put("he", ae.a.FoF);
    AGG.put("hi", ae.a.FoG);
    AGG.put("id", ae.a.FoH);
    AGG.put("in", ae.a.FoI);
    AGG.put("it", ae.a.FoJ);
    AGG.put("iw", ae.a.FoK);
    AGG.put("ja", ae.a.FoL);
    AGG.put("ko", ae.a.FoM);
    AGG.put("lo", ae.a.FoN);
    AGG.put("ms", ae.a.FoO);
    AGG.put("my", ae.a.FoP);
    AGG.put("pl", ae.a.FoQ);
    AGG.put("pt", ae.a.FoR);
    AGG.put("ru", ae.a.FoS);
    AGG.put("th", ae.a.FoT);
    AGG.put("tr", ae.a.FoU);
    AGG.put("vi", ae.a.FoV);
    AGK = "";
    gWw = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(117709);
        ad.i("MicroMsg.WebSearch.WebSearchConfigLogic", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousn instanceof u))
        {
          com.tencent.mm.kernel.g.aeS().b(1948, ac.dFD());
          paramAnonymousString = new ya();
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            break label162;
          }
          Object localObject = (u)paramAnonymousn;
          paramAnonymousn = ((u)localObject).AGl;
          localObject = ((u)localObject).AGk;
          ad.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfig onSceneEnd %s", new Object[] { paramAnonymousn.DLy });
          if (ac.jM(((dsv)localObject).oXs, paramAnonymousn.DLy) != ac.a.AGL) {
            break label151;
          }
          paramAnonymousString.dEp.result = 0;
        }
        for (;;)
        {
          a.ESL.l(paramAnonymousString);
          AppMethodBeat.o(117709);
          return;
          label151:
          paramAnonymousString.dEp.result = -1;
          continue;
          label162:
          paramAnonymousString.dEp.result = -1;
        }
      }
    };
    AppMethodBeat.o(117722);
  }
  
  public static boolean Sf(int paramInt)
  {
    AppMethodBeat.i(117713);
    if (AGJ == null) {
      AGJ = new HashMap();
    }
    String str = com.tencent.mm.sdk.platformtools.ac.ir(aj.getContext());
    if ((AGK == null) || (AGK.equalsIgnoreCase(str)))
    {
      Long localLong = (Long)AGJ.get(str);
      Object localObject = localLong;
      if (localLong == null) {
        localObject = Long.valueOf(0L);
      }
      if (System.currentTimeMillis() - ((Long)localObject).longValue() < 600000L)
      {
        AppMethodBeat.o(117713);
        return false;
      }
      long l = System.currentTimeMillis();
      AGJ.put(str, Long.valueOf(l));
      ad.i("MicroMsg.WebSearch.WebSearchConfigLogic", "startToRequestConfig %s %d %d", new Object[] { str, Integer.valueOf(paramInt), Long.valueOf(0L) });
      localObject = (String)com.tencent.mm.kernel.g.afB().afk().get(avd(str), null);
      try
      {
        if (!bt.isNullOrNil((String)localObject))
        {
          localObject = avc((String)localObject);
          if (localObject != null) {
            break label200;
          }
          localObject = ac.a.AGN;
          if (localObject != ac.a.AGL) {
            break label240;
          }
          AppMethodBeat.o(117713);
          return false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.a locala = null;
          continue;
          label200:
          if (locala.optLong("updateTime") + locala.optLong("timevalSec") * 1000L < System.currentTimeMillis()) {
            locala = ac.a.AGM;
          } else {
            locala = ac.a.AGL;
          }
        }
      }
    }
    label240:
    AGK = str;
    if (AGI != null)
    {
      com.tencent.mm.kernel.g.aeS().a(AGI);
      AGI = null;
    }
    AGI = new u(paramInt);
    com.tencent.mm.kernel.g.aeS().a(1948, gWw);
    com.tencent.mm.kernel.g.aeS().a(AGI, 0);
    AppMethodBeat.o(117713);
    return true;
  }
  
  private static JSONObject avc(String paramString)
  {
    AppMethodBeat.i(117714);
    if ((AGH.containsKey(paramString)) && (AGH.get(paramString) != null))
    {
      paramString = (JSONObject)AGH.get(paramString);
      AppMethodBeat.o(117714);
      return paramString;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      AGH.put(paramString, localJSONObject);
      AppMethodBeat.o(117714);
      return localJSONObject;
    }
    catch (JSONException paramString)
    {
      ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchConfigLogic", paramString, "", new Object[0]);
      AppMethodBeat.o(117714);
    }
    return null;
  }
  
  private static ae.a avd(String paramString)
  {
    AppMethodBeat.i(117715);
    ae.a locala = (ae.a)AGG.get(paramString);
    paramString = locala;
    if (locala == null) {
      paramString = ae.a.Foz;
    }
    AppMethodBeat.o(117715);
    return paramString;
  }
  
  public static JSONObject ave(String paramString)
  {
    localObject3 = null;
    AppMethodBeat.i(117717);
    String str = com.tencent.mm.sdk.platformtools.ac.ir(aj.getContext());
    try
    {
      localObject1 = (String)com.tencent.mm.kernel.g.afB().afk().get(avd(str), null);
      if (bt.isNullOrNil((String)localObject1)) {
        break label148;
      }
      localObject1 = avc((String)localObject1).optJSONObject("data").optJSONObject(paramString);
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
        localObject4 = ehY();
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
        ad.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigKeyObj %s %s %s", new Object[] { str, paramString, localObject3 });
        AppMethodBeat.o(117717);
        return localObject1;
      }
    }
  }
  
  public static String avf(String paramString)
  {
    Object localObject3 = null;
    AppMethodBeat.i(117718);
    String str = com.tencent.mm.sdk.platformtools.ac.ir(aj.getContext());
    try
    {
      localObject1 = (String)com.tencent.mm.kernel.g.afB().afk().get(avd(str), null);
      if (bt.isNullOrNil((String)localObject1)) {
        break label139;
      }
      localObject1 = avc((String)localObject1);
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
        localObject4 = ehY();
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
        ad.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", new Object[] { str, paramString, localObject3 });
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
  
  public static String avg(String paramString)
  {
    AppMethodBeat.i(117720);
    JSONObject localJSONObject = ave("entranceWording");
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
  private static String ehY()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc_w 384
    //   5: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 201	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   11: invokevirtual 390	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   14: astore_0
    //   15: aload_0
    //   16: ldc_w 392
    //   19: invokestatic 201	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   22: invokestatic 207	com/tencent/mm/sdk/platformtools/ac:ir	(Landroid/content/Context;)Ljava/lang/String;
    //   25: invokestatic 395	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   28: invokevirtual 398	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   31: invokevirtual 404	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   34: astore_1
    //   35: aload_1
    //   36: astore_0
    //   37: aload_1
    //   38: invokestatic 408	com/tencent/mm/sdk/platformtools/bt:Q	(Ljava/io/InputStream;)Ljava/lang/String;
    //   41: astore_2
    //   42: aload_2
    //   43: astore_0
    //   44: aload_1
    //   45: invokestatic 412	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   48: ldc_w 384
    //   51: invokestatic 187	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: aload_0
    //   55: areturn
    //   56: astore_2
    //   57: aconst_null
    //   58: astore_1
    //   59: aload_1
    //   60: astore_0
    //   61: ldc 236
    //   63: aload_2
    //   64: aload_2
    //   65: invokevirtual 415	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   68: iconst_0
    //   69: anewarray 4	java/lang/Object
    //   72: invokestatic 341	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: aload_1
    //   76: invokestatic 412	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   79: aload_3
    //   80: astore_0
    //   81: goto -33 -> 48
    //   84: astore_1
    //   85: aconst_null
    //   86: astore_0
    //   87: aload_0
    //   88: invokestatic 412	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   91: ldc_w 384
    //   94: invokestatic 187	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private static ac.a jL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117716);
    try
    {
      paramString2 = new JSONObject(paramString2);
      paramString2.put("updateTime", System.currentTimeMillis());
      paramString2 = paramString2.toString();
      com.tencent.mm.kernel.g.afB().afk().set(avd(paramString1), paramString2);
      try
      {
        paramString1 = new JSONObject(paramString2);
        AGH.put(paramString2, paramString1);
        paramString1 = ac.a.AGL;
        AppMethodBeat.o(117716);
        return paramString1;
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchConfigLogic", paramString1, "", new Object[0]);
        }
      }
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      paramString1 = ac.a.AGN;
      AppMethodBeat.o(117716);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ac
 * JD-Core Version:    0.7.0.1
 */