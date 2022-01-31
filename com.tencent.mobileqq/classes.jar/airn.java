import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

class airn
  implements View.OnClickListener
{
  airn(airm paramairm) {}
  
  public void onClick(View paramView)
  {
    if (airm.a(this.a) == null) {
      return;
    }
    boolean bool = airm.a(this.a).a();
    if (bool)
    {
      airm.a(this.a).setImageDrawable(airm.a(this.a).getContext().getResources().getDrawable(2130838307));
      paramView = this.a;
      if (bool) {
        break label124;
      }
    }
    label124:
    for (bool = true;; bool = false)
    {
      airm.a(paramView, bool);
      airm.a(this.a).a(airm.a(this.a));
      return;
      airm.a(this.a).setImageDrawable(airm.a(this.a).getContext().getResources().getDrawable(2130838306));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     airn
 * JD-Core Version:    0.7.0.1
 */