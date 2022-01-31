package com.tencent.tencentmap.mapsdk.a;

public final class um
  extends uj
{
  private String[] b = { "https://m0.map.gtimg.com/hwap", "https://m1.map.gtimg.com/hwap", "https://m2.map.gtimg.com/hwap", "https://m3.map.gtimg.com/hwap" };
  
  public um(int paramInt)
  {
    super(paramInt);
  }
  
  /* Error */
  public final java.net.URL a(int paramInt1, int paramInt2, int paramInt3, java.lang.Object... paramVarArgs)
  {
    // Byte code:
    //   0: getstatic 34	com/tencent/tencentmap/mapsdk/a/sq:a	I
    //   3: istore 8
    //   5: iconst_0
    //   6: istore 11
    //   8: iconst_0
    //   9: istore 9
    //   11: aconst_null
    //   12: astore 15
    //   14: aconst_null
    //   15: astore 14
    //   17: iload 9
    //   19: istore 5
    //   21: iload 8
    //   23: istore 6
    //   25: aload 14
    //   27: astore 12
    //   29: iload 11
    //   31: istore 10
    //   33: aload 4
    //   35: ifnull +113 -> 148
    //   38: iload 9
    //   40: istore 5
    //   42: iload 8
    //   44: istore 6
    //   46: aload 14
    //   48: astore 12
    //   50: iload 11
    //   52: istore 10
    //   54: iload 8
    //   56: istore 7
    //   58: aload 15
    //   60: astore 13
    //   62: aload 4
    //   64: arraylength
    //   65: ifle +83 -> 148
    //   68: iload 8
    //   70: istore 7
    //   72: aload 15
    //   74: astore 13
    //   76: aload 4
    //   78: iconst_0
    //   79: aaload
    //   80: invokevirtual 40	java/lang/Object:toString	()Ljava/lang/String;
    //   83: invokestatic 46	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   86: istore 8
    //   88: iload 8
    //   90: istore 7
    //   92: aload 15
    //   94: astore 13
    //   96: aload 4
    //   98: arraylength
    //   99: iconst_3
    //   100: if_icmpne +242 -> 342
    //   103: iload 8
    //   105: istore 7
    //   107: aload 15
    //   109: astore 13
    //   111: aload 4
    //   113: iconst_1
    //   114: aaload
    //   115: invokevirtual 40	java/lang/Object:toString	()Ljava/lang/String;
    //   118: astore 12
    //   120: iload 8
    //   122: istore 7
    //   124: aload 12
    //   126: astore 13
    //   128: aload 4
    //   130: iconst_2
    //   131: aaload
    //   132: invokevirtual 40	java/lang/Object:toString	()Ljava/lang/String;
    //   135: invokestatic 52	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   138: istore 10
    //   140: iload 8
    //   142: istore 6
    //   144: iload 9
    //   146: istore 5
    //   148: iload_1
    //   149: iload_2
    //   150: iadd
    //   151: aload_0
    //   152: getfield 22	com/tencent/tencentmap/mapsdk/a/um:b	[Ljava/lang/String;
    //   155: arraylength
    //   156: invokestatic 55	com/tencent/tencentmap/mapsdk/a/um:a	(II)I
    //   159: istore 7
    //   161: ldc2_w 56
    //   164: iload_3
    //   165: i2d
    //   166: invokestatic 63	java/lang/Math:pow	(DD)D
    //   169: iload_2
    //   170: i2d
    //   171: dsub
    //   172: dconst_1
    //   173: dsub
    //   174: d2i
    //   175: istore_2
    //   176: new 65	java/lang/StringBuilder
    //   179: dup
    //   180: sipush 128
    //   183: invokespecial 66	java/lang/StringBuilder:<init>	(I)V
    //   186: astore 4
    //   188: aload 4
    //   190: aload_0
    //   191: getfield 22	com/tencent/tencentmap/mapsdk/a/um:b	[Ljava/lang/String;
    //   194: iload 7
    //   196: aaload
    //   197: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 4
    //   203: ldc 72
    //   205: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 4
    //   211: ldc 74
    //   213: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload 4
    //   219: iload_3
    //   220: iconst_1
    //   221: isub
    //   222: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 4
    //   228: ldc 79
    //   230: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload 4
    //   236: iload_1
    //   237: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload 4
    //   243: ldc 81
    //   245: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload 4
    //   251: iload_2
    //   252: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload 4
    //   258: ldc 83
    //   260: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: iload 5
    //   266: ifeq +170 -> 436
    //   269: aload 4
    //   271: bipush 7
    //   273: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload 4
    //   279: ldc 85
    //   281: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload 4
    //   287: iload 6
    //   289: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: new 87	java/lang/StringBuffer
    //   296: dup
    //   297: aload 4
    //   299: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokespecial 91	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   305: astore 4
    //   307: iload 10
    //   309: ifeq +16 -> 325
    //   312: aload 4
    //   314: ldc 93
    //   316: invokevirtual 96	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   319: aload 12
    //   321: invokevirtual 96	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   324: pop
    //   325: new 98	java/net/URL
    //   328: dup
    //   329: aload 4
    //   331: invokevirtual 99	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   334: invokespecial 100	java/net/URL:<init>	(Ljava/lang/String;)V
    //   337: astore 4
    //   339: aload 4
    //   341: areturn
    //   342: iload 9
    //   344: istore 5
    //   346: iload 8
    //   348: istore 6
    //   350: aload 14
    //   352: astore 12
    //   354: iload 11
    //   356: istore 10
    //   358: iload 8
    //   360: istore 7
    //   362: aload 15
    //   364: astore 13
    //   366: aload 4
    //   368: arraylength
    //   369: iconst_2
    //   370: if_icmpne -222 -> 148
    //   373: iload 8
    //   375: istore 7
    //   377: aload 15
    //   379: astore 13
    //   381: aload 4
    //   383: iconst_1
    //   384: aaload
    //   385: invokevirtual 40	java/lang/Object:toString	()Ljava/lang/String;
    //   388: invokestatic 46	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   391: istore 5
    //   393: bipush 7
    //   395: iload 5
    //   397: if_icmpne +21 -> 418
    //   400: iconst_1
    //   401: istore 5
    //   403: iload 8
    //   405: istore 6
    //   407: aload 14
    //   409: astore 12
    //   411: iload 11
    //   413: istore 10
    //   415: goto -267 -> 148
    //   418: iconst_0
    //   419: istore 5
    //   421: iload 8
    //   423: istore 6
    //   425: aload 14
    //   427: astore 12
    //   429: iload 11
    //   431: istore 10
    //   433: goto -285 -> 148
    //   436: aload 4
    //   438: invokestatic 105	com/tencent/tencentmap/mapsdk/a/tp:a	()I
    //   441: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: goto -168 -> 277
    //   448: astore 4
    //   450: new 65	java/lang/StringBuilder
    //   453: dup
    //   454: ldc 107
    //   456: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   459: aconst_null
    //   460: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   463: pop
    //   464: aconst_null
    //   465: areturn
    //   466: astore 4
    //   468: iload 9
    //   470: istore 5
    //   472: iload 7
    //   474: istore 6
    //   476: aload 13
    //   478: astore 12
    //   480: iload 11
    //   482: istore 10
    //   484: goto -336 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	487	0	this	um
    //   0	487	1	paramInt1	int
    //   0	487	2	paramInt2	int
    //   0	487	3	paramInt3	int
    //   0	487	4	paramVarArgs	java.lang.Object[]
    //   19	452	5	i	int
    //   23	452	6	j	int
    //   56	417	7	k	int
    //   3	419	8	m	int
    //   9	460	9	n	int
    //   31	452	10	bool1	boolean
    //   6	475	11	bool2	boolean
    //   27	452	12	localObject1	java.lang.Object
    //   60	417	13	localObject2	java.lang.Object
    //   15	411	14	localObject3	java.lang.Object
    //   12	366	15	localObject4	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   148	264	448	java/net/MalformedURLException
    //   269	277	448	java/net/MalformedURLException
    //   277	307	448	java/net/MalformedURLException
    //   312	325	448	java/net/MalformedURLException
    //   325	339	448	java/net/MalformedURLException
    //   436	445	448	java/net/MalformedURLException
    //   62	68	466	java/lang/Exception
    //   76	88	466	java/lang/Exception
    //   96	103	466	java/lang/Exception
    //   111	120	466	java/lang/Exception
    //   128	140	466	java/lang/Exception
    //   366	373	466	java/lang/Exception
    //   381	393	466	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.um
 * JD-Core Version:    0.7.0.1
 */