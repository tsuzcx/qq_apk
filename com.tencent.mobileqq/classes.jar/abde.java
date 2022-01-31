import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.activity.MainFragment;

public class abde
  extends abdk
{
  public abde(MainFragment paramMainFragment)
  {
    super(null);
  }
  
  public void onClick(View paramView)
  {
    ajii localajii = this.a.b();
    if ((localajii instanceof ReadinjoyTabFrame)) {
      ((ReadinjoyTabFrame)localajii).k();
    }
    ogy.a().l();
    MainFragment.a(MainFragment.a(this.a), MainFragment.a(this.a));
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abde
 * JD-Core Version:    0.7.0.1
 */