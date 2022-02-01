import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public abstract class aabe
  implements Application.ActivityLifecycleCallbacks
{
  private aabf jdField_a_of_type_Aabf;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private BasePartFragment jdField_a_of_type_ComTencentBizRichframeworkPartBasePartFragment;
  public QQAppInterface a;
  
  public <T extends aabb> T a(BasePartFragment paramBasePartFragment, String paramString, Class<T> paramClass)
  {
    if (this.jdField_a_of_type_ComTencentBizRichframeworkPartBasePartFragment != null) {
      return this.jdField_a_of_type_ComTencentBizRichframeworkPartBasePartFragment.a(paramBasePartFragment, paramString, paramClass);
    }
    return null;
  }
  
  public <T extends aabb> T a(Class<T> paramClass)
  {
    return a(null, paramClass);
  }
  
  public <T extends aabb> T a(String paramString, Class<T> paramClass)
  {
    if (this.jdField_a_of_type_ComTencentBizRichframeworkPartBasePartFragment != null) {
      return a(this.jdField_a_of_type_ComTencentBizRichframeworkPartBasePartFragment, paramString, paramClass);
    }
    return null;
  }
  
  public aabf a()
  {
    return this.jdField_a_of_type_Aabf;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public Context a()
  {
    if (this.jdField_a_of_type_AndroidAppActivity != null) {
      return this.jdField_a_of_type_AndroidAppActivity;
    }
    return null;
  }
  
  public BasePartFragment a()
  {
    return this.jdField_a_of_type_ComTencentBizRichframeworkPartBasePartFragment;
  }
  
  public Object a(String paramString, Object paramObject)
  {
    return null;
  }
  
  public abstract String a();
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Configuration paramConfiguration) {}
  
  protected void a(View paramView)
  {
    QLog.d(a(), 1, a() + "->onInitView");
  }
  
  public void a(BasePartFragment paramBasePartFragment, View paramView, aabf paramaabf)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramBasePartFragment.getActivity();
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBasePartFragment = paramBasePartFragment;
    this.jdField_a_of_type_Aabf = paramaabf;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBasePartFragment.getActivity().app;
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(String paramString, Object paramObject) {}
  
  public boolean a()
  {
    return false;
  }
  
  public Object b(String paramString, Object paramObject)
  {
    return this.jdField_a_of_type_Aabf.a(paramString, paramObject);
  }
  
  public void b(String paramString, Object paramObject)
  {
    this.jdField_a_of_type_Aabf.a(paramString, paramObject);
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aabe
 * JD-Core Version:    0.7.0.1
 */