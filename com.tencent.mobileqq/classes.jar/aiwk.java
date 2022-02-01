import com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactViewPagerTroopFragment;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleCheckableSlidingIndicator;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aiwk
  implements ajka
{
  public aiwk(TroopView paramTroopView) {}
  
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
        aivj localaivj = (aivj)this.a.a.get(i);
        localaivj.b = -1;
        ((AddContactViewPagerTroopFragment)localObject).a(localaivj.d, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiwk
 * JD-Core Version:    0.7.0.1
 */