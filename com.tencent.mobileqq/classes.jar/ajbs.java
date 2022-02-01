import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.qphone.base.util.QLog;

public class ajbs
  extends aywj
{
  public ajbs(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, String.format("onQueryShowBindPhonePage result=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (paramBoolean)
    {
      paramBoolean = PhoneContactManagerImp.b(this.a, PhoneContactManagerImp.g(this.a));
      PhoneContactManagerImp.c(this.a, paramBoolean);
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, String.format("onSetShowBindPhonePageResult result=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajbs
 * JD-Core Version:    0.7.0.1
 */