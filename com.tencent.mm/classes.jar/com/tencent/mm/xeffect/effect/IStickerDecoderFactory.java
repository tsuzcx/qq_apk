package com.tencent.mm.xeffect.effect;

import android.support.annotation.Keep;
import kotlin.l;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/xeffect/effect/IStickerDecoderFactory;", "", "getDecoder", "Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "bytes", "", "path", "", "renderlib_release"})
@Keep
public abstract interface IStickerDecoderFactory
{
  public abstract IStickerDecoder getDecoder(String paramString);
  
  public abstract IStickerDecoder getDecoder(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.IStickerDecoderFactory
 * JD-Core Version:    0.7.0.1
 */