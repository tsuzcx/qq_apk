import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.qphone.base.util.QLog;

class ainu
  extends ViewPager.SimpleOnPageChangeListener
{
  ainu(ainq paramainq) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1) {
      ainq.a(this.a, ainq.a(this.a).getCurrentItem());
    }
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "mViewPager onPageScrollStateChanged mOccurSwitchAccountChangeTab:" + ainq.b(this.a) + "  mPageChangedByIndicator:" + ainq.a(this.a));
    }
    if (ainq.a(this.a)) {
      ainq.b(this.a, false);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    ainq.a(this.a, paramInt);
    if (!ainq.a(this.a)) {
      bcef.b(this.a.a, "dc00898", "", "", "0X8008059", "0X8008059", 0, 0, "", "", "", "");
    }
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "mViewPager onPageSelected mOccurSwitchAccountChangeTab:" + ainq.b(this.a) + " mPageChangedByIndicator:" + ainq.a(this.a));
    }
    ainq.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainu
 * JD-Core Version:    0.7.0.1
 */