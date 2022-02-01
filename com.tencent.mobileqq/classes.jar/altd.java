import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

public class altd
  implements DialogInterface.OnClickListener
{
  public altd(SelectMemberActivity paramSelectMemberActivity, ArrayList paramArrayList) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ((anwd)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.a(20)).a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c, this.jdField_a_of_type_JavaUtilArrayList, "");
    SelectMemberActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b.show();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d("Clk_invite");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     altd
 * JD-Core Version:    0.7.0.1
 */