package com.tencent.xweb.xwalk;

public final class a
{
  /* Error */
  public static com.tencent.xweb.a.a hp(Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 7
    //   7: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: new 15	com/tencent/xweb/a$a
    //   13: dup
    //   14: invokespecial 19	com/tencent/xweb/a$a:<init>	()V
    //   17: astore_3
    //   18: aload_0
    //   19: instanceof 21
    //   22: ifne +13 -> 35
    //   25: ldc 7
    //   27: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: ldc 2
    //   32: monitorexit
    //   33: aload_3
    //   34: areturn
    //   35: aload_0
    //   36: checkcast 21	com/tencent/xweb/internal/b$b
    //   39: astore 4
    //   41: aload 4
    //   43: getfield 28	com/tencent/xweb/internal/b$b:aiiR	Ljava/lang/String;
    //   46: astore_2
    //   47: aload 4
    //   49: getfield 31	com/tencent/xweb/internal/b$b:aiiS	Ljava/lang/String;
    //   52: astore_0
    //   53: aload 4
    //   55: getfield 28	com/tencent/xweb/internal/b$b:aiiR	Ljava/lang/String;
    //   58: ldc 33
    //   60: invokevirtual 39	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   63: ifeq +253 -> 316
    //   66: invokestatic 45	com/tencent/xweb/a:keX	()Lcom/tencent/xweb/a;
    //   69: pop
    //   70: aload 4
    //   72: getfield 31	com/tencent/xweb/internal/b$b:aiiS	Ljava/lang/String;
    //   75: invokestatic 49	com/tencent/xweb/a:bHe	(Ljava/lang/String;)[Ljava/lang/String;
    //   78: astore_0
    //   79: aload_0
    //   80: ifnull +9 -> 89
    //   83: aload_0
    //   84: arraylength
    //   85: iconst_2
    //   86: if_icmpge +17 -> 103
    //   89: ldc 7
    //   91: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: goto -64 -> 30
    //   97: astore_0
    //   98: ldc 2
    //   100: monitorexit
    //   101: aload_0
    //   102: athrow
    //   103: aload_0
    //   104: iconst_0
    //   105: aaload
    //   106: astore_2
    //   107: aload_0
    //   108: iconst_1
    //   109: aaload
    //   110: astore_0
    //   111: ldc 51
    //   113: new 53	java/lang/StringBuilder
    //   116: dup
    //   117: ldc 55
    //   119: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   122: aload_2
    //   123: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc 64
    //   128: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_0
    //   132: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 74	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload_2
    //   142: invokevirtual 78	java/lang/String:hashCode	()I
    //   145: lookupswitch	default:+174->319, -844092179:+55->200, -638079348:+69->214, 1108642905:+43->188
    //   181: iconst_4
    //   182: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: goto -155 -> 30
    //   188: aload_2
    //   189: ldc 80
    //   191: invokevirtual 39	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   194: ifeq +125 -> 319
    //   197: goto +124 -> 321
    //   200: aload_2
    //   201: ldc 82
    //   203: invokevirtual 39	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   206: ifeq +113 -> 319
    //   209: iconst_1
    //   210: istore_1
    //   211: goto +110 -> 321
    //   214: aload_2
    //   215: ldc 84
    //   217: invokevirtual 39	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   220: ifeq +99 -> 319
    //   223: iconst_2
    //   224: istore_1
    //   225: goto +96 -> 321
    //   228: aload_3
    //   229: iconst_1
    //   230: putfield 88	com/tencent/xweb/a$a:aiej	Z
    //   233: aload_0
    //   234: invokestatic 94	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   237: istore_1
    //   238: invokestatic 100	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   241: iload_1
    //   242: invokestatic 106	com/tencent/xweb/xwalk/updater/j:bK	(Landroid/content/Context;I)I
    //   245: pop
    //   246: ldc 7
    //   248: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   251: goto -221 -> 30
    //   254: astore_2
    //   255: ldc 51
    //   257: new 53	java/lang/StringBuilder
    //   260: dup
    //   261: ldc 108
    //   263: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   266: aload_0
    //   267: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: ldc 110
    //   272: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_2
    //   276: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 116	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: ldc 7
    //   287: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   290: goto -260 -> 30
    //   293: aload_3
    //   294: iconst_1
    //   295: putfield 88	com/tencent/xweb/a$a:aiej	Z
    //   298: invokestatic 122	com/tencent/xweb/xwalk/updater/f:kki	()Z
    //   301: pop
    //   302: goto -122 -> 180
    //   305: aload_3
    //   306: iconst_1
    //   307: putfield 88	com/tencent/xweb/a$a:aiej	Z
    //   310: invokestatic 127	com/tencent/xweb/xwalk/o:kjm	()V
    //   313: goto -133 -> 180
    //   316: goto -205 -> 111
    //   319: iconst_m1
    //   320: istore_1
    //   321: iload_1
    //   322: tableswitch	default:+26 -> 348, 0:+-94->228, 1:+-29->293, 2:+-17->305
    //   349: impdep2
    //   350: pop2
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	paramObject	Object
    //   1	321	1	i	int
    //   46	169	2	str	java.lang.String
    //   254	22	2	localObject	Object
    //   17	289	3	locala	com.tencent.xweb.a.a
    //   39	32	4	localb	com.tencent.xweb.internal.b.b
    // Exception table:
    //   from	to	target	type
    //   5	30	97	finally
    //   35	79	97	finally
    //   83	89	97	finally
    //   89	94	97	finally
    //   111	180	97	finally
    //   180	185	97	finally
    //   188	197	97	finally
    //   200	209	97	finally
    //   214	223	97	finally
    //   228	233	97	finally
    //   238	251	97	finally
    //   255	290	97	finally
    //   293	302	97	finally
    //   305	313	97	finally
    //   233	238	254	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a
 * JD-Core Version:    0.7.0.1
 */