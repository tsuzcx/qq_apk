import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

class afis
  extends aubs
{
  afis(afim paramafim) {}
  
  protected void a()
  {
    if (((aubl)this.a.app.getManager(156)).a(this.a.sessionInfo.curType, this.a.sessionInfo.curFriendUin)) {
      this.a.mTipsMgr.a(this.a.a, new Object[0]);
    }
  }
  
  protected void b()
  {
    if (((aubl)this.a.app.getManager(156)).a(this.a.sessionInfo.curType, this.a.sessionInfo.curFriendUin)) {
      this.a.a.a();
    }
  }
  
  protected void c()
  {
    if ((((aubl)this.a.app.getManager(156)).a(this.a.sessionInfo.curType, this.a.sessionInfo.curFriendUin)) && (this.a.mTipsMgr.a() == 14)) {
      this.a.mTipsMgr.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afis
 * JD-Core Version:    0.7.0.1
 */