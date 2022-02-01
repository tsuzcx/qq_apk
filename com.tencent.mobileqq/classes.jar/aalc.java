import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDelFeedRsp;
import android.app.Activity;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;

class aalc
  implements zxa<CertifiedAccountWrite.StDelFeedRsp>
{
  aalc(aakz paramaakz) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDelFeedRsp paramStDelFeedRsp)
  {
    if (this.a.a == null) {
      return;
    }
    if ((!paramBoolean) || (paramLong != 0L))
    {
      QQToast.a(this.a.a, 1, anni.a(2131713341), 0).a();
      return;
    }
    zwp.a().a(new SubscribeFeedsEvent(aakz.a(this.a).a.id.get(), 3));
    this.a.a.finish();
    QQToast.a(this.a.a, anni.a(2131713337), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalc
 * JD-Core Version:    0.7.0.1
 */