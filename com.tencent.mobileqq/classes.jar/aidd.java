import android.view.View;
import android.view.View.OnClickListener;

class aidd
  implements View.OnClickListener
{
  aidd(aida paramaida) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if (!(paramView instanceof aidj)) {
      return;
    }
    paramView = (aidj)paramView;
    if ((paramView.a != null) && (paramView.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)) {
      this.a.jdField_a_of_type_Aidf.a(paramView.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, paramView.a.jdField_a_of_type_Int);
    }
    if ((paramView.a != null) && (paramView.a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null)) {
      this.a.jdField_a_of_type_Aidf.a(paramView.a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo);
    }
    new awrb(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("send_to").d("clk_grp").a(new String[] { "1" }).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aidd
 * JD-Core Version:    0.7.0.1
 */