import android.text.TextUtils;
import com.tencent.ad.tangram.canvas.views.form.AdFormData;
import com.tencent.ad.tangram.canvas.views.form.AdFormError;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormItemData;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormTableData;
import com.tencent.ad.tangram.canvas.views.xijing.AdTextData;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.gdtad.views.form.textbox.GdtFormItemTextBoxData;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class abtl
{
  private static abtn a(byte[] paramArrayOfByte)
  {
    abtn localabtn = new abtn(null);
    localabtn.setUrl("https://h5.gdt.qq.com/player/api/form/saveForNative");
    localabtn.method = "POST";
    localabtn.contentType = "application/json";
    localabtn.connectTimeoutMillis = 5000;
    localabtn.readTimeoutMillis = 5000;
    localabtn.requestData = paramArrayOfByte;
    return localabtn;
  }
  
  public static AdFormError a(AdFormData paramAdFormData)
  {
    byte[] arrayOfByte = a(paramAdFormData);
    Object localObject;
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      abrl.d("GdtFormUploadUtil", "upload error");
      localObject = new AdFormError(4, -1, null);
      return localObject;
    }
    AdFormError localAdFormError = new AdFormError(4, -1, null);
    int i = 0;
    for (;;)
    {
      abtn localabtn;
      if (i < 3)
      {
        localabtn = a(arrayOfByte);
        if (localabtn != null) {}
      }
      else
      {
        abrl.d("GdtFormUploadUtil", "upload error");
        return localAdFormError;
      }
      AdHttp.send(localabtn);
      if (localabtn.isSuccess()) {
        localAdFormError = a(paramAdFormData, localabtn);
      }
      localObject = localAdFormError;
      if (localabtn.a == 0) {
        break;
      }
      localObject = localAdFormError;
      if (localabtn.a == 1) {
        break;
      }
      localObject = localAdFormError;
      if (localabtn.a == 2) {
        break;
      }
      localObject = localAdFormError;
      if (localabtn.a == 4) {
        break;
      }
      i += 1;
    }
  }
  
  private static AdFormError a(AdFormData paramAdFormData, abtn paramabtn)
  {
    if ((paramAdFormData == null) || (!paramAdFormData.isValid()) || (paramabtn == null) || (!paramabtn.isSuccess()))
    {
      abrl.d("GdtFormUploadUtil", "commit error");
      paramabtn = new AdFormError(4, -1, null);
      return paramabtn;
    }
    Object localObject1;
    try
    {
      localObject2 = new JSONObject(new String(paramabtn.responseData, "UTF-8"));
      paramabtn.a = ((JSONObject)localObject2).getInt("code");
      localObject1 = ((JSONObject)localObject2).optString("message");
      abrl.b("GdtFormUploadUtil", "parseResponse code:" + paramabtn.a + " message:" + (String)localObject1);
      if (paramabtn.a == 0)
      {
        paramAdFormData = new AdFormError(1, -1, null);
        return paramAdFormData;
      }
    }
    catch (UnsupportedEncodingException paramAdFormData)
    {
      abrl.d("GdtFormUploadUtil", "parseResponse", paramAdFormData);
      return new AdFormError(4, -1, null);
      if (paramabtn.a != 1) {
        break label452;
      }
      localObject1 = new AdFormError(4, -1, null);
      paramabtn = ((JSONObject)localObject2).getJSONObject("data");
      if ((paramabtn == null) || (JSONObject.NULL.equals(paramabtn)))
      {
        abrl.d("GdtFormUploadUtil", "parseResponse error");
        return localObject1;
      }
    }
    catch (JSONException paramAdFormData)
    {
      abrl.d("GdtFormUploadUtil", "parseResponse", paramAdFormData);
      return new AdFormError(4, -1, null);
    }
    Object localObject2 = paramabtn.getJSONArray("items");
    if (((JSONArray)localObject2).length() != paramAdFormData.table.getSize())
    {
      abrl.d("GdtFormUploadUtil", "parseResponse error");
      return localObject1;
    }
    for (;;)
    {
      paramabtn = (abtn)localObject1;
      int i;
      if (i >= ((JSONArray)localObject2).length()) {
        break;
      }
      paramabtn = paramAdFormData.table.getItem(i);
      if ((paramabtn == null) || (!paramabtn.isValid()))
      {
        abrl.d("GdtFormUploadUtil", "parseResponse error");
        return new AdFormError(4, -1, null);
      }
      JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
      if ((localJSONObject == null) || (JSONObject.NULL.equals(localJSONObject)))
      {
        abrl.d("GdtFormUploadUtil", "parseResponse error");
        return new AdFormError(4, i, paramabtn.title.text);
      }
      int j = localJSONObject.getInt("errorCode");
      if (j == 0)
      {
        i += 1;
      }
      else
      {
        if (j == 1) {
          return new AdFormError(5, i, paramabtn.title.text);
        }
        if (j == 2) {
          return new AdFormError(6, i, paramabtn.title.text);
        }
        abrl.d("GdtFormUploadUtil", "parseResponse error");
        return new AdFormError(4, i, paramabtn.title.text);
        label452:
        if (paramabtn.a == 3) {
          return new AdFormError(4, -1, null);
        }
        if (paramabtn.a == 4) {
          return new AdFormError(7, -1, null);
        }
        paramAdFormData = new AdFormError(4, -1, null);
        return paramAdFormData;
        i = 0;
      }
    }
  }
  
  public static JSONArray a(AdFormData paramAdFormData)
  {
    if ((paramAdFormData == null) || (!paramAdFormData.isValid()))
    {
      abrl.d("GdtFormUploadUtil", "toJson error");
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    if (i < paramAdFormData.table.getSize())
    {
      Object localObject = paramAdFormData.table.getItem(i);
      if ((localObject == null) || (!((AdFormItemData)localObject).isValid())) {
        abrl.d("GdtFormUploadUtil", "toJson error");
      }
      for (;;)
      {
        i += 1;
        break;
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("name", ((AdFormItemData)localObject).title.text);
          localJSONObject.put("require", ((AdFormItemData)localObject).required);
          if ((localObject instanceof GdtFormItemTextBoxData))
          {
            localObject = (GdtFormItemTextBoxData)GdtFormItemTextBoxData.class.cast(localObject);
            localJSONObject.put("regexType", ((GdtFormItemTextBoxData)localObject).regexType);
            localJSONObject.put("value", ((GdtFormItemTextBoxData)localObject).getResult());
          }
          localJSONArray.put(i, localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          abrl.d("GdtFormUploadUtil", "toJson", localJSONException);
        }
      }
    }
    return localJSONArray;
  }
  
  private static byte[] a(AdFormData paramAdFormData)
  {
    JSONArray localJSONArray = a(paramAdFormData);
    if ((paramAdFormData == null) || (!paramAdFormData.isValid()) || (localJSONArray == null) || (JSONObject.NULL.equals(localJSONArray)))
    {
      abrl.d("GdtFormUploadUtil", "getRequestData error");
      return null;
    }
    if (TextUtils.isEmpty(paramAdFormData.tokenForUpload)) {}
    for (String str = "";; str = paramAdFormData.tokenForUpload) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("token", str);
        localJSONObject.put("formId", paramAdFormData.formId);
        localJSONObject.put("formValue", localJSONArray.toString());
        paramAdFormData = localJSONObject.toString().getBytes("UTF-8");
        return paramAdFormData;
      }
      catch (JSONException paramAdFormData)
      {
        abrl.d("GdtFormUploadUtil", "getRequestData", paramAdFormData);
        return null;
      }
      catch (UnsupportedEncodingException paramAdFormData)
      {
        abrl.d("GdtFormUploadUtil", "getRequestData", paramAdFormData);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abtl
 * JD-Core Version:    0.7.0.1
 */