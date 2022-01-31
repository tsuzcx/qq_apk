import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.qphone.base.util.QLog;

public class ahxy
  implements Runnable
{
  public ahxy(QZoneManagerImp paramQZoneManagerImp) {}
  
  public void run()
  {
    QZoneManagerImp.a(this.a);
    QZoneManagerImp.a(this.a, QZoneManagerImp.b(this.a));
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.QZoneManagerImp.", 2, "QZoneManagerImp init notifyQQTab type:" + Long.toBinaryString(QZoneManagerImp.a(this.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxy
 * JD-Core Version:    0.7.0.1
 */