package com.tencent.mm.plugin.u;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Message;
import android.os.Process;
import com.tencent.mm.compatible.deviceinfo.MediaCodecProxyUtils.b;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.k.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.FileDescriptor;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class i
{
  private static boolean KSV;
  private static long KSW;
  protected h KSM;
  protected MMHandler KSN;
  protected FileDescriptor KSO;
  private volatile boolean KSP = false;
  b KSQ = null;
  protected long KSR = 0L;
  private g KSS;
  private boolean KST = false;
  private boolean KSU = false;
  private long KSX = 0L;
  private long KSY = 0L;
  private String cBw;
  private MediaCodec.BufferInfo cWF = new MediaCodec.BufferInfo();
  private volatile int cWV;
  protected long cXM;
  long durationMs;
  private MediaFormat format;
  protected long length;
  private final Object lock = new Object();
  protected aa nyz;
  protected String path;
  private com.tencent.mm.compatible.i.c pcp;
  protected volatile int state;
  private int trackIndex;
  
  static
  {
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yVe, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      KSV = bool;
      KSW = 0L;
      return;
    }
  }
  
  public i(h paramh, MMHandler paramMMHandler)
  {
    this.KSM = paramh;
    this.KSN = paramMMHandler;
    this.state = 0;
    this.cWV = -1;
  }
  
  private boolean D(long paramLong1, long paramLong2)
  {
    Log.d("MicroMsg.TrackDataSource", "%s drain output buffer state:%s time[%d %d %s] index %d", new Object[] { info(), Integer.valueOf(this.state), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(this.pcp.lZm.getSampleTime()), Integer.valueOf(this.cWV) });
    long l = Util.currentTicks();
    if (this.cWV < 0)
    {
      synchronized (this.lock)
      {
        this.cWV = this.nyz.dequeueOutputBuffer(this.cWF, KSW);
        if (this.cWV >= 0)
        {
          if ((this.cWF.flags & 0x4) == 0) {
            break label256;
          }
          Log.i("MicroMsg.TrackDataSource", "%s process end of stream", new Object[] { info() });
          setState(9);
          this.cWV = -1;
          return false;
        }
      }
      if (this.cWV == -2)
      {
        ??? = this.nyz.getOutputFormat();
        this.format = ((MediaFormat)???);
        a(this.nyz, (MediaFormat)???);
        return true;
      }
      if (this.cWV == -3) {
        return true;
      }
      Log.d("MicroMsg.TrackDataSource", "%s drain output buffer error outputIndex[%d] state:%s", new Object[] { info(), Integer.valueOf(this.cWV), Integer.valueOf(this.state) });
      return false;
    }
    label256:
    if (this.state == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.nyz.releaseOutputBuffer(this.cWV, true);
      this.cWV = -1;
      setState(2);
      return true;
    }
    Log.d("MicroMsg.TrackDataSource", "%s process output buffer state:%s: index %d, cost:%s", new Object[] { info(), Integer.valueOf(this.state), Integer.valueOf(this.cWV), Long.valueOf(Util.ticksToNow(l)) });
    synchronized (this.lock)
    {
      if (this.cWV >= 0)
      {
        ByteBuffer localByteBuffer = this.nyz.getOutputBuffer(this.cWV);
        if (localByteBuffer != null)
        {
          localByteBuffer.position(this.cWF.offset);
          localByteBuffer.limit(this.cWF.offset + this.cWF.size);
        }
        if (a(paramLong1, paramLong2, this.nyz, localByteBuffer, this.cWV, this.cWF))
        {
          this.cWV = -1;
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean SC()
  {
    int k;
    try
    {
      Log.d("MicroMsg.TrackDataSource", "doubleReleaseSwitch:[%b]", new Object[] { Boolean.valueOf(KSV) });
      if ((e.aaM(this.state)) || (this.KSP))
      {
        Log.d("MicroMsg.TrackDataSource", "%s feed input buffer is end.", new Object[] { info() });
        return false;
      }
      k = -1;
      synchronized (this.lock)
      {
        if (this.nyz != null)
        {
          i = this.nyz.dequeueInputBuffer(0L);
          k = i;
          if (i < 0)
          {
            Log.d("MicroMsg.TrackDataSource", "%s can not dequeue effect input buffer, state:%s", new Object[] { info(), Integer.valueOf(this.state) });
            return false;
          }
        }
      }
      if (k < 0) {
        break label1150;
      }
    }
    catch (Exception localException1)
    {
      Log.printErrStackTrace("MicroMsg.TrackDataSource", localException1, "feedInputBuffer exception", new Object[0]);
      return false;
    }
    ??? = this.nyz.getInputBuffer(k);
    Log.d("MicroMsg.TrackDataSource", "%s start to feed input buffer index %d [%d, %b]", new Object[] { info(), Integer.valueOf(k), Integer.valueOf(this.state), Boolean.valueOf(this.KSP) });
    if (a.dsY()) {}
    for (int m = -1;; m = 0)
    {
      if (this.KSS != null) {
        throw null;
      }
      if (this.KSM.KSI)
      {
        if (KSV) {}
        for (;;)
        {
          synchronized (this.lock)
          {
            if (this.nyz != null) {
              this.nyz.a(k, 0, this.durationMs * 1000L, 4);
            }
            this.KSP = true;
            this.KSM.KSI = false;
            return false;
          }
          this.nyz.a(k, 0, this.durationMs * 1000L, 4);
        }
      }
      long l1 = 0L;
      if (??? != null) {}
      for (;;)
      {
        try
        {
          i = this.pcp.readSampleData((ByteBuffer)???, 0);
        }
        catch (Exception localException3)
        {
          long l2;
          int n;
          int j;
          long l3;
          Object localObject3;
          i = 0;
          continue;
        }
        try
        {
          l2 = this.pcp.lZm.getSampleTime();
          l1 = l2;
          n = this.pcp.lZm.getSampleFlags();
          l1 = l2;
          j = i;
          i = n;
          Log.d("MicroMsg.TrackDataSource", "%s read data, state:%s index[%d, %d] sample info[%d, %d]", new Object[] { info(), Integer.valueOf(this.state), Integer.valueOf(k), Integer.valueOf(j), Long.valueOf(l1), Integer.valueOf(i) });
          aH(i, l1);
          if (j > m) {
            continue;
          }
          Log.i("MicroMsg.TrackDataSource", "read data index eof. sampleSize:%d", new Object[] { Integer.valueOf(j) });
          if (!KSV) {
            continue;
          }
        }
        catch (Exception localException2)
        {
          continue;
        }
        synchronized (this.lock)
        {
          if (this.nyz != null) {
            this.nyz.a(k, 0, this.durationMs * 1000L, 4);
          }
          this.KSP = true;
          return false;
          Log.printErrStackTrace("MicroMsg.TrackDataSource", (Throwable)???, "MediaExtractor get sample data error: %s", new Object[] { ((Exception)???).getMessage() });
          n = 0;
          j = i;
          i = n;
        }
        this.nyz.a(k, 0, this.durationMs * 1000L, 4);
        continue;
        if (j > 0)
        {
          if (KSV) {
            synchronized (this.lock)
            {
              if (this.nyz != null) {
                this.nyz.a(k, j, l1, 0);
              }
              this.pcp.lZm.advance();
              l2 = this.pcp.lZm.getSampleTime();
              if (this.KSM.ykm) {
                continue;
              }
              if (aR(l1, l2))
              {
                Log.w("MicroMsg.TrackDataSource", "%s feed input buffer isOnlineVideo[%b] next[%d] onlineCacheMs[%d]", new Object[] { info(), Boolean.valueOf(this.KSM.ykm), Long.valueOf(l2), Long.valueOf(this.KSR) });
                l3 = this.pcp.lZm.getSampleTime();
                if (Math.abs(l3 - l1) >= 1000000L)
                {
                  Log.w("MicroMsg.TrackDataSource", "%s reset extractor finish but seek time is not right[%d, %d]", new Object[] { info(), Long.valueOf(l3), Long.valueOf(l1) });
                  this.KSM.KSI = true;
                }
              }
              Log.d("MicroMsg.TrackDataSource", "%s finish to feed input buffer [%d, %d]", new Object[] { info(), Long.valueOf(l1), Long.valueOf(l2) });
              return false;
            }
          }
          this.nyz.a(k, j, l1, 0);
          continue;
        }
        Log.e("MicroMsg.TrackDataSource", "%s read data index[%d, %d] sample info[%d, %d]", new Object[] { info(), Integer.valueOf(k), Integer.valueOf(j), Long.valueOf(l1), Integer.valueOf(i) });
        continue;
        if (this.KSR == 0L)
        {
          if (aR(l1, l2))
          {
            Log.w("MicroMsg.TrackDataSource", "%s feed input buffer next[%d] onlineCacheMs[%d]", new Object[] { info(), Long.valueOf(l2), Long.valueOf(this.KSR) });
            l3 = this.pcp.lZm.getSampleTime();
            if (Math.abs(l3 - l1) >= 3000000L)
            {
              Log.w("MicroMsg.TrackDataSource", "%s reset extractor finish but seek time is not right[%d, %d]", new Object[] { info(), Long.valueOf(l3), Long.valueOf(l1) });
              this.KSN.obtainMessage(5, -2, -2).sendToTarget();
            }
            gbH();
          }
        }
        else if ((l2 < 0L) || (l2 / 1000L + 1200L > this.KSR))
        {
          Log.w("MicroMsg.TrackDataSource", "%s feed input buffer next[%d] onlineCacheMs[%d]", new Object[] { info(), Long.valueOf(l2), Long.valueOf(this.KSR) });
          if (aR(l1, -1L)) {
            this.KSN.obtainMessage(5, -3, -3).sendToTarget();
          }
          gbH();
          continue;
          i = 0;
          j = 0;
        }
      }
      label1150:
      localObject3 = null;
      break;
    }
  }
  
  private void gbH()
  {
    if (this.KSQ != null) {
      this.KSR = (this.KSQ.gbz() * 1000L);
    }
  }
  
  protected void a(aa paramaa, MediaFormat paramMediaFormat) {}
  
  public final void a(FileDescriptor paramFileDescriptor, long paramLong1, long paramLong2)
  {
    this.KSO = paramFileDescriptor;
    this.cXM = paramLong1;
    this.length = paramLong2;
  }
  
  abstract boolean a(long paramLong1, long paramLong2, aa paramaa, ByteBuffer paramByteBuffer, int paramInt, MediaCodec.BufferInfo paramBufferInfo);
  
  abstract boolean a(aa paramaa);
  
  protected boolean aH(int paramInt, long paramLong)
  {
    return false;
  }
  
  /* Error */
  protected final int aQ(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc 106
    //   2: ldc_w 356
    //   5: iconst_4
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: aload_0
    //   12: invokevirtual 112	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   15: aastore
    //   16: dup
    //   17: iconst_1
    //   18: lload_1
    //   19: invokestatic 123	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   22: aastore
    //   23: dup
    //   24: iconst_2
    //   25: lload_3
    //   26: invokestatic 123	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   29: aastore
    //   30: dup
    //   31: iconst_3
    //   32: aload_0
    //   33: getfield 100	com/tencent/mm/plugin/u/i:state	I
    //   36: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   39: aastore
    //   40: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: aload_0
    //   44: getfield 150	com/tencent/mm/plugin/u/i:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   47: ifnull +61 -> 108
    //   50: aload_0
    //   51: lload_1
    //   52: lload_3
    //   53: invokespecial 358	com/tencent/mm/plugin/u/i:D	(JJ)Z
    //   56: ifeq +24 -> 80
    //   59: aload_0
    //   60: invokestatic 361	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   63: putfield 92	com/tencent/mm/plugin/u/i:KSX	J
    //   66: aload_0
    //   67: getfield 100	com/tencent/mm/plugin/u/i:state	I
    //   70: invokestatic 228	com/tencent/mm/plugin/u/e:aaM	(I)Z
    //   73: istore 5
    //   75: iload 5
    //   77: ifeq -27 -> 50
    //   80: aload_0
    //   81: invokespecial 363	com/tencent/mm/plugin/u/i:SC	()Z
    //   84: ifeq +24 -> 108
    //   87: aload_0
    //   88: invokestatic 361	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   91: putfield 94	com/tencent/mm/plugin/u/i:KSY	J
    //   94: aload_0
    //   95: getfield 100	com/tencent/mm/plugin/u/i:state	I
    //   98: invokestatic 228	com/tencent/mm/plugin/u/e:aaM	(I)Z
    //   101: istore 5
    //   103: iload 5
    //   105: ifeq -25 -> 80
    //   108: ldc 106
    //   110: ldc_w 365
    //   113: iconst_2
    //   114: anewarray 4	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: aload_0
    //   120: invokevirtual 112	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   123: aastore
    //   124: dup
    //   125: iconst_1
    //   126: aload_0
    //   127: getfield 100	com/tencent/mm/plugin/u/i:state	I
    //   130: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   133: aastore
    //   134: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: aload_0
    //   138: getfield 100	com/tencent/mm/plugin/u/i:state	I
    //   141: ireturn
    //   142: astore 6
    //   144: aload_0
    //   145: getfield 88	com/tencent/mm/plugin/u/i:KST	Z
    //   148: ifeq +216 -> 364
    //   151: ldc 106
    //   153: ldc_w 367
    //   156: iconst_2
    //   157: anewarray 4	java/lang/Object
    //   160: dup
    //   161: iconst_0
    //   162: aload_0
    //   163: invokevirtual 112	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   166: aastore
    //   167: dup
    //   168: iconst_1
    //   169: aload 6
    //   171: invokevirtual 370	java/lang/Exception:toString	()Ljava/lang/String;
    //   174: aastore
    //   175: invokestatic 317	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   178: aload_0
    //   179: getfield 100	com/tencent/mm/plugin/u/i:state	I
    //   182: invokestatic 228	com/tencent/mm/plugin/u/e:aaM	(I)Z
    //   185: ifne +7 -> 192
    //   188: aload_0
    //   189: invokevirtual 373	com/tencent/mm/plugin/u/i:gbI	()V
    //   192: aload_0
    //   193: getfield 96	com/tencent/mm/plugin/u/i:KSM	Lcom/tencent/mm/plugin/u/h;
    //   196: astore 6
    //   198: aload_0
    //   199: invokevirtual 376	com/tencent/mm/plugin/u/i:type	()Ljava/lang/String;
    //   202: astore 7
    //   204: aload 6
    //   206: getfield 379	com/tencent/mm/plugin/u/h:KSK	Z
    //   209: ifne +102 -> 311
    //   212: aload 6
    //   214: getfield 382	com/tencent/mm/plugin/u/h:KSH	Z
    //   217: ifeq +94 -> 311
    //   220: getstatic 387	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   223: ifne +15 -> 238
    //   226: getstatic 390	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_RED	Z
    //   229: ifne +9 -> 238
    //   232: getstatic 393	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_PURPLE	Z
    //   235: ifeq +15 -> 250
    //   238: new 395	com/tencent/mm/plugin/u/h$2
    //   241: dup
    //   242: aload 6
    //   244: invokespecial 398	com/tencent/mm/plugin/u/h$2:<init>	(Lcom/tencent/mm/plugin/u/h;)V
    //   247: invokestatic 404	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   250: getstatic 410	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   253: aload 6
    //   255: invokevirtual 413	com/tencent/mm/plugin/u/h:gbG	()I
    //   258: i2l
    //   259: ldc2_w 414
    //   262: lconst_1
    //   263: iconst_0
    //   264: invokevirtual 419	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   267: getstatic 410	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   270: aload 6
    //   272: invokevirtual 422	com/tencent/mm/plugin/u/h:gbF	()I
    //   275: iconst_3
    //   276: anewarray 4	java/lang/Object
    //   279: dup
    //   280: iconst_0
    //   281: sipush 506
    //   284: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   287: aastore
    //   288: dup
    //   289: iconst_1
    //   290: invokestatic 425	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   293: invokestatic 123	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   296: aastore
    //   297: dup
    //   298: iconst_2
    //   299: aload 7
    //   301: aastore
    //   302: invokevirtual 429	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   305: aload 6
    //   307: iconst_1
    //   308: putfield 379	com/tencent/mm/plugin/u/h:KSK	Z
    //   311: aload_0
    //   312: getfield 92	com/tencent/mm/plugin/u/i:KSX	J
    //   315: lconst_0
    //   316: lcmp
    //   317: ifne +10 -> 327
    //   320: aload_0
    //   321: invokestatic 361	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   324: putfield 92	com/tencent/mm/plugin/u/i:KSX	J
    //   327: aload_0
    //   328: getfield 92	com/tencent/mm/plugin/u/i:KSX	J
    //   331: invokestatic 432	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   334: ldc2_w 433
    //   337: lcmp
    //   338: iflt -258 -> 80
    //   341: ldc 106
    //   343: ldc_w 436
    //   346: invokestatic 439	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   349: aload_0
    //   350: iconst_m1
    //   351: invokevirtual 168	com/tencent/mm/plugin/u/i:setState	(I)V
    //   354: aload_0
    //   355: invokestatic 361	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   358: putfield 92	com/tencent/mm/plugin/u/i:KSX	J
    //   361: goto -281 -> 80
    //   364: aload_0
    //   365: iconst_1
    //   366: putfield 88	com/tencent/mm/plugin/u/i:KST	Z
    //   369: ldc 106
    //   371: aload 6
    //   373: ldc_w 441
    //   376: iconst_1
    //   377: anewarray 4	java/lang/Object
    //   380: dup
    //   381: iconst_0
    //   382: aload_0
    //   383: invokevirtual 112	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   386: aastore
    //   387: invokestatic 242	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   390: goto -212 -> 178
    //   393: astore 6
    //   395: aload_0
    //   396: getfield 90	com/tencent/mm/plugin/u/i:KSU	Z
    //   399: ifeq +216 -> 615
    //   402: ldc 106
    //   404: ldc_w 443
    //   407: iconst_2
    //   408: anewarray 4	java/lang/Object
    //   411: dup
    //   412: iconst_0
    //   413: aload_0
    //   414: invokevirtual 112	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   417: aastore
    //   418: dup
    //   419: iconst_1
    //   420: aload 6
    //   422: invokevirtual 370	java/lang/Exception:toString	()Ljava/lang/String;
    //   425: aastore
    //   426: invokestatic 317	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   429: aload_0
    //   430: getfield 100	com/tencent/mm/plugin/u/i:state	I
    //   433: invokestatic 228	com/tencent/mm/plugin/u/e:aaM	(I)Z
    //   436: ifne +7 -> 443
    //   439: aload_0
    //   440: invokevirtual 373	com/tencent/mm/plugin/u/i:gbI	()V
    //   443: aload_0
    //   444: getfield 96	com/tencent/mm/plugin/u/i:KSM	Lcom/tencent/mm/plugin/u/h;
    //   447: astore 6
    //   449: aload_0
    //   450: invokevirtual 376	com/tencent/mm/plugin/u/i:type	()Ljava/lang/String;
    //   453: astore 7
    //   455: aload 6
    //   457: getfield 446	com/tencent/mm/plugin/u/h:KSJ	Z
    //   460: ifne +102 -> 562
    //   463: aload 6
    //   465: getfield 382	com/tencent/mm/plugin/u/h:KSH	Z
    //   468: ifeq +94 -> 562
    //   471: getstatic 387	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   474: ifne +15 -> 489
    //   477: getstatic 390	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_RED	Z
    //   480: ifne +9 -> 489
    //   483: getstatic 393	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_PURPLE	Z
    //   486: ifeq +15 -> 501
    //   489: new 448	com/tencent/mm/plugin/u/h$1
    //   492: dup
    //   493: aload 6
    //   495: invokespecial 449	com/tencent/mm/plugin/u/h$1:<init>	(Lcom/tencent/mm/plugin/u/h;)V
    //   498: invokestatic 404	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   501: getstatic 410	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   504: aload 6
    //   506: invokevirtual 413	com/tencent/mm/plugin/u/h:gbG	()I
    //   509: i2l
    //   510: ldc2_w 450
    //   513: lconst_1
    //   514: iconst_0
    //   515: invokevirtual 419	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   518: getstatic 410	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   521: aload 6
    //   523: invokevirtual 422	com/tencent/mm/plugin/u/h:gbF	()I
    //   526: iconst_3
    //   527: anewarray 4	java/lang/Object
    //   530: dup
    //   531: iconst_0
    //   532: sipush 505
    //   535: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   538: aastore
    //   539: dup
    //   540: iconst_1
    //   541: invokestatic 425	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   544: invokestatic 123	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   547: aastore
    //   548: dup
    //   549: iconst_2
    //   550: aload 7
    //   552: aastore
    //   553: invokevirtual 429	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   556: aload 6
    //   558: iconst_1
    //   559: putfield 446	com/tencent/mm/plugin/u/h:KSJ	Z
    //   562: aload_0
    //   563: getfield 94	com/tencent/mm/plugin/u/i:KSY	J
    //   566: lconst_0
    //   567: lcmp
    //   568: ifne +10 -> 578
    //   571: aload_0
    //   572: invokestatic 361	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   575: putfield 94	com/tencent/mm/plugin/u/i:KSY	J
    //   578: aload_0
    //   579: getfield 94	com/tencent/mm/plugin/u/i:KSY	J
    //   582: invokestatic 432	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   585: ldc2_w 433
    //   588: lcmp
    //   589: iflt -481 -> 108
    //   592: ldc 106
    //   594: ldc_w 453
    //   597: invokestatic 439	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   600: aload_0
    //   601: iconst_m1
    //   602: invokevirtual 168	com/tencent/mm/plugin/u/i:setState	(I)V
    //   605: aload_0
    //   606: invokestatic 361	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   609: putfield 94	com/tencent/mm/plugin/u/i:KSY	J
    //   612: goto -504 -> 108
    //   615: aload_0
    //   616: iconst_1
    //   617: putfield 90	com/tencent/mm/plugin/u/i:KSU	Z
    //   620: ldc 106
    //   622: aload 6
    //   624: ldc_w 455
    //   627: iconst_1
    //   628: anewarray 4	java/lang/Object
    //   631: dup
    //   632: iconst_0
    //   633: aload_0
    //   634: invokevirtual 112	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   637: aastore
    //   638: invokestatic 242	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   641: goto -212 -> 429
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	644	0	this	i
    //   0	644	1	paramLong1	long
    //   0	644	3	paramLong2	long
    //   73	31	5	bool	boolean
    //   142	28	6	localException1	Exception
    //   196	176	6	localh1	h
    //   393	28	6	localException2	Exception
    //   447	176	6	localh2	h
    //   202	349	7	str	String
    // Exception table:
    //   from	to	target	type
    //   50	75	142	java/lang/Exception
    //   80	103	393	java/lang/Exception
  }
  
  /* Error */
  protected final boolean aR(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: invokestatic 148	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   3: lstore 5
    //   5: lload_1
    //   6: ldc2_w 262
    //   9: ldiv
    //   10: ldc2_w 262
    //   13: ladd
    //   14: aload_0
    //   15: getfield 261	com/tencent/mm/plugin/u/i:durationMs	J
    //   18: lcmp
    //   19: ifge +561 -> 580
    //   22: lload_3
    //   23: ldc2_w 338
    //   26: lcmp
    //   27: ifne +553 -> 580
    //   30: ldc 106
    //   32: ldc_w 457
    //   35: invokestatic 459	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: ldc_w 461
    //   41: invokestatic 467	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   44: astore 10
    //   46: aload_0
    //   47: instanceof 469
    //   50: ifeq +54 -> 104
    //   53: aload_0
    //   54: getfield 471	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   57: ifnonnull +388 -> 445
    //   60: ldc_w 473
    //   63: astore 9
    //   65: aload 10
    //   67: ldc_w 474
    //   70: aload 9
    //   72: invokevirtual 478	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   75: pop
    //   76: aload 10
    //   78: ldc_w 479
    //   81: iconst_1
    //   82: invokevirtual 483	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   85: pop
    //   86: aload 10
    //   88: ldc_w 485
    //   91: invokestatic 490	java/lang/System:currentTimeMillis	()J
    //   94: invokevirtual 494	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   97: pop
    //   98: aload 10
    //   100: invokevirtual 497	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:commit	()Z
    //   103: pop
    //   104: aload_0
    //   105: getfield 96	com/tencent/mm/plugin/u/i:KSM	Lcom/tencent/mm/plugin/u/h;
    //   108: iconst_1
    //   109: putfield 500	com/tencent/mm/plugin/u/h:ykl	Z
    //   112: aload_0
    //   113: iconst_0
    //   114: putfield 75	com/tencent/mm/plugin/u/i:KSP	Z
    //   117: aload_0
    //   118: getfield 125	com/tencent/mm/plugin/u/i:pcp	Lcom/tencent/mm/compatible/i/c;
    //   121: getfield 131	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
    //   124: invokevirtual 503	android/media/MediaExtractor:release	()V
    //   127: aload_0
    //   128: new 127	com/tencent/mm/compatible/i/c
    //   131: dup
    //   132: invokespecial 504	com/tencent/mm/compatible/i/c:<init>	()V
    //   135: putfield 125	com/tencent/mm/plugin/u/i:pcp	Lcom/tencent/mm/compatible/i/c;
    //   138: aload_0
    //   139: getfield 471	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   142: invokestatic 508	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   145: ifne +437 -> 582
    //   148: aload_0
    //   149: getfield 471	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   152: iconst_0
    //   153: invokestatic 514	com/tencent/mm/vfs/y:eA	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   156: astore 9
    //   158: aload 9
    //   160: invokevirtual 520	java/io/RandomAccessFile:getFD	()Ljava/io/FileDescriptor;
    //   163: astore 11
    //   165: getstatic 526	com/tencent/mm/compatible/deviceinfo/af:lYa	Lcom/tencent/mm/compatible/deviceinfo/ab;
    //   168: getfield 531	com/tencent/mm/compatible/deviceinfo/ab:lXN	I
    //   171: iconst_1
    //   172: if_icmpne +282 -> 454
    //   175: aload_0
    //   176: getfield 125	com/tencent/mm/plugin/u/i:pcp	Lcom/tencent/mm/compatible/i/c;
    //   179: aload 11
    //   181: lconst_0
    //   182: aload_0
    //   183: getfield 471	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   186: invokestatic 535	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   189: invokevirtual 538	com/tencent/mm/compatible/i/c:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   192: aload 9
    //   194: invokevirtual 541	java/io/RandomAccessFile:close	()V
    //   197: aload 10
    //   199: ldc_w 474
    //   202: ldc_w 473
    //   205: invokevirtual 545	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   208: aload_0
    //   209: getfield 471	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   212: invokevirtual 551	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   215: ifeq +48 -> 263
    //   218: aload_0
    //   219: instanceof 469
    //   222: ifeq +41 -> 263
    //   225: aload 10
    //   227: ldc_w 479
    //   230: iconst_0
    //   231: invokevirtual 483	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   234: pop
    //   235: aload 10
    //   237: ldc_w 474
    //   240: ldc_w 473
    //   243: invokevirtual 478	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   246: pop
    //   247: aload 10
    //   249: ldc_w 485
    //   252: lconst_0
    //   253: invokevirtual 494	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   256: pop
    //   257: aload 10
    //   259: invokevirtual 497	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:commit	()Z
    //   262: pop
    //   263: aload_0
    //   264: getfield 125	com/tencent/mm/plugin/u/i:pcp	Lcom/tencent/mm/compatible/i/c;
    //   267: aload_0
    //   268: getfield 553	com/tencent/mm/plugin/u/i:trackIndex	I
    //   271: invokevirtual 556	com/tencent/mm/compatible/i/c:selectTrack	(I)V
    //   274: aload_0
    //   275: getfield 125	com/tencent/mm/plugin/u/i:pcp	Lcom/tencent/mm/compatible/i/c;
    //   278: lload_1
    //   279: iconst_2
    //   280: invokevirtual 560	com/tencent/mm/compatible/i/c:seekTo	(JI)V
    //   283: aload_0
    //   284: getfield 125	com/tencent/mm/plugin/u/i:pcp	Lcom/tencent/mm/compatible/i/c;
    //   287: getfield 131	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
    //   290: invokevirtual 137	android/media/MediaExtractor:getSampleTime	()J
    //   293: lstore 7
    //   295: lload 7
    //   297: lload_1
    //   298: lsub
    //   299: invokestatic 306	java/lang/Math:abs	(J)J
    //   302: ldc2_w 320
    //   305: lcmp
    //   306: ifle +74 -> 380
    //   309: aload_0
    //   310: getfield 471	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   313: ifnull +67 -> 380
    //   316: aload_0
    //   317: getfield 471	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   320: ldc_w 562
    //   323: invokevirtual 566	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   326: ifeq +54 -> 380
    //   329: getstatic 410	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   332: sipush 150
    //   335: bipush 75
    //   337: invokevirtual 570	com/tencent/mm/plugin/report/service/h:kJ	(II)V
    //   340: getstatic 410	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   343: sipush 17844
    //   346: iconst_2
    //   347: anewarray 4	java/lang/Object
    //   350: dup
    //   351: iconst_0
    //   352: iconst_1
    //   353: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   356: aastore
    //   357: dup
    //   358: iconst_1
    //   359: new 572	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 573	java/lang/StringBuilder:<init>	()V
    //   366: lload 7
    //   368: lload_1
    //   369: lsub
    //   370: invokevirtual 577	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   373: invokevirtual 578	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: aastore
    //   377: invokevirtual 429	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   380: ldc 106
    //   382: ldc_w 580
    //   385: bipush 6
    //   387: anewarray 4	java/lang/Object
    //   390: dup
    //   391: iconst_0
    //   392: aload_0
    //   393: invokevirtual 112	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   396: aastore
    //   397: dup
    //   398: iconst_1
    //   399: lload_1
    //   400: invokestatic 123	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   403: aastore
    //   404: dup
    //   405: iconst_2
    //   406: lload 7
    //   408: invokestatic 123	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   411: aastore
    //   412: dup
    //   413: iconst_3
    //   414: lload_3
    //   415: invokestatic 123	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   418: aastore
    //   419: dup
    //   420: iconst_4
    //   421: aload_0
    //   422: getfield 79	com/tencent/mm/plugin/u/i:KSR	J
    //   425: invokestatic 123	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   428: aastore
    //   429: dup
    //   430: iconst_5
    //   431: lload 5
    //   433: invokestatic 189	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   436: invokestatic 123	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   439: aastore
    //   440: invokestatic 301	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   443: iconst_1
    //   444: ireturn
    //   445: aload_0
    //   446: getfield 471	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   449: astore 9
    //   451: goto -386 -> 65
    //   454: aload_0
    //   455: getfield 125	com/tencent/mm/plugin/u/i:pcp	Lcom/tencent/mm/compatible/i/c;
    //   458: aload 11
    //   460: invokevirtual 583	com/tencent/mm/compatible/i/c:setDataSource	(Ljava/io/FileDescriptor;)V
    //   463: goto -271 -> 192
    //   466: astore 9
    //   468: ldc 106
    //   470: aload 9
    //   472: ldc_w 457
    //   475: iconst_0
    //   476: anewarray 4	java/lang/Object
    //   479: invokestatic 242	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   482: aload 10
    //   484: ldc_w 474
    //   487: ldc_w 473
    //   490: invokevirtual 545	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   493: aload_0
    //   494: getfield 471	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   497: invokevirtual 551	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   500: ifeq -237 -> 263
    //   503: aload_0
    //   504: instanceof 469
    //   507: ifeq -244 -> 263
    //   510: aload 10
    //   512: ldc_w 479
    //   515: iconst_0
    //   516: invokevirtual 483	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   519: pop
    //   520: aload 10
    //   522: ldc_w 474
    //   525: ldc_w 473
    //   528: invokevirtual 478	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   531: pop
    //   532: aload 10
    //   534: ldc_w 485
    //   537: lconst_0
    //   538: invokevirtual 494	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   541: pop
    //   542: aload 10
    //   544: invokevirtual 497	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:commit	()Z
    //   547: pop
    //   548: goto -285 -> 263
    //   551: astore 9
    //   553: ldc 106
    //   555: ldc_w 585
    //   558: iconst_2
    //   559: anewarray 4	java/lang/Object
    //   562: dup
    //   563: iconst_0
    //   564: aload_0
    //   565: invokevirtual 112	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   568: aastore
    //   569: dup
    //   570: iconst_1
    //   571: aload 9
    //   573: invokevirtual 370	java/lang/Exception:toString	()Ljava/lang/String;
    //   576: aastore
    //   577: invokestatic 317	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   580: iconst_0
    //   581: ireturn
    //   582: aload_0
    //   583: getfield 347	com/tencent/mm/plugin/u/i:KSO	Ljava/io/FileDescriptor;
    //   586: ifnull -389 -> 197
    //   589: aload_0
    //   590: getfield 347	com/tencent/mm/plugin/u/i:KSO	Ljava/io/FileDescriptor;
    //   593: invokevirtual 590	java/io/FileDescriptor:valid	()Z
    //   596: ifeq -399 -> 197
    //   599: aload_0
    //   600: getfield 125	com/tencent/mm/plugin/u/i:pcp	Lcom/tencent/mm/compatible/i/c;
    //   603: aload_0
    //   604: getfield 347	com/tencent/mm/plugin/u/i:KSO	Ljava/io/FileDescriptor;
    //   607: aload_0
    //   608: getfield 349	com/tencent/mm/plugin/u/i:cXM	J
    //   611: aload_0
    //   612: getfield 351	com/tencent/mm/plugin/u/i:length	J
    //   615: invokevirtual 538	com/tencent/mm/compatible/i/c:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   618: goto -421 -> 197
    //   621: astore 9
    //   623: aload 10
    //   625: ldc_w 474
    //   628: ldc_w 473
    //   631: invokevirtual 545	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   634: aload_0
    //   635: getfield 471	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   638: invokevirtual 551	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   641: ifeq +48 -> 689
    //   644: aload_0
    //   645: instanceof 469
    //   648: ifeq +41 -> 689
    //   651: aload 10
    //   653: ldc_w 479
    //   656: iconst_0
    //   657: invokevirtual 483	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   660: pop
    //   661: aload 10
    //   663: ldc_w 474
    //   666: ldc_w 473
    //   669: invokevirtual 478	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   672: pop
    //   673: aload 10
    //   675: ldc_w 485
    //   678: lconst_0
    //   679: invokevirtual 494	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   682: pop
    //   683: aload 10
    //   685: invokevirtual 497	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:commit	()Z
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
    //   466	5	9	localThrowable	Throwable
    //   551	21	9	localException	Exception
    //   621	69	9	localObject2	Object
    //   692	1	9	localObject3	Object
    //   44	640	10	localMultiProcessMMKV	com.tencent.mm.sdk.platformtools.MultiProcessMMKV
    //   163	296	11	localFileDescriptor	FileDescriptor
    // Exception table:
    //   from	to	target	type
    //   104	192	466	finally
    //   192	197	466	finally
    //   454	463	466	finally
    //   582	618	466	finally
    //   5	22	551	java/lang/Exception
    //   30	60	551	java/lang/Exception
    //   65	104	551	java/lang/Exception
    //   197	263	551	java/lang/Exception
    //   263	295	551	java/lang/Exception
    //   380	443	551	java/lang/Exception
    //   445	451	551	java/lang/Exception
    //   482	548	551	java/lang/Exception
    //   623	689	551	java/lang/Exception
    //   689	692	551	java/lang/Exception
    //   468	482	621	finally
    //   295	380	692	finally
  }
  
  public final long aaR(int paramInt)
  {
    Log.i("MicroMsg.TrackDataSource", "%s start to seek to ms[%d] isFeedEnd[%b]", new Object[] { info(), Integer.valueOf(paramInt), Boolean.valueOf(this.KSP) });
    this.KSP = false;
    if (this.KSS != null) {
      try
      {
        throw null;
      }
      catch (Exception localException1)
      {
        Log.printErrStackTrace("MicroMsg.TrackDataSource", localException1, "%s extractor seek exception %s", new Object[] { info(), localException1.toString() });
        return 0L;
      }
    }
    try
    {
      this.pcp.seekTo(paramInt * 1000, 0);
      if (this.pcp.lZm.getSampleTime() < 0L) {
        aR(paramInt * 1000L, -1L);
      }
      if (this.pcp.lZm.getSampleTime() < 0L)
      {
        aR(0L, -1L);
        h localh = this.KSM;
        if (localh.KSH)
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(localh.gbG(), 155L, 1L, false);
          com.tencent.mm.plugin.report.service.h.OAn.b(localh.gbF(), new Object[] { Integer.valueOf(503), Long.valueOf(Util.nowSecond()), "" });
        }
      }
      long l = this.pcp.lZm.getSampleTime();
      int i = this.pcp.lZm.getSampleFlags();
      Log.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d, %d], sampleFlag:%s", new Object[] { info(), Long.valueOf(l), Long.valueOf(this.pcp.lZm.getCachedDuration()), Integer.valueOf(i) });
      if ((i & 0x1) == 0) {
        Log.e("MicroMsg.TrackDataSource", "%s seek error, not in keyframe!!", new Object[] { info() });
      }
      if ((l == 0L) && (paramInt > 0)) {
        Log.e("MicroMsg.TrackDataSource", "%s seek error, not seek to %s", new Object[] { Integer.valueOf(paramInt * 1000), info() });
      }
      l /= 1000L;
      return l;
    }
    catch (Exception localException2)
    {
      Log.printErrStackTrace("MicroMsg.TrackDataSource", localException2, "%s extractor seek exception %s", new Object[] { info(), localException2.toString() });
    }
    return 0L;
  }
  
  protected void b(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    Log.i("MicroMsg.TrackDataSource", "%s found media format mime[%s] track[%d] format[%s]", new Object[] { info(), paramString, Integer.valueOf(paramInt), paramMediaFormat });
    this.trackIndex = paramInt;
    this.cBw = paramString;
    this.durationMs = (paramMediaFormat.getLong("durationUs") / 1000L);
    this.format = paramMediaFormat;
  }
  
  public final void gbI()
  {
    Log.i("MicroMsg.TrackDataSource", "%s flush codec", new Object[] { info() });
    this.cWV = -1;
    try
    {
      aa localaa;
      if (this.nyz != null) {
        localaa = this.nyz;
      }
      try
      {
        if (!localaa.fez) {
          Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy flush not alive");
        }
        MediaCodecProxyUtils.b.qY(96);
        localaa.lXj.flush();
        MediaCodecProxyUtils.b.qY(97);
        return;
      }
      catch (Exception localException2)
      {
        Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException2, "MediaCodecProxy flush, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
        MediaCodecProxyUtils.b.qY(39);
        localaa.lXl.getAndIncrement();
        throw localException2;
      }
      return;
    }
    catch (Exception localException1)
    {
      Log.printErrStackTrace("MicroMsg.TrackDataSource", localException1, "flushCodec exception", new Object[0]);
    }
  }
  
  protected final boolean gbJ()
  {
    try
    {
      Log.i("MicroMsg.TrackDataSource", "%s start to prepare decoder mime[%s]", new Object[] { info(), this.cBw });
      this.nyz = aa.Dw(this.cBw);
      a(this.nyz);
      this.nyz.start();
      return true;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.TrackDataSource", localException, "%s prepare decoder init decoder error ", new Object[] { info() });
      this.KSM.aMq(type());
    }
    return false;
  }
  
  protected final MediaFormat gbK()
  {
    if ((this.pcp == null) || (this.trackIndex < 0)) {
      return this.format;
    }
    return this.pcp.getTrackFormat(this.trackIndex);
  }
  
  protected g gbL()
  {
    return null;
  }
  
  protected final MediaFormat getFormat()
  {
    return this.format;
  }
  
  public final String info()
  {
    if (this.KSM != null) {
      return type() + "_" + this.KSM.info() + "_" + Process.myTid();
    }
    return type() + "_" + Process.myTid();
  }
  
  protected void onPause() {}
  
  protected void onStart() {}
  
  public final void pause()
  {
    Log.i("MicroMsg.TrackDataSource", "%s start to pause", new Object[] { info() });
    setState(4);
    onPause();
  }
  
  /* Error */
  public final boolean prepare()
  {
    // Byte code:
    //   0: ldc 106
    //   2: ldc_w 705
    //   5: iconst_2
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: aload_0
    //   12: invokevirtual 112	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   15: aastore
    //   16: dup
    //   17: iconst_1
    //   18: aload_0
    //   19: getfield 471	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   22: aastore
    //   23: invokestatic 164	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: invokestatic 148	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   29: lstore 5
    //   31: ldc_w 461
    //   34: invokestatic 467	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   37: astore 10
    //   39: aload_0
    //   40: iconst_0
    //   41: putfield 75	com/tencent/mm/plugin/u/i:KSP	Z
    //   44: ldc 106
    //   46: ldc_w 707
    //   49: iconst_1
    //   50: anewarray 4	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: aload_0
    //   56: invokevirtual 112	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   59: aastore
    //   60: invokestatic 164	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   63: aload_0
    //   64: new 127	com/tencent/mm/compatible/i/c
    //   67: dup
    //   68: invokespecial 504	com/tencent/mm/compatible/i/c:<init>	()V
    //   71: putfield 125	com/tencent/mm/plugin/u/i:pcp	Lcom/tencent/mm/compatible/i/c;
    //   74: aload_0
    //   75: instanceof 469
    //   78: ifeq +54 -> 132
    //   81: aload_0
    //   82: getfield 471	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   85: ifnonnull +355 -> 440
    //   88: ldc_w 473
    //   91: astore 9
    //   93: aload 10
    //   95: ldc_w 474
    //   98: aload 9
    //   100: invokevirtual 478	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   103: pop
    //   104: aload 10
    //   106: ldc_w 479
    //   109: iconst_1
    //   110: invokevirtual 483	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   113: pop
    //   114: aload 10
    //   116: ldc_w 485
    //   119: invokestatic 490	java/lang/System:currentTimeMillis	()J
    //   122: invokevirtual 494	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   125: pop
    //   126: aload 10
    //   128: invokevirtual 497	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:commit	()Z
    //   131: pop
    //   132: aload_0
    //   133: getfield 471	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   136: invokestatic 508	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   139: ifne +427 -> 566
    //   142: aload_0
    //   143: getfield 471	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   146: iconst_0
    //   147: invokestatic 514	com/tencent/mm/vfs/y:eA	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   150: astore 9
    //   152: aload_0
    //   153: aload 9
    //   155: invokevirtual 520	java/io/RandomAccessFile:getFD	()Ljava/io/FileDescriptor;
    //   158: putfield 347	com/tencent/mm/plugin/u/i:KSO	Ljava/io/FileDescriptor;
    //   161: getstatic 526	com/tencent/mm/compatible/deviceinfo/af:lYa	Lcom/tencent/mm/compatible/deviceinfo/ab;
    //   164: getfield 531	com/tencent/mm/compatible/deviceinfo/ab:lXN	I
    //   167: iconst_1
    //   168: if_icmpne +281 -> 449
    //   171: aload_0
    //   172: getfield 125	com/tencent/mm/plugin/u/i:pcp	Lcom/tencent/mm/compatible/i/c;
    //   175: aload_0
    //   176: getfield 347	com/tencent/mm/plugin/u/i:KSO	Ljava/io/FileDescriptor;
    //   179: lconst_0
    //   180: aload_0
    //   181: getfield 471	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   184: invokestatic 535	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   187: invokevirtual 538	com/tencent/mm/compatible/i/c:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   190: aload 9
    //   192: invokevirtual 541	java/io/RandomAccessFile:close	()V
    //   195: aload_0
    //   196: getfield 125	com/tencent/mm/plugin/u/i:pcp	Lcom/tencent/mm/compatible/i/c;
    //   199: getfield 131	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
    //   202: invokevirtual 710	android/media/MediaExtractor:getTrackCount	()I
    //   205: istore_1
    //   206: iload_1
    //   207: ifgt +943 -> 1150
    //   210: ldc 106
    //   212: ldc_w 712
    //   215: invokestatic 439	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: aload_0
    //   219: getfield 125	com/tencent/mm/plugin/u/i:pcp	Lcom/tencent/mm/compatible/i/c;
    //   222: getfield 131	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
    //   225: invokevirtual 503	android/media/MediaExtractor:release	()V
    //   228: aload_0
    //   229: new 127	com/tencent/mm/compatible/i/c
    //   232: dup
    //   233: invokespecial 504	com/tencent/mm/compatible/i/c:<init>	()V
    //   236: putfield 125	com/tencent/mm/plugin/u/i:pcp	Lcom/tencent/mm/compatible/i/c;
    //   239: aload_0
    //   240: getfield 125	com/tencent/mm/plugin/u/i:pcp	Lcom/tencent/mm/compatible/i/c;
    //   243: aload_0
    //   244: getfield 471	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   247: invokevirtual 714	com/tencent/mm/compatible/i/c:setDataSource	(Ljava/lang/String;)V
    //   250: aload_0
    //   251: getfield 125	com/tencent/mm/plugin/u/i:pcp	Lcom/tencent/mm/compatible/i/c;
    //   254: getfield 131	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
    //   257: invokevirtual 710	android/media/MediaExtractor:getTrackCount	()I
    //   260: istore_1
    //   261: aload_0
    //   262: iconst_m1
    //   263: putfield 553	com/tencent/mm/plugin/u/i:trackIndex	I
    //   266: iconst_0
    //   267: istore_2
    //   268: iload_2
    //   269: iload_1
    //   270: if_icmpge +49 -> 319
    //   273: aload_0
    //   274: getfield 125	com/tencent/mm/plugin/u/i:pcp	Lcom/tencent/mm/compatible/i/c;
    //   277: iload_2
    //   278: invokevirtual 683	com/tencent/mm/compatible/i/c:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   281: astore 9
    //   283: aload 9
    //   285: ldc_w 716
    //   288: invokevirtual 719	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   291: astore 11
    //   293: aload 11
    //   295: ifnull +419 -> 714
    //   298: aload 11
    //   300: aload_0
    //   301: invokevirtual 376	com/tencent/mm/plugin/u/i:type	()Ljava/lang/String;
    //   304: invokevirtual 566	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   307: ifeq +407 -> 714
    //   310: aload_0
    //   311: aload 9
    //   313: aload 11
    //   315: iload_2
    //   316: invokevirtual 721	com/tencent/mm/plugin/u/i:b	(Landroid/media/MediaFormat;Ljava/lang/String;I)V
    //   319: aload_0
    //   320: getfield 553	com/tencent/mm/plugin/u/i:trackIndex	I
    //   323: ifge +398 -> 721
    //   326: ldc 106
    //   328: ldc_w 723
    //   331: iconst_3
    //   332: anewarray 4	java/lang/Object
    //   335: dup
    //   336: iconst_0
    //   337: aload_0
    //   338: invokevirtual 112	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   341: aastore
    //   342: dup
    //   343: iconst_1
    //   344: iload_1
    //   345: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   348: aastore
    //   349: dup
    //   350: iconst_2
    //   351: aload_0
    //   352: getfield 553	com/tencent/mm/plugin/u/i:trackIndex	I
    //   355: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   358: aastore
    //   359: invokestatic 301	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   362: aload_0
    //   363: getfield 96	com/tencent/mm/plugin/u/i:KSM	Lcom/tencent/mm/plugin/u/h;
    //   366: ldc_w 725
    //   369: invokevirtual 728	com/tencent/mm/plugin/u/h:aMp	(Ljava/lang/String;)V
    //   372: aload 10
    //   374: ldc_w 474
    //   377: ldc_w 473
    //   380: invokevirtual 545	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   383: aload_0
    //   384: getfield 471	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   387: invokevirtual 551	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   390: ifeq +48 -> 438
    //   393: aload_0
    //   394: instanceof 469
    //   397: ifeq +41 -> 438
    //   400: aload 10
    //   402: ldc_w 479
    //   405: iconst_0
    //   406: invokevirtual 483	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   409: pop
    //   410: aload 10
    //   412: ldc_w 474
    //   415: ldc_w 473
    //   418: invokevirtual 478	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   421: pop
    //   422: aload 10
    //   424: ldc_w 485
    //   427: lconst_0
    //   428: invokevirtual 494	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   431: pop
    //   432: aload 10
    //   434: invokevirtual 497	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:commit	()Z
    //   437: pop
    //   438: iconst_0
    //   439: ireturn
    //   440: aload_0
    //   441: getfield 471	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   444: astore 9
    //   446: goto -353 -> 93
    //   449: aload_0
    //   450: getfield 125	com/tencent/mm/plugin/u/i:pcp	Lcom/tencent/mm/compatible/i/c;
    //   453: aload_0
    //   454: getfield 347	com/tencent/mm/plugin/u/i:KSO	Ljava/io/FileDescriptor;
    //   457: invokevirtual 583	com/tencent/mm/compatible/i/c:setDataSource	(Ljava/io/FileDescriptor;)V
    //   460: goto -270 -> 190
    //   463: astore 9
    //   465: ldc 106
    //   467: aload 9
    //   469: ldc_w 730
    //   472: iconst_1
    //   473: anewarray 4	java/lang/Object
    //   476: dup
    //   477: iconst_0
    //   478: aload_0
    //   479: invokevirtual 112	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   482: aastore
    //   483: invokestatic 242	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   486: aload_0
    //   487: getfield 96	com/tencent/mm/plugin/u/i:KSM	Lcom/tencent/mm/plugin/u/h;
    //   490: aload 9
    //   492: invokevirtual 370	java/lang/Exception:toString	()Ljava/lang/String;
    //   495: invokevirtual 728	com/tencent/mm/plugin/u/h:aMp	(Ljava/lang/String;)V
    //   498: aload 10
    //   500: ldc_w 474
    //   503: ldc_w 473
    //   506: invokevirtual 545	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   509: aload_0
    //   510: getfield 471	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   513: invokevirtual 551	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   516: ifeq +48 -> 564
    //   519: aload_0
    //   520: instanceof 469
    //   523: ifeq +41 -> 564
    //   526: aload 10
    //   528: ldc_w 479
    //   531: iconst_0
    //   532: invokevirtual 483	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   535: pop
    //   536: aload 10
    //   538: ldc_w 474
    //   541: ldc_w 473
    //   544: invokevirtual 478	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   547: pop
    //   548: aload 10
    //   550: ldc_w 485
    //   553: lconst_0
    //   554: invokevirtual 494	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   557: pop
    //   558: aload 10
    //   560: invokevirtual 497	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:commit	()Z
    //   563: pop
    //   564: iconst_0
    //   565: ireturn
    //   566: aload_0
    //   567: getfield 347	com/tencent/mm/plugin/u/i:KSO	Ljava/io/FileDescriptor;
    //   570: ifnull -375 -> 195
    //   573: aload_0
    //   574: getfield 347	com/tencent/mm/plugin/u/i:KSO	Ljava/io/FileDescriptor;
    //   577: invokevirtual 590	java/io/FileDescriptor:valid	()Z
    //   580: ifeq -385 -> 195
    //   583: aload_0
    //   584: getfield 125	com/tencent/mm/plugin/u/i:pcp	Lcom/tencent/mm/compatible/i/c;
    //   587: aload_0
    //   588: getfield 347	com/tencent/mm/plugin/u/i:KSO	Ljava/io/FileDescriptor;
    //   591: aload_0
    //   592: getfield 349	com/tencent/mm/plugin/u/i:cXM	J
    //   595: aload_0
    //   596: getfield 351	com/tencent/mm/plugin/u/i:length	J
    //   599: invokevirtual 538	com/tencent/mm/compatible/i/c:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   602: goto -407 -> 195
    //   605: astore 9
    //   607: ldc 106
    //   609: ldc_w 732
    //   612: iconst_2
    //   613: anewarray 4	java/lang/Object
    //   616: dup
    //   617: iconst_0
    //   618: aload_0
    //   619: invokevirtual 112	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   622: aastore
    //   623: dup
    //   624: iconst_1
    //   625: aload 9
    //   627: invokevirtual 735	java/lang/Throwable:toString	()Ljava/lang/String;
    //   630: aastore
    //   631: invokestatic 317	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   634: aload_0
    //   635: getfield 96	com/tencent/mm/plugin/u/i:KSM	Lcom/tencent/mm/plugin/u/h;
    //   638: aload 9
    //   640: invokevirtual 735	java/lang/Throwable:toString	()Ljava/lang/String;
    //   643: invokevirtual 728	com/tencent/mm/plugin/u/h:aMp	(Ljava/lang/String;)V
    //   646: aload 10
    //   648: ldc_w 474
    //   651: ldc_w 473
    //   654: invokevirtual 545	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   657: aload_0
    //   658: getfield 471	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   661: invokevirtual 551	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   664: ifeq +48 -> 712
    //   667: aload_0
    //   668: instanceof 469
    //   671: ifeq +41 -> 712
    //   674: aload 10
    //   676: ldc_w 479
    //   679: iconst_0
    //   680: invokevirtual 483	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   683: pop
    //   684: aload 10
    //   686: ldc_w 474
    //   689: ldc_w 473
    //   692: invokevirtual 478	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   695: pop
    //   696: aload 10
    //   698: ldc_w 485
    //   701: lconst_0
    //   702: invokevirtual 494	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   705: pop
    //   706: aload 10
    //   708: invokevirtual 497	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:commit	()Z
    //   711: pop
    //   712: iconst_0
    //   713: ireturn
    //   714: iload_2
    //   715: iconst_1
    //   716: iadd
    //   717: istore_2
    //   718: goto -450 -> 268
    //   721: aload_0
    //   722: getfield 125	com/tencent/mm/plugin/u/i:pcp	Lcom/tencent/mm/compatible/i/c;
    //   725: aload_0
    //   726: getfield 553	com/tencent/mm/plugin/u/i:trackIndex	I
    //   729: invokevirtual 556	com/tencent/mm/compatible/i/c:selectTrack	(I)V
    //   732: aload_0
    //   733: getfield 471	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   736: invokestatic 508	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   739: ifne +11 -> 750
    //   742: aload_0
    //   743: aload_0
    //   744: invokevirtual 737	com/tencent/mm/plugin/u/i:gbL	()Lcom/tencent/mm/plugin/u/g;
    //   747: putfield 254	com/tencent/mm/plugin/u/i:KSS	Lcom/tencent/mm/plugin/u/g;
    //   750: invokestatic 148	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   753: lstore 7
    //   755: aload 10
    //   757: ldc_w 474
    //   760: ldc_w 473
    //   763: invokevirtual 545	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   766: aload_0
    //   767: getfield 471	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   770: invokevirtual 551	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   773: ifeq +48 -> 821
    //   776: aload_0
    //   777: instanceof 469
    //   780: ifeq +41 -> 821
    //   783: aload 10
    //   785: ldc_w 479
    //   788: iconst_0
    //   789: invokevirtual 483	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   792: pop
    //   793: aload 10
    //   795: ldc_w 474
    //   798: ldc_w 473
    //   801: invokevirtual 478	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   804: pop
    //   805: aload 10
    //   807: ldc_w 485
    //   810: lconst_0
    //   811: invokevirtual 494	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   814: pop
    //   815: aload 10
    //   817: invokevirtual 497	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:commit	()Z
    //   820: pop
    //   821: ldc 106
    //   823: ldc_w 739
    //   826: iconst_3
    //   827: anewarray 4	java/lang/Object
    //   830: dup
    //   831: iconst_0
    //   832: aload_0
    //   833: invokevirtual 112	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   836: aastore
    //   837: dup
    //   838: iconst_1
    //   839: aload_0
    //   840: getfield 612	com/tencent/mm/plugin/u/i:cBw	Ljava/lang/String;
    //   843: aastore
    //   844: dup
    //   845: iconst_2
    //   846: aload_0
    //   847: getfield 100	com/tencent/mm/plugin/u/i:state	I
    //   850: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   853: aastore
    //   854: invokestatic 164	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   857: aload_0
    //   858: getfield 100	com/tencent/mm/plugin/u/i:state	I
    //   861: invokestatic 228	com/tencent/mm/plugin/u/e:aaM	(I)Z
    //   864: ifne +281 -> 1145
    //   867: aload_0
    //   868: getfield 86	com/tencent/mm/plugin/u/i:lock	Ljava/lang/Object;
    //   871: astore 9
    //   873: aload 9
    //   875: monitorenter
    //   876: ldc 106
    //   878: ldc_w 741
    //   881: iconst_2
    //   882: anewarray 4	java/lang/Object
    //   885: dup
    //   886: iconst_0
    //   887: aload_0
    //   888: invokevirtual 112	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   891: aastore
    //   892: dup
    //   893: iconst_1
    //   894: aload_0
    //   895: getfield 174	com/tencent/mm/plugin/u/i:format	Landroid/media/MediaFormat;
    //   898: aastore
    //   899: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   902: aload_0
    //   903: aload_0
    //   904: getfield 612	com/tencent/mm/plugin/u/i:cBw	Ljava/lang/String;
    //   907: invokestatic 667	com/tencent/mm/compatible/deviceinfo/aa:Dw	(Ljava/lang/String;)Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   910: putfield 150	com/tencent/mm/plugin/u/i:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   913: aload_0
    //   914: aload_0
    //   915: getfield 150	com/tencent/mm/plugin/u/i:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   918: invokevirtual 669	com/tencent/mm/plugin/u/i:a	(Lcom/tencent/mm/compatible/deviceinfo/aa;)Z
    //   921: pop
    //   922: aload_0
    //   923: getfield 150	com/tencent/mm/plugin/u/i:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   926: invokevirtual 672	com/tencent/mm/compatible/deviceinfo/aa:start	()V
    //   929: aload 9
    //   931: monitorexit
    //   932: invokestatic 148	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   935: lstore_3
    //   936: aload_0
    //   937: iconst_1
    //   938: invokevirtual 168	com/tencent/mm/plugin/u/i:setState	(I)V
    //   941: ldc 106
    //   943: ldc_w 743
    //   946: iconst_4
    //   947: anewarray 4	java/lang/Object
    //   950: dup
    //   951: iconst_0
    //   952: aload_0
    //   953: invokevirtual 112	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   956: aastore
    //   957: dup
    //   958: iconst_1
    //   959: lload 5
    //   961: invokestatic 189	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   964: invokestatic 123	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   967: aastore
    //   968: dup
    //   969: iconst_2
    //   970: lload 7
    //   972: lload 5
    //   974: lsub
    //   975: invokestatic 123	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   978: aastore
    //   979: dup
    //   980: iconst_3
    //   981: lload_3
    //   982: lload 5
    //   984: lsub
    //   985: invokestatic 123	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   988: aastore
    //   989: invokestatic 164	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   992: iconst_1
    //   993: ireturn
    //   994: astore 9
    //   996: aload 10
    //   998: ldc_w 474
    //   1001: ldc_w 473
    //   1004: invokevirtual 545	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1007: aload_0
    //   1008: getfield 471	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   1011: invokevirtual 551	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1014: ifeq +48 -> 1062
    //   1017: aload_0
    //   1018: instanceof 469
    //   1021: ifeq +41 -> 1062
    //   1024: aload 10
    //   1026: ldc_w 479
    //   1029: iconst_0
    //   1030: invokevirtual 483	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   1033: pop
    //   1034: aload 10
    //   1036: ldc_w 474
    //   1039: ldc_w 473
    //   1042: invokevirtual 478	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   1045: pop
    //   1046: aload 10
    //   1048: ldc_w 485
    //   1051: lconst_0
    //   1052: invokevirtual 494	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   1055: pop
    //   1056: aload 10
    //   1058: invokevirtual 497	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:commit	()Z
    //   1061: pop
    //   1062: aload 9
    //   1064: athrow
    //   1065: astore 10
    //   1067: aload 9
    //   1069: monitorexit
    //   1070: aload 10
    //   1072: athrow
    //   1073: astore 9
    //   1075: ldc 106
    //   1077: aload 9
    //   1079: ldc_w 745
    //   1082: iconst_2
    //   1083: anewarray 4	java/lang/Object
    //   1086: dup
    //   1087: iconst_0
    //   1088: aload_0
    //   1089: invokevirtual 112	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   1092: aastore
    //   1093: dup
    //   1094: iconst_1
    //   1095: aload 9
    //   1097: invokevirtual 370	java/lang/Exception:toString	()Ljava/lang/String;
    //   1100: aastore
    //   1101: invokestatic 242	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1104: ldc 106
    //   1106: aload 9
    //   1108: ldc_w 747
    //   1111: iconst_2
    //   1112: anewarray 4	java/lang/Object
    //   1115: dup
    //   1116: iconst_0
    //   1117: aload_0
    //   1118: invokevirtual 112	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   1121: aastore
    //   1122: dup
    //   1123: iconst_1
    //   1124: aload_0
    //   1125: getfield 174	com/tencent/mm/plugin/u/i:format	Landroid/media/MediaFormat;
    //   1128: aastore
    //   1129: invokestatic 242	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1132: aload_0
    //   1133: getfield 96	com/tencent/mm/plugin/u/i:KSM	Lcom/tencent/mm/plugin/u/h;
    //   1136: aload_0
    //   1137: invokevirtual 376	com/tencent/mm/plugin/u/i:type	()Ljava/lang/String;
    //   1140: invokevirtual 678	com/tencent/mm/plugin/u/h:aMq	(Ljava/lang/String;)V
    //   1143: iconst_0
    //   1144: ireturn
    //   1145: lconst_0
    //   1146: lstore_3
    //   1147: goto -211 -> 936
    //   1150: goto -889 -> 261
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1153	0	this	i
    //   205	140	1	i	int
    //   267	451	2	j	int
    //   935	212	3	l1	long
    //   29	954	5	l2	long
    //   753	218	7	l3	long
    //   91	354	9	localObject1	Object
    //   463	28	9	localException1	Exception
    //   605	34	9	localObject2	Object
    //   994	74	9	localObject4	Object
    //   1073	34	9	localException2	Exception
    //   37	1020	10	localMultiProcessMMKV	com.tencent.mm.sdk.platformtools.MultiProcessMMKV
    //   1065	6	10	localObject5	Object
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
    //   721	750	463	java/lang/Exception
    //   750	755	463	java/lang/Exception
    //   44	88	605	finally
    //   93	132	605	finally
    //   132	190	605	finally
    //   190	195	605	finally
    //   195	206	605	finally
    //   210	261	605	finally
    //   261	266	605	finally
    //   273	293	605	finally
    //   298	319	605	finally
    //   319	372	605	finally
    //   440	446	605	finally
    //   449	460	605	finally
    //   566	602	605	finally
    //   721	750	605	finally
    //   750	755	605	finally
    //   465	498	994	finally
    //   607	646	994	finally
    //   876	932	1065	finally
    //   821	876	1073	java/lang/Exception
    //   932	936	1073	java/lang/Exception
    //   1067	1073	1073	java/lang/Exception
  }
  
  public void release()
  {
    Log.i("MicroMsg.TrackDataSource", "%s release doubleReleaseSwitch:[%b]", new Object[] { info(), Boolean.valueOf(KSV) });
    if (KSV)
    {
      Log.i("MicroMsg.TrackDataSource", "%s into release fun", new Object[] { info() });
      if (this.pcp != null)
      {
        Log.i("MicroMsg.TrackDataSource", "%s release,  extractor != null", new Object[] { info() });
        this.pcp.lZm.release();
        this.pcp = null;
      }
      releaseDecoder();
      if (this.KSS != null)
      {
        Log.i("MicroMsg.TrackDataSource", "%s release,  mp4Extractor != null", new Object[] { info() });
        throw null;
      }
      Log.i("MicroMsg.TrackDataSource", "%s finish release", new Object[] { info() });
      return;
    }
    Log.i("MicroMsg.TrackDataSource", "%s release", new Object[] { info() });
    if (this.pcp != null)
    {
      this.pcp.lZm.release();
      this.pcp = null;
    }
    if (this.nyz != null)
    {
      this.nyz.release();
      this.nyz = null;
    }
    if (this.KSS != null) {
      throw null;
    }
    Log.i("MicroMsg.TrackDataSource", "%s finish release", new Object[] { info() });
  }
  
  /* Error */
  protected final void releaseDecoder()
  {
    // Byte code:
    //   0: ldc 106
    //   2: ldc_w 765
    //   5: iconst_2
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: aload_0
    //   12: invokevirtual 112	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   15: aastore
    //   16: dup
    //   17: iconst_1
    //   18: getstatic 66	com/tencent/mm/plugin/u/i:KSV	Z
    //   21: invokestatic 222	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   24: aastore
    //   25: invokestatic 164	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: getstatic 66	com/tencent/mm/plugin/u/i:KSV	Z
    //   31: ifeq +217 -> 248
    //   34: invokestatic 148	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   37: lstore_1
    //   38: aload_0
    //   39: getfield 86	com/tencent/mm/plugin/u/i:lock	Ljava/lang/Object;
    //   42: astore_3
    //   43: aload_3
    //   44: monitorenter
    //   45: aload_0
    //   46: getfield 150	com/tencent/mm/plugin/u/i:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   49: ifnull +177 -> 226
    //   52: ldc 106
    //   54: ldc_w 767
    //   57: iconst_1
    //   58: anewarray 4	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: aload_0
    //   64: invokevirtual 112	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   67: aastore
    //   68: invokestatic 164	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: aload_0
    //   72: invokevirtual 373	com/tencent/mm/plugin/u/i:gbI	()V
    //   75: ldc 106
    //   77: ldc_w 769
    //   80: iconst_2
    //   81: anewarray 4	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: aload_0
    //   87: invokevirtual 112	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   90: aastore
    //   91: dup
    //   92: iconst_1
    //   93: lload_1
    //   94: invokestatic 189	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   97: invokestatic 123	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   100: aastore
    //   101: invokestatic 164	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   104: aload_0
    //   105: getfield 150	com/tencent/mm/plugin/u/i:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   108: invokevirtual 772	com/tencent/mm/compatible/deviceinfo/aa:stop	()V
    //   111: aload_0
    //   112: getfield 150	com/tencent/mm/plugin/u/i:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   115: invokevirtual 763	com/tencent/mm/compatible/deviceinfo/aa:release	()V
    //   118: aload_0
    //   119: aconst_null
    //   120: putfield 150	com/tencent/mm/plugin/u/i:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   123: ldc 106
    //   125: ldc_w 774
    //   128: iconst_2
    //   129: anewarray 4	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: aload_0
    //   135: invokevirtual 112	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   138: aastore
    //   139: dup
    //   140: iconst_1
    //   141: lload_1
    //   142: invokestatic 189	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   145: invokestatic 123	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   148: aastore
    //   149: invokestatic 164	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: aload_3
    //   153: monitorexit
    //   154: return
    //   155: astore 4
    //   157: aload_0
    //   158: aconst_null
    //   159: putfield 150	com/tencent/mm/plugin/u/i:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   162: aload 4
    //   164: athrow
    //   165: astore 4
    //   167: aload_3
    //   168: monitorexit
    //   169: aload 4
    //   171: athrow
    //   172: astore 4
    //   174: aload_0
    //   175: getfield 150	com/tencent/mm/plugin/u/i:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   178: invokevirtual 763	com/tencent/mm/compatible/deviceinfo/aa:release	()V
    //   181: aload_0
    //   182: aconst_null
    //   183: putfield 150	com/tencent/mm/plugin/u/i:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   186: goto -63 -> 123
    //   189: astore 4
    //   191: aload_0
    //   192: aconst_null
    //   193: putfield 150	com/tencent/mm/plugin/u/i:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   196: aload 4
    //   198: athrow
    //   199: astore 4
    //   201: aload_0
    //   202: getfield 150	com/tencent/mm/plugin/u/i:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   205: invokevirtual 763	com/tencent/mm/compatible/deviceinfo/aa:release	()V
    //   208: aload_0
    //   209: aconst_null
    //   210: putfield 150	com/tencent/mm/plugin/u/i:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   213: aload 4
    //   215: athrow
    //   216: astore 4
    //   218: aload_0
    //   219: aconst_null
    //   220: putfield 150	com/tencent/mm/plugin/u/i:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   223: aload 4
    //   225: athrow
    //   226: ldc 106
    //   228: ldc_w 776
    //   231: iconst_1
    //   232: anewarray 4	java/lang/Object
    //   235: dup
    //   236: iconst_0
    //   237: aload_0
    //   238: invokevirtual 112	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   241: aastore
    //   242: invokestatic 164	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   245: goto -93 -> 152
    //   248: aload_0
    //   249: getfield 150	com/tencent/mm/plugin/u/i:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   252: ifnull +188 -> 440
    //   255: ldc 106
    //   257: ldc_w 767
    //   260: iconst_1
    //   261: anewarray 4	java/lang/Object
    //   264: dup
    //   265: iconst_0
    //   266: aload_0
    //   267: invokevirtual 112	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   270: aastore
    //   271: invokestatic 164	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: aload_0
    //   275: invokevirtual 373	com/tencent/mm/plugin/u/i:gbI	()V
    //   278: invokestatic 148	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   281: lstore_1
    //   282: aload_0
    //   283: getfield 86	com/tencent/mm/plugin/u/i:lock	Ljava/lang/Object;
    //   286: astore_3
    //   287: aload_3
    //   288: monitorenter
    //   289: ldc 106
    //   291: ldc_w 769
    //   294: iconst_2
    //   295: anewarray 4	java/lang/Object
    //   298: dup
    //   299: iconst_0
    //   300: aload_0
    //   301: invokevirtual 112	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   304: aastore
    //   305: dup
    //   306: iconst_1
    //   307: lload_1
    //   308: invokestatic 189	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   311: invokestatic 123	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   314: aastore
    //   315: invokestatic 164	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   318: aload_0
    //   319: getfield 150	com/tencent/mm/plugin/u/i:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   322: invokevirtual 772	com/tencent/mm/compatible/deviceinfo/aa:stop	()V
    //   325: aload_0
    //   326: getfield 150	com/tencent/mm/plugin/u/i:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   329: invokevirtual 763	com/tencent/mm/compatible/deviceinfo/aa:release	()V
    //   332: aload_0
    //   333: aconst_null
    //   334: putfield 150	com/tencent/mm/plugin/u/i:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   337: aload_3
    //   338: monitorexit
    //   339: ldc 106
    //   341: ldc_w 774
    //   344: iconst_2
    //   345: anewarray 4	java/lang/Object
    //   348: dup
    //   349: iconst_0
    //   350: aload_0
    //   351: invokevirtual 112	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   354: aastore
    //   355: dup
    //   356: iconst_1
    //   357: lload_1
    //   358: invokestatic 189	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   361: invokestatic 123	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   364: aastore
    //   365: invokestatic 164	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   368: return
    //   369: astore 4
    //   371: aload_0
    //   372: aconst_null
    //   373: putfield 150	com/tencent/mm/plugin/u/i:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   376: aload 4
    //   378: athrow
    //   379: astore 4
    //   381: aload_3
    //   382: monitorexit
    //   383: aload 4
    //   385: athrow
    //   386: astore 4
    //   388: aload_0
    //   389: getfield 150	com/tencent/mm/plugin/u/i:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   392: invokevirtual 763	com/tencent/mm/compatible/deviceinfo/aa:release	()V
    //   395: aload_0
    //   396: aconst_null
    //   397: putfield 150	com/tencent/mm/plugin/u/i:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   400: goto -63 -> 337
    //   403: astore 4
    //   405: aload_0
    //   406: aconst_null
    //   407: putfield 150	com/tencent/mm/plugin/u/i:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   410: aload 4
    //   412: athrow
    //   413: astore 4
    //   415: aload_0
    //   416: getfield 150	com/tencent/mm/plugin/u/i:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   419: invokevirtual 763	com/tencent/mm/compatible/deviceinfo/aa:release	()V
    //   422: aload_0
    //   423: aconst_null
    //   424: putfield 150	com/tencent/mm/plugin/u/i:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   427: aload 4
    //   429: athrow
    //   430: astore 4
    //   432: aload_0
    //   433: aconst_null
    //   434: putfield 150	com/tencent/mm/plugin/u/i:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   437: aload 4
    //   439: athrow
    //   440: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	441	0	this	i
    //   37	321	1	l	long
    //   42	340	3	localObject1	Object
    //   155	8	4	localObject2	Object
    //   165	5	4	localObject3	Object
    //   172	1	4	localException1	Exception
    //   189	8	4	localObject4	Object
    //   199	15	4	localObject5	Object
    //   216	8	4	localObject6	Object
    //   369	8	4	localObject7	Object
    //   379	5	4	localObject8	Object
    //   386	1	4	localException2	Exception
    //   403	8	4	localObject9	Object
    //   413	15	4	localObject10	Object
    //   430	8	4	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   111	118	155	finally
    //   45	104	165	finally
    //   118	123	165	finally
    //   123	152	165	finally
    //   152	154	165	finally
    //   157	165	165	finally
    //   181	186	165	finally
    //   191	199	165	finally
    //   208	216	165	finally
    //   218	226	165	finally
    //   226	245	165	finally
    //   104	111	172	java/lang/Exception
    //   174	181	189	finally
    //   104	111	199	finally
    //   201	208	216	finally
    //   325	332	369	finally
    //   289	318	379	finally
    //   332	337	379	finally
    //   337	339	379	finally
    //   371	379	379	finally
    //   395	400	379	finally
    //   405	413	379	finally
    //   422	430	379	finally
    //   432	440	379	finally
    //   318	325	386	java/lang/Exception
    //   388	395	403	finally
    //   318	325	413	finally
    //   415	422	430	finally
  }
  
  public final void setPath(String paramString)
  {
    this.path = paramString;
  }
  
  protected final void setState(int paramInt)
  {
    Log.i("MicroMsg.TrackDataSource", "%s set state old %d new %d", new Object[] { info(), Integer.valueOf(this.state), Integer.valueOf(paramInt) });
    this.state = paramInt;
  }
  
  public final void start()
  {
    Log.i("MicroMsg.TrackDataSource", "%s start to play", new Object[] { info() });
    this.KSP = false;
    setState(3);
    onStart();
  }
  
  abstract String type();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.u.i
 * JD-Core Version:    0.7.0.1
 */