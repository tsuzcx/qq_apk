import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.qphone.base.util.QLog;

class ajho
  extends ViewPager.SimpleOnPageChangeListener
{
  ajho(ajhk paramajhk) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1) {
      ajhk.a(this.a, ajhk.a(this.a).getCurrentItem());
    }
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "mViewPager onPageScrollStateChanged mOccurSwitchAccountChangeTab:" + ajhk.b(this.a) + "  mPageChangedByIndicator:" + ajhk.a(this.a));
    }
    if (ajhk.a(this.a)) {
      ajhk.b(this.a, false);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    ajhk.a(this.a, paramInt);
    if (!ajhk.a(this.a)) {
      bcst.b(this.a.a, "dc00898", "", "", "0X8008059", "0X8008059", 0, 0, "", "", "", "");
    }
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "mViewPager onPageSelected mOccurSwitchAccountChangeTab:" + ajhk.b(this.a) + " mPageChangedByIndicator:" + ajhk.a(this.a));
    }
    ajhk.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajho
 * JD-Core Version:    0.7.0.1
 */