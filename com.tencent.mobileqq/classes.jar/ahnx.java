import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.activity.contacts.view.ContactsViewPager;
import com.tencent.qphone.base.util.QLog;

class ahnx
  extends ViewPager.SimpleOnPageChangeListener
{
  ahnx(ahnt paramahnt) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1) {
      ahnt.a(this.a, ahnt.a(this.a).getCurrentItem());
    }
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "mViewPager onPageScrollStateChanged mOccurSwitchAccountChangeTab:" + ahnt.b(this.a) + "  mPageChangedByIndicator:" + ahnt.a(this.a));
    }
    if (ahnt.a(this.a)) {
      ahnt.b(this.a, false);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    ahnt.a(this.a, paramInt);
    if (!ahnt.a(this.a)) {
      azmj.b(this.a.a, "dc00898", "", "", "0X8008059", "0X8008059", 0, 0, "", "", "", "");
    }
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "mViewPager onPageSelected mOccurSwitchAccountChangeTab:" + ahnt.b(this.a) + " mPageChangedByIndicator:" + ahnt.a(this.a));
    }
    ahnt.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahnx
 * JD-Core Version:    0.7.0.1
 */