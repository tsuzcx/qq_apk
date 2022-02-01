package mqq.manager;

import android.os.Bundle;
import java.util.HashMap;
import mqq.observer.AccountObserver;

public abstract interface AccountManager
  extends Manager
{
  public static final int OP_DEL_LOGLEVEL = 3;
  public static final int OP_SET_LOGLEVEL_PERMANENT = 1;
  public static final int OP_SET_LOGLEVEL_TEMPORARY = 2;
  
  public abstract void changeToken(HashMap<String, Object> paramHashMap, AccountObserver paramAccountObserver);
  
  public abstract void checkQuickRegisterAccount(String paramString1, int paramInt, String paramString2, AccountObserver paramAccountObserver);
  
  public abstract void deleteAccount(String paramString1, String paramString2, AccountObserver paramAccountObserver);
  
  public abstract void getKey(AccountObserver paramAccountObserver);
  
  public abstract void getQuickRegisterAccount(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, AccountObserver paramAccountObserver);
  
  public abstract void queryUpSmsStat(AccountObserver paramAccountObserver);
  
  public abstract void refreshDA2(String paramString, AccountObserver paramAccountObserver);
  
  public abstract void sendRegistByPhoneNumber(String paramString1, byte paramByte, String paramString2, String paramString3, String paramString4, Long paramLong, String paramString5, Bundle paramBundle, AccountObserver paramAccountObserver);
  
  public abstract void sendRegistByResendSms(AccountObserver paramAccountObserver);
  
  public abstract void sendRegisterByCommitSmsVerifycode(String paramString, AccountObserver paramAccountObserver);
  
  public abstract void sendRegisterBySetPass(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, Bundle paramBundle, AccountObserver paramAccountObserver);
  
  public abstract void sendRegisterBySetPassWithLH(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, Bundle paramBundle, AccountObserver paramAccountObserver);
  
  public abstract void sendRegisterQueryMobile(String paramString1, String paramString2, AccountObserver paramAccountObserver);
  
  public abstract void setManualLogLevel(int paramInt1, int paramInt2);
  
  public abstract void updateSKey(AccountObserver paramAccountObserver);
  
  public abstract void updateSTwxWeb(AccountObserver paramAccountObserver);
  
  public abstract void verifyPasswd(String paramString1, String paramString2, AccountObserver paramAccountObserver);
  
  public abstract void verifyPasswdRefreshImage(String paramString, AccountObserver paramAccountObserver);
  
  public abstract void verifyPasswdSubmitImage(String paramString1, String paramString2, AccountObserver paramAccountObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.manager.AccountManager
 * JD-Core Version:    0.7.0.1
 */