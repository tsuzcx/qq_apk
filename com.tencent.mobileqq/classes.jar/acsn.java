import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnTransEventListener;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;

class acsn
  implements FMDialogUtil.FMDialogInterface
{
  acsn(acsm paramacsm) {}
  
  public void a()
  {
    int i = this.a.a.i();
    int j = this.a.a.d();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (i == 6) {
      if (j == 0) {
        localQQAppInterface.a().b(this.a.a.c());
      }
    }
    for (;;)
    {
      if (this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener != null) {
        this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.d();
      }
      return;
      localQQAppInterface.a().a(this.a.a.c());
      continue;
      if (j == 0) {
        localQQAppInterface.a().a(this.a.a.c());
      } else {
        localQQAppInterface.a().b(this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acsn
 * JD-Core Version:    0.7.0.1
 */