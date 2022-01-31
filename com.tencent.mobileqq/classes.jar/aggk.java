import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.qcall.LightalkShieldHandler;
import com.tencent.mobileqq.qcall.LightalkSwitchHanlder;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.qcall.UinUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;

class aggk
  implements DialogInterface.OnClickListener
{
  aggk(aggi paramaggi, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    while (paramInt != 1) {
      return;
    }
    QCallDetailActivity.a(this.jdField_a_of_type_Aggi.a).b(10, UinUtils.a(QCallDetailActivity.a(this.jdField_a_of_type_Aggi.a)));
    QCallDetailActivity.a(this.jdField_a_of_type_Aggi.a).a((byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aggk
 * JD-Core Version:    0.7.0.1
 */