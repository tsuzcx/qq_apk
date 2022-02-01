import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDelFeedRsp;
import android.app.Activity;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;

class aapd
  implements aaav<CertifiedAccountWrite.StDelFeedRsp>
{
  aapd(aapa paramaapa) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDelFeedRsp paramStDelFeedRsp)
  {
    if (this.a.a == null) {
      return;
    }
    if ((!paramBoolean) || (paramLong != 0L))
    {
      QQToast.a(this.a.a, 1, anzj.a(2131713450), 0).a();
      return;
    }
    aaak.a().a(new SubscribeFeedsEvent(aapa.a(this.a).a.id.get(), 3));
    this.a.a.finish();
    QQToast.a(this.a.a, anzj.a(2131713446), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapd
 * JD-Core Version:    0.7.0.1
 */