package com.tencent.mm.plugin.websearch;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.websearch.c.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Map;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.plugin.websearch.api.h
{
  private void a(Context paramContext, int paramInt, String paramString1, String paramString2, boolean paramBoolean, Map<String, String> paramMap, String paramString3)
  {
    AppMethodBeat.i(256243);
    a(paramContext, paramInt, paramString1, paramString2, paramBoolean, paramMap, false, 2147483647, paramString3);
    AppMethodBeat.o(256243);
  }
  
  private void a(Context paramContext, int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, Map<String, String> paramMap, boolean paramBoolean2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(116534);
    a(paramContext, paramInt1, paramString1, paramString2, paramBoolean1, paramMap, paramBoolean2, paramInt2, paramString3, 0, false);
    AppMethodBeat.o(116534);
  }
  
  private void a(final Context paramContext, final int paramInt1, final String paramString1, final String paramString2, final boolean paramBoolean1, final Map<String, String> paramMap, final boolean paramBoolean2, final int paramInt2, final String paramString3, final int paramInt3, final boolean paramBoolean3)
  {
    AppMethodBeat.i(256250);
    ((i)com.tencent.mm.kernel.h.ae(i.class)).a(paramContext, new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 74
        //   2: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: iconst_0
        //   6: invokestatic 86	com/tencent/mm/plugin/websearch/api/ai:ang	(I)Z
        //   9: ifne +16 -> 25
        //   12: ldc 88
        //   14: ldc 90
        //   16: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   19: ldc 74
        //   21: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   24: return
        //   25: getstatic 105	com/tencent/mm/sdk/platformtools/WeChatBrands$Business$Entries:DiscoverySearch	Lcom/tencent/mm/sdk/platformtools/WeChatBrands$Business$Entries;
        //   28: aload_0
        //   29: getfield 38	com/tencent/mm/plugin/websearch/b$2:val$context	Landroid/content/Context;
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
        //   66: getfield 40	com/tencent/mm/plugin/websearch/b$2:Pxp	Ljava/util/Map;
        //   69: ifnull +852 -> 921
        //   72: aload_0
        //   73: getfield 40	com/tencent/mm/plugin/websearch/b$2:Pxp	Ljava/util/Map;
        //   76: ldc 116
        //   78: invokeinterface 122 2 0
        //   83: checkcast 124	java/lang/String
        //   86: astore 5
        //   88: aload_0
        //   89: getfield 40	com/tencent/mm/plugin/websearch/b$2:Pxp	Ljava/util/Map;
        //   92: ldc 126
        //   94: invokeinterface 130 2 0
        //   99: ifeq +676 -> 775
        //   102: aload_0
        //   103: getfield 40	com/tencent/mm/plugin/websearch/b$2:Pxp	Ljava/util/Map;
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
        //   129: getfield 40	com/tencent/mm/plugin/websearch/b$2:Pxp	Ljava/util/Map;
        //   132: ldc 116
        //   134: invokeinterface 122 2 0
        //   139: checkcast 124	java/lang/String
        //   142: astore 5
        //   144: aload_0
        //   145: getfield 40	com/tencent/mm/plugin/websearch/b$2:Pxp	Ljava/util/Map;
        //   148: ldc 136
        //   150: invokeinterface 122 2 0
        //   155: checkcast 124	java/lang/String
        //   158: invokestatic 142	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
        //   161: istore_2
        //   162: aload_0
        //   163: getfield 40	com/tencent/mm/plugin/websearch/b$2:Pxp	Ljava/util/Map;
        //   166: ldc 144
        //   168: invokeinterface 122 2 0
        //   173: checkcast 124	java/lang/String
        //   176: invokestatic 142	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
        //   179: istore_1
        //   180: aload_0
        //   181: getfield 40	com/tencent/mm/plugin/websearch/b$2:Pxp	Ljava/util/Map;
        //   184: ldc 146
        //   186: invokeinterface 122 2 0
        //   191: checkcast 124	java/lang/String
        //   194: astore 7
        //   196: aload 7
        //   198: ifnull +20 -> 218
        //   201: aload_0
        //   202: getfield 40	com/tencent/mm/plugin/websearch/b$2:Pxp	Ljava/util/Map;
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
        //   234: getfield 44	com/tencent/mm/plugin/websearch/b$2:iWM	I
        //   237: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   240: aastore
        //   241: invokestatic 166	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   244: invokestatic 172	java/lang/System:currentTimeMillis	()J
        //   247: invokestatic 175	java/lang/String:valueOf	(J)Ljava/lang/String;
        //   250: astore 8
        //   252: aload_0
        //   253: getfield 44	com/tencent/mm/plugin/websearch/b$2:iWM	I
        //   256: invokestatic 179	com/tencent/mm/plugin/websearch/api/ai:ane	(I)Ljava/lang/String;
        //   259: astore 7
        //   261: aload_0
        //   262: getfield 46	com/tencent/mm/plugin/websearch/b$2:Pxq	Z
        //   265: ifeq +51 -> 316
        //   268: aload_0
        //   269: getfield 48	com/tencent/mm/plugin/websearch/b$2:val$type	I
        //   272: ifne +44 -> 316
        //   275: iload_1
        //   276: ifne +40 -> 316
        //   279: ldc 88
        //   281: ldc 181
        //   283: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   286: aload 8
        //   288: aload_0
        //   289: getfield 50	com/tencent/mm/plugin/websearch/b$2:oiy	Ljava/lang/String;
        //   292: aload 7
        //   294: aload_0
        //   295: getfield 42	com/tencent/mm/plugin/websearch/b$2:acr	Ljava/lang/String;
        //   298: aload_0
        //   299: getfield 44	com/tencent/mm/plugin/websearch/b$2:iWM	I
        //   302: aload 5
        //   304: iload_2
        //   305: aload 4
        //   307: iload_1
        //   308: aconst_null
        //   309: aload_0
        //   310: getfield 40	com/tencent/mm/plugin/websearch/b$2:Pxp	Ljava/util/Map;
        //   313: invokestatic 186	com/tencent/mm/plugin/websearch/api/ai:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/util/Map;)V
        //   316: new 188	com/tencent/mm/f/a/pj
        //   319: dup
        //   320: invokespecial 189	com/tencent/mm/f/a/pj:<init>	()V
        //   323: astore 4
        //   325: aload 4
        //   327: getfield 193	com/tencent/mm/f/a/pj:fOb	Lcom/tencent/mm/f/a/pj$a;
        //   330: iconst_0
        //   331: putfield 198	com/tencent/mm/f/a/pj$a:scene	I
        //   334: getstatic 204	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
        //   337: aload 4
        //   339: invokevirtual 208	com/tencent/mm/sdk/event/EventCenter:publish	(Lcom/tencent/mm/sdk/event/IEvent;)Z
        //   342: pop
        //   343: aload_0
        //   344: getfield 44	com/tencent/mm/plugin/websearch/b$2:iWM	I
        //   347: aload_0
        //   348: getfield 46	com/tencent/mm/plugin/websearch/b$2:Pxq	Z
        //   351: aload_0
        //   352: getfield 48	com/tencent/mm/plugin/websearch/b$2:val$type	I
        //   355: aload 6
        //   357: invokevirtual 212	org/json/JSONObject:toString	()Ljava/lang/String;
        //   360: invokestatic 152	android/net/Uri:encode	(Ljava/lang/String;)Ljava/lang/String;
        //   363: ldc 111
        //   365: aload_0
        //   366: getfield 50	com/tencent/mm/plugin/websearch/b$2:oiy	Ljava/lang/String;
        //   369: aload_0
        //   370: getfield 42	com/tencent/mm/plugin/websearch/b$2:acr	Ljava/lang/String;
        //   373: ldc 111
        //   375: aload 7
        //   377: ldc 111
        //   379: aload 8
        //   381: invokestatic 215	com/tencent/mm/plugin/websearch/api/ai:a	(IZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
        //   384: astore 4
        //   386: aload_0
        //   387: getfield 40	com/tencent/mm/plugin/websearch/b$2:Pxp	Ljava/util/Map;
        //   390: ifnull +14 -> 404
        //   393: aload 4
        //   395: aload_0
        //   396: getfield 40	com/tencent/mm/plugin/websearch/b$2:Pxp	Ljava/util/Map;
        //   399: invokeinterface 219 2 0
        //   404: aload 4
        //   406: ldc 221
        //   408: aload_0
        //   409: getfield 42	com/tencent/mm/plugin/websearch/b$2:acr	Ljava/lang/String;
        //   412: ldc 223
        //   414: invokestatic 229	com/tencent/mm/compatible/util/q:an	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   417: invokeinterface 155 3 0
        //   422: pop
        //   423: aload 4
        //   425: ldc 231
        //   427: aload_0
        //   428: getfield 50	com/tencent/mm/plugin/websearch/b$2:oiy	Ljava/lang/String;
        //   431: invokeinterface 155 3 0
        //   436: pop
        //   437: aload 4
        //   439: invokestatic 235	com/tencent/mm/plugin/websearch/api/ai:aX	(Ljava/util/Map;)Ljava/lang/String;
        //   442: astore 5
        //   444: aload_0
        //   445: getfield 44	com/tencent/mm/plugin/websearch/b$2:iWM	I
        //   448: aload_0
        //   449: getfield 50	com/tencent/mm/plugin/websearch/b$2:oiy	Ljava/lang/String;
        //   452: aload 7
        //   454: aload_0
        //   455: getfield 46	com/tencent/mm/plugin/websearch/b$2:Pxq	Z
        //   458: aload_0
        //   459: getfield 42	com/tencent/mm/plugin/websearch/b$2:acr	Ljava/lang/String;
        //   462: aload_0
        //   463: getfield 48	com/tencent/mm/plugin/websearch/b$2:val$type	I
        //   466: ldc 111
        //   468: ldc 111
        //   470: invokestatic 240	com/tencent/mm/plugin/websearch/api/ah:a	(ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
        //   473: invokestatic 244	com/tencent/mm/plugin/websearch/api/ai:gQI	()Landroid/content/Intent;
        //   476: astore 6
        //   478: aload 6
        //   480: ldc 246
        //   482: aload_0
        //   483: getfield 48	com/tencent/mm/plugin/websearch/b$2:val$type	I
        //   486: invokevirtual 252	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   489: pop
        //   490: aload 6
        //   492: ldc 254
        //   494: aload_0
        //   495: getfield 52	com/tencent/mm/plugin/websearch/b$2:cWz	Ljava/lang/String;
        //   498: invokevirtual 257	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   501: pop
        //   502: aload 6
        //   504: ldc_w 259
        //   507: aload_0
        //   508: getfield 44	com/tencent/mm/plugin/websearch/b$2:iWM	I
        //   511: invokevirtual 252	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   514: pop
        //   515: aload 6
        //   517: ldc_w 261
        //   520: aload_0
        //   521: getfield 42	com/tencent/mm/plugin/websearch/b$2:acr	Ljava/lang/String;
        //   524: invokevirtual 257	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   527: pop
        //   528: aload_0
        //   529: getfield 42	com/tencent/mm/plugin/websearch/b$2:acr	Ljava/lang/String;
        //   532: invokestatic 267	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   535: ifeq +10 -> 545
        //   538: aload_0
        //   539: getfield 54	com/tencent/mm/plugin/websearch/b$2:Pxr	Z
        //   542: ifeq +401 -> 943
        //   545: iconst_1
        //   546: istore_3
        //   547: aload 6
        //   549: ldc_w 269
        //   552: iload_3
        //   553: invokevirtual 272	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
        //   556: pop
        //   557: aload 6
        //   559: ldc 231
        //   561: aload_0
        //   562: getfield 50	com/tencent/mm/plugin/websearch/b$2:oiy	Ljava/lang/String;
        //   565: invokevirtual 257	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   568: pop
        //   569: aload 6
        //   571: ldc_w 274
        //   574: aload 7
        //   576: invokevirtual 257	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   579: pop
        //   580: aload 6
        //   582: ldc_w 276
        //   585: aload 5
        //   587: invokevirtual 257	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   590: pop
        //   591: aload 6
        //   593: ldc_w 278
        //   596: invokestatic 282	com/tencent/mm/plugin/websearch/b:gQd	()I
        //   599: invokevirtual 252	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   602: pop
        //   603: aload 6
        //   605: ldc_w 284
        //   608: aload_0
        //   609: getfield 50	com/tencent/mm/plugin/websearch/b$2:oiy	Ljava/lang/String;
        //   612: invokestatic 287	com/tencent/mm/plugin/websearch/b:biG	(Ljava/lang/String;)Ljava/lang/String;
        //   615: invokevirtual 257	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   618: pop
        //   619: aload 6
        //   621: ldc_w 289
        //   624: aload_0
        //   625: getfield 56	com/tencent/mm/plugin/websearch/b$2:Pxs	Z
        //   628: invokevirtual 272	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
        //   631: pop
        //   632: aload 6
        //   634: ldc_w 291
        //   637: aload_0
        //   638: getfield 58	com/tencent/mm/plugin/websearch/b$2:Pxt	I
        //   641: invokevirtual 252	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   644: pop
        //   645: aload 6
        //   647: ldc_w 293
        //   650: aload_0
        //   651: getfield 60	com/tencent/mm/plugin/websearch/b$2:Pxu	Z
        //   654: invokevirtual 272	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
        //   657: pop
        //   658: aload 6
        //   660: ldc_w 295
        //   663: aload 4
        //   665: ldc_w 297
        //   668: invokeinterface 122 2 0
        //   673: checkcast 124	java/lang/String
        //   676: invokevirtual 257	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   679: pop
        //   680: aload_0
        //   681: getfield 62	com/tencent/mm/plugin/websearch/b$2:Pxv	Z
        //   684: ifeq +15 -> 699
        //   687: aload 6
        //   689: ldc_w 299
        //   692: ldc_w 301
        //   695: invokevirtual 257	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   698: pop
        //   699: aload_0
        //   700: getfield 64	com/tencent/mm/plugin/websearch/b$2:Pxw	I
        //   703: ldc_w 302
        //   706: if_icmpeq +16 -> 722
        //   709: aload 6
        //   711: ldc_w 304
        //   714: aload_0
        //   715: getfield 64	com/tencent/mm/plugin/websearch/b$2:Pxw	I
        //   718: invokevirtual 252	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   721: pop
        //   722: aload 6
        //   724: ldc_w 306
        //   727: iconst_1
        //   728: invokevirtual 272	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
        //   731: pop
        //   732: aload_0
        //   733: getfield 44	com/tencent/mm/plugin/websearch/b$2:iWM	I
        //   736: bipush 56
        //   738: if_icmpne +13 -> 751
        //   741: aload 6
        //   743: ldc_w 308
        //   746: iconst_1
        //   747: invokevirtual 272	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
        //   750: pop
        //   751: aload_0
        //   752: getfield 38	com/tencent/mm/plugin/websearch/b$2:val$context	Landroid/content/Context;
        //   755: ldc_w 310
        //   758: ldc_w 312
        //   761: aload 6
        //   763: invokestatic 318	com/tencent/mm/by/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
        //   766: invokestatic 321	com/tencent/mm/plugin/websearch/b:gQe	()V
        //   769: ldc 74
        //   771: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   774: return
        //   775: new 323	java/lang/StringBuilder
        //   778: dup
        //   779: invokespecial 324	java/lang/StringBuilder:<init>	()V
        //   782: astore 7
        //   784: aload_0
        //   785: getfield 40	com/tencent/mm/plugin/websearch/b$2:Pxp	Ljava/util/Map;
        //   788: ldc_w 326
        //   791: invokeinterface 130 2 0
        //   796: ifeq +78 -> 874
        //   799: new 323	java/lang/StringBuilder
        //   802: dup
        //   803: invokespecial 324	java/lang/StringBuilder:<init>	()V
        //   806: aload_0
        //   807: getfield 40	com/tencent/mm/plugin/websearch/b$2:Pxp	Ljava/util/Map;
        //   810: ldc_w 326
        //   813: invokeinterface 122 2 0
        //   818: checkcast 124	java/lang/String
        //   821: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   824: ldc_w 332
        //   827: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   830: invokevirtual 333	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   833: astore 4
        //   835: aload 7
        //   837: aload 4
        //   839: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   842: aload 5
        //   844: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   847: ldc_w 332
        //   850: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   853: aload_0
        //   854: getfield 42	com/tencent/mm/plugin/websearch/b$2:acr	Ljava/lang/String;
        //   857: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   860: ldc_w 332
        //   863: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   866: invokevirtual 333	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   869: astore 4
        //   871: goto -753 -> 118
        //   874: ldc_w 335
        //   877: astore 4
        //   879: goto -44 -> 835
        //   882: astore 5
        //   884: ldc 88
        //   886: ldc 111
        //   888: iconst_1
        //   889: anewarray 4	java/lang/Object
        //   892: dup
        //   893: iconst_0
        //   894: aload 5
        //   896: aastore
        //   897: invokestatic 338	com/tencent/mm/sdk/platformtools/Log:printDebugStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   900: goto -772 -> 128
        //   903: astore 7
        //   905: ldc 88
        //   907: ldc 111
        //   909: iconst_1
        //   910: anewarray 4	java/lang/Object
        //   913: dup
        //   914: iconst_0
        //   915: aload 7
        //   917: aastore
        //   918: invokestatic 338	com/tencent/mm/sdk/platformtools/Log:printDebugStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   921: goto -703 -> 218
        //   924: astore 5
        //   926: aload 4
        //   928: ldc 221
        //   930: aload_0
        //   931: getfield 42	com/tencent/mm/plugin/websearch/b$2:acr	Ljava/lang/String;
        //   934: invokeinterface 155 3 0
        //   939: pop
        //   940: goto -517 -> 423
        //   943: iconst_0
        //   944: istore_3
        //   945: goto -398 -> 547
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	948	0	this	2
        //   64	244	1	i	int
        //   49	256	2	j	int
        //   546	399	3	bool	boolean
        //   61	866	4	localObject1	Object
        //   46	797	5	str1	String
        //   882	13	5	localJSONException	org.json.JSONException
        //   924	1	5	localException1	Exception
        //   57	705	6	localObject2	Object
        //   194	642	7	localObject3	Object
        //   903	13	7	localException2	Exception
        //   250	130	8	str2	String
        // Exception table:
        //   from	to	target	type
        //   118	128	882	org/json/JSONException
        //   180	196	903	java/lang/Exception
        //   201	218	903	java/lang/Exception
        //   404	423	924	java/lang/Exception
      }
    });
    AppMethodBeat.o(256250);
  }
  
  public final void U(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(116527);
    a(paramContext, 16, paramString1, paramString2, null);
    AppMethodBeat.o(116527);
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
    AppMethodBeat.i(256240);
    a(paramContext, paramInt1, paramString1, paramString2, paramBoolean, paramMap, false, 2147483647, "", paramInt2, true);
    AppMethodBeat.o(256240);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(116533);
    a(paramContext, 3, paramString1, paramString2, true, paramMap, true, -1, "");
    AppMethodBeat.o(116533);
  }
  
  public final void a(final ag paramag)
  {
    AppMethodBeat.i(256237);
    ((i)com.tencent.mm.kernel.h.ae(i.class)).a(paramag.context, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116526);
        if (!ai.ang(0))
        {
          Log.e("StartWebSearchService", "fts h5 template not avail");
          AppMethodBeat.o(116526);
          return;
        }
        Log.i("StartWebSearchService", "startWebSearch");
        b.b(paramag);
        String str3 = String.valueOf(System.currentTimeMillis());
        String str2 = ai.ane(paramag.scene);
        int i = 0;
        Object localObject1 = null;
        if (paramag.fPy != null)
        {
          i = Util.safeParseInt((String)paramag.fPy.get("chatSearch"));
          localObject1 = (String)paramag.fPy.get("reqKey");
        }
        if (!Util.isNullOrNil(paramag.PyI)) {}
        label149:
        String str1;
        for (Object localObject2 = new JSONObject();; str1 = "") {
          try
          {
            ((JSONObject)localObject2).put("parentSearchID", paramag.PyI);
            localObject2 = Uri.encode(((JSONObject)localObject2).toString());
            Log.i("StartWebSearchService", "preload web search data");
            ai.a(str3, paramag.sessionId, str2, paramag.query, paramag.scene, "", -1, paramag.PyI, i, (String)localObject1, paramag.fPy);
            localObject1 = ai.a(paramag.scene, paramag.PyA, paramag.type, (String)localObject2, "", paramag.sessionId, paramag.query, "", str2, "", str3);
            if (paramag.fPy != null) {
              ((Map)localObject1).putAll(paramag.fPy);
            }
            try
            {
              ((Map)localObject1).put("query", q.an(paramag.query, "UTF-8"));
              ((Map)localObject1).put("sessionId", paramag.sessionId);
              ((Map)localObject1).put("parentSearchID", paramag.PyI);
              localObject1 = ai.aX((Map)localObject1);
              localObject2 = ai.gQI();
              ((Intent)localObject2).putExtra("ftsType", paramag.type);
              ((Intent)localObject2).putExtra("title", paramag.title);
              ((Intent)localObject2).putExtra("ftsbizscene", paramag.scene);
              ((Intent)localObject2).putExtra("ftsQuery", paramag.query);
              if ((!TextUtils.isEmpty(paramag.query)) || (paramag.PyB))
              {
                bool = true;
                ((Intent)localObject2).putExtra("ftsInitToSearch", bool);
                ((Intent)localObject2).putExtra("sessionId", paramag.sessionId);
                ((Intent)localObject2).putExtra("subSessionId", str2);
                ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
                ((Intent)localObject2).putExtra("key_preload_biz", b.gQd());
                ((Intent)localObject2).putExtra("key_weapp_url", b.biG(paramag.sessionId));
                ((Intent)localObject2).putExtra("hideSearchInput", paramag.PyC);
                ((Intent)localObject2).putExtra("key_back_btn_type", paramag.PyD);
                ((Intent)localObject2).putExtra("key_hide_shadow_view", paramag.PyF);
                ((Intent)localObject2).putExtra("first_page_result", paramag.PyH);
                if (paramag.PyG) {
                  ((Intent)localObject2).putExtra("status_bar_style", "black");
                }
                if (paramag.PyE != 2147483647) {
                  ((Intent)localObject2).putExtra("customize_status_bar_color", paramag.PyE);
                }
                ((Intent)localObject2).putExtra("key_load_js_without_delay", true);
                if (paramag.scene == 56) {
                  ((Intent)localObject2).putExtra("ftsneedkeyboard", true);
                }
                if (paramag.PyK) {
                  ((Intent)localObject2).addFlags(67108864);
                }
                c.b(paramag.context, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", (Intent)localObject2);
                b.gQe();
                AppMethodBeat.o(116526);
                return;
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                ((Map)localObject1).put("query", paramag.query);
                continue;
                boolean bool = false;
              }
            }
          }
          catch (Exception localException2)
          {
            break label149;
          }
        }
      }
    });
    AppMethodBeat.o(256237);
  }
  
  public final void b(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(256248);
    Intent localIntent = new Intent();
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.RBc);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.RAX);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("key_trust_url", true);
    localIntent.putExtra("KRightBtn", true);
    localIntent.putExtra("ftsneedkeyboard", true);
    localIntent.putExtra("ftsType", 64);
    localIntent.putExtra("ftsbizscene", paramInt);
    Map localMap = a.bC(paramInt, false);
    String str = com.tencent.mm.modelappbrand.b.bgL();
    localMap.put("WASessionId", str);
    if (!Util.isNullOrNil(paramString2)) {
      localMap.put("query", paramString2);
    }
    localMap.put("sessionId", str);
    localMap.put("subSessionId", str);
    localIntent.putExtra("rawUrl", a.aX(localMap));
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
      c.b(paramContext, "appbrand", ".ui.AppBrandSearchUI", localIntent);
      AppMethodBeat.o(256248);
      return;
      paramString1 = com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vol, null);
      if ((paramString1 != null) && ((paramString1 instanceof String))) {
        localIntent.putExtra("key_search_input_hint", (String)paramString1);
      }
    }
  }
  
  public final void b(Context paramContext, int paramInt, String paramString1, String paramString2, boolean paramBoolean, Map<String, String> paramMap, String paramString3)
  {
    AppMethodBeat.i(256245);
    a(paramContext, paramInt, paramString1, paramString2, true, paramMap, paramString3);
    AppMethodBeat.o(256245);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.b
 * JD-Core Version:    0.7.0.1
 */