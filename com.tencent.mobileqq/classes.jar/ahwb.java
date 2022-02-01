import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.C2CPlusPanelAppConfigHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.List;

public class ahwb
  extends ahvq
{
  private void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, bjxa parambjxa)
  {
    if (parambjxa.c(paramSessionInfo.curFriendUin))
    {
      a(paramBaseChatPie.sessionInfo.curType, 201);
      a(paramBaseChatPie.sessionInfo.curType, 202);
    }
    a(paramBaseChatPie.sessionInfo.curType, 206);
    a(paramBaseChatPie.sessionInfo.curType, 205);
  }
  
  private void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    if (nwu.a(paramQQAppInterface, paramSessionInfo.curFriendUin, paramSessionInfo.curType)) {
      a(paramBaseChatPie.sessionInfo.curType, 201);
    }
    a(paramBaseChatPie.sessionInfo.curType, 217);
    a(paramBaseChatPie.sessionInfo.curType, 218);
    if (paramSessionInfo.curType == 1008)
    {
      paramSessionInfo = ((aoan)paramQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).b(paramSessionInfo.curFriendUin);
      if ((paramSessionInfo != null) && ((paramSessionInfo.accountFlag & 0x20000000) != 0) && (ShortVideoUtils.sSupportShortVideo) && (VideoEnvironment.supportShortVideoRecordAndPlay(paramQQAppInterface))) {
        a(paramBaseChatPie.sessionInfo.curType, 1104788673);
      }
      if ((paramSessionInfo != null) && ((paramSessionInfo.accountFlag & 0x10000000) != 0)) {
        this.a.add(0, C2CPlusPanelAppConfigHelper.INSTANCE.getAppInfoByAppID(1000000005));
      }
    }
    a(paramBaseChatPie.sessionInfo.curType, 205);
  }
  
  protected void b(BaseChatPie paramBaseChatPie)
  {
    SessionInfo localSessionInfo = paramBaseChatPie.sessionInfo;
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    bjxa localbjxa = (bjxa)localQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
    if (localbjxa.f(localSessionInfo.curFriendUin))
    {
      a(paramBaseChatPie, localSessionInfo, localbjxa);
      return;
    }
    a(paramBaseChatPie, localSessionInfo, localQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahwb
 * JD-Core Version:    0.7.0.1
 */