import Wallet.GetBroadCastHbIdiomReq;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import java.util.ArrayList;

class aiuo
  implements ajfp
{
  aiuo(aiul paramaiul, ArrayList paramArrayList, SessionInfo paramSessionInfo) {}
  
  public void a(String paramString)
  {
    int i = 1;
    GetBroadCastHbIdiomReq localGetBroadCastHbIdiomReq = new GetBroadCastHbIdiomReq();
    localGetBroadCastHbIdiomReq.billnos = this.jdField_a_of_type_JavaUtilArrayList;
    localGetBroadCastHbIdiomReq.sKey = paramString;
    localGetBroadCastHbIdiomReq.appid = AppSetting.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1) {}
    for (;;)
    {
      localGetBroadCastHbIdiomReq.fromType = i;
      localGetBroadCastHbIdiomReq.platform = 0;
      localGetBroadCastHbIdiomReq.qqVersion = "8.3.5";
      aivh.a(localGetBroadCastHbIdiomReq, new aiup(this));
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 3000) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiuo
 * JD-Core Version:    0.7.0.1
 */