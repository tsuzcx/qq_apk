import android.os.Bundle;
import android.os.Handler;
import com.tencent.device.msg.activities.DeviceMsgSettingActivity;
import com.tencent.device.msg.activities.DeviceMsgSettingActivity.2.1;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class abyl
  implements BusinessObserver
{
  public abyl(DeviceMsgSettingActivity paramDeviceMsgSettingActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.jdField_a_of_type_Bjbs.dismiss();
    if (!paramBoolean)
    {
      bjuh.a().a(this.a.getString(2131692662));
      DeviceMsgSettingActivity.b(this.a);
      return;
    }
    if (paramBundle.getInt("cgiResultCode", -1) != 0)
    {
      bjuh.a().a(this.a.getString(2131692662));
      return;
    }
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(new String(paramBundle.getByteArray("data")));
        if (paramBundle.optInt("ret", -1) != 0)
        {
          bjuh.a().a(this.a.getString(2131692662));
          this.a.jdField_a_of_type_AndroidOsHandler.post(new DeviceMsgSettingActivity.2.1(this));
          return;
        }
        paramBundle = paramBundle.optJSONArray("data");
        if (paramBundle == null)
        {
          bjuh.a().a(this.a.getString(2131694014));
          DeviceMsgSettingActivity.b(this.a);
          return;
        }
      }
      catch (JSONException paramBundle)
      {
        bjtx.e("DeviceMsgSettingActivity", "get msg setting json format faild!");
        bjuh.a().a(this.a.getString(2131692662));
        continue;
        paramInt = 0;
      }
      while (paramInt < paramBundle.length())
      {
        JSONObject localJSONObject = paramBundle.getJSONObject(paramInt);
        abyn localabyn = new abyn(this.a, null);
        localabyn.jdField_a_of_type_Int = localJSONObject.getInt("id");
        localabyn.jdField_a_of_type_JavaLangString = localJSONObject.getString("name");
        localabyn.b = localJSONObject.getInt("enable");
        this.a.jdField_a_of_type_JavaUtilArrayList.add(localabyn);
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abyl
 * JD-Core Version:    0.7.0.1
 */