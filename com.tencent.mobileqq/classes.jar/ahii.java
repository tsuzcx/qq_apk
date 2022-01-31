import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.qwallet.redpacket.widget.ViewPagerTabLayout;

public class ahii
  implements View.OnClickListener
{
  public ahii(ViewPagerTabLayout paramViewPagerTabLayout) {}
  
  public void onClick(View paramView)
  {
    int i = ViewPagerTabLayout.a(this.a).indexOfChild(paramView);
    if (i != -1)
    {
      if (ViewPagerTabLayout.a(this.a).getCurrentItem() == i) {
        break label85;
      }
      if (ViewPagerTabLayout.a(this.a)) {
        break label74;
      }
      this.a.setCurrentTab(i, false);
      if (ViewPagerTabLayout.a(this.a) != null) {
        ViewPagerTabLayout.a(this.a).a(i);
      }
    }
    label74:
    label85:
    while (ViewPagerTabLayout.a(this.a) == null) {
      for (;;)
      {
        return;
        this.a.setCurrentTab(i);
      }
    }
    ViewPagerTabLayout.a(this.a).b(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahii
 * JD-Core Version:    0.7.0.1
 */