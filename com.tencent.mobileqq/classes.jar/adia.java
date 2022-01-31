import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil.FileInfo;

public class adia
  implements Runnable
{
  public adia(UniformDownloadMgr paramUniformDownloadMgr, Bundle paramBundle, String paramString) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("_filename_from_dlg");
    long l = this.jdField_a_of_type_AndroidOsBundle.getLong("_filesize_from_dlg");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (0L == l) || (-1L == l))
    {
      localObject = UniformDownloadUtil.a(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidOsBundle.putLong("_filesize_from_dlg", ((UniformDownloadUtil.FileInfo)localObject).jdField_a_of_type_Long);
      if (TextUtils.isEmpty(((UniformDownloadUtil.FileInfo)localObject).jdField_a_of_type_JavaLangString)) {
        ((UniformDownloadUtil.FileInfo)localObject).jdField_a_of_type_JavaLangString = "nofilename.x";
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("_filename_from_dlg", ((UniformDownloadUtil.FileInfo)localObject).jdField_a_of_type_JavaLangString);
    }
    UniformDownloadMgr.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadMgr, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
    UniformDownloadMgr.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadMgr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adia
 * JD-Core Version:    0.7.0.1
 */