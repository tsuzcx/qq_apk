import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aisv
  implements aiks
{
  aisv(aist paramaist) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationEntryController", 2, new Object[] { "onUnreadCountChanged bShowEntry" + aist.a(this.a), " count" + paramInt });
    }
    this.a.d();
  }
  
  public void a(apus paramapus)
  {
    if ((paramapus == null) || (!paramapus.a(aist.a(this.a).getCurrentAccountUin()))) {
      aist.a(this.a, false);
    }
    for (;;)
    {
      if ((QLog.isColorLevel()) && (paramapus != null)) {
        QLog.d("TroopNotificationEntryController", 2, "onTroopNotificationConfigUpdate bShowEntry" + aist.a(this.a) + " newConf" + paramapus.toString());
      }
      this.a.d();
      return;
      aist.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisv
 * JD-Core Version:    0.7.0.1
 */