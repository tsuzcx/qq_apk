package com.tencent.mm.plugin.n;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Message;
import android.util.Pair;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.y;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.List;

public abstract class h
{
  private static long oEX = 0L;
  private MediaCodec.BufferInfo aMO = new MediaCodec.BufferInfo();
  long aNP;
  protected long aNW;
  private int aNd;
  private int aNe;
  protected long aPF;
  private ByteBuffer[] azr;
  MediaExtractor cfO;
  private String cfP;
  protected MediaCodec eRD;
  protected FileDescriptor fd;
  private ByteBuffer[] inputBuffers;
  private volatile Object lock = new Object();
  protected g oEN;
  protected ak oEO;
  private boolean oEP = false;
  b oEQ = null;
  protected long oER = 0L;
  MediaFormat oES;
  int oET;
  private f oEU;
  private boolean oEV = false;
  private boolean oEW = false;
  protected String path;
  protected int state;
  
  public h(g paramg, ak paramak)
  {
    this.oEN = paramg;
    this.oEO = paramak;
    this.state = 0;
    this.aNd = -1;
    this.aNe = -1;
  }
  
  private void bQv()
  {
    if (this.oEQ != null) {
      this.oER = (this.oEQ.bQp() * 1000L);
    }
  }
  
  private boolean h(long paramLong1, long paramLong2)
  {
    ab.d("MicroMsg.TrackDataSource", "%s drain output buffer time[%d %d] index %d", new Object[] { bau(), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(this.aNe) });
    if (this.aNe < 0)
    {
      synchronized (this.lock)
      {
        this.aNe = this.eRD.dequeueOutputBuffer(this.aMO, oEX);
        if (this.aNe < 0) {
          break label293;
        }
        if ((this.aMO.flags & 0x4) != 0)
        {
          ab.i("MicroMsg.TrackDataSource", "%s process end of stream", new Object[] { bau() });
          setState(9);
          this.aNe = -1;
          return false;
        }
      }
      ??? = this.azr[this.aNe];
      if (??? != null)
      {
        ((ByteBuffer)???).position(this.aMO.offset);
        ((ByteBuffer)???).limit(this.aMO.offset + this.aMO.size);
      }
    }
    if (this.state == 1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        setState(2);
      }
      ab.d("MicroMsg.TrackDataSource", "%s process output buffer index %d ", new Object[] { bau(), Integer.valueOf(this.aNe) });
      synchronized (this.lock)
      {
        if (!a(paramLong1, paramLong2, this.eRD, this.azr[this.aNe], this.aNe, this.aMO)) {
          break;
        }
        this.aNe = -1;
        return true;
      }
      label293:
      if (this.aNe == -2)
      {
        this.oES = this.eRD.getOutputFormat();
        b(this.eRD);
        return true;
      }
      if (this.aNe == -3)
      {
        this.azr = this.eRD.getOutputBuffers();
        return true;
      }
      ab.d("MicroMsg.TrackDataSource", "%s drain output buffer error outputIndex[%d]", new Object[] { bau(), Integer.valueOf(this.aNe) });
      return false;
    }
    return false;
  }
  
  private boolean oE()
  {
    ab.d("MicroMsg.TrackDataSource", "%s start to feed input buffer index %d [%d, %b]", new Object[] { bau(), Integer.valueOf(this.aNd), Integer.valueOf(this.state), Boolean.valueOf(this.oEP) });
    if ((d.zd(this.state)) || (this.oEP))
    {
      ab.i("MicroMsg.TrackDataSource", "%s feed input buffer is end.", new Object[] { bau() });
      return false;
    }
    if (this.aNd < 0)
    {
      this.aNd = this.eRD.dequeueInputBuffer(0L);
      if (this.aNd < 0)
      {
        ab.d("MicroMsg.TrackDataSource", "%s can not dequeue effect input buffer", new Object[] { bau() });
        return false;
      }
    }
    Object localObject = this.inputBuffers[this.aNd];
    int j;
    if (this.oEU != null)
    {
      i = this.oEU.F((ByteBuffer)localObject);
      l1 = this.oEU.oEA.eUW;
      j = this.oEU.oEA.gmB;
      ab.d("MicroMsg.TrackDataSource", "%s read data index[%d, %d] sample info[%d, %d]", new Object[] { bau(), Integer.valueOf(this.aNd), Integer.valueOf(i), Long.valueOf(l1), Integer.valueOf(j) });
      if (i <= 0)
      {
        this.eRD.queueInputBuffer(this.aNd, 0, 0, 0L, 4);
        this.oEP = true;
        return false;
      }
      this.eRD.queueInputBuffer(this.aNd, 0, i, l1, 0);
      this.aNd = -1;
      localObject = this.oEU;
      ((f)localObject).oEB += 1;
      if (((f)localObject).oEB < ((f)localObject).oEC)
      {
        ((f)localObject).oEA = ((com.tencent.mm.plugin.a.g)((f)localObject).gmy.get(((f)localObject).oEB));
        ab.d("MicroMsg.Mp4Extractor", "curr sample [%s]", new Object[] { ((f)localObject).oEA });
      }
      return false;
    }
    if (this.oEN.oEK)
    {
      this.eRD.queueInputBuffer(this.aNd, 0, 0, this.aNP * 1000L, 4);
      this.oEP = true;
      this.oEN.oEK = false;
      return false;
    }
    int i = 0;
    long l2 = 0L;
    int k = 0;
    long l1 = l2;
    try
    {
      j = this.cfO.readSampleData((ByteBuffer)localObject, 0);
      i = j;
      l1 = l2;
      l2 = this.cfO.getSampleTime();
      i = j;
      l1 = l2;
      int m = this.cfO.getSampleFlags();
      i = m;
      l1 = l2;
      k = j;
      j = i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.TrackDataSource", localException, "MediaExtractor get sample data error: %s", new Object[] { localException.getMessage() });
        j = k;
        k = i;
      }
      this.eRD.queueInputBuffer(this.aNd, 0, k, l1, 0);
      this.aNd = -1;
      this.cfO.advance();
      l2 = this.cfO.getSampleTime();
      if (this.oEN.lxF) {
        break label799;
      }
    }
    ab.d("MicroMsg.TrackDataSource", "%s read data index[%d, %d] sample info[%d, %d]", new Object[] { bau(), Integer.valueOf(this.aNd), Integer.valueOf(k), Long.valueOf(l1), Integer.valueOf(j) });
    V(j, l1);
    if (k <= 0)
    {
      this.eRD.queueInputBuffer(this.aNd, 0, 0, this.aNP * 1000L, 4);
      this.oEP = true;
      return false;
    }
    long l3;
    if (P(l1, l2))
    {
      ab.w("MicroMsg.TrackDataSource", "%s feed input buffer isOnlineVideo[%b] next[%d] onlineCacheMs[%d]", new Object[] { bau(), Boolean.valueOf(this.oEN.lxF), Long.valueOf(l2), Long.valueOf(this.oER) });
      l3 = this.cfO.getSampleTime();
      if (Math.abs(l3 - l1) >= 1000000L)
      {
        ab.w("MicroMsg.TrackDataSource", "%s reset extractor finish but seek time is not right[%d, %d]", new Object[] { bau(), Long.valueOf(l3), Long.valueOf(l1) });
        this.oEN.oEK = true;
      }
    }
    for (;;)
    {
      ab.d("MicroMsg.TrackDataSource", "%s finish to feed input buffer [%d, %d]", new Object[] { bau(), Long.valueOf(l1), Long.valueOf(l2) });
      return false;
      label799:
      if (this.oER == 0L)
      {
        if (P(l1, l2))
        {
          ab.w("MicroMsg.TrackDataSource", "%s feed input buffer next[%d] onlineCacheMs[%d]", new Object[] { bau(), Long.valueOf(l2), Long.valueOf(this.oER) });
          l3 = this.cfO.getSampleTime();
          if (Math.abs(l3 - l1) >= 3000000L)
          {
            ab.w("MicroMsg.TrackDataSource", "%s reset extractor finish but seek time is not right[%d, %d]", new Object[] { bau(), Long.valueOf(l3), Long.valueOf(l1) });
            this.oEO.obtainMessage(5, -2, -2).sendToTarget();
          }
          bQv();
        }
      }
      else if ((l2 < 0L) || (l2 / 1000L + 1200L > this.oER))
      {
        ab.w("MicroMsg.TrackDataSource", "%s feed input buffer next[%d] onlineCacheMs[%d]", new Object[] { bau(), Long.valueOf(l2), Long.valueOf(this.oER) });
        if (P(l1, -1L)) {
          this.oEO.obtainMessage(5, -3, -3).sendToTarget();
        }
        bQv();
      }
    }
  }
  
  /* Error */
  protected final int O(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc 94
    //   2: ldc_w 335
    //   5: iconst_4
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: aload_0
    //   12: invokevirtual 100	com/tencent/mm/plugin/n/h:bau	()Ljava/lang/String;
    //   15: aastore
    //   16: dup
    //   17: iconst_1
    //   18: lload_1
    //   19: invokestatic 106	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   22: aastore
    //   23: dup
    //   24: iconst_2
    //   25: lload_3
    //   26: invokestatic 106	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   29: aastore
    //   30: dup
    //   31: iconst_3
    //   32: aload_0
    //   33: getfield 77	com/tencent/mm/plugin/n/h:state	I
    //   36: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   39: aastore
    //   40: invokestatic 117	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: aload_0
    //   44: getfield 119	com/tencent/mm/plugin/n/h:eRD	Landroid/media/MediaCodec;
    //   47: ifnull +31 -> 78
    //   50: aload_0
    //   51: lload_1
    //   52: lload_3
    //   53: invokespecial 337	com/tencent/mm/plugin/n/h:h	(JJ)Z
    //   56: ifeq +17 -> 73
    //   59: aload_0
    //   60: getfield 77	com/tencent/mm/plugin/n/h:state	I
    //   63: invokestatic 193	com/tencent/mm/plugin/n/d:zd	(I)Z
    //   66: istore 5
    //   68: iload 5
    //   70: ifeq -20 -> 50
    //   73: aload_0
    //   74: invokespecial 339	com/tencent/mm/plugin/n/h:oE	()Z
    //   77: pop
    //   78: ldc 94
    //   80: ldc_w 341
    //   83: iconst_2
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: aload_0
    //   90: invokevirtual 100	com/tencent/mm/plugin/n/h:bau	()Ljava/lang/String;
    //   93: aastore
    //   94: dup
    //   95: iconst_1
    //   96: aload_0
    //   97: getfield 77	com/tencent/mm/plugin/n/h:state	I
    //   100: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   103: aastore
    //   104: invokestatic 117	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   107: aload_0
    //   108: getfield 77	com/tencent/mm/plugin/n/h:state	I
    //   111: ireturn
    //   112: astore 6
    //   114: aload_0
    //   115: getfield 69	com/tencent/mm/plugin/n/h:oEV	Z
    //   118: ifeq +131 -> 249
    //   121: ldc 94
    //   123: ldc_w 343
    //   126: iconst_2
    //   127: anewarray 4	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: aload_0
    //   133: invokevirtual 100	com/tencent/mm/plugin/n/h:bau	()Ljava/lang/String;
    //   136: aastore
    //   137: dup
    //   138: iconst_1
    //   139: aload 6
    //   141: invokevirtual 346	java/lang/Exception:toString	()Ljava/lang/String;
    //   144: aastore
    //   145: invokestatic 349	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   148: aload_0
    //   149: getfield 77	com/tencent/mm/plugin/n/h:state	I
    //   152: invokestatic 193	com/tencent/mm/plugin/n/d:zd	(I)Z
    //   155: ifne +7 -> 162
    //   158: aload_0
    //   159: invokevirtual 352	com/tencent/mm/plugin/n/h:bQw	()V
    //   162: aload_0
    //   163: getfield 73	com/tencent/mm/plugin/n/h:oEN	Lcom/tencent/mm/plugin/n/g;
    //   166: astore 6
    //   168: aload_0
    //   169: invokevirtual 355	com/tencent/mm/plugin/n/h:type	()Ljava/lang/String;
    //   172: astore 7
    //   174: aload 6
    //   176: getfield 358	com/tencent/mm/plugin/n/g:oEM	Z
    //   179: ifne -106 -> 73
    //   182: aload 6
    //   184: getfield 361	com/tencent/mm/plugin/n/g:oEJ	Z
    //   187: ifeq -114 -> 73
    //   190: getstatic 367	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   193: ldc2_w 368
    //   196: ldc2_w 370
    //   199: lconst_1
    //   200: iconst_0
    //   201: invokevirtual 375	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   204: getstatic 367	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   207: sipush 13836
    //   210: iconst_3
    //   211: anewarray 4	java/lang/Object
    //   214: dup
    //   215: iconst_0
    //   216: sipush 506
    //   219: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   222: aastore
    //   223: dup
    //   224: iconst_1
    //   225: invokestatic 380	com/tencent/mm/sdk/platformtools/bo:aox	()J
    //   228: invokestatic 106	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   231: aastore
    //   232: dup
    //   233: iconst_2
    //   234: aload 7
    //   236: aastore
    //   237: invokevirtual 383	com/tencent/mm/plugin/report/service/h:e	(I[Ljava/lang/Object;)V
    //   240: aload 6
    //   242: iconst_1
    //   243: putfield 358	com/tencent/mm/plugin/n/g:oEM	Z
    //   246: goto -173 -> 73
    //   249: aload_0
    //   250: iconst_1
    //   251: putfield 69	com/tencent/mm/plugin/n/h:oEV	Z
    //   254: ldc 94
    //   256: aload 6
    //   258: ldc_w 385
    //   261: iconst_1
    //   262: anewarray 4	java/lang/Object
    //   265: dup
    //   266: iconst_0
    //   267: aload_0
    //   268: invokevirtual 100	com/tencent/mm/plugin/n/h:bau	()Ljava/lang/String;
    //   271: aastore
    //   272: invokestatic 284	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   275: goto -127 -> 148
    //   278: astore 6
    //   280: aload_0
    //   281: getfield 71	com/tencent/mm/plugin/n/h:oEW	Z
    //   284: ifeq +131 -> 415
    //   287: ldc 94
    //   289: ldc_w 387
    //   292: iconst_2
    //   293: anewarray 4	java/lang/Object
    //   296: dup
    //   297: iconst_0
    //   298: aload_0
    //   299: invokevirtual 100	com/tencent/mm/plugin/n/h:bau	()Ljava/lang/String;
    //   302: aastore
    //   303: dup
    //   304: iconst_1
    //   305: aload 6
    //   307: invokevirtual 346	java/lang/Exception:toString	()Ljava/lang/String;
    //   310: aastore
    //   311: invokestatic 349	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   314: aload_0
    //   315: getfield 77	com/tencent/mm/plugin/n/h:state	I
    //   318: invokestatic 193	com/tencent/mm/plugin/n/d:zd	(I)Z
    //   321: ifne +7 -> 328
    //   324: aload_0
    //   325: invokevirtual 352	com/tencent/mm/plugin/n/h:bQw	()V
    //   328: aload_0
    //   329: getfield 73	com/tencent/mm/plugin/n/h:oEN	Lcom/tencent/mm/plugin/n/g;
    //   332: astore 6
    //   334: aload_0
    //   335: invokevirtual 355	com/tencent/mm/plugin/n/h:type	()Ljava/lang/String;
    //   338: astore 7
    //   340: aload 6
    //   342: getfield 390	com/tencent/mm/plugin/n/g:oEL	Z
    //   345: ifne -267 -> 78
    //   348: aload 6
    //   350: getfield 361	com/tencent/mm/plugin/n/g:oEJ	Z
    //   353: ifeq -275 -> 78
    //   356: getstatic 367	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   359: ldc2_w 368
    //   362: ldc2_w 391
    //   365: lconst_1
    //   366: iconst_0
    //   367: invokevirtual 375	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   370: getstatic 367	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   373: sipush 13836
    //   376: iconst_3
    //   377: anewarray 4	java/lang/Object
    //   380: dup
    //   381: iconst_0
    //   382: sipush 505
    //   385: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   388: aastore
    //   389: dup
    //   390: iconst_1
    //   391: invokestatic 380	com/tencent/mm/sdk/platformtools/bo:aox	()J
    //   394: invokestatic 106	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   397: aastore
    //   398: dup
    //   399: iconst_2
    //   400: aload 7
    //   402: aastore
    //   403: invokevirtual 383	com/tencent/mm/plugin/report/service/h:e	(I[Ljava/lang/Object;)V
    //   406: aload 6
    //   408: iconst_1
    //   409: putfield 390	com/tencent/mm/plugin/n/g:oEL	Z
    //   412: goto -334 -> 78
    //   415: aload_0
    //   416: iconst_1
    //   417: putfield 71	com/tencent/mm/plugin/n/h:oEW	Z
    //   420: ldc 94
    //   422: aload 6
    //   424: ldc_w 394
    //   427: iconst_1
    //   428: anewarray 4	java/lang/Object
    //   431: dup
    //   432: iconst_0
    //   433: aload_0
    //   434: invokevirtual 100	com/tencent/mm/plugin/n/h:bau	()Ljava/lang/String;
    //   437: aastore
    //   438: invokestatic 284	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   441: goto -127 -> 314
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	444	0	this	h
    //   0	444	1	paramLong1	long
    //   0	444	3	paramLong2	long
    //   66	3	5	bool	boolean
    //   112	28	6	localException1	Exception
    //   166	91	6	localg1	g
    //   278	28	6	localException2	Exception
    //   332	91	6	localg2	g
    //   172	229	7	str	String
    // Exception table:
    //   from	to	target	type
    //   50	68	112	java/lang/Exception
    //   73	78	278	java/lang/Exception
  }
  
  protected final boolean P(long paramLong1, long paramLong2)
  {
    long l1 = bo.yB();
    for (;;)
    {
      try
      {
        if ((paramLong1 / 1000L + 1000L < this.aNP) && (paramLong2 == -1L))
        {
          this.oEN.lxE = true;
          this.oEP = false;
          this.cfO.release();
          this.cfO = new MediaExtractor();
          if (!bo.isNullOrNil(this.path))
          {
            RandomAccessFile localRandomAccessFile = e.cr(this.path, false);
            FileDescriptor localFileDescriptor = localRandomAccessFile.getFD();
            if (ac.erw.erp == 1)
            {
              this.cfO.setDataSource(localFileDescriptor, 0L, e.avI(this.path));
              localRandomAccessFile.close();
              this.cfO.selectTrack(this.oET);
              this.cfO.seekTo(paramLong1, 2);
              long l2 = this.cfO.getSampleTime();
              ab.w("MicroMsg.TrackDataSource", "%s it don't play end. currTime[%d] afterSeek[%d] nextSampleTime[%d] onlineCacheMs[%d] cost[%d]", new Object[] { bau(), Long.valueOf(paramLong1), Long.valueOf(l2), Long.valueOf(paramLong2), Long.valueOf(this.oER), Long.valueOf(bo.av(l1)) });
              return true;
            }
            this.cfO.setDataSource(localFileDescriptor);
            continue;
          }
        }
        else
        {
          return false;
        }
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.TrackDataSource", "%s reset extractor error %s", new Object[] { bau(), localException.toString() });
      }
      if ((this.fd != null) && (this.fd.valid())) {
        this.cfO.setDataSource(this.fd, this.aNW, this.aPF);
      }
    }
  }
  
  protected boolean V(int paramInt, long paramLong)
  {
    return false;
  }
  
  public final void a(FileDescriptor paramFileDescriptor, long paramLong1, long paramLong2)
  {
    this.fd = paramFileDescriptor;
    this.aNW = paramLong1;
    this.aPF = paramLong2;
  }
  
  abstract boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt, MediaCodec.BufferInfo paramBufferInfo);
  
  abstract boolean a(MediaCodec paramMediaCodec);
  
  protected void b(MediaCodec paramMediaCodec) {}
  
  protected void b(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    ab.i("MicroMsg.TrackDataSource", "%s found media format mime[%s] track[%d]", new Object[] { bau(), paramString, Integer.valueOf(paramInt) });
    this.oET = paramInt;
    this.cfP = paramString;
    this.aNP = (paramMediaFormat.getLong("durationUs") / 1000L);
    this.oES = paramMediaFormat;
  }
  
  public final void bQw()
  {
    ab.i("MicroMsg.TrackDataSource", "%s flush codec", new Object[] { bau() });
    this.aNe = -1;
    this.aNd = -1;
    try
    {
      if (this.eRD != null) {
        this.eRD.flush();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  protected final boolean bQx()
  {
    try
    {
      ab.i("MicroMsg.TrackDataSource", "%s start to prepare decoder mime[%s]", new Object[] { bau(), this.cfP });
      this.eRD = MediaCodec.createDecoderByType(this.cfP);
      a(this.eRD);
      this.eRD.start();
      this.inputBuffers = this.eRD.getInputBuffers();
      this.azr = this.eRD.getOutputBuffers();
      return true;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.TrackDataSource", localException, "%s prepare decoder init decoder error ", new Object[] { bau() });
      this.oEN.TT(type());
    }
    return false;
  }
  
  public final String bau()
  {
    return type() + "_" + this.oEN.bau();
  }
  
  protected void onPause() {}
  
  protected void onStart() {}
  
  /* Error */
  protected final void pJ()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 119	com/tencent/mm/plugin/n/h:eRD	Landroid/media/MediaCodec;
    //   4: ifnull +126 -> 130
    //   7: ldc 94
    //   9: ldc_w 529
    //   12: iconst_1
    //   13: anewarray 4	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: aload_0
    //   19: invokevirtual 100	com/tencent/mm/plugin/n/h:bau	()Ljava/lang/String;
    //   22: aastore
    //   23: invokestatic 133	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: aload_0
    //   27: invokevirtual 352	com/tencent/mm/plugin/n/h:bQw	()V
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield 139	com/tencent/mm/plugin/n/h:azr	[Ljava/nio/ByteBuffer;
    //   35: aload_0
    //   36: aconst_null
    //   37: putfield 203	com/tencent/mm/plugin/n/h:inputBuffers	[Ljava/nio/ByteBuffer;
    //   40: invokestatic 397	com/tencent/mm/sdk/platformtools/bo:yB	()J
    //   43: lstore_1
    //   44: aload_0
    //   45: getfield 67	com/tencent/mm/plugin/n/h:lock	Ljava/lang/Object;
    //   48: astore_3
    //   49: aload_3
    //   50: monitorenter
    //   51: ldc 94
    //   53: ldc_w 531
    //   56: iconst_2
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: aload_0
    //   63: invokevirtual 100	com/tencent/mm/plugin/n/h:bau	()Ljava/lang/String;
    //   66: aastore
    //   67: dup
    //   68: iconst_1
    //   69: lload_1
    //   70: invokestatic 458	com/tencent/mm/sdk/platformtools/bo:av	(J)J
    //   73: invokestatic 106	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   76: aastore
    //   77: invokestatic 133	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: aload_0
    //   81: getfield 119	com/tencent/mm/plugin/n/h:eRD	Landroid/media/MediaCodec;
    //   84: invokevirtual 534	android/media/MediaCodec:stop	()V
    //   87: aload_0
    //   88: getfield 119	com/tencent/mm/plugin/n/h:eRD	Landroid/media/MediaCodec;
    //   91: invokevirtual 535	android/media/MediaCodec:release	()V
    //   94: aload_0
    //   95: aconst_null
    //   96: putfield 119	com/tencent/mm/plugin/n/h:eRD	Landroid/media/MediaCodec;
    //   99: aload_3
    //   100: monitorexit
    //   101: ldc 94
    //   103: ldc_w 537
    //   106: iconst_2
    //   107: anewarray 4	java/lang/Object
    //   110: dup
    //   111: iconst_0
    //   112: aload_0
    //   113: invokevirtual 100	com/tencent/mm/plugin/n/h:bau	()Ljava/lang/String;
    //   116: aastore
    //   117: dup
    //   118: iconst_1
    //   119: lload_1
    //   120: invokestatic 458	com/tencent/mm/sdk/platformtools/bo:av	(J)J
    //   123: invokestatic 106	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   126: aastore
    //   127: invokestatic 133	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   130: return
    //   131: astore 4
    //   133: aload_0
    //   134: aconst_null
    //   135: putfield 119	com/tencent/mm/plugin/n/h:eRD	Landroid/media/MediaCodec;
    //   138: aload 4
    //   140: athrow
    //   141: astore 4
    //   143: aload_3
    //   144: monitorexit
    //   145: aload 4
    //   147: athrow
    //   148: astore 4
    //   150: aload_0
    //   151: getfield 119	com/tencent/mm/plugin/n/h:eRD	Landroid/media/MediaCodec;
    //   154: invokevirtual 535	android/media/MediaCodec:release	()V
    //   157: aload_0
    //   158: aconst_null
    //   159: putfield 119	com/tencent/mm/plugin/n/h:eRD	Landroid/media/MediaCodec;
    //   162: goto -63 -> 99
    //   165: astore 4
    //   167: aload_0
    //   168: aconst_null
    //   169: putfield 119	com/tencent/mm/plugin/n/h:eRD	Landroid/media/MediaCodec;
    //   172: aload 4
    //   174: athrow
    //   175: astore 4
    //   177: aload_0
    //   178: getfield 119	com/tencent/mm/plugin/n/h:eRD	Landroid/media/MediaCodec;
    //   181: invokevirtual 535	android/media/MediaCodec:release	()V
    //   184: aload_0
    //   185: aconst_null
    //   186: putfield 119	com/tencent/mm/plugin/n/h:eRD	Landroid/media/MediaCodec;
    //   189: aload 4
    //   191: athrow
    //   192: astore 4
    //   194: aload_0
    //   195: aconst_null
    //   196: putfield 119	com/tencent/mm/plugin/n/h:eRD	Landroid/media/MediaCodec;
    //   199: aload 4
    //   201: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	h
    //   43	77	1	l	long
    //   48	96	3	localObject1	Object
    //   131	8	4	localObject2	Object
    //   141	5	4	localObject3	Object
    //   148	1	4	localException	Exception
    //   165	8	4	localObject4	Object
    //   175	15	4	localObject5	Object
    //   192	8	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   87	94	131	finally
    //   51	80	141	finally
    //   94	99	141	finally
    //   99	101	141	finally
    //   133	141	141	finally
    //   143	145	141	finally
    //   157	162	141	finally
    //   167	175	141	finally
    //   184	192	141	finally
    //   194	202	141	finally
    //   80	87	148	java/lang/Exception
    //   150	157	165	finally
    //   80	87	175	finally
    //   177	184	192	finally
  }
  
  public final void pause()
  {
    ab.i("MicroMsg.TrackDataSource", "%s start to pause", new Object[] { bau() });
    setState(4);
    onPause();
  }
  
  public final boolean prepare()
  {
    ab.i("MicroMsg.TrackDataSource", "%s start to prepare path %s", new Object[] { bau(), this.path });
    long l2 = bo.yB();
    try
    {
      ab.i("MicroMsg.TrackDataSource", "%s start to init extractor", new Object[] { bau() });
      this.cfO = new MediaExtractor();
      if (bo.isNullOrNil(this.path)) {
        break label296;
      }
      localObject1 = e.cr(this.path, false);
      this.fd = ((RandomAccessFile)localObject1).getFD();
      if (ac.erw.erp != 1) {
        break label245;
      }
      this.cfO.setDataSource(this.fd, 0L, e.avI(this.path));
      ((RandomAccessFile)localObject1).close();
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject1;
        int j;
        ab.printErrStackTrace("MicroMsg.TrackDataSource", localException1, "%s prepare init extractor error", new Object[] { bau() });
        this.oEN.TS(localException1.toString());
        return false;
        if ((this.fd != null) && (this.fd.valid())) {
          this.cfO.setDataSource(this.fd, this.aNW, this.aPF);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      ab.e("MicroMsg.TrackDataSource", "%s prepare init extractor error %s", new Object[] { bau(), localThrowable.toString() });
      this.oEN.TS(localThrowable.toString());
      return false;
    }
    j = this.cfO.getTrackCount();
    this.oET = -1;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        localObject1 = this.cfO.getTrackFormat(i);
        String str = ((MediaFormat)localObject1).getString("mime");
        if ((str != null) && (str.contains(type()))) {
          b((MediaFormat)localObject1, str, i);
        }
      }
      else
      {
        if (this.oET >= 0) {
          break label385;
        }
        ab.w("MicroMsg.TrackDataSource", "%s prepare track but can not find track index.[%d, %d]", new Object[] { bau(), Integer.valueOf(j), Integer.valueOf(this.oET) });
        this.oEN.TS("can not find ");
        return false;
        label245:
        this.cfO.setDataSource(this.fd);
        break;
      }
      label296:
      i += 1;
    }
    label385:
    this.cfO.selectTrack(this.oET);
    if (!bo.isNullOrNil(this.path)) {
      this.oEU = null;
    }
    long l3 = bo.yB();
    for (;;)
    {
      try
      {
        ab.i("MicroMsg.TrackDataSource", "%s start to init decoder mime[%s] state[%d]", new Object[] { bau(), this.cfP, Integer.valueOf(this.state) });
        if (!d.zd(this.state)) {
          synchronized (this.lock)
          {
            this.eRD = MediaCodec.createDecoderByType(this.cfP);
            a(this.eRD);
            this.eRD.start();
            this.inputBuffers = this.eRD.getInputBuffers();
            this.azr = this.eRD.getOutputBuffers();
            l1 = bo.yB();
            setState(1);
            ab.i("MicroMsg.TrackDataSource", "%s finish to prepare cost[%d %d %d]", new Object[] { bau(), Long.valueOf(bo.av(l2)), Long.valueOf(l3 - l2), Long.valueOf(l1 - l2) });
            return true;
          }
        }
        long l1 = 0L;
      }
      catch (Exception localException2)
      {
        ab.e("MicroMsg.TrackDataSource", "%s prepare init decoder error %s", new Object[] { bau(), localException2.toString() });
        this.oEN.TT(type());
        return false;
      }
    }
  }
  
  public void release()
  {
    ab.i("MicroMsg.TrackDataSource", "%s release", new Object[] { bau() });
    if (this.cfO != null)
    {
      this.cfO.release();
      this.cfO = null;
    }
    if (this.eRD != null)
    {
      this.eRD.release();
      this.eRD = null;
    }
    f localf;
    if (this.oEU != null)
    {
      localf = this.oEU;
      if (localf.oEz == null) {}
    }
    try
    {
      localf.oEz.close();
      label83:
      localf.gmy.clear();
      localf.gmy = null;
      localf.gmz.clear();
      localf.gmz = null;
      localf.oEA = null;
      ab.i("MicroMsg.TrackDataSource", "%s finish release", new Object[] { bau() });
      return;
    }
    catch (IOException localIOException)
    {
      break label83;
    }
  }
  
  public final void setPath(String paramString)
  {
    this.path = paramString;
  }
  
  protected final void setState(int paramInt)
  {
    ab.i("MicroMsg.TrackDataSource", "%s set state old %d new %d", new Object[] { bau(), Integer.valueOf(this.state), Integer.valueOf(paramInt) });
    this.state = paramInt;
  }
  
  public final void start()
  {
    ab.i("MicroMsg.TrackDataSource", "%s start to play", new Object[] { bau() });
    setState(3);
    onStart();
  }
  
  abstract String type();
  
  public final long zh(int paramInt)
  {
    ab.i("MicroMsg.TrackDataSource", "%s start to seek to ms[%d] isFeedEnd[%b]", new Object[] { bau(), Integer.valueOf(paramInt), Boolean.valueOf(this.oEP) });
    bQw();
    this.oEP = false;
    if (this.oEU != null) {}
    for (;;)
    {
      long l;
      int i;
      try
      {
        f localf = this.oEU;
        l = paramInt * 1000;
        i = 0;
        if (i < localf.gmz.size())
        {
          Pair localPair = (Pair)localf.gmz.get(i);
          if (l >= ((Long)localPair.second).longValue())
          {
            if (l != ((Long)localPair.second).longValue()) {
              break label590;
            }
            localf.oEB = ((Integer)localPair.first).intValue();
            localf.oEA = ((com.tencent.mm.plugin.a.g)localf.gmy.get(localf.oEB));
            if (this.oEU.oEA.eUW < 0L) {
              P(paramInt * 1000L, -1L);
            }
            if (this.oEU.oEA.eUW < 0L)
            {
              P(0L, -1L);
              this.oEN.bQu();
            }
            l = this.oEU.oEA.eUW;
            ab.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d]", new Object[] { bau(), Long.valueOf(l) });
            return l / 1000L;
          }
        }
        if ((i == 0) || (i == localf.gmz.size() - 1))
        {
          localf.oEB = ((Integer)((Pair)localf.gmz.get(i)).first).intValue();
          localf.oEA = ((com.tencent.mm.plugin.a.g)localf.gmy.get(localf.oEB));
          continue;
        }
        localException1.oEB = ((Integer)((Pair)localException1.gmz.get(i - 1)).first).intValue();
      }
      catch (Exception localException1)
      {
        ab.printErrStackTrace("MicroMsg.TrackDataSource", localException1, "%s extractor seek exception %s", new Object[] { bau(), localException1.toString() });
        return 0L;
      }
      localException1.oEA = ((com.tencent.mm.plugin.a.g)localException1.gmy.get(localException1.oEB));
      continue;
      try
      {
        this.cfO.seekTo(paramInt * 1000, 0);
        if (this.cfO.getSampleTime() < 0L) {
          P(paramInt * 1000L, -1L);
        }
        if (this.cfO.getSampleTime() < 0L)
        {
          P(0L, -1L);
          this.oEN.bQu();
        }
        l = this.cfO.getSampleTime();
        ab.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d, %d]", new Object[] { bau(), Long.valueOf(l), Long.valueOf(this.cfO.getCachedDuration()) });
        l /= 1000L;
        return l;
      }
      catch (Exception localException2)
      {
        ab.printErrStackTrace("MicroMsg.TrackDataSource", localException2, "%s extractor seek exception %s", new Object[] { bau(), localException2.toString() });
        return 0L;
      }
      label590:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.n.h
 * JD-Core Version:    0.7.0.1
 */