import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.qphone.base.util.QLog;

public class aijt
  implements Runnable
{
  public aijt(InitSkin paramInitSkin) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("InitSkin", 2, "start asynInitSkin");
    }
    InitSkin.initSkin(BaseApplicationImpl.sApplication);
    InitSkin.c = true;
    synchronized (InitSkin.a)
    {
      InitSkin.a.notifyAll();
      if (QLog.isColorLevel()) {
        QLog.i("InitSkin", 2, "end asynInitSkin");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aijt
 * JD-Core Version:    0.7.0.1
 */