import com.tencent.mobileqq.activity.contacts.fragment.PhoneContactFragment;
import com.tencent.qphone.base.util.QLog;

public class ahtj
  extends awhw
{
  private ahtj(PhoneContactFragment paramPhoneContactFragment) {}
  
  private void g(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactFragment", 2, String.format("refreshResult [%s]", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (this.a.c)
    {
      if (this.a.a != null) {
        this.a.a.a(this.a.b(), paramBoolean, null);
      }
      if (paramBoolean) {
        this.a.c();
      }
      this.a.c = false;
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactFragment", 2, String.format("onHideContact [%s]", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    this.a.c();
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactFragment", 2, String.format("onQueryBindState [%s, %s]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }));
    }
    g(paramBoolean1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahtj
 * JD-Core Version:    0.7.0.1
 */