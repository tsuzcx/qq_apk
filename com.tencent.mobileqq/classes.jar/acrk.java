import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

class acrk
  implements FMDialogUtil.FMDialogInterface
{
  acrk(acrj paramacrj) {}
  
  public void a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    localQQAppInterface.a().a(this.a.jdField_a_of_type_JavaLangString, null, localQQAppInterface.getAccount(), 0, false);
    FileManagerUtil.a(this.a.jdField_a_of_type_JavaLangString);
    FMToastUtil.d(BaseActivity.sTopActivity.getString(2131428195));
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(1);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b())
    {
      long l = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().b();
      FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), l);
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acrk
 * JD-Core Version:    0.7.0.1
 */