import cooperation.plugin.PluginPreInstaller;

public class alwm
  implements Runnable
{
  public alwm(PluginPreInstaller paramPluginPreInstaller) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	alwm:a	Lcooperation/plugin/PluginPreInstaller;
    //   4: invokestatic 24	cooperation/plugin/PluginPreInstaller:a	(Lcooperation/plugin/PluginPreInstaller;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7: ifnonnull +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: getfield 12	alwm:a	Lcooperation/plugin/PluginPreInstaller;
    //   15: invokestatic 24	cooperation/plugin/PluginPreInstaller:a	(Lcooperation/plugin/PluginPreInstaller;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   18: invokevirtual 30	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   21: astore 4
    //   23: aload 4
    //   25: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifeq +18 -> 46
    //   31: invokestatic 42	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   34: ifeq -24 -> 10
    //   37: ldc 44
    //   39: iconst_4
    //   40: ldc 46
    //   42: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: return
    //   46: aconst_null
    //   47: astore_3
    //   48: aconst_null
    //   49: astore 5
    //   51: aload_3
    //   52: astore_2
    //   53: iconst_1
    //   54: aload_0
    //   55: getfield 12	alwm:a	Lcooperation/plugin/PluginPreInstaller;
    //   58: invokestatic 24	cooperation/plugin/PluginPreInstaller:a	(Lcooperation/plugin/PluginPreInstaller;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   61: invokestatic 55	cooperation/qqreader/QReaderHelper:a	(ILcom/tencent/mobileqq/app/QQAppInterface;)V
    //   64: aload_3
    //   65: astore_2
    //   66: aload_0
    //   67: getfield 12	alwm:a	Lcooperation/plugin/PluginPreInstaller;
    //   70: invokestatic 24	cooperation/plugin/PluginPreInstaller:a	(Lcooperation/plugin/PluginPreInstaller;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   73: invokestatic 61	cooperation/qqreader/QRBridgeUtil:getSKey	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   76: astore 6
    //   78: aload_3
    //   79: astore_2
    //   80: new 63	java/net/URL
    //   83: dup
    //   84: new 65	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   91: ldc 68
    //   93: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload 6
    //   98: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc 74
    //   103: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokespecial 80	java/net/URL:<init>	(Ljava/lang/String;)V
    //   112: invokevirtual 84	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   115: checkcast 86	java/net/HttpURLConnection
    //   118: astore_3
    //   119: aload_3
    //   120: sipush 10000
    //   123: invokevirtual 90	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   126: aload_3
    //   127: sipush 10000
    //   130: invokevirtual 93	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   133: aload_3
    //   134: ldc 95
    //   136: new 65	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   143: ldc 97
    //   145: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload 4
    //   150: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc 99
    //   155: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload 4
    //   160: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: ldc 101
    //   165: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload 6
    //   170: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokevirtual 105	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: aload_3
    //   180: invokevirtual 109	java/net/HttpURLConnection:getResponseCode	()I
    //   183: sipush 200
    //   186: if_icmpne +141 -> 327
    //   189: new 111	java/io/BufferedReader
    //   192: dup
    //   193: new 113	java/io/InputStreamReader
    //   196: dup
    //   197: aload_3
    //   198: invokevirtual 117	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   201: invokespecial 120	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   204: invokespecial 123	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   207: astore_2
    //   208: new 125	java/lang/StringBuffer
    //   211: dup
    //   212: invokespecial 126	java/lang/StringBuffer:<init>	()V
    //   215: astore 4
    //   217: aload_2
    //   218: invokevirtual 129	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   221: astore 5
    //   223: aload 5
    //   225: ifnull +32 -> 257
    //   228: aload 4
    //   230: aload 5
    //   232: invokevirtual 132	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   235: pop
    //   236: goto -19 -> 217
    //   239: astore 4
    //   241: aload_3
    //   242: astore_2
    //   243: aload 4
    //   245: invokevirtual 135	java/lang/Exception:printStackTrace	()V
    //   248: aload_3
    //   249: ifnull -239 -> 10
    //   252: aload_3
    //   253: invokevirtual 138	java/net/HttpURLConnection:disconnect	()V
    //   256: return
    //   257: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   260: ifeq +32 -> 292
    //   263: ldc 44
    //   265: iconst_2
    //   266: new 65	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   273: ldc 143
    //   275: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload 4
    //   280: invokevirtual 144	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   283: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   292: new 146	org/json/JSONObject
    //   295: dup
    //   296: aload 4
    //   298: invokevirtual 144	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   301: invokespecial 147	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   304: ldc 149
    //   306: invokevirtual 153	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   309: ldc 155
    //   311: invokevirtual 159	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   314: istore_1
    //   315: aload_0
    //   316: getfield 12	alwm:a	Lcooperation/plugin/PluginPreInstaller;
    //   319: invokestatic 162	cooperation/plugin/PluginPreInstaller:a	(Lcooperation/plugin/PluginPreInstaller;)Landroid/content/Context;
    //   322: iload_1
    //   323: iconst_1
    //   324: invokestatic 167	cooperation/qqreader/QRUtility:a	(Landroid/content/Context;IZ)V
    //   327: aload_3
    //   328: ifnull -318 -> 10
    //   331: aload_3
    //   332: invokevirtual 138	java/net/HttpURLConnection:disconnect	()V
    //   335: return
    //   336: astore 4
    //   338: aload_2
    //   339: astore_3
    //   340: aload 4
    //   342: astore_2
    //   343: aload_3
    //   344: ifnull +7 -> 351
    //   347: aload_3
    //   348: invokevirtual 138	java/net/HttpURLConnection:disconnect	()V
    //   351: aload_2
    //   352: athrow
    //   353: astore_2
    //   354: goto -11 -> 343
    //   357: astore 4
    //   359: aload 5
    //   361: astore_3
    //   362: goto -121 -> 241
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	this	alwm
    //   314	9	1	i	int
    //   52	300	2	localObject1	Object
    //   353	1	2	localObject2	Object
    //   47	315	3	localObject3	Object
    //   21	208	4	localObject4	Object
    //   239	58	4	localException1	java.lang.Exception
    //   336	5	4	localObject5	Object
    //   357	1	4	localException2	java.lang.Exception
    //   49	311	5	str1	java.lang.String
    //   76	93	6	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   119	217	239	java/lang/Exception
    //   217	223	239	java/lang/Exception
    //   228	236	239	java/lang/Exception
    //   257	292	239	java/lang/Exception
    //   292	327	239	java/lang/Exception
    //   53	64	336	finally
    //   66	78	336	finally
    //   80	119	336	finally
    //   243	248	336	finally
    //   119	217	353	finally
    //   217	223	353	finally
    //   228	236	353	finally
    //   257	292	353	finally
    //   292	327	353	finally
    //   53	64	357	java/lang/Exception
    //   66	78	357	java/lang/Exception
    //   80	119	357	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alwm
 * JD-Core Version:    0.7.0.1
 */