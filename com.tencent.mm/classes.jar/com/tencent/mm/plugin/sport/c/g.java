package com.tencent.mm.plugin.sport.c;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.plugin.sport.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class g
{
  private static f eeo = new g.1();
  private static long ptt;
  private static JSONObject ptu;
  private static g.a ptv;
  
  public static void Pv(String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    try
    {
      ptu = new JSONObject(paramString);
      return;
    }
    catch (Exception paramString)
    {
      ptu = null;
    }
  }
  
  public static void a(g.a parama)
  {
    ptv = parama;
  }
  
  public static boolean bLm()
  {
    if (ptt == 0L) {
      ptt = i.Q(1, 0L);
    }
    if (System.currentTimeMillis() - ptt > 86400000L)
    {
      ptt = System.currentTimeMillis();
      i.R(1, ptt);
      y.i("MicroMsg.Sport.SportConfigLogic", "start to request sport config");
      com.tencent.mm.kernel.g.Dk().a(1947, eeo);
      com.tencent.mm.kernel.g.Dk().a(new e(), 0);
      return true;
    }
    y.i("MicroMsg.Sport.SportConfigLogic", "last request time is %s", new Object[] { n.ce(ptt) });
    return false;
  }
  
  public static JSONObject bLn()
  {
    String str1;
    if (ptu == null)
    {
      if (!ae.cqV()) {
        break label112;
      }
      str1 = ((PluginSport)com.tencent.mm.kernel.g.t(PluginSport.class)).getSportFileStorage().Px("");
      if (bk.bl(str1)) {
        break label132;
      }
    }
    for (;;)
    {
      label112:
      try
      {
        ptu = new JSONObject(str1);
        str1 = "server config";
        if (ptu == null)
        {
          ptu = bLo();
          str1 = "asset";
        }
        if (ptu == null)
        {
          ptu = new JSONObject();
          str1 = "new";
        }
        y.i("MicroMsg.Sport.SportConfigLogic", "get sport config from %s: %s", new Object[] { str1, ptu.toString() });
        return ptu;
      }
      catch (Exception localException) {}
      str1 = new h(a.ptb).Px("");
      break;
      label132:
      String str2 = "";
    }
  }
  
  /* Error */
  private static JSONObject bLo()
  {
    // Byte code:
    //   0: invokestatic 158	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   3: invokevirtual 164	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   6: astore_2
    //   7: aconst_null
    //   8: astore_1
    //   9: aconst_null
    //   10: astore_0
    //   11: aload_2
    //   12: ldc 166
    //   14: invokevirtual 172	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   17: astore_2
    //   18: aload_2
    //   19: astore_0
    //   20: aload_2
    //   21: astore_1
    //   22: new 36	org/json/JSONObject
    //   25: dup
    //   26: new 174	java/lang/String
    //   29: dup
    //   30: aload_2
    //   31: invokestatic 180	com/tencent/mm/a/e:k	(Ljava/io/InputStream;)[B
    //   34: invokespecial 183	java/lang/String:<init>	([B)V
    //   37: invokespecial 38	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   40: astore_3
    //   41: aload_3
    //   42: astore_1
    //   43: aload_2
    //   44: ifnull +9 -> 53
    //   47: aload_2
    //   48: invokevirtual 188	java/io/InputStream:close	()V
    //   51: aload_3
    //   52: astore_1
    //   53: aload_1
    //   54: areturn
    //   55: astore_2
    //   56: aload_0
    //   57: astore_1
    //   58: ldc 68
    //   60: aload_2
    //   61: ldc 190
    //   63: iconst_0
    //   64: anewarray 4	java/lang/Object
    //   67: invokestatic 194	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: aload_0
    //   71: astore_1
    //   72: new 36	org/json/JSONObject
    //   75: dup
    //   76: invokespecial 137	org/json/JSONObject:<init>	()V
    //   79: astore_2
    //   80: aload_2
    //   81: astore_1
    //   82: aload_0
    //   83: ifnull -30 -> 53
    //   86: aload_0
    //   87: invokevirtual 188	java/io/InputStream:close	()V
    //   90: aload_2
    //   91: areturn
    //   92: astore_0
    //   93: aload_2
    //   94: areturn
    //   95: astore_0
    //   96: aload_1
    //   97: ifnull +7 -> 104
    //   100: aload_1
    //   101: invokevirtual 188	java/io/InputStream:close	()V
    //   104: aload_0
    //   105: athrow
    //   106: astore_0
    //   107: aload_3
    //   108: areturn
    //   109: astore_1
    //   110: goto -6 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   10	77	0	localObject1	Object
    //   92	1	0	localIOException1	java.io.IOException
    //   95	10	0	localObject2	Object
    //   106	1	0	localIOException2	java.io.IOException
    //   8	93	1	localObject3	Object
    //   109	1	1	localIOException3	java.io.IOException
    //   6	42	2	localObject4	Object
    //   55	6	2	localException	Exception
    //   79	15	2	localJSONObject1	JSONObject
    //   40	68	3	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   11	18	55	java/lang/Exception
    //   22	41	55	java/lang/Exception
    //   86	90	92	java/io/IOException
    //   11	18	95	finally
    //   22	41	95	finally
    //   58	70	95	finally
    //   72	80	95	finally
    //   47	51	106	java/io/IOException
    //   100	104	109	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.c.g
 * JD-Core Version:    0.7.0.1
 */