import android.os.Looper;
import android.os.Message;

public class aant
{
  private int jdField_a_of_type_Int = -1;
  protected aans a;
  private aanv jdField_a_of_type_Aanv = new aanv(this, Looper.getMainLooper());
  
  public void a()
  {
    this.jdField_a_of_type_Aanv.removeCallbacks(null);
    this.jdField_a_of_type_Aans = null;
  }
  
  protected void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Aanv);
    localMessage.what = 7;
    localMessage.obj = new aanu(paramLong);
    localMessage.sendToTarget();
  }
  
  public void a(aans paramaans)
  {
    this.jdField_a_of_type_Aans = paramaans;
  }
  
  public void b()
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Aanv);
    localMessage.what = 4;
    localMessage.sendToTarget();
  }
  
  protected void b(long paramLong)
  {
    if (this.jdField_a_of_type_Aans != null) {
      this.jdField_a_of_type_Aans.a(paramLong);
    }
  }
  
  public void c()
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Aanv);
    localMessage.what = 2;
    localMessage.sendToTarget();
  }
  
  protected void c(long paramLong)
  {
    a(3);
    if (this.jdField_a_of_type_Aans != null) {
      this.jdField_a_of_type_Aans.a(paramLong);
    }
  }
  
  protected void d()
  {
    a(3);
    if (this.jdField_a_of_type_Aans != null) {}
  }
  
  protected void e()
  {
    a(4);
    if (this.jdField_a_of_type_Aans != null) {}
  }
  
  protected void f()
  {
    a(5);
    if (this.jdField_a_of_type_Aans != null) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aant
 * JD-Core Version:    0.7.0.1
 */