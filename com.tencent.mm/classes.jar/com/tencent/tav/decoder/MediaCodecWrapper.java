package com.tencent.tav.decoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.decoder.logger.Logger;

class MediaCodecWrapper
{
  private static final int MAX_RETRY_COUNT = 10;
  private static final long WAIT_TRANSIENT_MS = 20L;
  private final String TAG;
  private MediaCodec mediaCodec;
  private final VideoDecoder videoDecoder;
  
  MediaCodecWrapper(VideoDecoder paramVideoDecoder)
  {
    AppMethodBeat.i(214891);
    this.TAG = ("MediaCodecWrapper@" + Integer.toHexString(hashCode()));
    this.videoDecoder = paramVideoDecoder;
    AppMethodBeat.o(214891);
  }
  
  private boolean isLollipop()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  private void resetMediaCodec(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(214894);
    if (isLollipop())
    {
      this.mediaCodec.reset();
      AppMethodBeat.o(214894);
      return;
    }
    try
    {
      this.mediaCodec.stop();
      label32:
      this.mediaCodec.release();
      this.mediaCodec = MediaCodec.createDecoderByType(paramMediaFormat.getString("mime"));
      AppMethodBeat.o(214894);
      return;
    }
    catch (Exception localException)
    {
      break label32;
    }
  }
  
  private void tryLogMediaCodecError(MediaCodec.CodecException paramCodecException)
  {
    AppMethodBeat.i(214903);
    if (Build.VERSION.SDK_INT >= 23) {
      Logger.e(this.TAG, "CodecException - isTransient = " + paramCodecException.isTransient() + " , isRecoverable = " + paramCodecException.isRecoverable() + " , errorCode = " + paramCodecException.getErrorCode());
    }
    AppMethodBeat.o(214903);
  }
  
  boolean decoderConfigure(MediaFormat paramMediaFormat, Surface paramSurface)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(214892);
        long l = System.currentTimeMillis();
        this.mediaCodec = MediaCodec.createDecoderByType(paramMediaFormat.getString("mime"));
        boolean bool;
        if (Build.VERSION.SDK_INT < 21)
        {
          this.mediaCodec.configure(paramMediaFormat, paramSurface, null, 0);
          Logger.d(this.TAG, "decoderConfigure cost:" + (System.currentTimeMillis() - l));
          AppMethodBeat.o(214892);
          bool = true;
          return bool;
        }
        int i = 0;
        i += 1;
        try
        {
          Logger.d(this.TAG, "createdDecoder---time---".concat(String.valueOf(i)));
          if (i > 10)
          {
            AppMethodBeat.o(214892);
            bool = false;
            continue;
          }
          this.mediaCodec.configure(paramMediaFormat, paramSurface, null, 0);
          Logger.d(this.TAG, "decoderConfigure cost:" + (System.currentTimeMillis() - l));
          AppMethodBeat.o(214892);
          bool = true;
        }
        catch (Exception localException)
        {
          Logger.e(this.TAG, "decoderConfigure", localException);
          if (!(localException instanceof MediaCodec.CodecException)) {
            continue;
          }
        }
        if ((!((MediaCodec.CodecException)localException).isTransient()) && (!((MediaCodec.CodecException)localException).isRecoverable()))
        {
          this.mediaCodec.release();
          AppMethodBeat.o(214892);
          throw localException;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  int dequeueInputBuffer()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 182
    //   4: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 70	com/tencent/tav/decoder/MediaCodecWrapper:mediaCodec	Landroid/media/MediaCodec;
    //   11: ldc2_w 183
    //   14: invokevirtual 187	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   17: istore_1
    //   18: ldc 182
    //   20: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_1
    //   26: ireturn
    //   27: astore_2
    //   28: aload_0
    //   29: getfield 58	com/tencent/tav/decoder/MediaCodecWrapper:TAG	Ljava/lang/String;
    //   32: ldc 188
    //   34: aload_2
    //   35: invokestatic 178	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   38: aload_0
    //   39: invokespecial 88	com/tencent/tav/decoder/MediaCodecWrapper:isLollipop	()Z
    //   42: ifeq +53 -> 95
    //   45: aload_2
    //   46: instanceof 118
    //   49: ifeq +46 -> 95
    //   52: aload_0
    //   53: aload_2
    //   54: checkcast 118	android/media/MediaCodec$CodecException
    //   57: invokespecial 190	com/tencent/tav/decoder/MediaCodecWrapper:tryLogMediaCodecError	(Landroid/media/MediaCodec$CodecException;)V
    //   60: aload_2
    //   61: checkcast 118	android/media/MediaCodec$CodecException
    //   64: invokevirtual 121	android/media/MediaCodec$CodecException:isTransient	()Z
    //   67: ifeq +28 -> 95
    //   70: aload_0
    //   71: ldc2_w 12
    //   74: invokevirtual 194	com/tencent/tav/decoder/MediaCodecWrapper:waitTime	(J)V
    //   77: aload_0
    //   78: invokevirtual 196	com/tencent/tav/decoder/MediaCodecWrapper:dequeueInputBuffer	()I
    //   81: istore_1
    //   82: ldc 182
    //   84: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: goto -64 -> 23
    //   90: astore_2
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_2
    //   94: athrow
    //   95: ldc 182
    //   97: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_2
    //   101: athrow
    //   102: astore_2
    //   103: goto -75 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	MediaCodecWrapper
    //   17	65	1	i	int
    //   27	34	2	localException	Exception
    //   90	11	2	localObject	Object
    //   102	1	2	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   7	18	27	java/lang/Exception
    //   2	7	90	finally
    //   7	18	90	finally
    //   18	23	90	finally
    //   28	87	90	finally
    //   95	102	90	finally
    //   7	18	102	java/lang/Error
  }
  
  int dequeueOutputBuffer(MediaCodec.BufferInfo paramBufferInfo)
  {
    try
    {
      AppMethodBeat.i(214896);
      for (;;)
      {
        try
        {
          i = this.mediaCodec.dequeueOutputBuffer(paramBufferInfo, 1000L);
          AppMethodBeat.o(214896);
          return i;
        }
        catch (Exception localException)
        {
          Logger.e(this.TAG, "dequeueOutputBuffer", localException);
          if (!isLollipop()) {
            break;
          }
        }
        if (!(localException instanceof MediaCodec.CodecException)) {
          break;
        }
        tryLogMediaCodecError((MediaCodec.CodecException)localException);
        if (!((MediaCodec.CodecException)localException).isTransient()) {
          break;
        }
        waitTime(20L);
        int i = dequeueOutputBuffer(paramBufferInfo);
        AppMethodBeat.o(214896);
      }
      AppMethodBeat.o(214896);
    }
    finally {}
    throw localException;
  }
  
  void flushDecoder()
  {
    AppMethodBeat.i(214904);
    this.mediaCodec.flush();
    AppMethodBeat.o(214904);
  }
  
  /* Error */
  java.nio.ByteBuffer getInputBuffer(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 213
    //   4: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 70	com/tencent/tav/decoder/MediaCodecWrapper:mediaCodec	Landroid/media/MediaCodec;
    //   11: iload_1
    //   12: invokestatic 218	com/tencent/tav/decoder/DecoderUtils:getInputBuffer	(Landroid/media/MediaCodec;I)Ljava/nio/ByteBuffer;
    //   15: astore_2
    //   16: ldc 213
    //   18: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_2
    //   24: areturn
    //   25: astore_2
    //   26: aload_0
    //   27: getfield 58	com/tencent/tav/decoder/MediaCodecWrapper:TAG	Ljava/lang/String;
    //   30: ldc 219
    //   32: aload_2
    //   33: invokestatic 178	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   36: aload_0
    //   37: invokespecial 88	com/tencent/tav/decoder/MediaCodecWrapper:isLollipop	()Z
    //   40: ifeq +54 -> 94
    //   43: aload_2
    //   44: instanceof 118
    //   47: ifeq +47 -> 94
    //   50: aload_0
    //   51: aload_2
    //   52: checkcast 118	android/media/MediaCodec$CodecException
    //   55: invokespecial 190	com/tencent/tav/decoder/MediaCodecWrapper:tryLogMediaCodecError	(Landroid/media/MediaCodec$CodecException;)V
    //   58: aload_2
    //   59: checkcast 118	android/media/MediaCodec$CodecException
    //   62: invokevirtual 121	android/media/MediaCodec$CodecException:isTransient	()Z
    //   65: ifeq +29 -> 94
    //   68: aload_0
    //   69: ldc2_w 12
    //   72: invokevirtual 194	com/tencent/tav/decoder/MediaCodecWrapper:waitTime	(J)V
    //   75: aload_0
    //   76: iload_1
    //   77: invokevirtual 221	com/tencent/tav/decoder/MediaCodecWrapper:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   80: astore_2
    //   81: ldc 213
    //   83: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: goto -65 -> 21
    //   89: astore_2
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_2
    //   93: athrow
    //   94: ldc 213
    //   96: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_2
    //   100: athrow
    //   101: astore_2
    //   102: goto -76 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	MediaCodecWrapper
    //   0	105	1	paramInt	int
    //   15	9	2	localByteBuffer1	java.nio.ByteBuffer
    //   25	34	2	localException	Exception
    //   80	1	2	localByteBuffer2	java.nio.ByteBuffer
    //   89	11	2	localObject	Object
    //   101	1	2	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   7	16	25	java/lang/Exception
    //   2	7	89	finally
    //   7	16	89	finally
    //   16	21	89	finally
    //   26	86	89	finally
    //   94	101	89	finally
    //   7	16	101	java/lang/Error
  }
  
  /* Error */
  java.nio.ByteBuffer getOnputBuffer(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 223
    //   4: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 70	com/tencent/tav/decoder/MediaCodecWrapper:mediaCodec	Landroid/media/MediaCodec;
    //   11: iload_1
    //   12: invokestatic 226	com/tencent/tav/decoder/DecoderUtils:getOutputBuffer	(Landroid/media/MediaCodec;I)Ljava/nio/ByteBuffer;
    //   15: astore_2
    //   16: ldc 223
    //   18: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_2
    //   24: areturn
    //   25: astore_2
    //   26: aload_0
    //   27: getfield 58	com/tencent/tav/decoder/MediaCodecWrapper:TAG	Ljava/lang/String;
    //   30: ldc 227
    //   32: aload_2
    //   33: invokestatic 178	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   36: aload_0
    //   37: invokespecial 88	com/tencent/tav/decoder/MediaCodecWrapper:isLollipop	()Z
    //   40: ifeq +54 -> 94
    //   43: aload_2
    //   44: instanceof 118
    //   47: ifeq +47 -> 94
    //   50: aload_0
    //   51: aload_2
    //   52: checkcast 118	android/media/MediaCodec$CodecException
    //   55: invokespecial 190	com/tencent/tav/decoder/MediaCodecWrapper:tryLogMediaCodecError	(Landroid/media/MediaCodec$CodecException;)V
    //   58: aload_2
    //   59: checkcast 118	android/media/MediaCodec$CodecException
    //   62: invokevirtual 121	android/media/MediaCodec$CodecException:isTransient	()Z
    //   65: ifeq +29 -> 94
    //   68: aload_0
    //   69: ldc2_w 12
    //   72: invokevirtual 194	com/tencent/tav/decoder/MediaCodecWrapper:waitTime	(J)V
    //   75: aload_0
    //   76: iload_1
    //   77: invokevirtual 229	com/tencent/tav/decoder/MediaCodecWrapper:getOnputBuffer	(I)Ljava/nio/ByteBuffer;
    //   80: astore_2
    //   81: ldc 223
    //   83: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: goto -65 -> 21
    //   89: astore_2
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_2
    //   93: athrow
    //   94: ldc 223
    //   96: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_2
    //   100: athrow
    //   101: astore_2
    //   102: goto -76 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	MediaCodecWrapper
    //   0	105	1	paramInt	int
    //   15	9	2	localByteBuffer1	java.nio.ByteBuffer
    //   25	34	2	localException	Exception
    //   80	1	2	localByteBuffer2	java.nio.ByteBuffer
    //   89	11	2	localObject	Object
    //   101	1	2	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   7	16	25	java/lang/Exception
    //   2	7	89	finally
    //   7	16	89	finally
    //   16	21	89	finally
    //   26	86	89	finally
    //   94	101	89	finally
    //   7	16	101	java/lang/Error
  }
  
  /* Error */
  void queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 232
    //   4: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 70	com/tencent/tav/decoder/MediaCodecWrapper:mediaCodec	Landroid/media/MediaCodec;
    //   11: iload_1
    //   12: iload_2
    //   13: iload_3
    //   14: lload 4
    //   16: iload 6
    //   18: invokevirtual 234	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   21: ldc 232
    //   23: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: astore 7
    //   31: aload_0
    //   32: getfield 58	com/tencent/tav/decoder/MediaCodecWrapper:TAG	Ljava/lang/String;
    //   35: ldc 235
    //   37: aload 7
    //   39: invokestatic 178	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   42: aload_0
    //   43: invokespecial 88	com/tencent/tav/decoder/MediaCodecWrapper:isLollipop	()Z
    //   46: ifeq +49 -> 95
    //   49: aload 7
    //   51: instanceof 118
    //   54: ifeq +41 -> 95
    //   57: aload_0
    //   58: aload 7
    //   60: checkcast 118	android/media/MediaCodec$CodecException
    //   63: invokespecial 190	com/tencent/tav/decoder/MediaCodecWrapper:tryLogMediaCodecError	(Landroid/media/MediaCodec$CodecException;)V
    //   66: aload 7
    //   68: checkcast 118	android/media/MediaCodec$CodecException
    //   71: invokevirtual 121	android/media/MediaCodec$CodecException:isTransient	()Z
    //   74: ifeq +21 -> 95
    //   77: aload_0
    //   78: ldc2_w 12
    //   81: invokevirtual 194	com/tencent/tav/decoder/MediaCodecWrapper:waitTime	(J)V
    //   84: aload_0
    //   85: iload_1
    //   86: iload_2
    //   87: iload_3
    //   88: lload 4
    //   90: iload 6
    //   92: invokevirtual 236	com/tencent/tav/decoder/MediaCodecWrapper:queueInputBuffer	(IIIJI)V
    //   95: ldc 232
    //   97: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload 7
    //   102: athrow
    //   103: astore 7
    //   105: aload_0
    //   106: monitorexit
    //   107: aload 7
    //   109: athrow
    //   110: astore 7
    //   112: goto -81 -> 31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	MediaCodecWrapper
    //   0	115	1	paramInt1	int
    //   0	115	2	paramInt2	int
    //   0	115	3	paramInt3	int
    //   0	115	4	paramLong	long
    //   0	115	6	paramInt4	int
    //   29	72	7	localException	Exception
    //   103	5	7	localObject	Object
    //   110	1	7	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   7	21	29	java/lang/Exception
    //   2	7	103	finally
    //   7	21	103	finally
    //   21	26	103	finally
    //   31	95	103	finally
    //   95	103	103	finally
    //   7	21	110	java/lang/Error
  }
  
  void release()
  {
    AppMethodBeat.i(214905);
    if (this.mediaCodec != null) {
      new Thread()
      {
        public void run()
        {
          AppMethodBeat.i(214890);
          try
          {
            MediaCodecWrapper.this.videoDecoder.releaseOutputBuffer();
            MediaCodecWrapper.this.mediaCodec.stop();
            try
            {
              MediaCodecWrapper.this.mediaCodec.release();
              MediaCodecWrapper.access$102(MediaCodecWrapper.this, null);
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                Logger.e(MediaCodecWrapper.this.TAG, "mediaCodec.release", localException2);
                MediaCodecWrapper.access$102(MediaCodecWrapper.this, null);
              }
            }
            finally
            {
              MediaCodecWrapper.access$102(MediaCodecWrapper.this, null);
              AppMethodBeat.o(214890);
            }
            MediaCodecWrapper.access$102(MediaCodecWrapper.this, null);
            AppMethodBeat.o(214890);
            return;
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              Logger.e(MediaCodecWrapper.this.TAG, "mediaCodec.stop", localException1);
            }
          }
        }
      }.start();
    }
    AppMethodBeat.o(214905);
  }
  
  /* Error */
  void releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 246
    //   4: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 70	com/tencent/tav/decoder/MediaCodecWrapper:mediaCodec	Landroid/media/MediaCodec;
    //   11: iload_1
    //   12: iload_2
    //   13: invokevirtual 248	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   16: iload_2
    //   17: ifeq +11 -> 28
    //   20: aload_0
    //   21: getfield 60	com/tencent/tav/decoder/MediaCodecWrapper:videoDecoder	Lcom/tencent/tav/decoder/VideoDecoder;
    //   24: iconst_1
    //   25: putfield 254	com/tencent/tav/decoder/VideoDecoder:lastFrameValid	Z
    //   28: ldc 246
    //   30: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: astore_3
    //   37: aload_0
    //   38: getfield 58	com/tencent/tav/decoder/MediaCodecWrapper:TAG	Ljava/lang/String;
    //   41: ldc 255
    //   43: aload_3
    //   44: invokestatic 178	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   47: aload_0
    //   48: invokespecial 88	com/tencent/tav/decoder/MediaCodecWrapper:isLollipop	()Z
    //   51: ifeq +41 -> 92
    //   54: aload_3
    //   55: instanceof 118
    //   58: ifeq +34 -> 92
    //   61: aload_0
    //   62: aload_3
    //   63: checkcast 118	android/media/MediaCodec$CodecException
    //   66: invokespecial 190	com/tencent/tav/decoder/MediaCodecWrapper:tryLogMediaCodecError	(Landroid/media/MediaCodec$CodecException;)V
    //   69: aload_3
    //   70: checkcast 118	android/media/MediaCodec$CodecException
    //   73: invokevirtual 121	android/media/MediaCodec$CodecException:isTransient	()Z
    //   76: ifeq +16 -> 92
    //   79: aload_0
    //   80: ldc2_w 12
    //   83: invokevirtual 194	com/tencent/tav/decoder/MediaCodecWrapper:waitTime	(J)V
    //   86: aload_0
    //   87: iload_1
    //   88: iload_2
    //   89: invokevirtual 256	com/tencent/tav/decoder/MediaCodecWrapper:releaseOutputBuffer	(IZ)V
    //   92: ldc 246
    //   94: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_3
    //   98: athrow
    //   99: astore_3
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_3
    //   103: athrow
    //   104: astore_3
    //   105: goto -68 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	MediaCodecWrapper
    //   0	108	1	paramInt	int
    //   0	108	2	paramBoolean	boolean
    //   36	62	3	localException	Exception
    //   99	4	3	localObject	Object
    //   104	1	3	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   7	16	36	java/lang/Exception
    //   20	28	36	java/lang/Exception
    //   2	7	99	finally
    //   7	16	99	finally
    //   20	28	99	finally
    //   28	33	99	finally
    //   37	92	99	finally
    //   92	99	99	finally
    //   7	16	104	java/lang/Error
    //   20	28	104	java/lang/Error
  }
  
  void reset(Surface paramSurface, MediaFormat paramMediaFormat)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(214893);
        if (this.videoDecoder.isReleased)
        {
          AppMethodBeat.o(214893);
          return;
        }
        Logger.d(this.TAG, "reset");
      }
      finally
      {
        try
        {
          resetMediaCodec(paramMediaFormat);
          decoderConfigure(paramMediaFormat, paramSurface);
          startDecoder(paramSurface, paramMediaFormat);
          AppMethodBeat.o(214893);
        }
        catch (Exception paramSurface)
        {
          Logger.e(this.TAG, "reset", paramSurface);
          AppMethodBeat.o(214893);
        }
        paramSurface = finally;
      }
    }
  }
  
  void startDecoder(Surface paramSurface, MediaFormat paramMediaFormat)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(214895);
        try
        {
          long l = System.currentTimeMillis();
          this.mediaCodec.start();
          Logger.i(this.TAG, "startDecoder cost:" + (System.currentTimeMillis() - l));
          AppMethodBeat.o(214895);
          return;
        }
        catch (Exception localException)
        {
          Logger.e(this.TAG, "startDecoder: start", localException);
          if (!isLollipop()) {
            break;
          }
        }
        if (!(localException instanceof MediaCodec.CodecException)) {
          break;
        }
        tryLogMediaCodecError((MediaCodec.CodecException)localException);
        if (((MediaCodec.CodecException)localException).isTransient())
        {
          waitTime(20L);
          startDecoder(paramSurface, paramMediaFormat);
          AppMethodBeat.o(214895);
          continue;
        }
        if (!((MediaCodec.CodecException)localException).isRecoverable()) {
          break;
        }
      }
      finally {}
      reset(paramSurface, paramMediaFormat);
      AppMethodBeat.o(214895);
    }
    this.videoDecoder.release(false);
    AppMethodBeat.o(214895);
    throw localException;
  }
  
  void waitTime(long paramLong)
  {
    try
    {
      AppMethodBeat.i(214902);
      try
      {
        this.videoDecoder.wait(paramLong);
        AppMethodBeat.o(214902);
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          AppMethodBeat.o(214902);
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.decoder.MediaCodecWrapper
 * JD-Core Version:    0.7.0.1
 */