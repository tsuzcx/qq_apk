import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class aawn
{
  protected aawo a;
  protected aawp a;
  public QQAppInterface a;
  protected int b = -1;
  public String b;
  
  public aawn(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public abstract int a();
  
  public aawp a()
  {
    return this.jdField_a_of_type_Aawp;
  }
  
  public abstract aawp a(int paramInt);
  
  public Drawable a()
  {
    return null;
  }
  
  public abstract void a(int paramInt);
  
  public void a(aawo paramaawo)
  {
    this.jdField_a_of_type_Aawo = paramaawo;
  }
  
  public abstract void a(aawp paramaawp);
  
  public abstract void a(BaseActivity paramBaseActivity);
  
  public abstract void a(BaseActivity paramBaseActivity, aawp paramaawp);
  
  public int b()
  {
    return this.b;
  }
  
  public abstract void b(BaseActivity paramBaseActivity);
  
  public void c(aawp paramaawp)
  {
    if ((paramaawp == this.jdField_a_of_type_Aawp) && (this.jdField_a_of_type_Aawo != null)) {
      this.jdField_a_of_type_Aawo.a(paramaawp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aawn
 * JD-Core Version:    0.7.0.1
 */