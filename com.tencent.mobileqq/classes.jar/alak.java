import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

class alak
  implements View.OnClickListener
{
  alak(alaj paramalaj) {}
  
  public void onClick(View paramView)
  {
    if (alaj.a(this.a) == null) {
      return;
    }
    boolean bool = alaj.a(this.a).a();
    if (bool)
    {
      alaj.a(this.a).setImageDrawable(alaj.a(this.a).getContext().getResources().getDrawable(2130838376));
      paramView = this.a;
      if (bool) {
        break label124;
      }
    }
    label124:
    for (bool = true;; bool = false)
    {
      alaj.a(paramView, bool);
      alaj.a(this.a).a(alaj.a(this.a));
      return;
      alaj.a(this.a).setImageDrawable(alaj.a(this.a).getContext().getResources().getDrawable(2130838375));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alak
 * JD-Core Version:    0.7.0.1
 */