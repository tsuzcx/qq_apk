import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class aebb
{
  protected aebc a;
  protected aebd a;
  public QQAppInterface a;
  protected int b = -1;
  public String b;
  
  public aebb(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public abstract int a();
  
  public aebd a()
  {
    return this.jdField_a_of_type_Aebd;
  }
  
  public abstract aebd a(int paramInt);
  
  public Drawable a()
  {
    return null;
  }
  
  public abstract void a(int paramInt);
  
  public void a(aebc paramaebc)
  {
    this.jdField_a_of_type_Aebc = paramaebc;
  }
  
  public abstract void a(aebd paramaebd);
  
  public abstract void a(BaseActivity paramBaseActivity);
  
  public abstract void a(BaseActivity paramBaseActivity, aebd paramaebd);
  
  public int b()
  {
    return this.b;
  }
  
  public abstract void b(BaseActivity paramBaseActivity);
  
  public void c(aebd paramaebd)
  {
    if ((paramaebd == this.jdField_a_of_type_Aebd) && (this.jdField_a_of_type_Aebc != null)) {
      this.jdField_a_of_type_Aebc.a(paramaebd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebb
 * JD-Core Version:    0.7.0.1
 */