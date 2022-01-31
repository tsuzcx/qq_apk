import android.os.Bundle;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.nearby.NearbyJsInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class aeup
  implements BusinessObserver
{
  public aeup(NearbyJsInterface paramNearbyJsInterface, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          WebSsoBody.WebSsoResponseBody localWebSsoResponseBody = new WebSsoBody.WebSsoResponseBody();
          localWebSsoResponseBody.mergeFrom(paramBundle);
          paramBundle = new JSONObject(localWebSsoResponseBody.data.get());
          this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface.callJs(new JSONObject(this.jdField_a_of_type_JavaLangString).getString("callback"), new String[] { paramBundle.toString() });
          return;
        }
        if (QLog.isColorLevel())
        {
          QLog.w("followUser js api", 2, " no data!");
          return;
        }
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.w("followUser js api", 2, " no data! error");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeup
 * JD-Core Version:    0.7.0.1
 */