import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.drawer.IntimateInfoChatDrawer.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class afck
  extends afcg
{
  private aesk jdField_a_of_type_Aesk;
  private boolean jdField_a_of_type_Boolean = true;
  
  public afck(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  private void m()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agps))
    {
      agps localagps = (agps)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
      if (localagps.a != null) {
        localagps.a.d(1);
      }
    }
    ThreadManager.getSubThreadHandler().post(new IntimateInfoChatDrawer.2(this));
  }
  
  protected View a()
  {
    this.jdField_a_of_type_Aesk = new afcl(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (this.jdField_a_of_type_Aesk.a() == null) {}
    this.jdField_a_of_type_Aesk.a(1);
    return this.jdField_a_of_type_Aesk.a();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Aesk != null) {
      this.jdField_a_of_type_Aesk.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aesk != null) {
      this.jdField_a_of_type_Aesk.a();
    }
  }
  
  public void f()
  {
    super.f();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("onDrawerOpened, needReqIntimateInfo: %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    }
    if (this.jdField_a_of_type_Aesk != null)
    {
      this.jdField_a_of_type_Aesk.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Aesk.b();
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Aesk.d();
        this.jdField_a_of_type_Aesk.e();
        this.jdField_a_of_type_Aesk.q();
      }
    }
    m();
  }
  
  public void h()
  {
    super.h();
    if (this.jdField_a_of_type_Aesk != null)
    {
      this.jdField_a_of_type_Aesk.b = true;
      this.jdField_a_of_type_Aesk.g();
    }
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Aesk != null)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Aesk.f();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Aesk != null)
    {
      if (a())
      {
        this.jdField_a_of_type_Aesk.d();
        this.jdField_a_of_type_Aesk.q();
      }
      this.jdField_a_of_type_Aesk.i();
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Aesk != null) {
      this.jdField_a_of_type_Aesk.j();
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Aesk != null) {
      this.jdField_a_of_type_Aesk.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afck
 * JD-Core Version:    0.7.0.1
 */