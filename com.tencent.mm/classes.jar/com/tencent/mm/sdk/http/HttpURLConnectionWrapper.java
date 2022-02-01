package com.tencent.mm.sdk.http;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HttpURLConnectionWrapper
  extends HttpWrapperBase
{
  public static final String DEF_ATTACH_NAME = "default_attach_name";
  private static final String TAG = "MicroMsg.HttpURLConnectionWrapper";
  private HttpURLConnection conn = null;
  
  public HttpURLConnectionWrapper(HttpURLConnection paramHttpURLConnection)
  {
    this.conn = paramHttpURLConnection;
  }
  
  private void writePostStringContent(HttpWrapperBase.Request paramRequest, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(157519);
    if (paramRequest.params == null)
    {
      AppMethodBeat.o(157519);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramRequest.params.keySet().iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if (i != 0) {}
      for (String str1 = "";; str1 = "&")
      {
        localStringBuilder.append(str1).append(URLEncoder.encode(str2, "utf-8")).append('=').append(URLEncoder.encode((String)paramRequest.params.get(str2), "utf-8"));
        i = 0;
        break;
      }
    }
    paramOutputStream.write(localStringBuilder.toString().getBytes());
    AppMethodBeat.o(157519);
  }
  
  public void cancel()
  {
    AppMethodBeat.i(243173);
    Log.d("MicroMsg.HttpURLConnectionWrapper", "cancel conection.");
    if (this.conn != null) {
      this.conn.disconnect();
    }
    AppMethodBeat.o(243173);
  }
  
  /* Error */
  public void send(HttpWrapperBase.Request paramRequest, HttpWrapperBase.Response paramResponse)
  {
    // Byte code:
    //   0: ldc 125
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 11
    //   7: ldc 127
    //   9: iconst_1
    //   10: anewarray 129	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload_1
    //   16: aastore
    //   17: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: aload_0
    //   21: getfield 20	com/tencent/mm/sdk/http/HttpURLConnectionWrapper:conn	Ljava/net/HttpURLConnection;
    //   24: aload_1
    //   25: getfield 136	com/tencent/mm/sdk/http/HttpWrapperBase$Request:timeout	I
    //   28: invokevirtual 139	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   31: aload_0
    //   32: getfield 20	com/tencent/mm/sdk/http/HttpURLConnectionWrapper:conn	Ljava/net/HttpURLConnection;
    //   35: astore 6
    //   37: aload_1
    //   38: getfield 142	com/tencent/mm/sdk/http/HttpWrapperBase$Request:method	I
    //   41: ifne +453 -> 494
    //   44: ldc 144
    //   46: astore 5
    //   48: aload 6
    //   50: aload 5
    //   52: invokevirtual 148	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   55: aload_1
    //   56: getfield 142	com/tencent/mm/sdk/http/HttpWrapperBase$Request:method	I
    //   59: iconst_1
    //   60: if_icmpne +19 -> 79
    //   63: aload_0
    //   64: getfield 20	com/tencent/mm/sdk/http/HttpURLConnectionWrapper:conn	Ljava/net/HttpURLConnection;
    //   67: iconst_1
    //   68: invokevirtual 152	java/net/HttpURLConnection:setDoInput	(Z)V
    //   71: aload_0
    //   72: getfield 20	com/tencent/mm/sdk/http/HttpURLConnectionWrapper:conn	Ljava/net/HttpURLConnection;
    //   75: iconst_1
    //   76: invokevirtual 155	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   79: aload_0
    //   80: getfield 20	com/tencent/mm/sdk/http/HttpURLConnectionWrapper:conn	Ljava/net/HttpURLConnection;
    //   83: iconst_0
    //   84: invokevirtual 158	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   87: aload_0
    //   88: getfield 20	com/tencent/mm/sdk/http/HttpURLConnectionWrapper:conn	Ljava/net/HttpURLConnection;
    //   91: ldc 160
    //   93: ldc 162
    //   95: invokevirtual 165	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload_0
    //   99: getfield 20	com/tencent/mm/sdk/http/HttpURLConnectionWrapper:conn	Ljava/net/HttpURLConnection;
    //   102: ldc 167
    //   104: aload_1
    //   105: getfield 170	com/tencent/mm/sdk/http/HttpWrapperBase$Request:host	Ljava/lang/String;
    //   108: invokevirtual 165	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: ldc 172
    //   113: ldc 174
    //   115: invokestatic 179	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   118: pop
    //   119: aload_0
    //   120: getfield 20	com/tencent/mm/sdk/http/HttpURLConnectionWrapper:conn	Ljava/net/HttpURLConnection;
    //   123: ldc 181
    //   125: ldc 74
    //   127: invokevirtual 165	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload_0
    //   131: getfield 20	com/tencent/mm/sdk/http/HttpURLConnectionWrapper:conn	Ljava/net/HttpURLConnection;
    //   134: ldc 183
    //   136: ldc 185
    //   138: invokevirtual 165	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload_0
    //   142: getfield 20	com/tencent/mm/sdk/http/HttpURLConnectionWrapper:conn	Ljava/net/HttpURLConnection;
    //   145: ldc 187
    //   147: aload_1
    //   148: getfield 190	com/tencent/mm/sdk/http/HttpWrapperBase$Request:cookie	Ljava/util/Map;
    //   151: invokestatic 194	com/tencent/mm/sdk/http/HttpURLConnectionWrapper:getCookie	(Ljava/util/Map;)Ljava/lang/String;
    //   154: invokevirtual 165	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: aload_0
    //   158: getfield 20	com/tencent/mm/sdk/http/HttpURLConnectionWrapper:conn	Ljava/net/HttpURLConnection;
    //   161: invokevirtual 197	java/net/HttpURLConnection:connect	()V
    //   164: aload_1
    //   165: getfield 142	com/tencent/mm/sdk/http/HttpWrapperBase$Request:method	I
    //   168: iconst_1
    //   169: if_icmpne +856 -> 1025
    //   172: aload_0
    //   173: getfield 20	com/tencent/mm/sdk/http/HttpURLConnectionWrapper:conn	Ljava/net/HttpURLConnection;
    //   176: invokevirtual 201	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   179: astore 5
    //   181: aload_0
    //   182: aload_1
    //   183: aload 5
    //   185: invokespecial 203	com/tencent/mm/sdk/http/HttpURLConnectionWrapper:writePostStringContent	(Lcom/tencent/mm/sdk/http/HttpWrapperBase$Request;Ljava/io/OutputStream;)V
    //   188: aload 5
    //   190: invokevirtual 206	java/io/OutputStream:flush	()V
    //   193: aload 5
    //   195: astore 6
    //   197: aload_0
    //   198: getfield 20	com/tencent/mm/sdk/http/HttpURLConnectionWrapper:conn	Ljava/net/HttpURLConnection;
    //   201: invokevirtual 210	java/net/HttpURLConnection:getResponseCode	()I
    //   204: istore_3
    //   205: aload_0
    //   206: getfield 20	com/tencent/mm/sdk/http/HttpURLConnectionWrapper:conn	Ljava/net/HttpURLConnection;
    //   209: ldc 212
    //   211: invokevirtual 216	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   214: astore 8
    //   216: aload_0
    //   217: getfield 20	com/tencent/mm/sdk/http/HttpURLConnectionWrapper:conn	Ljava/net/HttpURLConnection;
    //   220: ldc 218
    //   222: invokevirtual 216	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   225: astore 5
    //   227: aload_0
    //   228: getfield 20	com/tencent/mm/sdk/http/HttpURLConnectionWrapper:conn	Ljava/net/HttpURLConnection;
    //   231: ldc 220
    //   233: invokevirtual 216	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   236: pop
    //   237: aload_0
    //   238: getfield 20	com/tencent/mm/sdk/http/HttpURLConnectionWrapper:conn	Ljava/net/HttpURLConnection;
    //   241: invokevirtual 224	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   244: astore_1
    //   245: aload 5
    //   247: ifnull +775 -> 1022
    //   250: aload 5
    //   252: ldc 226
    //   254: invokevirtual 230	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   257: ifeq +765 -> 1022
    //   260: new 232	java/util/zip/GZIPInputStream
    //   263: dup
    //   264: aload_1
    //   265: invokespecial 235	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   268: astore 5
    //   270: aload 5
    //   272: astore_1
    //   273: aload_2
    //   274: getfield 241	com/tencent/mm/sdk/http/HttpWrapperBase$Response:attachment	Lcom/tencent/mm/sdk/http/HttpWrapperBase$Attachment;
    //   277: ifnull +225 -> 502
    //   280: aload_2
    //   281: getfield 241	com/tencent/mm/sdk/http/HttpWrapperBase$Response:attachment	Lcom/tencent/mm/sdk/http/HttpWrapperBase$Attachment;
    //   284: getfield 246	com/tencent/mm/sdk/http/HttpWrapperBase$Attachment:filePath	Ljava/lang/String;
    //   287: invokestatic 252	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   290: ifeq +212 -> 502
    //   293: new 254	com/tencent/mm/vfs/u
    //   296: dup
    //   297: aload_2
    //   298: getfield 241	com/tencent/mm/sdk/http/HttpWrapperBase$Response:attachment	Lcom/tencent/mm/sdk/http/HttpWrapperBase$Attachment;
    //   301: getfield 246	com/tencent/mm/sdk/http/HttpWrapperBase$Attachment:filePath	Ljava/lang/String;
    //   304: invokespecial 256	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   307: iconst_1
    //   308: invokestatic 262	com/tencent/mm/vfs/y:e	(Lcom/tencent/mm/vfs/u;Z)Ljava/io/OutputStream;
    //   311: astore 5
    //   313: aload 5
    //   315: astore 7
    //   317: sipush 1024
    //   320: newarray byte
    //   322: astore 9
    //   324: aload 5
    //   326: astore 7
    //   328: aload_1
    //   329: aload 9
    //   331: invokevirtual 268	java/io/InputStream:read	([B)I
    //   334: istore 4
    //   336: iload 4
    //   338: ifle +184 -> 522
    //   341: aload 5
    //   343: astore 7
    //   345: aload 5
    //   347: aload 9
    //   349: iconst_0
    //   350: iload 4
    //   352: invokevirtual 271	java/io/OutputStream:write	([BII)V
    //   355: aload 5
    //   357: astore 7
    //   359: aload 5
    //   361: invokevirtual 206	java/io/OutputStream:flush	()V
    //   364: goto -40 -> 324
    //   367: astore 8
    //   369: aload 5
    //   371: astore 7
    //   373: ldc 11
    //   375: aload 8
    //   377: ldc 68
    //   379: iconst_0
    //   380: anewarray 129	java/lang/Object
    //   383: invokestatic 275	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   386: iload_3
    //   387: ifne +319 -> 706
    //   390: sipush 503
    //   393: istore 4
    //   395: aload 5
    //   397: astore 7
    //   399: aload_2
    //   400: iload 4
    //   402: putfield 278	com/tencent/mm/sdk/http/HttpWrapperBase$Response:status	I
    //   405: aload 5
    //   407: ifnull +27 -> 434
    //   410: aload_1
    //   411: astore 7
    //   413: aload 6
    //   415: astore 8
    //   417: aload 5
    //   419: invokevirtual 206	java/io/OutputStream:flush	()V
    //   422: aload_1
    //   423: astore 7
    //   425: aload 6
    //   427: astore 8
    //   429: aload 5
    //   431: invokevirtual 281	java/io/OutputStream:close	()V
    //   434: aload_1
    //   435: astore 7
    //   437: aload 6
    //   439: astore 8
    //   441: ldc 11
    //   443: ldc_w 283
    //   446: aload_2
    //   447: invokestatic 287	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   450: invokevirtual 290	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   453: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   456: aload 6
    //   458: ifnull +8 -> 466
    //   461: aload 6
    //   463: invokevirtual 281	java/io/OutputStream:close	()V
    //   466: aload_1
    //   467: ifnull +7 -> 474
    //   470: aload_1
    //   471: invokevirtual 291	java/io/InputStream:close	()V
    //   474: aload_0
    //   475: getfield 20	com/tencent/mm/sdk/http/HttpURLConnectionWrapper:conn	Ljava/net/HttpURLConnection;
    //   478: ifnull +444 -> 922
    //   481: aload_0
    //   482: getfield 20	com/tencent/mm/sdk/http/HttpURLConnectionWrapper:conn	Ljava/net/HttpURLConnection;
    //   485: invokevirtual 118	java/net/HttpURLConnection:disconnect	()V
    //   488: ldc 125
    //   490: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   493: return
    //   494: ldc_w 293
    //   497: astore 5
    //   499: goto -451 -> 48
    //   502: new 295	java/io/ByteArrayOutputStream
    //   505: dup
    //   506: invokespecial 296	java/io/ByteArrayOutputStream:<init>	()V
    //   509: astore 5
    //   511: goto -198 -> 313
    //   514: astore 8
    //   516: aconst_null
    //   517: astore 5
    //   519: goto -150 -> 369
    //   522: aload 5
    //   524: astore 7
    //   526: aload_2
    //   527: iload_3
    //   528: putfield 278	com/tencent/mm/sdk/http/HttpWrapperBase$Response:status	I
    //   531: aload 5
    //   533: astore 7
    //   535: aload_2
    //   536: aload 8
    //   538: invokestatic 300	com/tencent/mm/sdk/http/HttpURLConnectionWrapper:parseCookie	(Ljava/lang/String;)Ljava/util/Map;
    //   541: putfield 301	com/tencent/mm/sdk/http/HttpWrapperBase$Response:cookie	Ljava/util/Map;
    //   544: aload 5
    //   546: astore 7
    //   548: aload 5
    //   550: instanceof 295
    //   553: ifeq +146 -> 699
    //   556: aload 5
    //   558: astore 7
    //   560: new 66	java/lang/String
    //   563: dup
    //   564: aload 5
    //   566: checkcast 295	java/io/ByteArrayOutputStream
    //   569: invokevirtual 304	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   572: invokespecial 306	java/lang/String:<init>	([B)V
    //   575: astore 8
    //   577: aload 5
    //   579: astore 7
    //   581: aload_2
    //   582: aload 8
    //   584: putfield 309	com/tencent/mm/sdk/http/HttpWrapperBase$Response:content	Ljava/lang/String;
    //   587: aload 5
    //   589: ifnull -155 -> 434
    //   592: aload_1
    //   593: astore 7
    //   595: aload 6
    //   597: astore 8
    //   599: aload 5
    //   601: invokevirtual 206	java/io/OutputStream:flush	()V
    //   604: aload_1
    //   605: astore 7
    //   607: aload 6
    //   609: astore 8
    //   611: aload 5
    //   613: invokevirtual 281	java/io/OutputStream:close	()V
    //   616: goto -182 -> 434
    //   619: astore 5
    //   621: aload_1
    //   622: astore 7
    //   624: aload 6
    //   626: astore 8
    //   628: ldc 11
    //   630: aload 5
    //   632: ldc 68
    //   634: iconst_0
    //   635: anewarray 129	java/lang/Object
    //   638: invokestatic 275	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   641: iload_3
    //   642: ifne +207 -> 849
    //   645: sipush 503
    //   648: istore_3
    //   649: aload_1
    //   650: astore 7
    //   652: aload 6
    //   654: astore 8
    //   656: aload_2
    //   657: iload_3
    //   658: putfield 278	com/tencent/mm/sdk/http/HttpWrapperBase$Response:status	I
    //   661: aload 6
    //   663: ifnull +8 -> 671
    //   666: aload 6
    //   668: invokevirtual 281	java/io/OutputStream:close	()V
    //   671: aload_1
    //   672: ifnull +7 -> 679
    //   675: aload_1
    //   676: invokevirtual 291	java/io/InputStream:close	()V
    //   679: aload_0
    //   680: getfield 20	com/tencent/mm/sdk/http/HttpURLConnectionWrapper:conn	Ljava/net/HttpURLConnection;
    //   683: ifnull +239 -> 922
    //   686: aload_0
    //   687: getfield 20	com/tencent/mm/sdk/http/HttpURLConnectionWrapper:conn	Ljava/net/HttpURLConnection;
    //   690: invokevirtual 118	java/net/HttpURLConnection:disconnect	()V
    //   693: ldc 125
    //   695: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   698: return
    //   699: ldc 68
    //   701: astore 8
    //   703: goto -126 -> 577
    //   706: sipush 500
    //   709: istore 4
    //   711: goto -316 -> 395
    //   714: astore 5
    //   716: aconst_null
    //   717: astore 9
    //   719: aload 9
    //   721: ifnull +27 -> 748
    //   724: aload_1
    //   725: astore 7
    //   727: aload 6
    //   729: astore 8
    //   731: aload 9
    //   733: invokevirtual 206	java/io/OutputStream:flush	()V
    //   736: aload_1
    //   737: astore 7
    //   739: aload 6
    //   741: astore 8
    //   743: aload 9
    //   745: invokevirtual 281	java/io/OutputStream:close	()V
    //   748: aload_1
    //   749: astore 7
    //   751: aload 6
    //   753: astore 8
    //   755: ldc 125
    //   757: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   760: aload_1
    //   761: astore 7
    //   763: aload 6
    //   765: astore 8
    //   767: aload 5
    //   769: athrow
    //   770: astore_1
    //   771: aload 8
    //   773: astore 6
    //   775: aload 7
    //   777: astore_2
    //   778: aload 6
    //   780: ifnull +8 -> 788
    //   783: aload 6
    //   785: invokevirtual 281	java/io/OutputStream:close	()V
    //   788: aload_2
    //   789: ifnull +7 -> 796
    //   792: aload_2
    //   793: invokevirtual 291	java/io/InputStream:close	()V
    //   796: aload_0
    //   797: getfield 20	com/tencent/mm/sdk/http/HttpURLConnectionWrapper:conn	Ljava/net/HttpURLConnection;
    //   800: ifnull +10 -> 810
    //   803: aload_0
    //   804: getfield 20	com/tencent/mm/sdk/http/HttpURLConnectionWrapper:conn	Ljava/net/HttpURLConnection;
    //   807: invokevirtual 118	java/net/HttpURLConnection:disconnect	()V
    //   810: ldc 125
    //   812: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   815: aload_1
    //   816: athrow
    //   817: astore_2
    //   818: ldc 11
    //   820: aload_2
    //   821: ldc 68
    //   823: iconst_0
    //   824: anewarray 129	java/lang/Object
    //   827: invokestatic 275	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   830: goto -364 -> 466
    //   833: astore_1
    //   834: ldc 11
    //   836: aload_1
    //   837: ldc 68
    //   839: iconst_0
    //   840: anewarray 129	java/lang/Object
    //   843: invokestatic 275	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   846: goto -372 -> 474
    //   849: sipush 500
    //   852: istore_3
    //   853: goto -204 -> 649
    //   856: astore_2
    //   857: ldc 11
    //   859: aload_2
    //   860: ldc 68
    //   862: iconst_0
    //   863: anewarray 129	java/lang/Object
    //   866: invokestatic 275	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   869: goto -198 -> 671
    //   872: astore_1
    //   873: ldc 11
    //   875: aload_1
    //   876: ldc 68
    //   878: iconst_0
    //   879: anewarray 129	java/lang/Object
    //   882: invokestatic 275	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   885: goto -206 -> 679
    //   888: astore 5
    //   890: ldc 11
    //   892: aload 5
    //   894: ldc 68
    //   896: iconst_0
    //   897: anewarray 129	java/lang/Object
    //   900: invokestatic 275	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   903: goto -115 -> 788
    //   906: astore_2
    //   907: ldc 11
    //   909: aload_2
    //   910: ldc 68
    //   912: iconst_0
    //   913: anewarray 129	java/lang/Object
    //   916: invokestatic 275	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   919: goto -123 -> 796
    //   922: ldc 125
    //   924: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   927: return
    //   928: astore_1
    //   929: aconst_null
    //   930: astore_2
    //   931: aconst_null
    //   932: astore 6
    //   934: goto -156 -> 778
    //   937: astore_1
    //   938: aconst_null
    //   939: astore_2
    //   940: aload 5
    //   942: astore 6
    //   944: goto -166 -> 778
    //   947: astore_1
    //   948: aconst_null
    //   949: astore_2
    //   950: goto -172 -> 778
    //   953: astore 5
    //   955: aload_1
    //   956: astore_2
    //   957: aload 5
    //   959: astore_1
    //   960: goto -182 -> 778
    //   963: astore 5
    //   965: iconst_0
    //   966: istore_3
    //   967: aconst_null
    //   968: astore_1
    //   969: aconst_null
    //   970: astore 6
    //   972: goto -351 -> 621
    //   975: astore 7
    //   977: iconst_0
    //   978: istore_3
    //   979: aconst_null
    //   980: astore_1
    //   981: aload 5
    //   983: astore 6
    //   985: aload 7
    //   987: astore 5
    //   989: goto -368 -> 621
    //   992: astore 5
    //   994: iconst_0
    //   995: istore_3
    //   996: aconst_null
    //   997: astore_1
    //   998: goto -377 -> 621
    //   1001: astore 5
    //   1003: aconst_null
    //   1004: astore_1
    //   1005: goto -384 -> 621
    //   1008: astore 5
    //   1010: goto -389 -> 621
    //   1013: astore 5
    //   1015: aload 7
    //   1017: astore 9
    //   1019: goto -300 -> 719
    //   1022: goto -749 -> 273
    //   1025: aconst_null
    //   1026: astore 6
    //   1028: goto -831 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1031	0	this	HttpURLConnectionWrapper
    //   0	1031	1	paramRequest	HttpWrapperBase.Request
    //   0	1031	2	paramResponse	HttpWrapperBase.Response
    //   204	792	3	i	int
    //   334	376	4	j	int
    //   46	566	5	localObject1	java.lang.Object
    //   619	12	5	localException1	java.lang.Exception
    //   714	54	5	localObject2	java.lang.Object
    //   888	53	5	localIOException	java.io.IOException
    //   953	5	5	localObject3	java.lang.Object
    //   963	19	5	localException2	java.lang.Exception
    //   987	1	5	localObject4	java.lang.Object
    //   992	1	5	localException3	java.lang.Exception
    //   1001	1	5	localException4	java.lang.Exception
    //   1008	1	5	localException5	java.lang.Exception
    //   1013	1	5	localObject5	java.lang.Object
    //   35	992	6	localObject6	java.lang.Object
    //   315	461	7	localObject7	java.lang.Object
    //   975	41	7	localException6	java.lang.Exception
    //   214	1	8	str	String
    //   367	9	8	localException7	java.lang.Exception
    //   415	25	8	localObject8	java.lang.Object
    //   514	23	8	localException8	java.lang.Exception
    //   575	197	8	localObject9	java.lang.Object
    //   322	696	9	localObject10	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   317	324	367	java/lang/Exception
    //   328	336	367	java/lang/Exception
    //   345	355	367	java/lang/Exception
    //   359	364	367	java/lang/Exception
    //   526	531	367	java/lang/Exception
    //   535	544	367	java/lang/Exception
    //   548	556	367	java/lang/Exception
    //   560	577	367	java/lang/Exception
    //   581	587	367	java/lang/Exception
    //   273	313	514	java/lang/Exception
    //   502	511	514	java/lang/Exception
    //   417	422	619	java/lang/Exception
    //   429	434	619	java/lang/Exception
    //   441	456	619	java/lang/Exception
    //   599	604	619	java/lang/Exception
    //   611	616	619	java/lang/Exception
    //   731	736	619	java/lang/Exception
    //   743	748	619	java/lang/Exception
    //   755	760	619	java/lang/Exception
    //   767	770	619	java/lang/Exception
    //   273	313	714	finally
    //   502	511	714	finally
    //   417	422	770	finally
    //   429	434	770	finally
    //   441	456	770	finally
    //   599	604	770	finally
    //   611	616	770	finally
    //   628	641	770	finally
    //   656	661	770	finally
    //   731	736	770	finally
    //   743	748	770	finally
    //   755	760	770	finally
    //   767	770	770	finally
    //   461	466	817	java/io/IOException
    //   470	474	833	java/io/IOException
    //   666	671	856	java/io/IOException
    //   675	679	872	java/io/IOException
    //   783	788	888	java/io/IOException
    //   792	796	906	java/io/IOException
    //   20	44	928	finally
    //   48	79	928	finally
    //   79	181	928	finally
    //   181	193	937	finally
    //   197	205	947	finally
    //   205	245	947	finally
    //   250	270	953	finally
    //   20	44	963	java/lang/Exception
    //   48	79	963	java/lang/Exception
    //   79	181	963	java/lang/Exception
    //   181	193	975	java/lang/Exception
    //   197	205	992	java/lang/Exception
    //   205	245	1001	java/lang/Exception
    //   250	270	1008	java/lang/Exception
    //   317	324	1013	finally
    //   328	336	1013	finally
    //   345	355	1013	finally
    //   359	364	1013	finally
    //   373	386	1013	finally
    //   399	405	1013	finally
    //   526	531	1013	finally
    //   535	544	1013	finally
    //   548	556	1013	finally
    //   560	577	1013	finally
    //   581	587	1013	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.http.HttpURLConnectionWrapper
 * JD-Core Version:    0.7.0.1
 */