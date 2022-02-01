package com.tencent.mm.xeffect.effect;

import android.graphics.Bitmap;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/xeffect/effect/StickerDecoderWrapper;", "Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "decoder", "(Lcom/tencent/mm/xeffect/effect/IStickerDecoder;)V", "getDecoder", "()Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "destroy", "", "duration", "", "getFrame", "Landroid/graphics/Bitmap;", "seekTo", "time", "size", "Landroid/util/Size;", "sizeInArray", "", "renderlib_release"}, k=1, mv={1, 1, 15})
public final class StickerDecoderWrapper
  implements IStickerDecoder
{
  private final IStickerDecoder decoder;
  
  public StickerDecoderWrapper(IStickerDecoder paramIStickerDecoder)
  {
    AppMethodBeat.i(234593);
    this.decoder = paramIStickerDecoder;
    AppMethodBeat.o(234593);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(234606);
    this.decoder.destroy();
    AppMethodBeat.o(234606);
  }
  
  public final long duration()
  {
    AppMethodBeat.i(234599);
    long l = this.decoder.duration();
    AppMethodBeat.o(234599);
    return l;
  }
  
  public final IStickerDecoder getDecoder()
  {
    return this.decoder;
  }
  
  public final Bitmap getFrame()
  {
    AppMethodBeat.i(234604);
    Bitmap localBitmap = this.decoder.getFrame();
    AppMethodBeat.o(234604);
    return localBitmap;
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(234602);
    this.decoder.seekTo(paramLong);
    AppMethodBeat.o(234602);
  }
  
  public final Size size()
  {
    AppMethodBeat.i(234595);
    Size localSize = this.decoder.size();
    AppMethodBeat.o(234595);
    return localSize;
  }
  
  public final int[] sizeInArray()
  {
    AppMethodBeat.i(234598);
    Size localSize = this.decoder.size();
    int i = localSize.getWidth();
    int j = localSize.getHeight();
    AppMethodBeat.o(234598);
    return new int[] { i, j };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.StickerDecoderWrapper
 * JD-Core Version:    0.7.0.1
 */