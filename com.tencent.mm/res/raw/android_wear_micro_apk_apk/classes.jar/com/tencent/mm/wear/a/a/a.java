package com.tencent.mm.wear.a.a;

import java.util.Map;

public final class a
{
  private static Map<String, String> amu = null;
  
  private static String a(Map<String, String> paramMap, String paramString)
  {
    return (String)paramMap.get(paramString);
  }
  
  /* Error */
  private static java.util.HashMap<String, String> ow()
  {
    // Byte code:
    //   0: new 32	java/util/HashMap
    //   3: dup
    //   4: invokespecial 35	java/util/HashMap:<init>	()V
    //   7: astore_3
    //   8: new 37	java/io/BufferedReader
    //   11: dup
    //   12: new 39	java/io/InputStreamReader
    //   15: dup
    //   16: new 41	java/io/FileInputStream
    //   19: dup
    //   20: ldc 43
    //   22: invokespecial 46	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   25: ldc 48
    //   27: invokespecial 51	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   30: invokespecial 54	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   33: astore_1
    //   34: aload_1
    //   35: astore_0
    //   36: aload_1
    //   37: invokevirtual 58	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   40: astore_2
    //   41: aload_2
    //   42: ifnull +97 -> 139
    //   45: aload_1
    //   46: astore_0
    //   47: aload_2
    //   48: ldc 60
    //   50: iconst_2
    //   51: invokevirtual 64	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   54: astore 4
    //   56: aload 4
    //   58: ifnull -24 -> 34
    //   61: aload_1
    //   62: astore_0
    //   63: aload 4
    //   65: arraylength
    //   66: iconst_2
    //   67: if_icmplt -33 -> 34
    //   70: aload_1
    //   71: astore_0
    //   72: aload 4
    //   74: iconst_0
    //   75: aaload
    //   76: invokevirtual 67	java/lang/String:trim	()Ljava/lang/String;
    //   79: astore_2
    //   80: aload_1
    //   81: astore_0
    //   82: aload 4
    //   84: iconst_1
    //   85: aaload
    //   86: invokevirtual 67	java/lang/String:trim	()Ljava/lang/String;
    //   89: astore 4
    //   91: aload_1
    //   92: astore_0
    //   93: aload_3
    //   94: aload_2
    //   95: invokevirtual 68	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   98: ifnonnull -64 -> 34
    //   101: aload_1
    //   102: astore_0
    //   103: aload_3
    //   104: aload_2
    //   105: aload 4
    //   107: invokevirtual 72	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   110: pop
    //   111: goto -77 -> 34
    //   114: astore_2
    //   115: aload_1
    //   116: astore_0
    //   117: ldc 74
    //   119: aload_2
    //   120: ldc 76
    //   122: iconst_0
    //   123: anewarray 4	java/lang/Object
    //   126: invokestatic 81	com/tencent/mm/sdk/platformtools/f:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   129: aload_1
    //   130: ifnull +7 -> 137
    //   133: aload_1
    //   134: invokevirtual 84	java/io/BufferedReader:close	()V
    //   137: aload_3
    //   138: areturn
    //   139: aload_1
    //   140: invokevirtual 84	java/io/BufferedReader:close	()V
    //   143: aload_3
    //   144: areturn
    //   145: astore_0
    //   146: aload_3
    //   147: areturn
    //   148: astore_1
    //   149: aconst_null
    //   150: astore_0
    //   151: aload_0
    //   152: ifnull +7 -> 159
    //   155: aload_0
    //   156: invokevirtual 84	java/io/BufferedReader:close	()V
    //   159: aload_1
    //   160: athrow
    //   161: astore_0
    //   162: aload_3
    //   163: areturn
    //   164: astore_0
    //   165: goto -6 -> 159
    //   168: astore_1
    //   169: goto -18 -> 151
    //   172: astore_2
    //   173: aconst_null
    //   174: astore_1
    //   175: goto -60 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   35	82	0	localBufferedReader1	java.io.BufferedReader
    //   145	1	0	localThrowable1	java.lang.Throwable
    //   150	6	0	localObject1	Object
    //   161	1	0	localThrowable2	java.lang.Throwable
    //   164	1	0	localThrowable3	java.lang.Throwable
    //   33	107	1	localBufferedReader2	java.io.BufferedReader
    //   148	12	1	localObject2	Object
    //   168	1	1	localObject3	Object
    //   174	1	1	localObject4	Object
    //   40	65	2	str	String
    //   114	6	2	localIOException1	java.io.IOException
    //   172	1	2	localIOException2	java.io.IOException
    //   7	156	3	localHashMap	java.util.HashMap
    //   54	52	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   36	41	114	java/io/IOException
    //   47	56	114	java/io/IOException
    //   63	70	114	java/io/IOException
    //   72	80	114	java/io/IOException
    //   82	91	114	java/io/IOException
    //   93	101	114	java/io/IOException
    //   103	111	114	java/io/IOException
    //   139	143	145	java/lang/Throwable
    //   8	34	148	finally
    //   133	137	161	java/lang/Throwable
    //   155	159	164	java/lang/Throwable
    //   36	41	168	finally
    //   47	56	168	finally
    //   63	70	168	finally
    //   72	80	168	finally
    //   82	91	168	finally
    //   93	101	168	finally
    //   103	111	168	finally
    //   117	129	168	finally
    //   8	34	172	java/io/IOException
  }
  
  public static String ox()
  {
    if (amu == null) {
      amu = ow();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(": ");
    localStringBuilder.append(a(amu, "Features"));
    localStringBuilder.append(": ");
    localStringBuilder.append(a(amu, "Processor"));
    localStringBuilder.append(": ");
    localStringBuilder.append(a(amu, "CPU architecture"));
    localStringBuilder.append(": ");
    localStringBuilder.append(a(amu, "Hardware"));
    localStringBuilder.append(": ");
    localStringBuilder.append(a(amu, "Serial"));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.a.a.a
 * JD-Core Version:    0.7.0.1
 */