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
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.os.MqqHandler;

public class ahzo
  extends amug
{
  private WeakReference<ahzc> a;
  
  ahzo(ahzc paramahzc)
  {
    this.a = new WeakReference(paramahzc);
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameChatPie", 2, "[onPushPlaymateExitAio] friendUin:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    ahzc localahzc;
    do
    {
      return;
      localahzc = (ahzc)this.a.get();
    } while ((localahzc == null) || (localahzc.sessionInfo == null) || (!paramString.equals(localahzc.getCurFriendUin())));
    localahzc.a(paramString, localahzc.app.getCurrentUin(), "", 3);
  }
  
  public void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
    ahzc localahzc = (ahzc)this.a.get();
    if ((localahzc == null) || (localahzc.sessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localahzc.getCurFriendUin()))) {
      return;
    }
    if (paramInt == 0) {}
    for (boolean bool = false;; bool = true)
    {
      localahzc.b(bool);
      return;
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameChatPie", 2, "[onQueryUserStatus] friendUin:" + paramString + ",status:" + paramInt1 + ",lastTs:" + paramInt2);
    }
    super.a(paramString, paramInt1, paramInt2);
    ahzc localahzc = (ahzc)this.a.get();
    if ((localahzc == null) || (localahzc.sessionInfo == null)) {}
    while (!localahzc.sessionInfo.curFriendUin.equals(paramString)) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.11(this, localahzc, paramString, paramInt1, paramInt2));
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    ahzc localahzc = (ahzc)this.a.get();
    if ((localahzc == null) || (localahzc.sessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localahzc.sessionInfo.curFriendUin))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.9(this, localahzc, paramInt, paramLong));
  }
  
  public void a(String paramString, int paramInt, List<MessageForApollo> paramList)
  {
    super.a(paramString, paramInt, paramList);
    ahzc localahzc = (ahzc)this.a.get();
    if ((localahzc == null) || (localahzc.sessionInfo == null)) {}
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
        if (ahzc.a(localahzc) != null) {
          ahzc.a(localahzc).dismiss();
        }
      } while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localahzc.sessionInfo.curFriendUin)));
      localQQAppInterface = localahzc.app;
    } while (localQQAppInterface == null);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      QLog.e("CmGameChatPie", 1, "onAcceptMyInvite msgs == null || msgs.isEmpty()");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CmGameChatPie", 2, new Object[] { "onAcceptMyInvite friendUin:", paramString, " msgs.size:", Integer.valueOf(paramList.size()) });
    }
    if (ahzc.a(localahzc))
    {
      QLog.e("CmGameChatPie", 1, "onAcceptMyInvite chatPie.mStoped");
      return;
    }
    paramString = (MessageForApollo)paramList.get(0);
    paramString = new CmGameStartChecker.StartCheckParam(paramString.gameId, paramString.isSend(), "message", paramString.roomId, 1, 0, localahzc.sessionInfo.curType, ApolloGameUtil.a(localQQAppInterface, localahzc.sessionInfo.curType, localahzc.sessionInfo.curFriendUin), localahzc.sessionInfo.curFriendUin, ahzc.c(localahzc), paramString.gameName);
    paramString.mTempAIOUin = localahzc.sessionInfo.curFriendUin;
    paramString.mTempAIONickName = localahzc.sessionInfo.curFriendNick;
    paramString.disableMinGame = true;
    ApolloGameUtil.a(localahzc.mActivity, paramString);
    ahzc.c = true;
  }
  
  public void a(String paramString, ahzp paramahzp)
  {
    ahzc localahzc = (ahzc)this.a.get();
    if ((localahzc == null) || (localahzc.sessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localahzc.sessionInfo.curFriendUin))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.1(this, localahzc, paramString, paramahzp));
  }
  
  public void a(String paramString, amuj paramamuj)
  {
    ahzc localahzc = (ahzc)this.a.get();
    if ((localahzc == null) || (localahzc.sessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localahzc.sessionInfo.curFriendUin))) {
      return;
    }
    localahzc.a(paramamuj);
  }
  
  public void a(String paramString, List<ApolloGameData> paramList)
  {
    super.a(paramString, paramList);
    ahzc localahzc = (ahzc)this.a.get();
    if ((localahzc == null) || (localahzc.sessionInfo == null)) {}
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localahzc.sessionInfo.curFriendUin)));
      localahzc.a(paramList);
    } while (localahzc.mApolloPanel == null);
    localahzc.mApolloPanel.m();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    super.a(paramString, paramBoolean);
    paramString = (ahzc)this.a.get();
    if ((paramString == null) || (paramString.sessionInfo == null)) {
      return;
    }
    paramString.b(paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    super.a(paramBoolean, paramInt1, paramLong, paramInt2);
    ahzc localahzc = (ahzc)this.a.get();
    if ((localahzc == null) || (localahzc.sessionInfo == null)) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean)
        {
          QLog.e("CmGameTemp_CmGameChatPie", 1, "onCreateRoomId createSuccess:false");
          ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.7(this, localahzc));
          return;
        }
      } while (localahzc.app == null);
      if (ahzc.a(localahzc) != paramInt2) {
        break label216;
      }
      if (!amuo.a(localahzc.sessionInfo.curFriendUin)) {
        break;
      }
    } while (ahzc.a(localahzc) == null);
    String str = ahzc.a(localahzc).a();
    if (ahzc.d(localahzc) == paramInt2)
    {
      amub.a(localahzc.app, localahzc.sessionInfo.curFriendUin, str, paramLong, paramInt1);
      localahzc.a(paramLong);
      return;
    }
    localahzc.a(paramInt1, paramLong);
    ThreadManagerV2.getUIHandlerV2().postDelayed(new CmGameChatPie.ChatPieMsgListener.8(this, localahzc, paramInt1, paramLong, str), 1500L);
    return;
    ((amme)localahzc.app.getManager(QQManagerFactory.APOLLO_MANAGER)).a().a(localahzc.sessionInfo.curFriendUin, paramInt1, paramLong);
    return;
    label216:
    QLog.e("CmGameTemp_CmGameChatPie", 1, "onCreateRoomId chatPie.mCreateRoomReqCode != reqCode, reqCode:" + paramInt2);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    super.a(paramBoolean, paramString, paramInt, paramLong);
    ahzc localahzc = (ahzc)this.a.get();
    if ((localahzc == null) || (localahzc.sessionInfo == null) || (localahzc.app == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localahzc.sessionInfo.curFriendUin))) {
      return;
    }
    if (paramBoolean) {
      localahzc.a(paramInt, paramLong);
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.2(this, localahzc, paramBoolean));
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, long paramLong, String paramString2)
  {
    super.a(paramBoolean, paramString1, paramInt, paramLong, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameChatPie", 2, "[onCheckRobotModeRsp] friendUin:" + paramString1 + ",gameId:" + paramInt + ",roomId:" + paramLong);
    }
    ahzc localahzc = (ahzc)this.a.get();
    if ((localahzc == null) || (localahzc.sessionInfo == null) || (localahzc.app == null)) {}
    while ((TextUtils.isEmpty(paramString1)) || (!paramString1.equals(localahzc.sessionInfo.curFriendUin)) || (!paramBoolean)) {
      return;
    }
    long l = System.currentTimeMillis() - amub.jdField_a_of_type_Long;
    if (l > 1500L)
    {
      localahzc.a(paramInt, paramLong, paramString2);
      return;
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new CmGameChatPie.ChatPieMsgListener.12(this, localahzc, paramInt, paramLong, paramString2), 1500L - l);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt, long paramLong)
  {
    super.a(paramBoolean1, paramBoolean2, paramString, paramInt, paramLong);
    ahzc localahzc = (ahzc)this.a.get();
    if ((localahzc == null) || (localahzc.sessionInfo == null)) {}
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localahzc.sessionInfo.curFriendUin)) || (!paramBoolean1));
      if (ahzc.a(localahzc))
      {
        QLog.e("CmGameTemp_CmGameChatPie", 1, "onOneMoreGameRspFinish chatPie.mStoped");
        return;
      }
    } while ((!paramBoolean2) || (localahzc.app == null) || (ahzc.a(localahzc) == null));
    paramString = new CmGameStartChecker.StartCheckParam(ahzc.a(localahzc).jdField_a_of_type_Int, true, "message", ahzc.a(localahzc).jdField_a_of_type_Long, 1, 0, localahzc.sessionInfo.curType, ApolloGameUtil.a(localahzc.app, localahzc.sessionInfo.curType, localahzc.sessionInfo.curFriendUin), localahzc.sessionInfo.curFriendUin, ahzc.c(localahzc), null);
    paramString.mTempAIOUin = localahzc.sessionInfo.curFriendUin;
    paramString.mTempAIONickName = localahzc.sessionInfo.curFriendNick;
    paramString.disableMinGame = true;
    ApolloGameUtil.a(localahzc.mActivity, paramString);
    ahzc.c = true;
    amub.b(localahzc.app, localahzc.sessionInfo.curFriendUin, localahzc.sessionInfo.curType, paramInt, paramLong);
  }
  
  public void b(String paramString)
  {
    ahzc localahzc = (ahzc)this.a.get();
    if ((localahzc == null) || (localahzc.sessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localahzc.sessionInfo.curFriendUin))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.3(this, localahzc, paramString));
  }
  
  public void b(boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    ahzc localahzc = (ahzc)this.a.get();
    if ((localahzc == null) || (localahzc.sessionInfo == null) || (localahzc.app == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localahzc.sessionInfo.curFriendUin))) {
      return;
    }
    if (!paramBoolean) {
      amub.a(localahzc.app, localahzc.sessionInfo.curFriendUin, localahzc.sessionInfo.curType, paramInt, paramLong);
    }
    if (ahzc.a(localahzc))
    {
      QLog.e("CmGameTemp_CmGameChatPie", 1, "onPushOneMoreGameMsgRsp chatPie.mStoped");
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.10(this, paramBoolean, localahzc, paramInt, paramLong));
  }
  
  public void c(String paramString)
  {
    ahzc localahzc = (ahzc)this.a.get();
    if ((localahzc == null) || (localahzc.sessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localahzc.sessionInfo.curFriendUin))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.4(this, localahzc, paramString));
  }
  
  public void d(String paramString)
  {
    ahzc localahzc = (ahzc)this.a.get();
    if ((localahzc == null) || (localahzc.sessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localahzc.sessionInfo.curFriendUin))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.5(this, localahzc, paramString));
  }
  
  public void e(String paramString)
  {
    ahzc localahzc = (ahzc)this.a.get();
    if ((localahzc == null) || (localahzc.sessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localahzc.sessionInfo.curFriendUin))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.6(this, localahzc, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahzo
 * JD-Core Version:    0.7.0.1
 */