import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class ader
  implements DialogInterface.OnClickListener
{
  ader(adeq paramadeq) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.d("nearby.check.auth", 1, "onCheckNearbyUserAuth onClick exit");
    this.a.a.finish();
    if (bdee.d(BaseApplication.getContext())) {
      asbl.a(this.a.a.a);
    }
    new azmo(null).a("dc00899").b("grp_lbs").c("home").d("year_pop_clk").e(this.a.a.a.getCurrentAccountUin()).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ader
 * JD-Core Version:    0.7.0.1
 */