package com.tencent.soter.a.g;

final class h$a$3
  implements Runnable
{
  h$a$3(h.a parama) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	com/tencent/soter/a/g/h$a$3:wQA	Lcom/tencent/soter/a/g/h$a;
    //   4: getfield 29	com/tencent/soter/a/g/h$a:wQw	Lcom/tencent/soter/a/g/h;
    //   7: getfield 35	com/tencent/soter/a/g/h:qRa	Ljava/lang/String;
    //   10: invokestatic 41	com/tencent/soter/core/c/g:bl	(Ljava/lang/String;)Z
    //   13: ifne +380 -> 393
    //   16: invokestatic 47	com/tencent/soter/core/a:cPf	()I
    //   19: iconst_1
    //   20: if_icmpne +115 -> 135
    //   23: aload_0
    //   24: getfield 17	com/tencent/soter/a/g/h$a$3:wQA	Lcom/tencent/soter/a/g/h$a;
    //   27: getfield 29	com/tencent/soter/a/g/h$a:wQw	Lcom/tencent/soter/a/g/h;
    //   30: astore_3
    //   31: aload_0
    //   32: getfield 17	com/tencent/soter/a/g/h$a$3:wQA	Lcom/tencent/soter/a/g/h$a;
    //   35: getfield 51	com/tencent/soter/a/g/h$a:wPs	J
    //   38: lstore_1
    //   39: aload_3
    //   40: lload_1
    //   41: invokestatic 55	com/tencent/soter/core/a:im	(J)[B
    //   44: invokestatic 59	com/tencent/soter/core/a:bR	([B)Lcom/tencent/soter/core/c/j;
    //   47: putfield 63	com/tencent/soter/a/g/h:wQr	Lcom/tencent/soter/core/c/j;
    //   50: aload_3
    //   51: getfield 67	com/tencent/soter/a/g/h:wQn	Lcom/tencent/soter/a/f/f;
    //   54: ifnull +8 -> 62
    //   57: aload_3
    //   58: invokevirtual 70	com/tencent/soter/a/g/h:cPM	()V
    //   61: return
    //   62: ldc 72
    //   64: ldc 74
    //   66: iconst_0
    //   67: anewarray 4	java/lang/Object
    //   70: invokestatic 80	com/tencent/soter/core/c/d:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   73: aload_3
    //   74: new 82	com/tencent/soter/a/b/a
    //   77: dup
    //   78: aload_3
    //   79: getfield 63	com/tencent/soter/a/g/h:wQr	Lcom/tencent/soter/core/c/j;
    //   82: invokespecial 85	com/tencent/soter/a/b/a:<init>	(Lcom/tencent/soter/core/c/j;)V
    //   85: invokevirtual 89	com/tencent/soter/a/g/h:b	(Lcom/tencent/soter/a/b/e;)V
    //   88: return
    //   89: astore 4
    //   91: ldc 72
    //   93: ldc 91
    //   95: iconst_1
    //   96: anewarray 4	java/lang/Object
    //   99: dup
    //   100: iconst_0
    //   101: aload 4
    //   103: invokevirtual 95	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   106: aastore
    //   107: invokestatic 98	com/tencent/soter/core/c/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   110: ldc 72
    //   112: aload 4
    //   114: ldc 100
    //   116: invokestatic 104	com/tencent/soter/core/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   119: aload_3
    //   120: new 82	com/tencent/soter/a/b/a
    //   123: dup
    //   124: bipush 22
    //   126: ldc 106
    //   128: invokespecial 109	com/tencent/soter/a/b/a:<init>	(ILjava/lang/String;)V
    //   131: invokevirtual 89	com/tencent/soter/a/g/h:b	(Lcom/tencent/soter/a/b/e;)V
    //   134: return
    //   135: aload_0
    //   136: getfield 17	com/tencent/soter/a/g/h$a$3:wQA	Lcom/tencent/soter/a/g/h$a;
    //   139: getfield 113	com/tencent/soter/a/g/h$a:wQx	Ljava/security/Signature;
    //   142: aload_0
    //   143: getfield 17	com/tencent/soter/a/g/h$a$3:wQA	Lcom/tencent/soter/a/g/h$a;
    //   146: getfield 29	com/tencent/soter/a/g/h$a:wQw	Lcom/tencent/soter/a/g/h;
    //   149: getfield 35	com/tencent/soter/a/g/h:qRa	Ljava/lang/String;
    //   152: ldc 115
    //   154: invokestatic 121	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   157: invokevirtual 127	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   160: invokevirtual 133	java/security/Signature:update	([B)V
    //   163: aload_0
    //   164: getfield 17	com/tencent/soter/a/g/h$a$3:wQA	Lcom/tencent/soter/a/g/h$a;
    //   167: getfield 29	com/tencent/soter/a/g/h$a:wQw	Lcom/tencent/soter/a/g/h;
    //   170: astore_3
    //   171: aload_0
    //   172: getfield 17	com/tencent/soter/a/g/h$a$3:wQA	Lcom/tencent/soter/a/g/h$a;
    //   175: getfield 113	com/tencent/soter/a/g/h$a:wQx	Ljava/security/Signature;
    //   178: astore 4
    //   180: aload_3
    //   181: aload 4
    //   183: invokevirtual 137	java/security/Signature:sign	()[B
    //   186: invokestatic 59	com/tencent/soter/core/a:bR	([B)Lcom/tencent/soter/core/c/j;
    //   189: putfield 63	com/tencent/soter/a/g/h:wQr	Lcom/tencent/soter/core/c/j;
    //   192: aload_3
    //   193: getfield 67	com/tencent/soter/a/g/h:wQn	Lcom/tencent/soter/a/f/f;
    //   196: ifnull +170 -> 366
    //   199: aload_3
    //   200: invokevirtual 70	com/tencent/soter/a/g/h:cPM	()V
    //   203: return
    //   204: astore 4
    //   206: ldc 72
    //   208: ldc 139
    //   210: iconst_1
    //   211: anewarray 4	java/lang/Object
    //   214: dup
    //   215: iconst_0
    //   216: aload 4
    //   218: invokevirtual 140	java/security/SignatureException:getMessage	()Ljava/lang/String;
    //   221: aastore
    //   222: invokestatic 98	com/tencent/soter/core/c/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   225: ldc 72
    //   227: aload 4
    //   229: ldc 100
    //   231: invokestatic 104	com/tencent/soter/core/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   234: aload_3
    //   235: new 82	com/tencent/soter/a/b/a
    //   238: dup
    //   239: bipush 22
    //   241: ldc 106
    //   243: invokespecial 109	com/tencent/soter/a/b/a:<init>	(ILjava/lang/String;)V
    //   246: invokevirtual 89	com/tencent/soter/a/g/h:b	(Lcom/tencent/soter/a/b/e;)V
    //   249: return
    //   250: astore_3
    //   251: ldc 72
    //   253: ldc 142
    //   255: iconst_0
    //   256: anewarray 4	java/lang/Object
    //   259: invokestatic 98	com/tencent/soter/core/c/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   262: ldc 72
    //   264: aload_3
    //   265: ldc 144
    //   267: invokestatic 104	com/tencent/soter/core/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   270: aload_0
    //   271: getfield 17	com/tencent/soter/a/g/h$a$3:wQA	Lcom/tencent/soter/a/g/h$a;
    //   274: sipush -1000
    //   277: ldc 146
    //   279: invokevirtual 150	com/tencent/soter/a/g/h$a:onAuthenticationError	(ILjava/lang/CharSequence;)V
    //   282: return
    //   283: astore_3
    //   284: ldc 72
    //   286: ldc 152
    //   288: iconst_0
    //   289: anewarray 4	java/lang/Object
    //   292: invokestatic 98	com/tencent/soter/core/c/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   295: ldc 72
    //   297: aload_3
    //   298: ldc 152
    //   300: invokestatic 104	com/tencent/soter/core/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   303: ldc 72
    //   305: ldc 154
    //   307: iconst_1
    //   308: anewarray 4	java/lang/Object
    //   311: dup
    //   312: iconst_0
    //   313: aload_0
    //   314: getfield 17	com/tencent/soter/a/g/h$a$3:wQA	Lcom/tencent/soter/a/g/h$a;
    //   317: getfield 29	com/tencent/soter/a/g/h$a:wQw	Lcom/tencent/soter/a/g/h;
    //   320: getfield 157	com/tencent/soter/a/g/h:wPD	Ljava/lang/String;
    //   323: aastore
    //   324: invokestatic 98	com/tencent/soter/core/c/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   327: aload_0
    //   328: getfield 17	com/tencent/soter/a/g/h$a$3:wQA	Lcom/tencent/soter/a/g/h$a;
    //   331: getfield 29	com/tencent/soter/a/g/h$a:wQw	Lcom/tencent/soter/a/g/h;
    //   334: getfield 157	com/tencent/soter/a/g/h:wPD	Ljava/lang/String;
    //   337: iconst_0
    //   338: invokestatic 160	com/tencent/soter/core/a:bR	(Ljava/lang/String;Z)Lcom/tencent/soter/core/c/f;
    //   341: pop
    //   342: aload_0
    //   343: getfield 17	com/tencent/soter/a/g/h$a$3:wQA	Lcom/tencent/soter/a/g/h$a;
    //   346: getfield 29	com/tencent/soter/a/g/h$a:wQw	Lcom/tencent/soter/a/g/h;
    //   349: new 82	com/tencent/soter/a/b/a
    //   352: dup
    //   353: bipush 30
    //   355: ldc 162
    //   357: invokespecial 109	com/tencent/soter/a/b/a:<init>	(ILjava/lang/String;)V
    //   360: invokevirtual 89	com/tencent/soter/a/g/h:b	(Lcom/tencent/soter/a/b/e;)V
    //   363: goto -200 -> 163
    //   366: ldc 72
    //   368: ldc 74
    //   370: iconst_0
    //   371: anewarray 4	java/lang/Object
    //   374: invokestatic 80	com/tencent/soter/core/c/d:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   377: aload_3
    //   378: new 82	com/tencent/soter/a/b/a
    //   381: dup
    //   382: aload_3
    //   383: getfield 63	com/tencent/soter/a/g/h:wQr	Lcom/tencent/soter/core/c/j;
    //   386: invokespecial 85	com/tencent/soter/a/b/a:<init>	(Lcom/tencent/soter/core/c/j;)V
    //   389: invokevirtual 89	com/tencent/soter/a/g/h:b	(Lcom/tencent/soter/a/b/e;)V
    //   392: return
    //   393: ldc 72
    //   395: ldc 164
    //   397: iconst_0
    //   398: anewarray 4	java/lang/Object
    //   401: invokestatic 98	com/tencent/soter/core/c/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   404: aload_0
    //   405: getfield 17	com/tencent/soter/a/g/h$a$3:wQA	Lcom/tencent/soter/a/g/h$a;
    //   408: sipush -1000
    //   411: ldc 166
    //   413: invokevirtual 150	com/tencent/soter/a/g/h$a:onAuthenticationError	(ILjava/lang/CharSequence;)V
    //   416: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	417	0	this	3
    //   38	3	1	l	long
    //   30	205	3	localh	h
    //   250	15	3	localException1	java.lang.Exception
    //   283	100	3	localSignatureException1	java.security.SignatureException
    //   89	24	4	localException2	java.lang.Exception
    //   178	4	4	localSignature	java.security.Signature
    //   204	24	4	localSignatureException2	java.security.SignatureException
    // Exception table:
    //   from	to	target	type
    //   39	61	89	java/lang/Exception
    //   62	88	89	java/lang/Exception
    //   180	203	204	java/security/SignatureException
    //   366	392	204	java/security/SignatureException
    //   163	180	250	java/lang/Exception
    //   180	203	250	java/lang/Exception
    //   206	249	250	java/lang/Exception
    //   366	392	250	java/lang/Exception
    //   135	163	283	java/security/SignatureException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.soter.a.g.h.a.3
 * JD-Core Version:    0.7.0.1
 */