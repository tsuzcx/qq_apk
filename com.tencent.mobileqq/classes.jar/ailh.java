import android.util.LruCache;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.util.HashMap;

public class ailh
{
  public static ailh a;
  private static LRULinkedHashMap<String, LruCache<String, ailj>> jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(2);
  private static HashMap<String, aizl> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static ailh a()
  {
    if (jdField_a_of_type_Ailh == null) {}
    try
    {
      if (jdField_a_of_type_Ailh == null) {
        jdField_a_of_type_Ailh = new ailh();
      }
      return jdField_a_of_type_Ailh;
    }
    finally {}
  }
  
  public static String a(String paramString)
  {
    return ajed.aU + ".apollo/game/" + String.valueOf(paramString);
  }
  
  /* Error */
  public ailj a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +673 -> 677
    //   7: aload_2
    //   8: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +666 -> 677
    //   14: getstatic 26	ailh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   17: ifnonnull +13 -> 30
    //   20: new 22	java/util/HashMap
    //   23: dup
    //   24: invokespecial 24	java/util/HashMap:<init>	()V
    //   27: putstatic 26	ailh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   30: aload_2
    //   31: invokestatic 73	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   34: istore_3
    //   35: iload_3
    //   36: invokestatic 78	aizl:a	(I)Z
    //   39: ifne +654 -> 693
    //   42: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +11 -> 56
    //   48: ldc 86
    //   50: iconst_2
    //   51: ldc 88
    //   53: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: iconst_0
    //   57: istore_3
    //   58: iload_3
    //   59: ifeq +62 -> 121
    //   62: getstatic 26	ailh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   65: astore 5
    //   67: aload 5
    //   69: monitorenter
    //   70: aload_2
    //   71: invokestatic 73	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   74: istore 4
    //   76: getstatic 26	ailh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   79: aload_2
    //   80: invokevirtual 96	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   83: checkcast 75	aizl
    //   86: ifnonnull +32 -> 118
    //   89: new 75	aizl
    //   92: dup
    //   93: iload 4
    //   95: invokespecial 97	aizl:<init>	(I)V
    //   98: astore 6
    //   100: aload 6
    //   102: invokevirtual 100	aizl:b	()Z
    //   105: ifeq +251 -> 356
    //   108: getstatic 26	ailh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   111: aload_2
    //   112: aload 6
    //   114: invokevirtual 104	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   117: pop
    //   118: aload 5
    //   120: monitorexit
    //   121: aload_1
    //   122: aload_2
    //   123: invokestatic 73	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   126: aconst_null
    //   127: iconst_1
    //   128: invokestatic 109	ailn:a	(Ljava/lang/String;ILjava/lang/String;Z)Ljava/lang/String;
    //   131: astore 7
    //   133: aload 7
    //   135: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   138: ifne +539 -> 677
    //   141: getstatic 20	ailh:jdField_a_of_type_ComTencentUtilLRULinkedHashMap	Lcom/tencent/util/LRULinkedHashMap;
    //   144: aload_2
    //   145: invokevirtual 110	com/tencent/util/LRULinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   148: checkcast 112	android/util/LruCache
    //   151: astore 5
    //   153: aload 5
    //   155: ifnonnull +535 -> 690
    //   158: new 114	aili
    //   161: dup
    //   162: aload_0
    //   163: ldc 115
    //   165: invokespecial 118	aili:<init>	(Lailh;I)V
    //   168: astore 5
    //   170: getstatic 20	ailh:jdField_a_of_type_ComTencentUtilLRULinkedHashMap	Lcom/tencent/util/LRULinkedHashMap;
    //   173: aload_2
    //   174: aload 5
    //   176: invokevirtual 119	com/tencent/util/LRULinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   179: pop
    //   180: aload 5
    //   182: aload 7
    //   184: invokevirtual 120	android/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   187: checkcast 122	ailj
    //   190: astore_1
    //   191: aload_1
    //   192: astore 6
    //   194: aload_1
    //   195: ifnonnull +139 -> 334
    //   198: iload_3
    //   199: ifeq +366 -> 565
    //   202: getstatic 26	ailh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   205: astore 8
    //   207: aload 8
    //   209: monitorenter
    //   210: getstatic 26	ailh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   213: aload_2
    //   214: invokevirtual 96	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   217: checkcast 75	aizl
    //   220: astore 6
    //   222: aload_2
    //   223: invokestatic 124	ailh:a	(Ljava/lang/String;)Ljava/lang/String;
    //   226: astore_2
    //   227: aload 7
    //   229: new 35	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   236: aload_2
    //   237: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: ldc 126
    //   242: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: ldc 128
    //   250: invokevirtual 132	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   253: astore_2
    //   254: aload 6
    //   256: ifnull +23 -> 279
    //   259: aload 6
    //   261: aload_2
    //   262: invokevirtual 135	aizl:a	(Ljava/lang/String;)Z
    //   265: ifeq +14 -> 279
    //   268: aload 6
    //   270: aload 7
    //   272: aload_2
    //   273: invokevirtual 138	aizl:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   276: ifne +116 -> 392
    //   279: ldc 86
    //   281: iconst_1
    //   282: new 35	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   289: ldc 140
    //   291: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: aload 7
    //   296: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: ldc 142
    //   301: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: aload_2
    //   305: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: ldc 142
    //   310: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokestatic 148	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   316: invokevirtual 151	java/lang/Thread:getName	()Ljava/lang/String;
    //   319: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokestatic 154	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   328: aload 8
    //   330: monitorexit
    //   331: aconst_null
    //   332: astore 6
    //   334: aload 6
    //   336: areturn
    //   337: astore 5
    //   339: ldc 86
    //   341: iconst_1
    //   342: aload 5
    //   344: iconst_0
    //   345: anewarray 4	java/lang/Object
    //   348: invokestatic 157	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   351: iconst_0
    //   352: istore_3
    //   353: goto -318 -> 35
    //   356: ldc 86
    //   358: iconst_1
    //   359: ldc 159
    //   361: invokestatic 154	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   364: aload 5
    //   366: monitorexit
    //   367: aconst_null
    //   368: areturn
    //   369: astore 6
    //   371: ldc 86
    //   373: iconst_1
    //   374: aload 6
    //   376: iconst_0
    //   377: anewarray 4	java/lang/Object
    //   380: invokestatic 157	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   383: goto -265 -> 118
    //   386: astore_1
    //   387: aload 5
    //   389: monitorexit
    //   390: aload_1
    //   391: athrow
    //   392: new 122	ailj
    //   395: dup
    //   396: invokespecial 160	ailj:<init>	()V
    //   399: astore 6
    //   401: aload 6
    //   403: astore_2
    //   404: aload 6
    //   406: aload 7
    //   408: putfield 162	ailj:b	Ljava/lang/String;
    //   411: ldc 164
    //   413: astore_1
    //   414: aload 6
    //   416: astore_2
    //   417: aload 7
    //   419: ldc 166
    //   421: invokevirtual 169	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   424: ifeq +45 -> 469
    //   427: ldc 171
    //   429: astore_1
    //   430: aload 6
    //   432: astore_2
    //   433: aload 6
    //   435: aload_1
    //   436: putfield 173	ailj:a	Ljava/lang/String;
    //   439: aload 6
    //   441: astore_2
    //   442: aload 6
    //   444: invokevirtual 175	ailj:a	()V
    //   447: aload 6
    //   449: astore_2
    //   450: aload 5
    //   452: aload 7
    //   454: aload 6
    //   456: invokevirtual 176	android/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   459: pop
    //   460: aload 6
    //   462: astore_2
    //   463: aload 8
    //   465: monitorexit
    //   466: aload 6
    //   468: areturn
    //   469: aload 6
    //   471: astore_2
    //   472: aload 7
    //   474: ldc 178
    //   476: invokevirtual 169	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   479: ifeq +9 -> 488
    //   482: ldc 180
    //   484: astore_1
    //   485: goto -55 -> 430
    //   488: aload 6
    //   490: astore_2
    //   491: aload 7
    //   493: ldc 182
    //   495: invokevirtual 169	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   498: ifne +200 -> 698
    //   501: aload 6
    //   503: astore_2
    //   504: aload 7
    //   506: ldc 184
    //   508: invokevirtual 169	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   511: ifne +187 -> 698
    //   514: aload 6
    //   516: astore_2
    //   517: aload 7
    //   519: ldc 186
    //   521: invokevirtual 169	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   524: ifne +174 -> 698
    //   527: aload 6
    //   529: astore_2
    //   530: aload 7
    //   532: ldc 188
    //   534: invokevirtual 169	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   537: ifeq -107 -> 430
    //   540: goto +158 -> 698
    //   543: aload_1
    //   544: astore_2
    //   545: aload 8
    //   547: monitorexit
    //   548: aload 5
    //   550: athrow
    //   551: astore_2
    //   552: ldc 86
    //   554: iconst_1
    //   555: aload_2
    //   556: iconst_0
    //   557: anewarray 4	java/lang/Object
    //   560: invokestatic 157	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   563: aload_1
    //   564: areturn
    //   565: new 122	ailj
    //   568: dup
    //   569: invokespecial 160	ailj:<init>	()V
    //   572: astore_2
    //   573: aload_2
    //   574: aload 7
    //   576: putfield 162	ailj:b	Ljava/lang/String;
    //   579: ldc 164
    //   581: astore_1
    //   582: aload 7
    //   584: ldc 166
    //   586: invokevirtual 169	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   589: ifeq +26 -> 615
    //   592: ldc 171
    //   594: astore_1
    //   595: aload_2
    //   596: aload_1
    //   597: putfield 173	ailj:a	Ljava/lang/String;
    //   600: aload_2
    //   601: invokevirtual 175	ailj:a	()V
    //   604: aload 5
    //   606: aload 7
    //   608: aload_2
    //   609: invokevirtual 176	android/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   612: pop
    //   613: aload_2
    //   614: areturn
    //   615: aload 7
    //   617: ldc 178
    //   619: invokevirtual 169	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   622: ifeq +9 -> 631
    //   625: ldc 180
    //   627: astore_1
    //   628: goto -33 -> 595
    //   631: aload 7
    //   633: ldc 182
    //   635: invokevirtual 169	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   638: ifne +33 -> 671
    //   641: aload 7
    //   643: ldc 184
    //   645: invokevirtual 169	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   648: ifne +23 -> 671
    //   651: aload 7
    //   653: ldc 186
    //   655: invokevirtual 169	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   658: ifne +13 -> 671
    //   661: aload 7
    //   663: ldc 188
    //   665: invokevirtual 169	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   668: ifeq -73 -> 595
    //   671: ldc 190
    //   673: astore_1
    //   674: goto -79 -> 595
    //   677: aconst_null
    //   678: areturn
    //   679: astore_2
    //   680: goto -128 -> 552
    //   683: astore 5
    //   685: aload_2
    //   686: astore_1
    //   687: goto -144 -> 543
    //   690: goto -510 -> 180
    //   693: iconst_1
    //   694: istore_3
    //   695: goto -637 -> 58
    //   698: ldc 190
    //   700: astore_1
    //   701: goto -271 -> 430
    //   704: astore 5
    //   706: goto -163 -> 543
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	709	0	this	ailh
    //   0	709	1	paramString1	String
    //   0	709	2	paramString2	String
    //   34	661	3	i	int
    //   74	20	4	j	int
    //   65	116	5	localObject1	Object
    //   337	268	5	localThrowable1	Throwable
    //   683	1	5	localObject2	Object
    //   704	1	5	localObject3	Object
    //   98	237	6	localObject4	Object
    //   369	6	6	localThrowable2	Throwable
    //   399	129	6	localailj	ailj
    //   131	531	7	str	String
    // Exception table:
    //   from	to	target	type
    //   30	35	337	java/lang/Throwable
    //   70	118	369	java/lang/Throwable
    //   356	364	369	java/lang/Throwable
    //   70	118	386	finally
    //   118	121	386	finally
    //   356	364	386	finally
    //   364	367	386	finally
    //   371	383	386	finally
    //   387	390	386	finally
    //   548	551	551	java/lang/Throwable
    //   202	210	679	java/lang/Throwable
    //   404	411	683	finally
    //   417	427	683	finally
    //   433	439	683	finally
    //   442	447	683	finally
    //   450	460	683	finally
    //   463	466	683	finally
    //   472	482	683	finally
    //   491	501	683	finally
    //   504	514	683	finally
    //   517	527	683	finally
    //   530	540	683	finally
    //   545	548	683	finally
    //   210	254	704	finally
    //   259	279	704	finally
    //   279	331	704	finally
    //   392	401	704	finally
  }
  
  public void a()
  {
    try
    {
      if (jdField_a_of_type_Ailh != null) {
        jdField_a_of_type_Ailh = null;
      }
      if (jdField_a_of_type_ComTencentUtilLRULinkedHashMap != null) {
        jdField_a_of_type_ComTencentUtilLRULinkedHashMap.clear();
      }
      if (jdField_a_of_type_JavaUtilHashMap != null)
      {
        jdField_a_of_type_JavaUtilHashMap.clear();
        jdField_a_of_type_JavaUtilHashMap = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameResManager", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ailh
 * JD-Core Version:    0.7.0.1
 */