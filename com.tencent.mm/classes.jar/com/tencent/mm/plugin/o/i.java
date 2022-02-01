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
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.FileDescriptor;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class i
{
  private static long uIA;
  private static boolean uIz;
  private ByteBuffer[] aVy;
  private MediaCodec.BufferInfo biS = new MediaCodec.BufferInfo();
  long bjU;
  private ByteBuffer[] bjg;
  private int bji;
  private int bjj;
  protected long bkb;
  private c cSi;
  protected FileDescriptor fd;
  protected z gOr;
  protected long length;
  private volatile Object lock = new Object();
  private String mime;
  protected String path;
  protected volatile int state;
  private int trackIndex;
  protected h uIq;
  protected ao uIr;
  private volatile boolean uIs = false;
  b uIt = null;
  protected long uIu = 0L;
  MediaFormat uIv;
  private g uIw;
  private boolean uIx = false;
  private boolean uIy = false;
  
  static
  {
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pTK, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      uIz = bool;
      uIA = 0L;
      return;
    }
  }
  
  public i(h paramh, ao paramao)
  {
    this.uIq = paramh;
    this.uIr = paramao;
    this.state = 0;
    this.bji = -1;
    this.bjj = -1;
  }
  
  private void dcZ()
  {
    if (this.uIt != null) {
      this.uIu = (this.uIt.dcT() * 1000L);
    }
  }
  
  private boolean g(long paramLong1, long paramLong2)
  {
    ac.d("MicroMsg.TrackDataSource", "%s drain output buffer state:%s time[%d %d %s] index %d", new Object[] { info(), Integer.valueOf(this.state), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(this.cSi.fKr.getSampleTime()), Integer.valueOf(this.bjj) });
    long l = bs.Gn();
    if (this.bjj < 0)
    {
      synchronized (this.lock)
      {
        this.bjj = this.gOr.dequeueOutputBuffer(this.biS, uIA);
        if (this.bjj < 0) {
          break label259;
        }
        if ((this.biS.flags & 0x4) != 0)
        {
          ac.i("MicroMsg.TrackDataSource", "%s process end of stream", new Object[] { info() });
          setState(9);
          this.bjj = -1;
          return false;
        }
      }
      ??? = this.aVy[this.bjj];
      if (??? != null)
      {
        ((ByteBuffer)???).position(this.biS.offset);
        ((ByteBuffer)???).limit(this.biS.offset + this.biS.size);
      }
    }
    if (this.state == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.gOr.releaseOutputBuffer(this.bjj, true);
      this.bjj = -1;
      setState(2);
      return true;
      label259:
      if (this.bjj == -2)
      {
        ??? = this.gOr.getOutputFormat();
        this.uIv = ((MediaFormat)???);
        a(this.gOr, (MediaFormat)???);
        return true;
      }
      if (this.bjj == -3)
      {
        this.aVy = this.gOr.getOutputBuffers();
        return true;
      }
      ac.d("MicroMsg.TrackDataSource", "%s drain output buffer error outputIndex[%d] state:%s", new Object[] { info(), Integer.valueOf(this.bjj), Integer.valueOf(this.state) });
      return false;
    }
    ac.d("MicroMsg.TrackDataSource", "%s process output buffer state:%s: index %d, cost:%s", new Object[] { info(), Integer.valueOf(this.state), Integer.valueOf(this.bjj), Long.valueOf(bs.aO(l)) });
    synchronized (this.lock)
    {
      if (a(paramLong1, paramLong2, this.gOr, this.aVy[this.bjj], this.bjj, this.biS))
      {
        this.bjj = -1;
        return true;
      }
    }
    return false;
  }
  
  private boolean ty()
  {
    try
    {
      ac.d("MicroMsg.TrackDataSource", "%s start to feed input buffer index %d [%d, %b]", new Object[] { info(), Integer.valueOf(this.bji), Integer.valueOf(this.state), Boolean.valueOf(this.uIs) });
      ac.d("MicroMsg.TrackDataSource", "doubleReleaseSwitch:[%b]", new Object[] { Boolean.valueOf(uIz) });
      if ((e.Iz(this.state)) || (this.uIs))
      {
        ac.d("MicroMsg.TrackDataSource", "%s feed input buffer is end.", new Object[] { info() });
        return false;
      }
      if ((this.bji < 0) && (this.gOr != null))
      {
        this.bji = this.gOr.dequeueInputBuffer(0L);
        if (this.bji < 0)
        {
          ac.d("MicroMsg.TrackDataSource", "%s can not dequeue effect input buffer, state:%s", new Object[] { info(), Integer.valueOf(this.state) });
          return false;
        }
      }
    }
    catch (Exception localException1)
    {
      ac.printErrStackTrace("MicroMsg.TrackDataSource", localException1, "feedInputBuffer exception", new Object[0]);
      return false;
    }
    ??? = this.bjg[this.bji];
    int j;
    if (this.uIw != null)
    {
      i = this.uIw.j((ByteBuffer)???);
      l1 = this.uIw.uId.gRL;
      j = this.uIw.uId.ixT;
      ac.d("MicroMsg.TrackDataSource", "%s read data index[%d, %d] sample info[%d, %d]", new Object[] { info(), Integer.valueOf(this.bji), Integer.valueOf(i), Long.valueOf(l1), Integer.valueOf(j) });
      if (i <= 0)
      {
        if (uIz) {}
        for (;;)
        {
          synchronized (this.lock)
          {
            if (this.gOr != null) {
              this.gOr.a(this.bji, 0, 0L, 4);
            }
            this.uIs = true;
            return false;
          }
          this.gOr.a(this.bji, 0, 0L, 4);
        }
      }
      if (uIz) {}
      for (;;)
      {
        synchronized (this.lock)
        {
          if (this.gOr != null) {
            this.gOr.a(this.bji, i, l1, 0);
          }
          this.bji = -1;
          ??? = this.uIw;
          ((g)???).uIe += 1;
          if (((g)???).uIe >= ((g)???).uIf) {
            break;
          }
          ((g)???).uId = ((n)((g)???).ixB.get(((g)???).uIe));
          ac.d("MicroMsg.Mp4Extractor", "curr sample [%s]", new Object[] { ((g)???).uId });
          return false;
        }
        this.gOr.a(this.bji, i, l1, 0);
      }
    }
    if (this.uIq.uIn)
    {
      if (uIz) {}
      for (;;)
      {
        synchronized (this.lock)
        {
          if (this.gOr != null) {
            this.gOr.a(this.bji, 0, this.bjU * 1000L, 4);
          }
          this.uIs = true;
          this.uIq.uIn = false;
          return false;
        }
        this.gOr.a(this.bji, 0, this.bjU * 1000L, 4);
      }
    }
    for (;;)
    {
      try
      {
        i = this.cSi.j((ByteBuffer)???);
      }
      catch (Exception localException4)
      {
        l1 = 0L;
        i = 0;
        continue;
      }
      try
      {
        l1 = this.cSi.fKr.getSampleTime();
      }
      catch (Exception localException2)
      {
        l1 = 0L;
        continue;
      }
      try
      {
        j = this.cSi.fKr.getSampleFlags();
        ac.d("MicroMsg.TrackDataSource", "%s read data, state:%s index[%d, %d] sample info[%d, %d]", new Object[] { info(), Integer.valueOf(this.state), Integer.valueOf(this.bji), Integer.valueOf(i), Long.valueOf(l1), Integer.valueOf(j) });
        ai(j, l1);
        if (i > 0) {
          continue;
        }
        if (!uIz) {
          continue;
        }
      }
      catch (Exception localException3)
      {
        continue;
      }
      synchronized (this.lock)
      {
        if (this.gOr != null) {
          this.gOr.a(this.bji, 0, this.bjU * 1000L, 4);
        }
        this.uIs = true;
        return false;
        ac.printErrStackTrace("MicroMsg.TrackDataSource", (Throwable)???, "MediaExtractor get sample data error: %s", new Object[] { ((Exception)???).getMessage() });
        j = 0;
      }
      this.gOr.a(this.bji, 0, this.bjU * 1000L, 4);
    }
    if (uIz) {}
    for (;;)
    {
      long l2;
      long l3;
      synchronized (this.lock)
      {
        if (this.gOr != null) {
          this.gOr.a(this.bji, i, l1, 0);
        }
        this.bji = -1;
        this.cSi.fKr.advance();
        l2 = this.cSi.fKr.getSampleTime();
        if (this.uIq.prk) {
          break label1091;
        }
        if (W(l1, l2))
        {
          ac.w("MicroMsg.TrackDataSource", "%s feed input buffer isOnlineVideo[%b] next[%d] onlineCacheMs[%d]", new Object[] { info(), Boolean.valueOf(this.uIq.prk), Long.valueOf(l2), Long.valueOf(this.uIu) });
          l3 = this.cSi.fKr.getSampleTime();
          if (Math.abs(l3 - l1) >= 1000000L)
          {
            ac.w("MicroMsg.TrackDataSource", "%s reset extractor finish but seek time is not right[%d, %d]", new Object[] { info(), Long.valueOf(l3), Long.valueOf(l1) });
            this.uIq.uIn = true;
          }
        }
        ac.d("MicroMsg.TrackDataSource", "%s finish to feed input buffer [%d, %d]", new Object[] { info(), Long.valueOf(l1), Long.valueOf(l2) });
        return false;
      }
      this.gOr.a(this.bji, i, l1, 0);
      continue;
      label1091:
      if (this.uIu == 0L)
      {
        if (W(l1, l2))
        {
          ac.w("MicroMsg.TrackDataSource", "%s feed input buffer next[%d] onlineCacheMs[%d]", new Object[] { info(), Long.valueOf(l2), Long.valueOf(this.uIu) });
          l3 = this.cSi.fKr.getSampleTime();
          if (Math.abs(l3 - l1) >= 3000000L)
          {
            ac.w("MicroMsg.TrackDataSource", "%s reset extractor finish but seek time is not right[%d, %d]", new Object[] { info(), Long.valueOf(l3), Long.valueOf(l1) });
            this.uIr.obtainMessage(5, -2, -2).sendToTarget();
          }
          dcZ();
        }
      }
      else if ((l2 < 0L) || (l2 / 1000L + 1200L > this.uIu))
      {
        ac.w("MicroMsg.TrackDataSource", "%s feed input buffer next[%d] onlineCacheMs[%d]", new Object[] { info(), Long.valueOf(l2), Long.valueOf(this.uIu) });
        if (W(l1, -1L)) {
          this.uIr.obtainMessage(5, -3, -3).sendToTarget();
        }
        dcZ();
      }
    }
    return false;
  }
  
  public final long ID(int paramInt)
  {
    ac.i("MicroMsg.TrackDataSource", "%s start to seek to ms[%d] isFeedEnd[%b]", new Object[] { info(), Integer.valueOf(paramInt), Boolean.valueOf(this.uIs) });
    this.uIs = false;
    if (this.uIw != null) {}
    for (;;)
    {
      long l;
      int i;
      try
      {
        g localg = this.uIw;
        l = paramInt * 1000;
        i = 0;
        if (i < localg.ixC.size())
        {
          Pair localPair = (Pair)localg.ixC.get(i);
          if (l >= ((Long)localPair.second).longValue())
          {
            if (l != ((Long)localPair.second).longValue()) {
              break label681;
            }
            localg.uIe = ((Integer)localPair.first).intValue();
            localg.uId = ((n)localg.ixB.get(localg.uIe));
            if (this.uIw.uId.gRL < 0L) {
              W(paramInt * 1000L, -1L);
            }
            if (this.uIw.uId.gRL < 0L)
            {
              W(0L, -1L);
              this.uIq.dcY();
            }
            l = this.uIw.uId.gRL;
            ac.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d]", new Object[] { info(), Long.valueOf(l) });
            return l / 1000L;
          }
        }
        if ((i == 0) || (i == localg.ixC.size() - 1))
        {
          localg.uIe = ((Integer)((Pair)localg.ixC.get(i)).first).intValue();
          localg.uId = ((n)localg.ixB.get(localg.uIe));
          continue;
        }
        localException1.uIe = ((Integer)((Pair)localException1.ixC.get(i - 1)).first).intValue();
      }
      catch (Exception localException1)
      {
        ac.printErrStackTrace("MicroMsg.TrackDataSource", localException1, "%s extractor seek exception %s", new Object[] { info(), localException1.toString() });
        return 0L;
      }
      localException1.uId = ((n)localException1.ixB.get(localException1.uIe));
      continue;
      try
      {
        this.cSi.seekTo(paramInt * 1000, 0);
        if (this.cSi.fKr.getSampleTime() < 0L) {
          W(paramInt * 1000L, -1L);
        }
        if (this.cSi.fKr.getSampleTime() < 0L)
        {
          W(0L, -1L);
          this.uIq.dcY();
        }
        l = this.cSi.fKr.getSampleTime();
        i = this.cSi.fKr.getSampleFlags();
        ac.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d, %d], sampleFlag:%s", new Object[] { info(), Long.valueOf(l), Long.valueOf(this.cSi.fKr.getCachedDuration()), Integer.valueOf(i) });
        if ((i & 0x1) == 0) {
          ac.e("MicroMsg.TrackDataSource", "%s seek error, not in keyframe!!", new Object[] { info() });
        }
        if ((l == 0L) && (paramInt > 0)) {
          ac.e("MicroMsg.TrackDataSource", "%s seek error, not seek to %s", new Object[] { Integer.valueOf(paramInt * 1000), info() });
        }
        l /= 1000L;
        return l;
      }
      catch (Exception localException2)
      {
        ac.printErrStackTrace("MicroMsg.TrackDataSource", localException2, "%s extractor seek exception %s", new Object[] { info(), localException2.toString() });
        return 0L;
      }
      label681:
      i += 1;
    }
  }
  
  /* Error */
  protected final int V(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc 115
    //   2: ldc_w 423
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
    //   40: invokestatic 151	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: aload_0
    //   44: getfield 158	com/tencent/mm/plugin/o/i:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   47: ifnull +31 -> 78
    //   50: aload_0
    //   51: lload_1
    //   52: lload_3
    //   53: invokespecial 425	com/tencent/mm/plugin/o/i:g	(JJ)Z
    //   56: ifeq +17 -> 73
    //   59: aload_0
    //   60: getfield 98	com/tencent/mm/plugin/o/i:state	I
    //   63: invokestatic 240	com/tencent/mm/plugin/o/e:Iz	(I)Z
    //   66: istore 5
    //   68: iload 5
    //   70: ifeq -20 -> 50
    //   73: aload_0
    //   74: invokespecial 427	com/tencent/mm/plugin/o/i:ty	()Z
    //   77: pop
    //   78: ldc 115
    //   80: ldc_w 429
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
    //   104: invokestatic 151	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   107: aload_0
    //   108: getfield 98	com/tencent/mm/plugin/o/i:state	I
    //   111: ireturn
    //   112: astore 6
    //   114: aload_0
    //   115: getfield 90	com/tencent/mm/plugin/o/i:uIx	Z
    //   118: ifeq +131 -> 249
    //   121: ldc 115
    //   123: ldc_w 431
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
    //   141: invokevirtual 403	java/lang/Exception:toString	()Ljava/lang/String;
    //   144: aastore
    //   145: invokestatic 417	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   148: aload_0
    //   149: getfield 98	com/tencent/mm/plugin/o/i:state	I
    //   152: invokestatic 240	com/tencent/mm/plugin/o/e:Iz	(I)Z
    //   155: ifne +7 -> 162
    //   158: aload_0
    //   159: invokevirtual 434	com/tencent/mm/plugin/o/i:dda	()V
    //   162: aload_0
    //   163: getfield 94	com/tencent/mm/plugin/o/i:uIq	Lcom/tencent/mm/plugin/o/h;
    //   166: astore 6
    //   168: aload_0
    //   169: invokevirtual 437	com/tencent/mm/plugin/o/i:type	()Ljava/lang/String;
    //   172: astore 7
    //   174: aload 6
    //   176: getfield 440	com/tencent/mm/plugin/o/h:uIp	Z
    //   179: ifne -106 -> 73
    //   182: aload 6
    //   184: getfield 443	com/tencent/mm/plugin/o/h:uIm	Z
    //   187: ifeq -114 -> 73
    //   190: getstatic 449	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   193: ldc2_w 450
    //   196: ldc2_w 452
    //   199: lconst_1
    //   200: iconst_0
    //   201: invokevirtual 457	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   204: getstatic 449	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
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
    //   225: invokestatic 460	com/tencent/mm/sdk/platformtools/bs:aNx	()J
    //   228: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   231: aastore
    //   232: dup
    //   233: iconst_2
    //   234: aload 7
    //   236: aastore
    //   237: invokevirtual 464	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   240: aload 6
    //   242: iconst_1
    //   243: putfield 440	com/tencent/mm/plugin/o/h:uIp	Z
    //   246: goto -173 -> 73
    //   249: aload_0
    //   250: iconst_1
    //   251: putfield 90	com/tencent/mm/plugin/o/i:uIx	Z
    //   254: ldc 115
    //   256: aload 6
    //   258: ldc_w 466
    //   261: iconst_1
    //   262: anewarray 4	java/lang/Object
    //   265: dup
    //   266: iconst_0
    //   267: aload_0
    //   268: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   271: aastore
    //   272: invokestatic 254	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   275: goto -127 -> 148
    //   278: astore 6
    //   280: aload_0
    //   281: getfield 92	com/tencent/mm/plugin/o/i:uIy	Z
    //   284: ifeq +131 -> 415
    //   287: ldc 115
    //   289: ldc_w 468
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
    //   307: invokevirtual 403	java/lang/Exception:toString	()Ljava/lang/String;
    //   310: aastore
    //   311: invokestatic 417	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   314: aload_0
    //   315: getfield 98	com/tencent/mm/plugin/o/i:state	I
    //   318: invokestatic 240	com/tencent/mm/plugin/o/e:Iz	(I)Z
    //   321: ifne +7 -> 328
    //   324: aload_0
    //   325: invokevirtual 434	com/tencent/mm/plugin/o/i:dda	()V
    //   328: aload_0
    //   329: getfield 94	com/tencent/mm/plugin/o/i:uIq	Lcom/tencent/mm/plugin/o/h;
    //   332: astore 6
    //   334: aload_0
    //   335: invokevirtual 437	com/tencent/mm/plugin/o/i:type	()Ljava/lang/String;
    //   338: astore 7
    //   340: aload 6
    //   342: getfield 471	com/tencent/mm/plugin/o/h:uIo	Z
    //   345: ifne -267 -> 78
    //   348: aload 6
    //   350: getfield 443	com/tencent/mm/plugin/o/h:uIm	Z
    //   353: ifeq -275 -> 78
    //   356: getstatic 449	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   359: ldc2_w 450
    //   362: ldc2_w 472
    //   365: lconst_1
    //   366: iconst_0
    //   367: invokevirtual 457	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   370: getstatic 449	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
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
    //   391: invokestatic 460	com/tencent/mm/sdk/platformtools/bs:aNx	()J
    //   394: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   397: aastore
    //   398: dup
    //   399: iconst_2
    //   400: aload 7
    //   402: aastore
    //   403: invokevirtual 464	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   406: aload 6
    //   408: iconst_1
    //   409: putfield 471	com/tencent/mm/plugin/o/h:uIo	Z
    //   412: goto -334 -> 78
    //   415: aload_0
    //   416: iconst_1
    //   417: putfield 92	com/tencent/mm/plugin/o/i:uIy	Z
    //   420: ldc 115
    //   422: aload 6
    //   424: ldc_w 475
    //   427: iconst_1
    //   428: anewarray 4	java/lang/Object
    //   431: dup
    //   432: iconst_0
    //   433: aload_0
    //   434: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   437: aastore
    //   438: invokestatic 254	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  protected final boolean W(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: invokestatic 156	com/tencent/mm/sdk/platformtools/bs:Gn	()J
    //   3: lstore 5
    //   5: lload_1
    //   6: ldc2_w 110
    //   9: ldiv
    //   10: ldc2_w 110
    //   13: ladd
    //   14: aload_0
    //   15: getfield 308	com/tencent/mm/plugin/o/i:bjU	J
    //   18: lcmp
    //   19: ifge +561 -> 580
    //   22: lload_3
    //   23: ldc2_w 369
    //   26: lcmp
    //   27: ifne +553 -> 580
    //   30: ldc 115
    //   32: ldc_w 479
    //   35: invokestatic 482	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: ldc_w 484
    //   41: invokestatic 490	com/tencent/mm/sdk/platformtools/aw:aKT	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/aw;
    //   44: astore 10
    //   46: aload_0
    //   47: instanceof 492
    //   50: ifeq +54 -> 104
    //   53: aload_0
    //   54: getfield 494	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   57: ifnonnull +388 -> 445
    //   60: ldc_w 496
    //   63: astore 9
    //   65: aload 10
    //   67: ldc_w 497
    //   70: aload 9
    //   72: invokevirtual 501	com/tencent/mm/sdk/platformtools/aw:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   75: pop
    //   76: aload 10
    //   78: ldc_w 502
    //   81: iconst_1
    //   82: invokevirtual 506	com/tencent/mm/sdk/platformtools/aw:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   85: pop
    //   86: aload 10
    //   88: ldc_w 508
    //   91: invokestatic 513	java/lang/System:currentTimeMillis	()J
    //   94: invokevirtual 517	com/tencent/mm/sdk/platformtools/aw:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   97: pop
    //   98: aload 10
    //   100: invokevirtual 520	com/tencent/mm/sdk/platformtools/aw:commit	()Z
    //   103: pop
    //   104: aload_0
    //   105: getfield 94	com/tencent/mm/plugin/o/i:uIq	Lcom/tencent/mm/plugin/o/h;
    //   108: iconst_1
    //   109: putfield 523	com/tencent/mm/plugin/o/h:prj	Z
    //   112: aload_0
    //   113: iconst_0
    //   114: putfield 77	com/tencent/mm/plugin/o/i:uIs	Z
    //   117: aload_0
    //   118: getfield 134	com/tencent/mm/plugin/o/i:cSi	Lcom/tencent/mm/compatible/h/c;
    //   121: getfield 140	com/tencent/mm/compatible/h/c:fKr	Landroid/media/MediaExtractor;
    //   124: invokevirtual 526	android/media/MediaExtractor:release	()V
    //   127: aload_0
    //   128: new 136	com/tencent/mm/compatible/h/c
    //   131: dup
    //   132: invokespecial 527	com/tencent/mm/compatible/h/c:<init>	()V
    //   135: putfield 134	com/tencent/mm/plugin/o/i:cSi	Lcom/tencent/mm/compatible/h/c;
    //   138: aload_0
    //   139: getfield 494	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   142: invokestatic 531	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   145: ifne +437 -> 582
    //   148: aload_0
    //   149: getfield 494	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   152: iconst_0
    //   153: invokestatic 537	com/tencent/mm/vfs/i:cY	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   156: astore 9
    //   158: aload 9
    //   160: invokevirtual 543	java/io/RandomAccessFile:getFD	()Ljava/io/FileDescriptor;
    //   163: astore 11
    //   165: getstatic 549	com/tencent/mm/compatible/deviceinfo/ae:fJf	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   168: getfield 554	com/tencent/mm/compatible/deviceinfo/aa:fIY	I
    //   171: iconst_1
    //   172: if_icmpne +282 -> 454
    //   175: aload_0
    //   176: getfield 134	com/tencent/mm/plugin/o/i:cSi	Lcom/tencent/mm/compatible/h/c;
    //   179: aload 11
    //   181: lconst_0
    //   182: aload_0
    //   183: getfield 494	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   186: invokestatic 558	com/tencent/mm/vfs/i:aSp	(Ljava/lang/String;)J
    //   189: invokevirtual 562	com/tencent/mm/compatible/h/c:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   192: aload 9
    //   194: invokevirtual 565	java/io/RandomAccessFile:close	()V
    //   197: aload 10
    //   199: ldc_w 497
    //   202: ldc_w 496
    //   205: invokevirtual 569	com/tencent/mm/sdk/platformtools/aw:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   208: aload_0
    //   209: getfield 494	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   212: invokevirtual 575	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   215: ifeq +48 -> 263
    //   218: aload_0
    //   219: instanceof 492
    //   222: ifeq +41 -> 263
    //   225: aload 10
    //   227: ldc_w 502
    //   230: iconst_0
    //   231: invokevirtual 506	com/tencent/mm/sdk/platformtools/aw:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   234: pop
    //   235: aload 10
    //   237: ldc_w 497
    //   240: ldc_w 496
    //   243: invokevirtual 501	com/tencent/mm/sdk/platformtools/aw:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   246: pop
    //   247: aload 10
    //   249: ldc_w 508
    //   252: lconst_0
    //   253: invokevirtual 517	com/tencent/mm/sdk/platformtools/aw:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   256: pop
    //   257: aload 10
    //   259: invokevirtual 520	com/tencent/mm/sdk/platformtools/aw:commit	()Z
    //   262: pop
    //   263: aload_0
    //   264: getfield 134	com/tencent/mm/plugin/o/i:cSi	Lcom/tencent/mm/compatible/h/c;
    //   267: aload_0
    //   268: getfield 577	com/tencent/mm/plugin/o/i:trackIndex	I
    //   271: invokevirtual 580	com/tencent/mm/compatible/h/c:selectTrack	(I)V
    //   274: aload_0
    //   275: getfield 134	com/tencent/mm/plugin/o/i:cSi	Lcom/tencent/mm/compatible/h/c;
    //   278: lload_1
    //   279: iconst_2
    //   280: invokevirtual 407	com/tencent/mm/compatible/h/c:seekTo	(JI)V
    //   283: aload_0
    //   284: getfield 134	com/tencent/mm/plugin/o/i:cSi	Lcom/tencent/mm/compatible/h/c;
    //   287: getfield 140	com/tencent/mm/compatible/h/c:fKr	Landroid/media/MediaExtractor;
    //   290: invokevirtual 145	android/media/MediaExtractor:getSampleTime	()J
    //   293: lstore 7
    //   295: lload 7
    //   297: lload_1
    //   298: lsub
    //   299: invokestatic 343	java/lang/Math:abs	(J)J
    //   302: ldc2_w 352
    //   305: lcmp
    //   306: ifle +74 -> 380
    //   309: aload_0
    //   310: getfield 494	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   313: ifnull +67 -> 380
    //   316: aload_0
    //   317: getfield 494	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   320: ldc_w 582
    //   323: invokevirtual 586	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   326: ifeq +54 -> 380
    //   329: getstatic 449	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   332: sipush 150
    //   335: bipush 75
    //   337: invokevirtual 590	com/tencent/mm/plugin/report/service/h:dB	(II)V
    //   340: getstatic 449	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
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
    //   359: new 592	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 593	java/lang/StringBuilder:<init>	()V
    //   366: lload 7
    //   368: lload_1
    //   369: lsub
    //   370: invokevirtual 597	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   373: invokevirtual 598	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: aastore
    //   377: invokevirtual 464	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   380: ldc 115
    //   382: ldc_w 600
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
    //   422: getfield 81	com/tencent/mm/plugin/o/i:uIu	J
    //   425: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   428: aastore
    //   429: dup
    //   430: iconst_5
    //   431: lload 5
    //   433: invokestatic 218	com/tencent/mm/sdk/platformtools/bs:aO	(J)J
    //   436: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   439: aastore
    //   440: invokestatic 338	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   443: iconst_1
    //   444: ireturn
    //   445: aload_0
    //   446: getfield 494	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   449: astore 9
    //   451: goto -386 -> 65
    //   454: aload_0
    //   455: getfield 134	com/tencent/mm/plugin/o/i:cSi	Lcom/tencent/mm/compatible/h/c;
    //   458: aload 11
    //   460: invokevirtual 603	com/tencent/mm/compatible/h/c:setDataSource	(Ljava/io/FileDescriptor;)V
    //   463: goto -271 -> 192
    //   466: astore 9
    //   468: ldc 115
    //   470: aload 9
    //   472: ldc_w 479
    //   475: iconst_0
    //   476: anewarray 4	java/lang/Object
    //   479: invokestatic 254	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   482: aload 10
    //   484: ldc_w 497
    //   487: ldc_w 496
    //   490: invokevirtual 569	com/tencent/mm/sdk/platformtools/aw:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   493: aload_0
    //   494: getfield 494	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   497: invokevirtual 575	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   500: ifeq -237 -> 263
    //   503: aload_0
    //   504: instanceof 492
    //   507: ifeq -244 -> 263
    //   510: aload 10
    //   512: ldc_w 502
    //   515: iconst_0
    //   516: invokevirtual 506	com/tencent/mm/sdk/platformtools/aw:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   519: pop
    //   520: aload 10
    //   522: ldc_w 497
    //   525: ldc_w 496
    //   528: invokevirtual 501	com/tencent/mm/sdk/platformtools/aw:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   531: pop
    //   532: aload 10
    //   534: ldc_w 508
    //   537: lconst_0
    //   538: invokevirtual 517	com/tencent/mm/sdk/platformtools/aw:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   541: pop
    //   542: aload 10
    //   544: invokevirtual 520	com/tencent/mm/sdk/platformtools/aw:commit	()Z
    //   547: pop
    //   548: goto -285 -> 263
    //   551: astore 9
    //   553: ldc 115
    //   555: ldc_w 605
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
    //   573: invokevirtual 403	java/lang/Exception:toString	()Ljava/lang/String;
    //   576: aastore
    //   577: invokestatic 417	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   580: iconst_0
    //   581: ireturn
    //   582: aload_0
    //   583: getfield 607	com/tencent/mm/plugin/o/i:fd	Ljava/io/FileDescriptor;
    //   586: ifnull -389 -> 197
    //   589: aload_0
    //   590: getfield 607	com/tencent/mm/plugin/o/i:fd	Ljava/io/FileDescriptor;
    //   593: invokevirtual 612	java/io/FileDescriptor:valid	()Z
    //   596: ifeq -399 -> 197
    //   599: aload_0
    //   600: getfield 134	com/tencent/mm/plugin/o/i:cSi	Lcom/tencent/mm/compatible/h/c;
    //   603: aload_0
    //   604: getfield 607	com/tencent/mm/plugin/o/i:fd	Ljava/io/FileDescriptor;
    //   607: aload_0
    //   608: getfield 614	com/tencent/mm/plugin/o/i:bkb	J
    //   611: aload_0
    //   612: getfield 616	com/tencent/mm/plugin/o/i:length	J
    //   615: invokevirtual 562	com/tencent/mm/compatible/h/c:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   618: goto -421 -> 197
    //   621: astore 9
    //   623: aload 10
    //   625: ldc_w 497
    //   628: ldc_w 496
    //   631: invokevirtual 569	com/tencent/mm/sdk/platformtools/aw:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   634: aload_0
    //   635: getfield 494	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   638: invokevirtual 575	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   641: ifeq +48 -> 689
    //   644: aload_0
    //   645: instanceof 492
    //   648: ifeq +41 -> 689
    //   651: aload 10
    //   653: ldc_w 502
    //   656: iconst_0
    //   657: invokevirtual 506	com/tencent/mm/sdk/platformtools/aw:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   660: pop
    //   661: aload 10
    //   663: ldc_w 497
    //   666: ldc_w 496
    //   669: invokevirtual 501	com/tencent/mm/sdk/platformtools/aw:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   672: pop
    //   673: aload 10
    //   675: ldc_w 508
    //   678: lconst_0
    //   679: invokevirtual 517	com/tencent/mm/sdk/platformtools/aw:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   682: pop
    //   683: aload 10
    //   685: invokevirtual 520	com/tencent/mm/sdk/platformtools/aw:commit	()Z
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
    //   44	640	10	localaw	com.tencent.mm.sdk.platformtools.aw
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
    this.bkb = paramLong1;
    this.length = paramLong2;
  }
  
  abstract boolean a(long paramLong1, long paramLong2, z paramz, ByteBuffer paramByteBuffer, int paramInt, MediaCodec.BufferInfo paramBufferInfo);
  
  abstract boolean a(z paramz);
  
  protected boolean ai(int paramInt, long paramLong)
  {
    return false;
  }
  
  protected void b(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    ac.i("MicroMsg.TrackDataSource", "%s found media format mime[%s] track[%d] format[%s]", new Object[] { info(), paramString, Integer.valueOf(paramInt), paramMediaFormat });
    this.trackIndex = paramInt;
    this.mime = paramString;
    this.bjU = (paramMediaFormat.getLong("durationUs") / 1000L);
    this.uIv = paramMediaFormat;
  }
  
  /* Error */
  public final boolean cIc()
  {
    // Byte code:
    //   0: ldc 115
    //   2: ldc_w 633
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
    //   19: getfield 494	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   22: aastore
    //   23: invokestatic 172	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: invokestatic 156	com/tencent/mm/sdk/platformtools/bs:Gn	()J
    //   29: lstore 5
    //   31: ldc_w 484
    //   34: invokestatic 490	com/tencent/mm/sdk/platformtools/aw:aKT	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/aw;
    //   37: astore 10
    //   39: aload_0
    //   40: iconst_0
    //   41: putfield 77	com/tencent/mm/plugin/o/i:uIs	Z
    //   44: ldc 115
    //   46: ldc_w 635
    //   49: iconst_1
    //   50: anewarray 4	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: aload_0
    //   56: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   59: aastore
    //   60: invokestatic 172	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   63: aload_0
    //   64: new 136	com/tencent/mm/compatible/h/c
    //   67: dup
    //   68: invokespecial 527	com/tencent/mm/compatible/h/c:<init>	()V
    //   71: putfield 134	com/tencent/mm/plugin/o/i:cSi	Lcom/tencent/mm/compatible/h/c;
    //   74: aload_0
    //   75: instanceof 492
    //   78: ifeq +54 -> 132
    //   81: aload_0
    //   82: getfield 494	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   85: ifnonnull +300 -> 385
    //   88: ldc_w 496
    //   91: astore 9
    //   93: aload 10
    //   95: ldc_w 497
    //   98: aload 9
    //   100: invokevirtual 501	com/tencent/mm/sdk/platformtools/aw:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   103: pop
    //   104: aload 10
    //   106: ldc_w 502
    //   109: iconst_1
    //   110: invokevirtual 506	com/tencent/mm/sdk/platformtools/aw:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   113: pop
    //   114: aload 10
    //   116: ldc_w 508
    //   119: invokestatic 513	java/lang/System:currentTimeMillis	()J
    //   122: invokevirtual 517	com/tencent/mm/sdk/platformtools/aw:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   125: pop
    //   126: aload 10
    //   128: invokevirtual 520	com/tencent/mm/sdk/platformtools/aw:commit	()Z
    //   131: pop
    //   132: aload_0
    //   133: getfield 494	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   136: invokestatic 531	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   139: ifne +372 -> 511
    //   142: aload_0
    //   143: getfield 494	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   146: iconst_0
    //   147: invokestatic 537	com/tencent/mm/vfs/i:cY	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   150: astore 9
    //   152: aload_0
    //   153: aload 9
    //   155: invokevirtual 543	java/io/RandomAccessFile:getFD	()Ljava/io/FileDescriptor;
    //   158: putfield 607	com/tencent/mm/plugin/o/i:fd	Ljava/io/FileDescriptor;
    //   161: getstatic 549	com/tencent/mm/compatible/deviceinfo/ae:fJf	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   164: getfield 554	com/tencent/mm/compatible/deviceinfo/aa:fIY	I
    //   167: iconst_1
    //   168: if_icmpne +226 -> 394
    //   171: aload_0
    //   172: getfield 134	com/tencent/mm/plugin/o/i:cSi	Lcom/tencent/mm/compatible/h/c;
    //   175: aload_0
    //   176: getfield 607	com/tencent/mm/plugin/o/i:fd	Ljava/io/FileDescriptor;
    //   179: lconst_0
    //   180: aload_0
    //   181: getfield 494	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   184: invokestatic 558	com/tencent/mm/vfs/i:aSp	(Ljava/lang/String;)J
    //   187: invokevirtual 562	com/tencent/mm/compatible/h/c:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   190: aload 9
    //   192: invokevirtual 565	java/io/RandomAccessFile:close	()V
    //   195: aload_0
    //   196: getfield 134	com/tencent/mm/plugin/o/i:cSi	Lcom/tencent/mm/compatible/h/c;
    //   199: getfield 140	com/tencent/mm/compatible/h/c:fKr	Landroid/media/MediaExtractor;
    //   202: invokevirtual 638	android/media/MediaExtractor:getTrackCount	()I
    //   205: istore_2
    //   206: aload_0
    //   207: iconst_m1
    //   208: putfield 577	com/tencent/mm/plugin/o/i:trackIndex	I
    //   211: iconst_0
    //   212: istore_1
    //   213: iload_1
    //   214: iload_2
    //   215: if_icmpge +49 -> 264
    //   218: aload_0
    //   219: getfield 134	com/tencent/mm/plugin/o/i:cSi	Lcom/tencent/mm/compatible/h/c;
    //   222: iload_1
    //   223: invokevirtual 642	com/tencent/mm/compatible/h/c:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   226: astore 9
    //   228: aload 9
    //   230: ldc_w 643
    //   233: invokevirtual 646	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   236: astore 11
    //   238: aload 11
    //   240: ifnull +419 -> 659
    //   243: aload 11
    //   245: aload_0
    //   246: invokevirtual 437	com/tencent/mm/plugin/o/i:type	()Ljava/lang/String;
    //   249: invokevirtual 586	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   252: ifeq +407 -> 659
    //   255: aload_0
    //   256: aload 9
    //   258: aload 11
    //   260: iload_1
    //   261: invokevirtual 648	com/tencent/mm/plugin/o/i:b	(Landroid/media/MediaFormat;Ljava/lang/String;I)V
    //   264: aload_0
    //   265: getfield 577	com/tencent/mm/plugin/o/i:trackIndex	I
    //   268: ifge +398 -> 666
    //   271: ldc 115
    //   273: ldc_w 650
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
    //   297: getfield 577	com/tencent/mm/plugin/o/i:trackIndex	I
    //   300: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   303: aastore
    //   304: invokestatic 338	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   307: aload_0
    //   308: getfield 94	com/tencent/mm/plugin/o/i:uIq	Lcom/tencent/mm/plugin/o/h;
    //   311: ldc_w 652
    //   314: invokevirtual 656	com/tencent/mm/plugin/o/h:alS	(Ljava/lang/String;)V
    //   317: aload 10
    //   319: ldc_w 497
    //   322: ldc_w 496
    //   325: invokevirtual 569	com/tencent/mm/sdk/platformtools/aw:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   328: aload_0
    //   329: getfield 494	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   332: invokevirtual 575	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   335: ifeq +48 -> 383
    //   338: aload_0
    //   339: instanceof 492
    //   342: ifeq +41 -> 383
    //   345: aload 10
    //   347: ldc_w 502
    //   350: iconst_0
    //   351: invokevirtual 506	com/tencent/mm/sdk/platformtools/aw:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   354: pop
    //   355: aload 10
    //   357: ldc_w 497
    //   360: ldc_w 496
    //   363: invokevirtual 501	com/tencent/mm/sdk/platformtools/aw:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   366: pop
    //   367: aload 10
    //   369: ldc_w 508
    //   372: lconst_0
    //   373: invokevirtual 517	com/tencent/mm/sdk/platformtools/aw:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   376: pop
    //   377: aload 10
    //   379: invokevirtual 520	com/tencent/mm/sdk/platformtools/aw:commit	()Z
    //   382: pop
    //   383: iconst_0
    //   384: ireturn
    //   385: aload_0
    //   386: getfield 494	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   389: astore 9
    //   391: goto -298 -> 93
    //   394: aload_0
    //   395: getfield 134	com/tencent/mm/plugin/o/i:cSi	Lcom/tencent/mm/compatible/h/c;
    //   398: aload_0
    //   399: getfield 607	com/tencent/mm/plugin/o/i:fd	Ljava/io/FileDescriptor;
    //   402: invokevirtual 603	com/tencent/mm/compatible/h/c:setDataSource	(Ljava/io/FileDescriptor;)V
    //   405: goto -215 -> 190
    //   408: astore 9
    //   410: ldc 115
    //   412: aload 9
    //   414: ldc_w 658
    //   417: iconst_1
    //   418: anewarray 4	java/lang/Object
    //   421: dup
    //   422: iconst_0
    //   423: aload_0
    //   424: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   427: aastore
    //   428: invokestatic 254	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   431: aload_0
    //   432: getfield 94	com/tencent/mm/plugin/o/i:uIq	Lcom/tencent/mm/plugin/o/h;
    //   435: aload 9
    //   437: invokevirtual 403	java/lang/Exception:toString	()Ljava/lang/String;
    //   440: invokevirtual 656	com/tencent/mm/plugin/o/h:alS	(Ljava/lang/String;)V
    //   443: aload 10
    //   445: ldc_w 497
    //   448: ldc_w 496
    //   451: invokevirtual 569	com/tencent/mm/sdk/platformtools/aw:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   454: aload_0
    //   455: getfield 494	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   458: invokevirtual 575	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   461: ifeq +48 -> 509
    //   464: aload_0
    //   465: instanceof 492
    //   468: ifeq +41 -> 509
    //   471: aload 10
    //   473: ldc_w 502
    //   476: iconst_0
    //   477: invokevirtual 506	com/tencent/mm/sdk/platformtools/aw:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   480: pop
    //   481: aload 10
    //   483: ldc_w 497
    //   486: ldc_w 496
    //   489: invokevirtual 501	com/tencent/mm/sdk/platformtools/aw:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   492: pop
    //   493: aload 10
    //   495: ldc_w 508
    //   498: lconst_0
    //   499: invokevirtual 517	com/tencent/mm/sdk/platformtools/aw:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   502: pop
    //   503: aload 10
    //   505: invokevirtual 520	com/tencent/mm/sdk/platformtools/aw:commit	()Z
    //   508: pop
    //   509: iconst_0
    //   510: ireturn
    //   511: aload_0
    //   512: getfield 607	com/tencent/mm/plugin/o/i:fd	Ljava/io/FileDescriptor;
    //   515: ifnull -320 -> 195
    //   518: aload_0
    //   519: getfield 607	com/tencent/mm/plugin/o/i:fd	Ljava/io/FileDescriptor;
    //   522: invokevirtual 612	java/io/FileDescriptor:valid	()Z
    //   525: ifeq -330 -> 195
    //   528: aload_0
    //   529: getfield 134	com/tencent/mm/plugin/o/i:cSi	Lcom/tencent/mm/compatible/h/c;
    //   532: aload_0
    //   533: getfield 607	com/tencent/mm/plugin/o/i:fd	Ljava/io/FileDescriptor;
    //   536: aload_0
    //   537: getfield 614	com/tencent/mm/plugin/o/i:bkb	J
    //   540: aload_0
    //   541: getfield 616	com/tencent/mm/plugin/o/i:length	J
    //   544: invokevirtual 562	com/tencent/mm/compatible/h/c:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   547: goto -352 -> 195
    //   550: astore 9
    //   552: ldc 115
    //   554: ldc_w 660
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
    //   572: invokevirtual 661	java/lang/Throwable:toString	()Ljava/lang/String;
    //   575: aastore
    //   576: invokestatic 417	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   579: aload_0
    //   580: getfield 94	com/tencent/mm/plugin/o/i:uIq	Lcom/tencent/mm/plugin/o/h;
    //   583: aload 9
    //   585: invokevirtual 661	java/lang/Throwable:toString	()Ljava/lang/String;
    //   588: invokevirtual 656	com/tencent/mm/plugin/o/h:alS	(Ljava/lang/String;)V
    //   591: aload 10
    //   593: ldc_w 497
    //   596: ldc_w 496
    //   599: invokevirtual 569	com/tencent/mm/sdk/platformtools/aw:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   602: aload_0
    //   603: getfield 494	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   606: invokevirtual 575	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   609: ifeq +48 -> 657
    //   612: aload_0
    //   613: instanceof 492
    //   616: ifeq +41 -> 657
    //   619: aload 10
    //   621: ldc_w 502
    //   624: iconst_0
    //   625: invokevirtual 506	com/tencent/mm/sdk/platformtools/aw:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   628: pop
    //   629: aload 10
    //   631: ldc_w 497
    //   634: ldc_w 496
    //   637: invokevirtual 501	com/tencent/mm/sdk/platformtools/aw:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   640: pop
    //   641: aload 10
    //   643: ldc_w 508
    //   646: lconst_0
    //   647: invokevirtual 517	com/tencent/mm/sdk/platformtools/aw:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   650: pop
    //   651: aload 10
    //   653: invokevirtual 520	com/tencent/mm/sdk/platformtools/aw:commit	()Z
    //   656: pop
    //   657: iconst_0
    //   658: ireturn
    //   659: iload_1
    //   660: iconst_1
    //   661: iadd
    //   662: istore_1
    //   663: goto -450 -> 213
    //   666: aload_0
    //   667: getfield 134	com/tencent/mm/plugin/o/i:cSi	Lcom/tencent/mm/compatible/h/c;
    //   670: aload_0
    //   671: getfield 577	com/tencent/mm/plugin/o/i:trackIndex	I
    //   674: invokevirtual 580	com/tencent/mm/compatible/h/c:selectTrack	(I)V
    //   677: aload_0
    //   678: getfield 494	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   681: invokestatic 531	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   684: ifne +8 -> 692
    //   687: aload_0
    //   688: aconst_null
    //   689: putfield 258	com/tencent/mm/plugin/o/i:uIw	Lcom/tencent/mm/plugin/o/g;
    //   692: invokestatic 156	com/tencent/mm/sdk/platformtools/bs:Gn	()J
    //   695: lstore 7
    //   697: aload 10
    //   699: ldc_w 497
    //   702: ldc_w 496
    //   705: invokevirtual 569	com/tencent/mm/sdk/platformtools/aw:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   708: aload_0
    //   709: getfield 494	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   712: invokevirtual 575	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   715: ifeq +48 -> 763
    //   718: aload_0
    //   719: instanceof 492
    //   722: ifeq +41 -> 763
    //   725: aload 10
    //   727: ldc_w 502
    //   730: iconst_0
    //   731: invokevirtual 506	com/tencent/mm/sdk/platformtools/aw:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   734: pop
    //   735: aload 10
    //   737: ldc_w 497
    //   740: ldc_w 496
    //   743: invokevirtual 501	com/tencent/mm/sdk/platformtools/aw:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   746: pop
    //   747: aload 10
    //   749: ldc_w 508
    //   752: lconst_0
    //   753: invokevirtual 517	com/tencent/mm/sdk/platformtools/aw:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   756: pop
    //   757: aload 10
    //   759: invokevirtual 520	com/tencent/mm/sdk/platformtools/aw:commit	()Z
    //   762: pop
    //   763: ldc 115
    //   765: ldc_w 663
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
    //   782: getfield 623	com/tencent/mm/plugin/o/i:mime	Ljava/lang/String;
    //   785: aastore
    //   786: dup
    //   787: iconst_2
    //   788: aload_0
    //   789: getfield 98	com/tencent/mm/plugin/o/i:state	I
    //   792: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   795: aastore
    //   796: invokestatic 172	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   799: aload_0
    //   800: getfield 98	com/tencent/mm/plugin/o/i:state	I
    //   803: invokestatic 240	com/tencent/mm/plugin/o/e:Iz	(I)Z
    //   806: ifne +303 -> 1109
    //   809: aload_0
    //   810: getfield 88	com/tencent/mm/plugin/o/i:lock	Ljava/lang/Object;
    //   813: astore 9
    //   815: aload 9
    //   817: monitorenter
    //   818: ldc 115
    //   820: ldc_w 665
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
    //   837: getfield 203	com/tencent/mm/plugin/o/i:uIv	Landroid/media/MediaFormat;
    //   840: aastore
    //   841: invokestatic 151	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   844: aload_0
    //   845: aload_0
    //   846: getfield 623	com/tencent/mm/plugin/o/i:mime	Ljava/lang/String;
    //   849: invokestatic 669	com/tencent/mm/compatible/deviceinfo/z:sx	(Ljava/lang/String;)Lcom/tencent/mm/compatible/deviceinfo/z;
    //   852: putfield 158	com/tencent/mm/plugin/o/i:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   855: aload_0
    //   856: aload_0
    //   857: getfield 158	com/tencent/mm/plugin/o/i:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   860: invokevirtual 671	com/tencent/mm/plugin/o/i:a	(Lcom/tencent/mm/compatible/deviceinfo/z;)Z
    //   863: pop
    //   864: aload_0
    //   865: getfield 158	com/tencent/mm/plugin/o/i:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   868: invokevirtual 674	com/tencent/mm/compatible/deviceinfo/z:start	()V
    //   871: aload_0
    //   872: aload_0
    //   873: getfield 158	com/tencent/mm/plugin/o/i:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   876: invokevirtual 677	com/tencent/mm/compatible/deviceinfo/z:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   879: putfield 256	com/tencent/mm/plugin/o/i:bjg	[Ljava/nio/ByteBuffer;
    //   882: aload_0
    //   883: aload_0
    //   884: getfield 158	com/tencent/mm/plugin/o/i:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   887: invokevirtual 210	com/tencent/mm/compatible/deviceinfo/z:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   890: putfield 178	com/tencent/mm/plugin/o/i:aVy	[Ljava/nio/ByteBuffer;
    //   893: aload 9
    //   895: monitorexit
    //   896: invokestatic 156	com/tencent/mm/sdk/platformtools/bs:Gn	()J
    //   899: lstore_3
    //   900: aload_0
    //   901: iconst_1
    //   902: invokevirtual 176	com/tencent/mm/plugin/o/i:setState	(I)V
    //   905: ldc 115
    //   907: ldc_w 679
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
    //   925: invokestatic 218	com/tencent/mm/sdk/platformtools/bs:aO	(J)J
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
    //   953: invokestatic 172	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   956: iconst_1
    //   957: ireturn
    //   958: astore 9
    //   960: aload 10
    //   962: ldc_w 497
    //   965: ldc_w 496
    //   968: invokevirtual 569	com/tencent/mm/sdk/platformtools/aw:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   971: aload_0
    //   972: getfield 494	com/tencent/mm/plugin/o/i:path	Ljava/lang/String;
    //   975: invokevirtual 575	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   978: ifeq +48 -> 1026
    //   981: aload_0
    //   982: instanceof 492
    //   985: ifeq +41 -> 1026
    //   988: aload 10
    //   990: ldc_w 502
    //   993: iconst_0
    //   994: invokevirtual 506	com/tencent/mm/sdk/platformtools/aw:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   997: pop
    //   998: aload 10
    //   1000: ldc_w 497
    //   1003: ldc_w 496
    //   1006: invokevirtual 501	com/tencent/mm/sdk/platformtools/aw:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   1009: pop
    //   1010: aload 10
    //   1012: ldc_w 508
    //   1015: lconst_0
    //   1016: invokevirtual 517	com/tencent/mm/sdk/platformtools/aw:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   1019: pop
    //   1020: aload 10
    //   1022: invokevirtual 520	com/tencent/mm/sdk/platformtools/aw:commit	()Z
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
    //   1043: ldc_w 681
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
    //   1061: invokevirtual 403	java/lang/Exception:toString	()Ljava/lang/String;
    //   1064: aastore
    //   1065: invokestatic 254	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1068: ldc 115
    //   1070: aload 9
    //   1072: ldc_w 683
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
    //   1089: getfield 203	com/tencent/mm/plugin/o/i:uIv	Landroid/media/MediaFormat;
    //   1092: aastore
    //   1093: invokestatic 254	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1096: aload_0
    //   1097: getfield 94	com/tencent/mm/plugin/o/i:uIq	Lcom/tencent/mm/plugin/o/h;
    //   1100: aload_0
    //   1101: invokevirtual 437	com/tencent/mm/plugin/o/i:type	()Ljava/lang/String;
    //   1104: invokevirtual 686	com/tencent/mm/plugin/o/h:alT	(Ljava/lang/String;)V
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
    //   37	984	10	localaw	com.tencent.mm.sdk.platformtools.aw
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
  
  public final void dda()
  {
    ac.i("MicroMsg.TrackDataSource", "%s flush codec", new Object[] { info() });
    this.bjj = -1;
    this.bji = -1;
    try
    {
      z localz;
      if (this.gOr != null) {
        localz = this.gOr;
      }
      try
      {
        if (!localz.czg) {
          ac.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy flush not alive");
        }
        MediaCodecProxyUtils.b.kW(96);
        localz.fIx.flush();
        MediaCodecProxyUtils.b.kW(97);
        return;
      }
      catch (Exception localException2)
      {
        ac.printErrStackTrace("MicroMsg.MediaCodecProxy", localException2, "MediaCodecProxy flush, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
        MediaCodecProxyUtils.b.kW(39);
        localz.fIz.getAndIncrement();
        throw localException2;
      }
      return;
    }
    catch (Exception localException1)
    {
      ac.printErrStackTrace("MicroMsg.TrackDataSource", localException1, "flushCodec exception", new Object[0]);
    }
  }
  
  protected final boolean ddb()
  {
    try
    {
      ac.i("MicroMsg.TrackDataSource", "%s start to prepare decoder mime[%s]", new Object[] { info(), this.mime });
      this.gOr = z.sx(this.mime);
      a(this.gOr);
      this.gOr.start();
      this.bjg = this.gOr.getInputBuffers();
      this.aVy = this.gOr.getOutputBuffers();
      return true;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.TrackDataSource", localException, "%s prepare decoder init decoder error ", new Object[] { info() });
      this.uIq.alT(type());
    }
    return false;
  }
  
  protected final MediaFormat ddc()
  {
    if ((this.cSi == null) || (this.trackIndex < 0)) {
      return this.uIv;
    }
    return this.cSi.getTrackFormat(this.trackIndex);
  }
  
  public final String info()
  {
    if (this.uIq != null) {
      return type() + "_" + this.uIq.info() + "_" + Process.myTid();
    }
    return type() + "_" + Process.myTid();
  }
  
  protected void onPause() {}
  
  protected void onStart() {}
  
  public final void pause()
  {
    ac.i("MicroMsg.TrackDataSource", "%s start to pause", new Object[] { info() });
    setState(4);
    onPause();
  }
  
  public void release()
  {
    ac.i("MicroMsg.TrackDataSource", "release doubleReleaseSwitch:[%b]", new Object[] { Boolean.valueOf(uIz) });
    if (uIz)
    {
      ac.i("MicroMsg.TrackDataSource", "%s into release fun", new Object[] { info() });
      if (this.cSi != null)
      {
        ac.i("MicroMsg.TrackDataSource", "%s release,  extractor != null", new Object[] { info() });
        this.cSi.fKr.release();
        this.cSi = null;
      }
      releaseDecoder();
      if (this.uIw != null)
      {
        ac.i("MicroMsg.TrackDataSource", "%s release,  mp4Extractor != null", new Object[] { info() });
        this.uIw.release();
      }
      ac.i("MicroMsg.TrackDataSource", "%s finish release", new Object[] { info() });
      return;
    }
    ac.i("MicroMsg.TrackDataSource", "%s release", new Object[] { info() });
    if (this.cSi != null)
    {
      this.cSi.fKr.release();
      this.cSi = null;
    }
    if (this.gOr != null)
    {
      this.gOr.release();
      this.gOr = null;
    }
    if (this.uIw != null) {
      this.uIw.release();
    }
    ac.i("MicroMsg.TrackDataSource", "%s finish release", new Object[] { info() });
  }
  
  /* Error */
  protected final void releaseDecoder()
  {
    // Byte code:
    //   0: ldc 115
    //   2: ldc_w 770
    //   5: iconst_1
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: getstatic 68	com/tencent/mm/plugin/o/i:uIz	Z
    //   14: invokestatic 232	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   17: aastore
    //   18: invokestatic 172	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   21: getstatic 68	com/tencent/mm/plugin/o/i:uIz	Z
    //   24: ifeq +227 -> 251
    //   27: invokestatic 156	com/tencent/mm/sdk/platformtools/bs:Gn	()J
    //   30: lstore_1
    //   31: aload_0
    //   32: getfield 88	com/tencent/mm/plugin/o/i:lock	Ljava/lang/Object;
    //   35: astore_3
    //   36: aload_3
    //   37: monitorenter
    //   38: aload_0
    //   39: getfield 158	com/tencent/mm/plugin/o/i:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   42: ifnull +187 -> 229
    //   45: ldc 115
    //   47: ldc_w 772
    //   50: iconst_1
    //   51: anewarray 4	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: aload_0
    //   57: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   60: aastore
    //   61: invokestatic 172	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: aload_0
    //   65: invokevirtual 434	com/tencent/mm/plugin/o/i:dda	()V
    //   68: aload_0
    //   69: aconst_null
    //   70: putfield 178	com/tencent/mm/plugin/o/i:aVy	[Ljava/nio/ByteBuffer;
    //   73: aload_0
    //   74: aconst_null
    //   75: putfield 256	com/tencent/mm/plugin/o/i:bjg	[Ljava/nio/ByteBuffer;
    //   78: ldc 115
    //   80: ldc_w 774
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
    //   97: invokestatic 218	com/tencent/mm/sdk/platformtools/bs:aO	(J)J
    //   100: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   103: aastore
    //   104: invokestatic 172	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   107: aload_0
    //   108: getfield 158	com/tencent/mm/plugin/o/i:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   111: invokevirtual 777	com/tencent/mm/compatible/deviceinfo/z:stop	()V
    //   114: aload_0
    //   115: getfield 158	com/tencent/mm/plugin/o/i:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   118: invokevirtual 768	com/tencent/mm/compatible/deviceinfo/z:release	()V
    //   121: aload_0
    //   122: aconst_null
    //   123: putfield 158	com/tencent/mm/plugin/o/i:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   126: ldc 115
    //   128: ldc_w 779
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
    //   145: invokestatic 218	com/tencent/mm/sdk/platformtools/bs:aO	(J)J
    //   148: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   151: aastore
    //   152: invokestatic 172	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload_3
    //   156: monitorexit
    //   157: return
    //   158: astore 4
    //   160: aload_0
    //   161: aconst_null
    //   162: putfield 158	com/tencent/mm/plugin/o/i:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   165: aload 4
    //   167: athrow
    //   168: astore 4
    //   170: aload_3
    //   171: monitorexit
    //   172: aload 4
    //   174: athrow
    //   175: astore 4
    //   177: aload_0
    //   178: getfield 158	com/tencent/mm/plugin/o/i:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   181: invokevirtual 768	com/tencent/mm/compatible/deviceinfo/z:release	()V
    //   184: aload_0
    //   185: aconst_null
    //   186: putfield 158	com/tencent/mm/plugin/o/i:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   189: goto -63 -> 126
    //   192: astore 4
    //   194: aload_0
    //   195: aconst_null
    //   196: putfield 158	com/tencent/mm/plugin/o/i:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   199: aload 4
    //   201: athrow
    //   202: astore 4
    //   204: aload_0
    //   205: getfield 158	com/tencent/mm/plugin/o/i:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   208: invokevirtual 768	com/tencent/mm/compatible/deviceinfo/z:release	()V
    //   211: aload_0
    //   212: aconst_null
    //   213: putfield 158	com/tencent/mm/plugin/o/i:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   216: aload 4
    //   218: athrow
    //   219: astore 4
    //   221: aload_0
    //   222: aconst_null
    //   223: putfield 158	com/tencent/mm/plugin/o/i:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   226: aload 4
    //   228: athrow
    //   229: ldc 115
    //   231: ldc_w 781
    //   234: iconst_1
    //   235: anewarray 4	java/lang/Object
    //   238: dup
    //   239: iconst_0
    //   240: aload_0
    //   241: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   244: aastore
    //   245: invokestatic 172	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   248: goto -93 -> 155
    //   251: aload_0
    //   252: getfield 158	com/tencent/mm/plugin/o/i:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   255: ifnull +198 -> 453
    //   258: ldc 115
    //   260: ldc_w 772
    //   263: iconst_1
    //   264: anewarray 4	java/lang/Object
    //   267: dup
    //   268: iconst_0
    //   269: aload_0
    //   270: invokevirtual 121	com/tencent/mm/plugin/o/i:info	()Ljava/lang/String;
    //   273: aastore
    //   274: invokestatic 172	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   277: aload_0
    //   278: invokevirtual 434	com/tencent/mm/plugin/o/i:dda	()V
    //   281: aload_0
    //   282: aconst_null
    //   283: putfield 178	com/tencent/mm/plugin/o/i:aVy	[Ljava/nio/ByteBuffer;
    //   286: aload_0
    //   287: aconst_null
    //   288: putfield 256	com/tencent/mm/plugin/o/i:bjg	[Ljava/nio/ByteBuffer;
    //   291: invokestatic 156	com/tencent/mm/sdk/platformtools/bs:Gn	()J
    //   294: lstore_1
    //   295: aload_0
    //   296: getfield 88	com/tencent/mm/plugin/o/i:lock	Ljava/lang/Object;
    //   299: astore_3
    //   300: aload_3
    //   301: monitorenter
    //   302: ldc 115
    //   304: ldc_w 774
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
    //   321: invokestatic 218	com/tencent/mm/sdk/platformtools/bs:aO	(J)J
    //   324: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   327: aastore
    //   328: invokestatic 172	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   331: aload_0
    //   332: getfield 158	com/tencent/mm/plugin/o/i:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   335: invokevirtual 777	com/tencent/mm/compatible/deviceinfo/z:stop	()V
    //   338: aload_0
    //   339: getfield 158	com/tencent/mm/plugin/o/i:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   342: invokevirtual 768	com/tencent/mm/compatible/deviceinfo/z:release	()V
    //   345: aload_0
    //   346: aconst_null
    //   347: putfield 158	com/tencent/mm/plugin/o/i:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   350: aload_3
    //   351: monitorexit
    //   352: ldc 115
    //   354: ldc_w 779
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
    //   371: invokestatic 218	com/tencent/mm/sdk/platformtools/bs:aO	(J)J
    //   374: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   377: aastore
    //   378: invokestatic 172	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   381: return
    //   382: astore 4
    //   384: aload_0
    //   385: aconst_null
    //   386: putfield 158	com/tencent/mm/plugin/o/i:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   389: aload 4
    //   391: athrow
    //   392: astore 4
    //   394: aload_3
    //   395: monitorexit
    //   396: aload 4
    //   398: athrow
    //   399: astore 4
    //   401: aload_0
    //   402: getfield 158	com/tencent/mm/plugin/o/i:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   405: invokevirtual 768	com/tencent/mm/compatible/deviceinfo/z:release	()V
    //   408: aload_0
    //   409: aconst_null
    //   410: putfield 158	com/tencent/mm/plugin/o/i:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   413: goto -63 -> 350
    //   416: astore 4
    //   418: aload_0
    //   419: aconst_null
    //   420: putfield 158	com/tencent/mm/plugin/o/i:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   423: aload 4
    //   425: athrow
    //   426: astore 4
    //   428: aload_0
    //   429: getfield 158	com/tencent/mm/plugin/o/i:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   432: invokevirtual 768	com/tencent/mm/compatible/deviceinfo/z:release	()V
    //   435: aload_0
    //   436: aconst_null
    //   437: putfield 158	com/tencent/mm/plugin/o/i:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   440: aload 4
    //   442: athrow
    //   443: astore 4
    //   445: aload_0
    //   446: aconst_null
    //   447: putfield 158	com/tencent/mm/plugin/o/i:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
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
    ac.i("MicroMsg.TrackDataSource", "%s set state old %d new %d", new Object[] { info(), Integer.valueOf(this.state), Integer.valueOf(paramInt) });
    this.state = paramInt;
  }
  
  public final void start()
  {
    ac.i("MicroMsg.TrackDataSource", "%s start to play", new Object[] { info() });
    this.uIs = false;
    setState(3);
    onStart();
  }
  
  abstract String type();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.o.i
 * JD-Core Version:    0.7.0.1
 */