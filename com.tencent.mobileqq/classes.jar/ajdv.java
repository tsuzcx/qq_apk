import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajdv
  extends ajec
{
  public ajdv(MainFragment paramMainFragment)
  {
    super(null);
  }
  
  public void onClick(View paramView)
  {
    amrz localamrz = this.a.b();
    if ((localamrz instanceof ReadinjoyTabFrame)) {
      ((ReadinjoyTabFrame)localamrz).j();
    }
    pkm.a().l();
    MainFragment.a(MainFragment.a(this.a), MainFragment.a(this.a));
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdv
 * JD-Core Version:    0.7.0.1
 */