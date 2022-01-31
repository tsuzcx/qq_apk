import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.provider.QZConfigProviderUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

class alsi
  implements Runnable
{
  alsi(alsh paramalsh, boolean paramBoolean) {}
  
  public void run()
  {
    String str = QZConfigProviderUtil.b();
    if (QLog.isColorLevel()) {
      QLog.d("QzoneConfig", 2, "QZoneConfigService onChange from:" + str + " ,processName:" + BaseApplicationImpl.processName + " ,selfChange:" + this.jdField_a_of_type_Boolean);
    }
    if ((str != null) && (!str.equals(BaseApplicationImpl.processName)))
    {
      QzoneConfig.getInstance().clearConfigs();
      QzoneConfig.getInstance().loadAllConfigs();
    }
    QzoneConfig.access$000(this.jdField_a_of_type_Alsh.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alsi
 * JD-Core Version:    0.7.0.1
 */