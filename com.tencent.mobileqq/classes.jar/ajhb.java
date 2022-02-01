import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;

public class ajhb
  extends ViewPager.SimpleOnPageChangeListener
{
  public ajhb(TroopView paramTroopView) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (bduy.a()) {}
    while (paramInt != 1) {
      return;
    }
    TroopView.a(this.a, TroopView.a(this.a).getCurrentItem());
  }
  
  public void onPageSelected(int paramInt)
  {
    if (bduy.a()) {
      return;
    }
    TroopView.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhb
 * JD-Core Version:    0.7.0.1
 */