import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

public class afnr
  extends afnn
{
  private afbj jdField_a_of_type_Afbj;
  private boolean jdField_a_of_type_Boolean = true;
  
  public afnr(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  private void m() {}
  
  protected View a()
  {
    this.jdField_a_of_type_Afbj = new afns(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
    if (this.jdField_a_of_type_Afbj.a() == null) {}
    this.jdField_a_of_type_Afbj.a(1);
    return this.jdField_a_of_type_Afbj.a();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Afbj != null) {
      this.jdField_a_of_type_Afbj.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Afbj != null) {
      this.jdField_a_of_type_Afbj.a();
    }
  }
  
  public void f()
  {
    super.f();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("onDrawerOpened, needReqIntimateInfo: %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    }
    if (this.jdField_a_of_type_Afbj != null)
    {
      this.jdField_a_of_type_Afbj.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Afbj.b();
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Afbj.d();
        this.jdField_a_of_type_Afbj.e();
        this.jdField_a_of_type_Afbj.o();
      }
    }
    m();
  }
  
  public void h()
  {
    super.h();
    if (this.jdField_a_of_type_Afbj != null)
    {
      this.jdField_a_of_type_Afbj.b = true;
      this.jdField_a_of_type_Afbj.g();
    }
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Afbj != null)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Afbj.f();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Afbj != null)
    {
      if (a())
      {
        this.jdField_a_of_type_Afbj.d();
        this.jdField_a_of_type_Afbj.o();
      }
      this.jdField_a_of_type_Afbj.i();
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Afbj != null) {
      this.jdField_a_of_type_Afbj.j();
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Afbj != null) {
      this.jdField_a_of_type_Afbj.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afnr
 * JD-Core Version:    0.7.0.1
 */