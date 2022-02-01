import com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactViewPagerTroopFragment;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class aivp
  implements ajim
{
  public aivp(TroopView paramTroopView) {}
  
  public int a(int paramInt, boolean paramBoolean)
  {
    int i = TroopView.a(this.a).getCurrentItem();
    if (QLog.isColorLevel()) {
      QLog.i("addContacts.TroopView", 2, "onTabChanged. position:" + paramInt + " currentClassifyPos:" + i);
    }
    Object localObject = TroopView.a(this.a).a(i, false);
    if (localObject != null)
    {
      localObject = (AddContactViewPagerTroopFragment)localObject;
      aius localaius = (aius)this.a.a.get(i);
      if ((paramInt >= 0) && (paramInt < localaius.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        localaius.b = paramInt;
        aiut localaiut = (aiut)localaius.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        ((AddContactViewPagerTroopFragment)localObject).a(localaiut.b, localaiut.jdField_a_of_type_JavaLangString);
        bcst.b(null, "dc00899", "Grp_find_new", "", "grptab", "sub_tag_clk", 0, 0, localaiut.jdField_a_of_type_JavaLangString, localaius.jdField_a_of_type_JavaLangString, "", "");
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aivp
 * JD-Core Version:    0.7.0.1
 */