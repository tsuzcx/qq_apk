import Wallet.GetRandomHbIdiomReq;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.observer.BusinessObserver;

class agwe
  implements ahjr
{
  agwe(agvx paramagvx, int paramInt, BusinessObserver paramBusinessObserver) {}
  
  public void a(String paramString)
  {
    if (agvx.a(this.jdField_a_of_type_Agvx) != null)
    {
      GetRandomHbIdiomReq localGetRandomHbIdiomReq = new GetRandomHbIdiomReq();
      localGetRandomHbIdiomReq.makeUin = agvx.a(this.jdField_a_of_type_Agvx).getLongAccountUin();
      localGetRandomHbIdiomReq.sKey = paramString;
      localGetRandomHbIdiomReq.appid = AppSetting.a();
      localGetRandomHbIdiomReq.fromType = this.jdField_a_of_type_Int;
      localGetRandomHbIdiomReq.platform = 0;
      localGetRandomHbIdiomReq.qqVersion = "8.3.0";
      agwt.a(localGetRandomHbIdiomReq, this.jdField_a_of_type_MqqObserverBusinessObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agwe
 * JD-Core Version:    0.7.0.1
 */