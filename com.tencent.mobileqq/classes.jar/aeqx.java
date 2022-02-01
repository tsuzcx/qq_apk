import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class aeqx
{
  protected aeqy a;
  protected aeqz a;
  public QQAppInterface a;
  protected int b = -1;
  public String b;
  
  public aeqx(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public abstract int a();
  
  public aeqz a()
  {
    return this.jdField_a_of_type_Aeqz;
  }
  
  public abstract aeqz a(int paramInt);
  
  public Drawable a()
  {
    return null;
  }
  
  public abstract void a(int paramInt);
  
  public void a(aeqy paramaeqy)
  {
    this.jdField_a_of_type_Aeqy = paramaeqy;
  }
  
  public abstract void a(aeqz paramaeqz);
  
  public abstract void a(BaseActivity paramBaseActivity);
  
  public abstract void a(BaseActivity paramBaseActivity, aeqz paramaeqz);
  
  public int b()
  {
    return this.b;
  }
  
  public abstract void b(BaseActivity paramBaseActivity);
  
  public void c(aeqz paramaeqz)
  {
    if ((paramaeqz == this.jdField_a_of_type_Aeqz) && (this.jdField_a_of_type_Aeqy != null)) {
      this.jdField_a_of_type_Aeqy.a(paramaeqz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeqx
 * JD-Core Version:    0.7.0.1
 */