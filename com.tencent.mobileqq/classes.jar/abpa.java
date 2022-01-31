import com.tencent.mobileqq.armap.wealthgod.ARMapLoadingActivity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class abpa
  implements Runnable
{
  public abpa(ARMapLoadingActivity paramARMapLoadingActivity, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("failType", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("subType", String.valueOf(this.b));
    localHashMap.put("failInfo", this.jdField_a_of_type_JavaLangString);
    StatisticCollector.a(BaseApplication.getContext()).a("", "REPORT_TAG_LOADING_FAIL", false, 0L, 0L, localHashMap, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abpa
 * JD-Core Version:    0.7.0.1
 */