package mqq.observer;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime.Status;
import mqq.app.Constants.Action;
import oicq.wlogin_sdk.tools.ErrMsg;

public abstract class AccountObserver
  implements Constants.Action, BusinessObserver
{
  private static final List<Integer> LOGIN_ACTIONS = Arrays.asList(new Integer[] { Integer.valueOf(1001), Integer.valueOf(2205), Integer.valueOf(2206), Integer.valueOf(2207) });
  private static final List<Integer> OTHER_ACCOUNT_ACTIONS = Arrays.asList(new Integer[] { Integer.valueOf(2211), Integer.valueOf(1022), Integer.valueOf(1007), Integer.valueOf(1030), Integer.valueOf(1032), Integer.valueOf(1046) });
  private static final List<Integer> REGISTER_ACTIONS = Arrays.asList(new Integer[] { Integer.valueOf(1040), Integer.valueOf(1002), Integer.valueOf(1041), Integer.valueOf(1003), Integer.valueOf(1004), Integer.valueOf(1020), Integer.valueOf(1005), Integer.valueOf(1008), Integer.valueOf(1009) });
  
  private void onReceiveLoginActions(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1;
    int i;
    Object localObject3;
    if (paramInt != 1001)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 2207: 
        localObject1 = paramBundle.getString("uin");
        paramInt = paramBundle.getInt("resultCode");
        str1 = paramBundle.getString("userAccount");
        onVerifyPasswdRefreshImage((String)localObject1, paramBoolean, paramBundle.getString("errorMsg"), paramInt, str1, paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"), paramBundle.getByteArray("pictureData"));
        return;
      case 2206: 
        localObject1 = paramBundle.getString("uin");
        paramInt = paramBundle.getInt("resultCode");
        str1 = paramBundle.getString("userAccount");
        localObject2 = paramBundle.getString("errorMsg");
        i = paramBundle.getInt("ret");
        localObject3 = (ErrMsg)paramBundle.getParcelable("lastError");
        onVerifyPasswdImage((String)localObject1, paramBoolean, (String)localObject2, paramInt, str1, paramBundle.getByteArray("userInput"), i, (ErrMsg)localObject3, paramBundle.getByteArray("image"));
        return;
      }
      localObject1 = paramBundle.getString("uin");
      paramInt = paramBundle.getInt("resultCode");
      onVerifyPasswd((String)localObject1, paramBoolean, paramBundle.getString("errorMsg"), paramInt, paramBundle.getInt("ret"), paramBundle.getString("notice"), paramBundle.getByteArray("image"));
      return;
    }
    paramInt = paramBundle.getInt("code");
    String str1 = paramBundle.getString("alias");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onRV  action login code = ");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append("; alias = ");
    if (str1 == null) {
      localObject1 = "is null";
    } else {
      localObject1 = str1;
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.d("AccountObserver", 1, ((StringBuilder)localObject2).toString());
    if (paramBoolean)
    {
      localObject1 = paramBundle.getByteArray("tlv543In119");
      onLoginSuccess(paramBundle.getString("uin"), str1, (byte[])localObject1);
      return;
    }
    if ((paramInt != 1002) && (paramInt != 1013))
    {
      if (paramInt == 2006)
      {
        onUserCancel(str1);
        return;
      }
      localObject1 = paramBundle.getString("errorurl");
      paramInt = paramBundle.getInt("loginret");
      localObject2 = paramBundle.getByteArray("lhsig");
      i = paramBundle.getInt("errorver");
      localObject3 = paramBundle.getByteArray("tlverror");
      String str2 = paramBundle.getString("title");
      onLoginFailed(str1, paramBundle.getString("error"), (String)localObject1, paramInt, (byte[])localObject2, i, (byte[])localObject3, str2);
      return;
    }
    onLoginTimeout(str1);
  }
  
  private void onReceiveLoginRegisterActions(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt != 1008)
    {
      if (paramInt != 1009)
      {
        if (paramInt != 1020)
        {
          if (paramInt != 1040)
          {
            if (paramInt != 1041)
            {
              switch (paramInt)
              {
              default: 
                return;
              case 1005: 
                if (paramBundle.getBoolean("reg_Lianghao", false))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("wtLogin_LiangHao", 2, "onRegisterCommitPassRespWithLhSig");
                  }
                  onRegisterCommitPassRespWithLhSig(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getString("uin"), paramBundle.getByteArray("promptInfo"), paramBundle.getByteArray("promptInfo_error"), paramBundle.getByteArray("lhsig"));
                  return;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("wtLogin_LiangHao", 2, "onRegisterCommitPassResp");
                }
                onRegisterCommitPassResp(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getString("uin"), paramBundle.getByteArray("promptInfo"), paramBundle.getByteArray("promptInfo_error"), paramBundle.getByteArray("resp_register_supersig"));
                return;
              case 1004: 
                onRegisterCommitSmsCodeResp(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getString("bind_qq_uin"), paramBundle.getString("bind_qq_nick"), paramBundle.getString("bind_qq_face_url"), paramBundle.getByteArray("promptInfo"), paramBundle.getString("phone_protect_uins_url"));
                return;
              case 1003: 
                onRegisterCommitMobileResp(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getByteArray("promptInfo"), paramBundle.getByteArray("mobile"), paramBundle.getString("inviteCode"));
                return;
              }
              AppRuntime.Status localStatus = (AppRuntime.Status)paramBundle.getSerializable("onlineStatus");
              long l1 = paramBundle.getLong("extOnlineStatus", -1L);
              boolean bool1 = paramBundle.getBoolean("isChanged");
              long l2 = paramBundle.getLong("timeStamp");
              boolean bool2 = paramBundle.getBoolean("isLargeChanged");
              onOnlineStatusChanged(paramBoolean, localStatus, l1, paramBundle.getBoolean("isUserSet", false), bool1, l2, bool2);
              return;
            }
            onRegQueryAccountResp(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getByteArray("promptInfo"));
            return;
          }
          onRegisterCmdCallback(paramBoolean);
          return;
        }
        onRegisterSendResendSmsreqResp(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getByteArray("promptInfo"), paramBundle.getInt("next_chk_time"), paramBundle.getInt("total_time_over"));
        return;
      }
      onGetQuickRegisterAccount(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getString("uin"), paramBundle.getString("phone"), paramBundle.getByteArray("promptInfo_error"));
      return;
    }
    onCheckQuickRegisterAccount(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getByteArray("promptInfo_error"));
  }
  
  private void onReceiveOtherAccountActions(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt != 1007)
    {
      if (paramInt != 1022) {
        if (paramInt != 1030)
        {
          if (paramInt != 1032)
          {
            if (paramInt != 1046)
            {
              if (paramInt != 2211) {
                return;
              }
              onOnlineStatusPush((AppRuntime.Status)paramBundle.getSerializable("onlineStatus"), paramBundle.getLong("extOnlineStatus"));
            }
            else
            {
              onRefreshDA2(paramBoolean, paramBundle.getString("account"), paramBundle.getString("da2"));
            }
          }
          else {
            onChangeToken(paramBoolean, (HashMap)paramBundle.getSerializable("map"));
          }
        }
        else
        {
          onGetKeyResp(paramBundle.getString("key"));
          return;
        }
      }
      onRegisterQuerySmsStatResp(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getByteArray("promptInfo"), paramBundle.getInt("next_chk_time"), paramBundle.getInt("total_time_over"), paramBundle.getString("uin"), paramBundle.getString("nick"), paramBundle.getString("faceUrl"), paramBundle.getString("errmsg"), paramBundle.getString("phone_protect_uins_url"));
      return;
    }
    onDeleteAccount(paramBoolean);
  }
  
  public void onChangeToken(boolean paramBoolean, HashMap<String, Object> paramHashMap) {}
  
  public void onCheckQuickRegisterAccount(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte) {}
  
  public void onDeleteAccount(boolean paramBoolean) {}
  
  public void onExchangeUin(String paramString1, String paramString2, String paramString3) {}
  
  public void onGetKeyResp(String paramString) {}
  
  public void onGetQuickRegisterAccount(boolean paramBoolean, int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte) {}
  
  protected void onLoginFailed(String paramString1, String paramString2, String paramString3, int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2, String paramString4) {}
  
  public void onLoginSuccess(String paramString1, String paramString2, byte[] paramArrayOfByte) {}
  
  protected void onLoginTimeout(String paramString) {}
  
  protected void onOnlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, long paramLong1, boolean paramBoolean2, boolean paramBoolean3, long paramLong2, boolean paramBoolean4) {}
  
  protected void onOnlineStatusPush(AppRuntime.Status paramStatus, long paramLong) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (REGISTER_ACTIONS.contains(Integer.valueOf(paramInt)))
    {
      onReceiveLoginRegisterActions(paramInt, paramBoolean, paramBundle);
      return;
    }
    if (LOGIN_ACTIONS.contains(Integer.valueOf(paramInt)))
    {
      onReceiveLoginActions(paramInt, paramBoolean, paramBundle);
      return;
    }
    if (OTHER_ACCOUNT_ACTIONS.contains(Integer.valueOf(paramInt))) {
      onReceiveOtherAccountActions(paramInt, paramBoolean, paramBundle);
    }
  }
  
  public void onRefreshDA2(boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void onRegQueryAccountResp(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte) {}
  
  public void onRegisterCmdCallback(boolean paramBoolean) {}
  
  public void onRegisterCommitMobileResp(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString) {}
  
  public void onRegisterCommitPassResp(boolean paramBoolean, int paramInt, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3) {}
  
  public void onRegisterCommitPassRespWithLhSig(boolean paramBoolean, int paramInt, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3) {}
  
  public void onRegisterCommitSmsCodeResp(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, String paramString4) {}
  
  public void onRegisterQuerySmsStatResp(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void onRegisterSendResendSmsreqResp(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3) {}
  
  public void onUpdateSKey(String paramString1, String paramString2) {}
  
  public void onUpdateSTwxWeb(String paramString) {}
  
  protected void onUserCancel(String paramString) {}
  
  public void onVerifyPasswd(String paramString1, boolean paramBoolean, String paramString2, int paramInt1, int paramInt2, String paramString3, byte[] paramArrayOfByte) {}
  
  public void onVerifyPasswdImage(String paramString1, boolean paramBoolean, String paramString2, int paramInt1, String paramString3, byte[] paramArrayOfByte1, int paramInt2, ErrMsg paramErrMsg, byte[] paramArrayOfByte2) {}
  
  public void onVerifyPasswdRefreshImage(String paramString1, boolean paramBoolean, String paramString2, int paramInt1, String paramString3, int paramInt2, ErrMsg paramErrMsg, byte[] paramArrayOfByte) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.observer.AccountObserver
 * JD-Core Version:    0.7.0.1
 */