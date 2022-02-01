import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class aipb
  extends WebViewPlugin
{
  private static String a;
  public BroadcastReceiver a;
  
  public aipb()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aipc(this);
    this.mPluginNameSpace = "bless";
  }
  
  public void a(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessJsApiPlugin", 2, "onActivityResult, requestCode:" + paramInt1 + "，resultCode：" + paramInt2);
    }
    if ((paramInt1 != 11000) || (paramIntent == null)) {}
    String str;
    do
    {
      do
      {
        return;
        str = paramIntent.getStringExtra("arg_callback");
      } while (TextUtils.isEmpty(str));
      if (paramInt2 != -1) {
        break;
      }
      paramIntent = paramIntent.getStringExtra("arg_result_json");
    } while (paramIntent == null);
    try
    {
      paramIntent = new JSONObject(paramIntent);
      paramIntent.put("retCode", 0);
      paramIntent = paramIntent.toString();
      if (QLog.isColorLevel()) {
        QLog.d("BlessJsApiPlugin", 2, "startNewPTVActivity" + " result:" + ReadInJoyDeliverUGCActivity.a(paramIntent));
      }
      callJs(str, new String[] { paramIntent });
      return;
    }
    catch (Exception paramIntent)
    {
      return;
    }
    try
    {
      paramIntent = new JSONObject();
      paramIntent.put("retCode", -1);
      paramIntent = paramIntent.toString();
      if (QLog.isColorLevel()) {
        QLog.d("BlessJsApiPlugin", 2, "startNewPTVActivity" + " result:" + paramIntent);
      }
      callJs(str, new String[] { paramIntent });
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 8589934600L) && (paramMap != null))
    {
      int i = ((Integer)paramMap.get("requestCode")).intValue();
      if (i == 11000)
      {
        int j = ((Integer)paramMap.get("resultCode")).intValue();
        a((Intent)paramMap.get("data"), i, j);
        return true;
      }
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessJsApiPlugin", 2, "Call BlessJsApiPlugin handleJsRequest, url" + paramString1 + " pkgName:" + paramString2);
    }
    if ("bless".equals(paramString2))
    {
      if ("GSBase64Encode".equals(paramString3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BlessJsApiPlugin", 2, "Call Bless Api GSBaze64Encode, args:" + paramVarArgs);
        }
        if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {}
      }
      for (;;)
      {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          paramString1 = paramJsBridgeListener.optString("need_encode_string");
          paramJsBridgeListener = paramJsBridgeListener.optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = axeg.a(paramString1);
            paramString2 = new JSONObject();
            paramString2.put("encoded_string", paramString1);
            callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
          }
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          continue;
        }
        if ("getBlessConfig".equals(paramString3))
        {
          if (QLog.isColorLevel()) {
            QLog.d("BlessJsApiPlugin", 2, "Call Bless Api getBlessConfig, args:" + paramVarArgs);
          }
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
              if (TextUtils.isEmpty(paramJsBridgeListener)) {
                continue;
              }
              paramString1 = aipe.i();
              paramString2 = new JSONObject();
              paramString2.put("bless_config", paramString1);
              callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
        }
        else if ("sendBlessText".equals(paramString3))
        {
          if (QLog.isColorLevel()) {
            QLog.d("BlessJsApiPlugin", 2, "Call Bless Api sendBlessText, args:" + paramVarArgs);
          }
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
            try
            {
              paramString1 = new JSONObject(paramVarArgs[0]);
              paramJsBridgeListener = paramString1.optString("callback");
              paramString1 = paramString1.optString("blesswords");
              if (TextUtils.isEmpty(paramJsBridgeListener)) {
                continue;
              }
              aipd.a(this.mRuntime.a(), paramString1, paramJsBridgeListener);
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
        }
        else if ("sendBlessPtv".equals(paramString3))
        {
          if (QLog.isColorLevel()) {
            QLog.d("BlessJsApiPlugin", 2, "Call Ptv Api sendBlessPtv, args:" + paramVarArgs);
          }
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
            try
            {
              Object localObject = new JSONObject(paramVarArgs[0]);
              paramJsBridgeListener = ((JSONObject)localObject).optString("callback");
              paramString1 = ((JSONObject)localObject).optString("supportvideo");
              paramString2 = ((JSONObject)localObject).optString("supportphoto");
              paramString3 = ((JSONObject)localObject).optString("cameramode");
              paramVarArgs = ((JSONObject)localObject).optString("supportDD");
              String str1 = ((JSONObject)localObject).optString("unfoldDD");
              String str2 = ((JSONObject)localObject).optString("DDCategoryName");
              String str3 = ((JSONObject)localObject).optString("DDItemID");
              String str4 = ((JSONObject)localObject).optString("supportFilter");
              String str5 = ((JSONObject)localObject).optString("unfoldFilter");
              String str6 = ((JSONObject)localObject).optString("filterCategoryName");
              localObject = ((JSONObject)localObject).optString("filterItemID");
              if (TextUtils.isEmpty(paramJsBridgeListener)) {
                continue;
              }
              AppInterface localAppInterface = this.mRuntime.a();
              Activity localActivity = this.mRuntime.a();
              jdField_a_of_type_JavaLangString = paramJsBridgeListener;
              aipd.a(localAppInterface, localActivity, paramString1, paramString2, paramString3, paramVarArgs, str1, str2, str3, str4, str5, str6, (String)localObject, paramJsBridgeListener);
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
        }
        else
        {
          boolean bool;
          if ("isSupportPTV".equals(paramString3))
          {
            if (QLog.isColorLevel()) {
              QLog.d("BlessJsApiPlugin", 2, "Call Bless Api isSupportPTV, args:" + paramVarArgs);
            }
            if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
              try
              {
                paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
                if (TextUtils.isEmpty(paramJsBridgeListener)) {
                  continue;
                }
                bool = aipd.c(this.mRuntime.a());
                paramString1 = new JSONObject();
                paramString1.put("is_support_ptv", bool);
                callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
              }
              catch (JSONException paramJsBridgeListener)
              {
                paramJsBridgeListener.printStackTrace();
              }
            }
          }
          else if ("isMobileSupportPTV".equals(paramString3))
          {
            if (QLog.isColorLevel()) {
              QLog.d("BlessJsApiPlugin", 2, "Call Bless Api isMobileSupportPTV, args:" + paramVarArgs);
            }
            if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
              try
              {
                paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
                if (TextUtils.isEmpty(paramJsBridgeListener)) {
                  continue;
                }
                bool = aipd.a(this.mRuntime.a());
                paramString1 = new JSONObject();
                paramString1.put("is_mobile_support_ptv", bool);
                callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
              }
              catch (JSONException paramJsBridgeListener)
              {
                paramJsBridgeListener.printStackTrace();
              }
            }
          }
          else if ("isMobileSupportPendant".equals(paramString3))
          {
            if (QLog.isColorLevel()) {
              QLog.d("BlessJsApiPlugin", 2, "Call Bless Api isMobileSupportPendant, args:" + paramVarArgs);
            }
            if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
              try
              {
                paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
                if (!TextUtils.isEmpty(paramJsBridgeListener))
                {
                  bool = aipd.b(this.mRuntime.a());
                  paramString1 = new JSONObject();
                  paramString1.put("is_support_DynamicDecoration", bool);
                  callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
                }
              }
              catch (JSONException paramJsBridgeListener)
              {
                paramJsBridgeListener.printStackTrace();
              }
            }
          }
        }
      }
    }
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.BlessJsApiPlugin");
    this.mRuntime.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mRuntime.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipb
 * JD-Core Version:    0.7.0.1
 */