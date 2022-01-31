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

class aaue
{
  private static aaug a(byte[] paramArrayOfByte)
  {
    aaug localaaug = new aaug(null);
    localaaug.setUrl("https://h5.gdt.qq.com/player/api/form/saveForNative");
    localaaug.method = "POST";
    localaaug.contentType = "application/json";
    localaaug.connectTimeoutMillis = 5000;
    localaaug.readTimeoutMillis = 5000;
    localaaug.requestData = paramArrayOfByte;
    return localaaug;
  }
  
  public static AdFormError a(AdFormData paramAdFormData)
  {
    byte[] arrayOfByte = a(paramAdFormData);
    Object localObject;
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      aase.d("GdtFormUploadUtil", "upload error");
      localObject = new AdFormError(4, -1, null);
      return localObject;
    }
    AdFormError localAdFormError = new AdFormError(4, -1, null);
    int i = 0;
    for (;;)
    {
      aaug localaaug;
      if (i < 3)
      {
        localaaug = a(arrayOfByte);
        if (localaaug != null) {}
      }
      else
      {
        aase.d("GdtFormUploadUtil", "upload error");
        return localAdFormError;
      }
      AdHttp.send(localaaug);
      if (localaaug.isSuccess()) {
        localAdFormError = a(paramAdFormData, localaaug);
      }
      localObject = localAdFormError;
      if (localaaug.a == 0) {
        break;
      }
      localObject = localAdFormError;
      if (localaaug.a == 1) {
        break;
      }
      localObject = localAdFormError;
      if (localaaug.a == 2) {
        break;
      }
      localObject = localAdFormError;
      if (localaaug.a == 4) {
        break;
      }
      i += 1;
    }
  }
  
  private static AdFormError a(AdFormData paramAdFormData, aaug paramaaug)
  {
    if ((paramAdFormData == null) || (!paramAdFormData.isValid()) || (paramaaug == null) || (!paramaaug.isSuccess()))
    {
      aase.d("GdtFormUploadUtil", "commit error");
      paramaaug = new AdFormError(4, -1, null);
      return paramaaug;
    }
    Object localObject1;
    try
    {
      localObject2 = new JSONObject(new String(paramaaug.responseData, "UTF-8"));
      paramaaug.a = ((JSONObject)localObject2).getInt("code");
      localObject1 = ((JSONObject)localObject2).optString("message");
      aase.b("GdtFormUploadUtil", "parseResponse code:" + paramaaug.a + " message:" + (String)localObject1);
      if (paramaaug.a == 0)
      {
        paramAdFormData = new AdFormError(1, -1, null);
        return paramAdFormData;
      }
    }
    catch (UnsupportedEncodingException paramAdFormData)
    {
      aase.d("GdtFormUploadUtil", "parseResponse", paramAdFormData);
      return new AdFormError(4, -1, null);
      if (paramaaug.a != 1) {
        break label446;
      }
      localObject1 = new AdFormError(4, -1, null);
      paramaaug = ((JSONObject)localObject2).getJSONObject("data");
      if ((paramaaug == null) || (paramaaug == JSONObject.NULL))
      {
        aase.d("GdtFormUploadUtil", "parseResponse error");
        return localObject1;
      }
    }
    catch (JSONException paramAdFormData)
    {
      aase.d("GdtFormUploadUtil", "parseResponse", paramAdFormData);
      return new AdFormError(4, -1, null);
    }
    Object localObject2 = paramaaug.getJSONArray("items");
    if (((JSONArray)localObject2).length() != paramAdFormData.table.getSize())
    {
      aase.d("GdtFormUploadUtil", "parseResponse error");
      return localObject1;
    }
    for (;;)
    {
      paramaaug = (aaug)localObject1;
      int i;
      if (i >= ((JSONArray)localObject2).length()) {
        break;
      }
      paramaaug = paramAdFormData.table.getItem(i);
      if ((paramaaug == null) || (!paramaaug.isValid()))
      {
        aase.d("GdtFormUploadUtil", "parseResponse error");
        return new AdFormError(4, -1, null);
      }
      JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
      if ((localJSONObject == null) || (localJSONObject == JSONObject.NULL))
      {
        aase.d("GdtFormUploadUtil", "parseResponse error");
        return new AdFormError(4, i, paramaaug.title.text);
      }
      int j = localJSONObject.getInt("errorCode");
      if (j == 0)
      {
        i += 1;
      }
      else
      {
        if (j == 1) {
          return new AdFormError(5, i, paramaaug.title.text);
        }
        if (j == 2) {
          return new AdFormError(6, i, paramaaug.title.text);
        }
        aase.d("GdtFormUploadUtil", "parseResponse error");
        return new AdFormError(4, i, paramaaug.title.text);
        label446:
        if (paramaaug.a == 3) {
          return new AdFormError(4, -1, null);
        }
        if (paramaaug.a == 4) {
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
      aase.d("GdtFormUploadUtil", "toJson error");
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    if (i < paramAdFormData.table.getSize())
    {
      Object localObject = paramAdFormData.table.getItem(i);
      if ((localObject == null) || (!((AdFormItemData)localObject).isValid())) {
        aase.d("GdtFormUploadUtil", "toJson error");
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
          aase.d("GdtFormUploadUtil", "toJson", localJSONException);
        }
      }
    }
    return localJSONArray;
  }
  
  private static byte[] a(AdFormData paramAdFormData)
  {
    JSONArray localJSONArray = a(paramAdFormData);
    if ((paramAdFormData == null) || (!paramAdFormData.isValid()) || (localJSONArray == null) || (localJSONArray == JSONObject.NULL))
    {
      aase.d("GdtFormUploadUtil", "getRequestData error");
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
        aase.d("GdtFormUploadUtil", "getRequestData", paramAdFormData);
        return null;
      }
      catch (UnsupportedEncodingException paramAdFormData)
      {
        aase.d("GdtFormUploadUtil", "getRequestData", paramAdFormData);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaue
 * JD-Core Version:    0.7.0.1
 */