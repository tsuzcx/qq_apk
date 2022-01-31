import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.activity.contacts.view.ContactsViewPager;
import com.tencent.qphone.base.util.QLog;

class ahsm
  extends ViewPager.SimpleOnPageChangeListener
{
  ahsm(ahsi paramahsi) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1) {
      ahsi.a(this.a, ahsi.a(this.a).getCurrentItem());
    }
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "mViewPager onPageScrollStateChanged mOccurSwitchAccountChangeTab:" + ahsi.b(this.a) + "  mPageChangedByIndicator:" + ahsi.a(this.a));
    }
    if (ahsi.a(this.a)) {
      ahsi.b(this.a, false);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    ahsi.a(this.a, paramInt);
    if (!ahsi.a(this.a)) {
      azqs.b(this.a.a, "dc00898", "", "", "0X8008059", "0X8008059", 0, 0, "", "", "", "");
    }
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "mViewPager onPageSelected mOccurSwitchAccountChangeTab:" + ahsi.b(this.a) + " mPageChangedByIndicator:" + ahsi.a(this.a));
    }
    ahsi.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsm
 * JD-Core Version:    0.7.0.1
 */