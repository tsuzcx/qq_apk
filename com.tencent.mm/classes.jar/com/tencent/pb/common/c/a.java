package com.tencent.pb.common.c;

public final class a
{
  /* Error */
  public static boolean o(java.lang.String paramString, android.content.Context paramContext)
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
    //   49: if_icmpeq +428 -> 477
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
    //   90: ifeq +683 -> 773
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
    //   121: ifeq +453 -> 574
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
    //   180: ifne +687 -> 867
    //   183: aload_0
    //   184: ldc 80
    //   186: invokevirtual 30	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   189: ifne +678 -> 867
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
    //   313: ifne +401 -> 714
    //   316: aload 4
    //   318: ldc 82
    //   320: invokevirtual 85	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   323: ifne +391 -> 714
    //   326: new 44	java/lang/StringBuilder
    //   329: dup
    //   330: ldc 82
    //   332: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   335: aload 4
    //   337: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: astore 4
    //   345: new 18	java/io/File
    //   348: dup
    //   349: new 44	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   356: aload_1
    //   357: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload 4
    //   362: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   371: invokevirtual 62	java/io/File:exists	()Z
    //   374: ifeq +340 -> 714
    //   377: ldc 64
    //   379: iconst_1
    //   380: anewarray 4	java/lang/Object
    //   383: dup
    //   384: iconst_0
    //   385: new 44	java/lang/StringBuilder
    //   388: dup
    //   389: ldc 66
    //   391: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   394: aload_1
    //   395: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload 4
    //   400: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: aastore
    //   407: invokestatic 73	com/tencent/pb/common/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   410: new 44	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   417: aload_1
    //   418: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: aload 4
    //   423: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 78	java/lang/System:load	(Ljava/lang/String;)V
    //   432: iconst_1
    //   433: istore_2
    //   434: iload_2
    //   435: ifne +40 -> 475
    //   438: ldc 64
    //   440: iconst_1
    //   441: anewarray 4	java/lang/Object
    //   444: dup
    //   445: iconst_0
    //   446: new 44	java/lang/StringBuilder
    //   449: dup
    //   450: ldc 66
    //   452: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   455: aload_0
    //   456: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: ldc 87
    //   461: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: aastore
    //   468: invokestatic 73	com/tencent/pb/common/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   471: aload_0
    //   472: invokestatic 89	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   475: iconst_1
    //   476: ireturn
    //   477: ldc 91
    //   479: astore_1
    //   480: goto -394 -> 86
    //   483: astore 4
    //   485: new 44	java/lang/StringBuilder
    //   488: dup
    //   489: ldc 93
    //   491: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   494: aload_1
    //   495: invokevirtual 96	android/content/Context:getPackageName	()Ljava/lang/String;
    //   498: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: ldc 54
    //   503: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: astore_1
    //   510: goto -424 -> 86
    //   513: astore 4
    //   515: sipush 146
    //   518: iconst_3
    //   519: new 44	java/lang/StringBuilder
    //   522: dup
    //   523: ldc 98
    //   525: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   528: aload_1
    //   529: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: aload_0
    //   533: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   539: invokestatic 104	com/tencent/pb/common/c/f:y	(IILjava/lang/String;)V
    //   542: ldc 64
    //   544: iconst_1
    //   545: anewarray 4	java/lang/Object
    //   548: dup
    //   549: iconst_0
    //   550: new 44	java/lang/StringBuilder
    //   553: dup
    //   554: ldc 106
    //   556: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   559: aload_1
    //   560: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: aload_0
    //   564: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   570: aastore
    //   571: invokestatic 109	com/tencent/pb/common/c/c:x	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   574: iconst_0
    //   575: istore_2
    //   576: goto -397 -> 179
    //   579: astore 4
    //   581: ldc 64
    //   583: iconst_1
    //   584: anewarray 4	java/lang/Object
    //   587: dup
    //   588: iconst_0
    //   589: new 44	java/lang/StringBuilder
    //   592: dup
    //   593: ldc 106
    //   595: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   598: aload_1
    //   599: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: aload 5
    //   604: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: aastore
    //   611: invokestatic 109	com/tencent/pb/common/c/c:x	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   614: sipush 146
    //   617: iconst_3
    //   618: new 44	java/lang/StringBuilder
    //   621: dup
    //   622: ldc 111
    //   624: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   627: aload_1
    //   628: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: aload 5
    //   633: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   639: invokestatic 104	com/tencent/pb/common/c/f:y	(IILjava/lang/String;)V
    //   642: iload_2
    //   643: istore_3
    //   644: aload 5
    //   646: astore 4
    //   648: goto -336 -> 312
    //   651: astore 5
    //   653: ldc 64
    //   655: iconst_1
    //   656: anewarray 4	java/lang/Object
    //   659: dup
    //   660: iconst_0
    //   661: new 44	java/lang/StringBuilder
    //   664: dup
    //   665: ldc 106
    //   667: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   670: aload_1
    //   671: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: aload 4
    //   676: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   682: aastore
    //   683: invokestatic 109	com/tencent/pb/common/c/c:x	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   686: sipush 146
    //   689: iconst_3
    //   690: new 44	java/lang/StringBuilder
    //   693: dup
    //   694: ldc 113
    //   696: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   699: aload_1
    //   700: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: aload 4
    //   705: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   711: invokestatic 104	com/tencent/pb/common/c/f:y	(IILjava/lang/String;)V
    //   714: iload_3
    //   715: istore_2
    //   716: goto -282 -> 434
    //   719: astore_1
    //   720: ldc 64
    //   722: iconst_1
    //   723: anewarray 4	java/lang/Object
    //   726: dup
    //   727: iconst_0
    //   728: new 44	java/lang/StringBuilder
    //   731: dup
    //   732: ldc 106
    //   734: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   737: aload_0
    //   738: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   744: aastore
    //   745: invokestatic 109	com/tencent/pb/common/c/c:x	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   748: sipush 146
    //   751: iconst_3
    //   752: new 44	java/lang/StringBuilder
    //   755: dup
    //   756: ldc 115
    //   758: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   761: aload_0
    //   762: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   768: invokestatic 104	com/tencent/pb/common/c/f:y	(IILjava/lang/String;)V
    //   771: iconst_0
    //   772: ireturn
    //   773: ldc 64
    //   775: iconst_1
    //   776: anewarray 4	java/lang/Object
    //   779: dup
    //   780: iconst_0
    //   781: new 44	java/lang/StringBuilder
    //   784: dup
    //   785: ldc 66
    //   787: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   790: aload_0
    //   791: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: ldc 87
    //   796: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   802: aastore
    //   803: invokestatic 73	com/tencent/pb/common/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   806: aload_0
    //   807: invokestatic 89	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   810: goto -335 -> 475
    //   813: astore_1
    //   814: ldc 64
    //   816: iconst_1
    //   817: anewarray 4	java/lang/Object
    //   820: dup
    //   821: iconst_0
    //   822: new 44	java/lang/StringBuilder
    //   825: dup
    //   826: ldc 106
    //   828: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   831: aload_0
    //   832: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   838: aastore
    //   839: invokestatic 109	com/tencent/pb/common/c/c:x	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   842: sipush 146
    //   845: iconst_3
    //   846: new 44	java/lang/StringBuilder
    //   849: dup
    //   850: ldc 117
    //   852: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   855: aload_0
    //   856: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   862: invokestatic 104	com/tencent/pb/common/c/f:y	(IILjava/lang/String;)V
    //   865: iconst_0
    //   866: ireturn
    //   867: aload_0
    //   868: astore 4
    //   870: iload_2
    //   871: istore_3
    //   872: goto -560 -> 312
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	875	0	paramString	java.lang.String
    //   0	875	1	paramContext	android.content.Context
    //   46	825	2	i	int
    //   214	658	3	j	int
    //   11	411	4	str1	java.lang.String
    //   483	1	4	localException	java.lang.Exception
    //   513	1	4	localUnsatisfiedLinkError1	java.lang.UnsatisfiedLinkError
    //   579	1	4	localUnsatisfiedLinkError2	java.lang.UnsatisfiedLinkError
    //   646	223	4	str2	java.lang.String
    //   7	638	5	str3	java.lang.String
    //   651	1	5	localUnsatisfiedLinkError3	java.lang.UnsatisfiedLinkError
    // Exception table:
    //   from	to	target	type
    //   0	9	483	java/lang/Exception
    //   13	39	483	java/lang/Exception
    //   39	47	483	java/lang/Exception
    //   52	83	483	java/lang/Exception
    //   124	177	513	java/lang/UnsatisfiedLinkError
    //   251	306	579	java/lang/UnsatisfiedLinkError
    //   377	432	651	java/lang/UnsatisfiedLinkError
    //   438	475	719	java/lang/UnsatisfiedLinkError
    //   773	810	813	java/lang/UnsatisfiedLinkError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.pb.common.c.a
 * JD-Core Version:    0.7.0.1
 */