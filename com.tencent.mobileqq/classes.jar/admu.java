import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;

public class admu
  implements View.OnClickListener
{
  public admu(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (!bdee.d(this.a)) {
      this.a.x();
    }
    for (;;)
    {
      zcg.a("see_streetview");
      return;
      if (bdee.a(this.a)) {
        this.a.p();
      } else {
        bdcd.a(this.a, 230).setTitle(this.a.getString(2131690071)).setMessage(2131695057).setPositiveButton(2131691089, new admw(this)).setNegativeButton(2131690648, new admv(this)).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     admu
 * JD-Core Version:    0.7.0.1
 */