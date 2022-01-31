package com.tencent.qqmusic.mediaplayer.codec.ape;

import android.text.TextUtils;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.upstream.FileDataSource;

public class ApeRecognition
  implements IAudioRecognition
{
  public static final String TAG = "ApeRecognition";
  
  public AudioFormat.AudioType getAudioType(String paramString, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (new String(paramArrayOfByte).startsWith("MAC"))) {
      paramArrayOfByte = AudioFormat.AudioType.APE;
    }
    do
    {
      AudioFormat.AudioType localAudioType;
      do
      {
        NativeDecoder localNativeDecoder;
        do
        {
          return paramArrayOfByte;
          localAudioType = AudioFormat.AudioType.UNSUPPORT;
          localNativeDecoder = new NativeDecoder();
          paramArrayOfByte = localAudioType;
        } while (localNativeDecoder.init(new FileDataSource(paramString)) != 0);
        paramString = localNativeDecoder.getAudioInformation();
        paramArrayOfByte = localAudioType;
      } while (paramString == null);
      paramArrayOfByte = localAudioType;
    } while (paramString.getAudioType() != AudioFormat.AudioType.APE);
    return AudioFormat.AudioType.APE;
  }
  
  public AudioFormat.AudioType guessAudioType(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.toLowerCase().contains(".ape")) || (paramString.toLowerCase().contains(".mac")))) {
      return AudioFormat.AudioType.APE;
    }
    return AudioFormat.AudioType.UNSUPPORT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.ape.ApeRecognition
 * JD-Core Version:    0.7.0.1
 */