import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;

final class aftt
  extends aofu
{
  aftt(SessionInfo paramSessionInfo) {}
  
  protected void onOIDB0X88D_0_Ret(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString, Object[] paramArrayOfObject)
  {
    if (paramBoolean)
    {
      QWalletHelper.saveLastUpdateToopMemberNumTime(this.a.curFriendUin);
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanelUtils", 2, "onOIDB0X88D_0_Ret 群uin：" + this.a.curFriendUin + " 群成员个数：" + paramTroopInfo.wMemberNum);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aftt
 * JD-Core Version:    0.7.0.1
 */