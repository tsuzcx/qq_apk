package com.tencent.mm.plugin.multitalk.a;

import android.os.Looper;
import com.tencent.mm.pluginsdk.f.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.LinkedBlockingQueue;

public final class l
  implements Runnable
{
  boolean bDX;
  protected volatile b mtQ;
  protected LinkedBlockingQueue<l.c> muA = new LinkedBlockingQueue();
  protected ah[] muB;
  volatile d muC = new d("multitalk_network");
  private int muD;
  private int muE = 5;
  private int muF;
  private int muG;
  
  public l(b paramb)
  {
    this.mtQ = paramb;
  }
  
  /* Error */
  private boolean a(l.c paramc)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_1
    //   6: ifnull +428 -> 434
    //   9: aload_1
    //   10: getfield 60	com/tencent/mm/plugin/multitalk/a/l$c:muJ	[I
    //   13: ifnonnull +11 -> 24
    //   16: aload_1
    //   17: ldc 61
    //   19: newarray int
    //   21: putfield 60	com/tencent/mm/plugin/multitalk/a/l$c:muJ	[I
    //   24: aload_1
    //   25: getfield 60	com/tencent/mm/plugin/multitalk/a/l$c:muJ	[I
    //   28: iconst_0
    //   29: iconst_0
    //   30: iastore
    //   31: invokestatic 67	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   34: invokevirtual 71	java/lang/Thread:getName	()Ljava/lang/String;
    //   37: ldc 73
    //   39: invokevirtual 79	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   42: ifeq +10 -> 52
    //   45: aload_1
    //   46: getfield 60	com/tencent/mm/plugin/multitalk/a/l$c:muJ	[I
    //   49: iconst_0
    //   50: iconst_1
    //   51: iastore
    //   52: invokestatic 85	com/tencent/mm/plugin/multitalk/a/p:blE	()Lcom/tencent/mm/plugin/multitalk/a/d;
    //   55: getfield 91	com/tencent/mm/plugin/multitalk/a/d:mtp	Lcom/tencent/pb/talkroom/sdk/d;
    //   58: aload_1
    //   59: getfield 60	com/tencent/mm/plugin/multitalk/a/l$c:muJ	[I
    //   62: invokeinterface 97 2 0
    //   67: astore 5
    //   69: aload_0
    //   70: getfield 51	com/tencent/mm/plugin/multitalk/a/l:mtQ	Lcom/tencent/mm/plugin/multitalk/a/b;
    //   73: ifnull +229 -> 302
    //   76: aload 5
    //   78: getfield 102	com/tencent/pb/talkroom/sdk/f:ret	I
    //   81: ifle +221 -> 302
    //   84: aload 5
    //   86: getfield 106	com/tencent/pb/talkroom/sdk/f:wJQ	Ljava/lang/String;
    //   89: invokestatic 112	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   92: ifne +210 -> 302
    //   95: aload_0
    //   96: getfield 51	com/tencent/mm/plugin/multitalk/a/l:mtQ	Lcom/tencent/mm/plugin/multitalk/a/b;
    //   99: aload 5
    //   101: getfield 106	com/tencent/pb/talkroom/sdk/f:wJQ	Ljava/lang/String;
    //   104: invokeinterface 118 2 0
    //   109: istore_2
    //   110: aload_1
    //   111: aload 5
    //   113: getfield 106	com/tencent/pb/talkroom/sdk/f:wJQ	Ljava/lang/String;
    //   116: putfield 121	com/tencent/mm/plugin/multitalk/a/l$c:username	Ljava/lang/String;
    //   119: aload_1
    //   120: aload 5
    //   122: getfield 124	com/tencent/pb/talkroom/sdk/f:wJU	I
    //   125: putfield 127	com/tencent/mm/plugin/multitalk/a/l$c:muL	I
    //   128: aload_1
    //   129: aload 5
    //   131: getfield 130	com/tencent/pb/talkroom/sdk/f:wJV	I
    //   134: putfield 133	com/tencent/mm/plugin/multitalk/a/l$c:muM	I
    //   137: aload_1
    //   138: aload 5
    //   140: getfield 136	com/tencent/pb/talkroom/sdk/f:wJT	I
    //   143: putfield 139	com/tencent/mm/plugin/multitalk/a/l$c:muK	I
    //   146: ldc 141
    //   148: ldc 143
    //   150: iconst_2
    //   151: anewarray 4	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: aload_1
    //   157: getfield 121	com/tencent/mm/plugin/multitalk/a/l$c:username	Ljava/lang/String;
    //   160: aastore
    //   161: dup
    //   162: iconst_1
    //   163: iload_2
    //   164: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   167: aastore
    //   168: invokestatic 155	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: iload_2
    //   172: iflt +35 -> 207
    //   175: aload_0
    //   176: getfield 157	com/tencent/mm/plugin/multitalk/a/l:muB	[Lcom/tencent/mm/sdk/platformtools/ah;
    //   179: iload_2
    //   180: iconst_2
    //   181: irem
    //   182: aaload
    //   183: ifnull +24 -> 207
    //   186: aload_0
    //   187: getfield 157	com/tencent/mm/plugin/multitalk/a/l:muB	[Lcom/tencent/mm/sdk/platformtools/ah;
    //   190: iload_2
    //   191: iconst_2
    //   192: irem
    //   193: aaload
    //   194: new 10	com/tencent/mm/plugin/multitalk/a/l$b
    //   197: dup
    //   198: aload_0
    //   199: aload_1
    //   200: invokespecial 160	com/tencent/mm/plugin/multitalk/a/l$b:<init>	(Lcom/tencent/mm/plugin/multitalk/a/l;Lcom/tencent/mm/plugin/multitalk/a/l$c;)V
    //   203: invokevirtual 166	com/tencent/mm/sdk/platformtools/ah:post	(Ljava/lang/Runnable;)Z
    //   206: pop
    //   207: aload_0
    //   208: getfield 42	com/tencent/mm/plugin/multitalk/a/l:muC	Lcom/tencent/mm/pluginsdk/f/d;
    //   211: ldc 168
    //   213: invokevirtual 171	com/tencent/mm/pluginsdk/f/d:Wd	(Ljava/lang/String;)V
    //   216: aload_0
    //   217: aload_0
    //   218: getfield 173	com/tencent/mm/plugin/multitalk/a/l:muG	I
    //   221: iconst_1
    //   222: iadd
    //   223: putfield 173	com/tencent/mm/plugin/multitalk/a/l:muG	I
    //   226: iload 4
    //   228: istore_3
    //   229: aload_0
    //   230: getfield 175	com/tencent/mm/plugin/multitalk/a/l:muF	I
    //   233: aload_0
    //   234: getfield 173	com/tencent/mm/plugin/multitalk/a/l:muG	I
    //   237: iadd
    //   238: bipush 100
    //   240: irem
    //   241: ifne +57 -> 298
    //   244: ldc 141
    //   246: ldc 177
    //   248: iconst_2
    //   249: anewarray 4	java/lang/Object
    //   252: dup
    //   253: iconst_0
    //   254: aload_0
    //   255: getfield 175	com/tencent/mm/plugin/multitalk/a/l:muF	I
    //   258: aload_0
    //   259: getfield 175	com/tencent/mm/plugin/multitalk/a/l:muF	I
    //   262: aload_0
    //   263: getfield 173	com/tencent/mm/plugin/multitalk/a/l:muG	I
    //   266: iadd
    //   267: idiv
    //   268: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   271: aastore
    //   272: dup
    //   273: iconst_1
    //   274: aload_0
    //   275: getfield 173	com/tencent/mm/plugin/multitalk/a/l:muG	I
    //   278: aload_0
    //   279: getfield 175	com/tencent/mm/plugin/multitalk/a/l:muF	I
    //   282: aload_0
    //   283: getfield 173	com/tencent/mm/plugin/multitalk/a/l:muG	I
    //   286: iadd
    //   287: idiv
    //   288: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   291: aastore
    //   292: invokestatic 180	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   295: iload 4
    //   297: istore_3
    //   298: aload_0
    //   299: monitorexit
    //   300: iload_3
    //   301: ireturn
    //   302: aload 5
    //   304: getfield 102	com/tencent/pb/talkroom/sdk/f:ret	I
    //   307: ifne +13 -> 320
    //   310: aload_0
    //   311: aload_0
    //   312: getfield 175	com/tencent/mm/plugin/multitalk/a/l:muF	I
    //   315: iconst_1
    //   316: iadd
    //   317: putfield 175	com/tencent/mm/plugin/multitalk/a/l:muF	I
    //   320: aload_0
    //   321: getfield 42	com/tencent/mm/plugin/multitalk/a/l:muC	Lcom/tencent/mm/pluginsdk/f/d;
    //   324: ldc 182
    //   326: invokevirtual 171	com/tencent/mm/pluginsdk/f/d:Wd	(Ljava/lang/String;)V
    //   329: ldc 141
    //   331: ldc 184
    //   333: iconst_1
    //   334: anewarray 4	java/lang/Object
    //   337: dup
    //   338: iconst_0
    //   339: aload 5
    //   341: getfield 102	com/tencent/pb/talkroom/sdk/f:ret	I
    //   344: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   347: aastore
    //   348: invokestatic 180	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   351: aload_0
    //   352: getfield 175	com/tencent/mm/plugin/multitalk/a/l:muF	I
    //   355: aload_0
    //   356: getfield 173	com/tencent/mm/plugin/multitalk/a/l:muG	I
    //   359: iadd
    //   360: bipush 100
    //   362: irem
    //   363: ifne +58 -> 421
    //   366: ldc 141
    //   368: ldc 186
    //   370: iconst_2
    //   371: anewarray 4	java/lang/Object
    //   374: dup
    //   375: iconst_0
    //   376: aload_0
    //   377: getfield 175	com/tencent/mm/plugin/multitalk/a/l:muF	I
    //   380: i2f
    //   381: aload_0
    //   382: getfield 175	com/tencent/mm/plugin/multitalk/a/l:muF	I
    //   385: aload_0
    //   386: getfield 173	com/tencent/mm/plugin/multitalk/a/l:muG	I
    //   389: iadd
    //   390: i2f
    //   391: fdiv
    //   392: invokestatic 191	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   395: aastore
    //   396: dup
    //   397: iconst_1
    //   398: aload_0
    //   399: getfield 173	com/tencent/mm/plugin/multitalk/a/l:muG	I
    //   402: i2f
    //   403: aload_0
    //   404: getfield 175	com/tencent/mm/plugin/multitalk/a/l:muF	I
    //   407: aload_0
    //   408: getfield 173	com/tencent/mm/plugin/multitalk/a/l:muG	I
    //   411: iadd
    //   412: i2f
    //   413: fdiv
    //   414: invokestatic 191	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   417: aastore
    //   418: invokestatic 180	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   421: aload_0
    //   422: getfield 49	com/tencent/mm/plugin/multitalk/a/l:muA	Ljava/util/concurrent/LinkedBlockingQueue;
    //   425: aload_1
    //   426: invokevirtual 195	java/util/concurrent/LinkedBlockingQueue:put	(Ljava/lang/Object;)V
    //   429: iconst_0
    //   430: istore_3
    //   431: goto -133 -> 298
    //   434: iconst_0
    //   435: istore_3
    //   436: goto -138 -> 298
    //   439: astore_1
    //   440: aload_0
    //   441: monitorexit
    //   442: aload_1
    //   443: athrow
    //   444: astore_1
    //   445: goto -16 -> 429
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	448	0	this	l
    //   0	448	1	paramc	l.c
    //   109	84	2	i	int
    //   228	208	3	bool1	boolean
    //   1	295	4	bool2	boolean
    //   67	273	5	localf	com.tencent.pb.talkroom.sdk.f
    // Exception table:
    //   from	to	target	type
    //   9	24	439	finally
    //   24	52	439	finally
    //   52	171	439	finally
    //   175	207	439	finally
    //   207	226	439	finally
    //   229	295	439	finally
    //   302	320	439	finally
    //   320	421	439	finally
    //   421	429	439	finally
    //   421	429	444	java/lang/InterruptedException
  }
  
  public final void run()
  {
    y.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "start run receiver sleepTime: " + this.muE);
    while (this.bDX)
    {
      this.muC.Wd("_total");
      Object localObject = null;
      try
      {
        l.c localc = (l.c)this.muA.take();
        localObject = localc;
      }
      catch (InterruptedException localInterruptedException2)
      {
        label55:
        boolean bool;
        break label55;
      }
      bool = false;
      if (localObject != null)
      {
        if (localObject.dYj) {
          break;
        }
        bool = a(localObject);
      }
      if (!bool) {
        try
        {
          Thread.sleep(this.muE);
        }
        catch (InterruptedException localInterruptedException1) {}
      }
    }
    y.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "stop run receiver");
  }
  
  public final void start()
  {
    y.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "current member size %d", new Object[] { Integer.valueOf(this.muD) });
    this.bDX = true;
    e.c(this, "MultiTalk_videoReceiver1", 1).start();
    e.c(this, "MultiTalk_videoReceiver2", 1).start();
    this.muB = new ah[2];
    int i = 0;
    while (i < this.muB.length)
    {
      e.c(new l.a(this, i), "MultiTalkVideoTaskManager_drawer_handler", 1).start();
      i += 1;
    }
    i = 0;
    while (i < 36)
    {
      this.muA.add(new l.c(this, false));
      i += 1;
    }
  }
  
  public final void stop()
  {
    int i = 0;
    this.mtQ = null;
    this.bDX = false;
    this.muD = 0;
    if (this.muB != null) {
      while (i < this.muB.length)
      {
        if (this.muB[i] != null)
        {
          this.muB[i].removeCallbacksAndMessages(null);
          this.muB[i].getLooper().quit();
          this.muB[i] = null;
        }
        i += 1;
      }
    }
    this.muA.clear();
    this.muA.add(new l.c(this, true));
    this.muA.add(new l.c(this, true));
  }
  
  public final void us(int paramInt)
  {
    this.muD = paramInt;
    y.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "memberSize " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.l
 * JD-Core Version:    0.7.0.1
 */