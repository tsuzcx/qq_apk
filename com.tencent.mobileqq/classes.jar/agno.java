import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class agno
  implements View.OnClickListener
{
  public agno(ApolloItemBuilder paramApolloItemBuilder) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (agnq)AIOUtils.getHolder(paramView);
    amme localamme = (amme)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER);
    localObject = (MessageForApollo)((agnq)localObject).a;
    if (localObject == null) {
      QLog.e("ApolloItemBuilder", 1, "errInfo->mr is null.");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ApolloActionData localApolloActionData = ((ankc)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOOLO_DAO_MANAGER)).b(((MessageForApollo)localObject).mApolloMessage.id);
      if (localApolloActionData == null)
      {
        QLog.e("ApolloItemBuilder", 1, "ApolloActionData is null.");
      }
      else
      {
        CmGameStartChecker.StartCheckParam localStartCheckParam = new CmGameStartChecker.StartCheckParam(localApolloActionData.gameId, ((MessageForApollo)localObject).isSend(), "message", 0L, 1, 0, 0, 0, "", 333001, localApolloActionData.gameName);
        localStartCheckParam.version = localamme.a(localApolloActionData.gameId);
        localStartCheckParam.disableMinGame = true;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloItemBuilder", 2, "game tail click: " + localStartCheckParam.toString());
        }
        ApolloGameUtil.a(this.a.jdField_a_of_type_AndroidContentContext, localStartCheckParam);
        VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "game_actiontail_clk", ApolloUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), 0, new String[] { Integer.toString(((MessageForApollo)localObject).mApolloMessage.id), Integer.toString(localApolloActionData.gameId) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agno
 * JD-Core Version:    0.7.0.1
 */