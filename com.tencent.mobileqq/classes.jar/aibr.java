import android.os.Handler;
import com.tencent.mobileqq.secspy.SecSpyFileManager;
import com.tencent.mobileqq.secspy.SecSpyFileManager.UploadProgressInfo;
import com.tencent.mobileqq.unifiedebug.UnifiedDebugManager;

public class aibr
  implements Runnable
{
  public aibr(SecSpyFileManager paramSecSpyFileManager, SecSpyFileManager.UploadProgressInfo paramUploadProgressInfo, long paramLong) {}
  
  public void run()
  {
    if (SecSpyFileManager.UploadProgressInfo.a(this.jdField_a_of_type_ComTencentMobileqqSecspySecSpyFileManager$UploadProgressInfo)) {
      return;
    }
    float f = SecSpyFileManager.UploadProgressInfo.a(this.jdField_a_of_type_ComTencentMobileqqSecspySecSpyFileManager$UploadProgressInfo) / SecSpyFileManager.UploadProgressInfo.b(this.jdField_a_of_type_ComTencentMobileqqSecspySecSpyFileManager$UploadProgressInfo);
    this.jdField_a_of_type_ComTencentMobileqqSecspySecSpyFileManager.a(this.jdField_a_of_type_Long, 3, new Object[] { Integer.valueOf((int)(f * 100.0F)) });
    this.jdField_a_of_type_ComTencentMobileqqSecspySecSpyFileManager.a.a().postDelayed(this, 20000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aibr
 * JD-Core Version:    0.7.0.1
 */