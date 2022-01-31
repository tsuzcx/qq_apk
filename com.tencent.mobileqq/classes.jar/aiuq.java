import Wallet.IdiomRedPackMatchReq;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

class aiuq
  implements ajfp
{
  aiuq(aiul paramaiul, aiuk paramaiuk, String paramString, SessionInfo paramSessionInfo, long paramLong, int paramInt) {}
  
  public void a(String paramString)
  {
    int i = 1;
    IdiomRedPackMatchReq localIdiomRedPackMatchReq = new IdiomRedPackMatchReq();
    localIdiomRedPackMatchReq.grabUin = aiul.a(this.jdField_a_of_type_Aiul).getLongAccountUin();
    localIdiomRedPackMatchReq.billno = this.jdField_a_of_type_Aiuk.jdField_a_of_type_JavaLangString;
    localIdiomRedPackMatchReq.inputIdiom = this.jdField_a_of_type_JavaLangString;
    localIdiomRedPackMatchReq.hbIdiom = aiul.a(this.jdField_a_of_type_Aiul, this.jdField_a_of_type_Aiuk);
    localIdiomRedPackMatchReq.makeUin = Long.parseLong(this.jdField_a_of_type_Aiuk.c);
    localIdiomRedPackMatchReq.sKey = paramString;
    localIdiomRedPackMatchReq.appid = AppSetting.a();
    localIdiomRedPackMatchReq.subchannel = this.jdField_a_of_type_Aiuk.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      localIdiomRedPackMatchReq.fromType = i;
      localIdiomRedPackMatchReq.platform = 0;
      localIdiomRedPackMatchReq.qqVersion = "8.3.5";
      aivh.a(localIdiomRedPackMatchReq, new aiur(this));
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiuq
 * JD-Core Version:    0.7.0.1
 */