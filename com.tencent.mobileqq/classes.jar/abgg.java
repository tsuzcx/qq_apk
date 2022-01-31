import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class abgg
{
  protected abgh a;
  protected abgi a;
  public QQAppInterface a;
  protected int b = -1;
  public String b;
  
  public abgg(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public abstract int a();
  
  public abgi a()
  {
    return this.jdField_a_of_type_Abgi;
  }
  
  public abstract abgi a(int paramInt);
  
  public Drawable a()
  {
    return null;
  }
  
  public abstract void a(int paramInt);
  
  public void a(abgh paramabgh)
  {
    this.jdField_a_of_type_Abgh = paramabgh;
  }
  
  public abstract void a(abgi paramabgi);
  
  public abstract void a(BaseActivity paramBaseActivity);
  
  public abstract void a(BaseActivity paramBaseActivity, abgi paramabgi);
  
  public int b()
  {
    return this.b;
  }
  
  public abstract void b(BaseActivity paramBaseActivity);
  
  public void c(abgi paramabgi)
  {
    if ((paramabgi == this.jdField_a_of_type_Abgi) && (this.jdField_a_of_type_Abgh != null)) {
      this.jdField_a_of_type_Abgh.a(paramabgi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abgg
 * JD-Core Version:    0.7.0.1
 */