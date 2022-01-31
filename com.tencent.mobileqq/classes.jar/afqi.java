import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.activity.contacts.view.ContactsViewPager;
import com.tencent.qphone.base.util.QLog;

class afqi
  extends ViewPager.SimpleOnPageChangeListener
{
  afqi(afqe paramafqe) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1) {
      afqe.a(this.a, afqe.a(this.a).getCurrentItem());
    }
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "mViewPager onPageScrollStateChanged mOccurSwitchAccountChangeTab:" + afqe.b(this.a) + "  mPageChangedByIndicator:" + afqe.a(this.a));
    }
    if (afqe.a(this.a)) {
      afqe.b(this.a, false);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    afqe.a(this.a, paramInt);
    if (!afqe.a(this.a)) {
      axqw.b(this.a.a, "dc00898", "", "", "0X8008059", "0X8008059", 0, 0, "", "", "", "");
    }
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "mViewPager onPageSelected mOccurSwitchAccountChangeTab:" + afqe.b(this.a) + " mPageChangedByIndicator:" + afqe.a(this.a));
    }
    afqe.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afqi
 * JD-Core Version:    0.7.0.1
 */