package com.tencent.mm.plugin.sns.ad.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.d.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
{
  public String TAG;
  public long hTD;
  public long hTE;
  public long urm;
  public int xJP;
  public int xJQ;
  public long xJR;
  public int xJS;
  public int xJT;
  public int xJU;
  public int xJV;
  public boolean xJW;
  public a xJX;
  public LinkedList<a> xJY;
  private long xJZ;
  public long xKa;
  
  public j()
  {
    AppMethodBeat.i(95020);
    this.TAG = "MicroMsg.SnsAdVideoStatistic";
    this.xJP = 0;
    this.xJQ = 0;
    this.xJR = 0L;
    this.xJS = 0;
    this.hTE = 0L;
    this.xJT = 0;
    this.xJU = 0;
    this.xJV = 0;
    this.xJW = false;
    this.xJX = new a();
    this.xJY = new LinkedList();
    this.urm = 0L;
    this.hTD = 0L;
    this.xJZ = 0L;
    AppMethodBeat.o(95020);
  }
  
  public j(String paramString)
  {
    AppMethodBeat.i(95021);
    this.TAG = "MicroMsg.SnsAdVideoStatistic";
    this.xJP = 0;
    this.xJQ = 0;
    this.xJR = 0L;
    this.xJS = 0;
    this.hTE = 0L;
    this.xJT = 0;
    this.xJU = 0;
    this.xJV = 0;
    this.xJW = false;
    this.xJX = new a();
    this.xJY = new LinkedList();
    this.urm = 0L;
    this.hTD = 0L;
    this.xJZ = 0L;
    this.TAG = "MicroMsg.SnsAdVideoStatistic:".concat(String.valueOf(paramString));
    AppMethodBeat.o(95021);
  }
  
  /* Error */
  public final void NV(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 96
    //   4: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:xJX	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   11: getfield 99	com/tencent/mm/plugin/sns/ad/d/a/a:xKZ	I
    //   14: ifgt +148 -> 162
    //   17: aload_0
    //   18: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:xJX	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   21: astore 5
    //   23: aload_0
    //   24: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:xJX	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   27: getfield 102	com/tencent/mm/plugin/sns/ad/d/a/a:xLd	J
    //   30: lconst_0
    //   31: lcmp
    //   32: ifne +223 -> 255
    //   35: iconst_0
    //   36: istore_2
    //   37: aload 5
    //   39: iload_2
    //   40: putfield 99	com/tencent/mm/plugin/sns/ad/d/a/a:xKZ	I
    //   43: aload_0
    //   44: invokevirtual 105	com/tencent/mm/plugin/sns/ad/d/j:dFJ	()V
    //   47: aload_0
    //   48: getfield 42	com/tencent/mm/plugin/sns/ad/d/j:TAG	Ljava/lang/String;
    //   51: new 107	java/lang/StringBuilder
    //   54: dup
    //   55: ldc 109
    //   57: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   60: aload_0
    //   61: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:xJX	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   64: getfield 99	com/tencent/mm/plugin/sns/ad/d/a/a:xKZ	I
    //   67: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: ldc 117
    //   72: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_0
    //   76: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:xJX	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   79: getfield 123	com/tencent/mm/plugin/sns/ad/d/a/a:xLf	J
    //   82: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   85: ldc 128
    //   87: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_0
    //   91: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:xJX	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   94: getfield 99	com/tencent/mm/plugin/sns/ad/d/a/a:xKZ	I
    //   97: i2l
    //   98: aload_0
    //   99: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:xJX	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   102: getfield 123	com/tencent/mm/plugin/sns/ad/d/a/a:xLf	J
    //   105: lsub
    //   106: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   109: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 137	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload_0
    //   116: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:xJX	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   119: getfield 99	com/tencent/mm/plugin/sns/ad/d/a/a:xKZ	I
    //   122: i2l
    //   123: aload_0
    //   124: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:xJX	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   127: getfield 123	com/tencent/mm/plugin/sns/ad/d/a/a:xLf	J
    //   130: lsub
    //   131: lconst_0
    //   132: lcmp
    //   133: ifle +29 -> 162
    //   136: aload_0
    //   137: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:xJX	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   140: astore 5
    //   142: aload 5
    //   144: aload 5
    //   146: getfield 99	com/tencent/mm/plugin/sns/ad/d/a/a:xKZ	I
    //   149: i2l
    //   150: aload_0
    //   151: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:xJX	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   154: getfield 123	com/tencent/mm/plugin/sns/ad/d/a/a:xLf	J
    //   157: lsub
    //   158: l2i
    //   159: putfield 99	com/tencent/mm/plugin/sns/ad/d/a/a:xKZ	I
    //   162: iload_1
    //   163: ifeq +17 -> 180
    //   166: aload_0
    //   167: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:xJX	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   170: iload_1
    //   171: putfield 140	com/tencent/mm/plugin/sns/ad/d/a/a:xLa	I
    //   174: aload_0
    //   175: iload_1
    //   176: i2l
    //   177: putfield 72	com/tencent/mm/plugin/sns/ad/d/j:urm	J
    //   180: aload_0
    //   181: getfield 42	com/tencent/mm/plugin/sns/ad/d/j:TAG	Ljava/lang/String;
    //   184: new 107	java/lang/StringBuilder
    //   187: dup
    //   188: ldc 142
    //   190: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   193: aload_0
    //   194: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:xJX	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   197: getfield 99	com/tencent/mm/plugin/sns/ad/d/a/a:xKZ	I
    //   200: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   203: ldc 144
    //   205: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_0
    //   209: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:xJX	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   212: getfield 147	com/tencent/mm/plugin/sns/ad/d/a/a:xLc	I
    //   215: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   218: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 137	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: aload_0
    //   225: getfield 70	com/tencent/mm/plugin/sns/ad/d/j:xJY	Ljava/util/LinkedList;
    //   228: aload_0
    //   229: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:xJX	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   232: invokevirtual 151	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   235: pop
    //   236: aload_0
    //   237: new 62	com/tencent/mm/plugin/sns/ad/d/a/a
    //   240: dup
    //   241: invokespecial 63	com/tencent/mm/plugin/sns/ad/d/a/a:<init>	()V
    //   244: putfield 65	com/tencent/mm/plugin/sns/ad/d/j:xJX	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   247: ldc 96
    //   249: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: aload_0
    //   253: monitorexit
    //   254: return
    //   255: aload_0
    //   256: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:xJX	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   259: getfield 102	com/tencent/mm/plugin/sns/ad/d/a/a:xLd	J
    //   262: invokestatic 157	com/tencent/mm/sdk/platformtools/bs:aO	(J)J
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
  
  public final void dER()
  {
    try
    {
      AppMethodBeat.i(199968);
      if ((this.xJX.xLd > 0L) && (this.xJZ == 0L))
      {
        this.xJZ = bs.Gn();
        ac.i(this.TAG, "onPausePlay, pauseBeginTime=" + this.xJZ);
      }
      AppMethodBeat.o(199968);
      return;
    }
    finally {}
  }
  
  public final String dFH()
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
        if (this.xJR == 0L)
        {
          i = 0;
          this.xJQ = i;
          localStringBuffer = new StringBuffer();
          localStringBuffer.append("<viewinfo>");
          localStringBuffer.append("<downloadstatus>");
          localStringBuffer.append(this.xJP);
          localStringBuffer.append("</downloadstatus>");
          localStringBuffer.append("<staytotaltime>");
          localStringBuffer.append(this.xJQ);
          localStringBuffer.append("</staytotaltime>");
          if (this.xJS > 0)
          {
            localStringBuffer.append("<masktotaltime>");
            localStringBuffer.append(this.xJS);
            localStringBuffer.append("</masktotaltime>");
          }
          localObject1 = this.xJY;
          if ((!this.xJW) || (this.xJY.size() <= 1)) {
            break label552;
          }
          locala = new a();
          i = 0;
          if (i < this.xJY.size())
          {
            localObject1 = (a)this.xJY.get(i);
            if (i == 0)
            {
              locala.xLa = ((a)localObject1).xLa;
              locala.xLb = ((a)localObject1).xLb;
              locala.xLc = ((a)localObject1).xLc;
            }
            locala.xKY += ((a)localObject1).xKY;
            int k = locala.xKZ;
            locala.xKZ = (((a)localObject1).xKZ + k);
            i += 1;
            continue;
          }
        }
        else
        {
          i = (int)bs.aO(this.xJR);
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
          localStringBuffer.append(String.format("<playcount>%d</playcount>", new Object[] { Integer.valueOf(locala.xKY) }));
          localStringBuffer.append(String.format("<playtotaltime>%d</playtotaltime>", new Object[] { Integer.valueOf(locala.xKZ) }));
          localStringBuffer.append(String.format("<videototaltime>%d</videototaltime>", new Object[] { Integer.valueOf(locala.xLa * 1000) }));
          localStringBuffer.append(String.format("<playmode>%d</playmode>", new Object[] { Integer.valueOf(locala.xLb) }));
          localStringBuffer.append(String.format("<playorientation>%d</playorientation>", new Object[] { Integer.valueOf(locala.xLc) }));
          localStringBuffer.append("</playitem>");
          i += 1;
        }
        else
        {
          localStringBuffer.append("</playitemlist>");
          localStringBuffer.append("</viewinfo>");
          localObject1 = localStringBuffer.toString();
          ac.i(this.TAG, "xml ".concat(String.valueOf(localObject1)));
          AppMethodBeat.o(95023);
          return localObject1;
        }
      }
      finally {}
    }
  }
  
  public final void dFI()
  {
    AppMethodBeat.i(95024);
    this.xJT = 0;
    this.xJU = 0;
    this.xJV = 0;
    Iterator localIterator = this.xJY.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      this.xJT += locala.xKX;
      this.xJU += locala.xKY;
      int i = this.xJV;
      this.xJV = (locala.xKZ + i);
    }
    if ((this.xJX != null) && (!this.xJY.contains(this.xJX)))
    {
      this.xJT += this.xJX.xKX;
      this.xJU += this.xJX.xKY;
      this.xJV += this.xJX.xKZ;
    }
    AppMethodBeat.o(95024);
  }
  
  /* Error */
  final void dFJ()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 259
    //   5: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 76	com/tencent/mm/plugin/sns/ad/d/j:xJZ	J
    //   12: lconst_0
    //   13: lcmp
    //   14: ifne +12 -> 26
    //   17: ldc_w 259
    //   20: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: getfield 76	com/tencent/mm/plugin/sns/ad/d/j:xJZ	J
    //   30: invokestatic 157	com/tencent/mm/sdk/platformtools/bs:aO	(J)J
    //   33: lstore_1
    //   34: aload_0
    //   35: lconst_0
    //   36: putfield 76	com/tencent/mm/plugin/sns/ad/d/j:xJZ	J
    //   39: aload_0
    //   40: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:xJX	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   43: ifnull +58 -> 101
    //   46: aload_0
    //   47: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:xJX	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   50: astore_3
    //   51: aload_3
    //   52: aload_3
    //   53: getfield 123	com/tencent/mm/plugin/sns/ad/d/a/a:xLf	J
    //   56: lload_1
    //   57: ladd
    //   58: putfield 123	com/tencent/mm/plugin/sns/ad/d/a/a:xLf	J
    //   61: aload_0
    //   62: getfield 42	com/tencent/mm/plugin/sns/ad/d/j:TAG	Ljava/lang/String;
    //   65: new 107	java/lang/StringBuilder
    //   68: dup
    //   69: ldc_w 261
    //   72: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: lload_1
    //   76: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   79: ldc_w 263
    //   82: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_0
    //   86: getfield 65	com/tencent/mm/plugin/sns/ad/d/j:xJX	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   89: getfield 123	com/tencent/mm/plugin/sns/ad/d/a/a:xLf	J
    //   92: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   95: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 137	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   0	115	0	this	j
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
    if (this.hTD == 0L)
    {
      AppMethodBeat.o(95025);
      return;
    }
    long l = bs.aO(this.hTD);
    this.hTE += l;
    this.hTD = 0L;
    if (this.xJX != null)
    {
      a locala = this.xJX;
      locala.xLe = (l + locala.xLe);
    }
    AppMethodBeat.o(95025);
  }
  
  public final void setDuration(int paramInt)
  {
    this.urm = paramInt;
    this.xJX.xLa = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.j
 * JD-Core Version:    0.7.0.1
 */