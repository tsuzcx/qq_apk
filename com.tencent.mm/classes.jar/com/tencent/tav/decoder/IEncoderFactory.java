package com.tencent.tav.decoder;

public abstract interface IEncoderFactory
{
  public abstract AssetWriterAudioEncoder getAudioEncoder();
  
  public abstract AssetWriterVideoEncoder getVideoEncoder();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.IEncoderFactory
 * JD-Core Version:    0.7.0.1
 */