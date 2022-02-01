import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.util.QQDeviceInfo;
import java.util.HashMap;

public class aclr
{
  public static void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = QQDeviceInfo.getDeviceInfo("406d43");
    int i;
    HashMap localHashMap;
    if ((!TextUtils.isEmpty(((bkyg)localObject).a)) && (((bkyg)localObject).a.startsWith("66666")))
    {
      i = 1;
      boolean bool = Build.FINGERPRINT.contains("generic/vbox86tp/");
      if ((i != 0) || (bool))
      {
        localHashMap = new HashMap();
        if (i == 0) {
          break label115;
        }
        localObject = "1";
        label63:
        localHashMap.put("imei_match", localObject);
        if (!bool) {
          break label121;
        }
      }
    }
    label115:
    label121:
    for (localObject = "1";; localObject = "0")
    {
      localHashMap.put("finger_print_match", localObject);
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "game_assist_vbox_stat", true, 0L, 0L, localHashMap, null);
      return;
      i = 0;
      break;
      localObject = "0";
      break label63;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aclr
 * JD-Core Version:    0.7.0.1
 */