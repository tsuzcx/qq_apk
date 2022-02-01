import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class adnk
  implements bcan
{
  adnk(adnj paramadnj) {}
  
  public void a()
  {
    QLog.i("JumpAction", 1, "system share.doShare show self dialog grant");
    HashMap localHashMap = new HashMap();
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "noSDPermissionShareSelftGrant", true, 0L, 0L, localHashMap, "");
  }
  
  public void b()
  {
    QLog.i("JumpAction", 1, "system share.doShare show self dialog denied");
    HashMap localHashMap = new HashMap();
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "noSDPermissionShareSelftDeny", true, 0L, 0L, localHashMap, "");
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adnk
 * JD-Core Version:    0.7.0.1
 */