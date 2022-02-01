package com.tencent.tmassistantsdk.network;

import com.qq.taf.jce.JceStruct;
import com.tencent.e.h;
import com.tencent.e.i;
import org.apache.http.client.methods.HttpPost;

public abstract class PostHttpRequest
{
  static final String REQUEST_SERVER_URL = "http://masdk.3g.qq.com/";
  static final String TAG = "BaseHttpRequest";
  HttpPost mHttpPost = null;
  
  /* Error */
  public void cancleRequest()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 21	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
    //   6: ifnull +51 -> 57
    //   9: aload_0
    //   10: getfield 21	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
    //   13: invokevirtual 31	org/apache/http/client/methods/HttpPost:isAborted	()Z
    //   16: ifne +41 -> 57
    //   19: ldc 13
    //   21: new 33	java/lang/StringBuilder
    //   24: dup
    //   25: ldc 35
    //   27: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   30: aload_0
    //   31: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   34: ldc 44
    //   36: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 57	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_0
    //   46: getfield 21	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
    //   49: invokevirtual 60	org/apache/http/client/methods/HttpPost:abort	()V
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 21	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: astore_1
    //   61: ldc 13
    //   63: aload_1
    //   64: ldc 62
    //   66: iconst_0
    //   67: anewarray 4	java/lang/Object
    //   70: invokestatic 68	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   73: aload_0
    //   74: aconst_null
    //   75: putfield 21	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
    //   78: goto -21 -> 57
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    //   86: astore_1
    //   87: aload_0
    //   88: aconst_null
    //   89: putfield 21	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	PostHttpRequest
    //   60	4	1	localException	java.lang.Exception
    //   81	4	1	localObject1	Object
    //   86	7	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   45	52	60	java/lang/Exception
    //   2	45	81	finally
    //   52	57	81	finally
    //   73	78	81	finally
    //   87	94	81	finally
    //   45	52	86	finally
    //   61	73	86	finally
  }
  
  protected abstract void onFinished(JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt);
  
  protected boolean sendRequest(final JceStruct paramJceStruct)
  {
    if (paramJceStruct == null) {}
    for (;;)
    {
      return false;
      try
      {
        if (this.mHttpPost != null) {
          continue;
        }
        h.MqF.aR(new Runnable()
        {
          /* Error */
          public void run()
          {
            // Byte code:
            //   0: ldc 35
            //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
            //   5: aload_0
            //   6: getfield 21	com/tencent/tmassistantsdk/network/PostHttpRequest$1:val$sendRequest	Lcom/qq/taf/jce/JceStruct;
            //   9: invokestatic 47	com/tencent/tmassistantsdk/protocol/ProtocolPackage:buildRequest	(Lcom/qq/taf/jce/JceStruct;)Lcom/tencent/tmassistantsdk/protocol/jce/Request;
            //   12: astore 5
            //   14: aload 5
            //   16: invokestatic 51	com/tencent/tmassistantsdk/protocol/ProtocolPackage:buildPostData	(Lcom/tencent/tmassistantsdk/protocol/jce/Request;)[B
            //   19: astore_2
            //   20: aload_0
            //   21: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   24: new 53	org/apache/http/client/methods/HttpPost
            //   27: dup
            //   28: ldc 55
            //   30: invokespecial 58	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
            //   33: putfield 62	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
            //   36: aload_0
            //   37: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   40: getfield 62	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
            //   43: ldc 64
            //   45: ldc 66
            //   47: invokevirtual 70	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
            //   50: aload_0
            //   51: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   54: getfield 62	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
            //   57: new 72	org/apache/http/entity/ByteArrayEntity
            //   60: dup
            //   61: aload_2
            //   62: invokespecial 75	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
            //   65: invokevirtual 79	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
            //   68: invokestatic 85	com/tencent/tmassistantsdk/downloadservice/HttpClientUtil:createHttpClient	()Lorg/apache/http/client/HttpClient;
            //   71: astore_3
            //   72: aload_3
            //   73: astore_2
            //   74: aload_3
            //   75: invokestatic 89	com/tencent/tmassistantsdk/downloadservice/HttpClientUtil:setProxy	(Lorg/apache/http/client/HttpClient;)V
            //   78: aload_3
            //   79: astore_2
            //   80: aload_3
            //   81: aload_0
            //   82: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   85: getfield 62	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
            //   88: invokeinterface 95 2 0
            //   93: astore 4
            //   95: aload 4
            //   97: ifnull +288 -> 385
            //   100: aload_3
            //   101: astore_2
            //   102: aload 4
            //   104: invokeinterface 101 1 0
            //   109: invokeinterface 107 1 0
            //   114: sipush 200
            //   117: if_icmpne +268 -> 385
            //   120: aload_3
            //   121: astore_2
            //   122: aload 4
            //   124: invokeinterface 111 1 0
            //   129: astore 6
            //   131: aload 6
            //   133: ifnull +252 -> 385
            //   136: aload_3
            //   137: astore_2
            //   138: new 113	org/apache/http/util/ByteArrayBuffer
            //   141: dup
            //   142: aload 6
            //   144: invokeinterface 119 1 0
            //   149: l2i
            //   150: invokespecial 121	org/apache/http/util/ByteArrayBuffer:<init>	(I)V
            //   153: astore 4
            //   155: aload_3
            //   156: astore_2
            //   157: aload 6
            //   159: invokeinterface 125 1 0
            //   164: astore 6
            //   166: aload_3
            //   167: astore_2
            //   168: sipush 2048
            //   171: newarray byte
            //   173: astore 7
            //   175: aload_3
            //   176: astore_2
            //   177: aload 6
            //   179: aload 7
            //   181: invokevirtual 131	java/io/InputStream:read	([B)I
            //   184: istore_1
            //   185: iload_1
            //   186: iconst_m1
            //   187: if_icmpeq +78 -> 265
            //   190: aload_3
            //   191: astore_2
            //   192: aload 4
            //   194: aload 7
            //   196: iconst_0
            //   197: iload_1
            //   198: invokevirtual 135	org/apache/http/util/ByteArrayBuffer:append	([BII)V
            //   201: goto -26 -> 175
            //   204: astore 4
            //   206: aload_3
            //   207: astore_2
            //   208: ldc 137
            //   210: aload 4
            //   212: ldc 139
            //   214: iconst_0
            //   215: anewarray 4	java/lang/Object
            //   218: invokestatic 145	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
            //   221: aload_3
            //   222: astore_2
            //   223: aload_0
            //   224: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   227: aload 5
            //   229: aconst_null
            //   230: sipush 601
            //   233: invokevirtual 149	com/tencent/tmassistantsdk/network/PostHttpRequest:onFinished	(Lcom/qq/taf/jce/JceStruct;Lcom/qq/taf/jce/JceStruct;I)V
            //   236: aload_0
            //   237: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   240: aconst_null
            //   241: putfield 62	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
            //   244: aload_3
            //   245: ifnull +391 -> 636
            //   248: aload_3
            //   249: invokeinterface 153 1 0
            //   254: invokeinterface 158 1 0
            //   259: ldc 35
            //   261: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   264: return
            //   265: aload_3
            //   266: astore_2
            //   267: aload 4
            //   269: invokevirtual 165	org/apache/http/util/ByteArrayBuffer:buffer	()[B
            //   272: astore 4
            //   274: aload 4
            //   276: ifnull +109 -> 385
            //   279: aload_3
            //   280: astore_2
            //   281: aload 4
            //   283: arraylength
            //   284: iconst_4
            //   285: if_icmple +100 -> 385
            //   288: aload_3
            //   289: astore_2
            //   290: aload 4
            //   292: invokestatic 169	com/tencent/tmassistantsdk/protocol/ProtocolPackage:unpackPackage	([B)Lcom/tencent/tmassistantsdk/protocol/jce/Response;
            //   295: astore 4
            //   297: aload 4
            //   299: ifnull +86 -> 385
            //   302: aload_3
            //   303: astore_2
            //   304: aload 4
            //   306: getfield 175	com/tencent/tmassistantsdk/protocol/jce/Response:body	[B
            //   309: ifnull +76 -> 385
            //   312: aload_3
            //   313: astore_2
            //   314: aload_0
            //   315: getfield 21	com/tencent/tmassistantsdk/network/PostHttpRequest$1:val$sendRequest	Lcom/qq/taf/jce/JceStruct;
            //   318: aload 4
            //   320: getfield 175	com/tencent/tmassistantsdk/protocol/jce/Response:body	[B
            //   323: invokestatic 179	com/tencent/tmassistantsdk/protocol/ProtocolPackage:unpageageJceResponse	(Lcom/qq/taf/jce/JceStruct;[B)Lcom/qq/taf/jce/JceStruct;
            //   326: astore 6
            //   328: aload 6
            //   330: ifnull +55 -> 385
            //   333: aload_3
            //   334: astore_2
            //   335: aload_0
            //   336: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   339: aload_0
            //   340: getfield 21	com/tencent/tmassistantsdk/network/PostHttpRequest$1:val$sendRequest	Lcom/qq/taf/jce/JceStruct;
            //   343: aload 6
            //   345: aload 4
            //   347: getfield 183	com/tencent/tmassistantsdk/protocol/jce/Response:head	Lcom/tencent/tmassistantsdk/protocol/jce/RspHead;
            //   350: getfield 189	com/tencent/tmassistantsdk/protocol/jce/RspHead:ret	I
            //   353: invokevirtual 149	com/tencent/tmassistantsdk/network/PostHttpRequest:onFinished	(Lcom/qq/taf/jce/JceStruct;Lcom/qq/taf/jce/JceStruct;I)V
            //   356: aload_0
            //   357: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   360: aconst_null
            //   361: putfield 62	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
            //   364: aload_3
            //   365: ifnull +14 -> 379
            //   368: aload_3
            //   369: invokeinterface 153 1 0
            //   374: invokeinterface 158 1 0
            //   379: ldc 35
            //   381: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   384: return
            //   385: aload_0
            //   386: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   389: aconst_null
            //   390: putfield 62	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
            //   393: aload_3
            //   394: ifnull +242 -> 636
            //   397: aload_3
            //   398: invokeinterface 153 1 0
            //   403: invokeinterface 158 1 0
            //   408: ldc 35
            //   410: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   413: return
            //   414: astore 4
            //   416: aconst_null
            //   417: astore_3
            //   418: aload_3
            //   419: astore_2
            //   420: ldc 137
            //   422: aload 4
            //   424: ldc 139
            //   426: iconst_0
            //   427: anewarray 4	java/lang/Object
            //   430: invokestatic 145	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
            //   433: aload_3
            //   434: astore_2
            //   435: aload_0
            //   436: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   439: aload 5
            //   441: aconst_null
            //   442: iconst_1
            //   443: invokevirtual 149	com/tencent/tmassistantsdk/network/PostHttpRequest:onFinished	(Lcom/qq/taf/jce/JceStruct;Lcom/qq/taf/jce/JceStruct;I)V
            //   446: aload_0
            //   447: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   450: aconst_null
            //   451: putfield 62	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
            //   454: aload_3
            //   455: ifnull +181 -> 636
            //   458: aload_3
            //   459: invokeinterface 153 1 0
            //   464: invokeinterface 158 1 0
            //   469: ldc 35
            //   471: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   474: return
            //   475: astore 4
            //   477: aconst_null
            //   478: astore_3
            //   479: aload_3
            //   480: astore_2
            //   481: ldc 137
            //   483: aload 4
            //   485: ldc 139
            //   487: iconst_0
            //   488: anewarray 4	java/lang/Object
            //   491: invokestatic 145	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
            //   494: aload_3
            //   495: astore_2
            //   496: aload_0
            //   497: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   500: aload 5
            //   502: aconst_null
            //   503: sipush 602
            //   506: invokevirtual 149	com/tencent/tmassistantsdk/network/PostHttpRequest:onFinished	(Lcom/qq/taf/jce/JceStruct;Lcom/qq/taf/jce/JceStruct;I)V
            //   509: aload_0
            //   510: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   513: aconst_null
            //   514: putfield 62	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
            //   517: aload_3
            //   518: ifnull +118 -> 636
            //   521: aload_3
            //   522: invokeinterface 153 1 0
            //   527: invokeinterface 158 1 0
            //   532: ldc 35
            //   534: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   537: return
            //   538: astore 4
            //   540: aconst_null
            //   541: astore_3
            //   542: aload_3
            //   543: astore_2
            //   544: ldc 137
            //   546: aload 4
            //   548: ldc 139
            //   550: iconst_0
            //   551: anewarray 4	java/lang/Object
            //   554: invokestatic 145	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
            //   557: aload_3
            //   558: astore_2
            //   559: aload_0
            //   560: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   563: aload_0
            //   564: getfield 21	com/tencent/tmassistantsdk/network/PostHttpRequest$1:val$sendRequest	Lcom/qq/taf/jce/JceStruct;
            //   567: aconst_null
            //   568: sipush 604
            //   571: invokevirtual 149	com/tencent/tmassistantsdk/network/PostHttpRequest:onFinished	(Lcom/qq/taf/jce/JceStruct;Lcom/qq/taf/jce/JceStruct;I)V
            //   574: aload_0
            //   575: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   578: aconst_null
            //   579: putfield 62	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
            //   582: aload_3
            //   583: ifnull +53 -> 636
            //   586: aload_3
            //   587: invokeinterface 153 1 0
            //   592: invokeinterface 158 1 0
            //   597: ldc 35
            //   599: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   602: return
            //   603: astore_3
            //   604: aconst_null
            //   605: astore_2
            //   606: aload_0
            //   607: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   610: aconst_null
            //   611: putfield 62	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
            //   614: aload_2
            //   615: ifnull +14 -> 629
            //   618: aload_2
            //   619: invokeinterface 153 1 0
            //   624: invokeinterface 158 1 0
            //   629: ldc 35
            //   631: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   634: aload_3
            //   635: athrow
            //   636: ldc 35
            //   638: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   641: return
            //   642: astore_3
            //   643: goto -37 -> 606
            //   646: astore 4
            //   648: goto -106 -> 542
            //   651: astore 4
            //   653: goto -174 -> 479
            //   656: astore 4
            //   658: goto -240 -> 418
            //   661: astore 4
            //   663: aconst_null
            //   664: astore_3
            //   665: goto -459 -> 206
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	668	0	this	1
            //   184	14	1	i	int
            //   19	600	2	localObject1	Object
            //   71	516	3	localHttpClient	org.apache.http.client.HttpClient
            //   603	32	3	localObject2	Object
            //   642	1	3	localObject3	Object
            //   664	1	3	localObject4	Object
            //   93	100	4	localObject5	Object
            //   204	64	4	localConnectTimeoutException1	org.apache.http.conn.ConnectTimeoutException
            //   272	74	4	localObject6	Object
            //   414	9	4	localConnectException1	java.net.ConnectException
            //   475	9	4	localSocketTimeoutException1	java.net.SocketTimeoutException
            //   538	9	4	localException1	java.lang.Exception
            //   646	1	4	localException2	java.lang.Exception
            //   651	1	4	localSocketTimeoutException2	java.net.SocketTimeoutException
            //   656	1	4	localConnectException2	java.net.ConnectException
            //   661	1	4	localConnectTimeoutException2	org.apache.http.conn.ConnectTimeoutException
            //   12	489	5	localRequest	com.tencent.tmassistantsdk.protocol.jce.Request
            //   129	215	6	localObject7	Object
            //   173	22	7	arrayOfByte	byte[]
            // Exception table:
            //   from	to	target	type
            //   74	78	204	org/apache/http/conn/ConnectTimeoutException
            //   80	95	204	org/apache/http/conn/ConnectTimeoutException
            //   102	120	204	org/apache/http/conn/ConnectTimeoutException
            //   122	131	204	org/apache/http/conn/ConnectTimeoutException
            //   138	155	204	org/apache/http/conn/ConnectTimeoutException
            //   157	166	204	org/apache/http/conn/ConnectTimeoutException
            //   168	175	204	org/apache/http/conn/ConnectTimeoutException
            //   177	185	204	org/apache/http/conn/ConnectTimeoutException
            //   192	201	204	org/apache/http/conn/ConnectTimeoutException
            //   267	274	204	org/apache/http/conn/ConnectTimeoutException
            //   281	288	204	org/apache/http/conn/ConnectTimeoutException
            //   290	297	204	org/apache/http/conn/ConnectTimeoutException
            //   304	312	204	org/apache/http/conn/ConnectTimeoutException
            //   314	328	204	org/apache/http/conn/ConnectTimeoutException
            //   335	356	204	org/apache/http/conn/ConnectTimeoutException
            //   68	72	414	java/net/ConnectException
            //   68	72	475	java/net/SocketTimeoutException
            //   68	72	538	java/lang/Exception
            //   68	72	603	finally
            //   74	78	642	finally
            //   80	95	642	finally
            //   102	120	642	finally
            //   122	131	642	finally
            //   138	155	642	finally
            //   157	166	642	finally
            //   168	175	642	finally
            //   177	185	642	finally
            //   192	201	642	finally
            //   208	221	642	finally
            //   223	236	642	finally
            //   267	274	642	finally
            //   281	288	642	finally
            //   290	297	642	finally
            //   304	312	642	finally
            //   314	328	642	finally
            //   335	356	642	finally
            //   420	433	642	finally
            //   435	446	642	finally
            //   481	494	642	finally
            //   496	509	642	finally
            //   544	557	642	finally
            //   559	574	642	finally
            //   74	78	646	java/lang/Exception
            //   80	95	646	java/lang/Exception
            //   102	120	646	java/lang/Exception
            //   122	131	646	java/lang/Exception
            //   138	155	646	java/lang/Exception
            //   157	166	646	java/lang/Exception
            //   168	175	646	java/lang/Exception
            //   177	185	646	java/lang/Exception
            //   192	201	646	java/lang/Exception
            //   267	274	646	java/lang/Exception
            //   281	288	646	java/lang/Exception
            //   290	297	646	java/lang/Exception
            //   304	312	646	java/lang/Exception
            //   314	328	646	java/lang/Exception
            //   335	356	646	java/lang/Exception
            //   74	78	651	java/net/SocketTimeoutException
            //   80	95	651	java/net/SocketTimeoutException
            //   102	120	651	java/net/SocketTimeoutException
            //   122	131	651	java/net/SocketTimeoutException
            //   138	155	651	java/net/SocketTimeoutException
            //   157	166	651	java/net/SocketTimeoutException
            //   168	175	651	java/net/SocketTimeoutException
            //   177	185	651	java/net/SocketTimeoutException
            //   192	201	651	java/net/SocketTimeoutException
            //   267	274	651	java/net/SocketTimeoutException
            //   281	288	651	java/net/SocketTimeoutException
            //   290	297	651	java/net/SocketTimeoutException
            //   304	312	651	java/net/SocketTimeoutException
            //   314	328	651	java/net/SocketTimeoutException
            //   335	356	651	java/net/SocketTimeoutException
            //   74	78	656	java/net/ConnectException
            //   80	95	656	java/net/ConnectException
            //   102	120	656	java/net/ConnectException
            //   122	131	656	java/net/ConnectException
            //   138	155	656	java/net/ConnectException
            //   157	166	656	java/net/ConnectException
            //   168	175	656	java/net/ConnectException
            //   177	185	656	java/net/ConnectException
            //   192	201	656	java/net/ConnectException
            //   267	274	656	java/net/ConnectException
            //   281	288	656	java/net/ConnectException
            //   290	297	656	java/net/ConnectException
            //   304	312	656	java/net/ConnectException
            //   314	328	656	java/net/ConnectException
            //   335	356	656	java/net/ConnectException
            //   68	72	661	org/apache/http/conn/ConnectTimeoutException
          }
        });
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.network.PostHttpRequest
 * JD-Core Version:    0.7.0.1
 */