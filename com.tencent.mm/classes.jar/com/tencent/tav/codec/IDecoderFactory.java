package com.tencent.tav.codec;

public abstract interface IDecoderFactory
{
  public abstract IMediaCodec createAudioDecoder(String paramString1, String paramString2);
  
  public abstract IMediaCodec createVideoDecoder(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.codec.IDecoderFactory
 * JD-Core Version:    0.7.0.1
 */