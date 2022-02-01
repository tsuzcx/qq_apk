package com.tencent.tmediacodec.b;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmediacodec.a.a;
import com.tencent.tmediacodec.e.a.b;
import com.tencent.tmediacodec.g.b;

public final class d
  implements c
{
  private final MediaCodec btk;
  
  public d(MediaCodec paramMediaCodec)
  {
    this.btk = paramMediaCodec;
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    AppMethodBeat.i(190110);
    this.btk.queueInputBuffer(paramInt1, 0, paramInt2, paramLong, paramInt3);
    AppMethodBeat.o(190110);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(190101);
    b.bqS("DirectCodecWrapper");
    AppMethodBeat.o(190101);
  }
  
  public final a.b b(e parame)
  {
    AppMethodBeat.i(190102);
    b.bqS("DirectCodecWrapper");
    parame = a.b.SmB;
    AppMethodBeat.o(190102);
    return parame;
  }
  
  public final void configure(MediaFormat paramMediaFormat, Surface paramSurface, MediaCrypto paramMediaCrypto, int paramInt)
  {
    AppMethodBeat.i(190104);
    this.btk.configure(paramMediaFormat, paramSurface, paramMediaCrypto, 0);
    AppMethodBeat.o(190104);
  }
  
  public final int dequeueInputBuffer(long paramLong)
  {
    AppMethodBeat.i(190112);
    int i = this.btk.dequeueInputBuffer(paramLong);
    AppMethodBeat.o(190112);
    return i;
  }
  
  public final int dequeueOutputBuffer(MediaCodec.BufferInfo paramBufferInfo, long paramLong)
  {
    AppMethodBeat.i(190111);
    int i = this.btk.dequeueOutputBuffer(paramBufferInfo, paramLong);
    AppMethodBeat.o(190111);
    return i;
  }
  
  public final void flush()
  {
    AppMethodBeat.i(190106);
    this.btk.flush();
    AppMethodBeat.o(190106);
  }
  
  public final MediaCodec hps()
  {
    return this.btk;
  }
  
  public final void hpt() {}
  
  public final void hpu()
  {
    AppMethodBeat.i(190103);
    b.bqS("DirectCodecWrapper");
    AppMethodBeat.o(190103);
  }
  
  public final void release()
  {
    AppMethodBeat.i(190108);
    this.btk.release();
    AppMethodBeat.o(190108);
  }
  
  public final void releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(190109);
    this.btk.releaseOutputBuffer(paramInt, paramBoolean);
    AppMethodBeat.o(190109);
  }
  
  @TargetApi(23)
  public final void setOutputSurface(Surface paramSurface)
  {
    AppMethodBeat.i(190113);
    this.btk.setOutputSurface(paramSurface);
    AppMethodBeat.o(190113);
  }
  
  public final void start()
  {
    AppMethodBeat.i(190105);
    this.btk.start();
    AppMethodBeat.o(190105);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(190107);
    this.btk.stop();
    AppMethodBeat.o(190107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tmediacodec.b.d
 * JD-Core Version:    0.7.0.1
 */