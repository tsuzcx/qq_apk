import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.drawer.IntimateInfoChatDrawer.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aexv
  extends aexr
{
  private aenv jdField_a_of_type_Aenv;
  private boolean jdField_a_of_type_Boolean = true;
  
  public aexv(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  private void m()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agld))
    {
      agld localagld = (agld)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
      if (localagld.a != null) {
        localagld.a.d(1);
      }
    }
    ThreadManager.getSubThreadHandler().post(new IntimateInfoChatDrawer.2(this));
  }
  
  protected View a()
  {
    this.jdField_a_of_type_Aenv = new aexw(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (this.jdField_a_of_type_Aenv.a() == null) {}
    this.jdField_a_of_type_Aenv.a(1);
    return this.jdField_a_of_type_Aenv.a();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Aenv != null) {
      this.jdField_a_of_type_Aenv.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aenv != null) {
      this.jdField_a_of_type_Aenv.a();
    }
  }
  
  public void f()
  {
    super.f();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("onDrawerOpened, needReqIntimateInfo: %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    }
    if (this.jdField_a_of_type_Aenv != null)
    {
      this.jdField_a_of_type_Aenv.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Aenv.b();
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Aenv.d();
        this.jdField_a_of_type_Aenv.e();
        this.jdField_a_of_type_Aenv.q();
      }
    }
    m();
  }
  
  public void h()
  {
    super.h();
    if (this.jdField_a_of_type_Aenv != null)
    {
      this.jdField_a_of_type_Aenv.b = true;
      this.jdField_a_of_type_Aenv.g();
    }
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Aenv != null)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Aenv.f();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Aenv != null)
    {
      if (a())
      {
        this.jdField_a_of_type_Aenv.d();
        this.jdField_a_of_type_Aenv.q();
      }
      this.jdField_a_of_type_Aenv.i();
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Aenv != null) {
      this.jdField_a_of_type_Aenv.j();
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Aenv != null) {
      this.jdField_a_of_type_Aenv.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aexv
 * JD-Core Version:    0.7.0.1
 */