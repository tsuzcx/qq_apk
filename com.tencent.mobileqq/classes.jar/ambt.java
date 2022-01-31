import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneLiveVideoDownLoadActivtyV2;
import cooperation.qzone.plugin.IQZonePluginManager;

public class ambt
  implements Runnable
{
  public ambt(QZoneLiveVideoDownLoadActivtyV2 paramQZoneLiveVideoDownLoadActivtyV2, PluginBaseInfo paramPluginBaseInfo) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_CooperationQzoneQZoneLiveVideoDownLoadActivtyV2.a != null) {
        this.jdField_a_of_type_CooperationQzoneQZoneLiveVideoDownLoadActivtyV2.a.a(this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginBaseInfo.mID, null, this.jdField_a_of_type_CooperationQzoneQZoneLiveVideoDownLoadActivtyV2.c);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QZoneLiveVideoDownLoadActivtyV2", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ambt
 * JD-Core Version:    0.7.0.1
 */