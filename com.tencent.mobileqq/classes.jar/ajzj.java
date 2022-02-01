import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajzj
  extends ajzq
{
  public ajzj(MainFragment paramMainFragment)
  {
    super(null);
  }
  
  public void onClick(View paramView)
  {
    anun localanun = this.a.b();
    if ((localanun instanceof ReadinjoyTabFrame)) {
      ((ReadinjoyTabFrame)localanun).j();
    }
    pvj.a().l();
    MainFragment.a(MainFragment.a(this.a), MainFragment.a(this.a));
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzj
 * JD-Core Version:    0.7.0.1
 */