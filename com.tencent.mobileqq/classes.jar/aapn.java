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

public class aapn
{
  private static aapo a()
  {
    aapo localaapo = new aapo(null);
    localaapo.setUrl("https://h5.gdt.qq.com/player/api/form/getRegexp");
    localaapo.method = "GET";
    localaapo.contentType = "application/json";
    localaapo.connectTimeoutMillis = 5000;
    localaapo.readTimeoutMillis = 5000;
    return localaapo;
  }
  
  private static Map<Integer, String> a(aapo paramaapo, JSONObject paramJSONObject)
  {
    localHashMap = new HashMap();
    if ((paramaapo != null) && (paramJSONObject != null)) {}
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
          catch (JSONException paramaapo)
          {
            for (;;)
            {
              Object localObject;
              aanp.d("GdtFormUpdateRegexUtil", "parseRegex", paramaapo);
            }
            return localHashMap;
          }
          catch (Throwable paramaapo)
          {
            for (;;)
            {
              aanp.d("GdtFormUpdateRegexUtil", "parseRegex", paramaapo);
            }
          }
          aanp.d("GdtFormUpdateRegexUtil", "parseRegex error");
          return null;
          paramaapo.a = paramJSONObject.getInt("code");
          localObject = paramJSONObject.optString("message");
          aanp.b("GdtFormUpdateRegexUtil", "onResponse code:" + paramaapo.a + " message:" + (String)localObject);
        } while (paramaapo.a != 0);
        paramaapo = paramJSONObject.getJSONObject("data");
      } while ((paramaapo == null) || (paramaapo == JSONObject.NULL));
      paramaapo = paramaapo.getJSONObject("regexMap");
    } while ((paramaapo == null) || (paramaapo == JSONObject.NULL));
    paramJSONObject = paramaapo.keys();
    while (paramJSONObject.hasNext())
    {
      String str = (String)paramJSONObject.next();
      if (!TextUtils.isEmpty(str))
      {
        localObject = Integer.valueOf(str);
        str = paramaapo.getString(str);
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
  
  private static void a(WeakReference<AdFormData> paramWeakReference, aapo paramaapo)
  {
    if ((paramaapo == null) || (!paramaapo.isSuccess()) || (paramaapo.responseData == null) || (paramWeakReference == null) || (paramWeakReference.get() == null) || (!((AdFormData)paramWeakReference.get()).isValid()))
    {
      aanp.d("GdtFormUpdateRegexUtil", "parseResponse error");
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
        localObject = new String(paramaapo.responseData, (Charset)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        paramaapo = a(paramaapo, new JSONObject((String)localObject));
        if (paramaapo == null) {
          break;
        }
        i = 0;
        if (i >= ((AdFormData)paramWeakReference.get()).table.getSize()) {
          break label49;
        }
        localObject = ((AdFormData)paramWeakReference.get()).table.getItem(i);
        if ((localObject == null) || (!((AdFormItemData)localObject).isValid()))
        {
          aanp.d("GdtFormUpdateRegexUtil", "parseResponse error");
        }
        else if ((localObject instanceof GdtFormItemTextBoxData))
        {
          localObject = (GdtFormItemTextBoxData)GdtFormItemTextBoxData.class.cast(localObject);
          if (localObject == null) {
            aanp.d("GdtFormUpdateRegexUtil", "parseResponse error");
          }
        }
      }
      catch (JSONException paramWeakReference)
      {
        aanp.d("GdtFormUpdateRegexUtil", "parseResponse", paramWeakReference);
        break;
        if (((GdtFormItemTextBoxData)localObject).regexType == -2147483648) {
          break label262;
        }
        if (paramaapo.containsKey(Integer.valueOf(((GdtFormItemTextBoxData)localObject).regexType))) {
          break label242;
        }
        aanp.d("GdtFormUpdateRegexUtil", "parseResponse error");
      }
      catch (Throwable paramWeakReference)
      {
        aanp.d("GdtFormUpdateRegexUtil", "parseResponse", paramWeakReference);
      }
      break;
      label242:
      ((GdtFormItemTextBoxData)localObject).regex = ((String)paramaapo.get(Integer.valueOf(((GdtFormItemTextBoxData)localObject).regexType)));
      label262:
      i += 1;
    }
  }
  
  private static void c(WeakReference<AdFormData> paramWeakReference)
  {
    int i = 0;
    for (;;)
    {
      aapo localaapo;
      if (i < 3)
      {
        localaapo = a();
        if (localaapo != null) {}
      }
      else
      {
        aanp.d("GdtFormUpdateRegexUtil", "update error");
      }
      do
      {
        return;
        AdHttp.send(localaapo);
        a(paramWeakReference, localaapo);
      } while ((localaapo.isSuccess()) && (localaapo.a == 0));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapn
 * JD-Core Version:    0.7.0.1
 */