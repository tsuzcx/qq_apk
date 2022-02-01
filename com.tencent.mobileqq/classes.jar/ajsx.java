import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.qphone.base.util.QLog;

class ajsx
  extends ViewPager.SimpleOnPageChangeListener
{
  ajsx(ajst paramajst) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1) {
      ajst.a(this.a, ajst.a(this.a).getCurrentItem());
    }
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "mViewPager onPageScrollStateChanged mOccurSwitchAccountChangeTab:" + ajst.b(this.a) + "  mPageChangedByIndicator:" + ajst.a(this.a));
    }
    if (ajst.a(this.a)) {
      ajst.b(this.a, false);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    ajst.a(this.a, paramInt);
    if (!ajst.a(this.a)) {
      bdll.b(this.a.a, "dc00898", "", "", "0X8008059", "0X8008059", 0, 0, "", "", "", "");
    }
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "mViewPager onPageSelected mOccurSwitchAccountChangeTab:" + ajst.b(this.a) + " mPageChangedByIndicator:" + ajst.a(this.a));
    }
    ajst.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajsx
 * JD-Core Version:    0.7.0.1
 */