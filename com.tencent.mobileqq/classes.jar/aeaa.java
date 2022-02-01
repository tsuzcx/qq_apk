import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;

final class aeaa
  implements DialogInterface.OnClickListener
{
  aeaa(aeca paramaeca, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, aebz paramaebz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Aeca.d = false;
    this.jdField_a_of_type_Aeca.e = false;
    ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aebz, this.jdField_a_of_type_Aeca);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeaa
 * JD-Core Version:    0.7.0.1
 */