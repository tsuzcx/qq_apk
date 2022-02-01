import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.widget.QQViewPager;

class akca
  extends ViewPager.SimpleOnPageChangeListener
{
  akca(akbz paramakbz) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1) {
      this.a.b = this.a.a.getCurrentItem();
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    akbz.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akca
 * JD-Core Version:    0.7.0.1
 */