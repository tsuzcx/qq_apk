import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.QQToast;

public class aeqd
  implements bkzq
{
  public aeqd(QQLSActivity paramQQLSActivity, MessageForPtt paramMessageForPtt, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    admh.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
    paramView = admh.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), new SessionInfo(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
    if (paramView != null) {}
    try
    {
      ((MessageForPtt)paramView).c2cViaOffline = true;
      Bundle localBundle = new Bundle();
      localBundle.putInt("DiyTextId", paramView.vipBubbleDiyTextId);
      admh.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getLocalFilePath(), paramView.uniseq, true, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceLength * 1000, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType, true, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceChangeFlag, 0, true, paramView.vipSubBubbleId, localBundle);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.d();
      this.jdField_a_of_type_Bkzi.dismiss();
      return;
    }
    catch (RuntimeException paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, paramView.getMessage(), 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeqd
 * JD-Core Version:    0.7.0.1
 */