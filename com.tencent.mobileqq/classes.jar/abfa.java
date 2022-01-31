import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.armap.ResDownloadManager.IResDownloadListener;
import com.tencent.mobileqq.armap.config.ARMapConfigManager;
import com.tencent.mobileqq.armap.config.PreloadMapRDHandler.UserData;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class abfa
  implements ResDownloadManager.IResDownloadListener
{
  public abfa(ARMapConfigManager paramARMapConfigManager) {}
  
  public void a(String paramString1, String paramString2, int paramInt) {}
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    long l;
    if ((paramObject instanceof PreloadMapRDHandler.UserData))
    {
      paramString2 = (PreloadMapRDHandler.UserData)paramObject;
      if (paramInt != 0) {
        break label155;
      }
      l = new File(paramString3).length() / 1024L;
      paramString3 = new HashMap();
      paramString3.put("failReason", String.valueOf(paramInt));
      paramString3.put("fileSize", String.valueOf(l));
      if (!paramString2.jdField_a_of_type_Boolean) {
        break label161;
      }
    }
    label155:
    label161:
    for (paramString1 = "1";; paramString1 = "0")
    {
      paramString3.put("isFileExist", paramString1);
      paramString3.put("areaCode", String.valueOf(paramString2.jdField_a_of_type_Int));
      StatisticCollector.a(BaseApplicationImpl.getContext()).a("", "ARMAP_OFFLINE_FILESIZE", true, 0L, 0L, paramString3, "", false);
      if (paramInt != 0) {
        QLog.d("ARMapConfigManager.preloadMap", 1, "preload armap errCode:" + paramInt);
      }
      return;
      l = 0L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abfa
 * JD-Core Version:    0.7.0.1
 */