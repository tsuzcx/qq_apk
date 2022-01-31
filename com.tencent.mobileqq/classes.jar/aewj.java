import com.tencent.mobileqq.activity.contact.addcontact.AddContactViewPagerTroopFragment;
import com.tencent.mobileqq.activity.contact.addcontact.TroopView;
import com.tencent.mobileqq.activity.contacts.adapter.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.view.ContactsViewPager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class aewj
  implements afhm
{
  public aewj(TroopView paramTroopView) {}
  
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
      aeso localaeso = (aeso)this.a.a.get(i);
      if ((paramInt >= 0) && (paramInt < localaeso.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        localaeso.b = paramInt;
        aesp localaesp = (aesp)localaeso.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        ((AddContactViewPagerTroopFragment)localObject).a(localaesp.b, localaesp.jdField_a_of_type_JavaLangString);
        awqx.b(null, "dc00899", "Grp_find_new", "", "grptab", "sub_tag_clk", 0, 0, localaesp.jdField_a_of_type_JavaLangString, localaeso.jdField_a_of_type_JavaLangString, "", "");
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aewj
 * JD-Core Version:    0.7.0.1
 */