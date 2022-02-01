import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class almb
  implements View.OnClickListener
{
  almb(ally paramally) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof almh)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = (almh)localObject;
      if ((((almh)localObject).a != null) && (((almh)localObject).a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)) {
        this.a.jdField_a_of_type_Almd.a(((almh)localObject).a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, ((almh)localObject).a.jdField_a_of_type_Int);
      }
      if ((((almh)localObject).a != null) && (((almh)localObject).a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null)) {
        this.a.jdField_a_of_type_Almd.a(((almh)localObject).a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo);
      }
      new bcek(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("send_to").d("clk_grp").a(new String[] { "1" }).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     almb
 * JD-Core Version:    0.7.0.1
 */