import Wallet.IdiomRedPackMatchReq;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

class agjp
  implements agxe
{
  agjp(agjk paramagjk, agjj paramagjj, String paramString, SessionInfo paramSessionInfo, long paramLong, int paramInt) {}
  
  public void a(String paramString)
  {
    int i = 1;
    IdiomRedPackMatchReq localIdiomRedPackMatchReq = new IdiomRedPackMatchReq();
    localIdiomRedPackMatchReq.grabUin = agjk.a(this.jdField_a_of_type_Agjk).getLongAccountUin();
    localIdiomRedPackMatchReq.billno = this.jdField_a_of_type_Agjj.jdField_a_of_type_JavaLangString;
    localIdiomRedPackMatchReq.inputIdiom = this.jdField_a_of_type_JavaLangString;
    localIdiomRedPackMatchReq.hbIdiom = agjk.a(this.jdField_a_of_type_Agjk, this.jdField_a_of_type_Agjj);
    localIdiomRedPackMatchReq.makeUin = Long.parseLong(this.jdField_a_of_type_Agjj.c);
    localIdiomRedPackMatchReq.sKey = paramString;
    localIdiomRedPackMatchReq.appid = AppSetting.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      localIdiomRedPackMatchReq.fromType = i;
      localIdiomRedPackMatchReq.platform = 0;
      localIdiomRedPackMatchReq.qqVersion = "8.2.6";
      agkg.a(localIdiomRedPackMatchReq, new agjq(this));
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
 * Qualified Name:     agjp
 * JD-Core Version:    0.7.0.1
 */