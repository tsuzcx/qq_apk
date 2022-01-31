import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class abgk
{
  protected abgl a;
  protected abgm a;
  public QQAppInterface a;
  protected int b = -1;
  public String b;
  
  public abgk(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public abstract int a();
  
  public abgm a()
  {
    return this.jdField_a_of_type_Abgm;
  }
  
  public abstract abgm a(int paramInt);
  
  public Drawable a()
  {
    return null;
  }
  
  public abstract void a(int paramInt);
  
  public void a(abgl paramabgl)
  {
    this.jdField_a_of_type_Abgl = paramabgl;
  }
  
  public abstract void a(abgm paramabgm);
  
  public abstract void a(BaseActivity paramBaseActivity);
  
  public abstract void a(BaseActivity paramBaseActivity, abgm paramabgm);
  
  public int b()
  {
    return this.b;
  }
  
  public abstract void b(BaseActivity paramBaseActivity);
  
  public void c(abgm paramabgm)
  {
    if ((paramabgm == this.jdField_a_of_type_Abgm) && (this.jdField_a_of_type_Abgl != null)) {
      this.jdField_a_of_type_Abgl.a(paramabgm);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abgk
 * JD-Core Version:    0.7.0.1
 */