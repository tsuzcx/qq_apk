import com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactViewPagerTroopFragment;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class aibh
  implements aios
{
  public aibh(TroopView paramTroopView) {}
  
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
      aiak localaiak = (aiak)this.a.a.get(i);
      if ((paramInt >= 0) && (paramInt < localaiak.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        localaiak.b = paramInt;
        aial localaial = (aial)localaiak.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        ((AddContactViewPagerTroopFragment)localObject).a(localaial.b, localaial.jdField_a_of_type_JavaLangString);
        bcef.b(null, "dc00899", "Grp_find_new", "", "grptab", "sub_tag_clk", 0, 0, localaial.jdField_a_of_type_JavaLangString, localaiak.jdField_a_of_type_JavaLangString, "", "");
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aibh
 * JD-Core Version:    0.7.0.1
 */