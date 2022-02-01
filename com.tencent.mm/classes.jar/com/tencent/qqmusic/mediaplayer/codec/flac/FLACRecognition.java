package com.tencent.qqmusic.mediaplayer.codec.flac;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.upstream.FileDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;

public class FLACRecognition
  implements IAudioRecognition
{
  public static final String TAG = "FLACRecognition";
  
  private boolean checkFormatBySoftDecoder(String paramString)
  {
    boolean bool2 = false;
    AppMethodBeat.i(114337);
    NativeDecoder localNativeDecoder = new NativeDecoder();
    for (;;)
    {
      try
      {
        if (localNativeDecoder.init(paramString, false) == 0)
        {
          paramString = localNativeDecoder.getAudioInformation();
          boolean bool1 = bool2;
          if (paramString != null)
          {
            paramString = paramString.getAudioType();
            AudioFormat.AudioType localAudioType = AudioFormat.AudioType.FLAC;
            bool1 = bool2;
            if (paramString == localAudioType) {
              bool1 = true;
            }
          }
          try
          {
            localNativeDecoder.release();
            AppMethodBeat.o(114337);
            return bool1;
          }
          catch (Throwable paramString)
          {
            Logger.e("FLACRecognition", paramString);
            continue;
          }
        }
      }
      catch (Throwable paramString)
      {
        paramString = paramString;
        Logger.e("FLACRecognition", paramString);
        try
        {
          localNativeDecoder.release();
        }
        catch (Throwable paramString)
        {
          Logger.e("FLACRecognition", paramString);
        }
        continue;
      }
      finally {}
      try
      {
        localNativeDecoder.release();
        AppMethodBeat.o(114337);
        return false;
      }
      catch (Throwable paramString)
      {
        Logger.e("FLACRecognition", paramString);
      }
    }
    try
    {
      localNativeDecoder.release();
      AppMethodBeat.o(114337);
      throw paramString;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Logger.e("FLACRecognition", localThrowable);
      }
    }
  }
  
  public static boolean isFlac(IDataSource paramIDataSource)
  {
    AppMethodBeat.i(114339);
    byte[] arrayOfByte = new byte[10];
    try
    {
      paramIDataSource.readAt(0L, arrayOfByte, 0, 10);
      if ((arrayOfByte[0] == 73) && (arrayOfByte[1] == 68) && (arrayOfByte[2] == 51))
      {
        int i = ((arrayOfByte[6] & 0x7F) << 21) + ((arrayOfByte[7] & 0x7F) << 14) + ((arrayOfByte[8] & 0x7F) << 7) + (arrayOfByte[9] & 0x7F);
        int j;
        if ((arrayOfByte[5] & 0x10) > 0)
        {
          i += 20;
          j = 1;
        }
        for (;;)
        {
          if (j == 0)
          {
            arrayOfByte = new byte[1];
            l = i;
            try
            {
              j = paramIDataSource.readAt(l, arrayOfByte, 0, 1);
              for (;;)
              {
                k = i;
                if (arrayOfByte[0] != 0) {
                  break label205;
                }
                k = i;
                if (j != 1) {
                  break label205;
                }
                i += 1;
                l = i;
                try
                {
                  k = paramIDataSource.readAt(l, arrayOfByte, 0, 1);
                  j = k;
                }
                catch (IOException localIOException2) {}
              }
              i += 10;
              j = 0;
            }
            catch (IOException localIOException1)
            {
              for (;;)
              {
                j = 0;
              }
            }
          }
        }
        k = i;
        label205:
        arrayOfByte = new byte[4];
        l = k;
      }
    }
    catch (IOException localIOException3)
    {
      for (;;)
      {
        try
        {
          long l;
          paramIDataSource.readAt(l, arrayOfByte, 0, 4);
          if ((arrayOfByte[0] == 102) && (arrayOfByte[1] == 76) && (arrayOfByte[2] == 97) && (arrayOfByte[3] == 67))
          {
            AppMethodBeat.o(114339);
            return true;
          }
          AppMethodBeat.o(114339);
          return false;
          localIOException3 = localIOException3;
        }
        catch (IOException paramIDataSource)
        {
          continue;
        }
        int k = 0;
      }
    }
  }
  
  public AudioFormat.AudioType getAudioType(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114336);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (new String(paramArrayOfByte).startsWith("flaC")))
    {
      paramString = AudioFormat.AudioType.FLAC;
      AppMethodBeat.o(114336);
      return paramString;
    }
    if (checkFormatBySoftDecoder(paramString))
    {
      paramString = AudioFormat.AudioType.FLAC;
      AppMethodBeat.o(114336);
      return paramString;
    }
    paramString = AudioFormat.AudioType.UNSUPPORT;
    AppMethodBeat.o(114336);
    return paramString;
  }
  
  public AudioFormat.AudioType guessAudioType(String paramString)
  {
    AppMethodBeat.i(114338);
    boolean bool2;
    boolean bool1;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.toLowerCase().contains(".flac"))
      {
        paramString = AudioFormat.AudioType.FLAC;
        AppMethodBeat.o(114338);
        return paramString;
      }
      paramString = new FileDataSource(paramString);
      bool2 = false;
      bool1 = bool2;
    }
    try
    {
      paramString.open();
      bool1 = bool2;
      bool2 = isFlac(paramString);
      bool1 = bool2;
      paramString.close();
      bool1 = bool2;
    }
    catch (IOException paramString)
    {
      label67:
      break label67;
    }
    if (bool1)
    {
      paramString = AudioFormat.AudioType.FLAC;
      AppMethodBeat.o(114338);
      return paramString;
    }
    paramString = AudioFormat.AudioType.UNSUPPORT;
    AppMethodBeat.o(114338);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.flac.FLACRecognition
 * JD-Core Version:    0.7.0.1
 */