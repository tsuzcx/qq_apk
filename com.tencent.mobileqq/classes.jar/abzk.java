import android.text.TextUtils;
import com.tencent.mobileqq.activity.RewardNoticeActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class abzk
  extends ajsn
{
  public abzk(RewardNoticeActivity paramRewardNoticeActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(this.a.f)) {
        bcql.a(this.a.app.getApp(), 2, this.a.f, 0).a();
      }
      if (this.a.a == 13) {
        this.a.b();
      }
      this.a.finish();
      return;
    }
    bcql.a(this.a.app.getApp(), 1, ajya.a(2131713453), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abzk
 * JD-Core Version:    0.7.0.1
 */