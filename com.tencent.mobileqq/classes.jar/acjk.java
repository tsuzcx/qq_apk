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

class acjk
{
  private static acjm a(byte[] paramArrayOfByte)
  {
    acjm localacjm = new acjm(null);
    localacjm.setUrl("https://h5.gdt.qq.com/player/api/form/saveForNative");
    localacjm.method = "POST";
    localacjm.contentType = "application/json";
    localacjm.connectTimeoutMillis = 5000;
    localacjm.readTimeoutMillis = 5000;
    localacjm.requestData = paramArrayOfByte;
    return localacjm;
  }
  
  public static AdFormError a(AdFormData paramAdFormData)
  {
    byte[] arrayOfByte = a(paramAdFormData);
    Object localObject;
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      acho.d("GdtFormUploadUtil", "upload error");
      localObject = new AdFormError(4, -1, null);
      return localObject;
    }
    AdFormError localAdFormError = new AdFormError(4, -1, null);
    int i = 0;
    for (;;)
    {
      acjm localacjm;
      if (i < 3)
      {
        localacjm = a(arrayOfByte);
        if (localacjm != null) {}
      }
      else
      {
        acho.d("GdtFormUploadUtil", "upload error");
        return localAdFormError;
      }
      AdHttp.send(localacjm);
      if (localacjm.isSuccess()) {
        localAdFormError = a(paramAdFormData, localacjm);
      }
      localObject = localAdFormError;
      if (localacjm.a == 0) {
        break;
      }
      localObject = localAdFormError;
      if (localacjm.a == 1) {
        break;
      }
      localObject = localAdFormError;
      if (localacjm.a == 2) {
        break;
      }
      localObject = localAdFormError;
      if (localacjm.a == 4) {
        break;
      }
      i += 1;
    }
  }
  
  private static AdFormError a(AdFormData paramAdFormData, acjm paramacjm)
  {
    if ((paramAdFormData == null) || (!paramAdFormData.isValid()) || (paramacjm == null) || (!paramacjm.isSuccess()))
    {
      acho.d("GdtFormUploadUtil", "commit error");
      paramacjm = new AdFormError(4, -1, null);
      return paramacjm;
    }
    Object localObject1;
    try
    {
      localObject2 = new JSONObject(new String(paramacjm.responseData, "UTF-8"));
      paramacjm.a = ((JSONObject)localObject2).getInt("code");
      localObject1 = ((JSONObject)localObject2).optString("message");
      acho.b("GdtFormUploadUtil", "parseResponse code:" + paramacjm.a + " message:" + (String)localObject1);
      if (paramacjm.a == 0)
      {
        paramAdFormData = new AdFormError(1, -1, null);
        return paramAdFormData;
      }
    }
    catch (UnsupportedEncodingException paramAdFormData)
    {
      acho.d("GdtFormUploadUtil", "parseResponse", paramAdFormData);
      return new AdFormError(4, -1, null);
      if (paramacjm.a != 1) {
        break label452;
      }
      localObject1 = new AdFormError(4, -1, null);
      paramacjm = ((JSONObject)localObject2).getJSONObject("data");
      if ((paramacjm == null) || (JSONObject.NULL.equals(paramacjm)))
      {
        acho.d("GdtFormUploadUtil", "parseResponse error");
        return localObject1;
      }
    }
    catch (JSONException paramAdFormData)
    {
      acho.d("GdtFormUploadUtil", "parseResponse", paramAdFormData);
      return new AdFormError(4, -1, null);
    }
    Object localObject2 = paramacjm.getJSONArray("items");
    if (((JSONArray)localObject2).length() != paramAdFormData.table.getSize())
    {
      acho.d("GdtFormUploadUtil", "parseResponse error");
      return localObject1;
    }
    for (;;)
    {
      paramacjm = (acjm)localObject1;
      int i;
      if (i >= ((JSONArray)localObject2).length()) {
        break;
      }
      paramacjm = paramAdFormData.table.getItem(i);
      if ((paramacjm == null) || (!paramacjm.isValid()))
      {
        acho.d("GdtFormUploadUtil", "parseResponse error");
        return new AdFormError(4, -1, null);
      }
      JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
      if ((localJSONObject == null) || (JSONObject.NULL.equals(localJSONObject)))
      {
        acho.d("GdtFormUploadUtil", "parseResponse error");
        return new AdFormError(4, i, paramacjm.title.text);
      }
      int j = localJSONObject.getInt("errorCode");
      if (j == 0)
      {
        i += 1;
      }
      else
      {
        if (j == 1) {
          return new AdFormError(5, i, paramacjm.title.text);
        }
        if (j == 2) {
          return new AdFormError(6, i, paramacjm.title.text);
        }
        acho.d("GdtFormUploadUtil", "parseResponse error");
        return new AdFormError(4, i, paramacjm.title.text);
        label452:
        if (paramacjm.a == 3) {
          return new AdFormError(4, -1, null);
        }
        if (paramacjm.a == 4) {
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
      acho.d("GdtFormUploadUtil", "toJson error");
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    if (i < paramAdFormData.table.getSize())
    {
      Object localObject = paramAdFormData.table.getItem(i);
      if ((localObject == null) || (!((AdFormItemData)localObject).isValid())) {
        acho.d("GdtFormUploadUtil", "toJson error");
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
          acho.d("GdtFormUploadUtil", "toJson", localJSONException);
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
      acho.d("GdtFormUploadUtil", "getRequestData error");
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
        acho.d("GdtFormUploadUtil", "getRequestData", paramAdFormData);
        return null;
      }
      catch (UnsupportedEncodingException paramAdFormData)
      {
        acho.d("GdtFormUploadUtil", "getRequestData", paramAdFormData);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acjk
 * JD-Core Version:    0.7.0.1
 */