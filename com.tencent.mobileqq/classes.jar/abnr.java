import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class abnr
  implements DialogInterface.OnClickListener
{
  abnr(abnq paramabnq) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.d("nearby.check.auth", 1, "onCheckNearbyUserAuth onClick exit");
    this.a.a.finish();
    if (bbev.d(BaseApplication.getContext())) {
      aqhu.a(this.a.a.a);
    }
    new axra(null).a("dc00899").b("grp_lbs").c("home").d("year_pop_clk").e(this.a.a.a.getCurrentAccountUin()).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abnr
 * JD-Core Version:    0.7.0.1
 */