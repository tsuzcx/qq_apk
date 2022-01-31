import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class agkv
  extends aume
{
  agkv(agku paramagku) {}
  
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
    this.a.a.a.a(1, ajyc.a(2131713857));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agkv
 * JD-Core Version:    0.7.0.1
 */