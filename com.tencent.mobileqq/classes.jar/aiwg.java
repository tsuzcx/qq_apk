import com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactViewPagerTroopFragment;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class aiwg
  implements ajkh
{
  public aiwg(TroopView paramTroopView) {}
  
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
      aivj localaivj = (aivj)this.a.a.get(i);
      if ((paramInt >= 0) && (paramInt < localaivj.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        localaivj.b = paramInt;
        aivk localaivk = (aivk)localaivj.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        ((AddContactViewPagerTroopFragment)localObject).a(localaivk.b, localaivk.jdField_a_of_type_JavaLangString);
        bdla.b(null, "dc00899", "Grp_find_new", "", "grptab", "sub_tag_clk", 0, 0, localaivk.jdField_a_of_type_JavaLangString, localaivj.jdField_a_of_type_JavaLangString, "", "");
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiwg
 * JD-Core Version:    0.7.0.1
 */