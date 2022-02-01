package mqq.app;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.sharemem.WloginLoginInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.util;

public class WtloginManagerImpl
  implements WtloginManager
{
  private final AppRuntime app;
  private WtloginHelper localWtloginHelper;
  
  public WtloginManagerImpl(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
    this.localWtloginHelper = new WtloginHelper(paramAppRuntime.getApplication(), true);
  }
  
  public int askDevLockSms(String paramString, WtloginObserver paramWtloginObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
    localNewIntent.putExtra("action", 2109);
    localNewIntent.putExtra("userAccount", paramString);
    localNewIntent.withouLogin = true;
    localNewIntent.setObserver(paramWtloginObserver);
    this.app.startServlet(localNewIntent);
    return 0;
  }
  
  public void cancelCode(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
    localNewIntent.putExtra("action", 2213);
    localNewIntent.putExtra("userAccount", paramString);
    localNewIntent.putExtra("appid", paramLong);
    localNewIntent.putExtra("code", paramArrayOfByte);
    localNewIntent.withouLogin = true;
    this.app.startServlet(localNewIntent);
  }
  
  public int checkDevLockSms(String paramString1, long paramLong, String paramString2, byte[] paramArrayOfByte, WtloginObserver paramWtloginObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
    localNewIntent.putExtra("action", 2110);
    localNewIntent.putExtra("userAccount", paramString1);
    localNewIntent.putExtra("subAppid", paramLong);
    localNewIntent.putExtra("smsCode", paramString2);
    localNewIntent.putExtra("sppKey", paramArrayOfByte);
    localNewIntent.withouLogin = true;
    localNewIntent.setObserver(paramWtloginObserver);
    this.app.startServlet(localNewIntent);
    return 0;
  }
  
  public int checkDevLockStatus(String paramString, long paramLong, WtloginObserver paramWtloginObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
    localNewIntent.putExtra("action", 2108);
    localNewIntent.putExtra("userAccount", paramString);
    localNewIntent.putExtra("subAppid", paramLong);
    localNewIntent.withouLogin = true;
    localNewIntent.setObserver(paramWtloginObserver);
    this.app.startServlet(localNewIntent);
    return 0;
  }
  
  public int checkPictureAndGetSt(String paramString, byte[] paramArrayOfByte, WtloginObserver paramWtloginObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
    localNewIntent.putExtra("action", 2102);
    localNewIntent.putExtra("uin", paramString);
    localNewIntent.putExtra("userInput", paramArrayOfByte);
    localNewIntent.withouLogin = true;
    localNewIntent.setObserver(paramWtloginObserver);
    this.app.startServlet(localNewIntent);
    return 0;
  }
  
  public int checkSMSAndGetSt(String paramString, byte[] paramArrayOfByte, WtloginObserver paramWtloginObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
    localNewIntent.putExtra("action", 2113);
    localNewIntent.putExtra("userAccount", paramString);
    localNewIntent.putExtra("userInput", paramArrayOfByte);
    localNewIntent.withouLogin = true;
    localNewIntent.setObserver(paramWtloginObserver);
    this.app.startServlet(localNewIntent);
    return 0;
  }
  
  public int checkSMSAndGetStExt(String paramString, byte[] paramArrayOfByte, WtloginObserver paramWtloginObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
    localNewIntent.putExtra("action", 2113);
    localNewIntent.putExtra("userAccount", paramString);
    localNewIntent.putExtra("userInput", paramArrayOfByte);
    localNewIntent.withouLogin = true;
    localNewIntent.setObserver(paramWtloginObserver);
    this.app.startServlet(localNewIntent);
    return 0;
  }
  
  public int checkSMSVerifyLoginAccount(String paramString1, String paramString2, int paramInt, WtloginObserver paramWtloginObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
    localNewIntent.putExtra("action", 2118);
    localNewIntent.putExtra("userAccount", paramString1);
    localNewIntent.putExtra("countryCode", paramString2);
    localNewIntent.putExtra("appid", paramInt);
    localNewIntent.withouLogin = true;
    localNewIntent.setObserver(paramWtloginObserver);
    this.app.startServlet(localNewIntent);
    return 0;
  }
  
  public int checkSMSVerifyLoginAccount(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte, WtloginObserver paramWtloginObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
    localNewIntent.putExtra("action", 2118);
    localNewIntent.putExtra("userAccount", paramString1);
    localNewIntent.putExtra("countryCode", paramString2);
    localNewIntent.putExtra("appid", paramInt);
    localNewIntent.putExtra("verifyToken", paramArrayOfByte);
    localNewIntent.withouLogin = true;
    localNewIntent.setObserver(paramWtloginObserver);
    this.app.startServlet(localNewIntent);
    return 0;
  }
  
  public Boolean clearUserFastLoginData(String paramString, long paramLong)
  {
    return this.localWtloginHelper.ClearUserLoginData(paramString, paramLong);
  }
  
  public int closeCode(String paramString, long paramLong, byte[] paramArrayOfByte, int paramInt, ArrayList<String> paramArrayList, WtloginObserver paramWtloginObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
    localNewIntent.putExtra("action", 2105);
    localNewIntent.putExtra("userAccount", paramString);
    localNewIntent.putExtra("appid", paramLong);
    localNewIntent.putExtra("code", paramArrayOfByte);
    localNewIntent.putStringArrayListExtra("data", paramArrayList);
    localNewIntent.withouLogin = true;
    localNewIntent.setObserver(paramWtloginObserver);
    this.app.startServlet(localNewIntent);
    return 0;
  }
  
  public int closeDevLock(String paramString, long paramLong, WtloginObserver paramWtloginObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
    localNewIntent.putExtra("action", 2111);
    localNewIntent.putExtra("userAccount", paramString);
    localNewIntent.putExtra("subAppid", paramLong);
    localNewIntent.withouLogin = true;
    localNewIntent.setObserver(paramWtloginObserver);
    this.app.startServlet(localNewIntent);
    return 0;
  }
  
  public int getA1WithA1(String paramString, long paramLong1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WFastLoginInfo paramWFastLoginInfo, WtloginObserver paramWtloginObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
    localNewIntent.putExtra("action", 2106);
    localNewIntent.putExtra("userAccount", paramString);
    localNewIntent.putExtra("dwSrcAppid", paramLong1);
    localNewIntent.putExtra("dwSubSrcAppid", paramLong2);
    localNewIntent.putExtra("dstAppName", paramArrayOfByte1);
    localNewIntent.putExtra("dwDstSsoVer", paramLong3);
    localNewIntent.putExtra("dwDstAppid", paramLong4);
    localNewIntent.putExtra("dwSubDstAppid", paramLong5);
    localNewIntent.putExtra("dstAppVer", paramArrayOfByte2);
    localNewIntent.putExtra("dstAppSign", paramArrayOfByte3);
    localNewIntent.intentMap = new HashMap();
    localNewIntent.intentMap.put("fastLoginInfo", paramWFastLoginInfo);
    localNewIntent.withouLogin = true;
    localNewIntent.setObserver(paramWtloginObserver);
    this.app.startServlet(localNewIntent);
    return 0;
  }
  
  public List<WloginLoginInfo> getAllLoginInfo()
  {
    return this.localWtloginHelper.GetAllLoginInfo();
  }
  
  public Boolean getBasicUserInfo(String paramString, WloginSimpleInfo paramWloginSimpleInfo)
  {
    return this.localWtloginHelper.GetBasicUserInfo(paramString, paramWloginSimpleInfo);
  }
  
  public byte[] getGUID()
  {
    return this.localWtloginHelper.GetGuid();
  }
  
  public boolean getHasPwd(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getHasPwd uin= ");
      localStringBuilder.append(paramString);
      QLog.d("sp", 2, localStringBuilder.toString());
    }
    try
    {
      boolean bool = this.localWtloginHelper.getHasPassword(Long.valueOf(paramString).longValue());
      return bool;
    }
    catch (NumberFormatException paramString)
    {
      QLog.d("sp", 1, "getHasPwd e:", paramString);
    }
    return false;
  }
  
  public WUserSigInfo getLocalSig(String paramString, long paramLong)
  {
    return this.localWtloginHelper.GetLocalSig(paramString, paramLong);
  }
  
  public Ticket getLocalTicket(String paramString, long paramLong, int paramInt)
  {
    return this.localWtloginHelper.GetLocalTicket(paramString, paramLong, paramInt);
  }
  
  public int getOpenKeyWithoutPasswd(String paramString, long paramLong1, long paramLong2, WtloginObserver paramWtloginObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
    localNewIntent.putExtra("action", 2208);
    localNewIntent.putExtra("uin", paramString);
    localNewIntent.putExtra("dwSrcAppid", paramLong1);
    localNewIntent.putExtra("dwDstAppid", paramLong2);
    localNewIntent.withouLogin = true;
    localNewIntent.setObserver(paramWtloginObserver);
    this.app.startServlet(localNewIntent);
    return 0;
  }
  
  public byte[] getPkgSigFromApkName(Context paramContext, String paramString)
  {
    return util.getPkgSigFromApkName(paramContext, paramString);
  }
  
  public int getStViaSMSVerifyLogin(String paramString1, String paramString2, int paramInt, WtloginObserver paramWtloginObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
    localNewIntent.putExtra("action", 2121);
    localNewIntent.putExtra("userAccount", paramString2);
    localNewIntent.putExtra("countryCode", paramString1);
    localNewIntent.putExtra("appid", paramInt);
    if ("com.tencent.mobileqq:openSdk".equals(this.app.getApplication().getQQProcessName())) {
      localNewIntent.putExtra("from_where", "ssoAccountAction");
    }
    localNewIntent.withouLogin = true;
    localNewIntent.setObserver(paramWtloginObserver);
    this.app.startServlet(localNewIntent);
    return 0;
  }
  
  public int getStWithPasswd(String paramString1, long paramLong, String paramString2, WtloginObserver paramWtloginObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
    localNewIntent.putExtra("action", 2100);
    localNewIntent.putExtra("uin", paramString1);
    localNewIntent.putExtra("appid", paramLong);
    localNewIntent.putExtra("passwd", paramString2);
    localNewIntent.withouLogin = true;
    localNewIntent.setObserver(paramWtloginObserver);
    this.app.startServlet(localNewIntent);
    return 0;
  }
  
  public int getStWithoutPasswd(String paramString, long paramLong1, long paramLong2, WtloginObserver paramWtloginObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
    localNewIntent.putExtra("action", 2101);
    localNewIntent.putExtra("uin", paramString);
    localNewIntent.putExtra("dwSrcAppid", paramLong1);
    localNewIntent.putExtra("dwDstAppid", paramLong2);
    localNewIntent.withouLogin = true;
    localNewIntent.setObserver(paramWtloginObserver);
    this.app.startServlet(localNewIntent);
    return 0;
  }
  
  public int getSubAccountStViaSMSVerifyLogin(String paramString1, String paramString2, String paramString3, int paramInt, WtloginObserver paramWtloginObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
    localNewIntent.putExtra("action", 2122);
    localNewIntent.putExtra("userAccount", paramString3);
    localNewIntent.putExtra("countryCode", paramString2);
    localNewIntent.putExtra("appid", paramInt);
    localNewIntent.putExtra("mainaccount", paramString1);
    localNewIntent.withouLogin = true;
    localNewIntent.setObserver(paramWtloginObserver);
    this.app.startServlet(localNewIntent);
    return 0;
  }
  
  public boolean isNeedLoginWithPasswd(String paramString, int paramInt)
  {
    return this.localWtloginHelper.IsNeedLoginWithPasswd(paramString, paramInt).booleanValue();
  }
  
  public boolean isUserHaveA1(String paramString, long paramLong)
  {
    return this.localWtloginHelper.IsUserHaveA1(paramString, paramLong).booleanValue();
  }
  
  public boolean isWtLoginUrl(String paramString)
  {
    return this.localWtloginHelper.IsWtLoginUrl(paramString);
  }
  
  public void onDestroy() {}
  
  public int quickLoginByGateway(byte[] paramArrayOfByte, WtloginObserver paramWtloginObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
    localNewIntent.putExtra("action", 2215);
    localNewIntent.putExtra("phoneToken", paramArrayOfByte);
    localNewIntent.withouLogin = true;
    localNewIntent.setObserver(paramWtloginObserver);
    this.app.startServlet(localNewIntent);
    return 0;
  }
  
  public void refreLocalHelper(Context paramContext)
  {
    this.localWtloginHelper = new WtloginHelper(paramContext, true);
  }
  
  public void refreshMemorySig()
  {
    this.localWtloginHelper.RefreshMemorySig();
  }
  
  public int refreshPictureData(String paramString, WtloginObserver paramWtloginObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
    localNewIntent.putExtra("action", 2103);
    localNewIntent.putExtra("uin", paramString);
    localNewIntent.withouLogin = true;
    localNewIntent.setObserver(paramWtloginObserver);
    this.app.startServlet(localNewIntent);
    return 0;
  }
  
  public int refreshSMSData(String paramString, WtloginObserver paramWtloginObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
    localNewIntent.putExtra("action", 2112);
    localNewIntent.putExtra("userAccount", paramString);
    localNewIntent.withouLogin = true;
    localNewIntent.setObserver(paramWtloginObserver);
    this.app.startServlet(localNewIntent);
    return 0;
  }
  
  public int refreshSMSVerifyLoginCode(String paramString1, String paramString2, WtloginObserver paramWtloginObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
    localNewIntent.putExtra("action", 2119);
    localNewIntent.putExtra("userAccount", paramString2);
    localNewIntent.putExtra("countryCode", paramString1);
    localNewIntent.withouLogin = true;
    localNewIntent.setObserver(paramWtloginObserver);
    this.app.startServlet(localNewIntent);
    return 0;
  }
  
  public int regGetSMSVerifyLoginAccount(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString1, String paramString2, WtloginObserver paramWtloginObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
    localNewIntent.putExtra("action", 2117);
    localNewIntent.putExtra("msgchk", paramArrayOfByte1);
    localNewIntent.putExtra("nick", paramArrayOfByte2);
    if ((paramString1 != null) && (paramString1.length() > 0)) {
      localNewIntent.putExtra("unBindlhUin", paramString1);
    }
    localNewIntent.putExtra("appVersion", paramString2);
    localNewIntent.withouLogin = true;
    localNewIntent.setObserver(paramWtloginObserver);
    this.app.startServlet(localNewIntent);
    return 0;
  }
  
  public int regGetSMSVerifyLoginAccountWithLH(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString1, String paramString2, WtloginObserver paramWtloginObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
    localNewIntent.putExtra("action", 2117);
    localNewIntent.putExtra("msgchk", paramArrayOfByte1);
    localNewIntent.putExtra("nick", paramArrayOfByte2);
    localNewIntent.putExtra("lhuin", paramString1);
    localNewIntent.putExtra("appVersion", paramString2);
    localNewIntent.withouLogin = true;
    localNewIntent.setObserver(paramWtloginObserver);
    this.app.startServlet(localNewIntent);
    return 0;
  }
  
  public void setDevLockMobileType(int paramInt)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
    localNewIntent.putExtra("action", 2129);
    localNewIntent.putExtra("mobile_type", paramInt);
    localNewIntent.withouLogin = true;
    this.app.startServlet(localNewIntent);
  }
  
  public void setHasPwd(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setHasPwd uin= ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" hasPwd= ");
      localStringBuilder.append(paramBoolean);
      QLog.d("sp", 2, localStringBuilder.toString());
    }
    this.localWtloginHelper.setHasPassword(Long.valueOf(paramString).longValue(), paramBoolean);
  }
  
  public void setRegDevLockFlag(int paramInt)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
    localNewIntent.putExtra("action", 2125);
    localNewIntent.putExtra("flag", paramInt);
    localNewIntent.withouLogin = true;
    this.app.startServlet(localNewIntent);
  }
  
  public int verifyCode(String paramString, long paramLong, boolean paramBoolean, byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt, WtloginObserver paramWtloginObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
    localNewIntent.putExtra("action", 2104);
    localNewIntent.putExtra("userAccount", paramString);
    localNewIntent.putExtra("appid", paramLong);
    localNewIntent.putExtra("close", paramBoolean);
    localNewIntent.putExtra("code", paramArrayOfByte);
    localNewIntent.putExtra("tlv", paramArrayOfInt);
    localNewIntent.putExtra("version", paramInt);
    localNewIntent.withouLogin = true;
    localNewIntent.setObserver(paramWtloginObserver);
    this.app.startServlet(localNewIntent);
    return 0;
  }
  
  public int verifySMSVerifyLoginCode(String paramString1, String paramString2, String paramString3, WtloginObserver paramWtloginObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), WtloginServlet.class);
    localNewIntent.putExtra("action", 2120);
    localNewIntent.putExtra("userAccount", paramString2);
    localNewIntent.putExtra("countryCode", paramString1);
    localNewIntent.putExtra("code", paramString3);
    localNewIntent.withouLogin = true;
    localNewIntent.setObserver(paramWtloginObserver);
    this.app.startServlet(localNewIntent);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.WtloginManagerImpl
 * JD-Core Version:    0.7.0.1
 */