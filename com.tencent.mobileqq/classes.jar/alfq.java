import android.os.Bundle;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpBaseUtil.Statistic;
import com.tencent.open.business.base.OpenConfig;
import org.json.JSONObject;

public class alfq
  implements Runnable
{
  public alfq(OpenConfig paramOpenConfig, Bundle paramBundle) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = HttpBaseUtil.a(HttpBaseUtil.a("http://qappcenter.3g.qq.com/cgi-bin/mapp/mapp_policy_config", "GET", this.jdField_a_of_type_AndroidOsBundle).a);
      LogUtility.c("nemo", localJSONObject.toString());
      this.jdField_a_of_type_ComTencentOpenBusinessBaseOpenConfig.a(localJSONObject);
      this.jdField_a_of_type_ComTencentOpenBusinessBaseOpenConfig.a = 0;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alfq
 * JD-Core Version:    0.7.0.1
 */