package com.tencent.youtu.sdkkitframework.net;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;

public class YtSDKKitNetHelper
{
  private static final String TAG;
  private static final int TIME_OUT = 10000;
  private static YtSDKKitNetHelper _instane;
  private HttpsURLConnection conn;
  private Thread networkThread;
  private HashMap<Integer, Thread> runningMap;
  
  static
  {
    AppMethodBeat.i(218120);
    TAG = YtSDKKitNetHelper.class.getSimpleName();
    AppMethodBeat.o(218120);
  }
  
  private YtSDKKitNetHelper()
  {
    AppMethodBeat.i(218075);
    this.runningMap = new HashMap();
    AppMethodBeat.o(218075);
  }
  
  public static void clearInstance()
  {
    try
    {
      AppMethodBeat.i(218068);
      if (_instane != null) {
        _instane.stopNetworkRequest();
      }
      _instane = null;
      AppMethodBeat.o(218068);
      return;
    }
    finally {}
  }
  
  public static YtSDKKitNetHelper getInstance()
  {
    try
    {
      AppMethodBeat.i(218066);
      if (_instane == null) {
        _instane = new YtSDKKitNetHelper();
      }
      YtSDKKitNetHelper localYtSDKKitNetHelper = _instane;
      AppMethodBeat.o(218066);
      return localYtSDKKitNetHelper;
    }
    finally {}
  }
  
  public void sendNetworkRequest(final String paramString1, final String paramString2, final HashMap<String, String> paramHashMap, final YtSDKKitFramework.IYtSDKKitNetResponseParser paramIYtSDKKitNetResponseParser)
  {
    AppMethodBeat.i(218132);
    this.networkThread = new Thread(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: ldc 40
        //   2: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 24	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
        //   9: invokestatic 50	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$100	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljava/util/HashMap;
        //   12: invokestatic 56	android/os/Process:myTid	()I
        //   15: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   18: aload_0
        //   19: getfield 24	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
        //   22: invokestatic 66	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$000	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljava/lang/Thread;
        //   25: invokevirtual 72	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   28: pop
        //   29: new 74	java/net/URL
        //   32: dup
        //   33: aload_0
        //   34: getfield 26	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:val$url	Ljava/lang/String;
        //   37: invokespecial 77	java/net/URL:<init>	(Ljava/lang/String;)V
        //   40: astore_2
        //   41: aload_0
        //   42: getfield 24	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
        //   45: aload_2
        //   46: invokevirtual 81	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   49: checkcast 83	javax/net/ssl/HttpsURLConnection
        //   52: invokestatic 87	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$202	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;Ljavax/net/ssl/HttpsURLConnection;)Ljavax/net/ssl/HttpsURLConnection;
        //   55: pop
        //   56: aload_0
        //   57: getfield 24	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
        //   60: invokestatic 91	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$200	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljavax/net/ssl/HttpsURLConnection;
        //   63: ldc 93
        //   65: invokevirtual 96	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   68: aload_0
        //   69: getfield 24	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
        //   72: invokestatic 91	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$200	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljavax/net/ssl/HttpsURLConnection;
        //   75: invokestatic 102	com/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework:getInstance	()Lcom/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework;
        //   78: invokevirtual 105	com/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework:getNetworkRequestTimeoutMS	()I
        //   81: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
        //   84: aload_0
        //   85: getfield 28	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:val$requestHeader	Ljava/util/HashMap;
        //   88: ifnull +127 -> 215
        //   91: aload_0
        //   92: getfield 28	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:val$requestHeader	Ljava/util/HashMap;
        //   95: invokevirtual 112	java/util/HashMap:entrySet	()Ljava/util/Set;
        //   98: invokeinterface 118 1 0
        //   103: astore_2
        //   104: aload_2
        //   105: invokeinterface 124 1 0
        //   110: ifeq +105 -> 215
        //   113: aload_2
        //   114: invokeinterface 128 1 0
        //   119: checkcast 130	java/util/Map$Entry
        //   122: astore_3
        //   123: aload_0
        //   124: getfield 24	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
        //   127: invokestatic 91	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$200	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljavax/net/ssl/HttpsURLConnection;
        //   130: aload_3
        //   131: invokeinterface 133 1 0
        //   136: checkcast 135	java/lang/String
        //   139: aload_3
        //   140: invokeinterface 138 1 0
        //   145: checkcast 135	java/lang/String
        //   148: invokevirtual 142	javax/net/ssl/HttpsURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   151: goto -47 -> 104
        //   154: astore_2
        //   155: invokestatic 146	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$300	()Ljava/lang/String;
        //   158: new 148	java/lang/StringBuilder
        //   161: dup
        //   162: ldc 150
        //   164: invokespecial 151	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   167: aload_2
        //   168: invokevirtual 154	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
        //   171: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   174: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   177: invokestatic 166	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   180: aload_0
        //   181: getfield 32	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:val$parser	Lcom/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework$IYtSDKKitNetResponseParser;
        //   184: aconst_null
        //   185: aload_2
        //   186: invokeinterface 172 3 0
        //   191: invokestatic 146	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$300	()Ljava/lang/String;
        //   194: ldc 174
        //   196: invokestatic 178	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
        //   199: aload_0
        //   200: getfield 24	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
        //   203: invokestatic 91	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$200	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljavax/net/ssl/HttpsURLConnection;
        //   206: invokevirtual 181	javax/net/ssl/HttpsURLConnection:disconnect	()V
        //   209: ldc 40
        //   211: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   214: return
        //   215: invokestatic 146	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$300	()Ljava/lang/String;
        //   218: ldc 186
        //   220: invokestatic 178	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
        //   223: aload_0
        //   224: getfield 24	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
        //   227: invokestatic 91	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$200	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljavax/net/ssl/HttpsURLConnection;
        //   230: invokevirtual 190	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
        //   233: astore_2
        //   234: new 192	java/io/BufferedWriter
        //   237: dup
        //   238: new 194	java/io/OutputStreamWriter
        //   241: dup
        //   242: aload_2
        //   243: ldc 196
        //   245: invokespecial 199	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
        //   248: invokespecial 202	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
        //   251: astore_3
        //   252: aload_3
        //   253: aload_0
        //   254: getfield 30	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:val$requestContent	Ljava/lang/String;
        //   257: invokevirtual 205	java/io/BufferedWriter:write	(Ljava/lang/String;)V
        //   260: aload_3
        //   261: invokevirtual 208	java/io/BufferedWriter:flush	()V
        //   264: aload_3
        //   265: invokevirtual 211	java/io/BufferedWriter:close	()V
        //   268: aload_2
        //   269: invokevirtual 214	java/io/OutputStream:close	()V
        //   272: invokestatic 146	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$300	()Ljava/lang/String;
        //   275: ldc 216
        //   277: invokestatic 178	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
        //   280: aload_0
        //   281: getfield 24	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
        //   284: invokestatic 91	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$200	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljavax/net/ssl/HttpsURLConnection;
        //   287: invokevirtual 219	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
        //   290: istore_1
        //   291: invokestatic 146	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$300	()Ljava/lang/String;
        //   294: ldc 221
        //   296: invokestatic 178	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
        //   299: aload_0
        //   300: getfield 24	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
        //   303: invokestatic 50	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$100	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljava/util/HashMap;
        //   306: invokestatic 56	android/os/Process:myTid	()I
        //   309: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   312: invokevirtual 225	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
        //   315: ifne +45 -> 360
        //   318: invokestatic 146	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$300	()Ljava/lang/String;
        //   321: ldc 227
        //   323: invokestatic 229	com/tencent/youtu/sdkkitframework/common/YtLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   326: aload_0
        //   327: getfield 24	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
        //   330: invokestatic 91	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$200	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljavax/net/ssl/HttpsURLConnection;
        //   333: invokevirtual 181	javax/net/ssl/HttpsURLConnection:disconnect	()V
        //   336: invokestatic 146	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$300	()Ljava/lang/String;
        //   339: ldc 174
        //   341: invokestatic 178	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
        //   344: aload_0
        //   345: getfield 24	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
        //   348: invokestatic 91	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$200	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljavax/net/ssl/HttpsURLConnection;
        //   351: invokevirtual 181	javax/net/ssl/HttpsURLConnection:disconnect	()V
        //   354: ldc 40
        //   356: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   359: return
        //   360: iload_1
        //   361: sipush 200
        //   364: if_icmpne +115 -> 479
        //   367: new 231	java/io/BufferedReader
        //   370: dup
        //   371: new 233	java/io/InputStreamReader
        //   374: dup
        //   375: aload_0
        //   376: getfield 24	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
        //   379: invokestatic 91	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$200	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljavax/net/ssl/HttpsURLConnection;
        //   382: invokevirtual 237	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
        //   385: invokespecial 240	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
        //   388: invokespecial 243	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   391: astore_3
        //   392: new 245	java/lang/StringBuffer
        //   395: dup
        //   396: ldc 247
        //   398: invokespecial 248	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
        //   401: astore_2
        //   402: aload_3
        //   403: invokevirtual 251	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   406: astore 4
        //   408: aload 4
        //   410: ifnull +10 -> 420
        //   413: aload_2
        //   414: aload 4
        //   416: invokevirtual 254	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   419: pop
        //   420: aload_3
        //   421: invokevirtual 255	java/io/BufferedReader:close	()V
        //   424: new 68	java/util/HashMap
        //   427: dup
        //   428: invokespecial 256	java/util/HashMap:<init>	()V
        //   431: astore_3
        //   432: aload_3
        //   433: ldc_w 258
        //   436: aload_2
        //   437: invokevirtual 259	java/lang/StringBuffer:toString	()Ljava/lang/String;
        //   440: invokevirtual 72	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   443: pop
        //   444: aload_0
        //   445: getfield 32	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:val$parser	Lcom/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework$IYtSDKKitNetResponseParser;
        //   448: aload_3
        //   449: aconst_null
        //   450: invokeinterface 172 3 0
        //   455: invokestatic 146	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$300	()Ljava/lang/String;
        //   458: ldc 174
        //   460: invokestatic 178	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
        //   463: aload_0
        //   464: getfield 24	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
        //   467: invokestatic 91	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$200	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljavax/net/ssl/HttpsURLConnection;
        //   470: invokevirtual 181	javax/net/ssl/HttpsURLConnection:disconnect	()V
        //   473: ldc 40
        //   475: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   478: return
        //   479: invokestatic 146	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$300	()Ljava/lang/String;
        //   482: ldc 150
        //   484: iload_1
        //   485: invokestatic 262	java/lang/String:valueOf	(I)Ljava/lang/String;
        //   488: invokevirtual 266	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   491: invokestatic 166	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   494: aload_0
        //   495: getfield 32	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:val$parser	Lcom/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework$IYtSDKKitNetResponseParser;
        //   498: aconst_null
        //   499: new 39	java/lang/Exception
        //   502: dup
        //   503: ldc_w 268
        //   506: iload_1
        //   507: invokestatic 262	java/lang/String:valueOf	(I)Ljava/lang/String;
        //   510: invokevirtual 266	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   513: invokespecial 269	java/lang/Exception:<init>	(Ljava/lang/String;)V
        //   516: invokeinterface 172 3 0
        //   521: goto -66 -> 455
        //   524: astore_2
        //   525: invokestatic 146	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$300	()Ljava/lang/String;
        //   528: ldc 174
        //   530: invokestatic 178	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
        //   533: aload_0
        //   534: getfield 24	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
        //   537: invokestatic 91	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$200	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljavax/net/ssl/HttpsURLConnection;
        //   540: invokevirtual 181	javax/net/ssl/HttpsURLConnection:disconnect	()V
        //   543: ldc 40
        //   545: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   548: aload_2
        //   549: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	550	0	this	1
        //   290	217	1	i	int
        //   40	74	2	localObject1	Object
        //   154	32	2	localException	java.lang.Exception
        //   233	204	2	localObject2	Object
        //   524	25	2	localObject3	Object
        //   122	327	3	localObject4	Object
        //   406	9	4	str	String
        // Exception table:
        //   from	to	target	type
        //   5	104	154	java/lang/Exception
        //   104	151	154	java/lang/Exception
        //   215	336	154	java/lang/Exception
        //   367	408	154	java/lang/Exception
        //   413	420	154	java/lang/Exception
        //   420	455	154	java/lang/Exception
        //   479	521	154	java/lang/Exception
        //   5	104	524	finally
        //   104	151	524	finally
        //   155	191	524	finally
        //   215	336	524	finally
        //   367	408	524	finally
        //   413	420	524	finally
        //   420	455	524	finally
        //   479	521	524	finally
      }
    });
    this.networkThread.setName("YtNetworkRequestThread");
    this.networkThread.start();
    AppMethodBeat.o(218132);
  }
  
  public void stopNetworkRequest()
  {
    AppMethodBeat.i(218128);
    Iterator localIterator = this.runningMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry.getValue() == this.networkThread)
      {
        this.runningMap.remove(localEntry.getKey());
        YtLogger.d(TAG, "network remove " + localEntry.getKey());
        AppMethodBeat.o(218128);
        return;
      }
    }
    AppMethodBeat.o(218128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.net.YtSDKKitNetHelper
 * JD-Core Version:    0.7.0.1
 */