import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZoneLogTags;

class ahjv
  implements Runnable
{
  ahjv(ahju paramahju) {}
  
  public void run()
  {
    long l = QZoneManagerImp.a(this.a.a);
    QZoneManagerImp.a(this.a.a);
    QZoneManagerImp.a(this.a.a, QZoneManagerImp.b(this.a.a));
    this.a.a.a(l | QZoneManagerImp.a(this.a.a));
    if (QLog.isColorLevel()) {
      QLog.d(QZoneLogTags.LOG_TAG_UNDEALCOUNT + "QZoneManagerImp.", 2, "onChange notifyQQTab type:" + Long.toBinaryString(QZoneManagerImp.a(this.a.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahjv
 * JD-Core Version:    0.7.0.1
 */