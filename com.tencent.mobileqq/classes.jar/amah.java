import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amah
  implements View.OnClickListener
{
  amah(amad paramamad) {}
  
  public void onClick(View paramView)
  {
    if ((amad.a(this.a).d()) || (amad.b(this.a)))
    {
      amad.b(this.a, false);
      amad.a(this.a).a();
      amad.c(this.a).setVisibility(8);
      amad.b(this.a).setVisibility(8);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (amad.a(this.a).c())
      {
        amad.b(this.a, true);
        amad.a(this.a).b();
        amad.b(this.a).setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amah
 * JD-Core Version:    0.7.0.1
 */