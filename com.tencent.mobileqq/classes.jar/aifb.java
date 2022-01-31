import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable.DebuggableCallback;
import com.tencent.mobileqq.startup.step.InitUrlDrawable;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class aifb
  implements URLDrawable.DebuggableCallback
{
  private Set a = new HashSet();
  
  public boolean isNeedSample()
  {
    return UnifiedMonitor.a().whetherReportThisTime(2);
  }
  
  public void onDebug(int paramInt, Object paramObject)
  {
    String str2;
    String str3;
    String str4;
    String str1;
    switch (paramInt)
    {
    default: 
    case 1: 
      do
      {
        return;
        paramObject = (Object[])paramObject;
      } while (paramObject.length != 5);
      str2 = (String)paramObject[0];
      str3 = (String)paramObject[1];
      str4 = (String)paramObject[2];
      str1 = (String)paramObject[3];
      paramObject = (Exception)paramObject[4];
    }
    for (;;)
    {
      try
      {
        Object localObject = str2.split("\\(|,|\\)");
        paramInt = Integer.parseInt(localObject[1]);
        int i = Integer.parseInt(localObject[2]);
        localObject = str3.split("\\(|,|\\)");
        int j = Integer.parseInt(localObject[1]);
        int k = Integer.parseInt(localObject[2]);
        if ((j <= 0) || (k <= 0)) {
          break;
        }
        if ((paramInt > 0) && (i > 0))
        {
          j = Math.max(Math.round(j / paramInt), Math.round(k / i));
          if (j >= 2)
          {
            paramInt = i * paramInt * (j * j - 1);
            if (paramInt <= 0) {
              break;
            }
            paramInt = paramInt * 4 / 1024;
            localObject = new HashMap(8);
            paramObject = InitUrlDrawable.a(paramObject);
            if (paramObject == null) {
              break label348;
            }
            ((Map)localObject).put("stack", paramObject);
            ((Map)localObject).put("viewsize", str2);
            ((Map)localObject).put("picsize", str3);
            if (str4 != null)
            {
              paramObject = str4.replace('&', ' ');
              ((Map)localObject).put("img_url", paramObject);
              UnifiedMonitor.a().addEvent(2, str1, paramInt, 0, (Map)localObject);
              return;
            }
            paramObject = "";
            continue;
            paramObject = (Object[])paramObject;
            if (paramObject.length != 2) {
              break;
            }
            str1 = (String)paramObject[0];
            paramObject = (Exception)paramObject[1];
            return;
          }
          paramInt = 0;
          continue;
        }
        paramInt = j * k;
      }
      catch (Throwable paramObject)
      {
        return;
      }
      continue;
      label348:
      paramObject = "";
    }
  }
  
  public void onReportThread(HashMap paramHashMap)
  {
    if (paramHashMap != null)
    {
      paramHashMap.put("version", AppSetting.c());
      paramHashMap.put("build_type", "pub");
      StatisticCollector.a(BaseApplicationImpl.sApplication).a(null, "URLDrawableThreadState", true, 0L, 0L, paramHashMap, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aifb
 * JD-Core Version:    0.7.0.1
 */