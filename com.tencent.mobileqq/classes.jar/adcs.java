import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.ControlerCallback;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.model.DefaultFileModel;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnZipEventListener;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

public class adcs
  implements FilePreviewActivity.ControlerCallback
{
  public adcs(DefaultFileModel paramDefaultFileModel) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (!paramBoolean)
    {
      QLog.e("FileBrowserModelBase", 1, "sending cs to get preview url but failed, retCode[" + paramLong + "], retMeg[" + paramString3 + "]");
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener.a(paramLong);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.d();
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
      return;
    }
    this.a.jdField_a_of_type_JavaLangString = paramString1;
    this.a.b = paramString2;
    this.a.c = paramString4;
    this.a.d = paramString5;
    this.a.a(this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.c, FileManagerUtil.c(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()), "/", this.a.d, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a(), new adct(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adcs
 * JD-Core Version:    0.7.0.1
 */