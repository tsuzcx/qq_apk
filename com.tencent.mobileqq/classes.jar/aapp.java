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

class aapp
{
  private static aapr a(byte[] paramArrayOfByte)
  {
    aapr localaapr = new aapr(null);
    localaapr.setUrl("https://h5.gdt.qq.com/player/api/form/saveForNative");
    localaapr.method = "POST";
    localaapr.contentType = "application/json";
    localaapr.connectTimeoutMillis = 5000;
    localaapr.readTimeoutMillis = 5000;
    localaapr.requestData = paramArrayOfByte;
    return localaapr;
  }
  
  public static AdFormError a(AdFormData paramAdFormData)
  {
    byte[] arrayOfByte = a(paramAdFormData);
    Object localObject;
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      aanp.d("GdtFormUploadUtil", "upload error");
      localObject = new AdFormError(4, -1, null);
      return localObject;
    }
    AdFormError localAdFormError = new AdFormError(4, -1, null);
    int i = 0;
    for (;;)
    {
      aapr localaapr;
      if (i < 3)
      {
        localaapr = a(arrayOfByte);
        if (localaapr != null) {}
      }
      else
      {
        aanp.d("GdtFormUploadUtil", "upload error");
        return localAdFormError;
      }
      AdHttp.send(localaapr);
      if (localaapr.isSuccess()) {
        localAdFormError = a(paramAdFormData, localaapr);
      }
      localObject = localAdFormError;
      if (localaapr.a == 0) {
        break;
      }
      localObject = localAdFormError;
      if (localaapr.a == 1) {
        break;
      }
      localObject = localAdFormError;
      if (localaapr.a == 2) {
        break;
      }
      localObject = localAdFormError;
      if (localaapr.a == 4) {
        break;
      }
      i += 1;
    }
  }
  
  private static AdFormError a(AdFormData paramAdFormData, aapr paramaapr)
  {
    if ((paramAdFormData == null) || (!paramAdFormData.isValid()) || (paramaapr == null) || (!paramaapr.isSuccess()))
    {
      aanp.d("GdtFormUploadUtil", "commit error");
      paramaapr = new AdFormError(4, -1, null);
      return paramaapr;
    }
    Object localObject1;
    try
    {
      localObject2 = new JSONObject(new String(paramaapr.responseData, "UTF-8"));
      paramaapr.a = ((JSONObject)localObject2).getInt("code");
      localObject1 = ((JSONObject)localObject2).optString("message");
      aanp.b("GdtFormUploadUtil", "parseResponse code:" + paramaapr.a + " message:" + (String)localObject1);
      if (paramaapr.a == 0)
      {
        paramAdFormData = new AdFormError(1, -1, null);
        return paramAdFormData;
      }
    }
    catch (UnsupportedEncodingException paramAdFormData)
    {
      aanp.d("GdtFormUploadUtil", "parseResponse", paramAdFormData);
      return new AdFormError(4, -1, null);
      if (paramaapr.a != 1) {
        break label446;
      }
      localObject1 = new AdFormError(4, -1, null);
      paramaapr = ((JSONObject)localObject2).getJSONObject("data");
      if ((paramaapr == null) || (paramaapr == JSONObject.NULL))
      {
        aanp.d("GdtFormUploadUtil", "parseResponse error");
        return localObject1;
      }
    }
    catch (JSONException paramAdFormData)
    {
      aanp.d("GdtFormUploadUtil", "parseResponse", paramAdFormData);
      return new AdFormError(4, -1, null);
    }
    Object localObject2 = paramaapr.getJSONArray("items");
    if (((JSONArray)localObject2).length() != paramAdFormData.table.getSize())
    {
      aanp.d("GdtFormUploadUtil", "parseResponse error");
      return localObject1;
    }
    for (;;)
    {
      paramaapr = (aapr)localObject1;
      int i;
      if (i >= ((JSONArray)localObject2).length()) {
        break;
      }
      paramaapr = paramAdFormData.table.getItem(i);
      if ((paramaapr == null) || (!paramaapr.isValid()))
      {
        aanp.d("GdtFormUploadUtil", "parseResponse error");
        return new AdFormError(4, -1, null);
      }
      JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
      if ((localJSONObject == null) || (localJSONObject == JSONObject.NULL))
      {
        aanp.d("GdtFormUploadUtil", "parseResponse error");
        return new AdFormError(4, i, paramaapr.title.text);
      }
      int j = localJSONObject.getInt("errorCode");
      if (j == 0)
      {
        i += 1;
      }
      else
      {
        if (j == 1) {
          return new AdFormError(5, i, paramaapr.title.text);
        }
        if (j == 2) {
          return new AdFormError(6, i, paramaapr.title.text);
        }
        aanp.d("GdtFormUploadUtil", "parseResponse error");
        return new AdFormError(4, i, paramaapr.title.text);
        label446:
        if (paramaapr.a == 3) {
          return new AdFormError(4, -1, null);
        }
        if (paramaapr.a == 4) {
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
      aanp.d("GdtFormUploadUtil", "toJson error");
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    if (i < paramAdFormData.table.getSize())
    {
      Object localObject = paramAdFormData.table.getItem(i);
      if ((localObject == null) || (!((AdFormItemData)localObject).isValid())) {
        aanp.d("GdtFormUploadUtil", "toJson error");
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
          aanp.d("GdtFormUploadUtil", "toJson", localJSONException);
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
      aanp.d("GdtFormUploadUtil", "getRequestData error");
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
        aanp.d("GdtFormUploadUtil", "getRequestData", paramAdFormData);
        return null;
      }
      catch (UnsupportedEncodingException paramAdFormData)
      {
        aanp.d("GdtFormUploadUtil", "getRequestData", paramAdFormData);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapp
 * JD-Core Version:    0.7.0.1
 */