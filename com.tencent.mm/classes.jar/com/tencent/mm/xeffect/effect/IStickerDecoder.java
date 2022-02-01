package com.tencent.mm.xeffect.effect;

import android.graphics.Bitmap;
import android.util.Size;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "", "destroy", "", "duration", "", "getFrame", "Landroid/graphics/Bitmap;", "seekTo", "time", "size", "Landroid/util/Size;", "renderlib_release"}, k=1, mv={1, 1, 15})
public abstract interface IStickerDecoder
{
  public abstract void destroy();
  
  public abstract long duration();
  
  public abstract Bitmap getFrame();
  
  public abstract void seekTo(long paramLong);
  
  public abstract Size size();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.IStickerDecoder
 * JD-Core Version:    0.7.0.1
 */