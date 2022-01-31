import com.tencent.mobileqq.activity.contact.addcontact.AddContactViewPagerTroopFragment;
import com.tencent.mobileqq.activity.contact.addcontact.TroopView;
import com.tencent.mobileqq.activity.contacts.adapter.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.view.ContactsViewPager;
import com.tencent.mobileqq.activity.contacts.view.SimpleCheckableSlidingIndicator;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class afhh
  implements aftb
{
  public afhh(TroopView paramTroopView) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("addContacts.TroopView", 2, "onRepeatClick. position:" + paramInt);
    }
    if (paramInt != -1)
    {
      TroopView.a(this.a).setCurrentPosition(-1, false);
      int i = TroopView.a(this.a).getCurrentItem();
      if (QLog.isColorLevel()) {
        QLog.i("addContacts.TroopView", 2, "onCurrentTabClick. position:" + paramInt + " currentClassifyPos:" + i);
      }
      Object localObject = TroopView.a(this.a).a(i, false);
      if (localObject != null)
      {
        localObject = (AddContactViewPagerTroopFragment)localObject;
        afdi localafdi = (afdi)this.a.a.get(i);
        localafdi.b = -1;
        ((AddContactViewPagerTroopFragment)localObject).a(localafdi.d, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afhh
 * JD-Core Version:    0.7.0.1
 */