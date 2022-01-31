import com.tencent.mobileqq.filemanager.fileviewer.model.DatalineFileModel;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnTransEventListener;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.qphone.base.util.QLog;

class acsu
  implements FMDialogUtil.FMDialogInterface
{
  acsu(acst paramacst) {}
  
  public void a()
  {
    int i = this.a.a.g();
    if (this.a.a.f() == 6000) {
      if (i == 0) {
        DatalineFileModel.a(this.a.a);
      }
    }
    for (;;)
    {
      if (this.a.a.a != null) {
        this.a.a.a.d();
      }
      return;
      DatalineFileModel.c(this.a.a);
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("DatalineFileModel<FileAssistant>", 2, "DatalineFileModel doStartDownload : error, this file is not from dataline");
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acsu
 * JD-Core Version:    0.7.0.1
 */