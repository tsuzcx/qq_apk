import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;

public class abvm
  implements View.OnClickListener
{
  public abvm(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (!bbfj.d(this.a)) {
      this.a.x();
    }
    for (;;)
    {
      xnn.a("see_streetview");
      return;
      if (bbfj.a(this.a)) {
        this.a.p();
      } else {
        bbdj.a(this.a, 230).setTitle(this.a.getString(2131690024)).setMessage(2131694900).setPositiveButton(2131691036, new abvo(this)).setNegativeButton(2131690596, new abvn(this)).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abvm
 * JD-Core Version:    0.7.0.1
 */