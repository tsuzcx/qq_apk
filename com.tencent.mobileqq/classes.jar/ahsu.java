import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.EmptyHWDecodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.HWDecodeListener;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicLong;

public class ahsu
  implements Runnable
{
  long jdField_a_of_type_Long = System.currentTimeMillis();
  MediaCodec.BufferInfo jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo;
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  private MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private final DecodeConfig jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig;
  @NonNull
  private final HWDecodeListener jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString = "HWVideoDecoder.DecodeRunnable";
  private final AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(-1L);
  boolean jdField_a_of_type_Boolean = false;
  ByteBuffer[] jdField_a_of_type_ArrayOfJavaNioByteBuffer;
  public final long b;
  private final DecodeConfig jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig;
  private final String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  ByteBuffer[] jdField_b_of_type_ArrayOfJavaNioByteBuffer;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private volatile boolean jdField_d_of_type_Boolean;
  
  public ahsu(@NonNull String paramString, Surface paramSurface, HWDecodeListener paramHWDecodeListener)
  {
    SLog.b("HWVideoDecoder.DecodeRunnable", "create DecodeRunnable filePath: %s", paramString);
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    if (paramHWDecodeListener != null) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener = paramHWDecodeListener;
      this.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_b_of_type_Long = VideoCompositeHelper.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig = new DecodeConfig(paramString, 0, true, false, 0L, this.jdField_b_of_type_Long);
      this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig = new DecodeConfig(paramString, 0, true, false, 0L, this.jdField_b_of_type_Long);
      return;
      paramHWDecodeListener = new EmptyHWDecodeListener();
    }
  }
  
  private long a(int paramInt, long paramLong1, long paramLong2)
  {
    switch (paramInt)
    {
    default: 
      return paramLong1 + paramLong2;
    case 1: 
      return paramLong2 / 2L + paramLong1;
    case 2: 
      return 2L * paramLong2 + paramLong1;
    }
    return paramLong1 - paramLong2;
  }
  
  private long a(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidMediaMediaCodec.flush();
    this.jdField_a_of_type_AndroidMediaMediaExtractor.seekTo(paramLong, 0);
    long l2 = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener.b(l2 / 1000L);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    if (l2 == -1L) {
      a();
    }
    this.jdField_c_of_type_Long = l2;
    this.jdField_d_of_type_Long = 0L;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 4, "end seekTo seekTime=" + 0 + " timecost=" + (System.currentTimeMillis() - l1) + " seekTargetTimeUs:" + paramLong + " realStartTime:" + l2);
    }
    return l2;
  }
  
  private void a()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_a_of_type_Int == 3)
    {
      this.jdField_c_of_type_Long = (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_b_of_type_Long * 1000L);
      return;
    }
    this.jdField_c_of_type_Long = 0L;
  }
  
  private boolean a()
  {
    this.jdField_a_of_type_AndroidMediaMediaExtractor = new MediaExtractor();
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaExtractor.setDataSource(this.jdField_b_of_type_JavaLangString);
        i = 0;
        if (i >= this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackCount()) {
          break label167;
        }
        MediaFormat localMediaFormat = this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackFormat(i);
        localObject = localMediaFormat.getString("mime");
        if (!((String)localObject).startsWith("video/")) {
          break label210;
        }
        this.jdField_a_of_type_AndroidMediaMediaExtractor.selectTrack(i);
        if (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_c_of_type_Boolean)
        {
          i = this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_b_of_type_Int;
          localMediaFormat.setInteger("rotation-degrees", i);
          try
          {
            this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createDecoderByType((String)localObject);
            if (this.jdField_a_of_type_AndroidViewSurface.isValid()) {
              break label153;
            }
            throw new RuntimeException("surface is not valid.");
          }
          catch (Throwable localThrowable)
          {
            if (!Thread.interrupted()) {
              break label169;
            }
          }
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, "Thread is interrupted.", localThrowable);
          return false;
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return false;
      }
      int i = 0;
      continue;
      label153:
      this.jdField_a_of_type_AndroidMediaMediaCodec.configure(localIOException, this.jdField_a_of_type_AndroidViewSurface, null, 0);
      label167:
      return true;
      label169:
      Object localObject = new RuntimeException(localIOException);
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener.a(1, (Throwable)localObject);
      }
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "decode configure error", localIOException);
      return false;
      label210:
      i += 1;
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
    switch (i)
    {
    default: 
      if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x4) != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "output EOS");
        }
        this.jdField_c_of_type_Boolean = true;
      }
      if ((this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_a_of_type_Boolean) || (!paramBoolean)) {
        break;
      }
    case -3: 
    case -2: 
    case -1: 
      while (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs / 1000L > System.currentTimeMillis() - this.jdField_a_of_type_Long)
      {
        try
        {
          Thread.sleep(10L);
        }
        catch (InterruptedException localInterruptedException1)
        {
          localInterruptedException1.printStackTrace();
          this.jdField_a_of_type_Boolean = true;
        }
        continue;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "INFO_OUTPUT_BUFFERS_CHANGED");
        }
        this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
        do
        {
          do
          {
            return true;
          } while (!QLog.isColorLevel());
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "New format " + this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat());
          return true;
        } while (!QLog.isColorLevel());
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "dequeueOutputBuffer timed out!");
        return true;
      }
    }
    if ((paramBoolean) && (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size != 0)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(i, paramBoolean);
      if (!paramBoolean) {
        break;
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener.a(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs * 1000L);
        return true;
      }
      catch (InterruptedException localInterruptedException2)
      {
        localInterruptedException2.printStackTrace();
        this.jdField_a_of_type_Boolean = true;
        return true;
      }
    }
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaCodec == null)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "Can't find video info!");
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener.e();
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.start();
      RuntimeException localRuntimeException;
      return false;
    }
    catch (Throwable localThrowable)
    {
      try
      {
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers();
        this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
        this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        if (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_a_of_type_Int == 3) {
          this.jdField_c_of_type_Long = (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_b_of_type_Long * 1000L);
        }
        return true;
      }
      catch (Exception localException)
      {
        if (this.jdField_a_of_type_Boolean) {
          break label184;
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener.a(2, localException);
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "decode start error2", localException);
      }
      localThrowable = localThrowable;
      if (Thread.interrupted())
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "Thread is interrupted.", localThrowable);
        return false;
      }
      localRuntimeException = new RuntimeException(localThrowable);
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener.a(2, localRuntimeException);
      }
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "decode start error", localThrowable);
      return false;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (!this.jdField_b_of_type_Boolean) {
      c();
    }
    if (!this.jdField_c_of_type_Boolean) {
      a(paramBoolean);
    }
  }
  
  private boolean c()
  {
    int i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(10000L);
    if (i >= 0)
    {
      ByteBuffer localByteBuffer = this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[i];
      long l1;
      MediaExtractor localMediaExtractor;
      long l2;
      int j;
      long l3;
      if (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_a_of_type_Int == 3)
      {
        l1 = this.jdField_c_of_type_Long - 1000;
        if (("xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) && ("MI 6".equalsIgnoreCase(Build.MODEL)))
        {
          localMediaExtractor = this.jdField_a_of_type_AndroidMediaMediaExtractor;
          l2 = l1;
          if (l1 < 0L) {
            l2 = 0L;
          }
          localMediaExtractor.seekTo(l2, 1);
        }
      }
      else
      {
        j = this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData(localByteBuffer, 0);
        l3 = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime();
        l2 = 1000L * this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_a_of_type_Long;
        long l4 = 1000L * this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_b_of_type_Long;
        if ((j >= 0) && ((l4 <= 0L) || (l3 <= l4)))
        {
          if (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_a_of_type_Int != 3) {
            break label310;
          }
          if (l2 <= 0L) {
            break label302;
          }
          l1 = l2;
          label180:
          if (l3 >= l1) {
            break label310;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "InputBuffer BUFFER_FLAG_END_OF_STREAM sampleTime=" + l3 + " endTime=" + l4 + " startTime=" + l2 + " sampleSize=" + j);
        }
        this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, 0, 0L, 4);
        this.jdField_b_of_type_Boolean = true;
      }
      for (;;)
      {
        return true;
        localMediaExtractor = this.jdField_a_of_type_AndroidMediaMediaExtractor;
        l2 = l1;
        if (l1 < 0L) {
          l2 = 0L;
        }
        localMediaExtractor.seekTo(l2, 0);
        break;
        label302:
        l1 = 10000;
        break label180;
        label310:
        l1 = this.jdField_c_of_type_Long;
        this.jdField_c_of_type_Long = l3;
        this.jdField_d_of_type_Long = a(this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_a_of_type_Int, this.jdField_d_of_type_Long, l3 - l1);
        this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, j, this.jdField_d_of_type_Long, 0);
        this.jdField_a_of_type_AndroidMediaMediaExtractor.advance();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 2, "queueSampleToCodec inIndex = " + i);
    }
    return false;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(1000L * paramLong);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 < 0L) || (paramLong2 < 0L)) {
      throw new IllegalArgumentException("both start time and end time should not less than 0");
    }
    if (paramLong2 < paramLong1) {
      throw new IllegalArgumentException("end time should not less than start time");
    }
    if (paramLong1 >= this.jdField_b_of_type_Long)
    {
      SLog.e("HWVideoDecoder.DecodeRunnable", "setPlayRange ignore, startTimeMs=%d, videoDuration=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(this.jdField_b_of_type_Long) });
      return;
    }
    if (paramLong2 > this.jdField_b_of_type_Long) {
      paramLong2 = this.jdField_b_of_type_Long;
    }
    for (;;)
    {
      long l = paramLong2;
      if (paramLong2 == 0L) {
        l = this.jdField_b_of_type_Long;
      }
      if ((paramLong1 == this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_a_of_type_Long) && (l == this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_b_of_type_Long))
      {
        SLog.d("HWVideoDecoder.DecodeRunnable", "segment not changed, setPlayRange ignore, startTimeMs=%d, endTimeMs=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(l) });
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_a_of_type_Long = paramLong1;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_b_of_type_Long = l;
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_a_of_type_Int == 3)
      {
        a(l);
        return;
      }
      a(paramLong1);
      return;
    }
  }
  
  public void a(@NonNull DecodeConfig paramDecodeConfig)
  {
    if (!TextUtils.equals(this.jdField_b_of_type_JavaLangString, paramDecodeConfig.jdField_a_of_type_JavaLangString)) {
      SLog.d("HWVideoDecoder.DecodeRunnable", "DecodeRunnable does not support changing the file");
    }
    a(paramDecodeConfig.jdField_a_of_type_Int);
    a(paramDecodeConfig.jdField_a_of_type_Long, paramDecodeConfig.jdField_b_of_type_Long);
    b(paramDecodeConfig.jdField_b_of_type_Boolean);
    a(paramDecodeConfig.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_b_of_type_Int = paramDecodeConfig.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_c_of_type_Boolean = paramDecodeConfig.jdField_c_of_type_Boolean;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 40	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: aload_0
    //   5: getfield 102	ahsu:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/DecodeConfig;
    //   8: aload_0
    //   9: getfield 100	ahsu:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/DecodeConfig;
    //   12: invokevirtual 440	com/tencent/mobileqq/richmedia/mediacodec/decoder/DecodeConfig:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/DecodeConfig;)Z
    //   15: pop
    //   16: aload_0
    //   17: invokespecial 442	ahsu:a	()Z
    //   20: ifne +4 -> 24
    //   23: return
    //   24: aload_0
    //   25: invokespecial 444	ahsu:b	()Z
    //   28: ifeq -5 -> 23
    //   31: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +35 -> 69
    //   37: aload_0
    //   38: getfield 32	ahsu:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   41: iconst_2
    //   42: new 55	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 446
    //   52: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokestatic 40	java/lang/System:currentTimeMillis	()J
    //   58: lload_3
    //   59: lsub
    //   60: invokevirtual 158	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   63: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: invokestatic 235	java/lang/Thread:interrupted	()Z
    //   72: ifne +415 -> 487
    //   75: aload_0
    //   76: getfield 34	ahsu:jdField_a_of_type_Boolean	Z
    //   79: ifne +408 -> 487
    //   82: aload_0
    //   83: getfield 100	ahsu:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/DecodeConfig;
    //   86: getfield 169	com/tencent/mobileqq/richmedia/mediacodec/decoder/DecodeConfig:jdField_a_of_type_Int	I
    //   89: aload_0
    //   90: getfield 102	ahsu:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/DecodeConfig;
    //   93: getfield 169	com/tencent/mobileqq/richmedia/mediacodec/decoder/DecodeConfig:jdField_a_of_type_Int	I
    //   96: if_icmpeq +29 -> 125
    //   99: aload_0
    //   100: getfield 100	ahsu:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/DecodeConfig;
    //   103: getfield 169	com/tencent/mobileqq/richmedia/mediacodec/decoder/DecodeConfig:jdField_a_of_type_Int	I
    //   106: iconst_3
    //   107: if_icmpne +18 -> 125
    //   110: aload_0
    //   111: aload_0
    //   112: getfield 102	ahsu:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/DecodeConfig;
    //   115: getfield 170	com/tencent/mobileqq/richmedia/mediacodec/decoder/DecodeConfig:jdField_b_of_type_Long	J
    //   118: ldc2_w 130
    //   121: lmul
    //   122: putfield 143	ahsu:jdField_c_of_type_Long	J
    //   125: aload_0
    //   126: getfield 102	ahsu:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/DecodeConfig;
    //   129: aload_0
    //   130: getfield 100	ahsu:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/DecodeConfig;
    //   133: invokevirtual 440	com/tencent/mobileqq/richmedia/mediacodec/decoder/DecodeConfig:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/DecodeConfig;)Z
    //   136: pop
    //   137: aload_0
    //   138: getfield 102	ahsu:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/DecodeConfig;
    //   141: getfield 365	com/tencent/mobileqq/richmedia/mediacodec/decoder/DecodeConfig:jdField_a_of_type_Long	J
    //   144: ldc2_w 130
    //   147: lmul
    //   148: lstore_3
    //   149: ldc2_w 130
    //   152: aload_0
    //   153: getfield 102	ahsu:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/DecodeConfig;
    //   156: getfield 170	com/tencent/mobileqq/richmedia/mediacodec/decoder/DecodeConfig:jdField_b_of_type_Long	J
    //   159: lmul
    //   160: lstore 5
    //   162: iconst_0
    //   163: istore_2
    //   164: aload_0
    //   165: getfield 51	ahsu:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong	Ljava/util/concurrent/atomic/AtomicLong;
    //   168: invokevirtual 449	java/util/concurrent/atomic/AtomicLong:get	()J
    //   171: lstore 7
    //   173: iload_2
    //   174: istore_1
    //   175: lload 7
    //   177: lconst_0
    //   178: lcmp
    //   179: iflt +31 -> 210
    //   182: iload_2
    //   183: istore_1
    //   184: lload 7
    //   186: lload_3
    //   187: lcmp
    //   188: iflt +22 -> 210
    //   191: iload_2
    //   192: istore_1
    //   193: lload 7
    //   195: lload 5
    //   197: lcmp
    //   198: ifgt +12 -> 210
    //   201: aload_0
    //   202: lload 7
    //   204: invokespecial 451	ahsu:a	(J)J
    //   207: pop2
    //   208: iconst_1
    //   209: istore_1
    //   210: aload_0
    //   211: getfield 51	ahsu:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong	Ljava/util/concurrent/atomic/AtomicLong;
    //   214: lload 7
    //   216: ldc2_w 45
    //   219: invokevirtual 455	java/util/concurrent/atomic/AtomicLong:compareAndSet	(JJ)Z
    //   222: pop
    //   223: invokestatic 40	java/lang/System:currentTimeMillis	()J
    //   226: lstore 7
    //   228: aload_0
    //   229: iconst_1
    //   230: invokespecial 457	ahsu:c	(Z)V
    //   233: iload_1
    //   234: ifeq +42 -> 276
    //   237: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   240: ifeq +36 -> 276
    //   243: aload_0
    //   244: getfield 32	ahsu:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   247: iconst_2
    //   248: new 55	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   255: ldc_w 446
    //   258: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokestatic 40	java/lang/System:currentTimeMillis	()J
    //   264: lload 7
    //   266: lsub
    //   267: invokevirtual 158	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   270: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   276: aload_0
    //   277: getfield 139	ahsu:jdField_c_of_type_Boolean	Z
    //   280: ifeq +59 -> 339
    //   283: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   286: ifeq +14 -> 300
    //   289: aload_0
    //   290: getfield 32	ahsu:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   293: iconst_2
    //   294: ldc_w 459
    //   297: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: aload_0
    //   301: getfield 102	ahsu:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/DecodeConfig;
    //   304: getfield 432	com/tencent/mobileqq/richmedia/mediacodec/decoder/DecodeConfig:jdField_b_of_type_Boolean	Z
    //   307: ifeq +180 -> 487
    //   310: aload_0
    //   311: getfield 102	ahsu:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/DecodeConfig;
    //   314: getfield 169	com/tencent/mobileqq/richmedia/mediacodec/decoder/DecodeConfig:jdField_a_of_type_Int	I
    //   317: iconst_3
    //   318: if_icmpne +158 -> 476
    //   321: lload 5
    //   323: lstore_3
    //   324: aload_0
    //   325: lload_3
    //   326: invokespecial 451	ahsu:a	(J)J
    //   329: pop2
    //   330: aload_0
    //   331: getfield 84	ahsu:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/HWDecodeListener;
    //   334: invokeinterface 462 1 0
    //   339: aload_0
    //   340: getfield 259	ahsu:jdField_d_of_type_Boolean	Z
    //   343: ifeq -274 -> 69
    //   346: aload_0
    //   347: getfield 53	ahsu:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   350: astore 9
    //   352: aload 9
    //   354: monitorenter
    //   355: aload_0
    //   356: getfield 34	ahsu:jdField_a_of_type_Boolean	Z
    //   359: ifne +10 -> 369
    //   362: aload_0
    //   363: getfield 53	ahsu:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   366: invokevirtual 465	java/lang/Object:wait	()V
    //   369: aload 9
    //   371: monitorexit
    //   372: aload_0
    //   373: invokestatic 40	java/lang/System:currentTimeMillis	()J
    //   376: aload_0
    //   377: getfield 264	ahsu:jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   380: getfield 281	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   383: ldc2_w 130
    //   386: ldiv
    //   387: lsub
    //   388: putfield 42	ahsu:jdField_a_of_type_Long	J
    //   391: goto -322 -> 69
    //   394: astore 9
    //   396: aload 9
    //   398: invokevirtual 287	java/lang/InterruptedException:printStackTrace	()V
    //   401: aload_0
    //   402: iconst_1
    //   403: putfield 34	ahsu:jdField_a_of_type_Boolean	Z
    //   406: goto -337 -> 69
    //   409: astore 9
    //   411: invokestatic 235	java/lang/Thread:interrupted	()Z
    //   414: ifeq +18 -> 432
    //   417: aload_0
    //   418: getfield 32	ahsu:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   421: iconst_2
    //   422: ldc 237
    //   424: aload 9
    //   426: invokestatic 241	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   429: goto -196 -> 233
    //   432: new 226	java/lang/RuntimeException
    //   435: dup
    //   436: aload 9
    //   438: invokespecial 251	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   441: astore 10
    //   443: aload_0
    //   444: getfield 34	ahsu:jdField_a_of_type_Boolean	Z
    //   447: ifne +15 -> 462
    //   450: aload_0
    //   451: getfield 84	ahsu:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/HWDecodeListener;
    //   454: iconst_3
    //   455: aload 10
    //   457: invokeinterface 254 3 0
    //   462: aload_0
    //   463: getfield 32	ahsu:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   466: iconst_2
    //   467: ldc_w 256
    //   470: aload 9
    //   472: invokestatic 241	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   475: return
    //   476: goto -152 -> 324
    //   479: astore 10
    //   481: aload 9
    //   483: monitorexit
    //   484: aload 10
    //   486: athrow
    //   487: aload_0
    //   488: getfield 113	ahsu:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   491: invokevirtual 468	android/media/MediaCodec:stop	()V
    //   494: aload_0
    //   495: getfield 113	ahsu:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   498: invokevirtual 471	android/media/MediaCodec:release	()V
    //   501: aload_0
    //   502: getfield 120	ahsu:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   505: invokevirtual 472	android/media/MediaExtractor:release	()V
    //   508: aload_0
    //   509: getfield 139	ahsu:jdField_c_of_type_Boolean	Z
    //   512: ifeq +48 -> 560
    //   515: aload_0
    //   516: getfield 84	ahsu:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/HWDecodeListener;
    //   519: invokeinterface 475 1 0
    //   524: return
    //   525: astore 9
    //   527: ldc 30
    //   529: iconst_1
    //   530: new 55	java/lang/StringBuilder
    //   533: dup
    //   534: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   537: ldc_w 477
    //   540: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: aload 9
    //   545: invokevirtual 478	java/lang/Exception:toString	()Ljava/lang/String;
    //   548: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   554: invokestatic 321	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   557: goto -49 -> 508
    //   560: aload_0
    //   561: getfield 84	ahsu:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/HWDecodeListener;
    //   564: invokeinterface 481 1 0
    //   569: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	570	0	this	ahsu
    //   174	60	1	i	int
    //   163	29	2	j	int
    //   3	323	3	l1	long
    //   160	162	5	l2	long
    //   171	94	7	l3	long
    //   394	3	9	localInterruptedException	InterruptedException
    //   409	73	9	localThrowable	Throwable
    //   525	19	9	localException	Exception
    //   441	15	10	localRuntimeException	RuntimeException
    //   479	6	10	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   346	355	394	java/lang/InterruptedException
    //   372	391	394	java/lang/InterruptedException
    //   484	487	394	java/lang/InterruptedException
    //   228	233	409	java/lang/Throwable
    //   355	369	479	finally
    //   369	372	479	finally
    //   481	484	479	finally
    //   487	508	525	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahsu
 * JD-Core Version:    0.7.0.1
 */