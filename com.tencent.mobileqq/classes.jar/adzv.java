import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class adzv
  implements Runnable
{
  adzv(adzu paramadzu) {}
  
  public void run()
  {
    try
    {
      NearbySPUtil.c(this.a.jdField_a_of_type_JavaLangString);
      long l1 = this.a.jdField_a_of_type_Long - this.a.c;
      long l2 = this.a.d - this.a.c;
      long l3 = this.a.jdField_b_of_type_Long;
      long l4 = this.a.c;
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_DeviceType", StatisticConstants.a() + "");
      localHashMap.put("param_PreloadType", this.a.jdField_b_of_type_Int + "");
      if ((l1 > 0L) && (l1 < 60000L) && (l2 > 0L) && (l2 < 60000L))
      {
        if (this.a.jdField_a_of_type_Int != 0) {
          break label261;
        }
        StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.a.jdField_a_of_type_JavaLangString, "actEnterNearbyActCost", false, l2, l1, localHashMap, "");
      }
      while (QLog.isColorLevel())
      {
        NearbyUtils.a("NearbyProcessPerf", new Object[] { Integer.valueOf(this.a.jdField_a_of_type_Int), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3 - l4), Integer.valueOf(this.a.jdField_b_of_type_Int) });
        return;
        label261:
        if (this.a.jdField_a_of_type_Int == 1) {
          StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.a.jdField_a_of_type_JavaLangString, "actEnterNearbyActCost", true, l2, l1, localHashMap, "");
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adzv
 * JD-Core Version:    0.7.0.1
 */