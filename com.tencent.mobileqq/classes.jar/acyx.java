import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import mqq.os.MqqHandler;

class acyx
  implements Runnable
{
  acyx(acyw paramacyw) {}
  
  public void run()
  {
    QfileEditBottomBar.a(this.a.a).a().a(false);
    ThreadManager.getUIHandler().post(new acyy(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acyx
 * JD-Core Version:    0.7.0.1
 */