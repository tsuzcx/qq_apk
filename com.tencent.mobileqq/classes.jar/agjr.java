import Wallet.GetRandomHbIdiomReq;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.observer.BusinessObserver;

class agjr
  implements agxe
{
  agjr(agjk paramagjk, int paramInt, BusinessObserver paramBusinessObserver) {}
  
  public void a(String paramString)
  {
    if (agjk.a(this.jdField_a_of_type_Agjk) != null)
    {
      GetRandomHbIdiomReq localGetRandomHbIdiomReq = new GetRandomHbIdiomReq();
      localGetRandomHbIdiomReq.makeUin = agjk.a(this.jdField_a_of_type_Agjk).getLongAccountUin();
      localGetRandomHbIdiomReq.sKey = paramString;
      localGetRandomHbIdiomReq.appid = AppSetting.a();
      localGetRandomHbIdiomReq.fromType = this.jdField_a_of_type_Int;
      localGetRandomHbIdiomReq.platform = 0;
      localGetRandomHbIdiomReq.qqVersion = "8.2.6";
      agkg.a(localGetRandomHbIdiomReq, this.jdField_a_of_type_MqqObserverBusinessObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agjr
 * JD-Core Version:    0.7.0.1
 */