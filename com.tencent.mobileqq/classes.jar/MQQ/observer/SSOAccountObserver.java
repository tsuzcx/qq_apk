package mqq.observer;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Constants.Action;

public class SSOAccountObserver
  implements Constants.Action, BusinessObserver
{
  public static final String TAG = "SSOAccountObserver";
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle) {}
  
  public void onGetA1WithA1(String paramString, int paramInt1, byte[] paramArrayOfByte, int paramInt2, Bundle paramBundle) {}
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle) {}
  
  public void onLoginSuccess(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int n = paramBundle.getInt("code");
    String str = paramBundle.getString("ssoAccount");
    int i1 = paramBundle.getInt("targetTicket", 4096);
    int i2 = paramBundle.getInt("ret");
    byte[] arrayOfByte = paramBundle.getByteArray("wtTicket");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("account:");
      localStringBuilder.append(str);
      localStringBuilder.append(" action:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" code:");
      localStringBuilder.append(n);
      localStringBuilder.append(" isSuccess:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ret:");
      localStringBuilder.append(i2);
      localStringBuilder.append(" wtTicketArr:");
      Object localObject;
      if (arrayOfByte == null) {
        localObject = "null";
      } else {
        localObject = Integer.valueOf(arrayOfByte.length);
      }
      localStringBuilder.append(localObject);
      QLog.d("SSOAccountObserver", 2, localStringBuilder.toString());
    }
    int m = 0;
    int k = 0;
    int i;
    if (i2 == 0) {
      i = 1;
    } else {
      i = 0;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1102: 
      j = k;
      if (arrayOfByte != null) {
        if (arrayOfByte.length == 0) {
          j = k;
        } else {
          j = i;
        }
      }
      if (j != 0)
      {
        onGetA1WithA1(str, i2, arrayOfByte, i1, paramBundle);
        return;
      }
      if (n == 2006)
      {
        onUserCancel(str, paramInt, paramBundle);
        return;
      }
      onFailed(str, paramInt, i2, paramBundle);
      return;
    }
    int j = m;
    if (arrayOfByte != null) {
      if (arrayOfByte.length == 0) {
        j = m;
      } else {
        j = i;
      }
    }
    if (j != 0)
    {
      if (paramInt == 1100)
      {
        onLoginSuccess(str, arrayOfByte, i1, paramBundle);
        return;
      }
      if (paramInt == 1101) {
        onGetTicketNoPasswd(str, arrayOfByte, i1, paramBundle);
      }
    }
    else
    {
      if (n == 2006)
      {
        onUserCancel(str, paramInt, paramBundle);
        return;
      }
      onFailed(str, paramInt, i2, paramBundle);
    }
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.observer.SSOAccountObserver
 * JD-Core Version:    0.7.0.1
 */