import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adgr
  implements View.OnClickListener
{
  public adgr(AddFriendVerifyActivity paramAddFriendVerifyActivity, int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a("", null, "");
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00898", "", "", "0X80077B4", "0X80077B4", 0, 0, String.valueOf(this.jdField_a_of_type_Int), String.valueOf(this.b), "", "");
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077B4  sourceId = " + this.jdField_a_of_type_Int + " subSourceId = " + this.b);
    }
    if (bhbx.b(AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity))) {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00898", "", "", "0X8008275", "0X8008275", 0, 0, "", "", "", "");
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.c)) {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 0, "1", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adgr
 * JD-Core Version:    0.7.0.1
 */