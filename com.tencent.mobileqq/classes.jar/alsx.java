import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class alsx
  implements View.OnClickListener
{
  public alsx(FrameHelperActivity paramFrameHelperActivity, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    if ((FrameHelperActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity) != null) && (FrameHelperActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity).isShowing())) {
      FrameHelperActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity).dismiss();
    }
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800433B", "0X800433B", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alsx
 * JD-Core Version:    0.7.0.1
 */