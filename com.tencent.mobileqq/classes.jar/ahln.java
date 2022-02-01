import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahln
  implements View.OnClickListener
{
  ahln(ahll paramahll) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131363793) {
      ahll.a(this.a).a(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131363794) {
        ahll.a(this.a).b(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahln
 * JD-Core Version:    0.7.0.1
 */