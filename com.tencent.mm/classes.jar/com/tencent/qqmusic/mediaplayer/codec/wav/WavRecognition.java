package com.tencent.qqmusic.mediaplayer.codec.wav;

import android.text.TextUtils;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;

public class WavRecognition
  implements IAudioRecognition
{
  public AudioFormat.AudioType getAudioType(String paramString, byte[] paramArrayOfByte)
  {
    if (WaveReader.isWavFormat(paramString)) {
      return AudioFormat.AudioType.WAV;
    }
    return AudioFormat.AudioType.UNSUPPORT;
  }
  
  public AudioFormat.AudioType guessAudioType(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.toLowerCase().contains(".wav"))) {
      return AudioFormat.AudioType.WAV;
    }
    return AudioFormat.AudioType.UNSUPPORT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.wav.WavRecognition
 * JD-Core Version:    0.7.0.1
 */