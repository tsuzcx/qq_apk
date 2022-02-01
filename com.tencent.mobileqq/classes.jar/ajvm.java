import com.tencent.mobileqq.activity.contacts.phone.PhoneContactFragment;
import com.tencent.qphone.base.util.QLog;

public class ajvm
  extends azov
{
  private ajvm(PhoneContactFragment paramPhoneContactFragment) {}
  
  private void g(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactFragment", 2, String.format("refreshResult [%s]", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (this.a.c)
    {
      if (PhoneContactFragment.a(this.a) != null) {
        PhoneContactFragment.b(this.a).a(this.a.b(), paramBoolean, null);
      }
      if (paramBoolean) {
        this.a.c();
      }
      this.a.c = false;
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactFragment", 2, String.format("onQueryBindState [%s, %s]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }));
    }
    g(paramBoolean1);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactFragment", 2, String.format("onHideContact [%s]", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajvm
 * JD-Core Version:    0.7.0.1
 */