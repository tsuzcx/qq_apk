import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.SubscribePersonalDetailRequest;
import com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment;
import com.tencent.mobileqq.pb.PBStringField;

public class aahf
  implements zxw<aacp>
{
  public aahf(SubscribePersonalBottomOpusFragment paramSubscribePersonalBottomOpusFragment) {}
  
  public void a(zxz paramzxz, aacp paramaacp)
  {
    if ((paramzxz.e()) && (this.a.a != null) && (this.a.a.a != null))
    {
      paramzxz = new SubscribePersonalDetailRequest(this.a.a.a.poster.id.get(), paramzxz.b());
      VSNetworkHelper.a().a(paramzxz, new aahg(this, paramaacp));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aahf
 * JD-Core Version:    0.7.0.1
 */