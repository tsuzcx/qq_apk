package com.tencent.qqmusic.mediaplayer;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(114405);
    nlog = new NativeLibs("nlog", 0, "NLog", 1L);
    audioCommon = new NativeLibs("audioCommon", 1, "audio_common", 1L);
    QmNativeDataSource = new NativeLibs("QmNativeDataSource", 2, "QmNativeDataSource", 1L);
    formatDetector = new NativeLibs("formatDetector", 3, "FormatDetector", 1L);
    codecFactory = new NativeLibs("codecFactory", 4, "codec_factory", 3L);
    decoderJni = new NativeLibs("decoderJni", 5, "qqmusic_decoder_jni", 3L);
    FFmpeg = new NativeLibs("FFmpeg", 6, "FFmpeg_audio", 3L);
    cppShared = new NativeLibs("cppShared", 7, "c++_shared", 3L);
    stlportShared = new NativeLibs("stlportShared", 8, "stlport_shared", 3L);
    xlog = new NativeLibs("xlog", 9, "wechatxlog", 3L);
    $VALUES = new NativeLibs[] { nlog, audioCommon, QmNativeDataSource, formatDetector, codecFactory, decoderJni, FFmpeg, cppShared, stlportShared, xlog };
    SparseArray localSparseArray = new SparseArray();
    SUFFIX = localSparseArray;
    localSparseArray.put(1, "");
    SUFFIX.put(2, "");
    AppMethodBeat.o(114405);
  }
  
  private NativeLibs(String paramString, long paramLong)
  {
    this.name = paramString;
    this.supportedAbi = paramLong;
  }
  
  public static boolean loadAll(Iterable<NativeLibs> paramIterable)
  {
    AppMethodBeat.i(114402);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      if (!((NativeLibs)paramIterable.next()).load())
      {
        AppMethodBeat.o(114402);
        return false;
      }
    }
    AppMethodBeat.o(114402);
    return true;
  }
  
  public static boolean loadAll(NativeLibs... paramVarArgs)
  {
    AppMethodBeat.i(114401);
    boolean bool = loadAll(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(114401);
    return bool;
  }
  
  private boolean loadLibrary(String paramString)
  {
    boolean bool1 = false;
    AppMethodBeat.i(114404);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(114404);
      return false;
    }
    try
    {
      Logger.i("NativeLibs", "[loadLibrary] loading: ".concat(String.valueOf(paramString)));
      boolean bool2 = AudioPlayerConfigure.getSoLibraryLoader().load(paramString);
      bool1 = bool2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Logger.e("NativeLibs", "[loadLibrary] failed: ".concat(String.valueOf(paramString)), localThrowable);
        continue;
        Logger.e("NativeLibs", "[loadLibrary] failed: ".concat(String.valueOf(paramString)));
      }
    }
    if (bool1)
    {
      Logger.i("NativeLibs", "[loadLibrary] succeed: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(114404);
      return bool1;
    }
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final boolean load()
  {
    AppMethodBeat.i(114403);
    if (this.mHasLoadSoSuccess)
    {
      AppMethodBeat.o(114403);
      return true;
    }
    this.mHasLoadSoSuccess = loadLibrary(getName());
    boolean bool = this.mHasLoadSoSuccess;
    AppMethodBeat.o(114403);
    return bool;
  }
  
  public final boolean supportAbi(int paramInt)
  {
    return (this.supportedAbi & paramInt) == paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.NativeLibs
 * JD-Core Version:    0.7.0.1
 */