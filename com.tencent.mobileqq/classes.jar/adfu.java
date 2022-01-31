import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;

public class adfu
  extends adfp
{
  private asrn jdField_a_of_type_Asrn;
  private boolean jdField_a_of_type_Boolean;
  
  public adfu(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  private void a(String paramString)
  {
    if (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString)) {
      c(false);
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    adjn localadjn = (adjn)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(31);
    if (localadjn != null) {
      localadjn.e();
    }
    aefs.e();
  }
  
  protected View a()
  {
    this.jdField_a_of_type_Asrn = new adfv(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    if (this.jdField_a_of_type_Asrn.a() == null) {}
    return this.jdField_a_of_type_Asrn.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Asrn != null) {
      this.jdField_a_of_type_Asrn.b();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_Asrn != null) && (a()))
    {
      this.jdField_a_of_type_Asrn.a();
      return true;
    }
    return false;
  }
  
  public void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("onDrawerStartOpen", new Object[0]));
    }
    if (this.jdField_a_of_type_Asrn != null) {
      this.jdField_a_of_type_Asrn.a();
    }
    l();
  }
  
  public void h()
  {
    super.h();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("onDrawerClosed", new Object[0]));
    }
    if (this.jdField_a_of_type_Asrn != null) {
      this.jdField_a_of_type_Asrn.c();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Asrn != null)
    {
      this.jdField_a_of_type_Asrn.d();
      this.jdField_a_of_type_Asrn = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adfu
 * JD-Core Version:    0.7.0.1
 */