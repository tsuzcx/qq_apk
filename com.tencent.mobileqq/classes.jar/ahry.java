import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.statistics.StatisticCollector;

public class ahry
  implements Runnable
{
  public ahry(StatisticCollector paramStatisticCollector, String paramString) {}
  
  public void run()
  {
    try
    {
      SharedPreferences localSharedPreferences = StatisticCollector.a().getSharedPreferences("crashcontrol", 0);
      if ((localSharedPreferences != null) && (localSharedPreferences.getBoolean("shouldStopMsf", false)))
      {
        this.jdField_a_of_type_ComTencentMobileqqStatisticsStatisticCollector.a(this.jdField_a_of_type_JavaLangString, "actKillMsf", true, 0L, 0L, null, "");
        localSharedPreferences.edit().putBoolean("shouldStopMsf", false).commit();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ahry
 * JD-Core Version:    0.7.0.1
 */