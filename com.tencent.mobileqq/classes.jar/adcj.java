import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel;
import com.tencent.mobileqq.filemanager.recreate.FileModel;

public class adcj
  implements IDownloadController
{
  public adcj(C2CFileModel paramC2CFileModel) {}
  
  public void a()
  {
    this.a.a(false, FileModel.a(this.a.a.a()), this.a.b(), new adck(this));
  }
  
  public void b()
  {
    this.a.d();
    int i = this.a.d();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (i == 0)
    {
      localQQAppInterface.a().a(this.a.c());
      return;
    }
    localQQAppInterface.a().a(this.a.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adcj
 * JD-Core Version:    0.7.0.1
 */