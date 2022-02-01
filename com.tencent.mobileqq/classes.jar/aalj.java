import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aalj
  implements View.OnClickListener
{
  public aalj(SubscribePersonalBottomOpusFragment paramSubscribePersonalBottomOpusFragment, aaks paramaaks) {}
  
  public void onClick(View paramView)
  {
    aaej.a("https://h5.qzone.qq.com/subscription/syncFeeds/{uin}?_proxy=1&_wv=3".replace("{uin}", this.jdField_a_of_type_Aaks.a.poster.id.get()));
    abbe.b(this.jdField_a_of_type_Aaks.a.poster.id.get(), "auth_person", "sync_qzone", 0, 0, new String[0]);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalj
 * JD-Core Version:    0.7.0.1
 */