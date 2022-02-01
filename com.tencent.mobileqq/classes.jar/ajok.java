import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class ajok
  implements ajfo
{
  ajok(ajoi paramajoi) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationEntryController", 2, new Object[] { "onUnreadCountChanged bShowEntry" + ajoi.a(this.a), " count" + paramInt });
    }
    this.a.d();
  }
  
  public void a(aqxv paramaqxv)
  {
    if ((paramaqxv == null) || (!paramaqxv.a(ajoi.a(this.a).getCurrentAccountUin()))) {
      ajoi.a(this.a, false);
    }
    for (;;)
    {
      if ((QLog.isColorLevel()) && (paramaqxv != null)) {
        QLog.d("TroopNotificationEntryController", 2, "onTroopNotificationConfigUpdate bShowEntry" + ajoi.a(this.a) + " newConf" + paramaqxv.toString());
      }
      this.a.d();
      return;
      ajoi.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajok
 * JD-Core Version:    0.7.0.1
 */