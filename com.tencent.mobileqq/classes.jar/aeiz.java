import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadInfo;

class aeiz
  implements Runnable
{
  aeiz(aeiy paramaeiy, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.isEmpty()))
    {
      VideoFeedsUploader.a(this.jdField_a_of_type_Aeiy.a).a = -102;
      VideoFeedsUploader.a(this.jdField_a_of_type_Aeiy.a, VideoFeedsUploader.a(this.jdField_a_of_type_Aeiy.a));
      return;
    }
    if ((VideoFeedsUploader.a(this.jdField_a_of_type_Aeiy.a).c == null) || (this.jdField_a_of_type_JavaLangString.compareTo(VideoFeedsUploader.a(this.jdField_a_of_type_Aeiy.a).c) != 0))
    {
      VideoFeedsUploader.a(this.jdField_a_of_type_Aeiy.a).a = -103;
      VideoFeedsUploader.a(this.jdField_a_of_type_Aeiy.a, VideoFeedsUploader.a(this.jdField_a_of_type_Aeiy.a));
      return;
    }
    VideoFeedsUploader.a(this.jdField_a_of_type_Aeiy.a).c = this.jdField_a_of_type_JavaLangString;
    VideoFeedsUploader.a(this.jdField_a_of_type_Aeiy.a).b = this.jdField_a_of_type_JavaLangString;
    VideoFeedsUploader.a(this.jdField_a_of_type_Aeiy.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeiz
 * JD-Core Version:    0.7.0.1
 */