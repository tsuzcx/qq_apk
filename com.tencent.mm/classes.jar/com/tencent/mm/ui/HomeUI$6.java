package com.tencent.mm.ui;

import android.os.MessageQueue.IdleHandler;

final class HomeUI$6
  implements MessageQueue.IdleHandler
{
  HomeUI$6(HomeUI paramHomeUI) {}
  
  /* Error */
  public final boolean queueIdle()
  {
    // Byte code:
    //   0: invokestatic 26	com/tencent/mm/model/au:Hx	()Lcom/tencent/mm/model/c;
    //   3: pop
    //   4: invokestatic 32	com/tencent/mm/model/c:Dz	()Lcom/tencent/mm/storage/z;
    //   7: bipush 15
    //   9: aconst_null
    //   10: invokevirtual 38	com/tencent/mm/storage/z:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   13: checkcast 40	java/lang/Integer
    //   16: invokestatic 46	com/tencent/mm/platformtools/ah:g	(Ljava/lang/Integer;)I
    //   19: ifne +18 -> 37
    //   22: iconst_1
    //   23: istore_1
    //   24: iload_1
    //   25: ifeq +17 -> 42
    //   28: ldc 48
    //   30: ldc 50
    //   32: invokestatic 56	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: iconst_0
    //   36: ireturn
    //   37: iconst_0
    //   38: istore_1
    //   39: goto -15 -> 24
    //   42: getstatic 62	com/tencent/mm/model/at:dVC	Lcom/tencent/mm/model/at;
    //   45: ldc 64
    //   47: ldc 66
    //   49: invokevirtual 70	com/tencent/mm/model/at:L	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   52: astore_3
    //   53: invokestatic 73	com/tencent/mm/model/au:Hz	()Z
    //   56: ifne +12 -> 68
    //   59: aload_3
    //   60: ldc 66
    //   62: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   65: ifne +28 -> 93
    //   68: invokestatic 83	com/tencent/mm/model/au:Dk	()Lcom/tencent/mm/ah/p;
    //   71: new 85	com/tencent/mm/model/bi
    //   74: dup
    //   75: new 87	com/tencent/mm/ui/HomeUI$6$1
    //   78: dup
    //   79: aload_0
    //   80: invokespecial 90	com/tencent/mm/ui/HomeUI$6$1:<init>	(Lcom/tencent/mm/ui/HomeUI$6;)V
    //   83: ldc 92
    //   85: invokespecial 95	com/tencent/mm/model/bi:<init>	(Lcom/tencent/mm/model/bi$a;Ljava/lang/String;)V
    //   88: iconst_0
    //   89: invokevirtual 101	com/tencent/mm/ah/p:a	(Lcom/tencent/mm/ah/m;I)Z
    //   92: pop
    //   93: new 103	com/tencent/mm/booter/y$1
    //   96: dup
    //   97: new 105	com/tencent/mm/booter/y
    //   100: dup
    //   101: aload_0
    //   102: getfield 14	com/tencent/mm/ui/HomeUI$6:uKu	Lcom/tencent/mm/ui/HomeUI;
    //   105: invokestatic 109	com/tencent/mm/ui/HomeUI:d	(Lcom/tencent/mm/ui/HomeUI;)Lcom/tencent/mm/ui/MMFragmentActivity;
    //   108: invokespecial 112	com/tencent/mm/booter/y:<init>	(Landroid/content/Context;)V
    //   111: invokespecial 115	com/tencent/mm/booter/y$1:<init>	(Lcom/tencent/mm/booter/y;)V
    //   114: ldc 117
    //   116: invokestatic 123	com/tencent/mm/sdk/f/e:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   119: iconst_1
    //   120: invokestatic 129	com/tencent/mm/booter/o:onCreate	(Z)V
    //   123: invokestatic 132	com/tencent/mm/ui/HomeUI:cyL	()V
    //   126: invokestatic 137	com/tencent/mm/plugin/report/service/f:bwW	()V
    //   129: invokestatic 143	com/tencent/mm/as/n:OA	()Lcom/tencent/mm/as/n;
    //   132: getfield 147	com/tencent/mm/as/n:epA	Lcom/tencent/mm/as/n$c;
    //   135: astore_3
    //   136: aload_3
    //   137: getfield 153	com/tencent/mm/as/n$c:epP	Ljava/util/LinkedList;
    //   140: invokevirtual 159	java/util/LinkedList:size	()I
    //   143: ifgt +13 -> 156
    //   146: aload_3
    //   147: getfield 162	com/tencent/mm/as/n$c:epO	Ljava/util/LinkedList;
    //   150: invokevirtual 159	java/util/LinkedList:size	()I
    //   153: ifle +22 -> 175
    //   156: aload_3
    //   157: invokevirtual 165	com/tencent/mm/as/n$c:OD	()V
    //   160: invokestatic 171	android/os/Looper:myQueue	()Landroid/os/MessageQueue;
    //   163: aload_0
    //   164: getfield 14	com/tencent/mm/ui/HomeUI$6:uKu	Lcom/tencent/mm/ui/HomeUI;
    //   167: getfield 175	com/tencent/mm/ui/HomeUI:uKq	Landroid/os/MessageQueue$IdleHandler;
    //   170: invokevirtual 181	android/os/MessageQueue:removeIdleHandler	(Landroid/os/MessageQueue$IdleHandler;)V
    //   173: iconst_0
    //   174: ireturn
    //   175: invokestatic 187	com/tencent/mm/kernel/g:DP	()Lcom/tencent/mm/kernel/e;
    //   178: invokevirtual 190	com/tencent/mm/kernel/e:Dz	()Lcom/tencent/mm/storage/z;
    //   181: ldc 191
    //   183: ldc 66
    //   185: invokevirtual 38	com/tencent/mm/storage/z:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   188: checkcast 75	java/lang/String
    //   191: astore 5
    //   193: invokestatic 187	com/tencent/mm/kernel/g:DP	()Lcom/tencent/mm/kernel/e;
    //   196: invokevirtual 190	com/tencent/mm/kernel/e:Dz	()Lcom/tencent/mm/storage/z;
    //   199: ldc 192
    //   201: ldc 66
    //   203: invokevirtual 38	com/tencent/mm/storage/z:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   206: checkcast 75	java/lang/String
    //   209: astore 4
    //   211: aload 5
    //   213: invokestatic 198	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   216: ifne +54 -> 270
    //   219: aload 5
    //   221: ldc 200
    //   223: invokevirtual 204	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   226: astore 5
    //   228: aload_3
    //   229: monitorenter
    //   230: aload 5
    //   232: arraylength
    //   233: istore_2
    //   234: iconst_0
    //   235: istore_1
    //   236: iload_1
    //   237: iload_2
    //   238: if_icmpge +30 -> 268
    //   241: aload 5
    //   243: iload_1
    //   244: aaload
    //   245: invokestatic 208	com/tencent/mm/as/n$c:mk	(Ljava/lang/String;)Lcom/tencent/mm/as/n$b;
    //   248: astore 6
    //   250: aload 6
    //   252: ifnull +135 -> 387
    //   255: aload_3
    //   256: getfield 153	com/tencent/mm/as/n$c:epP	Ljava/util/LinkedList;
    //   259: aload 6
    //   261: invokevirtual 211	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   264: pop
    //   265: goto +122 -> 387
    //   268: aload_3
    //   269: monitorexit
    //   270: aload 4
    //   272: invokestatic 198	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   275: ifne +65 -> 340
    //   278: aload 4
    //   280: ldc 200
    //   282: invokevirtual 204	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   285: astore 4
    //   287: aload_3
    //   288: monitorenter
    //   289: aload 4
    //   291: arraylength
    //   292: istore_2
    //   293: iconst_0
    //   294: istore_1
    //   295: iload_1
    //   296: iload_2
    //   297: if_icmpge +41 -> 338
    //   300: aload 4
    //   302: iload_1
    //   303: aaload
    //   304: invokestatic 214	com/tencent/mm/as/n$c:mj	(Ljava/lang/String;)Lcom/tencent/mm/as/n$b;
    //   307: astore 5
    //   309: aload 5
    //   311: ifnull +13 -> 324
    //   314: aload_3
    //   315: getfield 162	com/tencent/mm/as/n$c:epO	Ljava/util/LinkedList;
    //   318: aload 5
    //   320: invokevirtual 211	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   323: pop
    //   324: iload_1
    //   325: iconst_1
    //   326: iadd
    //   327: istore_1
    //   328: goto -33 -> 295
    //   331: astore 4
    //   333: aload_3
    //   334: monitorexit
    //   335: aload 4
    //   337: athrow
    //   338: aload_3
    //   339: monitorexit
    //   340: ldc 216
    //   342: ldc 218
    //   344: iconst_2
    //   345: anewarray 4	java/lang/Object
    //   348: dup
    //   349: iconst_0
    //   350: aload_3
    //   351: getfield 162	com/tencent/mm/as/n$c:epO	Ljava/util/LinkedList;
    //   354: invokevirtual 159	java/util/LinkedList:size	()I
    //   357: invokestatic 222	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   360: aastore
    //   361: dup
    //   362: iconst_1
    //   363: aload_3
    //   364: getfield 153	com/tencent/mm/as/n$c:epP	Ljava/util/LinkedList;
    //   367: invokevirtual 159	java/util/LinkedList:size	()I
    //   370: invokestatic 222	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   373: aastore
    //   374: invokestatic 226	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   377: goto -221 -> 156
    //   380: astore 4
    //   382: aload_3
    //   383: monitorexit
    //   384: aload 4
    //   386: athrow
    //   387: iload_1
    //   388: iconst_1
    //   389: iadd
    //   390: istore_1
    //   391: goto -155 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	394	0	this	6
    //   23	368	1	i	int
    //   233	65	2	j	int
    //   52	331	3	localObject1	Object
    //   209	92	4	localObject2	Object
    //   331	5	4	localObject3	Object
    //   380	5	4	localObject4	Object
    //   191	128	5	localObject5	Object
    //   248	12	6	localb	com.tencent.mm.as.n.b
    // Exception table:
    //   from	to	target	type
    //   230	234	331	finally
    //   241	250	331	finally
    //   255	265	331	finally
    //   268	270	331	finally
    //   333	335	331	finally
    //   289	293	380	finally
    //   300	309	380	finally
    //   314	324	380	finally
    //   338	340	380	finally
    //   382	384	380	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.6
 * JD-Core Version:    0.7.0.1
 */