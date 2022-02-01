package com.tencent.tmediacodec.b;

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
  private final MediaCodec codec;
  
  public d(MediaCodec paramMediaCodec)
  {
    this.codec = paramMediaCodec;
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    AppMethodBeat.i(210898);
    this.codec.queueInputBuffer(paramInt1, 0, paramInt2, paramLong, paramInt3);
    AppMethodBeat.o(210898);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(210805);
    b.R("DirectCodecWrapper");
    AppMethodBeat.o(210805);
  }
  
  public final a.b b(e parame)
  {
    AppMethodBeat.i(210820);
    b.R("DirectCodecWrapper");
    parame = a.b.ahUn;
    AppMethodBeat.o(210820);
    return parame;
  }
  
  public final void configure(MediaFormat paramMediaFormat, Surface paramSurface, MediaCrypto paramMediaCrypto, int paramInt)
  {
    AppMethodBeat.i(210850);
    this.codec.configure(paramMediaFormat, paramSurface, paramMediaCrypto, 0);
    AppMethodBeat.o(210850);
  }
  
  public final int dequeueInputBuffer(long paramLong)
  {
    AppMethodBeat.i(210914);
    int i = this.codec.dequeueInputBuffer(paramLong);
    AppMethodBeat.o(210914);
    return i;
  }
  
  public final int dequeueOutputBuffer(MediaCodec.BufferInfo paramBufferInfo, long paramLong)
  {
    AppMethodBeat.i(210906);
    int i = this.codec.dequeueOutputBuffer(paramBufferInfo, paramLong);
    AppMethodBeat.o(210906);
    return i;
  }
  
  public final void flush()
  {
    AppMethodBeat.i(210868);
    this.codec.flush();
    AppMethodBeat.o(210868);
  }
  
  public final MediaCodec kcs()
  {
    return this.codec;
  }
  
  public final void kct() {}
  
  public final void kcu()
  {
    AppMethodBeat.i(210839);
    b.R("DirectCodecWrapper");
    AppMethodBeat.o(210839);
  }
  
  public final void release()
  {
    AppMethodBeat.i(210884);
    this.codec.release();
    AppMethodBeat.o(210884);
  }
  
  public final void releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(210891);
    this.codec.releaseOutputBuffer(paramInt, paramBoolean);
    AppMethodBeat.o(210891);
  }
  
  public final void setOutputSurface(Surface paramSurface)
  {
    AppMethodBeat.i(210920);
    this.codec.setOutputSurface(paramSurface);
    AppMethodBeat.o(210920);
  }
  
  public final void start()
  {
    AppMethodBeat.i(210860);
    this.codec.start();
    AppMethodBeat.o(210860);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(210878);
    this.codec.stop();
    AppMethodBeat.o(210878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmediacodec.b.d
 * JD-Core Version:    0.7.0.1
 */