import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.activity.MainFragment;

public class abmw
  extends abne
{
  public abmw(MainFragment paramMainFragment)
  {
    super(null);
  }
  
  public void onClick(View paramView)
  {
    ajwk localajwk = this.a.b();
    if ((localajwk instanceof ReadinjoyTabFrame)) {
      ((ReadinjoyTabFrame)localajwk).k();
    }
    osg.a().l();
    MainFragment.a(MainFragment.a(this.a), MainFragment.a(this.a));
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abmw
 * JD-Core Version:    0.7.0.1
 */