import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.qphone.base.util.QLog;

class afqm
  implements View.OnClickListener
{
  afqm(afqh paramafqh) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a()) {}
    BaseChatPie localBaseChatPie;
    do
    {
      do
      {
        do
        {
          return;
          paramView = aekt.a(paramView);
          if ((paramView instanceof MessageForLongMsg)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.w("ChatItemBuilder", 2, "TextItemBuilder onClickListener: AIOUtils.getMessage(v) is not MessageForLongMsg");
        return;
        paramView = (MessageForLongMsg)paramView;
      } while ((paramView.mSourceMsgInfo == null) || (!(this.a.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)));
      if (QLog.isColorLevel()) {
        QLog.w("ChatItemBuilder", 2, "TextItemBuilder onClickListener: isReplyMsg = true");
      }
      localBaseChatPie = ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 0) && ((localBaseChatPie instanceof agld)))
      {
        ((agld)localBaseChatPie).a(22, paramView.mSourceMsgInfo.origUid, paramView.mSourceMsgInfo.mSourceMsgTime, null);
        return;
      }
    } while (!localBaseChatPie.j());
    localBaseChatPie.a(22, paramView.mSourceMsgInfo.mSourceMsgSeq, (int)(paramView.shmsgseq - paramView.mSourceMsgInfo.mSourceMsgSeq), paramView);
    MessageForReplyText.reportReplyMsg(null, "replyMsg_bubble", "clk_original", paramView.frienduin, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afqm
 * JD-Core Version:    0.7.0.1
 */