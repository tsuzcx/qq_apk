import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Apollo3DMessage;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashSet;
import mqq.os.MqqHandler;

public class agpf
  implements View.OnClickListener
{
  public agpf(ApolloItemBuilder paramApolloItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if ((!this.a.f) || (this.a.a()) || (System.currentTimeMillis() - ApolloItemBuilder.b(this.a) < 600L)) {}
    agpj localagpj;
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
          amhd.jdField_a_of_type_JavaUtilArrayList.clear();
          localagpj = (agpj)afur.a(paramView);
          localObject1 = (MessageForApollo)localagpj.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
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
            QQToast.a(paramView.getContext(), anni.a(2131699214), 0).a();
          }
        }
      } while (!amhd.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()));
      int j = ((amhd)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      if (ApolloGameUtil.a(((MessageForApollo)localObject1).msgType)) {
        break;
      }
      int k = ((MessageForApollo)localObject1).mApolloMessage.id;
      if (!((MessageForApollo)localObject1).isDoubleAction()) {
        break label629;
      }
      i = 1;
      if (ApolloUtil.a(k, i)) {
        break;
      }
      if (j != 2)
      {
        localagpj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        if (!amhd.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(localagpj.e))) {
          amhd.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(localagpj.e));
        }
      }
    } while (!bgnt.g(this.a.jdField_a_of_type_AndroidContentContext));
    ApolloItemBuilder.a(this.a, (MessageForApollo)localObject1);
    if (amzq.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0)
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
          break label634;
        }
        i = 1;
        label460:
        if (((BaseChatPie)localObject2).a == null) {
          break label639;
        }
        ((BaseChatPie)localObject2).a.c = 0;
        ((BaseChatPie)localObject2).a.e(i);
      }
    }
    for (;;)
    {
      localObject1 = ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
      if ((localObject1 != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)) {
        VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "new_clk_action", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, ApolloUtil.b(((BaseChatPie)localObject1).b()), amzq.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), new String[] { String.valueOf(localagpj.e), "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      }
      this.a.a(localagpj, 2);
      break;
      label629:
      i = 0;
      break label251;
      label634:
      i = 0;
      break label460;
      label639:
      ApolloPanel.b = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agpf
 * JD-Core Version:    0.7.0.1
 */