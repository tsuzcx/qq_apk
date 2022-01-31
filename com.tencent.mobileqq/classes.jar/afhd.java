import com.tencent.mobileqq.activity.contact.addcontact.AddContactViewPagerTroopFragment;
import com.tencent.mobileqq.activity.contact.addcontact.TroopView;
import com.tencent.mobileqq.activity.contacts.adapter.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.view.ContactsViewPager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class afhd
  implements afth
{
  public afhd(TroopView paramTroopView) {}
  
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
      afdi localafdi = (afdi)this.a.a.get(i);
      if ((paramInt >= 0) && (paramInt < localafdi.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        localafdi.b = paramInt;
        afdj localafdj = (afdj)localafdi.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        ((AddContactViewPagerTroopFragment)localObject).a(localafdj.b, localafdj.jdField_a_of_type_JavaLangString);
        axqy.b(null, "dc00899", "Grp_find_new", "", "grptab", "sub_tag_clk", 0, 0, localafdj.jdField_a_of_type_JavaLangString, localafdi.jdField_a_of_type_JavaLangString, "", "");
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afhd
 * JD-Core Version:    0.7.0.1
 */