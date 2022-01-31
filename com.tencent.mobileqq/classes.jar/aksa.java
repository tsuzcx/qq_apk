import com.tencent.mobileqq.vashealth.VideoCallBack;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class aksa
  implements Runnable
{
  public aksa(VideoCallBack paramVideoCallBack, QQProgressDialog paramQQProgressDialog) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在处理");
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aksa
 * JD-Core Version:    0.7.0.1
 */