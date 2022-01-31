import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.qq.im.poi.LbsPackSendActivity;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class abgm
  implements DialogInterface.OnClickListener
{
  public abgm(ARMapActivity paramARMapActivity, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    LbsPackSendActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, 105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abgm
 * JD-Core Version:    0.7.0.1
 */