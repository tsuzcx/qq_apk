import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput;

public class ajqo
  implements View.OnClickListener
{
  public ajqo(QQCustomDialogWtihEmoticonInput paramQQCustomDialogWtihEmoticonInput, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null)
    {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihEmoticonInput, 0);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihEmoticonInput.b)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihEmoticonInput.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihEmoticonInput.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihEmoticonInput.b = false;
      }
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihEmoticonInput.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihEmoticonInput.dismiss();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajqo
 * JD-Core Version:    0.7.0.1
 */