import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.remind.widget.IosTimepicker;
import com.tencent.widget.ActionSheet;

public class agsb
  implements View.OnClickListener
{
  public agsb(IosTimepicker paramIosTimepicker) {}
  
  public void onClick(View paramView)
  {
    if ((IosTimepicker.a(this.a) != null) && (IosTimepicker.a(this.a).isShowing()))
    {
      IosTimepicker.a(this.a).dismiss();
      IosTimepicker.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     agsb
 * JD-Core Version:    0.7.0.1
 */