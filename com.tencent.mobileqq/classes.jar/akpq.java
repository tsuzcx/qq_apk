import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class akpq
  extends azov
{
  akpq(akpp paramakpp) {}
  
  protected void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SettingActivity2", 2, "onDisableMobileMatch suc[" + paramBoolean + "]");
    }
    this.a.a.a.b();
    this.a.a.a.app.unRegistObserver(this);
    if (paramBoolean)
    {
      this.a.a.a.a();
      this.a.a.a.setResult(-1);
      return;
    }
    this.a.a.a.a(1, anzj.a(2131712731));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akpq
 * JD-Core Version:    0.7.0.1
 */