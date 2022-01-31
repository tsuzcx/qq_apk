import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;

public class abvq
  implements View.OnClickListener
{
  public abvq(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (!bbev.d(this.a)) {
      this.a.x();
    }
    for (;;)
    {
      xnq.a("see_streetview");
      return;
      if (bbev.a(this.a)) {
        this.a.p();
      } else {
        bbcv.a(this.a, 230).setTitle(this.a.getString(2131690024)).setMessage(2131694899).setPositiveButton(2131691036, new abvs(this)).setNegativeButton(2131690596, new abvr(this)).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abvq
 * JD-Core Version:    0.7.0.1
 */