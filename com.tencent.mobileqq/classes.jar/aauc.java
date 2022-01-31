import android.text.TextUtils;
import com.tencent.ad.tangram.canvas.views.form.AdFormData;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormItemData;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormTableData;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.gdtad.views.form.framework.GdtFormUpdateRegexUtil.1;
import com.tencent.gdtad.views.form.textbox.GdtFormItemTextBoxData;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class aauc
{
  private static aaud a()
  {
    aaud localaaud = new aaud(null);
    localaaud.setUrl("https://h5.gdt.qq.com/player/api/form/getRegexp");
    localaaud.method = "GET";
    localaaud.contentType = "application/json";
    localaaud.connectTimeoutMillis = 5000;
    localaaud.readTimeoutMillis = 5000;
    return localaaud;
  }
  
  private static Map<Integer, String> a(aaud paramaaud, JSONObject paramJSONObject)
  {
    localHashMap = new HashMap();
    if ((paramaaud != null) && (paramJSONObject != null)) {}
    label34:
    do
    {
      do
      {
        do
        {
          try
          {
            localObject = JSONObject.NULL;
            if (paramJSONObject != localObject) {
              break label34;
            }
          }
          catch (JSONException paramaaud)
          {
            for (;;)
            {
              Object localObject;
              aase.d("GdtFormUpdateRegexUtil", "parseRegex", paramaaud);
            }
            return localHashMap;
          }
          catch (Throwable paramaaud)
          {
            for (;;)
            {
              aase.d("GdtFormUpdateRegexUtil", "parseRegex", paramaaud);
            }
          }
          aase.d("GdtFormUpdateRegexUtil", "parseRegex error");
          return null;
          paramaaud.a = paramJSONObject.getInt("code");
          localObject = paramJSONObject.optString("message");
          aase.b("GdtFormUpdateRegexUtil", "onResponse code:" + paramaaud.a + " message:" + (String)localObject);
        } while (paramaaud.a != 0);
        paramaaud = paramJSONObject.getJSONObject("data");
      } while ((paramaaud == null) || (paramaaud == JSONObject.NULL));
      paramaaud = paramaaud.getJSONObject("regexMap");
    } while ((paramaaud == null) || (paramaaud == JSONObject.NULL));
    paramJSONObject = paramaaud.keys();
    while (paramJSONObject.hasNext())
    {
      String str = (String)paramJSONObject.next();
      if (!TextUtils.isEmpty(str))
      {
        localObject = Integer.valueOf(str);
        str = paramaaud.getString(str);
        if (!TextUtils.isEmpty(str)) {
          localHashMap.put(localObject, str);
        }
      }
    }
  }
  
  public static void a(WeakReference<AdFormData> paramWeakReference)
  {
    ThreadManager.post(new GdtFormUpdateRegexUtil.1(paramWeakReference), 5, null, true);
  }
  
  private static void a(WeakReference<AdFormData> paramWeakReference, aaud paramaaud)
  {
    if ((paramaaud == null) || (!paramaaud.isSuccess()) || (paramaaud.responseData == null) || (paramWeakReference == null) || (paramWeakReference.get() == null) || (!((AdFormData)paramWeakReference.get()).isValid()))
    {
      aase.d("GdtFormUpdateRegexUtil", "parseResponse error");
      label49:
      return;
    }
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        localObject = Charset.forName("UTF-8");
        if (localObject == null) {
          break;
        }
        localObject = new String(paramaaud.responseData, (Charset)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        paramaaud = a(paramaaud, new JSONObject((String)localObject));
        if (paramaaud == null) {
          break;
        }
        i = 0;
        if (i >= ((AdFormData)paramWeakReference.get()).table.getSize()) {
          break label49;
        }
        localObject = ((AdFormData)paramWeakReference.get()).table.getItem(i);
        if ((localObject == null) || (!((AdFormItemData)localObject).isValid()))
        {
          aase.d("GdtFormUpdateRegexUtil", "parseResponse error");
        }
        else if ((localObject instanceof GdtFormItemTextBoxData))
        {
          localObject = (GdtFormItemTextBoxData)GdtFormItemTextBoxData.class.cast(localObject);
          if (localObject == null) {
            aase.d("GdtFormUpdateRegexUtil", "parseResponse error");
          }
        }
      }
      catch (JSONException paramWeakReference)
      {
        aase.d("GdtFormUpdateRegexUtil", "parseResponse", paramWeakReference);
        break;
        if (((GdtFormItemTextBoxData)localObject).regexType == -2147483648) {
          break label262;
        }
        if (paramaaud.containsKey(Integer.valueOf(((GdtFormItemTextBoxData)localObject).regexType))) {
          break label242;
        }
        aase.d("GdtFormUpdateRegexUtil", "parseResponse error");
      }
      catch (Throwable paramWeakReference)
      {
        aase.d("GdtFormUpdateRegexUtil", "parseResponse", paramWeakReference);
      }
      break;
      label242:
      ((GdtFormItemTextBoxData)localObject).regex = ((String)paramaaud.get(Integer.valueOf(((GdtFormItemTextBoxData)localObject).regexType)));
      label262:
      i += 1;
    }
  }
  
  private static void c(WeakReference<AdFormData> paramWeakReference)
  {
    int i = 0;
    for (;;)
    {
      aaud localaaud;
      if (i < 3)
      {
        localaaud = a();
        if (localaaud != null) {}
      }
      else
      {
        aase.d("GdtFormUpdateRegexUtil", "update error");
      }
      do
      {
        return;
        AdHttp.send(localaaud);
        a(paramWeakReference, localaaud);
      } while ((localaaud.isSuccess()) && (localaaud.a == 0));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aauc
 * JD-Core Version:    0.7.0.1
 */