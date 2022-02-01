import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

public class agev
  extends ager
{
  private afsv jdField_a_of_type_Afsv;
  private boolean jdField_a_of_type_Boolean = true;
  
  public agev(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  private void m() {}
  
  protected View a()
  {
    this.jdField_a_of_type_Afsv = new agew(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
    if (this.jdField_a_of_type_Afsv.a() == null) {}
    this.jdField_a_of_type_Afsv.a(1);
    return this.jdField_a_of_type_Afsv.a();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Afsv != null) {
      this.jdField_a_of_type_Afsv.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Afsv != null) {
      this.jdField_a_of_type_Afsv.a();
    }
  }
  
  public void f()
  {
    super.f();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("onDrawerOpened, needReqIntimateInfo: %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    }
    if (this.jdField_a_of_type_Afsv != null)
    {
      this.jdField_a_of_type_Afsv.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Afsv.b();
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Afsv.c();
        this.jdField_a_of_type_Afsv.d();
        this.jdField_a_of_type_Afsv.m();
      }
    }
    m();
  }
  
  public void h()
  {
    super.h();
    if (this.jdField_a_of_type_Afsv != null)
    {
      this.jdField_a_of_type_Afsv.b = true;
      this.jdField_a_of_type_Afsv.f();
    }
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Afsv != null)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Afsv.e();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Afsv != null)
    {
      if (a())
      {
        this.jdField_a_of_type_Afsv.c();
        this.jdField_a_of_type_Afsv.m();
      }
      this.jdField_a_of_type_Afsv.h();
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Afsv != null) {
      this.jdField_a_of_type_Afsv.i();
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Afsv != null) {
      this.jdField_a_of_type_Afsv.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agev
 * JD-Core Version:    0.7.0.1
 */