import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;

public abstract class akal
{
  protected akcs a;
  protected FragmentActivity a;
  protected View a;
  protected String a;
  
  public akal(FragmentActivity paramFragmentActivity)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
  }
  
  public abstract int a();
  
  public FragmentManager a()
  {
    return this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager();
  }
  
  protected View a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidViewView.findViewById(paramInt);
  }
  
  public BaseActivity a()
  {
    return this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.findViewById(2131376925);
    f();
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(akcs paramakcs)
  {
    this.jdField_a_of_type_Akcs = paramakcs;
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    this.jdField_a_of_type_Akcs = null;
  }
  
  public void e() {}
  
  protected void f()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("SissionUin");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akal
 * JD-Core Version:    0.7.0.1
 */