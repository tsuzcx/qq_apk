import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.Doraemon.DoraemonOpenAPI.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class absn
{
  public static absi a(@NonNull Activity paramActivity, int paramInt, String paramString)
  {
    return a(paramActivity, paramInt, paramString, null);
  }
  
  public static absi a(@NonNull Activity paramActivity, int paramInt, String paramString, Bundle paramBundle)
  {
    String str = null;
    absp localabsp = null;
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI", 2, "createAPIManager type=" + paramInt + ", appid=" + paramString);
    }
    if (paramActivity == null)
    {
      QLog.e("DoraemonOpenAPI", 1, "can not create APIManager activity == null");
      return null;
    }
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("DoraemonOpenAPI", 1, "can not create APIManager appid is empty");
    }
    Object localObject = localabsp;
    switch (paramInt)
    {
    default: 
      localObject = localabsp;
    case 2: 
    case 0: 
    case 1: 
    case 3: 
    case 4: 
    case 5: 
      while (localObject == null)
      {
        QLog.e("DoraemonOpenAPI", 1, "can not create APIManager type=" + paramInt + ", appid=" + paramString);
        return localObject;
        if (paramBundle == null) {}
        for (paramBundle = null; TextUtils.isEmpty(paramBundle); paramBundle = paramBundle.getString("urlSummary", ""))
        {
          QLog.e("DoraemonOpenAPI", 1, "can not create APIManger url is empty");
          return null;
        }
        localObject = new abui(paramActivity, paramInt, paramString, paramBundle);
        continue;
        localabsp = new absp(paramActivity, paramInt, paramString);
        if (paramBundle == null) {
          break label305;
        }
        localObject = paramBundle.getString("sdkVersion");
        str = paramBundle.getString("pkgName");
        paramActivity = paramBundle.getString("signature");
        paramBundle = str;
      }
    }
    for (;;)
    {
      ((absp)localabsp).a((String)localObject, paramBundle, paramActivity);
      localObject = localabsp;
      break;
      localObject = new abtf(paramActivity, paramInt, paramString);
      break;
      ((absi)localObject).a();
      return localObject;
      label305:
      paramBundle = null;
      localObject = null;
      paramActivity = str;
    }
  }
  
  public static void a()
  {
    ThreadManager.post(new DoraemonOpenAPI.1(), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     absn
 * JD-Core Version:    0.7.0.1
 */