import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;

public class afdi
  implements View.OnClickListener
{
  public afdi(ApolloItemBuilder paramApolloItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if ((!this.a.f) || (this.a.a()) || (System.currentTimeMillis() - ApolloItemBuilder.b(this.a) < 600L)) {}
    afdm localafdm;
    MessageForApollo localMessageForApollo;
    do
    {
      return;
      ApolloItemBuilder.b(this.a, System.currentTimeMillis());
      akji.jdField_a_of_type_JavaUtilArrayList.clear();
      localafdm = (afdm)aekt.a(paramView);
      localMessageForApollo = (MessageForApollo)localafdm.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (localMessageForApollo == null)
      {
        QLog.e("ApolloItemBuilder", 1, "errInfo->mr is null.");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloItemBuilder", 2, "click game msg, roomId:" + localMessageForApollo.roomId);
      }
      if ((localMessageForApollo.mApolloMessage == null) || (localMessageForApollo.mApolloMessage.id == 99999))
      {
        QQToast.a(paramView.getContext(), alpo.a(2131700777), 0).a();
        return;
      }
    } while (!akji.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()));
    int j;
    if (!ApolloGameUtil.a(localMessageForApollo.msgType))
    {
      j = localMessageForApollo.mApolloMessage.id;
      if (!localMessageForApollo.isDoubleAction()) {
        break label706;
      }
    }
    label706:
    for (int i = 1;; i = 0)
    {
      if (!ApolloUtil.a(j, i))
      {
        paramView = (akji)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
        if ((paramView != null) && (paramView.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) != 2))
        {
          localafdm.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          if (!akji.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(localafdm.e))) {
            akji.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(localafdm.e));
          }
        }
        if (!bdee.g(this.a.jdField_a_of_type_AndroidContentContext)) {
          break;
        }
      }
      Object localObject = (akji)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      paramView = (bdpx)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
      if (paramView != null)
      {
        ArrayList localArrayList = new ArrayList(2);
        if (!localMessageForApollo.isSend())
        {
          ApolloBaseInfo localApolloBaseInfo = ((akji)localObject).a(localMessageForApollo.senderuin);
          if ((localApolloBaseInfo == null) || (NetConnInfoCenter.getServerTime() - localApolloBaseInfo.apolloUpdateTime > 300L)) {
            localArrayList.add(localMessageForApollo.senderuin);
          }
          if ((QLog.isColorLevel()) && (localApolloBaseInfo != null) && (!localApolloBaseInfo.isApolloStatusOpen()))
          {
            i = localApolloBaseInfo.apolloStatus;
            QLog.d("ApolloItemBuilder", 2, "apollo status is not opened uin: " + localMessageForApollo.senderuin + ", status: " + i);
          }
        }
        if ((localMessageForApollo.isDoubleAction()) && (localMessageForApollo.mApolloMessage.peer_uin > 0L) && (localMessageForApollo.mApolloMessage.peer_uin != this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()))
        {
          localObject = ((akji)localObject).a(localMessageForApollo.mApolloMessage.peer_uin + "");
          if ((localObject == null) || (NetConnInfoCenter.getServerTime() - ((ApolloBaseInfo)localObject).apolloUpdateTime > 300L)) {
            localArrayList.add(localMessageForApollo.mApolloMessage.peer_uin + "");
          }
          if ((QLog.isColorLevel()) && (localObject != null) && (!((ApolloBaseInfo)localObject).isApolloStatusOpen()))
          {
            i = ((ApolloBaseInfo)localObject).apolloStatus;
            QLog.d("ApolloItemBuilder", 2, "apollo status is not opened uin: " + localMessageForApollo.mApolloMessage.peer_uin + ", status: " + i);
          }
        }
        if (!localArrayList.isEmpty()) {
          paramView.a((String[])localArrayList.toArray(new String[0]));
        }
      }
      this.a.a(localafdm, 2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afdi
 * JD-Core Version:    0.7.0.1
 */