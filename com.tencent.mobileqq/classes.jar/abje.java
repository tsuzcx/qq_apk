import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class abje
  implements Runnable
{
  public abje(ArMapInterface paramArMapInterface) {}
  
  public void run()
  {
    if ((!ArMapInterface.a(this.a).verifyAuthentication()) && (QLog.isColorLevel())) {
      QLog.i("ArMapInterface", 2, "verifyAuthentication fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abje
 * JD-Core Version:    0.7.0.1
 */