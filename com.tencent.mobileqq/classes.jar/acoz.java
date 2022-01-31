import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.ControlerCallback;
import com.tencent.mobileqq.filemanager.core.QfavFilePreviewController;
import com.tencent.qphone.base.util.QLog;

public class acoz
  implements Runnable
{
  public acoz(QfavFilePreviewController paramQfavFilePreviewController) {}
  
  public void run()
  {
    if (3 != QfavFilePreviewController.b(this.a))
    {
      this.a.a.a(false, QfavFilePreviewController.a(this.a), String.valueOf(QfavFilePreviewController.a(this.a)), QfavFilePreviewController.a(this.a), null, QfavFilePreviewController.b(this.a), null, QfavFilePreviewController.c(this.a));
      QfavFilePreviewController.b(this.a, 3);
      if (QLog.isColorLevel()) {
        QLog.i("QfavFilePreviewController", 2, "QfavFilePreviewController.run:wait for remote command timeout(5min).");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acoz
 * JD-Core Version:    0.7.0.1
 */