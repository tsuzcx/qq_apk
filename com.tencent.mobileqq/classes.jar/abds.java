import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;

public class abds
  extends ajne
{
  public abds(NearbyActivity paramNearbyActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString)
  {
    QLog.d("nearby.check.auth", 1, "onCheckNearbyUserAuth isSuccess=" + paramBoolean + ", checkRet=" + paramInt + ", checkMsg=" + paramString + ", isFinishing=" + this.a.isFinishing() + ", isStopHeartBeat=" + this.a.c);
    if ((paramBoolean) && (paramInt != 0)) {
      if (!this.a.isFinishing()) {}
    }
    while ((this.a.isFinishing()) || (this.a.c))
    {
      do
      {
        return;
        try
        {
          bafb localbafb = babr.a(this.a, 230);
          localbafb.setCancelable(false);
          String str = paramString;
          if (TextUtils.isEmpty(paramString)) {
            str = ajjy.a(2131641309);
          }
          localbafb.setMessage(str);
          localbafb.setNegativeButton(ajjy.a(2131641310), new abdt(this));
          localbafb.show();
          new awrb(null).a("dc00899").b("grp_lbs").c("home").d("year_pop_exp").e(this.a.a.getCurrentAccountUin()).a();
          return;
        }
        catch (Exception paramString) {}
      } while (!QLog.isColorLevel());
      QLog.d("nearby.NearbyActivity", 2, "onCheckNearbyUserAuth exp:" + paramString.toString());
      return;
    }
    this.a.e();
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearby.heart_beat", 2, "onNearbyHeartBeat:isSucc=" + paramBoolean + ", cmd=" + paramString + ", interval=" + paramLong);
    }
    if ("OidbSvc.0xafc_1".equals(paramString))
    {
      if (paramBoolean) {
        this.a.n = paramLong;
      }
      if (!this.a.c)
      {
        this.a.b.removeMessages(this.a.i);
        this.a.b.sendEmptyMessageDelayed(this.a.i, this.a.n);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abds
 * JD-Core Version:    0.7.0.1
 */