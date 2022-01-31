import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.leba.view.LebaFeedsArkView;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aebf
  implements ArkViewImplement.LoadCallback
{
  public aebf(LebaFeedsArkView paramLebaFeedsArkView) {}
  
  public void onLoadFinish(int paramInt)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i("LebaFeedsArkView", 2, "onLoadFinish" + paramInt);
    }
    StatisticCollector localStatisticCollector;
    if ((paramInt == 1) || (paramInt == -1))
    {
      localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
      if (paramInt != 1) {
        break label70;
      }
    }
    for (;;)
    {
      localStatisticCollector.a("", "newleba_feeds_ark_load", bool, 0L, 0L, null, "");
      return;
      label70:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebf
 * JD-Core Version:    0.7.0.1
 */