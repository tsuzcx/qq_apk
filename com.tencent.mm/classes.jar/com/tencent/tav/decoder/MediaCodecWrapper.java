package com.tencent.tav.decoder;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.codec.MediaCodecAnalyse;
import com.tencent.tav.decoder.logger.Logger;

class MediaCodecWrapper
{
  private static final int MAX_RETRY_COUNT = 10;
  private static final String SCENE = "tav-video-decoder";
  private static final long WAIT_TRANSIENT_MS = 20L;
  private final String TAG;
  private MediaCodecAnalyse mediaCodec;
  private final VideoDecoder videoDecoder;
  
  MediaCodecWrapper(VideoDecoder paramVideoDecoder)
  {
    AppMethodBeat.i(216088);
    this.TAG = ("MediaCodecWrapper@" + Integer.toHexString(hashCode()));
    this.videoDecoder = paramVideoDecoder;
    AppMethodBeat.o(216088);
  }
  
  private boolean isLollipop()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  private void resetMediaCodec(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(216096);
    if (isLollipop())
    {
      this.mediaCodec.reset();
      AppMethodBeat.o(216096);
      return;
    }
    try
    {
      this.mediaCodec.stop();
      label32:
      this.mediaCodec.release();
      this.mediaCodec = MediaCodecAnalyse.createDecoderByType(paramMediaFormat.getString("mime"), "tav-video-decoder");
      AppMethodBeat.o(216096);
      return;
    }
    catch (Exception localException)
    {
      break label32;
    }
  }
  
  private void tryLogMediaCodecError(MediaCodec.CodecException paramCodecException)
  {
    AppMethodBeat.i(216114);
    if (Build.VERSION.SDK_INT >= 23) {
      Logger.e(this.TAG, "CodecException - isTransient = " + paramCodecException.isTransient() + " , isRecoverable = " + paramCodecException.isRecoverable() + " , errorCode = " + paramCodecException.getErrorCode());
    }
    AppMethodBeat.o(216114);
  }
  
  boolean decoderConfigure(MediaFormat paramMediaFormat, Surface paramSurface)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(216152);
        long l = System.currentTimeMillis();
        this.mediaCodec = MediaCodecAnalyse.createDecoderByType(paramMediaFormat.getString("mime"), "tav-video-decoder");
        boolean bool;
        if (Build.VERSION.SDK_INT < 21)
        {
          this.mediaCodec.configure(paramMediaFormat, paramSurface, null, 0);
          Logger.d(this.TAG, "decoderConfigure cost:" + (System.currentTimeMillis() - l));
          AppMethodBeat.o(216152);
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
            AppMethodBeat.o(216152);
            bool = false;
            continue;
          }
          this.mediaCodec.configure(paramMediaFormat, paramSurface, null, 0);
          Logger.d(this.TAG, "decoderConfigure cost:" + (System.currentTimeMillis() - l));
          AppMethodBeat.o(216152);
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
          AppMethodBeat.o(216152);
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
    //   2: ldc 185
    //   4: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 73	com/tencent/tav/decoder/MediaCodecWrapper:mediaCodec	Lcom/tencent/tav/codec/MediaCodecAnalyse;
    //   11: ldc2_w 186
    //   14: invokevirtual 190	com/tencent/tav/codec/MediaCodecAnalyse:dequeueInputBuffer	(J)I
    //   17: istore_1
    //   18: ldc 185
    //   20: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_1
    //   26: ireturn
    //   27: astore_2
    //   28: aload_0
    //   29: getfield 61	com/tencent/tav/decoder/MediaCodecWrapper:TAG	Ljava/lang/String;
    //   32: ldc 191
    //   34: aload_2
    //   35: invokestatic 181	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   38: aload_0
    //   39: invokespecial 91	com/tencent/tav/decoder/MediaCodecWrapper:isLollipop	()Z
    //   42: ifeq +53 -> 95
    //   45: aload_2
    //   46: instanceof 121
    //   49: ifeq +46 -> 95
    //   52: aload_0
    //   53: aload_2
    //   54: checkcast 121	android/media/MediaCodec$CodecException
    //   57: invokespecial 193	com/tencent/tav/decoder/MediaCodecWrapper:tryLogMediaCodecError	(Landroid/media/MediaCodec$CodecException;)V
    //   60: aload_2
    //   61: checkcast 121	android/media/MediaCodec$CodecException
    //   64: invokevirtual 124	android/media/MediaCodec$CodecException:isTransient	()Z
    //   67: ifeq +28 -> 95
    //   70: aload_0
    //   71: ldc2_w 16
    //   74: invokevirtual 197	com/tencent/tav/decoder/MediaCodecWrapper:waitTime	(J)V
    //   77: aload_0
    //   78: invokevirtual 199	com/tencent/tav/decoder/MediaCodecWrapper:dequeueInputBuffer	()I
    //   81: istore_1
    //   82: ldc 185
    //   84: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: goto -64 -> 23
    //   90: astore_2
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_2
    //   94: athrow
    //   95: ldc 185
    //   97: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      AppMethodBeat.i(216178);
      for (;;)
      {
        try
        {
          i = this.mediaCodec.dequeueOutputBuffer(paramBufferInfo, 1000L);
          AppMethodBeat.o(216178);
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
        AppMethodBeat.o(216178);
      }
      AppMethodBeat.o(216178);
    }
    finally {}
    throw localException;
  }
  
  void flushDecoder()
  {
    AppMethodBeat.i(216246);
    this.mediaCodec.flush();
    AppMethodBeat.o(216246);
  }
  
  /* Error */
  java.nio.ByteBuffer getInputBuffer(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 216
    //   4: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 73	com/tencent/tav/decoder/MediaCodecWrapper:mediaCodec	Lcom/tencent/tav/codec/MediaCodecAnalyse;
    //   11: iload_1
    //   12: invokestatic 221	com/tencent/tav/decoder/DecoderUtils:getInputBuffer	(Lcom/tencent/tav/codec/MediaCodecAnalyse;I)Ljava/nio/ByteBuffer;
    //   15: astore_2
    //   16: ldc 216
    //   18: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_2
    //   24: areturn
    //   25: astore_2
    //   26: aload_0
    //   27: getfield 61	com/tencent/tav/decoder/MediaCodecWrapper:TAG	Ljava/lang/String;
    //   30: ldc 222
    //   32: aload_2
    //   33: invokestatic 181	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   36: aload_0
    //   37: invokespecial 91	com/tencent/tav/decoder/MediaCodecWrapper:isLollipop	()Z
    //   40: ifeq +54 -> 94
    //   43: aload_2
    //   44: instanceof 121
    //   47: ifeq +47 -> 94
    //   50: aload_0
    //   51: aload_2
    //   52: checkcast 121	android/media/MediaCodec$CodecException
    //   55: invokespecial 193	com/tencent/tav/decoder/MediaCodecWrapper:tryLogMediaCodecError	(Landroid/media/MediaCodec$CodecException;)V
    //   58: aload_2
    //   59: checkcast 121	android/media/MediaCodec$CodecException
    //   62: invokevirtual 124	android/media/MediaCodec$CodecException:isTransient	()Z
    //   65: ifeq +29 -> 94
    //   68: aload_0
    //   69: ldc2_w 16
    //   72: invokevirtual 197	com/tencent/tav/decoder/MediaCodecWrapper:waitTime	(J)V
    //   75: aload_0
    //   76: iload_1
    //   77: invokevirtual 224	com/tencent/tav/decoder/MediaCodecWrapper:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   80: astore_2
    //   81: ldc 216
    //   83: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: goto -65 -> 21
    //   89: astore_2
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_2
    //   93: athrow
    //   94: ldc 216
    //   96: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2: ldc 226
    //   4: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 73	com/tencent/tav/decoder/MediaCodecWrapper:mediaCodec	Lcom/tencent/tav/codec/MediaCodecAnalyse;
    //   11: iload_1
    //   12: invokestatic 229	com/tencent/tav/decoder/DecoderUtils:getOutputBuffer	(Lcom/tencent/tav/codec/MediaCodecAnalyse;I)Ljava/nio/ByteBuffer;
    //   15: astore_2
    //   16: ldc 226
    //   18: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_2
    //   24: areturn
    //   25: astore_2
    //   26: aload_0
    //   27: getfield 61	com/tencent/tav/decoder/MediaCodecWrapper:TAG	Ljava/lang/String;
    //   30: ldc 230
    //   32: aload_2
    //   33: invokestatic 181	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   36: aload_0
    //   37: invokespecial 91	com/tencent/tav/decoder/MediaCodecWrapper:isLollipop	()Z
    //   40: ifeq +54 -> 94
    //   43: aload_2
    //   44: instanceof 121
    //   47: ifeq +47 -> 94
    //   50: aload_0
    //   51: aload_2
    //   52: checkcast 121	android/media/MediaCodec$CodecException
    //   55: invokespecial 193	com/tencent/tav/decoder/MediaCodecWrapper:tryLogMediaCodecError	(Landroid/media/MediaCodec$CodecException;)V
    //   58: aload_2
    //   59: checkcast 121	android/media/MediaCodec$CodecException
    //   62: invokevirtual 124	android/media/MediaCodec$CodecException:isTransient	()Z
    //   65: ifeq +29 -> 94
    //   68: aload_0
    //   69: ldc2_w 16
    //   72: invokevirtual 197	com/tencent/tav/decoder/MediaCodecWrapper:waitTime	(J)V
    //   75: aload_0
    //   76: iload_1
    //   77: invokevirtual 232	com/tencent/tav/decoder/MediaCodecWrapper:getOnputBuffer	(I)Ljava/nio/ByteBuffer;
    //   80: astore_2
    //   81: ldc 226
    //   83: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: goto -65 -> 21
    //   89: astore_2
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_2
    //   93: athrow
    //   94: ldc 226
    //   96: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  MediaFormat getOutputFormat()
  {
    try
    {
      AppMethodBeat.i(216228);
      try
      {
        localMediaFormat = this.mediaCodec.getOutputFormat();
        AppMethodBeat.o(216228);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          MediaFormat localMediaFormat;
          new StringBuilder("getOutputFormat error:").append(localException);
          Object localObject1 = null;
          AppMethodBeat.o(216228);
        }
      }
      return localMediaFormat;
    }
    finally {}
  }
  
  /* Error */
  void queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 245
    //   4: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 73	com/tencent/tav/decoder/MediaCodecWrapper:mediaCodec	Lcom/tencent/tav/codec/MediaCodecAnalyse;
    //   11: iload_1
    //   12: iload_2
    //   13: iload_3
    //   14: lload 4
    //   16: iload 6
    //   18: invokevirtual 247	com/tencent/tav/codec/MediaCodecAnalyse:queueInputBuffer	(IIIJI)V
    //   21: ldc 245
    //   23: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: astore 7
    //   31: aload_0
    //   32: getfield 61	com/tencent/tav/decoder/MediaCodecWrapper:TAG	Ljava/lang/String;
    //   35: ldc 248
    //   37: aload 7
    //   39: invokestatic 181	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   42: aload_0
    //   43: invokespecial 91	com/tencent/tav/decoder/MediaCodecWrapper:isLollipop	()Z
    //   46: ifeq +49 -> 95
    //   49: aload 7
    //   51: instanceof 121
    //   54: ifeq +41 -> 95
    //   57: aload_0
    //   58: aload 7
    //   60: checkcast 121	android/media/MediaCodec$CodecException
    //   63: invokespecial 193	com/tencent/tav/decoder/MediaCodecWrapper:tryLogMediaCodecError	(Landroid/media/MediaCodec$CodecException;)V
    //   66: aload 7
    //   68: checkcast 121	android/media/MediaCodec$CodecException
    //   71: invokevirtual 124	android/media/MediaCodec$CodecException:isTransient	()Z
    //   74: ifeq +21 -> 95
    //   77: aload_0
    //   78: ldc2_w 16
    //   81: invokevirtual 197	com/tencent/tav/decoder/MediaCodecWrapper:waitTime	(J)V
    //   84: aload_0
    //   85: iload_1
    //   86: iload_2
    //   87: iload_3
    //   88: lload 4
    //   90: iload 6
    //   92: invokevirtual 249	com/tencent/tav/decoder/MediaCodecWrapper:queueInputBuffer	(IIIJI)V
    //   95: ldc 245
    //   97: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(216252);
    if (this.mediaCodec != null) {
      new Thread()
      {
        public void run()
        {
          AppMethodBeat.i(216013);
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
              AppMethodBeat.o(216013);
            }
            MediaCodecWrapper.access$102(MediaCodecWrapper.this, null);
            AppMethodBeat.o(216013);
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
    AppMethodBeat.o(216252);
  }
  
  /* Error */
  void releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 259
    //   5: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 73	com/tencent/tav/decoder/MediaCodecWrapper:mediaCodec	Lcom/tencent/tav/codec/MediaCodecAnalyse;
    //   12: iload_1
    //   13: iload_2
    //   14: invokevirtual 261	com/tencent/tav/codec/MediaCodecAnalyse:releaseOutputBuffer	(IZ)V
    //   17: iload_2
    //   18: ifeq +11 -> 29
    //   21: aload_0
    //   22: getfield 63	com/tencent/tav/decoder/MediaCodecWrapper:videoDecoder	Lcom/tencent/tav/decoder/VideoDecoder;
    //   25: iconst_1
    //   26: putfield 267	com/tencent/tav/decoder/VideoDecoder:lastFrameValid	Z
    //   29: ldc_w 259
    //   32: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: astore_3
    //   39: aload_0
    //   40: getfield 61	com/tencent/tav/decoder/MediaCodecWrapper:TAG	Ljava/lang/String;
    //   43: ldc_w 268
    //   46: aload_3
    //   47: invokestatic 181	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   50: aload_0
    //   51: invokespecial 91	com/tencent/tav/decoder/MediaCodecWrapper:isLollipop	()Z
    //   54: ifeq +41 -> 95
    //   57: aload_3
    //   58: instanceof 121
    //   61: ifeq +34 -> 95
    //   64: aload_0
    //   65: aload_3
    //   66: checkcast 121	android/media/MediaCodec$CodecException
    //   69: invokespecial 193	com/tencent/tav/decoder/MediaCodecWrapper:tryLogMediaCodecError	(Landroid/media/MediaCodec$CodecException;)V
    //   72: aload_3
    //   73: checkcast 121	android/media/MediaCodec$CodecException
    //   76: invokevirtual 124	android/media/MediaCodec$CodecException:isTransient	()Z
    //   79: ifeq +16 -> 95
    //   82: aload_0
    //   83: ldc2_w 16
    //   86: invokevirtual 197	com/tencent/tav/decoder/MediaCodecWrapper:waitTime	(J)V
    //   89: aload_0
    //   90: iload_1
    //   91: iload_2
    //   92: invokevirtual 269	com/tencent/tav/decoder/MediaCodecWrapper:releaseOutputBuffer	(IZ)V
    //   95: ldc_w 259
    //   98: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: aload_3
    //   102: athrow
    //   103: astore_3
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_3
    //   107: athrow
    //   108: astore_3
    //   109: goto -70 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	MediaCodecWrapper
    //   0	112	1	paramInt	int
    //   0	112	2	paramBoolean	boolean
    //   38	64	3	localException	Exception
    //   103	4	3	localObject	Object
    //   108	1	3	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   8	17	38	java/lang/Exception
    //   21	29	38	java/lang/Exception
    //   2	8	103	finally
    //   8	17	103	finally
    //   21	29	103	finally
    //   29	35	103	finally
    //   39	95	103	finally
    //   95	103	103	finally
    //   8	17	108	java/lang/Error
    //   21	29	108	java/lang/Error
  }
  
  void reset(Surface paramSurface, MediaFormat paramMediaFormat)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(216160);
        if (this.videoDecoder.isReleased)
        {
          AppMethodBeat.o(216160);
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
          AppMethodBeat.o(216160);
        }
        catch (Exception paramSurface)
        {
          Logger.e(this.TAG, "reset", paramSurface);
          AppMethodBeat.o(216160);
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
        AppMethodBeat.i(216169);
        try
        {
          long l = System.currentTimeMillis();
          this.mediaCodec.start();
          Logger.i(this.TAG, "startDecoder cost:" + (System.currentTimeMillis() - l));
          AppMethodBeat.o(216169);
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
          AppMethodBeat.o(216169);
          continue;
        }
        if (!((MediaCodec.CodecException)localException).isRecoverable()) {
          break;
        }
      }
      finally {}
      reset(paramSurface, paramMediaFormat);
      AppMethodBeat.o(216169);
    }
    this.videoDecoder.release(false);
    AppMethodBeat.o(216169);
    throw localException;
  }
  
  void waitTime(long paramLong)
  {
    try
    {
      AppMethodBeat.i(216237);
      try
      {
        this.videoDecoder.wait(paramLong);
        AppMethodBeat.o(216237);
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          AppMethodBeat.o(216237);
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.MediaCodecWrapper
 * JD-Core Version:    0.7.0.1
 */