import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class afjf
  implements View.OnClickListener
{
  afjf(afiw paramafiw) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.hasDestory) {
      acvv.a(this.a.sessionInfo, this.a.app, this.a.getActivity());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afjf
 * JD-Core Version:    0.7.0.1
 */