package com.tencent.tav.core;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.AudioInfo;
import java.nio.ByteBuffer;

public abstract interface AudioTapProcessor
{
  public abstract ByteBuffer processAudioPCM(CMTime paramCMTime, ByteBuffer paramByteBuffer, AudioInfo paramAudioInfo);
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.core.AudioTapProcessor
 * JD-Core Version:    0.7.0.1
 */