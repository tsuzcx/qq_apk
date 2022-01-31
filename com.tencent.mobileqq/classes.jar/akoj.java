import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.qphone.base.util.QLog;

public final class akoj
  implements ThreadExcutor.IThreadListener
{
  long a = 0L;
  
  public void a()
  {
    this.a = System.currentTimeMillis();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SwiftBrowserCookieMonster", 2, "Web_qqbrowser_pre_get_key, cost=" + (System.currentTimeMillis() - this.a));
    }
    this.a = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akoj
 * JD-Core Version:    0.7.0.1
 */