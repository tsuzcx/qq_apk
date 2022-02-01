import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.fragments.SubscribeBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aagj
  implements View.OnClickListener
{
  aagj(aagi paramaagi) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.getParentFragment() instanceof SubscribeBaseFragment)) {
      ((SubscribeBaseFragment)this.a.getParentFragment()).a(this.a.a(2));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aagj
 * JD-Core Version:    0.7.0.1
 */