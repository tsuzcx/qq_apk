import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.config.APMModuleConfig;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qapmsdk.QAPM;
import com.tencent.qapmsdk.base.listener.ILooperListener;
import com.tencent.qapmsdk.base.meta.LooperMeta;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class acyr
  extends acyf
  implements ILooperListener
{
  public String a()
  {
    return "looper";
  }
  
  public void a()
  {
    QAPM.setProperty(116, this);
  }
  
  protected void a(APMModuleConfig paramAPMModuleConfig)
  {
    String str2;
    String str1;
    if (BaseApplicationImpl.sProcessId == 2)
    {
      paramAPMModuleConfig.threshold = QzoneConfig.getInstance().getConfig("QzoneHomepage", "DropFrame_Stack_Threshold", paramAPMModuleConfig.threshold);
      str2 = QzoneConfig.getInstance().getConfig("QzoneHomepage", "DropFrame_Stack_UserSampleRatio");
      str1 = QzoneConfig.getInstance().getConfig("QzoneHomepage", "Dropframe_Stack_EventSampleRatio");
      if (TextUtils.isEmpty(str2)) {}
    }
    try
    {
      f = Float.valueOf(str2).floatValue();
      if (f >= 0.0F) {
        paramAPMModuleConfig.userRatio = f;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          float f = Float.valueOf(str1).floatValue();
          if (f >= 0.0F) {
            paramAPMModuleConfig.evenRatio = f;
          }
          return;
        }
        catch (Exception paramAPMModuleConfig)
        {
          paramAPMModuleConfig.printStackTrace();
        }
        localException = localException;
        localException.printStackTrace();
      }
    }
    if (!TextUtils.isEmpty(str1)) {}
  }
  
  public void onBeforeReport(LooperMeta paramLooperMeta)
  {
    HashMap localHashMap = new HashMap();
    paramLooperMeta = paramLooperMeta.getLooperParams();
    try
    {
      Iterator localIterator = paramLooperMeta.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, paramLooperMeta.getString(str));
      }
      i = acyg.a();
    }
    catch (Exception paramLooperMeta)
    {
      QLog.e("MagnifierSDK.QAPM", 1, "onMetaGet looper", paramLooperMeta);
      return;
    }
    int i;
    int j = paramLooperMeta.getInt("cost_time");
    UnifiedMonitor.a().addEvent(i, "LooperSingle", j, 0, localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acyr
 * JD-Core Version:    0.7.0.1
 */