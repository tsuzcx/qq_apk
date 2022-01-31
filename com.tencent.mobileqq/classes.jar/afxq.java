import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.widget.QQViewPager;

class afxq
  extends ViewPager.SimpleOnPageChangeListener
{
  afxq(afxp paramafxp) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1) {
      this.a.b = this.a.a.getCurrentItem();
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    afxp.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afxq
 * JD-Core Version:    0.7.0.1
 */