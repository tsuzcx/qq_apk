import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZoneLogTags;

public class ahjw
  implements Runnable
{
  public ahjw(QZoneManagerImp paramQZoneManagerImp) {}
  
  public void run()
  {
    QZoneManagerImp.a(this.a);
    QZoneManagerImp.a(this.a, QZoneManagerImp.b(this.a));
    if (QLog.isColorLevel()) {
      QLog.d(QZoneLogTags.LOG_TAG_UNDEALCOUNT + "QZoneManagerImp.", 2, "QZoneManagerImp init notifyQQTab type:" + Long.toBinaryString(QZoneManagerImp.a(this.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahjw
 * JD-Core Version:    0.7.0.1
 */