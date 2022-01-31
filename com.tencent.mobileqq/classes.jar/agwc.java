import Wallet.IdiomRedPackMatchReq;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

class agwc
  implements ahjr
{
  agwc(agvx paramagvx, agvw paramagvw, String paramString, SessionInfo paramSessionInfo, long paramLong, int paramInt) {}
  
  public void a(String paramString)
  {
    int i = 1;
    IdiomRedPackMatchReq localIdiomRedPackMatchReq = new IdiomRedPackMatchReq();
    localIdiomRedPackMatchReq.grabUin = agvx.a(this.jdField_a_of_type_Agvx).getLongAccountUin();
    localIdiomRedPackMatchReq.billno = this.jdField_a_of_type_Agvw.jdField_a_of_type_JavaLangString;
    localIdiomRedPackMatchReq.inputIdiom = this.jdField_a_of_type_JavaLangString;
    localIdiomRedPackMatchReq.hbIdiom = agvx.a(this.jdField_a_of_type_Agvx, this.jdField_a_of_type_Agvw);
    localIdiomRedPackMatchReq.makeUin = Long.parseLong(this.jdField_a_of_type_Agvw.c);
    localIdiomRedPackMatchReq.sKey = paramString;
    localIdiomRedPackMatchReq.appid = AppSetting.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      localIdiomRedPackMatchReq.fromType = i;
      localIdiomRedPackMatchReq.platform = 0;
      localIdiomRedPackMatchReq.qqVersion = "8.3.0";
      agwt.a(localIdiomRedPackMatchReq, new agwd(this));
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agwc
 * JD-Core Version:    0.7.0.1
 */