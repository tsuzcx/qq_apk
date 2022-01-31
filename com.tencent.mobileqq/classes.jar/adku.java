import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class adku
  implements View.OnClickListener
{
  adku(adkt paramadkt) {}
  
  public void onClick(View paramView)
  {
    if ((!adkt.a(this.a)) || (this.a.a()) || (System.currentTimeMillis() - adkt.a(this.a) < 600L)) {}
    MessageForApollo localMessageForApollo;
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          adkt.a(this.a, System.currentTimeMillis());
          localMessageForApollo = (MessageForApollo)((adly)actn.a(paramView)).a;
          if (localMessageForApollo == null)
          {
            QLog.e("ApolloGameItemBuilder", 1, "errInfo->mr is null.");
            return;
          }
          QLog.i("ApolloGameItemBuilder", 1, "click game msg game staus: " + localMessageForApollo.gameStatus + ", msgType:" + localMessageForApollo.msgType + ",gameId:" + localMessageForApollo.gameId + ",roomId:" + localMessageForApollo.roomId);
          if ((localMessageForApollo.mApolloMessage == null) || (localMessageForApollo.mApolloMessage.id == 99999))
          {
            bcpw.a(paramView.getContext(), ajyc.a(2131700332), 0).a();
            return;
          }
          if (!ApolloEngine.a())
          {
            QLog.w("ApolloGameItemBuilder", 1, "apollo lib NOT loaded, click game return.");
            return;
          }
        } while ((!(this.a.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) || (((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment() == null));
        paramView = ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
      } while ((paramView == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null));
      localObject = (airz)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    } while (localObject == null);
    int i;
    if (localMessageForApollo.gameStatus == 1) {
      i = 0;
    }
    for (;;)
    {
      int k = ((airz)localObject).b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      paramView = paramView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      int m = ApolloUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localMessageForApollo.playerList == null) {}
      for (int j = 0;; j = localMessageForApollo.playerList.size())
      {
        VipUtils.a(paramView, "cmshow", "Apollo", "clk_game_msg", m, j, new String[] { Integer.toString(localMessageForApollo.gameId), Integer.toString(i), Integer.toString(k), Long.toString(localMessageForApollo.roomId) });
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1036) {
          break label734;
        }
        paramView = ApolloUtil.b(localMessageForApollo);
        if ((NetConnInfoCenter.getServerTimeMillis() / 1000L >= localMessageForApollo.time + 60L) || (localMessageForApollo.gameStatus != 0) || (TextUtils.isEmpty(paramView))) {
          break label724;
        }
        QLog.i("ApolloGameItemBuilder", 1, "UIN_TYPE_CMGAME_TEMP start robot game");
        localObject = new CmGameStartChecker.StartCheckParam(localMessageForApollo.gameId, true, "message", localMessageForApollo.roomId, 7, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ApolloGameUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 318001, localMessageForApollo.gameName);
        ((CmGameStartChecker.StartCheckParam)localObject).extendJson = localMessageForApollo.extendJson;
        ((CmGameStartChecker.StartCheckParam)localObject).disableMinGame = true;
        ((CmGameStartChecker.StartCheckParam)localObject).mRobotOpenId = paramView;
        ((CmGameStartChecker.StartCheckParam)localObject).mTempAIOUin = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        ((CmGameStartChecker.StartCheckParam)localObject).mTempAIONickName = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
        ApolloGameUtil.a(this.a.jdField_a_of_type_AndroidContentContext, (CmGameStartChecker.StartCheckParam)localObject);
        aizg.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForApollo.gameId, localMessageForApollo.roomId);
        return;
        if (localMessageForApollo.gameStatus == 3)
        {
          i = 1;
          break;
        }
        if ((localMessageForApollo.gameStatus != 7) && (localMessageForApollo.gameStatus != 4) && (localMessageForApollo.gameStatus != 5) && (localMessageForApollo.gameStatus != 6)) {
          break label904;
        }
        i = 2;
        break;
      }
      label724:
      QLog.i("ApolloGameItemBuilder", 1, "UIN_TYPE_CMGAME_TEMP onClickGameView but dispatch to ark");
      return;
      label734:
      if (localMessageForApollo.msgType == 4)
      {
        i = 201;
        j = localMessageForApollo.mGameMode;
        paramView = new CmGameStartChecker.StartCheckParam(localMessageForApollo.gameId, localMessageForApollo.isSend(), "message", localMessageForApollo.roomId, 1, j, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ApolloGameUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i, localMessageForApollo.gameName);
        if (localMessageForApollo.msgType != 4) {
          break label896;
        }
        paramView.launchNewGame = true;
      }
      for (;;)
      {
        paramView.mSendMsgUin = localMessageForApollo.senderuin;
        paramView.msgGameStatus = localMessageForApollo.gameStatus;
        paramView.extendJson = localMessageForApollo.gameExtendJson;
        ApolloGameUtil.a(this.a.jdField_a_of_type_AndroidContentContext, paramView);
        return;
        i = 200;
        break;
        label896:
        paramView.showAlertTips = true;
      }
      label904:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adku
 * JD-Core Version:    0.7.0.1
 */