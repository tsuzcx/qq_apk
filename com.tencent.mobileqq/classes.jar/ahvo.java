import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.widget.QQViewPager;

class ahvo
  extends ViewPager.SimpleOnPageChangeListener
{
  ahvo(ahvn paramahvn) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1) {
      this.a.b = this.a.a.getCurrentItem();
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    ahvn.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahvo
 * JD-Core Version:    0.7.0.1
 */