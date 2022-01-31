import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavHelper;

public final class alyv
  implements Runnable
{
  public void run()
  {
    synchronized ()
    {
      if (QLog.isColorLevel()) {
        QLog.i("qqfav", 2, "notify(sPluginInstalled) qqfav.apk");
      }
      QfavHelper.a().notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alyv
 * JD-Core Version:    0.7.0.1
 */