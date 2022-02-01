package mqq.observer;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Constants.Action;

public abstract class SubAccountObserver
  implements Constants.Action, BusinessObserver
{
  protected void onGetKeyBack(String paramString1, String paramString2, String paramString3) {}
  
  protected void onLoginFailed(String paramString1, String paramString2, String paramString3, Bundle paramBundle) {}
  
  public void onLoginSuccess(String paramString1, String paramString2, String paramString3) {}
  
  protected void onLoginTimeout(String paramString1, String paramString2, String paramString3) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt != 1035)
    {
      if (paramInt != 1037) {
        return;
      }
      str1 = paramBundle.getString("uin");
      paramBundle.getString("error");
      paramBundle.getInt("code");
      str2 = paramBundle.getString("subaccountA2");
      onGetKeyBack(paramBundle.getString("mainaccount"), str1, str2);
      return;
    }
    paramInt = paramBundle.getInt("code");
    String str1 = paramBundle.getString("alias");
    String str2 = paramBundle.getString("uin");
    String str3 = paramBundle.getString("submainaccount");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SubAccountObserver onReceive ACTION_SUBACCOUNT_LOGIN  isSuccess = ");
    localStringBuilder.append(paramBoolean);
    QLog.d("mqq", 2, localStringBuilder.toString());
    if (paramBoolean)
    {
      onLoginSuccess(str3, str2, str1);
      return;
    }
    if ((paramInt != 1002) && (paramInt != 1013))
    {
      if (paramInt == 2006)
      {
        onUserCancel(str3, str2, str1);
        return;
      }
      onLoginFailed(str3, str2, str1, paramBundle);
      return;
    }
    onLoginTimeout(str3, str2, str1);
  }
  
  protected void onUserCancel(String paramString1, String paramString2, String paramString3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.observer.SubAccountObserver
 * JD-Core Version:    0.7.0.1
 */