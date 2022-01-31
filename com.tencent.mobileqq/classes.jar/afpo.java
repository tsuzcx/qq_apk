import android.view.View;
import android.view.View.OnClickListener;

class afpo
  implements View.OnClickListener
{
  afpo(afpm paramafpm, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Afpm.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int] = 2;
    this.jdField_a_of_type_Afpm.notifyDataSetChanged();
    int i = afpm.a(this.jdField_a_of_type_Afpm, this.jdField_a_of_type_Int);
    new axrc(this.jdField_a_of_type_Afpm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_inactive").a(new String[] { "", String.valueOf(i) }).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afpo
 * JD-Core Version:    0.7.0.1
 */