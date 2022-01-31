import android.text.TextUtils;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ambq
  implements alzn<String>
{
  public String a;
  public HashMap<String, ArrayList<String>> a;
  public boolean a;
  public String b;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  
  public ambq()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public String a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null)
    {
      QLog.e("DialogConfig", 1, "getArkStringConfig, json is empty");
      return "";
    }
    paramJSONObject = paramJSONObject.optString(paramString);
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      QLog.i("DialogConfig", 1, String.format("getArkStringConfig, " + paramString + "=%s", new Object[] { paramJSONObject }));
      return paramJSONObject;
    }
    QLog.i("DialogConfig", 1, "getArkStringConfig, " + paramString + " is empty");
    return "";
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ArkAppCenter.c("DialogConfig", "onParse,fileOrRes is null");
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        this.jdField_a_of_type_Boolean = a(localJSONObject, "ark_map_transfer_struct");
        this.jdField_b_of_type_JavaLangString = a(localJSONObject, "business_percent");
        if (localJSONObject.optInt("ark_use_android_http", 0) == 0) {
          break label428;
        }
        bool = true;
        this.jdField_b_of_type_Boolean = bool;
        this.c = a(localJSONObject, "ark_support_android9_emoji");
        this.d = a(localJSONObject, "ark_engine_multi_thread");
        this.jdField_a_of_type_JavaLangString = a(localJSONObject, "ark_engine_hardware_rendering_device_matcher");
        this.e = a(localJSONObject, "ark_engine_disable_hardware_rendering");
        QLog.i("DialogConfig", 1, "mArkMapTransferStruct=" + this.jdField_a_of_type_Boolean + ", mBusinessPercent=" + this.jdField_b_of_type_JavaLangString + ", mArkUseAndroidHttp=" + this.jdField_b_of_type_Boolean + ", mArkAndroid9EmojiFeatureSupport=" + this.c + ", mArkEngineMultiThread" + this.d + ", mArkEngineHardwareRenderingDeviceMatcher=" + this.jdField_a_of_type_JavaLangString + ", mArkEngineDisableHardwareRendering=" + this.e);
        localJSONObject = localJSONObject.optJSONObject("msgai_intent_app_map");
        if (localJSONObject == null) {
          break;
        }
        Iterator localIterator = localJSONObject.keys();
        if (!localIterator.hasNext()) {
          break;
        }
        String str1 = (String)localIterator.next();
        QLog.i("DialogConfig", 1, "msgai_intent_app_map, intent = " + str1);
        JSONArray localJSONArray = localJSONObject.optJSONArray(str1);
        if (localJSONArray == null) {
          continue;
        }
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        if (i < localJSONArray.length())
        {
          String str2 = localJSONArray.optString(i);
          QLog.i("DialogConfig", 1, "msgai_intent_app_map, appID = " + str2);
          if (!TextUtils.isEmpty(str2)) {
            localArrayList.add(str2);
          }
        }
        else
        {
          if (localArrayList.isEmpty()) {
            continue;
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(str1, localArrayList);
          continue;
        }
        i += 1;
      }
      catch (JSONException localJSONException)
      {
        QLog.e("DialogConfig", 1, String.format("updateDialogConfig, parse json fail, json=%s, err=%s", new Object[] { paramString, localJSONException.getMessage() }));
        return;
      }
      continue;
      label428:
      boolean bool = false;
    }
  }
  
  public boolean a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null)
    {
      QLog.e("DialogConfig", 1, "getArkBoolConfig, dictConfigJsonString is empty");
      return false;
    }
    paramJSONObject = paramJSONObject.optString(paramString);
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      QLog.i("DialogConfig", 1, String.format("getArkBoolConfig, " + paramString + "=%s", new Object[] { paramJSONObject }));
      return paramJSONObject.equals("true");
    }
    QLog.i("DialogConfig", 1, "getArkBoolConfig, " + paramString + " is empty");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ambq
 * JD-Core Version:    0.7.0.1
 */