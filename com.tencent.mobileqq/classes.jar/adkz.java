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

public class adkz
  implements View.OnClickListener
{
  public adkz(ApolloItemBuilder paramApolloItemBuilder) {}
  
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
    ajqd localajqd;
    do
    {
      return;
      i = 0;
      break;
      j = 0;
      break label68;
      localajqd = new ajqd(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      paramView = new ApolloActionData();
      ajmu localajmu = (ajmu)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      if (localajmu == null) {
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
      paramView = localajmu.a(i);
    } while (paramView == null);
    label416:
    for (;;)
    {
      paramView.peerUin = (localApolloMessage.peer_uin + "");
      if (localApolloMessage.text != null) {
        paramView.atNickName = new String(localApolloMessage.text);
      }
      paramView.inputText = ApolloItemBuilder.a(this.a).inputText;
      localajqd.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = paramView;
      if (ApolloItemBuilder.a(this.a).isBarrageMode()) {}
      for (i = k;; i = 0)
      {
        localajqd.d = i;
        localajqd.b = ApolloItemBuilder.a(this.a).inputText;
        localajqd.e = ApolloItemBuilder.a(this.a).audioId;
        localajqd.jdField_a_of_type_Float = ApolloItemBuilder.a(this.a).audioStartTime;
        aanz.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localajqd);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adkz
 * JD-Core Version:    0.7.0.1
 */