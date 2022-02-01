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

public class acsw
{
  private static acsx a()
  {
    acsx localacsx = new acsx(null);
    localacsx.setUrl("https://h5.gdt.qq.com/player/api/form/getRegexp");
    localacsx.method = "GET";
    localacsx.contentType = "application/json";
    localacsx.connectTimeoutMillis = 5000;
    localacsx.readTimeoutMillis = 5000;
    return localacsx;
  }
  
  private static Map<Integer, String> a(acsx paramacsx, JSONObject paramJSONObject)
  {
    localHashMap = new HashMap();
    if ((paramacsx != null) && (paramJSONObject != null)) {}
    label37:
    do
    {
      do
      {
        do
        {
          try
          {
            boolean bool = JSONObject.NULL.equals(paramJSONObject);
            if (!bool) {
              break label37;
            }
          }
          catch (JSONException paramacsx)
          {
            for (;;)
            {
              Object localObject;
              acqy.d("GdtFormUpdateRegexUtil", "parseRegex", paramacsx);
            }
            return localHashMap;
          }
          catch (Throwable paramacsx)
          {
            for (;;)
            {
              acqy.d("GdtFormUpdateRegexUtil", "parseRegex", paramacsx);
            }
          }
          acqy.d("GdtFormUpdateRegexUtil", "parseRegex error");
          return null;
          paramacsx.a = paramJSONObject.getInt("code");
          localObject = paramJSONObject.optString("message");
          acqy.b("GdtFormUpdateRegexUtil", "onResponse code:" + paramacsx.a + " message:" + (String)localObject);
        } while (paramacsx.a != 0);
        paramacsx = paramJSONObject.getJSONObject("data");
      } while ((paramacsx == null) || (JSONObject.NULL.equals(paramacsx)));
      paramacsx = paramacsx.getJSONObject("regexMap");
    } while ((paramacsx == null) || (JSONObject.NULL.equals(paramacsx)));
    paramJSONObject = paramacsx.keys();
    while (paramJSONObject.hasNext())
    {
      String str = (String)paramJSONObject.next();
      if (!TextUtils.isEmpty(str))
      {
        localObject = Integer.valueOf(str);
        str = paramacsx.getString(str);
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
  
  private static void a(WeakReference<AdFormData> paramWeakReference, acsx paramacsx)
  {
    if ((paramacsx == null) || (!paramacsx.isSuccess()) || (paramacsx.responseData == null) || (paramWeakReference == null) || (paramWeakReference.get() == null) || (!((AdFormData)paramWeakReference.get()).isValid()))
    {
      acqy.d("GdtFormUpdateRegexUtil", "parseResponse error");
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
        localObject = new String(paramacsx.responseData, (Charset)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        paramacsx = a(paramacsx, new JSONObject((String)localObject));
        if (paramacsx == null) {
          break;
        }
        i = 0;
        if (i >= ((AdFormData)paramWeakReference.get()).table.getSize()) {
          break label49;
        }
        localObject = ((AdFormData)paramWeakReference.get()).table.getItem(i);
        if ((localObject == null) || (!((AdFormItemData)localObject).isValid()))
        {
          acqy.d("GdtFormUpdateRegexUtil", "parseResponse error");
        }
        else if ((localObject instanceof GdtFormItemTextBoxData))
        {
          localObject = (GdtFormItemTextBoxData)GdtFormItemTextBoxData.class.cast(localObject);
          if (localObject == null) {
            acqy.d("GdtFormUpdateRegexUtil", "parseResponse error");
          }
        }
      }
      catch (JSONException paramWeakReference)
      {
        acqy.d("GdtFormUpdateRegexUtil", "parseResponse", paramWeakReference);
        break;
        if (((GdtFormItemTextBoxData)localObject).regexType == -2147483648) {
          break label262;
        }
        if (paramacsx.containsKey(Integer.valueOf(((GdtFormItemTextBoxData)localObject).regexType))) {
          break label242;
        }
        acqy.d("GdtFormUpdateRegexUtil", "parseResponse error");
      }
      catch (Throwable paramWeakReference)
      {
        acqy.d("GdtFormUpdateRegexUtil", "parseResponse", paramWeakReference);
      }
      break;
      label242:
      ((GdtFormItemTextBoxData)localObject).regex = ((String)paramacsx.get(Integer.valueOf(((GdtFormItemTextBoxData)localObject).regexType)));
      label262:
      i += 1;
    }
  }
  
  private static void c(WeakReference<AdFormData> paramWeakReference)
  {
    int i = 0;
    for (;;)
    {
      acsx localacsx;
      if (i < 3)
      {
        localacsx = a();
        if (localacsx != null) {}
      }
      else
      {
        acqy.d("GdtFormUpdateRegexUtil", "update error");
      }
      do
      {
        return;
        AdHttp.send(localacsx);
        a(paramWeakReference, localacsx);
      } while ((localacsx.isSuccess()) && (localacsx.a == 0));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acsw
 * JD-Core Version:    0.7.0.1
 */