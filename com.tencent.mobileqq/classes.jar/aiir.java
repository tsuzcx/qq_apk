import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class aiir
{
  static
  {
    UserAction.registerTunnel(new TunnelInfo("00000BXKOY3QZQ1E"));
  }
  
  public static void a(HashMap<String, String> paramHashMap)
  {
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("00000BXKOY3QZQ1E", BaseApplicationImpl.getApplication().getRuntime().getAccount(), "expo", true, 0L, 0L, paramHashMap, null);
  }
  
  public static void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, aihq paramaihq)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("keyword", paramString1);
    localHashMap.put("pic_md5", paramaihq.c());
    localHashMap.put("pic_url", paramaihq.a());
    localHashMap.put("aio_type", EmoticonUtils.getStickerRecAioType(paramInt));
    if ((paramaihq instanceof aiig))
    {
      paramString1 = ((aiig)paramaihq).n();
      if (paramString1 != null) {
        localHashMap.put("algo_info", paramString1);
      }
      paramString1 = ((aiig)paramaihq).o();
      if (paramString1 != null) {
        localHashMap.put("recom_transfer", paramString1);
      }
    }
    paramString1 = paramaihq.d();
    if ((paramString1 != null) && (paramString1.length() > 1) && (paramString1.endsWith("-"))) {
      localHashMap.put("source", paramString1.substring(0, 1));
    }
    if (paramString2 != null) {
      localHashMap.put("target_qq", paramString2);
    }
    localHashMap.put("duration_ms", paramaihq.a() + "");
    if (paramBoolean)
    {
      a(localHashMap);
      return;
    }
    b(localHashMap);
  }
  
  public static void b(HashMap<String, String> paramHashMap)
  {
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("00000BXKOY3QZQ1E", BaseApplicationImpl.getApplication().getRuntime().getAccount(), "click", true, 0L, 0L, paramHashMap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiir
 * JD-Core Version:    0.7.0.1
 */