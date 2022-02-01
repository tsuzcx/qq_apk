import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class ahiv
  implements View.OnClickListener
{
  ahiv(ahit paramahit) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = AIOUtils.getMessage(paramView);
    if (!(localObject1 instanceof MessageForText)) {
      if (QLog.isColorLevel()) {
        QLog.w("ChatItemBuilder", 2, "TextItemBuilder onClickListener: AIOUtils.getMessage(v) is not MessageForText");
      }
    }
    MessageForText localMessageForText;
    label56:
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localMessageForText = (MessageForText)localObject1;
      if (localMessageForText.sb == null) {
        break;
      }
      localObject1 = localMessageForText.sb.toString();
      admo localadmo = new admo();
      if ((this.a.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
      {
        localObject2 = ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
        if (localObject2 != null)
        {
          localObject2 = (agjr)((BaseChatPie)localObject2).getHelper(27);
          if (localObject2 != null) {
            ((agjr)localObject2).a((String)localObject1, localadmo, 0);
          }
        }
      }
      Object localObject2 = MessageForText.getTroopMemberInfoFromExtrJson(localMessageForText.getExtInfoFromExtStr(bcrn.i));
      admh.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject1, (ArrayList)localObject2, localadmo);
    } while (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1);
    localObject1 = (HotChatManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    if ((localObject1 != null) && (((HotChatManager)localObject1).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))) {}
    for (localObject1 = "2";; localObject1 = "1")
    {
      bdla.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_msg", "", "grp_msg", "clk_like", 0, 0, localMessageForText.frienduin, "", (String)localObject1, "");
      break;
      localObject1 = localMessageForText.msg;
      break label56;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahiv
 * JD-Core Version:    0.7.0.1
 */