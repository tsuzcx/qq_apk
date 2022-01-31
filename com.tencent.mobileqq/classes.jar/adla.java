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
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;

public class adla
  implements View.OnClickListener
{
  public adla(ApolloItemBuilder paramApolloItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if ((!this.a.f) || (this.a.a()) || (System.currentTimeMillis() - ApolloItemBuilder.b(this.a) < 600L)) {}
    adle localadle;
    MessageForApollo localMessageForApollo;
    do
    {
      return;
      ApolloItemBuilder.b(this.a, System.currentTimeMillis());
      airz.jdField_a_of_type_JavaUtilArrayList.clear();
      localadle = (adle)actn.a(paramView);
      localMessageForApollo = (MessageForApollo)localadle.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
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
        bcpw.a(paramView.getContext(), ajyc.a(2131700397), 0).a();
        return;
      }
    } while (!airz.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()));
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
        paramView = (airz)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
        if ((paramView != null) && (paramView.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) != 2))
        {
          localadle.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          if (!airz.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(localadle.e))) {
            airz.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(localadle.e));
          }
        }
        if (!bbev.g(this.a.jdField_a_of_type_AndroidContentContext)) {
          break;
        }
      }
      Object localObject = (airz)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      paramView = (bbqp)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
      if (paramView != null)
      {
        ArrayList localArrayList = new ArrayList(2);
        if (!localMessageForApollo.isSend())
        {
          ApolloBaseInfo localApolloBaseInfo = ((airz)localObject).a(localMessageForApollo.senderuin);
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
          localObject = ((airz)localObject).a(localMessageForApollo.mApolloMessage.peer_uin + "");
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
      this.a.a(localadle, 2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adla
 * JD-Core Version:    0.7.0.1
 */