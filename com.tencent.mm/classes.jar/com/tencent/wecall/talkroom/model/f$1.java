package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multi.talk.a;
import com.tencent.pb.common.c.c;

final class f$1
  implements talk.a
{
  f$1(f paramf) {}
  
  public final void keep_OnError(int paramInt)
  {
    int m = -401;
    AppMethodBeat.i(127866);
    int j = 207;
    int i = -3007;
    int k = 103;
    switch (paramInt)
    {
    default: 
      m = -400;
    }
    for (;;)
    {
      h.Tw(i);
      this.BBh.BAG.Tx(j);
      c.d("TalkRoomService", new Object[] { "engine exitTalkRoom engineCallback OnError:", Integer.valueOf(paramInt) });
      this.BBh.a(f.b(this.BBh), f.g(this.BBh), f.h(this.BBh), k, true);
      f.f(this.BBh).l(m, null);
      AppMethodBeat.o(127866);
      return;
      j = 203;
      k = 112;
      i = -3003;
      continue;
      j = 204;
      k = 113;
      i = -3004;
      continue;
      j = 205;
      k = 114;
      i = -3005;
      continue;
      j = 206;
      i = -3006;
      k = 115;
      m = -400;
    }
  }
  
  public final void keep_OnNotify(int paramInt)
  {
    AppMethodBeat.i(127867);
    c.w("TalkRoomService", new Object[] { "keep_OnNotify eventCode: ", Integer.valueOf(paramInt) });
    h localh;
    if (paramInt == 5)
    {
      this.BBh.BAG.BBW = 1;
      localh = this.BBh.BAG;
      if (localh.BCj != 0L) {
        break label121;
      }
    }
    label121:
    for (localh.BBX = 0L;; localh.BBX = (System.currentTimeMillis() - localh.BCj))
    {
      c.d(h.TAG, new Object[] { "endRecvFirstPcm", Long.valueOf(localh.BCj), Long.valueOf(localh.BBX) });
      f.i(this.BBh);
      f.j(this.BBh);
      AppMethodBeat.o(127867);
      return;
    }
  }
  
  /* Error */
  public final void keep_OnOpenSuccess()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc 131
    //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 17	com/tencent/wecall/talkroom/model/f$1:BBh	Lcom/tencent/wecall/talkroom/model/f;
    //   12: getfield 38	com/tencent/wecall/talkroom/model/f:BAG	Lcom/tencent/wecall/talkroom/model/h;
    //   15: iconst_1
    //   16: putfield 134	com/tencent/wecall/talkroom/model/h:nOq	I
    //   19: ldc 43
    //   21: iconst_1
    //   22: anewarray 4	java/lang/Object
    //   25: dup
    //   26: iconst_0
    //   27: ldc 136
    //   29: aastore
    //   30: invokestatic 57	com/tencent/pb/common/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   33: aload_0
    //   34: getfield 17	com/tencent/wecall/talkroom/model/f$1:BBh	Lcom/tencent/wecall/talkroom/model/f;
    //   37: invokestatic 138	com/tencent/wecall/talkroom/model/f:a	(Lcom/tencent/wecall/talkroom/model/f;)I
    //   40: iconst_4
    //   41: if_icmpeq +36 -> 77
    //   44: ldc 43
    //   46: iconst_2
    //   47: anewarray 4	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: ldc 140
    //   54: aastore
    //   55: dup
    //   56: iconst_1
    //   57: aload_0
    //   58: getfield 17	com/tencent/wecall/talkroom/model/f$1:BBh	Lcom/tencent/wecall/talkroom/model/f;
    //   61: invokestatic 138	com/tencent/wecall/talkroom/model/f:a	(Lcom/tencent/wecall/talkroom/model/f;)I
    //   64: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   67: aastore
    //   68: invokestatic 93	com/tencent/pb/common/c/c:w	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: ldc 131
    //   73: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: return
    //   77: aload_0
    //   78: getfield 17	com/tencent/wecall/talkroom/model/f$1:BBh	Lcom/tencent/wecall/talkroom/model/f;
    //   81: astore 6
    //   83: invokestatic 146	com/tencent/wecall/talkroom/model/c:dXv	()Lcom/tencent/wecall/talkroom/model/c;
    //   86: astore 4
    //   88: aload_0
    //   89: getfield 17	com/tencent/wecall/talkroom/model/f$1:BBh	Lcom/tencent/wecall/talkroom/model/f;
    //   92: invokestatic 61	com/tencent/wecall/talkroom/model/f:b	(Lcom/tencent/wecall/talkroom/model/f;)Ljava/lang/String;
    //   95: astore 7
    //   97: aload 7
    //   99: invokestatic 152	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   102: ifeq +336 -> 438
    //   105: aload 5
    //   107: astore 4
    //   109: aload 6
    //   111: aload 4
    //   113: invokestatic 155	com/tencent/wecall/talkroom/model/f:a	(Lcom/tencent/wecall/talkroom/model/f;[I)V
    //   116: aload_0
    //   117: getfield 17	com/tencent/wecall/talkroom/model/f$1:BBh	Lcom/tencent/wecall/talkroom/model/f;
    //   120: invokestatic 159	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
    //   123: ifnull +30 -> 153
    //   126: aload_0
    //   127: getfield 17	com/tencent/wecall/talkroom/model/f$1:BBh	Lcom/tencent/wecall/talkroom/model/f;
    //   130: invokestatic 159	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
    //   133: astore 4
    //   135: invokestatic 162	com/tencent/wecall/talkroom/model/f:KM	()Z
    //   138: istore_3
    //   139: getstatic 168	com/tencent/pb/common/a/a:BcB	Z
    //   142: ifeq +11 -> 153
    //   145: aload 4
    //   147: getfield 174	com/tencent/wecall/talkroom/model/b:BzZ	Lcom/tencent/mm/plugin/multi/talk;
    //   150: ifnonnull +431 -> 581
    //   153: aload_0
    //   154: getfield 17	com/tencent/wecall/talkroom/model/f$1:BBh	Lcom/tencent/wecall/talkroom/model/f;
    //   157: invokestatic 177	com/tencent/wecall/talkroom/model/f:d	(Lcom/tencent/wecall/talkroom/model/f;)Z
    //   160: pop
    //   161: aload_0
    //   162: getfield 17	com/tencent/wecall/talkroom/model/f$1:BBh	Lcom/tencent/wecall/talkroom/model/f;
    //   165: invokestatic 159	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
    //   168: pop
    //   169: invokestatic 181	com/tencent/wecall/talkroom/model/f:dXO	()Lcom/tencent/pb/talkroom/sdk/e;
    //   172: astore 4
    //   174: aload 4
    //   176: ifnull +11 -> 187
    //   179: aload 4
    //   181: invokeinterface 187 1 0
    //   186: pop
    //   187: aload_0
    //   188: getfield 17	com/tencent/wecall/talkroom/model/f$1:BBh	Lcom/tencent/wecall/talkroom/model/f;
    //   191: invokestatic 159	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
    //   194: getfield 174	com/tencent/wecall/talkroom/model/b:BzZ	Lcom/tencent/mm/plugin/multi/talk;
    //   197: astore 6
    //   199: getstatic 168	com/tencent/pb/common/a/a:BcB	Z
    //   202: ifeq +83 -> 285
    //   205: new 189	java/util/concurrent/atomic/AtomicInteger
    //   208: dup
    //   209: invokespecial 190	java/util/concurrent/atomic/AtomicInteger:<init>	()V
    //   212: astore 4
    //   214: new 189	java/util/concurrent/atomic/AtomicInteger
    //   217: dup
    //   218: invokespecial 190	java/util/concurrent/atomic/AtomicInteger:<init>	()V
    //   221: astore 5
    //   223: aload 6
    //   225: aload 4
    //   227: aload 5
    //   229: invokevirtual 196	com/tencent/mm/plugin/multi/talk:getSampleRate	(Ljava/util/concurrent/atomic/AtomicInteger;Ljava/util/concurrent/atomic/AtomicInteger;)I
    //   232: pop
    //   233: aload 4
    //   235: invokevirtual 199	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   238: istore_1
    //   239: aload 5
    //   241: invokevirtual 199	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   244: istore_2
    //   245: iload_1
    //   246: putstatic 202	com/tencent/mm/plugin/multi/talk:VOICE_SAMPLERATE	I
    //   249: iload_2
    //   250: putstatic 205	com/tencent/mm/plugin/multi/talk:VOICE_FRAME_DURATION	I
    //   253: ldc 207
    //   255: iconst_3
    //   256: anewarray 4	java/lang/Object
    //   259: dup
    //   260: iconst_0
    //   261: ldc 209
    //   263: aastore
    //   264: dup
    //   265: iconst_1
    //   266: getstatic 202	com/tencent/mm/plugin/multi/talk:VOICE_SAMPLERATE	I
    //   269: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   272: aastore
    //   273: dup
    //   274: iconst_2
    //   275: getstatic 205	com/tencent/mm/plugin/multi/talk:VOICE_FRAME_DURATION	I
    //   278: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   281: aastore
    //   282: invokestatic 93	com/tencent/pb/common/c/c:w	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   285: new 211	android/os/Handler
    //   288: dup
    //   289: invokestatic 217	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   292: invokespecial 220	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   295: new 222	com/tencent/wecall/talkroom/model/f$1$1
    //   298: dup
    //   299: aload_0
    //   300: invokespecial 225	com/tencent/wecall/talkroom/model/f$1$1:<init>	(Lcom/tencent/wecall/talkroom/model/f$1;)V
    //   303: invokevirtual 229	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   306: pop
    //   307: aload_0
    //   308: getfield 17	com/tencent/wecall/talkroom/model/f$1:BBh	Lcom/tencent/wecall/talkroom/model/f;
    //   311: getfield 38	com/tencent/wecall/talkroom/model/f:BAG	Lcom/tencent/wecall/talkroom/model/h;
    //   314: astore 4
    //   316: aload 4
    //   318: getfield 101	com/tencent/wecall/talkroom/model/h:BCj	J
    //   321: lconst_0
    //   322: lcmp
    //   323: ifne +317 -> 640
    //   326: aload 4
    //   328: lconst_0
    //   329: putfield 232	com/tencent/wecall/talkroom/model/h:BBY	J
    //   332: getstatic 108	com/tencent/wecall/talkroom/model/h:TAG	Ljava/lang/String;
    //   335: iconst_3
    //   336: anewarray 4	java/lang/Object
    //   339: dup
    //   340: iconst_0
    //   341: ldc 234
    //   343: aastore
    //   344: dup
    //   345: iconst_1
    //   346: aload 4
    //   348: getfield 232	com/tencent/wecall/talkroom/model/h:BBY	J
    //   351: invokestatic 115	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   354: aastore
    //   355: dup
    //   356: iconst_2
    //   357: aload 4
    //   359: getfield 101	com/tencent/wecall/talkroom/model/h:BCj	J
    //   362: invokestatic 115	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   365: aastore
    //   366: invokestatic 57	com/tencent/pb/common/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   369: aload_0
    //   370: getfield 17	com/tencent/wecall/talkroom/model/f$1:BBh	Lcom/tencent/wecall/talkroom/model/f;
    //   373: invokestatic 77	com/tencent/wecall/talkroom/model/f:f	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/g;
    //   376: astore 4
    //   378: new 236	com/tencent/wecall/talkroom/model/g$3
    //   381: dup
    //   382: aload 4
    //   384: invokespecial 239	com/tencent/wecall/talkroom/model/g$3:<init>	(Lcom/tencent/wecall/talkroom/model/g;)V
    //   387: astore 5
    //   389: invokestatic 242	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   392: invokestatic 217	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   395: if_acmpne +262 -> 657
    //   398: aload 5
    //   400: invokeinterface 247 1 0
    //   405: ldc 131
    //   407: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   410: return
    //   411: astore 4
    //   413: ldc 43
    //   415: iconst_2
    //   416: anewarray 4	java/lang/Object
    //   419: dup
    //   420: iconst_0
    //   421: ldc 249
    //   423: aastore
    //   424: dup
    //   425: iconst_1
    //   426: aload 4
    //   428: aastore
    //   429: invokestatic 93	com/tencent/pb/common/c/c:w	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   432: ldc 131
    //   434: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   437: return
    //   438: aload 4
    //   440: aload 7
    //   442: invokevirtual 253	com/tencent/wecall/talkroom/model/c:axp	(Ljava/lang/String;)Lcom/tencent/wecall/talkroom/model/TalkRoom;
    //   445: astore 7
    //   447: aload 5
    //   449: astore 4
    //   451: aload 7
    //   453: ifnull -344 -> 109
    //   456: aload 7
    //   458: invokevirtual 259	com/tencent/wecall/talkroom/model/TalkRoom:dXm	()Ljava/util/List;
    //   461: astore 7
    //   463: aload 5
    //   465: astore 4
    //   467: aload 7
    //   469: ifnull -360 -> 109
    //   472: aload 7
    //   474: invokeinterface 264 1 0
    //   479: newarray int
    //   481: astore 4
    //   483: new 266	java/lang/StringBuffer
    //   486: dup
    //   487: invokespecial 267	java/lang/StringBuffer:<init>	()V
    //   490: astore 5
    //   492: iconst_0
    //   493: istore_1
    //   494: iload_1
    //   495: aload 7
    //   497: invokeinterface 264 1 0
    //   502: if_icmpge +52 -> 554
    //   505: aload 7
    //   507: iload_1
    //   508: invokeinterface 270 2 0
    //   513: checkcast 272	com/tencent/wecall/talkroom/model/d
    //   516: astore 8
    //   518: aload 8
    //   520: ifnull +154 -> 674
    //   523: aload 4
    //   525: iload_1
    //   526: aload 8
    //   528: invokevirtual 275	com/tencent/wecall/talkroom/model/d:getMemberId	()I
    //   531: iastore
    //   532: aload 5
    //   534: aload 4
    //   536: iload_1
    //   537: iaload
    //   538: invokevirtual 279	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   541: pop
    //   542: aload 5
    //   544: ldc_w 281
    //   547: invokevirtual 284	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   550: pop
    //   551: goto +123 -> 674
    //   554: ldc_w 286
    //   557: iconst_2
    //   558: anewarray 4	java/lang/Object
    //   561: dup
    //   562: iconst_0
    //   563: ldc_w 288
    //   566: aastore
    //   567: dup
    //   568: iconst_1
    //   569: aload 5
    //   571: invokevirtual 292	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   574: aastore
    //   575: invokestatic 93	com/tencent/pb/common/c/c:w	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   578: goto -469 -> 109
    //   581: iload_3
    //   582: ifeq +18 -> 600
    //   585: aload 4
    //   587: getfield 174	com/tencent/wecall/talkroom/model/b:BzZ	Lcom/tencent/mm/plugin/multi/talk;
    //   590: sipush 401
    //   593: invokevirtual 296	com/tencent/mm/plugin/multi/talk:setAppCmd	(I)I
    //   596: pop
    //   597: goto -444 -> 153
    //   600: aload 4
    //   602: getfield 174	com/tencent/wecall/talkroom/model/b:BzZ	Lcom/tencent/mm/plugin/multi/talk;
    //   605: sipush 402
    //   608: invokevirtual 296	com/tencent/mm/plugin/multi/talk:setAppCmd	(I)I
    //   611: pop
    //   612: goto -459 -> 153
    //   615: astore 6
    //   617: ldc 207
    //   619: iconst_2
    //   620: anewarray 4	java/lang/Object
    //   623: dup
    //   624: iconst_0
    //   625: ldc_w 298
    //   628: aastore
    //   629: dup
    //   630: iconst_1
    //   631: aload 6
    //   633: aastore
    //   634: invokestatic 93	com/tencent/pb/common/c/c:w	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   637: goto -404 -> 233
    //   640: aload 4
    //   642: invokestatic 127	java/lang/System:currentTimeMillis	()J
    //   645: aload 4
    //   647: getfield 101	com/tencent/wecall/talkroom/model/h:BCj	J
    //   650: lsub
    //   651: putfield 232	com/tencent/wecall/talkroom/model/h:BBY	J
    //   654: goto -322 -> 332
    //   657: aload 4
    //   659: getfield 302	com/tencent/wecall/talkroom/model/g:handler	Landroid/os/Handler;
    //   662: aload 5
    //   664: invokevirtual 229	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   667: pop
    //   668: ldc 131
    //   670: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   673: return
    //   674: iload_1
    //   675: iconst_1
    //   676: iadd
    //   677: istore_1
    //   678: goto -184 -> 494
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	681	0	this	1
    //   238	440	1	i	int
    //   244	6	2	j	int
    //   138	444	3	bool	boolean
    //   86	297	4	localObject1	Object
    //   411	28	4	localThrowable1	java.lang.Throwable
    //   449	209	4	localObject2	Object
    //   1	662	5	localObject3	Object
    //   81	143	6	localObject4	Object
    //   615	17	6	localThrowable2	java.lang.Throwable
    //   95	411	7	localObject5	Object
    //   516	11	8	locald	d
    // Exception table:
    //   from	to	target	type
    //   77	105	411	java/lang/Throwable
    //   109	153	411	java/lang/Throwable
    //   153	174	411	java/lang/Throwable
    //   179	187	411	java/lang/Throwable
    //   187	223	411	java/lang/Throwable
    //   233	285	411	java/lang/Throwable
    //   285	332	411	java/lang/Throwable
    //   332	410	411	java/lang/Throwable
    //   438	447	411	java/lang/Throwable
    //   456	463	411	java/lang/Throwable
    //   472	492	411	java/lang/Throwable
    //   494	518	411	java/lang/Throwable
    //   523	551	411	java/lang/Throwable
    //   554	578	411	java/lang/Throwable
    //   585	597	411	java/lang/Throwable
    //   600	612	411	java/lang/Throwable
    //   617	637	411	java/lang/Throwable
    //   640	654	411	java/lang/Throwable
    //   657	668	411	java/lang/Throwable
    //   223	233	615	java/lang/Throwable
  }
  
  public final void keep_OnReportChannel(String paramString)
  {
    AppMethodBeat.i(127870);
    c.d("TalkRoomService", new Object[] { "keep_OnReportChannel:", paramString });
    StringBuilder localStringBuilder = new StringBuilder(com.tencent.pb.common.c.g.aws(this.BBh.BAS));
    localStringBuilder.append(",");
    localStringBuilder.append(paramString);
    h.axC(localStringBuilder.toString());
    AppMethodBeat.o(127870);
  }
  
  public final void keep_OnReportEngineRecv(String paramString, int paramInt)
  {
    AppMethodBeat.i(127868);
    c.d("TalkRoomService", new Object[] { "keep_OnReportEngineRecv:", Integer.valueOf(paramInt), paramString });
    StringBuilder localStringBuilder = new StringBuilder(com.tencent.pb.common.c.g.aws(this.BBh.BAS));
    localStringBuilder.append(",");
    localStringBuilder.append(paramString);
    h.axA(localStringBuilder.toString());
    AppMethodBeat.o(127868);
  }
  
  public final void keep_OnReportEngineSend(String paramString)
  {
    AppMethodBeat.i(127869);
    c.d("TalkRoomService", new Object[] { "keep_OnReportEngineSend:", paramString });
    StringBuilder localStringBuilder = new StringBuilder(com.tencent.pb.common.c.g.aws(this.BBh.BAS));
    localStringBuilder.append(",");
    localStringBuilder.append(paramString);
    h.axB(localStringBuilder.toString());
    AppMethodBeat.o(127869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.f.1
 * JD-Core Version:    0.7.0.1
 */