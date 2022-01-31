package com.tencent.qqmusic.mediaplayer.formatdetector;

import android.text.TextUtils;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioRecognition;
import com.tencent.qqmusic.mediaplayer.NativeLibs;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public class FormatDetector
{
  private static final String TAG = "FormatDetector";
  private static final FormatDetector mInstance = new FormatDetector();
  public static boolean sIsLoadSuccess = NativeLibs.loadAll(new NativeLibs[] { NativeLibs.audioCommon, NativeLibs.formatDetector });
  
  public static AudioFormat.AudioType getAudioFormat(IDataSource paramIDataSource, boolean paramBoolean)
  {
    if (paramIDataSource == null) {
      throw new IllegalArgumentException("dataSource can't be null!");
    }
    AudioFormat.AudioType localAudioType = AudioFormat.AudioType.UNSUPPORT;
    try
    {
      paramIDataSource = AudioFormat.getAudioType(mInstance.getFormatFromDataSource(paramIDataSource, paramBoolean));
      return paramIDataSource;
    }
    catch (UnsatisfiedLinkError paramIDataSource)
    {
      Logger.e("FormatDetector", paramIDataSource);
    }
    return localAudioType;
  }
  
  public static AudioFormat.AudioType getAudioFormat(String paramString)
  {
    return getAudioFormat(paramString, true);
  }
  
  public static AudioFormat.AudioType getAudioFormat(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("filePath can't be null!");
    }
    try
    {
      AudioFormat.AudioType localAudioType = AudioFormat.getAudioType(mInstance.getFormat(paramString, paramBoolean));
      return localAudioType;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      Logger.e("FormatDetector", localUnsatisfiedLinkError);
    }
    return AudioRecognition.guessFormat(paramString);
  }
  
  public static AudioFormat.AudioType getAudioType(IDataSource paramIDataSource)
  {
    if (paramIDataSource == null) {
      throw new IllegalArgumentException("dataSource can't be null!");
    }
    AudioFormat.AudioType localAudioType = AudioFormat.AudioType.UNSUPPORT;
    if (sIsLoadSuccess)
    {
      paramIDataSource = getAudioFormat(paramIDataSource, false);
      if (AudioFormat.isAudioType(paramIDataSource)) {
        return paramIDataSource;
      }
    }
    return localAudioType;
  }
  
  public static AudioFormat.AudioType getAudioType(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
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
      return localAudioType2;
      localAudioType1 = null;
    }
  }
  
  public static AudioFormat.AudioType getAudioTypeFromExtension(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      localObject = null;
      return localObject;
    }
    AudioFormat.AudioType[] arrayOfAudioType = AudioFormat.AudioType.values();
    int j = arrayOfAudioType.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label55;
      }
      AudioFormat.AudioType localAudioType = arrayOfAudioType[i];
      localObject = localAudioType;
      if (localAudioType.getExtension().equalsIgnoreCase(paramString)) {
        break;
      }
      i += 1;
    }
    label55:
    return AudioFormat.AudioType.UNSUPPORT;
  }
  
  private native int getFormat(String paramString, boolean paramBoolean);
  
  private native int getFormatFromDataSource(IDataSource paramIDataSource, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector
 * JD-Core Version:    0.7.0.1
 */