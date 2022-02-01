import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

class ailr
  implements DialogInterface.OnClickListener
{
  ailr(ailq paramailq) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.jdField_a_of_type_Ailn.d = new ReportDialog(this.a.jdField_a_of_type_Ailn.a(), 2131755824);
    this.a.jdField_a_of_type_Ailn.d.setContentView(2131558434);
    this.a.jdField_a_of_type_Ailn.d.setCancelable(true);
    ((TextView)this.a.jdField_a_of_type_Ailn.d.findViewById(2131365519)).setText(this.a.jdField_a_of_type_Ailn.a().getString(2131717902));
    this.a.jdField_a_of_type_Ailn.d.show();
    ((anzp)this.a.jdField_a_of_type_Ailn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).b(this.a.jdField_a_of_type_Ailn.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Ailn.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, this.a.jdField_a_of_type_JavaLangString, 1);
    bdll.b(this.a.jdField_a_of_type_Ailn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005D55", "0X8005D55", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ailr
 * JD-Core Version:    0.7.0.1
 */