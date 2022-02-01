package com.tencent.tav.extractor;

import android.content.res.AssetFileDescriptor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.logger.Logger;
import java.io.FileDescriptor;
import java.io.PrintStream;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.Map;

public class AssetExtractor
  implements Cloneable
{
  public static boolean DOWNGRADING = false;
  public static final int SAMPLE_FLAG_ENCRYPTED = 2;
  public static final int SAMPLE_FLAG_SYNC = 1;
  public static final int SEEK_TO_CLOSEST_SYNC = 2;
  public static final int SEEK_TO_NEXT_SYNC = 1;
  public static final int SEEK_TO_PREVIOUS_SYNC = 0;
  private static final String TAG = "AssetExtractor";
  private IAssetExtractorDelegate delegate;
  private long duration;
  private long mNativeContext;
  private int preferRotation;
  private boolean released;
  private CGSize size;
  private String sourcePath;
  
  static
  {
    AppMethodBeat.i(202045);
    DOWNGRADING = false;
    System.out.println("loadlibrary : tav start");
    try
    {
      System.loadLibrary("tav");
      nativeInit();
      AppMethodBeat.o(202045);
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("AssetExtractor", "setDataSource", localThrowable);
      AppMethodBeat.o(202045);
    }
  }
  
  public AssetExtractor()
  {
    this(DOWNGRADING);
  }
  
  public AssetExtractor(boolean paramBoolean)
  {
    AppMethodBeat.i(202023);
    this.released = false;
    this.mNativeContext = 0L;
    this.sourcePath = "";
    this.duration = 0L;
    this.size = null;
    this.preferRotation = -1;
    if (paramBoolean) {
      this.delegate = new ApiAssetExtractorDelegate();
    }
    AppMethodBeat.o(202023);
  }
  
  private synchronized native boolean advanceNative();
  
  private synchronized native long getSampleTimeNative();
  
  private synchronized native int getSampleTrackIndexNative();
  
  private final synchronized native int getTrackCountNative();
  
  private synchronized native Map<String, Object> getTrackFormatNative(int paramInt);
  
  private final synchronized native void nativeFinalize();
  
  private static final synchronized native void nativeInit();
  
  private synchronized native int readSampleDataNative(ByteBuffer paramByteBuffer, int paramInt);
  
  private final synchronized native void releaseNative();
  
  private native void seekToNative(long paramLong, int paramInt);
  
  private synchronized native void selectTrackNative(int paramInt);
  
  private synchronized native void unselectTrackNative(int paramInt);
  
  public boolean advance()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(202035);
        if (this.delegate != null)
        {
          bool = this.delegate.advance();
          AppMethodBeat.o(202035);
          return bool;
        }
        if (!this.released)
        {
          bool = advanceNative();
          AppMethodBeat.o(202035);
          continue;
        }
        boolean bool = false;
      }
      finally {}
      AppMethodBeat.o(202035);
    }
  }
  
  public AssetExtractor clone()
  {
    AppMethodBeat.i(202024);
    AssetExtractor localAssetExtractor = new AssetExtractor();
    localAssetExtractor.setSize(getSize());
    localAssetExtractor.setPreferRotation(getPreferRotation());
    localAssetExtractor.setDuration(getDuration());
    localAssetExtractor.setDataSource(this.sourcePath);
    AppMethodBeat.o(202024);
    return localAssetExtractor;
  }
  
  /* Error */
  public void dispose()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 168
    //   4: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 99	com/tencent/tav/extractor/AssetExtractor:sourcePath	Ljava/lang/String;
    //   11: invokevirtual 173	java/lang/String:isEmpty	()Z
    //   14: ifeq +11 -> 25
    //   17: ldc 168
    //   19: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: getfield 93	com/tencent/tav/extractor/AssetExtractor:released	Z
    //   29: ifne +14 -> 43
    //   32: aload_0
    //   33: getfield 110	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   36: ifnonnull +7 -> 43
    //   39: aload_0
    //   40: invokespecial 175	com/tencent/tav/extractor/AssetExtractor:releaseNative	()V
    //   43: ldc 168
    //   45: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: goto -26 -> 22
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	AssetExtractor
    //   51	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	51	finally
    //   25	43	51	finally
    //   43	48	51	finally
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(202028);
    if (this.delegate != null)
    {
      AppMethodBeat.o(202028);
      return;
    }
    if (this.released)
    {
      AppMethodBeat.o(202028);
      return;
    }
    try
    {
      if (!this.released)
      {
        this.released = true;
        nativeFinalize();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(202028);
    }
  }
  
  public long getAudioDuration()
  {
    try
    {
      AppMethodBeat.i(202041);
      long l = ExtractorUtils.getAudioDuration(this);
      AppMethodBeat.o(202041);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getDuration()
  {
    try
    {
      AppMethodBeat.i(202040);
      if (this.duration == 0L) {
        this.duration = ExtractorUtils.getDuration(this);
      }
      long l = this.duration;
      AppMethodBeat.o(202040);
      return l;
    }
    finally {}
  }
  
  public int getPreferRotation()
  {
    try
    {
      AppMethodBeat.i(202043);
      if (this.preferRotation == -1) {
        this.preferRotation = ExtractorUtils.getPreferRotation(this);
      }
      int i = this.preferRotation;
      AppMethodBeat.o(202043);
      return i;
    }
    finally {}
  }
  
  public native int getSampleFlags();
  
  public long getSampleTime()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(202038);
        if (this.delegate != null)
        {
          l = this.delegate.getSampleTime();
          AppMethodBeat.o(202038);
          return l;
        }
        if (!this.released)
        {
          l = getSampleTimeNative();
          AppMethodBeat.o(202038);
          continue;
        }
        long l = -1L;
      }
      finally {}
      AppMethodBeat.o(202038);
    }
  }
  
  public int getSampleTrackIndex()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(202037);
        if (this.delegate != null)
        {
          i = this.delegate.getSampleTrackIndex();
          AppMethodBeat.o(202037);
          return i;
        }
        if (!this.released)
        {
          i = getSampleTrackIndexNative();
          AppMethodBeat.o(202037);
          continue;
        }
        int i = -1;
      }
      finally {}
      AppMethodBeat.o(202037);
    }
  }
  
  public CGSize getSize()
  {
    try
    {
      AppMethodBeat.i(202042);
      if (this.size == null) {
        this.size = ExtractorUtils.getVideoSize(this);
      }
      CGSize localCGSize = this.size;
      AppMethodBeat.o(202042);
      return localCGSize;
    }
    finally {}
  }
  
  public String getSourcePath()
  {
    return this.sourcePath;
  }
  
  public final int getTrackCount()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(202030);
        if (this.delegate != null)
        {
          i = this.delegate.getTrackCount();
          AppMethodBeat.o(202030);
          return i;
        }
        if (!this.released)
        {
          i = getTrackCountNative();
          AppMethodBeat.o(202030);
          continue;
        }
        int i = 0;
      }
      finally {}
      AppMethodBeat.o(202030);
    }
  }
  
  public MediaFormat getTrackFormat(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(202031);
        if (this.delegate != null)
        {
          localMediaFormat = this.delegate.getTrackFormat(paramInt);
          AppMethodBeat.o(202031);
          return localMediaFormat;
        }
        MediaFormat localMediaFormat = new MediaFormat();
        if (this.released)
        {
          AppMethodBeat.o(202031);
          continue;
        }
        localMap = getTrackFormatNative(paramInt);
      }
      finally {}
      try
      {
        Map localMap;
        Field localField = MediaFormat.class.getDeclaredField("mMap");
        localField.setAccessible(true);
        localField.set(localObject, localMap);
        AppMethodBeat.o(202031);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.getMessage();
        }
      }
    }
  }
  
  public boolean isReleased()
  {
    return this.released;
  }
  
  public int readSampleData(ByteBuffer paramByteBuffer, int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(202036);
        if (this.delegate != null)
        {
          paramInt = this.delegate.readSampleData(paramByteBuffer, paramInt);
          AppMethodBeat.o(202036);
          return paramInt;
        }
        if (!this.released)
        {
          paramInt = readSampleDataNative(paramByteBuffer, paramInt);
          AppMethodBeat.o(202036);
          continue;
        }
        paramInt = -1;
      }
      finally {}
      AppMethodBeat.o(202036);
    }
  }
  
  /* Error */
  public final void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 262
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 110	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   12: ifnull +26 -> 38
    //   15: aload_0
    //   16: getfield 110	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   19: invokeinterface 264 1 0
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield 110	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   29: ldc_w 262
    //   32: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: aload_0
    //   39: getfield 93	com/tencent/tav/extractor/AssetExtractor:released	Z
    //   42: ifne +12 -> 54
    //   45: aload_0
    //   46: invokespecial 175	com/tencent/tav/extractor/AssetExtractor:releaseNative	()V
    //   49: aload_0
    //   50: iconst_1
    //   51: putfield 93	com/tencent/tav/extractor/AssetExtractor:released	Z
    //   54: ldc_w 262
    //   57: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: goto -25 -> 35
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	AssetExtractor
    //   63	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	35	63	finally
    //   38	54	63	finally
    //   54	60	63	finally
  }
  
  /* Error */
  public void seekTo(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 266
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 110	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   12: ifnull +23 -> 35
    //   15: aload_0
    //   16: getfield 110	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   19: lload_1
    //   20: iload_3
    //   21: invokeinterface 268 4 0
    //   26: ldc_w 266
    //   29: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: aload_0
    //   36: getfield 93	com/tencent/tav/extractor/AssetExtractor:released	Z
    //   39: ifne +9 -> 48
    //   42: aload_0
    //   43: lload_1
    //   44: iload_3
    //   45: invokespecial 270	com/tencent/tav/extractor/AssetExtractor:seekToNative	(JI)V
    //   48: ldc_w 266
    //   51: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: goto -22 -> 32
    //   57: astore 4
    //   59: aload_0
    //   60: monitorexit
    //   61: aload 4
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	AssetExtractor
    //   0	64	1	paramLong	long
    //   0	64	3	paramInt	int
    //   57	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	32	57	finally
    //   35	48	57	finally
    //   48	54	57	finally
  }
  
  /* Error */
  public void selectTrack(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 272
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 110	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   12: ifnull +22 -> 34
    //   15: aload_0
    //   16: getfield 110	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   19: iload_1
    //   20: invokeinterface 274 2 0
    //   25: ldc_w 272
    //   28: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: getfield 93	com/tencent/tav/extractor/AssetExtractor:released	Z
    //   38: ifne +8 -> 46
    //   41: aload_0
    //   42: iload_1
    //   43: invokespecial 276	com/tencent/tav/extractor/AssetExtractor:selectTrackNative	(I)V
    //   46: ldc_w 272
    //   49: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: goto -21 -> 31
    //   55: astore_2
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_2
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	AssetExtractor
    //   0	60	1	paramInt	int
    //   55	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	31	55	finally
    //   34	46	55	finally
    //   46	52	55	finally
  }
  
  public final void setDataSource(AssetFileDescriptor paramAssetFileDescriptor)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(202026);
        if (this.delegate != null)
        {
          this.delegate.setDataSource(paramAssetFileDescriptor);
          AppMethodBeat.o(202026);
          return;
        }
        if (paramAssetFileDescriptor.getDeclaredLength() < 0L)
        {
          setDataSource(paramAssetFileDescriptor.getFileDescriptor());
          AppMethodBeat.o(202026);
          continue;
        }
        setDataSource(paramAssetFileDescriptor.getFileDescriptor(), paramAssetFileDescriptor.getStartOffset(), paramAssetFileDescriptor.getDeclaredLength());
      }
      finally {}
      AppMethodBeat.o(202026);
    }
  }
  
  /* Error */
  public final void setDataSource(FileDescriptor paramFileDescriptor)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 299
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 110	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   12: ifnull +22 -> 34
    //   15: aload_0
    //   16: getfield 110	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   19: aload_1
    //   20: invokeinterface 300 2 0
    //   25: ldc_w 299
    //   28: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: aload_1
    //   36: lconst_0
    //   37: ldc2_w 301
    //   40: invokevirtual 298	com/tencent/tav/extractor/AssetExtractor:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   43: ldc_w 299
    //   46: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: goto -18 -> 31
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	AssetExtractor
    //   0	57	1	paramFileDescriptor	FileDescriptor
    // Exception table:
    //   from	to	target	type
    //   2	31	52	finally
    //   34	49	52	finally
  }
  
  public final native void setDataSource(FileDescriptor paramFileDescriptor, long paramLong1, long paramLong2);
  
  /* Error */
  public final void setDataSource(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 303
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 110	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   12: ifnull +13 -> 25
    //   15: aload_0
    //   16: getfield 110	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   19: aload_1
    //   20: invokeinterface 304 2 0
    //   25: aload_0
    //   26: aload_1
    //   27: putfield 99	com/tencent/tav/extractor/AssetExtractor:sourcePath	Ljava/lang/String;
    //   30: aload_1
    //   31: invokestatic 310	com/tencent/tav/extractor/wrapper/ExtractorWrapperPool:contains	(Ljava/lang/String;)Z
    //   34: ifeq +20 -> 54
    //   37: aload_0
    //   38: getfield 99	com/tencent/tav/extractor/AssetExtractor:sourcePath	Ljava/lang/String;
    //   41: aload_0
    //   42: invokestatic 314	com/tencent/tav/extractor/wrapper/ExtractorWrapperPool:fillIn	(Ljava/lang/String;Lcom/tencent/tav/extractor/AssetExtractor;)V
    //   45: ldc_w 303
    //   48: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: aload_1
    //   55: invokestatic 319	com/tencent/tav/extractor/wrapper/ExtractorLoader:cacheExtractor	(Ljava/lang/String;)V
    //   58: ldc_w 303
    //   61: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: goto -13 -> 51
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	AssetExtractor
    //   0	72	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	25	67	finally
    //   25	51	67	finally
    //   54	64	67	finally
  }
  
  public void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }
  
  public void setPreferRotation(int paramInt)
  {
    this.preferRotation = paramInt;
  }
  
  public void setSize(CGSize paramCGSize)
  {
    this.size = paramCGSize;
  }
  
  /* Error */
  public void unselectTrack(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 321
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 110	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   12: ifnull +22 -> 34
    //   15: aload_0
    //   16: getfield 110	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   19: iload_1
    //   20: invokeinterface 323 2 0
    //   25: ldc_w 321
    //   28: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: getfield 93	com/tencent/tav/extractor/AssetExtractor:released	Z
    //   38: ifne +8 -> 46
    //   41: aload_0
    //   42: iload_1
    //   43: invokespecial 325	com/tencent/tav/extractor/AssetExtractor:unselectTrackNative	(I)V
    //   46: ldc_w 321
    //   49: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: goto -21 -> 31
    //   55: astore_2
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_2
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	AssetExtractor
    //   0	60	1	paramInt	int
    //   55	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	31	55	finally
    //   34	46	55	finally
    //   46	52	55	finally
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SampleFlag {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SeekMode {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.extractor.AssetExtractor
 * JD-Core Version:    0.7.0.1
 */