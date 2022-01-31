import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;

public class aexx
  extends aexr
{
  private bbcq jdField_a_of_type_Bbcq;
  private boolean jdField_a_of_type_Boolean;
  
  public aexx(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  private void a(String paramString)
  {
    if (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString)) {
      c(false);
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    afbu localafbu = (afbu)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(55);
    if (localafbu != null) {
      localafbu.e();
    }
    agcg.e();
  }
  
  protected View a()
  {
    this.jdField_a_of_type_Bbcq = new aexy(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    if (this.jdField_a_of_type_Bbcq.a() == null) {}
    return this.jdField_a_of_type_Bbcq.a();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.jdField_a_of_type_Bbcq != null) && (a())) {
      this.jdField_a_of_type_Bbcq.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void b()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_Bbcq != null) && (a()))
    {
      this.jdField_a_of_type_Bbcq.a();
      return true;
    }
    return false;
  }
  
  public void f()
  {
    super.f();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("onDrawerStartOpen", new Object[0]));
    }
    if (this.jdField_a_of_type_Bbcq != null) {
      this.jdField_a_of_type_Bbcq.a();
    }
    m();
  }
  
  public void i()
  {
    super.i();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("onDrawerClosed", new Object[0]));
    }
    if (this.jdField_a_of_type_Bbcq != null) {
      this.jdField_a_of_type_Bbcq.b();
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Bbcq != null)
    {
      this.jdField_a_of_type_Bbcq.d();
      this.jdField_a_of_type_Bbcq = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aexx
 * JD-Core Version:    0.7.0.1
 */