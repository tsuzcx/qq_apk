package com.tencent.mm.plugin.sns.ad.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.g.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class l
{
  public int DvO;
  public int DvP;
  public long DvQ;
  public int DvR;
  public int DvS;
  public int DvT;
  public int DvU;
  public boolean DvV;
  public a DvW;
  public LinkedList<a> DvX;
  private long DvY;
  public long DvZ;
  public String TAG;
  public long jkY;
  public long jkZ;
  public long pLQ;
  
  public l()
  {
    AppMethodBeat.i(95020);
    this.TAG = "MicroMsg.SnsAdVideoStatistic";
    this.DvO = 0;
    this.DvP = 0;
    this.DvQ = 0L;
    this.DvR = 0;
    this.jkZ = 0L;
    this.DvS = 0;
    this.DvT = 0;
    this.DvU = 0;
    this.DvV = false;
    this.DvW = new a();
    this.DvX = new LinkedList();
    this.pLQ = 0L;
    this.jkY = 0L;
    this.DvY = 0L;
    AppMethodBeat.o(95020);
  }
  
  public l(String paramString)
  {
    AppMethodBeat.i(95021);
    this.TAG = "MicroMsg.SnsAdVideoStatistic";
    this.DvO = 0;
    this.DvP = 0;
    this.DvQ = 0L;
    this.DvR = 0;
    this.jkZ = 0L;
    this.DvS = 0;
    this.DvT = 0;
    this.DvU = 0;
    this.DvV = false;
    this.DvW = new a();
    this.DvX = new LinkedList();
    this.pLQ = 0L;
    this.jkY = 0L;
    this.DvY = 0L;
    this.TAG = "MicroMsg.SnsAdVideoStatistic:".concat(String.valueOf(paramString));
    AppMethodBeat.o(95021);
  }
  
  /* Error */
  public final void XK(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 96
    //   4: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 65	com/tencent/mm/plugin/sns/ad/g/l:DvW	Lcom/tencent/mm/plugin/sns/ad/g/a/a;
    //   11: getfield 99	com/tencent/mm/plugin/sns/ad/g/a/a:DwY	I
    //   14: ifgt +148 -> 162
    //   17: aload_0
    //   18: getfield 65	com/tencent/mm/plugin/sns/ad/g/l:DvW	Lcom/tencent/mm/plugin/sns/ad/g/a/a;
    //   21: astore 5
    //   23: aload_0
    //   24: getfield 65	com/tencent/mm/plugin/sns/ad/g/l:DvW	Lcom/tencent/mm/plugin/sns/ad/g/a/a;
    //   27: getfield 102	com/tencent/mm/plugin/sns/ad/g/a/a:Dxc	J
    //   30: lconst_0
    //   31: lcmp
    //   32: ifne +223 -> 255
    //   35: iconst_0
    //   36: istore_2
    //   37: aload 5
    //   39: iload_2
    //   40: putfield 99	com/tencent/mm/plugin/sns/ad/g/a/a:DwY	I
    //   43: aload_0
    //   44: invokevirtual 105	com/tencent/mm/plugin/sns/ad/g/l:eXt	()V
    //   47: aload_0
    //   48: getfield 42	com/tencent/mm/plugin/sns/ad/g/l:TAG	Ljava/lang/String;
    //   51: new 107	java/lang/StringBuilder
    //   54: dup
    //   55: ldc 109
    //   57: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   60: aload_0
    //   61: getfield 65	com/tencent/mm/plugin/sns/ad/g/l:DvW	Lcom/tencent/mm/plugin/sns/ad/g/a/a;
    //   64: getfield 99	com/tencent/mm/plugin/sns/ad/g/a/a:DwY	I
    //   67: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: ldc 117
    //   72: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_0
    //   76: getfield 65	com/tencent/mm/plugin/sns/ad/g/l:DvW	Lcom/tencent/mm/plugin/sns/ad/g/a/a;
    //   79: getfield 123	com/tencent/mm/plugin/sns/ad/g/a/a:Dxe	J
    //   82: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   85: ldc 128
    //   87: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_0
    //   91: getfield 65	com/tencent/mm/plugin/sns/ad/g/l:DvW	Lcom/tencent/mm/plugin/sns/ad/g/a/a;
    //   94: getfield 99	com/tencent/mm/plugin/sns/ad/g/a/a:DwY	I
    //   97: i2l
    //   98: aload_0
    //   99: getfield 65	com/tencent/mm/plugin/sns/ad/g/l:DvW	Lcom/tencent/mm/plugin/sns/ad/g/a/a;
    //   102: getfield 123	com/tencent/mm/plugin/sns/ad/g/a/a:Dxe	J
    //   105: lsub
    //   106: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   109: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload_0
    //   116: getfield 65	com/tencent/mm/plugin/sns/ad/g/l:DvW	Lcom/tencent/mm/plugin/sns/ad/g/a/a;
    //   119: getfield 99	com/tencent/mm/plugin/sns/ad/g/a/a:DwY	I
    //   122: i2l
    //   123: aload_0
    //   124: getfield 65	com/tencent/mm/plugin/sns/ad/g/l:DvW	Lcom/tencent/mm/plugin/sns/ad/g/a/a;
    //   127: getfield 123	com/tencent/mm/plugin/sns/ad/g/a/a:Dxe	J
    //   130: lsub
    //   131: lconst_0
    //   132: lcmp
    //   133: ifle +29 -> 162
    //   136: aload_0
    //   137: getfield 65	com/tencent/mm/plugin/sns/ad/g/l:DvW	Lcom/tencent/mm/plugin/sns/ad/g/a/a;
    //   140: astore 5
    //   142: aload 5
    //   144: aload 5
    //   146: getfield 99	com/tencent/mm/plugin/sns/ad/g/a/a:DwY	I
    //   149: i2l
    //   150: aload_0
    //   151: getfield 65	com/tencent/mm/plugin/sns/ad/g/l:DvW	Lcom/tencent/mm/plugin/sns/ad/g/a/a;
    //   154: getfield 123	com/tencent/mm/plugin/sns/ad/g/a/a:Dxe	J
    //   157: lsub
    //   158: l2i
    //   159: putfield 99	com/tencent/mm/plugin/sns/ad/g/a/a:DwY	I
    //   162: iload_1
    //   163: ifeq +17 -> 180
    //   166: aload_0
    //   167: getfield 65	com/tencent/mm/plugin/sns/ad/g/l:DvW	Lcom/tencent/mm/plugin/sns/ad/g/a/a;
    //   170: iload_1
    //   171: putfield 140	com/tencent/mm/plugin/sns/ad/g/a/a:DwZ	I
    //   174: aload_0
    //   175: iload_1
    //   176: i2l
    //   177: putfield 72	com/tencent/mm/plugin/sns/ad/g/l:pLQ	J
    //   180: aload_0
    //   181: getfield 42	com/tencent/mm/plugin/sns/ad/g/l:TAG	Ljava/lang/String;
    //   184: new 107	java/lang/StringBuilder
    //   187: dup
    //   188: ldc 142
    //   190: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   193: aload_0
    //   194: getfield 65	com/tencent/mm/plugin/sns/ad/g/l:DvW	Lcom/tencent/mm/plugin/sns/ad/g/a/a;
    //   197: getfield 99	com/tencent/mm/plugin/sns/ad/g/a/a:DwY	I
    //   200: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   203: ldc 144
    //   205: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_0
    //   209: getfield 65	com/tencent/mm/plugin/sns/ad/g/l:DvW	Lcom/tencent/mm/plugin/sns/ad/g/a/a;
    //   212: getfield 147	com/tencent/mm/plugin/sns/ad/g/a/a:Dxb	I
    //   215: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   218: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: aload_0
    //   225: getfield 70	com/tencent/mm/plugin/sns/ad/g/l:DvX	Ljava/util/LinkedList;
    //   228: aload_0
    //   229: getfield 65	com/tencent/mm/plugin/sns/ad/g/l:DvW	Lcom/tencent/mm/plugin/sns/ad/g/a/a;
    //   232: invokevirtual 151	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   235: pop
    //   236: aload_0
    //   237: new 62	com/tencent/mm/plugin/sns/ad/g/a/a
    //   240: dup
    //   241: invokespecial 63	com/tencent/mm/plugin/sns/ad/g/a/a:<init>	()V
    //   244: putfield 65	com/tencent/mm/plugin/sns/ad/g/l:DvW	Lcom/tencent/mm/plugin/sns/ad/g/a/a;
    //   247: ldc 96
    //   249: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: aload_0
    //   253: monitorexit
    //   254: return
    //   255: aload_0
    //   256: getfield 65	com/tencent/mm/plugin/sns/ad/g/l:DvW	Lcom/tencent/mm/plugin/sns/ad/g/a/a;
    //   259: getfield 102	com/tencent/mm/plugin/sns/ad/g/a/a:Dxc	J
    //   262: invokestatic 157	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
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
    //   0	279	0	this	l
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
  
  public final void eVQ()
  {
    try
    {
      AppMethodBeat.i(202053);
      if ((this.DvW.Dxc > 0L) && (this.DvY == 0L))
      {
        this.DvY = Util.currentTicks();
        Log.i(this.TAG, "onPausePlay, pauseBeginTime=" + this.DvY);
      }
      AppMethodBeat.o(202053);
      return;
    }
    finally {}
  }
  
  public final String eXr()
  {
    int j = 0;
    label552:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(95023);
        StringBuffer localStringBuffer;
        a locala;
        if (this.DvQ == 0L)
        {
          i = 0;
          this.DvP = i;
          localStringBuffer = new StringBuffer();
          localStringBuffer.append("<viewinfo>");
          localStringBuffer.append("<downloadstatus>");
          localStringBuffer.append(this.DvO);
          localStringBuffer.append("</downloadstatus>");
          localStringBuffer.append("<staytotaltime>");
          localStringBuffer.append(this.DvP);
          localStringBuffer.append("</staytotaltime>");
          if (this.DvR > 0)
          {
            localStringBuffer.append("<masktotaltime>");
            localStringBuffer.append(this.DvR);
            localStringBuffer.append("</masktotaltime>");
          }
          localObject1 = this.DvX;
          if ((!this.DvV) || (this.DvX.size() <= 1)) {
            break label552;
          }
          locala = new a();
          i = 0;
          if (i < this.DvX.size())
          {
            localObject1 = (a)this.DvX.get(i);
            if (i == 0)
            {
              locala.DwZ = ((a)localObject1).DwZ;
              locala.Dxa = ((a)localObject1).Dxa;
              locala.Dxb = ((a)localObject1).Dxb;
            }
            locala.DwX += ((a)localObject1).DwX;
            int k = locala.DwY;
            locala.DwY = (((a)localObject1).DwY + k);
            i += 1;
            continue;
          }
        }
        else
        {
          i = (int)Util.ticksToNow(this.DvQ);
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
          localStringBuffer.append(String.format("<playcount>%d</playcount>", new Object[] { Integer.valueOf(locala.DwX) }));
          localStringBuffer.append(String.format("<playtotaltime>%d</playtotaltime>", new Object[] { Integer.valueOf(locala.DwY) }));
          localStringBuffer.append(String.format("<videototaltime>%d</videototaltime>", new Object[] { Integer.valueOf(locala.DwZ * 1000) }));
          localStringBuffer.append(String.format("<playmode>%d</playmode>", new Object[] { Integer.valueOf(locala.Dxa) }));
          localStringBuffer.append(String.format("<playorientation>%d</playorientation>", new Object[] { Integer.valueOf(locala.Dxb) }));
          localStringBuffer.append("</playitem>");
          i += 1;
        }
        else
        {
          localStringBuffer.append("</playitemlist>");
          localStringBuffer.append("</viewinfo>");
          localObject1 = localStringBuffer.toString();
          Log.i(this.TAG, "xml ".concat(String.valueOf(localObject1)));
          AppMethodBeat.o(95023);
          return localObject1;
        }
      }
      finally {}
    }
  }
  
  public final void eXs()
  {
    AppMethodBeat.i(95024);
    this.DvS = 0;
    this.DvT = 0;
    this.DvU = 0;
    Iterator localIterator = this.DvX.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      this.DvS += locala.DwW;
      this.DvT += locala.DwX;
      int i = this.DvU;
      this.DvU = (locala.DwY + i);
    }
    if ((this.DvW != null) && (!this.DvX.contains(this.DvW)))
    {
      this.DvS += this.DvW.DwW;
      this.DvT += this.DvW.DwX;
      this.DvU += this.DvW.DwY;
    }
    AppMethodBeat.o(95024);
  }
  
  /* Error */
  final void eXt()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 259
    //   5: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 76	com/tencent/mm/plugin/sns/ad/g/l:DvY	J
    //   12: lconst_0
    //   13: lcmp
    //   14: ifne +12 -> 26
    //   17: ldc_w 259
    //   20: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: getfield 76	com/tencent/mm/plugin/sns/ad/g/l:DvY	J
    //   30: invokestatic 157	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   33: lstore_1
    //   34: aload_0
    //   35: lconst_0
    //   36: putfield 76	com/tencent/mm/plugin/sns/ad/g/l:DvY	J
    //   39: aload_0
    //   40: getfield 65	com/tencent/mm/plugin/sns/ad/g/l:DvW	Lcom/tencent/mm/plugin/sns/ad/g/a/a;
    //   43: ifnull +58 -> 101
    //   46: aload_0
    //   47: getfield 65	com/tencent/mm/plugin/sns/ad/g/l:DvW	Lcom/tencent/mm/plugin/sns/ad/g/a/a;
    //   50: astore_3
    //   51: aload_3
    //   52: aload_3
    //   53: getfield 123	com/tencent/mm/plugin/sns/ad/g/a/a:Dxe	J
    //   56: lload_1
    //   57: ladd
    //   58: putfield 123	com/tencent/mm/plugin/sns/ad/g/a/a:Dxe	J
    //   61: aload_0
    //   62: getfield 42	com/tencent/mm/plugin/sns/ad/g/l:TAG	Ljava/lang/String;
    //   65: new 107	java/lang/StringBuilder
    //   68: dup
    //   69: ldc_w 261
    //   72: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: lload_1
    //   76: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   79: ldc_w 263
    //   82: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_0
    //   86: getfield 65	com/tencent/mm/plugin/sns/ad/g/l:DvW	Lcom/tencent/mm/plugin/sns/ad/g/a/a;
    //   89: getfield 123	com/tencent/mm/plugin/sns/ad/g/a/a:Dxe	J
    //   92: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   95: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: ldc_w 259
    //   104: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: goto -84 -> 23
    //   110: astore_3
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_3
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	l
    //   33	43	1	l	long
    //   50	3	3	locala	a
    //   110	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	23	110	finally
    //   26	101	110	finally
    //   101	107	110	finally
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(95025);
    if (this.jkY == 0L)
    {
      AppMethodBeat.o(95025);
      return;
    }
    long l = Util.ticksToNow(this.jkY);
    this.jkZ += l;
    this.jkY = 0L;
    if (this.DvW != null)
    {
      a locala = this.DvW;
      locala.Dxd = (l + locala.Dxd);
    }
    AppMethodBeat.o(95025);
  }
  
  public final void setDuration(int paramInt)
  {
    this.pLQ = paramInt;
    this.DvW.DwZ = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.g.l
 * JD-Core Version:    0.7.0.1
 */