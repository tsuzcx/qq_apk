import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class ainl
  extends awhw
{
  ainl(aink paramaink) {}
  
  protected void c(boolean paramBoolean)
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
    this.a.a.a.a(1, alud.a(2131714252));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainl
 * JD-Core Version:    0.7.0.1
 */