package com.tencent.mm.plugin.sns.ad.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.sns.ad.h.b;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.protocal.protobuf.ag;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.threadpool.i;
import java.util.HashMap;
import org.json.JSONObject;

public final class a
{
  private static HashMap<Long, Long> PNJ;
  
  static
  {
    AppMethodBeat.i(310065);
    PNJ = new HashMap();
    AppMethodBeat.o(310065);
  }
  
  /* Error */
  public static void O(android.content.Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 38
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 40
    //   7: ldc 42
    //   9: aload_1
    //   10: invokestatic 48	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   13: invokevirtual 52	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   16: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_0
    //   20: ifnull +10 -> 30
    //   23: aload_1
    //   24: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   27: ifeq +9 -> 36
    //   30: ldc 38
    //   32: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: return
    //   36: new 65	org/json/JSONObject
    //   39: dup
    //   40: aload_1
    //   41: invokespecial 68	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   44: astore 8
    //   46: aload 8
    //   48: ldc 70
    //   50: invokevirtual 74	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   53: istore_3
    //   54: aload 8
    //   56: ldc 76
    //   58: invokevirtual 80	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   61: lstore 4
    //   63: aload 8
    //   65: ldc 82
    //   67: invokevirtual 85	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   70: astore 6
    //   72: iload_3
    //   73: tableswitch	default:+27 -> 100, 0:+33->106, 1:+97->170, 2:+308->381
    //   101: dload_0
    //   102: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: return
    //   106: aload 8
    //   108: ldc 87
    //   110: invokevirtual 80	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   113: aload 6
    //   115: invokestatic 92	com/tencent/mm/plugin/sns/data/m:aWg	(Ljava/lang/String;)Ljava/lang/String;
    //   118: ldc 94
    //   120: bipush 32
    //   122: invokestatic 97	com/tencent/mm/plugin/sns/data/m:a	(JLjava/lang/String;Ljava/lang/String;I)V
    //   125: lload 4
    //   127: aload 6
    //   129: iconst_0
    //   130: invokestatic 101	com/tencent/mm/plugin/sns/ad/d/a:d	(JLjava/lang/String;I)V
    //   133: ldc 38
    //   135: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: return
    //   139: astore_0
    //   140: ldc 40
    //   142: new 103	java/lang/StringBuilder
    //   145: dup
    //   146: ldc 105
    //   148: invokespecial 106	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   151: aload_0
    //   152: invokevirtual 112	java/lang/Throwable:toString	()Ljava/lang/String;
    //   155: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 120	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: ldc 38
    //   166: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: return
    //   170: aload 8
    //   172: ldc 122
    //   174: invokevirtual 85	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   177: astore_2
    //   178: new 124	android/content/Intent
    //   181: dup
    //   182: invokespecial 125	android/content/Intent:<init>	()V
    //   185: astore 7
    //   187: aload_2
    //   188: astore_1
    //   189: aload 6
    //   191: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   194: ifne +17 -> 211
    //   197: aload_2
    //   198: aload 6
    //   200: invokestatic 131	com/tencent/mm/plugin/sns/data/t:lY	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   203: astore_1
    //   204: aload 7
    //   206: aload 6
    //   208: invokestatic 134	com/tencent/mm/plugin/sns/data/t:i	(Landroid/content/Intent;Ljava/lang/String;)V
    //   211: aload 7
    //   213: ldc 136
    //   215: iconst_0
    //   216: invokevirtual 140	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   219: pop
    //   220: new 142	com/tencent/mm/modelsns/SnsAdClick
    //   223: dup
    //   224: iconst_0
    //   225: bipush 9
    //   227: lconst_0
    //   228: iconst_3
    //   229: iconst_0
    //   230: invokespecial 145	com/tencent/mm/modelsns/SnsAdClick:<init>	(IIJII)V
    //   233: astore_2
    //   234: new 147	android/os/Bundle
    //   237: dup
    //   238: invokespecial 148	android/os/Bundle:<init>	()V
    //   241: astore 8
    //   243: aload 8
    //   245: ldc 150
    //   247: aload_2
    //   248: invokevirtual 154	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   251: aload 6
    //   253: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   256: ifne +12 -> 268
    //   259: aload 8
    //   261: ldc 156
    //   263: aload 6
    //   265: invokevirtual 159	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: aload 7
    //   270: ldc 161
    //   272: aload 8
    //   274: invokevirtual 164	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
    //   277: pop
    //   278: aload 7
    //   280: ldc 166
    //   282: aload_1
    //   283: invokevirtual 169	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   286: pop
    //   287: aload 7
    //   289: ldc 171
    //   291: iconst_1
    //   292: invokevirtual 140	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   295: pop
    //   296: aload 7
    //   298: ldc 173
    //   300: iconst_2
    //   301: invokevirtual 176	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   304: pop
    //   305: aload 7
    //   307: ldc 178
    //   309: bipush 15
    //   311: invokevirtual 176	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   314: pop
    //   315: aload_0
    //   316: ldc 180
    //   318: ldc 182
    //   320: aload 7
    //   322: invokestatic 187	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   325: ldc 40
    //   327: ldc 189
    //   329: aload_1
    //   330: invokestatic 48	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   333: invokevirtual 52	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   336: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   339: lload 4
    //   341: aload 6
    //   343: iconst_1
    //   344: invokestatic 101	com/tencent/mm/plugin/sns/ad/d/a:d	(JLjava/lang/String;I)V
    //   347: ldc 38
    //   349: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   352: return
    //   353: astore_0
    //   354: ldc 40
    //   356: new 103	java/lang/StringBuilder
    //   359: dup
    //   360: ldc 191
    //   362: invokespecial 106	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   365: aload_0
    //   366: invokevirtual 112	java/lang/Throwable:toString	()Ljava/lang/String;
    //   369: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokestatic 120	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   378: goto -39 -> 339
    //   381: aload 8
    //   383: ldc 193
    //   385: invokevirtual 85	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   388: astore_0
    //   389: aload 8
    //   391: ldc 195
    //   393: invokevirtual 85	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   396: astore 7
    //   398: aload 8
    //   400: ldc 197
    //   402: invokevirtual 85	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   405: astore_1
    //   406: aload 8
    //   408: ldc 199
    //   410: invokevirtual 85	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   413: pop
    //   414: aload 6
    //   416: invokestatic 202	com/tencent/mm/plugin/sns/data/m:aXi	(Ljava/lang/String;)Ljava/lang/String;
    //   419: astore 8
    //   421: aload 6
    //   423: invokestatic 205	com/tencent/mm/plugin/sns/data/m:aXj	(Ljava/lang/String;)Ljava/lang/String;
    //   426: astore 9
    //   428: new 103	java/lang/StringBuilder
    //   431: dup
    //   432: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   435: lconst_0
    //   436: invokestatic 210	com/tencent/mm/plugin/sns/data/t:uA	(J)Ljava/lang/String;
    //   439: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: ldc 212
    //   444: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: aload 6
    //   449: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: ldc 212
    //   454: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: invokestatic 217	com/tencent/mm/plugin/sns/model/al:hgg	()Ljava/lang/String;
    //   460: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: ldc 212
    //   465: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: invokestatic 223	java/lang/System:currentTimeMillis	()J
    //   471: invokevirtual 226	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   474: ldc 212
    //   476: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: aload_2
    //   480: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: astore_2
    //   487: aload 7
    //   489: iconst_1
    //   490: invokestatic 230	com/tencent/mm/plugin/sns/data/m:cW	(Ljava/lang/String;Z)Ljava/lang/String;
    //   493: astore 7
    //   495: aload_0
    //   496: aload 7
    //   498: aload_1
    //   499: aload 8
    //   501: aload 9
    //   503: aload_2
    //   504: aload 6
    //   506: sipush 1215
    //   509: invokestatic 233	com/tencent/mm/plugin/sns/data/t:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   512: ldc 40
    //   514: new 103	java/lang/StringBuilder
    //   517: dup
    //   518: ldc 235
    //   520: invokespecial 106	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   523: aload_0
    //   524: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: ldc 237
    //   529: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: aload 7
    //   534: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: ldc 239
    //   539: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: aload_1
    //   543: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: ldc 241
    //   548: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: aload 6
    //   553: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: ldc 243
    //   558: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: aload_2
    //   562: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   571: lload 4
    //   573: aload 6
    //   575: iconst_2
    //   576: invokestatic 101	com/tencent/mm/plugin/sns/ad/d/a:d	(JLjava/lang/String;I)V
    //   579: goto -479 -> 100
    //   582: astore_0
    //   583: ldc 40
    //   585: new 103	java/lang/StringBuilder
    //   588: dup
    //   589: ldc 245
    //   591: invokespecial 106	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   594: aload_0
    //   595: invokevirtual 112	java/lang/Throwable:toString	()Ljava/lang/String;
    //   598: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   604: invokestatic 120	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   607: goto -36 -> 571
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	610	0	paramContext	android.content.Context
    //   0	610	1	paramString1	String
    //   0	610	2	paramString2	String
    //   53	20	3	i	int
    //   61	511	4	l	long
    //   70	504	6	str1	String
    //   185	348	7	localObject1	Object
    //   44	456	8	localObject2	Object
    //   426	76	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   36	72	139	finally
    //   106	138	139	finally
    //   170	178	139	finally
    //   339	352	139	finally
    //   354	378	139	finally
    //   381	414	139	finally
    //   571	579	139	finally
    //   583	607	139	finally
    //   178	187	353	finally
    //   189	211	353	finally
    //   211	268	353	finally
    //   268	339	353	finally
    //   414	571	582	finally
  }
  
  public static String a(String paramString, com.tencent.mm.plugin.sns.ad.adxml.a parama)
  {
    AppMethodBeat.i(310036);
    Object localObject2 = "0";
    if (parama == null)
    {
      AppMethodBeat.o(310036);
      return "0";
    }
    long l = cn.getSyncServerTimeSecond();
    Object localObject1;
    if ((parama.PLi != 0L) && (parama.PLi < l))
    {
      Log.i("ADAppointment.AdAppointmentHelper", "getLocalCacheState, expireTime=" + parama.PLi + ", serverTime=" + l);
      localObject2 = "1000";
      localObject1 = "";
    }
    label217:
    for (;;)
    {
      Log.d("ADAppointment.AdAppointmentHelper", "getLocalCacheState, cacheStatus=" + (String)localObject1 + ", state=" + (String)localObject2 + ", id=" + parama.PKZ + ", snsId=" + paramString);
      AppMethodBeat.o(310036);
      return localObject2;
      localObject1 = um(parama.PKZ);
      if (MMApplicationContext.isMainProcess()) {}
      for (localObject1 = com.tencent.mm.plugin.sns.ad.a.getAdValue(paramString, (String)localObject1);; localObject1 = AdLandingPagesProxy.getInstance().getAdValue(paramString, (String)localObject1))
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label217;
        }
        localObject2 = localObject1;
        Object localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        break;
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, long paramLong, a parama)
  {
    AppMethodBeat.i(310009);
    Log.i("ADAppointment.AdAppointmentHelper", "doAppointment, id=" + paramLong + ", snsId=" + paramString1 + ", uxInfo=" + paramString2);
    paramString2 = new b(paramString2, paramLong, 0);
    com.tencent.mm.kernel.h.aZW().a(5159, new b(paramString1, paramLong, 0, parama));
    com.tencent.mm.kernel.h.aZW().a(paramString2, 0);
    AppMethodBeat.o(310009);
  }
  
  public static void b(String paramString1, String paramString2, long paramLong, a parama)
  {
    AppMethodBeat.i(310018);
    Log.i("ADAppointment.AdAppointmentHelper", "cancelAppointment, id=" + paramLong + ", snsId=" + paramString1 + ", uxInfo=" + paramString2);
    paramString2 = new b(paramString2, paramLong, 1);
    com.tencent.mm.kernel.h.aZW().a(5159, new b(paramString1, paramLong, 1, parama));
    com.tencent.mm.kernel.h.aZW().a(paramString2, 0);
    AppMethodBeat.o(310018);
  }
  
  public static boolean c(String paramString1, String paramString2, long paramLong, a parama)
  {
    AppMethodBeat.i(310026);
    if (PNJ.containsKey(Long.valueOf(paramLong))) {}
    for (long l = ((Long)PNJ.get(Long.valueOf(paramLong))).longValue();; l = 0L)
    {
      if ((l != 0L) && (System.currentTimeMillis() - l <= 30000L))
      {
        Log.d("ADAppointment.AdAppointmentHelper", "getAppointmentStatus, too frequently, id=".concat(String.valueOf(paramLong)));
        AppMethodBeat.o(310026);
        return false;
      }
      PNJ.put(Long.valueOf(paramLong), Long.valueOf(System.currentTimeMillis()));
      Log.i("ADAppointment.AdAppointmentHelper", "getAppointmentStatus, id=" + paramLong + ", snsId=" + paramString1 + ", lastReqTime=" + l + ", uxInfo=" + paramString2);
      paramString2 = new b(paramString2, paramLong, 2);
      com.tencent.mm.kernel.h.aZW().a(5159, new b(paramString1, paramLong, 2, parama));
      com.tencent.mm.kernel.h.aZW().a(paramString2, 0);
      AppMethodBeat.o(310026);
      return true;
    }
  }
  
  private static void d(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(310058);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("snsid", "");
      localJSONObject.put("uxinfo", paramString);
      localJSONObject.put("scene", 9);
      paramString = new JSONObject();
      paramString.put("appointmentId", paramLong);
      paramString.put("type", paramInt);
      localJSONObject.put("extInfo", paramString);
      m.lU("general_msg_ad_general_service_msg_click", localJSONObject.toString());
      AppMethodBeat.o(310058);
      return;
    }
    finally
    {
      Log.e("ADAppointment.AdAppointmentHelper", "doCancelReport, exp=" + paramString.toString());
      AppMethodBeat.o(310058);
    }
  }
  
  public static String um(long paramLong)
  {
    AppMethodBeat.i(310002);
    String str = "appointment_status_".concat(String.valueOf(paramLong));
    AppMethodBeat.o(310002);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract void aw(boolean paramBoolean, String paramString);
  }
  
  static final class b
    implements com.tencent.mm.am.h
  {
    private a.a PNK;
    private int PNL;
    private long PNM;
    private String PNx;
    
    public b(String paramString, long paramLong, int paramInt, a.a parama)
    {
      this.PNx = paramString;
      this.PNM = paramLong;
      this.PNL = paramInt;
      this.PNK = parama;
    }
    
    public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final p paramp)
    {
      AppMethodBeat.i(310091);
      Log.i("ADAppointment.AdAppointmentHelper", "parseResp, snsId=" + this.PNx + ", appointmentId=" + this.PNM + ", opType=" + this.PNL + ", errType=" + paramInt1 + ", errCode=" + paramInt2 + ", errMsg=" + paramString);
      if (this.PNK == null)
      {
        Log.e("ADAppointment.AdAppointmentHelper", "parseResp callback==null");
        AppMethodBeat.o(310091);
        return;
      }
      com.tencent.threadpool.h.ahAA.bk(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(310039);
          try
          {
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              Object localObject1 = (ag)c.c.b(((c)paramp.getReqResp()).otC);
              if (localObject1 != null)
              {
                localObject1 = String.valueOf(((ag)localObject1).status);
                Log.i("ADAppointment.AdAppointmentHelper", "parseResp status=".concat(String.valueOf(localObject1)));
                com.tencent.mm.plugin.sns.ad.a.setAdValue(a.b.a(a.b.this), a.um(a.b.b(a.b.this)), (String)localObject1);
                a.a locala2 = a.b.d(a.b.this);
                a.b.b(a.b.this);
                a.b.c(a.b.this);
                locala2.aw(true, (String)localObject1);
                AppMethodBeat.o(310039);
                return;
              }
            }
          }
          finally
          {
            Log.e("ADAppointment.AdAppointmentHelper", "parseResp exp=" + localObject2.toString());
            a.a locala1 = a.b.d(a.b.this);
            a.b.b(a.b.this);
            a.b.c(a.b.this);
            locala1.aw(false, "-1");
            AppMethodBeat.o(310039);
          }
        }
      });
      com.tencent.mm.kernel.h.aZW().b(5159, this);
      AppMethodBeat.o(310091);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.a
 * JD-Core Version:    0.7.0.1
 */