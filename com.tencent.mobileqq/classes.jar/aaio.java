import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.tools.ErrMsg;

public class aaio
  extends WtloginObserver
{
  public aaio(ArkAppModuleReg.ModuleQQ paramModuleQQ, long paramLong) {}
  
  public void OnGetOpenKeyWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp", 2, "OnGetOpenKeyWithoutPasswd userAccount=" + paramString + ", dwSrcAppid=" + paramLong1 + ", dwDstAppid=" + paramLong2 + ", dwMainSigMap=" + paramInt1 + ", ret=" + paramInt2);
    }
    ArkAppCenter.a().post(new aaip(this, paramInt2, paramArrayOfByte1, paramArrayOfByte2, paramLong2, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaio
 * JD-Core Version:    0.7.0.1
 */