import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.OnOpenPluginListener;
import cooperation.plugin.IPluginManager.OnPluginReadyListener;
import cooperation.plugin.IPluginManager.PluginParams;

public final class alvr
  implements IPluginManager.OnPluginReadyListener
{
  public alvr(IPluginManager.OnOpenPluginListener paramOnOpenPluginListener) {}
  
  public void a(boolean paramBoolean, Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "openActivityForResult onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      IPluginManager.b((Activity)paramContext, paramPluginParams);
    }
    for (;;)
    {
      if (this.a != null) {
        this.a.a(paramBoolean);
      }
      return;
      Toast.makeText(BaseApplicationImpl.getContext(), "加载失败", 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alvr
 * JD-Core Version:    0.7.0.1
 */