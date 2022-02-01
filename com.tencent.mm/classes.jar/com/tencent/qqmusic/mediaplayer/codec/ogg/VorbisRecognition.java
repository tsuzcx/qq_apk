package com.tencent.qqmusic.mediaplayer.codec.ogg;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;

public class VorbisRecognition
  implements IAudioRecognition
{
  public AudioFormat.AudioType getAudioType(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114313);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (new String(paramArrayOfByte).startsWith("OggS")))
    {
      paramString = AudioFormat.AudioType.OGG;
      AppMethodBeat.o(114313);
      return paramString;
    }
    paramString = AudioFormat.AudioType.UNSUPPORT;
    AppMethodBeat.o(114313);
    return paramString;
  }
  
  public AudioFormat.AudioType guessAudioType(String paramString)
  {
    AppMethodBeat.i(114314);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.toLowerCase().contains(".ogg")))
    {
      paramString = AudioFormat.AudioType.OGG;
      AppMethodBeat.o(114314);
      return paramString;
    }
    paramString = AudioFormat.AudioType.UNSUPPORT;
    AppMethodBeat.o(114314);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.ogg.VorbisRecognition
 * JD-Core Version:    0.7.0.1
 */