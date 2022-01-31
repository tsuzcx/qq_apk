package com.tencent.mm.plugin.multitalk.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.concurrent.LinkedBlockingQueue;

public final class l
  implements Runnable
{
  protected volatile b oTC;
  protected LinkedBlockingQueue<l.c> oUp;
  protected ak[] oUq;
  volatile com.tencent.mm.pluginsdk.f.d oUr;
  private int oUs;
  private int oUt;
  private int oUu;
  private int oUv;
  boolean running;
  
  public l(b paramb)
  {
    AppMethodBeat.i(54067);
    this.oUr = new com.tencent.mm.pluginsdk.f.d("multitalk_network");
    this.oUt = 5;
    this.oUp = new LinkedBlockingQueue();
    this.oTC = paramb;
    AppMethodBeat.o(54067);
  }
  
  /* Error */
  private boolean a(l.c paramc)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 68
    //   6: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: ifnull +450 -> 460
    //   13: aload_1
    //   14: getfield 72	com/tencent/mm/plugin/multitalk/model/l$c:oUy	[I
    //   17: ifnonnull +11 -> 28
    //   20: aload_1
    //   21: ldc 73
    //   23: newarray int
    //   25: putfield 72	com/tencent/mm/plugin/multitalk/model/l$c:oUy	[I
    //   28: aload_1
    //   29: getfield 72	com/tencent/mm/plugin/multitalk/model/l$c:oUy	[I
    //   32: iconst_0
    //   33: iconst_0
    //   34: iastore
    //   35: invokestatic 79	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   38: invokevirtual 83	java/lang/Thread:getName	()Ljava/lang/String;
    //   41: ldc 85
    //   43: invokevirtual 91	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   46: ifeq +10 -> 56
    //   49: aload_1
    //   50: getfield 72	com/tencent/mm/plugin/multitalk/model/l$c:oUy	[I
    //   53: iconst_0
    //   54: iconst_1
    //   55: iastore
    //   56: invokestatic 97	com/tencent/mm/plugin/multitalk/model/p:bTE	()Lcom/tencent/mm/plugin/multitalk/model/d;
    //   59: getfield 103	com/tencent/mm/plugin/multitalk/model/d:oTa	Lcom/tencent/pb/talkroom/sdk/d;
    //   62: aload_1
    //   63: getfield 72	com/tencent/mm/plugin/multitalk/model/l$c:oUy	[I
    //   66: invokeinterface 109 2 0
    //   71: astore 4
    //   73: aload 4
    //   75: ifnonnull +12 -> 87
    //   78: ldc 68
    //   80: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: aload_0
    //   84: monitorexit
    //   85: iload_3
    //   86: ireturn
    //   87: aload_0
    //   88: getfield 59	com/tencent/mm/plugin/multitalk/model/l:oTC	Lcom/tencent/mm/plugin/multitalk/model/b;
    //   91: ifnull +229 -> 320
    //   94: aload 4
    //   96: getfield 114	com/tencent/pb/talkroom/sdk/f:ret	I
    //   99: ifle +221 -> 320
    //   102: aload 4
    //   104: getfield 118	com/tencent/pb/talkroom/sdk/f:Bhq	Ljava/lang/String;
    //   107: invokestatic 124	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   110: ifne +210 -> 320
    //   113: aload_0
    //   114: getfield 59	com/tencent/mm/plugin/multitalk/model/l:oTC	Lcom/tencent/mm/plugin/multitalk/model/b;
    //   117: aload 4
    //   119: getfield 118	com/tencent/pb/talkroom/sdk/f:Bhq	Ljava/lang/String;
    //   122: invokeinterface 130 2 0
    //   127: istore_2
    //   128: aload_1
    //   129: aload 4
    //   131: getfield 118	com/tencent/pb/talkroom/sdk/f:Bhq	Ljava/lang/String;
    //   134: putfield 133	com/tencent/mm/plugin/multitalk/model/l$c:username	Ljava/lang/String;
    //   137: aload_1
    //   138: aload 4
    //   140: getfield 136	com/tencent/pb/talkroom/sdk/f:Bhu	I
    //   143: putfield 139	com/tencent/mm/plugin/multitalk/model/l$c:oUA	I
    //   146: aload_1
    //   147: aload 4
    //   149: getfield 142	com/tencent/pb/talkroom/sdk/f:Bhv	I
    //   152: putfield 145	com/tencent/mm/plugin/multitalk/model/l$c:oUB	I
    //   155: aload_1
    //   156: aload 4
    //   158: getfield 148	com/tencent/pb/talkroom/sdk/f:Bht	I
    //   161: putfield 151	com/tencent/mm/plugin/multitalk/model/l$c:oUz	I
    //   164: ldc 153
    //   166: ldc 155
    //   168: iconst_2
    //   169: anewarray 4	java/lang/Object
    //   172: dup
    //   173: iconst_0
    //   174: aload_1
    //   175: getfield 133	com/tencent/mm/plugin/multitalk/model/l$c:username	Ljava/lang/String;
    //   178: aastore
    //   179: dup
    //   180: iconst_1
    //   181: iload_2
    //   182: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   185: aastore
    //   186: invokestatic 167	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: iload_2
    //   190: iflt +35 -> 225
    //   193: aload_0
    //   194: getfield 169	com/tencent/mm/plugin/multitalk/model/l:oUq	[Lcom/tencent/mm/sdk/platformtools/ak;
    //   197: iload_2
    //   198: iconst_2
    //   199: irem
    //   200: aaload
    //   201: ifnull +24 -> 225
    //   204: aload_0
    //   205: getfield 169	com/tencent/mm/plugin/multitalk/model/l:oUq	[Lcom/tencent/mm/sdk/platformtools/ak;
    //   208: iload_2
    //   209: iconst_2
    //   210: irem
    //   211: aaload
    //   212: new 10	com/tencent/mm/plugin/multitalk/model/l$b
    //   215: dup
    //   216: aload_0
    //   217: aload_1
    //   218: invokespecial 172	com/tencent/mm/plugin/multitalk/model/l$b:<init>	(Lcom/tencent/mm/plugin/multitalk/model/l;Lcom/tencent/mm/plugin/multitalk/model/l$c;)V
    //   221: invokevirtual 178	com/tencent/mm/sdk/platformtools/ak:post	(Ljava/lang/Runnable;)Z
    //   224: pop
    //   225: aload_0
    //   226: getfield 50	com/tencent/mm/plugin/multitalk/model/l:oUr	Lcom/tencent/mm/pluginsdk/f/d;
    //   229: ldc 180
    //   231: invokevirtual 183	com/tencent/mm/pluginsdk/f/d:alD	(Ljava/lang/String;)V
    //   234: aload_0
    //   235: aload_0
    //   236: getfield 185	com/tencent/mm/plugin/multitalk/model/l:oUv	I
    //   239: iconst_1
    //   240: iadd
    //   241: putfield 185	com/tencent/mm/plugin/multitalk/model/l:oUv	I
    //   244: aload_0
    //   245: getfield 187	com/tencent/mm/plugin/multitalk/model/l:oUu	I
    //   248: aload_0
    //   249: getfield 185	com/tencent/mm/plugin/multitalk/model/l:oUv	I
    //   252: iadd
    //   253: bipush 100
    //   255: irem
    //   256: ifne +54 -> 310
    //   259: ldc 153
    //   261: ldc 189
    //   263: iconst_2
    //   264: anewarray 4	java/lang/Object
    //   267: dup
    //   268: iconst_0
    //   269: aload_0
    //   270: getfield 187	com/tencent/mm/plugin/multitalk/model/l:oUu	I
    //   273: aload_0
    //   274: getfield 187	com/tencent/mm/plugin/multitalk/model/l:oUu	I
    //   277: aload_0
    //   278: getfield 185	com/tencent/mm/plugin/multitalk/model/l:oUv	I
    //   281: iadd
    //   282: idiv
    //   283: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   286: aastore
    //   287: dup
    //   288: iconst_1
    //   289: aload_0
    //   290: getfield 185	com/tencent/mm/plugin/multitalk/model/l:oUv	I
    //   293: aload_0
    //   294: getfield 187	com/tencent/mm/plugin/multitalk/model/l:oUu	I
    //   297: aload_0
    //   298: getfield 185	com/tencent/mm/plugin/multitalk/model/l:oUv	I
    //   301: iadd
    //   302: idiv
    //   303: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   306: aastore
    //   307: invokestatic 192	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   310: ldc 68
    //   312: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   315: iconst_1
    //   316: istore_3
    //   317: goto -234 -> 83
    //   320: aload 4
    //   322: getfield 114	com/tencent/pb/talkroom/sdk/f:ret	I
    //   325: ifne +13 -> 338
    //   328: aload_0
    //   329: aload_0
    //   330: getfield 187	com/tencent/mm/plugin/multitalk/model/l:oUu	I
    //   333: iconst_1
    //   334: iadd
    //   335: putfield 187	com/tencent/mm/plugin/multitalk/model/l:oUu	I
    //   338: aload_0
    //   339: getfield 50	com/tencent/mm/plugin/multitalk/model/l:oUr	Lcom/tencent/mm/pluginsdk/f/d;
    //   342: ldc 194
    //   344: invokevirtual 183	com/tencent/mm/pluginsdk/f/d:alD	(Ljava/lang/String;)V
    //   347: ldc 153
    //   349: ldc 196
    //   351: iconst_1
    //   352: anewarray 4	java/lang/Object
    //   355: dup
    //   356: iconst_0
    //   357: aload 4
    //   359: getfield 114	com/tencent/pb/talkroom/sdk/f:ret	I
    //   362: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   365: aastore
    //   366: invokestatic 192	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   369: aload_0
    //   370: getfield 187	com/tencent/mm/plugin/multitalk/model/l:oUu	I
    //   373: aload_0
    //   374: getfield 185	com/tencent/mm/plugin/multitalk/model/l:oUv	I
    //   377: iadd
    //   378: bipush 100
    //   380: irem
    //   381: ifne +58 -> 439
    //   384: ldc 153
    //   386: ldc 198
    //   388: iconst_2
    //   389: anewarray 4	java/lang/Object
    //   392: dup
    //   393: iconst_0
    //   394: aload_0
    //   395: getfield 187	com/tencent/mm/plugin/multitalk/model/l:oUu	I
    //   398: i2f
    //   399: aload_0
    //   400: getfield 187	com/tencent/mm/plugin/multitalk/model/l:oUu	I
    //   403: aload_0
    //   404: getfield 185	com/tencent/mm/plugin/multitalk/model/l:oUv	I
    //   407: iadd
    //   408: i2f
    //   409: fdiv
    //   410: invokestatic 203	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   413: aastore
    //   414: dup
    //   415: iconst_1
    //   416: aload_0
    //   417: getfield 185	com/tencent/mm/plugin/multitalk/model/l:oUv	I
    //   420: i2f
    //   421: aload_0
    //   422: getfield 187	com/tencent/mm/plugin/multitalk/model/l:oUu	I
    //   425: aload_0
    //   426: getfield 185	com/tencent/mm/plugin/multitalk/model/l:oUv	I
    //   429: iadd
    //   430: i2f
    //   431: fdiv
    //   432: invokestatic 203	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   435: aastore
    //   436: invokestatic 192	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   439: aload_0
    //   440: getfield 57	com/tencent/mm/plugin/multitalk/model/l:oUp	Ljava/util/concurrent/LinkedBlockingQueue;
    //   443: aload_1
    //   444: invokevirtual 207	java/util/concurrent/LinkedBlockingQueue:put	(Ljava/lang/Object;)V
    //   447: ldc 68
    //   449: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   452: goto -369 -> 83
    //   455: astore_1
    //   456: aload_0
    //   457: monitorexit
    //   458: aload_1
    //   459: athrow
    //   460: ldc 68
    //   462: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   465: goto -382 -> 83
    //   468: astore_1
    //   469: goto -22 -> 447
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	472	0	this	l
    //   0	472	1	paramc	l.c
    //   127	84	2	i	int
    //   1	316	3	bool	boolean
    //   71	287	4	localf	com.tencent.pb.talkroom.sdk.f
    // Exception table:
    //   from	to	target	type
    //   4	9	455	finally
    //   13	28	455	finally
    //   28	56	455	finally
    //   56	73	455	finally
    //   78	83	455	finally
    //   87	189	455	finally
    //   193	225	455	finally
    //   225	310	455	finally
    //   310	315	455	finally
    //   320	338	455	finally
    //   338	439	455	finally
    //   439	447	455	finally
    //   447	452	455	finally
    //   460	465	455	finally
    //   439	447	468	java/lang/InterruptedException
  }
  
  public final void run()
  {
    AppMethodBeat.i(54070);
    ab.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "start run receiver sleepTime: " + this.oUt);
    while (this.running)
    {
      this.oUr.alD("_total");
      Object localObject = null;
      try
      {
        l.c localc = (l.c)this.oUp.take();
        localObject = localc;
      }
      catch (InterruptedException localInterruptedException2)
      {
        label60:
        boolean bool;
        break label60;
      }
      bool = false;
      if (localObject != null)
      {
        if (localObject.fon) {
          break;
        }
        bool = a(localObject);
      }
      if (!bool) {
        try
        {
          Thread.sleep(this.oUt);
        }
        catch (InterruptedException localInterruptedException1) {}
      }
    }
    ab.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "stop run receiver");
    AppMethodBeat.o(54070);
  }
  
  public final void start()
  {
    AppMethodBeat.i(54068);
    ab.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "current member size %d", new Object[] { Integer.valueOf(this.oUs) });
    this.running = true;
    com.tencent.mm.sdk.g.d.a(this, "MultiTalk_videoReceiver1", 1).start();
    com.tencent.mm.sdk.g.d.a(this, "MultiTalk_videoReceiver2", 1).start();
    this.oUq = new ak[2];
    int i = 0;
    while (i < this.oUq.length)
    {
      com.tencent.mm.sdk.g.d.a(new l.a(this, i), "MultiTalkVideoTaskManager_drawer_handler", 1).start();
      i += 1;
    }
    i = 0;
    while (i < 36)
    {
      this.oUp.add(new l.c(this, false));
      i += 1;
    }
    AppMethodBeat.o(54068);
  }
  
  public final void stop()
  {
    int i = 0;
    AppMethodBeat.i(54069);
    this.oTC = null;
    this.running = false;
    this.oUs = 0;
    if (this.oUq != null) {
      while (i < this.oUq.length)
      {
        if (this.oUq[i] != null)
        {
          this.oUq[i].removeCallbacksAndMessages(null);
          this.oUq[i].getLooper().quit();
          this.oUq[i] = null;
        }
        i += 1;
      }
    }
    this.oUp.clear();
    this.oUp.add(new l.c(this, true));
    this.oUp.add(new l.c(this, true));
    AppMethodBeat.o(54069);
  }
  
  public final void zI(int paramInt)
  {
    AppMethodBeat.i(54071);
    this.oUs = paramInt;
    ab.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "memberSize ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(54071);
  }
  
  protected final class b
    implements Runnable
  {
    private l.c oUx;
    
    public b(l.c paramc)
    {
      this.oUx = paramc;
    }
    
    public final void run()
    {
      AppMethodBeat.i(54066);
      if (this.oUx != null)
      {
        ab.d("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "draw user %s threadId %d", new Object[] { this.oUx.username, Long.valueOf(Thread.currentThread().getId()) });
        if (l.this.oTC != null) {
          l.this.oTC.a(this.oUx.username, this.oUx.oUy, this.oUx.oUA, this.oUx.oUB, OpenGlRender.FLAG_Angle90);
        }
        try
        {
          l.this.oUp.put(this.oUx);
          AppMethodBeat.o(54066);
          return;
        }
        catch (InterruptedException localInterruptedException) {}
      }
      AppMethodBeat.o(54066);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.l
 * JD-Core Version:    0.7.0.1
 */