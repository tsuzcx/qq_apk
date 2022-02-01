import android.os.Build.VERSION;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.Processor;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.VideoConvertConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aldz
  implements VideoConverter.Processor
{
  final int jdField_a_of_type_Int;
  final long jdField_a_of_type_Long;
  final String jdField_a_of_type_JavaLangString;
  public Throwable a;
  final int jdField_b_of_type_Int;
  final long jdField_b_of_type_Long;
  
  public aldz(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    if (paramInt2 > 0) {}
    for (this.jdField_b_of_type_Int = paramInt2;; this.jdField_b_of_type_Int = 30)
    {
      this.jdField_a_of_type_JavaLangThrowable = null;
      if (paramString == null) {}
      return;
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if ((Build.VERSION.SDK_INT >= 18) && (Build.VERSION.SDK_INT <= 19)) {
      bool = true;
    }
    while (Build.VERSION.SDK_INT <= 19) {
      return bool;
    }
    return false;
  }
  
  public VideoConverter.VideoConvertConfig getEncodeConfig(int paramInt1, int paramInt2)
  {
    int j = 1280;
    int i = 30;
    VideoConverter.VideoConvertConfig localVideoConvertConfig = new VideoConverter.VideoConvertConfig();
    Object localObject;
    if (paramInt1 <= paramInt2)
    {
      localObject = new File(this.jdField_a_of_type_JavaLangString);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      localVideoConvertConfig.output = ((File)localObject);
      if (paramInt2 < 1280) {
        break label278;
      }
      localObject = "720p";
      paramInt1 = j;
      label70:
      if (paramInt2 >= paramInt1) {
        break label307;
      }
    }
    label278:
    label307:
    for (localVideoConvertConfig.videoBitRate = ((int)(819200 * 1.0D / paramInt1 * paramInt2));; localVideoConvertConfig.videoBitRate = 819200)
    {
      localVideoConvertConfig.scaleRate = (paramInt1 / paramInt2);
      paramInt2 = i;
      if (this.jdField_b_of_type_Int <= 30) {
        paramInt2 = this.jdField_b_of_type_Int;
      }
      localVideoConvertConfig.videoFrameRate = paramInt2;
      localVideoConvertConfig.setRotation = a();
      localVideoConvertConfig.beginTime = this.jdField_a_of_type_Long;
      localVideoConvertConfig.endTime = this.jdField_b_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressTask", 2, "CompressTask, step: getEncodeConfig() config.setRotation = " + localVideoConvertConfig.setRotation + ", scaleRate=" + localVideoConvertConfig.scaleRate + ", videoBitRate=" + localVideoConvertConfig.videoBitRate + ", videoFrameRate=" + localVideoConvertConfig.videoFrameRate + ", beginTime=" + localVideoConvertConfig.beginTime + ", endTime=" + localVideoConvertConfig.endTime + ",quality:" + (String)localObject + ",videoLongestEdge=" + paramInt1);
      }
      return localVideoConvertConfig;
      paramInt2 = paramInt1;
      break;
      if (paramInt2 >= 960)
      {
        localObject = "540p";
        paramInt1 = 960;
        break label70;
      }
      paramInt1 = 640;
      localObject = "480p";
      break label70;
    }
  }
  
  public void onCanceled() {}
  
  public void onFailed(Throwable paramThrowable)
  {
    QLog.e("VideoCompressTask", 1, "CompressTask, step: HWCompressProcessor onFailed:" + paramThrowable.getMessage());
    this.jdField_a_of_type_JavaLangThrowable = paramThrowable;
  }
  
  public void onProgress(int paramInt) {}
  
  public void onSuccessed() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aldz
 * JD-Core Version:    0.7.0.1
 */