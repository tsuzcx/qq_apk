import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class adtn
  implements View.OnClickListener
{
  public adtn(AddFriendVerifyActivity paramAddFriendVerifyActivity, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.jdField_a_of_type_AndroidViewInputmethodInputMethodManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getWindow().setSoftInputMode(2);
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length() > 30)
    {
      localObject = new ReportDialog(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, 2131755824);
      ((Dialog)localObject).setContentView(2131562849);
      ((TextView)((Dialog)localObject).findViewById(2131365519)).setText(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getString(2131690952));
      ((ProgressBar)((Dialog)localObject).findViewById(2131367008)).setVisibility(8);
      ((ImageView)((Dialog)localObject).findViewById(2131380466)).setImageResource(2130839595);
      ((Dialog)localObject).show();
    }
    label351:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a((String)localObject, false);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getString(2131691773).equals(localObject)) && (!AddFriendVerifyActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity))) {
        AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim());
      if (this.jdField_a_of_type_Int == 0) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00898", "", "", "0X800796F", "0X800796F", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.c)) {
          break label351;
        }
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 0, "1", "", "", "");
        break;
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00898", "", "", "0X8007976", "0X8007976", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adtn
 * JD-Core Version:    0.7.0.1
 */