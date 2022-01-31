import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;

public class acjo
  implements View.OnLongClickListener
{
  public acjo(BaseBubbleBuilder paramBaseBubbleBuilder) {}
  
  public boolean onLongClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        return false;
        localObject1 = paramView.getContext();
        if (!(localObject1 instanceof FragmentActivity)) {
          return true;
        }
        localObject2 = (FragmentActivity)localObject1;
        localObject1 = (String)paramView.getTag(2131298561);
        paramView = (ChatMessage)paramView.getTag();
        if (paramView == null) {
          break;
        }
        localObject2 = ((FragmentActivity)localObject2).getChatFragment();
      } while (localObject2 == null);
      localObject2 = ((ChatFragment)localObject2).a();
    } while (localObject2 == null);
    if ((localObject2 instanceof aefe))
    {
      HotChatManager localHotChatManager = (HotChatManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
      HotChatInfo localHotChatInfo = localHotChatManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if ((localHotChatInfo != null) && (localHotChatInfo.isGameRoom)) {
        return true;
      }
      azks localazks = (azks)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      if ((localHotChatInfo != null) && ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localHotChatInfo.ownerUin)) || (((localHotChatInfo.isOwnerOrAdmin(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) || (localHotChatManager.b())) && (!localHotChatInfo.isOwnerOrAdmin(paramView.senderuin)) && ((!localHotChatInfo.isRobotHotChat) || (!localazks.b(paramView.senderuin)))))) {
        ((aefe)localObject2).a(paramView, (String)localObject1);
      }
    }
    for (;;)
    {
      return true;
      ((aefe)localObject2).a(paramView.senderuin, (String)localObject1, false, 1);
      continue;
      if ((localObject2 instanceof aejb))
      {
        ((aejb)localObject2).a(paramView.senderuin, (String)localObject1, false, 1);
      }
      else if ((localObject2 instanceof aede))
      {
        if (babh.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.frienduin)) {
          return true;
        }
        ((aede)localObject2).a(paramView.senderuin, (String)localObject1, false);
        awqx.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006210", "0X8006210", 0, 0, "", "", "", "");
      }
      else if ((localObject2 instanceof aedo))
      {
        ((BaseChatPie)localObject2).bl();
        awqx.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A010", "0X800A010", 0, 0, "", "", "", "");
      }
      else if (((localObject2 instanceof aeiv)) || ((localObject2 instanceof aego)) || ((localObject2 instanceof aegy)))
      {
        ((BaseChatPie)localObject2).bl();
        awqx.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A011", "0X800A011", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acjo
 * JD-Core Version:    0.7.0.1
 */