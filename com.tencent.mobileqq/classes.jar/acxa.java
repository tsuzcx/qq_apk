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

public class acxa
{
  private static acxb a()
  {
    acxb localacxb = new acxb(null);
    localacxb.setUrl("https://h5.gdt.qq.com/player/api/form/getRegexp");
    localacxb.method = "GET";
    localacxb.contentType = "application/json";
    localacxb.connectTimeoutMillis = 5000;
    localacxb.readTimeoutMillis = 5000;
    return localacxb;
  }
  
  private static Map<Integer, String> a(acxb paramacxb, JSONObject paramJSONObject)
  {
    localHashMap = new HashMap();
    if ((paramacxb != null) && (paramJSONObject != null)) {}
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
          catch (JSONException paramacxb)
          {
            for (;;)
            {
              Object localObject;
              acvc.d("GdtFormUpdateRegexUtil", "parseRegex", paramacxb);
            }
            return localHashMap;
          }
          catch (Throwable paramacxb)
          {
            for (;;)
            {
              acvc.d("GdtFormUpdateRegexUtil", "parseRegex", paramacxb);
            }
          }
          acvc.d("GdtFormUpdateRegexUtil", "parseRegex error");
          return null;
          paramacxb.a = paramJSONObject.getInt("code");
          localObject = paramJSONObject.optString("message");
          acvc.b("GdtFormUpdateRegexUtil", "onResponse code:" + paramacxb.a + " message:" + (String)localObject);
        } while (paramacxb.a != 0);
        paramacxb = paramJSONObject.getJSONObject("data");
      } while ((paramacxb == null) || (JSONObject.NULL.equals(paramacxb)));
      paramacxb = paramacxb.getJSONObject("regexMap");
    } while ((paramacxb == null) || (JSONObject.NULL.equals(paramacxb)));
    paramJSONObject = paramacxb.keys();
    while (paramJSONObject.hasNext())
    {
      String str = (String)paramJSONObject.next();
      if (!TextUtils.isEmpty(str))
      {
        localObject = Integer.valueOf(str);
        str = paramacxb.getString(str);
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
  
  private static void a(WeakReference<AdFormData> paramWeakReference, acxb paramacxb)
  {
    if ((paramacxb == null) || (!paramacxb.isSuccess()) || (paramacxb.responseData == null) || (paramWeakReference == null) || (paramWeakReference.get() == null) || (!((AdFormData)paramWeakReference.get()).isValid()))
    {
      acvc.d("GdtFormUpdateRegexUtil", "parseResponse error");
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
        localObject = new String(paramacxb.responseData, (Charset)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        paramacxb = a(paramacxb, new JSONObject((String)localObject));
        if (paramacxb == null) {
          break;
        }
        i = 0;
        if (i >= ((AdFormData)paramWeakReference.get()).table.getSize()) {
          break label49;
        }
        localObject = ((AdFormData)paramWeakReference.get()).table.getItem(i);
        if ((localObject == null) || (!((AdFormItemData)localObject).isValid()))
        {
          acvc.d("GdtFormUpdateRegexUtil", "parseResponse error");
        }
        else if ((localObject instanceof GdtFormItemTextBoxData))
        {
          localObject = (GdtFormItemTextBoxData)GdtFormItemTextBoxData.class.cast(localObject);
          if (localObject == null) {
            acvc.d("GdtFormUpdateRegexUtil", "parseResponse error");
          }
        }
      }
      catch (JSONException paramWeakReference)
      {
        acvc.d("GdtFormUpdateRegexUtil", "parseResponse", paramWeakReference);
        break;
        if (((GdtFormItemTextBoxData)localObject).regexType == -2147483648) {
          break label262;
        }
        if (paramacxb.containsKey(Integer.valueOf(((GdtFormItemTextBoxData)localObject).regexType))) {
          break label242;
        }
        acvc.d("GdtFormUpdateRegexUtil", "parseResponse error");
      }
      catch (Throwable paramWeakReference)
      {
        acvc.d("GdtFormUpdateRegexUtil", "parseResponse", paramWeakReference);
      }
      break;
      label242:
      ((GdtFormItemTextBoxData)localObject).regex = ((String)paramacxb.get(Integer.valueOf(((GdtFormItemTextBoxData)localObject).regexType)));
      label262:
      i += 1;
    }
  }
  
  private static void c(WeakReference<AdFormData> paramWeakReference)
  {
    int i = 0;
    for (;;)
    {
      acxb localacxb;
      if (i < 3)
      {
        localacxb = a();
        if (localacxb != null) {}
      }
      else
      {
        acvc.d("GdtFormUpdateRegexUtil", "update error");
      }
      do
      {
        return;
        AdHttp.send(localacxb);
        a(paramWeakReference, localacxb);
      } while ((localacxb.isSuccess()) && (localacxb.a == 0));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acxa
 * JD-Core Version:    0.7.0.1
 */