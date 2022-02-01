package mqq.manager;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;

public abstract interface VerifyDevLockManager
  extends Manager
{
  public static final int NOTIFY_AUTH_RESULT = 1001;
  public static final int NOTIFY_CHECK_SELF_PHONE = 1004;
  public static final int NOTIFY_GET_GATEWAY_URL = 1003;
  public static final int NOTIFY_REFRESH_SMS_RESULT = 1002;
  
  public abstract void cancelVerify(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver);
  
  public abstract boolean checkVerifyDevLockSmsResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
  
  public abstract void gatewayVerify(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver, byte[] paramArrayOfByte);
  
  public abstract void refreshDevLockSms(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver, HashMap<String, Object> paramHashMap);
  
  public abstract void refreshDevLockSms(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver, byte[] paramArrayOfByte);
  
  public abstract void removeVerifyDevlockObserver(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver);
  
  public abstract void submitSms(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver, String paramString, HashMap<String, Object> paramHashMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.manager.VerifyDevLockManager
 * JD-Core Version:    0.7.0.1
 */