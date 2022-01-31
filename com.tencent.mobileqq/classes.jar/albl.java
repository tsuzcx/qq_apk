import android.text.TextUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.agent.BindGroupConfirmActivity;

public class albl
  implements Runnable
{
  public albl(BindGroupConfirmActivity paramBindGroupConfirmActivity, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity.a == null) {
      this.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity.a = DialogUtil.a(this.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity, 230);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity.a.setMessage(this.jdField_a_of_type_JavaLangString);
    }
    albm localalbm = new albm(this);
    this.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity.a.setTitle(2131433695);
    this.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity.a.setPositiveButton(2131432417, localalbm);
    this.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity.a.setNegativeButton(2131433015, localalbm);
    if (!this.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity.a.isShowing()) {
      this.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity.a.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     albl
 * JD-Core Version:    0.7.0.1
 */