package com.tencent.tav.core.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.decoder.logger.Logger;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;

class EncoderUtils
{
  private static final int FREQ_IDX = 4;
  public static final int INDEX_START = 1;
  private static final int PROFILE = 2;
  
  public static void addADTStoPacket(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(189572);
    byte[] arrayOfByte = generateADTSHeader(paramArrayOfByte.length, paramInt);
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, arrayOfByte.length);
    AppMethodBeat.o(189572);
  }
  
  public static void close(Closeable paramCloseable)
  {
    AppMethodBeat.i(189586);
    if (paramCloseable == null)
    {
      AppMethodBeat.o(189586);
      return;
    }
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(189586);
      return;
    }
    catch (Throwable paramCloseable)
    {
      AppMethodBeat.o(189586);
    }
  }
  
  static void deleteAllTmpFiles(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(189580);
    Logger.d("EncoderUtils", "deleteAllTmpFiles " + paramInt + " sessionId = " + paramString2);
    int i = 1;
    while (i <= paramInt)
    {
      File localFile = new File(getAudioOutSaveFilePath(paramString1, i, paramString2));
      boolean bool = localFile.delete();
      Logger.d("EncoderUtils", "delete file " + localFile.getAbsolutePath() + " deleteResult = " + bool);
      i += 1;
    }
    AppMethodBeat.o(189580);
  }
  
  public static byte[] generateADTSHeader(int paramInt1, int paramInt2)
  {
    return new byte[] { -1, -7, (byte)((paramInt2 >> 2) + 80), (byte)(((paramInt2 & 0x3) << 6) + (paramInt1 >> 11)), (byte)((paramInt1 & 0x7FF) >> 3), (byte)(((paramInt1 & 0x7) << 5) + 31), -4 };
  }
  
  static String getAudioOutSaveFilePath(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(189575);
    int i = paramString1.lastIndexOf(".");
    if (i > 0)
    {
      paramString1 = paramString1.substring(0, i) + "_" + paramString2 + "_" + paramInt + paramString1.substring(i);
      AppMethodBeat.o(189575);
      return paramString1;
    }
    paramString1 = paramString1 + "_" + paramString2 + "_" + paramInt;
    AppMethodBeat.o(189575);
    return paramString1;
  }
  
  private static boolean isValidFile(File paramFile)
  {
    AppMethodBeat.i(189582);
    if ((paramFile.createNewFile()) || ((paramFile.exists()) && (paramFile.isFile())))
    {
      AppMethodBeat.o(189582);
      return true;
    }
    AppMethodBeat.o(189582);
    return false;
  }
  
  static boolean mergeAllFiles(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(189579);
    Logger.d("EncoderUtils", "mergeAllFiles " + paramInt + " sessionId = " + paramString2);
    try
    {
      Object localObject = new File(paramString1);
      ((File)localObject).delete();
      if (isValidFile((File)localObject))
      {
        localObject = new RandomAccessFile((File)localObject, "rw");
        int i = 1;
        while (i <= paramInt)
        {
          ((RandomAccessFile)localObject).write(readFromFile(getAudioOutSaveFilePath(paramString1, i, paramString2)));
          i += 1;
        }
        close((Closeable)localObject);
        AppMethodBeat.o(189579);
        return true;
      }
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(189579);
    }
    return false;
  }
  
  private static byte[] readFromFile(String paramString)
  {
    AppMethodBeat.i(189585);
    paramString = new FileInputStream(paramString);
    try
    {
      byte[] arrayOfByte = new byte[paramString.available()];
      paramString.read(arrayOfByte);
      return arrayOfByte;
    }
    finally
    {
      close(paramString);
      AppMethodBeat.o(189585);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.core.audio.EncoderUtils
 * JD-Core Version:    0.7.0.1
 */