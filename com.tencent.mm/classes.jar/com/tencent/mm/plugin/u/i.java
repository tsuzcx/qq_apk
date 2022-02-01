package com.tencent.mm.plugin.u;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Message;
import android.os.Process;
import com.tencent.mm.compatible.deviceinfo.MediaCodecProxyUtils.b;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.k.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.FileDescriptor;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class i
{
  private static boolean EXk;
  private static long EXl;
  protected h EXa;
  protected MMHandler EXb;
  protected FileDescriptor EXc;
  private volatile boolean EXd = false;
  b EXe = null;
  protected long EXf = 0L;
  private MediaFormat EXg;
  private g EXh;
  private boolean EXi = false;
  private boolean EXj = false;
  private long EXm = 0L;
  private long EXn = 0L;
  protected long aFL;
  private String aFM;
  private MediaCodec.BufferInfo bcK = new MediaCodec.BufferInfo();
  protected long bdS;
  private volatile int bdb;
  long durationMs;
  protected aa kSN;
  private final Object lock = new Object();
  private c miS;
  protected String path;
  protected volatile int state;
  private int trackIndex;
  
  static
  {
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFF, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      EXk = bool;
      EXl = 0L;
      return;
    }
  }
  
  public i(h paramh, MMHandler paramMMHandler)
  {
    this.EXa = paramh;
    this.EXb = paramMMHandler;
    this.state = 0;
    this.bdb = -1;
  }
  
  private void eSO()
  {
    if (this.EXe != null) {
      this.EXf = (this.EXe.eSG() * 1000L);
    }
  }
  
  private boolean h(long paramLong1, long paramLong2)
  {
    Log.d("MicroMsg.TrackDataSource", "%s drain output buffer state:%s time[%d %d %s] index %d", new Object[] { info(), Integer.valueOf(this.state), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(this.miS.jvU.getSampleTime()), Integer.valueOf(this.bdb) });
    long l = Util.currentTicks();
    if (this.bdb < 0)
    {
      synchronized (this.lock)
      {
        this.bdb = this.kSN.a(this.bcK, EXl);
        if (this.bdb >= 0)
        {
          if ((this.bcK.flags & 0x4) == 0) {
            break label256;
          }
          Log.i("MicroMsg.TrackDataSource", "%s process end of stream", new Object[] { info() });
          setState(9);
          this.bdb = -1;
          return false;
        }
      }
      if (this.bdb == -2)
      {
        ??? = this.kSN.avi();
        this.EXg = ((MediaFormat)???);
        a(this.kSN, (MediaFormat)???);
        return true;
      }
      if (this.bdb == -3) {
        return true;
      }
      Log.d("MicroMsg.TrackDataSource", "%s drain output buffer error outputIndex[%d] state:%s", new Object[] { info(), Integer.valueOf(this.bdb), Integer.valueOf(this.state) });
      return false;
    }
    label256:
    if (this.state == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.kSN.releaseOutputBuffer(this.bdb, true);
      this.bdb = -1;
      setState(2);
      return true;
    }
    Log.d("MicroMsg.TrackDataSource", "%s process output buffer state:%s: index %d, cost:%s", new Object[] { info(), Integer.valueOf(this.state), Integer.valueOf(this.bdb), Long.valueOf(Util.ticksToNow(l)) });
    synchronized (this.lock)
    {
      if (this.bdb >= 0)
      {
        ByteBuffer localByteBuffer = this.kSN.getOutputBuffer(this.bdb);
        if (localByteBuffer != null)
        {
          localByteBuffer.position(this.bcK.offset);
          localByteBuffer.limit(this.bcK.offset + this.bcK.size);
        }
        if (a(paramLong1, paramLong2, this.kSN, localByteBuffer, this.bdb, this.bcK))
        {
          this.bdb = -1;
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean sZ()
  {
    int k;
    try
    {
      Log.d("MicroMsg.TrackDataSource", "doubleReleaseSwitch:[%b]", new Object[] { Boolean.valueOf(EXk) });
      if ((e.WK(this.state)) || (this.EXd))
      {
        Log.d("MicroMsg.TrackDataSource", "%s feed input buffer is end.", new Object[] { info() });
        return false;
      }
      k = -1;
      synchronized (this.lock)
      {
        if (this.kSN != null)
        {
          i = this.kSN.EX(0L);
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
    ??? = this.kSN.getInputBuffer(k);
    Log.d("MicroMsg.TrackDataSource", "%s start to feed input buffer index %d [%d, %b]", new Object[] { info(), Integer.valueOf(k), Integer.valueOf(this.state), Boolean.valueOf(this.EXd) });
    if (a.cPp()) {}
    for (int m = -1;; m = 0)
    {
      if (this.EXh != null) {
        throw null;
      }
      if (this.EXa.EWW)
      {
        if (EXk) {}
        for (;;)
        {
          synchronized (this.lock)
          {
            if (this.kSN != null) {
              this.kSN.a(k, 0, this.durationMs * 1000L, 4);
            }
            this.EXd = true;
            this.EXa.EWW = false;
            return false;
          }
          this.kSN.a(k, 0, this.durationMs * 1000L, 4);
        }
      }
      long l1 = 0L;
      if (??? != null) {}
      for (;;)
      {
        try
        {
          i = this.miS.readSampleData((ByteBuffer)???, 0);
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
          l2 = this.miS.jvU.getSampleTime();
          l1 = l2;
          n = this.miS.jvU.getSampleFlags();
          l1 = l2;
          j = i;
          i = n;
          Log.d("MicroMsg.TrackDataSource", "%s read data, state:%s index[%d, %d] sample info[%d, %d]", new Object[] { info(), Integer.valueOf(this.state), Integer.valueOf(k), Integer.valueOf(j), Long.valueOf(l1), Integer.valueOf(i) });
          aA(i, l1);
          if (j > m) {
            continue;
          }
          Log.i("MicroMsg.TrackDataSource", "read data index eof. sampleSize:%d", new Object[] { Integer.valueOf(j) });
          if (!EXk) {
            continue;
          }
        }
        catch (Exception localException2)
        {
          continue;
        }
        synchronized (this.lock)
        {
          if (this.kSN != null) {
            this.kSN.a(k, 0, this.durationMs * 1000L, 4);
          }
          this.EXd = true;
          return false;
          Log.printErrStackTrace("MicroMsg.TrackDataSource", (Throwable)???, "MediaExtractor get sample data error: %s", new Object[] { ((Exception)???).getMessage() });
          n = 0;
          j = i;
          i = n;
        }
        this.kSN.a(k, 0, this.durationMs * 1000L, 4);
        continue;
        if (j > 0)
        {
          if (EXk) {
            synchronized (this.lock)
            {
              if (this.kSN != null) {
                this.kSN.a(k, j, l1, 0);
              }
              this.miS.jvU.advance();
              l2 = this.miS.jvU.getSampleTime();
              if (this.EXa.uXY) {
                continue;
              }
              if (ai(l1, l2))
              {
                Log.w("MicroMsg.TrackDataSource", "%s feed input buffer isOnlineVideo[%b] next[%d] onlineCacheMs[%d]", new Object[] { info(), Boolean.valueOf(this.EXa.uXY), Long.valueOf(l2), Long.valueOf(this.EXf) });
                l3 = this.miS.jvU.getSampleTime();
                if (Math.abs(l3 - l1) >= 1000000L)
                {
                  Log.w("MicroMsg.TrackDataSource", "%s reset extractor finish but seek time is not right[%d, %d]", new Object[] { info(), Long.valueOf(l3), Long.valueOf(l1) });
                  this.EXa.EWW = true;
                }
              }
              Log.d("MicroMsg.TrackDataSource", "%s finish to feed input buffer [%d, %d]", new Object[] { info(), Long.valueOf(l1), Long.valueOf(l2) });
              return false;
            }
          }
          this.kSN.a(k, j, l1, 0);
          continue;
        }
        Log.e("MicroMsg.TrackDataSource", "%s read data index[%d, %d] sample info[%d, %d]", new Object[] { info(), Integer.valueOf(k), Integer.valueOf(j), Long.valueOf(l1), Integer.valueOf(i) });
        continue;
        if (this.EXf == 0L)
        {
          if (ai(l1, l2))
          {
            Log.w("MicroMsg.TrackDataSource", "%s feed input buffer next[%d] onlineCacheMs[%d]", new Object[] { info(), Long.valueOf(l2), Long.valueOf(this.EXf) });
            l3 = this.miS.jvU.getSampleTime();
            if (Math.abs(l3 - l1) >= 3000000L)
            {
              Log.w("MicroMsg.TrackDataSource", "%s reset extractor finish but seek time is not right[%d, %d]", new Object[] { info(), Long.valueOf(l3), Long.valueOf(l1) });
              this.EXb.obtainMessage(5, -2, -2).sendToTarget();
            }
            eSO();
          }
        }
        else if ((l2 < 0L) || (l2 / 1000L + 1200L > this.EXf))
        {
          Log.w("MicroMsg.TrackDataSource", "%s feed input buffer next[%d] onlineCacheMs[%d]", new Object[] { info(), Long.valueOf(l2), Long.valueOf(this.EXf) });
          if (ai(l1, -1L)) {
            this.EXb.obtainMessage(5, -3, -3).sendToTarget();
          }
          eSO();
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
  
  public final long WP(int paramInt)
  {
    Log.i("MicroMsg.TrackDataSource", "%s start to seek to ms[%d] isFeedEnd[%b]", new Object[] { info(), Integer.valueOf(paramInt), Boolean.valueOf(this.EXd) });
    this.EXd = false;
    if (this.EXh != null) {
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
      this.miS.seekTo(paramInt * 1000, 0);
      if (this.miS.jvU.getSampleTime() < 0L) {
        ai(paramInt * 1000L, -1L);
      }
      if (this.miS.jvU.getSampleTime() < 0L)
      {
        ai(0L, -1L);
        h localh = this.EXa;
        if (localh.EWV)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(localh.eSN(), 155L, 1L, false);
          com.tencent.mm.plugin.report.service.h.IzE.a(localh.eSM(), new Object[] { Integer.valueOf(503), Long.valueOf(Util.nowSecond()), "" });
        }
      }
      long l = this.miS.jvU.getSampleTime();
      int i = this.miS.jvU.getSampleFlags();
      Log.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d, %d], sampleFlag:%s", new Object[] { info(), Long.valueOf(l), Long.valueOf(this.miS.jvU.getCachedDuration()), Integer.valueOf(i) });
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
  
  protected void a(aa paramaa, MediaFormat paramMediaFormat) {}
  
  public final void a(FileDescriptor paramFileDescriptor, long paramLong1, long paramLong2)
  {
    this.EXc = paramFileDescriptor;
    this.bdS = paramLong1;
    this.aFL = paramLong2;
  }
  
  abstract boolean a(long paramLong1, long paramLong2, aa paramaa, ByteBuffer paramByteBuffer, int paramInt, MediaCodec.BufferInfo paramBufferInfo);
  
  abstract boolean a(aa paramaa);
  
  protected boolean aA(int paramInt, long paramLong)
  {
    return false;
  }
  
  /* Error */
  protected final int ah(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc 115
    //   2: ldc_w 406
    //   5: iconst_4
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: aload_0
    //   12: invokevirtual 121	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
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
    //   33: getfield 100	com/tencent/mm/plugin/u/i:state	I
    //   36: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   39: aastore
    //   40: invokestatic 151	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: aload_0
    //   44: getfield 158	com/tencent/mm/plugin/u/i:kSN	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   47: ifnull +38 -> 85
    //   50: aload_0
    //   51: lload_1
    //   52: lload_3
    //   53: invokespecial 408	com/tencent/mm/plugin/u/i:h	(JJ)Z
    //   56: ifeq +24 -> 80
    //   59: aload_0
    //   60: invokestatic 411	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   63: putfield 92	com/tencent/mm/plugin/u/i:EXm	J
    //   66: aload_0
    //   67: getfield 100	com/tencent/mm/plugin/u/i:state	I
    //   70: invokestatic 235	com/tencent/mm/plugin/u/e:WK	(I)Z
    //   73: istore 5
    //   75: iload 5
    //   77: ifeq -27 -> 50
    //   80: aload_0
    //   81: invokespecial 413	com/tencent/mm/plugin/u/i:sZ	()Z
    //   84: pop
    //   85: ldc 115
    //   87: ldc_w 415
    //   90: iconst_2
    //   91: anewarray 4	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: aload_0
    //   97: invokevirtual 121	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   100: aastore
    //   101: dup
    //   102: iconst_1
    //   103: aload_0
    //   104: getfield 100	com/tencent/mm/plugin/u/i:state	I
    //   107: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   110: aastore
    //   111: invokestatic 151	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   114: aload_0
    //   115: getfield 100	com/tencent/mm/plugin/u/i:state	I
    //   118: ireturn
    //   119: astore 6
    //   121: aload_0
    //   122: getfield 88	com/tencent/mm/plugin/u/i:EXi	Z
    //   125: ifeq +216 -> 341
    //   128: ldc 115
    //   130: ldc_w 417
    //   133: iconst_2
    //   134: anewarray 4	java/lang/Object
    //   137: dup
    //   138: iconst_0
    //   139: aload_0
    //   140: invokevirtual 121	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   143: aastore
    //   144: dup
    //   145: iconst_1
    //   146: aload 6
    //   148: invokevirtual 352	java/lang/Exception:toString	()Ljava/lang/String;
    //   151: aastore
    //   152: invokestatic 322	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload_0
    //   156: getfield 100	com/tencent/mm/plugin/u/i:state	I
    //   159: invokestatic 235	com/tencent/mm/plugin/u/e:WK	(I)Z
    //   162: ifne +7 -> 169
    //   165: aload_0
    //   166: invokevirtual 420	com/tencent/mm/plugin/u/i:eSP	()V
    //   169: aload_0
    //   170: getfield 96	com/tencent/mm/plugin/u/i:EXa	Lcom/tencent/mm/plugin/u/h;
    //   173: astore 6
    //   175: aload_0
    //   176: invokevirtual 423	com/tencent/mm/plugin/u/i:type	()Ljava/lang/String;
    //   179: astore 7
    //   181: aload 6
    //   183: getfield 426	com/tencent/mm/plugin/u/h:EWY	Z
    //   186: ifne +102 -> 288
    //   189: aload 6
    //   191: getfield 359	com/tencent/mm/plugin/u/h:EWV	Z
    //   194: ifeq +94 -> 288
    //   197: getstatic 431	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   200: ifne +15 -> 215
    //   203: getstatic 434	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_RED	Z
    //   206: ifne +9 -> 215
    //   209: getstatic 437	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_PURPLE	Z
    //   212: ifeq +15 -> 227
    //   215: new 439	com/tencent/mm/plugin/u/h$2
    //   218: dup
    //   219: aload 6
    //   221: invokespecial 442	com/tencent/mm/plugin/u/h$2:<init>	(Lcom/tencent/mm/plugin/u/h;)V
    //   224: invokestatic 448	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   227: getstatic 365	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   230: aload 6
    //   232: invokevirtual 368	com/tencent/mm/plugin/u/h:eSN	()I
    //   235: i2l
    //   236: ldc2_w 449
    //   239: lconst_1
    //   240: iconst_0
    //   241: invokevirtual 374	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   244: getstatic 365	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   247: aload 6
    //   249: invokevirtual 377	com/tencent/mm/plugin/u/h:eSM	()I
    //   252: iconst_3
    //   253: anewarray 4	java/lang/Object
    //   256: dup
    //   257: iconst_0
    //   258: sipush 506
    //   261: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   264: aastore
    //   265: dup
    //   266: iconst_1
    //   267: invokestatic 380	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   270: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   273: aastore
    //   274: dup
    //   275: iconst_2
    //   276: aload 7
    //   278: aastore
    //   279: invokevirtual 385	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   282: aload 6
    //   284: iconst_1
    //   285: putfield 426	com/tencent/mm/plugin/u/h:EWY	Z
    //   288: aload_0
    //   289: getfield 92	com/tencent/mm/plugin/u/i:EXm	J
    //   292: lconst_0
    //   293: lcmp
    //   294: ifne +10 -> 304
    //   297: aload_0
    //   298: invokestatic 411	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   301: putfield 92	com/tencent/mm/plugin/u/i:EXm	J
    //   304: aload_0
    //   305: getfield 92	com/tencent/mm/plugin/u/i:EXm	J
    //   308: invokestatic 453	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   311: ldc2_w 454
    //   314: lcmp
    //   315: iflt -235 -> 80
    //   318: ldc 115
    //   320: ldc_w 457
    //   323: invokestatic 460	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   326: aload_0
    //   327: iconst_m1
    //   328: invokevirtual 175	com/tencent/mm/plugin/u/i:setState	(I)V
    //   331: aload_0
    //   332: invokestatic 411	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   335: putfield 92	com/tencent/mm/plugin/u/i:EXm	J
    //   338: goto -258 -> 80
    //   341: aload_0
    //   342: iconst_1
    //   343: putfield 88	com/tencent/mm/plugin/u/i:EXi	Z
    //   346: ldc 115
    //   348: aload 6
    //   350: ldc_w 462
    //   353: iconst_1
    //   354: anewarray 4	java/lang/Object
    //   357: dup
    //   358: iconst_0
    //   359: aload_0
    //   360: invokevirtual 121	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   363: aastore
    //   364: invokestatic 249	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   367: goto -212 -> 155
    //   370: astore 6
    //   372: aload_0
    //   373: getfield 90	com/tencent/mm/plugin/u/i:EXj	Z
    //   376: ifeq +216 -> 592
    //   379: ldc 115
    //   381: ldc_w 464
    //   384: iconst_2
    //   385: anewarray 4	java/lang/Object
    //   388: dup
    //   389: iconst_0
    //   390: aload_0
    //   391: invokevirtual 121	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   394: aastore
    //   395: dup
    //   396: iconst_1
    //   397: aload 6
    //   399: invokevirtual 352	java/lang/Exception:toString	()Ljava/lang/String;
    //   402: aastore
    //   403: invokestatic 322	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   406: aload_0
    //   407: getfield 100	com/tencent/mm/plugin/u/i:state	I
    //   410: invokestatic 235	com/tencent/mm/plugin/u/e:WK	(I)Z
    //   413: ifne +7 -> 420
    //   416: aload_0
    //   417: invokevirtual 420	com/tencent/mm/plugin/u/i:eSP	()V
    //   420: aload_0
    //   421: getfield 96	com/tencent/mm/plugin/u/i:EXa	Lcom/tencent/mm/plugin/u/h;
    //   424: astore 6
    //   426: aload_0
    //   427: invokevirtual 423	com/tencent/mm/plugin/u/i:type	()Ljava/lang/String;
    //   430: astore 7
    //   432: aload 6
    //   434: getfield 467	com/tencent/mm/plugin/u/h:EWX	Z
    //   437: ifne +102 -> 539
    //   440: aload 6
    //   442: getfield 359	com/tencent/mm/plugin/u/h:EWV	Z
    //   445: ifeq +94 -> 539
    //   448: getstatic 431	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   451: ifne +15 -> 466
    //   454: getstatic 434	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_RED	Z
    //   457: ifne +9 -> 466
    //   460: getstatic 437	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_PURPLE	Z
    //   463: ifeq +15 -> 478
    //   466: new 469	com/tencent/mm/plugin/u/h$1
    //   469: dup
    //   470: aload 6
    //   472: invokespecial 470	com/tencent/mm/plugin/u/h$1:<init>	(Lcom/tencent/mm/plugin/u/h;)V
    //   475: invokestatic 448	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   478: getstatic 365	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   481: aload 6
    //   483: invokevirtual 368	com/tencent/mm/plugin/u/h:eSN	()I
    //   486: i2l
    //   487: ldc2_w 471
    //   490: lconst_1
    //   491: iconst_0
    //   492: invokevirtual 374	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   495: getstatic 365	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   498: aload 6
    //   500: invokevirtual 377	com/tencent/mm/plugin/u/h:eSM	()I
    //   503: iconst_3
    //   504: anewarray 4	java/lang/Object
    //   507: dup
    //   508: iconst_0
    //   509: sipush 505
    //   512: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   515: aastore
    //   516: dup
    //   517: iconst_1
    //   518: invokestatic 380	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   521: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   524: aastore
    //   525: dup
    //   526: iconst_2
    //   527: aload 7
    //   529: aastore
    //   530: invokevirtual 385	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   533: aload 6
    //   535: iconst_1
    //   536: putfield 467	com/tencent/mm/plugin/u/h:EWX	Z
    //   539: aload_0
    //   540: getfield 94	com/tencent/mm/plugin/u/i:EXn	J
    //   543: lconst_0
    //   544: lcmp
    //   545: ifne +10 -> 555
    //   548: aload_0
    //   549: invokestatic 411	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   552: putfield 94	com/tencent/mm/plugin/u/i:EXn	J
    //   555: aload_0
    //   556: getfield 94	com/tencent/mm/plugin/u/i:EXn	J
    //   559: invokestatic 453	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   562: ldc2_w 454
    //   565: lcmp
    //   566: iflt -481 -> 85
    //   569: ldc 115
    //   571: ldc_w 474
    //   574: invokestatic 460	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   577: aload_0
    //   578: iconst_m1
    //   579: invokevirtual 175	com/tencent/mm/plugin/u/i:setState	(I)V
    //   582: aload_0
    //   583: invokestatic 411	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   586: putfield 94	com/tencent/mm/plugin/u/i:EXn	J
    //   589: goto -504 -> 85
    //   592: aload_0
    //   593: iconst_1
    //   594: putfield 90	com/tencent/mm/plugin/u/i:EXj	Z
    //   597: ldc 115
    //   599: aload 6
    //   601: ldc_w 476
    //   604: iconst_1
    //   605: anewarray 4	java/lang/Object
    //   608: dup
    //   609: iconst_0
    //   610: aload_0
    //   611: invokevirtual 121	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   614: aastore
    //   615: invokestatic 249	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   618: goto -212 -> 406
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	621	0	this	i
    //   0	621	1	paramLong1	long
    //   0	621	3	paramLong2	long
    //   73	3	5	bool	boolean
    //   119	28	6	localException1	Exception
    //   173	176	6	localh1	h
    //   370	28	6	localException2	Exception
    //   424	176	6	localh2	h
    //   179	349	7	str	String
    // Exception table:
    //   from	to	target	type
    //   50	75	119	java/lang/Exception
    //   80	85	370	java/lang/Exception
  }
  
  /* Error */
  protected final boolean ai(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: invokestatic 156	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   3: lstore 5
    //   5: lload_1
    //   6: ldc2_w 110
    //   9: ldiv
    //   10: ldc2_w 110
    //   13: ladd
    //   14: aload_0
    //   15: getfield 268	com/tencent/mm/plugin/u/i:durationMs	J
    //   18: lcmp
    //   19: ifge +561 -> 580
    //   22: lload_3
    //   23: ldc2_w 342
    //   26: lcmp
    //   27: ifne +553 -> 580
    //   30: ldc 115
    //   32: ldc_w 480
    //   35: invokestatic 482	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: ldc_w 484
    //   41: invokestatic 490	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   44: astore 10
    //   46: aload_0
    //   47: instanceof 492
    //   50: ifeq +54 -> 104
    //   53: aload_0
    //   54: getfield 494	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   57: ifnonnull +388 -> 445
    //   60: ldc_w 382
    //   63: astore 9
    //   65: aload 10
    //   67: ldc_w 495
    //   70: aload 9
    //   72: invokevirtual 499	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   75: pop
    //   76: aload 10
    //   78: ldc_w 500
    //   81: iconst_1
    //   82: invokevirtual 504	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   85: pop
    //   86: aload 10
    //   88: ldc_w 506
    //   91: invokestatic 511	java/lang/System:currentTimeMillis	()J
    //   94: invokevirtual 515	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   97: pop
    //   98: aload 10
    //   100: invokevirtual 518	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:commit	()Z
    //   103: pop
    //   104: aload_0
    //   105: getfield 96	com/tencent/mm/plugin/u/i:EXa	Lcom/tencent/mm/plugin/u/h;
    //   108: iconst_1
    //   109: putfield 521	com/tencent/mm/plugin/u/h:uXX	Z
    //   112: aload_0
    //   113: iconst_0
    //   114: putfield 75	com/tencent/mm/plugin/u/i:EXd	Z
    //   117: aload_0
    //   118: getfield 134	com/tencent/mm/plugin/u/i:miS	Lcom/tencent/mm/compatible/i/c;
    //   121: getfield 140	com/tencent/mm/compatible/i/c:jvU	Landroid/media/MediaExtractor;
    //   124: invokevirtual 524	android/media/MediaExtractor:release	()V
    //   127: aload_0
    //   128: new 136	com/tencent/mm/compatible/i/c
    //   131: dup
    //   132: invokespecial 525	com/tencent/mm/compatible/i/c:<init>	()V
    //   135: putfield 134	com/tencent/mm/plugin/u/i:miS	Lcom/tencent/mm/compatible/i/c;
    //   138: aload_0
    //   139: getfield 494	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   142: invokestatic 529	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   145: ifne +437 -> 582
    //   148: aload_0
    //   149: getfield 494	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   152: iconst_0
    //   153: invokestatic 535	com/tencent/mm/vfs/u:dO	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   156: astore 9
    //   158: aload 9
    //   160: invokevirtual 541	java/io/RandomAccessFile:getFD	()Ljava/io/FileDescriptor;
    //   163: astore 11
    //   165: getstatic 547	com/tencent/mm/compatible/deviceinfo/af:juJ	Lcom/tencent/mm/compatible/deviceinfo/ab;
    //   168: getfield 552	com/tencent/mm/compatible/deviceinfo/ab:juw	I
    //   171: iconst_1
    //   172: if_icmpne +282 -> 454
    //   175: aload_0
    //   176: getfield 134	com/tencent/mm/plugin/u/i:miS	Lcom/tencent/mm/compatible/i/c;
    //   179: aload 11
    //   181: lconst_0
    //   182: aload_0
    //   183: getfield 494	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   186: invokestatic 556	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   189: invokevirtual 559	com/tencent/mm/compatible/i/c:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   192: aload 9
    //   194: invokevirtual 562	java/io/RandomAccessFile:close	()V
    //   197: aload 10
    //   199: ldc_w 495
    //   202: ldc_w 382
    //   205: invokevirtual 566	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   208: aload_0
    //   209: getfield 494	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   212: invokevirtual 572	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   215: ifeq +48 -> 263
    //   218: aload_0
    //   219: instanceof 492
    //   222: ifeq +41 -> 263
    //   225: aload 10
    //   227: ldc_w 500
    //   230: iconst_0
    //   231: invokevirtual 504	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   234: pop
    //   235: aload 10
    //   237: ldc_w 495
    //   240: ldc_w 382
    //   243: invokevirtual 499	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   246: pop
    //   247: aload 10
    //   249: ldc_w 506
    //   252: lconst_0
    //   253: invokevirtual 515	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   256: pop
    //   257: aload 10
    //   259: invokevirtual 518	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:commit	()Z
    //   262: pop
    //   263: aload_0
    //   264: getfield 134	com/tencent/mm/plugin/u/i:miS	Lcom/tencent/mm/compatible/i/c;
    //   267: aload_0
    //   268: getfield 574	com/tencent/mm/plugin/u/i:trackIndex	I
    //   271: invokevirtual 577	com/tencent/mm/compatible/i/c:selectTrack	(I)V
    //   274: aload_0
    //   275: getfield 134	com/tencent/mm/plugin/u/i:miS	Lcom/tencent/mm/compatible/i/c;
    //   278: lload_1
    //   279: iconst_2
    //   280: invokevirtual 356	com/tencent/mm/compatible/i/c:seekTo	(JI)V
    //   283: aload_0
    //   284: getfield 134	com/tencent/mm/plugin/u/i:miS	Lcom/tencent/mm/compatible/i/c;
    //   287: getfield 140	com/tencent/mm/compatible/i/c:jvU	Landroid/media/MediaExtractor;
    //   290: invokevirtual 145	android/media/MediaExtractor:getSampleTime	()J
    //   293: lstore 7
    //   295: lload 7
    //   297: lload_1
    //   298: lsub
    //   299: invokestatic 311	java/lang/Math:abs	(J)J
    //   302: ldc2_w 325
    //   305: lcmp
    //   306: ifle +74 -> 380
    //   309: aload_0
    //   310: getfield 494	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   313: ifnull +67 -> 380
    //   316: aload_0
    //   317: getfield 494	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   320: ldc_w 579
    //   323: invokevirtual 583	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   326: ifeq +54 -> 380
    //   329: getstatic 365	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   332: sipush 150
    //   335: bipush 75
    //   337: invokevirtual 587	com/tencent/mm/plugin/report/service/h:el	(II)V
    //   340: getstatic 365	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
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
    //   359: new 589	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 590	java/lang/StringBuilder:<init>	()V
    //   366: lload 7
    //   368: lload_1
    //   369: lsub
    //   370: invokevirtual 594	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   373: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: aastore
    //   377: invokevirtual 385	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   380: ldc 115
    //   382: ldc_w 597
    //   385: bipush 6
    //   387: anewarray 4	java/lang/Object
    //   390: dup
    //   391: iconst_0
    //   392: aload_0
    //   393: invokevirtual 121	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
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
    //   422: getfield 79	com/tencent/mm/plugin/u/i:EXf	J
    //   425: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   428: aastore
    //   429: dup
    //   430: iconst_5
    //   431: lload 5
    //   433: invokestatic 196	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   436: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   439: aastore
    //   440: invokestatic 306	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   443: iconst_1
    //   444: ireturn
    //   445: aload_0
    //   446: getfield 494	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   449: astore 9
    //   451: goto -386 -> 65
    //   454: aload_0
    //   455: getfield 134	com/tencent/mm/plugin/u/i:miS	Lcom/tencent/mm/compatible/i/c;
    //   458: aload 11
    //   460: invokevirtual 600	com/tencent/mm/compatible/i/c:setDataSource	(Ljava/io/FileDescriptor;)V
    //   463: goto -271 -> 192
    //   466: astore 9
    //   468: ldc 115
    //   470: aload 9
    //   472: ldc_w 480
    //   475: iconst_0
    //   476: anewarray 4	java/lang/Object
    //   479: invokestatic 249	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   482: aload 10
    //   484: ldc_w 495
    //   487: ldc_w 382
    //   490: invokevirtual 566	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   493: aload_0
    //   494: getfield 494	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   497: invokevirtual 572	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   500: ifeq -237 -> 263
    //   503: aload_0
    //   504: instanceof 492
    //   507: ifeq -244 -> 263
    //   510: aload 10
    //   512: ldc_w 500
    //   515: iconst_0
    //   516: invokevirtual 504	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   519: pop
    //   520: aload 10
    //   522: ldc_w 495
    //   525: ldc_w 382
    //   528: invokevirtual 499	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   531: pop
    //   532: aload 10
    //   534: ldc_w 506
    //   537: lconst_0
    //   538: invokevirtual 515	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   541: pop
    //   542: aload 10
    //   544: invokevirtual 518	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:commit	()Z
    //   547: pop
    //   548: goto -285 -> 263
    //   551: astore 9
    //   553: ldc 115
    //   555: ldc_w 602
    //   558: iconst_2
    //   559: anewarray 4	java/lang/Object
    //   562: dup
    //   563: iconst_0
    //   564: aload_0
    //   565: invokevirtual 121	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   568: aastore
    //   569: dup
    //   570: iconst_1
    //   571: aload 9
    //   573: invokevirtual 352	java/lang/Exception:toString	()Ljava/lang/String;
    //   576: aastore
    //   577: invokestatic 322	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   580: iconst_0
    //   581: ireturn
    //   582: aload_0
    //   583: getfield 397	com/tencent/mm/plugin/u/i:EXc	Ljava/io/FileDescriptor;
    //   586: ifnull -389 -> 197
    //   589: aload_0
    //   590: getfield 397	com/tencent/mm/plugin/u/i:EXc	Ljava/io/FileDescriptor;
    //   593: invokevirtual 607	java/io/FileDescriptor:valid	()Z
    //   596: ifeq -399 -> 197
    //   599: aload_0
    //   600: getfield 134	com/tencent/mm/plugin/u/i:miS	Lcom/tencent/mm/compatible/i/c;
    //   603: aload_0
    //   604: getfield 397	com/tencent/mm/plugin/u/i:EXc	Ljava/io/FileDescriptor;
    //   607: aload_0
    //   608: getfield 399	com/tencent/mm/plugin/u/i:bdS	J
    //   611: aload_0
    //   612: getfield 401	com/tencent/mm/plugin/u/i:aFL	J
    //   615: invokevirtual 559	com/tencent/mm/compatible/i/c:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   618: goto -421 -> 197
    //   621: astore 9
    //   623: aload 10
    //   625: ldc_w 495
    //   628: ldc_w 382
    //   631: invokevirtual 566	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   634: aload_0
    //   635: getfield 494	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   638: invokevirtual 572	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   641: ifeq +48 -> 689
    //   644: aload_0
    //   645: instanceof 492
    //   648: ifeq +41 -> 689
    //   651: aload 10
    //   653: ldc_w 500
    //   656: iconst_0
    //   657: invokevirtual 504	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   660: pop
    //   661: aload 10
    //   663: ldc_w 495
    //   666: ldc_w 382
    //   669: invokevirtual 499	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   672: pop
    //   673: aload 10
    //   675: ldc_w 506
    //   678: lconst_0
    //   679: invokevirtual 515	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   682: pop
    //   683: aload 10
    //   685: invokevirtual 518	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:commit	()Z
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
    //   44	640	10	localMultiProcessMMKV	com.tencent.mm.sdk.platformtools.MultiProcessMMKV
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
  
  protected void b(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    Log.i("MicroMsg.TrackDataSource", "%s found media format mime[%s] track[%d] format[%s]", new Object[] { info(), paramString, Integer.valueOf(paramInt), paramMediaFormat });
    this.trackIndex = paramInt;
    this.aFM = paramString;
    this.durationMs = (paramMediaFormat.getLong("durationUs") / 1000L);
    this.EXg = paramMediaFormat;
  }
  
  public final void eSP()
  {
    Log.i("MicroMsg.TrackDataSource", "%s flush codec", new Object[] { info() });
    this.bdb = -1;
    try
    {
      aa localaa;
      if (this.kSN != null) {
        localaa = this.kSN;
      }
      try
      {
        if (!localaa.dfl) {
          Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy flush not alive");
        }
        MediaCodecProxyUtils.b.qS(96);
        localaa.jtS.flush();
        MediaCodecProxyUtils.b.qS(97);
        return;
      }
      catch (Exception localException2)
      {
        Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException2, "MediaCodecProxy flush, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
        MediaCodecProxyUtils.b.qS(39);
        localaa.jtU.getAndIncrement();
        throw localException2;
      }
      return;
    }
    catch (Exception localException1)
    {
      Log.printErrStackTrace("MicroMsg.TrackDataSource", localException1, "flushCodec exception", new Object[0]);
    }
  }
  
  protected final boolean eSQ()
  {
    try
    {
      Log.i("MicroMsg.TrackDataSource", "%s start to prepare decoder mime[%s]", new Object[] { info(), this.aFM });
      this.kSN = aa.KR(this.aFM);
      a(this.kSN);
      this.kSN.start();
      return true;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.TrackDataSource", localException, "%s prepare decoder init decoder error ", new Object[] { info() });
      this.EXa.aPs(type());
    }
    return false;
  }
  
  protected final MediaFormat eSR()
  {
    return this.EXg;
  }
  
  protected final MediaFormat eSS()
  {
    if ((this.miS == null) || (this.trackIndex < 0)) {
      return this.EXg;
    }
    return this.miS.getTrackFormat(this.trackIndex);
  }
  
  public final String info()
  {
    if (this.EXa != null) {
      return type() + "_" + this.EXa.info() + "_" + Process.myTid();
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
    //   0: ldc 115
    //   2: ldc_w 704
    //   5: iconst_2
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: aload_0
    //   12: invokevirtual 121	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   15: aastore
    //   16: dup
    //   17: iconst_1
    //   18: aload_0
    //   19: getfield 494	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   22: aastore
    //   23: invokestatic 171	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: invokestatic 156	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   29: lstore 5
    //   31: ldc_w 484
    //   34: invokestatic 490	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   37: astore 10
    //   39: aload_0
    //   40: iconst_0
    //   41: putfield 75	com/tencent/mm/plugin/u/i:EXd	Z
    //   44: ldc 115
    //   46: ldc_w 706
    //   49: iconst_1
    //   50: anewarray 4	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: aload_0
    //   56: invokevirtual 121	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   59: aastore
    //   60: invokestatic 171	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   63: aload_0
    //   64: new 136	com/tencent/mm/compatible/i/c
    //   67: dup
    //   68: invokespecial 525	com/tencent/mm/compatible/i/c:<init>	()V
    //   71: putfield 134	com/tencent/mm/plugin/u/i:miS	Lcom/tencent/mm/compatible/i/c;
    //   74: aload_0
    //   75: instanceof 492
    //   78: ifeq +54 -> 132
    //   81: aload_0
    //   82: getfield 494	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   85: ifnonnull +355 -> 440
    //   88: ldc_w 382
    //   91: astore 9
    //   93: aload 10
    //   95: ldc_w 495
    //   98: aload 9
    //   100: invokevirtual 499	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   103: pop
    //   104: aload 10
    //   106: ldc_w 500
    //   109: iconst_1
    //   110: invokevirtual 504	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   113: pop
    //   114: aload 10
    //   116: ldc_w 506
    //   119: invokestatic 511	java/lang/System:currentTimeMillis	()J
    //   122: invokevirtual 515	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   125: pop
    //   126: aload 10
    //   128: invokevirtual 518	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:commit	()Z
    //   131: pop
    //   132: aload_0
    //   133: getfield 494	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   136: invokestatic 529	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   139: ifne +427 -> 566
    //   142: aload_0
    //   143: getfield 494	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   146: iconst_0
    //   147: invokestatic 535	com/tencent/mm/vfs/u:dO	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   150: astore 9
    //   152: aload_0
    //   153: aload 9
    //   155: invokevirtual 541	java/io/RandomAccessFile:getFD	()Ljava/io/FileDescriptor;
    //   158: putfield 397	com/tencent/mm/plugin/u/i:EXc	Ljava/io/FileDescriptor;
    //   161: getstatic 547	com/tencent/mm/compatible/deviceinfo/af:juJ	Lcom/tencent/mm/compatible/deviceinfo/ab;
    //   164: getfield 552	com/tencent/mm/compatible/deviceinfo/ab:juw	I
    //   167: iconst_1
    //   168: if_icmpne +281 -> 449
    //   171: aload_0
    //   172: getfield 134	com/tencent/mm/plugin/u/i:miS	Lcom/tencent/mm/compatible/i/c;
    //   175: aload_0
    //   176: getfield 397	com/tencent/mm/plugin/u/i:EXc	Ljava/io/FileDescriptor;
    //   179: lconst_0
    //   180: aload_0
    //   181: getfield 494	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   184: invokestatic 556	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   187: invokevirtual 559	com/tencent/mm/compatible/i/c:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   190: aload 9
    //   192: invokevirtual 562	java/io/RandomAccessFile:close	()V
    //   195: aload_0
    //   196: getfield 134	com/tencent/mm/plugin/u/i:miS	Lcom/tencent/mm/compatible/i/c;
    //   199: getfield 140	com/tencent/mm/compatible/i/c:jvU	Landroid/media/MediaExtractor;
    //   202: invokevirtual 709	android/media/MediaExtractor:getTrackCount	()I
    //   205: istore_1
    //   206: iload_1
    //   207: ifgt +940 -> 1147
    //   210: ldc 115
    //   212: ldc_w 711
    //   215: invokestatic 460	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: aload_0
    //   219: getfield 134	com/tencent/mm/plugin/u/i:miS	Lcom/tencent/mm/compatible/i/c;
    //   222: getfield 140	com/tencent/mm/compatible/i/c:jvU	Landroid/media/MediaExtractor;
    //   225: invokevirtual 524	android/media/MediaExtractor:release	()V
    //   228: aload_0
    //   229: new 136	com/tencent/mm/compatible/i/c
    //   232: dup
    //   233: invokespecial 525	com/tencent/mm/compatible/i/c:<init>	()V
    //   236: putfield 134	com/tencent/mm/plugin/u/i:miS	Lcom/tencent/mm/compatible/i/c;
    //   239: aload_0
    //   240: getfield 134	com/tencent/mm/plugin/u/i:miS	Lcom/tencent/mm/compatible/i/c;
    //   243: aload_0
    //   244: getfield 494	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   247: invokevirtual 713	com/tencent/mm/compatible/i/c:setDataSource	(Ljava/lang/String;)V
    //   250: aload_0
    //   251: getfield 134	com/tencent/mm/plugin/u/i:miS	Lcom/tencent/mm/compatible/i/c;
    //   254: getfield 140	com/tencent/mm/compatible/i/c:jvU	Landroid/media/MediaExtractor;
    //   257: invokevirtual 709	android/media/MediaExtractor:getTrackCount	()I
    //   260: istore_1
    //   261: aload_0
    //   262: iconst_m1
    //   263: putfield 574	com/tencent/mm/plugin/u/i:trackIndex	I
    //   266: iconst_0
    //   267: istore_2
    //   268: iload_2
    //   269: iload_1
    //   270: if_icmpge +49 -> 319
    //   273: aload_0
    //   274: getfield 134	com/tencent/mm/plugin/u/i:miS	Lcom/tencent/mm/compatible/i/c;
    //   277: iload_2
    //   278: invokevirtual 685	com/tencent/mm/compatible/i/c:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   281: astore 9
    //   283: aload 9
    //   285: ldc_w 715
    //   288: invokevirtual 718	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   291: astore 11
    //   293: aload 11
    //   295: ifnull +419 -> 714
    //   298: aload 11
    //   300: aload_0
    //   301: invokevirtual 423	com/tencent/mm/plugin/u/i:type	()Ljava/lang/String;
    //   304: invokevirtual 583	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   307: ifeq +407 -> 714
    //   310: aload_0
    //   311: aload 9
    //   313: aload 11
    //   315: iload_2
    //   316: invokevirtual 720	com/tencent/mm/plugin/u/i:b	(Landroid/media/MediaFormat;Ljava/lang/String;I)V
    //   319: aload_0
    //   320: getfield 574	com/tencent/mm/plugin/u/i:trackIndex	I
    //   323: ifge +398 -> 721
    //   326: ldc 115
    //   328: ldc_w 722
    //   331: iconst_3
    //   332: anewarray 4	java/lang/Object
    //   335: dup
    //   336: iconst_0
    //   337: aload_0
    //   338: invokevirtual 121	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   341: aastore
    //   342: dup
    //   343: iconst_1
    //   344: iload_1
    //   345: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   348: aastore
    //   349: dup
    //   350: iconst_2
    //   351: aload_0
    //   352: getfield 574	com/tencent/mm/plugin/u/i:trackIndex	I
    //   355: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   358: aastore
    //   359: invokestatic 306	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   362: aload_0
    //   363: getfield 96	com/tencent/mm/plugin/u/i:EXa	Lcom/tencent/mm/plugin/u/h;
    //   366: ldc_w 724
    //   369: invokevirtual 727	com/tencent/mm/plugin/u/h:aPr	(Ljava/lang/String;)V
    //   372: aload 10
    //   374: ldc_w 495
    //   377: ldc_w 382
    //   380: invokevirtual 566	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   383: aload_0
    //   384: getfield 494	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   387: invokevirtual 572	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   390: ifeq +48 -> 438
    //   393: aload_0
    //   394: instanceof 492
    //   397: ifeq +41 -> 438
    //   400: aload 10
    //   402: ldc_w 500
    //   405: iconst_0
    //   406: invokevirtual 504	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   409: pop
    //   410: aload 10
    //   412: ldc_w 495
    //   415: ldc_w 382
    //   418: invokevirtual 499	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   421: pop
    //   422: aload 10
    //   424: ldc_w 506
    //   427: lconst_0
    //   428: invokevirtual 515	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   431: pop
    //   432: aload 10
    //   434: invokevirtual 518	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:commit	()Z
    //   437: pop
    //   438: iconst_0
    //   439: ireturn
    //   440: aload_0
    //   441: getfield 494	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   444: astore 9
    //   446: goto -353 -> 93
    //   449: aload_0
    //   450: getfield 134	com/tencent/mm/plugin/u/i:miS	Lcom/tencent/mm/compatible/i/c;
    //   453: aload_0
    //   454: getfield 397	com/tencent/mm/plugin/u/i:EXc	Ljava/io/FileDescriptor;
    //   457: invokevirtual 600	com/tencent/mm/compatible/i/c:setDataSource	(Ljava/io/FileDescriptor;)V
    //   460: goto -270 -> 190
    //   463: astore 9
    //   465: ldc 115
    //   467: aload 9
    //   469: ldc_w 729
    //   472: iconst_1
    //   473: anewarray 4	java/lang/Object
    //   476: dup
    //   477: iconst_0
    //   478: aload_0
    //   479: invokevirtual 121	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   482: aastore
    //   483: invokestatic 249	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   486: aload_0
    //   487: getfield 96	com/tencent/mm/plugin/u/i:EXa	Lcom/tencent/mm/plugin/u/h;
    //   490: aload 9
    //   492: invokevirtual 352	java/lang/Exception:toString	()Ljava/lang/String;
    //   495: invokevirtual 727	com/tencent/mm/plugin/u/h:aPr	(Ljava/lang/String;)V
    //   498: aload 10
    //   500: ldc_w 495
    //   503: ldc_w 382
    //   506: invokevirtual 566	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   509: aload_0
    //   510: getfield 494	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   513: invokevirtual 572	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   516: ifeq +48 -> 564
    //   519: aload_0
    //   520: instanceof 492
    //   523: ifeq +41 -> 564
    //   526: aload 10
    //   528: ldc_w 500
    //   531: iconst_0
    //   532: invokevirtual 504	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   535: pop
    //   536: aload 10
    //   538: ldc_w 495
    //   541: ldc_w 382
    //   544: invokevirtual 499	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   547: pop
    //   548: aload 10
    //   550: ldc_w 506
    //   553: lconst_0
    //   554: invokevirtual 515	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   557: pop
    //   558: aload 10
    //   560: invokevirtual 518	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:commit	()Z
    //   563: pop
    //   564: iconst_0
    //   565: ireturn
    //   566: aload_0
    //   567: getfield 397	com/tencent/mm/plugin/u/i:EXc	Ljava/io/FileDescriptor;
    //   570: ifnull -375 -> 195
    //   573: aload_0
    //   574: getfield 397	com/tencent/mm/plugin/u/i:EXc	Ljava/io/FileDescriptor;
    //   577: invokevirtual 607	java/io/FileDescriptor:valid	()Z
    //   580: ifeq -385 -> 195
    //   583: aload_0
    //   584: getfield 134	com/tencent/mm/plugin/u/i:miS	Lcom/tencent/mm/compatible/i/c;
    //   587: aload_0
    //   588: getfield 397	com/tencent/mm/plugin/u/i:EXc	Ljava/io/FileDescriptor;
    //   591: aload_0
    //   592: getfield 399	com/tencent/mm/plugin/u/i:bdS	J
    //   595: aload_0
    //   596: getfield 401	com/tencent/mm/plugin/u/i:aFL	J
    //   599: invokevirtual 559	com/tencent/mm/compatible/i/c:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   602: goto -407 -> 195
    //   605: astore 9
    //   607: ldc 115
    //   609: ldc_w 731
    //   612: iconst_2
    //   613: anewarray 4	java/lang/Object
    //   616: dup
    //   617: iconst_0
    //   618: aload_0
    //   619: invokevirtual 121	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   622: aastore
    //   623: dup
    //   624: iconst_1
    //   625: aload 9
    //   627: invokevirtual 732	java/lang/Throwable:toString	()Ljava/lang/String;
    //   630: aastore
    //   631: invokestatic 322	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   634: aload_0
    //   635: getfield 96	com/tencent/mm/plugin/u/i:EXa	Lcom/tencent/mm/plugin/u/h;
    //   638: aload 9
    //   640: invokevirtual 732	java/lang/Throwable:toString	()Ljava/lang/String;
    //   643: invokevirtual 727	com/tencent/mm/plugin/u/h:aPr	(Ljava/lang/String;)V
    //   646: aload 10
    //   648: ldc_w 495
    //   651: ldc_w 382
    //   654: invokevirtual 566	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   657: aload_0
    //   658: getfield 494	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   661: invokevirtual 572	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   664: ifeq +48 -> 712
    //   667: aload_0
    //   668: instanceof 492
    //   671: ifeq +41 -> 712
    //   674: aload 10
    //   676: ldc_w 500
    //   679: iconst_0
    //   680: invokevirtual 504	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   683: pop
    //   684: aload 10
    //   686: ldc_w 495
    //   689: ldc_w 382
    //   692: invokevirtual 499	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   695: pop
    //   696: aload 10
    //   698: ldc_w 506
    //   701: lconst_0
    //   702: invokevirtual 515	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   705: pop
    //   706: aload 10
    //   708: invokevirtual 518	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:commit	()Z
    //   711: pop
    //   712: iconst_0
    //   713: ireturn
    //   714: iload_2
    //   715: iconst_1
    //   716: iadd
    //   717: istore_2
    //   718: goto -450 -> 268
    //   721: aload_0
    //   722: getfield 134	com/tencent/mm/plugin/u/i:miS	Lcom/tencent/mm/compatible/i/c;
    //   725: aload_0
    //   726: getfield 574	com/tencent/mm/plugin/u/i:trackIndex	I
    //   729: invokevirtual 577	com/tencent/mm/compatible/i/c:selectTrack	(I)V
    //   732: aload_0
    //   733: getfield 494	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   736: invokestatic 529	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   739: ifne +8 -> 747
    //   742: aload_0
    //   743: aconst_null
    //   744: putfield 261	com/tencent/mm/plugin/u/i:EXh	Lcom/tencent/mm/plugin/u/g;
    //   747: invokestatic 156	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   750: lstore 7
    //   752: aload 10
    //   754: ldc_w 495
    //   757: ldc_w 382
    //   760: invokevirtual 566	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   763: aload_0
    //   764: getfield 494	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   767: invokevirtual 572	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   770: ifeq +48 -> 818
    //   773: aload_0
    //   774: instanceof 492
    //   777: ifeq +41 -> 818
    //   780: aload 10
    //   782: ldc_w 500
    //   785: iconst_0
    //   786: invokevirtual 504	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   789: pop
    //   790: aload 10
    //   792: ldc_w 495
    //   795: ldc_w 382
    //   798: invokevirtual 499	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   801: pop
    //   802: aload 10
    //   804: ldc_w 506
    //   807: lconst_0
    //   808: invokevirtual 515	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   811: pop
    //   812: aload 10
    //   814: invokevirtual 518	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:commit	()Z
    //   817: pop
    //   818: ldc 115
    //   820: ldc_w 734
    //   823: iconst_3
    //   824: anewarray 4	java/lang/Object
    //   827: dup
    //   828: iconst_0
    //   829: aload_0
    //   830: invokevirtual 121	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   833: aastore
    //   834: dup
    //   835: iconst_1
    //   836: aload_0
    //   837: getfield 613	com/tencent/mm/plugin/u/i:aFM	Ljava/lang/String;
    //   840: aastore
    //   841: dup
    //   842: iconst_2
    //   843: aload_0
    //   844: getfield 100	com/tencent/mm/plugin/u/i:state	I
    //   847: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   850: aastore
    //   851: invokestatic 171	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   854: aload_0
    //   855: getfield 100	com/tencent/mm/plugin/u/i:state	I
    //   858: invokestatic 235	com/tencent/mm/plugin/u/e:WK	(I)Z
    //   861: ifne +281 -> 1142
    //   864: aload_0
    //   865: getfield 86	com/tencent/mm/plugin/u/i:lock	Ljava/lang/Object;
    //   868: astore 9
    //   870: aload 9
    //   872: monitorenter
    //   873: ldc 115
    //   875: ldc_w 736
    //   878: iconst_2
    //   879: anewarray 4	java/lang/Object
    //   882: dup
    //   883: iconst_0
    //   884: aload_0
    //   885: invokevirtual 121	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   888: aastore
    //   889: dup
    //   890: iconst_1
    //   891: aload_0
    //   892: getfield 181	com/tencent/mm/plugin/u/i:EXg	Landroid/media/MediaFormat;
    //   895: aastore
    //   896: invokestatic 151	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   899: aload_0
    //   900: aload_0
    //   901: getfield 613	com/tencent/mm/plugin/u/i:aFM	Ljava/lang/String;
    //   904: invokestatic 668	com/tencent/mm/compatible/deviceinfo/aa:KR	(Ljava/lang/String;)Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   907: putfield 158	com/tencent/mm/plugin/u/i:kSN	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   910: aload_0
    //   911: aload_0
    //   912: getfield 158	com/tencent/mm/plugin/u/i:kSN	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   915: invokevirtual 670	com/tencent/mm/plugin/u/i:a	(Lcom/tencent/mm/compatible/deviceinfo/aa;)Z
    //   918: pop
    //   919: aload_0
    //   920: getfield 158	com/tencent/mm/plugin/u/i:kSN	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   923: invokevirtual 673	com/tencent/mm/compatible/deviceinfo/aa:start	()V
    //   926: aload 9
    //   928: monitorexit
    //   929: invokestatic 156	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   932: lstore_3
    //   933: aload_0
    //   934: iconst_1
    //   935: invokevirtual 175	com/tencent/mm/plugin/u/i:setState	(I)V
    //   938: ldc 115
    //   940: ldc_w 738
    //   943: iconst_4
    //   944: anewarray 4	java/lang/Object
    //   947: dup
    //   948: iconst_0
    //   949: aload_0
    //   950: invokevirtual 121	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   953: aastore
    //   954: dup
    //   955: iconst_1
    //   956: lload 5
    //   958: invokestatic 196	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   961: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   964: aastore
    //   965: dup
    //   966: iconst_2
    //   967: lload 7
    //   969: lload 5
    //   971: lsub
    //   972: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   975: aastore
    //   976: dup
    //   977: iconst_3
    //   978: lload_3
    //   979: lload 5
    //   981: lsub
    //   982: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   985: aastore
    //   986: invokestatic 171	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   989: iconst_1
    //   990: ireturn
    //   991: astore 9
    //   993: aload 10
    //   995: ldc_w 495
    //   998: ldc_w 382
    //   1001: invokevirtual 566	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1004: aload_0
    //   1005: getfield 494	com/tencent/mm/plugin/u/i:path	Ljava/lang/String;
    //   1008: invokevirtual 572	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1011: ifeq +48 -> 1059
    //   1014: aload_0
    //   1015: instanceof 492
    //   1018: ifeq +41 -> 1059
    //   1021: aload 10
    //   1023: ldc_w 500
    //   1026: iconst_0
    //   1027: invokevirtual 504	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   1030: pop
    //   1031: aload 10
    //   1033: ldc_w 495
    //   1036: ldc_w 382
    //   1039: invokevirtual 499	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   1042: pop
    //   1043: aload 10
    //   1045: ldc_w 506
    //   1048: lconst_0
    //   1049: invokevirtual 515	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   1052: pop
    //   1053: aload 10
    //   1055: invokevirtual 518	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:commit	()Z
    //   1058: pop
    //   1059: aload 9
    //   1061: athrow
    //   1062: astore 10
    //   1064: aload 9
    //   1066: monitorexit
    //   1067: aload 10
    //   1069: athrow
    //   1070: astore 9
    //   1072: ldc 115
    //   1074: aload 9
    //   1076: ldc_w 740
    //   1079: iconst_2
    //   1080: anewarray 4	java/lang/Object
    //   1083: dup
    //   1084: iconst_0
    //   1085: aload_0
    //   1086: invokevirtual 121	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   1089: aastore
    //   1090: dup
    //   1091: iconst_1
    //   1092: aload 9
    //   1094: invokevirtual 352	java/lang/Exception:toString	()Ljava/lang/String;
    //   1097: aastore
    //   1098: invokestatic 249	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1101: ldc 115
    //   1103: aload 9
    //   1105: ldc_w 742
    //   1108: iconst_2
    //   1109: anewarray 4	java/lang/Object
    //   1112: dup
    //   1113: iconst_0
    //   1114: aload_0
    //   1115: invokevirtual 121	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   1118: aastore
    //   1119: dup
    //   1120: iconst_1
    //   1121: aload_0
    //   1122: getfield 181	com/tencent/mm/plugin/u/i:EXg	Landroid/media/MediaFormat;
    //   1125: aastore
    //   1126: invokestatic 249	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1129: aload_0
    //   1130: getfield 96	com/tencent/mm/plugin/u/i:EXa	Lcom/tencent/mm/plugin/u/h;
    //   1133: aload_0
    //   1134: invokevirtual 423	com/tencent/mm/plugin/u/i:type	()Ljava/lang/String;
    //   1137: invokevirtual 679	com/tencent/mm/plugin/u/h:aPs	(Ljava/lang/String;)V
    //   1140: iconst_0
    //   1141: ireturn
    //   1142: lconst_0
    //   1143: lstore_3
    //   1144: goto -211 -> 933
    //   1147: goto -886 -> 261
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1150	0	this	i
    //   205	140	1	i	int
    //   267	451	2	j	int
    //   932	212	3	l1	long
    //   29	951	5	l2	long
    //   750	218	7	l3	long
    //   91	354	9	localObject1	Object
    //   463	28	9	localException1	Exception
    //   605	34	9	localThrowable	Throwable
    //   991	74	9	localObject3	Object
    //   1070	34	9	localException2	Exception
    //   37	1017	10	localMultiProcessMMKV	com.tencent.mm.sdk.platformtools.MultiProcessMMKV
    //   1062	6	10	localObject4	Object
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
    //   44	88	991	finally
    //   93	132	991	finally
    //   132	190	991	finally
    //   190	195	991	finally
    //   195	206	991	finally
    //   210	261	991	finally
    //   261	266	991	finally
    //   273	293	991	finally
    //   298	319	991	finally
    //   319	372	991	finally
    //   440	446	991	finally
    //   449	460	991	finally
    //   465	498	991	finally
    //   566	602	991	finally
    //   607	646	991	finally
    //   721	747	991	finally
    //   747	752	991	finally
    //   873	929	1062	finally
    //   818	873	1070	java/lang/Exception
    //   929	933	1070	java/lang/Exception
    //   1064	1070	1070	java/lang/Exception
  }
  
  public void release()
  {
    Log.i("MicroMsg.TrackDataSource", "%s release doubleReleaseSwitch:[%b]", new Object[] { info(), Boolean.valueOf(EXk) });
    if (EXk)
    {
      Log.i("MicroMsg.TrackDataSource", "%s into release fun", new Object[] { info() });
      if (this.miS != null)
      {
        Log.i("MicroMsg.TrackDataSource", "%s release,  extractor != null", new Object[] { info() });
        this.miS.jvU.release();
        this.miS = null;
      }
      releaseDecoder();
      if (this.EXh != null)
      {
        Log.i("MicroMsg.TrackDataSource", "%s release,  mp4Extractor != null", new Object[] { info() });
        throw null;
      }
      Log.i("MicroMsg.TrackDataSource", "%s finish release", new Object[] { info() });
      return;
    }
    Log.i("MicroMsg.TrackDataSource", "%s release", new Object[] { info() });
    if (this.miS != null)
    {
      this.miS.jvU.release();
      this.miS = null;
    }
    if (this.kSN != null)
    {
      this.kSN.release();
      this.kSN = null;
    }
    if (this.EXh != null) {
      throw null;
    }
    Log.i("MicroMsg.TrackDataSource", "%s finish release", new Object[] { info() });
  }
  
  /* Error */
  protected final void releaseDecoder()
  {
    // Byte code:
    //   0: ldc 115
    //   2: ldc_w 760
    //   5: iconst_2
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: aload_0
    //   12: invokevirtual 121	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   15: aastore
    //   16: dup
    //   17: iconst_1
    //   18: getstatic 66	com/tencent/mm/plugin/u/i:EXk	Z
    //   21: invokestatic 229	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   24: aastore
    //   25: invokestatic 171	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: getstatic 66	com/tencent/mm/plugin/u/i:EXk	Z
    //   31: ifeq +217 -> 248
    //   34: invokestatic 156	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   37: lstore_1
    //   38: aload_0
    //   39: getfield 86	com/tencent/mm/plugin/u/i:lock	Ljava/lang/Object;
    //   42: astore_3
    //   43: aload_3
    //   44: monitorenter
    //   45: aload_0
    //   46: getfield 158	com/tencent/mm/plugin/u/i:kSN	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   49: ifnull +177 -> 226
    //   52: ldc 115
    //   54: ldc_w 762
    //   57: iconst_1
    //   58: anewarray 4	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: aload_0
    //   64: invokevirtual 121	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   67: aastore
    //   68: invokestatic 171	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: aload_0
    //   72: invokevirtual 420	com/tencent/mm/plugin/u/i:eSP	()V
    //   75: ldc 115
    //   77: ldc_w 764
    //   80: iconst_2
    //   81: anewarray 4	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: aload_0
    //   87: invokevirtual 121	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   90: aastore
    //   91: dup
    //   92: iconst_1
    //   93: lload_1
    //   94: invokestatic 196	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   97: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   100: aastore
    //   101: invokestatic 171	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   104: aload_0
    //   105: getfield 158	com/tencent/mm/plugin/u/i:kSN	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   108: invokevirtual 767	com/tencent/mm/compatible/deviceinfo/aa:stop	()V
    //   111: aload_0
    //   112: getfield 158	com/tencent/mm/plugin/u/i:kSN	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   115: invokevirtual 758	com/tencent/mm/compatible/deviceinfo/aa:release	()V
    //   118: aload_0
    //   119: aconst_null
    //   120: putfield 158	com/tencent/mm/plugin/u/i:kSN	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   123: ldc 115
    //   125: ldc_w 769
    //   128: iconst_2
    //   129: anewarray 4	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: aload_0
    //   135: invokevirtual 121	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   138: aastore
    //   139: dup
    //   140: iconst_1
    //   141: lload_1
    //   142: invokestatic 196	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   145: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   148: aastore
    //   149: invokestatic 171	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: aload_3
    //   153: monitorexit
    //   154: return
    //   155: astore 4
    //   157: aload_0
    //   158: aconst_null
    //   159: putfield 158	com/tencent/mm/plugin/u/i:kSN	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   162: aload 4
    //   164: athrow
    //   165: astore 4
    //   167: aload_3
    //   168: monitorexit
    //   169: aload 4
    //   171: athrow
    //   172: astore 4
    //   174: aload_0
    //   175: getfield 158	com/tencent/mm/plugin/u/i:kSN	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   178: invokevirtual 758	com/tencent/mm/compatible/deviceinfo/aa:release	()V
    //   181: aload_0
    //   182: aconst_null
    //   183: putfield 158	com/tencent/mm/plugin/u/i:kSN	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   186: goto -63 -> 123
    //   189: astore 4
    //   191: aload_0
    //   192: aconst_null
    //   193: putfield 158	com/tencent/mm/plugin/u/i:kSN	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   196: aload 4
    //   198: athrow
    //   199: astore 4
    //   201: aload_0
    //   202: getfield 158	com/tencent/mm/plugin/u/i:kSN	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   205: invokevirtual 758	com/tencent/mm/compatible/deviceinfo/aa:release	()V
    //   208: aload_0
    //   209: aconst_null
    //   210: putfield 158	com/tencent/mm/plugin/u/i:kSN	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   213: aload 4
    //   215: athrow
    //   216: astore 4
    //   218: aload_0
    //   219: aconst_null
    //   220: putfield 158	com/tencent/mm/plugin/u/i:kSN	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   223: aload 4
    //   225: athrow
    //   226: ldc 115
    //   228: ldc_w 771
    //   231: iconst_1
    //   232: anewarray 4	java/lang/Object
    //   235: dup
    //   236: iconst_0
    //   237: aload_0
    //   238: invokevirtual 121	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   241: aastore
    //   242: invokestatic 171	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   245: goto -93 -> 152
    //   248: aload_0
    //   249: getfield 158	com/tencent/mm/plugin/u/i:kSN	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   252: ifnull +188 -> 440
    //   255: ldc 115
    //   257: ldc_w 762
    //   260: iconst_1
    //   261: anewarray 4	java/lang/Object
    //   264: dup
    //   265: iconst_0
    //   266: aload_0
    //   267: invokevirtual 121	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   270: aastore
    //   271: invokestatic 171	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: aload_0
    //   275: invokevirtual 420	com/tencent/mm/plugin/u/i:eSP	()V
    //   278: invokestatic 156	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   281: lstore_1
    //   282: aload_0
    //   283: getfield 86	com/tencent/mm/plugin/u/i:lock	Ljava/lang/Object;
    //   286: astore_3
    //   287: aload_3
    //   288: monitorenter
    //   289: ldc 115
    //   291: ldc_w 764
    //   294: iconst_2
    //   295: anewarray 4	java/lang/Object
    //   298: dup
    //   299: iconst_0
    //   300: aload_0
    //   301: invokevirtual 121	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   304: aastore
    //   305: dup
    //   306: iconst_1
    //   307: lload_1
    //   308: invokestatic 196	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   311: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   314: aastore
    //   315: invokestatic 171	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   318: aload_0
    //   319: getfield 158	com/tencent/mm/plugin/u/i:kSN	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   322: invokevirtual 767	com/tencent/mm/compatible/deviceinfo/aa:stop	()V
    //   325: aload_0
    //   326: getfield 158	com/tencent/mm/plugin/u/i:kSN	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   329: invokevirtual 758	com/tencent/mm/compatible/deviceinfo/aa:release	()V
    //   332: aload_0
    //   333: aconst_null
    //   334: putfield 158	com/tencent/mm/plugin/u/i:kSN	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   337: aload_3
    //   338: monitorexit
    //   339: ldc 115
    //   341: ldc_w 769
    //   344: iconst_2
    //   345: anewarray 4	java/lang/Object
    //   348: dup
    //   349: iconst_0
    //   350: aload_0
    //   351: invokevirtual 121	com/tencent/mm/plugin/u/i:info	()Ljava/lang/String;
    //   354: aastore
    //   355: dup
    //   356: iconst_1
    //   357: lload_1
    //   358: invokestatic 196	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   361: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   364: aastore
    //   365: invokestatic 171	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   368: return
    //   369: astore 4
    //   371: aload_0
    //   372: aconst_null
    //   373: putfield 158	com/tencent/mm/plugin/u/i:kSN	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   376: aload 4
    //   378: athrow
    //   379: astore 4
    //   381: aload_3
    //   382: monitorexit
    //   383: aload 4
    //   385: athrow
    //   386: astore 4
    //   388: aload_0
    //   389: getfield 158	com/tencent/mm/plugin/u/i:kSN	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   392: invokevirtual 758	com/tencent/mm/compatible/deviceinfo/aa:release	()V
    //   395: aload_0
    //   396: aconst_null
    //   397: putfield 158	com/tencent/mm/plugin/u/i:kSN	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   400: goto -63 -> 337
    //   403: astore 4
    //   405: aload_0
    //   406: aconst_null
    //   407: putfield 158	com/tencent/mm/plugin/u/i:kSN	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   410: aload 4
    //   412: athrow
    //   413: astore 4
    //   415: aload_0
    //   416: getfield 158	com/tencent/mm/plugin/u/i:kSN	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   419: invokevirtual 758	com/tencent/mm/compatible/deviceinfo/aa:release	()V
    //   422: aload_0
    //   423: aconst_null
    //   424: putfield 158	com/tencent/mm/plugin/u/i:kSN	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   427: aload 4
    //   429: athrow
    //   430: astore 4
    //   432: aload_0
    //   433: aconst_null
    //   434: putfield 158	com/tencent/mm/plugin/u/i:kSN	Lcom/tencent/mm/compatible/deviceinfo/aa;
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
    this.EXd = false;
    setState(3);
    onStart();
  }
  
  abstract String type();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.u.i
 * JD-Core Version:    0.7.0.1
 */