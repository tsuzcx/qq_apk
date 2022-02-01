import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.qphone.base.util.QLog;

class ajjj
  extends ViewPager.SimpleOnPageChangeListener
{
  ajjj(ajjf paramajjf) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1) {
      ajjf.a(this.a, ajjf.a(this.a).getCurrentItem());
    }
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "mViewPager onPageScrollStateChanged mOccurSwitchAccountChangeTab:" + ajjf.b(this.a) + "  mPageChangedByIndicator:" + ajjf.a(this.a));
    }
    if (ajjf.a(this.a)) {
      ajjf.b(this.a, false);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    ajjf.a(this.a, paramInt);
    if (!ajjf.a(this.a)) {
      bdla.b(this.a.a, "dc00898", "", "", "0X8008059", "0X8008059", 0, 0, "", "", "", "");
    }
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "mViewPager onPageSelected mOccurSwitchAccountChangeTab:" + ajjf.b(this.a) + " mPageChangedByIndicator:" + ajjf.a(this.a));
    }
    ajjf.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajjj
 * JD-Core Version:    0.7.0.1
 */