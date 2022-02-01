import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class adro
  extends amxe
{
  public adro(NearbyActivity paramNearbyActivity) {}
  
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
          QQCustomDialog localQQCustomDialog = bfur.a(this.a, 230);
          localQQCustomDialog.setCancelable(false);
          String str = paramString;
          if (TextUtils.isEmpty(paramString)) {
            str = amtj.a(2131706217);
          }
          localQQCustomDialog.setMessage(str);
          localQQCustomDialog.setNegativeButton(amtj.a(2131706218), new adrp(this));
          localQQCustomDialog.show();
          new bcek(null).a("dc00899").b("grp_lbs").c("home").d("year_pop_exp").e(this.a.a.getCurrentAccountUin()).a();
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
        this.a.b.removeMessages(1000);
        this.a.b.sendEmptyMessageDelayed(1000, this.a.n);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adro
 * JD-Core Version:    0.7.0.1
 */