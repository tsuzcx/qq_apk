import android.content.Intent;
import com.tencent.biz.troop.TroopMemberApiService;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.tools.ErrMsg;

public class aaeh
  extends WtloginListener
{
  public aaeh(TroopMemberApiService paramTroopMemberApiService, WtloginHelper paramWtloginHelper) {}
  
  public void OnException(ErrMsg paramErrMsg, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    super.OnException(paramErrMsg, paramInt, paramWUserSigInfo);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(61, null);
  }
  
  public void onGetA1WithA1(String paramString, long paramLong1, int paramInt1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    if (paramInt2 == 0)
    {
      paramString = this.jdField_a_of_type_OicqWlogin_sdkRequestWtloginHelper.PrepareQloginResult(paramString, paramLong4, paramLong5, paramInt2, paramWFastLoginInfo);
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(61, paramString.getExtras());
      return;
    }
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(61, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaeh
 * JD-Core Version:    0.7.0.1
 */