import android.widget.TextView;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.qphone.base.util.QLog;

public class afxn
  extends atog
{
  private afxn(ContactListView paramContactListView) {}
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactListView", 2, "onHideContact isSuccess=" + paramBoolean);
    }
    if ((paramBoolean) && (this.a.jdField_a_of_type_Int == 5)) {
      this.a.j();
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if ((!paramBoolean) || (!badq.d(this.a.getContext())))
    {
      this.a.i();
      this.a.g();
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = this.a.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d();
    if (!paramBoolean1)
    {
      this.a.i();
      this.a.g();
      if (((i == 0) || (i == 7)) && ((this.a.jdField_a_of_type_Int != 2) || (!(this.a.jdField_a_of_type_Aphp instanceof apmn))) && (this.a.b == 0)) {
        this.a.a(2131652912, 3000L);
      }
    }
    do
    {
      return;
      this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    } while (!this.a.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.e());
    this.a.a(2131653452, 0L, false);
  }
  
  protected void d(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.a.i();
      ContactListView.a(this.a, true);
      if ((paramInt & 0x1) == 0) {
        this.a.g();
      }
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_Int == 6) {
        this.a.f();
      }
      return;
      this.a.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afxn
 * JD-Core Version:    0.7.0.1
 */