import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.qphone.base.util.QLog;

public class ahqx
  implements Runnable
{
  public ahqx(InitSkin paramInitSkin) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahqx
 * JD-Core Version:    0.7.0.1
 */