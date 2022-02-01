package org.xwalk.core;

public class XWalkUpdater$AssetsUpdateConfig
  extends XWalkUpdater.EmbededUpdateConfig
{
  public XWalkUpdater$AssetsUpdateConfig(int paramInt, String paramString1, String paramString2)
  {
    super(paramInt, paramString1, paramString2);
  }
  
  /* Error */
  public boolean copyPackageToLocal(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 19
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 31	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   8: invokevirtual 37	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   11: astore_2
    //   12: aload_2
    //   13: aload_1
    //   14: invokevirtual 43	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   17: astore_1
    //   18: new 45	java/io/FileOutputStream
    //   21: dup
    //   22: aload_0
    //   23: invokevirtual 49	org/xwalk/core/XWalkUpdater$AssetsUpdateConfig:getDownloadPath	()Ljava/lang/String;
    //   26: invokespecial 52	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   29: astore_2
    //   30: aload_2
    //   31: astore 5
    //   33: aload_1
    //   34: astore 4
    //   36: ldc 53
    //   38: newarray byte
    //   40: astore 6
    //   42: aload_2
    //   43: astore 5
    //   45: aload_1
    //   46: astore 4
    //   48: aload_1
    //   49: aload 6
    //   51: invokevirtual 59	java/io/InputStream:read	([B)I
    //   54: istore_3
    //   55: iload_3
    //   56: iconst_m1
    //   57: if_icmpeq +76 -> 133
    //   60: aload_2
    //   61: astore 5
    //   63: aload_1
    //   64: astore 4
    //   66: aload_2
    //   67: aload 6
    //   69: iconst_0
    //   70: iload_3
    //   71: invokevirtual 65	java/io/OutputStream:write	([BII)V
    //   74: goto -32 -> 42
    //   77: astore 6
    //   79: aload_2
    //   80: astore 5
    //   82: aload_1
    //   83: astore 4
    //   85: ldc 67
    //   87: new 69	java/lang/StringBuilder
    //   90: dup
    //   91: ldc 71
    //   93: invokespecial 72	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   96: aload 6
    //   98: invokevirtual 75	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   101: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 86	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload_1
    //   111: ifnull +7 -> 118
    //   114: aload_1
    //   115: invokevirtual 90	java/io/InputStream:close	()V
    //   118: aload_2
    //   119: ifnull +7 -> 126
    //   122: aload_2
    //   123: invokevirtual 91	java/io/OutputStream:close	()V
    //   126: ldc 19
    //   128: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: iconst_0
    //   132: ireturn
    //   133: aload_2
    //   134: astore 5
    //   136: aload_1
    //   137: astore 4
    //   139: aload_2
    //   140: invokevirtual 97	java/io/OutputStream:flush	()V
    //   143: aload_1
    //   144: ifnull +7 -> 151
    //   147: aload_1
    //   148: invokevirtual 90	java/io/InputStream:close	()V
    //   151: aload_2
    //   152: invokevirtual 91	java/io/OutputStream:close	()V
    //   155: ldc 19
    //   157: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: iconst_1
    //   161: ireturn
    //   162: astore_2
    //   163: aconst_null
    //   164: astore 5
    //   166: aconst_null
    //   167: astore_1
    //   168: aload_1
    //   169: ifnull +7 -> 176
    //   172: aload_1
    //   173: invokevirtual 90	java/io/InputStream:close	()V
    //   176: aload 5
    //   178: ifnull +8 -> 186
    //   181: aload 5
    //   183: invokevirtual 91	java/io/OutputStream:close	()V
    //   186: ldc 19
    //   188: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: aload_2
    //   192: athrow
    //   193: astore_1
    //   194: goto -43 -> 151
    //   197: astore_1
    //   198: goto -43 -> 155
    //   201: astore_1
    //   202: goto -84 -> 118
    //   205: astore_1
    //   206: goto -80 -> 126
    //   209: astore_1
    //   210: goto -34 -> 176
    //   213: astore_1
    //   214: goto -28 -> 186
    //   217: astore_2
    //   218: aconst_null
    //   219: astore 5
    //   221: goto -53 -> 168
    //   224: astore_2
    //   225: aload 4
    //   227: astore_1
    //   228: goto -60 -> 168
    //   231: astore 6
    //   233: aconst_null
    //   234: astore_2
    //   235: aconst_null
    //   236: astore_1
    //   237: goto -158 -> 79
    //   240: astore 6
    //   242: aconst_null
    //   243: astore_2
    //   244: goto -165 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	this	AssetsUpdateConfig
    //   0	247	1	paramString1	String
    //   0	247	2	paramString2	String
    //   54	17	3	i	int
    //   34	192	4	str1	String
    //   31	189	5	str2	String
    //   40	28	6	arrayOfByte	byte[]
    //   77	20	6	localException1	java.lang.Exception
    //   231	1	6	localException2	java.lang.Exception
    //   240	1	6	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   36	42	77	java/lang/Exception
    //   48	55	77	java/lang/Exception
    //   66	74	77	java/lang/Exception
    //   139	143	77	java/lang/Exception
    //   12	18	162	finally
    //   147	151	193	java/lang/Exception
    //   151	155	197	java/io/IOException
    //   114	118	201	java/lang/Exception
    //   122	126	205	java/io/IOException
    //   172	176	209	java/lang/Exception
    //   181	186	213	java/io/IOException
    //   18	30	217	finally
    //   36	42	224	finally
    //   48	55	224	finally
    //   66	74	224	finally
    //   85	110	224	finally
    //   139	143	224	finally
    //   12	18	231	java/lang/Exception
    //   18	30	240	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.xwalk.core.XWalkUpdater.AssetsUpdateConfig
 * JD-Core Version:    0.7.0.1
 */