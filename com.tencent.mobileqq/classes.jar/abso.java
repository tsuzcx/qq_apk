import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class abso
  implements BusinessObserver
{
  abso(absn paramabsn) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((this.a.jdField_a_of_type_Bisl != null) && (!this.a.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      this.a.jdField_a_of_type_Bisl.dismiss();
    }
    if (!paramBoolean)
    {
      bjkv.a().a(2131691510);
      if (this.a.jdField_a_of_type_Absp != null) {
        this.a.jdField_a_of_type_Absp.a(false);
      }
    }
    do
    {
      return;
      if (paramBundle.getInt("cgiResultCode", -1) == 0) {
        break;
      }
      bjkv.a().a(2131691510);
    } while (this.a.jdField_a_of_type_Absp == null);
    this.a.jdField_a_of_type_Absp.a(false);
    return;
    int j;
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(new String(paramBundle.getByteArray("data")));
        j = paramBundle.optInt("ret", -1);
        if (j != 0)
        {
          bjko.a("LightAppUtil", "GETLightAppSettingCallBack failed,resultCode=" + j);
          bjkv.a().a(2131691510);
          if (this.a.jdField_a_of_type_Absp != null) {
            this.a.jdField_a_of_type_Absp.a(false);
          }
          if (this.a.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo == null) {
            break label921;
          }
          paramInt = this.a.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId;
          label223:
          if (!this.a.c) {
            break label910;
          }
          absy.a(this.a.jdField_a_of_type_MqqAppAppRuntime, "Net_Get_LiteappSetting", 0, j, paramInt);
          return;
        }
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      try
      {
        paramBundle = paramBundle.getJSONArray("list");
        if (((paramBundle != null) && (paramBundle.length() != 0)) || (!this.a.b)) {
          break label429;
        }
        bjkv.a().a(2131691510);
        if ((this.a.jdField_a_of_type_Bisl != null) && (this.a.jdField_a_of_type_Bisl.isShowing()) && (this.a.jdField_a_of_type_AndroidAppActivity != null) && (!this.a.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
          this.a.jdField_a_of_type_Bisl.dismiss();
        }
        if (this.a.jdField_a_of_type_Absp != null) {
          this.a.jdField_a_of_type_Absp.a(true);
        }
        absy.a(null, "Net_LiteApp_Setting", 0, 1, this.a.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId);
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        bjkv.a().a(2131691510);
      }
      if (this.a.jdField_a_of_type_Absp != null)
      {
        this.a.jdField_a_of_type_Absp.a(false);
        continue;
        label429:
        if (paramBundle != null) {
          paramInt = 0;
        }
      }
    }
    for (;;)
    {
      if (paramInt < paramBundle.length())
      {
        Object localObject1 = paramBundle.getJSONObject(paramInt);
        LightAppSettingInfo localLightAppSettingInfo = new LightAppSettingInfo();
        localLightAppSettingInfo.jdField_c_of_type_Int = ((JSONObject)localObject1).optInt("pid");
        localLightAppSettingInfo.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("template_type");
        localLightAppSettingInfo.jdField_b_of_type_Int = ((JSONObject)localObject1).optInt("has_own_app");
        localLightAppSettingInfo.jdField_d_of_type_JavaLangString = ((JSONObject)localObject1).optString("h5_url");
        localLightAppSettingInfo.jdField_c_of_type_JavaLangString = ((JSONObject)localObject1).optString("public_url");
        localLightAppSettingInfo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("own_appid");
        localLightAppSettingInfo.jdField_d_of_type_Int = ((JSONObject)localObject1).optInt("device_type");
        localLightAppSettingInfo.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("own_pkgname");
        localLightAppSettingInfo.jdField_e_of_type_JavaLangString = ((JSONObject)localObject1).optString("openid");
        localLightAppSettingInfo.f = ((JSONObject)localObject1).optString("openkey");
        localLightAppSettingInfo.g = ((JSONObject)localObject1).optString("appname");
        localLightAppSettingInfo.jdField_e_of_type_Int = ((JSONObject)localObject1).optInt("bindtype", 1);
        Object localObject2 = ((JSONObject)localObject1).optString("pub_propertyids");
        JSONArray localJSONArray = ((JSONObject)localObject1).getJSONArray("config_list");
        localLightAppSettingInfo.jdField_a_of_type_JavaUtilHashMap = this.a.a(localJSONArray);
        localLightAppSettingInfo.h = ((JSONObject)localObject1).optString("comment");
        localObject1 = ((String)localObject2).split(",");
        if (localObject1 != null)
        {
          localObject2 = new ArrayList();
          int k = localObject1.length;
          int i = 0;
          while (i < k)
          {
            ((ArrayList)localObject2).add(Integer.valueOf(localObject1[i]));
            i += 1;
          }
          localLightAppSettingInfo.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject2);
        }
        for (;;)
        {
          if (!absn.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(localLightAppSettingInfo.jdField_c_of_type_Int)))
          {
            absn.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localLightAppSettingInfo.jdField_c_of_type_Int), localLightAppSettingInfo);
            absn.jdField_a_of_type_JavaUtilArrayList.add(localLightAppSettingInfo);
          }
          if ((!this.a.b) || (this.a.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId != localLightAppSettingInfo.jdField_c_of_type_Int)) {
            break;
          }
          this.a.a(this.a.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo, this.a.jdField_a_of_type_AndroidOsBundle, this.a.d);
          break label926;
          bjko.e("LightAppUtil", "no ids!");
        }
        if (this.a.jdField_a_of_type_Absp != null) {
          this.a.jdField_a_of_type_Absp.a(false);
        }
      }
      else
      {
        if ((this.a.c) || (absn.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
          break;
        }
        paramBundle = BaseApplicationImpl.getApplication().getRuntime();
        if (!(paramBundle instanceof QQAppInterface)) {
          break;
        }
        ((abgm)((QQAppInterface)paramBundle).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(absn.jdField_a_of_type_JavaUtilArrayList);
        break;
        label910:
        absy.a(null, "Net_Get_LiteappSetting", 0, j, paramInt);
        return;
        label921:
        paramInt = 0;
        break label223;
      }
      label926:
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abso
 * JD-Core Version:    0.7.0.1
 */