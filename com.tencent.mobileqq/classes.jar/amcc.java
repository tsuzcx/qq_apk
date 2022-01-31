import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneStartupMonitor;

class amcc
  implements Runnable
{
  amcc(amcb paramamcb, int paramInt) {}
  
  public void run()
  {
    QZoneStartupMonitor.a(this.jdField_a_of_type_Amcb.a);
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "atuoRecoveryQzoneCount", 1) > this.jdField_a_of_type_Int)
    {
      QLog.i("QZoneStartupMonitor", 1, "oat 不合法，并且wns配置要自动修复，重新安装qzone=");
      QZoneStartupMonitor.b(this.jdField_a_of_type_Amcb.a);
      LocalMultiProcConfig.putInt("key_recovery_count", this.jdField_a_of_type_Int + 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amcc
 * JD-Core Version:    0.7.0.1
 */