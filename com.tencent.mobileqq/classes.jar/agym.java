import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Apollo3DMessage;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class agym
  implements View.OnClickListener
{
  public agym(ApolloItemBuilder paramApolloItemBuilder) {}
  
  public void onClick(View paramView)
  {
    BaseChatPie localBaseChatPie;
    int i;
    int j;
    label70:
    Object localObject;
    int k;
    label95:
    ApolloMessage localApolloMessage;
    Apollo3DMessage localApollo3DMessage;
    if (ApolloItemBuilder.a(this.a) != null)
    {
      localBaseChatPie = ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
      if (localBaseChatPie != null)
      {
        if (localBaseChatPie.g() != 21) {
          break label186;
        }
        i = 1;
        if (anlk.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0) {
          break label191;
        }
        j = 0;
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!ApolloItemBuilder.a(this.a).isDoubleAction()) {
          break label196;
        }
        k = 1;
        VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "groupplusclick", i, k, new String[] { Integer.toString(ApolloItemBuilder.a(this.a).mApolloMessage.id), String.valueOf(j) });
      }
      localApolloMessage = ApolloItemBuilder.a(this.a).mApolloMessage;
      localApollo3DMessage = ApolloItemBuilder.a(this.a).mApollo3DMessage;
      if ((localApolloMessage != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
        break label202;
      }
    }
    label186:
    label191:
    label196:
    label202:
    anrg localanrg;
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 0;
      break;
      j = 1;
      break label70;
      k = 0;
      break label95;
      localanrg = new anrg(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      localObject = new ApolloActionData();
      annx localannx = (annx)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      if (localannx == null) {
        break label640;
      }
      j = localApolloMessage.id;
      i = j;
      if (localApollo3DMessage != null)
      {
        i = j;
        if (ApolloActionData.isAction3DModel(localApollo3DMessage.actionID_3D)) {
          i = localApollo3DMessage.actionID_3D;
        }
      }
      localObject = localannx.a(i);
    } while (localObject == null);
    label640:
    for (;;)
    {
      ((ApolloActionData)localObject).peerUin = (localApolloMessage.peer_uin + "");
      if (localApolloMessage.text != null) {
        ((ApolloActionData)localObject).atNickName = new String(localApolloMessage.text);
      }
      ((ApolloActionData)localObject).inputText = ApolloItemBuilder.a(this.a).inputText;
      localanrg.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((ApolloActionData)localObject);
      if (ApolloItemBuilder.a(this.a).isBarrageMode())
      {
        i = 1;
        label388:
        localanrg.d = i;
        localanrg.b = ApolloItemBuilder.a(this.a).inputText;
        localanrg.e = ApolloItemBuilder.a(this.a).audioId;
        localanrg.jdField_a_of_type_Float = ApolloItemBuilder.a(this.a).audioStartTime;
        localanrg.h = 2;
        aean.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localanrg);
        if (anlk.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0) {
          break;
        }
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
        if (localObject != null)
        {
          ((MqqHandler)localObject).obtainMessage(49).sendToTarget();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloItemBuilder", 2, "onPlusIconClickListener INIT_STATUS user open panel");
          }
        }
        if ((this.a.jdField_a_of_type_AndroidContentContext == null) || (((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment() == null)) {
          break;
        }
        if ((ApolloItemBuilder.a(this.a).mApollo3DMessage == null) || (ApolloItemBuilder.a(this.a).mApollo3DMessage.actionID_3D <= 0)) {
          break label628;
        }
      }
      label628:
      for (i = 1;; i = 0)
      {
        if (localBaseChatPie.a == null) {
          break label633;
        }
        localBaseChatPie.a.c = 1;
        localBaseChatPie.a.e(i);
        break;
        i = 0;
        break label388;
      }
      label633:
      ApolloPanel.b = i;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agym
 * JD-Core Version:    0.7.0.1
 */