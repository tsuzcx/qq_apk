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

class acxc
{
  private static acxe a(byte[] paramArrayOfByte)
  {
    acxe localacxe = new acxe(null);
    localacxe.setUrl("https://h5.gdt.qq.com/player/api/form/saveForNative");
    localacxe.method = "POST";
    localacxe.contentType = "application/json";
    localacxe.connectTimeoutMillis = 5000;
    localacxe.readTimeoutMillis = 5000;
    localacxe.requestData = paramArrayOfByte;
    return localacxe;
  }
  
  public static AdFormError a(AdFormData paramAdFormData)
  {
    byte[] arrayOfByte = a(paramAdFormData);
    Object localObject;
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      acvc.d("GdtFormUploadUtil", "upload error");
      localObject = new AdFormError(4, -1, null);
      return localObject;
    }
    AdFormError localAdFormError = new AdFormError(4, -1, null);
    int i = 0;
    for (;;)
    {
      acxe localacxe;
      if (i < 3)
      {
        localacxe = a(arrayOfByte);
        if (localacxe != null) {}
      }
      else
      {
        acvc.d("GdtFormUploadUtil", "upload error");
        return localAdFormError;
      }
      AdHttp.send(localacxe);
      if (localacxe.isSuccess()) {
        localAdFormError = a(paramAdFormData, localacxe);
      }
      localObject = localAdFormError;
      if (localacxe.a == 0) {
        break;
      }
      localObject = localAdFormError;
      if (localacxe.a == 1) {
        break;
      }
      localObject = localAdFormError;
      if (localacxe.a == 2) {
        break;
      }
      localObject = localAdFormError;
      if (localacxe.a == 4) {
        break;
      }
      i += 1;
    }
  }
  
  private static AdFormError a(AdFormData paramAdFormData, acxe paramacxe)
  {
    if ((paramAdFormData == null) || (!paramAdFormData.isValid()) || (paramacxe == null) || (!paramacxe.isSuccess()))
    {
      acvc.d("GdtFormUploadUtil", "commit error");
      paramacxe = new AdFormError(4, -1, null);
      return paramacxe;
    }
    Object localObject1;
    try
    {
      localObject2 = new JSONObject(new String(paramacxe.responseData, "UTF-8"));
      paramacxe.a = ((JSONObject)localObject2).getInt("code");
      localObject1 = ((JSONObject)localObject2).optString("message");
      acvc.b("GdtFormUploadUtil", "parseResponse code:" + paramacxe.a + " message:" + (String)localObject1);
      if (paramacxe.a == 0)
      {
        paramAdFormData = new AdFormError(1, -1, null);
        return paramAdFormData;
      }
    }
    catch (UnsupportedEncodingException paramAdFormData)
    {
      acvc.d("GdtFormUploadUtil", "parseResponse", paramAdFormData);
      return new AdFormError(4, -1, null);
      if (paramacxe.a != 1) {
        break label452;
      }
      localObject1 = new AdFormError(4, -1, null);
      paramacxe = ((JSONObject)localObject2).getJSONObject("data");
      if ((paramacxe == null) || (JSONObject.NULL.equals(paramacxe)))
      {
        acvc.d("GdtFormUploadUtil", "parseResponse error");
        return localObject1;
      }
    }
    catch (JSONException paramAdFormData)
    {
      acvc.d("GdtFormUploadUtil", "parseResponse", paramAdFormData);
      return new AdFormError(4, -1, null);
    }
    Object localObject2 = paramacxe.getJSONArray("items");
    if (((JSONArray)localObject2).length() != paramAdFormData.table.getSize())
    {
      acvc.d("GdtFormUploadUtil", "parseResponse error");
      return localObject1;
    }
    for (;;)
    {
      paramacxe = (acxe)localObject1;
      int i;
      if (i >= ((JSONArray)localObject2).length()) {
        break;
      }
      paramacxe = paramAdFormData.table.getItem(i);
      if ((paramacxe == null) || (!paramacxe.isValid()))
      {
        acvc.d("GdtFormUploadUtil", "parseResponse error");
        return new AdFormError(4, -1, null);
      }
      JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
      if ((localJSONObject == null) || (JSONObject.NULL.equals(localJSONObject)))
      {
        acvc.d("GdtFormUploadUtil", "parseResponse error");
        return new AdFormError(4, i, paramacxe.title.text);
      }
      int j = localJSONObject.getInt("errorCode");
      if (j == 0)
      {
        i += 1;
      }
      else
      {
        if (j == 1) {
          return new AdFormError(5, i, paramacxe.title.text);
        }
        if (j == 2) {
          return new AdFormError(6, i, paramacxe.title.text);
        }
        acvc.d("GdtFormUploadUtil", "parseResponse error");
        return new AdFormError(4, i, paramacxe.title.text);
        label452:
        if (paramacxe.a == 3) {
          return new AdFormError(4, -1, null);
        }
        if (paramacxe.a == 4) {
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
      acvc.d("GdtFormUploadUtil", "toJson error");
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    if (i < paramAdFormData.table.getSize())
    {
      Object localObject = paramAdFormData.table.getItem(i);
      if ((localObject == null) || (!((AdFormItemData)localObject).isValid())) {
        acvc.d("GdtFormUploadUtil", "toJson error");
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
          acvc.d("GdtFormUploadUtil", "toJson", localJSONException);
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
      acvc.d("GdtFormUploadUtil", "getRequestData error");
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
        acvc.d("GdtFormUploadUtil", "getRequestData", paramAdFormData);
        return null;
      }
      catch (UnsupportedEncodingException paramAdFormData)
      {
        acvc.d("GdtFormUploadUtil", "getRequestData", paramAdFormData);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acxc
 * JD-Core Version:    0.7.0.1
 */