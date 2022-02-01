package com.tencent.qqmusic.mediaplayer.codec.flac;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.upstream.FileDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.io.IOException;

public class FLACRecognition
  implements IAudioRecognition
{
  public static final String TAG = "FLACRecognition";
  
  /* Error */
  private boolean checkFormatBySoftDecoder(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 18
    //   4: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 26	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder
    //   10: dup
    //   11: invokespecial 27	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder:<init>	()V
    //   14: astore 4
    //   16: aload 4
    //   18: aload_1
    //   19: iconst_0
    //   20: invokevirtual 31	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder:init	(Ljava/lang/String;Z)I
    //   23: ifne +58 -> 81
    //   26: aload 4
    //   28: invokevirtual 35	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder:getAudioInformation	()Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   31: astore_1
    //   32: iload_3
    //   33: istore_2
    //   34: aload_1
    //   35: ifnull +23 -> 58
    //   38: aload_1
    //   39: invokevirtual 41	com/tencent/qqmusic/mediaplayer/AudioInformation:getAudioType	()Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   42: astore_1
    //   43: getstatic 47	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:FLAC	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   46: astore 5
    //   48: iload_3
    //   49: istore_2
    //   50: aload_1
    //   51: aload 5
    //   53: if_acmpne +5 -> 58
    //   56: iconst_1
    //   57: istore_2
    //   58: aload 4
    //   60: invokevirtual 51	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder:release	()I
    //   63: pop
    //   64: ldc 18
    //   66: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: iload_2
    //   70: ireturn
    //   71: astore_1
    //   72: ldc 10
    //   74: aload_1
    //   75: invokestatic 60	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   78: goto -14 -> 64
    //   81: aload 4
    //   83: invokevirtual 51	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder:release	()I
    //   86: pop
    //   87: ldc 18
    //   89: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: iconst_0
    //   93: ireturn
    //   94: astore_1
    //   95: ldc 10
    //   97: aload_1
    //   98: invokestatic 60	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   101: goto -14 -> 87
    //   104: astore_1
    //   105: ldc 10
    //   107: aload_1
    //   108: invokestatic 60	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   111: aload 4
    //   113: invokevirtual 51	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder:release	()I
    //   116: pop
    //   117: goto -30 -> 87
    //   120: astore_1
    //   121: ldc 10
    //   123: aload_1
    //   124: invokestatic 60	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   127: goto -40 -> 87
    //   130: astore_1
    //   131: aload 4
    //   133: invokevirtual 51	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder:release	()I
    //   136: pop
    //   137: ldc 18
    //   139: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: aload_1
    //   143: athrow
    //   144: astore 4
    //   146: ldc 10
    //   148: aload 4
    //   150: invokestatic 60	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   153: goto -16 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	FLACRecognition
    //   0	156	1	paramString	String
    //   33	37	2	bool1	boolean
    //   1	48	3	bool2	boolean
    //   14	118	4	localNativeDecoder	com.tencent.qqmusic.mediaplayer.codec.NativeDecoder
    //   144	5	4	localThrowable	java.lang.Throwable
    //   46	6	5	localAudioType	AudioFormat.AudioType
    // Exception table:
    //   from	to	target	type
    //   58	64	71	finally
    //   81	87	94	finally
    //   16	32	104	finally
    //   38	48	104	finally
    //   111	117	120	finally
    //   105	111	130	finally
    //   131	137	144	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.flac.FLACRecognition
 * JD-Core Version:    0.7.0.1
 */