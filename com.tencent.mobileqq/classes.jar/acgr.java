import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;

public final class acgr
  implements DialogInterface.OnClickListener
{
  public acgr(QQAppInterface paramQQAppInterface, acgz paramacgz, long paramLong, Context paramContext, acgy paramacgy) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ausd localausd = (ausd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(66);
    if (localausd != null) {
      localausd.a((byte)0);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true);
    if (this.jdField_a_of_type_Acgz.a) {
      azmj.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "1", "", "", "");
    }
    this.jdField_a_of_type_Acgz.e = false;
    ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Acgy, this.jdField_a_of_type_Acgz);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acgr
 * JD-Core Version:    0.7.0.1
 */