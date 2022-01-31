import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.BaseApplication;

public class aaqq
  implements DialogInterface.OnClickListener
{
  public aaqq(ChatHistory paramChatHistory) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (bbfj.d(BaseApplication.getContext()))
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      this.a.h();
      axqy.b(this.a.app, "CliOper", "", "", "AIO", "AIO_chatlog_lately", 0, 0, "", "", "", "");
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    this.a.jdField_c_of_type_AndroidAppDialog.dismiss();
    if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(0);
    this.a.jdField_c_of_type_AndroidWidgetTextView.setText(this.a.getString(2131692321));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaqq
 * JD-Core Version:    0.7.0.1
 */