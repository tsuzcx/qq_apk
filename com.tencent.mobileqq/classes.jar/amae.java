import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amae
  implements View.OnClickListener
{
  amae(amad paramamad) {}
  
  public void onClick(View paramView)
  {
    if (amad.a(this.a) == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    boolean bool = amad.a(this.a).a();
    label63:
    amad localamad;
    if (bool)
    {
      amad.a(this.a).setImageDrawable(amad.a(this.a).getContext().getResources().getDrawable(2130838513));
      localamad = this.a;
      if (bool) {
        break label133;
      }
    }
    label133:
    for (bool = true;; bool = false)
    {
      amad.a(localamad, bool);
      amad.a(this.a).a(amad.a(this.a));
      break;
      amad.a(this.a).setImageDrawable(amad.a(this.a).getContext().getResources().getDrawable(2130838512));
      break label63;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amae
 * JD-Core Version:    0.7.0.1
 */