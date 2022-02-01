package com.tencent.mm.xeffect.effect;

import android.graphics.Bitmap;
import android.util.Size;
import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/xeffect/effect/StickerDecoderWrapper;", "Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "decoder", "(Lcom/tencent/mm/xeffect/effect/IStickerDecoder;)V", "getDecoder", "()Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "destroy", "", "duration", "", "getFrame", "Landroid/graphics/Bitmap;", "seekTo", "time", "size", "Landroid/util/Size;", "sizeInArray", "", "renderlib_release"})
@Keep
public final class StickerDecoderWrapper
  implements IStickerDecoder
{
  private final IStickerDecoder decoder;
  
  public StickerDecoderWrapper(IStickerDecoder paramIStickerDecoder)
  {
    AppMethodBeat.i(195888);
    this.decoder = paramIStickerDecoder;
    AppMethodBeat.o(195888);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(195886);
    this.decoder.destroy();
    AppMethodBeat.o(195886);
  }
  
  public final long duration()
  {
    AppMethodBeat.i(195883);
    long l = this.decoder.duration();
    AppMethodBeat.o(195883);
    return l;
  }
  
  public final IStickerDecoder getDecoder()
  {
    return this.decoder;
  }
  
  public final Bitmap getFrame()
  {
    AppMethodBeat.i(195885);
    Bitmap localBitmap = this.decoder.getFrame();
    AppMethodBeat.o(195885);
    return localBitmap;
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(195884);
    this.decoder.seekTo(paramLong);
    AppMethodBeat.o(195884);
  }
  
  public final Size size()
  {
    AppMethodBeat.i(195881);
    Size localSize = this.decoder.size();
    AppMethodBeat.o(195881);
    return localSize;
  }
  
  public final int[] sizeInArray()
  {
    AppMethodBeat.i(195882);
    Size localSize = this.decoder.size();
    int i = localSize.getWidth();
    int j = localSize.getHeight();
    AppMethodBeat.o(195882);
    return new int[] { i, j };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.StickerDecoderWrapper
 * JD-Core Version:    0.7.0.1
 */