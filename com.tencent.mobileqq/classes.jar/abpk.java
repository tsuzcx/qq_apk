import android.text.TextUtils;
import com.tencent.mobileqq.activity.RewardNoticeActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class abpk
  extends ajen
{
  public abpk(RewardNoticeActivity paramRewardNoticeActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(this.a.f)) {
        bbmy.a(this.a.app.getApp(), 2, this.a.f, 0).a();
      }
      if (this.a.a == 13) {
        this.a.b();
      }
      this.a.finish();
      return;
    }
    bbmy.a(this.a.app.getApp(), 1, ajjy.a(2131647654), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abpk
 * JD-Core Version:    0.7.0.1
 */