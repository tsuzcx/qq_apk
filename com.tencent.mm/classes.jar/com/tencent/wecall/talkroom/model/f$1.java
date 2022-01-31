package com.tencent.wecall.talkroom.model;

import com.tencent.mm.plugin.multi.talk.a;
import com.tencent.pb.common.c.c;

final class f$1
  implements talk.a
{
  f$1(f paramf) {}
  
  public final void keep_OnError(int paramInt)
  {
    int m = -401;
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
      h.KD(i);
      this.xeA.xdZ.KE(j);
      c.d("TalkRoomService", new Object[] { "engine exitTalkRoom engineCallback OnError:", Integer.valueOf(paramInt) });
      this.xeA.a(f.b(this.xeA), f.g(this.xeA), f.h(this.xeA), k, true);
      f.f(this.xeA).i(m, null);
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
    c.x("TalkRoomService", new Object[] { "keep_OnNotify eventCode: ", Integer.valueOf(paramInt) });
    h localh;
    if (paramInt == 5)
    {
      this.xeA.xdZ.xfp = 1;
      localh = this.xeA.xdZ;
      if (localh.xfC != 0L) {
        break label111;
      }
    }
    label111:
    for (localh.xfq = 0L;; localh.xfq = (System.currentTimeMillis() - localh.xfC))
    {
      c.d(h.TAG, new Object[] { "endRecvFirstPcm", Long.valueOf(localh.xfC), Long.valueOf(localh.xfq) });
      f.i(this.xeA);
      f.j(this.xeA);
      return;
    }
  }
  
  /* Error */
  public final void keep_OnOpenSuccess()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: getfield 17	com/tencent/wecall/talkroom/model/f$1:xeA	Lcom/tencent/wecall/talkroom/model/f;
    //   7: getfield 32	com/tencent/wecall/talkroom/model/f:xdZ	Lcom/tencent/wecall/talkroom/model/h;
    //   10: iconst_1
    //   11: putfield 123	com/tencent/wecall/talkroom/model/h:lqU	I
    //   14: ldc 37
    //   16: iconst_1
    //   17: anewarray 4	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: ldc 125
    //   24: aastore
    //   25: invokestatic 51	com/tencent/pb/common/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: aload_0
    //   29: getfield 17	com/tencent/wecall/talkroom/model/f$1:xeA	Lcom/tencent/wecall/talkroom/model/f;
    //   32: invokestatic 127	com/tencent/wecall/talkroom/model/f:a	(Lcom/tencent/wecall/talkroom/model/f;)I
    //   35: iconst_4
    //   36: if_icmpeq +31 -> 67
    //   39: ldc 37
    //   41: iconst_2
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: ldc 129
    //   49: aastore
    //   50: dup
    //   51: iconst_1
    //   52: aload_0
    //   53: getfield 17	com/tencent/wecall/talkroom/model/f$1:xeA	Lcom/tencent/wecall/talkroom/model/f;
    //   56: invokestatic 127	com/tencent/wecall/talkroom/model/f:a	(Lcom/tencent/wecall/talkroom/model/f;)I
    //   59: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   62: aastore
    //   63: invokestatic 83	com/tencent/pb/common/c/c:x	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   66: return
    //   67: aload_0
    //   68: getfield 17	com/tencent/wecall/talkroom/model/f$1:xeA	Lcom/tencent/wecall/talkroom/model/f;
    //   71: astore 6
    //   73: invokestatic 135	com/tencent/wecall/talkroom/model/c:cRC	()Lcom/tencent/wecall/talkroom/model/c;
    //   76: astore 4
    //   78: aload_0
    //   79: getfield 17	com/tencent/wecall/talkroom/model/f$1:xeA	Lcom/tencent/wecall/talkroom/model/f;
    //   82: invokestatic 55	com/tencent/wecall/talkroom/model/f:b	(Lcom/tencent/wecall/talkroom/model/f;)Ljava/lang/String;
    //   85: astore 7
    //   87: aload 7
    //   89: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   92: ifeq +334 -> 426
    //   95: aload 5
    //   97: astore 4
    //   99: aload 6
    //   101: aload 4
    //   103: invokestatic 144	com/tencent/wecall/talkroom/model/f:a	(Lcom/tencent/wecall/talkroom/model/f;[I)V
    //   106: aload_0
    //   107: getfield 17	com/tencent/wecall/talkroom/model/f$1:xeA	Lcom/tencent/wecall/talkroom/model/f;
    //   110: invokestatic 148	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
    //   113: ifnull +38 -> 151
    //   116: aload_0
    //   117: getfield 17	com/tencent/wecall/talkroom/model/f$1:xeA	Lcom/tencent/wecall/talkroom/model/f;
    //   120: invokestatic 148	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
    //   123: astore 4
    //   125: invokestatic 151	com/tencent/wecall/talkroom/model/f:ys	()Z
    //   128: istore_3
    //   129: getstatic 157	com/tencent/pb/common/a/a:wFa	Z
    //   132: ifeq +19 -> 151
    //   135: iload_3
    //   136: ifeq +433 -> 569
    //   139: aload 4
    //   141: getfield 163	com/tencent/wecall/talkroom/model/b:xdr	Lcom/tencent/mm/plugin/multi/talk;
    //   144: sipush 401
    //   147: invokevirtual 169	com/tencent/mm/plugin/multi/talk:um	(I)I
    //   150: pop
    //   151: aload_0
    //   152: getfield 17	com/tencent/wecall/talkroom/model/f$1:xeA	Lcom/tencent/wecall/talkroom/model/f;
    //   155: invokestatic 172	com/tencent/wecall/talkroom/model/f:d	(Lcom/tencent/wecall/talkroom/model/f;)Z
    //   158: pop
    //   159: aload_0
    //   160: getfield 17	com/tencent/wecall/talkroom/model/f$1:xeA	Lcom/tencent/wecall/talkroom/model/f;
    //   163: invokestatic 148	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
    //   166: pop
    //   167: invokestatic 176	com/tencent/wecall/talkroom/model/f:cRT	()Lcom/tencent/pb/talkroom/sdk/e;
    //   170: astore 4
    //   172: aload 4
    //   174: ifnull +11 -> 185
    //   177: aload 4
    //   179: invokeinterface 182 1 0
    //   184: pop
    //   185: aload_0
    //   186: getfield 17	com/tencent/wecall/talkroom/model/f$1:xeA	Lcom/tencent/wecall/talkroom/model/f;
    //   189: invokestatic 148	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
    //   192: getfield 163	com/tencent/wecall/talkroom/model/b:xdr	Lcom/tencent/mm/plugin/multi/talk;
    //   195: astore 6
    //   197: getstatic 157	com/tencent/pb/common/a/a:wFa	Z
    //   200: ifeq +83 -> 283
    //   203: new 184	java/util/concurrent/atomic/AtomicInteger
    //   206: dup
    //   207: invokespecial 185	java/util/concurrent/atomic/AtomicInteger:<init>	()V
    //   210: astore 4
    //   212: new 184	java/util/concurrent/atomic/AtomicInteger
    //   215: dup
    //   216: invokespecial 185	java/util/concurrent/atomic/AtomicInteger:<init>	()V
    //   219: astore 5
    //   221: aload 6
    //   223: aload 4
    //   225: aload 5
    //   227: invokevirtual 189	com/tencent/mm/plugin/multi/talk:getSampleRate	(Ljava/util/concurrent/atomic/AtomicInteger;Ljava/util/concurrent/atomic/AtomicInteger;)I
    //   230: pop
    //   231: aload 4
    //   233: invokevirtual 192	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   236: istore_1
    //   237: aload 5
    //   239: invokevirtual 192	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   242: istore_2
    //   243: iload_1
    //   244: putstatic 195	com/tencent/mm/plugin/multi/talk:VOICE_SAMPLERATE	I
    //   247: iload_2
    //   248: putstatic 198	com/tencent/mm/plugin/multi/talk:VOICE_FRAME_DURATION	I
    //   251: ldc 200
    //   253: iconst_3
    //   254: anewarray 4	java/lang/Object
    //   257: dup
    //   258: iconst_0
    //   259: ldc 202
    //   261: aastore
    //   262: dup
    //   263: iconst_1
    //   264: getstatic 195	com/tencent/mm/plugin/multi/talk:VOICE_SAMPLERATE	I
    //   267: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   270: aastore
    //   271: dup
    //   272: iconst_2
    //   273: getstatic 198	com/tencent/mm/plugin/multi/talk:VOICE_FRAME_DURATION	I
    //   276: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   279: aastore
    //   280: invokestatic 83	com/tencent/pb/common/c/c:x	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   283: new 204	android/os/Handler
    //   286: dup
    //   287: invokestatic 210	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   290: invokespecial 213	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   293: new 215	com/tencent/wecall/talkroom/model/f$1$1
    //   296: dup
    //   297: aload_0
    //   298: invokespecial 218	com/tencent/wecall/talkroom/model/f$1$1:<init>	(Lcom/tencent/wecall/talkroom/model/f$1;)V
    //   301: invokevirtual 222	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   304: pop
    //   305: aload_0
    //   306: getfield 17	com/tencent/wecall/talkroom/model/f$1:xeA	Lcom/tencent/wecall/talkroom/model/f;
    //   309: getfield 32	com/tencent/wecall/talkroom/model/f:xdZ	Lcom/tencent/wecall/talkroom/model/h;
    //   312: astore 4
    //   314: aload 4
    //   316: getfield 91	com/tencent/wecall/talkroom/model/h:xfC	J
    //   319: lconst_0
    //   320: lcmp
    //   321: ifne +288 -> 609
    //   324: aload 4
    //   326: lconst_0
    //   327: putfield 225	com/tencent/wecall/talkroom/model/h:xfr	J
    //   330: getstatic 98	com/tencent/wecall/talkroom/model/h:TAG	Ljava/lang/String;
    //   333: iconst_3
    //   334: anewarray 4	java/lang/Object
    //   337: dup
    //   338: iconst_0
    //   339: ldc 227
    //   341: aastore
    //   342: dup
    //   343: iconst_1
    //   344: aload 4
    //   346: getfield 225	com/tencent/wecall/talkroom/model/h:xfr	J
    //   349: invokestatic 105	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   352: aastore
    //   353: dup
    //   354: iconst_2
    //   355: aload 4
    //   357: getfield 91	com/tencent/wecall/talkroom/model/h:xfC	J
    //   360: invokestatic 105	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   363: aastore
    //   364: invokestatic 51	com/tencent/pb/common/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   367: aload_0
    //   368: getfield 17	com/tencent/wecall/talkroom/model/f$1:xeA	Lcom/tencent/wecall/talkroom/model/f;
    //   371: invokestatic 71	com/tencent/wecall/talkroom/model/f:f	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/g;
    //   374: astore 4
    //   376: new 229	com/tencent/wecall/talkroom/model/g$3
    //   379: dup
    //   380: aload 4
    //   382: invokespecial 232	com/tencent/wecall/talkroom/model/g$3:<init>	(Lcom/tencent/wecall/talkroom/model/g;)V
    //   385: astore 5
    //   387: invokestatic 235	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   390: invokestatic 210	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   393: if_acmpne +233 -> 626
    //   396: aload 5
    //   398: invokeinterface 240 1 0
    //   403: return
    //   404: astore 4
    //   406: ldc 37
    //   408: iconst_2
    //   409: anewarray 4	java/lang/Object
    //   412: dup
    //   413: iconst_0
    //   414: ldc 242
    //   416: aastore
    //   417: dup
    //   418: iconst_1
    //   419: aload 4
    //   421: aastore
    //   422: invokestatic 83	com/tencent/pb/common/c/c:x	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   425: return
    //   426: aload 4
    //   428: aload 7
    //   430: invokevirtual 246	com/tencent/wecall/talkroom/model/c:agw	(Ljava/lang/String;)Lcom/tencent/wecall/talkroom/model/TalkRoom;
    //   433: astore 7
    //   435: aload 5
    //   437: astore 4
    //   439: aload 7
    //   441: ifnull -342 -> 99
    //   444: aload 7
    //   446: invokevirtual 252	com/tencent/wecall/talkroom/model/TalkRoom:cRw	()Ljava/util/List;
    //   449: astore 7
    //   451: aload 5
    //   453: astore 4
    //   455: aload 7
    //   457: ifnull -358 -> 99
    //   460: aload 7
    //   462: invokeinterface 257 1 0
    //   467: newarray int
    //   469: astore 4
    //   471: new 259	java/lang/StringBuffer
    //   474: dup
    //   475: invokespecial 260	java/lang/StringBuffer:<init>	()V
    //   478: astore 5
    //   480: iconst_0
    //   481: istore_1
    //   482: iload_1
    //   483: aload 7
    //   485: invokeinterface 257 1 0
    //   490: if_icmpge +52 -> 542
    //   493: aload 7
    //   495: iload_1
    //   496: invokeinterface 263 2 0
    //   501: checkcast 265	com/tencent/wecall/talkroom/model/d
    //   504: astore 8
    //   506: aload 8
    //   508: ifnull +130 -> 638
    //   511: aload 4
    //   513: iload_1
    //   514: aload 8
    //   516: invokevirtual 268	com/tencent/wecall/talkroom/model/d:cRF	()I
    //   519: iastore
    //   520: aload 5
    //   522: aload 4
    //   524: iload_1
    //   525: iaload
    //   526: invokevirtual 272	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   529: pop
    //   530: aload 5
    //   532: ldc_w 274
    //   535: invokevirtual 277	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   538: pop
    //   539: goto +99 -> 638
    //   542: ldc_w 279
    //   545: iconst_2
    //   546: anewarray 4	java/lang/Object
    //   549: dup
    //   550: iconst_0
    //   551: ldc_w 281
    //   554: aastore
    //   555: dup
    //   556: iconst_1
    //   557: aload 5
    //   559: invokevirtual 285	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   562: aastore
    //   563: invokestatic 83	com/tencent/pb/common/c/c:x	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   566: goto -467 -> 99
    //   569: aload 4
    //   571: getfield 163	com/tencent/wecall/talkroom/model/b:xdr	Lcom/tencent/mm/plugin/multi/talk;
    //   574: sipush 402
    //   577: invokevirtual 169	com/tencent/mm/plugin/multi/talk:um	(I)I
    //   580: pop
    //   581: goto -430 -> 151
    //   584: astore 6
    //   586: ldc 200
    //   588: iconst_2
    //   589: anewarray 4	java/lang/Object
    //   592: dup
    //   593: iconst_0
    //   594: ldc_w 287
    //   597: aastore
    //   598: dup
    //   599: iconst_1
    //   600: aload 6
    //   602: aastore
    //   603: invokestatic 83	com/tencent/pb/common/c/c:x	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   606: goto -375 -> 231
    //   609: aload 4
    //   611: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   614: aload 4
    //   616: getfield 91	com/tencent/wecall/talkroom/model/h:xfC	J
    //   619: lsub
    //   620: putfield 225	com/tencent/wecall/talkroom/model/h:xfr	J
    //   623: goto -293 -> 330
    //   626: aload 4
    //   628: getfield 291	com/tencent/wecall/talkroom/model/g:handler	Landroid/os/Handler;
    //   631: aload 5
    //   633: invokevirtual 222	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   636: pop
    //   637: return
    //   638: iload_1
    //   639: iconst_1
    //   640: iadd
    //   641: istore_1
    //   642: goto -160 -> 482
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	645	0	this	1
    //   236	406	1	i	int
    //   242	6	2	j	int
    //   128	8	3	bool	boolean
    //   76	305	4	localObject1	Object
    //   404	23	4	localThrowable1	java.lang.Throwable
    //   437	190	4	localObject2	Object
    //   1	631	5	localObject3	Object
    //   71	151	6	localObject4	Object
    //   584	17	6	localThrowable2	java.lang.Throwable
    //   85	409	7	localObject5	Object
    //   504	11	8	locald	d
    // Exception table:
    //   from	to	target	type
    //   67	95	404	java/lang/Throwable
    //   99	135	404	java/lang/Throwable
    //   139	151	404	java/lang/Throwable
    //   151	172	404	java/lang/Throwable
    //   177	185	404	java/lang/Throwable
    //   185	221	404	java/lang/Throwable
    //   231	283	404	java/lang/Throwable
    //   283	330	404	java/lang/Throwable
    //   330	403	404	java/lang/Throwable
    //   426	435	404	java/lang/Throwable
    //   444	451	404	java/lang/Throwable
    //   460	480	404	java/lang/Throwable
    //   482	506	404	java/lang/Throwable
    //   511	539	404	java/lang/Throwable
    //   542	566	404	java/lang/Throwable
    //   569	581	404	java/lang/Throwable
    //   586	606	404	java/lang/Throwable
    //   609	623	404	java/lang/Throwable
    //   626	637	404	java/lang/Throwable
    //   221	231	584	java/lang/Throwable
  }
  
  public final void keep_OnReportChannel(String paramString)
  {
    c.d("TalkRoomService", new Object[] { "keep_OnReportChannel:", paramString });
    StringBuilder localStringBuilder = new StringBuilder(com.tencent.pb.common.c.g.afu(this.xeA.xel));
    localStringBuilder.append(",");
    localStringBuilder.append(paramString);
    h.agH(localStringBuilder.toString());
  }
  
  public final void keep_OnReportEngineRecv(String paramString, int paramInt)
  {
    c.d("TalkRoomService", new Object[] { "keep_OnReportEngineRecv:", Integer.valueOf(paramInt), paramString });
    StringBuilder localStringBuilder = new StringBuilder(com.tencent.pb.common.c.g.afu(this.xeA.xel));
    localStringBuilder.append(",");
    localStringBuilder.append(paramString);
    h.agF(localStringBuilder.toString());
  }
  
  public final void keep_OnReportEngineSend(String paramString)
  {
    c.d("TalkRoomService", new Object[] { "keep_OnReportEngineSend:", paramString });
    StringBuilder localStringBuilder = new StringBuilder(com.tencent.pb.common.c.g.afu(this.xeA.xel));
    localStringBuilder.append(",");
    localStringBuilder.append(paramString);
    h.agG(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.f.1
 * JD-Core Version:    0.7.0.1
 */