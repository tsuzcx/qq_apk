import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil.GetApkNameCallback;

public final class adic
  implements Runnable
{
  public adic(String paramString, UniformDownloadUtil.GetApkNameCallback paramGetApkNameCallback) {}
  
  public void run()
  {
    String str = UniformDownloadUtil.a(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloadUtil$GetApkNameCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloadUtil$GetApkNameCallback.a(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adic
 * JD-Core Version:    0.7.0.1
 */