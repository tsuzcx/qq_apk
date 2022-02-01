import android.os.SystemClock;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForMixedMsg;

class ahbs
  implements bkzq
{
  ahbs(ahbp paramahbp, MessageForMixedMsg paramMessageForMixedMsg, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkzi.dismiss();
      long l;
      do
      {
        return;
        l = SystemClock.uptimeMillis();
      } while (l - this.jdField_a_of_type_Ahbp.c < 500L);
      this.jdField_a_of_type_Ahbp.c = l;
      paramView = (awyg)this.jdField_a_of_type_Ahbp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MIXED_MSG_MANAGER);
      this.jdField_a_of_type_Ahbp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().removeMsgByUniseq(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq);
      paramView.a(this.jdField_a_of_type_Ahbp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahbs
 * JD-Core Version:    0.7.0.1
 */