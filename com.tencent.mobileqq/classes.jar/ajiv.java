import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout.OnReciteListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class ajiv
  implements DialogInterface.OnClickListener
{
  public ajiv(ReciteRecordLayout paramReciteRecordLayout) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    if (!NetworkUtil.g(this.a.jdField_a_of_type_AndroidContentContext)) {
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
    do
    {
      return;
      this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    } while (ReciteRecordLayout.a(this.a) == null);
    ReciteRecordLayout.a(this.a).e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajiv
 * JD-Core Version:    0.7.0.1
 */