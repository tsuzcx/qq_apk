import Wallet.GetRandomHbIdiomReq;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.observer.BusinessObserver;

class agwg
  implements ahjt
{
  agwg(agvz paramagvz, int paramInt, BusinessObserver paramBusinessObserver) {}
  
  public void a(String paramString)
  {
    if (agvz.a(this.jdField_a_of_type_Agvz) != null)
    {
      GetRandomHbIdiomReq localGetRandomHbIdiomReq = new GetRandomHbIdiomReq();
      localGetRandomHbIdiomReq.makeUin = agvz.a(this.jdField_a_of_type_Agvz).getLongAccountUin();
      localGetRandomHbIdiomReq.sKey = paramString;
      localGetRandomHbIdiomReq.appid = AppSetting.a();
      localGetRandomHbIdiomReq.fromType = this.jdField_a_of_type_Int;
      localGetRandomHbIdiomReq.platform = 0;
      localGetRandomHbIdiomReq.qqVersion = "8.2.8";
      agwv.a(localGetRandomHbIdiomReq, this.jdField_a_of_type_MqqObserverBusinessObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agwg
 * JD-Core Version:    0.7.0.1
 */