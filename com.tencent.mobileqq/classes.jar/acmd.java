import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.BaseApplication;

public class acmd
  implements DialogInterface.OnClickListener
{
  public acmd(ChatHistory paramChatHistory) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (bdin.d(BaseApplication.getContext()))
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      this.a.h();
      azqs.b(this.a.app, "CliOper", "", "", "AIO", "AIO_chatlog_lately", 0, 0, "", "", "", "");
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    this.a.jdField_c_of_type_AndroidAppDialog.dismiss();
    if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(0);
    this.a.jdField_c_of_type_AndroidWidgetTextView.setText(this.a.getString(2131692398));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acmd
 * JD-Core Version:    0.7.0.1
 */