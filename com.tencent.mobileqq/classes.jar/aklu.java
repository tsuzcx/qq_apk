import android.view.View;
import android.view.View.OnClickListener;

class aklu
  implements View.OnClickListener
{
  aklu(aklr paramaklr) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if (!(paramView instanceof akma)) {
      return;
    }
    paramView = (akma)paramView;
    if ((paramView.a != null) && (paramView.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)) {
      this.a.jdField_a_of_type_Aklw.a(paramView.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, paramView.a.jdField_a_of_type_Int);
    }
    if ((paramView.a != null) && (paramView.a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null)) {
      this.a.jdField_a_of_type_Aklw.a(paramView.a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo);
    }
    new azqx(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("send_to").d("clk_grp").a(new String[] { "1" }).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aklu
 * JD-Core Version:    0.7.0.1
 */