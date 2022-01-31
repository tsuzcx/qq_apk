import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.1;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.10;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.11;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.12;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.2;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.3;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.4;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.5;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.6;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.7;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.8;
import com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.9;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.os.MqqHandler;

public class aenk
  extends aizj
{
  private WeakReference<aemy> a;
  
  aenk(aemy paramaemy)
  {
    this.a = new WeakReference(paramaemy);
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameChatPie", 2, "[onPushPlaymateExitAio] friendUin:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    aemy localaemy;
    do
    {
      return;
      localaemy = (aemy)this.a.get();
    } while ((localaemy == null) || (localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (!paramString.equals(localaemy.a())));
    localaemy.a(paramString, localaemy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "", 3);
  }
  
  public void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
    aemy localaemy = (aemy)this.a.get();
    if ((localaemy == null) || (localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaemy.a()))) {
      return;
    }
    if (paramInt == 0) {}
    for (boolean bool = false;; bool = true)
    {
      localaemy.u(bool);
      return;
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameChatPie", 2, "[onQueryUserStatus] friendUin:" + paramString + ",status:" + paramInt1 + ",lastTs:" + paramInt2);
    }
    super.a(paramString, paramInt1, paramInt2);
    aemy localaemy = (aemy)this.a.get();
    if ((localaemy == null) || (localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while (!localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.11(this, localaemy, paramString, paramInt1, paramInt2));
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    aemy localaemy = (aemy)this.a.get();
    if ((localaemy == null) || (localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.9(this, localaemy, paramInt, paramLong));
  }
  
  public void a(String paramString, int paramInt, List<MessageForApollo> paramList)
  {
    super.a(paramString, paramInt, paramList);
    aemy localaemy = (aemy)this.a.get();
    if ((localaemy == null) || (localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
        if (aemy.a(localaemy) != null) {
          aemy.a(localaemy).dismiss();
        }
      } while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
      localQQAppInterface = localaemy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    } while (localQQAppInterface == null);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      QLog.e("CmGameChatPie", 1, "onAcceptMyInvite msgs == null || msgs.isEmpty()");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CmGameChatPie", 2, new Object[] { "onAcceptMyInvite friendUin:", paramString, " msgs.size:", Integer.valueOf(paramList.size()) });
    }
    if (aemy.a(localaemy))
    {
      QLog.e("CmGameChatPie", 1, "onAcceptMyInvite chatPie.mStoped");
      return;
    }
    paramString = (MessageForApollo)paramList.get(0);
    paramString = new CmGameStartChecker.StartCheckParam(paramString.gameId, paramString.isSend(), "message", paramString.roomId, 1, 0, localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ApolloGameUtil.a(localQQAppInterface, localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, aemy.c(localaemy), paramString.gameName);
    paramString.mTempAIOUin = localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramString.mTempAIONickName = localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
    paramString.disableMinGame = true;
    ApolloGameUtil.a(localaemy.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString);
    aemy.U = true;
  }
  
  public void a(String paramString, aenl paramaenl)
  {
    aemy localaemy = (aemy)this.a.get();
    if ((localaemy == null) || (localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.1(this, localaemy, paramString, paramaenl));
  }
  
  public void a(String paramString, aizm paramaizm)
  {
    aemy localaemy = (aemy)this.a.get();
    if ((localaemy == null) || (localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    localaemy.a(paramaizm);
  }
  
  public void a(String paramString, List<ApolloGameData> paramList)
  {
    super.a(paramString, paramList);
    aemy localaemy = (aemy)this.a.get();
    if ((localaemy == null) || (localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
      localaemy.b(paramList);
    } while (localaemy.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel == null);
    localaemy.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.m();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    super.a(paramString, paramBoolean);
    paramString = (aemy)this.a.get();
    if ((paramString == null) || (paramString.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {
      return;
    }
    paramString.u(paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    super.a(paramBoolean, paramInt1, paramLong, paramInt2);
    aemy localaemy = (aemy)this.a.get();
    if ((localaemy == null) || (localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean)
        {
          QLog.e("CmGameTemp_CmGameChatPie", 1, "onCreateRoomId createSuccess:false");
          ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.7(this, localaemy));
          return;
        }
      } while (localaemy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      if (aemy.a(localaemy) != paramInt2) {
        break label216;
      }
      if (!aizr.a(localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        break;
      }
    } while (aemy.a(localaemy) == null);
    String str = aemy.a(localaemy).a();
    if (aemy.d(localaemy) == paramInt2)
    {
      aize.a(localaemy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, paramLong, paramInt1);
      localaemy.c(paramLong);
      return;
    }
    localaemy.a(paramInt1, paramLong);
    ThreadManagerV2.getUIHandlerV2().postDelayed(new CmGameChatPie.ChatPieMsgListener.8(this, localaemy, paramInt1, paramLong, str), 1500L);
    return;
    ((airx)localaemy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().a(localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramInt1, paramLong);
    return;
    label216:
    QLog.e("CmGameTemp_CmGameChatPie", 1, "onCreateRoomId chatPie.mCreateRoomReqCode != reqCode, reqCode:" + paramInt2);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    super.a(paramBoolean, paramString, paramInt, paramLong);
    aemy localaemy = (aemy)this.a.get();
    if ((localaemy == null) || (localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (localaemy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (paramBoolean) {
      localaemy.a(paramInt, paramLong);
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.2(this, localaemy, paramBoolean));
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, long paramLong, String paramString2)
  {
    super.a(paramBoolean, paramString1, paramInt, paramLong, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameChatPie", 2, "[onCheckRobotModeRsp] friendUin:" + paramString1 + ",gameId:" + paramInt + ",roomId:" + paramLong);
    }
    aemy localaemy = (aemy)this.a.get();
    if ((localaemy == null) || (localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (localaemy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    while ((TextUtils.isEmpty(paramString1)) || (!paramString1.equals(localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (!paramBoolean)) {
      return;
    }
    long l = System.currentTimeMillis() - aize.jdField_a_of_type_Long;
    if (l > 1500L)
    {
      localaemy.a(paramInt, paramLong, paramString2);
      return;
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new CmGameChatPie.ChatPieMsgListener.12(this, localaemy, paramInt, paramLong, paramString2), 1500L - l);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt, long paramLong)
  {
    super.a(paramBoolean1, paramBoolean2, paramString, paramInt, paramLong);
    aemy localaemy = (aemy)this.a.get();
    if ((localaemy == null) || (localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (!paramBoolean1));
      if (aemy.a(localaemy))
      {
        QLog.e("CmGameTemp_CmGameChatPie", 1, "onOneMoreGameRspFinish chatPie.mStoped");
        return;
      }
    } while ((!paramBoolean2) || (localaemy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (aemy.a(localaemy) == null));
    paramString = new CmGameStartChecker.StartCheckParam(aemy.a(localaemy).jdField_a_of_type_Int, true, "message", aemy.a(localaemy).jdField_a_of_type_Long, 1, 0, localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ApolloGameUtil.a(localaemy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, aemy.c(localaemy), null);
    paramString.mTempAIOUin = localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramString.mTempAIONickName = localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
    paramString.disableMinGame = true;
    ApolloGameUtil.a(localaemy.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString);
    aemy.U = true;
    aize.b(localaemy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramInt, paramLong);
  }
  
  public void b(String paramString)
  {
    aemy localaemy = (aemy)this.a.get();
    if ((localaemy == null) || (localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.3(this, localaemy, paramString));
  }
  
  public void b(boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    aemy localaemy = (aemy)this.a.get();
    if ((localaemy == null) || (localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (localaemy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (!paramBoolean) {
      aize.a(localaemy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramInt, paramLong);
    }
    if (aemy.a(localaemy))
    {
      QLog.e("CmGameTemp_CmGameChatPie", 1, "onPushOneMoreGameMsgRsp chatPie.mStoped");
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.10(this, paramBoolean, localaemy, paramInt, paramLong));
  }
  
  public void c(String paramString)
  {
    aemy localaemy = (aemy)this.a.get();
    if ((localaemy == null) || (localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.4(this, localaemy, paramString));
  }
  
  public void d(String paramString)
  {
    aemy localaemy = (aemy)this.a.get();
    if ((localaemy == null) || (localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.5(this, localaemy, paramString));
  }
  
  public void e(String paramString)
  {
    aemy localaemy = (aemy)this.a.get();
    if ((localaemy == null) || (localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaemy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.6(this, localaemy, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aenk
 * JD-Core Version:    0.7.0.1
 */