import android.os.Looper;
import android.os.Message;

public class abbw
{
  private int jdField_a_of_type_Int = -1;
  protected abbv a;
  private abby jdField_a_of_type_Abby = new abby(this, Looper.getMainLooper());
  
  public void a()
  {
    this.jdField_a_of_type_Abby.removeCallbacks(null);
    this.jdField_a_of_type_Abbv = null;
  }
  
  protected void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Abby);
    localMessage.what = 7;
    localMessage.obj = new abbx(paramLong);
    localMessage.sendToTarget();
  }
  
  public void a(abbv paramabbv)
  {
    this.jdField_a_of_type_Abbv = paramabbv;
  }
  
  public void b()
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Abby);
    localMessage.what = 4;
    localMessage.sendToTarget();
  }
  
  protected void b(long paramLong)
  {
    if (this.jdField_a_of_type_Abbv != null) {
      this.jdField_a_of_type_Abbv.a(paramLong);
    }
  }
  
  public void c()
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Abby);
    localMessage.what = 2;
    localMessage.sendToTarget();
  }
  
  protected void c(long paramLong)
  {
    a(3);
    if (this.jdField_a_of_type_Abbv != null) {
      this.jdField_a_of_type_Abbv.a(paramLong);
    }
  }
  
  protected void d()
  {
    a(3);
    if (this.jdField_a_of_type_Abbv != null) {}
  }
  
  protected void e()
  {
    a(4);
    if (this.jdField_a_of_type_Abbv != null) {}
  }
  
  protected void f()
  {
    a(5);
    if (this.jdField_a_of_type_Abbv != null) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abbw
 * JD-Core Version:    0.7.0.1
 */