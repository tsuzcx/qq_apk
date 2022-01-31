import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class ahtd
{
  private static final String a = EditLocalVideoActivity.a + File.separator + "silent.m4a";
  
  private static String a(long paramLong)
  {
    return String.format(Locale.getDefault(), "%.3f", new Object[] { Float.valueOf((float)paramLong / 1000.0F) });
  }
  
  public static String a(long paramLong1, long paramLong2, String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (new File(paramString).exists())
      {
        str = EditLocalVideoActivity.a + File.separator + "clipped." + a(paramString, "m4a");
        int i = bhpo.a(new String[] { "-y", "-i", paramString, "-ss", a(paramLong1), "-t", a(paramLong2), "-c", "copy", str });
        if (i == 0) {
          break label182;
        }
        QZLog.e("EditLocalVideoMusicMixH", 2, new Object[] { "ffmpegClipAudio: FFmpeg run failed with " + i });
        str = null;
      }
    }
    return str;
    label182:
    return str;
  }
  
  /* Error */
  public static String a(long paramLong1, String paramString, long paramLong2)
  {
    // Byte code:
    //   0: new 10	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   7: getstatic 17	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:a	Ljava/lang/String;
    //   10: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: getstatic 26	java/io/File:separator	Ljava/lang/String;
    //   16: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc 116
    //   21: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: astore 10
    //   29: lload_0
    //   30: lload_3
    //   31: ldiv
    //   32: lconst_1
    //   33: ladd
    //   34: l2i
    //   35: istore 6
    //   37: new 118	java/io/BufferedWriter
    //   40: dup
    //   41: new 120	java/io/OutputStreamWriter
    //   44: dup
    //   45: new 122	java/io/FileOutputStream
    //   48: dup
    //   49: aload 10
    //   51: invokespecial 123	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   54: invokespecial 126	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   57: invokespecial 129	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   60: astore 8
    //   62: iconst_0
    //   63: istore 5
    //   65: iload 5
    //   67: iload 6
    //   69: if_icmpge +64 -> 133
    //   72: aload 8
    //   74: astore 7
    //   76: aload 8
    //   78: new 10	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   85: ldc 131
    //   87: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: new 23	java/io/File
    //   93: dup
    //   94: aload_2
    //   95: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   98: invokevirtual 134	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   101: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc 136
    //   106: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokevirtual 139	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   115: aload 8
    //   117: astore 7
    //   119: aload 8
    //   121: invokevirtual 142	java/io/BufferedWriter:newLine	()V
    //   124: iload 5
    //   126: iconst_1
    //   127: iadd
    //   128: istore 5
    //   130: goto -65 -> 65
    //   133: aload 8
    //   135: astore 7
    //   137: aload 8
    //   139: invokevirtual 145	java/io/BufferedWriter:flush	()V
    //   142: aload 8
    //   144: ifnull +8 -> 152
    //   147: aload 8
    //   149: invokevirtual 148	java/io/BufferedWriter:close	()V
    //   152: bipush 12
    //   154: anewarray 52	java/lang/String
    //   157: dup
    //   158: iconst_0
    //   159: ldc 79
    //   161: aastore
    //   162: dup
    //   163: iconst_1
    //   164: ldc 150
    //   166: aastore
    //   167: dup
    //   168: iconst_2
    //   169: ldc 152
    //   171: aastore
    //   172: dup
    //   173: iconst_3
    //   174: ldc 154
    //   176: aastore
    //   177: dup
    //   178: iconst_4
    //   179: ldc 156
    //   181: aastore
    //   182: dup
    //   183: iconst_5
    //   184: ldc 81
    //   186: aastore
    //   187: dup
    //   188: bipush 6
    //   190: aload 10
    //   192: aastore
    //   193: dup
    //   194: bipush 7
    //   196: ldc 87
    //   198: aastore
    //   199: dup
    //   200: bipush 8
    //   202: lload_0
    //   203: invokestatic 85	ahtd:a	(J)Ljava/lang/String;
    //   206: aastore
    //   207: dup
    //   208: bipush 9
    //   210: ldc 89
    //   212: aastore
    //   213: dup
    //   214: bipush 10
    //   216: ldc 91
    //   218: aastore
    //   219: dup
    //   220: bipush 11
    //   222: getstatic 33	ahtd:a	Ljava/lang/String;
    //   225: aastore
    //   226: invokestatic 96	bhpo:a	([Ljava/lang/String;)I
    //   229: istore 5
    //   231: new 23	java/io/File
    //   234: dup
    //   235: aload 10
    //   237: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   240: invokevirtual 159	java/io/File:delete	()Z
    //   243: ifeq +29 -> 272
    //   246: ldc 98
    //   248: iconst_2
    //   249: new 10	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   256: ldc 161
    //   258: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload 10
    //   263: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 165	cooperation/qzone/util/QZLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: iload 5
    //   274: ifeq +131 -> 405
    //   277: ldc 98
    //   279: iconst_2
    //   280: iconst_1
    //   281: anewarray 4	java/lang/Object
    //   284: dup
    //   285: iconst_0
    //   286: new 10	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   293: ldc 167
    //   295: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: iload 5
    //   300: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   303: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: aastore
    //   307: invokestatic 109	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   310: aconst_null
    //   311: areturn
    //   312: astore_2
    //   313: ldc 98
    //   315: iconst_2
    //   316: aload_2
    //   317: iconst_0
    //   318: anewarray 4	java/lang/Object
    //   321: invokestatic 170	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   324: goto -172 -> 152
    //   327: astore 9
    //   329: aconst_null
    //   330: astore_2
    //   331: aload_2
    //   332: astore 7
    //   334: ldc 98
    //   336: iconst_2
    //   337: aload 9
    //   339: iconst_0
    //   340: anewarray 4	java/lang/Object
    //   343: invokestatic 170	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   346: aload_2
    //   347: ifnull -195 -> 152
    //   350: aload_2
    //   351: invokevirtual 148	java/io/BufferedWriter:close	()V
    //   354: goto -202 -> 152
    //   357: astore_2
    //   358: ldc 98
    //   360: iconst_2
    //   361: aload_2
    //   362: iconst_0
    //   363: anewarray 4	java/lang/Object
    //   366: invokestatic 170	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   369: goto -217 -> 152
    //   372: astore_2
    //   373: aconst_null
    //   374: astore 7
    //   376: aload 7
    //   378: ifnull +8 -> 386
    //   381: aload 7
    //   383: invokevirtual 148	java/io/BufferedWriter:close	()V
    //   386: aload_2
    //   387: athrow
    //   388: astore 7
    //   390: ldc 98
    //   392: iconst_2
    //   393: aload 7
    //   395: iconst_0
    //   396: anewarray 4	java/lang/Object
    //   399: invokestatic 170	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   402: goto -16 -> 386
    //   405: getstatic 33	ahtd:a	Ljava/lang/String;
    //   408: areturn
    //   409: astore_2
    //   410: goto -34 -> 376
    //   413: astore 9
    //   415: aload 8
    //   417: astore_2
    //   418: goto -87 -> 331
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	421	0	paramLong1	long
    //   0	421	2	paramString	String
    //   0	421	3	paramLong2	long
    //   63	236	5	i	int
    //   35	35	6	j	int
    //   74	308	7	localObject	Object
    //   388	6	7	localIOException	java.io.IOException
    //   60	356	8	localBufferedWriter	java.io.BufferedWriter
    //   327	11	9	localException1	java.lang.Exception
    //   413	1	9	localException2	java.lang.Exception
    //   27	235	10	str	String
    // Exception table:
    //   from	to	target	type
    //   147	152	312	java/io/IOException
    //   37	62	327	java/lang/Exception
    //   350	354	357	java/io/IOException
    //   37	62	372	finally
    //   381	386	388	java/io/IOException
    //   76	115	409	finally
    //   119	124	409	finally
    //   137	142	409	finally
    //   334	346	409	finally
    //   76	115	413	java/lang/Exception
    //   119	124	413	java/lang/Exception
    //   137	142	413	java/lang/Exception
  }
  
  public static String a(String paramString)
  {
    String str;
    if ((!TextUtils.isEmpty(paramString)) && (new File(paramString).exists()))
    {
      str = EditLocalVideoActivity.a + File.separator + UUID.randomUUID().toString() + "_an." + a(paramString, "mp4");
      int i = bhpo.a(new String[] { "-y", "-i", paramString, "-an", "-c", "copy", str });
      if (i != 0) {
        QZLog.e("EditLocalVideoMusicMixH", 2, new Object[] { "ffmpegRemoveAudioTrack: FFmpeg run failed with code " + i });
      }
    }
    else
    {
      return paramString;
    }
    return str;
  }
  
  public static String a(String paramString, int paramInt)
  {
    Object localObject = paramString;
    if (paramInt >= 2)
    {
      localObject = new ArrayList();
      int i = 0;
      while (i < paramInt)
      {
        ((List)localObject).add(paramString);
        i += 1;
      }
      localObject = a((List)localObject);
    }
    return localObject;
  }
  
  @NonNull
  private static String a(String paramString1, String paramString2)
  {
    int i = paramString1.lastIndexOf('.');
    if (i > 0) {
      paramString2 = paramString1.substring(i + 1);
    }
    return paramString2;
  }
  
  public static String a(String paramString1, String paramString2, long paramLong)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      String str = EditLocalVideoActivity.a + File.separator + "merged_" + UUID.randomUUID().toString() + ".mp4";
      String[] arrayOfString = new String[14];
      arrayOfString[0] = "-y";
      arrayOfString[1] = "-i";
      arrayOfString[2] = paramString1;
      arrayOfString[3] = "-i";
      arrayOfString[4] = paramString2;
      arrayOfString[5] = "-t";
      arrayOfString[6] = a(paramLong);
      arrayOfString[7] = "-codec";
      arrayOfString[8] = "copy";
      arrayOfString[9] = "-map";
      arrayOfString[10] = "0:v:0";
      arrayOfString[11] = "-map";
      arrayOfString[12] = "1:a";
      arrayOfString[13] = str;
      QZLog.d("EditLocalVideoMusicMixH", 2, "ffmpegMergeVideoAndAudio: " + Arrays.toString(arrayOfString));
      int i = bhpo.a(arrayOfString);
      if (i != 0)
      {
        QZLog.e("EditLocalVideoMusicMixH", 2, new Object[] { "ffmpegMergeVideoAndAudio: FFmpeg run failed with code " + i });
        return null;
      }
      return str;
    }
    QZLog.e("EditLocalVideoMusicMixH", 2, new Object[] { "ffmpegMergeVideoAndAudio: input video/audio is empty " + paramString1 + " " + paramString2 });
    return null;
  }
  
  /* Error */
  public static String a(List<String> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +423 -> 424
    //   4: aload_0
    //   5: invokeinterface 239 1 0
    //   10: iconst_1
    //   11: if_icmpne +16 -> 27
    //   14: aload_0
    //   15: iconst_0
    //   16: invokeinterface 243 2 0
    //   21: checkcast 52	java/lang/String
    //   24: astore_0
    //   25: aload_0
    //   26: areturn
    //   27: new 10	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   34: getstatic 17	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:a	Ljava/lang/String;
    //   37: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: getstatic 26	java/io/File:separator	Ljava/lang/String;
    //   43: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc 245
    //   48: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: astore 4
    //   56: new 118	java/io/BufferedWriter
    //   59: dup
    //   60: new 120	java/io/OutputStreamWriter
    //   63: dup
    //   64: new 122	java/io/FileOutputStream
    //   67: dup
    //   68: aload 4
    //   70: invokespecial 123	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   73: invokespecial 126	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   76: invokespecial 129	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   79: astore_3
    //   80: aload_3
    //   81: astore_2
    //   82: aload_0
    //   83: invokeinterface 249 1 0
    //   88: astore_0
    //   89: aload_3
    //   90: astore_2
    //   91: aload_0
    //   92: invokeinterface 254 1 0
    //   97: ifeq +252 -> 349
    //   100: aload_3
    //   101: astore_2
    //   102: aload_0
    //   103: invokeinterface 258 1 0
    //   108: checkcast 52	java/lang/String
    //   111: astore 5
    //   113: aload_3
    //   114: astore_2
    //   115: aload_3
    //   116: new 10	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   123: ldc 131
    //   125: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: new 23	java/io/File
    //   131: dup
    //   132: aload 5
    //   134: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   137: invokevirtual 134	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   140: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc 136
    //   145: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokevirtual 139	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   154: aload_3
    //   155: astore_2
    //   156: aload_3
    //   157: invokevirtual 142	java/io/BufferedWriter:newLine	()V
    //   160: goto -71 -> 89
    //   163: astore_2
    //   164: aload_3
    //   165: astore_0
    //   166: aload_2
    //   167: astore_3
    //   168: aload_0
    //   169: astore_2
    //   170: ldc 98
    //   172: iconst_2
    //   173: aload_3
    //   174: iconst_0
    //   175: anewarray 4	java/lang/Object
    //   178: invokestatic 170	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   181: aload_0
    //   182: ifnull +7 -> 189
    //   185: aload_0
    //   186: invokevirtual 148	java/io/BufferedWriter:close	()V
    //   189: new 10	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   196: getstatic 17	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:a	Ljava/lang/String;
    //   199: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: getstatic 26	java/io/File:separator	Ljava/lang/String;
    //   205: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokestatic 177	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   211: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   214: ldc_w 263
    //   217: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: astore_0
    //   224: bipush 10
    //   226: anewarray 52	java/lang/String
    //   229: dup
    //   230: iconst_0
    //   231: ldc 79
    //   233: aastore
    //   234: dup
    //   235: iconst_1
    //   236: ldc 150
    //   238: aastore
    //   239: dup
    //   240: iconst_2
    //   241: ldc 152
    //   243: aastore
    //   244: dup
    //   245: iconst_3
    //   246: ldc 154
    //   248: aastore
    //   249: dup
    //   250: iconst_4
    //   251: ldc 156
    //   253: aastore
    //   254: dup
    //   255: iconst_5
    //   256: ldc 81
    //   258: aastore
    //   259: dup
    //   260: bipush 6
    //   262: aload 4
    //   264: aastore
    //   265: dup
    //   266: bipush 7
    //   268: ldc 89
    //   270: aastore
    //   271: dup
    //   272: bipush 8
    //   274: ldc 91
    //   276: aastore
    //   277: dup
    //   278: bipush 9
    //   280: aload_0
    //   281: aastore
    //   282: invokestatic 96	bhpo:a	([Ljava/lang/String;)I
    //   285: istore_1
    //   286: new 23	java/io/File
    //   289: dup
    //   290: aload 4
    //   292: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   295: invokevirtual 159	java/io/File:delete	()Z
    //   298: ifeq +12 -> 310
    //   301: ldc 98
    //   303: ldc_w 265
    //   306: invokestatic 270	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   309: pop
    //   310: iload_1
    //   311: ifeq -286 -> 25
    //   314: ldc 98
    //   316: iconst_2
    //   317: iconst_1
    //   318: anewarray 4	java/lang/Object
    //   321: dup
    //   322: iconst_0
    //   323: new 10	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   330: ldc_w 272
    //   333: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: iload_1
    //   337: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   340: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: aastore
    //   344: invokestatic 109	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   347: aconst_null
    //   348: areturn
    //   349: aload_3
    //   350: astore_2
    //   351: aload_3
    //   352: invokevirtual 145	java/io/BufferedWriter:flush	()V
    //   355: aload_3
    //   356: ifnull -167 -> 189
    //   359: aload_3
    //   360: invokevirtual 148	java/io/BufferedWriter:close	()V
    //   363: goto -174 -> 189
    //   366: astore_0
    //   367: ldc 98
    //   369: iconst_2
    //   370: aload_0
    //   371: iconst_0
    //   372: anewarray 4	java/lang/Object
    //   375: invokestatic 170	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   378: goto -189 -> 189
    //   381: astore_0
    //   382: ldc 98
    //   384: iconst_2
    //   385: aload_0
    //   386: iconst_0
    //   387: anewarray 4	java/lang/Object
    //   390: invokestatic 170	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   393: goto -204 -> 189
    //   396: astore_0
    //   397: aconst_null
    //   398: astore_2
    //   399: aload_2
    //   400: ifnull +7 -> 407
    //   403: aload_2
    //   404: invokevirtual 148	java/io/BufferedWriter:close	()V
    //   407: aload_0
    //   408: athrow
    //   409: astore_2
    //   410: ldc 98
    //   412: iconst_2
    //   413: aload_2
    //   414: iconst_0
    //   415: anewarray 4	java/lang/Object
    //   418: invokestatic 170	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   421: goto -14 -> 407
    //   424: aconst_null
    //   425: areturn
    //   426: astore_0
    //   427: goto -28 -> 399
    //   430: astore_3
    //   431: aconst_null
    //   432: astore_0
    //   433: goto -265 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	436	0	paramList	List<String>
    //   285	52	1	i	int
    //   81	75	2	localObject1	Object
    //   163	4	2	localException1	java.lang.Exception
    //   169	235	2	localObject2	Object
    //   409	5	2	localIOException	java.io.IOException
    //   79	281	3	localObject3	Object
    //   430	1	3	localException2	java.lang.Exception
    //   54	237	4	str1	String
    //   111	22	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   82	89	163	java/lang/Exception
    //   91	100	163	java/lang/Exception
    //   102	113	163	java/lang/Exception
    //   115	154	163	java/lang/Exception
    //   156	160	163	java/lang/Exception
    //   351	355	163	java/lang/Exception
    //   359	363	366	java/io/IOException
    //   185	189	381	java/io/IOException
    //   56	80	396	finally
    //   403	407	409	java/io/IOException
    //   82	89	426	finally
    //   91	100	426	finally
    //   102	113	426	finally
    //   115	154	426	finally
    //   156	160	426	finally
    //   170	181	426	finally
    //   351	355	426	finally
    //   56	80	430	java/lang/Exception
  }
  
  public static String b(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (new File(paramString).exists())
      {
        str = EditLocalVideoActivity.a + File.separator + "converted_no_video." + a(paramString, "m4a");
        int i = bhpo.a(new String[] { "-y", "-i", paramString, "-vn", "-c", "copy", "-map", "0:a:0", str });
        if (i == 0) {
          return str;
        }
        QZLog.e("EditLocalVideoMusicMixH", 2, new Object[] { "ffmpegRemoveVideoTrack: FFmpeg run failed with " + i });
        str = null;
      }
    }
    return str;
    return str;
  }
  
  public static String c(String paramString)
  {
    if ((paramString != null) && (new File(paramString).exists()))
    {
      if (paramString.endsWith("m4a")) {
        return paramString;
      }
      String str = EditLocalVideoActivity.a + File.separator + "converted.m4a";
      int i = bhpo.a(new String[] { "-y", "-i", paramString, "-c:a", "aac", str });
      if (i != 0)
      {
        QZLog.e("EditLocalVideoMusicMixH", 2, new Object[] { "ffmpegConvert2AAC: FFmpeg run failed with " + i });
        return null;
      }
      return str;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahtd
 * JD-Core Version:    0.7.0.1
 */