import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class adjv
{
  protected adjw a;
  protected adjx a;
  public QQAppInterface a;
  protected int b = -1;
  public String b;
  
  public adjv(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public abstract int a();
  
  public adjx a()
  {
    return this.jdField_a_of_type_Adjx;
  }
  
  public abstract adjx a(int paramInt);
  
  public Drawable a()
  {
    return null;
  }
  
  public abstract void a(int paramInt);
  
  public void a(adjw paramadjw)
  {
    this.jdField_a_of_type_Adjw = paramadjw;
  }
  
  public abstract void a(adjx paramadjx);
  
  public abstract void a(BaseActivity paramBaseActivity);
  
  public abstract void a(BaseActivity paramBaseActivity, adjx paramadjx);
  
  public int b()
  {
    return this.b;
  }
  
  public abstract void b(BaseActivity paramBaseActivity);
  
  public void c(adjx paramadjx)
  {
    if ((paramadjx == this.jdField_a_of_type_Adjx) && (this.jdField_a_of_type_Adjw != null)) {
      this.jdField_a_of_type_Adjw.a(paramadjx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adjv
 * JD-Core Version:    0.7.0.1
 */