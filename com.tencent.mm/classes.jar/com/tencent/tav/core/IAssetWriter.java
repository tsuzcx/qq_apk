package com.tencent.tav.core;

import com.tencent.tav.decoder.EncoderWriter;

public abstract interface IAssetWriter
  extends IContextCreate
{
  public abstract EncoderWriter encoderWriter();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.IAssetWriter
 * JD-Core Version:    0.7.0.1
 */