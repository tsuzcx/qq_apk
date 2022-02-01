package com.tencent.mm.plugin.sns.ad.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.e.d;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.adxml.e.a;
import com.tencent.mm.plugin.sns.ad.adxml.e.a.a;
import com.tencent.mm.plugin.sns.ad.adxml.e.a.b;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.threadpool.i;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class r
{
  public static String a(AdClickActionInfo paramAdClickActionInfo, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(310008);
    if ((paramAdClickActionInfo == null) || (paramSnsInfo == null))
    {
      AppMethodBeat.o(310008);
      return "";
    }
    JSONObject localJSONObject1;
    Object localObject;
    try
    {
      localJSONObject1 = new JSONObject();
      localJSONObject1.put("image", Util.nullAsNil(paramAdClickActionInfo.PLX));
      localJSONObject1.put("title", Util.nullAsNil(paramAdClickActionInfo.PLY));
      localJSONObject1.put("desc", Util.nullAsNil(paramAdClickActionInfo.PLZ));
      localJSONObject1.put("actionTitle", Util.nullAsNil(paramAdClickActionInfo.PMa));
      localJSONObject1.put("canvasId", Util.nullAsNil(paramAdClickActionInfo.PMb));
      localJSONObject1.put("uxInfo", Util.nullAsNil(paramSnsInfo.getUxinfo()));
      paramSnsInfo = new JSONArray();
      localObject = paramAdClickActionInfo.PMc.iterator();
      while (((Iterator)localObject).hasNext())
      {
        e.a.a locala = (e.a.a)((Iterator)localObject).next();
        if (locala != null)
        {
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("iconUrl", Util.nullAsNil(locala.PMB));
          localJSONObject2.put("sampleRate", Util.nullAsNil(Integer.valueOf(locala.PMC)));
          paramSnsInfo.put(localJSONObject2);
        }
      }
      localObject = new JSONObject();
    }
    finally
    {
      Log.e("LiteAppPreviewHelper", paramAdClickActionInfo.toString());
      AppMethodBeat.o(310008);
      return "";
    }
    ((JSONObject)localObject).put("bgImage", paramAdClickActionInfo.PLU);
    ((JSONObject)localObject).put("avatar", paramAdClickActionInfo.PLV);
    ((JSONObject)localObject).put("nickname", paramAdClickActionInfo.PLW);
    ((JSONObject)localObject).put("productInfo", localJSONObject1);
    ((JSONObject)localObject).put("liveCheerIconList", paramSnsInfo);
    paramAdClickActionInfo = ((JSONObject)localObject).toString();
    AppMethodBeat.o(310008);
    return paramAdClickActionInfo;
  }
  
  public static String a(e.a parama, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(309992);
    if ((parama == null) || (paramSnsInfo == null))
    {
      AppMethodBeat.o(309992);
      return "";
    }
    JSONObject localJSONObject1;
    Object localObject;
    try
    {
      localJSONObject1 = new JSONObject();
      localJSONObject1.put("image", Util.nullAsNil(parama.PMA.PLX));
      localJSONObject1.put("title", Util.nullAsNil(parama.PMA.PLY));
      localJSONObject1.put("desc", Util.nullAsNil(parama.PMA.PLZ));
      localJSONObject1.put("actionTitle", Util.nullAsNil(parama.PMA.PMa));
      localJSONObject1.put("canvasId", Util.nullAsNil(parama.PMA.PMb));
      localJSONObject1.put("uxInfo", Util.nullAsNil(paramSnsInfo.getUxinfo()));
      paramSnsInfo = new JSONArray();
      localObject = parama.PMc.iterator();
      while (((Iterator)localObject).hasNext())
      {
        e.a.a locala = (e.a.a)((Iterator)localObject).next();
        if (locala != null)
        {
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("iconUrl", Util.nullAsNil(locala.PMB));
          localJSONObject2.put("sampleRate", Util.nullAsNil(Integer.valueOf(locala.PMC)));
          paramSnsInfo.put(localJSONObject2);
        }
      }
      localObject = new JSONObject();
    }
    finally
    {
      Log.e("LiteAppPreviewHelper", parama.toString());
      AppMethodBeat.o(309992);
      return "";
    }
    ((JSONObject)localObject).put("bgImage", parama.PLU);
    ((JSONObject)localObject).put("avatar", parama.PLV);
    ((JSONObject)localObject).put("nickname", parama.PLW);
    ((JSONObject)localObject).put("productInfo", localJSONObject1);
    ((JSONObject)localObject).put("liveCheerIconList", paramSnsInfo);
    parama = ((JSONObject)localObject).toString();
    AppMethodBeat.o(309992);
    return parama;
  }
  
  public static boolean aJT(String paramString)
  {
    AppMethodBeat.i(309973);
    try
    {
      paramString = String.format("clicfg_ad_liteapp_%s_open", new Object[] { paramString });
      Log.d("LiteAppPreviewHelper", "expAppId is ".concat(String.valueOf(paramString)));
      paramString = d.dNI().hx(paramString, "0");
      Log.d("LiteAppPreviewHelper", "flagStr is ".concat(String.valueOf(paramString)));
      boolean bool = paramString.equalsIgnoreCase("1");
      AppMethodBeat.o(309973);
      return bool;
    }
    finally
    {
      Log.e("LiteAppPreviewHelper", paramString.toString());
      AppMethodBeat.o(309973);
    }
    return false;
  }
  
  /* Error */
  public static void bN(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 218
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 220
    //   7: invokestatic 222	com/tencent/mm/plugin/sns/ad/d/r:aJT	(Ljava/lang/String;)Z
    //   10: ifne +24 -> 34
    //   13: aload_0
    //   14: invokestatic 226	com/tencent/mm/plugin/sns/ad/d/r:jL	(Landroid/content/Context;)V
    //   17: getstatic 232	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   20: sipush 1706
    //   23: bipush 10
    //   25: invokevirtual 236	com/tencent/mm/plugin/report/service/h:kJ	(II)V
    //   28: ldc 218
    //   30: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: return
    //   34: ldc 238
    //   36: invokestatic 244	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   39: checkcast 238	com/tencent/mm/plugin/lite/api/c
    //   42: ldc 220
    //   44: invokeinterface 248 2 0
    //   49: ifnonnull +43 -> 92
    //   52: aload_0
    //   53: invokestatic 226	com/tencent/mm/plugin/sns/ad/d/r:jL	(Landroid/content/Context;)V
    //   56: invokestatic 251	com/tencent/mm/plugin/sns/ad/d/r:gZW	()V
    //   59: getstatic 232	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   62: sipush 1706
    //   65: bipush 12
    //   67: invokevirtual 236	com/tencent/mm/plugin/report/service/h:kJ	(II)V
    //   70: ldc 218
    //   72: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: return
    //   76: astore_0
    //   77: ldc 123
    //   79: aload_0
    //   80: invokevirtual 128	java/lang/Throwable:toString	()Ljava/lang/String;
    //   83: invokestatic 134	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: ldc 218
    //   88: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: return
    //   92: aload_0
    //   93: ifnonnull +27 -> 120
    //   96: ldc 123
    //   98: ldc 253
    //   100: invokestatic 134	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: getstatic 232	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   106: sipush 1706
    //   109: bipush 13
    //   111: invokevirtual 236	com/tencent/mm/plugin/report/service/h:kJ	(II)V
    //   114: ldc 218
    //   116: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: return
    //   120: ldc 220
    //   122: invokestatic 256	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   125: ifeq +14 -> 139
    //   128: ldc 123
    //   130: ldc_w 258
    //   133: invokestatic 134	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: goto -33 -> 103
    //   139: invokestatic 264	java/lang/System:currentTimeMillis	()J
    //   142: lstore_2
    //   143: new 266	android/os/Bundle
    //   146: dup
    //   147: invokespecial 267	android/os/Bundle:<init>	()V
    //   150: astore 4
    //   152: aload 4
    //   154: ldc_w 269
    //   157: ldc 220
    //   159: invokevirtual 272	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload 4
    //   164: ldc_w 274
    //   167: ldc 18
    //   169: invokevirtual 272	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: aload 4
    //   174: ldc_w 276
    //   177: aload_1
    //   178: invokevirtual 272	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: aload 4
    //   183: ldc_w 278
    //   186: iconst_1
    //   187: invokevirtual 282	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   190: aload 4
    //   192: ldc_w 284
    //   195: getstatic 289	com/tencent/mm/plugin/sns/b$a:slide_right_in	I
    //   198: invokevirtual 293	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   201: aload 4
    //   203: ldc_w 295
    //   206: getstatic 298	com/tencent/mm/plugin/sns/b$a:slide_right_out	I
    //   209: invokevirtual 293	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   212: ldc 238
    //   214: invokestatic 244	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   217: checkcast 238	com/tencent/mm/plugin/lite/api/c
    //   220: aload_0
    //   221: aload 4
    //   223: iconst_0
    //   224: iconst_1
    //   225: new 300	com/tencent/mm/plugin/sns/ad/d/r$2
    //   228: dup
    //   229: lload_2
    //   230: invokespecial 303	com/tencent/mm/plugin/sns/ad/d/r$2:<init>	(J)V
    //   233: invokeinterface 306 6 0
    //   238: goto -135 -> 103
    //   241: astore_0
    //   242: ldc 123
    //   244: aload_0
    //   245: invokevirtual 128	java/lang/Throwable:toString	()Ljava/lang/String;
    //   248: invokestatic 134	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   251: goto -148 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	paramContext	Context
    //   0	254	1	paramString	String
    //   142	88	2	l	long
    //   150	72	4	localBundle	android.os.Bundle
    // Exception table:
    //   from	to	target	type
    //   5	28	76	finally
    //   34	75	76	finally
    //   96	103	76	finally
    //   103	114	76	finally
    //   120	136	76	finally
    //   242	251	76	finally
    //   139	238	241	finally
  }
  
  public static void gZW()
  {
    AppMethodBeat.i(310017);
    com.tencent.threadpool.h.ahAA.bm(new r.1("wxaliteb984a6d0a709290f7f2cd6cab0db8fbe"));
    AppMethodBeat.o(310017);
  }
  
  public static void gZX()
  {
    AppMethodBeat.i(310055);
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1706, 26);
    AppMethodBeat.o(310055);
  }
  
  public static void jL(Context paramContext)
  {
    AppMethodBeat.i(310044);
    if (paramContext == null)
    {
      AppMethodBeat.o(310044);
      return;
    }
    aa.dc(paramContext, "直播间配置拉取失败");
    AppMethodBeat.o(310044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.r
 * JD-Core Version:    0.7.0.1
 */