import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class aapt
  extends WebViewPlugin
{
  public static final String a = aapt.class.getSimpleName();
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, String.format(Locale.getDefault(), "handleJsRequest url: %s pkgName; %s method: %s, args: %s", new Object[] { paramString1, paramString2, paramString3, paramVarArgs }));
    }
    if ("arcard".equals(paramString2)) {
      if ("isEntranceSupport".equals(paramString3)) {
        if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
          break label328;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        QLog.d(a, 2, "handleJsRequest jsonobject is " + paramJsBridgeListener.toString());
        paramJsBridgeListener = paramJsBridgeListener.optString("callback");
        if (!apfl.a())
        {
          bool1 = true;
          paramString1 = new JSONObject();
          paramString1.put("is_entrance_support", bool1);
          callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          bool1 = bool2;
          return bool1;
        }
        bool1 = false;
        continue;
        if (!"isModelSupport".equals(paramString3)) {
          break label296;
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        return false;
      }
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        QLog.d(a, 2, "handleJsRequest jsonobject is " + paramJsBridgeListener.toString());
        paramJsBridgeListener = paramJsBridgeListener.optString("callback");
        bool1 = apdv.a();
        paramString1 = new JSONObject();
        paramString1.put("is_device_support", bool1);
        callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
        bool1 = bool2;
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        return false;
      }
      label296:
      boolean bool1 = super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
      continue;
      bool1 = super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
      continue;
      label328:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapt
 * JD-Core Version:    0.7.0.1
 */