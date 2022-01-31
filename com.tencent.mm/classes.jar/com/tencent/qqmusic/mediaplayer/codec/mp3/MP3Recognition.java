package com.tencent.qqmusic.mediaplayer.codec.mp3;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;

public class MP3Recognition
  implements IAudioRecognition
{
  public AudioFormat.AudioType getAudioType(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(128576);
    if (MP3FileCheck.isMp3File(paramString))
    {
      paramString = AudioFormat.AudioType.MP3;
      AppMethodBeat.o(128576);
      return paramString;
    }
    paramString = AudioFormat.AudioType.UNSUPPORT;
    AppMethodBeat.o(128576);
    return paramString;
  }
  
  public AudioFormat.AudioType guessAudioType(String paramString)
  {
    AppMethodBeat.i(128577);
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.toLowerCase().endsWith(".mp3")) || (paramString.endsWith(".mp3.tmp")) || (paramString.endsWith(".mp3.mqcc")) || (paramString.endsWith(".ofl")) || (paramString.endsWith(".efe"))))
    {
      paramString = AudioFormat.AudioType.MP3;
      AppMethodBeat.o(128577);
      return paramString;
    }
    paramString = AudioFormat.AudioType.UNSUPPORT;
    AppMethodBeat.o(128577);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.mp3.MP3Recognition
 * JD-Core Version:    0.7.0.1
 */