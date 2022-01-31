import com.tencent.mobileqq.activity.contact.addcontact.AddContactViewPagerTroopFragment;
import com.tencent.mobileqq.activity.contact.addcontact.TroopView;
import com.tencent.mobileqq.activity.contacts.adapter.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.view.ContactsViewPager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ahix
  implements ahvo
{
  public ahix(TroopView paramTroopView) {}
  
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
      ahfc localahfc = (ahfc)this.a.a.get(i);
      if ((paramInt >= 0) && (paramInt < localahfc.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        localahfc.b = paramInt;
        ahfd localahfd = (ahfd)localahfc.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        ((AddContactViewPagerTroopFragment)localObject).a(localahfd.b, localahfd.jdField_a_of_type_JavaLangString);
        azqs.b(null, "dc00899", "Grp_find_new", "", "grptab", "sub_tag_clk", 0, 0, localahfd.jdField_a_of_type_JavaLangString, localahfc.jdField_a_of_type_JavaLangString, "", "");
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahix
 * JD-Core Version:    0.7.0.1
 */