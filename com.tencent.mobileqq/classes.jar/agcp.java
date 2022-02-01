import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.activateFriend.QQRecurrentNotifySettingFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class agcp
{
  public static int a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return -1;
    }
    return paramBundle.getInt("callback_id", -1);
  }
  
  public static Bundle a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("callback_id", paramInt);
    return localBundle;
  }
  
  public static Bundle a(int paramInt, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("retcode", paramInt);
    localBundle.putString("retmsg", paramString);
    return localBundle;
  }
  
  public static Bundle a(int paramInt1, String paramString, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("retcode", paramInt1);
    localBundle.putString("retmsg", paramString);
    if (paramInt2 != -1) {
      localBundle.putInt("has_subscribe", paramInt2);
    }
    return localBundle;
  }
  
  public static Bundle a(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("busiid", paramString3);
    localBundle.putString("msgid", paramString1);
    localBundle.putString("domain", paramString2);
    return localBundle;
  }
  
  public static String a(Bundle paramBundle)
  {
    int i = paramBundle.getInt("retcode", -1);
    String str = paramBundle.getString("retmsg", "");
    int j = paramBundle.getInt("has_subscribe", -1);
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("retcode", i);
      paramBundle.put("retmsg", str);
      if (i == 0) {
        paramBundle.put("has_subscribe", j);
      }
      paramBundle = paramBundle.toString();
      return paramBundle;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
    return "";
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQNotifyUtils", 1, "newSubscribeNotify msgId is empty");
      }
      return;
    }
    QQRecurrentNotifySettingFragment.a(paramActivity, paramString1, paramString3, paramString2, paramInt);
  }
  
  public static void a(@NonNull String paramString1, String paramString2, String paramString3, @NonNull agcq paramagcq)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      paramagcq.queryHasSetNotify(a(4, "params error"), null);
      if (QLog.isColorLevel()) {
        QLog.d("QQNotifyUtils", 1, "hasBusinessSetNotify msgId is empty");
      }
      return;
    }
    if (BaseApplicationImpl.sProcessId == 1)
    {
      agdi.c((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString1, new agck(paramagcq, null));
      return;
    }
    paramString1 = a(paramString1, paramString2, paramString3);
    QIPCClientHelper.getInstance().callServer("QQNotifyIPCModule", "query", paramString1, new agck(paramagcq, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agcp
 * JD-Core Version:    0.7.0.1
 */