import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import mqq.os.MqqHandler;

class adrb
  implements Runnable
{
  adrb(adra paramadra) {}
  
  public void run()
  {
    QfileEditBottomBar.a(this.a.a).a().a(false);
    ThreadManager.getUIHandler().post(new adrc(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adrb
 * JD-Core Version:    0.7.0.1
 */