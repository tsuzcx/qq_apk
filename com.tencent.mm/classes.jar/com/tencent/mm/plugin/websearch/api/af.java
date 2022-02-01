package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.zf;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.eeo;
import com.tencent.mm.protocal.protobuf.eep;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class af
{
  private static HashMap<String, al.a> DBU;
  private static Map<String, JSONObject> DBV;
  private static x DBW;
  private static HashMap<String, Long> DBX;
  private static String DBY;
  private static f hPn;
  
  static
  {
    AppMethodBeat.i(117722);
    DBU = new HashMap();
    DBV = new HashMap();
    DBU.put("zh_CN", al.a.IyD);
    DBU.put("zh_HK", al.a.IyF);
    DBU.put("zh_TW", al.a.IyE);
    DBU.put("en", al.a.IyG);
    DBU.put("ar", al.a.IyH);
    DBU.put("de", al.a.IyI);
    DBU.put("de_DE", al.a.IyJ);
    DBU.put("es", al.a.IyK);
    DBU.put("fr", al.a.IyL);
    DBU.put("he", al.a.IyM);
    DBU.put("hi", al.a.IyN);
    DBU.put("id", al.a.IyO);
    DBU.put("in", al.a.IyP);
    DBU.put("it", al.a.IyQ);
    DBU.put("iw", al.a.IyR);
    DBU.put("ja", al.a.IyS);
    DBU.put("ko", al.a.IyT);
    DBU.put("lo", al.a.IyU);
    DBU.put("ms", al.a.IyV);
    DBU.put("my", al.a.IyW);
    DBU.put("pl", al.a.IyX);
    DBU.put("pt", al.a.IyY);
    DBU.put("ru", al.a.IyZ);
    DBU.put("th", al.a.Iza);
    DBU.put("tr", al.a.Izb);
    DBU.put("vi", al.a.Izc);
    DBY = "";
    hPn = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(117709);
        ad.i("MicroMsg.WebSearch.WebSearchConfigLogic", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousn instanceof x))
        {
          g.aiU().b(1948, af.egs());
          paramAnonymousString = new zf();
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            break label162;
          }
          Object localObject = (x)paramAnonymousn;
          paramAnonymousn = ((x)localObject).DBz;
          localObject = ((x)localObject).DBy;
          ad.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfig onSceneEnd %s", new Object[] { paramAnonymousn.GDb });
          if (af.kG(((eeo)localObject).qei, paramAnonymousn.GDb) != af.a.DBZ) {
            break label151;
          }
          paramAnonymousString.dOo.result = 0;
        }
        for (;;)
        {
          a.IbL.l(paramAnonymousString);
          AppMethodBeat.o(117709);
          return;
          label151:
          paramAnonymousString.dOo.result = -1;
          continue;
          label162:
          paramAnonymousString.dOo.result = -1;
        }
      }
    };
    AppMethodBeat.o(117722);
  }
  
  public static boolean Wi(int paramInt)
  {
    AppMethodBeat.i(117713);
    if (DBX == null) {
      DBX = new HashMap();
    }
    String str = ac.iM(aj.getContext());
    if ((DBY == null) || (DBY.equalsIgnoreCase(str)))
    {
      Long localLong = (Long)DBX.get(str);
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
      DBX.put(str, Long.valueOf(l));
      ad.i("MicroMsg.WebSearch.WebSearchConfigLogic", "startToRequestConfig %s %d %d", new Object[] { str, Integer.valueOf(paramInt), Long.valueOf(0L) });
      localObject = (String)g.ajC().ajl().get(aFO(str), null);
      try
      {
        if (!bt.isNullOrNil((String)localObject))
        {
          localObject = aFN((String)localObject);
          if (localObject != null) {
            break label200;
          }
          localObject = af.a.DCb;
          if (localObject != af.a.DBZ) {
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
          af.a locala = null;
          continue;
          label200:
          if (locala.optLong("updateTime") + locala.optLong("timevalSec") * 1000L < System.currentTimeMillis()) {
            locala = af.a.DCa;
          } else {
            locala = af.a.DBZ;
          }
        }
      }
    }
    label240:
    DBY = str;
    if (DBW != null)
    {
      g.aiU().a(DBW);
      DBW = null;
    }
    DBW = new x(paramInt);
    g.aiU().a(1948, hPn);
    g.aiU().a(DBW, 0);
    AppMethodBeat.o(117713);
    return true;
  }
  
  private static JSONObject aFN(String paramString)
  {
    AppMethodBeat.i(117714);
    if ((DBV.containsKey(paramString)) && (DBV.get(paramString) != null))
    {
      paramString = (JSONObject)DBV.get(paramString);
      AppMethodBeat.o(117714);
      return paramString;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      DBV.put(paramString, localJSONObject);
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
  
  private static al.a aFO(String paramString)
  {
    AppMethodBeat.i(117715);
    al.a locala = (al.a)DBU.get(paramString);
    paramString = locala;
    if (locala == null) {
      paramString = al.a.IyG;
    }
    AppMethodBeat.o(117715);
    return paramString;
  }
  
  public static JSONObject aFP(String paramString)
  {
    localObject3 = null;
    AppMethodBeat.i(117717);
    String str = ac.iM(aj.getContext());
    try
    {
      localObject1 = (String)g.ajC().ajl().get(aFO(str), null);
      if (bt.isNullOrNil((String)localObject1)) {
        break label148;
      }
      localObject1 = aFN((String)localObject1).optJSONObject("data").optJSONObject(paramString);
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
        localObject4 = eMj();
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
  
  public static String aFQ(String paramString)
  {
    Object localObject3 = null;
    AppMethodBeat.i(117718);
    String str = ac.iM(aj.getContext());
    try
    {
      localObject1 = (String)g.ajC().ajl().get(aFO(str), null);
      if (bt.isNullOrNil((String)localObject1)) {
        break label139;
      }
      localObject1 = aFN((String)localObject1);
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
        localObject4 = eMj();
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
  
  public static String aFR(String paramString)
  {
    AppMethodBeat.i(117720);
    JSONObject localJSONObject = aFP("entranceWording");
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
  private static String eMj()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc_w 382
    //   5: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 201	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   11: invokevirtual 388	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   14: astore_0
    //   15: aload_0
    //   16: ldc_w 390
    //   19: invokestatic 201	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   22: invokestatic 207	com/tencent/mm/sdk/platformtools/ac:iM	(Landroid/content/Context;)Ljava/lang/String;
    //   25: invokestatic 393	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   28: invokevirtual 396	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   31: invokevirtual 402	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   34: astore_1
    //   35: aload_1
    //   36: astore_0
    //   37: aload_1
    //   38: invokestatic 406	com/tencent/mm/sdk/platformtools/bt:S	(Ljava/io/InputStream;)Ljava/lang/String;
    //   41: astore_2
    //   42: aload_2
    //   43: astore_0
    //   44: aload_1
    //   45: invokestatic 410	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   48: ldc_w 382
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
    //   65: invokevirtual 413	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   68: iconst_0
    //   69: anewarray 4	java/lang/Object
    //   72: invokestatic 341	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: aload_1
    //   76: invokestatic 410	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   79: aload_3
    //   80: astore_0
    //   81: goto -33 -> 48
    //   84: astore_1
    //   85: aconst_null
    //   86: astore_0
    //   87: aload_0
    //   88: invokestatic 410	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   91: ldc_w 382
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
  
  private static af.a kF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117716);
    try
    {
      paramString2 = new JSONObject(paramString2);
      paramString2.put("updateTime", System.currentTimeMillis());
      paramString2 = paramString2.toString();
      g.ajC().ajl().set(aFO(paramString1), paramString2);
      try
      {
        paramString1 = new JSONObject(paramString2);
        DBV.put(paramString2, paramString1);
        paramString1 = af.a.DBZ;
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
      paramString1 = af.a.DCb;
      AppMethodBeat.o(117716);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.af
 * JD-Core Version:    0.7.0.1
 */