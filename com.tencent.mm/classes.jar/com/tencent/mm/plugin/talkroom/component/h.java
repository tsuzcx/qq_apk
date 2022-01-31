package com.tencent.mm.plugin.talkroom.component;

import android.media.AudioTrack;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.plugin.talkroom.model.a;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class h
  extends e.a
  implements Runnable
{
  private static final int tbK = a.tbK;
  private AudioTrack ayN;
  private int bufferSize;
  private boolean caT;
  private boolean cvo;
  private boolean gan;
  private boolean gcf;
  private ak handler;
  private final Object lock;
  private int obe;
  private int tbL;
  private final c tbM;
  private boolean tbN;
  private long tbO;
  private int tbP;
  private long tbQ;
  private v2engine tbv;
  private short tbw;
  private short tbx;
  
  public h(v2engine paramv2engine, c paramc)
  {
    AppMethodBeat.i(25737);
    this.tbL = tbK;
    this.bufferSize = (tbK / 1000 * 20 * 2);
    this.handler = new ak(Looper.getMainLooper());
    this.lock = new Object();
    this.caT = false;
    this.gan = false;
    this.cvo = true;
    this.tbN = false;
    this.tbO = 0L;
    this.gcf = true;
    this.obe = 0;
    this.tbQ = 0L;
    this.tbv = paramv2engine;
    this.tbM = paramc;
    this.gan = true;
    if ((this.ayN != null) && (this.ayN.getState() == 1)) {
      this.ayN.stop();
    }
    if (this.ayN != null) {}
    try
    {
      this.ayN.release();
      label152:
      v2engine.aaA().d(true, false, false);
      int i = v2engine.aaA().bM(true);
      int j = AudioTrack.getMinBufferSize(this.tbL, 2, 2);
      if ((j == -2) || (j == -1))
      {
        AppMethodBeat.o(25737);
        return;
      }
      this.ayN = new e(i, this.tbL, 2, j * 8);
      this.gan = false;
      AppMethodBeat.o(25737);
      return;
    }
    catch (Exception paramv2engine)
    {
      break label152;
    }
  }
  
  public final int cHq()
  {
    if (this.tbx < this.tbw) {
      this.tbx = this.tbw;
    }
    if (this.tbx == 0) {
      return 0;
    }
    int i = (short)(this.tbw * 100 / this.tbx);
    this.tbw = 0;
    return i;
  }
  
  public final void crn()
  {
    AppMethodBeat.i(25738);
    this.cvo = true;
    if ((this.ayN != null) && (this.ayN.getState() == 1)) {
      this.ayN.pause();
    }
    AppMethodBeat.o(25738);
  }
  
  public final void ctY()
  {
    AppMethodBeat.i(25739);
    if ((this.ayN != null) && (this.ayN.getState() == 1)) {
      this.ayN.play();
    }
    synchronized (this.lock)
    {
      this.cvo = false;
      this.lock.notify();
      this.tbx = 0;
      this.tbw = 0;
      AppMethodBeat.o(25739);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(25740);
    ab.i("MicroMsg.TalkRoomPlayer", "release");
    this.caT = true;
    if ((this.ayN != null) && (this.ayN.getState() == 1)) {
      this.ayN.stop();
    }
    if (this.ayN != null) {
      this.ayN.release();
    }
    synchronized (this.lock)
    {
      this.cvo = false;
      this.lock.notify();
      AppMethodBeat.o(25740);
      return;
    }
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: sipush 25741
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 78	com/tencent/mm/plugin/talkroom/component/h:caT	Z
    //   10: ifeq +10 -> 20
    //   13: sipush 25741
    //   16: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: return
    //   20: aload_0
    //   21: getfield 80	com/tencent/mm/plugin/talkroom/component/h:gan	Z
    //   24: ifeq +30 -> 54
    //   27: ldc2_w 169
    //   30: invokestatic 176	java/lang/Thread:sleep	(J)V
    //   33: goto -27 -> 6
    //   36: astore 8
    //   38: ldc 159
    //   40: aload 8
    //   42: ldc 178
    //   44: iconst_0
    //   45: anewarray 73	java/lang/Object
    //   48: invokestatic 182	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   51: goto -45 -> 6
    //   54: aload_0
    //   55: getfield 76	com/tencent/mm/plugin/talkroom/component/h:lock	Ljava/lang/Object;
    //   58: astore 8
    //   60: aload 8
    //   62: monitorenter
    //   63: aload_0
    //   64: getfield 82	com/tencent/mm/plugin/talkroom/component/h:cvo	Z
    //   67: istore 5
    //   69: iload 5
    //   71: ifeq +10 -> 81
    //   74: aload_0
    //   75: getfield 76	com/tencent/mm/plugin/talkroom/component/h:lock	Ljava/lang/Object;
    //   78: invokevirtual 185	java/lang/Object:wait	()V
    //   81: aload 8
    //   83: monitorexit
    //   84: aload_0
    //   85: getfield 92	com/tencent/mm/plugin/talkroom/component/h:tbQ	J
    //   88: lstore 6
    //   90: aload_0
    //   91: invokestatic 191	com/tencent/mm/sdk/platformtools/bo:yB	()J
    //   94: putfield 92	com/tencent/mm/plugin/talkroom/component/h:tbQ	J
    //   97: aload_0
    //   98: getfield 92	com/tencent/mm/plugin/talkroom/component/h:tbQ	J
    //   101: lload 6
    //   103: lsub
    //   104: lstore 6
    //   106: lload 6
    //   108: ldc2_w 192
    //   111: lcmp
    //   112: ifge +31 -> 143
    //   115: lload 6
    //   117: lconst_0
    //   118: lcmp
    //   119: ifle +24 -> 143
    //   122: aload_0
    //   123: getfield 76	com/tencent/mm/plugin/talkroom/component/h:lock	Ljava/lang/Object;
    //   126: astore 8
    //   128: aload 8
    //   130: monitorenter
    //   131: aload_0
    //   132: getfield 76	com/tencent/mm/plugin/talkroom/component/h:lock	Ljava/lang/Object;
    //   135: lload 6
    //   137: invokevirtual 195	java/lang/Object:wait	(J)V
    //   140: aload 8
    //   142: monitorexit
    //   143: new 197	com/tencent/mm/pointers/PByteArray
    //   146: dup
    //   147: invokespecial 198	com/tencent/mm/pointers/PByteArray:<init>	()V
    //   150: astore 8
    //   152: new 200	com/tencent/mm/pointers/PInt
    //   155: dup
    //   156: invokespecial 201	com/tencent/mm/pointers/PInt:<init>	()V
    //   159: astore 9
    //   161: new 200	com/tencent/mm/pointers/PInt
    //   164: dup
    //   165: invokespecial 201	com/tencent/mm/pointers/PInt:<init>	()V
    //   168: astore 10
    //   170: aload_0
    //   171: getfield 94	com/tencent/mm/plugin/talkroom/component/h:tbv	Lcom/tencent/mm/plugin/talkroom/component/v2engine;
    //   174: invokevirtual 204	com/tencent/mm/plugin/talkroom/component/v2engine:IsSilenceFrame	()I
    //   177: istore_3
    //   178: iload_3
    //   179: ifne +449 -> 628
    //   182: aload_0
    //   183: getfield 94	com/tencent/mm/plugin/talkroom/component/h:tbv	Lcom/tencent/mm/plugin/talkroom/component/v2engine;
    //   186: aload 8
    //   188: aload_0
    //   189: getfield 58	com/tencent/mm/plugin/talkroom/component/h:bufferSize	I
    //   192: aload 9
    //   194: aload 10
    //   196: invokevirtual 208	com/tencent/mm/plugin/talkroom/component/v2engine:GetAudioData	(Lcom/tencent/mm/pointers/PByteArray;ILcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)I
    //   199: istore_2
    //   200: iload_2
    //   201: ifge +155 -> 356
    //   204: aload_0
    //   205: aload_0
    //   206: getfield 90	com/tencent/mm/plugin/talkroom/component/h:obe	I
    //   209: iconst_1
    //   210: iadd
    //   211: putfield 90	com/tencent/mm/plugin/talkroom/component/h:obe	I
    //   214: ldc 159
    //   216: ldc 210
    //   218: iconst_2
    //   219: anewarray 73	java/lang/Object
    //   222: dup
    //   223: iconst_0
    //   224: iload_2
    //   225: invokestatic 216	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   228: aastore
    //   229: dup
    //   230: iconst_1
    //   231: aload_0
    //   232: getfield 90	com/tencent/mm/plugin/talkroom/component/h:obe	I
    //   235: invokestatic 216	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   238: aastore
    //   239: invokestatic 220	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   242: aload_0
    //   243: getfield 90	com/tencent/mm/plugin/talkroom/component/h:obe	I
    //   246: bipush 100
    //   248: if_icmplt -242 -> 6
    //   251: aload_0
    //   252: iconst_0
    //   253: putfield 90	com/tencent/mm/plugin/talkroom/component/h:obe	I
    //   256: aload_0
    //   257: iconst_1
    //   258: putfield 82	com/tencent/mm/plugin/talkroom/component/h:cvo	Z
    //   261: goto -255 -> 6
    //   264: astore 8
    //   266: ldc 159
    //   268: aload 8
    //   270: ldc 178
    //   272: iconst_0
    //   273: anewarray 73	java/lang/Object
    //   276: invokestatic 182	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   279: ldc 159
    //   281: aload 8
    //   283: invokevirtual 224	java/lang/Exception:toString	()Ljava/lang/String;
    //   286: invokestatic 226	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   289: goto -283 -> 6
    //   292: astore 9
    //   294: ldc 159
    //   296: aload 9
    //   298: ldc 178
    //   300: iconst_0
    //   301: anewarray 73	java/lang/Object
    //   304: invokestatic 182	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   307: goto -226 -> 81
    //   310: astore 9
    //   312: aload 8
    //   314: monitorexit
    //   315: sipush 25741
    //   318: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   321: aload 9
    //   323: athrow
    //   324: astore 9
    //   326: aload 8
    //   328: monitorexit
    //   329: sipush 25741
    //   332: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   335: aload 9
    //   337: athrow
    //   338: astore 8
    //   340: ldc 159
    //   342: aload 8
    //   344: ldc 178
    //   346: iconst_0
    //   347: anewarray 73	java/lang/Object
    //   350: invokestatic 182	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   353: goto -210 -> 143
    //   356: iload_3
    //   357: ifne +224 -> 581
    //   360: aload_0
    //   361: getfield 98	com/tencent/mm/plugin/talkroom/component/h:ayN	Landroid/media/AudioTrack;
    //   364: invokevirtual 229	android/media/AudioTrack:getPlayState	()I
    //   367: iconst_3
    //   368: if_icmpeq +10 -> 378
    //   371: aload_0
    //   372: getfield 98	com/tencent/mm/plugin/talkroom/component/h:ayN	Landroid/media/AudioTrack;
    //   375: invokevirtual 154	android/media/AudioTrack:play	()V
    //   378: aload 8
    //   380: getfield 233	com/tencent/mm/pointers/PByteArray:value	[B
    //   383: astore 11
    //   385: aload 8
    //   387: getfield 233	com/tencent/mm/pointers/PByteArray:value	[B
    //   390: arraylength
    //   391: istore 4
    //   393: iconst_0
    //   394: istore_2
    //   395: iload_2
    //   396: iload 4
    //   398: iconst_2
    //   399: idiv
    //   400: if_icmpge +43 -> 443
    //   403: aload 11
    //   405: iload_2
    //   406: iconst_2
    //   407: imul
    //   408: baload
    //   409: sipush 255
    //   412: iand
    //   413: aload 11
    //   415: iload_2
    //   416: iconst_2
    //   417: imul
    //   418: iconst_1
    //   419: iadd
    //   420: baload
    //   421: bipush 8
    //   423: ishl
    //   424: ior
    //   425: i2s
    //   426: istore_1
    //   427: iload_1
    //   428: aload_0
    //   429: getfield 146	com/tencent/mm/plugin/talkroom/component/h:tbw	S
    //   432: if_icmple +201 -> 633
    //   435: aload_0
    //   436: iload_1
    //   437: putfield 146	com/tencent/mm/plugin/talkroom/component/h:tbw	S
    //   440: goto +193 -> 633
    //   443: aload_0
    //   444: getfield 98	com/tencent/mm/plugin/talkroom/component/h:ayN	Landroid/media/AudioTrack;
    //   447: aload 8
    //   449: getfield 233	com/tencent/mm/pointers/PByteArray:value	[B
    //   452: iconst_0
    //   453: aload 8
    //   455: getfield 233	com/tencent/mm/pointers/PByteArray:value	[B
    //   458: arraylength
    //   459: invokevirtual 237	android/media/AudioTrack:write	([BII)I
    //   462: pop
    //   463: iload_3
    //   464: ifne +134 -> 598
    //   467: aload_0
    //   468: invokestatic 191	com/tencent/mm/sdk/platformtools/bo:yB	()J
    //   471: putfield 86	com/tencent/mm/plugin/talkroom/component/h:tbO	J
    //   474: iconst_0
    //   475: istore 5
    //   477: aload_0
    //   478: getfield 88	com/tencent/mm/plugin/talkroom/component/h:gcf	Z
    //   481: ifne +15 -> 496
    //   484: aload_0
    //   485: getfield 239	com/tencent/mm/plugin/talkroom/component/h:tbP	I
    //   488: aload 10
    //   490: getfield 241	com/tencent/mm/pointers/PInt:value	I
    //   493: if_icmpeq +16 -> 509
    //   496: iload 5
    //   498: ifne +11 -> 509
    //   501: aload 9
    //   503: getfield 241	com/tencent/mm/pointers/PInt:value	I
    //   506: ifne +15 -> 521
    //   509: aload_0
    //   510: getfield 88	com/tencent/mm/plugin/talkroom/component/h:gcf	Z
    //   513: ifne -507 -> 6
    //   516: iload 5
    //   518: ifeq -512 -> 6
    //   521: aload_0
    //   522: getfield 84	com/tencent/mm/plugin/talkroom/component/h:tbN	Z
    //   525: ifne -519 -> 6
    //   528: iload 5
    //   530: ifne +20 -> 550
    //   533: aload 10
    //   535: getfield 241	com/tencent/mm/pointers/PInt:value	I
    //   538: ifeq +12 -> 550
    //   541: aload_0
    //   542: aload 10
    //   544: getfield 241	com/tencent/mm/pointers/PInt:value	I
    //   547: putfield 239	com/tencent/mm/plugin/talkroom/component/h:tbP	I
    //   550: aload_0
    //   551: getfield 71	com/tencent/mm/plugin/talkroom/component/h:handler	Lcom/tencent/mm/sdk/platformtools/ak;
    //   554: new 243	com/tencent/mm/plugin/talkroom/component/h$1
    //   557: dup
    //   558: aload_0
    //   559: aload 9
    //   561: aload 10
    //   563: iload 5
    //   565: invokespecial 246	com/tencent/mm/plugin/talkroom/component/h$1:<init>	(Lcom/tencent/mm/plugin/talkroom/component/h;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Z)V
    //   568: invokevirtual 250	com/tencent/mm/sdk/platformtools/ak:postAtFrontOfQueueV2	(Ljava/lang/Runnable;)Z
    //   571: pop
    //   572: aload_0
    //   573: iload 5
    //   575: putfield 88	com/tencent/mm/plugin/talkroom/component/h:gcf	Z
    //   578: goto -572 -> 6
    //   581: aload_0
    //   582: getfield 88	com/tencent/mm/plugin/talkroom/component/h:gcf	Z
    //   585: ifeq -122 -> 463
    //   588: aload_0
    //   589: getfield 98	com/tencent/mm/plugin/talkroom/component/h:ayN	Landroid/media/AudioTrack;
    //   592: invokevirtual 150	android/media/AudioTrack:pause	()V
    //   595: goto -132 -> 463
    //   598: aload_0
    //   599: getfield 86	com/tencent/mm/plugin/talkroom/component/h:tbO	J
    //   602: invokestatic 254	com/tencent/mm/sdk/platformtools/bo:av	(J)J
    //   605: lstore 6
    //   607: lload 6
    //   609: ldc2_w 255
    //   612: lcmp
    //   613: ifge +9 -> 622
    //   616: iconst_0
    //   617: istore 5
    //   619: goto -142 -> 477
    //   622: iconst_1
    //   623: istore 5
    //   625: goto -148 -> 477
    //   628: iconst_0
    //   629: istore_2
    //   630: goto -430 -> 200
    //   633: iload_2
    //   634: iconst_1
    //   635: iadd
    //   636: istore_2
    //   637: goto -242 -> 395
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	640	0	this	h
    //   426	11	1	s	short
    //   199	438	2	i	int
    //   177	287	3	j	int
    //   391	9	4	k	int
    //   67	557	5	bool	boolean
    //   88	520	6	l	long
    //   36	5	8	localInterruptedException1	java.lang.InterruptedException
    //   264	63	8	localException	Exception
    //   338	116	8	localInterruptedException2	java.lang.InterruptedException
    //   159	34	9	localPInt1	com.tencent.mm.pointers.PInt
    //   292	5	9	localInterruptedException3	java.lang.InterruptedException
    //   310	12	9	localObject2	Object
    //   324	236	9	localPInt2	com.tencent.mm.pointers.PInt
    //   168	394	10	localPInt3	com.tencent.mm.pointers.PInt
    //   383	31	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   27	33	36	java/lang/InterruptedException
    //   143	178	264	java/lang/Exception
    //   182	200	264	java/lang/Exception
    //   204	261	264	java/lang/Exception
    //   360	378	264	java/lang/Exception
    //   378	393	264	java/lang/Exception
    //   395	403	264	java/lang/Exception
    //   427	440	264	java/lang/Exception
    //   443	463	264	java/lang/Exception
    //   467	474	264	java/lang/Exception
    //   477	496	264	java/lang/Exception
    //   501	509	264	java/lang/Exception
    //   509	516	264	java/lang/Exception
    //   521	528	264	java/lang/Exception
    //   533	550	264	java/lang/Exception
    //   550	578	264	java/lang/Exception
    //   581	595	264	java/lang/Exception
    //   598	607	264	java/lang/Exception
    //   74	81	292	java/lang/InterruptedException
    //   63	69	310	finally
    //   74	81	310	finally
    //   81	84	310	finally
    //   294	307	310	finally
    //   312	315	310	finally
    //   131	143	324	finally
    //   326	329	324	finally
    //   122	131	338	java/lang/InterruptedException
    //   329	338	338	java/lang/InterruptedException
  }
  
  public final void start()
  {
    AppMethodBeat.i(25742);
    d.h(this, "TalkRoomPlayer_start").start();
    AppMethodBeat.o(25742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.h
 * JD-Core Version:    0.7.0.1
 */