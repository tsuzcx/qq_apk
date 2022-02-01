import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.network.DoLikeRequest;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aabu
  implements View.OnClickListener
{
  public aabu(RelativeFeedItemView paramRelativeFeedItemView, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void onClick(View paramView)
  {
    if ((!RelativeFeedItemView.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeFeedItemView)) || (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeFeedItemView.a() == null) || (!zqn.a(((CertifiedAccountMeta.StFeed)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeFeedItemView.a()).status.get()))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!RelativeFeedItemView.b(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeFeedItemView))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeFeedItemView.getContext(), anvx.a(2131712827), 0).a();
      }
      else
      {
        RelativeFeedItemView.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeFeedItemView, false);
        DoLikeRequest localDoLikeRequest = new DoLikeRequest(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
        VSNetworkHelper.getInstance().sendRequest(localDoLikeRequest, new aabv(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aabu
 * JD-Core Version:    0.7.0.1
 */