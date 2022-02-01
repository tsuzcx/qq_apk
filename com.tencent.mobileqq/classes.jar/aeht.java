import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class aeht
{
  protected aehu a;
  protected aehv a;
  public QQAppInterface a;
  protected int b = -1;
  public String b;
  
  public aeht(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public abstract int a();
  
  public aehv a()
  {
    return this.jdField_a_of_type_Aehv;
  }
  
  public abstract aehv a(int paramInt);
  
  public Drawable a()
  {
    return null;
  }
  
  public abstract void a(int paramInt);
  
  public void a(aehu paramaehu)
  {
    this.jdField_a_of_type_Aehu = paramaehu;
  }
  
  public abstract void a(aehv paramaehv);
  
  public abstract void a(BaseActivity paramBaseActivity);
  
  public abstract void a(BaseActivity paramBaseActivity, aehv paramaehv);
  
  public int b()
  {
    return this.b;
  }
  
  public abstract void b(BaseActivity paramBaseActivity);
  
  public void c(aehv paramaehv)
  {
    if ((paramaehv == this.jdField_a_of_type_Aehv) && (this.jdField_a_of_type_Aehu != null)) {
      this.jdField_a_of_type_Aehu.a(paramaehv);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeht
 * JD-Core Version:    0.7.0.1
 */