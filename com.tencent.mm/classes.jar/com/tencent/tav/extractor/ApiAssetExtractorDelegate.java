package com.tencent.tav.extractor;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.decoder.logger.Logger;
import java.io.FileDescriptor;
import java.io.IOException;

public class ApiAssetExtractorDelegate
  implements IAssetExtractorDelegate
{
  private static final String TAG = "ApiAssetExtractorDelegate";
  private MediaExtractor mediaExtractor;
  private boolean released;
  
  public ApiAssetExtractorDelegate()
  {
    AppMethodBeat.i(218477);
    this.released = false;
    this.mediaExtractor = new MediaExtractor();
    AppMethodBeat.o(218477);
  }
  
  public boolean advance()
  {
    try
    {
      AppMethodBeat.i(218487);
      if (!this.released) {
        this.mediaExtractor.advance();
      }
      AppMethodBeat.o(218487);
      return false;
    }
    finally {}
  }
  
  /* Error */
  public long getSampleTime()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 44
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 27	com/tencent/tav/extractor/ApiAssetExtractorDelegate:released	Z
    //   11: ifne +20 -> 31
    //   14: aload_0
    //   15: getfield 32	com/tencent/tav/extractor/ApiAssetExtractorDelegate:mediaExtractor	Landroid/media/MediaExtractor;
    //   18: invokevirtual 46	android/media/MediaExtractor:getSampleTime	()J
    //   21: lstore_1
    //   22: ldc 44
    //   24: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_0
    //   28: monitorexit
    //   29: lload_1
    //   30: lreturn
    //   31: ldc2_w 47
    //   34: lstore_1
    //   35: ldc 44
    //   37: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: goto -13 -> 27
    //   43: astore_3
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_3
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	ApiAssetExtractorDelegate
    //   21	14	1	l	long
    //   43	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	27	43	finally
    //   35	40	43	finally
  }
  
  /* Error */
  public int getSampleTrackIndex()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 51
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 27	com/tencent/tav/extractor/ApiAssetExtractorDelegate:released	Z
    //   11: ifne +20 -> 31
    //   14: aload_0
    //   15: getfield 32	com/tencent/tav/extractor/ApiAssetExtractorDelegate:mediaExtractor	Landroid/media/MediaExtractor;
    //   18: invokevirtual 53	android/media/MediaExtractor:getSampleTrackIndex	()I
    //   21: istore_1
    //   22: ldc 51
    //   24: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_0
    //   28: monitorexit
    //   29: iload_1
    //   30: ireturn
    //   31: iconst_m1
    //   32: istore_1
    //   33: ldc 51
    //   35: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: goto -11 -> 27
    //   41: astore_2
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_2
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	ApiAssetExtractorDelegate
    //   21	12	1	i	int
    //   41	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	27	41	finally
    //   33	38	41	finally
  }
  
  /* Error */
  public final int getTrackCount()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 55
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 27	com/tencent/tav/extractor/ApiAssetExtractorDelegate:released	Z
    //   11: ifne +20 -> 31
    //   14: aload_0
    //   15: getfield 32	com/tencent/tav/extractor/ApiAssetExtractorDelegate:mediaExtractor	Landroid/media/MediaExtractor;
    //   18: invokevirtual 57	android/media/MediaExtractor:getTrackCount	()I
    //   21: istore_1
    //   22: ldc 55
    //   24: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_0
    //   28: monitorexit
    //   29: iload_1
    //   30: ireturn
    //   31: iconst_0
    //   32: istore_1
    //   33: ldc 55
    //   35: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: goto -11 -> 27
    //   41: astore_2
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_2
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	ApiAssetExtractorDelegate
    //   21	12	1	i	int
    //   41	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	27	41	finally
    //   33	38	41	finally
  }
  
  public MediaFormat getTrackFormat(int paramInt)
  {
    try
    {
      AppMethodBeat.i(218483);
      MediaFormat localMediaFormat = this.mediaExtractor.getTrackFormat(paramInt);
      AppMethodBeat.o(218483);
      return localMediaFormat;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public int readSampleData(java.nio.ByteBuffer paramByteBuffer, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 65
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 27	com/tencent/tav/extractor/ApiAssetExtractorDelegate:released	Z
    //   11: ifne +22 -> 33
    //   14: aload_0
    //   15: getfield 32	com/tencent/tav/extractor/ApiAssetExtractorDelegate:mediaExtractor	Landroid/media/MediaExtractor;
    //   18: aload_1
    //   19: iload_2
    //   20: invokevirtual 67	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   23: istore_2
    //   24: ldc 65
    //   26: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_2
    //   32: ireturn
    //   33: iconst_m1
    //   34: istore_2
    //   35: ldc 65
    //   37: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: goto -11 -> 29
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	ApiAssetExtractorDelegate
    //   0	48	1	paramByteBuffer	java.nio.ByteBuffer
    //   0	48	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   2	29	43	finally
    //   35	40	43	finally
  }
  
  public final void release()
  {
    try
    {
      AppMethodBeat.i(218481);
      this.mediaExtractor.release();
      AppMethodBeat.o(218481);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void seekTo(long paramLong, int paramInt)
  {
    try
    {
      AppMethodBeat.i(218486);
      if (!this.released) {
        this.mediaExtractor.seekTo(paramLong, paramInt);
      }
      AppMethodBeat.o(218486);
      return;
    }
    finally {}
  }
  
  public void selectTrack(int paramInt)
  {
    try
    {
      AppMethodBeat.i(218484);
      if (!this.released) {
        this.mediaExtractor.selectTrack(paramInt);
      }
      AppMethodBeat.o(218484);
      return;
    }
    finally {}
  }
  
  @TargetApi(24)
  public final void setDataSource(AssetFileDescriptor paramAssetFileDescriptor)
  {
    try
    {
      AppMethodBeat.i(218479);
      try
      {
        this.mediaExtractor.setDataSource(paramAssetFileDescriptor);
        AppMethodBeat.o(218479);
      }
      catch (IOException paramAssetFileDescriptor)
      {
        for (;;)
        {
          Logger.e("ApiAssetExtractorDelegate", "setDataSource", paramAssetFileDescriptor);
          AppMethodBeat.o(218479);
        }
      }
      return;
    }
    finally {}
  }
  
  public final void setDataSource(FileDescriptor paramFileDescriptor)
  {
    try
    {
      AppMethodBeat.i(218480);
      try
      {
        this.mediaExtractor.setDataSource(paramFileDescriptor, 0L, 576460752303423487L);
        AppMethodBeat.o(218480);
      }
      catch (IOException paramFileDescriptor)
      {
        for (;;)
        {
          Logger.e("ApiAssetExtractorDelegate", "setDataSource", paramFileDescriptor);
          AppMethodBeat.o(218480);
        }
      }
      return;
    }
    finally {}
  }
  
  public final void setDataSource(String paramString)
  {
    try
    {
      AppMethodBeat.i(218478);
      try
      {
        this.mediaExtractor.setDataSource(paramString);
        AppMethodBeat.o(218478);
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          Logger.e("ApiAssetExtractorDelegate", "setDataSource", paramString);
          AppMethodBeat.o(218478);
        }
      }
      return;
    }
    finally {}
  }
  
  public void unselectTrack(int paramInt)
  {
    try
    {
      AppMethodBeat.i(218485);
      if (!this.released) {
        this.mediaExtractor.unselectTrack(paramInt);
      }
      AppMethodBeat.o(218485);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.extractor.ApiAssetExtractorDelegate
 * JD-Core Version:    0.7.0.1
 */