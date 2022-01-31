import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.qphone.base.util.QLog;

public class abys
  implements View.OnClickListener
{
  public abys(AddFriendVerifyActivity paramAddFriendVerifyActivity, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onClick(View paramView)
  {
    paramView = AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, false);
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    if ((str != null) && (paramView != null) && (!str.equals(paramView))) {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00898", "", "", "0X80077B0", "0X80077B0", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a(str, false);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getString(2131692133).equals(str)) && (!AddFriendVerifyActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity))) {
      AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo != null)
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00898", "", "", "0X8008439", "0X8008439", 0, 0, "", "", "", "");
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.verifyMsg)) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.verifyMsg.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.jdField_a_of_type_AndroidWidgetEditText.getText().toString()))) {
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00898", "", "", "0X800843A", "0X800843A", 0, 0, "", "", "", "");
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim(), null, "");
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00898", "", "", "0X80077B4", "0X80077B4", 0, 0, String.valueOf(this.jdField_a_of_type_Int), String.valueOf(this.b), "", "");
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077B4  sourceId = " + this.jdField_a_of_type_Int + " subSourceId = " + this.b);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.c)) {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 0, "1", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a(this.jdField_a_of_type_Int, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abys
 * JD-Core Version:    0.7.0.1
 */