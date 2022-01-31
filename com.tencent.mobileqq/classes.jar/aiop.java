import com.tencent.mobileqq.highway.netprobe.WeakNetCallback;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public final class aiop
  implements WeakNetCallback
{
  private StatisticCollector a = StatisticCollector.a(BaseApplication.getContext());
  
  public void onResultOverflow(HashMap paramHashMap)
  {
    this.a.a(QQUtils.a(), "actWeaknetProbe", true, 0L, paramHashMap.size(), paramHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiop
 * JD-Core Version:    0.7.0.1
 */