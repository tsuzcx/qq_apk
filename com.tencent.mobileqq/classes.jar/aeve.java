import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.KPLProfileCardActivity;

public class aeve
  implements View.OnTouchListener
{
  public aeve(KPLProfileCardActivity paramKPLProfileCardActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.a.a)
    {
      bdll.b(this.a.app, "dc00898", "", "", "0X8008438", "0X8008438", 0, 0, "", "", "", "");
      this.a.a = true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeve
 * JD-Core Version:    0.7.0.1
 */