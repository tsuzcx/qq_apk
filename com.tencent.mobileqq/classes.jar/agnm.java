import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Apollo3DMessage;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashSet;
import mqq.os.MqqHandler;

public class agnm
  implements View.OnClickListener
{
  public agnm(ApolloItemBuilder paramApolloItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (ApolloItemBuilder.a(this.a)) {}
    agnq localagnq;
    Object localObject1;
    int i;
    label128:
    do
    {
      do
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        ApolloItemBuilder.b(this.a, System.currentTimeMillis());
        amme.jdField_a_of_type_JavaUtilArrayList.clear();
        localagnq = (agnq)AIOUtils.getHolder(paramView);
        localObject1 = (MessageForApollo)localagnq.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      } while (ApolloItemBuilder.a(this.a, paramView, (MessageForApollo)localObject1));
      int j = ((amme)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER)).b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      if (ApolloGameUtil.a(((MessageForApollo)localObject1).msgType)) {
        break;
      }
      int k = ((MessageForApollo)localObject1).mApolloMessage.id;
      if (!((MessageForApollo)localObject1).isDoubleAction()) {
        break label529;
      }
      i = 1;
      if (ApolloUtil.a(k, i)) {
        break;
      }
      if (j != 2)
      {
        localagnq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        if (!amme.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(localagnq.e))) {
          amme.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(localagnq.e));
        }
      }
    } while (!NetworkUtil.isNetworkAvailable(this.a.jdField_a_of_type_AndroidContentContext));
    ApolloItemBuilder.a(this.a, (MessageForApollo)localObject1);
    if (anhm.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0)
    {
      Object localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (localObject2 != null)
      {
        ((MqqHandler)localObject2).obtainMessage(49).sendToTarget();
        if (QLog.isColorLevel()) {
          QLog.d("ApolloItemBuilder", 2, "INIT_STATUS user open panel");
        }
      }
      if ((this.a.jdField_a_of_type_AndroidContentContext != null) && (((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment() != null))
      {
        localObject2 = ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
        if ((((MessageForApollo)localObject1).mApollo3DMessage == null) || (((MessageForApollo)localObject1).mApollo3DMessage.actionID_3D <= 0)) {
          break label534;
        }
        i = 1;
        label337:
        if (((BaseChatPie)localObject2).mApolloPanel == null) {
          break label539;
        }
        ((BaseChatPie)localObject2).mApolloPanel.c = 0;
        ((BaseChatPie)localObject2).mApolloPanel.e(i);
      }
    }
    for (;;)
    {
      if ((this.a.jdField_a_of_type_AndroidContentContext != null) && (((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment() != null))
      {
        localObject1 = ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
        if ((localObject1 != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)) {
          VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "new_clk_action", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, ApolloUtil.b(((BaseChatPie)localObject1).getCurType()), anhm.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), new String[] { String.valueOf(localagnq.e), "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
        }
      }
      this.a.a(localagnq, 2);
      break;
      label529:
      i = 0;
      break label128;
      label534:
      i = 0;
      break label337;
      label539:
      ApolloPanel.b = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agnm
 * JD-Core Version:    0.7.0.1
 */