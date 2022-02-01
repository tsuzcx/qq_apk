import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class agoz
  implements View.OnClickListener
{
  agoz(agoy paramagoy) {}
  
  public void onClick(View paramView)
  {
    if ((!agoy.a(this.a)) || (this.a.a()) || (System.currentTimeMillis() - agoy.a(this.a) < 600L)) {}
    MessageForApollo localMessageForApollo;
    Object localObject;
    amhd localamhd;
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            EventCollector.getInstance().onViewClicked(paramView);
            return;
            agoy.a(this.a, System.currentTimeMillis());
            localMessageForApollo = (MessageForApollo)((agqe)afur.a(paramView)).a;
            if (localMessageForApollo == null)
            {
              QLog.e("ApolloGameItemBuilder", 1, "errInfo->mr is null.");
            }
            else
            {
              QLog.i("ApolloGameItemBuilder", 1, "click game msg game staus: " + localMessageForApollo.gameStatus + ", msgType:" + localMessageForApollo.msgType + ",gameId:" + localMessageForApollo.gameId + ",roomId:" + localMessageForApollo.roomId);
              if ((localMessageForApollo.mApolloMessage == null) || (localMessageForApollo.mApolloMessage.id == 99999))
              {
                QQToast.a(paramView.getContext(), anni.a(2131699149), 0).a();
              }
              else
              {
                if (ApolloEngine.a()) {
                  break;
                }
                QLog.w("ApolloGameItemBuilder", 1, "apollo lib NOT loaded, click game return.");
              }
            }
          }
        } while ((!(this.a.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) || (((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment() == null));
        localObject = ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
      } while ((localObject == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null));
      localamhd = (amhd)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    } while (localamhd == null);
    int i;
    if (localMessageForApollo.gameStatus == 1) {
      i = 0;
    }
    for (;;)
    {
      label310:
      int k = localamhd.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      localObject = ((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      int m = ApolloUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localMessageForApollo.playerList == null) {}
      for (int j = 0;; j = localMessageForApollo.playerList.size())
      {
        VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "clk_game_msg", m, j, new String[] { Integer.toString(localMessageForApollo.gameId), Integer.toString(i), Integer.toString(k), Long.toString(localMessageForApollo.roomId) });
        agoy.a(this.a, localMessageForApollo);
        break;
        if (localMessageForApollo.gameStatus == 3)
        {
          i = 1;
          break label310;
        }
        if ((localMessageForApollo.gameStatus != 7) && (localMessageForApollo.gameStatus != 4) && (localMessageForApollo.gameStatus != 5) && (localMessageForApollo.gameStatus != 6)) {
          break label501;
        }
        i = 2;
        break label310;
      }
      label501:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agoz
 * JD-Core Version:    0.7.0.1
 */