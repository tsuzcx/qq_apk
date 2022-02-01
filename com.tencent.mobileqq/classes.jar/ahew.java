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

public class ahew
  extends alve
{
  private WeakReference<ahek> a;
  
  ahew(ahek paramahek)
  {
    this.a = new WeakReference(paramahek);
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameChatPie", 2, "[onPushPlaymateExitAio] friendUin:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    ahek localahek;
    do
    {
      return;
      localahek = (ahek)this.a.get();
    } while ((localahek == null) || (localahek.sessionInfo == null) || (!paramString.equals(localahek.getCurFriendUin())));
    localahek.a(paramString, localahek.app.getCurrentUin(), "", 3);
  }
  
  public void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
    ahek localahek = (ahek)this.a.get();
    if ((localahek == null) || (localahek.sessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localahek.getCurFriendUin()))) {
      return;
    }
    if (paramInt == 0) {}
    for (boolean bool = false;; bool = true)
    {
      localahek.b(bool);
      return;
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameChatPie", 2, "[onQueryUserStatus] friendUin:" + paramString + ",status:" + paramInt1 + ",lastTs:" + paramInt2);
    }
    super.a(paramString, paramInt1, paramInt2);
    ahek localahek = (ahek)this.a.get();
    if ((localahek == null) || (localahek.sessionInfo == null)) {}
    while (!localahek.sessionInfo.curFriendUin.equals(paramString)) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.11(this, localahek, paramString, paramInt1, paramInt2));
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    ahek localahek = (ahek)this.a.get();
    if ((localahek == null) || (localahek.sessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localahek.sessionInfo.curFriendUin))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.9(this, localahek, paramInt, paramLong));
  }
  
  public void a(String paramString, int paramInt, List<MessageForApollo> paramList)
  {
    super.a(paramString, paramInt, paramList);
    ahek localahek = (ahek)this.a.get();
    if ((localahek == null) || (localahek.sessionInfo == null)) {}
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
        if (ahek.a(localahek) != null) {
          ahek.a(localahek).dismiss();
        }
      } while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localahek.sessionInfo.curFriendUin)));
      localQQAppInterface = localahek.app;
    } while (localQQAppInterface == null);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      QLog.e("CmGameChatPie", 1, "onAcceptMyInvite msgs == null || msgs.isEmpty()");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CmGameChatPie", 2, new Object[] { "onAcceptMyInvite friendUin:", paramString, " msgs.size:", Integer.valueOf(paramList.size()) });
    }
    if (ahek.a(localahek))
    {
      QLog.e("CmGameChatPie", 1, "onAcceptMyInvite chatPie.mStoped");
      return;
    }
    paramString = (MessageForApollo)paramList.get(0);
    paramString = new CmGameStartChecker.StartCheckParam(paramString.gameId, paramString.isSend(), "message", paramString.roomId, 1, 0, localahek.sessionInfo.curType, ApolloGameUtil.a(localQQAppInterface, localahek.sessionInfo.curType, localahek.sessionInfo.curFriendUin), localahek.sessionInfo.curFriendUin, ahek.c(localahek), paramString.gameName);
    paramString.mTempAIOUin = localahek.sessionInfo.curFriendUin;
    paramString.mTempAIONickName = localahek.sessionInfo.curFriendNick;
    paramString.disableMinGame = true;
    ApolloGameUtil.a(localahek.mActivity, paramString);
    ahek.c = true;
  }
  
  public void a(String paramString, ahex paramahex)
  {
    ahek localahek = (ahek)this.a.get();
    if ((localahek == null) || (localahek.sessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localahek.sessionInfo.curFriendUin))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.1(this, localahek, paramString, paramahex));
  }
  
  public void a(String paramString, alvh paramalvh)
  {
    ahek localahek = (ahek)this.a.get();
    if ((localahek == null) || (localahek.sessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localahek.sessionInfo.curFriendUin))) {
      return;
    }
    localahek.a(paramalvh);
  }
  
  public void a(String paramString, List<ApolloGameData> paramList)
  {
    super.a(paramString, paramList);
    ahek localahek = (ahek)this.a.get();
    if ((localahek == null) || (localahek.sessionInfo == null)) {}
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localahek.sessionInfo.curFriendUin)));
      localahek.a(paramList);
    } while (localahek.mApolloPanel == null);
    localahek.mApolloPanel.m();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    super.a(paramString, paramBoolean);
    paramString = (ahek)this.a.get();
    if ((paramString == null) || (paramString.sessionInfo == null)) {
      return;
    }
    paramString.b(paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    super.a(paramBoolean, paramInt1, paramLong, paramInt2);
    ahek localahek = (ahek)this.a.get();
    if ((localahek == null) || (localahek.sessionInfo == null)) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean)
        {
          QLog.e("CmGameTemp_CmGameChatPie", 1, "onCreateRoomId createSuccess:false");
          ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.7(this, localahek));
          return;
        }
      } while (localahek.app == null);
      if (ahek.a(localahek) != paramInt2) {
        break label216;
      }
      if (!alvm.a(localahek.sessionInfo.curFriendUin)) {
        break;
      }
    } while (ahek.a(localahek) == null);
    String str = ahek.a(localahek).a();
    if (ahek.d(localahek) == paramInt2)
    {
      aluz.a(localahek.app, localahek.sessionInfo.curFriendUin, str, paramLong, paramInt1);
      localahek.a(paramLong);
      return;
    }
    localahek.a(paramInt1, paramLong);
    ThreadManagerV2.getUIHandlerV2().postDelayed(new CmGameChatPie.ChatPieMsgListener.8(this, localahek, paramInt1, paramLong, str), 1500L);
    return;
    ((alnr)localahek.app.getManager(153)).a().a(localahek.sessionInfo.curFriendUin, paramInt1, paramLong);
    return;
    label216:
    QLog.e("CmGameTemp_CmGameChatPie", 1, "onCreateRoomId chatPie.mCreateRoomReqCode != reqCode, reqCode:" + paramInt2);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    super.a(paramBoolean, paramString, paramInt, paramLong);
    ahek localahek = (ahek)this.a.get();
    if ((localahek == null) || (localahek.sessionInfo == null) || (localahek.app == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localahek.sessionInfo.curFriendUin))) {
      return;
    }
    if (paramBoolean) {
      localahek.a(paramInt, paramLong);
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.2(this, localahek, paramBoolean));
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, long paramLong, String paramString2)
  {
    super.a(paramBoolean, paramString1, paramInt, paramLong, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameChatPie", 2, "[onCheckRobotModeRsp] friendUin:" + paramString1 + ",gameId:" + paramInt + ",roomId:" + paramLong);
    }
    ahek localahek = (ahek)this.a.get();
    if ((localahek == null) || (localahek.sessionInfo == null) || (localahek.app == null)) {}
    while ((TextUtils.isEmpty(paramString1)) || (!paramString1.equals(localahek.sessionInfo.curFriendUin)) || (!paramBoolean)) {
      return;
    }
    long l = System.currentTimeMillis() - aluz.jdField_a_of_type_Long;
    if (l > 1500L)
    {
      localahek.a(paramInt, paramLong, paramString2);
      return;
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new CmGameChatPie.ChatPieMsgListener.12(this, localahek, paramInt, paramLong, paramString2), 1500L - l);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt, long paramLong)
  {
    super.a(paramBoolean1, paramBoolean2, paramString, paramInt, paramLong);
    ahek localahek = (ahek)this.a.get();
    if ((localahek == null) || (localahek.sessionInfo == null)) {}
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localahek.sessionInfo.curFriendUin)) || (!paramBoolean1));
      if (ahek.a(localahek))
      {
        QLog.e("CmGameTemp_CmGameChatPie", 1, "onOneMoreGameRspFinish chatPie.mStoped");
        return;
      }
    } while ((!paramBoolean2) || (localahek.app == null) || (ahek.a(localahek) == null));
    paramString = new CmGameStartChecker.StartCheckParam(ahek.a(localahek).jdField_a_of_type_Int, true, "message", ahek.a(localahek).jdField_a_of_type_Long, 1, 0, localahek.sessionInfo.curType, ApolloGameUtil.a(localahek.app, localahek.sessionInfo.curType, localahek.sessionInfo.curFriendUin), localahek.sessionInfo.curFriendUin, ahek.c(localahek), null);
    paramString.mTempAIOUin = localahek.sessionInfo.curFriendUin;
    paramString.mTempAIONickName = localahek.sessionInfo.curFriendNick;
    paramString.disableMinGame = true;
    ApolloGameUtil.a(localahek.mActivity, paramString);
    ahek.c = true;
    aluz.b(localahek.app, localahek.sessionInfo.curFriendUin, localahek.sessionInfo.curType, paramInt, paramLong);
  }
  
  public void b(String paramString)
  {
    ahek localahek = (ahek)this.a.get();
    if ((localahek == null) || (localahek.sessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localahek.sessionInfo.curFriendUin))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.3(this, localahek, paramString));
  }
  
  public void b(boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    ahek localahek = (ahek)this.a.get();
    if ((localahek == null) || (localahek.sessionInfo == null) || (localahek.app == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localahek.sessionInfo.curFriendUin))) {
      return;
    }
    if (!paramBoolean) {
      aluz.a(localahek.app, localahek.sessionInfo.curFriendUin, localahek.sessionInfo.curType, paramInt, paramLong);
    }
    if (ahek.a(localahek))
    {
      QLog.e("CmGameTemp_CmGameChatPie", 1, "onPushOneMoreGameMsgRsp chatPie.mStoped");
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.10(this, paramBoolean, localahek, paramInt, paramLong));
  }
  
  public void c(String paramString)
  {
    ahek localahek = (ahek)this.a.get();
    if ((localahek == null) || (localahek.sessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localahek.sessionInfo.curFriendUin))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.4(this, localahek, paramString));
  }
  
  public void d(String paramString)
  {
    ahek localahek = (ahek)this.a.get();
    if ((localahek == null) || (localahek.sessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localahek.sessionInfo.curFriendUin))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.5(this, localahek, paramString));
  }
  
  public void e(String paramString)
  {
    ahek localahek = (ahek)this.a.get();
    if ((localahek == null) || (localahek.sessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localahek.sessionInfo.curFriendUin))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.6(this, localahek, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahew
 * JD-Core Version:    0.7.0.1
 */