import Wallet.IdiomRedPackMatchReq;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

class aiqb
  implements ajba
{
  aiqb(aipw paramaipw, aipv paramaipv, String paramString, SessionInfo paramSessionInfo, long paramLong, int paramInt) {}
  
  public void a(String paramString)
  {
    int i = 1;
    IdiomRedPackMatchReq localIdiomRedPackMatchReq = new IdiomRedPackMatchReq();
    localIdiomRedPackMatchReq.grabUin = aipw.a(this.jdField_a_of_type_Aipw).getLongAccountUin();
    localIdiomRedPackMatchReq.billno = this.jdField_a_of_type_Aipv.jdField_a_of_type_JavaLangString;
    localIdiomRedPackMatchReq.inputIdiom = this.jdField_a_of_type_JavaLangString;
    localIdiomRedPackMatchReq.hbIdiom = aipw.a(this.jdField_a_of_type_Aipw, this.jdField_a_of_type_Aipv);
    localIdiomRedPackMatchReq.makeUin = Long.parseLong(this.jdField_a_of_type_Aipv.c);
    localIdiomRedPackMatchReq.sKey = paramString;
    localIdiomRedPackMatchReq.appid = AppSetting.a();
    localIdiomRedPackMatchReq.subchannel = this.jdField_a_of_type_Aipv.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      localIdiomRedPackMatchReq.fromType = i;
      localIdiomRedPackMatchReq.platform = 0;
      localIdiomRedPackMatchReq.qqVersion = "8.3.3";
      aiqs.a(localIdiomRedPackMatchReq, new aiqc(this));
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
 * Qualified Name:     aiqb
 * JD-Core Version:    0.7.0.1
 */