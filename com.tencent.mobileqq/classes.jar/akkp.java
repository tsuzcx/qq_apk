import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NewUpgradeDialog;
import com.tencent.open.appcircle.st.AppCircleReportManager;
import com.tencent.open.appcircle.st.STUtils;
import com.tencent.open.base.LogUtility;
import java.lang.ref.WeakReference;

public class akkp
  implements View.OnClickListener
{
  public akkp(NewUpgradeDialog paramNewUpgradeDialog) {}
  
  public void onClick(View paramView)
  {
    int i = 2;
    LogUtility.b("NewUpgradeDialog", STUtils.a(10010, NewUpgradeDialog.a(), 2, 200));
    AppCircleReportManager.a().a(17, STUtils.a(10010, NewUpgradeDialog.a(), 4, 200));
    this.a.dismiss();
    ((Activity)this.a.a.get()).finish();
    if (NewUpgradeDialog.a() == 2) {
      i = 1;
    }
    ReportController.b(null, "dc00898", "", "", "0X8008FFC", "0X8008FFC", i, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akkp
 * JD-Core Version:    0.7.0.1
 */