import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.KPLProfileCardActivity;

public class adfn
  implements View.OnTouchListener
{
  public adfn(KPLProfileCardActivity paramKPLProfileCardActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.a.a)
    {
      azqs.b(this.a.app, "dc00898", "", "", "0X8008438", "0X8008438", 0, 0, "", "", "", "");
      this.a.a = true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adfn
 * JD-Core Version:    0.7.0.1
 */