import com.tencent.mobileqq.jsp.MediaApiPlugin;
import java.util.concurrent.atomic.AtomicBoolean;

public class admg
  implements Runnable
{
  public admg(MediaApiPlugin paramMediaApiPlugin, String paramString1, String paramString2, AtomicBoolean paramAtomicBoolean) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 36	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 37	org/json/JSONObject:<init>	()V
    //   7: astore 4
    //   9: invokestatic 43	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   12: astore 5
    //   14: invokestatic 43	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   17: aload_0
    //   18: getfield 17	admg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: aconst_null
    //   22: ldc 45
    //   24: aconst_null
    //   25: aconst_null
    //   26: invokestatic 50	com/tencent/biz/common/util/HttpUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)Lorg/apache/http/HttpResponse;
    //   29: astore 6
    //   31: aload 6
    //   33: ifnull +368 -> 401
    //   36: aload 6
    //   38: invokeinterface 56 1 0
    //   43: invokeinterface 62 1 0
    //   48: istore_1
    //   49: iload_1
    //   50: istore_2
    //   51: iload_1
    //   52: sipush 200
    //   55: if_icmpne +348 -> 403
    //   58: aload 6
    //   60: invokestatic 65	com/tencent/biz/common/util/HttpUtil:a	(Lorg/apache/http/HttpResponse;)Ljava/io/ByteArrayOutputStream;
    //   63: invokevirtual 71	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   66: astore 6
    //   68: aload 4
    //   70: ldc 73
    //   72: iload_1
    //   73: invokevirtual 77	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   76: pop
    //   77: aload_0
    //   78: getfield 15	admg:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   81: aload 6
    //   83: invokevirtual 82	com/tencent/mobileqq/jsp/MediaApiPlugin:a	([B)Ljava/lang/String;
    //   86: astore 6
    //   88: aload 4
    //   90: ldc 84
    //   92: iconst_0
    //   93: invokevirtual 77	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   96: pop
    //   97: aload 4
    //   99: ldc 86
    //   101: aload 5
    //   103: ldc 87
    //   105: invokevirtual 93	android/content/Context:getString	(I)Ljava/lang/String;
    //   108: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   111: pop
    //   112: aload 4
    //   114: ldc 98
    //   116: aload 6
    //   118: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   121: pop
    //   122: aload_0
    //   123: getfield 19	admg:b	Ljava/lang/String;
    //   126: invokestatic 104	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   129: ifne +140 -> 269
    //   132: aload_0
    //   133: getfield 21	admg:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   136: iconst_0
    //   137: iconst_1
    //   138: invokevirtual 110	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   141: ifeq +128 -> 269
    //   144: aload_0
    //   145: getfield 15	admg:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   148: aload_0
    //   149: getfield 19	admg:b	Ljava/lang/String;
    //   152: iconst_1
    //   153: anewarray 112	java/lang/String
    //   156: dup
    //   157: iconst_0
    //   158: aload 4
    //   160: invokevirtual 116	org/json/JSONObject:toString	()Ljava/lang/String;
    //   163: aastore
    //   164: invokevirtual 120	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   167: aload_0
    //   168: getfield 15	admg:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   171: getfield 123	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   174: ifnull +26 -> 200
    //   177: aload_0
    //   178: getfield 15	admg:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   181: getfield 123	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   184: invokevirtual 129	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   187: ifeq +13 -> 200
    //   190: aload_0
    //   191: getfield 15	admg:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   194: getfield 123	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   197: invokevirtual 132	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   200: return
    //   201: astore 6
    //   203: aload 4
    //   205: ldc 84
    //   207: iconst_1
    //   208: invokevirtual 77	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   211: pop
    //   212: aload 4
    //   214: ldc 86
    //   216: aload 5
    //   218: ldc 133
    //   220: invokevirtual 93	android/content/Context:getString	(I)Ljava/lang/String;
    //   223: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   226: pop
    //   227: goto -105 -> 122
    //   230: astore 6
    //   232: goto -110 -> 122
    //   235: astore 6
    //   237: aload 4
    //   239: ldc 84
    //   241: iconst_2
    //   242: invokevirtual 77	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   245: pop
    //   246: aload 4
    //   248: ldc 86
    //   250: aload 5
    //   252: ldc 134
    //   254: invokevirtual 93	android/content/Context:getString	(I)Ljava/lang/String;
    //   257: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   260: pop
    //   261: goto -139 -> 122
    //   264: astore 6
    //   266: goto -144 -> 122
    //   269: aload_0
    //   270: getfield 15	admg:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   273: ldc 136
    //   275: iconst_0
    //   276: aload 4
    //   278: invokevirtual 116	org/json/JSONObject:toString	()Ljava/lang/String;
    //   281: invokevirtual 140	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   284: goto -117 -> 167
    //   287: astore 6
    //   289: aload 4
    //   291: ldc 84
    //   293: iconst_m1
    //   294: invokevirtual 77	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   297: pop
    //   298: aload 4
    //   300: ldc 86
    //   302: aload 5
    //   304: ldc 141
    //   306: invokevirtual 93	android/content/Context:getString	(I)Ljava/lang/String;
    //   309: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   312: pop
    //   313: aload 4
    //   315: ldc 73
    //   317: iload_1
    //   318: invokevirtual 77	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   321: pop
    //   322: aload_0
    //   323: getfield 19	admg:b	Ljava/lang/String;
    //   326: invokestatic 104	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   329: ifne +192 -> 521
    //   332: aload_0
    //   333: getfield 21	admg:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   336: iconst_0
    //   337: iconst_1
    //   338: invokevirtual 110	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   341: ifeq +180 -> 521
    //   344: aload_0
    //   345: getfield 15	admg:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   348: aload_0
    //   349: getfield 19	admg:b	Ljava/lang/String;
    //   352: iconst_1
    //   353: anewarray 112	java/lang/String
    //   356: dup
    //   357: iconst_0
    //   358: aload 4
    //   360: invokevirtual 116	org/json/JSONObject:toString	()Ljava/lang/String;
    //   363: aastore
    //   364: invokevirtual 120	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   367: aload_0
    //   368: getfield 15	admg:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   371: getfield 123	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   374: ifnull -174 -> 200
    //   377: aload_0
    //   378: getfield 15	admg:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   381: getfield 123	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   384: invokevirtual 129	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   387: ifeq -187 -> 200
    //   390: aload_0
    //   391: getfield 15	admg:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   394: getfield 123	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   397: invokevirtual 132	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   400: return
    //   401: iconst_m1
    //   402: istore_2
    //   403: iload_2
    //   404: istore_3
    //   405: aload_0
    //   406: getfield 15	admg:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   409: getfield 123	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   412: ifnull +30 -> 442
    //   415: iload_2
    //   416: istore_3
    //   417: aload_0
    //   418: getfield 15	admg:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   421: getfield 123	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   424: invokevirtual 129	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   427: ifeq +15 -> 442
    //   430: aload_0
    //   431: getfield 15	admg:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   434: getfield 123	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   437: invokevirtual 132	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   440: iload_2
    //   441: istore_3
    //   442: aload 4
    //   444: ldc 84
    //   446: iconst_3
    //   447: invokevirtual 77	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   450: pop
    //   451: aload 4
    //   453: ldc 86
    //   455: aload 5
    //   457: ldc 142
    //   459: invokevirtual 93	android/content/Context:getString	(I)Ljava/lang/String;
    //   462: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   465: pop
    //   466: aload 4
    //   468: ldc 73
    //   470: iload_3
    //   471: invokevirtual 77	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   474: pop
    //   475: aload_0
    //   476: getfield 19	admg:b	Ljava/lang/String;
    //   479: invokestatic 104	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   482: ifne +141 -> 623
    //   485: aload_0
    //   486: getfield 21	admg:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   489: iconst_0
    //   490: iconst_1
    //   491: invokevirtual 110	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   494: ifeq +129 -> 623
    //   497: aload_0
    //   498: getfield 15	admg:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   501: aload_0
    //   502: getfield 19	admg:b	Ljava/lang/String;
    //   505: iconst_1
    //   506: anewarray 112	java/lang/String
    //   509: dup
    //   510: iconst_0
    //   511: aload 4
    //   513: invokevirtual 116	org/json/JSONObject:toString	()Ljava/lang/String;
    //   516: aastore
    //   517: invokevirtual 120	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   520: return
    //   521: aload_0
    //   522: getfield 15	admg:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   525: ldc 136
    //   527: iconst_0
    //   528: aload 4
    //   530: invokevirtual 116	org/json/JSONObject:toString	()Ljava/lang/String;
    //   533: invokevirtual 140	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   536: goto -169 -> 367
    //   539: astore 4
    //   541: aload_0
    //   542: getfield 15	admg:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   545: getfield 123	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   548: ifnull +26 -> 574
    //   551: aload_0
    //   552: getfield 15	admg:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   555: getfield 123	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   558: invokevirtual 129	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   561: ifeq +13 -> 574
    //   564: aload_0
    //   565: getfield 15	admg:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   568: getfield 123	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   571: invokevirtual 132	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   574: aload 4
    //   576: athrow
    //   577: astore 6
    //   579: iconst_m1
    //   580: istore_1
    //   581: iload_1
    //   582: istore_3
    //   583: aload_0
    //   584: getfield 15	admg:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   587: getfield 123	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   590: ifnull -148 -> 442
    //   593: iload_1
    //   594: istore_3
    //   595: aload_0
    //   596: getfield 15	admg:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   599: getfield 123	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   602: invokevirtual 129	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   605: ifeq -163 -> 442
    //   608: aload_0
    //   609: getfield 15	admg:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   612: getfield 123	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   615: invokevirtual 132	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   618: iload_1
    //   619: istore_3
    //   620: goto -178 -> 442
    //   623: aload_0
    //   624: getfield 15	admg:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   627: ldc 136
    //   629: iconst_0
    //   630: aload 4
    //   632: invokevirtual 116	org/json/JSONObject:toString	()Ljava/lang/String;
    //   635: invokevirtual 140	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   638: return
    //   639: astore 5
    //   641: goto -166 -> 475
    //   644: astore 6
    //   646: goto -65 -> 581
    //   649: astore 5
    //   651: goto -329 -> 322
    //   654: astore 6
    //   656: iconst_m1
    //   657: istore_1
    //   658: goto -369 -> 289
    //   661: astore 6
    //   663: goto -541 -> 122
    //   666: astore 7
    //   668: goto -591 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	671	0	this	admg
    //   48	610	1	i	int
    //   50	391	2	j	int
    //   404	216	3	k	int
    //   7	522	4	localJSONObject	org.json.JSONObject
    //   539	92	4	localObject1	Object
    //   12	444	5	localBaseApplication	com.tencent.qphone.base.util.BaseApplication
    //   639	1	5	localJSONException1	org.json.JSONException
    //   649	1	5	localJSONException2	org.json.JSONException
    //   29	88	6	localObject2	Object
    //   201	1	6	localIOException1	java.io.IOException
    //   230	1	6	localJSONException3	org.json.JSONException
    //   235	1	6	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   264	1	6	localJSONException4	org.json.JSONException
    //   287	1	6	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   577	1	6	localIOException2	java.io.IOException
    //   644	1	6	localIOException3	java.io.IOException
    //   654	1	6	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   661	1	6	localJSONException5	org.json.JSONException
    //   666	1	7	localJSONException6	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   77	88	201	java/io/IOException
    //   88	122	201	java/io/IOException
    //   203	227	230	org/json/JSONException
    //   77	88	235	java/lang/IllegalArgumentException
    //   88	122	235	java/lang/IllegalArgumentException
    //   237	261	264	org/json/JSONException
    //   58	68	287	java/lang/OutOfMemoryError
    //   68	77	287	java/lang/OutOfMemoryError
    //   77	88	287	java/lang/OutOfMemoryError
    //   88	122	287	java/lang/OutOfMemoryError
    //   122	167	287	java/lang/OutOfMemoryError
    //   203	227	287	java/lang/OutOfMemoryError
    //   237	261	287	java/lang/OutOfMemoryError
    //   269	284	287	java/lang/OutOfMemoryError
    //   14	31	539	finally
    //   36	49	539	finally
    //   58	68	539	finally
    //   68	77	539	finally
    //   77	88	539	finally
    //   88	122	539	finally
    //   122	167	539	finally
    //   203	227	539	finally
    //   237	261	539	finally
    //   269	284	539	finally
    //   289	322	539	finally
    //   322	367	539	finally
    //   521	536	539	finally
    //   14	31	577	java/io/IOException
    //   36	49	577	java/io/IOException
    //   442	475	639	org/json/JSONException
    //   58	68	644	java/io/IOException
    //   68	77	644	java/io/IOException
    //   122	167	644	java/io/IOException
    //   203	227	644	java/io/IOException
    //   237	261	644	java/io/IOException
    //   269	284	644	java/io/IOException
    //   289	322	649	org/json/JSONException
    //   14	31	654	java/lang/OutOfMemoryError
    //   36	49	654	java/lang/OutOfMemoryError
    //   88	122	661	org/json/JSONException
    //   68	77	666	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     admg
 * JD-Core Version:    0.7.0.1
 */