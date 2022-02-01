import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aext
  implements View.OnClickListener
{
  public aext(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (!bgnt.d(this.a)) {
      this.a.x();
    }
    for (;;)
    {
      abdo.a("see_streetview");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (bgnt.a(this.a)) {
        this.a.p();
      } else {
        bglp.a(this.a, 230).setTitle(this.a.getString(2131689967)).setMessage(2131694137).setPositiveButton(2131690913, new aexv(this)).setNegativeButton(2131690582, new aexu(this)).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aext
 * JD-Core Version:    0.7.0.1
 */