import android.text.TextUtils;
import com.tencent.mobileqq.activity.RewardNoticeActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class adqs
  extends alka
{
  public adqs(RewardNoticeActivity paramRewardNoticeActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(this.a.f)) {
        QQToast.a(this.a.app.getApp(), 2, this.a.f, 0).a();
      }
      if (this.a.a == 13) {
        this.a.b();
      }
      this.a.finish();
      return;
    }
    QQToast.a(this.a.app.getApp(), 1, alpo.a(2131713825), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adqs
 * JD-Core Version:    0.7.0.1
 */