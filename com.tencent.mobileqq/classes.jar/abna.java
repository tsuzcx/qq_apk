import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.activity.MainFragment;

public class abna
  extends abni
{
  public abna(MainFragment paramMainFragment)
  {
    super(null);
  }
  
  public void onClick(View paramView)
  {
    ajwm localajwm = this.a.b();
    if ((localajwm instanceof ReadinjoyTabFrame)) {
      ((ReadinjoyTabFrame)localajwm).k();
    }
    osj.a().l();
    MainFragment.a(MainFragment.a(this.a), MainFragment.a(this.a));
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abna
 * JD-Core Version:    0.7.0.1
 */