package com.tencent.tav.extractor;

import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.logger.Logger;
import java.io.FileDescriptor;
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
  private final String TAG;
  private byte _hellAccFlag_;
  private IExtractorDelegate delegate;
  private long duration;
  private long mNativeContext;
  private int preferRotation;
  private boolean released;
  private CGSize size;
  private String sourcePath;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: ldc 38
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 50	com/tencent/tav/ResourceLoadUtil:isLoaded	()Z
    //   8: ifeq +16 -> 24
    //   11: invokestatic 53	com/tencent/tav/extractor/AssetExtractor:nativeInit	()V
    //   14: iconst_0
    //   15: putstatic 55	com/tencent/tav/extractor/AssetExtractor:DOWNGRADING	Z
    //   18: ldc 38
    //   20: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: return
    //   24: getstatic 64	java/lang/System:out	Ljava/io/PrintStream;
    //   27: ldc 66
    //   29: invokevirtual 72	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   32: new 74	com/tencent/mm/hellhoundlib/b/a
    //   35: dup
    //   36: invokespecial 77	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   39: ldc 79
    //   41: invokevirtual 83	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   44: astore_0
    //   45: new 4	java/lang/Object
    //   48: dup
    //   49: invokespecial 84	java/lang/Object:<init>	()V
    //   52: astore_1
    //   53: aload_1
    //   54: aload_0
    //   55: invokevirtual 88	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   58: ldc 89
    //   60: ldc 90
    //   62: ldc 91
    //   64: ldc 93
    //   66: ldc 95
    //   68: ldc 96
    //   70: invokestatic 102	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_0
    //   74: iconst_0
    //   75: invokevirtual 106	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   78: checkcast 108	java/lang/String
    //   81: invokestatic 110	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   84: aload_1
    //   85: ldc 89
    //   87: ldc 90
    //   89: ldc 91
    //   91: ldc 93
    //   93: ldc 95
    //   95: ldc 96
    //   97: invokestatic 114	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   100: iconst_1
    //   101: invokestatic 118	com/tencent/tav/ResourceLoadUtil:setLoaded	(Z)V
    //   104: invokestatic 53	com/tencent/tav/extractor/AssetExtractor:nativeInit	()V
    //   107: goto -93 -> 14
    //   110: astore_0
    //   111: goto -97 -> 14
    // Local variable table:
    //   start	length	slot	name	signature
    //   44	30	0	locala	com.tencent.mm.hellhoundlib.b.a
    //   110	1	0	localObject1	Object
    //   52	33	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   32	107	110	finally
  }
  
  public AssetExtractor()
  {
    this(DOWNGRADING);
  }
  
  public AssetExtractor(boolean paramBoolean)
  {
    AppMethodBeat.i(215018);
    this.TAG = ("AssetExtractor@" + Integer.toHexString(hashCode()));
    this.released = false;
    this.mNativeContext = 0L;
    this.sourcePath = "";
    this.duration = 0L;
    this.size = null;
    this.preferRotation = -1;
    if (paramBoolean) {
      this.delegate = ExtractorDelegateFactory.createDelegate();
    }
    AppMethodBeat.o(215018);
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
        AppMethodBeat.i(215208);
        if (this.delegate != null)
        {
          bool = this.delegate.advance();
          AppMethodBeat.o(215208);
          return bool;
        }
        if (!this.released)
        {
          bool = advanceNative();
          AppMethodBeat.o(215208);
          continue;
        }
        boolean bool = false;
      }
      finally {}
      AppMethodBeat.o(215208);
    }
  }
  
  public AssetExtractor clone()
  {
    AppMethodBeat.i(215303);
    AssetExtractor localAssetExtractor = new AssetExtractor();
    localAssetExtractor.setSize(getSize());
    localAssetExtractor.setPreferRotation(getPreferRotation());
    localAssetExtractor.setDuration(getDuration());
    localAssetExtractor.setDataSource(this.sourcePath);
    AppMethodBeat.o(215303);
    return localAssetExtractor;
  }
  
  /* Error */
  public void dispose()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 227
    //   4: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 156	com/tencent/tav/extractor/AssetExtractor:sourcePath	Ljava/lang/String;
    //   11: invokevirtual 230	java/lang/String:isEmpty	()Z
    //   14: ifeq +11 -> 25
    //   17: ldc 227
    //   19: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: getfield 150	com/tencent/tav/extractor/AssetExtractor:released	Z
    //   29: ifne +40 -> 69
    //   32: aload_0
    //   33: getfield 170	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IExtractorDelegate;
    //   36: ifnonnull +33 -> 69
    //   39: aload_0
    //   40: getfield 148	com/tencent/tav/extractor/AssetExtractor:TAG	Ljava/lang/String;
    //   43: new 124	java/lang/StringBuilder
    //   46: dup
    //   47: ldc 232
    //   49: invokespecial 128	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   52: aload_0
    //   53: getfield 156	com/tencent/tav/extractor/AssetExtractor:sourcePath	Ljava/lang/String;
    //   56: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 237	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: aload_0
    //   66: invokespecial 239	com/tencent/tav/extractor/AssetExtractor:releaseNative	()V
    //   69: aload_0
    //   70: getfield 170	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IExtractorDelegate;
    //   73: ifnull +17 -> 90
    //   76: aload_0
    //   77: getfield 170	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IExtractorDelegate;
    //   80: invokeinterface 242 1 0
    //   85: aload_0
    //   86: aconst_null
    //   87: putfield 170	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IExtractorDelegate;
    //   90: ldc 227
    //   92: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: goto -73 -> 22
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	AssetExtractor
    //   98	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	98	finally
    //   25	69	98	finally
    //   69	90	98	finally
    //   90	95	98	finally
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(215154);
    if (this.delegate != null)
    {
      AppMethodBeat.o(215154);
      return;
    }
    if (this.released)
    {
      AppMethodBeat.o(215154);
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
      AppMethodBeat.o(215154);
    }
  }
  
  public long getAudioDuration()
  {
    try
    {
      AppMethodBeat.i(215261);
      long l = DecoderUtils.getAudioDuration(this);
      AppMethodBeat.o(215261);
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
      AppMethodBeat.i(215255);
      if (this.duration == 0L) {
        this.duration = DecoderUtils.getDuration(this);
      }
      long l = this.duration;
      AppMethodBeat.o(215255);
      return l;
    }
    finally {}
  }
  
  public int getPreferRotation()
  {
    try
    {
      AppMethodBeat.i(215277);
      if (this.preferRotation == -1) {
        this.preferRotation = ExtractorUtils.getPreferRotation(this);
      }
      int i = this.preferRotation;
      AppMethodBeat.o(215277);
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
        AppMethodBeat.i(215229);
        if (this.delegate != null)
        {
          l = this.delegate.getSampleTime();
          AppMethodBeat.o(215229);
          return l;
        }
        if (!this.released)
        {
          l = getSampleTimeNative();
          AppMethodBeat.o(215229);
          continue;
        }
        long l = -1L;
      }
      finally {}
      AppMethodBeat.o(215229);
    }
  }
  
  public int getSampleTrackIndex()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(215222);
        if (this.delegate != null)
        {
          i = this.delegate.getSampleTrackIndex();
          AppMethodBeat.o(215222);
          return i;
        }
        if (!this.released)
        {
          i = getSampleTrackIndexNative();
          AppMethodBeat.o(215222);
          continue;
        }
        int i = -1;
      }
      finally {}
      AppMethodBeat.o(215222);
    }
  }
  
  public CGSize getSize()
  {
    try
    {
      AppMethodBeat.i(215269);
      if (this.size == null) {
        this.size = ExtractorUtils.getVideoSize(this);
      }
      CGSize localCGSize = this.size;
      AppMethodBeat.o(215269);
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
        AppMethodBeat.i(215168);
        if (this.delegate != null)
        {
          i = this.delegate.getTrackCount();
          AppMethodBeat.o(215168);
          return i;
        }
        if (!this.released)
        {
          i = getTrackCountNative();
          AppMethodBeat.o(215168);
          continue;
        }
        int i = 0;
      }
      finally {}
      AppMethodBeat.o(215168);
    }
  }
  
  public MediaFormat getTrackFormat(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(215177);
        if (this.delegate != null)
        {
          localMediaFormat = this.delegate.getTrackFormat(paramInt);
          Logger.v(this.TAG, "getTrackFormat(delegate): index = " + paramInt + ", format = " + localMediaFormat);
          AppMethodBeat.o(215177);
          return localMediaFormat;
        }
        MediaFormat localMediaFormat = new MediaFormat();
        if (this.released)
        {
          AppMethodBeat.o(215177);
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
        Logger.v(this.TAG, "getTrackFormat: index = " + paramInt + ", format = " + localObject);
        AppMethodBeat.o(215177);
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
  
  public boolean needMirror()
  {
    AppMethodBeat.i(215125);
    if (this.delegate != null)
    {
      boolean bool = this.delegate.needMirror();
      AppMethodBeat.o(215125);
      return bool;
    }
    AppMethodBeat.o(215125);
    return true;
  }
  
  public int readSampleData(ByteBuffer paramByteBuffer, int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(215214);
        if (this.delegate != null)
        {
          paramInt = this.delegate.readSampleData(paramByteBuffer, paramInt);
          Logger.v(this.TAG, "readSampleData(delegate): ret = " + paramInt + ", buf = " + paramByteBuffer);
          AppMethodBeat.o(215214);
          return paramInt;
        }
        if (!this.released)
        {
          paramInt = readSampleDataNative(paramByteBuffer, paramInt);
          Logger.v(this.TAG, "readSampleData: ret = " + paramInt + ", buf = " + paramByteBuffer);
          AppMethodBeat.o(215214);
          continue;
        }
        paramInt = -1;
      }
      finally {}
      AppMethodBeat.o(215214);
    }
  }
  
  /* Error */
  public final void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 354
    //   5: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 170	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IExtractorDelegate;
    //   12: ifnull +26 -> 38
    //   15: aload_0
    //   16: getfield 170	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IExtractorDelegate;
    //   19: invokeinterface 242 1 0
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield 170	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IExtractorDelegate;
    //   29: ldc_w 354
    //   32: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: aload_0
    //   39: getfield 150	com/tencent/tav/extractor/AssetExtractor:released	Z
    //   42: ifne +12 -> 54
    //   45: aload_0
    //   46: invokespecial 239	com/tencent/tav/extractor/AssetExtractor:releaseNative	()V
    //   49: aload_0
    //   50: iconst_1
    //   51: putfield 150	com/tencent/tav/extractor/AssetExtractor:released	Z
    //   54: ldc_w 354
    //   57: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2: ldc_w 356
    //   5: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 148	com/tencent/tav/extractor/AssetExtractor:TAG	Ljava/lang/String;
    //   12: new 124	java/lang/StringBuilder
    //   15: dup
    //   16: ldc_w 358
    //   19: invokespecial 128	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: lload_1
    //   23: invokevirtual 361	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   26: ldc_w 363
    //   29: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: iload_3
    //   33: invokevirtual 301	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: ldc_w 365
    //   39: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 309	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: aload_0
    //   49: getfield 170	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IExtractorDelegate;
    //   52: ifnull +23 -> 75
    //   55: aload_0
    //   56: getfield 170	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IExtractorDelegate;
    //   59: lload_1
    //   60: iload_3
    //   61: invokeinterface 367 4 0
    //   66: ldc_w 356
    //   69: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aload_0
    //   73: monitorexit
    //   74: return
    //   75: aload_0
    //   76: getfield 150	com/tencent/tav/extractor/AssetExtractor:released	Z
    //   79: ifne +9 -> 88
    //   82: aload_0
    //   83: lload_1
    //   84: iload_3
    //   85: invokespecial 369	com/tencent/tav/extractor/AssetExtractor:seekToNative	(JI)V
    //   88: ldc_w 356
    //   91: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: goto -22 -> 72
    //   97: astore 4
    //   99: aload_0
    //   100: monitorexit
    //   101: aload 4
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	AssetExtractor
    //   0	104	1	paramLong	long
    //   0	104	3	paramInt	int
    //   97	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	72	97	finally
    //   75	88	97	finally
    //   88	94	97	finally
  }
  
  /* Error */
  public void selectTrack(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 371
    //   5: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 170	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IExtractorDelegate;
    //   12: ifnull +22 -> 34
    //   15: aload_0
    //   16: getfield 170	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IExtractorDelegate;
    //   19: iload_1
    //   20: invokeinterface 373 2 0
    //   25: ldc_w 371
    //   28: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: getfield 150	com/tencent/tav/extractor/AssetExtractor:released	Z
    //   38: ifne +8 -> 46
    //   41: aload_0
    //   42: iload_1
    //   43: invokespecial 375	com/tencent/tav/extractor/AssetExtractor:selectTrackNative	(I)V
    //   46: ldc_w 371
    //   49: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final native void setDataSource(FileDescriptor paramFileDescriptor, long paramLong1, long paramLong2);
  
  /* Error */
  public final void setDataSource(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 377
    //   5: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 170	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IExtractorDelegate;
    //   12: ifnull +13 -> 25
    //   15: aload_0
    //   16: getfield 170	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IExtractorDelegate;
    //   19: aload_1
    //   20: invokeinterface 378 2 0
    //   25: aload_0
    //   26: aload_1
    //   27: putfield 156	com/tencent/tav/extractor/AssetExtractor:sourcePath	Ljava/lang/String;
    //   30: aload_1
    //   31: invokestatic 384	com/tencent/tav/extractor/wrapper/ExtractorWrapperPool:contains	(Ljava/lang/String;)Z
    //   34: ifeq +20 -> 54
    //   37: aload_0
    //   38: getfield 156	com/tencent/tav/extractor/AssetExtractor:sourcePath	Ljava/lang/String;
    //   41: aload_0
    //   42: invokestatic 388	com/tencent/tav/extractor/wrapper/ExtractorWrapperPool:fillIn	(Ljava/lang/String;Lcom/tencent/tav/extractor/AssetExtractor;)V
    //   45: ldc_w 377
    //   48: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: aload_1
    //   55: invokestatic 393	com/tencent/tav/extractor/wrapper/ExtractorLoader:cacheExtractor	(Ljava/lang/String;)V
    //   58: ldc_w 377
    //   61: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2: ldc_w 395
    //   5: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 170	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IExtractorDelegate;
    //   12: ifnull +22 -> 34
    //   15: aload_0
    //   16: getfield 170	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IExtractorDelegate;
    //   19: iload_1
    //   20: invokeinterface 397 2 0
    //   25: ldc_w 395
    //   28: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: getfield 150	com/tencent/tav/extractor/AssetExtractor:released	Z
    //   38: ifne +8 -> 46
    //   41: aload_0
    //   42: iload_1
    //   43: invokespecial 399	com/tencent/tav/extractor/AssetExtractor:unselectTrackNative	(I)V
    //   46: ldc_w 395
    //   49: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.extractor.AssetExtractor
 * JD-Core Version:    0.7.0.1
 */