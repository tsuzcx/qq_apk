package com.tencent.mm.plugin.multitalk.model;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.e.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.pluginsdk.g.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.concurrent.LinkedBlockingQueue;

public final class l
  implements Runnable
{
  boolean running;
  protected volatile b tOU;
  protected LinkedBlockingQueue<a> tPK;
  protected ap[] tPL;
  volatile d tPM;
  private int tPN;
  private int tPO;
  private int tPP;
  private int tPQ;
  
  public l(b paramb)
  {
    AppMethodBeat.i(114598);
    this.tPM = new d("multitalk_network");
    this.tPO = 5;
    this.tPK = new LinkedBlockingQueue();
    this.tOU = paramb;
    AppMethodBeat.o(114598);
  }
  
  /* Error */
  private boolean a(final a parama)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 65
    //   6: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: ifnull +438 -> 448
    //   13: aload_1
    //   14: getfield 69	com/tencent/mm/plugin/multitalk/model/l$a:tPT	[I
    //   17: ifnonnull +11 -> 28
    //   20: aload_1
    //   21: ldc 70
    //   23: newarray int
    //   25: putfield 69	com/tencent/mm/plugin/multitalk/model/l$a:tPT	[I
    //   28: aload_1
    //   29: getfield 69	com/tencent/mm/plugin/multitalk/model/l$a:tPT	[I
    //   32: iconst_0
    //   33: iconst_0
    //   34: iastore
    //   35: invokestatic 76	com/tencent/e/j/a:fon	()Ljava/lang/String;
    //   38: ldc 78
    //   40: invokevirtual 84	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   43: ifeq +10 -> 53
    //   46: aload_1
    //   47: getfield 69	com/tencent/mm/plugin/multitalk/model/l$a:tPT	[I
    //   50: iconst_0
    //   51: iconst_1
    //   52: iastore
    //   53: invokestatic 90	com/tencent/mm/plugin/multitalk/model/p:cSN	()Lcom/tencent/mm/plugin/multitalk/model/d;
    //   56: getfield 96	com/tencent/mm/plugin/multitalk/model/d:tOr	Lcom/tencent/pb/talkroom/sdk/d;
    //   59: aload_1
    //   60: getfield 69	com/tencent/mm/plugin/multitalk/model/l$a:tPT	[I
    //   63: invokeinterface 102 2 0
    //   68: astore 4
    //   70: aload 4
    //   72: ifnonnull +12 -> 84
    //   75: ldc 65
    //   77: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aload_0
    //   81: monitorexit
    //   82: iload_3
    //   83: ireturn
    //   84: aload_0
    //   85: getfield 57	com/tencent/mm/plugin/multitalk/model/l:tOU	Lcom/tencent/mm/plugin/multitalk/model/b;
    //   88: ifnull +220 -> 308
    //   91: aload 4
    //   93: getfield 107	com/tencent/pb/talkroom/sdk/f:ret	I
    //   96: ifle +212 -> 308
    //   99: aload 4
    //   101: getfield 111	com/tencent/pb/talkroom/sdk/f:Iol	Ljava/lang/String;
    //   104: invokestatic 117	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   107: ifne +201 -> 308
    //   110: aload_0
    //   111: getfield 57	com/tencent/mm/plugin/multitalk/model/l:tOU	Lcom/tencent/mm/plugin/multitalk/model/b;
    //   114: aload 4
    //   116: getfield 111	com/tencent/pb/talkroom/sdk/f:Iol	Ljava/lang/String;
    //   119: invokeinterface 123 2 0
    //   124: istore_2
    //   125: aload_1
    //   126: aload 4
    //   128: getfield 111	com/tencent/pb/talkroom/sdk/f:Iol	Ljava/lang/String;
    //   131: putfield 126	com/tencent/mm/plugin/multitalk/model/l$a:username	Ljava/lang/String;
    //   134: aload_1
    //   135: aload 4
    //   137: getfield 129	com/tencent/pb/talkroom/sdk/f:Iop	I
    //   140: putfield 132	com/tencent/mm/plugin/multitalk/model/l$a:tPV	I
    //   143: aload_1
    //   144: aload 4
    //   146: getfield 135	com/tencent/pb/talkroom/sdk/f:Ioq	I
    //   149: putfield 138	com/tencent/mm/plugin/multitalk/model/l$a:tPW	I
    //   152: aload_1
    //   153: aload 4
    //   155: getfield 141	com/tencent/pb/talkroom/sdk/f:Ioo	I
    //   158: putfield 144	com/tencent/mm/plugin/multitalk/model/l$a:tPU	I
    //   161: ldc 146
    //   163: ldc 148
    //   165: iconst_2
    //   166: anewarray 4	java/lang/Object
    //   169: dup
    //   170: iconst_0
    //   171: aload_1
    //   172: getfield 126	com/tencent/mm/plugin/multitalk/model/l$a:username	Ljava/lang/String;
    //   175: aastore
    //   176: dup
    //   177: iconst_1
    //   178: iload_2
    //   179: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   182: aastore
    //   183: invokestatic 160	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   186: iload_2
    //   187: iflt +26 -> 213
    //   190: aload_0
    //   191: getfield 162	com/tencent/mm/plugin/multitalk/model/l:tPL	[Lcom/tencent/mm/sdk/platformtools/ap;
    //   194: iload_2
    //   195: iconst_2
    //   196: irem
    //   197: aaload
    //   198: ifnull +15 -> 213
    //   201: new 8	com/tencent/mm/plugin/multitalk/model/l$1
    //   204: dup
    //   205: aload_0
    //   206: aload_1
    //   207: invokespecial 165	com/tencent/mm/plugin/multitalk/model/l$1:<init>	(Lcom/tencent/mm/plugin/multitalk/model/l;Lcom/tencent/mm/plugin/multitalk/model/l$a;)V
    //   210: invokestatic 171	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   213: aload_0
    //   214: getfield 48	com/tencent/mm/plugin/multitalk/model/l:tPM	Lcom/tencent/mm/pluginsdk/g/d;
    //   217: ldc 173
    //   219: invokevirtual 176	com/tencent/mm/pluginsdk/g/d:aBe	(Ljava/lang/String;)V
    //   222: aload_0
    //   223: aload_0
    //   224: getfield 178	com/tencent/mm/plugin/multitalk/model/l:tPQ	I
    //   227: iconst_1
    //   228: iadd
    //   229: putfield 178	com/tencent/mm/plugin/multitalk/model/l:tPQ	I
    //   232: aload_0
    //   233: getfield 180	com/tencent/mm/plugin/multitalk/model/l:tPP	I
    //   236: aload_0
    //   237: getfield 178	com/tencent/mm/plugin/multitalk/model/l:tPQ	I
    //   240: iadd
    //   241: bipush 100
    //   243: irem
    //   244: ifne +54 -> 298
    //   247: ldc 146
    //   249: ldc 182
    //   251: iconst_2
    //   252: anewarray 4	java/lang/Object
    //   255: dup
    //   256: iconst_0
    //   257: aload_0
    //   258: getfield 180	com/tencent/mm/plugin/multitalk/model/l:tPP	I
    //   261: aload_0
    //   262: getfield 180	com/tencent/mm/plugin/multitalk/model/l:tPP	I
    //   265: aload_0
    //   266: getfield 178	com/tencent/mm/plugin/multitalk/model/l:tPQ	I
    //   269: iadd
    //   270: idiv
    //   271: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   274: aastore
    //   275: dup
    //   276: iconst_1
    //   277: aload_0
    //   278: getfield 178	com/tencent/mm/plugin/multitalk/model/l:tPQ	I
    //   281: aload_0
    //   282: getfield 180	com/tencent/mm/plugin/multitalk/model/l:tPP	I
    //   285: aload_0
    //   286: getfield 178	com/tencent/mm/plugin/multitalk/model/l:tPQ	I
    //   289: iadd
    //   290: idiv
    //   291: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   294: aastore
    //   295: invokestatic 185	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   298: ldc 65
    //   300: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   303: iconst_1
    //   304: istore_3
    //   305: goto -225 -> 80
    //   308: aload 4
    //   310: getfield 107	com/tencent/pb/talkroom/sdk/f:ret	I
    //   313: ifne +13 -> 326
    //   316: aload_0
    //   317: aload_0
    //   318: getfield 180	com/tencent/mm/plugin/multitalk/model/l:tPP	I
    //   321: iconst_1
    //   322: iadd
    //   323: putfield 180	com/tencent/mm/plugin/multitalk/model/l:tPP	I
    //   326: aload_0
    //   327: getfield 48	com/tencent/mm/plugin/multitalk/model/l:tPM	Lcom/tencent/mm/pluginsdk/g/d;
    //   330: ldc 187
    //   332: invokevirtual 176	com/tencent/mm/pluginsdk/g/d:aBe	(Ljava/lang/String;)V
    //   335: ldc 146
    //   337: ldc 189
    //   339: iconst_1
    //   340: anewarray 4	java/lang/Object
    //   343: dup
    //   344: iconst_0
    //   345: aload 4
    //   347: getfield 107	com/tencent/pb/talkroom/sdk/f:ret	I
    //   350: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   353: aastore
    //   354: invokestatic 185	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   357: aload_0
    //   358: getfield 180	com/tencent/mm/plugin/multitalk/model/l:tPP	I
    //   361: aload_0
    //   362: getfield 178	com/tencent/mm/plugin/multitalk/model/l:tPQ	I
    //   365: iadd
    //   366: bipush 100
    //   368: irem
    //   369: ifne +58 -> 427
    //   372: ldc 146
    //   374: ldc 191
    //   376: iconst_2
    //   377: anewarray 4	java/lang/Object
    //   380: dup
    //   381: iconst_0
    //   382: aload_0
    //   383: getfield 180	com/tencent/mm/plugin/multitalk/model/l:tPP	I
    //   386: i2f
    //   387: aload_0
    //   388: getfield 180	com/tencent/mm/plugin/multitalk/model/l:tPP	I
    //   391: aload_0
    //   392: getfield 178	com/tencent/mm/plugin/multitalk/model/l:tPQ	I
    //   395: iadd
    //   396: i2f
    //   397: fdiv
    //   398: invokestatic 196	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   401: aastore
    //   402: dup
    //   403: iconst_1
    //   404: aload_0
    //   405: getfield 178	com/tencent/mm/plugin/multitalk/model/l:tPQ	I
    //   408: i2f
    //   409: aload_0
    //   410: getfield 180	com/tencent/mm/plugin/multitalk/model/l:tPP	I
    //   413: aload_0
    //   414: getfield 178	com/tencent/mm/plugin/multitalk/model/l:tPQ	I
    //   417: iadd
    //   418: i2f
    //   419: fdiv
    //   420: invokestatic 196	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   423: aastore
    //   424: invokestatic 185	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   427: aload_0
    //   428: getfield 55	com/tencent/mm/plugin/multitalk/model/l:tPK	Ljava/util/concurrent/LinkedBlockingQueue;
    //   431: aload_1
    //   432: invokevirtual 200	java/util/concurrent/LinkedBlockingQueue:put	(Ljava/lang/Object;)V
    //   435: ldc 65
    //   437: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   440: goto -360 -> 80
    //   443: astore_1
    //   444: aload_0
    //   445: monitorexit
    //   446: aload_1
    //   447: athrow
    //   448: ldc 65
    //   450: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   453: goto -373 -> 80
    //   456: astore_1
    //   457: goto -22 -> 435
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	460	0	this	l
    //   0	460	1	parama	a
    //   124	73	2	i	int
    //   1	304	3	bool	boolean
    //   68	278	4	localf	com.tencent.pb.talkroom.sdk.f
    // Exception table:
    //   from	to	target	type
    //   4	9	443	finally
    //   13	28	443	finally
    //   28	53	443	finally
    //   53	70	443	finally
    //   75	80	443	finally
    //   84	186	443	finally
    //   190	213	443	finally
    //   213	298	443	finally
    //   298	303	443	finally
    //   308	326	443	finally
    //   326	427	443	finally
    //   427	435	443	finally
    //   435	440	443	finally
    //   448	453	443	finally
    //   427	435	456	java/lang/InterruptedException
  }
  
  public final void Hl(int paramInt)
  {
    AppMethodBeat.i(114602);
    this.tPN = paramInt;
    ad.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "memberSize ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(114602);
  }
  
  public final void run()
  {
    AppMethodBeat.i(114601);
    ad.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "start run receiver sleepTime: " + this.tPO);
    while (this.running)
    {
      this.tPM.aBe("_total");
      Object localObject = null;
      try
      {
        a locala = (a)this.tPK.take();
        localObject = locala;
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
        if (localObject.gPQ) {
          break;
        }
        bool = a(localObject);
      }
      if (!bool) {
        try
        {
          Thread.sleep(this.tPO);
        }
        catch (InterruptedException localInterruptedException1) {}
      }
    }
    ad.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "stop run receiver");
    AppMethodBeat.o(114601);
  }
  
  public final void start()
  {
    AppMethodBeat.i(114599);
    ad.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "current member size %d", new Object[] { Integer.valueOf(this.tPN) });
    this.running = true;
    h.Iye.f(this, "MultiTalk_videoReceiver1");
    h.Iye.f(this, "MultiTalk_videoReceiver2");
    this.tPL = new ap[2];
    int i = 0;
    while (i < this.tPL.length)
    {
      this.tPL[i] = new ap("MultiTalkVideoTaskManager_drawer_handler#".concat(String.valueOf(i)));
      i += 1;
    }
    i = 0;
    while (i < 36)
    {
      this.tPK.add(new a(false));
      i += 1;
    }
    AppMethodBeat.o(114599);
  }
  
  public final void stop()
  {
    int i = 0;
    AppMethodBeat.i(114600);
    this.tOU = null;
    this.running = false;
    this.tPN = 0;
    if (this.tPL != null) {
      while (i < this.tPL.length)
      {
        if (this.tPL[i] != null)
        {
          this.tPL[i].removeCallbacksAndMessages(null);
          this.tPL[i].getSerial().quit();
          this.tPL[i] = null;
        }
        i += 1;
      }
    }
    this.tPK.clear();
    this.tPK.add(new a(true));
    this.tPK.add(new a(true));
    AppMethodBeat.o(114600);
  }
  
  public final class a
  {
    boolean gPQ;
    int[] tPT;
    int tPU;
    int tPV;
    int tPW;
    String username;
    
    a(boolean paramBoolean)
    {
      this.gPQ = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.l
 * JD-Core Version:    0.7.0.1
 */