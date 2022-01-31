import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Locale;

public final class abif
  implements Runnable
{
  public abif(int paramInt, String paramString1, String paramString2, long paramLong) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_FailCode", String.valueOf(this.jdField_a_of_type_Int));
        StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplicationImpl.getContext());
        String str1 = this.jdField_a_of_type_JavaLangString;
        String str2 = this.b;
        if (this.jdField_a_of_type_Int != 0) {
          continue;
        }
        bool = true;
        localStatisticCollector.a(str1, str2, bool, this.jdField_a_of_type_Long, 0L, localHashMap, "");
      }
      catch (Exception localException)
      {
        boolean bool;
        localException.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i("CampusCircleHelper", 2, String.format(Locale.getDefault(), "reportPerformance account: %s tag: %s resultCode: %d cost: %d", new Object[] { this.jdField_a_of_type_JavaLangString, this.b, Integer.valueOf(this.jdField_a_of_type_Int), Long.valueOf(this.jdField_a_of_type_Long) }));
      }
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abif
 * JD-Core Version:    0.7.0.1
 */