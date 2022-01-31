import android.view.View;
import android.view.View.OnClickListener;

class ahru
  implements View.OnClickListener
{
  ahru(ahrs paramahrs, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Ahrs.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int] = 2;
    this.jdField_a_of_type_Ahrs.notifyDataSetChanged();
    int i = ahrs.a(this.jdField_a_of_type_Ahrs, this.jdField_a_of_type_Int);
    new azqx(this.jdField_a_of_type_Ahrs.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_inactive").a(new String[] { "", String.valueOf(i) }).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahru
 * JD-Core Version:    0.7.0.1
 */