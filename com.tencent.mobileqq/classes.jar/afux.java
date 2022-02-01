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
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Apollo3DMessage;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashSet;
import mqq.os.MqqHandler;

public class afux
  implements View.OnClickListener
{
  public afux(ApolloItemBuilder paramApolloItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if ((!this.a.f) || (this.a.a()) || (System.currentTimeMillis() - ApolloItemBuilder.b(this.a) < 600L)) {}
    afvb localafvb;
    Object localObject1;
    int i;
    label251:
    do
    {
      do
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          ApolloItemBuilder.b(this.a, System.currentTimeMillis());
          alnr.jdField_a_of_type_JavaUtilArrayList.clear();
          localafvb = (afvb)AIOUtils.getHolder(paramView);
          localObject1 = (MessageForApollo)localafvb.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          if (localObject1 == null)
          {
            QLog.e("ApolloItemBuilder", 1, "errInfo->mr is null.");
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloItemBuilder", 2, "click game msg, roomId:" + ((MessageForApollo)localObject1).roomId);
            }
            if ((((MessageForApollo)localObject1).mApolloMessage != null) && (((MessageForApollo)localObject1).mApolloMessage.id != 99999)) {
              break;
            }
            QQToast.a(paramView.getContext(), amtj.a(2131699556), 0).a();
          }
        }
      } while (!alnr.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()));
      int j = ((alnr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      if (ApolloGameUtil.a(((MessageForApollo)localObject1).msgType)) {
        break;
      }
      int k = ((MessageForApollo)localObject1).mApolloMessage.id;
      if (!((MessageForApollo)localObject1).isDoubleAction()) {
        break label655;
      }
      i = 1;
      if (ApolloUtil.a(k, i)) {
        break;
      }
      if (j != 2)
      {
        localafvb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        if (!alnr.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(localafvb.e))) {
          alnr.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(localafvb.e));
        }
      }
    } while (!NetworkUtil.isNetworkAvailable(this.a.jdField_a_of_type_AndroidContentContext));
    ApolloItemBuilder.a(this.a, (MessageForApollo)localObject1);
    if (amge.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0)
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
          break label660;
        }
        i = 1;
        label460:
        if (((BaseChatPie)localObject2).mApolloPanel == null) {
          break label665;
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
          VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "new_clk_action", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, ApolloUtil.b(((BaseChatPie)localObject1).getCurType()), amge.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), new String[] { String.valueOf(localafvb.e), "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
        }
      }
      this.a.a(localafvb, 2);
      break;
      label655:
      i = 0;
      break label251;
      label660:
      i = 0;
      break label460;
      label665:
      ApolloPanel.b = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afux
 * JD-Core Version:    0.7.0.1
 */