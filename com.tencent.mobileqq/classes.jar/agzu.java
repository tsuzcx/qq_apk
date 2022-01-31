import com.tencent.mobileqq.qcall.QCallProxy;
import com.tencent.qphone.base.util.QLog;

public class agzu
  implements Runnable
{
  public agzu(QCallProxy paramQCallProxy) {}
  
  public void run()
  {
    try
    {
      this.a.d();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("QCallProxy", 2, localException.getMessage(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agzu
 * JD-Core Version:    0.7.0.1
 */