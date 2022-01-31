import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;

public class adfx
  extends adfs
{
  private asrl jdField_a_of_type_Asrl;
  private boolean jdField_a_of_type_Boolean;
  
  public adfx(BaseChatPie paramBaseChatPie)
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
    adjp localadjp = (adjp)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(31);
    if (localadjp != null) {
      localadjp.e();
    }
    aefu.e();
  }
  
  protected View a()
  {
    this.jdField_a_of_type_Asrl = new adfy(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    if (this.jdField_a_of_type_Asrl.a() == null) {}
    return this.jdField_a_of_type_Asrl.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Asrl != null) {
      this.jdField_a_of_type_Asrl.b();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_Asrl != null) && (a()))
    {
      this.jdField_a_of_type_Asrl.a();
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
    if (this.jdField_a_of_type_Asrl != null) {
      this.jdField_a_of_type_Asrl.a();
    }
    l();
  }
  
  public void h()
  {
    super.h();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("onDrawerClosed", new Object[0]));
    }
    if (this.jdField_a_of_type_Asrl != null) {
      this.jdField_a_of_type_Asrl.c();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Asrl != null)
    {
      this.jdField_a_of_type_Asrl.d();
      this.jdField_a_of_type_Asrl = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adfx
 * JD-Core Version:    0.7.0.1
 */