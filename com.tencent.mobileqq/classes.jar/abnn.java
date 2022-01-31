import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class abnn
  implements DialogInterface.OnClickListener
{
  abnn(abnm paramabnm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.d("nearby.check.auth", 1, "onCheckNearbyUserAuth onClick exit");
    this.a.a.finish();
    if (bbfj.d(BaseApplication.getContext())) {
      aqhw.a(this.a.a.a);
    }
    new axrc(null).a("dc00899").b("grp_lbs").c("home").d("year_pop_clk").e(this.a.a.a.getCurrentAccountUin()).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abnn
 * JD-Core Version:    0.7.0.1
 */