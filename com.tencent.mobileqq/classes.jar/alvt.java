import android.content.Context;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.OnPluginReadyListener;
import cooperation.plugin.IPluginManager.PluginParams;

public final class alvt
  extends OnPluginInstallListener.Stub
{
  public alvt(IPluginManager.OnPluginReadyListener paramOnPluginReadyListener, IPluginManager.PluginParams paramPluginParams, Context paramContext) {}
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("plugin_tag", 4, "doHandleOtherProcess onInstallError");
    }
    if (this.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener != null) {
      this.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener.a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams);
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("plugin_tag", 4, "doHandleOtherProcess onInstallFinish");
    }
    if (this.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener != null)
    {
      paramString = IPluginManager.a().queryPlugin(this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.b);
      if (paramString != null) {
        this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.c = paramString.mInstalledPath;
      }
      this.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener.a(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alvt
 * JD-Core Version:    0.7.0.1
 */