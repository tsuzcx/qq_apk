import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import android.view.Surface;
import com.tencent.av.mediacodec.AndroidCodec.BufferData;
import com.tencent.mobileqq.shortvideo.mediacodec.ShortVideoCodec;
import com.tencent.mobileqq.shortvideo.util.videoconverter.InputSurface;
import com.tencent.mobileqq.shortvideo.util.videoconverter.OutputSurface;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.Processor;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.VideoConvertConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

class ahqb
  implements Runnable
{
  long jdField_a_of_type_Long = -1L;
  MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor = null;
  MediaMuxer jdField_a_of_type_AndroidMediaMediaMuxer = null;
  ShortVideoCodec jdField_a_of_type_ComTencentMobileqqShortvideoMediacodecShortVideoCodec = null;
  InputSurface jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterInputSurface = null;
  OutputSurface jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterOutputSurface = null;
  VideoConverter.Processor jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter$Processor = null;
  File jdField_a_of_type_JavaIoFile = null;
  boolean jdField_a_of_type_Boolean = true;
  long jdField_b_of_type_Long = -1L;
  MediaExtractor jdField_b_of_type_AndroidMediaMediaExtractor = null;
  ShortVideoCodec jdField_b_of_type_ComTencentMobileqqShortvideoMediacodecShortVideoCodec = null;
  boolean jdField_b_of_type_Boolean = true;
  long jdField_c_of_type_Long = -1L;
  boolean jdField_c_of_type_Boolean = false;
  boolean d;
  
  public ahqb(ahqa paramahqa, File paramFile, VideoConverter.Processor paramProcessor)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter$Processor = paramProcessor;
  }
  
  int a(MediaExtractor paramMediaExtractor)
  {
    int i = 0;
    try
    {
      while (i < paramMediaExtractor.getTrackCount())
      {
        if (QLog.isColorLevel()) {
          QLog.d("JBMR2VideoConverterImpl", 2, "format for track " + i + " is " + paramMediaExtractor.getTrackFormat(i).getString("mime"));
        }
        if (paramMediaExtractor.getTrackFormat(i).getString("mime").startsWith("video/"))
        {
          paramMediaExtractor.selectTrack(i);
          return i;
        }
        i += 1;
      }
      return -1;
    }
    catch (Exception paramMediaExtractor) {}
  }
  
  MediaCodecInfo a(String paramString)
  {
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    if (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (!localMediaCodecInfo.isEncoder()) {}
      for (;;)
      {
        i += 1;
        break;
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int j = 0;
        while (j < arrayOfString.length)
        {
          if (arrayOfString[j].equalsIgnoreCase(paramString)) {
            return localMediaCodecInfo;
          }
          j += 1;
        }
      }
    }
    return null;
  }
  
  ShortVideoCodec a(MediaFormat paramMediaFormat, Surface paramSurface)
  {
    Object localObject = ShortVideoCodec.a(paramMediaFormat.getString("mime"), false);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = (MediaCodecInfo)((List)localObject).get(0);
      ShortVideoCodec localShortVideoCodec = new ShortVideoCodec();
      localShortVideoCodec.a(paramMediaFormat, ((MediaCodecInfo)localObject).getName(), paramSurface, null);
      localShortVideoCodec.a();
      return localShortVideoCodec;
    }
    return null;
  }
  
  ShortVideoCodec a(MediaFormat paramMediaFormat, AtomicReference paramAtomicReference)
  {
    ShortVideoCodec localShortVideoCodec = new ShortVideoCodec();
    localShortVideoCodec.a(paramMediaFormat, ShortVideoCodec.jdField_a_of_type_Int, null);
    paramAtomicReference.set(localShortVideoCodec.a().createInputSurface());
    localShortVideoCodec.a();
    return localShortVideoCodec;
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JBMR2VideoConverterImpl", 2, "shutting down encoder, decoder");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterOutputSurface != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterOutputSurface.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterInputSurface != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterInputSurface.b();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqShortvideoMediacodecShortVideoCodec != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqShortvideoMediacodecShortVideoCodec.c();
      this.jdField_b_of_type_ComTencentMobileqqShortvideoMediacodecShortVideoCodec.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediacodecShortVideoCodec != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediacodecShortVideoCodec.c();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediacodecShortVideoCodec.d();
    }
    if (this.jdField_a_of_type_AndroidMediaMediaMuxer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaMuxer.release();
      this.jdField_a_of_type_AndroidMediaMediaMuxer = null;
    }
    if (this.jdField_a_of_type_AndroidMediaMediaExtractor != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaExtractor.release();
      this.jdField_a_of_type_AndroidMediaMediaExtractor = null;
    }
    if (this.jdField_b_of_type_AndroidMediaMediaExtractor != null)
    {
      this.jdField_b_of_type_AndroidMediaMediaExtractor.release();
      this.jdField_b_of_type_AndroidMediaMediaExtractor = null;
    }
  }
  
  void a(MediaExtractor paramMediaExtractor1, MediaExtractor paramMediaExtractor2, ShortVideoCodec paramShortVideoCodec1, ShortVideoCodec paramShortVideoCodec2, MediaMuxer paramMediaMuxer, InputSurface paramInputSurface, OutputSurface paramOutputSurface)
  {
    int i2 = 0;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(262144);
    int i = 0;
    int j = 0;
    MediaFormat localMediaFormat1 = null;
    int i1 = -1;
    int k = 0;
    int m = -1;
    long l1 = 0L;
    long l3 = 0L;
    int n = 0;
    MediaFormat localMediaFormat2 = null;
    long l2 = -1L;
    if (((this.jdField_b_of_type_Boolean) && (i == 0)) || ((this.jdField_a_of_type_Boolean) && (k == 0)))
    {
      this.jdField_d_of_type_Boolean = Thread.interrupted();
      if (!this.jdField_d_of_type_Boolean) {}
    }
    else
    {
      return;
    }
    Object localObject;
    label153:
    int i4;
    label186:
    label233:
    long l5;
    if ((this.jdField_a_of_type_Boolean) && (k == 0) && ((localMediaFormat2 == null) || (i2 != 0))) {
      if ((localMediaFormat2 != null) && (i2 != 0))
      {
        localObject = new MediaCodec.BufferInfo();
        ((MediaCodec.BufferInfo)localObject).size = paramMediaExtractor2.readSampleData(localByteBuffer, 0);
        if (((MediaCodec.BufferInfo)localObject).size < 0)
        {
          k = 1;
          if (k != 0) {}
          if ((l3 < l1) && (l1 - l3 > 0L) && (k == 0) && (this.jdField_a_of_type_Boolean)) {
            break label553;
          }
          i4 = 1;
          if ((!this.jdField_b_of_type_Boolean) || (n != 0) || ((localMediaFormat1 != null) && (i2 == 0)) || (i4 == 0)) {
            break label1154;
          }
          localObject = paramShortVideoCodec1.a();
          if (localObject == null) {
            break label1154;
          }
          if (((AndroidCodec.BufferData)localObject).jdField_a_of_type_Int != -1) {
            break label559;
          }
          l5 = l2;
          if (!this.jdField_b_of_type_Boolean) {
            break label1141;
          }
          l5 = l2;
          if (j != 0) {
            break label1141;
          }
          if (localMediaFormat1 != null)
          {
            l5 = l2;
            if (i2 == 0) {
              break label1141;
            }
          }
          l5 = l2;
          if (i4 == 0) {
            break label1141;
          }
          localObject = paramShortVideoCodec1.b();
          if (localObject != null) {
            break label698;
          }
          label287:
          if ((!this.jdField_b_of_type_Boolean) || (i != 0) || ((localMediaFormat1 != null) && (i2 == 0)) || (i4 == 0)) {
            break label1138;
          }
          localObject = paramShortVideoCodec2.b();
          if (localObject != null) {
            break label958;
          }
          label326:
          if ((i2 != 0) || ((this.jdField_a_of_type_Boolean) && (localMediaFormat2 == null)) || ((this.jdField_b_of_type_Boolean) && (localMediaFormat1 == null))) {
            break label1163;
          }
          if (this.jdField_b_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("JBMR2VideoConverterImpl", 2, "muxer: adding video track.");
            }
            m = paramMediaMuxer.addTrack(localMediaFormat1);
          }
          if (!this.jdField_a_of_type_Boolean) {
            break label1160;
          }
          if (QLog.isColorLevel()) {
            QLog.d("JBMR2VideoConverterImpl", 2, "muxer: adding audio track.");
          }
          i1 = paramMediaMuxer.addTrack(localMediaFormat2);
          label415:
          if (QLog.isColorLevel()) {
            QLog.d("JBMR2VideoConverterImpl", 2, "muxer: starting");
          }
          paramMediaMuxer.start();
          i2 = 1;
        }
      }
    }
    label1154:
    label1160:
    label1163:
    for (;;)
    {
      break;
      ((MediaCodec.BufferInfo)localObject).presentationTimeUs = paramMediaExtractor2.getSampleTime();
      ((MediaCodec.BufferInfo)localObject).flags = paramMediaExtractor2.getSampleFlags();
      paramMediaMuxer.writeSampleData(i1, localByteBuffer, (MediaCodec.BufferInfo)localObject);
      if (!paramMediaExtractor2.advance()) {}
      for (int i3 = 1;; i3 = 0)
      {
        l4 = ((MediaCodec.BufferInfo)localObject).presentationTimeUs;
        k = i3;
        l3 = l4;
        if (this.jdField_c_of_type_Long <= 0L) {
          break;
        }
        k = i3;
        l3 = l4;
        if (((MediaCodec.BufferInfo)localObject).presentationTimeUs < this.jdField_c_of_type_Long) {
          break;
        }
        k = 1;
        l3 = l4;
        break;
      }
      localMediaFormat2 = paramMediaExtractor2.getTrackFormat(paramMediaExtractor2.getSampleTrackIndex());
      break label153;
      label553:
      i4 = 0;
      break label186;
      label559:
      int i5 = paramMediaExtractor1.readSampleData(((AndroidCodec.BufferData)localObject).jdField_a_of_type_JavaNioByteBuffer, 0);
      long l4 = paramMediaExtractor1.getSampleTime();
      if (this.jdField_c_of_type_Long > 0L) {
        if (l4 >= this.jdField_c_of_type_Long) {
          n = 1;
        }
      }
      for (;;)
      {
        label599:
        if (i5 >= 0)
        {
          int i6 = ((AndroidCodec.BufferData)localObject).jdField_a_of_type_Int;
          if (n != 0)
          {
            i3 = 4;
            label619:
            paramShortVideoCodec1.a(i6, i5, l4, i3);
          }
        }
        else
        {
          if (paramMediaExtractor1.advance()) {
            break label692;
          }
        }
        label692:
        for (i3 = 1;; i3 = 0)
        {
          if (n != 0) {
            i3 = 1;
          }
          n = i3;
          if (i3 == 0) {
            break;
          }
          paramShortVideoCodec1.a(((AndroidCodec.BufferData)localObject).jdField_a_of_type_Int, 0, 0L, 4);
          n = i3;
          break;
          n = 0;
          break label599;
          i3 = paramMediaExtractor1.getSampleFlags();
          break label619;
        }
        label698:
        MediaCodec.BufferInfo localBufferInfo = ((AndroidCodec.BufferData)localObject).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo;
        i5 = ((AndroidCodec.BufferData)localObject).jdField_a_of_type_Int;
        if ((i5 == -1) || (i5 == -3)) {
          break label287;
        }
        if (i5 == -2)
        {
          paramShortVideoCodec1.a().getOutputFormat();
          break label287;
        }
        if ((localBufferInfo.flags & 0x2) != 0)
        {
          paramShortVideoCodec1.a(((AndroidCodec.BufferData)localObject).jdField_a_of_type_Int);
          break label287;
        }
        i3 = 0;
        if (this.jdField_c_of_type_Boolean)
        {
          if (localBufferInfo.presentationTimeUs < this.jdField_b_of_type_Long) {
            i3 = 1;
          }
        }
        else {
          label797:
          if ((localBufferInfo.size == 0) || (i3 != 0)) {
            break label952;
          }
        }
        float f;
        label952:
        for (boolean bool = true;; bool = false)
        {
          paramShortVideoCodec1.a().releaseOutputBuffer(i5, bool);
          l4 = l2;
          if (bool)
          {
            paramOutputSurface.c();
            paramOutputSurface.d();
            paramInputSurface.a(localBufferInfo.presentationTimeUs * 1000L);
            paramInputSurface.a();
            l4 = l2;
            if (l2 < 0L) {
              l4 = localBufferInfo.presentationTimeUs;
            }
            f = (float)(localBufferInfo.presentationTimeUs - l4) / (float)this.jdField_a_of_type_Long;
            this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter$Processor.a((int)(f * 10000.0F));
          }
          l5 = l4;
          if ((localBufferInfo.flags & 0x4) == 0) {
            break label1141;
          }
          paramShortVideoCodec2.a().signalEndOfInputStream();
          j = 1;
          l2 = l4;
          break;
          i3 = 0;
          break label797;
        }
        label958:
        localBufferInfo = ((AndroidCodec.BufferData)localObject).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo;
        i3 = ((AndroidCodec.BufferData)localObject).jdField_a_of_type_Int;
        if ((i3 == -1) || (i3 == -3)) {
          break label326;
        }
        if (i3 == -2)
        {
          if (m >= 0) {
            throw new IOException("video encoder changed its output format again?");
          }
          localMediaFormat1 = paramShortVideoCodec2.a().getOutputFormat();
          break label326;
        }
        if ((localBufferInfo.flags & 0x2) != 0)
        {
          paramShortVideoCodec2.a(((AndroidCodec.BufferData)localObject).jdField_a_of_type_Int);
          break label326;
        }
        if (localBufferInfo.size != 0)
        {
          paramMediaMuxer.writeSampleData(m, ((AndroidCodec.BufferData)localObject).jdField_a_of_type_JavaNioByteBuffer, localBufferInfo);
          l1 = localBufferInfo.presentationTimeUs;
          f = (float)(localBufferInfo.presentationTimeUs - l2) / (float)this.jdField_a_of_type_Long;
          this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter$Processor.a((int)(f * 10000.0F));
        }
        if ((localBufferInfo.flags & 0x4) != 0) {
          i = 1;
        }
        paramShortVideoCodec2.a(((AndroidCodec.BufferData)localObject).jdField_a_of_type_Int);
        break label326;
        label1138:
        break label326;
        label1141:
        l2 = l5;
        break label287;
        n = 0;
      }
      break label233;
      break label153;
      break label415;
    }
  }
  
  protected void a(File paramFile, VideoConverter.Processor paramProcessor)
  {
    Object localObject2 = paramFile.getAbsolutePath();
    Object localObject1 = a("video/avc");
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("JBMR2VideoConverterImpl", 2, "Unable to find an appropriate codec for video/avc");
      }
      throw new IOException("Unable to find an appropriate codec for video/avc");
    }
    if (QLog.isColorLevel()) {
      QLog.d("JBMR2VideoConverterImpl", 2, "video found codec: " + ((MediaCodecInfo)localObject1).getName());
    }
    MediaExtractor localMediaExtractor1 = new MediaExtractor();
    localMediaExtractor1.setDataSource((String)localObject2);
    if (b(localMediaExtractor1) < 0) {
      this.jdField_a_of_type_Boolean = false;
    }
    MediaExtractor localMediaExtractor2 = new MediaExtractor();
    localMediaExtractor2.setDataSource((String)localObject2);
    int i = a(localMediaExtractor2);
    if (i < 0) {
      throw new IOException("No video track found in " + paramFile);
    }
    localObject1 = localMediaExtractor2.getTrackFormat(i);
    paramFile = a((MediaFormat)localObject1, (String)localObject2);
    int n = (int)paramFile[2];
    int k = (int)paramFile[0];
    i = (int)paramFile[1];
    this.jdField_a_of_type_Long = paramFile[3];
    VideoConverter.VideoConvertConfig localVideoConvertConfig = paramProcessor.a(k, i);
    if ((localVideoConvertConfig.jdField_a_of_type_Long >= 0L) && (localVideoConvertConfig.jdField_b_of_type_Long > 0L) && (localVideoConvertConfig.jdField_b_of_type_Long - localVideoConvertConfig.jdField_a_of_type_Long >= 1000L))
    {
      this.jdField_c_of_type_Long = (localVideoConvertConfig.jdField_b_of_type_Long * 1000L);
      this.jdField_b_of_type_Long = (localVideoConvertConfig.jdField_a_of_type_Long * 1000L);
      this.jdField_a_of_type_Long = (this.jdField_c_of_type_Long - this.jdField_b_of_type_Long);
      localMediaExtractor2.seekTo(this.jdField_b_of_type_Long, 2);
      localMediaExtractor1.seekTo(this.jdField_b_of_type_Long, 2);
    }
    if (localVideoConvertConfig.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = false;
    }
    if (localVideoConvertConfig.jdField_d_of_type_Boolean) {
      this.jdField_c_of_type_Boolean = true;
    }
    int j;
    int m;
    if (!localVideoConvertConfig.jdField_b_of_type_Boolean)
    {
      j = k;
      m = i;
      if (n != 90)
      {
        if (n == 270)
        {
          m = i;
          j = k;
        }
      }
      else
      {
        if (!this.jdField_b_of_type_Boolean) {
          break label709;
        }
        paramProcessor = MediaFormat.createVideoFormat("video/avc", Math.round(m * localVideoConvertConfig.jdField_a_of_type_Float / 16.0F) * 16, Math.round(j * localVideoConvertConfig.jdField_a_of_type_Float / 16.0F) * 16);
        paramProcessor.setInteger("color-format", 2130708361);
        paramProcessor.setInteger("bitrate", localVideoConvertConfig.jdField_a_of_type_Int);
        paramProcessor.setFloat("frame-rate", localVideoConvertConfig.jdField_b_of_type_Int);
        paramProcessor.setInteger("i-frame-interval", localVideoConvertConfig.jdField_c_of_type_Int);
        if (localVideoConvertConfig.jdField_a_of_type_Boolean)
        {
          paramProcessor.setInteger("profile", localVideoConvertConfig.jdField_d_of_type_Int);
          paramProcessor.setInteger("level", localVideoConvertConfig.e);
        }
        if (localVideoConvertConfig.f != -1) {
          paramProcessor.setInteger("bitrate-mode", localVideoConvertConfig.f);
        }
        if (QLog.isColorLevel()) {
          QLog.d("JBMR2VideoConverterImpl", 2, "video format: " + paramProcessor);
        }
        paramFile = new AtomicReference();
        localObject2 = a(paramProcessor, paramFile);
        paramProcessor = new InputSurface((Surface)paramFile.get());
        paramProcessor.c();
        paramFile = new OutputSurface();
        localObject1 = a((MediaFormat)localObject1, paramFile.a);
      }
    }
    for (;;)
    {
      MediaMuxer localMediaMuxer = new MediaMuxer(localVideoConvertConfig.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 0);
      if ((this.jdField_b_of_type_Boolean) && (localVideoConvertConfig.jdField_b_of_type_Boolean)) {
        localMediaMuxer.setOrientationHint(n);
      }
      this.jdField_a_of_type_AndroidMediaMediaExtractor = localMediaExtractor2;
      this.jdField_b_of_type_AndroidMediaMediaExtractor = localMediaExtractor1;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediacodecShortVideoCodec = ((ShortVideoCodec)localObject1);
      this.jdField_b_of_type_ComTencentMobileqqShortvideoMediacodecShortVideoCodec = ((ShortVideoCodec)localObject2);
      this.jdField_a_of_type_AndroidMediaMediaMuxer = localMediaMuxer;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterInputSurface = paramProcessor;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterOutputSurface = paramFile;
      return;
      j = i;
      m = k;
      break;
      label709:
      paramFile = null;
      paramProcessor = null;
      localObject1 = null;
      localObject2 = null;
    }
  }
  
  long[] a(MediaFormat paramMediaFormat, String paramString)
  {
    j = paramMediaFormat.getInteger("width");
    k = paramMediaFormat.getInteger("height");
    long l = paramMediaFormat.getLong("durationUs");
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    paramMediaFormat = null;
    try
    {
      localMediaMetadataRetriever.setDataSource(paramString);
      paramString = localMediaMetadataRetriever.extractMetadata(24);
      paramMediaFormat = paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      for (;;)
      {
        int i;
        paramString.printStackTrace();
        continue;
        try
        {
          i = Integer.parseInt(paramMediaFormat);
        }
        catch (NumberFormatException paramString)
        {
          QLog.d("JBMR2VideoConverterImpl", 2, "Video size is " + j + "x" + k + ". rotation: " + paramMediaFormat, paramString);
          i = 0;
        }
      }
    }
    if (paramMediaFormat == null)
    {
      i = 0;
      localMediaMetadataRetriever.release();
      if (QLog.isColorLevel()) {
        QLog.d("JBMR2VideoConverterImpl", 2, "Video size is " + j + "x" + k + ". rotation: " + paramMediaFormat);
      }
      return new long[] { j, k, i, l };
    }
  }
  
  int b(MediaExtractor paramMediaExtractor)
  {
    int i = 0;
    try
    {
      while (i < paramMediaExtractor.getTrackCount())
      {
        if (QLog.isColorLevel()) {
          QLog.d("JBMR2VideoConverterImpl", 2, "format for track " + i + " is " + paramMediaExtractor.getTrackFormat(i).getString("mime"));
        }
        if (paramMediaExtractor.getTrackFormat(i).getString("mime").startsWith("audio/"))
        {
          paramMediaExtractor.selectTrack(i);
          return i;
        }
        i += 1;
      }
      return -1;
    }
    catch (Exception paramMediaExtractor) {}
  }
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter$Processor.a(0);
      a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter$Processor);
      a(this.jdField_a_of_type_AndroidMediaMediaExtractor, this.jdField_b_of_type_AndroidMediaMediaExtractor, this.jdField_a_of_type_ComTencentMobileqqShortvideoMediacodecShortVideoCodec, this.jdField_b_of_type_ComTencentMobileqqShortvideoMediacodecShortVideoCodec, this.jdField_a_of_type_AndroidMediaMediaMuxer, this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterInputSurface, this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterOutputSurface);
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter$Processor.b();
      }
    }
    catch (Exception localException1)
    {
      try
      {
        a();
        do
        {
          return;
          this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter$Processor.a(10000);
          this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter$Processor.a();
          break;
          localException1 = localException1;
          if (QLog.isColorLevel()) {
            QLog.e("JBMR2VideoConverterImpl", 1, localException1.getMessage(), localException1);
          }
          this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter$Processor.a(localException1);
          try
          {
            a();
            return;
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
            this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter$Processor.a(localException2);
          }
        } while (!QLog.isColorLevel());
        QLog.d("JBMR2VideoConverterImpl", 2, "release Hw Resource error...");
        QLog.d("JBMR2VideoConverterImpl", 2, localException2.getMessage(), localException2);
        return;
      }
      catch (Exception localException3)
      {
        do
        {
          localException3.printStackTrace();
          this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter$Processor.a(localException3);
        } while (!QLog.isColorLevel());
        QLog.d("JBMR2VideoConverterImpl", 2, "release Hw Resource error...");
        QLog.d("JBMR2VideoConverterImpl", 2, localException3.getMessage(), localException3);
        return;
      }
    }
    finally {}
    try
    {
      a();
      throw localObject;
    }
    catch (Exception localException4)
    {
      for (;;)
      {
        localException4.printStackTrace();
        this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter$Processor.a(localException4);
        if (QLog.isColorLevel())
        {
          QLog.d("JBMR2VideoConverterImpl", 2, "release Hw Resource error...");
          QLog.d("JBMR2VideoConverterImpl", 2, localException4.getMessage(), localException4);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahqb
 * JD-Core Version:    0.7.0.1
 */