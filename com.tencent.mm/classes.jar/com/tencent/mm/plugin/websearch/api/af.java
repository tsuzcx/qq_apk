package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.zl;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.egf;
import com.tencent.mm.protocal.protobuf.egg;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class af
{
  private static HashMap<String, am.a> DTR;
  private static Map<String, JSONObject> DTS;
  private static x DTT;
  private static HashMap<String, Long> DTU;
  private static String DTV;
  private static f ghB;
  
  static
  {
    AppMethodBeat.i(117722);
    DTR = new HashMap();
    DTS = new HashMap();
    DTR.put("zh_CN", am.a.ITb);
    DTR.put("zh_HK", am.a.ITd);
    DTR.put("zh_TW", am.a.ITc);
    DTR.put("en", am.a.ITe);
    DTR.put("ar", am.a.ITf);
    DTR.put("de", am.a.ITg);
    DTR.put("de_DE", am.a.ITh);
    DTR.put("es", am.a.ITi);
    DTR.put("fr", am.a.ITj);
    DTR.put("he", am.a.ITk);
    DTR.put("hi", am.a.ITl);
    DTR.put("id", am.a.ITm);
    DTR.put("in", am.a.ITn);
    DTR.put("it", am.a.ITo);
    DTR.put("iw", am.a.ITp);
    DTR.put("ja", am.a.ITq);
    DTR.put("ko", am.a.ITr);
    DTR.put("lo", am.a.ITs);
    DTR.put("ms", am.a.ITt);
    DTR.put("my", am.a.ITu);
    DTR.put("pl", am.a.ITv);
    DTR.put("pt", am.a.ITw);
    DTR.put("ru", am.a.ITx);
    DTR.put("th", am.a.ITy);
    DTR.put("tr", am.a.ITz);
    DTR.put("vi", am.a.ITA);
    DTV = "";
    ghB = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(117709);
        ae.i("MicroMsg.WebSearch.WebSearchConfigLogic", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousn instanceof x))
        {
          g.ajj().b(1948, af.eka());
          paramAnonymousString = new zl();
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            break label162;
          }
          Object localObject = (x)paramAnonymousn;
          paramAnonymousn = ((x)localObject).DTw;
          localObject = ((x)localObject).DTv;
          ae.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfig onSceneEnd %s", new Object[] { paramAnonymousn.GWB });
          if (af.kN(((egf)localObject).qkN, paramAnonymousn.GWB) != af.a.DTW) {
            break label151;
          }
          paramAnonymousString.dPE.result = 0;
        }
        for (;;)
        {
          a.IvT.l(paramAnonymousString);
          AppMethodBeat.o(117709);
          return;
          label151:
          paramAnonymousString.dPE.result = -1;
          continue;
          label162:
          paramAnonymousString.dPE.result = -1;
        }
      }
    };
    AppMethodBeat.o(117722);
  }
  
  public static boolean WP(int paramInt)
  {
    AppMethodBeat.i(117713);
    if (DTU == null) {
      DTU = new HashMap();
    }
    String str = ad.iR(ak.getContext());
    if ((DTV == null) || (DTV.equalsIgnoreCase(str)))
    {
      Long localLong = (Long)DTU.get(str);
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
      DTU.put(str, Long.valueOf(l));
      ae.i("MicroMsg.WebSearch.WebSearchConfigLogic", "startToRequestConfig %s %d %d", new Object[] { str, Integer.valueOf(paramInt), Long.valueOf(0L) });
      localObject = (String)g.ajR().ajA().get(aHi(str), null);
      try
      {
        if (!bu.isNullOrNil((String)localObject))
        {
          localObject = aHh((String)localObject);
          if (localObject != null) {
            break label200;
          }
          localObject = a.DTY;
          if (localObject != a.DTW) {
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
          a locala = null;
          continue;
          label200:
          if (locala.optLong("updateTime") + locala.optLong("timevalSec") * 1000L < System.currentTimeMillis()) {
            locala = a.DTX;
          } else {
            locala = a.DTW;
          }
        }
      }
    }
    label240:
    DTV = str;
    if (DTT != null)
    {
      g.ajj().a(DTT);
      DTT = null;
    }
    DTT = new x(paramInt);
    g.ajj().a(1948, ghB);
    g.ajj().a(DTT, 0);
    AppMethodBeat.o(117713);
    return true;
  }
  
  private static JSONObject aHh(String paramString)
  {
    AppMethodBeat.i(117714);
    if ((DTS.containsKey(paramString)) && (DTS.get(paramString) != null))
    {
      paramString = (JSONObject)DTS.get(paramString);
      AppMethodBeat.o(117714);
      return paramString;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      DTS.put(paramString, localJSONObject);
      AppMethodBeat.o(117714);
      return localJSONObject;
    }
    catch (JSONException paramString)
    {
      ae.printErrStackTrace("MicroMsg.WebSearch.WebSearchConfigLogic", paramString, "", new Object[0]);
      AppMethodBeat.o(117714);
    }
    return null;
  }
  
  private static am.a aHi(String paramString)
  {
    AppMethodBeat.i(117715);
    am.a locala = (am.a)DTR.get(paramString);
    paramString = locala;
    if (locala == null) {
      paramString = am.a.ITe;
    }
    AppMethodBeat.o(117715);
    return paramString;
  }
  
  public static JSONObject aHj(String paramString)
  {
    localObject3 = null;
    AppMethodBeat.i(117717);
    String str = ad.iR(ak.getContext());
    try
    {
      localObject1 = (String)g.ajR().ajA().get(aHi(str), null);
      if (bu.isNullOrNil((String)localObject1)) {
        break label148;
      }
      localObject1 = aHh((String)localObject1).optJSONObject("data").optJSONObject(paramString);
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
        localObject4 = ePS();
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
        ae.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigKeyObj %s %s %s", new Object[] { str, paramString, localObject3 });
        AppMethodBeat.o(117717);
        return localObject1;
      }
    }
  }
  
  public static String aHk(String paramString)
  {
    Object localObject3 = null;
    AppMethodBeat.i(117718);
    String str = ad.iR(ak.getContext());
    try
    {
      localObject1 = (String)g.ajR().ajA().get(aHi(str), null);
      if (bu.isNullOrNil((String)localObject1)) {
        break label139;
      }
      localObject1 = aHh((String)localObject1);
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
        localObject4 = ePS();
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
        ae.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", new Object[] { str, paramString, localObject3 });
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
  
  public static String aHl(String paramString)
  {
    AppMethodBeat.i(117720);
    JSONObject localJSONObject = aHj("entranceWording");
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
  private static String ePS()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc_w 382
    //   5: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 202	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   11: invokevirtual 388	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   14: astore_0
    //   15: aload_0
    //   16: ldc_w 390
    //   19: invokestatic 202	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   22: invokestatic 208	com/tencent/mm/sdk/platformtools/ad:iR	(Landroid/content/Context;)Ljava/lang/String;
    //   25: invokestatic 393	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   28: invokevirtual 396	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   31: invokevirtual 402	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   34: astore_1
    //   35: aload_1
    //   36: astore_0
    //   37: aload_1
    //   38: invokestatic 406	com/tencent/mm/sdk/platformtools/bu:S	(Ljava/io/InputStream;)Ljava/lang/String;
    //   41: astore_2
    //   42: aload_2
    //   43: astore_0
    //   44: aload_1
    //   45: invokestatic 410	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
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
    //   72: invokestatic 341	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: aload_1
    //   76: invokestatic 410	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   79: aload_3
    //   80: astore_0
    //   81: goto -33 -> 48
    //   84: astore_1
    //   85: aconst_null
    //   86: astore_0
    //   87: aload_0
    //   88: invokestatic 410	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
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
  
  private static a kM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117716);
    try
    {
      paramString2 = new JSONObject(paramString2);
      paramString2.put("updateTime", System.currentTimeMillis());
      paramString2 = paramString2.toString();
      g.ajR().ajA().set(aHi(paramString1), paramString2);
      try
      {
        paramString1 = new JSONObject(paramString2);
        DTS.put(paramString2, paramString1);
        paramString1 = a.DTW;
        AppMethodBeat.o(117716);
        return paramString1;
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.WebSearch.WebSearchConfigLogic", paramString1, "", new Object[0]);
        }
      }
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      paramString1 = a.DTY;
      AppMethodBeat.o(117716);
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(117712);
      DTW = new a("Valid", 0);
      DTX = new a("Expired", 1);
      DTY = new a("Invalid", 2);
      DTZ = new a[] { DTW, DTX, DTY };
      AppMethodBeat.o(117712);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.af
 * JD-Core Version:    0.7.0.1
 */