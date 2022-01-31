import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.PublicAccountListActivity;

public class abtc
  implements View.OnTouchListener
{
  public abtc(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      this.a.a();
      nol.a(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800573C", "0X800573C", 0, 0, "", "", "", "", false);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abtc
 * JD-Core Version:    0.7.0.1
 */