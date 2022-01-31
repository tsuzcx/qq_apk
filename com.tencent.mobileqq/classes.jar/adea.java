import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.activity.MainFragment;

public class adea
  extends adei
{
  public adea(MainFragment paramMainFragment)
  {
    super(null);
  }
  
  public void onClick(View paramView)
  {
    alny localalny = this.a.b();
    if ((localalny instanceof ReadinjoyTabFrame)) {
      ((ReadinjoyTabFrame)localalny).l();
    }
    owy.a().l();
    MainFragment.a(MainFragment.a(this.a), MainFragment.a(this.a));
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adea
 * JD-Core Version:    0.7.0.1
 */