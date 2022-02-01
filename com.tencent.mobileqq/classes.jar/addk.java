import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qapmsdk.QAPM;
import com.tencent.qapmsdk.base.meta.SceneMeta;
import com.tencent.qapmsdk.resource.ResourceListener;
import com.tencent.qapmsdk.resource.ResourceMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class addk
  extends adcg
  implements adca, ResourceListener
{
  public void a(String paramString)
  {
    if (e()) {
      QAPM.beginScene(paramString, QAPM.ModeResource);
    }
  }
  
  protected void b()
  {
    ResourceMonitor.setPublicMode(true);
    ResourceMonitor.setResourceListener(this);
  }
  
  public void b(String paramString)
  {
    if (e()) {
      QAPM.endScene(paramString, QAPM.ModeResource);
    }
  }
  
  public String c()
  {
    return "resource";
  }
  
  public void onMetaGet(SceneMeta paramSceneMeta)
  {
    double d = 100.0D * paramSceneMeta.cpu;
    if (QLog.isColorLevel()) {
      QLog.i("QAPM_QQ_Impl", 2, "reportToDenta" + paramSceneMeta.stage + " " + d + " " + paramSceneMeta.memory + " " + paramSceneMeta.duration);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("cpuUsage", String.valueOf(d));
    localHashMap.put("memory", String.valueOf(paramSceneMeta.memory));
    localHashMap.put("scene", String.valueOf(paramSceneMeta.stage));
    localHashMap.put("duration", String.valueOf(paramSceneMeta.duration));
    bctj.a(BaseApplicationImpl.getContext()).a("", "actScenePerf", true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     addk
 * JD-Core Version:    0.7.0.1
 */