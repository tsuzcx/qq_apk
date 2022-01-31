import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ocr.OcrCamera;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

public class agfv
  implements Runnable
{
  public agfv(OcrCamera paramOcrCamera, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("costTime", String.valueOf(this.jdField_a_of_type_Long));
    StatisticCollector.a(BaseApplicationImpl.getContext()).a("", "ocr_select_pic", true, 0L, 0L, localHashMap, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agfv
 * JD-Core Version:    0.7.0.1
 */