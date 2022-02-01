import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import android.view.View;
import com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;

public class aalf
  implements aagy
{
  public aalf(SubscribePersonalBottomOpusFragment paramSubscribePersonalBottomOpusFragment) {}
  
  public void a(View paramView, CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null) {
      if (!paramStFeed.id.get().startsWith("fakeid_")) {
        break label40;
      }
    }
    label40:
    do
    {
      QQToast.a(this.a.getActivity(), anzj.a(2131713447), 0).a();
      do
      {
        return;
      } while (!(paramView instanceof RelativeFeedItemView));
      paramView = (RelativeFeedItemView)paramView;
    } while (paramView.a == null);
    aaej.a(this.a.getActivity(), paramStFeed, 0, aame.a(paramView.a, paramStFeed.cover.width.get(), paramStFeed.cover.height.get()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalf
 * JD-Core Version:    0.7.0.1
 */