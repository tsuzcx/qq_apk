import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.SubscribePersonalDetailRequest;

public class aalv
  extends aadf
{
  private String a;
  
  public aalv(String paramString)
  {
    this.a = paramString;
  }
  
  public void a() {}
  
  public void a(aadl paramaadl)
  {
    SubscribePersonalDetailRequest localSubscribePersonalDetailRequest = new SubscribePersonalDetailRequest(this.a, null);
    paramaadl = new aalw(this, paramaadl);
    localSubscribePersonalDetailRequest.setEnableCache(true);
    VSNetworkHelper.a().a(localSubscribePersonalDetailRequest, paramaadl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalv
 * JD-Core Version:    0.7.0.1
 */