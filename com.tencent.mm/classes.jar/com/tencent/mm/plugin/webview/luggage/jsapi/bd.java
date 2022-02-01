package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class bd<T extends a>
  extends bv<T>
{
  private static JSONObject cm(Map<String, String> paramMap)
  {
    AppMethodBeat.i(296062);
    localJSONObject = new JSONObject();
    if (paramMap == null)
    {
      AppMethodBeat.o(296062);
      return localJSONObject;
    }
    try
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject.put(str, paramMap.get(str));
      }
      return localJSONObject;
    }
    catch (Exception paramMap)
    {
      AppMethodBeat.o(296062);
    }
  }
  
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(final b<T>.a paramb)
  {
    AppMethodBeat.i(296066);
    h.ahAA.bm(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 33
        //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 21	com/tencent/mm/plugin/webview/luggage/jsapi/bd$1:Iux	Lcom/tencent/luggage/d/b$a;
        //   9: getfield 45	com/tencent/luggage/d/b$a:eiZ	Lcom/tencent/luggage/bridge/k;
        //   12: getfield 51	com/tencent/luggage/bridge/k:eif	Lorg/json/JSONObject;
        //   15: astore_1
        //   16: aload_1
        //   17: ldc 53
        //   19: invokevirtual 59	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
        //   22: astore 5
        //   24: aload 5
        //   26: invokestatic 65	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   29: ifeq +19 -> 48
        //   32: aload_0
        //   33: getfield 21	com/tencent/mm/plugin/webview/luggage/jsapi/bd$1:Iux	Lcom/tencent/luggage/d/b$a;
        //   36: ldc 67
        //   38: aconst_null
        //   39: invokevirtual 71	com/tencent/luggage/d/b$a:a	(Ljava/lang/String;Lorg/json/JSONObject;)V
        //   42: ldc 33
        //   44: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   47: return
        //   48: aload_1
        //   49: ldc 76
        //   51: ldc 78
        //   53: invokevirtual 81	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   56: astore 6
        //   58: new 55	org/json/JSONObject
        //   61: dup
        //   62: invokespecial 82	org/json/JSONObject:<init>	()V
        //   65: astore_3
        //   66: new 84	com/tencent/mm/plugin/wepkg/f
        //   69: dup
        //   70: invokespecial 85	com/tencent/mm/plugin/wepkg/f:<init>	()V
        //   73: astore 4
        //   75: aload 4
        //   77: aload 5
        //   79: iconst_1
        //   80: iconst_0
        //   81: invokevirtual 89	com/tencent/mm/plugin/wepkg/f:q	(Ljava/lang/String;ZZ)Z
        //   84: ifeq +197 -> 281
        //   87: ldc 91
        //   89: ldc 93
        //   91: invokestatic 98	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   94: aload 4
        //   96: aconst_null
        //   97: aload 5
        //   99: aconst_null
        //   100: invokevirtual 101	com/tencent/mm/plugin/wepkg/f:a	(Lcom/tencent/xweb/WebView;Ljava/lang/String;Lcom/tencent/xweb/WebResourceRequest;)Lcom/tencent/xweb/WebResourceResponse;
        //   103: astore_2
        //   104: aload_2
        //   105: ifnull +176 -> 281
        //   108: ldc 103
        //   110: astore_1
        //   111: aload_2
        //   112: getfield 109	com/tencent/xweb/WebResourceResponse:mInputStream	Ljava/io/InputStream;
        //   115: invokestatic 115	com/tencent/mm/plugin/webview/k/d:Z	(Ljava/io/InputStream;)[B
        //   118: astore 5
        //   120: aload_3
        //   121: ldc 117
        //   123: aload_2
        //   124: getfield 121	com/tencent/xweb/WebResourceResponse:mResponseHeaders	Ljava/util/Map;
        //   127: invokestatic 125	com/tencent/mm/plugin/webview/luggage/jsapi/bd:cn	(Ljava/util/Map;)Lorg/json/JSONObject;
        //   130: invokevirtual 129	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   133: pop
        //   134: aload 5
        //   136: invokestatic 132	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
        //   139: ifne +490 -> 629
        //   142: aload 6
        //   144: ldc 134
        //   146: invokevirtual 140	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   149: ifeq +42 -> 191
        //   152: aload 5
        //   154: iconst_2
        //   155: invokestatic 146	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
        //   158: astore_2
        //   159: aload_2
        //   160: astore_1
        //   161: aload_3
        //   162: ldc 148
        //   164: aload_1
        //   165: invokevirtual 129	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   168: pop
        //   169: aload_0
        //   170: getfield 21	com/tencent/mm/plugin/webview/luggage/jsapi/bd$1:Iux	Lcom/tencent/luggage/d/b$a;
        //   173: ldc 103
        //   175: aload_3
        //   176: invokevirtual 71	com/tencent/luggage/d/b$a:a	(Ljava/lang/String;Lorg/json/JSONObject;)V
        //   179: aload 4
        //   181: iconst_1
        //   182: invokevirtual 152	com/tencent/mm/plugin/wepkg/f:Jk	(Z)V
        //   185: ldc 33
        //   187: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   190: return
        //   191: new 136	java/lang/String
        //   194: dup
        //   195: aload 5
        //   197: ldc 154
        //   199: invokespecial 157	java/lang/String:<init>	([BLjava/lang/String;)V
        //   202: astore_2
        //   203: aload_2
        //   204: astore_1
        //   205: goto -44 -> 161
        //   208: astore_2
        //   209: ldc 91
        //   211: new 159	java/lang/StringBuilder
        //   214: dup
        //   215: ldc 161
        //   217: invokespecial 164	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   220: aload_2
        //   221: invokevirtual 168	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
        //   224: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   227: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   230: invokestatic 178	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   233: goto -72 -> 161
        //   236: astore_1
        //   237: aload_0
        //   238: getfield 21	com/tencent/mm/plugin/webview/luggage/jsapi/bd$1:Iux	Lcom/tencent/luggage/d/b$a;
        //   241: ldc 67
        //   243: aconst_null
        //   244: invokevirtual 71	com/tencent/luggage/d/b$a:a	(Ljava/lang/String;Lorg/json/JSONObject;)V
        //   247: ldc 33
        //   249: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   252: return
        //   253: astore_2
        //   254: ldc 91
        //   256: new 159	java/lang/StringBuilder
        //   259: dup
        //   260: ldc 161
        //   262: invokespecial 164	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   265: aload_2
        //   266: invokevirtual 179	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
        //   269: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   272: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   275: invokestatic 178	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   278: goto -117 -> 161
        //   281: aload 5
        //   283: aconst_null
        //   284: invokestatic 183	com/tencent/mm/plugin/webview/k/d:af	(Ljava/lang/String;Ljava/util/Map;)Lcom/tencent/mm/plugin/webview/k/d$a;
        //   287: astore 7
        //   289: aload 7
        //   291: ifnull +304 -> 595
        //   294: new 55	org/json/JSONObject
        //   297: dup
        //   298: invokespecial 82	org/json/JSONObject:<init>	()V
        //   301: astore 4
        //   303: aload 4
        //   305: ldc 117
        //   307: aload 7
        //   309: getfield 188	com/tencent/mm/plugin/webview/k/d$a:toO	Ljava/util/Map;
        //   312: invokestatic 125	com/tencent/mm/plugin/webview/luggage/jsapi/bd:cn	(Ljava/util/Map;)Lorg/json/JSONObject;
        //   315: invokevirtual 129	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   318: pop
        //   319: ldc 103
        //   321: astore_3
        //   322: aload_3
        //   323: astore_2
        //   324: aload_3
        //   325: astore_1
        //   326: aload 7
        //   328: getfield 192	com/tencent/mm/plugin/webview/k/d$a:XsI	[B
        //   331: invokestatic 132	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
        //   334: ifne +107 -> 441
        //   337: aload_3
        //   338: astore_2
        //   339: aload_3
        //   340: astore_1
        //   341: aload 6
        //   343: ldc 134
        //   345: invokevirtual 140	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   348: ifeq +54 -> 402
        //   351: aload_3
        //   352: astore_2
        //   353: aload_3
        //   354: astore_1
        //   355: aload 7
        //   357: getfield 192	com/tencent/mm/plugin/webview/k/d$a:XsI	[B
        //   360: iconst_2
        //   361: invokestatic 146	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
        //   364: astore_3
        //   365: aload_3
        //   366: astore_1
        //   367: aload_1
        //   368: astore_2
        //   369: aload_1
        //   370: ifnonnull +6 -> 376
        //   373: ldc 103
        //   375: astore_2
        //   376: aload 4
        //   378: ldc 148
        //   380: aload_2
        //   381: invokevirtual 129	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   384: pop
        //   385: aload_0
        //   386: getfield 21	com/tencent/mm/plugin/webview/luggage/jsapi/bd$1:Iux	Lcom/tencent/luggage/d/b$a;
        //   389: ldc 103
        //   391: aload 4
        //   393: invokevirtual 71	com/tencent/luggage/d/b$a:a	(Ljava/lang/String;Lorg/json/JSONObject;)V
        //   396: ldc 33
        //   398: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   401: return
        //   402: aload_3
        //   403: astore_2
        //   404: aload_3
        //   405: astore_1
        //   406: new 136	java/lang/String
        //   409: dup
        //   410: aload 7
        //   412: getfield 192	com/tencent/mm/plugin/webview/k/d$a:XsI	[B
        //   415: ldc 154
        //   417: invokespecial 157	java/lang/String:<init>	([BLjava/lang/String;)V
        //   420: astore_3
        //   421: ldc 91
        //   423: ldc 194
        //   425: aload 5
        //   427: invokestatic 198	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   430: invokevirtual 201	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   433: invokestatic 178	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   436: aload_3
        //   437: astore_1
        //   438: goto -71 -> 367
        //   441: aload_3
        //   442: astore_2
        //   443: aload_3
        //   444: astore_1
        //   445: aload 7
        //   447: getfield 204	com/tencent/mm/plugin/webview/k/d$a:data	Ljava/lang/String;
        //   450: invokestatic 65	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   453: ifne +170 -> 623
        //   456: aload_3
        //   457: astore_2
        //   458: aload_3
        //   459: astore_1
        //   460: aload 6
        //   462: ldc 134
        //   464: invokevirtual 140	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   467: ifeq +44 -> 511
        //   470: aload_3
        //   471: astore_2
        //   472: aload_3
        //   473: astore_1
        //   474: aload 7
        //   476: getfield 204	com/tencent/mm/plugin/webview/k/d$a:data	Ljava/lang/String;
        //   479: invokevirtual 208	java/lang/String:getBytes	()[B
        //   482: iconst_2
        //   483: invokestatic 146	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
        //   486: astore_3
        //   487: aload_3
        //   488: astore_2
        //   489: aload_3
        //   490: astore_1
        //   491: ldc 91
        //   493: ldc 210
        //   495: aload 5
        //   497: invokestatic 198	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   500: invokevirtual 201	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   503: invokestatic 178	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   506: aload_3
        //   507: astore_1
        //   508: goto -141 -> 367
        //   511: aload_3
        //   512: astore_2
        //   513: aload_3
        //   514: astore_1
        //   515: new 136	java/lang/String
        //   518: dup
        //   519: aload 7
        //   521: getfield 204	com/tencent/mm/plugin/webview/k/d$a:data	Ljava/lang/String;
        //   524: invokevirtual 208	java/lang/String:getBytes	()[B
        //   527: ldc 154
        //   529: invokespecial 157	java/lang/String:<init>	([BLjava/lang/String;)V
        //   532: astore_3
        //   533: aload_3
        //   534: astore_1
        //   535: goto -168 -> 367
        //   538: astore_1
        //   539: ldc 91
        //   541: new 159	java/lang/StringBuilder
        //   544: dup
        //   545: ldc 161
        //   547: invokespecial 164	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   550: aload_1
        //   551: invokevirtual 168	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
        //   554: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   557: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   560: invokestatic 178	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   563: aload_2
        //   564: astore_1
        //   565: goto -198 -> 367
        //   568: ldc 91
        //   570: new 159	java/lang/StringBuilder
        //   573: dup
        //   574: ldc 161
        //   576: invokespecial 164	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   579: aload_2
        //   580: invokevirtual 179	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
        //   583: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   586: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   589: invokestatic 178	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   592: goto -225 -> 367
        //   595: aload_0
        //   596: getfield 21	com/tencent/mm/plugin/webview/luggage/jsapi/bd$1:Iux	Lcom/tencent/luggage/d/b$a;
        //   599: ldc 67
        //   601: aconst_null
        //   602: invokevirtual 71	com/tencent/luggage/d/b$a:a	(Ljava/lang/String;Lorg/json/JSONObject;)V
        //   605: ldc 33
        //   607: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   610: return
        //   611: astore_2
        //   612: aload_3
        //   613: astore_1
        //   614: goto -46 -> 568
        //   617: astore_1
        //   618: aload_3
        //   619: astore_2
        //   620: goto -81 -> 539
        //   623: ldc 103
        //   625: astore_1
        //   626: goto -259 -> 367
        //   629: ldc 103
        //   631: astore_1
        //   632: goto -427 -> 205
        //   635: astore_2
        //   636: goto -68 -> 568
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	639	0	this	1
        //   15	190	1	localObject1	Object
        //   236	1	1	localJSONException	org.json.JSONException
        //   325	210	1	localObject2	Object
        //   538	13	1	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
        //   564	50	1	localObject3	Object
        //   617	1	1	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
        //   625	7	1	str1	String
        //   103	101	2	localObject4	Object
        //   208	13	2	localUnsupportedEncodingException3	java.io.UnsupportedEncodingException
        //   253	13	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
        //   323	257	2	localObject5	Object
        //   611	1	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
        //   619	1	2	localObject6	Object
        //   635	1	2	localOutOfMemoryError3	java.lang.OutOfMemoryError
        //   65	554	3	localObject7	Object
        //   73	319	4	localObject8	Object
        //   22	474	5	localObject9	Object
        //   56	405	6	str2	String
        //   287	233	7	locala	com.tencent.mm.plugin.webview.k.d.a
        // Exception table:
        //   from	to	target	type
        //   134	159	208	java/io/UnsupportedEncodingException
        //   191	203	208	java/io/UnsupportedEncodingException
        //   5	42	236	org/json/JSONException
        //   48	104	236	org/json/JSONException
        //   111	134	236	org/json/JSONException
        //   134	159	236	org/json/JSONException
        //   161	185	236	org/json/JSONException
        //   191	203	236	org/json/JSONException
        //   209	233	236	org/json/JSONException
        //   254	278	236	org/json/JSONException
        //   281	289	236	org/json/JSONException
        //   294	319	236	org/json/JSONException
        //   326	337	236	org/json/JSONException
        //   341	351	236	org/json/JSONException
        //   355	365	236	org/json/JSONException
        //   376	401	236	org/json/JSONException
        //   406	421	236	org/json/JSONException
        //   421	436	236	org/json/JSONException
        //   445	456	236	org/json/JSONException
        //   460	470	236	org/json/JSONException
        //   474	487	236	org/json/JSONException
        //   491	506	236	org/json/JSONException
        //   515	533	236	org/json/JSONException
        //   539	563	236	org/json/JSONException
        //   568	592	236	org/json/JSONException
        //   595	605	236	org/json/JSONException
        //   134	159	253	java/lang/OutOfMemoryError
        //   191	203	253	java/lang/OutOfMemoryError
        //   326	337	538	java/io/UnsupportedEncodingException
        //   341	351	538	java/io/UnsupportedEncodingException
        //   355	365	538	java/io/UnsupportedEncodingException
        //   406	421	538	java/io/UnsupportedEncodingException
        //   445	456	538	java/io/UnsupportedEncodingException
        //   460	470	538	java/io/UnsupportedEncodingException
        //   474	487	538	java/io/UnsupportedEncodingException
        //   491	506	538	java/io/UnsupportedEncodingException
        //   515	533	538	java/io/UnsupportedEncodingException
        //   421	436	611	java/lang/OutOfMemoryError
        //   421	436	617	java/io/UnsupportedEncodingException
        //   326	337	635	java/lang/OutOfMemoryError
        //   341	351	635	java/lang/OutOfMemoryError
        //   355	365	635	java/lang/OutOfMemoryError
        //   406	421	635	java/lang/OutOfMemoryError
        //   445	456	635	java/lang/OutOfMemoryError
        //   460	470	635	java/lang/OutOfMemoryError
        //   474	487	635	java/lang/OutOfMemoryError
        //   491	506	635	java/lang/OutOfMemoryError
        //   515	533	635	java/lang/OutOfMemoryError
      }
    });
    AppMethodBeat.o(296066);
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "require";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bd
 * JD-Core Version:    0.7.0.1
 */