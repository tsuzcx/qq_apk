import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IUploadController;
import com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel;
import com.tencent.mobileqq.filemanager.recreate.FileModel;

public class acso
  implements IUploadController
{
  public acso(C2CFileModel paramC2CFileModel) {}
  
  public void a()
  {
    this.a.a(true, FileModel.a(this.a.a.a()), this.a.b(), new acsp(this));
  }
  
  public void b()
  {
    this.a.d();
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a().a(this.a.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acso
 * JD-Core Version:    0.7.0.1
 */