import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil.FileInfo;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil.GetFileInfoCallBack;

public final class adqi
  implements Runnable
{
  public adqi(String paramString, UniformDownloadUtil.GetFileInfoCallBack paramGetFileInfoCallBack) {}
  
  public void run()
  {
    UniformDownloadUtil.FileInfo localFileInfo = UniformDownloadUtil.a(this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloadUtil$GetFileInfoCallBack != null) && (localFileInfo != null)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloadUtil$GetFileInfoCallBack.a(localFileInfo.jdField_a_of_type_JavaLangString, localFileInfo.jdField_a_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adqi
 * JD-Core Version:    0.7.0.1
 */