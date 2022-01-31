package com.tencent.qqmusic.mediaplayer;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.Arrays;
import java.util.Iterator;

public enum NativeLibs
{
  private static final SparseArray<String> SUFFIX;
  private static final String TAG = "NativeLibs";
  private boolean mHasLoadSoSuccess;
  private final String name;
  private final long supportedAbi;
  
  static
  {
    audioCommon = new NativeLibs("audioCommon", 1, "audio_common", 1L);
    formatDetector = new NativeLibs("formatDetector", 2, "FormatDetector", 1L);
    codecFactory = new NativeLibs("codecFactory", 3, "codec_factory", 3L);
    decoderJni = new NativeLibs("decoderJni", 4, "qqmusic_decoder_jni", 3L);
    $VALUES = new NativeLibs[] { nlog, audioCommon, formatDetector, codecFactory, decoderJni };
    SparseArray localSparseArray = new SparseArray();
    SUFFIX = localSparseArray;
    localSparseArray.put(1, "");
    SUFFIX.put(2, "");
  }
  
  private NativeLibs(String paramString, long paramLong)
  {
    this.name = paramString;
    this.supportedAbi = paramLong;
  }
  
  public static boolean loadAll(Iterable<NativeLibs> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      if (!((NativeLibs)paramIterable.next()).load()) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean loadAll(NativeLibs... paramVarArgs)
  {
    return loadAll(Arrays.asList(paramVarArgs));
  }
  
  private boolean loadLibrary(String paramString)
  {
    boolean bool1 = false;
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      Logger.i("NativeLibs", "[loadLibrary] loading: " + paramString);
      boolean bool2 = AudioPlayerConfigure.getSoLibraryLoader().load(paramString);
      bool1 = bool2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Logger.e("NativeLibs", "[loadLibrary] failed: " + paramString, localThrowable);
      }
      Logger.e("NativeLibs", "[loadLibrary] failed: " + paramString);
    }
    if (bool1)
    {
      Logger.i("NativeLibs", "[loadLibrary] succeed: " + paramString);
      return bool1;
    }
    return bool1;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final boolean load()
  {
    if (this.mHasLoadSoSuccess) {
      return true;
    }
    this.mHasLoadSoSuccess = loadLibrary(getName());
    return this.mHasLoadSoSuccess;
  }
  
  public final boolean supportAbi(int paramInt)
  {
    return (this.supportedAbi & paramInt) == paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.NativeLibs
 * JD-Core Version:    0.7.0.1
 */