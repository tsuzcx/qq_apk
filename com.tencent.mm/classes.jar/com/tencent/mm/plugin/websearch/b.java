package com.tencent.mm.plugin.websearch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.websearch.d.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Map;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.plugin.websearch.api.h
{
  private void a(Context paramContext, int paramInt, String paramString1, String paramString2, boolean paramBoolean, Map<String, String> paramMap, String paramString3)
  {
    AppMethodBeat.i(315005);
    a(paramContext, paramInt, paramString1, paramString2, paramBoolean, paramMap, false, 2147483647, paramString3);
    AppMethodBeat.o(315005);
  }
  
  private void a(Context paramContext, int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, Map<String, String> paramMap, boolean paramBoolean2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(116534);
    a(paramContext, paramInt1, paramString1, paramString2, paramBoolean1, paramMap, paramBoolean2, paramInt2, paramString3, 0, false);
    AppMethodBeat.o(116534);
  }
  
  private void a(final Context paramContext, final int paramInt1, final String paramString1, final String paramString2, final boolean paramBoolean1, final Map<String, String> paramMap, final boolean paramBoolean2, final int paramInt2, final String paramString3, final int paramInt3, final boolean paramBoolean3)
  {
    AppMethodBeat.i(315012);
    ((i)com.tencent.mm.kernel.h.ax(i.class)).a(paramContext, new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 74
        //   2: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: iconst_0
        //   6: invokestatic 86	com/tencent/mm/plugin/websearch/api/aj:asX	(I)Z
        //   9: ifne +16 -> 25
        //   12: ldc 88
        //   14: ldc 90
        //   16: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   19: ldc 74
        //   21: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   24: return
        //   25: getstatic 105	com/tencent/mm/sdk/platformtools/WeChatBrands$Business$Entries:DiscoverySearch	Lcom/tencent/mm/sdk/platformtools/WeChatBrands$Business$Entries;
        //   28: aload_0
        //   29: getfield 38	com/tencent/mm/plugin/websearch/b$3:val$context	Landroid/content/Context;
        //   32: invokevirtual 109	com/tencent/mm/sdk/platformtools/WeChatBrands$Business$Entries:checkAvailable	(Landroid/content/Context;)Z
        //   35: ifne +9 -> 44
        //   38: ldc 74
        //   40: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   43: return
        //   44: ldc 111
        //   46: astore 5
        //   48: iconst_m1
        //   49: istore_2
        //   50: new 113	org/json/JSONObject
        //   53: dup
        //   54: invokespecial 114	org/json/JSONObject:<init>	()V
        //   57: astore 6
        //   59: ldc 111
        //   61: astore 4
        //   63: iconst_0
        //   64: istore_1
        //   65: aload_0
        //   66: getfield 40	com/tencent/mm/plugin/websearch/b$3:Wnv	Ljava/util/Map;
        //   69: ifnull +914 -> 983
        //   72: aload_0
        //   73: getfield 40	com/tencent/mm/plugin/websearch/b$3:Wnv	Ljava/util/Map;
        //   76: ldc 116
        //   78: invokeinterface 122 2 0
        //   83: checkcast 124	java/lang/String
        //   86: astore 5
        //   88: aload_0
        //   89: getfield 40	com/tencent/mm/plugin/websearch/b$3:Wnv	Ljava/util/Map;
        //   92: ldc 126
        //   94: invokeinterface 130 2 0
        //   99: ifeq +738 -> 837
        //   102: aload_0
        //   103: getfield 40	com/tencent/mm/plugin/websearch/b$3:Wnv	Ljava/util/Map;
        //   106: ldc 126
        //   108: invokeinterface 122 2 0
        //   113: checkcast 124	java/lang/String
        //   116: astore 4
        //   118: aload 6
        //   120: ldc 126
        //   122: aload 4
        //   124: invokevirtual 134	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   127: pop
        //   128: aload_0
        //   129: getfield 40	com/tencent/mm/plugin/websearch/b$3:Wnv	Ljava/util/Map;
        //   132: ldc 116
        //   134: invokeinterface 122 2 0
        //   139: checkcast 124	java/lang/String
        //   142: astore 5
        //   144: aload_0
        //   145: getfield 40	com/tencent/mm/plugin/websearch/b$3:Wnv	Ljava/util/Map;
        //   148: ldc 136
        //   150: invokeinterface 122 2 0
        //   155: checkcast 124	java/lang/String
        //   158: invokestatic 142	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
        //   161: istore_2
        //   162: aload_0
        //   163: getfield 40	com/tencent/mm/plugin/websearch/b$3:Wnv	Ljava/util/Map;
        //   166: ldc 144
        //   168: invokeinterface 122 2 0
        //   173: checkcast 124	java/lang/String
        //   176: invokestatic 142	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
        //   179: istore_1
        //   180: aload_0
        //   181: getfield 40	com/tencent/mm/plugin/websearch/b$3:Wnv	Ljava/util/Map;
        //   184: ldc 146
        //   186: invokeinterface 122 2 0
        //   191: checkcast 124	java/lang/String
        //   194: astore 7
        //   196: aload 7
        //   198: ifnull +20 -> 218
        //   201: aload_0
        //   202: getfield 40	com/tencent/mm/plugin/websearch/b$3:Wnv	Ljava/util/Map;
        //   205: ldc 146
        //   207: aload 7
        //   209: invokestatic 152	android/net/Uri:encode	(Ljava/lang/String;)Ljava/lang/String;
        //   212: invokeinterface 155 3 0
        //   217: pop
        //   218: ldc 88
        //   220: ldc 157
        //   222: iconst_2
        //   223: anewarray 4	java/lang/Object
        //   226: dup
        //   227: iconst_0
        //   228: aload 4
        //   230: aastore
        //   231: dup
        //   232: iconst_1
        //   233: aload_0
        //   234: getfield 44	com/tencent/mm/plugin/websearch/b$3:lyQ	I
        //   237: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   240: aastore
        //   241: invokestatic 166	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   244: invokestatic 172	java/lang/System:currentTimeMillis	()J
        //   247: invokestatic 175	java/lang/String:valueOf	(J)Ljava/lang/String;
        //   250: astore 8
        //   252: aload_0
        //   253: getfield 44	com/tencent/mm/plugin/websearch/b$3:lyQ	I
        //   256: invokestatic 179	com/tencent/mm/plugin/websearch/api/aj:asV	(I)Ljava/lang/String;
        //   259: astore 7
        //   261: aload_0
        //   262: getfield 46	com/tencent/mm/plugin/websearch/b$3:Wnw	Z
        //   265: ifeq +51 -> 316
        //   268: aload_0
        //   269: getfield 48	com/tencent/mm/plugin/websearch/b$3:val$type	I
        //   272: ifne +44 -> 316
        //   275: iload_1
        //   276: ifne +40 -> 316
        //   279: ldc 88
        //   281: ldc 181
        //   283: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   286: aload 8
        //   288: aload_0
        //   289: getfield 50	com/tencent/mm/plugin/websearch/b$3:rma	Ljava/lang/String;
        //   292: aload 7
        //   294: aload_0
        //   295: getfield 42	com/tencent/mm/plugin/websearch/b$3:bKa	Ljava/lang/String;
        //   298: aload_0
        //   299: getfield 44	com/tencent/mm/plugin/websearch/b$3:lyQ	I
        //   302: aload 5
        //   304: iload_2
        //   305: aload 4
        //   307: iload_1
        //   308: aconst_null
        //   309: aload_0
        //   310: getfield 40	com/tencent/mm/plugin/websearch/b$3:Wnv	Ljava/util/Map;
        //   313: invokestatic 186	com/tencent/mm/plugin/websearch/api/aj:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/util/Map;)V
        //   316: new 188	com/tencent/mm/autogen/a/qw
        //   319: dup
        //   320: invokespecial 189	com/tencent/mm/autogen/a/qw:<init>	()V
        //   323: astore 4
        //   325: aload 4
        //   327: getfield 193	com/tencent/mm/autogen/a/qw:hTT	Lcom/tencent/mm/autogen/a/qw$a;
        //   330: iconst_0
        //   331: putfield 198	com/tencent/mm/autogen/a/qw$a:scene	I
        //   334: aload 4
        //   336: invokevirtual 202	com/tencent/mm/autogen/a/qw:publish	()Z
        //   339: pop
        //   340: aload_0
        //   341: getfield 44	com/tencent/mm/plugin/websearch/b$3:lyQ	I
        //   344: aload_0
        //   345: getfield 46	com/tencent/mm/plugin/websearch/b$3:Wnw	Z
        //   348: aload_0
        //   349: getfield 48	com/tencent/mm/plugin/websearch/b$3:val$type	I
        //   352: aload 6
        //   354: invokevirtual 206	org/json/JSONObject:toString	()Ljava/lang/String;
        //   357: invokestatic 152	android/net/Uri:encode	(Ljava/lang/String;)Ljava/lang/String;
        //   360: ldc 111
        //   362: aload_0
        //   363: getfield 50	com/tencent/mm/plugin/websearch/b$3:rma	Ljava/lang/String;
        //   366: aload_0
        //   367: getfield 42	com/tencent/mm/plugin/websearch/b$3:bKa	Ljava/lang/String;
        //   370: ldc 111
        //   372: aload 7
        //   374: ldc 111
        //   376: aload 8
        //   378: invokestatic 209	com/tencent/mm/plugin/websearch/api/aj:a	(IZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
        //   381: astore 5
        //   383: aload_0
        //   384: getfield 40	com/tencent/mm/plugin/websearch/b$3:Wnv	Ljava/util/Map;
        //   387: ifnull +14 -> 401
        //   390: aload 5
        //   392: aload_0
        //   393: getfield 40	com/tencent/mm/plugin/websearch/b$3:Wnv	Ljava/util/Map;
        //   396: invokeinterface 213 2 0
        //   401: aload 5
        //   403: ldc 215
        //   405: aload_0
        //   406: getfield 42	com/tencent/mm/plugin/websearch/b$3:bKa	Ljava/lang/String;
        //   409: ldc 217
        //   411: invokestatic 223	com/tencent/mm/compatible/util/r:as	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   414: invokeinterface 155 3 0
        //   419: pop
        //   420: aload 5
        //   422: ldc 225
        //   424: aload_0
        //   425: getfield 50	com/tencent/mm/plugin/websearch/b$3:rma	Ljava/lang/String;
        //   428: invokeinterface 155 3 0
        //   433: pop
        //   434: aload 5
        //   436: ldc 227
        //   438: invokeinterface 122 2 0
        //   443: checkcast 124	java/lang/String
        //   446: astore 4
        //   448: aload 5
        //   450: ldc 227
        //   452: invokeinterface 230 2 0
        //   457: pop
        //   458: aload 5
        //   460: invokestatic 234	com/tencent/mm/plugin/websearch/api/aj:bo	(Ljava/util/Map;)Ljava/lang/String;
        //   463: astore 5
        //   465: aload_0
        //   466: getfield 40	com/tencent/mm/plugin/websearch/b$3:Wnv	Ljava/util/Map;
        //   469: ifnull +558 -> 1027
        //   472: ldc 236
        //   474: aload_0
        //   475: getfield 40	com/tencent/mm/plugin/websearch/b$3:Wnv	Ljava/util/Map;
        //   478: ldc 238
        //   480: invokeinterface 122 2 0
        //   485: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   488: ifeq +539 -> 1027
        //   491: iconst_0
        //   492: istore_3
        //   493: aload_0
        //   494: getfield 44	com/tencent/mm/plugin/websearch/b$3:lyQ	I
        //   497: aload_0
        //   498: getfield 50	com/tencent/mm/plugin/websearch/b$3:rma	Ljava/lang/String;
        //   501: aload 7
        //   503: aload_0
        //   504: getfield 46	com/tencent/mm/plugin/websearch/b$3:Wnw	Z
        //   507: aload_0
        //   508: getfield 42	com/tencent/mm/plugin/websearch/b$3:bKa	Ljava/lang/String;
        //   511: aload_0
        //   512: getfield 48	com/tencent/mm/plugin/websearch/b$3:val$type	I
        //   515: ldc 111
        //   517: ldc 111
        //   519: invokestatic 246	com/tencent/mm/plugin/websearch/api/ai:a	(ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
        //   522: invokestatic 250	com/tencent/mm/plugin/websearch/api/aj:ipS	()Landroid/content/Intent;
        //   525: astore 6
        //   527: aload 6
        //   529: ldc 252
        //   531: iload_3
        //   532: invokevirtual 258	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
        //   535: pop
        //   536: aload 6
        //   538: ldc_w 260
        //   541: aload_0
        //   542: getfield 48	com/tencent/mm/plugin/websearch/b$3:val$type	I
        //   545: invokevirtual 263	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   548: pop
        //   549: aload 6
        //   551: ldc_w 265
        //   554: aload_0
        //   555: getfield 52	com/tencent/mm/plugin/websearch/b$3:eSG	Ljava/lang/String;
        //   558: invokevirtual 268	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   561: pop
        //   562: aload 6
        //   564: ldc_w 270
        //   567: aload_0
        //   568: getfield 44	com/tencent/mm/plugin/websearch/b$3:lyQ	I
        //   571: invokevirtual 263	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   574: pop
        //   575: aload 6
        //   577: ldc_w 272
        //   580: aload_0
        //   581: getfield 42	com/tencent/mm/plugin/websearch/b$3:bKa	Ljava/lang/String;
        //   584: invokevirtual 268	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   587: pop
        //   588: aload_0
        //   589: getfield 42	com/tencent/mm/plugin/websearch/b$3:bKa	Ljava/lang/String;
        //   592: invokestatic 278	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   595: ifeq +10 -> 605
        //   598: aload_0
        //   599: getfield 54	com/tencent/mm/plugin/websearch/b$3:Wnx	Z
        //   602: ifeq +403 -> 1005
        //   605: iconst_1
        //   606: istore_3
        //   607: aload 6
        //   609: ldc_w 280
        //   612: iload_3
        //   613: invokevirtual 258	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
        //   616: pop
        //   617: aload 6
        //   619: ldc 225
        //   621: aload_0
        //   622: getfield 50	com/tencent/mm/plugin/websearch/b$3:rma	Ljava/lang/String;
        //   625: invokevirtual 268	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   628: pop
        //   629: aload 6
        //   631: ldc_w 282
        //   634: aload 7
        //   636: invokevirtual 268	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   639: pop
        //   640: aload 6
        //   642: ldc_w 284
        //   645: aload 5
        //   647: invokevirtual 268	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   650: pop
        //   651: aload 6
        //   653: ldc_w 286
        //   656: invokestatic 290	com/tencent/mm/plugin/websearch/b:ipu	()I
        //   659: invokevirtual 263	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   662: pop
        //   663: aload 6
        //   665: ldc_w 292
        //   668: aload_0
        //   669: getfield 50	com/tencent/mm/plugin/websearch/b$3:rma	Ljava/lang/String;
        //   672: invokestatic 295	com/tencent/mm/plugin/websearch/b:bio	(Ljava/lang/String;)Ljava/lang/String;
        //   675: invokevirtual 268	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   678: pop
        //   679: aload 6
        //   681: ldc_w 297
        //   684: aload_0
        //   685: getfield 56	com/tencent/mm/plugin/websearch/b$3:Wny	Z
        //   688: invokevirtual 258	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
        //   691: pop
        //   692: aload 6
        //   694: ldc_w 299
        //   697: aload_0
        //   698: getfield 58	com/tencent/mm/plugin/websearch/b$3:Wnz	I
        //   701: invokevirtual 263	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   704: pop
        //   705: aload 6
        //   707: ldc_w 301
        //   710: aload_0
        //   711: getfield 60	com/tencent/mm/plugin/websearch/b$3:WnA	Z
        //   714: invokevirtual 258	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
        //   717: pop
        //   718: aload 6
        //   720: ldc_w 303
        //   723: aload 4
        //   725: invokevirtual 268	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   728: pop
        //   729: aload_0
        //   730: getfield 62	com/tencent/mm/plugin/websearch/b$3:WnB	Z
        //   733: ifeq +15 -> 748
        //   736: aload 6
        //   738: ldc_w 305
        //   741: ldc_w 307
        //   744: invokevirtual 268	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   747: pop
        //   748: aload_0
        //   749: getfield 64	com/tencent/mm/plugin/websearch/b$3:WnC	I
        //   752: ldc_w 308
        //   755: if_icmpeq +16 -> 771
        //   758: aload 6
        //   760: ldc_w 310
        //   763: aload_0
        //   764: getfield 64	com/tencent/mm/plugin/websearch/b$3:WnC	I
        //   767: invokevirtual 263	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   770: pop
        //   771: aload 6
        //   773: ldc_w 312
        //   776: iconst_1
        //   777: invokevirtual 258	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
        //   780: pop
        //   781: aload_0
        //   782: getfield 44	com/tencent/mm/plugin/websearch/b$3:lyQ	I
        //   785: bipush 56
        //   787: if_icmpne +13 -> 800
        //   790: aload 6
        //   792: ldc_w 314
        //   795: iconst_1
        //   796: invokevirtual 258	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
        //   799: pop
        //   800: aload_0
        //   801: getfield 44	com/tencent/mm/plugin/websearch/b$3:lyQ	I
        //   804: iconst_3
        //   805: if_icmpne +205 -> 1010
        //   808: bipush 15
        //   810: invokestatic 319	com/tencent/mm/pluginsdk/wallet/h:setPayChannel	(I)V
        //   813: aload_0
        //   814: getfield 38	com/tencent/mm/plugin/websearch/b$3:val$context	Landroid/content/Context;
        //   817: ldc_w 321
        //   820: ldc_w 323
        //   823: aload 6
        //   825: invokestatic 329	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
        //   828: invokestatic 332	com/tencent/mm/plugin/websearch/b:ipv	()V
        //   831: ldc 74
        //   833: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   836: return
        //   837: new 334	java/lang/StringBuilder
        //   840: dup
        //   841: invokespecial 335	java/lang/StringBuilder:<init>	()V
        //   844: astore 7
        //   846: aload_0
        //   847: getfield 40	com/tencent/mm/plugin/websearch/b$3:Wnv	Ljava/util/Map;
        //   850: ldc_w 337
        //   853: invokeinterface 130 2 0
        //   858: ifeq +78 -> 936
        //   861: new 334	java/lang/StringBuilder
        //   864: dup
        //   865: invokespecial 335	java/lang/StringBuilder:<init>	()V
        //   868: aload_0
        //   869: getfield 40	com/tencent/mm/plugin/websearch/b$3:Wnv	Ljava/util/Map;
        //   872: ldc_w 337
        //   875: invokeinterface 122 2 0
        //   880: checkcast 124	java/lang/String
        //   883: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   886: ldc_w 343
        //   889: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   892: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   895: astore 4
        //   897: aload 7
        //   899: aload 4
        //   901: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   904: aload 5
        //   906: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   909: ldc_w 343
        //   912: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   915: aload_0
        //   916: getfield 42	com/tencent/mm/plugin/websearch/b$3:bKa	Ljava/lang/String;
        //   919: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   922: ldc_w 343
        //   925: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   928: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   931: astore 4
        //   933: goto -815 -> 118
        //   936: ldc_w 346
        //   939: astore 4
        //   941: goto -44 -> 897
        //   944: astore 5
        //   946: ldc 88
        //   948: ldc 111
        //   950: iconst_1
        //   951: anewarray 4	java/lang/Object
        //   954: dup
        //   955: iconst_0
        //   956: aload 5
        //   958: aastore
        //   959: invokestatic 349	com/tencent/mm/sdk/platformtools/Log:printDebugStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   962: goto -834 -> 128
        //   965: astore 7
        //   967: ldc 88
        //   969: ldc 111
        //   971: iconst_1
        //   972: anewarray 4	java/lang/Object
        //   975: dup
        //   976: iconst_0
        //   977: aload 7
        //   979: aastore
        //   980: invokestatic 349	com/tencent/mm/sdk/platformtools/Log:printDebugStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   983: goto -765 -> 218
        //   986: astore 4
        //   988: aload 5
        //   990: ldc 215
        //   992: aload_0
        //   993: getfield 42	com/tencent/mm/plugin/websearch/b$3:bKa	Ljava/lang/String;
        //   996: invokeinterface 155 3 0
        //   1001: pop
        //   1002: goto -582 -> 420
        //   1005: iconst_0
        //   1006: istore_3
        //   1007: goto -400 -> 607
        //   1010: aload_0
        //   1011: getfield 44	com/tencent/mm/plugin/websearch/b$3:lyQ	I
        //   1014: bipush 20
        //   1016: if_icmpne -203 -> 813
        //   1019: bipush 35
        //   1021: invokestatic 319	com/tencent/mm/pluginsdk/wallet/h:setPayChannel	(I)V
        //   1024: goto -211 -> 813
        //   1027: iconst_1
        //   1028: istore_3
        //   1029: goto -536 -> 493
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	1032	0	this	3
        //   64	244	1	i	int
        //   49	256	2	j	int
        //   492	537	3	bool	boolean
        //   61	879	4	localObject1	Object
        //   986	1	4	localException1	Exception
        //   46	859	5	localObject2	Object
        //   944	45	5	localJSONException	org.json.JSONException
        //   57	767	6	localObject3	Object
        //   194	704	7	localObject4	Object
        //   965	13	7	localException2	Exception
        //   250	127	8	str	String
        // Exception table:
        //   from	to	target	type
        //   118	128	944	org/json/JSONException
        //   180	196	965	java/lang/Exception
        //   201	218	965	java/lang/Exception
        //   401	420	986	java/lang/Exception
      }
    });
    AppMethodBeat.o(315012);
  }
  
  public final void W(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(116527);
    a(paramContext, 16, paramString1, paramString2, null);
    AppMethodBeat.o(116527);
  }
  
  public final void X(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(315066);
    Intent localIntent = new Intent();
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("key_trust_url", true);
    localIntent.putExtra("KRightBtn", true);
    localIntent.putExtra("ftsneedkeyboard", true);
    localIntent.putExtra("ftsType", 64);
    localIntent.putExtra("ftsbizscene", 14);
    Map localMap = a.ck(14, false);
    String str = com.tencent.mm.modelappbrand.c.bED();
    localMap.put("WASessionId", str);
    if (!Util.isNullOrNil(paramString2)) {
      localMap.put("query", paramString2);
    }
    localMap.put("sessionId", str);
    localMap.put("subSessionId", str);
    localIntent.putExtra("rawUrl", a.bo(localMap));
    localIntent.putExtra("key_load_js_without_delay", true);
    localIntent.addFlags(67108864);
    localIntent.putExtra("key_session_id", str);
    localIntent.putExtra("sessionId", str);
    localIntent.putExtra("subSessionId", str);
    localIntent.putExtra("ftsQuery", paramString2);
    localIntent.putExtra("key_preload_biz", 5);
    if (!Util.isNullOrNil(paramString1)) {
      localIntent.putExtra("key_search_place_holder", paramString1);
    }
    for (;;)
    {
      com.tencent.mm.br.c.b(paramContext, "appbrand", ".ui.AppBrandSearchUI", localIntent);
      AppMethodBeat.o(315066);
      return;
      paramString1 = com.tencent.mm.kernel.h.baE().ban().get(at.a.acPH, null);
      if ((paramString1 != null) && ((paramString1 instanceof String))) {
        localIntent.putExtra("key_search_input_hint", (String)paramString1);
      }
    }
  }
  
  public final void a(Context paramContext, int paramInt, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(116528);
    b(paramContext, paramInt, paramString1, paramString2, true, paramMap, "");
    AppMethodBeat.o(116528);
  }
  
  public final void a(Context paramContext, int paramInt1, String paramString1, String paramString2, Map<String, String> paramMap, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(116529);
    a(paramContext, paramInt1, paramString1, paramString2, true, paramMap, false, paramInt2, paramString3, 0, true);
    AppMethodBeat.o(116529);
  }
  
  public final void a(Context paramContext, int paramInt1, String paramString1, String paramString2, boolean paramBoolean, Map<String, String> paramMap, int paramInt2)
  {
    AppMethodBeat.i(315043);
    a(paramContext, paramInt1, paramString1, paramString2, paramBoolean, paramMap, false, 2147483647, "", paramInt2, true);
    AppMethodBeat.o(315043);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(116533);
    a(paramContext, 3, paramString1, paramString2, true, paramMap, true, -1, "");
    AppMethodBeat.o(116533);
  }
  
  public final void a(final ah paramah)
  {
    AppMethodBeat.i(315026);
    ((i)com.tencent.mm.kernel.h.ax(i.class)).a(paramah.context, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116526);
        if (!aj.asX(0))
        {
          Log.e("StartWebSearchService", "fts h5 template not avail");
          AppMethodBeat.o(116526);
          return;
        }
        Log.i("StartWebSearchService", "startWebSearch");
        b.b(paramah);
        if ((paramah.WoT != null) && (paramah.WoJ))
        {
          if ((!TextUtils.isEmpty((CharSequence)paramah.WoT.get("exposedFingerWord"))) || (!TextUtils.isEmpty((CharSequence)paramah.WoT.get("matchedFingerWord")))) {
            paramah.WoJ = false;
          }
          if (paramah.scene == 77) {
            paramah.WoJ = false;
          }
        }
        String str3 = String.valueOf(System.currentTimeMillis());
        String str2 = aj.asV(paramah.scene);
        int i = 0;
        Object localObject1 = null;
        if (paramah.hVt != null)
        {
          i = Util.safeParseInt((String)paramah.hVt.get("chatSearch"));
          localObject1 = (String)paramah.hVt.get("reqKey");
        }
        if (!Util.isNullOrNil(paramah.WoP)) {}
        label243:
        String str1;
        for (Object localObject2 = new JSONObject();; str1 = "") {
          try
          {
            ((JSONObject)localObject2).put("parentSearchID", paramah.WoP);
            localObject2 = Uri.encode(((JSONObject)localObject2).toString());
            Log.i("StartWebSearchService", "preload web search data");
            aj.a(str3, paramah.sessionId, str2, paramah.query, paramah.scene, "", -1, paramah.WoP, i, (String)localObject1, paramah.hVt);
            localObject1 = aj.a(paramah.scene, paramah.WoH, paramah.type, (String)localObject2, "", paramah.sessionId, paramah.query, "", str2, "", str3);
            if (paramah.hVt != null) {
              ((Map)localObject1).putAll(paramah.hVt);
            }
            try
            {
              ((Map)localObject1).put("query", r.as(paramah.query, "UTF-8"));
              ((Map)localObject1).put("sessionId", paramah.sessionId);
              ((Map)localObject1).put("parentSearchID", paramah.WoP);
              localObject1 = aj.bo((Map)localObject1);
              localObject2 = aj.ipS();
              ((Intent)localObject2).putExtra("ftsType", paramah.type);
              ((Intent)localObject2).putExtra("title", paramah.title);
              ((Intent)localObject2).putExtra("ftsbizscene", paramah.scene);
              ((Intent)localObject2).putExtra("ftsQuery", paramah.query);
              if ((!TextUtils.isEmpty(paramah.query)) || (paramah.WoI))
              {
                bool = true;
                ((Intent)localObject2).putExtra("ftsInitToSearch", bool);
                ((Intent)localObject2).putExtra("sessionId", paramah.sessionId);
                ((Intent)localObject2).putExtra("subSessionId", str2);
                ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
                ((Intent)localObject2).putExtra("key_preload_biz", b.ipu());
                ((Intent)localObject2).putExtra("key_weapp_url", b.bio(paramah.sessionId));
                ((Intent)localObject2).putExtra("hideSearchInput", paramah.WoJ);
                ((Intent)localObject2).putExtra("fts_need_sos_edittext_tobe_touch_only", paramah.WoS);
                ((Intent)localObject2).putExtra("key_back_btn_type", paramah.WoK);
                ((Intent)localObject2).putExtra("key_hide_shadow_view", paramah.WoM);
                ((Intent)localObject2).putExtra("first_page_result", paramah.WoO);
                if (paramah.WoN) {
                  ((Intent)localObject2).putExtra("status_bar_style", "black");
                }
                if (paramah.WoL != 2147483647) {
                  ((Intent)localObject2).putExtra("customize_status_bar_color", paramah.WoL);
                }
                ((Intent)localObject2).putExtra("key_load_js_without_delay", true);
                if (paramah.scene == 56) {
                  ((Intent)localObject2).putExtra("ftsneedkeyboard", true);
                }
                if (paramah.WoR) {
                  ((Intent)localObject2).addFlags(67108864);
                }
                com.tencent.mm.br.c.b(paramah.context, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", (Intent)localObject2);
                b.ipv();
                AppMethodBeat.o(116526);
                return;
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                ((Map)localObject1).put("query", paramah.query);
                continue;
                boolean bool = false;
              }
            }
          }
          catch (Exception localException2)
          {
            break label243;
          }
        }
      }
    });
    AppMethodBeat.o(315026);
  }
  
  public final void b(Context paramContext, int paramInt, String paramString1, String paramString2, boolean paramBoolean, Map<String, String> paramMap, String paramString3)
  {
    AppMethodBeat.i(315049);
    a(paramContext, paramInt, paramString1, paramString2, true, paramMap, paramString3);
    AppMethodBeat.o(315049);
  }
  
  public final void bg(final Context paramContext, final int paramInt)
  {
    AppMethodBeat.i(315072);
    ((i)com.tencent.mm.kernel.h.ax(i.class)).a(paramContext, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(315000);
        if (!aj.asX(0))
        {
          Log.e("StartWebSearchService", "fts h5 template not avail");
          AppMethodBeat.o(315000);
          return;
        }
        e.HrM = com.tencent.mm.plugin.fts.a.d.Wd(paramInt);
        Intent localIntent = aj.ipS();
        localIntent.putExtra("ftsneedkeyboard", true);
        localIntent.putExtra("ftsbizscene", paramInt);
        localIntent.putExtra("ftsType", this.val$type);
        localIntent.putExtra("key_change_search_icon", true);
        localIntent.putExtra("key_search_icon_and_hint_fix_default", true);
        Object localObject = aj.r(paramInt, false, this.val$type);
        ((Map)localObject).put("sessionId", String.valueOf(e.HrM));
        ((Map)localObject).put("subSessionId", String.valueOf(e.HrM));
        localIntent.putExtra("sessionId", String.valueOf(e.HrM));
        localIntent.putExtra("subSessionId", String.valueOf(e.HrM));
        localObject = aj.bo((Map)localObject);
        localIntent.putExtra("rawUrl", (String)localObject);
        Log.i("StartWebSearchService", "startMiniSearchTabByTemplate , KRawUrl = ".concat(String.valueOf(localObject)));
        localIntent.putExtra("key_load_js_without_delay", true);
        localIntent.putExtra("ftsneedkeyboard", true);
        com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", localIntent);
        if (((paramContext instanceof Activity)) && (com.tencent.mm.compatible.util.d.rd(16))) {
          ((Activity)paramContext).overridePendingTransition(a.a.fts_activity_anim_in, a.a.fts_activity_anim_out);
        }
        AppMethodBeat.o(315000);
      }
    });
    AppMethodBeat.o(315072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.b
 * JD-Core Version:    0.7.0.1
 */