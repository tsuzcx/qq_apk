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

class acsy
{
  private static acta a(byte[] paramArrayOfByte)
  {
    acta localacta = new acta(null);
    localacta.setUrl("https://h5.gdt.qq.com/player/api/form/saveForNative");
    localacta.method = "POST";
    localacta.contentType = "application/json";
    localacta.connectTimeoutMillis = 5000;
    localacta.readTimeoutMillis = 5000;
    localacta.requestData = paramArrayOfByte;
    return localacta;
  }
  
  public static AdFormError a(AdFormData paramAdFormData)
  {
    byte[] arrayOfByte = a(paramAdFormData);
    Object localObject;
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      acqy.d("GdtFormUploadUtil", "upload error");
      localObject = new AdFormError(4, -1, null);
      return localObject;
    }
    AdFormError localAdFormError = new AdFormError(4, -1, null);
    int i = 0;
    for (;;)
    {
      acta localacta;
      if (i < 3)
      {
        localacta = a(arrayOfByte);
        if (localacta != null) {}
      }
      else
      {
        acqy.d("GdtFormUploadUtil", "upload error");
        return localAdFormError;
      }
      AdHttp.send(localacta);
      if (localacta.isSuccess()) {
        localAdFormError = a(paramAdFormData, localacta);
      }
      localObject = localAdFormError;
      if (localacta.a == 0) {
        break;
      }
      localObject = localAdFormError;
      if (localacta.a == 1) {
        break;
      }
      localObject = localAdFormError;
      if (localacta.a == 2) {
        break;
      }
      localObject = localAdFormError;
      if (localacta.a == 4) {
        break;
      }
      i += 1;
    }
  }
  
  private static AdFormError a(AdFormData paramAdFormData, acta paramacta)
  {
    if ((paramAdFormData == null) || (!paramAdFormData.isValid()) || (paramacta == null) || (!paramacta.isSuccess()))
    {
      acqy.d("GdtFormUploadUtil", "commit error");
      paramacta = new AdFormError(4, -1, null);
      return paramacta;
    }
    Object localObject1;
    try
    {
      localObject2 = new JSONObject(new String(paramacta.responseData, "UTF-8"));
      paramacta.a = ((JSONObject)localObject2).getInt("code");
      localObject1 = ((JSONObject)localObject2).optString("message");
      acqy.b("GdtFormUploadUtil", "parseResponse code:" + paramacta.a + " message:" + (String)localObject1);
      if (paramacta.a == 0)
      {
        paramAdFormData = new AdFormError(1, -1, null);
        return paramAdFormData;
      }
    }
    catch (UnsupportedEncodingException paramAdFormData)
    {
      acqy.d("GdtFormUploadUtil", "parseResponse", paramAdFormData);
      return new AdFormError(4, -1, null);
      if (paramacta.a != 1) {
        break label452;
      }
      localObject1 = new AdFormError(4, -1, null);
      paramacta = ((JSONObject)localObject2).getJSONObject("data");
      if ((paramacta == null) || (JSONObject.NULL.equals(paramacta)))
      {
        acqy.d("GdtFormUploadUtil", "parseResponse error");
        return localObject1;
      }
    }
    catch (JSONException paramAdFormData)
    {
      acqy.d("GdtFormUploadUtil", "parseResponse", paramAdFormData);
      return new AdFormError(4, -1, null);
    }
    Object localObject2 = paramacta.getJSONArray("items");
    if (((JSONArray)localObject2).length() != paramAdFormData.table.getSize())
    {
      acqy.d("GdtFormUploadUtil", "parseResponse error");
      return localObject1;
    }
    for (;;)
    {
      paramacta = (acta)localObject1;
      int i;
      if (i >= ((JSONArray)localObject2).length()) {
        break;
      }
      paramacta = paramAdFormData.table.getItem(i);
      if ((paramacta == null) || (!paramacta.isValid()))
      {
        acqy.d("GdtFormUploadUtil", "parseResponse error");
        return new AdFormError(4, -1, null);
      }
      JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
      if ((localJSONObject == null) || (JSONObject.NULL.equals(localJSONObject)))
      {
        acqy.d("GdtFormUploadUtil", "parseResponse error");
        return new AdFormError(4, i, paramacta.title.text);
      }
      int j = localJSONObject.getInt("errorCode");
      if (j == 0)
      {
        i += 1;
      }
      else
      {
        if (j == 1) {
          return new AdFormError(5, i, paramacta.title.text);
        }
        if (j == 2) {
          return new AdFormError(6, i, paramacta.title.text);
        }
        acqy.d("GdtFormUploadUtil", "parseResponse error");
        return new AdFormError(4, i, paramacta.title.text);
        label452:
        if (paramacta.a == 3) {
          return new AdFormError(4, -1, null);
        }
        if (paramacta.a == 4) {
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
      acqy.d("GdtFormUploadUtil", "toJson error");
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    if (i < paramAdFormData.table.getSize())
    {
      Object localObject = paramAdFormData.table.getItem(i);
      if ((localObject == null) || (!((AdFormItemData)localObject).isValid())) {
        acqy.d("GdtFormUploadUtil", "toJson error");
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
          acqy.d("GdtFormUploadUtil", "toJson", localJSONException);
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
      acqy.d("GdtFormUploadUtil", "getRequestData error");
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
        acqy.d("GdtFormUploadUtil", "getRequestData", paramAdFormData);
        return null;
      }
      catch (UnsupportedEncodingException paramAdFormData)
      {
        acqy.d("GdtFormUploadUtil", "getRequestData", paramAdFormData);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acsy
 * JD-Core Version:    0.7.0.1
 */