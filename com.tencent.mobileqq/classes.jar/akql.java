import Wallet.GetRandomHbIdiomReq;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.observer.BusinessObserver;

class akql
  implements alct
{
  akql(akqe paramakqe, int paramInt1, int paramInt2, BusinessObserver paramBusinessObserver) {}
  
  public void a(String paramString)
  {
    if (akqe.a(this.jdField_a_of_type_Akqe) != null)
    {
      GetRandomHbIdiomReq localGetRandomHbIdiomReq = new GetRandomHbIdiomReq();
      localGetRandomHbIdiomReq.makeUin = akqe.a(this.jdField_a_of_type_Akqe).getLongAccountUin();
      localGetRandomHbIdiomReq.subchannel = this.jdField_a_of_type_Int;
      localGetRandomHbIdiomReq.sKey = paramString;
      localGetRandomHbIdiomReq.appid = AppSetting.a();
      localGetRandomHbIdiomReq.fromType = this.b;
      localGetRandomHbIdiomReq.platform = 0;
      localGetRandomHbIdiomReq.qqVersion = "8.4.10";
      akra.a(localGetRandomHbIdiomReq, this.jdField_a_of_type_MqqObserverBusinessObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akql
 * JD-Core Version:    0.7.0.1
 */