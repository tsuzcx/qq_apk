package com.tencent.mm.xeffect.effect;

import android.graphics.Bitmap;
import android.support.annotation.Keep;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/xeffect/effect/StickerDecoderWrapper;", "Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "decoder", "(Lcom/tencent/mm/xeffect/effect/IStickerDecoder;)V", "getDecoder", "()Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "destroy", "", "duration", "", "getFrame", "Landroid/graphics/Bitmap;", "seekTo", "time", "size", "Landroid/util/Size;", "sizeInArray", "", "renderlib_release"})
@Keep
public final class StickerDecoderWrapper
  implements IStickerDecoder
{
  private final IStickerDecoder decoder;
  
  public StickerDecoderWrapper(IStickerDecoder paramIStickerDecoder)
  {
    AppMethodBeat.i(237113);
    this.decoder = paramIStickerDecoder;
    AppMethodBeat.o(237113);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(237112);
    this.decoder.destroy();
    AppMethodBeat.o(237112);
  }
  
  public final long duration()
  {
    AppMethodBeat.i(237109);
    long l = this.decoder.duration();
    AppMethodBeat.o(237109);
    return l;
  }
  
  public final IStickerDecoder getDecoder()
  {
    return this.decoder;
  }
  
  public final Bitmap getFrame()
  {
    AppMethodBeat.i(237111);
    Bitmap localBitmap = this.decoder.getFrame();
    AppMethodBeat.o(237111);
    return localBitmap;
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(237110);
    this.decoder.seekTo(paramLong);
    AppMethodBeat.o(237110);
  }
  
  public final Size size()
  {
    AppMethodBeat.i(237107);
    Size localSize = this.decoder.size();
    AppMethodBeat.o(237107);
    return localSize;
  }
  
  public final int[] sizeInArray()
  {
    AppMethodBeat.i(237108);
    Size localSize = this.decoder.size();
    int i = localSize.getWidth();
    int j = localSize.getHeight();
    AppMethodBeat.o(237108);
    return new int[] { i, j };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.StickerDecoderWrapper
 * JD-Core Version:    0.7.0.1
 */