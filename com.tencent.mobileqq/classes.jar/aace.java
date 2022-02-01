import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.fragments.SubscribeBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aace
  implements View.OnClickListener
{
  aace(aacd paramaacd) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.getParentFragment() instanceof SubscribeBaseFragment)) {
      ((SubscribeBaseFragment)this.a.getParentFragment()).a(this.a.a(2));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aace
 * JD-Core Version:    0.7.0.1
 */