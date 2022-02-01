import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;

class ahde
  implements bkzq
{
  ahde(ahdc paramahdc, MessageForPtt paramMessageForPtt, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    admh.a(this.jdField_a_of_type_Ahdc.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
    paramView = admh.a(this.jdField_a_of_type_Ahdc.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ahdc.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
    if (paramView != null) {}
    try
    {
      ((MessageForPtt)paramView).c2cViaOffline = true;
      ((MessageForPtt)paramView).isResend = true;
      Bundle localBundle = new Bundle();
      localBundle.putInt("DiyTextId", paramView.vipBubbleDiyTextId);
      admh.a(this.jdField_a_of_type_Ahdc.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getLocalFilePath(), paramView.uniseq, true, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceLength * 1000, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType, true, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceChangeFlag, 0, true, paramView.vipSubBubbleId, localBundle);
      this.jdField_a_of_type_Ahdc.b();
      this.jdField_a_of_type_Bkzi.dismiss();
      return;
    }
    catch (RuntimeException paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
        Toast.makeText(this.jdField_a_of_type_Ahdc.jdField_a_of_type_AndroidContentContext, paramView.getMessage(), 0).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahde
 * JD-Core Version:    0.7.0.1
 */