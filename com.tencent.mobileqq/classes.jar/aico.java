import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.qphone.base.util.QLog;

class aico
  implements Runnable
{
  aico(aicn paramaicn) {}
  
  public void run()
  {
    long l = QZoneManagerImp.a(this.a.a);
    QZoneManagerImp.a(this.a.a);
    QZoneManagerImp.a(this.a.a, QZoneManagerImp.b(this.a.a));
    this.a.a.a(l | QZoneManagerImp.a(this.a.a));
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.QZoneManagerImp.", 2, "onChange notifyQQTab type:" + Long.toBinaryString(QZoneManagerImp.a(this.a.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aico
 * JD-Core Version:    0.7.0.1
 */