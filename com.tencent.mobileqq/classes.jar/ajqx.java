import android.view.WindowManager;
import com.tencent.mobileqq.activity.qwallet.widget.MyLinearLayout;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose;

public class ajqx
  implements Runnable
{
  public ajqx(QQCustomDialogWtihInputAndChoose paramQQCustomDialogWtihInputAndChoose) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_AndroidViewWindowManager$LayoutParams == null) {
      return;
    }
    this.a.jdField_a_of_type_AndroidViewWindowManager.addView(this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetMyLinearLayout, this.a.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
    this.a.b = true;
    this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetMyLinearLayout.post(new ajqy(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajqx
 * JD-Core Version:    0.7.0.1
 */