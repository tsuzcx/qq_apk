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

public class abtj
{
  private static abtk a()
  {
    abtk localabtk = new abtk(null);
    localabtk.setUrl("https://h5.gdt.qq.com/player/api/form/getRegexp");
    localabtk.method = "GET";
    localabtk.contentType = "application/json";
    localabtk.connectTimeoutMillis = 5000;
    localabtk.readTimeoutMillis = 5000;
    return localabtk;
  }
  
  private static Map<Integer, String> a(abtk paramabtk, JSONObject paramJSONObject)
  {
    localHashMap = new HashMap();
    if ((paramabtk != null) && (paramJSONObject != null)) {}
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
          catch (JSONException paramabtk)
          {
            for (;;)
            {
              Object localObject;
              abrl.d("GdtFormUpdateRegexUtil", "parseRegex", paramabtk);
            }
            return localHashMap;
          }
          catch (Throwable paramabtk)
          {
            for (;;)
            {
              abrl.d("GdtFormUpdateRegexUtil", "parseRegex", paramabtk);
            }
          }
          abrl.d("GdtFormUpdateRegexUtil", "parseRegex error");
          return null;
          paramabtk.a = paramJSONObject.getInt("code");
          localObject = paramJSONObject.optString("message");
          abrl.b("GdtFormUpdateRegexUtil", "onResponse code:" + paramabtk.a + " message:" + (String)localObject);
        } while (paramabtk.a != 0);
        paramabtk = paramJSONObject.getJSONObject("data");
      } while ((paramabtk == null) || (JSONObject.NULL.equals(paramabtk)));
      paramabtk = paramabtk.getJSONObject("regexMap");
    } while ((paramabtk == null) || (JSONObject.NULL.equals(paramabtk)));
    paramJSONObject = paramabtk.keys();
    while (paramJSONObject.hasNext())
    {
      String str = (String)paramJSONObject.next();
      if (!TextUtils.isEmpty(str))
      {
        localObject = Integer.valueOf(str);
        str = paramabtk.getString(str);
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
  
  private static void a(WeakReference<AdFormData> paramWeakReference, abtk paramabtk)
  {
    if ((paramabtk == null) || (!paramabtk.isSuccess()) || (paramabtk.responseData == null) || (paramWeakReference == null) || (paramWeakReference.get() == null) || (!((AdFormData)paramWeakReference.get()).isValid()))
    {
      abrl.d("GdtFormUpdateRegexUtil", "parseResponse error");
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
        localObject = new String(paramabtk.responseData, (Charset)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        paramabtk = a(paramabtk, new JSONObject((String)localObject));
        if (paramabtk == null) {
          break;
        }
        i = 0;
        if (i >= ((AdFormData)paramWeakReference.get()).table.getSize()) {
          break label49;
        }
        localObject = ((AdFormData)paramWeakReference.get()).table.getItem(i);
        if ((localObject == null) || (!((AdFormItemData)localObject).isValid()))
        {
          abrl.d("GdtFormUpdateRegexUtil", "parseResponse error");
        }
        else if ((localObject instanceof GdtFormItemTextBoxData))
        {
          localObject = (GdtFormItemTextBoxData)GdtFormItemTextBoxData.class.cast(localObject);
          if (localObject == null) {
            abrl.d("GdtFormUpdateRegexUtil", "parseResponse error");
          }
        }
      }
      catch (JSONException paramWeakReference)
      {
        abrl.d("GdtFormUpdateRegexUtil", "parseResponse", paramWeakReference);
        break;
        if (((GdtFormItemTextBoxData)localObject).regexType == -2147483648) {
          break label262;
        }
        if (paramabtk.containsKey(Integer.valueOf(((GdtFormItemTextBoxData)localObject).regexType))) {
          break label242;
        }
        abrl.d("GdtFormUpdateRegexUtil", "parseResponse error");
      }
      catch (Throwable paramWeakReference)
      {
        abrl.d("GdtFormUpdateRegexUtil", "parseResponse", paramWeakReference);
      }
      break;
      label242:
      ((GdtFormItemTextBoxData)localObject).regex = ((String)paramabtk.get(Integer.valueOf(((GdtFormItemTextBoxData)localObject).regexType)));
      label262:
      i += 1;
    }
  }
  
  private static void c(WeakReference<AdFormData> paramWeakReference)
  {
    int i = 0;
    for (;;)
    {
      abtk localabtk;
      if (i < 3)
      {
        localabtk = a();
        if (localabtk != null) {}
      }
      else
      {
        abrl.d("GdtFormUpdateRegexUtil", "update error");
      }
      do
      {
        return;
        AdHttp.send(localabtk);
        a(paramWeakReference, localabtk);
      } while ((localabtk.isSuccess()) && (localabtk.a == 0));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abtj
 * JD-Core Version:    0.7.0.1
 */