package com.tencent.mm.plugin.sns.ad.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.d.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
{
  public String TAG;
  public long imX;
  public long imY;
  public long vtP;
  public int yZe;
  public int yZf;
  public long yZg;
  public int yZh;
  public int yZi;
  public int yZj;
  public int yZk;
  public boolean yZl;
  public a yZm;
  public LinkedList<a> yZn;
  private long yZo;
  public long yZp;
  
  public j()
  {
    AppMethodBeat.i(95020);
    this.TAG = "MicroMsg.SnsAdVideoStatistic";
    this.yZe = 0;
    this.yZf = 0;
    this.yZg = 0L;
    this.yZh = 0;
    this.imY = 0L;
    this.yZi = 0;
    this.yZj = 0;
    this.yZk = 0;
    this.yZl = false;
    this.yZm = new a();
    this.yZn = new LinkedList();
    this.vtP = 0L;
    this.imX = 0L;
    this.yZo = 0L;
    AppMethodBeat.o(95020);
  }
  
  public j(String paramString)
  {
    AppMethodBeat.i(95021);
    this.TAG = "MicroMsg.SnsAdVideoStatistic";
    this.yZe = 0;
    this.yZf = 0;
    this.yZg = 0L;
    this.yZh = 0;
    this.imY = 0L;
    this.yZi = 0;
    this.yZj = 0;
    this.yZk = 0;
    this.yZl = false;
    this.yZm = new a();
    this.yZn = new LinkedList();
    this.vtP = 0L;
    this.imX = 0L;
    this.yZo = 0L;
    this.TAG = "MicroMsg.SnsAdVideoStatistic:".concat(String.valueOf(paramString));
    AppMethodBeat.o(95021);
  }
  
  /* Error */
  public final void Py(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 96
    //   4: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:yZm	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   11: getfield 99	com/tencent/mm/plugin/sns/ad/d/a/a:zao	I
    //   14: ifgt +148 -> 162
    //   17: aload_0
    //   18: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:yZm	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   21: astore 5
    //   23: aload_0
    //   24: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:yZm	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   27: getfield 102	com/tencent/mm/plugin/sns/ad/d/a/a:zas	J
    //   30: lconst_0
    //   31: lcmp
    //   32: ifne +223 -> 255
    //   35: iconst_0
    //   36: istore_2
    //   37: aload 5
    //   39: iload_2
    //   40: putfield 99	com/tencent/mm/plugin/sns/ad/d/a/a:zao	I
    //   43: aload_0
    //   44: invokevirtual 105	com/tencent/mm/plugin/sns/ad/d/j:dRB	()V
    //   47: aload_0
    //   48: getfield 42	com/tencent/mm/plugin/sns/ad/d/j:TAG	Ljava/lang/String;
    //   51: new 107	java/lang/StringBuilder
    //   54: dup
    //   55: ldc 109
    //   57: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   60: aload_0
    //   61: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:yZm	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   64: getfield 99	com/tencent/mm/plugin/sns/ad/d/a/a:zao	I
    //   67: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: ldc 117
    //   72: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_0
    //   76: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:yZm	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   79: getfield 123	com/tencent/mm/plugin/sns/ad/d/a/a:zau	J
    //   82: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   85: ldc 128
    //   87: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_0
    //   91: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:yZm	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   94: getfield 99	com/tencent/mm/plugin/sns/ad/d/a/a:zao	I
    //   97: i2l
    //   98: aload_0
    //   99: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:yZm	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   102: getfield 123	com/tencent/mm/plugin/sns/ad/d/a/a:zau	J
    //   105: lsub
    //   106: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   109: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 137	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload_0
    //   116: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:yZm	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   119: getfield 99	com/tencent/mm/plugin/sns/ad/d/a/a:zao	I
    //   122: i2l
    //   123: aload_0
    //   124: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:yZm	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   127: getfield 123	com/tencent/mm/plugin/sns/ad/d/a/a:zau	J
    //   130: lsub
    //   131: lconst_0
    //   132: lcmp
    //   133: ifle +29 -> 162
    //   136: aload_0
    //   137: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:yZm	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   140: astore 5
    //   142: aload 5
    //   144: aload 5
    //   146: getfield 99	com/tencent/mm/plugin/sns/ad/d/a/a:zao	I
    //   149: i2l
    //   150: aload_0
    //   151: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:yZm	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   154: getfield 123	com/tencent/mm/plugin/sns/ad/d/a/a:zau	J
    //   157: lsub
    //   158: l2i
    //   159: putfield 99	com/tencent/mm/plugin/sns/ad/d/a/a:zao	I
    //   162: iload_1
    //   163: ifeq +17 -> 180
    //   166: aload_0
    //   167: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:yZm	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   170: iload_1
    //   171: putfield 140	com/tencent/mm/plugin/sns/ad/d/a/a:zap	I
    //   174: aload_0
    //   175: iload_1
    //   176: i2l
    //   177: putfield 72	com/tencent/mm/plugin/sns/ad/d/j:vtP	J
    //   180: aload_0
    //   181: getfield 42	com/tencent/mm/plugin/sns/ad/d/j:TAG	Ljava/lang/String;
    //   184: new 107	java/lang/StringBuilder
    //   187: dup
    //   188: ldc 142
    //   190: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   193: aload_0
    //   194: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:yZm	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   197: getfield 99	com/tencent/mm/plugin/sns/ad/d/a/a:zao	I
    //   200: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   203: ldc 144
    //   205: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_0
    //   209: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:yZm	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   212: getfield 147	com/tencent/mm/plugin/sns/ad/d/a/a:zar	I
    //   215: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   218: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 137	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: aload_0
    //   225: getfield 70	com/tencent/mm/plugin/sns/ad/d/j:yZn	Ljava/util/LinkedList;
    //   228: aload_0
    //   229: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:yZm	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   232: invokevirtual 151	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   235: pop
    //   236: aload_0
    //   237: new 62	com/tencent/mm/plugin/sns/ad/d/a/a
    //   240: dup
    //   241: invokespecial 63	com/tencent/mm/plugin/sns/ad/d/a/a:<init>	()V
    //   244: putfield 65	com/tencent/mm/plugin/sns/ad/d/j:yZm	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   247: ldc 96
    //   249: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: aload_0
    //   253: monitorexit
    //   254: return
    //   255: aload_0
    //   256: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:yZm	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   259: getfield 102	com/tencent/mm/plugin/sns/ad/d/a/a:zas	J
    //   262: invokestatic 157	com/tencent/mm/sdk/platformtools/bt:aO	(J)J
    //   265: lstore_3
    //   266: lload_3
    //   267: l2i
    //   268: istore_2
    //   269: goto -232 -> 37
    //   272: astore 5
    //   274: aload_0
    //   275: monitorexit
    //   276: aload 5
    //   278: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	j
    //   0	279	1	paramInt	int
    //   36	233	2	i	int
    //   265	2	3	l	long
    //   21	124	5	locala	a
    //   272	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	35	272	finally
    //   37	162	272	finally
    //   166	180	272	finally
    //   180	252	272	finally
    //   255	266	272	finally
  }
  
  public final void dQt()
  {
    try
    {
      AppMethodBeat.i(197612);
      if ((this.yZm.zas > 0L) && (this.yZo == 0L))
      {
        this.yZo = bt.HI();
        ad.i(this.TAG, "onPausePlay, pauseBeginTime=" + this.yZo);
      }
      AppMethodBeat.o(197612);
      return;
    }
    finally {}
  }
  
  public final void dRA()
  {
    AppMethodBeat.i(95024);
    this.yZi = 0;
    this.yZj = 0;
    this.yZk = 0;
    Iterator localIterator = this.yZn.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      this.yZi += locala.zam;
      this.yZj += locala.zan;
      int i = this.yZk;
      this.yZk = (locala.zao + i);
    }
    if ((this.yZm != null) && (!this.yZn.contains(this.yZm)))
    {
      this.yZi += this.yZm.zam;
      this.yZj += this.yZm.zan;
      this.yZk += this.yZm.zao;
    }
    AppMethodBeat.o(95024);
  }
  
  /* Error */
  final void dRB()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 191
    //   4: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 76	com/tencent/mm/plugin/sns/ad/d/j:yZo	J
    //   11: lconst_0
    //   12: lcmp
    //   13: ifne +11 -> 24
    //   16: ldc 191
    //   18: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 76	com/tencent/mm/plugin/sns/ad/d/j:yZo	J
    //   28: invokestatic 157	com/tencent/mm/sdk/platformtools/bt:aO	(J)J
    //   31: lstore_1
    //   32: aload_0
    //   33: lconst_0
    //   34: putfield 76	com/tencent/mm/plugin/sns/ad/d/j:yZo	J
    //   37: aload_0
    //   38: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:yZm	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   41: ifnull +56 -> 97
    //   44: aload_0
    //   45: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:yZm	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   48: astore_3
    //   49: aload_3
    //   50: aload_3
    //   51: getfield 123	com/tencent/mm/plugin/sns/ad/d/a/a:zau	J
    //   54: lload_1
    //   55: ladd
    //   56: putfield 123	com/tencent/mm/plugin/sns/ad/d/a/a:zau	J
    //   59: aload_0
    //   60: getfield 42	com/tencent/mm/plugin/sns/ad/d/j:TAG	Ljava/lang/String;
    //   63: new 107	java/lang/StringBuilder
    //   66: dup
    //   67: ldc 193
    //   69: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   72: lload_1
    //   73: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   76: ldc 195
    //   78: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_0
    //   82: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:yZm	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   85: getfield 123	com/tencent/mm/plugin/sns/ad/d/a/a:zau	J
    //   88: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   91: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 137	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: ldc 191
    //   99: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: goto -81 -> 21
    //   105: astore_3
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_3
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	j
    //   31	42	1	l	long
    //   48	3	3	locala	a
    //   105	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	105	finally
    //   24	97	105	finally
    //   97	102	105	finally
  }
  
  public final String dRz()
  {
    int j = 0;
    label556:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(95023);
        StringBuffer localStringBuffer;
        a locala;
        if (this.yZg == 0L)
        {
          i = 0;
          this.yZf = i;
          localStringBuffer = new StringBuffer();
          localStringBuffer.append("<viewinfo>");
          localStringBuffer.append("<downloadstatus>");
          localStringBuffer.append(this.yZe);
          localStringBuffer.append("</downloadstatus>");
          localStringBuffer.append("<staytotaltime>");
          localStringBuffer.append(this.yZf);
          localStringBuffer.append("</staytotaltime>");
          if (this.yZh > 0)
          {
            localStringBuffer.append("<masktotaltime>");
            localStringBuffer.append(this.yZh);
            localStringBuffer.append("</masktotaltime>");
          }
          localObject1 = this.yZn;
          if ((!this.yZl) || (this.yZn.size() <= 1)) {
            break label556;
          }
          locala = new a();
          i = 0;
          if (i < this.yZn.size())
          {
            localObject1 = (a)this.yZn.get(i);
            if (i == 0)
            {
              locala.zap = ((a)localObject1).zap;
              locala.zaq = ((a)localObject1).zaq;
              locala.zar = ((a)localObject1).zar;
            }
            locala.zan += ((a)localObject1).zan;
            int k = locala.zao;
            locala.zao = (((a)localObject1).zao + k);
            i += 1;
            continue;
          }
        }
        else
        {
          i = (int)bt.aO(this.yZg);
          continue;
        }
        Object localObject1 = new LinkedList();
        ((LinkedList)localObject1).add(locala);
        localStringBuffer.append(String.format("<playitemlist count=\"%d\">", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()) }));
        int i = j;
        if (i < ((LinkedList)localObject1).size())
        {
          locala = (a)((LinkedList)localObject1).get(i);
          localStringBuffer.append("<playitem>");
          localStringBuffer.append(String.format("<playcount>%d</playcount>", new Object[] { Integer.valueOf(locala.zan) }));
          localStringBuffer.append(String.format("<playtotaltime>%d</playtotaltime>", new Object[] { Integer.valueOf(locala.zao) }));
          localStringBuffer.append(String.format("<videototaltime>%d</videototaltime>", new Object[] { Integer.valueOf(locala.zap * 1000) }));
          localStringBuffer.append(String.format("<playmode>%d</playmode>", new Object[] { Integer.valueOf(locala.zaq) }));
          localStringBuffer.append(String.format("<playorientation>%d</playorientation>", new Object[] { Integer.valueOf(locala.zar) }));
          localStringBuffer.append("</playitem>");
          i += 1;
        }
        else
        {
          localStringBuffer.append("</playitemlist>");
          localStringBuffer.append("</viewinfo>");
          localObject1 = localStringBuffer.toString();
          ad.i(this.TAG, "xml ".concat(String.valueOf(localObject1)));
          AppMethodBeat.o(95023);
          return localObject1;
        }
      }
      finally {}
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(95025);
    if (this.imX == 0L)
    {
      AppMethodBeat.o(95025);
      return;
    }
    long l = bt.aO(this.imX);
    this.imY += l;
    this.imX = 0L;
    if (this.yZm != null)
    {
      a locala = this.yZm;
      locala.zat = (l + locala.zat);
    }
    AppMethodBeat.o(95025);
  }
  
  public final void setDuration(int paramInt)
  {
    this.vtP = paramInt;
    this.yZm.zap = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.j
 * JD-Core Version:    0.7.0.1
 */