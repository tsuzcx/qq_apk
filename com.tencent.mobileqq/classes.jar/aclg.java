import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;

public final class aclg
  implements DialogInterface.OnClickListener
{
  public aclg(QQAppInterface paramQQAppInterface, aclo paramaclo, long paramLong, Context paramContext, acln paramacln) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    auwm localauwm = (auwm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(66);
    if (localauwm != null) {
      localauwm.a((byte)0);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true);
    if (this.jdField_a_of_type_Aclo.a) {
      azqs.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "1", "", "", "");
    }
    this.jdField_a_of_type_Aclo.e = false;
    ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Acln, this.jdField_a_of_type_Aclo);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aclg
 * JD-Core Version:    0.7.0.1
 */