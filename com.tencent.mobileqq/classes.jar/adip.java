import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.activity.MainFragment;

public class adip
  extends adix
{
  public adip(MainFragment paramMainFragment)
  {
    super(null);
  }
  
  public void onClick(View paramView)
  {
    alsn localalsn = this.a.b();
    if ((localalsn instanceof ReadinjoyTabFrame)) {
      ((ReadinjoyTabFrame)localalsn).l();
    }
    owy.a().l();
    MainFragment.a(MainFragment.a(this.a), MainFragment.a(this.a));
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adip
 * JD-Core Version:    0.7.0.1
 */