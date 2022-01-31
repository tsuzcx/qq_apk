import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder.EmptyHWDecodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder.timeStampPair;
import com.tencent.mobileqq.shortvideo.util.VideoUtil;
import com.tencent.sveffects.Logger;
import com.tencent.sveffects.SdkContext;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class ahov
  implements Runnable
{
  public int a;
  long jdField_a_of_type_Long = System.currentTimeMillis();
  MediaCodec.BufferInfo jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo;
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  private MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private final DecodeConfig jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig;
  private final HWDecodeListener jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString = "HWVideoDecoder.DecodeRunnable";
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(-1L);
  boolean jdField_a_of_type_Boolean = false;
  ByteBuffer[] jdField_a_of_type_ArrayOfJavaNioByteBuffer;
  public final long b;
  private final DecodeConfig jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig;
  private final String jdField_b_of_type_JavaLangString;
  private final AtomicLong jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(-1L);
  private boolean jdField_b_of_type_Boolean = false;
  ByteBuffer[] jdField_b_of_type_ArrayOfJavaNioByteBuffer;
  private long jdField_c_of_type_Long = 0L;
  private boolean jdField_c_of_type_Boolean = false;
  private long jdField_d_of_type_Long = 0L;
  private volatile boolean jdField_d_of_type_Boolean = false;
  private long e = 0L;
  
  public ahov(String paramString, Surface paramSurface, HWDecodeListener paramHWDecodeListener)
  {
    this.jdField_a_of_type_Int = 0;
    SdkContext.a().a().c("HWVideoDecoder.DecodeRunnable", "create DecodeRunnable filePath: " + paramString);
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    if (paramHWDecodeListener != null) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener = paramHWDecodeListener;
      this.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_b_of_type_Long = VideoUtil.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig = new DecodeConfig(paramString, 0, true, false, 0L, this.jdField_b_of_type_Long);
      this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig = new DecodeConfig(paramString, 0, true, false, 0L, this.jdField_b_of_type_Long);
      return;
      paramHWDecodeListener = new HWVideoDecoder.EmptyHWDecodeListener();
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
    case 3: 
      return (int)((float)paramLong2 / 1.5F) + paramLong1;
    case 4: 
      return 4L * paramLong2 + paramLong1;
    }
    return paramLong1 - paramLong2;
  }
  
  private long a(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidMediaMediaCodec.flush();
    this.jdField_a_of_type_AndroidMediaMediaExtractor.seekTo(paramLong, 0);
    long l2 = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener.a(l2 / 1000L);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Long = l2;
    this.jdField_d_of_type_Long = 0L;
    if (SdkContext.a().a().a()) {
      SdkContext.a().a().d(this.jdField_a_of_type_JavaLangString, "end seekTo seekTime=" + 0 + " timecost=" + (System.currentTimeMillis() - l1) + " seekTargetTimeUs:" + paramLong + " realStartTime:" + l2);
    }
    return l2;
  }
  
  private boolean a()
  {
    this.jdField_a_of_type_AndroidMediaMediaExtractor = new MediaExtractor();
    for (;;)
    {
      int i;
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaExtractor.setDataSource(this.jdField_b_of_type_JavaLangString);
        i = 0;
        if (i >= this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackCount()) {
          break label154;
        }
        MediaFormat localMediaFormat = this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackFormat(i);
        localObject = localMediaFormat.getString("mime");
        if (!((String)localObject).startsWith("video/")) {
          break label197;
        }
        this.jdField_a_of_type_AndroidMediaMediaExtractor.selectTrack(i);
        localMediaFormat.setInteger("rotation-degrees", this.jdField_a_of_type_Int);
        try
        {
          this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createDecoderByType((String)localObject);
          if (this.jdField_a_of_type_AndroidViewSurface.isValid()) {
            break label140;
          }
          throw new RuntimeException("surface is not valid.");
        }
        catch (Throwable localThrowable)
        {
          if (!Thread.interrupted()) {
            break label156;
          }
        }
        SdkContext.a().a().a(this.jdField_a_of_type_JavaLangString, "Thread is interrupted.", localThrowable);
        return false;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return false;
      }
      label140:
      this.jdField_a_of_type_AndroidMediaMediaCodec.configure(localIOException, this.jdField_a_of_type_AndroidViewSurface, null, 0);
      label154:
      return true;
      label156:
      Object localObject = new RuntimeException(localIOException);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener.a(1, (Throwable)localObject);
      SdkContext.a().a().a(this.jdField_a_of_type_JavaLangString, "decode configure error", localIOException);
      return false;
      label197:
      i += 1;
    }
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_Int != 5) {
      if (this.jdField_c_of_type_Long < this.e) {
        break label37;
      }
    }
    label37:
    do
    {
      do
      {
        return true;
      } while (this.jdField_c_of_type_Long <= this.e);
      paramLong1 = paramLong2 - paramLong1;
    } while ((paramLong1 > -100000L) && (paramLong1 < 100000L));
    return false;
  }
  
  private boolean a(boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
    switch (i)
    {
    default: 
      if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x4) != 0)
      {
        if (SdkContext.a().a().a()) {
          SdkContext.a().a().d(this.jdField_a_of_type_JavaLangString, "output EOS");
        }
        this.jdField_c_of_type_Boolean = true;
      }
      if ((this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_Boolean) || (!paramBoolean) || (this.jdField_d_of_type_Boolean)) {
        break;
      }
    case -3: 
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
        if (SdkContext.a().a().a()) {
          SdkContext.a().a().d(this.jdField_a_of_type_JavaLangString, "INFO_OUTPUT_BUFFERS_CHANGED");
        }
        this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
      }
    }
    label361:
    do
    {
      for (;;)
      {
        return true;
        if (SdkContext.a().a().a())
        {
          SdkContext.a().a().d(this.jdField_a_of_type_JavaLangString, "New format " + this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat());
          continue;
          if (SdkContext.a().a().a()) {
            SdkContext.a().a().d(this.jdField_a_of_type_JavaLangString, "dequeueOutputBuffer timed out!");
          }
        }
      }
      if ((paramBoolean) && (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size != 0)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        if ((!this.jdField_d_of_type_Boolean) || (a(this.jdField_c_of_type_Long, this.e)) || (this.jdField_c_of_type_Boolean)) {
          break label361;
        }
        this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(i, false);
        break;
      }
      this.e = -1L;
      this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(i, paramBoolean);
    } while (!paramBoolean);
    for (;;)
    {
      try
      {
        if (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_Int == 0) {
          break label659;
        }
        if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
          break label699;
        }
        l1 = ((HWVideoDecoder.timeStampPair)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long;
        l2 = Math.abs(((HWVideoDecoder.timeStampPair)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_Long - this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs);
        i = 0;
        if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label689;
        }
        HWVideoDecoder.timeStampPair localtimeStampPair = (HWVideoDecoder.timeStampPair)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localtimeStampPair.jdField_b_of_type_Long != this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs) {
          break label620;
        }
        l2 = localtimeStampPair.jdField_a_of_type_Long;
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        if (!SdkContext.a().a().a()) {
          break label706;
        }
        SdkContext.a().a().d(this.jdField_a_of_type_JavaLangString, "size : " + this.jdField_a_of_type_JavaUtilArrayList.size() + "  remove " + l2);
      }
      catch (InterruptedException localInterruptedException2)
      {
        localInterruptedException2.printStackTrace();
        this.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener.a(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs * 1000L, 1000L * l1);
      break;
      break;
      label620:
      long l3 = Math.abs(localInterruptedException2.jdField_b_of_type_Long - this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs);
      if (l3 < l2)
      {
        l2 = localInterruptedException2.jdField_a_of_type_Long;
        l1 = l3;
        break label715;
        label659:
        l1 = this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs;
      }
      else
      {
        label689:
        label699:
        label706:
        do
        {
          l1 = l2;
          break;
          l3 = l1;
          l1 = l2;
          l2 = l3;
          break label715;
          i = 0;
          l2 = -1L;
          continue;
          l1 = -1L;
          break;
          i = 1;
        } while (i != 0);
        continue;
      }
      label715:
      i += 1;
      l3 = l2;
      long l2 = l1;
      long l1 = l3;
    }
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaCodec == null)
    {
      SdkContext.a().a().a(this.jdField_a_of_type_JavaLangString, "Can't find video info!");
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener.d();
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
        if (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_Int == 5) {
          this.jdField_c_of_type_Long = (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_b_of_type_Long * 1000L);
        }
        return true;
      }
      catch (Exception localException)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener.a(2, localException);
        SdkContext.a().a().a(this.jdField_a_of_type_JavaLangString, "decode start error2", localException);
      }
      localThrowable = localThrowable;
      if (Thread.interrupted())
      {
        SdkContext.a().a().a(this.jdField_a_of_type_JavaLangString, "Thread is interrupted.", localThrowable);
        return false;
      }
      localRuntimeException = new RuntimeException(localThrowable);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener.a(2, localRuntimeException);
      SdkContext.a().a().a(this.jdField_a_of_type_JavaLangString, "decode start error", localThrowable);
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
      Object localObject = this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[i];
      if (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_Int == 5) {
        this.jdField_a_of_type_AndroidMediaMediaExtractor.seekTo(this.jdField_c_of_type_Long - 1000L, 0);
      }
      int j = this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData((ByteBuffer)localObject, 0);
      long l3 = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime();
      long l2 = 1000L * this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_Long;
      long l4 = 1000L * this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_b_of_type_Long;
      long l1;
      if ((j >= 0) && ((l4 <= 0L) || (l3 <= l4)))
      {
        if (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_Int != 5) {
          break label251;
        }
        if (l2 > 0L)
        {
          l1 = l2;
          if (l3 >= l1) {
            break label251;
          }
        }
      }
      else
      {
        if (SdkContext.a().a().a()) {
          SdkContext.a().a().d(this.jdField_a_of_type_JavaLangString, "InputBuffer BUFFER_FLAG_END_OF_STREAM sampleTime=" + l3 + " endTime=" + l4 + " startTime=" + l2 + " sampleSize=" + j);
        }
        this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, 0, 0L, 4);
        this.jdField_b_of_type_Boolean = true;
      }
      for (;;)
      {
        return true;
        l1 = 10000L;
        break;
        label251:
        l1 = this.jdField_c_of_type_Long;
        this.jdField_c_of_type_Long = l3;
        this.jdField_d_of_type_Long = a(this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_Int, this.jdField_d_of_type_Long, l3 - l1);
        this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, j, this.jdField_d_of_type_Long, 0);
        this.jdField_a_of_type_AndroidMediaMediaExtractor.advance();
        localObject = new HWVideoDecoder.timeStampPair(this.jdField_c_of_type_Long, this.jdField_d_of_type_Long);
        if ((this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_JavaUtilArrayList != null))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
          if (SdkContext.a().a().a()) {
            SdkContext.a().a().d(this.jdField_a_of_type_JavaLangString, "size : " + this.jdField_a_of_type_JavaUtilArrayList.size() + "  add " + this.jdField_c_of_type_Long);
          }
        }
      }
    }
    if (SdkContext.a().a().a()) {
      SdkContext.a().a().b(this.jdField_a_of_type_JavaLangString, "queueSampleToCodec inIndex = " + i);
    }
    return false;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_Int = paramInt;
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
      SdkContext.a().a().a("HWVideoDecoder.DecodeRunnable", "setPlayRange ignore, startTimeMs=" + paramLong1 + ", videoDuration=" + this.jdField_b_of_type_Long);
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
      if ((paramLong1 == this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_Long) && (l == this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_b_of_type_Long))
      {
        SdkContext.a().a().b("HWVideoDecoder.DecodeRunnable", "segment not changed, setPlayRange ignore, startTimeMs=" + paramLong1 + ", endTimeMs=" + l);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_Long = paramLong1;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_b_of_type_Long = l;
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_Int == 5)
      {
        a(l);
        return;
      }
      a(paramLong1);
      return;
    }
  }
  
  public void a(DecodeConfig paramDecodeConfig)
  {
    if (!TextUtils.equals(this.jdField_b_of_type_JavaLangString, paramDecodeConfig.jdField_a_of_type_JavaLangString)) {
      SdkContext.a().a().b("HWVideoDecoder.DecodeRunnable", "DecodeRunnable does not support changing the file");
    }
    a(paramDecodeConfig.jdField_a_of_type_Int);
    a(paramDecodeConfig.jdField_a_of_type_Long, paramDecodeConfig.jdField_b_of_type_Long);
    b(paramDecodeConfig.jdField_b_of_type_Boolean);
    a(paramDecodeConfig.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Int = paramDecodeConfig.jdField_b_of_type_Int;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(long paramLong)
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong.set(1000L * paramLong);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 46	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: aload_0
    //   5: getfield 133	ahov:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   8: aload_0
    //   9: getfield 131	ahov:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   12: invokevirtual 466	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;)V
    //   15: aload_0
    //   16: invokespecial 467	ahov:a	()Z
    //   19: ifne +4 -> 23
    //   22: return
    //   23: aload_0
    //   24: invokespecial 469	ahov:b	()Z
    //   27: ifeq -5 -> 22
    //   30: invokestatic 101	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/SdkContext;
    //   33: invokevirtual 104	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/Logger;
    //   36: invokeinterface 171 1 0
    //   41: ifeq +42 -> 83
    //   44: invokestatic 101	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/SdkContext;
    //   47: invokevirtual 104	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/Logger;
    //   50: aload_0
    //   51: getfield 34	ahov:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   54: new 78	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 471
    //   64: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokestatic 46	java/lang/System:currentTimeMillis	()J
    //   70: lload_3
    //   71: lsub
    //   72: invokevirtual 178	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   75: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokeinterface 184 3 0
    //   83: invokestatic 247	java/lang/Thread:interrupted	()Z
    //   86: ifne +515 -> 601
    //   89: aload_0
    //   90: getfield 40	ahov:jdField_a_of_type_Boolean	Z
    //   93: ifne +508 -> 601
    //   96: aload_0
    //   97: getfield 131	ahov:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   100: getfield 269	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:jdField_a_of_type_Int	I
    //   103: aload_0
    //   104: getfield 133	ahov:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   107: getfield 269	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:jdField_a_of_type_Int	I
    //   110: if_icmpeq +29 -> 139
    //   113: aload_0
    //   114: getfield 131	ahov:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   117: getfield 269	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:jdField_a_of_type_Int	I
    //   120: iconst_5
    //   121: if_icmpne +18 -> 139
    //   124: aload_0
    //   125: aload_0
    //   126: getfield 133	ahov:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   129: getfield 374	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:jdField_b_of_type_Long	J
    //   132: ldc2_w 163
    //   135: lmul
    //   136: putfield 50	ahov:jdField_c_of_type_Long	J
    //   139: aload_0
    //   140: getfield 133	ahov:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   143: aload_0
    //   144: getfield 131	ahov:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   147: invokevirtual 466	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;)V
    //   150: aload_0
    //   151: getfield 133	ahov:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   154: getfield 392	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:jdField_a_of_type_Long	J
    //   157: ldc2_w 163
    //   160: lmul
    //   161: lstore_3
    //   162: ldc2_w 163
    //   165: aload_0
    //   166: getfield 133	ahov:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   169: getfield 374	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:jdField_b_of_type_Long	J
    //   172: lmul
    //   173: lstore 5
    //   175: iconst_0
    //   176: istore_2
    //   177: aload_0
    //   178: getfield 61	ahov:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong	Ljava/util/concurrent/atomic/AtomicLong;
    //   181: invokevirtual 473	java/util/concurrent/atomic/AtomicLong:get	()J
    //   184: lstore 7
    //   186: iload_2
    //   187: istore_1
    //   188: lload 7
    //   190: lconst_0
    //   191: lcmp
    //   192: iflt +37 -> 229
    //   195: iload_2
    //   196: istore_1
    //   197: lload 7
    //   199: lload_3
    //   200: lcmp
    //   201: iflt +28 -> 229
    //   204: iload_2
    //   205: istore_1
    //   206: lload 7
    //   208: lload 5
    //   210: lcmp
    //   211: ifgt +18 -> 229
    //   214: aload_0
    //   215: lload 7
    //   217: invokespecial 475	ahov:a	(J)J
    //   220: pop2
    //   221: iconst_1
    //   222: istore_1
    //   223: aload_0
    //   224: lload 7
    //   226: putfield 76	ahov:e	J
    //   229: aload_0
    //   230: getfield 61	ahov:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong	Ljava/util/concurrent/atomic/AtomicLong;
    //   233: lload 7
    //   235: ldc2_w 55
    //   238: invokevirtual 478	java/util/concurrent/atomic/AtomicLong:compareAndSet	(JJ)Z
    //   241: pop
    //   242: aload_0
    //   243: getfield 63	ahov:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong	Ljava/util/concurrent/atomic/AtomicLong;
    //   246: invokevirtual 473	java/util/concurrent/atomic/AtomicLong:get	()J
    //   249: lstore 7
    //   251: lload 7
    //   253: lconst_0
    //   254: lcmp
    //   255: iflt +22 -> 277
    //   258: aload_0
    //   259: lload 7
    //   261: putfield 76	ahov:e	J
    //   264: aload_0
    //   265: getfield 63	ahov:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong	Ljava/util/concurrent/atomic/AtomicLong;
    //   268: lload 7
    //   270: ldc2_w 55
    //   273: invokevirtual 478	java/util/concurrent/atomic/AtomicLong:compareAndSet	(JJ)Z
    //   276: pop
    //   277: invokestatic 46	java/lang/System:currentTimeMillis	()J
    //   280: lstore 7
    //   282: aload_0
    //   283: iconst_1
    //   284: invokespecial 480	ahov:c	(Z)V
    //   287: iload_1
    //   288: ifeq +57 -> 345
    //   291: invokestatic 101	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/SdkContext;
    //   294: invokevirtual 104	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/Logger;
    //   297: invokeinterface 171 1 0
    //   302: ifeq +43 -> 345
    //   305: invokestatic 101	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/SdkContext;
    //   308: invokevirtual 104	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/Logger;
    //   311: aload_0
    //   312: getfield 34	ahov:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   315: new 78	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   322: ldc_w 471
    //   325: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: invokestatic 46	java/lang/System:currentTimeMillis	()J
    //   331: lload 7
    //   333: lsub
    //   334: invokevirtual 178	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   337: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokeinterface 184 3 0
    //   345: aload_0
    //   346: getfield 38	ahov:jdField_c_of_type_Boolean	Z
    //   349: ifeq +88 -> 437
    //   352: aload_0
    //   353: getfield 68	ahov:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   356: ifnull +10 -> 366
    //   359: aload_0
    //   360: getfield 68	ahov:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   363: invokevirtual 424	java/util/ArrayList:clear	()V
    //   366: invokestatic 101	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/SdkContext;
    //   369: invokevirtual 104	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/Logger;
    //   372: invokeinterface 171 1 0
    //   377: ifeq +21 -> 398
    //   380: invokestatic 101	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/SdkContext;
    //   383: invokevirtual 104	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/Logger;
    //   386: aload_0
    //   387: getfield 34	ahov:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   390: ldc_w 482
    //   393: invokeinterface 184 3 0
    //   398: aload_0
    //   399: getfield 133	ahov:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   402: getfield 457	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:jdField_b_of_type_Boolean	Z
    //   405: ifeq +196 -> 601
    //   408: aload_0
    //   409: getfield 133	ahov:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   412: getfield 269	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:jdField_a_of_type_Int	I
    //   415: iconst_5
    //   416: if_icmpne +174 -> 590
    //   419: lload 5
    //   421: lstore_3
    //   422: aload_0
    //   423: lload_3
    //   424: invokespecial 475	ahov:a	(J)J
    //   427: pop2
    //   428: aload_0
    //   429: getfield 115	ahov:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWDecodeListener;
    //   432: invokeinterface 485 1 0
    //   437: aload_0
    //   438: getfield 72	ahov:jdField_d_of_type_Boolean	Z
    //   441: ifeq -358 -> 83
    //   444: aload_0
    //   445: getfield 76	ahov:e	J
    //   448: lconst_0
    //   449: lcmp
    //   450: ifge -367 -> 83
    //   453: aload_0
    //   454: getfield 74	ahov:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   457: astore 9
    //   459: aload 9
    //   461: monitorenter
    //   462: aload_0
    //   463: getfield 40	ahov:jdField_a_of_type_Boolean	Z
    //   466: ifne +10 -> 476
    //   469: aload_0
    //   470: getfield 74	ahov:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   473: invokevirtual 488	java/lang/Object:wait	()V
    //   476: aload 9
    //   478: monitorexit
    //   479: aload_0
    //   480: invokestatic 46	java/lang/System:currentTimeMillis	()J
    //   483: aload_0
    //   484: getfield 280	ahov:jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   487: getfield 297	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   490: ldc2_w 163
    //   493: ldiv
    //   494: lsub
    //   495: putfield 48	ahov:jdField_a_of_type_Long	J
    //   498: goto -415 -> 83
    //   501: astore 9
    //   503: aload 9
    //   505: invokevirtual 303	java/lang/InterruptedException:printStackTrace	()V
    //   508: aload_0
    //   509: iconst_1
    //   510: putfield 40	ahov:jdField_a_of_type_Boolean	Z
    //   513: goto -430 -> 83
    //   516: astore 9
    //   518: invokestatic 247	java/lang/Thread:interrupted	()Z
    //   521: ifeq +25 -> 546
    //   524: invokestatic 101	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/SdkContext;
    //   527: invokevirtual 104	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/Logger;
    //   530: aload_0
    //   531: getfield 34	ahov:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   534: ldc 249
    //   536: aload 9
    //   538: invokeinterface 252 4 0
    //   543: goto -256 -> 287
    //   546: new 238	java/lang/RuntimeException
    //   549: dup
    //   550: aload 9
    //   552: invokespecial 262	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   555: astore 10
    //   557: aload_0
    //   558: getfield 115	ahov:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWDecodeListener;
    //   561: iconst_3
    //   562: aload 10
    //   564: invokeinterface 265 3 0
    //   569: invokestatic 101	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/SdkContext;
    //   572: invokevirtual 104	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/Logger;
    //   575: aload_0
    //   576: getfield 34	ahov:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   579: ldc_w 267
    //   582: aload 9
    //   584: invokeinterface 252 4 0
    //   589: return
    //   590: goto -168 -> 422
    //   593: astore 10
    //   595: aload 9
    //   597: monitorexit
    //   598: aload 10
    //   600: athrow
    //   601: aload_0
    //   602: getfield 146	ahov:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   605: invokevirtual 491	android/media/MediaCodec:stop	()V
    //   608: aload_0
    //   609: getfield 146	ahov:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   612: invokevirtual 494	android/media/MediaCodec:release	()V
    //   615: aload_0
    //   616: getfield 153	ahov:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   619: invokevirtual 495	android/media/MediaExtractor:release	()V
    //   622: aload_0
    //   623: getfield 38	ahov:jdField_c_of_type_Boolean	Z
    //   626: ifeq +55 -> 681
    //   629: aload_0
    //   630: getfield 115	ahov:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWDecodeListener;
    //   633: invokeinterface 497 1 0
    //   638: return
    //   639: astore 9
    //   641: invokestatic 101	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/SdkContext;
    //   644: invokevirtual 104	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/Logger;
    //   647: ldc 32
    //   649: new 78	java/lang/StringBuilder
    //   652: dup
    //   653: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   656: ldc_w 499
    //   659: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: aload 9
    //   664: invokevirtual 500	java/lang/Exception:toString	()Ljava/lang/String;
    //   667: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   673: invokeinterface 362 3 0
    //   678: goto -56 -> 622
    //   681: aload_0
    //   682: getfield 115	ahov:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWDecodeListener;
    //   685: invokeinterface 503 1 0
    //   690: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	691	0	this	ahov
    //   187	101	1	i	int
    //   176	29	2	j	int
    //   3	421	3	l1	long
    //   173	247	5	l2	long
    //   184	148	7	l3	long
    //   501	3	9	localInterruptedException	InterruptedException
    //   516	80	9	localThrowable	Throwable
    //   639	24	9	localException	Exception
    //   555	8	10	localRuntimeException	RuntimeException
    //   593	6	10	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   453	462	501	java/lang/InterruptedException
    //   479	498	501	java/lang/InterruptedException
    //   598	601	501	java/lang/InterruptedException
    //   282	287	516	java/lang/Throwable
    //   462	476	593	finally
    //   476	479	593	finally
    //   595	598	593	finally
    //   601	622	639	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahov
 * JD-Core Version:    0.7.0.1
 */