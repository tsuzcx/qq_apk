import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.mobileqq.ar.config.SplashPopupWin;
import com.tencent.mobileqq.ar.config.WorldCupReport;

public class aakc
  implements View.OnClickListener
{
  public aakc(SplashPopupWin paramSplashPopupWin) {}
  
  public void onClick(View paramView)
  {
    if (SplashPopupWin.a(this.a) != null) {
      SplashPopupWin.a(this.a).dismiss();
    }
    WorldCupReport.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aakc
 * JD-Core Version:    0.7.0.1
 */