import com.tencent.qphone.base.util.QLog;

class akao
  implements ajfo
{
  akao(akam paramakam) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainAssistObserver", 1, "onUnreadCountChanged, count = " + paramInt);
    }
    this.a.f();
  }
  
  public void a(aqxv paramaqxv)
  {
    if (QLog.isColorLevel())
    {
      if (paramaqxv == null) {
        break label46;
      }
      QLog.d("MainAssistObserver", 1, "onTroopNotificationConfigUpdate, newConf = " + paramaqxv.toString());
    }
    for (;;)
    {
      this.a.f();
      return;
      label46:
      QLog.d("MainAssistObserver", 1, "onTroopNotificationConfigUpdate, newConf is null ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akao
 * JD-Core Version:    0.7.0.1
 */