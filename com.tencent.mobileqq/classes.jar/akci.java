import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.qphone.base.util.QLog;

public class akci
  extends aumh
{
  public akci(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, String.format("onQueryShowBindPhonePage result=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (paramBoolean)
    {
      paramBoolean = PhoneContactManagerImp.b(this.a, PhoneContactManagerImp.g(this.a));
      PhoneContactManagerImp.d(this.a, paramBoolean);
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, String.format("onSetShowBindPhonePageResult result=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akci
 * JD-Core Version:    0.7.0.1
 */