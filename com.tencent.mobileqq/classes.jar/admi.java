import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IUploadController;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase;

public class admi
  implements View.OnClickListener
{
  public admi(FileBrowserPresenterBase paramFileBrowserPresenterBase) {}
  
  public void onClick(View paramView)
  {
    int i = this.a.a.h();
    if ((i == 2) || (i == 3)) {
      if (this.a.a.a() != null) {
        this.a.a.a().a();
      }
    }
    while ((i != 1) || (this.a.a.a() == null)) {
      return;
    }
    this.a.a.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     admi
 * JD-Core Version:    0.7.0.1
 */