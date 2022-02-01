package com.tencent.ugc;

import java.nio.ByteBuffer;

public class TXAudioFrame
{
  private ByteBuffer mByteBuffer;
  private int mLength;
  
  public ByteBuffer getByteBuffer()
  {
    return this.mByteBuffer;
  }
  
  public int getLength()
  {
    return this.mLength;
  }
  
  public void setByteBuffer(ByteBuffer paramByteBuffer)
  {
    this.mByteBuffer = paramByteBuffer;
  }
  
  public void setLength(int paramInt)
  {
    this.mLength = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ugc.TXAudioFrame
 * JD-Core Version:    0.7.0.1
 */