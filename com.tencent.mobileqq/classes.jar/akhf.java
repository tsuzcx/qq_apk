import android.view.View;
import android.view.View.OnClickListener;

class akhf
  implements View.OnClickListener
{
  akhf(akhc paramakhc) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if (!(paramView instanceof akhl)) {
      return;
    }
    paramView = (akhl)paramView;
    if ((paramView.a != null) && (paramView.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)) {
      this.a.jdField_a_of_type_Akhh.a(paramView.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, paramView.a.jdField_a_of_type_Int);
    }
    if ((paramView.a != null) && (paramView.a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null)) {
      this.a.jdField_a_of_type_Akhh.a(paramView.a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo);
    }
    new azmo(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("send_to").d("clk_grp").a(new String[] { "1" }).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akhf
 * JD-Core Version:    0.7.0.1
 */