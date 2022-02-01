package com.tencent.qqmusic.mediaplayer.codec.wav;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.io.IOException;

public class WavRecognition
  implements IAudioRecognition
{
  public static boolean isWav(IDataSource paramIDataSource)
  {
    AppMethodBeat.i(114319);
    byte[] arrayOfByte = new byte[4];
    try
    {
      paramIDataSource.readAt(0L, arrayOfByte, 0, 4);
      if ((arrayOfByte[0] == 82) && (arrayOfByte[1] == 73) && (arrayOfByte[2] == 70) && (arrayOfByte[3] == 70))
      {
        AppMethodBeat.o(114319);
        return true;
      }
    }
    catch (IOException localIOException)
    {
      try
      {
        paramIDataSource.readAt(8L, arrayOfByte, 0, 4);
        label72:
        if ((arrayOfByte[0] == 87) && (arrayOfByte[1] == 65) && (arrayOfByte[2] == 86) && (arrayOfByte[3] == 69))
        {
          AppMethodBeat.o(114319);
          return true;
        }
        AppMethodBeat.o(114319);
        return false;
        localIOException = localIOException;
      }
      catch (IOException paramIDataSource)
      {
        break label72;
      }
    }
  }
  
  public AudioFormat.AudioType getAudioType(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114317);
    if (WaveReader.isWavFormat(paramString))
    {
      paramString = AudioFormat.AudioType.WAV;
      AppMethodBeat.o(114317);
      return paramString;
    }
    paramString = AudioFormat.AudioType.UNSUPPORT;
    AppMethodBeat.o(114317);
    return paramString;
  }
  
  public AudioFormat.AudioType guessAudioType(String paramString)
  {
    AppMethodBeat.i(114318);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.toLowerCase().contains(".wav")))
    {
      paramString = AudioFormat.AudioType.WAV;
      AppMethodBeat.o(114318);
      return paramString;
    }
    paramString = AudioFormat.AudioType.UNSUPPORT;
    AppMethodBeat.o(114318);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.wav.WavRecognition
 * JD-Core Version:    0.7.0.1
 */