import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class alxv
  implements View.OnClickListener
{
  alxv(alxu paramalxu) {}
  
  public void onClick(View paramView)
  {
    alxu.a(this.a, true);
    this.a.a();
    alxu.a(this.a, -1, -1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alxv
 * JD-Core Version:    0.7.0.1
 */