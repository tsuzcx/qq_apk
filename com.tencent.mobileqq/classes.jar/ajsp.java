import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.widget.QQViewPager;

class ajsp
  extends ViewPager.SimpleOnPageChangeListener
{
  ajsp(ajso paramajso) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1) {
      this.a.b = this.a.a.getCurrentItem();
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    ajso.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajsp
 * JD-Core Version:    0.7.0.1
 */