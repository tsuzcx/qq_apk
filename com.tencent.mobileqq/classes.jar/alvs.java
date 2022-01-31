import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class alvs
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "handleOtherProcess onPluginManagerLoaded");
    }
    IPluginManager.a(paramPluginManagerClient);
    IPluginManager.a(null);
    while (!IPluginManager.a().isEmpty())
    {
      paramPluginManagerClient = (alvx)IPluginManager.a().poll();
      if (paramPluginManagerClient != null) {
        IPluginManager.b(paramPluginManagerClient.jdField_a_of_type_AndroidContentContext, paramPluginManagerClient.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams, paramPluginManagerClient.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alvs
 * JD-Core Version:    0.7.0.1
 */