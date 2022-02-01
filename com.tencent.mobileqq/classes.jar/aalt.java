import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.network.GetSubscribeFeedDetailRequest;

public class aalt
  extends aadf
{
  private CertifiedAccountMeta.StFeed a;
  
  public aalt(CertifiedAccountMeta.StFeed paramStFeed)
  {
    this.a = paramStFeed;
  }
  
  public void a() {}
  
  public void a(aadl paramaadl)
  {
    GetSubscribeFeedDetailRequest localGetSubscribeFeedDetailRequest = new GetSubscribeFeedDetailRequest(this.a, null);
    paramaadl = new aalu(this, paramaadl);
    localGetSubscribeFeedDetailRequest.setEnableCache(false);
    VSNetworkHelper.a().a(localGetSubscribeFeedDetailRequest, paramaadl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalt
 * JD-Core Version:    0.7.0.1
 */