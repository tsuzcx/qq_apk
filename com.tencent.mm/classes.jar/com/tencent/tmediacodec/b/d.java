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
  private final MediaCodec bcN;
  
  public d(MediaCodec paramMediaCodec)
  {
    this.bcN = paramMediaCodec;
  }
  
  public final int EX(long paramLong)
  {
    AppMethodBeat.i(224257);
    int i = this.bcN.dequeueInputBuffer(paramLong);
    AppMethodBeat.o(224257);
    return i;
  }
  
  public final int a(MediaCodec.BufferInfo paramBufferInfo, long paramLong)
  {
    AppMethodBeat.i(224254);
    int i = this.bcN.dequeueOutputBuffer(paramBufferInfo, paramLong);
    AppMethodBeat.o(224254);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    AppMethodBeat.i(224250);
    this.bcN.queueInputBuffer(paramInt1, 0, paramInt2, paramLong, paramInt3);
    AppMethodBeat.o(224250);
  }
  
  public final void a(MediaFormat paramMediaFormat, Surface paramSurface, MediaCrypto paramMediaCrypto, int paramInt)
  {
    AppMethodBeat.i(224236);
    this.bcN.configure(paramMediaFormat, paramSurface, paramMediaCrypto, 0);
    AppMethodBeat.o(224236);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(224232);
    b.bDR("DirectCodecWrapper");
    AppMethodBeat.o(224232);
  }
  
  public final a.b b(e parame)
  {
    AppMethodBeat.i(224233);
    b.bDR("DirectCodecWrapper");
    parame = a.b.ZPm;
    AppMethodBeat.o(224233);
    return parame;
  }
  
  public final void flush()
  {
    AppMethodBeat.i(224242);
    this.bcN.flush();
    AppMethodBeat.o(224242);
  }
  
  public final MediaCodec isY()
  {
    return this.bcN;
  }
  
  public final void isZ() {}
  
  public final void ita()
  {
    AppMethodBeat.i(224234);
    b.bDR("DirectCodecWrapper");
    AppMethodBeat.o(224234);
  }
  
  @TargetApi(23)
  public final void q(Surface paramSurface)
  {
    AppMethodBeat.i(224259);
    this.bcN.setOutputSurface(paramSurface);
    AppMethodBeat.o(224259);
  }
  
  public final void release()
  {
    AppMethodBeat.i(224245);
    this.bcN.release();
    AppMethodBeat.o(224245);
  }
  
  public final void releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(224246);
    this.bcN.releaseOutputBuffer(paramInt, paramBoolean);
    AppMethodBeat.o(224246);
  }
  
  public final void start()
  {
    AppMethodBeat.i(224241);
    this.bcN.start();
    AppMethodBeat.o(224241);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(224244);
    this.bcN.stop();
    AppMethodBeat.o(224244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmediacodec.b.d
 * JD-Core Version:    0.7.0.1
 */