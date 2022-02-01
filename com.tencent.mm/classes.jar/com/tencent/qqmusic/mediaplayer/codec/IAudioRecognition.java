package com.tencent.qqmusic.mediaplayer.codec;

import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;

public abstract interface IAudioRecognition
{
  public abstract AudioFormat.AudioType getAudioType(String paramString, byte[] paramArrayOfByte);
  
  public abstract AudioFormat.AudioType guessAudioType(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition
 * JD-Core Version:    0.7.0.1
 */