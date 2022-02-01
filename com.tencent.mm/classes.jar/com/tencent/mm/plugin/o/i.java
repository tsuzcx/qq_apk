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
import com.tencent.mm.plugin.a.m;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.FileDescriptor;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class i
{
  private static boolean tAd;
  private static long tAe;
  private ByteBuffer[] aUK;
  private ByteBuffer[] biB;
  private int biD;
  private int biE;
  private MediaCodec.BufferInfo bin = new MediaCodec.BufferInfo();
  long bjp;
  protected long bjw;
  private c cUM;
  protected FileDescriptor fd;
  protected z gnF;
  protected long length;
  private volatile Object lock = new Object();
  private String mime;
  protected String path;
  protected volatile int state;
  private g tAa;
  private boolean tAb = false;
  private boolean tAc = false;
  private int trackIndex;
  protected h tzT;
  protected ap tzU;
  private volatile boolean tzV = false;
  b tzW = null;
  protected long tzX = 0L;
  MediaFormat tzY;
  
  static
  {
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.ppZ, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      tAd = bool;
      tAe = 0L;
      return;
    }
  }
  
  public i(h paramh, ap paramap)
  {
    this.tzT = paramh;
    this.tzU = paramap;
    this.state = 0;
    this.biD = -1;
    this.biE = -1;
  }
  
  private void cPq()
  {
    if (this.tzW != null) {
      this.tzX = (this.tzW.cPk() * 1000L);
    }
  }
  
  private boolean g(long paramLong1, long paramLong2)
  {
    ad.d("MicroMsg.TrackDataSource", "%s drain output buffer state:%s time[%d %d %s] index %d", new Object[] { info(), Integer.valueOf(this.state), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(this.cUM.fGK.getSampleTime()), Integer.valueOf(this.biE) });
    long l = bt.GC();
    if (this.biE < 0)
    {
      synchronized (this.lock)
      {
        this.biE = this.gnF.dequeueOutputBuffer(this.bin, tAe);
        if (this.biE < 0) {
          break label259;
        }
        if ((this.bin.flags & 0x4) != 0)
        {
          ad.i("MicroMsg.TrackDataSource", "%s process end of stream", new Object[] { info() });
          setState(9);
          this.biE = -1;
          return false;
        }
      }
      ??? = this.aUK[this.biE];
      if (??? != null)
      {
        ((ByteBuffer)???).position(this.bin.offset);
        ((ByteBuffer)???).limit(this.bin.offset + this.bin.size);
      }
    }
    if (this.state == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.gnF.releaseOutputBuffer(this.biE, true);
      this.biE = -1;
      setState(2);
      return true;
      label259:
      if (this.biE == -2)
      {
        ??? = this.gnF.getOutputFormat();
        this.tzY = ((MediaFormat)???);
        a(this.gnF, (MediaFormat)???);
        return true;
      }
      if (this.biE == -3)
      {
        this.aUK = this.gnF.getOutputBuffers();
        return true;
      }
      ad.d("MicroMsg.TrackDataSource", "%s drain output buffer error outputIndex[%d] state:%s", new Object[] { info(), Integer.valueOf(this.biE), Integer.valueOf(this.state) });
      return false;
    }
    ad.d("MicroMsg.TrackDataSource", "%s process output buffer state:%s: index %d, cost:%s", new Object[] { info(), Integer.valueOf(this.state), Integer.valueOf(this.biE), Long.valueOf(bt.aS(l)) });
    synchronized (this.lock)
    {
      if (a(paramLong1, paramLong2, this.gnF, this.aUK[this.biE], this.biE, this.bin))
      {
        this.biE = -1;
        return true;
      }
    }
    return false;
  }
  
  private boolean tq()
  {
    try
    {
      ad.d("MicroMsg.TrackDataSource", "%s start to feed input buffer index %d [%d, %b]", new Object[] { info(), Integer.valueOf(this.biD), Integer.valueOf(this.state), Boolean.valueOf(this.tzV) });
      ad.d("MicroMsg.TrackDataSource", "doubleReleaseSwitch:[%b]", new Object[] { Boolean.valueOf(tAd) });
      if ((e.GD(this.state)) || (this.tzV))
      {
        ad.d("MicroMsg.TrackDataSource", "%s feed input buffer is end.", new Object[] { info() });
        return false;
      }
      if ((this.biD < 0) && (this.gnF != null))
      {
        this.biD = this.gnF.dequeueInputBuffer(0L);
        if (this.biD < 0)
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
    ??? = this.biB[this.biD];
    int j;
    if (this.tAa != null)
    {
      i = this.tAa.j((ByteBuffer)???);
      l1 = this.tAa.tzG.grd;
      j = this.tAa.tzG.hXP;
      ad.d("MicroMsg.TrackDataSource", "%s read data index[%d, %d] sample info[%d, %d]", new Object[] { info(), Integer.valueOf(this.biD), Integer.valueOf(i), Long.valueOf(l1), Integer.valueOf(j) });
      if (i <= 0)
      {
        if (tAd) {}
        for (;;)
        {
          synchronized (this.lock)
          {
            if (this.gnF != null) {
              this.gnF.a(this.biD, 0, 0L, 4);
            }
            this.tzV = true;
            return false;
          }
          this.gnF.a(this.biD, 0, 0L, 4);
        }
      }
      if (tAd) {}
      for (;;)
      {
        synchronized (this.lock)
        {
          if (this.gnF != null) {
            this.gnF.a(this.biD, i, l1, 0);
          }
          this.biD = -1;
          ??? = this.tAa;
          ((g)???).tzH += 1;
          if (((g)???).tzH >= ((g)???).tzI) {
            break;
          }
          ((g)???).tzG = ((m)((g)???).hXx.get(((g)???).tzH));
          ad.d("MicroMsg.Mp4Extractor", "curr sample [%s]", new Object[] { ((g)???).tzG });
          return false;
        }
        this.gnF.a(this.biD, i, l1, 0);
      }
    }
    if (this.tzT.tzQ)
    {
      if (tAd) {}
      for (;;)
      {
        synchronized (this.lock)
        {
          if (this.gnF != null) {
            this.gnF.a(this.biD, 0, this.bjp * 1000L, 4);
          }
          this.tzV = true;
          this.tzT.tzQ = false;
          return false;
        }
        this.gnF.a(this.biD, 0, this.bjp * 1000L, 4);
      }
    }
    for (;;)
    {
      try
      {
        i = this.cUM.j((ByteBuffer)???);
      }
      catch (Exception localException4)
      {
        l1 = 0L;
        i = 0;
        continue;
      }
      try
      {
        l1 = this.cUM.fGK.getSampleTime();
      }
      catch (Exception localException2)
      {
        l1 = 0L;
        continue;
      }
      try
      {
        j = this.cUM.fGK.getSampleFlags();
        ad.d("MicroMsg.TrackDataSource", "%s read data, state:%s index[%d, %d] sample info[%d, %d]", new Object[] { info(), Integer.valueOf(this.state), Integer.valueOf(this.biD), Integer.valueOf(i), Long.valueOf(l1), Integer.valueOf(j) });
        ak(j, l1);
        if (i > 0) {
          continue;
        }
        if (!tAd) {
          continue;
        }
      }
      catch (Exception localException3)
      {
        continue;
      }
      synchronized (this.lock)
      {
        if (this.gnF != null) {
          this.gnF.a(this.biD, 0, this.bjp * 1000L, 4);
        }
        this.tzV = true;
        return false;
        ad.printErrStackTrace("MicroMsg.TrackDataSource", (Throwable)???, "MediaExtractor get sample data error: %s", new Object[] { ((Exception)???).getMessage() });
        j = 0;
      }
      this.gnF.a(this.biD, 0, this.bjp * 1000L, 4);
    }
    if (tAd) {}
    for (;;)
    {
      long l2;
      long l3;
      synchronized (this.lock)
      {
        if (this.gnF != null) {
          this.gnF.a(this.biD, i, l1, 0);
        }
        this.biD = -1;
        this.cUM.fGK.advance();
        l2 = this.cUM.fGK.getSampleTime();
        if (this.tzT.oNQ) {
          break label1091;
        }
        if (Z(l1, l2))
        {
          ad.w("MicroMsg.TrackDataSource", "%s feed input buffer isOnlineVideo[%b] next[%d] onlineCacheMs[%d]", new Object[] { info(), Boolean.valueOf(this.tzT.oNQ), Long.valueOf(l2), Long.valueOf(this.tzX) });
          l3 = this.cUM.fGK.getSampleTime();
          if (Math.abs(l3 - l1) >= 1000000L)
          {
            ad.w("MicroMsg.TrackDataSource", "%s reset extractor finish but seek time is not right[%d, %d]", new Object[] { info(), Long.valueOf(l3), Long.valueOf(l1) });
            this.tzT.tzQ = true;
          }
        }
        ad.d("MicroMsg.TrackDataSource", "%s finish to feed input buffer [%d, %d]", new Object[] { info(), Long.valueOf(l1), Long.valueOf(l2) });
        return false;
      }
      this.gnF.a(this.biD, i, l1, 0);
      continue;
      label1091:
      if (this.tzX == 0L)
      {
        if (Z(l1, l2))
        {
          ad.w("MicroMsg.TrackDataSource", "%s feed input buffer next[%d] onlineCacheMs[%d]", new Object[] { info(), Long.valueOf(l2), Long.valueOf(this.tzX) });
          l3 = this.cUM.fGK.getSampleTime();
          if (Math.abs(l3 - l1) >= 3000000L)
          {
            ad.w("MicroMsg.TrackDataSource", "%s reset extractor finish but seek time is not right[%d, %d]", new Object[] { info(), Long.valueOf(l3), Long.valueOf(l1) });
            this.tzU.obtainMessage(5, -2, -2).sendToTarget();
          }
          cPq();
        }
      }
      else if ((l2 < 0L) || (l2 / 1000L + 1200L > this.tzX))
      {
        ad.w("MicroMsg.TrackDataSource", "%s feed input buffer next[%d] onlineCacheMs[%d]", new Object[] { info(), Long.valueOf(l2), Long.valueOf(this.tzX) });
        if (Z(l1, -1L)) {
          this.tzU.obtainMessage(5, -3, -3).sendToTarget();
        }
        cPq();
      }
    }
    return false;
  }
  
  public final long GH(int paramInt)
  {
    ad.i("MicroMsg.TrackDataSource", "%s start to seek to ms[%d] isFeedEnd[%b]", new Object[] { info(), Integer.valueOf(paramInt), Boolean.valueOf(this.tzV) });
    this.tzV = false;
    if (this.tAa != null) {}
    for (;;)
    {
      long l;
      int i;
      try
      {
        g localg = this.tAa;
        l = paramInt * 1000;
        i = 0;
        if (i < localg.hXy.size())
        {
          Pair localPair = (Pair)localg.hXy.get(i);
          if (l >= ((Long)localPair.second).longValue())
          {
            if (l != ((Long)localPair.second).longValue()) {
              break label681;
            }
            localg.tzH = ((Integer)localPair.first).intValue();
            localg.tzG = ((m)localg.hXx.get(localg.tzH));
            if (this.tAa.tzG.grd < 0L) {
              Z(paramInt * 1000L, -1L);
            }
            if (this.tAa.tzG.grd < 0L)
            {
              Z(0L, -1L);
              this.tzT.cPp();
            }
            l = this.tAa.tzG.grd;
            ad.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d]", new Object[] { info(), Long.valueOf(l) });
            return l / 1000L;
          }
        }
        if ((i == 0) || (i == localg.hXy.size() - 1))
        {
          localg.tzH = ((Integer)((Pair)localg.hXy.get(i)).first).intValue();
          localg.tzG = ((m)localg.hXx.get(localg.tzH));
          continue;
        }
        localException1.tzH = ((Integer)((Pair)localException1.hXy.get(i - 1)).first).intValue();
      }
      catch (Exception localException1)
      {
        ad.printErrStackTrace("MicroMsg.TrackDataSource", localException1, "%s extractor seek exception %s", new Object[] { info(), localException1.toString() });
        return 0L;
      }
      localException1.tzG = ((m)localException1.hXx.get(localException1.tzH));
      continue;
      try
      {
        this.cUM.seekTo(paramInt * 1000, 0);
        if (this.cUM.fGK.getSampleTime() < 0L) {
          Z(paramInt * 1000L, -1L);
        }
        if (this.cUM.fGK.getSampleTime() < 0L)
        {
          Z(0L, -1L);
          this.tzT.cPp();
        }
        l = this.cUM.fGK.getSampleTime();
        i = this.cUM.fGK.getSampleFlags();
        ad.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d, %d], sampleFlag:%s", new Object[] { info(), Long.valueOf(l), Long.valueOf(this.cUM.fGK.getCachedDuration()), Integer.valueOf(i) });
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
  protected final int Y(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc 115
    //   2: ldc_w 422
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
    //   44: getfield 158	com/tencent/mm/plugin/o/i:gnF	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   47: ifnull +31 -> 78
    //   50: aload_0
    //   51: lload_1
    //   52: lload_3
    //   53: invokespecial 424	com/tencent/mm/plugin/o/i:g	(JJ)Z
    //   56: ifeq +17 -> 73
    //   59: aload_0
    //   60: getfield 98	com/tencent/mm/plugin/o/i:state	I
    //   63: invokestatic 240	com/tencent/mm/plugin/o/e:GD	(I)Z
    //   66: istore 5
    //   68: iload 5
    //   70: ifeq -20 -> 50
    //   73: aload_0
    //   74: invokespecial 426	com/tencent/mm/plugin/o/i:tq	()Z
    //   77: pop
    //   78: ldc 115
    //   80: ldc_w 428
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
    //   115: getfield 90	com/tencent/mm/plugin/o/i:tAb	Z
    //   118: ifeq +131 -> 249
    //   121: ldc 115
    //   123: ldc_w 430
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
    //   141: invokevirtual 402	java/lang/Exception:toString	()Ljava/lang/String;
    //   144: aastore
    //   145: invokestatic 416	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   148: aload_0
    //   149: getfield 98	com/tencent/mm/plugin/o/i:state	I
    //   152: invokestatic 240	com/tencent/mm/plugin/o/e:GD	(I)Z
    //   155: ifne +7 -> 162
    //   158: aload_0
    //   159: invokevirtual 433	com/tencent/mm/plugin/o/i:cPr	()V
    //   162: aload_0
    //   163: getfield 94	com/tencent/mm/plugin/o/i:tzT	Lcom/tencent/mm/plugin/o/h;
    //   166: astore 6
    //   168: aload_0
    //   169: invokevirtual 436	com/tencent/mm/plugin/o/i:type	()Ljava/lang/String;
    //   172: astore 7
    //   174: aload 6
    //   176: getfield 439	com/tencent/mm/plugin/o/h:tzS	Z
    //   179: ifne -106 -> 73
    //   182: aload 6
    //   184: getfield 442	com/tencent/mm/plugin/o/h:tzP	Z
    //   187: ifeq -114 -> 73
    //   190: getstatic 448	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   193: ldc2_w 449
    //   196: ldc2_w 451
    //   199: lconst_1
    //   200: iconst_0
    //   201: invokevirtual 456	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   204: getstatic 448	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   207: sipush 13836
    //   210: iconst_3
    //   211: anewarray 4	java/lang/Object
    //   214: dup
    //   215: iconst_0
    //   216: sipush 506
    //   219: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   222: aastore
    //   223: dup
    //   224: iconst_1
    //   225: invokestatic 459	com/tencent/mm/sdk/platformtools/bt:aGK	()J
    //   228: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   231: aastore
    //   232: dup
    //   233: iconst_2
    //   234: aload 7
    //   236: aastore
    //   237: invokevirtual 463	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   240: aload 6
    //   242: iconst_1
    //   243: putfield 439	com/tencent/mm/plugin/o/h:tzS	Z
    //   246: goto -173 -> 73
    //   249: aload_0
    //   250: iconst_1
    //   251: putfield 90	com/tencent/mm/plugin/o/i:tAb	Z
    //   254: ldc 115
    //   256: aload 6
    //   258: ldc_w 465
    //   261: iconst_1
    //   262: anewarray 4	java/lang/Object
    //   265: dup
    //   266: iconst_0
    //   267: aload_0
    //   268: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   271: aastore
    //   272: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   275: goto -127 -> 148
    //   278: astore 6
    //   280: aload_0
    //   281: getfield 92	com/tencent/mm/plugin/o/i:tAc	Z
    //   284: ifeq +131 -> 415
    //   287: ldc 115
    //   289: ldc_w 467
    //   292: iconst_2
    //   293: anewarray 4	java/lang/Object
    //   296: dup
    //   297: iconst_0
    //   298: aload_0
    //   299: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   302: aastore
    //   303: dup
    //   304: iconst_1
    //   305: aload 6
    //   307: invokevirtual 402	java/lang/Exception:toString	()Ljava/lang/String;
    //   310: aastore
    //   311: invokestatic 416	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   314: aload_0
    //   315: getfield 98	com/tencent/mm/plugin/o/i:state	I
    //   318: invokestatic 240	com/tencent/mm/plugin/o/e:GD	(I)Z
    //   321: ifne +7 -> 328
    //   324: aload_0
    //   325: invokevirtual 433	com/tencent/mm/plugin/o/i:cPr	()V
    //   328: aload_0
    //   329: getfield 94	com/tencent/mm/plugin/o/i:tzT	Lcom/tencent/mm/plugin/o/h;
    //   332: astore 6
    //   334: aload_0
    //   335: invokevirtual 436	com/tencent/mm/plugin/o/i:type	()Ljava/lang/String;
    //   338: astore 7
    //   340: aload 6
    //   342: getfield 470	com/tencent/mm/plugin/o/h:tzR	Z
    //   345: ifne -267 -> 78
    //   348: aload 6
    //   350: getfield 442	com/tencent/mm/plugin/o/h:tzP	Z
    //   353: ifeq -275 -> 78
    //   356: getstatic 448	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   359: ldc2_w 449
    //   362: ldc2_w 471
    //   365: lconst_1
    //   366: iconst_0
    //   367: invokevirtual 456	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   370: getstatic 448	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   373: sipush 13836
    //   376: iconst_3
    //   377: anewarray 4	java/lang/Object
    //   380: dup
    //   381: iconst_0
    //   382: sipush 505
    //   385: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   388: aastore
    //   389: dup
    //   390: iconst_1
    //   391: invokestatic 459	com/tencent/mm/sdk/platformtools/bt:aGK	()J
    //   394: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   397: aastore
    //   398: dup
    //   399: iconst_2
    //   400: aload 7
    //   402: aastore
    //   403: invokevirtual 463	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   406: aload 6
    //   408: iconst_1
    //   409: putfield 470	com/tencent/mm/plugin/o/h:tzR	Z
    //   412: goto -334 -> 78
    //   415: aload_0
    //   416: iconst_1
    //   417: putfield 92	com/tencent/mm/plugin/o/i:tAc	Z
    //   420: ldc 115
    //   422: aload 6
    //   424: ldc_w 474
    //   427: iconst_1
    //   428: anewarray 4	java/lang/Object
    //   431: dup
    //   432: iconst_0
    //   433: aload_0
    //   434: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   437: aastore
    //   438: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   441: goto -127 -> 314
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	444	0	this	i
    //   0	444	1	paramLong1	long
    //   0	444	3	paramLong2	long
    //   66	3	5	bool	boolean
    //   112	28	6	localException1	Exception
    //   166	91	6	localh1	h
    //   278	28	6	localException2	Exception
    //   332	91	6	localh2	h
    //   172	229	7	str	String
    // Exception table:
    //   from	to	target	type
    //   50	68	112	java/lang/Exception
    //   73	78	278	java/lang/Exception
  }
  
  /* Error */
  protected final boolean Z(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: invokestatic 156	com/tencent/mm/sdk/platformtools/bt:GC	()J
    //   3: lstore 5
    //   5: lload_1
    //   6: ldc2_w 110
    //   9: ldiv
    //   10: ldc2_w 110
    //   13: ladd
    //   14: aload_0
    //   15: getfield 308	com/tencent/mm/plugin/o/i:bjp	J
    //   18: lcmp
    //   19: ifge +561 -> 580
    //   22: lload_3
    //   23: ldc2_w 368
    //   26: lcmp
    //   27: ifne +553 -> 580
    //   30: ldc 115
    //   32: ldc_w 478
    //   35: invokestatic 481	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: ldc_w 483
    //   41: invokestatic 489	com/tencent/mm/sdk/platformtools/ax:aFC	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/ax;
    //   44: astore 10
    //   46: aload_0
    //   47: instanceof 491
    //   50: ifeq +54 -> 104
    //   53: aload_0
    //   54: getfield 493	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   57: ifnonnull +388 -> 445
    //   60: ldc_w 495
    //   63: astore 9
    //   65: aload 10
    //   67: ldc_w 496
    //   70: aload 9
    //   72: invokevirtual 500	com/tencent/mm/sdk/platformtools/ax:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   75: pop
    //   76: aload 10
    //   78: ldc_w 501
    //   81: iconst_1
    //   82: invokevirtual 505	com/tencent/mm/sdk/platformtools/ax:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   85: pop
    //   86: aload 10
    //   88: ldc_w 507
    //   91: invokestatic 512	java/lang/System:currentTimeMillis	()J
    //   94: invokevirtual 516	com/tencent/mm/sdk/platformtools/ax:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   97: pop
    //   98: aload 10
    //   100: invokevirtual 519	com/tencent/mm/sdk/platformtools/ax:commit	()Z
    //   103: pop
    //   104: aload_0
    //   105: getfield 94	com/tencent/mm/plugin/o/i:tzT	Lcom/tencent/mm/plugin/o/h;
    //   108: iconst_1
    //   109: putfield 522	com/tencent/mm/plugin/o/h:oNP	Z
    //   112: aload_0
    //   113: iconst_0
    //   114: putfield 77	com/tencent/mm/plugin/o/i:tzV	Z
    //   117: aload_0
    //   118: getfield 134	com/tencent/mm/plugin/o/i:cUM	Lcom/tencent/mm/compatible/h/c;
    //   121: getfield 140	com/tencent/mm/compatible/h/c:fGK	Landroid/media/MediaExtractor;
    //   124: invokevirtual 525	android/media/MediaExtractor:release	()V
    //   127: aload_0
    //   128: new 136	com/tencent/mm/compatible/h/c
    //   131: dup
    //   132: invokespecial 526	com/tencent/mm/compatible/h/c:<init>	()V
    //   135: putfield 134	com/tencent/mm/plugin/o/i:cUM	Lcom/tencent/mm/compatible/h/c;
    //   138: aload_0
    //   139: getfield 493	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   142: invokestatic 530	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   145: ifne +437 -> 582
    //   148: aload_0
    //   149: getfield 493	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   152: iconst_0
    //   153: invokestatic 536	com/tencent/mm/vfs/i:cS	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   156: astore 9
    //   158: aload 9
    //   160: invokevirtual 542	java/io/RandomAccessFile:getFD	()Ljava/io/FileDescriptor;
    //   163: astore 11
    //   165: getstatic 548	com/tencent/mm/compatible/deviceinfo/ae:fFy	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   168: getfield 553	com/tencent/mm/compatible/deviceinfo/aa:fFr	I
    //   171: iconst_1
    //   172: if_icmpne +282 -> 454
    //   175: aload_0
    //   176: getfield 134	com/tencent/mm/plugin/o/i:cUM	Lcom/tencent/mm/compatible/h/c;
    //   179: aload 11
    //   181: lconst_0
    //   182: aload_0
    //   183: getfield 493	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   186: invokestatic 557	com/tencent/mm/vfs/i:aMN	(Ljava/lang/String;)J
    //   189: invokevirtual 561	com/tencent/mm/compatible/h/c:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   192: aload 9
    //   194: invokevirtual 564	java/io/RandomAccessFile:close	()V
    //   197: aload 10
    //   199: ldc_w 496
    //   202: ldc_w 495
    //   205: invokevirtual 568	com/tencent/mm/sdk/platformtools/ax:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   208: aload_0
    //   209: getfield 493	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   212: invokevirtual 574	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   215: ifeq +48 -> 263
    //   218: aload_0
    //   219: instanceof 491
    //   222: ifeq +41 -> 263
    //   225: aload 10
    //   227: ldc_w 501
    //   230: iconst_0
    //   231: invokevirtual 505	com/tencent/mm/sdk/platformtools/ax:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   234: pop
    //   235: aload 10
    //   237: ldc_w 496
    //   240: ldc_w 495
    //   243: invokevirtual 500	com/tencent/mm/sdk/platformtools/ax:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   246: pop
    //   247: aload 10
    //   249: ldc_w 507
    //   252: lconst_0
    //   253: invokevirtual 516	com/tencent/mm/sdk/platformtools/ax:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   256: pop
    //   257: aload 10
    //   259: invokevirtual 519	com/tencent/mm/sdk/platformtools/ax:commit	()Z
    //   262: pop
    //   263: aload_0
    //   264: getfield 134	com/tencent/mm/plugin/o/i:cUM	Lcom/tencent/mm/compatible/h/c;
    //   267: aload_0
    //   268: getfield 576	com/tencent/mm/plugin/o/i:trackIndex	I
    //   271: invokevirtual 579	com/tencent/mm/compatible/h/c:selectTrack	(I)V
    //   274: aload_0
    //   275: getfield 134	com/tencent/mm/plugin/o/i:cUM	Lcom/tencent/mm/compatible/h/c;
    //   278: lload_1
    //   279: iconst_2
    //   280: invokevirtual 406	com/tencent/mm/compatible/h/c:seekTo	(JI)V
    //   283: aload_0
    //   284: getfield 134	com/tencent/mm/plugin/o/i:cUM	Lcom/tencent/mm/compatible/h/c;
    //   287: getfield 140	com/tencent/mm/compatible/h/c:fGK	Landroid/media/MediaExtractor;
    //   290: invokevirtual 145	android/media/MediaExtractor:getSampleTime	()J
    //   293: lstore 7
    //   295: lload 7
    //   297: lload_1
    //   298: lsub
    //   299: invokestatic 342	java/lang/Math:abs	(J)J
    //   302: ldc2_w 351
    //   305: lcmp
    //   306: ifle +74 -> 380
    //   309: aload_0
    //   310: getfield 493	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   313: ifnull +67 -> 380
    //   316: aload_0
    //   317: getfield 493	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   320: ldc_w 581
    //   323: invokevirtual 585	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   326: ifeq +54 -> 380
    //   329: getstatic 448	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   332: sipush 150
    //   335: bipush 75
    //   337: invokevirtual 589	com/tencent/mm/plugin/report/service/h:dB	(II)V
    //   340: getstatic 448	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
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
    //   359: new 591	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 592	java/lang/StringBuilder:<init>	()V
    //   366: lload 7
    //   368: lload_1
    //   369: lsub
    //   370: invokevirtual 596	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   373: invokevirtual 597	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: aastore
    //   377: invokevirtual 463	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   380: ldc 115
    //   382: ldc_w 599
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
    //   422: getfield 81	com/tencent/mm/plugin/o/i:tzX	J
    //   425: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   428: aastore
    //   429: dup
    //   430: iconst_5
    //   431: lload 5
    //   433: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:aS	(J)J
    //   436: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   439: aastore
    //   440: invokestatic 337	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   443: iconst_1
    //   444: ireturn
    //   445: aload_0
    //   446: getfield 493	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   449: astore 9
    //   451: goto -386 -> 65
    //   454: aload_0
    //   455: getfield 134	com/tencent/mm/plugin/o/i:cUM	Lcom/tencent/mm/compatible/h/c;
    //   458: aload 11
    //   460: invokevirtual 602	com/tencent/mm/compatible/h/c:setDataSource	(Ljava/io/FileDescriptor;)V
    //   463: goto -271 -> 192
    //   466: astore 9
    //   468: ldc 115
    //   470: aload 9
    //   472: ldc_w 478
    //   475: iconst_0
    //   476: anewarray 4	java/lang/Object
    //   479: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   482: aload 10
    //   484: ldc_w 496
    //   487: ldc_w 495
    //   490: invokevirtual 568	com/tencent/mm/sdk/platformtools/ax:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   493: aload_0
    //   494: getfield 493	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   497: invokevirtual 574	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   500: ifeq -237 -> 263
    //   503: aload_0
    //   504: instanceof 491
    //   507: ifeq -244 -> 263
    //   510: aload 10
    //   512: ldc_w 501
    //   515: iconst_0
    //   516: invokevirtual 505	com/tencent/mm/sdk/platformtools/ax:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   519: pop
    //   520: aload 10
    //   522: ldc_w 496
    //   525: ldc_w 495
    //   528: invokevirtual 500	com/tencent/mm/sdk/platformtools/ax:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   531: pop
    //   532: aload 10
    //   534: ldc_w 507
    //   537: lconst_0
    //   538: invokevirtual 516	com/tencent/mm/sdk/platformtools/ax:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   541: pop
    //   542: aload 10
    //   544: invokevirtual 519	com/tencent/mm/sdk/platformtools/ax:commit	()Z
    //   547: pop
    //   548: goto -285 -> 263
    //   551: astore 9
    //   553: ldc 115
    //   555: ldc_w 604
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
    //   573: invokevirtual 402	java/lang/Exception:toString	()Ljava/lang/String;
    //   576: aastore
    //   577: invokestatic 416	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   580: iconst_0
    //   581: ireturn
    //   582: aload_0
    //   583: getfield 606	com/tencent/mm/plugin/o/i:fd	Ljava/io/FileDescriptor;
    //   586: ifnull -389 -> 197
    //   589: aload_0
    //   590: getfield 606	com/tencent/mm/plugin/o/i:fd	Ljava/io/FileDescriptor;
    //   593: invokevirtual 611	java/io/FileDescriptor:valid	()Z
    //   596: ifeq -399 -> 197
    //   599: aload_0
    //   600: getfield 134	com/tencent/mm/plugin/o/i:cUM	Lcom/tencent/mm/compatible/h/c;
    //   603: aload_0
    //   604: getfield 606	com/tencent/mm/plugin/o/i:fd	Ljava/io/FileDescriptor;
    //   607: aload_0
    //   608: getfield 613	com/tencent/mm/plugin/o/i:bjw	J
    //   611: aload_0
    //   612: getfield 615	com/tencent/mm/plugin/o/i:length	J
    //   615: invokevirtual 561	com/tencent/mm/compatible/h/c:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   618: goto -421 -> 197
    //   621: astore 9
    //   623: aload 10
    //   625: ldc_w 496
    //   628: ldc_w 495
    //   631: invokevirtual 568	com/tencent/mm/sdk/platformtools/ax:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   634: aload_0
    //   635: getfield 493	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   638: invokevirtual 574	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   641: ifeq +48 -> 689
    //   644: aload_0
    //   645: instanceof 491
    //   648: ifeq +41 -> 689
    //   651: aload 10
    //   653: ldc_w 501
    //   656: iconst_0
    //   657: invokevirtual 505	com/tencent/mm/sdk/platformtools/ax:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   660: pop
    //   661: aload 10
    //   663: ldc_w 496
    //   666: ldc_w 495
    //   669: invokevirtual 500	com/tencent/mm/sdk/platformtools/ax:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   672: pop
    //   673: aload 10
    //   675: ldc_w 507
    //   678: lconst_0
    //   679: invokevirtual 516	com/tencent/mm/sdk/platformtools/ax:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   682: pop
    //   683: aload 10
    //   685: invokevirtual 519	com/tencent/mm/sdk/platformtools/ax:commit	()Z
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
    this.bjw = paramLong1;
    this.length = paramLong2;
  }
  
  abstract boolean a(long paramLong1, long paramLong2, z paramz, ByteBuffer paramByteBuffer, int paramInt, MediaCodec.BufferInfo paramBufferInfo);
  
  abstract boolean a(z paramz);
  
  protected boolean ak(int paramInt, long paramLong)
  {
    return false;
  }
  
  protected void b(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    ad.i("MicroMsg.TrackDataSource", "%s found media format mime[%s] track[%d] format[%s]", new Object[] { info(), paramString, Integer.valueOf(paramInt), paramMediaFormat });
    this.trackIndex = paramInt;
    this.mime = paramString;
    this.bjp = (paramMediaFormat.getLong("durationUs") / 1000L);
    this.tzY = paramMediaFormat;
  }
  
  public final void cPr()
  {
    ad.i("MicroMsg.TrackDataSource", "%s flush codec", new Object[] { info() });
    this.biE = -1;
    this.biD = -1;
    try
    {
      z localz;
      if (this.gnF != null) {
        localz = this.gnF;
      }
      try
      {
        if (!localz.cBX) {
          ad.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy flush not alive");
        }
        MediaCodecProxyUtils.b.lc(96);
        localz.fEQ.flush();
        MediaCodecProxyUtils.b.lc(97);
        return;
      }
      catch (Exception localException2)
      {
        ad.printErrStackTrace("MicroMsg.MediaCodecProxy", localException2, "MediaCodecProxy flush, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
        MediaCodecProxyUtils.b.lc(39);
        localz.fES.getAndIncrement();
        throw localException2;
      }
      return;
    }
    catch (Exception localException1)
    {
      ad.printErrStackTrace("MicroMsg.TrackDataSource", localException1, "flushCodec exception", new Object[0]);
    }
  }
  
  protected final boolean cPs()
  {
    try
    {
      ad.i("MicroMsg.TrackDataSource", "%s start to prepare decoder mime[%s]", new Object[] { info(), this.mime });
      this.gnF = z.pl(this.mime);
      a(this.gnF);
      this.gnF.start();
      this.biB = this.gnF.getInputBuffers();
      this.aUK = this.gnF.getOutputBuffers();
      return true;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.TrackDataSource", localException, "%s prepare decoder init decoder error ", new Object[] { info() });
      this.tzT.agY(type());
    }
    return false;
  }
  
  protected final MediaFormat cPt()
  {
    if ((this.cUM == null) || (this.trackIndex < 0)) {
      return this.tzY;
    }
    return this.cUM.getTrackFormat(this.trackIndex);
  }
  
  /* Error */
  public final boolean cuQ()
  {
    // Byte code:
    //   0: ldc 115
    //   2: ldc_w 701
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
    //   19: getfield 493	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   22: aastore
    //   23: invokestatic 172	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: invokestatic 156	com/tencent/mm/sdk/platformtools/bt:GC	()J
    //   29: lstore 5
    //   31: ldc_w 483
    //   34: invokestatic 489	com/tencent/mm/sdk/platformtools/ax:aFC	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/ax;
    //   37: astore 10
    //   39: aload_0
    //   40: iconst_0
    //   41: putfield 77	com/tencent/mm/plugin/o/i:tzV	Z
    //   44: ldc 115
    //   46: ldc_w 703
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
    //   68: invokespecial 526	com/tencent/mm/compatible/h/c:<init>	()V
    //   71: putfield 134	com/tencent/mm/plugin/o/i:cUM	Lcom/tencent/mm/compatible/h/c;
    //   74: aload_0
    //   75: instanceof 491
    //   78: ifeq +54 -> 132
    //   81: aload_0
    //   82: getfield 493	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   85: ifnonnull +300 -> 385
    //   88: ldc_w 495
    //   91: astore 9
    //   93: aload 10
    //   95: ldc_w 496
    //   98: aload 9
    //   100: invokevirtual 500	com/tencent/mm/sdk/platformtools/ax:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   103: pop
    //   104: aload 10
    //   106: ldc_w 501
    //   109: iconst_1
    //   110: invokevirtual 505	com/tencent/mm/sdk/platformtools/ax:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   113: pop
    //   114: aload 10
    //   116: ldc_w 507
    //   119: invokestatic 512	java/lang/System:currentTimeMillis	()J
    //   122: invokevirtual 516	com/tencent/mm/sdk/platformtools/ax:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   125: pop
    //   126: aload 10
    //   128: invokevirtual 519	com/tencent/mm/sdk/platformtools/ax:commit	()Z
    //   131: pop
    //   132: aload_0
    //   133: getfield 493	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   136: invokestatic 530	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   139: ifne +372 -> 511
    //   142: aload_0
    //   143: getfield 493	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   146: iconst_0
    //   147: invokestatic 536	com/tencent/mm/vfs/i:cS	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   150: astore 9
    //   152: aload_0
    //   153: aload 9
    //   155: invokevirtual 542	java/io/RandomAccessFile:getFD	()Ljava/io/FileDescriptor;
    //   158: putfield 606	com/tencent/mm/plugin/o/i:fd	Ljava/io/FileDescriptor;
    //   161: getstatic 548	com/tencent/mm/compatible/deviceinfo/ae:fFy	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   164: getfield 553	com/tencent/mm/compatible/deviceinfo/aa:fFr	I
    //   167: iconst_1
    //   168: if_icmpne +226 -> 394
    //   171: aload_0
    //   172: getfield 134	com/tencent/mm/plugin/o/i:cUM	Lcom/tencent/mm/compatible/h/c;
    //   175: aload_0
    //   176: getfield 606	com/tencent/mm/plugin/o/i:fd	Ljava/io/FileDescriptor;
    //   179: lconst_0
    //   180: aload_0
    //   181: getfield 493	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   184: invokestatic 557	com/tencent/mm/vfs/i:aMN	(Ljava/lang/String;)J
    //   187: invokevirtual 561	com/tencent/mm/compatible/h/c:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   190: aload 9
    //   192: invokevirtual 564	java/io/RandomAccessFile:close	()V
    //   195: aload_0
    //   196: getfield 134	com/tencent/mm/plugin/o/i:cUM	Lcom/tencent/mm/compatible/h/c;
    //   199: getfield 140	com/tencent/mm/compatible/h/c:fGK	Landroid/media/MediaExtractor;
    //   202: invokevirtual 706	android/media/MediaExtractor:getTrackCount	()I
    //   205: istore_2
    //   206: aload_0
    //   207: iconst_m1
    //   208: putfield 576	com/tencent/mm/plugin/o/i:trackIndex	I
    //   211: iconst_0
    //   212: istore_1
    //   213: iload_1
    //   214: iload_2
    //   215: if_icmpge +49 -> 264
    //   218: aload_0
    //   219: getfield 134	com/tencent/mm/plugin/o/i:cUM	Lcom/tencent/mm/compatible/h/c;
    //   222: iload_1
    //   223: invokevirtual 698	com/tencent/mm/compatible/h/c:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   226: astore 9
    //   228: aload 9
    //   230: ldc_w 707
    //   233: invokevirtual 710	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   236: astore 11
    //   238: aload 11
    //   240: ifnull +419 -> 659
    //   243: aload 11
    //   245: aload_0
    //   246: invokevirtual 436	com/tencent/mm/plugin/o/i:type	()Ljava/lang/String;
    //   249: invokevirtual 585	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   252: ifeq +407 -> 659
    //   255: aload_0
    //   256: aload 9
    //   258: aload 11
    //   260: iload_1
    //   261: invokevirtual 712	com/tencent/mm/plugin/o/i:b	(Landroid/media/MediaFormat;Ljava/lang/String;I)V
    //   264: aload_0
    //   265: getfield 576	com/tencent/mm/plugin/o/i:trackIndex	I
    //   268: ifge +398 -> 666
    //   271: ldc 115
    //   273: ldc_w 714
    //   276: iconst_3
    //   277: anewarray 4	java/lang/Object
    //   280: dup
    //   281: iconst_0
    //   282: aload_0
    //   283: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   286: aastore
    //   287: dup
    //   288: iconst_1
    //   289: iload_2
    //   290: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   293: aastore
    //   294: dup
    //   295: iconst_2
    //   296: aload_0
    //   297: getfield 576	com/tencent/mm/plugin/o/i:trackIndex	I
    //   300: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   303: aastore
    //   304: invokestatic 337	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   307: aload_0
    //   308: getfield 94	com/tencent/mm/plugin/o/i:tzT	Lcom/tencent/mm/plugin/o/h;
    //   311: ldc_w 716
    //   314: invokevirtual 719	com/tencent/mm/plugin/o/h:agX	(Ljava/lang/String;)V
    //   317: aload 10
    //   319: ldc_w 496
    //   322: ldc_w 495
    //   325: invokevirtual 568	com/tencent/mm/sdk/platformtools/ax:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   328: aload_0
    //   329: getfield 493	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   332: invokevirtual 574	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   335: ifeq +48 -> 383
    //   338: aload_0
    //   339: instanceof 491
    //   342: ifeq +41 -> 383
    //   345: aload 10
    //   347: ldc_w 501
    //   350: iconst_0
    //   351: invokevirtual 505	com/tencent/mm/sdk/platformtools/ax:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   354: pop
    //   355: aload 10
    //   357: ldc_w 496
    //   360: ldc_w 495
    //   363: invokevirtual 500	com/tencent/mm/sdk/platformtools/ax:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   366: pop
    //   367: aload 10
    //   369: ldc_w 507
    //   372: lconst_0
    //   373: invokevirtual 516	com/tencent/mm/sdk/platformtools/ax:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   376: pop
    //   377: aload 10
    //   379: invokevirtual 519	com/tencent/mm/sdk/platformtools/ax:commit	()Z
    //   382: pop
    //   383: iconst_0
    //   384: ireturn
    //   385: aload_0
    //   386: getfield 493	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   389: astore 9
    //   391: goto -298 -> 93
    //   394: aload_0
    //   395: getfield 134	com/tencent/mm/plugin/o/i:cUM	Lcom/tencent/mm/compatible/h/c;
    //   398: aload_0
    //   399: getfield 606	com/tencent/mm/plugin/o/i:fd	Ljava/io/FileDescriptor;
    //   402: invokevirtual 602	com/tencent/mm/compatible/h/c:setDataSource	(Ljava/io/FileDescriptor;)V
    //   405: goto -215 -> 190
    //   408: astore 9
    //   410: ldc 115
    //   412: aload 9
    //   414: ldc_w 721
    //   417: iconst_1
    //   418: anewarray 4	java/lang/Object
    //   421: dup
    //   422: iconst_0
    //   423: aload_0
    //   424: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   427: aastore
    //   428: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   431: aload_0
    //   432: getfield 94	com/tencent/mm/plugin/o/i:tzT	Lcom/tencent/mm/plugin/o/h;
    //   435: aload 9
    //   437: invokevirtual 402	java/lang/Exception:toString	()Ljava/lang/String;
    //   440: invokevirtual 719	com/tencent/mm/plugin/o/h:agX	(Ljava/lang/String;)V
    //   443: aload 10
    //   445: ldc_w 496
    //   448: ldc_w 495
    //   451: invokevirtual 568	com/tencent/mm/sdk/platformtools/ax:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   454: aload_0
    //   455: getfield 493	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   458: invokevirtual 574	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   461: ifeq +48 -> 509
    //   464: aload_0
    //   465: instanceof 491
    //   468: ifeq +41 -> 509
    //   471: aload 10
    //   473: ldc_w 501
    //   476: iconst_0
    //   477: invokevirtual 505	com/tencent/mm/sdk/platformtools/ax:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   480: pop
    //   481: aload 10
    //   483: ldc_w 496
    //   486: ldc_w 495
    //   489: invokevirtual 500	com/tencent/mm/sdk/platformtools/ax:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   492: pop
    //   493: aload 10
    //   495: ldc_w 507
    //   498: lconst_0
    //   499: invokevirtual 516	com/tencent/mm/sdk/platformtools/ax:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   502: pop
    //   503: aload 10
    //   505: invokevirtual 519	com/tencent/mm/sdk/platformtools/ax:commit	()Z
    //   508: pop
    //   509: iconst_0
    //   510: ireturn
    //   511: aload_0
    //   512: getfield 606	com/tencent/mm/plugin/o/i:fd	Ljava/io/FileDescriptor;
    //   515: ifnull -320 -> 195
    //   518: aload_0
    //   519: getfield 606	com/tencent/mm/plugin/o/i:fd	Ljava/io/FileDescriptor;
    //   522: invokevirtual 611	java/io/FileDescriptor:valid	()Z
    //   525: ifeq -330 -> 195
    //   528: aload_0
    //   529: getfield 134	com/tencent/mm/plugin/o/i:cUM	Lcom/tencent/mm/compatible/h/c;
    //   532: aload_0
    //   533: getfield 606	com/tencent/mm/plugin/o/i:fd	Ljava/io/FileDescriptor;
    //   536: aload_0
    //   537: getfield 613	com/tencent/mm/plugin/o/i:bjw	J
    //   540: aload_0
    //   541: getfield 615	com/tencent/mm/plugin/o/i:length	J
    //   544: invokevirtual 561	com/tencent/mm/compatible/h/c:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   547: goto -352 -> 195
    //   550: astore 9
    //   552: ldc 115
    //   554: ldc_w 723
    //   557: iconst_2
    //   558: anewarray 4	java/lang/Object
    //   561: dup
    //   562: iconst_0
    //   563: aload_0
    //   564: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   567: aastore
    //   568: dup
    //   569: iconst_1
    //   570: aload 9
    //   572: invokevirtual 724	java/lang/Throwable:toString	()Ljava/lang/String;
    //   575: aastore
    //   576: invokestatic 416	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   579: aload_0
    //   580: getfield 94	com/tencent/mm/plugin/o/i:tzT	Lcom/tencent/mm/plugin/o/h;
    //   583: aload 9
    //   585: invokevirtual 724	java/lang/Throwable:toString	()Ljava/lang/String;
    //   588: invokevirtual 719	com/tencent/mm/plugin/o/h:agX	(Ljava/lang/String;)V
    //   591: aload 10
    //   593: ldc_w 496
    //   596: ldc_w 495
    //   599: invokevirtual 568	com/tencent/mm/sdk/platformtools/ax:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   602: aload_0
    //   603: getfield 493	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   606: invokevirtual 574	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   609: ifeq +48 -> 657
    //   612: aload_0
    //   613: instanceof 491
    //   616: ifeq +41 -> 657
    //   619: aload 10
    //   621: ldc_w 501
    //   624: iconst_0
    //   625: invokevirtual 505	com/tencent/mm/sdk/platformtools/ax:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   628: pop
    //   629: aload 10
    //   631: ldc_w 496
    //   634: ldc_w 495
    //   637: invokevirtual 500	com/tencent/mm/sdk/platformtools/ax:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   640: pop
    //   641: aload 10
    //   643: ldc_w 507
    //   646: lconst_0
    //   647: invokevirtual 516	com/tencent/mm/sdk/platformtools/ax:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   650: pop
    //   651: aload 10
    //   653: invokevirtual 519	com/tencent/mm/sdk/platformtools/ax:commit	()Z
    //   656: pop
    //   657: iconst_0
    //   658: ireturn
    //   659: iload_1
    //   660: iconst_1
    //   661: iadd
    //   662: istore_1
    //   663: goto -450 -> 213
    //   666: aload_0
    //   667: getfield 134	com/tencent/mm/plugin/o/i:cUM	Lcom/tencent/mm/compatible/h/c;
    //   670: aload_0
    //   671: getfield 576	com/tencent/mm/plugin/o/i:trackIndex	I
    //   674: invokevirtual 579	com/tencent/mm/compatible/h/c:selectTrack	(I)V
    //   677: aload_0
    //   678: getfield 493	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   681: invokestatic 530	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   684: ifne +8 -> 692
    //   687: aload_0
    //   688: aconst_null
    //   689: putfield 258	com/tencent/mm/plugin/o/i:tAa	Lcom/tencent/mm/plugin/o/g;
    //   692: invokestatic 156	com/tencent/mm/sdk/platformtools/bt:GC	()J
    //   695: lstore 7
    //   697: aload 10
    //   699: ldc_w 496
    //   702: ldc_w 495
    //   705: invokevirtual 568	com/tencent/mm/sdk/platformtools/ax:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   708: aload_0
    //   709: getfield 493	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   712: invokevirtual 574	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   715: ifeq +48 -> 763
    //   718: aload_0
    //   719: instanceof 491
    //   722: ifeq +41 -> 763
    //   725: aload 10
    //   727: ldc_w 501
    //   730: iconst_0
    //   731: invokevirtual 505	com/tencent/mm/sdk/platformtools/ax:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   734: pop
    //   735: aload 10
    //   737: ldc_w 496
    //   740: ldc_w 495
    //   743: invokevirtual 500	com/tencent/mm/sdk/platformtools/ax:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   746: pop
    //   747: aload 10
    //   749: ldc_w 507
    //   752: lconst_0
    //   753: invokevirtual 516	com/tencent/mm/sdk/platformtools/ax:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   756: pop
    //   757: aload 10
    //   759: invokevirtual 519	com/tencent/mm/sdk/platformtools/ax:commit	()Z
    //   762: pop
    //   763: ldc 115
    //   765: ldc_w 726
    //   768: iconst_3
    //   769: anewarray 4	java/lang/Object
    //   772: dup
    //   773: iconst_0
    //   774: aload_0
    //   775: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   778: aastore
    //   779: dup
    //   780: iconst_1
    //   781: aload_0
    //   782: getfield 622	com/tencent/mm/plugin/o/i:mime	Ljava/lang/String;
    //   785: aastore
    //   786: dup
    //   787: iconst_2
    //   788: aload_0
    //   789: getfield 98	com/tencent/mm/plugin/o/i:state	I
    //   792: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   795: aastore
    //   796: invokestatic 172	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   799: aload_0
    //   800: getfield 98	com/tencent/mm/plugin/o/i:state	I
    //   803: invokestatic 240	com/tencent/mm/plugin/o/e:GD	(I)Z
    //   806: ifne +303 -> 1109
    //   809: aload_0
    //   810: getfield 88	com/tencent/mm/plugin/o/i:lock	Ljava/lang/Object;
    //   813: astore 9
    //   815: aload 9
    //   817: monitorenter
    //   818: ldc 115
    //   820: ldc_w 728
    //   823: iconst_2
    //   824: anewarray 4	java/lang/Object
    //   827: dup
    //   828: iconst_0
    //   829: aload_0
    //   830: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   833: aastore
    //   834: dup
    //   835: iconst_1
    //   836: aload_0
    //   837: getfield 203	com/tencent/mm/plugin/o/i:tzY	Landroid/media/MediaFormat;
    //   840: aastore
    //   841: invokestatic 151	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   844: aload_0
    //   845: aload_0
    //   846: getfield 622	com/tencent/mm/plugin/o/i:mime	Ljava/lang/String;
    //   849: invokestatic 679	com/tencent/mm/compatible/deviceinfo/z:pl	(Ljava/lang/String;)Lcom/tencent/mm/compatible/deviceinfo/z;
    //   852: putfield 158	com/tencent/mm/plugin/o/i:gnF	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   855: aload_0
    //   856: aload_0
    //   857: getfield 158	com/tencent/mm/plugin/o/i:gnF	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   860: invokevirtual 681	com/tencent/mm/plugin/o/i:a	(Lcom/tencent/mm/compatible/deviceinfo/z;)Z
    //   863: pop
    //   864: aload_0
    //   865: getfield 158	com/tencent/mm/plugin/o/i:gnF	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   868: invokevirtual 684	com/tencent/mm/compatible/deviceinfo/z:start	()V
    //   871: aload_0
    //   872: aload_0
    //   873: getfield 158	com/tencent/mm/plugin/o/i:gnF	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   876: invokevirtual 687	com/tencent/mm/compatible/deviceinfo/z:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   879: putfield 256	com/tencent/mm/plugin/o/i:biB	[Ljava/nio/ByteBuffer;
    //   882: aload_0
    //   883: aload_0
    //   884: getfield 158	com/tencent/mm/plugin/o/i:gnF	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   887: invokevirtual 210	com/tencent/mm/compatible/deviceinfo/z:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   890: putfield 178	com/tencent/mm/plugin/o/i:aUK	[Ljava/nio/ByteBuffer;
    //   893: aload 9
    //   895: monitorexit
    //   896: invokestatic 156	com/tencent/mm/sdk/platformtools/bt:GC	()J
    //   899: lstore_3
    //   900: aload_0
    //   901: iconst_1
    //   902: invokevirtual 176	com/tencent/mm/plugin/o/i:setState	(I)V
    //   905: ldc 115
    //   907: ldc_w 730
    //   910: iconst_4
    //   911: anewarray 4	java/lang/Object
    //   914: dup
    //   915: iconst_0
    //   916: aload_0
    //   917: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   920: aastore
    //   921: dup
    //   922: iconst_1
    //   923: lload 5
    //   925: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:aS	(J)J
    //   928: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   931: aastore
    //   932: dup
    //   933: iconst_2
    //   934: lload 7
    //   936: lload 5
    //   938: lsub
    //   939: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   942: aastore
    //   943: dup
    //   944: iconst_3
    //   945: lload_3
    //   946: lload 5
    //   948: lsub
    //   949: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   952: aastore
    //   953: invokestatic 172	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   956: iconst_1
    //   957: ireturn
    //   958: astore 9
    //   960: aload 10
    //   962: ldc_w 496
    //   965: ldc_w 495
    //   968: invokevirtual 568	com/tencent/mm/sdk/platformtools/ax:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   971: aload_0
    //   972: getfield 493	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   975: invokevirtual 574	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   978: ifeq +48 -> 1026
    //   981: aload_0
    //   982: instanceof 491
    //   985: ifeq +41 -> 1026
    //   988: aload 10
    //   990: ldc_w 501
    //   993: iconst_0
    //   994: invokevirtual 505	com/tencent/mm/sdk/platformtools/ax:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   997: pop
    //   998: aload 10
    //   1000: ldc_w 496
    //   1003: ldc_w 495
    //   1006: invokevirtual 500	com/tencent/mm/sdk/platformtools/ax:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   1009: pop
    //   1010: aload 10
    //   1012: ldc_w 507
    //   1015: lconst_0
    //   1016: invokevirtual 516	com/tencent/mm/sdk/platformtools/ax:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   1019: pop
    //   1020: aload 10
    //   1022: invokevirtual 519	com/tencent/mm/sdk/platformtools/ax:commit	()Z
    //   1025: pop
    //   1026: aload 9
    //   1028: athrow
    //   1029: astore 10
    //   1031: aload 9
    //   1033: monitorexit
    //   1034: aload 10
    //   1036: athrow
    //   1037: astore 9
    //   1039: ldc 115
    //   1041: aload 9
    //   1043: ldc_w 732
    //   1046: iconst_2
    //   1047: anewarray 4	java/lang/Object
    //   1050: dup
    //   1051: iconst_0
    //   1052: aload_0
    //   1053: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   1056: aastore
    //   1057: dup
    //   1058: iconst_1
    //   1059: aload 9
    //   1061: invokevirtual 402	java/lang/Exception:toString	()Ljava/lang/String;
    //   1064: aastore
    //   1065: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1068: ldc 115
    //   1070: aload 9
    //   1072: ldc_w 734
    //   1075: iconst_2
    //   1076: anewarray 4	java/lang/Object
    //   1079: dup
    //   1080: iconst_0
    //   1081: aload_0
    //   1082: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   1085: aastore
    //   1086: dup
    //   1087: iconst_1
    //   1088: aload_0
    //   1089: getfield 203	com/tencent/mm/plugin/o/i:tzY	Landroid/media/MediaFormat;
    //   1092: aastore
    //   1093: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1096: aload_0
    //   1097: getfield 94	com/tencent/mm/plugin/o/i:tzT	Lcom/tencent/mm/plugin/o/h;
    //   1100: aload_0
    //   1101: invokevirtual 436	com/tencent/mm/plugin/o/i:type	()Ljava/lang/String;
    //   1104: invokevirtual 693	com/tencent/mm/plugin/o/h:agY	(Ljava/lang/String;)V
    //   1107: iconst_0
    //   1108: ireturn
    //   1109: lconst_0
    //   1110: lstore_3
    //   1111: goto -211 -> 900
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1114	0	this	i
    //   212	451	1	i	int
    //   205	85	2	j	int
    //   899	212	3	l1	long
    //   29	918	5	l2	long
    //   695	240	7	l3	long
    //   91	299	9	localObject1	Object
    //   408	28	9	localException1	Exception
    //   550	34	9	localThrowable	Throwable
    //   958	74	9	localObject3	Object
    //   1037	34	9	localException2	Exception
    //   37	984	10	localax	com.tencent.mm.sdk.platformtools.ax
    //   1029	6	10	localObject4	Object
    //   236	23	11	str	String
    // Exception table:
    //   from	to	target	type
    //   44	88	408	java/lang/Exception
    //   93	132	408	java/lang/Exception
    //   132	190	408	java/lang/Exception
    //   190	195	408	java/lang/Exception
    //   195	211	408	java/lang/Exception
    //   218	238	408	java/lang/Exception
    //   243	264	408	java/lang/Exception
    //   264	317	408	java/lang/Exception
    //   385	391	408	java/lang/Exception
    //   394	405	408	java/lang/Exception
    //   511	547	408	java/lang/Exception
    //   666	692	408	java/lang/Exception
    //   692	697	408	java/lang/Exception
    //   44	88	550	java/lang/Throwable
    //   93	132	550	java/lang/Throwable
    //   132	190	550	java/lang/Throwable
    //   190	195	550	java/lang/Throwable
    //   195	211	550	java/lang/Throwable
    //   218	238	550	java/lang/Throwable
    //   243	264	550	java/lang/Throwable
    //   264	317	550	java/lang/Throwable
    //   385	391	550	java/lang/Throwable
    //   394	405	550	java/lang/Throwable
    //   511	547	550	java/lang/Throwable
    //   666	692	550	java/lang/Throwable
    //   692	697	550	java/lang/Throwable
    //   44	88	958	finally
    //   93	132	958	finally
    //   132	190	958	finally
    //   190	195	958	finally
    //   195	211	958	finally
    //   218	238	958	finally
    //   243	264	958	finally
    //   264	317	958	finally
    //   385	391	958	finally
    //   394	405	958	finally
    //   410	443	958	finally
    //   511	547	958	finally
    //   552	591	958	finally
    //   666	692	958	finally
    //   692	697	958	finally
    //   818	896	1029	finally
    //   1031	1034	1029	finally
    //   763	818	1037	java/lang/Exception
    //   896	900	1037	java/lang/Exception
    //   1034	1037	1037	java/lang/Exception
  }
  
  public final String info()
  {
    if (this.tzT != null) {
      return type() + "_" + this.tzT.info() + "_" + Process.myTid();
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
    ad.i("MicroMsg.TrackDataSource", "release doubleReleaseSwitch:[%b]", new Object[] { Boolean.valueOf(tAd) });
    if (tAd)
    {
      ad.i("MicroMsg.TrackDataSource", "%s into release fun", new Object[] { info() });
      if (this.cUM != null)
      {
        ad.i("MicroMsg.TrackDataSource", "%s release,  extractor != null", new Object[] { info() });
        this.cUM.fGK.release();
        this.cUM = null;
      }
      releaseDecoder();
      if (this.tAa != null)
      {
        ad.i("MicroMsg.TrackDataSource", "%s release,  mp4Extractor != null", new Object[] { info() });
        this.tAa.release();
      }
      ad.i("MicroMsg.TrackDataSource", "%s finish release", new Object[] { info() });
      return;
    }
    ad.i("MicroMsg.TrackDataSource", "%s release", new Object[] { info() });
    if (this.cUM != null)
    {
      this.cUM.fGK.release();
      this.cUM = null;
    }
    if (this.gnF != null)
    {
      this.gnF.release();
      this.gnF = null;
    }
    if (this.tAa != null) {
      this.tAa.release();
    }
    ad.i("MicroMsg.TrackDataSource", "%s finish release", new Object[] { info() });
  }
  
  /* Error */
  protected final void releaseDecoder()
  {
    // Byte code:
    //   0: ldc 115
    //   2: ldc_w 769
    //   5: iconst_1
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: getstatic 68	com/tencent/mm/plugin/o/i:tAd	Z
    //   14: invokestatic 232	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   17: aastore
    //   18: invokestatic 172	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   21: getstatic 68	com/tencent/mm/plugin/o/i:tAd	Z
    //   24: ifeq +227 -> 251
    //   27: invokestatic 156	com/tencent/mm/sdk/platformtools/bt:GC	()J
    //   30: lstore_1
    //   31: aload_0
    //   32: getfield 88	com/tencent/mm/plugin/o/i:lock	Ljava/lang/Object;
    //   35: astore_3
    //   36: aload_3
    //   37: monitorenter
    //   38: aload_0
    //   39: getfield 158	com/tencent/mm/plugin/o/i:gnF	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   42: ifnull +187 -> 229
    //   45: ldc 115
    //   47: ldc_w 771
    //   50: iconst_1
    //   51: anewarray 4	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: aload_0
    //   57: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   60: aastore
    //   61: invokestatic 172	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: aload_0
    //   65: invokevirtual 433	com/tencent/mm/plugin/o/i:cPr	()V
    //   68: aload_0
    //   69: aconst_null
    //   70: putfield 178	com/tencent/mm/plugin/o/i:aUK	[Ljava/nio/ByteBuffer;
    //   73: aload_0
    //   74: aconst_null
    //   75: putfield 256	com/tencent/mm/plugin/o/i:biB	[Ljava/nio/ByteBuffer;
    //   78: ldc 115
    //   80: ldc_w 773
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
    //   97: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:aS	(J)J
    //   100: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   103: aastore
    //   104: invokestatic 172	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   107: aload_0
    //   108: getfield 158	com/tencent/mm/plugin/o/i:gnF	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   111: invokevirtual 776	com/tencent/mm/compatible/deviceinfo/z:stop	()V
    //   114: aload_0
    //   115: getfield 158	com/tencent/mm/plugin/o/i:gnF	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   118: invokevirtual 767	com/tencent/mm/compatible/deviceinfo/z:release	()V
    //   121: aload_0
    //   122: aconst_null
    //   123: putfield 158	com/tencent/mm/plugin/o/i:gnF	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   126: ldc 115
    //   128: ldc_w 778
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
    //   145: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:aS	(J)J
    //   148: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   151: aastore
    //   152: invokestatic 172	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload_3
    //   156: monitorexit
    //   157: return
    //   158: astore 4
    //   160: aload_0
    //   161: aconst_null
    //   162: putfield 158	com/tencent/mm/plugin/o/i:gnF	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   165: aload 4
    //   167: athrow
    //   168: astore 4
    //   170: aload_3
    //   171: monitorexit
    //   172: aload 4
    //   174: athrow
    //   175: astore 4
    //   177: aload_0
    //   178: getfield 158	com/tencent/mm/plugin/o/i:gnF	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   181: invokevirtual 767	com/tencent/mm/compatible/deviceinfo/z:release	()V
    //   184: aload_0
    //   185: aconst_null
    //   186: putfield 158	com/tencent/mm/plugin/o/i:gnF	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   189: goto -63 -> 126
    //   192: astore 4
    //   194: aload_0
    //   195: aconst_null
    //   196: putfield 158	com/tencent/mm/plugin/o/i:gnF	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   199: aload 4
    //   201: athrow
    //   202: astore 4
    //   204: aload_0
    //   205: getfield 158	com/tencent/mm/plugin/o/i:gnF	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   208: invokevirtual 767	com/tencent/mm/compatible/deviceinfo/z:release	()V
    //   211: aload_0
    //   212: aconst_null
    //   213: putfield 158	com/tencent/mm/plugin/o/i:gnF	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   216: aload 4
    //   218: athrow
    //   219: astore 4
    //   221: aload_0
    //   222: aconst_null
    //   223: putfield 158	com/tencent/mm/plugin/o/i:gnF	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   226: aload 4
    //   228: athrow
    //   229: ldc 115
    //   231: ldc_w 780
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
    //   252: getfield 158	com/tencent/mm/plugin/o/i:gnF	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   255: ifnull +198 -> 453
    //   258: ldc 115
    //   260: ldc_w 771
    //   263: iconst_1
    //   264: anewarray 4	java/lang/Object
    //   267: dup
    //   268: iconst_0
    //   269: aload_0
    //   270: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   273: aastore
    //   274: invokestatic 172	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   277: aload_0
    //   278: invokevirtual 433	com/tencent/mm/plugin/o/i:cPr	()V
    //   281: aload_0
    //   282: aconst_null
    //   283: putfield 178	com/tencent/mm/plugin/o/i:aUK	[Ljava/nio/ByteBuffer;
    //   286: aload_0
    //   287: aconst_null
    //   288: putfield 256	com/tencent/mm/plugin/o/i:biB	[Ljava/nio/ByteBuffer;
    //   291: invokestatic 156	com/tencent/mm/sdk/platformtools/bt:GC	()J
    //   294: lstore_1
    //   295: aload_0
    //   296: getfield 88	com/tencent/mm/plugin/o/i:lock	Ljava/lang/Object;
    //   299: astore_3
    //   300: aload_3
    //   301: monitorenter
    //   302: ldc 115
    //   304: ldc_w 773
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
    //   321: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:aS	(J)J
    //   324: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   327: aastore
    //   328: invokestatic 172	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   331: aload_0
    //   332: getfield 158	com/tencent/mm/plugin/o/i:gnF	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   335: invokevirtual 776	com/tencent/mm/compatible/deviceinfo/z:stop	()V
    //   338: aload_0
    //   339: getfield 158	com/tencent/mm/plugin/o/i:gnF	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   342: invokevirtual 767	com/tencent/mm/compatible/deviceinfo/z:release	()V
    //   345: aload_0
    //   346: aconst_null
    //   347: putfield 158	com/tencent/mm/plugin/o/i:gnF	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   350: aload_3
    //   351: monitorexit
    //   352: ldc 115
    //   354: ldc_w 778
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
    //   371: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:aS	(J)J
    //   374: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   377: aastore
    //   378: invokestatic 172	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   381: return
    //   382: astore 4
    //   384: aload_0
    //   385: aconst_null
    //   386: putfield 158	com/tencent/mm/plugin/o/i:gnF	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   389: aload 4
    //   391: athrow
    //   392: astore 4
    //   394: aload_3
    //   395: monitorexit
    //   396: aload 4
    //   398: athrow
    //   399: astore 4
    //   401: aload_0
    //   402: getfield 158	com/tencent/mm/plugin/o/i:gnF	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   405: invokevirtual 767	com/tencent/mm/compatible/deviceinfo/z:release	()V
    //   408: aload_0
    //   409: aconst_null
    //   410: putfield 158	com/tencent/mm/plugin/o/i:gnF	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   413: goto -63 -> 350
    //   416: astore 4
    //   418: aload_0
    //   419: aconst_null
    //   420: putfield 158	com/tencent/mm/plugin/o/i:gnF	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   423: aload 4
    //   425: athrow
    //   426: astore 4
    //   428: aload_0
    //   429: getfield 158	com/tencent/mm/plugin/o/i:gnF	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   432: invokevirtual 767	com/tencent/mm/compatible/deviceinfo/z:release	()V
    //   435: aload_0
    //   436: aconst_null
    //   437: putfield 158	com/tencent/mm/plugin/o/i:gnF	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   440: aload 4
    //   442: athrow
    //   443: astore 4
    //   445: aload_0
    //   446: aconst_null
    //   447: putfield 158	com/tencent/mm/plugin/o/i:gnF	Lcom/tencent/mm/compatible/deviceinfo/z;
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
    this.tzV = false;
    setState(3);
    onStart();
  }
  
  abstract String type();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.o.i
 * JD-Core Version:    0.7.0.1
 */