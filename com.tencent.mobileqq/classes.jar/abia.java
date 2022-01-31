import com.tencent.mobileqq.armap.wealthgod.ARMapLoadingActivity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class abia
  implements Runnable
{
  public abia(ARMapLoadingActivity paramARMapLoadingActivity, boolean paramBoolean) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    StatisticCollector.a(BaseApplication.getContext()).a("", "REPORT_TAG_PRE_START_THREAD", this.jdField_a_of_type_Boolean, 0L, 0L, localHashMap, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abia
 * JD-Core Version:    0.7.0.1
 */