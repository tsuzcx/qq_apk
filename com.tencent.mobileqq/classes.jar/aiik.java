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

public class aiik
  extends anak
{
  private WeakReference<aihy> a;
  
  aiik(aihy paramaihy)
  {
    this.a = new WeakReference(paramaihy);
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameChatPie", 2, "[onPushPlaymateExitAio] friendUin:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    aihy localaihy;
    do
    {
      return;
      localaihy = (aihy)this.a.get();
    } while ((localaihy == null) || (localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (!paramString.equals(localaihy.a())));
    localaihy.a(paramString, localaihy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "", 3);
  }
  
  public void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
    aihy localaihy = (aihy)this.a.get();
    if ((localaihy == null) || (localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaihy.a()))) {
      return;
    }
    if (paramInt == 0) {}
    for (boolean bool = false;; bool = true)
    {
      localaihy.w(bool);
      return;
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameChatPie", 2, "[onQueryUserStatus] friendUin:" + paramString + ",status:" + paramInt1 + ",lastTs:" + paramInt2);
    }
    super.a(paramString, paramInt1, paramInt2);
    aihy localaihy = (aihy)this.a.get();
    if ((localaihy == null) || (localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while (!localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.11(this, localaihy, paramString, paramInt1, paramInt2));
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    aihy localaihy = (aihy)this.a.get();
    if ((localaihy == null) || (localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.9(this, localaihy, paramInt, paramLong));
  }
  
  public void a(String paramString, int paramInt, List<MessageForApollo> paramList)
  {
    super.a(paramString, paramInt, paramList);
    aihy localaihy = (aihy)this.a.get();
    if ((localaihy == null) || (localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
        if (aihy.a(localaihy) != null) {
          aihy.a(localaihy).dismiss();
        }
      } while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
      localQQAppInterface = localaihy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    } while (localQQAppInterface == null);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      QLog.e("CmGameChatPie", 1, "onAcceptMyInvite msgs == null || msgs.isEmpty()");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CmGameChatPie", 2, new Object[] { "onAcceptMyInvite friendUin:", paramString, " msgs.size:", Integer.valueOf(paramList.size()) });
    }
    if (aihy.a(localaihy))
    {
      QLog.e("CmGameChatPie", 1, "onAcceptMyInvite chatPie.mStoped");
      return;
    }
    paramString = (MessageForApollo)paramList.get(0);
    paramString = new CmGameStartChecker.StartCheckParam(paramString.gameId, paramString.isSend(), "message", paramString.roomId, 1, 0, localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ApolloGameUtil.a(localQQAppInterface, localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, aihy.c(localaihy), paramString.gameName);
    paramString.mTempAIOUin = localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramString.mTempAIONickName = localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
    paramString.disableMinGame = true;
    ApolloGameUtil.a(localaihy.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString);
    aihy.T = true;
  }
  
  public void a(String paramString, aiil paramaiil)
  {
    aihy localaihy = (aihy)this.a.get();
    if ((localaihy == null) || (localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.1(this, localaihy, paramString, paramaiil));
  }
  
  public void a(String paramString, anan paramanan)
  {
    aihy localaihy = (aihy)this.a.get();
    if ((localaihy == null) || (localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    localaihy.a(paramanan);
  }
  
  public void a(String paramString, List<ApolloGameData> paramList)
  {
    super.a(paramString, paramList);
    aihy localaihy = (aihy)this.a.get();
    if ((localaihy == null) || (localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
      localaihy.b(paramList);
    } while (localaihy.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel == null);
    localaihy.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.m();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    super.a(paramString, paramBoolean);
    paramString = (aihy)this.a.get();
    if ((paramString == null) || (paramString.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {
      return;
    }
    paramString.w(paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    super.a(paramBoolean, paramInt1, paramLong, paramInt2);
    aihy localaihy = (aihy)this.a.get();
    if ((localaihy == null) || (localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean)
        {
          QLog.e("CmGameTemp_CmGameChatPie", 1, "onCreateRoomId createSuccess:false");
          ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.7(this, localaihy));
          return;
        }
      } while (localaihy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      if (aihy.a(localaihy) != paramInt2) {
        break label216;
      }
      if (!anas.a(localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        break;
      }
    } while (aihy.a(localaihy) == null);
    String str = aihy.a(localaihy).a();
    if (aihy.d(localaihy) == paramInt2)
    {
      anaf.a(localaihy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, paramLong, paramInt1);
      localaihy.d(paramLong);
      return;
    }
    localaihy.a(paramInt1, paramLong);
    ThreadManagerV2.getUIHandlerV2().postDelayed(new CmGameChatPie.ChatPieMsgListener.8(this, localaihy, paramInt1, paramLong, str), 1500L);
    return;
    ((amsx)localaihy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().a(localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramInt1, paramLong);
    return;
    label216:
    QLog.e("CmGameTemp_CmGameChatPie", 1, "onCreateRoomId chatPie.mCreateRoomReqCode != reqCode, reqCode:" + paramInt2);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    super.a(paramBoolean, paramString, paramInt, paramLong);
    aihy localaihy = (aihy)this.a.get();
    if ((localaihy == null) || (localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (localaihy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (paramBoolean) {
      localaihy.a(paramInt, paramLong);
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.2(this, localaihy, paramBoolean));
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, long paramLong, String paramString2)
  {
    super.a(paramBoolean, paramString1, paramInt, paramLong, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameChatPie", 2, "[onCheckRobotModeRsp] friendUin:" + paramString1 + ",gameId:" + paramInt + ",roomId:" + paramLong);
    }
    aihy localaihy = (aihy)this.a.get();
    if ((localaihy == null) || (localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (localaihy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    while ((TextUtils.isEmpty(paramString1)) || (!paramString1.equals(localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (!paramBoolean)) {
      return;
    }
    long l = System.currentTimeMillis() - anaf.jdField_a_of_type_Long;
    if (l > 1500L)
    {
      localaihy.a(paramInt, paramLong, paramString2);
      return;
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new CmGameChatPie.ChatPieMsgListener.12(this, localaihy, paramInt, paramLong, paramString2), 1500L - l);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt, long paramLong)
  {
    super.a(paramBoolean1, paramBoolean2, paramString, paramInt, paramLong);
    aihy localaihy = (aihy)this.a.get();
    if ((localaihy == null) || (localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (!paramBoolean1));
      if (aihy.a(localaihy))
      {
        QLog.e("CmGameTemp_CmGameChatPie", 1, "onOneMoreGameRspFinish chatPie.mStoped");
        return;
      }
    } while ((!paramBoolean2) || (localaihy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (aihy.a(localaihy) == null));
    paramString = new CmGameStartChecker.StartCheckParam(aihy.a(localaihy).jdField_a_of_type_Int, true, "message", aihy.a(localaihy).jdField_a_of_type_Long, 1, 0, localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ApolloGameUtil.a(localaihy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, aihy.c(localaihy), null);
    paramString.mTempAIOUin = localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramString.mTempAIONickName = localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
    paramString.disableMinGame = true;
    ApolloGameUtil.a(localaihy.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString);
    aihy.T = true;
    anaf.b(localaihy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramInt, paramLong);
  }
  
  public void b(String paramString)
  {
    aihy localaihy = (aihy)this.a.get();
    if ((localaihy == null) || (localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.3(this, localaihy, paramString));
  }
  
  public void b(boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    aihy localaihy = (aihy)this.a.get();
    if ((localaihy == null) || (localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (localaihy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (!paramBoolean) {
      anaf.a(localaihy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramInt, paramLong);
    }
    if (aihy.a(localaihy))
    {
      QLog.e("CmGameTemp_CmGameChatPie", 1, "onPushOneMoreGameMsgRsp chatPie.mStoped");
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.10(this, paramBoolean, localaihy, paramInt, paramLong));
  }
  
  public void c(String paramString)
  {
    aihy localaihy = (aihy)this.a.get();
    if ((localaihy == null) || (localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.4(this, localaihy, paramString));
  }
  
  public void d(String paramString)
  {
    aihy localaihy = (aihy)this.a.get();
    if ((localaihy == null) || (localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.5(this, localaihy, paramString));
  }
  
  public void e(String paramString)
  {
    aihy localaihy = (aihy)this.a.get();
    if ((localaihy == null) || (localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localaihy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.6(this, localaihy, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiik
 * JD-Core Version:    0.7.0.1
 */