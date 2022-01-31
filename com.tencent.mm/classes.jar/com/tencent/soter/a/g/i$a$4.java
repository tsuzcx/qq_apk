package com.tencent.soter.a.g;

final class i$a$4
  implements Runnable
{
  i$a$4(i.a parama) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: sipush 10528
    //   3: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 17	com/tencent/soter/a/g/i$a$4:Boh	Lcom/tencent/soter/a/g/i$a;
    //   10: getfield 36	com/tencent/soter/a/g/i$a:Bog	Lcom/tencent/soter/a/g/i;
    //   13: getfield 42	com/tencent/soter/a/g/i:uGi	Ljava/lang/String;
    //   16: invokestatic 48	com/tencent/soter/core/c/g:isNullOrNil	(Ljava/lang/String;)Z
    //   19: ifne +430 -> 449
    //   22: invokestatic 54	com/tencent/soter/core/a:dUY	()I
    //   25: iconst_1
    //   26: if_icmpne +141 -> 167
    //   29: aload_0
    //   30: getfield 17	com/tencent/soter/a/g/i$a$4:Boh	Lcom/tencent/soter/a/g/i$a;
    //   33: getfield 36	com/tencent/soter/a/g/i$a:Bog	Lcom/tencent/soter/a/g/i;
    //   36: astore_3
    //   37: aload_0
    //   38: getfield 17	com/tencent/soter/a/g/i$a$4:Boh	Lcom/tencent/soter/a/g/i$a;
    //   41: invokestatic 58	com/tencent/soter/a/g/i$a:a	(Lcom/tencent/soter/a/g/i$a;)Ljava/security/Signature;
    //   44: pop
    //   45: aload_0
    //   46: getfield 17	com/tencent/soter/a/g/i$a$4:Boh	Lcom/tencent/soter/a/g/i$a;
    //   49: invokestatic 62	com/tencent/soter/a/g/i$a:b	(Lcom/tencent/soter/a/g/i$a;)J
    //   52: lstore_1
    //   53: aload_3
    //   54: lload_1
    //   55: invokestatic 66	com/tencent/soter/core/a:oY	(J)[B
    //   58: invokestatic 70	com/tencent/soter/core/a:cr	([B)Lcom/tencent/soter/core/c/j;
    //   61: putfield 74	com/tencent/soter/a/g/i:BnR	Lcom/tencent/soter/core/c/j;
    //   64: aload_3
    //   65: getfield 78	com/tencent/soter/a/g/i:BnN	Lcom/tencent/soter/a/f/f;
    //   68: ifnull +14 -> 82
    //   71: aload_3
    //   72: invokevirtual 81	com/tencent/soter/a/g/i:dVI	()V
    //   75: sipush 10528
    //   78: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: return
    //   82: ldc 86
    //   84: ldc 88
    //   86: iconst_0
    //   87: anewarray 4	java/lang/Object
    //   90: invokestatic 93	com/tencent/soter/core/c/d:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   93: aload_3
    //   94: new 95	com/tencent/soter/a/b/a
    //   97: dup
    //   98: aload_3
    //   99: getfield 74	com/tencent/soter/a/g/i:BnR	Lcom/tencent/soter/core/c/j;
    //   102: invokespecial 98	com/tencent/soter/a/b/a:<init>	(Lcom/tencent/soter/core/c/j;)V
    //   105: invokevirtual 101	com/tencent/soter/a/g/i:b	(Lcom/tencent/soter/a/b/e;)V
    //   108: sipush 10528
    //   111: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: return
    //   115: astore 4
    //   117: ldc 86
    //   119: ldc 103
    //   121: iconst_1
    //   122: anewarray 4	java/lang/Object
    //   125: dup
    //   126: iconst_0
    //   127: aload 4
    //   129: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   132: aastore
    //   133: invokestatic 110	com/tencent/soter/core/c/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   136: ldc 86
    //   138: aload 4
    //   140: ldc 112
    //   142: invokestatic 115	com/tencent/soter/core/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   145: aload_3
    //   146: new 95	com/tencent/soter/a/b/a
    //   149: dup
    //   150: bipush 22
    //   152: ldc 117
    //   154: invokespecial 120	com/tencent/soter/a/b/a:<init>	(ILjava/lang/String;)V
    //   157: invokevirtual 101	com/tencent/soter/a/g/i:b	(Lcom/tencent/soter/a/b/e;)V
    //   160: sipush 10528
    //   163: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: return
    //   167: aload_0
    //   168: getfield 17	com/tencent/soter/a/g/i$a$4:Boh	Lcom/tencent/soter/a/g/i$a;
    //   171: invokestatic 58	com/tencent/soter/a/g/i$a:a	(Lcom/tencent/soter/a/g/i$a;)Ljava/security/Signature;
    //   174: aload_0
    //   175: getfield 17	com/tencent/soter/a/g/i$a$4:Boh	Lcom/tencent/soter/a/g/i$a;
    //   178: getfield 36	com/tencent/soter/a/g/i$a:Bog	Lcom/tencent/soter/a/g/i;
    //   181: getfield 42	com/tencent/soter/a/g/i:uGi	Ljava/lang/String;
    //   184: ldc 122
    //   186: invokestatic 128	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   189: invokevirtual 134	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   192: invokevirtual 140	java/security/Signature:update	([B)V
    //   195: aload_0
    //   196: getfield 17	com/tencent/soter/a/g/i$a$4:Boh	Lcom/tencent/soter/a/g/i$a;
    //   199: getfield 36	com/tencent/soter/a/g/i$a:Bog	Lcom/tencent/soter/a/g/i;
    //   202: astore_3
    //   203: aload_0
    //   204: getfield 17	com/tencent/soter/a/g/i$a$4:Boh	Lcom/tencent/soter/a/g/i$a;
    //   207: invokestatic 58	com/tencent/soter/a/g/i$a:a	(Lcom/tencent/soter/a/g/i$a;)Ljava/security/Signature;
    //   210: astore 4
    //   212: aload_3
    //   213: aload 4
    //   215: invokevirtual 144	java/security/Signature:sign	()[B
    //   218: invokestatic 70	com/tencent/soter/core/a:cr	([B)Lcom/tencent/soter/core/c/j;
    //   221: putfield 74	com/tencent/soter/a/g/i:BnR	Lcom/tencent/soter/core/c/j;
    //   224: aload_3
    //   225: getfield 78	com/tencent/soter/a/g/i:BnN	Lcom/tencent/soter/a/f/f;
    //   228: ifnull +149 -> 377
    //   231: aload_3
    //   232: invokevirtual 81	com/tencent/soter/a/g/i:dVI	()V
    //   235: sipush 10528
    //   238: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   241: return
    //   242: astore 4
    //   244: ldc 86
    //   246: ldc 146
    //   248: iconst_1
    //   249: anewarray 4	java/lang/Object
    //   252: dup
    //   253: iconst_0
    //   254: aload 4
    //   256: invokevirtual 147	java/security/SignatureException:getMessage	()Ljava/lang/String;
    //   259: aastore
    //   260: invokestatic 110	com/tencent/soter/core/c/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   263: ldc 86
    //   265: aload 4
    //   267: ldc 112
    //   269: invokestatic 115	com/tencent/soter/core/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   272: aload_3
    //   273: new 95	com/tencent/soter/a/b/a
    //   276: dup
    //   277: bipush 22
    //   279: ldc 117
    //   281: invokespecial 120	com/tencent/soter/a/b/a:<init>	(ILjava/lang/String;)V
    //   284: invokevirtual 101	com/tencent/soter/a/g/i:b	(Lcom/tencent/soter/a/b/e;)V
    //   287: sipush 10528
    //   290: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   293: return
    //   294: astore_3
    //   295: ldc 86
    //   297: ldc 149
    //   299: iconst_0
    //   300: anewarray 4	java/lang/Object
    //   303: invokestatic 110	com/tencent/soter/core/c/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   306: ldc 86
    //   308: aload_3
    //   309: ldc 149
    //   311: invokestatic 115	com/tencent/soter/core/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   314: ldc 86
    //   316: ldc 151
    //   318: iconst_1
    //   319: anewarray 4	java/lang/Object
    //   322: dup
    //   323: iconst_0
    //   324: aload_0
    //   325: getfield 17	com/tencent/soter/a/g/i$a$4:Boh	Lcom/tencent/soter/a/g/i$a;
    //   328: getfield 36	com/tencent/soter/a/g/i$a:Bog	Lcom/tencent/soter/a/g/i;
    //   331: getfield 154	com/tencent/soter/a/g/i:Bnd	Ljava/lang/String;
    //   334: aastore
    //   335: invokestatic 110	com/tencent/soter/core/c/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   338: aload_0
    //   339: getfield 17	com/tencent/soter/a/g/i$a$4:Boh	Lcom/tencent/soter/a/g/i$a;
    //   342: getfield 36	com/tencent/soter/a/g/i$a:Bog	Lcom/tencent/soter/a/g/i;
    //   345: getfield 154	com/tencent/soter/a/g/i:Bnd	Ljava/lang/String;
    //   348: iconst_0
    //   349: invokestatic 158	com/tencent/soter/core/a:cu	(Ljava/lang/String;Z)Lcom/tencent/soter/core/c/f;
    //   352: pop
    //   353: aload_0
    //   354: getfield 17	com/tencent/soter/a/g/i$a$4:Boh	Lcom/tencent/soter/a/g/i$a;
    //   357: getfield 36	com/tencent/soter/a/g/i$a:Bog	Lcom/tencent/soter/a/g/i;
    //   360: new 95	com/tencent/soter/a/b/a
    //   363: dup
    //   364: bipush 30
    //   366: ldc 160
    //   368: invokespecial 120	com/tencent/soter/a/b/a:<init>	(ILjava/lang/String;)V
    //   371: invokevirtual 101	com/tencent/soter/a/g/i:b	(Lcom/tencent/soter/a/b/e;)V
    //   374: goto -179 -> 195
    //   377: ldc 86
    //   379: ldc 88
    //   381: iconst_0
    //   382: anewarray 4	java/lang/Object
    //   385: invokestatic 93	com/tencent/soter/core/c/d:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   388: aload_3
    //   389: new 95	com/tencent/soter/a/b/a
    //   392: dup
    //   393: aload_3
    //   394: getfield 74	com/tencent/soter/a/g/i:BnR	Lcom/tencent/soter/core/c/j;
    //   397: invokespecial 98	com/tencent/soter/a/b/a:<init>	(Lcom/tencent/soter/core/c/j;)V
    //   400: invokevirtual 101	com/tencent/soter/a/g/i:b	(Lcom/tencent/soter/a/b/e;)V
    //   403: sipush 10528
    //   406: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   409: return
    //   410: astore_3
    //   411: ldc 86
    //   413: ldc 162
    //   415: iconst_0
    //   416: anewarray 4	java/lang/Object
    //   419: invokestatic 110	com/tencent/soter/core/c/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   422: ldc 86
    //   424: aload_3
    //   425: ldc 164
    //   427: invokestatic 115	com/tencent/soter/core/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   430: aload_0
    //   431: getfield 17	com/tencent/soter/a/g/i$a$4:Boh	Lcom/tencent/soter/a/g/i$a;
    //   434: sipush -1000
    //   437: ldc 166
    //   439: invokevirtual 170	com/tencent/soter/a/g/i$a:onAuthenticationError	(ILjava/lang/CharSequence;)V
    //   442: sipush 10528
    //   445: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   448: return
    //   449: ldc 86
    //   451: ldc 172
    //   453: iconst_0
    //   454: anewarray 4	java/lang/Object
    //   457: invokestatic 110	com/tencent/soter/core/c/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   460: aload_0
    //   461: getfield 17	com/tencent/soter/a/g/i$a$4:Boh	Lcom/tencent/soter/a/g/i$a;
    //   464: sipush -1000
    //   467: ldc 174
    //   469: invokevirtual 170	com/tencent/soter/a/g/i$a:onAuthenticationError	(ILjava/lang/CharSequence;)V
    //   472: sipush 10528
    //   475: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   478: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	479	0	this	4
    //   52	3	1	l	long
    //   36	237	3	locali	i
    //   294	100	3	localSignatureException1	java.security.SignatureException
    //   410	15	3	localException1	java.lang.Exception
    //   115	24	4	localException2	java.lang.Exception
    //   210	4	4	localSignature	java.security.Signature
    //   242	24	4	localSignatureException2	java.security.SignatureException
    // Exception table:
    //   from	to	target	type
    //   53	81	115	java/lang/Exception
    //   82	108	115	java/lang/Exception
    //   212	241	242	java/security/SignatureException
    //   377	403	242	java/security/SignatureException
    //   167	195	294	java/security/SignatureException
    //   195	212	410	java/lang/Exception
    //   212	241	410	java/lang/Exception
    //   244	287	410	java/lang/Exception
    //   377	403	410	java/lang/Exception
    //   403	409	410	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.soter.a.g.i.a.4
 * JD-Core Version:    0.7.0.1
 */