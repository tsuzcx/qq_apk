import com.tencent.mobileqq.pluginsdk.PluginInterface;
import com.tencent.mobileqq.pluginsdk.PluginInterfaceHelper.OnPluginInterfaceLoadedListener;
import com.tencent.mobileqq.vashealth.PathTraceManager;

public class ajvk
  implements PluginInterfaceHelper.OnPluginInterfaceLoadedListener
{
  public ajvk(PathTraceManager paramPathTraceManager) {}
  
  public void onPluginInterfaceLoaded(PluginInterface paramPluginInterface)
  {
    PathTraceManager.a(this.a, paramPluginInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajvk
 * JD-Core Version:    0.7.0.1
 */