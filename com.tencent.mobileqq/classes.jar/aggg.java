import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class aggg
  implements Runnable
{
  aggg(aggd paramaggd, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("jd_sso_code", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("jd_code", String.valueOf(this.b));
    localHashMap.put("ocr_sso_code", String.valueOf(this.c));
    localHashMap.put("ocr_code", String.valueOf(this.d));
    localHashMap.put("ret_code", String.valueOf(this.e));
    try
    {
      StatisticCollector.a(BaseApplicationImpl.getContext()).a("", "ocr_server_fail", true, 0L, 0L, localHashMap, "", false);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("Q.ocr.control", 1, "collectPerformance exception: " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aggg
 * JD-Core Version:    0.7.0.1
 */