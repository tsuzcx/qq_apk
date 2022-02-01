package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class bc<T extends a>
  extends bv<T>
{
  private static TrustManager WJo;
  
  static
  {
    AppMethodBeat.i(296061);
    WJo = new X509TrustManager()
    {
      public final void checkClientTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
      {
        AppMethodBeat.i(296018);
        Log.i("MicroMsg.JsApiRequest", "checkClientTrusted");
        AppMethodBeat.o(296018);
      }
      
      public final void checkServerTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
      {
        AppMethodBeat.i(296019);
        Log.i("MicroMsg.JsApiRequest", "checkServerTrusted");
        AppMethodBeat.o(296019);
      }
      
      public final X509Certificate[] getAcceptedIssuers()
      {
        return new X509Certificate[0];
      }
    };
    AppMethodBeat.o(296061);
  }
  
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public void b(final b<T>.a paramb)
  {
    AppMethodBeat.i(296065);
    h.ahAA.bm(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 31
        //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 21	com/tencent/mm/plugin/webview/luggage/jsapi/bc$1:Iux	Lcom/tencent/luggage/d/b$a;
        //   9: getfield 43	com/tencent/luggage/d/b$a:eiZ	Lcom/tencent/luggage/bridge/k;
        //   12: getfield 49	com/tencent/luggage/bridge/k:eif	Lorg/json/JSONObject;
        //   15: ldc 51
        //   17: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
        //   20: astore 5
        //   22: aload_0
        //   23: getfield 21	com/tencent/mm/plugin/webview/luggage/jsapi/bc$1:Iux	Lcom/tencent/luggage/d/b$a;
        //   26: getfield 43	com/tencent/luggage/d/b$a:eiZ	Lcom/tencent/luggage/bridge/k;
        //   29: getfield 49	com/tencent/luggage/bridge/k:eif	Lorg/json/JSONObject;
        //   32: ldc 59
        //   34: invokevirtual 63	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
        //   37: astore 4
        //   39: aload_0
        //   40: getfield 21	com/tencent/mm/plugin/webview/luggage/jsapi/bc$1:Iux	Lcom/tencent/luggage/d/b$a;
        //   43: getfield 43	com/tencent/luggage/d/b$a:eiZ	Lcom/tencent/luggage/bridge/k;
        //   46: getfield 49	com/tencent/luggage/bridge/k:eif	Lorg/json/JSONObject;
        //   49: ldc 65
        //   51: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
        //   54: astore 6
        //   56: aload_0
        //   57: getfield 21	com/tencent/mm/plugin/webview/luggage/jsapi/bc$1:Iux	Lcom/tencent/luggage/d/b$a;
        //   60: getfield 43	com/tencent/luggage/d/b$a:eiZ	Lcom/tencent/luggage/bridge/k;
        //   63: getfield 49	com/tencent/luggage/bridge/k:eif	Lorg/json/JSONObject;
        //   66: ldc 67
        //   68: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
        //   71: astore_2
        //   72: new 53	org/json/JSONObject
        //   75: dup
        //   76: invokespecial 68	org/json/JSONObject:<init>	()V
        //   79: astore_3
        //   80: aload 5
        //   82: invokestatic 74	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   85: ifeq +28 -> 113
        //   88: aload_3
        //   89: ldc 76
        //   91: ldc 78
        //   93: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   96: pop
        //   97: aload_0
        //   98: getfield 21	com/tencent/mm/plugin/webview/luggage/jsapi/bc$1:Iux	Lcom/tencent/luggage/d/b$a;
        //   101: ldc 84
        //   103: aload_3
        //   104: invokevirtual 88	com/tencent/luggage/d/b$a:a	(Ljava/lang/String;Lorg/json/JSONObject;)V
        //   107: ldc 31
        //   109: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   112: return
        //   113: aload 6
        //   115: invokestatic 74	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   118: ifne +23 -> 141
        //   121: aload 6
        //   123: ldc 93
        //   125: invokevirtual 98	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
        //   128: ifne +38 -> 166
        //   131: aload 6
        //   133: ldc 100
        //   135: invokevirtual 98	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
        //   138: ifne +28 -> 166
        //   141: aload_3
        //   142: ldc 76
        //   144: ldc 102
        //   146: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   149: pop
        //   150: aload_0
        //   151: getfield 21	com/tencent/mm/plugin/webview/luggage/jsapi/bc$1:Iux	Lcom/tencent/luggage/d/b$a;
        //   154: ldc 84
        //   156: aload_3
        //   157: invokevirtual 88	com/tencent/luggage/d/b$a:a	(Ljava/lang/String;Lorg/json/JSONObject;)V
        //   160: ldc 31
        //   162: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   165: return
        //   166: new 104	java/net/URL
        //   169: dup
        //   170: aload 5
        //   172: invokespecial 107	java/net/URL:<init>	(Ljava/lang/String;)V
        //   175: astore 5
        //   177: invokestatic 113	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
        //   180: invokestatic 119	com/tencent/xweb/ao:oQ	(Landroid/content/Context;)V
        //   183: new 121	java/lang/StringBuilder
        //   186: dup
        //   187: ldc 123
        //   189: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   192: aload 5
        //   194: invokevirtual 128	java/net/URL:getHost	()Ljava/lang/String;
        //   197: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   200: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   203: invokestatic 138	com/tencent/xweb/ao:getCookie	(Ljava/lang/String;)Ljava/lang/String;
        //   206: astore 7
        //   208: aload 5
        //   210: invokevirtual 142	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   213: checkcast 144	java/net/HttpURLConnection
        //   216: astore 5
        //   218: aload 5
        //   220: sipush 10000
        //   223: invokevirtual 147	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   226: aload 5
        //   228: sipush 10000
        //   231: invokevirtual 150	java/net/HttpURLConnection:setReadTimeout	(I)V
        //   234: aload 5
        //   236: iconst_0
        //   237: invokevirtual 154	java/net/HttpURLConnection:setUseCaches	(Z)V
        //   240: aload 5
        //   242: iconst_1
        //   243: invokevirtual 157	java/net/HttpURLConnection:setDoInput	(Z)V
        //   246: aload 5
        //   248: iconst_1
        //   249: invokevirtual 160	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
        //   252: aload 4
        //   254: ifnull +86 -> 340
        //   257: aload 4
        //   259: invokevirtual 164	org/json/JSONObject:keys	()Ljava/util/Iterator;
        //   262: astore 8
        //   264: aload 8
        //   266: invokeinterface 170 1 0
        //   271: ifeq +69 -> 340
        //   274: aload 8
        //   276: invokeinterface 174 1 0
        //   281: checkcast 95	java/lang/String
        //   284: astore 9
        //   286: aload 5
        //   288: aload 9
        //   290: aload 4
        //   292: aload 9
        //   294: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
        //   297: invokevirtual 178	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   300: goto -36 -> 264
        //   303: astore_2
        //   304: ldc 180
        //   306: aload_2
        //   307: invokevirtual 183	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   310: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   313: aload_3
        //   314: ldc 76
        //   316: aload_2
        //   317: invokevirtual 183	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   320: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   323: pop
        //   324: aload_0
        //   325: getfield 21	com/tencent/mm/plugin/webview/luggage/jsapi/bc$1:Iux	Lcom/tencent/luggage/d/b$a;
        //   328: ldc 84
        //   330: aload_3
        //   331: invokevirtual 88	com/tencent/luggage/d/b$a:a	(Ljava/lang/String;Lorg/json/JSONObject;)V
        //   334: ldc 31
        //   336: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   339: return
        //   340: aload 5
        //   342: ldc 190
        //   344: aload_0
        //   345: getfield 21	com/tencent/mm/plugin/webview/luggage/jsapi/bc$1:Iux	Lcom/tencent/luggage/d/b$a;
        //   348: getfield 194	com/tencent/luggage/d/b$a:eiY	Lcom/tencent/luggage/d/c;
        //   351: checkcast 196	com/tencent/luggage/d/a
        //   354: invokeinterface 200 1 0
        //   359: invokevirtual 205	com/tencent/luggage/d/n:getUserAgent	()Ljava/lang/String;
        //   362: invokevirtual 178	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   365: aload 7
        //   367: ifnull +12 -> 379
        //   370: aload 5
        //   372: ldc 207
        //   374: aload 7
        //   376: invokevirtual 178	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   379: aload 6
        //   381: ldc 93
        //   383: invokevirtual 98	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
        //   386: ifeq +219 -> 605
        //   389: aload 5
        //   391: ldc 93
        //   393: invokevirtual 210	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   396: aload 5
        //   398: invokevirtual 214	java/net/HttpURLConnection:getResponseCode	()I
        //   401: istore_1
        //   402: aload 5
        //   404: invokevirtual 217	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
        //   407: astore 4
        //   409: iload_1
        //   410: sipush 200
        //   413: if_icmpeq +10 -> 423
        //   416: iload_1
        //   417: sipush 206
        //   420: if_icmpne +366 -> 786
        //   423: aload 5
        //   425: invokevirtual 220	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
        //   428: astore_2
        //   429: aload 5
        //   431: invokevirtual 224	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   434: astore 5
        //   436: aload_2
        //   437: ifnull +234 -> 671
        //   440: aload_2
        //   441: invokevirtual 227	java/lang/String:toLowerCase	()Ljava/lang/String;
        //   444: ldc 229
        //   446: invokevirtual 233	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   449: ifeq +222 -> 671
        //   452: new 235	java/util/zip/GZIPInputStream
        //   455: dup
        //   456: aload 5
        //   458: invokespecial 238	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
        //   461: astore_2
        //   462: new 240	java/io/InputStreamReader
        //   465: dup
        //   466: aload_2
        //   467: invokespecial 241	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
        //   470: astore 5
        //   472: sipush 4096
        //   475: newarray char
        //   477: astore 7
        //   479: new 243	java/io/StringWriter
        //   482: dup
        //   483: invokespecial 244	java/io/StringWriter:<init>	()V
        //   486: astore 6
        //   488: aload 5
        //   490: aload 7
        //   492: invokevirtual 248	java/io/InputStreamReader:read	([C)I
        //   495: istore_1
        //   496: iconst_m1
        //   497: iload_1
        //   498: if_icmpeq +186 -> 684
        //   501: aload 6
        //   503: aload 7
        //   505: iconst_0
        //   506: iload_1
        //   507: invokevirtual 252	java/io/StringWriter:write	([CII)V
        //   510: goto -22 -> 488
        //   513: astore 7
        //   515: ldc 180
        //   517: ldc 254
        //   519: iconst_1
        //   520: anewarray 4	java/lang/Object
        //   523: dup
        //   524: iconst_0
        //   525: aload 7
        //   527: invokevirtual 183	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   530: aastore
        //   531: invokestatic 257	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   534: aload_3
        //   535: ldc 76
        //   537: aload 7
        //   539: invokevirtual 183	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   542: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   545: pop
        //   546: aload_0
        //   547: getfield 21	com/tencent/mm/plugin/webview/luggage/jsapi/bc$1:Iux	Lcom/tencent/luggage/d/b$a;
        //   550: ldc 84
        //   552: aload_3
        //   553: invokevirtual 88	com/tencent/luggage/d/b$a:a	(Ljava/lang/String;Lorg/json/JSONObject;)V
        //   556: aload 5
        //   558: invokestatic 261	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
        //   561: aload_2
        //   562: invokestatic 261	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
        //   565: aload_3
        //   566: ldc_w 263
        //   569: aload 4
        //   571: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   574: pop
        //   575: aload_3
        //   576: ldc_w 265
        //   579: aload 6
        //   581: invokevirtual 266	java/io/StringWriter:toString	()Ljava/lang/String;
        //   584: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   587: pop
        //   588: aload_0
        //   589: getfield 21	com/tencent/mm/plugin/webview/luggage/jsapi/bc$1:Iux	Lcom/tencent/luggage/d/b$a;
        //   592: ldc_w 268
        //   595: aload_3
        //   596: invokevirtual 88	com/tencent/luggage/d/b$a:a	(Ljava/lang/String;Lorg/json/JSONObject;)V
        //   599: ldc 31
        //   601: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   604: return
        //   605: aload 6
        //   607: ldc 100
        //   609: invokevirtual 98	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
        //   612: ifeq -216 -> 396
        //   615: aload 5
        //   617: ldc 100
        //   619: invokevirtual 210	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   622: aload 5
        //   624: iconst_1
        //   625: invokevirtual 271	java/net/HttpURLConnection:setDoOutput	(Z)V
        //   628: new 273	java/io/BufferedWriter
        //   631: dup
        //   632: new 275	java/io/OutputStreamWriter
        //   635: dup
        //   636: aload 5
        //   638: invokevirtual 279	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
        //   641: ldc_w 281
        //   644: invokespecial 284	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
        //   647: invokespecial 287	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
        //   650: astore 4
        //   652: aload 4
        //   654: aload_2
        //   655: invokevirtual 289	java/io/BufferedWriter:write	(Ljava/lang/String;)V
        //   658: aload 4
        //   660: invokevirtual 292	java/io/BufferedWriter:flush	()V
        //   663: aload 4
        //   665: invokevirtual 295	java/io/BufferedWriter:close	()V
        //   668: goto -272 -> 396
        //   671: new 297	java/io/BufferedInputStream
        //   674: dup
        //   675: aload 5
        //   677: invokespecial 298	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
        //   680: astore_2
        //   681: goto -219 -> 462
        //   684: aload 5
        //   686: invokestatic 261	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
        //   689: aload_2
        //   690: invokestatic 261	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
        //   693: aload_3
        //   694: ldc_w 263
        //   697: aload 4
        //   699: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   702: pop
        //   703: aload_3
        //   704: ldc_w 265
        //   707: aload 6
        //   709: invokevirtual 266	java/io/StringWriter:toString	()Ljava/lang/String;
        //   712: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   715: pop
        //   716: aload_0
        //   717: getfield 21	com/tencent/mm/plugin/webview/luggage/jsapi/bc$1:Iux	Lcom/tencent/luggage/d/b$a;
        //   720: ldc_w 268
        //   723: aload_3
        //   724: invokevirtual 88	com/tencent/luggage/d/b$a:a	(Ljava/lang/String;Lorg/json/JSONObject;)V
        //   727: ldc 31
        //   729: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   732: return
        //   733: astore 7
        //   735: aload 5
        //   737: invokestatic 261	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
        //   740: aload_2
        //   741: invokestatic 261	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
        //   744: aload_3
        //   745: ldc_w 263
        //   748: aload 4
        //   750: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   753: pop
        //   754: aload_3
        //   755: ldc_w 265
        //   758: aload 6
        //   760: invokevirtual 266	java/io/StringWriter:toString	()Ljava/lang/String;
        //   763: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   766: pop
        //   767: aload_0
        //   768: getfield 21	com/tencent/mm/plugin/webview/luggage/jsapi/bc$1:Iux	Lcom/tencent/luggage/d/b$a;
        //   771: ldc_w 268
        //   774: aload_3
        //   775: invokevirtual 88	com/tencent/luggage/d/b$a:a	(Ljava/lang/String;Lorg/json/JSONObject;)V
        //   778: ldc 31
        //   780: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   783: aload 7
        //   785: athrow
        //   786: aload_3
        //   787: ldc_w 263
        //   790: aload 4
        //   792: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   795: pop
        //   796: aload_0
        //   797: getfield 21	com/tencent/mm/plugin/webview/luggage/jsapi/bc$1:Iux	Lcom/tencent/luggage/d/b$a;
        //   800: ldc 84
        //   802: aload_3
        //   803: invokevirtual 88	com/tencent/luggage/d/b$a:a	(Ljava/lang/String;Lorg/json/JSONObject;)V
        //   806: ldc 31
        //   808: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   811: return
        //   812: astore_2
        //   813: goto -489 -> 324
        //   816: astore_2
        //   817: goto -667 -> 150
        //   820: astore_2
        //   821: goto -724 -> 97
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	824	0	this	1
        //   401	106	1	i	int
        //   71	1	2	str1	String
        //   303	14	2	localException1	java.lang.Exception
        //   428	313	2	localObject1	Object
        //   812	1	2	localJSONException1	org.json.JSONException
        //   816	1	2	localJSONException2	org.json.JSONException
        //   820	1	2	localJSONException3	org.json.JSONException
        //   79	724	3	localJSONObject	org.json.JSONObject
        //   37	754	4	localObject2	Object
        //   20	716	5	localObject3	Object
        //   54	705	6	localObject4	Object
        //   206	298	7	localObject5	Object
        //   513	25	7	localException2	java.lang.Exception
        //   733	51	7	localObject6	Object
        //   262	13	8	localIterator	java.util.Iterator
        //   284	9	9	str2	String
        // Exception table:
        //   from	to	target	type
        //   166	252	303	java/lang/Exception
        //   257	264	303	java/lang/Exception
        //   264	300	303	java/lang/Exception
        //   340	365	303	java/lang/Exception
        //   370	379	303	java/lang/Exception
        //   379	396	303	java/lang/Exception
        //   396	409	303	java/lang/Exception
        //   423	436	303	java/lang/Exception
        //   440	462	303	java/lang/Exception
        //   462	488	303	java/lang/Exception
        //   556	604	303	java/lang/Exception
        //   605	668	303	java/lang/Exception
        //   671	681	303	java/lang/Exception
        //   684	732	303	java/lang/Exception
        //   735	786	303	java/lang/Exception
        //   786	806	303	java/lang/Exception
        //   488	496	513	java/lang/Exception
        //   501	510	513	java/lang/Exception
        //   488	496	733	finally
        //   501	510	733	finally
        //   515	556	733	finally
        //   313	324	812	org/json/JSONException
        //   141	150	816	org/json/JSONException
        //   88	97	820	org/json/JSONException
      }
    });
    AppMethodBeat.o(296065);
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "request";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bc
 * JD-Core Version:    0.7.0.1
 */