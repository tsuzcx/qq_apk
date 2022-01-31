import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.EditActivity;

public class acqq
  implements View.OnClickListener
{
  public acqq(EditActivity paramEditActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a;
    if (!EditActivity.a(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      EditActivity.a(paramView, bool);
      if (!EditActivity.a(this.a)) {
        break;
      }
      this.a.e();
      EditActivity.a(this.a).setImageResource(2130837978);
      if (EditActivity.a(this.a) != null) {
        EditActivity.a(this.a).setVisibility(0);
      }
      return;
    }
    if (EditActivity.a(this.a) != null) {
      EditActivity.a(this.a).setVisibility(4);
    }
    EditActivity.a(this.a).setImageResource(2130847355);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqq
 * JD-Core Version:    0.7.0.1
 */