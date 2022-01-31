package com.tencent.pb.common.c;

public final class a
{
  /* Error */
  public static boolean q(java.lang.String paramString, android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 16	android/content/Context:getCacheDir	()Ljava/io/File;
    //   4: invokevirtual 22	java/io/File:toString	()Ljava/lang/String;
    //   7: astore 5
    //   9: aload 5
    //   11: astore 4
    //   13: aload 5
    //   15: ldc 24
    //   17: invokevirtual 30	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   20: iconst_1
    //   21: if_icmpne +18 -> 39
    //   24: aload 5
    //   26: iconst_0
    //   27: aload 5
    //   29: invokevirtual 34	java/lang/String:length	()I
    //   32: iconst_2
    //   33: isub
    //   34: invokevirtual 38	java/lang/String:substring	(II)Ljava/lang/String;
    //   37: astore 4
    //   39: aload 4
    //   41: bipush 47
    //   43: invokevirtual 42	java/lang/String:lastIndexOf	(I)I
    //   46: istore_2
    //   47: iload_2
    //   48: iconst_m1
    //   49: if_icmpeq +421 -> 470
    //   52: aload 4
    //   54: iconst_0
    //   55: iload_2
    //   56: invokevirtual 38	java/lang/String:substring	(II)Ljava/lang/String;
    //   59: astore 4
    //   61: new 44	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   68: aload 4
    //   70: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc 54
    //   75: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: astore 4
    //   83: aload 4
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 34	java/lang/String:length	()I
    //   90: ifeq +662 -> 752
    //   93: new 18	java/io/File
    //   96: dup
    //   97: new 44	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   104: aload_1
    //   105: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_0
    //   109: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   118: invokevirtual 62	java/io/File:exists	()Z
    //   121: ifeq +446 -> 567
    //   124: ldc 64
    //   126: iconst_1
    //   127: anewarray 4	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: new 44	java/lang/StringBuilder
    //   135: dup
    //   136: ldc 66
    //   138: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   141: aload_1
    //   142: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_0
    //   146: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: aastore
    //   153: invokestatic 73	com/tencent/pb/common/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   156: new 44	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   163: aload_1
    //   164: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_0
    //   168: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 78	java/lang/System:load	(Ljava/lang/String;)V
    //   177: iconst_1
    //   178: istore_2
    //   179: iload_2
    //   180: ifne +652 -> 832
    //   183: aload_0
    //   184: ldc 80
    //   186: invokevirtual 30	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   189: ifne +643 -> 832
    //   192: new 44	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   199: aload_0
    //   200: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: ldc 80
    //   205: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: astore 5
    //   213: iload_2
    //   214: istore_3
    //   215: aload 5
    //   217: astore 4
    //   219: new 18	java/io/File
    //   222: dup
    //   223: new 44	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   230: aload_1
    //   231: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload 5
    //   236: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   245: invokevirtual 62	java/io/File:exists	()Z
    //   248: ifeq +64 -> 312
    //   251: ldc 64
    //   253: iconst_1
    //   254: anewarray 4	java/lang/Object
    //   257: dup
    //   258: iconst_0
    //   259: new 44	java/lang/StringBuilder
    //   262: dup
    //   263: ldc 66
    //   265: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   268: aload_1
    //   269: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload 5
    //   274: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: aastore
    //   281: invokestatic 73	com/tencent/pb/common/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   284: new 44	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   291: aload_1
    //   292: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload 5
    //   297: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 78	java/lang/System:load	(Ljava/lang/String;)V
    //   306: iconst_1
    //   307: istore_3
    //   308: aload 5
    //   310: astore 4
    //   312: iload_3
    //   313: ifne +394 -> 707
    //   316: aload 4
    //   318: ldc 82
    //   320: invokevirtual 85	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   323: ifne +384 -> 707
    //   326: ldc 82
    //   328: aload 4
    //   330: invokestatic 89	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   333: invokevirtual 93	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   336: astore 4
    //   338: new 18	java/io/File
    //   341: dup
    //   342: new 44	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   349: aload_1
    //   350: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload 4
    //   355: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   364: invokevirtual 62	java/io/File:exists	()Z
    //   367: ifeq +340 -> 707
    //   370: ldc 64
    //   372: iconst_1
    //   373: anewarray 4	java/lang/Object
    //   376: dup
    //   377: iconst_0
    //   378: new 44	java/lang/StringBuilder
    //   381: dup
    //   382: ldc 66
    //   384: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   387: aload_1
    //   388: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: aload 4
    //   393: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: aastore
    //   400: invokestatic 73	com/tencent/pb/common/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   403: new 44	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   410: aload_1
    //   411: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: aload 4
    //   416: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 78	java/lang/System:load	(Ljava/lang/String;)V
    //   425: iconst_1
    //   426: istore_2
    //   427: iload_2
    //   428: ifne +40 -> 468
    //   431: ldc 64
    //   433: iconst_1
    //   434: anewarray 4	java/lang/Object
    //   437: dup
    //   438: iconst_0
    //   439: new 44	java/lang/StringBuilder
    //   442: dup
    //   443: ldc 66
    //   445: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   448: aload_0
    //   449: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: ldc 95
    //   454: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   460: aastore
    //   461: invokestatic 73	com/tencent/pb/common/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   464: aload_0
    //   465: invokestatic 97	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   468: iconst_1
    //   469: ireturn
    //   470: ldc 99
    //   472: astore_1
    //   473: goto -387 -> 86
    //   476: astore 4
    //   478: new 44	java/lang/StringBuilder
    //   481: dup
    //   482: ldc 101
    //   484: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   487: aload_1
    //   488: invokevirtual 104	android/content/Context:getPackageName	()Ljava/lang/String;
    //   491: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: ldc 54
    //   496: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: astore_1
    //   503: goto -417 -> 86
    //   506: astore 4
    //   508: sipush 146
    //   511: iconst_3
    //   512: new 44	java/lang/StringBuilder
    //   515: dup
    //   516: ldc 106
    //   518: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   521: aload_1
    //   522: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: aload_0
    //   526: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: invokestatic 112	com/tencent/pb/common/c/f:F	(IILjava/lang/String;)V
    //   535: ldc 64
    //   537: iconst_1
    //   538: anewarray 4	java/lang/Object
    //   541: dup
    //   542: iconst_0
    //   543: new 44	java/lang/StringBuilder
    //   546: dup
    //   547: ldc 114
    //   549: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   552: aload_1
    //   553: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aload_0
    //   557: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: aastore
    //   564: invokestatic 117	com/tencent/pb/common/c/c:w	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   567: iconst_0
    //   568: istore_2
    //   569: goto -390 -> 179
    //   572: astore 4
    //   574: ldc 64
    //   576: iconst_1
    //   577: anewarray 4	java/lang/Object
    //   580: dup
    //   581: iconst_0
    //   582: new 44	java/lang/StringBuilder
    //   585: dup
    //   586: ldc 114
    //   588: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   591: aload_1
    //   592: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: aload 5
    //   597: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: aastore
    //   604: invokestatic 117	com/tencent/pb/common/c/c:w	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   607: sipush 146
    //   610: iconst_3
    //   611: new 44	java/lang/StringBuilder
    //   614: dup
    //   615: ldc 119
    //   617: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   620: aload_1
    //   621: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: aload 5
    //   626: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   632: invokestatic 112	com/tencent/pb/common/c/f:F	(IILjava/lang/String;)V
    //   635: iload_2
    //   636: istore_3
    //   637: aload 5
    //   639: astore 4
    //   641: goto -329 -> 312
    //   644: astore 5
    //   646: ldc 64
    //   648: iconst_1
    //   649: anewarray 4	java/lang/Object
    //   652: dup
    //   653: iconst_0
    //   654: new 44	java/lang/StringBuilder
    //   657: dup
    //   658: ldc 114
    //   660: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   663: aload_1
    //   664: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: aload 4
    //   669: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   675: aastore
    //   676: invokestatic 117	com/tencent/pb/common/c/c:w	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   679: sipush 146
    //   682: iconst_3
    //   683: new 44	java/lang/StringBuilder
    //   686: dup
    //   687: ldc 121
    //   689: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   692: aload_1
    //   693: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: aload 4
    //   698: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   704: invokestatic 112	com/tencent/pb/common/c/f:F	(IILjava/lang/String;)V
    //   707: iload_3
    //   708: istore_2
    //   709: goto -282 -> 427
    //   712: astore_1
    //   713: ldc 64
    //   715: iconst_1
    //   716: anewarray 4	java/lang/Object
    //   719: dup
    //   720: iconst_0
    //   721: ldc 114
    //   723: aload_0
    //   724: invokestatic 89	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   727: invokevirtual 93	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   730: aastore
    //   731: invokestatic 117	com/tencent/pb/common/c/c:w	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   734: sipush 146
    //   737: iconst_3
    //   738: ldc 123
    //   740: aload_0
    //   741: invokestatic 89	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   744: invokevirtual 93	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   747: invokestatic 112	com/tencent/pb/common/c/f:F	(IILjava/lang/String;)V
    //   750: iconst_0
    //   751: ireturn
    //   752: ldc 64
    //   754: iconst_1
    //   755: anewarray 4	java/lang/Object
    //   758: dup
    //   759: iconst_0
    //   760: new 44	java/lang/StringBuilder
    //   763: dup
    //   764: ldc 66
    //   766: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   769: aload_0
    //   770: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: ldc 95
    //   775: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   781: aastore
    //   782: invokestatic 73	com/tencent/pb/common/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   785: aload_0
    //   786: invokestatic 97	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   789: goto -321 -> 468
    //   792: astore_1
    //   793: ldc 64
    //   795: iconst_1
    //   796: anewarray 4	java/lang/Object
    //   799: dup
    //   800: iconst_0
    //   801: ldc 114
    //   803: aload_0
    //   804: invokestatic 89	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   807: invokevirtual 93	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   810: aastore
    //   811: invokestatic 117	com/tencent/pb/common/c/c:w	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   814: sipush 146
    //   817: iconst_3
    //   818: ldc 125
    //   820: aload_0
    //   821: invokestatic 89	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   824: invokevirtual 93	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   827: invokestatic 112	com/tencent/pb/common/c/f:F	(IILjava/lang/String;)V
    //   830: iconst_0
    //   831: ireturn
    //   832: aload_0
    //   833: astore 4
    //   835: iload_2
    //   836: istore_3
    //   837: goto -525 -> 312
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	840	0	paramString	java.lang.String
    //   0	840	1	paramContext	android.content.Context
    //   46	790	2	i	int
    //   214	623	3	j	int
    //   11	404	4	str1	java.lang.String
    //   476	1	4	localException	java.lang.Exception
    //   506	1	4	localUnsatisfiedLinkError1	java.lang.UnsatisfiedLinkError
    //   572	1	4	localUnsatisfiedLinkError2	java.lang.UnsatisfiedLinkError
    //   639	195	4	str2	java.lang.String
    //   7	631	5	str3	java.lang.String
    //   644	1	5	localUnsatisfiedLinkError3	java.lang.UnsatisfiedLinkError
    // Exception table:
    //   from	to	target	type
    //   0	9	476	java/lang/Exception
    //   13	39	476	java/lang/Exception
    //   39	47	476	java/lang/Exception
    //   52	83	476	java/lang/Exception
    //   124	177	506	java/lang/UnsatisfiedLinkError
    //   251	306	572	java/lang/UnsatisfiedLinkError
    //   370	425	644	java/lang/UnsatisfiedLinkError
    //   431	468	712	java/lang/UnsatisfiedLinkError
    //   752	789	792	java/lang/UnsatisfiedLinkError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.pb.common.c.a
 * JD-Core Version:    0.7.0.1
 */