import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.qphone.base.util.QLog;

public class airs
  implements Runnable
{
  public volatile boolean a;
  
  public airs(ShortVideoUploadProcessor paramShortVideoUploadProcessor) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean) {
      synchronized (this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> PreUpload timeout");
        }
        ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor, 2);
        ShortVideoUploadProcessor.c(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor, 2);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     airs
 * JD-Core Version:    0.7.0.1
 */