package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ac
{
  private static f fur;
  private static String uJA;
  private static HashMap<String, com.tencent.mm.storage.ac.a> uJw;
  private static Map<String, JSONObject> uJx;
  private static u uJy;
  private static HashMap<String, Long> uJz;
  
  static
  {
    AppMethodBeat.i(124165);
    uJw = new HashMap();
    uJx = new HashMap();
    uJw.put("zh_CN", com.tencent.mm.storage.ac.a.yFN);
    uJw.put("zh_HK", com.tencent.mm.storage.ac.a.yFP);
    uJw.put("zh_TW", com.tencent.mm.storage.ac.a.yFO);
    uJw.put("en", com.tencent.mm.storage.ac.a.yFQ);
    uJw.put("ar", com.tencent.mm.storage.ac.a.yFR);
    uJw.put("de", com.tencent.mm.storage.ac.a.yFS);
    uJw.put("de_DE", com.tencent.mm.storage.ac.a.yFT);
    uJw.put("es", com.tencent.mm.storage.ac.a.yFU);
    uJw.put("fr", com.tencent.mm.storage.ac.a.yFV);
    uJw.put("he", com.tencent.mm.storage.ac.a.yFW);
    uJw.put("hi", com.tencent.mm.storage.ac.a.yFX);
    uJw.put("id", com.tencent.mm.storage.ac.a.yFY);
    uJw.put("in", com.tencent.mm.storage.ac.a.yFZ);
    uJw.put("it", com.tencent.mm.storage.ac.a.yGa);
    uJw.put("iw", com.tencent.mm.storage.ac.a.yGb);
    uJw.put("ja", com.tencent.mm.storage.ac.a.yGc);
    uJw.put("ko", com.tencent.mm.storage.ac.a.yGd);
    uJw.put("lo", com.tencent.mm.storage.ac.a.yGe);
    uJw.put("ms", com.tencent.mm.storage.ac.a.yGf);
    uJw.put("my", com.tencent.mm.storage.ac.a.yGg);
    uJw.put("pl", com.tencent.mm.storage.ac.a.yGh);
    uJw.put("pt", com.tencent.mm.storage.ac.a.yGi);
    uJw.put("ru", com.tencent.mm.storage.ac.a.yGj);
    uJw.put("th", com.tencent.mm.storage.ac.a.yGk);
    uJw.put("tr", com.tencent.mm.storage.ac.a.yGl);
    uJw.put("vi", com.tencent.mm.storage.ac.a.yGm);
    uJA = "";
    fur = new ac.1();
    AppMethodBeat.o(124165);
  }
  
  public static boolean Jq(int paramInt)
  {
    AppMethodBeat.i(124156);
    if (uJz == null) {
      uJz = new HashMap();
    }
    String str = aa.gP(ah.getContext());
    if ((uJA == null) || (uJA.equalsIgnoreCase(str)))
    {
      Long localLong = (Long)uJz.get(str);
      Object localObject = localLong;
      if (localLong == null) {
        localObject = Long.valueOf(0L);
      }
      if (System.currentTimeMillis() - ((Long)localObject).longValue() < 600000L)
      {
        AppMethodBeat.o(124156);
        return false;
      }
      long l = System.currentTimeMillis();
      uJz.put(str, Long.valueOf(l));
      ab.i("MicroMsg.WebSearch.WebSearchConfigLogic", "startToRequestConfig %s %d %d", new Object[] { str, Integer.valueOf(paramInt), Long.valueOf(0L) });
      localObject = (String)g.RL().Ru().get(agu(str), null);
      try
      {
        if (!bo.isNullOrNil((String)localObject))
        {
          localObject = agt((String)localObject);
          if (localObject != null) {
            break label200;
          }
          localObject = a.uJD;
          if (localObject != a.uJB) {
            break label240;
          }
          AppMethodBeat.o(124156);
          return false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          a locala = null;
          continue;
          label200:
          if (locala.optLong("updateTime") + locala.optLong("timevalSec") * 1000L < System.currentTimeMillis()) {
            locala = a.uJC;
          } else {
            locala = a.uJB;
          }
        }
      }
    }
    label240:
    uJA = str;
    if (uJy != null)
    {
      g.Rc().a(uJy);
      uJy = null;
    }
    uJy = new u(paramInt);
    g.Rc().a(1948, fur);
    g.Rc().a(uJy, 0);
    AppMethodBeat.o(124156);
    return true;
  }
  
  private static JSONObject agt(String paramString)
  {
    AppMethodBeat.i(124157);
    if ((uJx.containsKey(paramString)) && (uJx.get(paramString) != null))
    {
      paramString = (JSONObject)uJx.get(paramString);
      AppMethodBeat.o(124157);
      return paramString;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      uJx.put(paramString, localJSONObject);
      AppMethodBeat.o(124157);
      return localJSONObject;
    }
    catch (JSONException paramString)
    {
      ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchConfigLogic", paramString, "", new Object[0]);
      AppMethodBeat.o(124157);
    }
    return null;
  }
  
  private static com.tencent.mm.storage.ac.a agu(String paramString)
  {
    AppMethodBeat.i(124158);
    com.tencent.mm.storage.ac.a locala = (com.tencent.mm.storage.ac.a)uJw.get(paramString);
    paramString = locala;
    if (locala == null) {
      paramString = com.tencent.mm.storage.ac.a.yFQ;
    }
    AppMethodBeat.o(124158);
    return paramString;
  }
  
  public static JSONObject agv(String paramString)
  {
    localObject3 = null;
    AppMethodBeat.i(124160);
    String str = aa.gP(ah.getContext());
    try
    {
      localObject1 = (String)g.RL().Ru().get(agu(str), null);
      if (bo.isNullOrNil((String)localObject1)) {
        break label148;
      }
      localObject1 = agt((String)localObject1).optJSONObject("data").optJSONObject(paramString);
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
        localObject4 = cZv();
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
        ab.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigKeyObj %s %s %s", new Object[] { str, paramString, localObject3 });
        AppMethodBeat.o(124160);
        return localObject1;
      }
    }
  }
  
  public static String agw(String paramString)
  {
    Object localObject3 = null;
    AppMethodBeat.i(124161);
    String str = aa.gP(ah.getContext());
    try
    {
      localObject1 = (String)g.RL().Ru().get(agu(str), null);
      if (bo.isNullOrNil((String)localObject1)) {
        break label139;
      }
      localObject1 = agt((String)localObject1);
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
        localObject4 = cZv();
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
        AppMethodBeat.o(124161);
        return paramString;
      }
      if (localObject1 == null)
      {
        localObject1 = new JSONObject();
        ab.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", new Object[] { str, paramString, localObject3 });
        paramString = ((JSONObject)localObject1).opt(paramString);
        if (paramString == null)
        {
          AppMethodBeat.o(124161);
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
  
  public static String agx(String paramString)
  {
    AppMethodBeat.i(124163);
    JSONObject localJSONObject = agv("entranceWording");
    if (localJSONObject != null)
    {
      paramString = localJSONObject.optString(paramString);
      AppMethodBeat.o(124163);
      return paramString;
    }
    AppMethodBeat.o(124163);
    return null;
  }
  
  /* Error */
  private static String cZv()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc_w 382
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 202	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   11: invokevirtual 388	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   14: astore_0
    //   15: aload_0
    //   16: ldc_w 390
    //   19: invokestatic 202	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   22: invokestatic 208	com/tencent/mm/sdk/platformtools/aa:gP	(Landroid/content/Context;)Ljava/lang/String;
    //   25: invokestatic 393	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   28: invokevirtual 396	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   31: invokevirtual 402	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   34: astore_1
    //   35: aload_1
    //   36: astore_0
    //   37: aload_1
    //   38: invokestatic 406	com/tencent/mm/sdk/platformtools/bo:F	(Ljava/io/InputStream;)Ljava/lang/String;
    //   41: astore_2
    //   42: aload_2
    //   43: astore_0
    //   44: aload_1
    //   45: invokestatic 410	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   48: ldc_w 382
    //   51: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: aload_0
    //   55: areturn
    //   56: astore_2
    //   57: aconst_null
    //   58: astore_1
    //   59: aload_1
    //   60: astore_0
    //   61: ldc 237
    //   63: aload_2
    //   64: aload_2
    //   65: invokevirtual 413	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   68: iconst_0
    //   69: anewarray 4	java/lang/Object
    //   72: invokestatic 341	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: aload_1
    //   76: invokestatic 410	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   79: aload_3
    //   80: astore_0
    //   81: goto -33 -> 48
    //   84: astore_1
    //   85: aconst_null
    //   86: astore_0
    //   87: aload_0
    //   88: invokestatic 410	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   91: ldc_w 382
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
  
  private static a hi(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124159);
    try
    {
      paramString2 = new JSONObject(paramString2);
      paramString2.put("updateTime", System.currentTimeMillis());
      paramString2 = paramString2.toString();
      g.RL().Ru().set(agu(paramString1), paramString2);
      try
      {
        paramString1 = new JSONObject(paramString2);
        uJx.put(paramString2, paramString1);
        paramString1 = a.uJB;
        AppMethodBeat.o(124159);
        return paramString1;
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchConfigLogic", paramString1, "", new Object[0]);
        }
      }
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      paramString1 = a.uJD;
      AppMethodBeat.o(124159);
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(124155);
      uJB = new a("Valid", 0);
      uJC = new a("Expired", 1);
      uJD = new a("Invalid", 2);
      uJE = new a[] { uJB, uJC, uJD };
      AppMethodBeat.o(124155);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ac
 * JD-Core Version:    0.7.0.1
 */