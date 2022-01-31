import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;

public abstract class afwh
{
  protected afyk a;
  protected FragmentActivity a;
  protected View a;
  protected String a;
  
  public afwh(FragmentActivity paramFragmentActivity)
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
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.findViewById(2131375491);
    f();
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(afyk paramafyk)
  {
    this.jdField_a_of_type_Afyk = paramafyk;
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    this.jdField_a_of_type_Afyk = null;
  }
  
  public void e() {}
  
  protected void f()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("SissionUin");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afwh
 * JD-Core Version:    0.7.0.1
 */