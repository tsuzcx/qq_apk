package com.tencent.mm.plugin.vlog.decoder;

import android.media.MediaCodec.BufferInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/decoder/BufferQueue;", "", "count", "", "bufferSize", "tag", "", "(IILjava/lang/String;)V", "bufferList", "", "Lcom/tencent/mm/plugin/vlog/decoder/BufferQueue$BufferItem;", "[Lcom/tencent/mm/plugin/vlog/decoder/BufferQueue$BufferItem;", "getBufferSize", "()I", "setBufferSize", "(I)V", "getCount", "empty", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "full", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "readEnd", "readStart", "getTag", "()Ljava/lang/String;", "writeEnd", "writeStart", "acquireRead", "timeoutUs", "", "acquireWrite", "get", "index", "releaseRead", "", "releaseWrite", "rollbackWrite", "toString", "BufferItem", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private final Condition BkI;
  private final a[] TXr;
  final Condition TXs;
  int TXt;
  private int TXu;
  private int TXv;
  private int TXw;
  final ReentrantLock bKF;
  int bufferSize;
  private final int count;
  private final String tag;
  
  public b(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(281346);
    this.count = paramInt1;
    this.bufferSize = paramInt2;
    this.tag = paramString;
    paramInt1 = 0;
    paramInt2 = this.count;
    paramString = new a[paramInt2];
    while (paramInt1 < paramInt2)
    {
      paramString[paramInt1] = null;
      paramInt1 += 1;
    }
    this.TXr = paramString;
    this.bKF = new ReentrantLock();
    this.BkI = this.bKF.newCondition();
    this.TXs = this.bKF.newCondition();
    if (this.count == 0)
    {
      paramString = new IllegalArgumentException(s.X("Invalid count ", Integer.valueOf(this.count)));
      AppMethodBeat.o(281346);
      throw paramString;
    }
    AppMethodBeat.o(281346);
  }
  
  public final a apw(int paramInt)
  {
    AppMethodBeat.i(281369);
    this.bKF.lock();
    try
    {
      Object localObject3 = this.TXr[paramInt];
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = new MediaCodec.BufferInfo();
        localObject3 = ByteBuffer.allocateDirect(this.bufferSize).order(ByteOrder.nativeOrder());
        s.s(localObject3, "allocateDirect(bufferSiz…(ByteOrder.nativeOrder())");
        localObject1 = new a((MediaCodec.BufferInfo)localObject1, (ByteBuffer)localObject3);
        this.TXr[paramInt] = localObject1;
      }
      return localObject1;
    }
    finally
    {
      this.bKF.unlock();
      AppMethodBeat.o(281369);
    }
  }
  
  public final void hQk()
  {
    AppMethodBeat.i(281362);
    this.bKF.lock();
    try
    {
      this.TXw += 1;
      this.TXs.signalAll();
      return;
    }
    finally
    {
      this.bKF.unlock();
      AppMethodBeat.o(281362);
    }
  }
  
  public final void hQl()
  {
    AppMethodBeat.i(281366);
    this.bKF.lock();
    try
    {
      this.TXu += 1;
      this.BkI.signalAll();
      return;
    }
    finally
    {
      this.bKF.unlock();
      AppMethodBeat.o(281366);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(281373);
    String str = "[" + this.TXw + ", " + this.TXv + "; " + this.TXu + ", " + this.TXt + "] " + (this.TXt - this.TXw);
    AppMethodBeat.o(281373);
    return str;
  }
  
  public final int wv(long paramLong)
  {
    AppMethodBeat.i(281353);
    this.bKF.lock();
    try
    {
      if ((this.TXu == this.TXv) && (paramLong > 0L))
      {
        boolean bool = this.BkI.await(paramLong, TimeUnit.MICROSECONDS);
        if (!bool) {
          return -1;
        }
      }
      int i = this.TXv;
      this.TXv = (i + 1);
      int j = this.count;
      return i % j;
    }
    finally
    {
      this.bKF.unlock();
      AppMethodBeat.o(281353);
    }
  }
  
  public final int ww(long paramLong)
  {
    AppMethodBeat.i(281357);
    this.bKF.lock();
    try
    {
      if ((this.TXt - this.TXw >= this.count) && (paramLong > 0L))
      {
        boolean bool = this.TXs.await(paramLong, TimeUnit.MICROSECONDS);
        if (!bool) {
          return -1;
        }
      }
      int i = this.TXt;
      this.TXt = (i + 1);
      int j = this.count;
      return i % j;
    }
    finally
    {
      this.bKF.unlock();
      AppMethodBeat.o(281357);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/decoder/BufferQueue$BufferItem;", "", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "buffer", "Ljava/nio/ByteBuffer;", "(Landroid/media/MediaCodec$BufferInfo;Ljava/nio/ByteBuffer;)V", "getBuffer", "()Ljava/nio/ByteBuffer;", "getBufferInfo", "()Landroid/media/MediaCodec$BufferInfo;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    final ByteBuffer buffer;
    final MediaCodec.BufferInfo bufferInfo;
    
    public a(MediaCodec.BufferInfo paramBufferInfo, ByteBuffer paramByteBuffer)
    {
      AppMethodBeat.i(281363);
      this.bufferInfo = paramBufferInfo;
      this.buffer = paramByteBuffer;
      AppMethodBeat.o(281363);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.decoder.b
 * JD-Core Version:    0.7.0.1
 */