import Wallet.IdiomRedPackMatchReq;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

class akqj
  implements alct
{
  akqj(akqe paramakqe, akqd paramakqd, String paramString, SessionInfo paramSessionInfo, long paramLong, int paramInt) {}
  
  public void a(String paramString)
  {
    int i = 1;
    IdiomRedPackMatchReq localIdiomRedPackMatchReq = new IdiomRedPackMatchReq();
    localIdiomRedPackMatchReq.grabUin = akqe.a(this.jdField_a_of_type_Akqe).getLongAccountUin();
    localIdiomRedPackMatchReq.billno = this.jdField_a_of_type_Akqd.jdField_a_of_type_JavaLangString;
    localIdiomRedPackMatchReq.inputIdiom = this.jdField_a_of_type_JavaLangString;
    localIdiomRedPackMatchReq.hbIdiom = akqe.a(this.jdField_a_of_type_Akqe, this.jdField_a_of_type_Akqd);
    localIdiomRedPackMatchReq.makeUin = Long.parseLong(this.jdField_a_of_type_Akqd.c);
    localIdiomRedPackMatchReq.sKey = paramString;
    localIdiomRedPackMatchReq.appid = AppSetting.a();
    localIdiomRedPackMatchReq.subchannel = this.jdField_a_of_type_Akqd.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) {}
    for (;;)
    {
      localIdiomRedPackMatchReq.fromType = i;
      localIdiomRedPackMatchReq.platform = 0;
      localIdiomRedPackMatchReq.qqVersion = "8.4.10";
      akra.a(localIdiomRedPackMatchReq, new akqk(this));
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
 * Qualified Name:     akqj
 * JD-Core Version:    0.7.0.1
 */