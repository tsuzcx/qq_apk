import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;

public class adrj
  implements View.OnClickListener
{
  public adrj(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (!bdin.d(this.a)) {
      this.a.x();
    }
    for (;;)
    {
      zgv.a("see_streetview");
      return;
      if (bdin.a(this.a)) {
        this.a.p();
      } else {
        bdgm.a(this.a, 230).setTitle(this.a.getString(2131690071)).setMessage(2131695059).setPositiveButton(2131691090, new adrl(this)).setNegativeButton(2131690648, new adrk(this)).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adrj
 * JD-Core Version:    0.7.0.1
 */