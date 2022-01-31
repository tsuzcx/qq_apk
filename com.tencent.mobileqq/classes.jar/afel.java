import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.activity.contacts.view.ContactsViewPager;
import com.tencent.qphone.base.util.QLog;

class afel
  extends ViewPager.SimpleOnPageChangeListener
{
  afel(afeh paramafeh) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1) {
      afeh.a(this.a, afeh.a(this.a).getCurrentItem());
    }
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "mViewPager onPageScrollStateChanged mOccurSwitchAccountChangeTab:" + afeh.b(this.a) + "  mPageChangedByIndicator:" + afeh.a(this.a));
    }
    if (afeh.a(this.a)) {
      afeh.b(this.a, false);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    afeh.a(this.a, paramInt);
    if (!afeh.a(this.a)) {
      awqx.b(this.a.a, "dc00898", "", "", "0X8008059", "0X8008059", 0, 0, "", "", "", "");
    }
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "mViewPager onPageSelected mOccurSwitchAccountChangeTab:" + afeh.b(this.a) + " mPageChangedByIndicator:" + afeh.a(this.a));
    }
    afeh.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afel
 * JD-Core Version:    0.7.0.1
 */