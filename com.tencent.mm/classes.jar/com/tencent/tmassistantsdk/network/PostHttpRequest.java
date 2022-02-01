package com.tencent.tmassistantsdk.network;

import com.qq.taf.jce.JceStruct;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import org.apache.http.client.methods.HttpPost;

public abstract class PostHttpRequest
{
  static final String REQUEST_SERVER_URL = "http://" + WeChatHosts.domainString(2131761720) + "/";
  static final String TAG = "BaseHttpRequest";
  HttpPost mHttpPost = null;
  
  /* Error */
  public void cancleRequest()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 47	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
    //   6: ifnull +51 -> 57
    //   9: aload_0
    //   10: getfield 47	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
    //   13: invokevirtual 56	org/apache/http/client/methods/HttpPost:isAborted	()Z
    //   16: ifne +41 -> 57
    //   19: ldc 11
    //   21: new 17	java/lang/StringBuilder
    //   24: dup
    //   25: ldc 58
    //   27: invokespecial 23	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   30: aload_0
    //   31: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   34: ldc 63
    //   36: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 69	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_0
    //   46: getfield 47	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
    //   49: invokevirtual 72	org/apache/http/client/methods/HttpPost:abort	()V
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 47	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: astore_1
    //   61: ldc 11
    //   63: aload_1
    //   64: ldc 74
    //   66: iconst_0
    //   67: anewarray 4	java/lang/Object
    //   70: invokestatic 80	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   73: aload_0
    //   74: aconst_null
    //   75: putfield 47	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
    //   78: goto -21 -> 57
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    //   86: astore_1
    //   87: aload_0
    //   88: aconst_null
    //   89: putfield 47	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
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
        h.RTc.ba(new Runnable()
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
            //   28: getstatic 57	com/tencent/tmassistantsdk/network/PostHttpRequest:REQUEST_SERVER_URL	Ljava/lang/String;
            //   31: invokespecial 60	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
            //   34: putfield 64	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
            //   37: aload_0
            //   38: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   41: getfield 64	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
            //   44: ldc 66
            //   46: ldc 68
            //   48: invokevirtual 72	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
            //   51: aload_0
            //   52: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   55: getfield 64	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
            //   58: new 74	org/apache/http/entity/ByteArrayEntity
            //   61: dup
            //   62: aload_2
            //   63: invokespecial 77	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
            //   66: invokevirtual 81	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
            //   69: invokestatic 87	com/tencent/tmassistantsdk/downloadservice/HttpClientUtil:createHttpClient	()Lorg/apache/http/client/HttpClient;
            //   72: astore_3
            //   73: aload_3
            //   74: astore_2
            //   75: aload_3
            //   76: invokestatic 91	com/tencent/tmassistantsdk/downloadservice/HttpClientUtil:setProxy	(Lorg/apache/http/client/HttpClient;)V
            //   79: aload_3
            //   80: astore_2
            //   81: aload_3
            //   82: aload_0
            //   83: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   86: getfield 64	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
            //   89: invokeinterface 97 2 0
            //   94: astore 4
            //   96: aload 4
            //   98: ifnull +288 -> 386
            //   101: aload_3
            //   102: astore_2
            //   103: aload 4
            //   105: invokeinterface 103 1 0
            //   110: invokeinterface 109 1 0
            //   115: sipush 200
            //   118: if_icmpne +268 -> 386
            //   121: aload_3
            //   122: astore_2
            //   123: aload 4
            //   125: invokeinterface 113 1 0
            //   130: astore 6
            //   132: aload 6
            //   134: ifnull +252 -> 386
            //   137: aload_3
            //   138: astore_2
            //   139: new 115	org/apache/http/util/ByteArrayBuffer
            //   142: dup
            //   143: aload 6
            //   145: invokeinterface 121 1 0
            //   150: l2i
            //   151: invokespecial 123	org/apache/http/util/ByteArrayBuffer:<init>	(I)V
            //   154: astore 4
            //   156: aload_3
            //   157: astore_2
            //   158: aload 6
            //   160: invokeinterface 127 1 0
            //   165: astore 6
            //   167: aload_3
            //   168: astore_2
            //   169: sipush 2048
            //   172: newarray byte
            //   174: astore 7
            //   176: aload_3
            //   177: astore_2
            //   178: aload 6
            //   180: aload 7
            //   182: invokevirtual 133	java/io/InputStream:read	([B)I
            //   185: istore_1
            //   186: iload_1
            //   187: iconst_m1
            //   188: if_icmpeq +78 -> 266
            //   191: aload_3
            //   192: astore_2
            //   193: aload 4
            //   195: aload 7
            //   197: iconst_0
            //   198: iload_1
            //   199: invokevirtual 137	org/apache/http/util/ByteArrayBuffer:append	([BII)V
            //   202: goto -26 -> 176
            //   205: astore 4
            //   207: aload_3
            //   208: astore_2
            //   209: ldc 139
            //   211: aload 4
            //   213: ldc 141
            //   215: iconst_0
            //   216: anewarray 4	java/lang/Object
            //   219: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
            //   222: aload_3
            //   223: astore_2
            //   224: aload_0
            //   225: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   228: aload 5
            //   230: aconst_null
            //   231: sipush 601
            //   234: invokevirtual 151	com/tencent/tmassistantsdk/network/PostHttpRequest:onFinished	(Lcom/qq/taf/jce/JceStruct;Lcom/qq/taf/jce/JceStruct;I)V
            //   237: aload_0
            //   238: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   241: aconst_null
            //   242: putfield 64	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
            //   245: aload_3
            //   246: ifnull +391 -> 637
            //   249: aload_3
            //   250: invokeinterface 155 1 0
            //   255: invokeinterface 160 1 0
            //   260: ldc 35
            //   262: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   265: return
            //   266: aload_3
            //   267: astore_2
            //   268: aload 4
            //   270: invokevirtual 167	org/apache/http/util/ByteArrayBuffer:buffer	()[B
            //   273: astore 4
            //   275: aload 4
            //   277: ifnull +109 -> 386
            //   280: aload_3
            //   281: astore_2
            //   282: aload 4
            //   284: arraylength
            //   285: iconst_4
            //   286: if_icmple +100 -> 386
            //   289: aload_3
            //   290: astore_2
            //   291: aload 4
            //   293: invokestatic 171	com/tencent/tmassistantsdk/protocol/ProtocolPackage:unpackPackage	([B)Lcom/tencent/tmassistantsdk/protocol/jce/Response;
            //   296: astore 4
            //   298: aload 4
            //   300: ifnull +86 -> 386
            //   303: aload_3
            //   304: astore_2
            //   305: aload 4
            //   307: getfield 177	com/tencent/tmassistantsdk/protocol/jce/Response:body	[B
            //   310: ifnull +76 -> 386
            //   313: aload_3
            //   314: astore_2
            //   315: aload_0
            //   316: getfield 21	com/tencent/tmassistantsdk/network/PostHttpRequest$1:val$sendRequest	Lcom/qq/taf/jce/JceStruct;
            //   319: aload 4
            //   321: getfield 177	com/tencent/tmassistantsdk/protocol/jce/Response:body	[B
            //   324: invokestatic 181	com/tencent/tmassistantsdk/protocol/ProtocolPackage:unpageageJceResponse	(Lcom/qq/taf/jce/JceStruct;[B)Lcom/qq/taf/jce/JceStruct;
            //   327: astore 6
            //   329: aload 6
            //   331: ifnull +55 -> 386
            //   334: aload_3
            //   335: astore_2
            //   336: aload_0
            //   337: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   340: aload_0
            //   341: getfield 21	com/tencent/tmassistantsdk/network/PostHttpRequest$1:val$sendRequest	Lcom/qq/taf/jce/JceStruct;
            //   344: aload 6
            //   346: aload 4
            //   348: getfield 185	com/tencent/tmassistantsdk/protocol/jce/Response:head	Lcom/tencent/tmassistantsdk/protocol/jce/RspHead;
            //   351: getfield 191	com/tencent/tmassistantsdk/protocol/jce/RspHead:ret	I
            //   354: invokevirtual 151	com/tencent/tmassistantsdk/network/PostHttpRequest:onFinished	(Lcom/qq/taf/jce/JceStruct;Lcom/qq/taf/jce/JceStruct;I)V
            //   357: aload_0
            //   358: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   361: aconst_null
            //   362: putfield 64	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
            //   365: aload_3
            //   366: ifnull +14 -> 380
            //   369: aload_3
            //   370: invokeinterface 155 1 0
            //   375: invokeinterface 160 1 0
            //   380: ldc 35
            //   382: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   385: return
            //   386: aload_0
            //   387: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   390: aconst_null
            //   391: putfield 64	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
            //   394: aload_3
            //   395: ifnull +242 -> 637
            //   398: aload_3
            //   399: invokeinterface 155 1 0
            //   404: invokeinterface 160 1 0
            //   409: ldc 35
            //   411: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   414: return
            //   415: astore 4
            //   417: aconst_null
            //   418: astore_3
            //   419: aload_3
            //   420: astore_2
            //   421: ldc 139
            //   423: aload 4
            //   425: ldc 141
            //   427: iconst_0
            //   428: anewarray 4	java/lang/Object
            //   431: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
            //   434: aload_3
            //   435: astore_2
            //   436: aload_0
            //   437: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   440: aload 5
            //   442: aconst_null
            //   443: iconst_1
            //   444: invokevirtual 151	com/tencent/tmassistantsdk/network/PostHttpRequest:onFinished	(Lcom/qq/taf/jce/JceStruct;Lcom/qq/taf/jce/JceStruct;I)V
            //   447: aload_0
            //   448: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   451: aconst_null
            //   452: putfield 64	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
            //   455: aload_3
            //   456: ifnull +181 -> 637
            //   459: aload_3
            //   460: invokeinterface 155 1 0
            //   465: invokeinterface 160 1 0
            //   470: ldc 35
            //   472: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   475: return
            //   476: astore 4
            //   478: aconst_null
            //   479: astore_3
            //   480: aload_3
            //   481: astore_2
            //   482: ldc 139
            //   484: aload 4
            //   486: ldc 141
            //   488: iconst_0
            //   489: anewarray 4	java/lang/Object
            //   492: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
            //   495: aload_3
            //   496: astore_2
            //   497: aload_0
            //   498: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   501: aload 5
            //   503: aconst_null
            //   504: sipush 602
            //   507: invokevirtual 151	com/tencent/tmassistantsdk/network/PostHttpRequest:onFinished	(Lcom/qq/taf/jce/JceStruct;Lcom/qq/taf/jce/JceStruct;I)V
            //   510: aload_0
            //   511: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   514: aconst_null
            //   515: putfield 64	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
            //   518: aload_3
            //   519: ifnull +118 -> 637
            //   522: aload_3
            //   523: invokeinterface 155 1 0
            //   528: invokeinterface 160 1 0
            //   533: ldc 35
            //   535: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   538: return
            //   539: astore 4
            //   541: aconst_null
            //   542: astore_3
            //   543: aload_3
            //   544: astore_2
            //   545: ldc 139
            //   547: aload 4
            //   549: ldc 141
            //   551: iconst_0
            //   552: anewarray 4	java/lang/Object
            //   555: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
            //   558: aload_3
            //   559: astore_2
            //   560: aload_0
            //   561: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   564: aload_0
            //   565: getfield 21	com/tencent/tmassistantsdk/network/PostHttpRequest$1:val$sendRequest	Lcom/qq/taf/jce/JceStruct;
            //   568: aconst_null
            //   569: sipush 604
            //   572: invokevirtual 151	com/tencent/tmassistantsdk/network/PostHttpRequest:onFinished	(Lcom/qq/taf/jce/JceStruct;Lcom/qq/taf/jce/JceStruct;I)V
            //   575: aload_0
            //   576: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   579: aconst_null
            //   580: putfield 64	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
            //   583: aload_3
            //   584: ifnull +53 -> 637
            //   587: aload_3
            //   588: invokeinterface 155 1 0
            //   593: invokeinterface 160 1 0
            //   598: ldc 35
            //   600: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   603: return
            //   604: astore_3
            //   605: aconst_null
            //   606: astore_2
            //   607: aload_0
            //   608: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest$1:this$0	Lcom/tencent/tmassistantsdk/network/PostHttpRequest;
            //   611: aconst_null
            //   612: putfield 64	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
            //   615: aload_2
            //   616: ifnull +14 -> 630
            //   619: aload_2
            //   620: invokeinterface 155 1 0
            //   625: invokeinterface 160 1 0
            //   630: ldc 35
            //   632: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   635: aload_3
            //   636: athrow
            //   637: ldc 35
            //   639: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   642: return
            //   643: astore_3
            //   644: goto -37 -> 607
            //   647: astore 4
            //   649: goto -106 -> 543
            //   652: astore 4
            //   654: goto -174 -> 480
            //   657: astore 4
            //   659: goto -240 -> 419
            //   662: astore 4
            //   664: aconst_null
            //   665: astore_3
            //   666: goto -459 -> 207
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	669	0	this	1
            //   185	14	1	i	int
            //   19	601	2	localObject1	Object
            //   72	516	3	localHttpClient	org.apache.http.client.HttpClient
            //   604	32	3	localObject2	Object
            //   643	1	3	localObject3	Object
            //   665	1	3	localObject4	Object
            //   94	100	4	localObject5	Object
            //   205	64	4	localConnectTimeoutException1	org.apache.http.conn.ConnectTimeoutException
            //   273	74	4	localObject6	Object
            //   415	9	4	localConnectException1	java.net.ConnectException
            //   476	9	4	localSocketTimeoutException1	java.net.SocketTimeoutException
            //   539	9	4	localException1	java.lang.Exception
            //   647	1	4	localException2	java.lang.Exception
            //   652	1	4	localSocketTimeoutException2	java.net.SocketTimeoutException
            //   657	1	4	localConnectException2	java.net.ConnectException
            //   662	1	4	localConnectTimeoutException2	org.apache.http.conn.ConnectTimeoutException
            //   12	490	5	localRequest	com.tencent.tmassistantsdk.protocol.jce.Request
            //   130	215	6	localObject7	Object
            //   174	22	7	arrayOfByte	byte[]
            // Exception table:
            //   from	to	target	type
            //   75	79	205	org/apache/http/conn/ConnectTimeoutException
            //   81	96	205	org/apache/http/conn/ConnectTimeoutException
            //   103	121	205	org/apache/http/conn/ConnectTimeoutException
            //   123	132	205	org/apache/http/conn/ConnectTimeoutException
            //   139	156	205	org/apache/http/conn/ConnectTimeoutException
            //   158	167	205	org/apache/http/conn/ConnectTimeoutException
            //   169	176	205	org/apache/http/conn/ConnectTimeoutException
            //   178	186	205	org/apache/http/conn/ConnectTimeoutException
            //   193	202	205	org/apache/http/conn/ConnectTimeoutException
            //   268	275	205	org/apache/http/conn/ConnectTimeoutException
            //   282	289	205	org/apache/http/conn/ConnectTimeoutException
            //   291	298	205	org/apache/http/conn/ConnectTimeoutException
            //   305	313	205	org/apache/http/conn/ConnectTimeoutException
            //   315	329	205	org/apache/http/conn/ConnectTimeoutException
            //   336	357	205	org/apache/http/conn/ConnectTimeoutException
            //   69	73	415	java/net/ConnectException
            //   69	73	476	java/net/SocketTimeoutException
            //   69	73	539	java/lang/Exception
            //   69	73	604	finally
            //   75	79	643	finally
            //   81	96	643	finally
            //   103	121	643	finally
            //   123	132	643	finally
            //   139	156	643	finally
            //   158	167	643	finally
            //   169	176	643	finally
            //   178	186	643	finally
            //   193	202	643	finally
            //   209	222	643	finally
            //   224	237	643	finally
            //   268	275	643	finally
            //   282	289	643	finally
            //   291	298	643	finally
            //   305	313	643	finally
            //   315	329	643	finally
            //   336	357	643	finally
            //   421	434	643	finally
            //   436	447	643	finally
            //   482	495	643	finally
            //   497	510	643	finally
            //   545	558	643	finally
            //   560	575	643	finally
            //   75	79	647	java/lang/Exception
            //   81	96	647	java/lang/Exception
            //   103	121	647	java/lang/Exception
            //   123	132	647	java/lang/Exception
            //   139	156	647	java/lang/Exception
            //   158	167	647	java/lang/Exception
            //   169	176	647	java/lang/Exception
            //   178	186	647	java/lang/Exception
            //   193	202	647	java/lang/Exception
            //   268	275	647	java/lang/Exception
            //   282	289	647	java/lang/Exception
            //   291	298	647	java/lang/Exception
            //   305	313	647	java/lang/Exception
            //   315	329	647	java/lang/Exception
            //   336	357	647	java/lang/Exception
            //   75	79	652	java/net/SocketTimeoutException
            //   81	96	652	java/net/SocketTimeoutException
            //   103	121	652	java/net/SocketTimeoutException
            //   123	132	652	java/net/SocketTimeoutException
            //   139	156	652	java/net/SocketTimeoutException
            //   158	167	652	java/net/SocketTimeoutException
            //   169	176	652	java/net/SocketTimeoutException
            //   178	186	652	java/net/SocketTimeoutException
            //   193	202	652	java/net/SocketTimeoutException
            //   268	275	652	java/net/SocketTimeoutException
            //   282	289	652	java/net/SocketTimeoutException
            //   291	298	652	java/net/SocketTimeoutException
            //   305	313	652	java/net/SocketTimeoutException
            //   315	329	652	java/net/SocketTimeoutException
            //   336	357	652	java/net/SocketTimeoutException
            //   75	79	657	java/net/ConnectException
            //   81	96	657	java/net/ConnectException
            //   103	121	657	java/net/ConnectException
            //   123	132	657	java/net/ConnectException
            //   139	156	657	java/net/ConnectException
            //   158	167	657	java/net/ConnectException
            //   169	176	657	java/net/ConnectException
            //   178	186	657	java/net/ConnectException
            //   193	202	657	java/net/ConnectException
            //   268	275	657	java/net/ConnectException
            //   282	289	657	java/net/ConnectException
            //   291	298	657	java/net/ConnectException
            //   305	313	657	java/net/ConnectException
            //   315	329	657	java/net/ConnectException
            //   336	357	657	java/net/ConnectException
            //   69	73	662	org/apache/http/conn/ConnectTimeoutException
          }
        });
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tmassistantsdk.network.PostHttpRequest
 * JD-Core Version:    0.7.0.1
 */