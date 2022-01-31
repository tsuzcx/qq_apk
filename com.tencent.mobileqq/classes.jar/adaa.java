import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.qphone.base.util.QLog;

public class adaa
  implements View.OnClickListener
{
  public adaa(ApolloItemBuilder paramApolloItemBuilder) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (adac)aciy.a(paramView);
    paramView = (aifg)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    localObject = (MessageForApollo)((adac)localObject).a;
    if (localObject == null)
    {
      QLog.e("ApolloItemBuilder", 1, "errInfo->mr is null.");
      return;
    }
    ApolloActionData localApolloActionData = ((aiyu)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).b(((MessageForApollo)localObject).mApolloMessage.id);
    if (localApolloActionData == null)
    {
      QLog.e("ApolloItemBuilder", 1, "ApolloActionData is null.");
      return;
    }
    CmGameStartChecker.StartCheckParam localStartCheckParam = new CmGameStartChecker.StartCheckParam(localApolloActionData.gameId, ((MessageForApollo)localObject).isSend(), "message", 0L, 1, 0, 0, 0, "", 333001, localApolloActionData.gameName);
    localStartCheckParam.version = paramView.a(localApolloActionData.gameId);
    localStartCheckParam.disableMinGame = true;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "game tail click: " + localStartCheckParam.toString());
    }
    ApolloGameUtil.a(this.a.jdField_a_of_type_AndroidContentContext, localStartCheckParam);
    bajr.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "game_actiontail_clk", ApolloUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), 0, new String[] { Integer.toString(((MessageForApollo)localObject).mApolloMessage.id), Integer.toString(localApolloActionData.gameId) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adaa
 * JD-Core Version:    0.7.0.1
 */