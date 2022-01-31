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

public class aecn
  extends aims
{
  private WeakReference<aecb> a;
  
  aecn(aecb paramaecb)
  {
    this.a = new WeakReference(paramaecb);
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameChatPie", 2, "[onPushPlaymateExitAio] friendUin:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    aecb localaecb;
    do
    {
      return;
      localaecb = (aecb)this.a.get();
    } while ((localaecb == null) || (localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (!paramString.equals(localaecb.a())));
    localaecb.a(paramString, localaecb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "", 3);
  }
  
  public void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
    aecb localaecb = (aecb)this.a.get();
    if ((localaecb == null) || (localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaecb.a()))) {
      return;
    }
    if (paramInt == 0) {}
    for (boolean bool = false;; bool = true)
    {
      localaecb.u(bool);
      return;
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameChatPie", 2, "[onQueryUserStatus] friendUin:" + paramString + ",status:" + paramInt1 + ",lastTs:" + paramInt2);
    }
    super.a(paramString, paramInt1, paramInt2);
    aecb localaecb = (aecb)this.a.get();
    if ((localaecb == null) || (localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while (!localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.11(this, localaecb, paramString, paramInt1, paramInt2));
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    aecb localaecb = (aecb)this.a.get();
    if ((localaecb == null) || (localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.9(this, localaecb, paramInt, paramLong));
  }
  
  public void a(String paramString, int paramInt, List<MessageForApollo> paramList)
  {
    super.a(paramString, paramInt, paramList);
    aecb localaecb = (aecb)this.a.get();
    if ((localaecb == null) || (localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
        if (aecb.a(localaecb) != null) {
          aecb.a(localaecb).dismiss();
        }
      } while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
      localQQAppInterface = localaecb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    } while (localQQAppInterface == null);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      QLog.e("CmGameChatPie", 1, "onAcceptMyInvite msgs == null || msgs.isEmpty()");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CmGameChatPie", 2, new Object[] { "onAcceptMyInvite friendUin:", paramString, " msgs.size:", Integer.valueOf(paramList.size()) });
    }
    if (aecb.a(localaecb))
    {
      QLog.e("CmGameChatPie", 1, "onAcceptMyInvite chatPie.mStoped");
      return;
    }
    paramString = (MessageForApollo)paramList.get(0);
    paramString = new CmGameStartChecker.StartCheckParam(paramString.gameId, paramString.isSend(), "message", paramString.roomId, 1, 0, localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ApolloGameUtil.a(localQQAppInterface, localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, aecb.c(localaecb), paramString.gameName);
    paramString.mTempAIOUin = localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramString.mTempAIONickName = localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
    paramString.disableMinGame = true;
    ApolloGameUtil.a(localaecb.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString);
    aecb.U = true;
  }
  
  public void a(String paramString, aeco paramaeco)
  {
    aecb localaecb = (aecb)this.a.get();
    if ((localaecb == null) || (localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.1(this, localaecb, paramString, paramaeco));
  }
  
  public void a(String paramString, aimv paramaimv)
  {
    aecb localaecb = (aecb)this.a.get();
    if ((localaecb == null) || (localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    localaecb.a(paramaimv);
  }
  
  public void a(String paramString, List<ApolloGameData> paramList)
  {
    super.a(paramString, paramList);
    aecb localaecb = (aecb)this.a.get();
    if ((localaecb == null) || (localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
      localaecb.b(paramList);
    } while (localaecb.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel == null);
    localaecb.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.m();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    super.a(paramString, paramBoolean);
    paramString = (aecb)this.a.get();
    if ((paramString == null) || (paramString.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {
      return;
    }
    paramString.u(paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    super.a(paramBoolean, paramInt1, paramLong, paramInt2);
    aecb localaecb = (aecb)this.a.get();
    if ((localaecb == null) || (localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean)
        {
          QLog.e("CmGameTemp_CmGameChatPie", 1, "onCreateRoomId createSuccess:false");
          ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.7(this, localaecb));
          return;
        }
      } while (localaecb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      if (aecb.a(localaecb) != paramInt2) {
        break label216;
      }
      if (!aina.a(localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        break;
      }
    } while (aecb.a(localaecb) == null);
    String str = aecb.a(localaecb).a();
    if (aecb.d(localaecb) == paramInt2)
    {
      aimn.a(localaecb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, paramLong, paramInt1);
      localaecb.c(paramLong);
      return;
    }
    localaecb.a(paramInt1, paramLong);
    ThreadManagerV2.getUIHandlerV2().postDelayed(new CmGameChatPie.ChatPieMsgListener.8(this, localaecb, paramInt1, paramLong, str), 1500L);
    return;
    ((aifg)localaecb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().a(localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramInt1, paramLong);
    return;
    label216:
    QLog.e("CmGameTemp_CmGameChatPie", 1, "onCreateRoomId chatPie.mCreateRoomReqCode != reqCode, reqCode:" + paramInt2);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    super.a(paramBoolean, paramString, paramInt, paramLong);
    aecb localaecb = (aecb)this.a.get();
    if ((localaecb == null) || (localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (localaecb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (paramBoolean) {
      localaecb.a(paramInt, paramLong);
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.2(this, localaecb, paramBoolean));
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, long paramLong, String paramString2)
  {
    super.a(paramBoolean, paramString1, paramInt, paramLong, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameChatPie", 2, "[onCheckRobotModeRsp] friendUin:" + paramString1 + ",gameId:" + paramInt + ",roomId:" + paramLong);
    }
    aecb localaecb = (aecb)this.a.get();
    if ((localaecb == null) || (localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (localaecb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    while ((TextUtils.isEmpty(paramString1)) || (!paramString1.equals(localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (!paramBoolean)) {
      return;
    }
    long l = System.currentTimeMillis() - aimn.jdField_a_of_type_Long;
    if (l > 1500L)
    {
      localaecb.a(paramInt, paramLong, paramString2);
      return;
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new CmGameChatPie.ChatPieMsgListener.12(this, localaecb, paramInt, paramLong, paramString2), 1500L - l);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt, long paramLong)
  {
    super.a(paramBoolean1, paramBoolean2, paramString, paramInt, paramLong);
    aecb localaecb = (aecb)this.a.get();
    if ((localaecb == null) || (localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (!paramBoolean1));
      if (aecb.a(localaecb))
      {
        QLog.e("CmGameTemp_CmGameChatPie", 1, "onOneMoreGameRspFinish chatPie.mStoped");
        return;
      }
    } while ((!paramBoolean2) || (localaecb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (aecb.a(localaecb) == null));
    paramString = new CmGameStartChecker.StartCheckParam(aecb.a(localaecb).jdField_a_of_type_Int, true, "message", aecb.a(localaecb).jdField_a_of_type_Long, 1, 0, localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ApolloGameUtil.a(localaecb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, aecb.c(localaecb), null);
    paramString.mTempAIOUin = localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramString.mTempAIONickName = localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
    paramString.disableMinGame = true;
    ApolloGameUtil.a(localaecb.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString);
    aecb.U = true;
    aimn.b(localaecb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramInt, paramLong);
  }
  
  public void b(String paramString)
  {
    aecb localaecb = (aecb)this.a.get();
    if ((localaecb == null) || (localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.3(this, localaecb, paramString));
  }
  
  public void b(boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    aecb localaecb = (aecb)this.a.get();
    if ((localaecb == null) || (localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (localaecb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (!paramBoolean) {
      aimn.a(localaecb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramInt, paramLong);
    }
    if (aecb.a(localaecb))
    {
      QLog.e("CmGameTemp_CmGameChatPie", 1, "onPushOneMoreGameMsgRsp chatPie.mStoped");
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.10(this, paramBoolean, localaecb, paramInt, paramLong));
  }
  
  public void c(String paramString)
  {
    aecb localaecb = (aecb)this.a.get();
    if ((localaecb == null) || (localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.4(this, localaecb, paramString));
  }
  
  public void d(String paramString)
  {
    aecb localaecb = (aecb)this.a.get();
    if ((localaecb == null) || (localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.5(this, localaecb, paramString));
  }
  
  public void e(String paramString)
  {
    aecb localaecb = (aecb)this.a.get();
    if ((localaecb == null) || (localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.6(this, localaecb, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aecn
 * JD-Core Version:    0.7.0.1
 */