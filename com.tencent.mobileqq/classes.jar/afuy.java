import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
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

public class afuy
  implements View.OnClickListener
{
  public afuy(ApolloItemBuilder paramApolloItemBuilder) {}
  
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
        if (localBaseChatPie.getCurrentPanel() != 21) {
          break label186;
        }
        i = 1;
        if (amge.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0) {
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
    amlx localamlx;
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
      localamlx = new amlx(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      localObject = new ApolloActionData();
      amir localamir = (amir)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      if (localamir == null) {
        break label645;
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
      localObject = localamir.a(i);
    } while (localObject == null);
    label388:
    label645:
    for (;;)
    {
      ((ApolloActionData)localObject).peerUin = (localApolloMessage.peer_uin + "");
      if (localApolloMessage.text != null) {
        ((ApolloActionData)localObject).atNickName = new String(localApolloMessage.text);
      }
      ((ApolloActionData)localObject).inputText = ApolloItemBuilder.a(this.a).inputText;
      localamlx.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((ApolloActionData)localObject);
      if (ApolloItemBuilder.a(this.a).isBarrageMode())
      {
        i = 1;
        localamlx.d = i;
        localamlx.b = ApolloItemBuilder.a(this.a).inputText;
        localamlx.e = ApolloItemBuilder.a(this.a).audioId;
        localamlx.jdField_a_of_type_Float = ApolloItemBuilder.a(this.a).audioStartTime;
        localamlx.h = 2;
        acvv.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localamlx);
        if (amge.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0) {
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
          break label633;
        }
      }
      label633:
      for (i = 1;; i = 0)
      {
        if ((localBaseChatPie == null) || (localBaseChatPie.mApolloPanel == null)) {
          break label638;
        }
        localBaseChatPie.mApolloPanel.c = 1;
        localBaseChatPie.mApolloPanel.e(i);
        break;
        i = 0;
        break label388;
      }
      label638:
      ApolloPanel.b = i;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afuy
 * JD-Core Version:    0.7.0.1
 */