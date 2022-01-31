import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.activity.contact.addcontact.TroopView;
import com.tencent.mobileqq.activity.contacts.view.ContactsViewPager;

public class afhg
  extends ViewPager.SimpleOnPageChangeListener
{
  public afhg(TroopView paramTroopView) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1) {
      TroopView.a(this.a, TroopView.a(this.a).getCurrentItem());
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    TroopView.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afhg
 * JD-Core Version:    0.7.0.1
 */