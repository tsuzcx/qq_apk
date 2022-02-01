package com.tencent.mm.xeffect.effect;

import android.graphics.Bitmap;
import android.support.annotation.Keep;
import android.util.Size;
import kotlin.l;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "", "destroy", "", "duration", "", "getFrame", "Landroid/graphics/Bitmap;", "seekTo", "time", "size", "Landroid/util/Size;", "renderlib_release"})
@Keep
public abstract interface IStickerDecoder
{
  public abstract void destroy();
  
  public abstract long duration();
  
  public abstract Bitmap getFrame();
  
  public abstract void seekTo(long paramLong);
  
  public abstract Size size();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.IStickerDecoder
 * JD-Core Version:    0.7.0.1
 */