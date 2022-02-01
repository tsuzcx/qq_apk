import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.SubscribePersonalDetailRequest;
import com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment;
import com.tencent.mobileqq.pb.PBStringField;

public class aalg
  implements aabr<aagu>
{
  public aalg(SubscribePersonalBottomOpusFragment paramSubscribePersonalBottomOpusFragment) {}
  
  public void a(aabu paramaabu, aagu paramaagu)
  {
    if ((paramaabu.e()) && (this.a.a != null) && (this.a.a.a != null))
    {
      paramaabu = new SubscribePersonalDetailRequest(this.a.a.a.poster.id.get(), paramaabu.b());
      VSNetworkHelper.a().a(paramaabu, new aalh(this, paramaagu));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalg
 * JD-Core Version:    0.7.0.1
 */