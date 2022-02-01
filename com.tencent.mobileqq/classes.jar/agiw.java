import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.drawer.IntimateInfoChatDrawer.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class agiw
  extends agis
{
  private afyw jdField_a_of_type_Afyw;
  private boolean jdField_a_of_type_Boolean = true;
  
  public agiw(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  private void m()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof ahzy))
    {
      ahzy localahzy = (ahzy)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
      if (localahzy.a != null) {
        localahzy.a.d(1);
      }
    }
    ThreadManager.getSubThreadHandler().post(new IntimateInfoChatDrawer.2(this));
  }
  
  protected View a()
  {
    this.jdField_a_of_type_Afyw = new agix(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (this.jdField_a_of_type_Afyw.a() == null) {}
    this.jdField_a_of_type_Afyw.a(1);
    return this.jdField_a_of_type_Afyw.a();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Afyw != null) {
      this.jdField_a_of_type_Afyw.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Afyw != null) {
      this.jdField_a_of_type_Afyw.a();
    }
  }
  
  public void f()
  {
    super.f();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("onDrawerOpened, needReqIntimateInfo: %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    }
    if (this.jdField_a_of_type_Afyw != null)
    {
      this.jdField_a_of_type_Afyw.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Afyw.b();
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Afyw.d();
        this.jdField_a_of_type_Afyw.e();
        this.jdField_a_of_type_Afyw.o();
      }
    }
    m();
  }
  
  public void h()
  {
    super.h();
    if (this.jdField_a_of_type_Afyw != null)
    {
      this.jdField_a_of_type_Afyw.b = true;
      this.jdField_a_of_type_Afyw.g();
    }
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Afyw != null)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Afyw.f();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Afyw != null)
    {
      if (a())
      {
        this.jdField_a_of_type_Afyw.d();
        this.jdField_a_of_type_Afyw.o();
      }
      this.jdField_a_of_type_Afyw.i();
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Afyw != null) {
      this.jdField_a_of_type_Afyw.j();
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Afyw != null) {
      this.jdField_a_of_type_Afyw.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agiw
 * JD-Core Version:    0.7.0.1
 */