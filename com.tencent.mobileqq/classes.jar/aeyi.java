import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeyi
  extends aeyq
{
  public aeyi(MainFragment paramMainFragment)
  {
    super(null);
  }
  
  public void onClick(View paramView)
  {
    anxr localanxr = this.a.b();
    if ((localanxr instanceof ReadinjoyTabFrame)) {
      ((ReadinjoyTabFrame)localanxr).j();
    }
    pfa.a().l();
    MainFragment.a(MainFragment.a(this.a), MainFragment.a(this.a));
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeyi
 * JD-Core Version:    0.7.0.1
 */