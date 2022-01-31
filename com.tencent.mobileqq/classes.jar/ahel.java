import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.activity.contact.addcontact.TroopView;
import com.tencent.mobileqq.activity.contacts.view.ContactsViewPager;

public class ahel
  extends ViewPager.SimpleOnPageChangeListener
{
  public ahel(TroopView paramTroopView) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (azwu.a()) {}
    while (paramInt != 1) {
      return;
    }
    TroopView.a(this.a, TroopView.a(this.a).getCurrentItem());
  }
  
  public void onPageSelected(int paramInt)
  {
    if (azwu.a()) {
      return;
    }
    TroopView.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahel
 * JD-Core Version:    0.7.0.1
 */