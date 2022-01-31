import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.sonic.sdk.SonicEngine;
import java.util.Map;

public class akly
  implements Runnable
{
  public akly(WebProcessReceiver paramWebProcessReceiver, Map paramMap) {}
  
  public void run()
  {
    WebAccelerateHelper.getSonicEngine().removeExpiredSessionCache(this.jdField_a_of_type_JavaUtilMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akly
 * JD-Core Version:    0.7.0.1
 */