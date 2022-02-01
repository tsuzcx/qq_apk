import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
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

class afur
  implements View.OnClickListener
{
  afur(afuq paramafuq) {}
  
  public void onClick(View paramView)
  {
    if ((!afuq.a(this.a)) || (this.a.a()) || (System.currentTimeMillis() - afuq.a(this.a) < 600L)) {}
    MessageForApollo localMessageForApollo;
    Object localObject;
    alnr localalnr;
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
            afuq.a(this.a, System.currentTimeMillis());
            localMessageForApollo = (MessageForApollo)((afvw)AIOUtils.getHolder(paramView)).a;
            if (localMessageForApollo == null)
            {
              QLog.e("ApolloGameItemBuilder", 1, "errInfo->mr is null.");
            }
            else
            {
              QLog.i("ApolloGameItemBuilder", 1, "click game msg game staus: " + localMessageForApollo.gameStatus + ", msgType:" + localMessageForApollo.msgType + ",gameId:" + localMessageForApollo.gameId + ",roomId:" + localMessageForApollo.roomId);
              if ((localMessageForApollo.mApolloMessage == null) || (localMessageForApollo.mApolloMessage.id == 99999))
              {
                QQToast.a(paramView.getContext(), amtj.a(2131699491), 0).a();
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
      localalnr = (alnr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    } while (localalnr == null);
    int i;
    if (localMessageForApollo.gameStatus == 1) {
      i = 0;
    }
    for (;;)
    {
      label310:
      int k = localalnr.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      localObject = ((BaseChatPie)localObject).app;
      int m = ApolloUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localMessageForApollo.playerList == null) {}
      for (int j = 0;; j = localMessageForApollo.playerList.size())
      {
        VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "clk_game_msg", m, j, new String[] { Integer.toString(localMessageForApollo.gameId), Integer.toString(i), Integer.toString(k), Long.toString(localMessageForApollo.roomId) });
        afuq.a(this.a, localMessageForApollo);
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
 * Qualified Name:     afur
 * JD-Core Version:    0.7.0.1
 */