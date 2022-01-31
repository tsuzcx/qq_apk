import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Apollo3DMessage;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.utils.VipUtils;

public class afdj
  implements View.OnClickListener
{
  public afdj(ApolloItemBuilder paramApolloItemBuilder) {}
  
  public void onClick(View paramView)
  {
    int k = 1;
    int i;
    int j;
    label68:
    ApolloMessage localApolloMessage;
    Apollo3DMessage localApollo3DMessage;
    if (ApolloItemBuilder.a(this.a) != null)
    {
      paramView = ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
      if (paramView != null)
      {
        if (paramView.f() != 21) {
          break label143;
        }
        i = 1;
        paramView = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!ApolloItemBuilder.a(this.a).isDoubleAction()) {
          break label148;
        }
        j = 1;
        VipUtils.a(paramView, "cmshow", "Apollo", "groupplusclick", i, j, new String[] { Integer.toString(ApolloItemBuilder.a(this.a).mApolloMessage.id) });
      }
      localApolloMessage = ApolloItemBuilder.a(this.a).mApolloMessage;
      localApollo3DMessage = ApolloItemBuilder.a(this.a).mApollo3DMessage;
      if ((localApolloMessage != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
        break label153;
      }
    }
    label143:
    label148:
    label153:
    alhq localalhq;
    do
    {
      return;
      i = 0;
      break;
      j = 0;
      break label68;
      localalhq = new alhq(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      paramView = new ApolloActionData();
      aleh localaleh = (aleh)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      if (localaleh == null) {
        break label416;
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
      paramView = localaleh.a(i);
    } while (paramView == null);
    label416:
    for (;;)
    {
      paramView.peerUin = (localApolloMessage.peer_uin + "");
      if (localApolloMessage.text != null) {
        paramView.atNickName = new String(localApolloMessage.text);
      }
      paramView.inputText = ApolloItemBuilder.a(this.a).inputText;
      localalhq.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = paramView;
      if (ApolloItemBuilder.a(this.a).isBarrageMode()) {}
      for (i = k;; i = 0)
      {
        localalhq.d = i;
        localalhq.b = ApolloItemBuilder.a(this.a).inputText;
        localalhq.e = ApolloItemBuilder.a(this.a).audioId;
        localalhq.jdField_a_of_type_Float = ApolloItemBuilder.a(this.a).audioStartTime;
        acex.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localalhq);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afdj
 * JD-Core Version:    0.7.0.1
 */