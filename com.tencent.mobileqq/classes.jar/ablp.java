import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;

public class ablp
  implements View.OnClickListener
{
  public ablp(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (!badq.d(this.a)) {
      this.a.x();
    }
    for (;;)
    {
      xeq.a("see_streetview");
      return;
      if (badq.a(this.a)) {
        this.a.p();
      } else {
        babr.a(this.a, 230).setTitle(this.a.getString(2131624470)).setMessage(2131629222).setPositiveButton(2131625464, new ablr(this)).setNegativeButton(2131625035, new ablq(this)).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ablp
 * JD-Core Version:    0.7.0.1
 */