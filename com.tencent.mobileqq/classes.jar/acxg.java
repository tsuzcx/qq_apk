import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class acxg
{
  protected acxh a;
  protected acxi a;
  public QQAppInterface a;
  protected int b = -1;
  public String b;
  
  public acxg(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public abstract int a();
  
  public acxi a()
  {
    return this.jdField_a_of_type_Acxi;
  }
  
  public abstract acxi a(int paramInt);
  
  public Drawable a()
  {
    return null;
  }
  
  public abstract void a(int paramInt);
  
  public void a(acxh paramacxh)
  {
    this.jdField_a_of_type_Acxh = paramacxh;
  }
  
  public abstract void a(acxi paramacxi);
  
  public abstract void a(BaseActivity paramBaseActivity);
  
  public abstract void a(BaseActivity paramBaseActivity, acxi paramacxi);
  
  public int b()
  {
    return this.b;
  }
  
  public abstract void b(BaseActivity paramBaseActivity);
  
  public void c(acxi paramacxi)
  {
    if ((paramacxi == this.jdField_a_of_type_Acxi) && (this.jdField_a_of_type_Acxh != null)) {
      this.jdField_a_of_type_Acxh.a(paramacxi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acxg
 * JD-Core Version:    0.7.0.1
 */