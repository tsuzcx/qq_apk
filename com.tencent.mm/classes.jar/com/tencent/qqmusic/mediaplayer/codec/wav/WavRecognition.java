package com.tencent.qqmusic.mediaplayer.codec.wav;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;

public class WavRecognition
  implements IAudioRecognition
{
  public AudioFormat.AudioType getAudioType(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(128533);
    if (WaveReader.isWavFormat(paramString))
    {
      paramString = AudioFormat.AudioType.WAV;
      AppMethodBeat.o(128533);
      return paramString;
    }
    paramString = AudioFormat.AudioType.UNSUPPORT;
    AppMethodBeat.o(128533);
    return paramString;
  }
  
  public AudioFormat.AudioType guessAudioType(String paramString)
  {
    AppMethodBeat.i(128534);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.toLowerCase().contains(".wav")))
    {
      paramString = AudioFormat.AudioType.WAV;
      AppMethodBeat.o(128534);
      return paramString;
    }
    paramString = AudioFormat.AudioType.UNSUPPORT;
    AppMethodBeat.o(128534);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.wav.WavRecognition
 * JD-Core Version:    0.7.0.1
 */