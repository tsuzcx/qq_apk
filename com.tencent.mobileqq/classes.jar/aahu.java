import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.SubscribePersonalDetailRequest;

public class aahu
  extends zzj
{
  private String a;
  
  public aahu(String paramString)
  {
    this.a = paramString;
  }
  
  public void a() {}
  
  public void a(zzp paramzzp)
  {
    SubscribePersonalDetailRequest localSubscribePersonalDetailRequest = new SubscribePersonalDetailRequest(this.a, null);
    paramzzp = new aahv(this, paramzzp);
    localSubscribePersonalDetailRequest.setEnableCache(true);
    VSNetworkHelper.a().a(localSubscribePersonalDetailRequest, paramzzp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aahu
 * JD-Core Version:    0.7.0.1
 */