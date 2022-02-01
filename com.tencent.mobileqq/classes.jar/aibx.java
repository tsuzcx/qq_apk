import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

class aibx
  implements DialogInterface.OnClickListener
{
  aibx(aibw paramaibw) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.jdField_a_of_type_Aibs.b = new ReportDialog(this.a.jdField_a_of_type_Aibs.getActivity(), 2131755829);
    this.a.jdField_a_of_type_Aibs.b.setContentView(2131558435);
    this.a.jdField_a_of_type_Aibs.b.setCancelable(true);
    ((TextView)this.a.jdField_a_of_type_Aibs.b.findViewById(2131365644)).setText(this.a.jdField_a_of_type_Aibs.getActivity().getString(2131718527));
    this.a.jdField_a_of_type_Aibs.b.show();
    ((anwd)this.a.jdField_a_of_type_Aibs.app.getBusinessHandler(BusinessHandlerFactory.HOT_CHAT_HANDLER)).b(this.a.jdField_a_of_type_Aibs.sessionInfo.curFriendUin, this.a.jdField_a_of_type_Aibs.sessionInfo.troopUin, this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, this.a.jdField_a_of_type_JavaLangString, 1);
    bdla.b(this.a.jdField_a_of_type_Aibs.app, "CliOper", "", "", "0X8005D55", "0X8005D55", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aibx
 * JD-Core Version:    0.7.0.1
 */