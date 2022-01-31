import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public abstract class akuu
{
  /* Error */
  public static byte a(int paramInt, String arg1)
  {
    // Byte code:
    //   0: iconst_4
    //   1: istore_3
    //   2: iload_0
    //   3: iconst_1
    //   4: invokestatic 11	akuu:a	(IZ)V
    //   7: aload_1
    //   8: iload_0
    //   9: invokestatic 14	akuu:a	(I)Ljava/lang/String;
    //   12: invokestatic 17	akuu:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: new 19	java/util/HashMap
    //   18: dup
    //   19: invokespecial 23	java/util/HashMap:<init>	()V
    //   22: astore 6
    //   24: getstatic 29	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   27: ldc 31
    //   29: iconst_4
    //   30: invokevirtual 35	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   33: invokeinterface 41 1 0
    //   38: astore 5
    //   40: new 43	java/io/File
    //   43: dup
    //   44: new 45	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   51: iload_0
    //   52: invokestatic 14	akuu:a	(I)Ljava/lang/String;
    //   55: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 52
    //   60: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   69: astore 4
    //   71: aload 4
    //   73: invokevirtual 63	java/io/File:exists	()Z
    //   76: ifeq +381 -> 457
    //   79: aconst_null
    //   80: astore_1
    //   81: aload 4
    //   83: invokestatic 69	bace:b	(Ljava/io/File;)Ljava/lang/String;
    //   86: astore 4
    //   88: aload 4
    //   90: astore_1
    //   91: aload_1
    //   92: ifnull +344 -> 436
    //   95: iload_0
    //   96: aload_1
    //   97: aload 6
    //   99: invokestatic 72	akuu:a	(ILjava/lang/String;Ljava/util/HashMap;)Z
    //   102: ifeq +334 -> 436
    //   105: iload_0
    //   106: invokestatic 75	akuu:a	(I)Ljava/lang/Object;
    //   109: astore_1
    //   110: aload_1
    //   111: monitorenter
    //   112: aload 6
    //   114: invokevirtual 79	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   117: invokeinterface 85 1 0
    //   122: astore 4
    //   124: aload 4
    //   126: invokeinterface 90 1 0
    //   131: ifeq +345 -> 476
    //   134: aload 4
    //   136: invokeinterface 94 1 0
    //   141: checkcast 96	java/util/Map$Entry
    //   144: astore 6
    //   146: new 45	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   153: iload_0
    //   154: invokestatic 14	akuu:a	(I)Ljava/lang/String;
    //   157: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: getstatic 100	java/io/File:separator	Ljava/lang/String;
    //   163: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: iload_0
    //   167: aload 6
    //   169: invokeinterface 103 1 0
    //   174: checkcast 105	java/lang/String
    //   177: invokestatic 108	akuu:b	(ILjava/lang/String;)Ljava/lang/String;
    //   180: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: astore 8
    //   188: new 43	java/io/File
    //   191: dup
    //   192: aload 8
    //   194: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   197: astore 7
    //   199: aload 7
    //   201: invokevirtual 63	java/io/File:exists	()Z
    //   204: ifeq +227 -> 431
    //   207: aload 8
    //   209: invokestatic 113	attn:a	(Ljava/lang/String;)Ljava/lang/String;
    //   212: astore 8
    //   214: aload 6
    //   216: invokeinterface 116 1 0
    //   221: checkcast 105	java/lang/String
    //   224: aload 8
    //   226: invokevirtual 120	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   229: ifne +88 -> 317
    //   232: aload 7
    //   234: invokevirtual 123	java/io/File:delete	()Z
    //   237: pop
    //   238: iconst_2
    //   239: istore_2
    //   240: aload 5
    //   242: invokeinterface 128 1 0
    //   247: pop
    //   248: aload_1
    //   249: monitorexit
    //   250: iload_0
    //   251: iconst_0
    //   252: invokestatic 11	akuu:a	(IZ)V
    //   255: iload_2
    //   256: ireturn
    //   257: astore_1
    //   258: iload_0
    //   259: iconst_0
    //   260: invokestatic 11	akuu:a	(IZ)V
    //   263: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   266: ifeq +31 -> 297
    //   269: ldc 135
    //   271: iconst_2
    //   272: new 45	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   279: ldc 137
    //   281: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: aload_1
    //   285: invokevirtual 140	java/io/IOException:getMessage	()Ljava/lang/String;
    //   288: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   297: iload_0
    //   298: invokestatic 14	akuu:a	(I)Ljava/lang/String;
    //   301: iconst_0
    //   302: invokestatic 147	bace:a	(Ljava/lang/String;Z)V
    //   305: iconst_m1
    //   306: ireturn
    //   307: astore 4
    //   309: aload 4
    //   311: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   314: goto -223 -> 91
    //   317: aload 5
    //   319: new 45	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   326: ldc 152
    //   328: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload 6
    //   333: invokeinterface 103 1 0
    //   338: checkcast 105	java/lang/String
    //   341: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: aload 6
    //   349: invokeinterface 116 1 0
    //   354: checkcast 105	java/lang/String
    //   357: invokeinterface 156 3 0
    //   362: pop
    //   363: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   366: ifeq -242 -> 124
    //   369: ldc 135
    //   371: iconst_2
    //   372: new 45	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   379: ldc 158
    //   381: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: aload 6
    //   386: invokeinterface 103 1 0
    //   391: checkcast 105	java/lang/String
    //   394: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: ldc 160
    //   399: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: aload 6
    //   404: invokeinterface 116 1 0
    //   409: checkcast 105	java/lang/String
    //   412: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   421: goto -297 -> 124
    //   424: astore 4
    //   426: aload_1
    //   427: monitorexit
    //   428: aload 4
    //   430: athrow
    //   431: iconst_3
    //   432: istore_2
    //   433: goto -193 -> 240
    //   436: iload_3
    //   437: istore_2
    //   438: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   441: ifeq -191 -> 250
    //   444: ldc 135
    //   446: iconst_2
    //   447: ldc 162
    //   449: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   452: iload_3
    //   453: istore_2
    //   454: goto -204 -> 250
    //   457: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   460: ifeq +11 -> 471
    //   463: ldc 135
    //   465: iconst_2
    //   466: ldc 164
    //   468: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   471: iconst_0
    //   472: istore_2
    //   473: goto -223 -> 250
    //   476: iconst_0
    //   477: istore_2
    //   478: goto -238 -> 240
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	481	0	paramInt	int
    //   239	239	2	b1	byte
    //   1	452	3	b2	byte
    //   69	66	4	localObject1	Object
    //   307	3	4	localIOException	java.io.IOException
    //   424	5	4	localObject2	Object
    //   38	280	5	localEditor	android.content.SharedPreferences.Editor
    //   22	381	6	localObject3	Object
    //   197	36	7	localFile	File
    //   186	39	8	str	String
    // Exception table:
    //   from	to	target	type
    //   7	15	257	java/io/IOException
    //   81	88	307	java/io/IOException
    //   112	124	424	finally
    //   124	238	424	finally
    //   240	250	424	finally
    //   317	421	424	finally
    //   426	428	424	finally
  }
  
  public static byte a(int paramInt, boolean paramBoolean, String paramString)
  {
    byte b2 = 0;
    byte b1 = 0;
    if (paramString == null) {
      b1 = -1;
    }
    File localFile;
    for (;;)
    {
      return b1;
      String str = a(paramInt) + File.separator + b(paramInt, paramString);
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.BaseMiniSoLoader", 2, "start loadMiniNativeSo: " + str);
      }
      localFile = new File(str);
      if ((!paramBoolean) && (localFile.exists())) {
        try
        {
          SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "c++_shared");
          System.load(str);
          if (QLog.isColorLevel())
          {
            QLog.i("MiniRecog.BaseMiniSoLoader", 2, "load " + str + " success!");
            return 0;
          }
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          QLog.d("MiniRecog.BaseMiniSoLoader", 1, "load from mini dir failed, libName = " + paramString + "," + localUnsatisfiedLinkError.getMessage());
          return -2;
        }
      }
    }
    b1 = b2;
    if (paramBoolean)
    {
      b1 = b2;
      if (!localFile.exists()) {
        b1 = -3;
      }
    }
    b2 = b1;
    if (paramBoolean)
    {
      b2 = b1;
      if (localFile.exists()) {
        b2 = -4;
      }
    }
    b1 = b2;
    if (!paramBoolean)
    {
      b1 = b2;
      if (!localFile.exists()) {
        b1 = -5;
      }
    }
    QLog.d("MiniRecog.BaseMiniSoLoader", 1, "no mini so in mini dir,libName = " + paramString);
    return b1;
  }
  
  public static Object a(int paramInt)
  {
    if (paramInt == 0) {
      return akvg.a();
    }
    if (paramInt == 1) {
      return akvi.a();
    }
    if (paramInt == 2) {
      return akvh.a();
    }
    return null;
  }
  
  protected static String a(int paramInt)
  {
    if (paramInt == 0) {
      return akvg.a();
    }
    if (paramInt == 1) {
      return akvi.a();
    }
    if (paramInt == 2) {
      return akvh.a();
    }
    return "";
  }
  
  public static String a(int paramInt, String paramString)
  {
    new StringBuilder().append(a(paramInt)).append(File.separator).append(b(paramInt, paramString)).toString();
    String str = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4).getString("mini_native_" + paramString, null);
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.BaseMiniSoLoader", 2, "getMiniFileMd5 ,resName = " + paramString + ",md5 = " + str);
    }
    return str;
  }
  
  protected static void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0) {
      akvg.a(paramBoolean);
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        akvi.a(paramBoolean);
        return;
      }
    } while (paramInt != 2);
    akvh.a(paramBoolean);
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +28 -> 33
    //   8: ldc 135
    //   10: iconst_2
    //   11: new 45	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   18: ldc 232
    //   20: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: new 234	com/tencent/commonsdk/zip/QZipFile
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 235	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   41: astore 4
    //   43: aload 4
    //   45: invokevirtual 239	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   48: astore 6
    //   50: sipush 8192
    //   53: newarray byte
    //   55: astore 7
    //   57: aload 6
    //   59: invokeinterface 244 1 0
    //   64: ifeq +332 -> 396
    //   67: aload 6
    //   69: invokeinterface 247 1 0
    //   74: checkcast 249	java/util/zip/ZipEntry
    //   77: astore 5
    //   79: aload 5
    //   81: invokevirtual 252	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   84: astore_0
    //   85: aload_0
    //   86: ifnull +412 -> 498
    //   89: aload_0
    //   90: ldc 254
    //   92: invokevirtual 258	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   95: ifeq +6 -> 101
    //   98: goto -41 -> 57
    //   101: new 45	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   108: aload_1
    //   109: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: getstatic 100	java/io/File:separator	Ljava/lang/String;
    //   115: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_0
    //   119: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore_0
    //   126: aload 5
    //   128: invokevirtual 261	java/util/zip/ZipEntry:isDirectory	()Z
    //   131: ifeq +27 -> 158
    //   134: new 43	java/io/File
    //   137: dup
    //   138: aload_0
    //   139: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   142: astore_0
    //   143: aload_0
    //   144: invokevirtual 63	java/io/File:exists	()Z
    //   147: ifne +354 -> 501
    //   150: aload_0
    //   151: invokevirtual 264	java/io/File:mkdir	()Z
    //   154: pop
    //   155: goto +346 -> 501
    //   158: aload_0
    //   159: getstatic 100	java/io/File:separator	Ljava/lang/String;
    //   162: invokevirtual 268	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   165: istore_2
    //   166: aload_0
    //   167: iconst_0
    //   168: iload_2
    //   169: invokevirtual 272	java/lang/String:substring	(II)Ljava/lang/String;
    //   172: astore 8
    //   174: aload_0
    //   175: iload_2
    //   176: iconst_1
    //   177: iadd
    //   178: invokevirtual 274	java/lang/String:substring	(I)Ljava/lang/String;
    //   181: ldc_w 276
    //   184: invokevirtual 279	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   187: ifeq +6 -> 193
    //   190: goto -133 -> 57
    //   193: new 43	java/io/File
    //   196: dup
    //   197: aload 8
    //   199: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   202: astore 8
    //   204: aload 8
    //   206: invokevirtual 63	java/io/File:exists	()Z
    //   209: ifne +9 -> 218
    //   212: aload 8
    //   214: invokevirtual 264	java/io/File:mkdir	()Z
    //   217: pop
    //   218: new 43	java/io/File
    //   221: dup
    //   222: new 45	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   229: aload_0
    //   230: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc_w 281
    //   236: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   245: astore 8
    //   247: new 43	java/io/File
    //   250: dup
    //   251: aload_0
    //   252: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   255: astore 9
    //   257: aload 8
    //   259: invokevirtual 63	java/io/File:exists	()Z
    //   262: ifeq +9 -> 271
    //   265: aload 8
    //   267: invokevirtual 123	java/io/File:delete	()Z
    //   270: pop
    //   271: new 283	java/io/FileOutputStream
    //   274: dup
    //   275: aload 8
    //   277: invokespecial 286	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   280: astore_0
    //   281: aload 4
    //   283: aload 5
    //   285: invokevirtual 290	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   288: astore 5
    //   290: aload 5
    //   292: aload 7
    //   294: iconst_0
    //   295: aload 7
    //   297: arraylength
    //   298: invokevirtual 296	java/io/InputStream:read	([BII)I
    //   301: istore_2
    //   302: iload_2
    //   303: iconst_m1
    //   304: if_icmpeq +52 -> 356
    //   307: aload_0
    //   308: aload 7
    //   310: iconst_0
    //   311: iload_2
    //   312: invokevirtual 300	java/io/FileOutputStream:write	([BII)V
    //   315: goto -25 -> 290
    //   318: astore 6
    //   320: aload 5
    //   322: astore_1
    //   323: aload_0
    //   324: astore_3
    //   325: aload 6
    //   327: astore_0
    //   328: aload_3
    //   329: ifnull +7 -> 336
    //   332: aload_3
    //   333: invokevirtual 303	java/io/FileOutputStream:close	()V
    //   336: aload_1
    //   337: ifnull +7 -> 344
    //   340: aload_1
    //   341: invokevirtual 304	java/io/InputStream:close	()V
    //   344: aload 4
    //   346: ifnull +8 -> 354
    //   349: aload 4
    //   351: invokevirtual 305	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   354: aload_0
    //   355: athrow
    //   356: aload_0
    //   357: invokevirtual 308	java/io/FileOutputStream:flush	()V
    //   360: aload_0
    //   361: invokevirtual 303	java/io/FileOutputStream:close	()V
    //   364: aload 5
    //   366: invokevirtual 304	java/io/InputStream:close	()V
    //   369: aload 8
    //   371: aload 9
    //   373: invokestatic 311	bace:b	(Ljava/io/File;Ljava/io/File;)Z
    //   376: ifne +125 -> 501
    //   379: aload 8
    //   381: aload 9
    //   383: invokestatic 313	bace:a	(Ljava/io/File;Ljava/io/File;)Z
    //   386: pop
    //   387: goto +114 -> 501
    //   390: astore_0
    //   391: aconst_null
    //   392: astore_1
    //   393: goto -65 -> 328
    //   396: iconst_0
    //   397: ifeq +11 -> 408
    //   400: new 315	java/lang/NullPointerException
    //   403: dup
    //   404: invokespecial 316	java/lang/NullPointerException:<init>	()V
    //   407: athrow
    //   408: iconst_0
    //   409: ifeq +11 -> 420
    //   412: new 315	java/lang/NullPointerException
    //   415: dup
    //   416: invokespecial 316	java/lang/NullPointerException:<init>	()V
    //   419: athrow
    //   420: aload 4
    //   422: ifnull +8 -> 430
    //   425: aload 4
    //   427: invokevirtual 305	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   430: return
    //   431: astore_0
    //   432: aload_0
    //   433: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   436: goto -28 -> 408
    //   439: astore_0
    //   440: aload_0
    //   441: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   444: goto -24 -> 420
    //   447: astore_0
    //   448: aload_0
    //   449: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   452: return
    //   453: astore_3
    //   454: aload_3
    //   455: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   458: goto -122 -> 336
    //   461: astore_1
    //   462: aload_1
    //   463: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   466: goto -122 -> 344
    //   469: astore_1
    //   470: aload_1
    //   471: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   474: goto -120 -> 354
    //   477: astore_0
    //   478: aconst_null
    //   479: astore 4
    //   481: aconst_null
    //   482: astore_1
    //   483: goto -155 -> 328
    //   486: astore 5
    //   488: aconst_null
    //   489: astore_1
    //   490: aload_0
    //   491: astore_3
    //   492: aload 5
    //   494: astore_0
    //   495: goto -167 -> 328
    //   498: goto -441 -> 57
    //   501: goto -444 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	504	0	paramString1	String
    //   0	504	1	paramString2	String
    //   165	147	2	i	int
    //   1	332	3	str1	String
    //   453	2	3	localIOException	java.io.IOException
    //   491	1	3	str2	String
    //   41	439	4	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   77	288	5	localObject1	Object
    //   486	7	5	localObject2	Object
    //   48	20	6	localEnumeration	java.util.Enumeration
    //   318	8	6	localObject3	Object
    //   55	254	7	arrayOfByte	byte[]
    //   172	208	8	localObject4	Object
    //   255	127	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   290	302	318	finally
    //   307	315	318	finally
    //   356	369	318	finally
    //   43	57	390	finally
    //   57	85	390	finally
    //   89	98	390	finally
    //   101	155	390	finally
    //   158	190	390	finally
    //   193	218	390	finally
    //   218	271	390	finally
    //   271	281	390	finally
    //   369	387	390	finally
    //   400	408	431	java/io/IOException
    //   412	420	439	java/io/IOException
    //   425	430	447	java/io/IOException
    //   332	336	453	java/io/IOException
    //   340	344	461	java/io/IOException
    //   349	354	469	java/io/IOException
    //   33	43	477	finally
    //   281	290	486	finally
  }
  
  public static boolean a(int paramInt, String paramString, HashMap<String, String> paramHashMap)
  {
    if (paramInt == 0) {
      return akvg.a(paramString, paramHashMap);
    }
    if (paramInt == 1) {
      return akvi.a(paramString, paramHashMap);
    }
    if (paramInt == 2) {
      return akvh.a(paramString, paramHashMap);
    }
    return false;
  }
  
  public static boolean a(int paramInt, boolean paramBoolean, String paramString)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    String str1 = a(paramInt) + File.separator + b(paramInt, paramString);
    Object localObject = new File(str1);
    boolean bool1 = bool3;
    if (!paramBoolean)
    {
      bool1 = bool3;
      if (((File)localObject).exists())
      {
        localObject = a(paramInt);
        bool1 = bool3;
        if (localObject == null) {}
      }
    }
    label310:
    for (;;)
    {
      try
      {
        String str2 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4).getString("mini_native_" + paramString, null);
        str1 = attn.a(str1);
        if (QLog.isColorLevel()) {
          QLog.d("MiniRecog.BaseMiniSoLoader", 2, "isSoFileExist: soName= " + paramString + " ,spmd5 = " + str2 + ",fileMD5 = " + str1);
        }
        if (str2 != null) {
          if (str2.equalsIgnoreCase(str1))
          {
            break label310;
            if (QLog.isColorLevel()) {
              QLog.d("MiniRecog.BaseMiniSoLoader", 2, "isSoFileExist: soName= " + paramString + " ,result = " + bool1 + ",isUncompressZip = " + paramBoolean);
            }
            return bool1;
          }
          else
          {
            bool1 = bool2;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("MiniRecog.BaseMiniSoLoader", 2, "isSoFileExist: soName= " + paramString + " check md5 false!");
            bool1 = bool2;
            continue;
          }
        }
        bool1 = true;
      }
      finally {}
    }
  }
  
  public static String b(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      return akvg.a(paramString);
    }
    if (paramInt == 1) {
      return akvi.a(paramString);
    }
    if (paramInt == 2) {
      return akvh.a(paramString);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akuu
 * JD-Core Version:    0.7.0.1
 */