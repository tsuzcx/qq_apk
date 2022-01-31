package com.tencent.qqmusic.mediaplayer.codec.mp3;

import android.text.TextUtils;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;

public class MP3Recognition
  implements IAudioRecognition
{
  public AudioFormat.AudioType getAudioType(String paramString, byte[] paramArrayOfByte)
  {
    if (MP3FileCheck.isMp3File(paramString)) {
      return AudioFormat.AudioType.MP3;
    }
    return AudioFormat.AudioType.UNSUPPORT;
  }
  
  public AudioFormat.AudioType guessAudioType(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.toLowerCase().endsWith(".mp3")) || (paramString.endsWith(".mp3.tmp")) || (paramString.endsWith(".mp3.mqcc")) || (paramString.endsWith(".ofl")) || (paramString.endsWith(".efe")))) {
      return AudioFormat.AudioType.MP3;
    }
    return AudioFormat.AudioType.UNSUPPORT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.mp3.MP3Recognition
 * JD-Core Version:    0.7.0.1
 */