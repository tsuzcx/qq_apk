import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

public class adzh
  implements View.OnClickListener
{
  public adzh(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131373866);
      if ((localObject instanceof bgmh))
      {
        localObject = (bgmh)localObject;
        if ((localObject != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.aio.BaseChatPie", 2, "TextItemBuilder onClickListener: isReplyMsg = true, mSourceMsgSeq = " + ((bgmh)localObject).a);
          }
          BaseChatPie localBaseChatPie = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getChatFragment().a();
          if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) && ((localBaseChatPie instanceof aijm)))
          {
            ((aijm)localBaseChatPie).a(22, ((bgmh)localObject).d, ((bgmh)localObject).c, null);
          }
          else if (localBaseChatPie.j())
          {
            QQMessageFacade.Message localMessage = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            localBaseChatPie.a(22, ((bgmh)localObject).a, (int)(localMessage.shmsgseq - ((bgmh)localObject).a), null);
            MessageForReplyText.reportReplyMsg(null, "typebox", "clk_original", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzh
 * JD-Core Version:    0.7.0.1
 */