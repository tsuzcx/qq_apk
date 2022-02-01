package com.tencent.mm.xeffect.effect;

import androidx.annotation.Keep;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/xeffect/effect/IStickerDecoderFactory;", "", "getDecoder", "Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "bytes", "", "path", "", "renderlib_release"})
@Keep
public abstract interface IStickerDecoderFactory
{
  public abstract IStickerDecoder getDecoder(String paramString);
  
  public abstract IStickerDecoder getDecoder(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.IStickerDecoderFactory
 * JD-Core Version:    0.7.0.1
 */