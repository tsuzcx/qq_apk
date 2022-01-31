import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.statistics.UEC;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.Constants.LogoutReason;

public abstract class alny
{
  private View jdField_a_of_type_AndroidViewView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  public QQAppInterface a;
  public boolean x;
  
  public void A()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
  }
  
  public void B()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localObject = this.jdField_a_of_type_AndroidViewView.getAnimation();
      if (localObject != null) {
        ((Animation)localObject).setAnimationListener(null);
      }
      this.jdField_a_of_type_AndroidViewView.clearAnimation();
    }
    Object localObject = FrameHelperActivity.a(a());
    if (localObject != null) {
      ((FrameHelperActivity)localObject).u();
    }
  }
  
  protected void C()
  {
    CheckPermission.requestSDCardPermission(a(), new alnz(this));
  }
  
  protected void K_() {}
  
  public Resources a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
  }
  
  public View a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidViewView.findViewById(paramInt);
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    return null;
  }
  
  public final BaseActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  }
  
  public String a()
  {
    return null;
  }
  
  public String a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(paramInt);
  }
  
  public void a()
  {
    boolean bool2 = false;
    K_();
    QQAppInterface localQQAppInterface1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime());
    QQAppInterface localQQAppInterface2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    boolean bool1 = bool2;
    if (localQQAppInterface1 != null)
    {
      bool1 = bool2;
      if (localQQAppInterface2 != null) {
        if (TextUtils.equals(localQQAppInterface1.getAccount(), localQQAppInterface2.getAccount())) {
          break label67;
        }
      }
    }
    label67:
    for (bool1 = true;; bool1 = false)
    {
      b(bool1);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramIntent);
  }
  
  public void a(Configuration paramConfiguration) {}
  
  public void a(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      if (paramBoolean) {
        paramView.setBackgroundResource(2130849464);
      }
    }
    else {
      return;
    }
    paramView.setBackgroundColor(a().getColor(2131166957));
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(paramRunnable);
  }
  
  public void a(Constants.LogoutReason paramLogoutReason) {}
  
  public boolean a()
  {
    if (FrameHelperActivity.b())
    {
      FrameHelperActivity.s();
      return true;
    }
    return false;
  }
  
  public abstract void b(boolean paramBoolean);
  
  public boolean b()
  {
    return true;
  }
  
  public void c(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  protected void d() {}
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime());
  }
  
  public void e(boolean paramBoolean)
  {
    this.x = true;
    if (Build.VERSION.SDK_INT >= 15)
    {
      UEC localUEC = UEC.a;
      if (localUEC != null) {
        localUEC.a(getClass().getSimpleName(), a(), false, this);
      }
    }
  }
  
  protected boolean e()
  {
    return BaseApplicationImpl.getContext().doesHasSDCardPermission();
  }
  
  public void f() {}
  
  public void g()
  {
    this.x = false;
    if (Build.VERSION.SDK_INT >= 15)
    {
      UEC localUEC = UEC.a;
      if (localUEC != null) {
        localUEC.a(getClass().getSimpleName(), a(), true, this);
      }
    }
  }
  
  public void h()
  {
    if (this.x) {
      g();
    }
  }
  
  public void k() {}
  
  protected void m() {}
  
  public void p() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alny
 * JD-Core Version:    0.7.0.1
 */