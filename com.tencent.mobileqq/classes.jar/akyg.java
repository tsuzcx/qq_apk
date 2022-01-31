import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class akyg
{
  private ArrayList<akyh> a = new ArrayList();
  
  /* Error */
  public static akyg a(String paramString)
  {
    // Byte code:
    //   0: new 26	java/io/File
    //   3: dup
    //   4: new 28	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   11: aload_0
    //   12: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: ldc 35
    //   17: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore_0
    //   27: aload_0
    //   28: invokevirtual 46	java/io/File:exists	()Z
    //   31: ifeq +419 -> 450
    //   34: new 48	java/io/FileInputStream
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 51	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   42: astore_0
    //   43: aload_0
    //   44: invokevirtual 55	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   47: astore_1
    //   48: aload_1
    //   49: getstatic 61	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   52: lconst_0
    //   53: aload_1
    //   54: invokevirtual 67	java/nio/channels/FileChannel:size	()J
    //   57: invokevirtual 71	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   60: astore_2
    //   61: invokestatic 77	java/nio/charset/Charset:defaultCharset	()Ljava/nio/charset/Charset;
    //   64: aload_2
    //   65: invokevirtual 81	java/nio/charset/Charset:decode	(Ljava/nio/ByteBuffer;)Ljava/nio/CharBuffer;
    //   68: invokevirtual 84	java/nio/CharBuffer:toString	()Ljava/lang/String;
    //   71: astore_2
    //   72: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +28 -> 103
    //   78: ldc 91
    //   80: iconst_2
    //   81: new 28	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   88: ldc 93
    //   90: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_2
    //   94: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: aload_2
    //   104: invokestatic 100	akyg:b	(Ljava/lang/String;)Lakyg;
    //   107: astore_2
    //   108: aload_0
    //   109: ifnull +7 -> 116
    //   112: aload_0
    //   113: invokevirtual 103	java/io/FileInputStream:close	()V
    //   116: aload_1
    //   117: ifnull +7 -> 124
    //   120: aload_1
    //   121: invokevirtual 104	java/nio/channels/FileChannel:close	()V
    //   124: aload_2
    //   125: areturn
    //   126: astore_0
    //   127: invokestatic 107	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   130: ifeq +12 -> 142
    //   133: ldc 91
    //   135: iconst_0
    //   136: ldc 109
    //   138: aload_0
    //   139: invokestatic 113	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   142: aload_2
    //   143: areturn
    //   144: astore_1
    //   145: aconst_null
    //   146: astore_2
    //   147: aconst_null
    //   148: astore_0
    //   149: invokestatic 107	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   152: ifeq +12 -> 164
    //   155: ldc 91
    //   157: iconst_0
    //   158: ldc 115
    //   160: aload_1
    //   161: invokestatic 113	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   164: aload_0
    //   165: ifnull +7 -> 172
    //   168: aload_0
    //   169: invokevirtual 103	java/io/FileInputStream:close	()V
    //   172: aload_2
    //   173: ifnull +7 -> 180
    //   176: aload_2
    //   177: invokevirtual 104	java/nio/channels/FileChannel:close	()V
    //   180: aconst_null
    //   181: areturn
    //   182: astore_0
    //   183: invokestatic 107	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   186: ifeq +12 -> 198
    //   189: ldc 91
    //   191: iconst_0
    //   192: ldc 109
    //   194: aload_0
    //   195: invokestatic 113	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   198: aconst_null
    //   199: areturn
    //   200: astore_3
    //   201: aconst_null
    //   202: astore_1
    //   203: aconst_null
    //   204: astore 4
    //   206: aload_1
    //   207: astore_2
    //   208: aload 4
    //   210: astore_0
    //   211: invokestatic 107	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   214: ifeq +17 -> 231
    //   217: aload_1
    //   218: astore_2
    //   219: aload 4
    //   221: astore_0
    //   222: ldc 91
    //   224: iconst_0
    //   225: ldc 117
    //   227: aload_3
    //   228: invokestatic 113	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   231: aload 4
    //   233: ifnull +8 -> 241
    //   236: aload 4
    //   238: invokevirtual 103	java/io/FileInputStream:close	()V
    //   241: aload_1
    //   242: ifnull +7 -> 249
    //   245: aload_1
    //   246: invokevirtual 104	java/nio/channels/FileChannel:close	()V
    //   249: aconst_null
    //   250: areturn
    //   251: astore_0
    //   252: invokestatic 107	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   255: ifeq +12 -> 267
    //   258: ldc 91
    //   260: iconst_0
    //   261: ldc 109
    //   263: aload_0
    //   264: invokestatic 113	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   267: aconst_null
    //   268: areturn
    //   269: astore_3
    //   270: aconst_null
    //   271: astore_1
    //   272: aconst_null
    //   273: astore 4
    //   275: aload_1
    //   276: astore_2
    //   277: aload 4
    //   279: astore_0
    //   280: invokestatic 107	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   283: ifeq +17 -> 300
    //   286: aload_1
    //   287: astore_2
    //   288: aload 4
    //   290: astore_0
    //   291: ldc 91
    //   293: iconst_0
    //   294: ldc 119
    //   296: aload_3
    //   297: invokestatic 113	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   300: aload 4
    //   302: ifnull +8 -> 310
    //   305: aload 4
    //   307: invokevirtual 103	java/io/FileInputStream:close	()V
    //   310: aload_1
    //   311: ifnull +7 -> 318
    //   314: aload_1
    //   315: invokevirtual 104	java/nio/channels/FileChannel:close	()V
    //   318: aconst_null
    //   319: areturn
    //   320: astore_0
    //   321: invokestatic 107	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   324: ifeq +12 -> 336
    //   327: ldc 91
    //   329: iconst_0
    //   330: ldc 109
    //   332: aload_0
    //   333: invokestatic 113	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   336: aconst_null
    //   337: areturn
    //   338: astore_1
    //   339: aconst_null
    //   340: astore_2
    //   341: aconst_null
    //   342: astore_0
    //   343: aload_0
    //   344: ifnull +7 -> 351
    //   347: aload_0
    //   348: invokevirtual 103	java/io/FileInputStream:close	()V
    //   351: aload_2
    //   352: ifnull +7 -> 359
    //   355: aload_2
    //   356: invokevirtual 104	java/nio/channels/FileChannel:close	()V
    //   359: aload_1
    //   360: athrow
    //   361: astore_0
    //   362: invokestatic 107	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   365: ifeq -6 -> 359
    //   368: ldc 91
    //   370: iconst_0
    //   371: ldc 109
    //   373: aload_0
    //   374: invokestatic 113	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   377: goto -18 -> 359
    //   380: astore_1
    //   381: aconst_null
    //   382: astore_2
    //   383: goto -40 -> 343
    //   386: astore_3
    //   387: aload_1
    //   388: astore_2
    //   389: aload_3
    //   390: astore_1
    //   391: goto -48 -> 343
    //   394: astore_1
    //   395: goto -52 -> 343
    //   398: astore_1
    //   399: goto -56 -> 343
    //   402: astore_3
    //   403: aconst_null
    //   404: astore_1
    //   405: aload_0
    //   406: astore 4
    //   408: goto -133 -> 275
    //   411: astore_3
    //   412: aload_0
    //   413: astore 4
    //   415: goto -140 -> 275
    //   418: astore_3
    //   419: aconst_null
    //   420: astore_1
    //   421: aload_0
    //   422: astore 4
    //   424: goto -218 -> 206
    //   427: astore_3
    //   428: aload_0
    //   429: astore 4
    //   431: goto -225 -> 206
    //   434: astore_1
    //   435: aconst_null
    //   436: astore_2
    //   437: goto -288 -> 149
    //   440: astore_2
    //   441: aload_1
    //   442: astore_3
    //   443: aload_2
    //   444: astore_1
    //   445: aload_3
    //   446: astore_2
    //   447: goto -298 -> 149
    //   450: aconst_null
    //   451: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	452	0	paramString	String
    //   47	74	1	localFileChannel	java.nio.channels.FileChannel
    //   144	17	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   202	113	1	localObject1	Object
    //   338	22	1	localObject2	Object
    //   380	8	1	localObject3	Object
    //   390	1	1	localObject4	Object
    //   394	1	1	localObject5	Object
    //   398	1	1	localObject6	Object
    //   404	17	1	localObject7	Object
    //   434	8	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   444	1	1	localObject8	Object
    //   60	377	2	localObject9	Object
    //   440	4	2	localFileNotFoundException3	java.io.FileNotFoundException
    //   446	1	2	localObject10	Object
    //   200	28	3	localIOException1	java.io.IOException
    //   269	28	3	localException1	Exception
    //   386	4	3	localObject11	Object
    //   402	1	3	localException2	Exception
    //   411	1	3	localException3	Exception
    //   418	1	3	localIOException2	java.io.IOException
    //   427	1	3	localIOException3	java.io.IOException
    //   442	4	3	localFileNotFoundException4	java.io.FileNotFoundException
    //   204	226	4	str	String
    // Exception table:
    //   from	to	target	type
    //   112	116	126	java/lang/Exception
    //   120	124	126	java/lang/Exception
    //   34	43	144	java/io/FileNotFoundException
    //   168	172	182	java/lang/Exception
    //   176	180	182	java/lang/Exception
    //   34	43	200	java/io/IOException
    //   236	241	251	java/lang/Exception
    //   245	249	251	java/lang/Exception
    //   34	43	269	java/lang/Exception
    //   305	310	320	java/lang/Exception
    //   314	318	320	java/lang/Exception
    //   34	43	338	finally
    //   347	351	361	java/lang/Exception
    //   355	359	361	java/lang/Exception
    //   43	48	380	finally
    //   48	103	386	finally
    //   103	108	386	finally
    //   149	164	394	finally
    //   211	217	398	finally
    //   222	231	398	finally
    //   280	286	398	finally
    //   291	300	398	finally
    //   43	48	402	java/lang/Exception
    //   48	103	411	java/lang/Exception
    //   103	108	411	java/lang/Exception
    //   43	48	418	java/io/IOException
    //   48	103	427	java/io/IOException
    //   103	108	427	java/io/IOException
    //   43	48	434	java/io/FileNotFoundException
    //   48	103	440	java/io/FileNotFoundException
    //   103	108	440	java/io/FileNotFoundException
  }
  
  public static akyg b(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      akyg localakyg = new akyg();
      JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("360senceinfo");
      paramString = localakyg;
      if (((JSONObject)localObject).has("360senceinfo"))
      {
        int j = localJSONArray.length();
        paramString = localakyg;
        if (j > 0)
        {
          int i = 0;
          for (;;)
          {
            paramString = localakyg;
            if (i >= j) {
              break;
            }
            paramString = localJSONArray.getJSONObject(i);
            localObject = new akyh();
            if (paramString.has("text")) {
              ((akyh)localObject).jdField_a_of_type_JavaLangString = paramString.optString("text");
            }
            if (paramString.has("starttime")) {
              ((akyh)localObject).jdField_a_of_type_Long = paramString.optLong("starttime");
            }
            if (paramString.has("endtime")) {
              ((akyh)localObject).b = paramString.optLong("endtime");
            }
            localakyg.a.add(localObject);
            if (QLog.isColorLevel()) {
              QLog.d("ARTransferDoorVideoInfo", 2, "ARTransferDoorVideoInfo parseJson index: " + i + "," + ((akyh)localObject).toString());
            }
            i += 1;
          }
        }
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.d("ARTransferDoorVideoInfo", 1, String.format("parseJson, Exception\n%s", new Object[] { paramString }));
      paramString = null;
    }
  }
  
  public akyh a(long paramLong)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      akyh localakyh = (akyh)localIterator.next();
      long l = localakyh.jdField_a_of_type_Long;
      if ((paramLong < localakyh.b * 1000L) && (paramLong >= l * 1000L)) {
        return localakyh;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akyg
 * JD-Core Version:    0.7.0.1
 */