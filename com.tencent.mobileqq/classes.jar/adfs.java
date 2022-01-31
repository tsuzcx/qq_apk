import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.drawer.IntimateInfoChatDrawer.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class adfs
  extends adfp
{
  private acwl jdField_a_of_type_Acwl;
  private boolean jdField_a_of_type_Boolean = true;
  
  public adfs(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  private void l()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aeom))
    {
      aeom localaeom = (aeom)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
      if (localaeom.a != null) {
        localaeom.a.d(1);
      }
    }
    ThreadManager.getSubThreadHandler().post(new IntimateInfoChatDrawer.2(this));
  }
  
  protected View a()
  {
    this.jdField_a_of_type_Acwl = new adft(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (this.jdField_a_of_type_Acwl.a() == null) {}
    this.jdField_a_of_type_Acwl.a(1);
    return this.jdField_a_of_type_Acwl.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Acwl != null) {
      this.jdField_a_of_type_Acwl.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Acwl != null) {
      this.jdField_a_of_type_Acwl.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("onDrawerOpened, needReqIntimateInfo: %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    }
    if (this.jdField_a_of_type_Acwl != null)
    {
      this.jdField_a_of_type_Acwl.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Acwl.b();
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Acwl.d();
        this.jdField_a_of_type_Acwl.p();
      }
    }
    l();
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Acwl != null)
    {
      this.jdField_a_of_type_Acwl.b = true;
      this.jdField_a_of_type_Acwl.f();
    }
  }
  
  public void h()
  {
    super.h();
    if (this.jdField_a_of_type_Acwl != null)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Acwl.e();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Acwl != null)
    {
      if (a())
      {
        this.jdField_a_of_type_Acwl.d();
        this.jdField_a_of_type_Acwl.p();
      }
      this.jdField_a_of_type_Acwl.h();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Acwl != null) {
      this.jdField_a_of_type_Acwl.i();
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Acwl != null) {
      this.jdField_a_of_type_Acwl.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adfs
 * JD-Core Version:    0.7.0.1
 */