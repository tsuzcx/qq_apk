import android.os.Looper;
import android.os.Message;

public class aaxt
{
  private int jdField_a_of_type_Int = -1;
  protected aaxs a;
  private aaxv jdField_a_of_type_Aaxv = new aaxv(this, Looper.getMainLooper());
  
  public void a()
  {
    this.jdField_a_of_type_Aaxv.removeCallbacks(null);
    this.jdField_a_of_type_Aaxs = null;
  }
  
  protected void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Aaxv);
    localMessage.what = 7;
    localMessage.obj = new aaxu(paramLong);
    localMessage.sendToTarget();
  }
  
  public void a(aaxs paramaaxs)
  {
    this.jdField_a_of_type_Aaxs = paramaaxs;
  }
  
  public void b()
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Aaxv);
    localMessage.what = 4;
    localMessage.sendToTarget();
  }
  
  protected void b(long paramLong)
  {
    if (this.jdField_a_of_type_Aaxs != null) {
      this.jdField_a_of_type_Aaxs.a(paramLong);
    }
  }
  
  public void c()
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Aaxv);
    localMessage.what = 2;
    localMessage.sendToTarget();
  }
  
  protected void c(long paramLong)
  {
    a(3);
    if (this.jdField_a_of_type_Aaxs != null) {
      this.jdField_a_of_type_Aaxs.a(paramLong);
    }
  }
  
  protected void d()
  {
    a(3);
    if (this.jdField_a_of_type_Aaxs != null) {}
  }
  
  protected void e()
  {
    a(4);
    if (this.jdField_a_of_type_Aaxs != null) {}
  }
  
  protected void f()
  {
    a(5);
    if (this.jdField_a_of_type_Aaxs != null) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaxt
 * JD-Core Version:    0.7.0.1
 */