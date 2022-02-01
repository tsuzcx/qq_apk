import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

class ahhe
  implements DialogInterface.OnClickListener
{
  ahhe(ahhd paramahhd) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.jdField_a_of_type_Ahgz.b = new ReportDialog(this.a.jdField_a_of_type_Ahgz.getActivity(), 2131755826);
    this.a.jdField_a_of_type_Ahgz.b.setContentView(2131558434);
    this.a.jdField_a_of_type_Ahgz.b.setCancelable(true);
    ((TextView)this.a.jdField_a_of_type_Ahgz.b.findViewById(2131365552)).setText(this.a.jdField_a_of_type_Ahgz.getActivity().getString(2131718142));
    this.a.jdField_a_of_type_Ahgz.b.show();
    ((amtp)this.a.jdField_a_of_type_Ahgz.app.getBusinessHandler(35)).b(this.a.jdField_a_of_type_Ahgz.sessionInfo.curFriendUin, this.a.jdField_a_of_type_Ahgz.sessionInfo.troopUin, this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, this.a.jdField_a_of_type_JavaLangString, 1);
    bcef.b(this.a.jdField_a_of_type_Ahgz.app, "CliOper", "", "", "0X8005D55", "0X8005D55", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahhe
 * JD-Core Version:    0.7.0.1
 */