import GROUP.MessageRemindRsp;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.QLog;

public class agav
  extends aodb
{
  public agav(TroopChatPie paramTroopChatPie) {}
  
  public void a(boolean paramBoolean, MessageRemindRsp paramMessageRemindRsp)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("vip_pretty." + this.a.tag, 2, "SVIPObserver.onGetBigTroopExpiredInfo, troopUin: " + this.a.sessionInfo.curFriendUin + " iFreezedType=" + paramMessageRemindRsp.iFreezedType + " iLhGroupExpiredTime=" + paramMessageRemindRsp.iLhGroupExpiredTime + " iGroupType=" + paramMessageRemindRsp.iGroupType);
      }
      ((TroopManager)this.a.app.getManager(QQManagerFactory.TROOP_MANAGER)).a(this.a.sessionInfo.curFriendUin, paramMessageRemindRsp);
      TroopManager.a(paramMessageRemindRsp, this.a.app, this.a.sessionInfo.curFriendUin, this.a.mContext, this.a, this.a.mTipsMgr);
      return;
    }
    QLog.e("vip_pretty." + this.a.tag, 2, String.format("SVIPObserver.onGetBigTroopExpiredInfo, troopUin: %s, isSuccess: false", new Object[] { this.a.sessionInfo.curFriendUin }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agav
 * JD-Core Version:    0.7.0.1
 */