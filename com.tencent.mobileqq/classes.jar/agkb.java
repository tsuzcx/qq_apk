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

public class agkb
  extends akqv
{
  private WeakReference<agjp> a;
  
  agkb(agjp paramagjp)
  {
    this.a = new WeakReference(paramagjp);
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameChatPie", 2, "[onPushPlaymateExitAio] friendUin:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    agjp localagjp;
    do
    {
      return;
      localagjp = (agjp)this.a.get();
    } while ((localagjp == null) || (localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (!paramString.equals(localagjp.a())));
    localagjp.a(paramString, localagjp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "", 3);
  }
  
  public void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
    agjp localagjp = (agjp)this.a.get();
    if ((localagjp == null) || (localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localagjp.a()))) {
      return;
    }
    if (paramInt == 0) {}
    for (boolean bool = false;; bool = true)
    {
      localagjp.u(bool);
      return;
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameChatPie", 2, "[onQueryUserStatus] friendUin:" + paramString + ",status:" + paramInt1 + ",lastTs:" + paramInt2);
    }
    super.a(paramString, paramInt1, paramInt2);
    agjp localagjp = (agjp)this.a.get();
    if ((localagjp == null) || (localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while (!localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.11(this, localagjp, paramString, paramInt1, paramInt2));
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    agjp localagjp = (agjp)this.a.get();
    if ((localagjp == null) || (localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.9(this, localagjp, paramInt, paramLong));
  }
  
  public void a(String paramString, int paramInt, List<MessageForApollo> paramList)
  {
    super.a(paramString, paramInt, paramList);
    agjp localagjp = (agjp)this.a.get();
    if ((localagjp == null) || (localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
        if (agjp.a(localagjp) != null) {
          agjp.a(localagjp).dismiss();
        }
      } while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
      localQQAppInterface = localagjp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    } while (localQQAppInterface == null);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      QLog.e("CmGameChatPie", 1, "onAcceptMyInvite msgs == null || msgs.isEmpty()");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CmGameChatPie", 2, new Object[] { "onAcceptMyInvite friendUin:", paramString, " msgs.size:", Integer.valueOf(paramList.size()) });
    }
    if (agjp.a(localagjp))
    {
      QLog.e("CmGameChatPie", 1, "onAcceptMyInvite chatPie.mStoped");
      return;
    }
    paramString = (MessageForApollo)paramList.get(0);
    paramString = new CmGameStartChecker.StartCheckParam(paramString.gameId, paramString.isSend(), "message", paramString.roomId, 1, 0, localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ApolloGameUtil.a(localQQAppInterface, localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, agjp.c(localagjp), paramString.gameName);
    paramString.mTempAIOUin = localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramString.mTempAIONickName = localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
    paramString.disableMinGame = true;
    ApolloGameUtil.a(localagjp.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString);
    agjp.U = true;
  }
  
  public void a(String paramString, agkc paramagkc)
  {
    agjp localagjp = (agjp)this.a.get();
    if ((localagjp == null) || (localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.1(this, localagjp, paramString, paramagkc));
  }
  
  public void a(String paramString, akqy paramakqy)
  {
    agjp localagjp = (agjp)this.a.get();
    if ((localagjp == null) || (localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    localagjp.a(paramakqy);
  }
  
  public void a(String paramString, List<ApolloGameData> paramList)
  {
    super.a(paramString, paramList);
    agjp localagjp = (agjp)this.a.get();
    if ((localagjp == null) || (localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
      localagjp.b(paramList);
    } while (localagjp.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel == null);
    localagjp.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.m();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    super.a(paramString, paramBoolean);
    paramString = (agjp)this.a.get();
    if ((paramString == null) || (paramString.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {
      return;
    }
    paramString.u(paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    super.a(paramBoolean, paramInt1, paramLong, paramInt2);
    agjp localagjp = (agjp)this.a.get();
    if ((localagjp == null) || (localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean)
        {
          QLog.e("CmGameTemp_CmGameChatPie", 1, "onCreateRoomId createSuccess:false");
          ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.7(this, localagjp));
          return;
        }
      } while (localagjp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      if (agjp.a(localagjp) != paramInt2) {
        break label216;
      }
      if (!akrd.a(localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        break;
      }
    } while (agjp.a(localagjp) == null);
    String str = agjp.a(localagjp).a();
    if (agjp.d(localagjp) == paramInt2)
    {
      akqq.a(localagjp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, paramLong, paramInt1);
      localagjp.c(paramLong);
      return;
    }
    localagjp.a(paramInt1, paramLong);
    ThreadManagerV2.getUIHandlerV2().postDelayed(new CmGameChatPie.ChatPieMsgListener.8(this, localagjp, paramInt1, paramLong, str), 1500L);
    return;
    ((akji)localagjp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().a(localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramInt1, paramLong);
    return;
    label216:
    QLog.e("CmGameTemp_CmGameChatPie", 1, "onCreateRoomId chatPie.mCreateRoomReqCode != reqCode, reqCode:" + paramInt2);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    super.a(paramBoolean, paramString, paramInt, paramLong);
    agjp localagjp = (agjp)this.a.get();
    if ((localagjp == null) || (localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (localagjp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (paramBoolean) {
      localagjp.a(paramInt, paramLong);
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.2(this, localagjp, paramBoolean));
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, long paramLong, String paramString2)
  {
    super.a(paramBoolean, paramString1, paramInt, paramLong, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameChatPie", 2, "[onCheckRobotModeRsp] friendUin:" + paramString1 + ",gameId:" + paramInt + ",roomId:" + paramLong);
    }
    agjp localagjp = (agjp)this.a.get();
    if ((localagjp == null) || (localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (localagjp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    while ((TextUtils.isEmpty(paramString1)) || (!paramString1.equals(localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (!paramBoolean)) {
      return;
    }
    long l = System.currentTimeMillis() - akqq.jdField_a_of_type_Long;
    if (l > 1500L)
    {
      localagjp.a(paramInt, paramLong, paramString2);
      return;
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new CmGameChatPie.ChatPieMsgListener.12(this, localagjp, paramInt, paramLong, paramString2), 1500L - l);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt, long paramLong)
  {
    super.a(paramBoolean1, paramBoolean2, paramString, paramInt, paramLong);
    agjp localagjp = (agjp)this.a.get();
    if ((localagjp == null) || (localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (!paramBoolean1));
      if (agjp.a(localagjp))
      {
        QLog.e("CmGameTemp_CmGameChatPie", 1, "onOneMoreGameRspFinish chatPie.mStoped");
        return;
      }
    } while ((!paramBoolean2) || (localagjp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (agjp.a(localagjp) == null));
    paramString = new CmGameStartChecker.StartCheckParam(agjp.a(localagjp).jdField_a_of_type_Int, true, "message", agjp.a(localagjp).jdField_a_of_type_Long, 1, 0, localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ApolloGameUtil.a(localagjp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, agjp.c(localagjp), null);
    paramString.mTempAIOUin = localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramString.mTempAIONickName = localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
    paramString.disableMinGame = true;
    ApolloGameUtil.a(localagjp.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString);
    agjp.U = true;
    akqq.b(localagjp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramInt, paramLong);
  }
  
  public void b(String paramString)
  {
    agjp localagjp = (agjp)this.a.get();
    if ((localagjp == null) || (localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.3(this, localagjp, paramString));
  }
  
  public void b(boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    agjp localagjp = (agjp)this.a.get();
    if ((localagjp == null) || (localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (localagjp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (!paramBoolean) {
      akqq.a(localagjp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramInt, paramLong);
    }
    if (agjp.a(localagjp))
    {
      QLog.e("CmGameTemp_CmGameChatPie", 1, "onPushOneMoreGameMsgRsp chatPie.mStoped");
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.10(this, paramBoolean, localagjp, paramInt, paramLong));
  }
  
  public void c(String paramString)
  {
    agjp localagjp = (agjp)this.a.get();
    if ((localagjp == null) || (localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.4(this, localagjp, paramString));
  }
  
  public void d(String paramString)
  {
    agjp localagjp = (agjp)this.a.get();
    if ((localagjp == null) || (localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.5(this, localagjp, paramString));
  }
  
  public void e(String paramString)
  {
    agjp localagjp = (agjp)this.a.get();
    if ((localagjp == null) || (localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localagjp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.6(this, localagjp, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkb
 * JD-Core Version:    0.7.0.1
 */