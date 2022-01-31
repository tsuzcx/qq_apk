import android.view.WindowManager;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput;

public class ajqm
  implements Runnable
{
  public ajqm(QQCustomDialogWtihEmoticonInput paramQQCustomDialogWtihEmoticonInput) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_AndroidViewWindowManager.addView(this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel, this.a.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
    this.a.b = true;
    this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.post(new ajqn(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajqm
 * JD-Core Version:    0.7.0.1
 */