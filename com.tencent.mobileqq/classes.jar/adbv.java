import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class adbv
{
  protected adbw a;
  protected adbx a;
  public QQAppInterface a;
  protected int b = -1;
  public String b;
  
  public adbv(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public abstract int a();
  
  public adbx a()
  {
    return this.jdField_a_of_type_Adbx;
  }
  
  public abstract adbx a(int paramInt);
  
  public Drawable a()
  {
    return null;
  }
  
  public abstract void a(int paramInt);
  
  public void a(adbw paramadbw)
  {
    this.jdField_a_of_type_Adbw = paramadbw;
  }
  
  public abstract void a(adbx paramadbx);
  
  public abstract void a(BaseActivity paramBaseActivity);
  
  public abstract void a(BaseActivity paramBaseActivity, adbx paramadbx);
  
  public int b()
  {
    return this.b;
  }
  
  public abstract void b(BaseActivity paramBaseActivity);
  
  public void c(adbx paramadbx)
  {
    if ((paramadbx == this.jdField_a_of_type_Adbx) && (this.jdField_a_of_type_Adbw != null)) {
      this.jdField_a_of_type_Adbw.a(paramadbx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adbv
 * JD-Core Version:    0.7.0.1
 */