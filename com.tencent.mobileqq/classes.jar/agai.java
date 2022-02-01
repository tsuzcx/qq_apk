import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class agai
  extends avhm
{
  agai(agab paramagab) {}
  
  protected void a()
  {
    if (((avhf)this.a.app.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a(this.a.sessionInfo.curType, this.a.sessionInfo.curFriendUin)) {
      this.a.mTipsMgr.a(this.a.a, new Object[0]);
    }
  }
  
  protected void b()
  {
    if (((avhf)this.a.app.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a(this.a.sessionInfo.curType, this.a.sessionInfo.curFriendUin)) {
      this.a.a.a();
    }
  }
  
  protected void c()
  {
    if ((((avhf)this.a.app.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a(this.a.sessionInfo.curType, this.a.sessionInfo.curFriendUin)) && (this.a.mTipsMgr.a() == 14)) {
      this.a.mTipsMgr.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agai
 * JD-Core Version:    0.7.0.1
 */