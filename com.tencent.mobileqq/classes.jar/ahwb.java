import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahwb
  implements View.OnClickListener
{
  ahwb(ahvz paramahvz) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131363693) {
      ahvz.a(this.a).a(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131363694) {
        ahvz.a(this.a).b(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahwb
 * JD-Core Version:    0.7.0.1
 */