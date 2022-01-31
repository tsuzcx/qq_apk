import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aebz
  implements View.OnClickListener
{
  aebz(aebx paramaebx) {}
  
  public void onClick(View paramView)
  {
    paramView = actj.a(paramView);
    if (!(paramView instanceof MessageForText)) {
      if (QLog.isColorLevel()) {
        QLog.w("ChatItemBuilder", 2, "TextItemBuilder onClickListener: AIOUtils.getMessage(v) is not MessageForText");
      }
    }
    MessageForText localMessageForText;
    do
    {
      return;
      localMessageForText = (MessageForText)paramView;
      if (localMessageForText.sb == null) {
        break;
      }
      paramView = localMessageForText.sb.toString();
      aaog localaaog = new aaog();
      if ((this.a.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
      {
        localObject = ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
        if (localObject != null)
        {
          localObject = (adiw)((BaseChatPie)localObject).a(27);
          if (localObject != null) {
            ((adiw)localObject).a(paramView, localaaog, 0);
          }
        }
      }
      Object localObject = MessageForText.getTroopMemberInfoFromExtrJson(localMessageForText.getExtInfoFromExtStr(axaf.i));
      aanz.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView, (ArrayList)localObject, localaaog);
    } while (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1);
    paramView = (HotChatManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
    if ((paramView != null) && (paramView.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {}
    for (paramView = "2";; paramView = "1")
    {
      axqy.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_msg", "", "grp_msg", "clk_like", 0, 0, localMessageForText.frienduin, "", paramView, "");
      return;
      paramView = localMessageForText.msg;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aebz
 * JD-Core Version:    0.7.0.1
 */