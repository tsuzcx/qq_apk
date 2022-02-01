package com.tencent.mm.plugin.o;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Message;
import android.os.Process;
import android.util.Pair;
import com.tencent.mm.compatible.deviceinfo.MediaCodecProxyUtils.b;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.plugin.a.n;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.FileDescriptor;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class i
{
  private static boolean vLF;
  private static long vLG;
  private ByteBuffer[] bfT;
  private ByteBuffer[] btA;
  private int btC;
  private int btD;
  private MediaCodec.BufferInfo btm = new MediaCodec.BufferInfo();
  long bup;
  protected long buw;
  private c ddy;
  protected FileDescriptor fd;
  protected z hir;
  protected long length;
  private volatile Object lock = new Object();
  private String mime;
  protected String path;
  protected volatile int state;
  private int trackIndex;
  protected long vLA = 0L;
  MediaFormat vLB;
  private g vLC;
  private boolean vLD = false;
  private boolean vLE = false;
  protected h vLw;
  protected ap vLx;
  private volatile boolean vLy = false;
  b vLz = null;
  
  static
  {
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyq, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      vLF = bool;
      vLG = 0L;
      return;
    }
  }
  
  public i(h paramh, ap paramap)
  {
    this.vLw = paramh;
    this.vLx = paramap;
    this.state = 0;
    this.btC = -1;
    this.btD = -1;
  }
  
  private void dmv()
  {
    if (this.vLz != null) {
      this.vLA = (this.vLz.dmn() * 1000L);
    }
  }
  
  private boolean g(long paramLong1, long paramLong2)
  {
    ad.d("MicroMsg.TrackDataSource", "%s drain output buffer state:%s time[%d %d %s] index %d", new Object[] { info(), Integer.valueOf(this.state), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(this.ddy.gdS.getSampleTime()), Integer.valueOf(this.btD) });
    long l = bt.HI();
    if (this.btD < 0)
    {
      synchronized (this.lock)
      {
        this.btD = this.hir.dequeueOutputBuffer(this.btm, vLG);
        if (this.btD < 0) {
          break label259;
        }
        if ((this.btm.flags & 0x4) != 0)
        {
          ad.i("MicroMsg.TrackDataSource", "%s process end of stream", new Object[] { info() });
          setState(9);
          this.btD = -1;
          return false;
        }
      }
      ??? = this.bfT[this.btD];
      if (??? != null)
      {
        ((ByteBuffer)???).position(this.btm.offset);
        ((ByteBuffer)???).limit(this.btm.offset + this.btm.size);
      }
    }
    if (this.state == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.hir.releaseOutputBuffer(this.btD, true);
      this.btD = -1;
      setState(2);
      return true;
      label259:
      if (this.btD == -2)
      {
        ??? = this.hir.getOutputFormat();
        this.vLB = ((MediaFormat)???);
        a(this.hir, (MediaFormat)???);
        return true;
      }
      if (this.btD == -3)
      {
        this.bfT = this.hir.getOutputBuffers();
        return true;
      }
      ad.d("MicroMsg.TrackDataSource", "%s drain output buffer error outputIndex[%d] state:%s", new Object[] { info(), Integer.valueOf(this.btD), Integer.valueOf(this.state) });
      return false;
    }
    ad.d("MicroMsg.TrackDataSource", "%s process output buffer state:%s: index %d, cost:%s", new Object[] { info(), Integer.valueOf(this.state), Integer.valueOf(this.btD), Long.valueOf(bt.aO(l)) });
    synchronized (this.lock)
    {
      if (a(paramLong1, paramLong2, this.hir, this.bfT[this.btD], this.btD, this.btm))
      {
        this.btD = -1;
        return true;
      }
    }
    return false;
  }
  
  private boolean uX()
  {
    try
    {
      ad.d("MicroMsg.TrackDataSource", "%s start to feed input buffer index %d [%d, %b]", new Object[] { info(), Integer.valueOf(this.btC), Integer.valueOf(this.state), Boolean.valueOf(this.vLy) });
      ad.d("MicroMsg.TrackDataSource", "doubleReleaseSwitch:[%b]", new Object[] { Boolean.valueOf(vLF) });
      if ((e.JW(this.state)) || (this.vLy))
      {
        ad.d("MicroMsg.TrackDataSource", "%s feed input buffer is end.", new Object[] { info() });
        return false;
      }
      if ((this.btC < 0) && (this.hir != null))
      {
        this.btC = this.hir.dequeueInputBuffer(0L);
        if (this.btC < 0)
        {
          ad.d("MicroMsg.TrackDataSource", "%s can not dequeue effect input buffer, state:%s", new Object[] { info(), Integer.valueOf(this.state) });
          return false;
        }
      }
    }
    catch (Exception localException1)
    {
      ad.printErrStackTrace("MicroMsg.TrackDataSource", localException1, "feedInputBuffer exception", new Object[0]);
      return false;
    }
    ??? = this.btA[this.btC];
    int j;
    if (this.vLC != null)
    {
      i = this.vLC.H((ByteBuffer)???);
      l1 = this.vLC.vLi.hkd;
      j = this.vLC.vLi.iRc;
      ad.d("MicroMsg.TrackDataSource", "%s read data index[%d, %d] sample info[%d, %d]", new Object[] { info(), Integer.valueOf(this.btC), Integer.valueOf(i), Long.valueOf(l1), Integer.valueOf(j) });
      if (i <= 0)
      {
        if (vLF) {}
        for (;;)
        {
          synchronized (this.lock)
          {
            if (this.hir != null) {
              this.hir.a(this.btC, 0, 0L, 4);
            }
            this.vLy = true;
            return false;
          }
          this.hir.a(this.btC, 0, 0L, 4);
        }
      }
      if (vLF) {}
      for (;;)
      {
        synchronized (this.lock)
        {
          if (this.hir != null) {
            this.hir.a(this.btC, i, l1, 0);
          }
          this.btC = -1;
          ??? = this.vLC;
          ((g)???).vLj += 1;
          if (((g)???).vLj >= ((g)???).vLk) {
            break;
          }
          ((g)???).vLi = ((n)((g)???).iQK.get(((g)???).vLj));
          ad.d("MicroMsg.Mp4Extractor", "curr sample [%s]", new Object[] { ((g)???).vLi });
          return false;
        }
        this.hir.a(this.btC, i, l1, 0);
      }
    }
    if (this.vLw.vLs)
    {
      if (vLF) {}
      for (;;)
      {
        synchronized (this.lock)
        {
          if (this.hir != null) {
            this.hir.a(this.btC, 0, this.bup * 1000L, 4);
          }
          this.vLy = true;
          this.vLw.vLs = false;
          return false;
        }
        this.hir.a(this.btC, 0, this.bup * 1000L, 4);
      }
    }
    for (;;)
    {
      try
      {
        i = this.ddy.readSampleData((ByteBuffer)???, 0);
      }
      catch (Exception localException4)
      {
        l1 = 0L;
        i = 0;
        continue;
      }
      try
      {
        l1 = this.ddy.gdS.getSampleTime();
      }
      catch (Exception localException2)
      {
        l1 = 0L;
        continue;
      }
      try
      {
        j = this.ddy.gdS.getSampleFlags();
        ad.d("MicroMsg.TrackDataSource", "%s read data, state:%s index[%d, %d] sample info[%d, %d]", new Object[] { info(), Integer.valueOf(this.state), Integer.valueOf(this.btC), Integer.valueOf(i), Long.valueOf(l1), Integer.valueOf(j) });
        am(j, l1);
        if (i > 0) {
          continue;
        }
        if (!vLF) {
          continue;
        }
      }
      catch (Exception localException3)
      {
        continue;
      }
      synchronized (this.lock)
      {
        if (this.hir != null) {
          this.hir.a(this.btC, 0, this.bup * 1000L, 4);
        }
        this.vLy = true;
        return false;
        ad.printErrStackTrace("MicroMsg.TrackDataSource", (Throwable)???, "MediaExtractor get sample data error: %s", new Object[] { ((Exception)???).getMessage() });
        j = 0;
      }
      this.hir.a(this.btC, 0, this.bup * 1000L, 4);
    }
    if (vLF) {}
    for (;;)
    {
      long l2;
      long l3;
      synchronized (this.lock)
      {
        if (this.hir != null) {
          this.hir.a(this.btC, i, l1, 0);
        }
        this.btC = -1;
        this.ddy.gdS.advance();
        l2 = this.ddy.gdS.getSampleTime();
        if (this.vLw.pUQ) {
          break label1092;
        }
        if (X(l1, l2))
        {
          ad.w("MicroMsg.TrackDataSource", "%s feed input buffer isOnlineVideo[%b] next[%d] onlineCacheMs[%d]", new Object[] { info(), Boolean.valueOf(this.vLw.pUQ), Long.valueOf(l2), Long.valueOf(this.vLA) });
          l3 = this.ddy.gdS.getSampleTime();
          if (Math.abs(l3 - l1) >= 1000000L)
          {
            ad.w("MicroMsg.TrackDataSource", "%s reset extractor finish but seek time is not right[%d, %d]", new Object[] { info(), Long.valueOf(l3), Long.valueOf(l1) });
            this.vLw.vLs = true;
          }
        }
        ad.d("MicroMsg.TrackDataSource", "%s finish to feed input buffer [%d, %d]", new Object[] { info(), Long.valueOf(l1), Long.valueOf(l2) });
        return false;
      }
      this.hir.a(this.btC, i, l1, 0);
      continue;
      label1092:
      if (this.vLA == 0L)
      {
        if (X(l1, l2))
        {
          ad.w("MicroMsg.TrackDataSource", "%s feed input buffer next[%d] onlineCacheMs[%d]", new Object[] { info(), Long.valueOf(l2), Long.valueOf(this.vLA) });
          l3 = this.ddy.gdS.getSampleTime();
          if (Math.abs(l3 - l1) >= 3000000L)
          {
            ad.w("MicroMsg.TrackDataSource", "%s reset extractor finish but seek time is not right[%d, %d]", new Object[] { info(), Long.valueOf(l3), Long.valueOf(l1) });
            this.vLx.obtainMessage(5, -2, -2).sendToTarget();
          }
          dmv();
        }
      }
      else if ((l2 < 0L) || (l2 / 1000L + 1200L > this.vLA))
      {
        ad.w("MicroMsg.TrackDataSource", "%s feed input buffer next[%d] onlineCacheMs[%d]", new Object[] { info(), Long.valueOf(l2), Long.valueOf(this.vLA) });
        if (X(l1, -1L)) {
          this.vLx.obtainMessage(5, -3, -3).sendToTarget();
        }
        dmv();
      }
    }
    return false;
  }
  
  public final long Ka(int paramInt)
  {
    ad.i("MicroMsg.TrackDataSource", "%s start to seek to ms[%d] isFeedEnd[%b]", new Object[] { info(), Integer.valueOf(paramInt), Boolean.valueOf(this.vLy) });
    this.vLy = false;
    if (this.vLC != null) {}
    for (;;)
    {
      long l;
      int i;
      try
      {
        g localg = this.vLC;
        l = paramInt * 1000;
        i = 0;
        if (i < localg.iQL.size())
        {
          Pair localPair = (Pair)localg.iQL.get(i);
          if (l >= ((Long)localPair.second).longValue())
          {
            if (l != ((Long)localPair.second).longValue()) {
              break label681;
            }
            localg.vLj = ((Integer)localPair.first).intValue();
            localg.vLi = ((n)localg.iQK.get(localg.vLj));
            if (this.vLC.vLi.hkd < 0L) {
              X(paramInt * 1000L, -1L);
            }
            if (this.vLC.vLi.hkd < 0L)
            {
              X(0L, -1L);
              this.vLw.dms();
            }
            l = this.vLC.vLi.hkd;
            ad.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d]", new Object[] { info(), Long.valueOf(l) });
            return l / 1000L;
          }
        }
        if ((i == 0) || (i == localg.iQL.size() - 1))
        {
          localg.vLj = ((Integer)((Pair)localg.iQL.get(i)).first).intValue();
          localg.vLi = ((n)localg.iQK.get(localg.vLj));
          continue;
        }
        localException1.vLj = ((Integer)((Pair)localException1.iQL.get(i - 1)).first).intValue();
      }
      catch (Exception localException1)
      {
        ad.printErrStackTrace("MicroMsg.TrackDataSource", localException1, "%s extractor seek exception %s", new Object[] { info(), localException1.toString() });
        return 0L;
      }
      localException1.vLi = ((n)localException1.iQK.get(localException1.vLj));
      continue;
      try
      {
        this.ddy.seekTo(paramInt * 1000, 0);
        if (this.ddy.gdS.getSampleTime() < 0L) {
          X(paramInt * 1000L, -1L);
        }
        if (this.ddy.gdS.getSampleTime() < 0L)
        {
          X(0L, -1L);
          this.vLw.dms();
        }
        l = this.ddy.gdS.getSampleTime();
        i = this.ddy.gdS.getSampleFlags();
        ad.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d, %d], sampleFlag:%s", new Object[] { info(), Long.valueOf(l), Long.valueOf(this.ddy.gdS.getCachedDuration()), Integer.valueOf(i) });
        if ((i & 0x1) == 0) {
          ad.e("MicroMsg.TrackDataSource", "%s seek error, not in keyframe!!", new Object[] { info() });
        }
        if ((l == 0L) && (paramInt > 0)) {
          ad.e("MicroMsg.TrackDataSource", "%s seek error, not seek to %s", new Object[] { Integer.valueOf(paramInt * 1000), info() });
        }
        l /= 1000L;
        return l;
      }
      catch (Exception localException2)
      {
        ad.printErrStackTrace("MicroMsg.TrackDataSource", localException2, "%s extractor seek exception %s", new Object[] { info(), localException2.toString() });
        return 0L;
      }
      label681:
      i += 1;
    }
  }
  
  /* Error */
  protected final int W(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc 115
    //   2: ldc_w 426
    //   5: iconst_4
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: aload_0
    //   12: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   15: aastore
    //   16: dup
    //   17: iconst_1
    //   18: lload_1
    //   19: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   22: aastore
    //   23: dup
    //   24: iconst_2
    //   25: lload_3
    //   26: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   29: aastore
    //   30: dup
    //   31: iconst_3
    //   32: aload_0
    //   33: getfield 98	com/tencent/mm/plugin/o/i:state	I
    //   36: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   39: aastore
    //   40: invokestatic 151	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: aload_0
    //   44: getfield 158	com/tencent/mm/plugin/o/i:hir	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   47: ifnull +31 -> 78
    //   50: aload_0
    //   51: lload_1
    //   52: lload_3
    //   53: invokespecial 428	com/tencent/mm/plugin/o/i:g	(JJ)Z
    //   56: ifeq +17 -> 73
    //   59: aload_0
    //   60: getfield 98	com/tencent/mm/plugin/o/i:state	I
    //   63: invokestatic 240	com/tencent/mm/plugin/o/e:JW	(I)Z
    //   66: istore 5
    //   68: iload 5
    //   70: ifeq -20 -> 50
    //   73: aload_0
    //   74: invokespecial 430	com/tencent/mm/plugin/o/i:uX	()Z
    //   77: pop
    //   78: ldc 115
    //   80: ldc_w 432
    //   83: iconst_2
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: aload_0
    //   90: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   93: aastore
    //   94: dup
    //   95: iconst_1
    //   96: aload_0
    //   97: getfield 98	com/tencent/mm/plugin/o/i:state	I
    //   100: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   103: aastore
    //   104: invokestatic 151	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   107: aload_0
    //   108: getfield 98	com/tencent/mm/plugin/o/i:state	I
    //   111: ireturn
    //   112: astore 6
    //   114: aload_0
    //   115: getfield 90	com/tencent/mm/plugin/o/i:vLD	Z
    //   118: ifeq +166 -> 284
    //   121: ldc 115
    //   123: ldc_w 434
    //   126: iconst_2
    //   127: anewarray 4	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: aload_0
    //   133: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   136: aastore
    //   137: dup
    //   138: iconst_1
    //   139: aload 6
    //   141: invokevirtual 406	java/lang/Exception:toString	()Ljava/lang/String;
    //   144: aastore
    //   145: invokestatic 420	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   148: aload_0
    //   149: getfield 98	com/tencent/mm/plugin/o/i:state	I
    //   152: invokestatic 240	com/tencent/mm/plugin/o/e:JW	(I)Z
    //   155: ifne +7 -> 162
    //   158: aload_0
    //   159: invokevirtual 437	com/tencent/mm/plugin/o/i:dmw	()V
    //   162: aload_0
    //   163: getfield 94	com/tencent/mm/plugin/o/i:vLw	Lcom/tencent/mm/plugin/o/h;
    //   166: astore 6
    //   168: aload_0
    //   169: invokevirtual 440	com/tencent/mm/plugin/o/i:type	()Ljava/lang/String;
    //   172: astore 7
    //   174: aload 6
    //   176: getfield 443	com/tencent/mm/plugin/o/h:vLu	Z
    //   179: ifne -106 -> 73
    //   182: aload 6
    //   184: getfield 446	com/tencent/mm/plugin/o/h:vLr	Z
    //   187: ifeq -114 -> 73
    //   190: getstatic 451	com/tencent/mm/sdk/platformtools/i:DEBUG	Z
    //   193: ifne +15 -> 208
    //   196: getstatic 454	com/tencent/mm/sdk/platformtools/i:IS_FLAVOR_RED	Z
    //   199: ifne +9 -> 208
    //   202: getstatic 457	com/tencent/mm/sdk/platformtools/i:IS_FLAVOR_PURPLE	Z
    //   205: ifeq +15 -> 220
    //   208: new 459	com/tencent/mm/plugin/o/h$2
    //   211: dup
    //   212: aload 6
    //   214: invokespecial 462	com/tencent/mm/plugin/o/h$2:<init>	(Lcom/tencent/mm/plugin/o/h;)V
    //   217: invokestatic 468	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   220: getstatic 474	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
    //   223: aload 6
    //   225: invokevirtual 477	com/tencent/mm/plugin/o/h:dmu	()I
    //   228: i2l
    //   229: ldc2_w 478
    //   232: lconst_1
    //   233: iconst_0
    //   234: invokevirtual 483	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   237: getstatic 474	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
    //   240: aload 6
    //   242: invokevirtual 486	com/tencent/mm/plugin/o/h:dmt	()I
    //   245: iconst_3
    //   246: anewarray 4	java/lang/Object
    //   249: dup
    //   250: iconst_0
    //   251: sipush 506
    //   254: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   257: aastore
    //   258: dup
    //   259: iconst_1
    //   260: invokestatic 489	com/tencent/mm/sdk/platformtools/bt:aQJ	()J
    //   263: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   266: aastore
    //   267: dup
    //   268: iconst_2
    //   269: aload 7
    //   271: aastore
    //   272: invokevirtual 492	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
    //   275: aload 6
    //   277: iconst_1
    //   278: putfield 443	com/tencent/mm/plugin/o/h:vLu	Z
    //   281: goto -208 -> 73
    //   284: aload_0
    //   285: iconst_1
    //   286: putfield 90	com/tencent/mm/plugin/o/i:vLD	Z
    //   289: ldc 115
    //   291: aload 6
    //   293: ldc_w 494
    //   296: iconst_1
    //   297: anewarray 4	java/lang/Object
    //   300: dup
    //   301: iconst_0
    //   302: aload_0
    //   303: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   306: aastore
    //   307: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   310: goto -162 -> 148
    //   313: astore 6
    //   315: aload_0
    //   316: getfield 92	com/tencent/mm/plugin/o/i:vLE	Z
    //   319: ifeq +166 -> 485
    //   322: ldc 115
    //   324: ldc_w 496
    //   327: iconst_2
    //   328: anewarray 4	java/lang/Object
    //   331: dup
    //   332: iconst_0
    //   333: aload_0
    //   334: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   337: aastore
    //   338: dup
    //   339: iconst_1
    //   340: aload 6
    //   342: invokevirtual 406	java/lang/Exception:toString	()Ljava/lang/String;
    //   345: aastore
    //   346: invokestatic 420	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   349: aload_0
    //   350: getfield 98	com/tencent/mm/plugin/o/i:state	I
    //   353: invokestatic 240	com/tencent/mm/plugin/o/e:JW	(I)Z
    //   356: ifne +7 -> 363
    //   359: aload_0
    //   360: invokevirtual 437	com/tencent/mm/plugin/o/i:dmw	()V
    //   363: aload_0
    //   364: getfield 94	com/tencent/mm/plugin/o/i:vLw	Lcom/tencent/mm/plugin/o/h;
    //   367: astore 6
    //   369: aload_0
    //   370: invokevirtual 440	com/tencent/mm/plugin/o/i:type	()Ljava/lang/String;
    //   373: astore 7
    //   375: aload 6
    //   377: getfield 499	com/tencent/mm/plugin/o/h:vLt	Z
    //   380: ifne -302 -> 78
    //   383: aload 6
    //   385: getfield 446	com/tencent/mm/plugin/o/h:vLr	Z
    //   388: ifeq -310 -> 78
    //   391: getstatic 451	com/tencent/mm/sdk/platformtools/i:DEBUG	Z
    //   394: ifne +15 -> 409
    //   397: getstatic 454	com/tencent/mm/sdk/platformtools/i:IS_FLAVOR_RED	Z
    //   400: ifne +9 -> 409
    //   403: getstatic 457	com/tencent/mm/sdk/platformtools/i:IS_FLAVOR_PURPLE	Z
    //   406: ifeq +15 -> 421
    //   409: new 501	com/tencent/mm/plugin/o/h$1
    //   412: dup
    //   413: aload 6
    //   415: invokespecial 502	com/tencent/mm/plugin/o/h$1:<init>	(Lcom/tencent/mm/plugin/o/h;)V
    //   418: invokestatic 468	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   421: getstatic 474	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
    //   424: aload 6
    //   426: invokevirtual 477	com/tencent/mm/plugin/o/h:dmu	()I
    //   429: i2l
    //   430: ldc2_w 503
    //   433: lconst_1
    //   434: iconst_0
    //   435: invokevirtual 483	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   438: getstatic 474	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
    //   441: aload 6
    //   443: invokevirtual 486	com/tencent/mm/plugin/o/h:dmt	()I
    //   446: iconst_3
    //   447: anewarray 4	java/lang/Object
    //   450: dup
    //   451: iconst_0
    //   452: sipush 505
    //   455: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   458: aastore
    //   459: dup
    //   460: iconst_1
    //   461: invokestatic 489	com/tencent/mm/sdk/platformtools/bt:aQJ	()J
    //   464: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   467: aastore
    //   468: dup
    //   469: iconst_2
    //   470: aload 7
    //   472: aastore
    //   473: invokevirtual 492	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
    //   476: aload 6
    //   478: iconst_1
    //   479: putfield 499	com/tencent/mm/plugin/o/h:vLt	Z
    //   482: goto -404 -> 78
    //   485: aload_0
    //   486: iconst_1
    //   487: putfield 92	com/tencent/mm/plugin/o/i:vLE	Z
    //   490: ldc 115
    //   492: aload 6
    //   494: ldc_w 506
    //   497: iconst_1
    //   498: anewarray 4	java/lang/Object
    //   501: dup
    //   502: iconst_0
    //   503: aload_0
    //   504: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   507: aastore
    //   508: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   511: goto -162 -> 349
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	514	0	this	i
    //   0	514	1	paramLong1	long
    //   0	514	3	paramLong2	long
    //   66	3	5	bool	boolean
    //   112	28	6	localException1	Exception
    //   166	126	6	localh1	h
    //   313	28	6	localException2	Exception
    //   367	126	6	localh2	h
    //   172	299	7	str	String
    // Exception table:
    //   from	to	target	type
    //   50	68	112	java/lang/Exception
    //   73	78	313	java/lang/Exception
  }
  
  /* Error */
  protected final boolean X(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: invokestatic 156	com/tencent/mm/sdk/platformtools/bt:HI	()J
    //   3: lstore 5
    //   5: lload_1
    //   6: ldc2_w 110
    //   9: ldiv
    //   10: ldc2_w 110
    //   13: ladd
    //   14: aload_0
    //   15: getfield 308	com/tencent/mm/plugin/o/i:bup	J
    //   18: lcmp
    //   19: ifge +561 -> 580
    //   22: lload_3
    //   23: ldc2_w 372
    //   26: lcmp
    //   27: ifne +553 -> 580
    //   30: ldc 115
    //   32: ldc_w 510
    //   35: invokestatic 513	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: ldc_w 515
    //   41: invokestatic 521	com/tencent/mm/sdk/platformtools/ax:aQz	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/ax;
    //   44: astore 10
    //   46: aload_0
    //   47: instanceof 523
    //   50: ifeq +54 -> 104
    //   53: aload_0
    //   54: getfield 525	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   57: ifnonnull +388 -> 445
    //   60: ldc_w 527
    //   63: astore 9
    //   65: aload 10
    //   67: ldc_w 528
    //   70: aload 9
    //   72: invokevirtual 532	com/tencent/mm/sdk/platformtools/ax:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   75: pop
    //   76: aload 10
    //   78: ldc_w 533
    //   81: iconst_1
    //   82: invokevirtual 537	com/tencent/mm/sdk/platformtools/ax:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   85: pop
    //   86: aload 10
    //   88: ldc_w 539
    //   91: invokestatic 544	java/lang/System:currentTimeMillis	()J
    //   94: invokevirtual 548	com/tencent/mm/sdk/platformtools/ax:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   97: pop
    //   98: aload 10
    //   100: invokevirtual 551	com/tencent/mm/sdk/platformtools/ax:commit	()Z
    //   103: pop
    //   104: aload_0
    //   105: getfield 94	com/tencent/mm/plugin/o/i:vLw	Lcom/tencent/mm/plugin/o/h;
    //   108: iconst_1
    //   109: putfield 554	com/tencent/mm/plugin/o/h:pUP	Z
    //   112: aload_0
    //   113: iconst_0
    //   114: putfield 77	com/tencent/mm/plugin/o/i:vLy	Z
    //   117: aload_0
    //   118: getfield 134	com/tencent/mm/plugin/o/i:ddy	Lcom/tencent/mm/compatible/h/c;
    //   121: getfield 140	com/tencent/mm/compatible/h/c:gdS	Landroid/media/MediaExtractor;
    //   124: invokevirtual 557	android/media/MediaExtractor:release	()V
    //   127: aload_0
    //   128: new 136	com/tencent/mm/compatible/h/c
    //   131: dup
    //   132: invokespecial 558	com/tencent/mm/compatible/h/c:<init>	()V
    //   135: putfield 134	com/tencent/mm/plugin/o/i:ddy	Lcom/tencent/mm/compatible/h/c;
    //   138: aload_0
    //   139: getfield 525	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   142: invokestatic 562	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   145: ifne +437 -> 582
    //   148: aload_0
    //   149: getfield 525	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   152: iconst_0
    //   153: invokestatic 568	com/tencent/mm/vfs/i:dd	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   156: astore 9
    //   158: aload 9
    //   160: invokevirtual 574	java/io/RandomAccessFile:getFD	()Ljava/io/FileDescriptor;
    //   163: astore 11
    //   165: getstatic 580	com/tencent/mm/compatible/deviceinfo/ae:gcG	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   168: getfield 585	com/tencent/mm/compatible/deviceinfo/aa:gcz	I
    //   171: iconst_1
    //   172: if_icmpne +282 -> 454
    //   175: aload_0
    //   176: getfield 134	com/tencent/mm/plugin/o/i:ddy	Lcom/tencent/mm/compatible/h/c;
    //   179: aload 11
    //   181: lconst_0
    //   182: aload_0
    //   183: getfield 525	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   186: invokestatic 589	com/tencent/mm/vfs/i:aYo	(Ljava/lang/String;)J
    //   189: invokevirtual 593	com/tencent/mm/compatible/h/c:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   192: aload 9
    //   194: invokevirtual 596	java/io/RandomAccessFile:close	()V
    //   197: aload 10
    //   199: ldc_w 528
    //   202: ldc_w 527
    //   205: invokevirtual 600	com/tencent/mm/sdk/platformtools/ax:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   208: aload_0
    //   209: getfield 525	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   212: invokevirtual 606	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   215: ifeq +48 -> 263
    //   218: aload_0
    //   219: instanceof 523
    //   222: ifeq +41 -> 263
    //   225: aload 10
    //   227: ldc_w 533
    //   230: iconst_0
    //   231: invokevirtual 537	com/tencent/mm/sdk/platformtools/ax:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   234: pop
    //   235: aload 10
    //   237: ldc_w 528
    //   240: ldc_w 527
    //   243: invokevirtual 532	com/tencent/mm/sdk/platformtools/ax:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   246: pop
    //   247: aload 10
    //   249: ldc_w 539
    //   252: lconst_0
    //   253: invokevirtual 548	com/tencent/mm/sdk/platformtools/ax:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   256: pop
    //   257: aload 10
    //   259: invokevirtual 551	com/tencent/mm/sdk/platformtools/ax:commit	()Z
    //   262: pop
    //   263: aload_0
    //   264: getfield 134	com/tencent/mm/plugin/o/i:ddy	Lcom/tencent/mm/compatible/h/c;
    //   267: aload_0
    //   268: getfield 608	com/tencent/mm/plugin/o/i:trackIndex	I
    //   271: invokevirtual 611	com/tencent/mm/compatible/h/c:selectTrack	(I)V
    //   274: aload_0
    //   275: getfield 134	com/tencent/mm/plugin/o/i:ddy	Lcom/tencent/mm/compatible/h/c;
    //   278: lload_1
    //   279: iconst_2
    //   280: invokevirtual 410	com/tencent/mm/compatible/h/c:seekTo	(JI)V
    //   283: aload_0
    //   284: getfield 134	com/tencent/mm/plugin/o/i:ddy	Lcom/tencent/mm/compatible/h/c;
    //   287: getfield 140	com/tencent/mm/compatible/h/c:gdS	Landroid/media/MediaExtractor;
    //   290: invokevirtual 145	android/media/MediaExtractor:getSampleTime	()J
    //   293: lstore 7
    //   295: lload 7
    //   297: lload_1
    //   298: lsub
    //   299: invokestatic 346	java/lang/Math:abs	(J)J
    //   302: ldc2_w 355
    //   305: lcmp
    //   306: ifle +74 -> 380
    //   309: aload_0
    //   310: getfield 525	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   313: ifnull +67 -> 380
    //   316: aload_0
    //   317: getfield 525	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   320: ldc_w 613
    //   323: invokevirtual 617	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   326: ifeq +54 -> 380
    //   329: getstatic 474	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
    //   332: sipush 150
    //   335: bipush 75
    //   337: invokevirtual 621	com/tencent/mm/plugin/report/service/g:dD	(II)V
    //   340: getstatic 474	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
    //   343: sipush 17844
    //   346: iconst_2
    //   347: anewarray 4	java/lang/Object
    //   350: dup
    //   351: iconst_0
    //   352: iconst_1
    //   353: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   356: aastore
    //   357: dup
    //   358: iconst_1
    //   359: new 623	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 624	java/lang/StringBuilder:<init>	()V
    //   366: lload 7
    //   368: lload_1
    //   369: lsub
    //   370: invokevirtual 628	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   373: invokevirtual 629	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: aastore
    //   377: invokevirtual 492	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
    //   380: ldc 115
    //   382: ldc_w 631
    //   385: bipush 6
    //   387: anewarray 4	java/lang/Object
    //   390: dup
    //   391: iconst_0
    //   392: aload_0
    //   393: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   396: aastore
    //   397: dup
    //   398: iconst_1
    //   399: lload_1
    //   400: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   403: aastore
    //   404: dup
    //   405: iconst_2
    //   406: lload 7
    //   408: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   411: aastore
    //   412: dup
    //   413: iconst_3
    //   414: lload_3
    //   415: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   418: aastore
    //   419: dup
    //   420: iconst_4
    //   421: aload_0
    //   422: getfield 81	com/tencent/mm/plugin/o/i:vLA	J
    //   425: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   428: aastore
    //   429: dup
    //   430: iconst_5
    //   431: lload 5
    //   433: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:aO	(J)J
    //   436: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   439: aastore
    //   440: invokestatic 341	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   443: iconst_1
    //   444: ireturn
    //   445: aload_0
    //   446: getfield 525	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   449: astore 9
    //   451: goto -386 -> 65
    //   454: aload_0
    //   455: getfield 134	com/tencent/mm/plugin/o/i:ddy	Lcom/tencent/mm/compatible/h/c;
    //   458: aload 11
    //   460: invokevirtual 634	com/tencent/mm/compatible/h/c:setDataSource	(Ljava/io/FileDescriptor;)V
    //   463: goto -271 -> 192
    //   466: astore 9
    //   468: ldc 115
    //   470: aload 9
    //   472: ldc_w 510
    //   475: iconst_0
    //   476: anewarray 4	java/lang/Object
    //   479: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   482: aload 10
    //   484: ldc_w 528
    //   487: ldc_w 527
    //   490: invokevirtual 600	com/tencent/mm/sdk/platformtools/ax:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   493: aload_0
    //   494: getfield 525	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   497: invokevirtual 606	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   500: ifeq -237 -> 263
    //   503: aload_0
    //   504: instanceof 523
    //   507: ifeq -244 -> 263
    //   510: aload 10
    //   512: ldc_w 533
    //   515: iconst_0
    //   516: invokevirtual 537	com/tencent/mm/sdk/platformtools/ax:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   519: pop
    //   520: aload 10
    //   522: ldc_w 528
    //   525: ldc_w 527
    //   528: invokevirtual 532	com/tencent/mm/sdk/platformtools/ax:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   531: pop
    //   532: aload 10
    //   534: ldc_w 539
    //   537: lconst_0
    //   538: invokevirtual 548	com/tencent/mm/sdk/platformtools/ax:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   541: pop
    //   542: aload 10
    //   544: invokevirtual 551	com/tencent/mm/sdk/platformtools/ax:commit	()Z
    //   547: pop
    //   548: goto -285 -> 263
    //   551: astore 9
    //   553: ldc 115
    //   555: ldc_w 636
    //   558: iconst_2
    //   559: anewarray 4	java/lang/Object
    //   562: dup
    //   563: iconst_0
    //   564: aload_0
    //   565: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   568: aastore
    //   569: dup
    //   570: iconst_1
    //   571: aload 9
    //   573: invokevirtual 406	java/lang/Exception:toString	()Ljava/lang/String;
    //   576: aastore
    //   577: invokestatic 420	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   580: iconst_0
    //   581: ireturn
    //   582: aload_0
    //   583: getfield 638	com/tencent/mm/plugin/o/i:fd	Ljava/io/FileDescriptor;
    //   586: ifnull -389 -> 197
    //   589: aload_0
    //   590: getfield 638	com/tencent/mm/plugin/o/i:fd	Ljava/io/FileDescriptor;
    //   593: invokevirtual 643	java/io/FileDescriptor:valid	()Z
    //   596: ifeq -399 -> 197
    //   599: aload_0
    //   600: getfield 134	com/tencent/mm/plugin/o/i:ddy	Lcom/tencent/mm/compatible/h/c;
    //   603: aload_0
    //   604: getfield 638	com/tencent/mm/plugin/o/i:fd	Ljava/io/FileDescriptor;
    //   607: aload_0
    //   608: getfield 645	com/tencent/mm/plugin/o/i:buw	J
    //   611: aload_0
    //   612: getfield 647	com/tencent/mm/plugin/o/i:length	J
    //   615: invokevirtual 593	com/tencent/mm/compatible/h/c:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   618: goto -421 -> 197
    //   621: astore 9
    //   623: aload 10
    //   625: ldc_w 528
    //   628: ldc_w 527
    //   631: invokevirtual 600	com/tencent/mm/sdk/platformtools/ax:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   634: aload_0
    //   635: getfield 525	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   638: invokevirtual 606	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   641: ifeq +48 -> 689
    //   644: aload_0
    //   645: instanceof 523
    //   648: ifeq +41 -> 689
    //   651: aload 10
    //   653: ldc_w 533
    //   656: iconst_0
    //   657: invokevirtual 537	com/tencent/mm/sdk/platformtools/ax:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   660: pop
    //   661: aload 10
    //   663: ldc_w 528
    //   666: ldc_w 527
    //   669: invokevirtual 532	com/tencent/mm/sdk/platformtools/ax:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   672: pop
    //   673: aload 10
    //   675: ldc_w 539
    //   678: lconst_0
    //   679: invokevirtual 548	com/tencent/mm/sdk/platformtools/ax:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   682: pop
    //   683: aload 10
    //   685: invokevirtual 551	com/tencent/mm/sdk/platformtools/ax:commit	()Z
    //   688: pop
    //   689: aload 9
    //   691: athrow
    //   692: astore 9
    //   694: goto -314 -> 380
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	697	0	this	i
    //   0	697	1	paramLong1	long
    //   0	697	3	paramLong2	long
    //   3	429	5	l1	long
    //   293	114	7	l2	long
    //   63	387	9	localObject1	Object
    //   466	5	9	localThrowable1	Throwable
    //   551	21	9	localException	Exception
    //   621	69	9	localObject2	Object
    //   692	1	9	localThrowable2	Throwable
    //   44	640	10	localax	com.tencent.mm.sdk.platformtools.ax
    //   163	296	11	localFileDescriptor	FileDescriptor
    // Exception table:
    //   from	to	target	type
    //   104	192	466	java/lang/Throwable
    //   192	197	466	java/lang/Throwable
    //   454	463	466	java/lang/Throwable
    //   582	618	466	java/lang/Throwable
    //   5	22	551	java/lang/Exception
    //   30	60	551	java/lang/Exception
    //   65	104	551	java/lang/Exception
    //   197	263	551	java/lang/Exception
    //   263	295	551	java/lang/Exception
    //   295	380	551	java/lang/Exception
    //   380	443	551	java/lang/Exception
    //   445	451	551	java/lang/Exception
    //   482	548	551	java/lang/Exception
    //   623	689	551	java/lang/Exception
    //   689	692	551	java/lang/Exception
    //   104	192	621	finally
    //   192	197	621	finally
    //   454	463	621	finally
    //   468	482	621	finally
    //   582	618	621	finally
    //   295	380	692	java/lang/Throwable
  }
  
  protected void a(z paramz, MediaFormat paramMediaFormat) {}
  
  public final void a(FileDescriptor paramFileDescriptor, long paramLong1, long paramLong2)
  {
    this.fd = paramFileDescriptor;
    this.buw = paramLong1;
    this.length = paramLong2;
  }
  
  abstract boolean a(long paramLong1, long paramLong2, z paramz, ByteBuffer paramByteBuffer, int paramInt, MediaCodec.BufferInfo paramBufferInfo);
  
  abstract boolean a(z paramz);
  
  protected boolean am(int paramInt, long paramLong)
  {
    return false;
  }
  
  protected void b(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    ad.i("MicroMsg.TrackDataSource", "%s found media format mime[%s] track[%d] format[%s]", new Object[] { info(), paramString, Integer.valueOf(paramInt), paramMediaFormat });
    this.trackIndex = paramInt;
    this.mime = paramString;
    this.bup = (paramMediaFormat.getLong("durationUs") / 1000L);
    this.vLB = paramMediaFormat;
  }
  
  /* Error */
  public final boolean cQr()
  {
    // Byte code:
    //   0: ldc 115
    //   2: ldc_w 664
    //   5: iconst_2
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: aload_0
    //   12: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   15: aastore
    //   16: dup
    //   17: iconst_1
    //   18: aload_0
    //   19: getfield 525	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   22: aastore
    //   23: invokestatic 172	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: invokestatic 156	com/tencent/mm/sdk/platformtools/bt:HI	()J
    //   29: lstore 5
    //   31: ldc_w 515
    //   34: invokestatic 521	com/tencent/mm/sdk/platformtools/ax:aQz	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/ax;
    //   37: astore 10
    //   39: aload_0
    //   40: iconst_0
    //   41: putfield 77	com/tencent/mm/plugin/o/i:vLy	Z
    //   44: ldc 115
    //   46: ldc_w 666
    //   49: iconst_1
    //   50: anewarray 4	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: aload_0
    //   56: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   59: aastore
    //   60: invokestatic 172	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   63: aload_0
    //   64: new 136	com/tencent/mm/compatible/h/c
    //   67: dup
    //   68: invokespecial 558	com/tencent/mm/compatible/h/c:<init>	()V
    //   71: putfield 134	com/tencent/mm/plugin/o/i:ddy	Lcom/tencent/mm/compatible/h/c;
    //   74: aload_0
    //   75: instanceof 523
    //   78: ifeq +54 -> 132
    //   81: aload_0
    //   82: getfield 525	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   85: ifnonnull +355 -> 440
    //   88: ldc_w 527
    //   91: astore 9
    //   93: aload 10
    //   95: ldc_w 528
    //   98: aload 9
    //   100: invokevirtual 532	com/tencent/mm/sdk/platformtools/ax:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   103: pop
    //   104: aload 10
    //   106: ldc_w 533
    //   109: iconst_1
    //   110: invokevirtual 537	com/tencent/mm/sdk/platformtools/ax:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   113: pop
    //   114: aload 10
    //   116: ldc_w 539
    //   119: invokestatic 544	java/lang/System:currentTimeMillis	()J
    //   122: invokevirtual 548	com/tencent/mm/sdk/platformtools/ax:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   125: pop
    //   126: aload 10
    //   128: invokevirtual 551	com/tencent/mm/sdk/platformtools/ax:commit	()Z
    //   131: pop
    //   132: aload_0
    //   133: getfield 525	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   136: invokestatic 562	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   139: ifne +427 -> 566
    //   142: aload_0
    //   143: getfield 525	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   146: iconst_0
    //   147: invokestatic 568	com/tencent/mm/vfs/i:dd	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   150: astore 9
    //   152: aload_0
    //   153: aload 9
    //   155: invokevirtual 574	java/io/RandomAccessFile:getFD	()Ljava/io/FileDescriptor;
    //   158: putfield 638	com/tencent/mm/plugin/o/i:fd	Ljava/io/FileDescriptor;
    //   161: getstatic 580	com/tencent/mm/compatible/deviceinfo/ae:gcG	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   164: getfield 585	com/tencent/mm/compatible/deviceinfo/aa:gcz	I
    //   167: iconst_1
    //   168: if_icmpne +281 -> 449
    //   171: aload_0
    //   172: getfield 134	com/tencent/mm/plugin/o/i:ddy	Lcom/tencent/mm/compatible/h/c;
    //   175: aload_0
    //   176: getfield 638	com/tencent/mm/plugin/o/i:fd	Ljava/io/FileDescriptor;
    //   179: lconst_0
    //   180: aload_0
    //   181: getfield 525	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   184: invokestatic 589	com/tencent/mm/vfs/i:aYo	(Ljava/lang/String;)J
    //   187: invokevirtual 593	com/tencent/mm/compatible/h/c:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   190: aload 9
    //   192: invokevirtual 596	java/io/RandomAccessFile:close	()V
    //   195: aload_0
    //   196: getfield 134	com/tencent/mm/plugin/o/i:ddy	Lcom/tencent/mm/compatible/h/c;
    //   199: getfield 140	com/tencent/mm/compatible/h/c:gdS	Landroid/media/MediaExtractor;
    //   202: invokevirtual 669	android/media/MediaExtractor:getTrackCount	()I
    //   205: istore_1
    //   206: iload_1
    //   207: ifgt +962 -> 1169
    //   210: ldc 115
    //   212: ldc_w 671
    //   215: invokestatic 673	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: aload_0
    //   219: getfield 134	com/tencent/mm/plugin/o/i:ddy	Lcom/tencent/mm/compatible/h/c;
    //   222: getfield 140	com/tencent/mm/compatible/h/c:gdS	Landroid/media/MediaExtractor;
    //   225: invokevirtual 557	android/media/MediaExtractor:release	()V
    //   228: aload_0
    //   229: new 136	com/tencent/mm/compatible/h/c
    //   232: dup
    //   233: invokespecial 558	com/tencent/mm/compatible/h/c:<init>	()V
    //   236: putfield 134	com/tencent/mm/plugin/o/i:ddy	Lcom/tencent/mm/compatible/h/c;
    //   239: aload_0
    //   240: getfield 134	com/tencent/mm/plugin/o/i:ddy	Lcom/tencent/mm/compatible/h/c;
    //   243: aload_0
    //   244: getfield 525	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   247: invokevirtual 677	com/tencent/mm/compatible/h/c:vx	(Ljava/lang/String;)V
    //   250: aload_0
    //   251: getfield 134	com/tencent/mm/plugin/o/i:ddy	Lcom/tencent/mm/compatible/h/c;
    //   254: getfield 140	com/tencent/mm/compatible/h/c:gdS	Landroid/media/MediaExtractor;
    //   257: invokevirtual 669	android/media/MediaExtractor:getTrackCount	()I
    //   260: istore_1
    //   261: aload_0
    //   262: iconst_m1
    //   263: putfield 608	com/tencent/mm/plugin/o/i:trackIndex	I
    //   266: iconst_0
    //   267: istore_2
    //   268: iload_2
    //   269: iload_1
    //   270: if_icmpge +49 -> 319
    //   273: aload_0
    //   274: getfield 134	com/tencent/mm/plugin/o/i:ddy	Lcom/tencent/mm/compatible/h/c;
    //   277: iload_2
    //   278: invokevirtual 681	com/tencent/mm/compatible/h/c:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   281: astore 9
    //   283: aload 9
    //   285: ldc_w 682
    //   288: invokevirtual 685	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   291: astore 11
    //   293: aload 11
    //   295: ifnull +419 -> 714
    //   298: aload 11
    //   300: aload_0
    //   301: invokevirtual 440	com/tencent/mm/plugin/o/i:type	()Ljava/lang/String;
    //   304: invokevirtual 617	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   307: ifeq +407 -> 714
    //   310: aload_0
    //   311: aload 9
    //   313: aload 11
    //   315: iload_2
    //   316: invokevirtual 687	com/tencent/mm/plugin/o/i:b	(Landroid/media/MediaFormat;Ljava/lang/String;I)V
    //   319: aload_0
    //   320: getfield 608	com/tencent/mm/plugin/o/i:trackIndex	I
    //   323: ifge +398 -> 721
    //   326: ldc 115
    //   328: ldc_w 689
    //   331: iconst_3
    //   332: anewarray 4	java/lang/Object
    //   335: dup
    //   336: iconst_0
    //   337: aload_0
    //   338: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   341: aastore
    //   342: dup
    //   343: iconst_1
    //   344: iload_1
    //   345: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   348: aastore
    //   349: dup
    //   350: iconst_2
    //   351: aload_0
    //   352: getfield 608	com/tencent/mm/plugin/o/i:trackIndex	I
    //   355: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   358: aastore
    //   359: invokestatic 341	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   362: aload_0
    //   363: getfield 94	com/tencent/mm/plugin/o/i:vLw	Lcom/tencent/mm/plugin/o/h;
    //   366: ldc_w 691
    //   369: invokevirtual 694	com/tencent/mm/plugin/o/h:aqH	(Ljava/lang/String;)V
    //   372: aload 10
    //   374: ldc_w 528
    //   377: ldc_w 527
    //   380: invokevirtual 600	com/tencent/mm/sdk/platformtools/ax:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   383: aload_0
    //   384: getfield 525	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   387: invokevirtual 606	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   390: ifeq +48 -> 438
    //   393: aload_0
    //   394: instanceof 523
    //   397: ifeq +41 -> 438
    //   400: aload 10
    //   402: ldc_w 533
    //   405: iconst_0
    //   406: invokevirtual 537	com/tencent/mm/sdk/platformtools/ax:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   409: pop
    //   410: aload 10
    //   412: ldc_w 528
    //   415: ldc_w 527
    //   418: invokevirtual 532	com/tencent/mm/sdk/platformtools/ax:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   421: pop
    //   422: aload 10
    //   424: ldc_w 539
    //   427: lconst_0
    //   428: invokevirtual 548	com/tencent/mm/sdk/platformtools/ax:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   431: pop
    //   432: aload 10
    //   434: invokevirtual 551	com/tencent/mm/sdk/platformtools/ax:commit	()Z
    //   437: pop
    //   438: iconst_0
    //   439: ireturn
    //   440: aload_0
    //   441: getfield 525	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   444: astore 9
    //   446: goto -353 -> 93
    //   449: aload_0
    //   450: getfield 134	com/tencent/mm/plugin/o/i:ddy	Lcom/tencent/mm/compatible/h/c;
    //   453: aload_0
    //   454: getfield 638	com/tencent/mm/plugin/o/i:fd	Ljava/io/FileDescriptor;
    //   457: invokevirtual 634	com/tencent/mm/compatible/h/c:setDataSource	(Ljava/io/FileDescriptor;)V
    //   460: goto -270 -> 190
    //   463: astore 9
    //   465: ldc 115
    //   467: aload 9
    //   469: ldc_w 696
    //   472: iconst_1
    //   473: anewarray 4	java/lang/Object
    //   476: dup
    //   477: iconst_0
    //   478: aload_0
    //   479: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   482: aastore
    //   483: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   486: aload_0
    //   487: getfield 94	com/tencent/mm/plugin/o/i:vLw	Lcom/tencent/mm/plugin/o/h;
    //   490: aload 9
    //   492: invokevirtual 406	java/lang/Exception:toString	()Ljava/lang/String;
    //   495: invokevirtual 694	com/tencent/mm/plugin/o/h:aqH	(Ljava/lang/String;)V
    //   498: aload 10
    //   500: ldc_w 528
    //   503: ldc_w 527
    //   506: invokevirtual 600	com/tencent/mm/sdk/platformtools/ax:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   509: aload_0
    //   510: getfield 525	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   513: invokevirtual 606	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   516: ifeq +48 -> 564
    //   519: aload_0
    //   520: instanceof 523
    //   523: ifeq +41 -> 564
    //   526: aload 10
    //   528: ldc_w 533
    //   531: iconst_0
    //   532: invokevirtual 537	com/tencent/mm/sdk/platformtools/ax:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   535: pop
    //   536: aload 10
    //   538: ldc_w 528
    //   541: ldc_w 527
    //   544: invokevirtual 532	com/tencent/mm/sdk/platformtools/ax:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   547: pop
    //   548: aload 10
    //   550: ldc_w 539
    //   553: lconst_0
    //   554: invokevirtual 548	com/tencent/mm/sdk/platformtools/ax:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   557: pop
    //   558: aload 10
    //   560: invokevirtual 551	com/tencent/mm/sdk/platformtools/ax:commit	()Z
    //   563: pop
    //   564: iconst_0
    //   565: ireturn
    //   566: aload_0
    //   567: getfield 638	com/tencent/mm/plugin/o/i:fd	Ljava/io/FileDescriptor;
    //   570: ifnull -375 -> 195
    //   573: aload_0
    //   574: getfield 638	com/tencent/mm/plugin/o/i:fd	Ljava/io/FileDescriptor;
    //   577: invokevirtual 643	java/io/FileDescriptor:valid	()Z
    //   580: ifeq -385 -> 195
    //   583: aload_0
    //   584: getfield 134	com/tencent/mm/plugin/o/i:ddy	Lcom/tencent/mm/compatible/h/c;
    //   587: aload_0
    //   588: getfield 638	com/tencent/mm/plugin/o/i:fd	Ljava/io/FileDescriptor;
    //   591: aload_0
    //   592: getfield 645	com/tencent/mm/plugin/o/i:buw	J
    //   595: aload_0
    //   596: getfield 647	com/tencent/mm/plugin/o/i:length	J
    //   599: invokevirtual 593	com/tencent/mm/compatible/h/c:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   602: goto -407 -> 195
    //   605: astore 9
    //   607: ldc 115
    //   609: ldc_w 698
    //   612: iconst_2
    //   613: anewarray 4	java/lang/Object
    //   616: dup
    //   617: iconst_0
    //   618: aload_0
    //   619: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   622: aastore
    //   623: dup
    //   624: iconst_1
    //   625: aload 9
    //   627: invokevirtual 699	java/lang/Throwable:toString	()Ljava/lang/String;
    //   630: aastore
    //   631: invokestatic 420	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   634: aload_0
    //   635: getfield 94	com/tencent/mm/plugin/o/i:vLw	Lcom/tencent/mm/plugin/o/h;
    //   638: aload 9
    //   640: invokevirtual 699	java/lang/Throwable:toString	()Ljava/lang/String;
    //   643: invokevirtual 694	com/tencent/mm/plugin/o/h:aqH	(Ljava/lang/String;)V
    //   646: aload 10
    //   648: ldc_w 528
    //   651: ldc_w 527
    //   654: invokevirtual 600	com/tencent/mm/sdk/platformtools/ax:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   657: aload_0
    //   658: getfield 525	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   661: invokevirtual 606	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   664: ifeq +48 -> 712
    //   667: aload_0
    //   668: instanceof 523
    //   671: ifeq +41 -> 712
    //   674: aload 10
    //   676: ldc_w 533
    //   679: iconst_0
    //   680: invokevirtual 537	com/tencent/mm/sdk/platformtools/ax:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   683: pop
    //   684: aload 10
    //   686: ldc_w 528
    //   689: ldc_w 527
    //   692: invokevirtual 532	com/tencent/mm/sdk/platformtools/ax:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   695: pop
    //   696: aload 10
    //   698: ldc_w 539
    //   701: lconst_0
    //   702: invokevirtual 548	com/tencent/mm/sdk/platformtools/ax:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   705: pop
    //   706: aload 10
    //   708: invokevirtual 551	com/tencent/mm/sdk/platformtools/ax:commit	()Z
    //   711: pop
    //   712: iconst_0
    //   713: ireturn
    //   714: iload_2
    //   715: iconst_1
    //   716: iadd
    //   717: istore_2
    //   718: goto -450 -> 268
    //   721: aload_0
    //   722: getfield 134	com/tencent/mm/plugin/o/i:ddy	Lcom/tencent/mm/compatible/h/c;
    //   725: aload_0
    //   726: getfield 608	com/tencent/mm/plugin/o/i:trackIndex	I
    //   729: invokevirtual 611	com/tencent/mm/compatible/h/c:selectTrack	(I)V
    //   732: aload_0
    //   733: getfield 525	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   736: invokestatic 562	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   739: ifne +8 -> 747
    //   742: aload_0
    //   743: aconst_null
    //   744: putfield 258	com/tencent/mm/plugin/o/i:vLC	Lcom/tencent/mm/plugin/o/g;
    //   747: invokestatic 156	com/tencent/mm/sdk/platformtools/bt:HI	()J
    //   750: lstore 7
    //   752: aload 10
    //   754: ldc_w 528
    //   757: ldc_w 527
    //   760: invokevirtual 600	com/tencent/mm/sdk/platformtools/ax:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   763: aload_0
    //   764: getfield 525	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   767: invokevirtual 606	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   770: ifeq +48 -> 818
    //   773: aload_0
    //   774: instanceof 523
    //   777: ifeq +41 -> 818
    //   780: aload 10
    //   782: ldc_w 533
    //   785: iconst_0
    //   786: invokevirtual 537	com/tencent/mm/sdk/platformtools/ax:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   789: pop
    //   790: aload 10
    //   792: ldc_w 528
    //   795: ldc_w 527
    //   798: invokevirtual 532	com/tencent/mm/sdk/platformtools/ax:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   801: pop
    //   802: aload 10
    //   804: ldc_w 539
    //   807: lconst_0
    //   808: invokevirtual 548	com/tencent/mm/sdk/platformtools/ax:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   811: pop
    //   812: aload 10
    //   814: invokevirtual 551	com/tencent/mm/sdk/platformtools/ax:commit	()Z
    //   817: pop
    //   818: ldc 115
    //   820: ldc_w 701
    //   823: iconst_3
    //   824: anewarray 4	java/lang/Object
    //   827: dup
    //   828: iconst_0
    //   829: aload_0
    //   830: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   833: aastore
    //   834: dup
    //   835: iconst_1
    //   836: aload_0
    //   837: getfield 654	com/tencent/mm/plugin/o/i:mime	Ljava/lang/String;
    //   840: aastore
    //   841: dup
    //   842: iconst_2
    //   843: aload_0
    //   844: getfield 98	com/tencent/mm/plugin/o/i:state	I
    //   847: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   850: aastore
    //   851: invokestatic 172	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   854: aload_0
    //   855: getfield 98	com/tencent/mm/plugin/o/i:state	I
    //   858: invokestatic 240	com/tencent/mm/plugin/o/e:JW	(I)Z
    //   861: ifne +303 -> 1164
    //   864: aload_0
    //   865: getfield 88	com/tencent/mm/plugin/o/i:lock	Ljava/lang/Object;
    //   868: astore 9
    //   870: aload 9
    //   872: monitorenter
    //   873: ldc 115
    //   875: ldc_w 703
    //   878: iconst_2
    //   879: anewarray 4	java/lang/Object
    //   882: dup
    //   883: iconst_0
    //   884: aload_0
    //   885: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   888: aastore
    //   889: dup
    //   890: iconst_1
    //   891: aload_0
    //   892: getfield 203	com/tencent/mm/plugin/o/i:vLB	Landroid/media/MediaFormat;
    //   895: aastore
    //   896: invokestatic 151	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   899: aload_0
    //   900: aload_0
    //   901: getfield 654	com/tencent/mm/plugin/o/i:mime	Ljava/lang/String;
    //   904: invokestatic 707	com/tencent/mm/compatible/deviceinfo/z:vm	(Ljava/lang/String;)Lcom/tencent/mm/compatible/deviceinfo/z;
    //   907: putfield 158	com/tencent/mm/plugin/o/i:hir	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   910: aload_0
    //   911: aload_0
    //   912: getfield 158	com/tencent/mm/plugin/o/i:hir	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   915: invokevirtual 709	com/tencent/mm/plugin/o/i:a	(Lcom/tencent/mm/compatible/deviceinfo/z;)Z
    //   918: pop
    //   919: aload_0
    //   920: getfield 158	com/tencent/mm/plugin/o/i:hir	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   923: invokevirtual 712	com/tencent/mm/compatible/deviceinfo/z:start	()V
    //   926: aload_0
    //   927: aload_0
    //   928: getfield 158	com/tencent/mm/plugin/o/i:hir	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   931: invokevirtual 715	com/tencent/mm/compatible/deviceinfo/z:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   934: putfield 256	com/tencent/mm/plugin/o/i:btA	[Ljava/nio/ByteBuffer;
    //   937: aload_0
    //   938: aload_0
    //   939: getfield 158	com/tencent/mm/plugin/o/i:hir	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   942: invokevirtual 210	com/tencent/mm/compatible/deviceinfo/z:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   945: putfield 178	com/tencent/mm/plugin/o/i:bfT	[Ljava/nio/ByteBuffer;
    //   948: aload 9
    //   950: monitorexit
    //   951: invokestatic 156	com/tencent/mm/sdk/platformtools/bt:HI	()J
    //   954: lstore_3
    //   955: aload_0
    //   956: iconst_1
    //   957: invokevirtual 176	com/tencent/mm/plugin/o/i:setState	(I)V
    //   960: ldc 115
    //   962: ldc_w 717
    //   965: iconst_4
    //   966: anewarray 4	java/lang/Object
    //   969: dup
    //   970: iconst_0
    //   971: aload_0
    //   972: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   975: aastore
    //   976: dup
    //   977: iconst_1
    //   978: lload 5
    //   980: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:aO	(J)J
    //   983: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   986: aastore
    //   987: dup
    //   988: iconst_2
    //   989: lload 7
    //   991: lload 5
    //   993: lsub
    //   994: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   997: aastore
    //   998: dup
    //   999: iconst_3
    //   1000: lload_3
    //   1001: lload 5
    //   1003: lsub
    //   1004: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1007: aastore
    //   1008: invokestatic 172	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1011: iconst_1
    //   1012: ireturn
    //   1013: astore 9
    //   1015: aload 10
    //   1017: ldc_w 528
    //   1020: ldc_w 527
    //   1023: invokevirtual 600	com/tencent/mm/sdk/platformtools/ax:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1026: aload_0
    //   1027: getfield 525	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   1030: invokevirtual 606	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1033: ifeq +48 -> 1081
    //   1036: aload_0
    //   1037: instanceof 523
    //   1040: ifeq +41 -> 1081
    //   1043: aload 10
    //   1045: ldc_w 533
    //   1048: iconst_0
    //   1049: invokevirtual 537	com/tencent/mm/sdk/platformtools/ax:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   1052: pop
    //   1053: aload 10
    //   1055: ldc_w 528
    //   1058: ldc_w 527
    //   1061: invokevirtual 532	com/tencent/mm/sdk/platformtools/ax:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   1064: pop
    //   1065: aload 10
    //   1067: ldc_w 539
    //   1070: lconst_0
    //   1071: invokevirtual 548	com/tencent/mm/sdk/platformtools/ax:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   1074: pop
    //   1075: aload 10
    //   1077: invokevirtual 551	com/tencent/mm/sdk/platformtools/ax:commit	()Z
    //   1080: pop
    //   1081: aload 9
    //   1083: athrow
    //   1084: astore 10
    //   1086: aload 9
    //   1088: monitorexit
    //   1089: aload 10
    //   1091: athrow
    //   1092: astore 9
    //   1094: ldc 115
    //   1096: aload 9
    //   1098: ldc_w 719
    //   1101: iconst_2
    //   1102: anewarray 4	java/lang/Object
    //   1105: dup
    //   1106: iconst_0
    //   1107: aload_0
    //   1108: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   1111: aastore
    //   1112: dup
    //   1113: iconst_1
    //   1114: aload 9
    //   1116: invokevirtual 406	java/lang/Exception:toString	()Ljava/lang/String;
    //   1119: aastore
    //   1120: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1123: ldc 115
    //   1125: aload 9
    //   1127: ldc_w 721
    //   1130: iconst_2
    //   1131: anewarray 4	java/lang/Object
    //   1134: dup
    //   1135: iconst_0
    //   1136: aload_0
    //   1137: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   1140: aastore
    //   1141: dup
    //   1142: iconst_1
    //   1143: aload_0
    //   1144: getfield 203	com/tencent/mm/plugin/o/i:vLB	Landroid/media/MediaFormat;
    //   1147: aastore
    //   1148: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1151: aload_0
    //   1152: getfield 94	com/tencent/mm/plugin/o/i:vLw	Lcom/tencent/mm/plugin/o/h;
    //   1155: aload_0
    //   1156: invokevirtual 440	com/tencent/mm/plugin/o/i:type	()Ljava/lang/String;
    //   1159: invokevirtual 724	com/tencent/mm/plugin/o/h:aqI	(Ljava/lang/String;)V
    //   1162: iconst_0
    //   1163: ireturn
    //   1164: lconst_0
    //   1165: lstore_3
    //   1166: goto -211 -> 955
    //   1169: goto -908 -> 261
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1172	0	this	i
    //   205	140	1	i	int
    //   267	451	2	j	int
    //   954	212	3	l1	long
    //   29	973	5	l2	long
    //   750	240	7	l3	long
    //   91	354	9	localObject1	Object
    //   463	28	9	localException1	Exception
    //   605	34	9	localThrowable	Throwable
    //   1013	74	9	localObject3	Object
    //   1092	34	9	localException2	Exception
    //   37	1039	10	localax	com.tencent.mm.sdk.platformtools.ax
    //   1084	6	10	localObject4	Object
    //   291	23	11	str	String
    // Exception table:
    //   from	to	target	type
    //   44	88	463	java/lang/Exception
    //   93	132	463	java/lang/Exception
    //   132	190	463	java/lang/Exception
    //   190	195	463	java/lang/Exception
    //   195	206	463	java/lang/Exception
    //   210	261	463	java/lang/Exception
    //   261	266	463	java/lang/Exception
    //   273	293	463	java/lang/Exception
    //   298	319	463	java/lang/Exception
    //   319	372	463	java/lang/Exception
    //   440	446	463	java/lang/Exception
    //   449	460	463	java/lang/Exception
    //   566	602	463	java/lang/Exception
    //   721	747	463	java/lang/Exception
    //   747	752	463	java/lang/Exception
    //   44	88	605	java/lang/Throwable
    //   93	132	605	java/lang/Throwable
    //   132	190	605	java/lang/Throwable
    //   190	195	605	java/lang/Throwable
    //   195	206	605	java/lang/Throwable
    //   210	261	605	java/lang/Throwable
    //   261	266	605	java/lang/Throwable
    //   273	293	605	java/lang/Throwable
    //   298	319	605	java/lang/Throwable
    //   319	372	605	java/lang/Throwable
    //   440	446	605	java/lang/Throwable
    //   449	460	605	java/lang/Throwable
    //   566	602	605	java/lang/Throwable
    //   721	747	605	java/lang/Throwable
    //   747	752	605	java/lang/Throwable
    //   44	88	1013	finally
    //   93	132	1013	finally
    //   132	190	1013	finally
    //   190	195	1013	finally
    //   195	206	1013	finally
    //   210	261	1013	finally
    //   261	266	1013	finally
    //   273	293	1013	finally
    //   298	319	1013	finally
    //   319	372	1013	finally
    //   440	446	1013	finally
    //   449	460	1013	finally
    //   465	498	1013	finally
    //   566	602	1013	finally
    //   607	646	1013	finally
    //   721	747	1013	finally
    //   747	752	1013	finally
    //   873	951	1084	finally
    //   1086	1089	1084	finally
    //   818	873	1092	java/lang/Exception
    //   951	955	1092	java/lang/Exception
    //   1089	1092	1092	java/lang/Exception
  }
  
  public final void dmw()
  {
    ad.i("MicroMsg.TrackDataSource", "%s flush codec", new Object[] { info() });
    this.btD = -1;
    this.btC = -1;
    try
    {
      z localz;
      if (this.hir != null) {
        localz = this.hir;
      }
      try
      {
        if (!localz.cKc) {
          ad.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy flush not alive");
        }
        MediaCodecProxyUtils.b.lv(96);
        localz.gbX.flush();
        MediaCodecProxyUtils.b.lv(97);
        return;
      }
      catch (Exception localException2)
      {
        ad.printErrStackTrace("MicroMsg.MediaCodecProxy", localException2, "MediaCodecProxy flush, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
        MediaCodecProxyUtils.b.lv(39);
        localz.gbZ.getAndIncrement();
        throw localException2;
      }
      return;
    }
    catch (Exception localException1)
    {
      ad.printErrStackTrace("MicroMsg.TrackDataSource", localException1, "flushCodec exception", new Object[0]);
    }
  }
  
  protected final boolean dmx()
  {
    try
    {
      ad.i("MicroMsg.TrackDataSource", "%s start to prepare decoder mime[%s]", new Object[] { info(), this.mime });
      this.hir = z.vm(this.mime);
      a(this.hir);
      this.hir.start();
      this.btA = this.hir.getInputBuffers();
      this.bfT = this.hir.getOutputBuffers();
      return true;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.TrackDataSource", localException, "%s prepare decoder init decoder error ", new Object[] { info() });
      this.vLw.aqI(type());
    }
    return false;
  }
  
  protected final MediaFormat dmy()
  {
    if ((this.ddy == null) || (this.trackIndex < 0)) {
      return this.vLB;
    }
    return this.ddy.getTrackFormat(this.trackIndex);
  }
  
  public final String info()
  {
    if (this.vLw != null) {
      return type() + "_" + this.vLw.info() + "_" + Process.myTid();
    }
    return type() + "_" + Process.myTid();
  }
  
  protected void onPause() {}
  
  protected void onStart() {}
  
  public final void pause()
  {
    ad.i("MicroMsg.TrackDataSource", "%s start to pause", new Object[] { info() });
    setState(4);
    onPause();
  }
  
  public void release()
  {
    ad.i("MicroMsg.TrackDataSource", "release doubleReleaseSwitch:[%b]", new Object[] { Boolean.valueOf(vLF) });
    if (vLF)
    {
      ad.i("MicroMsg.TrackDataSource", "%s into release fun", new Object[] { info() });
      if (this.ddy != null)
      {
        ad.i("MicroMsg.TrackDataSource", "%s release,  extractor != null", new Object[] { info() });
        this.ddy.gdS.release();
        this.ddy = null;
      }
      releaseDecoder();
      if (this.vLC != null)
      {
        ad.i("MicroMsg.TrackDataSource", "%s release,  mp4Extractor != null", new Object[] { info() });
        this.vLC.release();
      }
      ad.i("MicroMsg.TrackDataSource", "%s finish release", new Object[] { info() });
      return;
    }
    ad.i("MicroMsg.TrackDataSource", "%s release", new Object[] { info() });
    if (this.ddy != null)
    {
      this.ddy.gdS.release();
      this.ddy = null;
    }
    if (this.hir != null)
    {
      this.hir.release();
      this.hir = null;
    }
    if (this.vLC != null) {
      this.vLC.release();
    }
    ad.i("MicroMsg.TrackDataSource", "%s finish release", new Object[] { info() });
  }
  
  /* Error */
  protected final void releaseDecoder()
  {
    // Byte code:
    //   0: ldc 115
    //   2: ldc_w 806
    //   5: iconst_1
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: getstatic 68	com/tencent/mm/plugin/o/i:vLF	Z
    //   14: invokestatic 232	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   17: aastore
    //   18: invokestatic 172	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   21: getstatic 68	com/tencent/mm/plugin/o/i:vLF	Z
    //   24: ifeq +227 -> 251
    //   27: invokestatic 156	com/tencent/mm/sdk/platformtools/bt:HI	()J
    //   30: lstore_1
    //   31: aload_0
    //   32: getfield 88	com/tencent/mm/plugin/o/i:lock	Ljava/lang/Object;
    //   35: astore_3
    //   36: aload_3
    //   37: monitorenter
    //   38: aload_0
    //   39: getfield 158	com/tencent/mm/plugin/o/i:hir	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   42: ifnull +187 -> 229
    //   45: ldc 115
    //   47: ldc_w 808
    //   50: iconst_1
    //   51: anewarray 4	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: aload_0
    //   57: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   60: aastore
    //   61: invokestatic 172	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: aload_0
    //   65: invokevirtual 437	com/tencent/mm/plugin/o/i:dmw	()V
    //   68: aload_0
    //   69: aconst_null
    //   70: putfield 178	com/tencent/mm/plugin/o/i:bfT	[Ljava/nio/ByteBuffer;
    //   73: aload_0
    //   74: aconst_null
    //   75: putfield 256	com/tencent/mm/plugin/o/i:btA	[Ljava/nio/ByteBuffer;
    //   78: ldc 115
    //   80: ldc_w 810
    //   83: iconst_2
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: aload_0
    //   90: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   93: aastore
    //   94: dup
    //   95: iconst_1
    //   96: lload_1
    //   97: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:aO	(J)J
    //   100: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   103: aastore
    //   104: invokestatic 172	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   107: aload_0
    //   108: getfield 158	com/tencent/mm/plugin/o/i:hir	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   111: invokevirtual 813	com/tencent/mm/compatible/deviceinfo/z:stop	()V
    //   114: aload_0
    //   115: getfield 158	com/tencent/mm/plugin/o/i:hir	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   118: invokevirtual 804	com/tencent/mm/compatible/deviceinfo/z:release	()V
    //   121: aload_0
    //   122: aconst_null
    //   123: putfield 158	com/tencent/mm/plugin/o/i:hir	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   126: ldc 115
    //   128: ldc_w 815
    //   131: iconst_2
    //   132: anewarray 4	java/lang/Object
    //   135: dup
    //   136: iconst_0
    //   137: aload_0
    //   138: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   141: aastore
    //   142: dup
    //   143: iconst_1
    //   144: lload_1
    //   145: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:aO	(J)J
    //   148: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   151: aastore
    //   152: invokestatic 172	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload_3
    //   156: monitorexit
    //   157: return
    //   158: astore 4
    //   160: aload_0
    //   161: aconst_null
    //   162: putfield 158	com/tencent/mm/plugin/o/i:hir	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   165: aload 4
    //   167: athrow
    //   168: astore 4
    //   170: aload_3
    //   171: monitorexit
    //   172: aload 4
    //   174: athrow
    //   175: astore 4
    //   177: aload_0
    //   178: getfield 158	com/tencent/mm/plugin/o/i:hir	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   181: invokevirtual 804	com/tencent/mm/compatible/deviceinfo/z:release	()V
    //   184: aload_0
    //   185: aconst_null
    //   186: putfield 158	com/tencent/mm/plugin/o/i:hir	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   189: goto -63 -> 126
    //   192: astore 4
    //   194: aload_0
    //   195: aconst_null
    //   196: putfield 158	com/tencent/mm/plugin/o/i:hir	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   199: aload 4
    //   201: athrow
    //   202: astore 4
    //   204: aload_0
    //   205: getfield 158	com/tencent/mm/plugin/o/i:hir	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   208: invokevirtual 804	com/tencent/mm/compatible/deviceinfo/z:release	()V
    //   211: aload_0
    //   212: aconst_null
    //   213: putfield 158	com/tencent/mm/plugin/o/i:hir	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   216: aload 4
    //   218: athrow
    //   219: astore 4
    //   221: aload_0
    //   222: aconst_null
    //   223: putfield 158	com/tencent/mm/plugin/o/i:hir	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   226: aload 4
    //   228: athrow
    //   229: ldc 115
    //   231: ldc_w 817
    //   234: iconst_1
    //   235: anewarray 4	java/lang/Object
    //   238: dup
    //   239: iconst_0
    //   240: aload_0
    //   241: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   244: aastore
    //   245: invokestatic 172	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   248: goto -93 -> 155
    //   251: aload_0
    //   252: getfield 158	com/tencent/mm/plugin/o/i:hir	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   255: ifnull +198 -> 453
    //   258: ldc 115
    //   260: ldc_w 808
    //   263: iconst_1
    //   264: anewarray 4	java/lang/Object
    //   267: dup
    //   268: iconst_0
    //   269: aload_0
    //   270: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   273: aastore
    //   274: invokestatic 172	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   277: aload_0
    //   278: invokevirtual 437	com/tencent/mm/plugin/o/i:dmw	()V
    //   281: aload_0
    //   282: aconst_null
    //   283: putfield 178	com/tencent/mm/plugin/o/i:bfT	[Ljava/nio/ByteBuffer;
    //   286: aload_0
    //   287: aconst_null
    //   288: putfield 256	com/tencent/mm/plugin/o/i:btA	[Ljava/nio/ByteBuffer;
    //   291: invokestatic 156	com/tencent/mm/sdk/platformtools/bt:HI	()J
    //   294: lstore_1
    //   295: aload_0
    //   296: getfield 88	com/tencent/mm/plugin/o/i:lock	Ljava/lang/Object;
    //   299: astore_3
    //   300: aload_3
    //   301: monitorenter
    //   302: ldc 115
    //   304: ldc_w 810
    //   307: iconst_2
    //   308: anewarray 4	java/lang/Object
    //   311: dup
    //   312: iconst_0
    //   313: aload_0
    //   314: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   317: aastore
    //   318: dup
    //   319: iconst_1
    //   320: lload_1
    //   321: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:aO	(J)J
    //   324: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   327: aastore
    //   328: invokestatic 172	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   331: aload_0
    //   332: getfield 158	com/tencent/mm/plugin/o/i:hir	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   335: invokevirtual 813	com/tencent/mm/compatible/deviceinfo/z:stop	()V
    //   338: aload_0
    //   339: getfield 158	com/tencent/mm/plugin/o/i:hir	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   342: invokevirtual 804	com/tencent/mm/compatible/deviceinfo/z:release	()V
    //   345: aload_0
    //   346: aconst_null
    //   347: putfield 158	com/tencent/mm/plugin/o/i:hir	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   350: aload_3
    //   351: monitorexit
    //   352: ldc 115
    //   354: ldc_w 815
    //   357: iconst_2
    //   358: anewarray 4	java/lang/Object
    //   361: dup
    //   362: iconst_0
    //   363: aload_0
    //   364: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   367: aastore
    //   368: dup
    //   369: iconst_1
    //   370: lload_1
    //   371: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:aO	(J)J
    //   374: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   377: aastore
    //   378: invokestatic 172	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   381: return
    //   382: astore 4
    //   384: aload_0
    //   385: aconst_null
    //   386: putfield 158	com/tencent/mm/plugin/o/i:hir	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   389: aload 4
    //   391: athrow
    //   392: astore 4
    //   394: aload_3
    //   395: monitorexit
    //   396: aload 4
    //   398: athrow
    //   399: astore 4
    //   401: aload_0
    //   402: getfield 158	com/tencent/mm/plugin/o/i:hir	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   405: invokevirtual 804	com/tencent/mm/compatible/deviceinfo/z:release	()V
    //   408: aload_0
    //   409: aconst_null
    //   410: putfield 158	com/tencent/mm/plugin/o/i:hir	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   413: goto -63 -> 350
    //   416: astore 4
    //   418: aload_0
    //   419: aconst_null
    //   420: putfield 158	com/tencent/mm/plugin/o/i:hir	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   423: aload 4
    //   425: athrow
    //   426: astore 4
    //   428: aload_0
    //   429: getfield 158	com/tencent/mm/plugin/o/i:hir	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   432: invokevirtual 804	com/tencent/mm/compatible/deviceinfo/z:release	()V
    //   435: aload_0
    //   436: aconst_null
    //   437: putfield 158	com/tencent/mm/plugin/o/i:hir	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   440: aload 4
    //   442: athrow
    //   443: astore 4
    //   445: aload_0
    //   446: aconst_null
    //   447: putfield 158	com/tencent/mm/plugin/o/i:hir	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   450: aload 4
    //   452: athrow
    //   453: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	454	0	this	i
    //   30	341	1	l	long
    //   35	360	3	localObject1	Object
    //   158	8	4	localObject2	Object
    //   168	5	4	localObject3	Object
    //   175	1	4	localException1	Exception
    //   192	8	4	localObject4	Object
    //   202	15	4	localObject5	Object
    //   219	8	4	localObject6	Object
    //   382	8	4	localObject7	Object
    //   392	5	4	localObject8	Object
    //   399	1	4	localException2	Exception
    //   416	8	4	localObject9	Object
    //   426	15	4	localObject10	Object
    //   443	8	4	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   114	121	158	finally
    //   38	107	168	finally
    //   121	126	168	finally
    //   126	155	168	finally
    //   155	157	168	finally
    //   160	168	168	finally
    //   170	172	168	finally
    //   184	189	168	finally
    //   194	202	168	finally
    //   211	219	168	finally
    //   221	229	168	finally
    //   229	248	168	finally
    //   107	114	175	java/lang/Exception
    //   177	184	192	finally
    //   107	114	202	finally
    //   204	211	219	finally
    //   338	345	382	finally
    //   302	331	392	finally
    //   345	350	392	finally
    //   350	352	392	finally
    //   384	392	392	finally
    //   394	396	392	finally
    //   408	413	392	finally
    //   418	426	392	finally
    //   435	443	392	finally
    //   445	453	392	finally
    //   331	338	399	java/lang/Exception
    //   401	408	416	finally
    //   331	338	426	finally
    //   428	435	443	finally
  }
  
  public final void setPath(String paramString)
  {
    this.path = paramString;
  }
  
  protected final void setState(int paramInt)
  {
    ad.i("MicroMsg.TrackDataSource", "%s set state old %d new %d", new Object[] { info(), Integer.valueOf(this.state), Integer.valueOf(paramInt) });
    this.state = paramInt;
  }
  
  public final void start()
  {
    ad.i("MicroMsg.TrackDataSource", "%s start to play", new Object[] { info() });
    this.vLy = false;
    setState(3);
    onStart();
  }
  
  abstract String type();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.o.i
 * JD-Core Version:    0.7.0.1
 */