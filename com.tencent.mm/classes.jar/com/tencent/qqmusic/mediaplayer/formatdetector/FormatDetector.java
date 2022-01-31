package com.tencent.qqmusic.mediaplayer.formatdetector;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioRecognition;
import com.tencent.qqmusic.mediaplayer.NativeLibs;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public class FormatDetector
{
  private static final String TAG = "FormatDetector";
  private static final FormatDetector mInstance;
  public static boolean sIsLoadSuccess;
  
  static
  {
    AppMethodBeat.i(128401);
    mInstance = new FormatDetector();
    sIsLoadSuccess = false;
    sIsLoadSuccess = NativeLibs.loadAll(new NativeLibs[] { NativeLibs.audioCommon, NativeLibs.formatDetector });
    AppMethodBeat.o(128401);
  }
  
  public static AudioFormat.AudioType getAudioFormat(IDataSource paramIDataSource, boolean paramBoolean)
  {
    AppMethodBeat.i(128397);
    if (paramIDataSource == null)
    {
      paramIDataSource = new IllegalArgumentException("dataSource can't be null!");
      AppMethodBeat.o(128397);
      throw paramIDataSource;
    }
    AudioFormat.AudioType localAudioType = AudioFormat.AudioType.UNSUPPORT;
    try
    {
      paramIDataSource = AudioFormat.getAudioType(mInstance.getFormatFromDataSource(paramIDataSource, paramBoolean));
      AppMethodBeat.o(128397);
      return paramIDataSource;
    }
    catch (UnsatisfiedLinkError paramIDataSource)
    {
      for (;;)
      {
        Logger.e("FormatDetector", paramIDataSource);
        paramIDataSource = localAudioType;
      }
    }
  }
  
  public static AudioFormat.AudioType getAudioFormat(String paramString)
  {
    AppMethodBeat.i(128395);
    paramString = getAudioFormat(paramString, true);
    AppMethodBeat.o(128395);
    return paramString;
  }
  
  public static AudioFormat.AudioType getAudioFormat(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(128396);
    if (paramString == null)
    {
      paramString = new IllegalArgumentException("filePath can't be null!");
      AppMethodBeat.o(128396);
      throw paramString;
    }
    try
    {
      AudioFormat.AudioType localAudioType = AudioFormat.getAudioType(mInstance.getFormat(paramString, paramBoolean));
      paramString = localAudioType;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        Logger.e("FormatDetector", localUnsatisfiedLinkError);
        paramString = AudioRecognition.guessFormat(paramString);
      }
    }
    AppMethodBeat.o(128396);
    return paramString;
  }
  
  public static AudioFormat.AudioType getAudioType(IDataSource paramIDataSource)
  {
    AppMethodBeat.i(128400);
    if (paramIDataSource == null)
    {
      paramIDataSource = new IllegalArgumentException("dataSource can't be null!");
      AppMethodBeat.o(128400);
      throw paramIDataSource;
    }
    AudioFormat.AudioType localAudioType = AudioFormat.AudioType.UNSUPPORT;
    if (sIsLoadSuccess)
    {
      paramIDataSource = getAudioFormat(paramIDataSource, false);
      if (!AudioFormat.isAudioType(paramIDataSource)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(128400);
      return paramIDataSource;
      paramIDataSource = localAudioType;
    }
  }
  
  public static AudioFormat.AudioType getAudioType(String paramString)
  {
    AppMethodBeat.i(128399);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(128399);
      return null;
    }
    AudioFormat.AudioType localAudioType1;
    if (sIsLoadSuccess)
    {
      localAudioType1 = getAudioFormat(paramString);
      if (!AudioFormat.isAudioType(localAudioType1)) {}
    }
    for (;;)
    {
      AudioFormat.AudioType localAudioType2 = localAudioType1;
      if (!AudioFormat.isAudioType(localAudioType1)) {
        localAudioType2 = getAudioTypeFromExtension(paramString.substring(paramString.lastIndexOf('.') + 1).toLowerCase());
      }
      AppMethodBeat.o(128399);
      return localAudioType2;
      localAudioType1 = null;
    }
  }
  
  public static AudioFormat.AudioType getAudioTypeFromExtension(String paramString)
  {
    AppMethodBeat.i(128398);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(128398);
      return null;
    }
    AudioFormat.AudioType[] arrayOfAudioType = AudioFormat.AudioType.values();
    int j = arrayOfAudioType.length;
    int i = 0;
    while (i < j)
    {
      AudioFormat.AudioType localAudioType = arrayOfAudioType[i];
      if (localAudioType.getExtension().equalsIgnoreCase(paramString))
      {
        AppMethodBeat.o(128398);
        return localAudioType;
      }
      i += 1;
    }
    paramString = AudioFormat.AudioType.UNSUPPORT;
    AppMethodBeat.o(128398);
    return paramString;
  }
  
  private native int getFormat(String paramString, boolean paramBoolean);
  
  private native int getFormatFromDataSource(IDataSource paramIDataSource, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector
 * JD-Core Version:    0.7.0.1
 */