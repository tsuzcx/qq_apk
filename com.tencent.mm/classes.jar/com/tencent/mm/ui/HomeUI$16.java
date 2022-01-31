package com.tencent.mm.ui;

import android.os.MessageQueue.IdleHandler;

final class HomeUI$16
  implements MessageQueue.IdleHandler
{
  HomeUI$16(HomeUI paramHomeUI) {}
  
  /* Error */
  public final boolean queueIdle()
  {
    // Byte code:
    //   0: ldc 21
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 33	com/tencent/mm/model/aw:aaz	()Lcom/tencent/mm/model/c;
    //   8: pop
    //   9: invokestatic 39	com/tencent/mm/model/c:Ru	()Lcom/tencent/mm/storage/z;
    //   12: bipush 15
    //   14: aconst_null
    //   15: invokevirtual 45	com/tencent/mm/storage/z:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   18: checkcast 47	java/lang/Integer
    //   21: invokestatic 53	com/tencent/mm/platformtools/ah:g	(Ljava/lang/Integer;)I
    //   24: ifne +23 -> 47
    //   27: iconst_1
    //   28: istore_1
    //   29: iload_1
    //   30: ifeq +22 -> 52
    //   33: ldc 55
    //   35: ldc 57
    //   37: invokestatic 63	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: ldc 21
    //   42: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: iconst_0
    //   46: ireturn
    //   47: iconst_0
    //   48: istore_1
    //   49: goto -20 -> 29
    //   52: getstatic 72	com/tencent/mm/model/av:flM	Lcom/tencent/mm/model/av;
    //   55: ldc 74
    //   57: ldc 76
    //   59: invokevirtual 80	com/tencent/mm/model/av:Y	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   62: astore_3
    //   63: invokestatic 83	com/tencent/mm/model/aw:aaB	()Z
    //   66: ifne +12 -> 78
    //   69: aload_3
    //   70: ldc 76
    //   72: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   75: ifne +28 -> 103
    //   78: invokestatic 93	com/tencent/mm/model/aw:Rc	()Lcom/tencent/mm/ai/p;
    //   81: new 95	com/tencent/mm/model/bk
    //   84: dup
    //   85: new 97	com/tencent/mm/ui/HomeUI$16$1
    //   88: dup
    //   89: aload_0
    //   90: invokespecial 100	com/tencent/mm/ui/HomeUI$16$1:<init>	(Lcom/tencent/mm/ui/HomeUI$16;)V
    //   93: ldc 102
    //   95: invokespecial 105	com/tencent/mm/model/bk:<init>	(Lcom/tencent/mm/model/bk$a;Ljava/lang/String;)V
    //   98: iconst_0
    //   99: invokevirtual 111	com/tencent/mm/ai/p:a	(Lcom/tencent/mm/ai/m;I)Z
    //   102: pop
    //   103: new 113	com/tencent/mm/booter/x$1
    //   106: dup
    //   107: new 115	com/tencent/mm/booter/x
    //   110: dup
    //   111: aload_0
    //   112: getfield 14	com/tencent/mm/ui/HomeUI$16:yYw	Lcom/tencent/mm/ui/HomeUI;
    //   115: invokestatic 119	com/tencent/mm/ui/HomeUI:b	(Lcom/tencent/mm/ui/HomeUI;)Lcom/tencent/mm/ui/MMFragmentActivity;
    //   118: invokespecial 122	com/tencent/mm/booter/x:<init>	(Landroid/content/Context;)V
    //   121: invokespecial 125	com/tencent/mm/booter/x$1:<init>	(Lcom/tencent/mm/booter/x;)V
    //   124: ldc 127
    //   126: invokestatic 133	com/tencent/mm/sdk/g/d:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   129: invokestatic 138	com/tencent/mm/booter/o:ID	()V
    //   132: invokestatic 141	com/tencent/mm/ui/HomeUI:dBX	()V
    //   135: invokestatic 146	com/tencent/mm/plugin/report/service/f:chP	()V
    //   138: invokestatic 152	com/tencent/mm/at/n:ahs	()Lcom/tencent/mm/at/n;
    //   141: getfield 156	com/tencent/mm/at/n:fGa	Lcom/tencent/mm/at/n$c;
    //   144: astore_3
    //   145: aload_3
    //   146: getfield 162	com/tencent/mm/at/n$c:fGp	Ljava/util/LinkedList;
    //   149: invokevirtual 168	java/util/LinkedList:size	()I
    //   152: ifgt +13 -> 165
    //   155: aload_3
    //   156: getfield 171	com/tencent/mm/at/n$c:fGo	Ljava/util/LinkedList;
    //   159: invokevirtual 168	java/util/LinkedList:size	()I
    //   162: ifle +27 -> 189
    //   165: aload_3
    //   166: invokevirtual 174	com/tencent/mm/at/n$c:ahw	()V
    //   169: invokestatic 180	android/os/Looper:myQueue	()Landroid/os/MessageQueue;
    //   172: aload_0
    //   173: getfield 14	com/tencent/mm/ui/HomeUI$16:yYw	Lcom/tencent/mm/ui/HomeUI;
    //   176: getfield 184	com/tencent/mm/ui/HomeUI:jZm	Landroid/os/MessageQueue$IdleHandler;
    //   179: invokevirtual 190	android/os/MessageQueue:removeIdleHandler	(Landroid/os/MessageQueue$IdleHandler;)V
    //   182: ldc 21
    //   184: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: iconst_0
    //   188: ireturn
    //   189: invokestatic 196	com/tencent/mm/kernel/g:RL	()Lcom/tencent/mm/kernel/e;
    //   192: invokevirtual 199	com/tencent/mm/kernel/e:Ru	()Lcom/tencent/mm/storage/z;
    //   195: ldc 200
    //   197: ldc 76
    //   199: invokevirtual 45	com/tencent/mm/storage/z:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   202: checkcast 85	java/lang/String
    //   205: astore 5
    //   207: invokestatic 196	com/tencent/mm/kernel/g:RL	()Lcom/tencent/mm/kernel/e;
    //   210: invokevirtual 199	com/tencent/mm/kernel/e:Ru	()Lcom/tencent/mm/storage/z;
    //   213: ldc 201
    //   215: ldc 76
    //   217: invokevirtual 45	com/tencent/mm/storage/z:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   220: checkcast 85	java/lang/String
    //   223: astore 4
    //   225: aload 5
    //   227: invokestatic 207	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   230: ifne +54 -> 284
    //   233: aload 5
    //   235: ldc 209
    //   237: invokevirtual 213	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   240: astore 5
    //   242: aload_3
    //   243: monitorenter
    //   244: aload 5
    //   246: arraylength
    //   247: istore_2
    //   248: iconst_0
    //   249: istore_1
    //   250: iload_1
    //   251: iload_2
    //   252: if_icmpge +30 -> 282
    //   255: aload 5
    //   257: iload_1
    //   258: aaload
    //   259: invokestatic 217	com/tencent/mm/at/n$c:tp	(Ljava/lang/String;)Lcom/tencent/mm/at/n$b;
    //   262: astore 6
    //   264: aload 6
    //   266: ifnull +145 -> 411
    //   269: aload_3
    //   270: getfield 162	com/tencent/mm/at/n$c:fGp	Ljava/util/LinkedList;
    //   273: aload 6
    //   275: invokevirtual 220	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   278: pop
    //   279: goto +132 -> 411
    //   282: aload_3
    //   283: monitorexit
    //   284: aload 4
    //   286: invokestatic 207	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   289: ifne +70 -> 359
    //   292: aload 4
    //   294: ldc 209
    //   296: invokevirtual 213	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   299: astore 4
    //   301: aload_3
    //   302: monitorenter
    //   303: aload 4
    //   305: arraylength
    //   306: istore_2
    //   307: iconst_0
    //   308: istore_1
    //   309: iload_1
    //   310: iload_2
    //   311: if_icmpge +46 -> 357
    //   314: aload 4
    //   316: iload_1
    //   317: aaload
    //   318: invokestatic 223	com/tencent/mm/at/n$c:to	(Ljava/lang/String;)Lcom/tencent/mm/at/n$b;
    //   321: astore 5
    //   323: aload 5
    //   325: ifnull +13 -> 338
    //   328: aload_3
    //   329: getfield 171	com/tencent/mm/at/n$c:fGo	Ljava/util/LinkedList;
    //   332: aload 5
    //   334: invokevirtual 220	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   337: pop
    //   338: iload_1
    //   339: iconst_1
    //   340: iadd
    //   341: istore_1
    //   342: goto -33 -> 309
    //   345: astore 4
    //   347: aload_3
    //   348: monitorexit
    //   349: ldc 21
    //   351: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   354: aload 4
    //   356: athrow
    //   357: aload_3
    //   358: monitorexit
    //   359: ldc 225
    //   361: ldc 227
    //   363: iconst_2
    //   364: anewarray 4	java/lang/Object
    //   367: dup
    //   368: iconst_0
    //   369: aload_3
    //   370: getfield 171	com/tencent/mm/at/n$c:fGo	Ljava/util/LinkedList;
    //   373: invokevirtual 168	java/util/LinkedList:size	()I
    //   376: invokestatic 231	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   379: aastore
    //   380: dup
    //   381: iconst_1
    //   382: aload_3
    //   383: getfield 162	com/tencent/mm/at/n$c:fGp	Ljava/util/LinkedList;
    //   386: invokevirtual 168	java/util/LinkedList:size	()I
    //   389: invokestatic 231	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   392: aastore
    //   393: invokestatic 234	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   396: goto -231 -> 165
    //   399: astore 4
    //   401: aload_3
    //   402: monitorexit
    //   403: ldc 21
    //   405: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   408: aload 4
    //   410: athrow
    //   411: iload_1
    //   412: iconst_1
    //   413: iadd
    //   414: istore_1
    //   415: goto -165 -> 250
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	this	16
    //   28	387	1	i	int
    //   247	65	2	j	int
    //   62	340	3	localObject1	Object
    //   223	92	4	localObject2	Object
    //   345	10	4	localObject3	Object
    //   399	10	4	localObject4	Object
    //   205	128	5	localObject5	Object
    //   262	12	6	localb	com.tencent.mm.at.n.b
    // Exception table:
    //   from	to	target	type
    //   244	248	345	finally
    //   255	264	345	finally
    //   269	279	345	finally
    //   282	284	345	finally
    //   347	349	345	finally
    //   303	307	399	finally
    //   314	323	399	finally
    //   328	338	399	finally
    //   357	359	399	finally
    //   401	403	399	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.16
 * JD-Core Version:    0.7.0.1
 */