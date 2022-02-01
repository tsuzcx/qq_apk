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

public class acji
{
  private static acjj a()
  {
    acjj localacjj = new acjj(null);
    localacjj.setUrl("https://h5.gdt.qq.com/player/api/form/getRegexp");
    localacjj.method = "GET";
    localacjj.contentType = "application/json";
    localacjj.connectTimeoutMillis = 5000;
    localacjj.readTimeoutMillis = 5000;
    return localacjj;
  }
  
  private static Map<Integer, String> a(acjj paramacjj, JSONObject paramJSONObject)
  {
    localHashMap = new HashMap();
    if ((paramacjj != null) && (paramJSONObject != null)) {}
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
          catch (JSONException paramacjj)
          {
            for (;;)
            {
              Object localObject;
              acho.d("GdtFormUpdateRegexUtil", "parseRegex", paramacjj);
            }
            return localHashMap;
          }
          catch (Throwable paramacjj)
          {
            for (;;)
            {
              acho.d("GdtFormUpdateRegexUtil", "parseRegex", paramacjj);
            }
          }
          acho.d("GdtFormUpdateRegexUtil", "parseRegex error");
          return null;
          paramacjj.a = paramJSONObject.getInt("code");
          localObject = paramJSONObject.optString("message");
          acho.b("GdtFormUpdateRegexUtil", "onResponse code:" + paramacjj.a + " message:" + (String)localObject);
        } while (paramacjj.a != 0);
        paramacjj = paramJSONObject.getJSONObject("data");
      } while ((paramacjj == null) || (JSONObject.NULL.equals(paramacjj)));
      paramacjj = paramacjj.getJSONObject("regexMap");
    } while ((paramacjj == null) || (JSONObject.NULL.equals(paramacjj)));
    paramJSONObject = paramacjj.keys();
    while (paramJSONObject.hasNext())
    {
      String str = (String)paramJSONObject.next();
      if (!TextUtils.isEmpty(str))
      {
        localObject = Integer.valueOf(str);
        str = paramacjj.getString(str);
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
  
  private static void a(WeakReference<AdFormData> paramWeakReference, acjj paramacjj)
  {
    if ((paramacjj == null) || (!paramacjj.isSuccess()) || (paramacjj.responseData == null) || (paramWeakReference == null) || (paramWeakReference.get() == null) || (!((AdFormData)paramWeakReference.get()).isValid()))
    {
      acho.d("GdtFormUpdateRegexUtil", "parseResponse error");
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
        localObject = new String(paramacjj.responseData, (Charset)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        paramacjj = a(paramacjj, new JSONObject((String)localObject));
        if (paramacjj == null) {
          break;
        }
        i = 0;
        if (i >= ((AdFormData)paramWeakReference.get()).table.getSize()) {
          break label49;
        }
        localObject = ((AdFormData)paramWeakReference.get()).table.getItem(i);
        if ((localObject == null) || (!((AdFormItemData)localObject).isValid()))
        {
          acho.d("GdtFormUpdateRegexUtil", "parseResponse error");
        }
        else if ((localObject instanceof GdtFormItemTextBoxData))
        {
          localObject = (GdtFormItemTextBoxData)GdtFormItemTextBoxData.class.cast(localObject);
          if (localObject == null) {
            acho.d("GdtFormUpdateRegexUtil", "parseResponse error");
          }
        }
      }
      catch (JSONException paramWeakReference)
      {
        acho.d("GdtFormUpdateRegexUtil", "parseResponse", paramWeakReference);
        break;
        if (((GdtFormItemTextBoxData)localObject).regexType == -2147483648) {
          break label262;
        }
        if (paramacjj.containsKey(Integer.valueOf(((GdtFormItemTextBoxData)localObject).regexType))) {
          break label242;
        }
        acho.d("GdtFormUpdateRegexUtil", "parseResponse error");
      }
      catch (Throwable paramWeakReference)
      {
        acho.d("GdtFormUpdateRegexUtil", "parseResponse", paramWeakReference);
      }
      break;
      label242:
      ((GdtFormItemTextBoxData)localObject).regex = ((String)paramacjj.get(Integer.valueOf(((GdtFormItemTextBoxData)localObject).regexType)));
      label262:
      i += 1;
    }
  }
  
  private static void c(WeakReference<AdFormData> paramWeakReference)
  {
    int i = 0;
    for (;;)
    {
      acjj localacjj;
      if (i < 3)
      {
        localacjj = a();
        if (localacjj != null) {}
      }
      else
      {
        acho.d("GdtFormUpdateRegexUtil", "update error");
      }
      do
      {
        return;
        AdHttp.send(localacjj);
        a(paramWeakReference, localacjj);
      } while ((localacjj.isSuccess()) && (localacjj.a == 0));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acji
 * JD-Core Version:    0.7.0.1
 */