import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.qphone.base.util.QLog;

public class acag
  implements Runnable
{
  public acag(EquipmentLockImpl paramEquipmentLockImpl) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DevLock", 2, "notification runnable run.");
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acag
 * JD-Core Version:    0.7.0.1
 */