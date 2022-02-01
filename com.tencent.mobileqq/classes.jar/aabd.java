import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDelFeedRsp;
import android.app.Activity;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;

class aabd
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountWrite.StDelFeedRsp>
{
  aabd(aaba paramaaba) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDelFeedRsp paramStDelFeedRsp)
  {
    if (this.a.a == null) {
      return;
    }
    if ((!paramBoolean) || (paramLong != 0L))
    {
      QQToast.a(this.a.a, 1, anvx.a(2131714029), 0).a();
      return;
    }
    SimpleEventBus.getInstance().dispatchEvent(new SubscribeFeedsEvent(aaba.a(this.a).a.id.get(), 3));
    this.a.a.finish();
    QQToast.a(this.a.a, anvx.a(2131714025), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aabd
 * JD-Core Version:    0.7.0.1
 */