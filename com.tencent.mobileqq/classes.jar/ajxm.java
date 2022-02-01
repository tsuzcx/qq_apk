import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajxm
  implements View.OnClickListener
{
  public ajxm(ContactsTroopAdapter paramContactsTroopAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int] = 2;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.notifyDataSetChanged();
    int i = ContactsTroopAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter, this.jdField_a_of_type_Int);
    new bdlq(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_inactive").a(new String[] { "", String.valueOf(i) }).a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxm
 * JD-Core Version:    0.7.0.1
 */