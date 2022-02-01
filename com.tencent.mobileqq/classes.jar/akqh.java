import Wallet.GetBroadCastHbIdiomReq;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import java.util.ArrayList;

class akqh
  implements alct
{
  akqh(akqe paramakqe, ArrayList paramArrayList, SessionInfo paramSessionInfo) {}
  
  public void a(String paramString)
  {
    int i = 1;
    GetBroadCastHbIdiomReq localGetBroadCastHbIdiomReq = new GetBroadCastHbIdiomReq();
    localGetBroadCastHbIdiomReq.billnos = this.jdField_a_of_type_JavaUtilArrayList;
    localGetBroadCastHbIdiomReq.sKey = paramString;
    localGetBroadCastHbIdiomReq.appid = AppSetting.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) {}
    for (;;)
    {
      localGetBroadCastHbIdiomReq.fromType = i;
      localGetBroadCastHbIdiomReq.platform = 0;
      localGetBroadCastHbIdiomReq.qqVersion = "8.4.10";
      akra.a(localGetBroadCastHbIdiomReq, new akqi(this));
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akqh
 * JD-Core Version:    0.7.0.1
 */