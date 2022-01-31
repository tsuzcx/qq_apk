package com.tencent.mm.plugin.websearch.api;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ac
{
  private static f eeo = new ac.1();
  private static HashMap<String, com.tencent.mm.storage.ac.a> qUl = new HashMap();
  private static Map<String, JSONObject> qUm = new HashMap();
  private static u qUn;
  private static HashMap<String, Long> qUo;
  private static String qUp;
  
  static
  {
    qUl.put("zh_CN", com.tencent.mm.storage.ac.a.uvF);
    qUl.put("zh_HK", com.tencent.mm.storage.ac.a.uvH);
    qUl.put("zh_TW", com.tencent.mm.storage.ac.a.uvG);
    qUl.put("en", com.tencent.mm.storage.ac.a.uvI);
    qUl.put("ar", com.tencent.mm.storage.ac.a.uvJ);
    qUl.put("de", com.tencent.mm.storage.ac.a.uvK);
    qUl.put("de_DE", com.tencent.mm.storage.ac.a.uvL);
    qUl.put("es", com.tencent.mm.storage.ac.a.uvM);
    qUl.put("fr", com.tencent.mm.storage.ac.a.uvN);
    qUl.put("he", com.tencent.mm.storage.ac.a.uvO);
    qUl.put("hi", com.tencent.mm.storage.ac.a.uvP);
    qUl.put("id", com.tencent.mm.storage.ac.a.uvQ);
    qUl.put("in", com.tencent.mm.storage.ac.a.uvR);
    qUl.put("it", com.tencent.mm.storage.ac.a.uvS);
    qUl.put("iw", com.tencent.mm.storage.ac.a.uvT);
    qUl.put("ja", com.tencent.mm.storage.ac.a.uvU);
    qUl.put("ko", com.tencent.mm.storage.ac.a.uvV);
    qUl.put("lo", com.tencent.mm.storage.ac.a.uvW);
    qUl.put("ms", com.tencent.mm.storage.ac.a.uvX);
    qUl.put("my", com.tencent.mm.storage.ac.a.uvY);
    qUl.put("pl", com.tencent.mm.storage.ac.a.uvZ);
    qUl.put("pt", com.tencent.mm.storage.ac.a.uwa);
    qUl.put("ru", com.tencent.mm.storage.ac.a.uwb);
    qUl.put("th", com.tencent.mm.storage.ac.a.uwc);
    qUl.put("tr", com.tencent.mm.storage.ac.a.uwd);
    qUl.put("vi", com.tencent.mm.storage.ac.a.uwe);
    qUp = "";
  }
  
  public static boolean BC(int paramInt)
  {
    if (qUo == null) {
      qUo = new HashMap();
    }
    String str = x.fB(ae.getContext());
    if ((qUp == null) || (qUp.equalsIgnoreCase(str)))
    {
      Long localLong = (Long)qUo.get(str);
      Object localObject = localLong;
      if (localLong == null) {
        localObject = Long.valueOf(0L);
      }
      if (System.currentTimeMillis() - ((Long)localObject).longValue() < 600000L) {
        return false;
      }
      long l = System.currentTimeMillis();
      qUo.put(str, Long.valueOf(l));
      y.i("MicroMsg.WebSearch.WebSearchConfigLogic", "startToRequestConfig %s %d %d", new Object[] { str, Integer.valueOf(paramInt), Long.valueOf(0L) });
      localObject = (String)g.DP().Dz().get(Rt(str), null);
      try
      {
        if (!bk.bl((String)localObject))
        {
          localObject = Rs((String)localObject);
          if (localObject != null) {
            break label185;
          }
          localObject = ac.a.qUs;
          if (localObject != ac.a.qUq) {
            break label225;
          }
          return false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.a locala = null;
          continue;
          label185:
          if (locala.optLong("updateTime") + locala.optLong("timevalSec") * 1000L < System.currentTimeMillis()) {
            locala = ac.a.qUr;
          } else {
            locala = ac.a.qUq;
          }
        }
      }
    }
    label225:
    qUp = str;
    if (qUn != null)
    {
      g.Dk().c(qUn);
      qUn = null;
    }
    qUn = new u(paramInt);
    g.Dk().a(1948, eeo);
    g.Dk().a(qUn, 0);
    return true;
  }
  
  private static JSONObject Rs(String paramString)
  {
    if ((qUm.containsKey(paramString)) && (qUm.get(paramString) != null)) {
      return (JSONObject)qUm.get(paramString);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      qUm.put(paramString, localJSONObject);
      return localJSONObject;
    }
    catch (JSONException paramString)
    {
      y.printErrStackTrace("MicroMsg.WebSearch.WebSearchConfigLogic", paramString, "", new Object[0]);
    }
    return null;
  }
  
  private static com.tencent.mm.storage.ac.a Rt(String paramString)
  {
    com.tencent.mm.storage.ac.a locala = (com.tencent.mm.storage.ac.a)qUl.get(paramString);
    paramString = locala;
    if (locala == null) {
      paramString = com.tencent.mm.storage.ac.a.uvI;
    }
    return paramString;
  }
  
  public static JSONObject Ru(String paramString)
  {
    localObject3 = null;
    String str = x.fB(ae.getContext());
    try
    {
      localObject1 = (String)g.DP().Dz().get(Rt(str), null);
      if (bk.bl((String)localObject1)) {
        break label136;
      }
      localObject1 = Rs((String)localObject1).optJSONObject("data").optJSONObject(paramString);
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
        localObject4 = bZz();
        if (localObject4 == null) {
          break label155;
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
        y.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigKeyObj %s %s %s", new Object[] { str, paramString, localObject3 });
        return localObject1;
      }
    }
  }
  
  public static String Rv(String paramString)
  {
    Object localObject3 = null;
    String str = x.fB(ae.getContext());
    try
    {
      localObject1 = (String)g.DP().Dz().get(Rt(str), null);
      if (bk.bl((String)localObject1)) {
        break label127;
      }
      localObject1 = Rs((String)localObject1);
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
        label127:
        localObject2 = "";
      }
    }
    if (localObject3 == null) {}
    for (;;)
    {
      try
      {
        localObject4 = bZz();
        if (localObject4 == null) {
          break label151;
        }
        localObject4 = new JSONObject((String)localObject4);
        localObject3 = "Asset";
        localObject1 = localObject4;
      }
      catch (Exception localException2)
      {
        localObject5 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject5;
        continue;
      }
      if (localObject1 == null)
      {
        localObject1 = new JSONObject();
        y.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", new Object[] { str, paramString, localObject3 });
        paramString = ((JSONObject)localObject1).opt(paramString);
        if (paramString == null) {
          return "";
        }
        return paramString.toString();
      }
      continue;
      label151:
      Object localObject5 = localObject3;
      localObject3 = localObject2;
      Object localObject2 = localObject5;
    }
  }
  
  public static String Rw(String paramString)
  {
    JSONObject localJSONObject = Ru("entranceWording");
    if (localJSONObject != null) {
      return localJSONObject.optString(paramString);
    }
    return null;
  }
  
  /* Error */
  private static String bZz()
  {
    // Byte code:
    //   0: invokestatic 190	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   3: invokevirtual 376	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   6: astore_0
    //   7: invokestatic 190	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   10: invokestatic 196	com/tencent/mm/sdk/platformtools/x:fB	(Landroid/content/Context;)Ljava/lang/String;
    //   13: astore_1
    //   14: aload_0
    //   15: new 378	java/lang/StringBuilder
    //   18: dup
    //   19: ldc_w 380
    //   22: invokespecial 381	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   25: aload_1
    //   26: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 386	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokevirtual 392	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   35: astore_1
    //   36: aload_1
    //   37: astore_0
    //   38: aload_1
    //   39: invokestatic 396	com/tencent/mm/sdk/platformtools/bk:E	(Ljava/io/InputStream;)Ljava/lang/String;
    //   42: astore_2
    //   43: aload_1
    //   44: invokestatic 400	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   47: aload_2
    //   48: areturn
    //   49: astore_2
    //   50: aconst_null
    //   51: astore_1
    //   52: aload_1
    //   53: astore_0
    //   54: ldc 225
    //   56: aload_2
    //   57: aload_2
    //   58: invokevirtual 403	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   61: iconst_0
    //   62: anewarray 4	java/lang/Object
    //   65: invokestatic 332	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   68: aload_1
    //   69: invokestatic 400	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   72: aconst_null
    //   73: areturn
    //   74: astore_1
    //   75: aconst_null
    //   76: astore_0
    //   77: aload_0
    //   78: invokestatic 400	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   81: aload_1
    //   82: athrow
    //   83: astore_1
    //   84: goto -7 -> 77
    //   87: astore_2
    //   88: goto -36 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	72	0	localObject1	Object
    //   13	56	1	localObject2	Object
    //   74	8	1	localObject3	Object
    //   83	1	1	localObject4	Object
    //   42	6	2	str	String
    //   49	9	2	localException1	Exception
    //   87	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   7	36	49	java/lang/Exception
    //   7	36	74	finally
    //   38	43	83	finally
    //   54	68	83	finally
    //   38	43	87	java/lang/Exception
  }
  
  private static ac.a fp(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = new JSONObject(paramString2);
      paramString2.put("updateTime", System.currentTimeMillis());
      paramString2 = paramString2.toString();
      g.DP().Dz().c(Rt(paramString1), paramString2);
      try
      {
        paramString1 = new JSONObject(paramString2);
        qUm.put(paramString2, paramString1);
        return ac.a.qUq;
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.WebSearch.WebSearchConfigLogic", paramString1, "", new Object[0]);
        }
      }
      return ac.a.qUs;
    }
    catch (JSONException paramString1) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ac
 * JD-Core Version:    0.7.0.1
 */