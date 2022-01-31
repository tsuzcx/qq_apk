import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.activity.contacts.view.ContactsViewPager;
import com.tencent.qphone.base.util.QLog;

class afqg
  extends ViewPager.SimpleOnPageChangeListener
{
  afqg(afqc paramafqc) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1) {
      afqc.a(this.a, afqc.a(this.a).getCurrentItem());
    }
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "mViewPager onPageScrollStateChanged mOccurSwitchAccountChangeTab:" + afqc.b(this.a) + "  mPageChangedByIndicator:" + afqc.a(this.a));
    }
    if (afqc.a(this.a)) {
      afqc.b(this.a, false);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    afqc.a(this.a, paramInt);
    if (!afqc.a(this.a)) {
      axqy.b(this.a.a, "dc00898", "", "", "0X8008059", "0X8008059", 0, 0, "", "", "", "");
    }
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "mViewPager onPageSelected mOccurSwitchAccountChangeTab:" + afqc.b(this.a) + " mPageChangedByIndicator:" + afqc.a(this.a));
    }
    afqc.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afqg
 * JD-Core Version:    0.7.0.1
 */