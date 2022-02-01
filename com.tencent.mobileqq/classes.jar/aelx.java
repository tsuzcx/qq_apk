import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aelx
  implements View.OnClickListener
{
  public aelx(EditActivity paramEditActivity) {}
  
  public void onClick(View paramView)
  {
    EditActivity localEditActivity = this.a;
    boolean bool;
    if (!EditActivity.a(this.a))
    {
      bool = true;
      EditActivity.a(localEditActivity, bool);
      if (!EditActivity.a(this.a)) {
        break label86;
      }
      this.a.e();
      EditActivity.a(this.a).setImageResource(2130838083);
      if (EditActivity.a(this.a) != null) {
        EditActivity.a(this.a).setVisibility(0);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool = false;
      break;
      label86:
      if (EditActivity.a(this.a) != null) {
        EditActivity.a(this.a).setVisibility(4);
      }
      EditActivity.a(this.a).setImageResource(2130847906);
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aelx
 * JD-Core Version:    0.7.0.1
 */