import com.tencent.mobileqq.now.enter.NowHongbaoPushManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

public class afnk
  implements Runnable
{
  public afnk(NowHongbaoPushManager paramNowHongbaoPushManager) {}
  
  public void run()
  {
    long l = NowHongbaoPushManager.a(this.a);
    if (QLog.isColorLevel()) {
      QLog.i("NowHongbaoPushManager", 2, "emmitTimerMessage tick = " + l / 1000L + "s, mCurrentTimerTick = " + NowHongbaoPushManager.b(this.a) / 1000L + "s");
    }
    if (!NowHongbaoPushManager.a(this.a).hasMessages(17))
    {
      NowHongbaoPushManager.a(this.a).sendEmptyMessageDelayed(17, l);
      NowHongbaoPushManager.a(this.a, l);
    }
    do
    {
      return;
      if (NowHongbaoPushManager.b(this.a) != l)
      {
        NowHongbaoPushManager.a(this.a).removeMessages(17);
        if (QLog.isColorLevel()) {
          QLog.i("NowHongbaoPushManager", 2, "emmitTimerMessage 更新计时器 mCurrentTimerTick=" + NowHongbaoPushManager.b(this.a) / 1000L + "s, newTick=" + l / 1000L + "s");
        }
        NowHongbaoPushManager.a(this.a, l);
        NowHongbaoPushManager.a(this.a).sendEmptyMessageDelayed(17, l);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("NowHongbaoPushManager", 2, "emmitTimerMessage 保持计时器 mCurrentTimerTick=" + NowHongbaoPushManager.b(this.a) / 1000L + "s");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     afnk
 * JD-Core Version:    0.7.0.1
 */