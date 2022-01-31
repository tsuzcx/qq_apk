import com.tencent.ad.tangram.canvas.views.form.AdFormData;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormItemData;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormTableData;
import com.tencent.ad.tangram.canvas.views.xijing.AdTextData;
import com.tencent.ad.tangram.canvas.views.xijing.a;
import com.tencent.gdtad.views.form.textbox.GdtFormItemTextBoxData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aapg
{
  public static AdFormData a(JSONObject paramJSONObject, int paramInt)
  {
    int i = 0;
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      aanp.d("AdFormDataBuilder", "getFormComponent error");
      return null;
    }
    AdFormData localAdFormData = new AdFormData();
    Object localObject;
    try
    {
      localAdFormData.formId = paramJSONObject.getLong("formId");
      localAdFormData.padding = aapa.b(paramInt, 60);
      localAdFormData.backgroundColor = aapa.a(paramJSONObject.getString("backgroundColor"), 0);
      localObject = paramJSONObject.getJSONObject("title");
      if (((JSONObject)localObject).getBoolean("visible"))
      {
        localAdFormData.title = new AdTextData();
        localAdFormData.title.text = ((JSONObject)localObject).getString("text");
        localAdFormData.title.color = aapa.a(((JSONObject)localObject).getString("fontColor"), 0);
        localAdFormData.title.size = aapa.b(paramInt, ((JSONObject)localObject).getInt("fontSize"));
      }
      localObject = paramJSONObject.getJSONObject("submitButton");
      localAdFormData.button.text.text = ((JSONObject)localObject).getString("text");
      localAdFormData.button.text.color = aapa.a(((JSONObject)localObject).getString("fontColor"), 0);
      localAdFormData.button.text.size = aapa.b(paramInt, 40);
      localAdFormData.button.borderCornerRadius = aapa.b(paramInt, 6);
      localAdFormData.button.backgroundColor = aapa.a(((JSONObject)localObject).getString("backgroundColor"), 0);
      localAdFormData.buttonHeight = aapa.b(paramInt, 124);
      localAdFormData.table.borderCornerRadius = aapa.b(paramInt, 6);
      localAdFormData.table.borderWidth = aapa.b(paramInt, 3);
      localAdFormData.table.borderColor = aapa.a("#EAEAEB", 0);
      localAdFormData.table.borderColorError = aapa.a("#FE6C6C", 0);
      paramJSONObject = paramJSONObject.getJSONArray("items");
      if (paramJSONObject.length() <= 0)
      {
        aanp.d("AdFormDataBuilder", "getFormComponent error");
        return null;
      }
    }
    catch (JSONException paramJSONObject)
    {
      aanp.d("AdFormDataBuilder", "getFormComponent", paramJSONObject);
      return null;
    }
    while (i < paramJSONObject.length())
    {
      localObject = a(paramJSONObject.getJSONObject(i), paramInt);
      if (!localAdFormData.table.addItem((AdFormItemData)localObject)) {
        aanp.d("AdFormDataBuilder", "getFormComponent error");
      }
      i += 1;
    }
    return localAdFormData;
  }
  
  private static AdFormItemData a(JSONObject paramJSONObject, int paramInt)
  {
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      aanp.d("AdFormDataBuilder", "getFormItem error");
      return null;
    }
    int i;
    try
    {
      i = paramJSONObject.getInt("type");
      switch (i)
      {
      default: 
        aanp.d("AdFormDataBuilder", "getFormItem error");
        return null;
      }
    }
    catch (JSONException paramJSONObject)
    {
      aanp.d("AdFormDataBuilder", "getFormItem", paramJSONObject);
      return null;
    }
    return a(paramJSONObject, paramInt, i);
  }
  
  private static GdtFormItemTextBoxData a(JSONObject paramJSONObject, int paramInt1, int paramInt2)
  {
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      aanp.d("AdFormDataBuilder", "getFormItemTextBox error");
      return null;
    }
    GdtFormItemTextBoxData localGdtFormItemTextBoxData = new GdtFormItemTextBoxData();
    if (!a(paramJSONObject, paramInt1, localGdtFormItemTextBoxData, paramInt2))
    {
      aanp.d("AdFormDataBuilder", "getFormItemTextBox error");
      return null;
    }
    localGdtFormItemTextBoxData.regexType = paramJSONObject.optInt("regexType", -2147483648);
    localGdtFormItemTextBoxData.content.color = aapa.a("#333333", 0);
    localGdtFormItemTextBoxData.content.size = aapa.b(paramInt1, 40);
    localGdtFormItemTextBoxData.content.lengthMax = paramJSONObject.optInt("maxLength", -2147483648);
    return localGdtFormItemTextBoxData;
  }
  
  private static boolean a(JSONObject paramJSONObject, int paramInt1, AdFormItemData paramAdFormItemData, int paramInt2)
  {
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL) || (paramAdFormItemData == null))
    {
      aanp.d("AdFormDataBuilder", "initFormItem error");
      return false;
    }
    try
    {
      if (paramJSONObject.getInt("type") != paramInt2)
      {
        aanp.d("AdFormDataBuilder", "initFormItem type error");
        return false;
      }
    }
    catch (JSONException paramJSONObject)
    {
      aanp.d("AdFormDataBuilder", "initFormItem", paramJSONObject);
      return false;
    }
    paramAdFormItemData.paddingTop = aapa.b(paramInt1, 60);
    paramAdFormItemData.paddingBottom = aapa.b(paramInt1, 60);
    paramAdFormItemData.backgroundColor = aapa.a("#FDFEFF", 0);
    paramAdFormItemData.required = paramJSONObject.getBoolean("require");
    paramAdFormItemData.title.text = paramJSONObject.getString("name");
    paramAdFormItemData.title.color = aapa.a("#333333", 0);
    paramAdFormItemData.title.size = aapa.b(paramInt1, 40);
    paramAdFormItemData.titlePaddingLeft = aapa.b(paramInt1, 60);
    paramAdFormItemData.titlePaddingRight = aapa.b(paramInt1, 15);
    paramAdFormItemData.contentPaddingLeft = aapa.b(paramInt1, 15);
    paramAdFormItemData.contentPaddingRight = aapa.b(paramInt1, 60);
    if (paramJSONObject.has("placeholder"))
    {
      paramAdFormItemData.placeholder = new AdTextData();
      paramAdFormItemData.placeholder.text = paramJSONObject.optString("placeholder");
      paramAdFormItemData.placeholder.color = aapa.a("#B9BDC2", 0);
      paramAdFormItemData.placeholder.size = aapa.b(paramInt1, 40);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapg
 * JD-Core Version:    0.7.0.1
 */