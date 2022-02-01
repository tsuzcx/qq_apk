import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afgy
  implements View.OnClickListener
{
  public afgy(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (!bhnv.d(this.a)) {
      this.a.x();
    }
    for (;;)
    {
      abhr.a("see_streetview");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (bhnv.a(this.a)) {
        this.a.p();
      } else {
        bhlq.a(this.a, 230).setTitle(this.a.getString(2131689974)).setMessage(2131694155).setPositiveButton(2131690913, new afha(this)).setNegativeButton(2131690580, new afgz(this)).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afgy
 * JD-Core Version:    0.7.0.1
 */