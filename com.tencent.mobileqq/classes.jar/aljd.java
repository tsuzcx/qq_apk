import android.text.TextUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.agent.BindGroupConfirmActivity;

public class aljd
  implements Runnable
{
  public aljd(BindGroupConfirmActivity paramBindGroupConfirmActivity, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity.a == null) {
      this.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity.a = DialogUtil.a(this.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity, 230);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity.a.setMessage(this.jdField_a_of_type_JavaLangString);
    }
    alje localalje = new alje(this);
    this.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity.a.setTitle(2131433709);
    this.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity.a.setPositiveButton(2131432428, localalje);
    this.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity.a.setNegativeButton(2131433029, localalje);
    if (!this.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity.a.isShowing()) {
      this.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity.a.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aljd
 * JD-Core Version:    0.7.0.1
 */