import android.view.View;
import android.view.View.OnClickListener;

class afds
  implements View.OnClickListener
{
  afds(afdq paramafdq, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Afdq.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int] = 2;
    this.jdField_a_of_type_Afdq.notifyDataSetChanged();
    int i = afdq.a(this.jdField_a_of_type_Afdq, this.jdField_a_of_type_Int);
    new awrb(this.jdField_a_of_type_Afdq.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_inactive").a(new String[] { "", String.valueOf(i) }).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afds
 * JD-Core Version:    0.7.0.1
 */